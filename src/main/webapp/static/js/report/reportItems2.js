//모달
    var modal = new bootstrap.Modal(document.getElementById('staticBackdrop'));
    //모달 여는 버튼
    var openModal = document.querySelector('#openModal');
    //항목 추가 form
    var itemAdd = document.querySelector('#itemAdd'); //form
    //항목 추가할 부분
    var itemList = document.querySelector('#itemList'); //tbody
    //modal 내의 Form
    var itemForm = document.querySelector('#itemForm');
    // 순번 초기화
    var currentNumber = 1;
	
 
    itemAdd.onclick = function(){
        let date = itemForm.modalDate.value;
        let amount = itemForm.amount.value;
        
        let categoryBig = itemForm.categoryBig;
        let bigItem = categoryBig.options[categoryBig.selectedIndex];
        
        let categorySm = itemForm.categorySm;
        let smItem = categorySm.options[categorySm.selectedIndex];
        
        let receiptImage = itemForm.receiptImage.files[0];
        let itemDesc = itemForm.itemDesc.value;
        //테이블 추가
        let tr = document.createElement('tr');
		
        // 순번 추가
        let numberTd = document.createElement('td');
        numberTd.textContent = currentNumber;  // 순번 추가
        currentNumber++;  // 순번 증가
        
        let dateTd = document.createElement('td');
        dateTd.textContent = date;

        let categoryBigTd = document.createElement('td');
        categoryBigTd.textContent = bigItem.value;
        categoryBigTd.id = bigItem.dataset.id; 
        
        let categorySmTd = document.createElement('td');
        categorySmTd.textContent = categorySm.value;
        categorySmTd.id = smItem.dataset.id;

        let amountTd = document.createElement('td');
        amountTd.textContent = amount;

        let maxAmount = document.createElement('td');
        let max = smItem.dataset.max;
        maxAmount.textContent = max;

        let selfAmount = document.createElement('td');
        selfAmount.textContent = amount - max;

        let receiptImageTd = document.createElement('td');
        if(!receiptImage){
            receiptImageTd.textContent = 'X';
        }else{
        	let url = URL.createObjectURL(receiptImage);
            receiptImageTd.textContent = 'O';
            receiptImageTd.dataset.receiptUrl = url;
        }
		
        let btn = document.createElement('td');
        btn.innerHTML = '<button type="button" class="btn btn-outline-danger" onclick="deleteBtn(event)">삭제</button> <button type="button" class="btn btn-outline-primary">수정</button>';
        
        tr.appendChild(numberTd);
        tr.appendChild(dateTd);
        tr.appendChild(categoryBigTd);
        tr.appendChild(categorySmTd);
        tr.appendChild(amountTd);
        tr.appendChild(maxAmount);
        tr.appendChild(selfAmount);
        tr.appendChild(receiptImageTd);
        tr.appendChild(btn);

        itemList.appendChild(tr);
		
      //DB에 저장하기
        fetch('/reportItemsApi/add', {
        	method: 'POST',
			headers: {
				'Accept' : 'application/json;charset=UTF-8', // 응답으로 JSON을 받을 것이라고 명시
				'Content-Type': 'application/json' // 요청 본문이 JSON 형식임을 명시
			},
			body: JSON.stringify({
				reportItemsVo: {
		            itemDesc: itemDesc,
		            resultAmount: amount - max, // 본인부담금
		            amount: amount,
		            itemDate: date
		        },
		        costVo: {
		            costId: smItem.dataset.id
		        },
		        receiptVo: {
		            attachId: 'attach_00000'
		        }
			})
        }).then(response => response.json())
        .then(data => {
            if(data !== 0){
            	itemForm.reset();
                modal.hide();
                openModal.focus();
            }
        }).catch(error => {
            console.error('Error:', error);
        });
    }

    function deleteBtn(event){
        let deleteTr = event.target.closest('tr');
        console.log(deleteTr);
        itemList.removeChild(deleteTr);

        reorderTable();
    }

    // 순번 다시 정렬 함수
    function reorderTable() {
        let rows = itemList.querySelectorAll('tr');
        let index = 1;
        rows.forEach(function(row) {
            let numberTd = row.querySelector('td');
            if (numberTd) {
                numberTd.textContent = index;
                index++;
            }
        });
        currentNumber = index;  // 순번을 계속해서 증가시키기 위해 업데이트
    }
    
    //항목 등록 취소
    function addCancel(){
    	let iemForm = document.querySelector('#itemForm');
    	itemForm.reset();
    	
    	modal.hide();
    	//modal.setAttribute('aria-hidden', 'true');
        openModal.focus();
    }
    
    function submitList(){
    	let list = itemList.getElementsByTagName('tr'); //모든 tr요소
    	let reportItems =[];
    	
    	//list를 reportItems 객체에 담기
    	for(let i = 0; i < list.length; i++){
    		let item = list[i].getElementsByTagName('td');
    		
    		let reportItem = {
    				addAt: item[1].innerHTML,
    				category: item[2].innerHTML,
    				cost: item[3].innerHTML,
    				amount: item[4].innerHTML,
    				resultAmount: item[6].innerHTML
    		};
    		
    		console.log(reportItem);
    	};
    }