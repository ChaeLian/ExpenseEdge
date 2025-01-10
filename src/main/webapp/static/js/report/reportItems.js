//모달
var modal = new bootstrap.Modal(document.getElementById('staticBackdrop'));
//모달 여는 버튼
var openModal = document.querySelector('#openModal');
//항목 추가 버튼
var itemAdd = document.querySelector('#itemAdd');
//항목 추가할 부분
var itemList = document.querySelector('#itemList'); //tbody
//modal 내의 Form
var itemForm = document.querySelector('#itemForm');
//순번 초기화
var currentNumber = 1;

reList();
	
//카테고리 변경
function categoryChage(event){
	let categoryBig = event.target.options[event.target.selectedIndex];
	let categoryId = categoryBig.dataset.id;

	if (categoryId) {
		costChage(categoryId);
    }	
}
function costChage(categoryId, costName){
	let categorySm = document.getElementById('categorySm');
	categorySm.innerHTML = '<option value="">서브 카테고리 선택</option>';
	
	//서브 카테고리 목록
    fetch('/costApi/costList/'+ categoryId, {
    	method: 'POST',
		headers: {'Accept' : 'application/json;charset=UTF-8'}
    }).then(response => response.json())
        .then(data => {
            // 서버에서 받은 서브 카테고리 목록을 추가
            data.forEach(function(item) {
                let option = document.createElement("option");
                option.value = item.costName;
                option.dataset.id = item.costId;
                option.textContent = item.costName;
                option.dataset.max = item.maxAmount;
                if(costName){
                	if(item.costName === costName){
                	option.selected = true                	
                	}
                }
                categorySm.appendChild(option);
                
                document.querySelector('#costId').value = item.costId;
                document.querySelector('#resultAmount').dataset.max = item.maxAmount;
            });
        })
        .catch(error => {
            console.error('카테고리 정렬 error:', error);
        });
}

//모달 날짜 선택 input 수정
flatpickr('.flatpickr-input', {
    dateFormat: 'Y-m-d',  // 날짜 형식 설정
});

//항목 새로고침 & list 출력
function reList(){
	var listCount = 0;
	//목록 불러오기
	fetch('/reportItemsApi/itemList' ,{
	  	method: 'POST'
  })
  	.then(response => response.json()) // 응답을 JSON 형식으로 파싱
    .then(data => {
    	listCount = data.length;
    	console.log(listCount);
    	
    	//기존 추가된 내용 없애기
    	itemList.innerHTML = '';
        
        // 받은 데이터를 반복하여 테이블에 행을 추가
        data.forEach((item, index) => {
        	console.log(item);
        	let itemJson = JSON.stringify(item);
        	// 이스케이프 처리: 특수 문자(따옴표 등)가 HTML 속성에서 문제를 일으킬 수 있기 때문에 이스케이프 처리
			let enItemJson = encodeURIComponent(itemJson);
        	
        	let reportItems = item.reportItemsVo;
	        let cost = item.costVo;
	        let receipt = item.receiptVo;
	        
            let row = document.createElement('tr'); // 새 행 생성
			
            // 각 객체 속성에 대해 셀을 생성하고 행에 추가
            //순번
            let rownum = document.createElement('td');
            rownum.textContent = index + 1;
            row.appendChild(rownum);

            //날짜
            let itemDateTd = document.createElement('td');
            let timestamp = reportItems.itemDate;
			// Date 객체로 변환
			let date = new Date(timestamp);
			// 날짜를 yyyy-MM-dd 형식으로 변환
			let formattedDate = date.toLocaleDateString('en-CA'); // en-CA는 yyyy-MM-dd 형식으로 반환됨

            itemDateTd.textContent = formattedDate;
            row.appendChild(itemDateTd);

            //비용항목
            let categoryNameTd = document.createElement('td');
            categoryNameTd.textContent = cost.categoryName;
            row.appendChild(categoryNameTd);

            //상세항목
            let costNameTd = document.createElement('td');
            costNameTd.textContent = cost.costName;
            row.appendChild(costNameTd);

            //지출금액
            let amountTd = document.createElement('td');
            amountTd.textContent = reportItems.amount;
            row.appendChild(amountTd);

            //지원금액
            let maxAmountTd = document.createElement('td');
            maxAmountTd.textContent = cost.maxAmount;
			row.appendChild(maxAmountTd);
			
            //본인부담금
            let resultAmountTd = document.createElement('td');
            resultAmountTd.textContent = reportItems.resultAmount;
            row.appendChild(resultAmountTd);

            //영수증첨부
            let receiptTd = document.createElement('td');
            if(!reportItems.attachId){
	            receiptTd.textContent = 'X';
	        }else{
	            receiptTd.textContent = 'O';
	        }
	        row.appendChild(receiptTd);

            //관리
            let btnTd = document.createElement('td');
            btnTd.innerHTML = `<button type="button" class="btn btn-outline-danger" data-id="${reportItems.itemId}" onclick="deleteBtn(event)">삭제</button> <button type="button" class="btn btn-outline-primary" data-id="${reportItems.itemId}" onclick="updateBtn('${enItemJson}')">수정</button>`;
            row.appendChild(btnTd);

            // 완성된 행을 tbody에 추가
            itemList.appendChild(row);
            document.querySelector('#rowCount').textContent = listCount;
        });        
    })
    .catch(error => console.error('재정렬 error:', error));

}

//항목 추가 취소
function addCancel(){
	let updateBtn = document.querySelector('#itemUpdate');
	if(updateBtn !== null){
		//버튼 원래 상태로
	  	updateBtn.textContent = '추가';
		updateBtn.id = 'itemAdd';
		
		document.querySelector('#fileShowDiv').style.display = 'none';
		document.querySelector('#receiptImageDiv').style.display = 'block';
	}
	itemForm.reset();
	modal.hide();
	openModal.focus();
}

//모달 항목 추가
itemAdd.onclick = function(){
	let amount = document.querySelector('#amount').value;
	let max = document.querySelector('#resultAmount').dataset.max;
	console.log(itemForm.querySelector('#befoDate').value);
	document.querySelector('#resultAmount').value = amount - max;
	
	let form = new FormData(itemForm); //form 태그 내용을 FormData 형식으로 전달되도록 설정

	fetch('/reportItemsApi/add', {
	  method: 'POST',
	  body: form,  // FormData는 자동으로 적절한 형식으로 전송됨
	})
	  .then(response => response.text())
	  .then(data => {
	    console.log('Response:', data);  // 서버에서 받은 응답 처리
	    reList();
	    addCancel();
	  })
	  .catch(error => {
	    console.error('항목 추가 error:', error);
	  });
	
}

//항목 삭제
function deleteBtn(event){
    let deleteBtn = event.target;
    let itemId = deleteBtn.dataset.id;
    console.log(itemId);
    
    if( !confirm("삭제하시겠습니까?") ){
    	alert("삭제가 취소되었습니다.");
    	return;
    }else{
    	fetch('/reportItemsApi/del/' + itemId, {
			method: 'GET'
		}).then(response => response.text())
		  .then(data => {
		    alert("삭제가 되었습니다.");
		    reList();
		}).catch(error => {
		    console.error('항목 추가 error:', error);
		});
	}
}

//항목 수정
function updateBtn(enItemJson){
	let item = JSON.parse(decodeURIComponent(enItemJson));
	//저장 버튼을 수정버튼으로 변경
	let itemAddModal = document.querySelector('#itemAdd');
	itemAddModal.textContent = '수정';
	itemAddModal.id = 'itemUpdate';
	console.log('함수',item);
	
    if( !confirm("수정하시겠습니까?") ){
    	alert("수정 요청이 취소되었습니다.");
    	return;
    }else{
    	//전달받은 item 객체의 내용을 사용해서 모달 open
    	console.log(item);
		let reportItems = item.reportItemsVo;
		let cost = item.costVo;
		let receipt = item.receiptVo;
    	//모달 열기
		modal.show();
		//등록하는 태그 보이지 않기
		document.querySelector('#receiptImageDiv').style.display = 'none';
		document.querySelector('#fileShowDiv').style.display = 'block';
		
		//form에 내용 보이기
		itemForm.querySelector("[name='costId']").value = reportItems.costId;
		itemForm.querySelector("[name='receiptId']").value = reportItems.receiptId;
		itemForm.querySelector("[name='resultAmount']").value = reportItems.resultAmount;
		
		let timestamp = reportItems.itemDate;
		// Date 객체로 변환
		let date = new Date(timestamp);
		// 날짜를 yyyy-MM-dd 형식으로 변환
		let formattedDate = date.toLocaleDateString('en-CA'); // en-CA는 yyyy-MM-dd 형식으로 반환됨

		itemForm.querySelector("[name='befoDate']").value = formattedDate;
		
		let selectBig = itemForm.querySelector('#categoryBig');
		selectBig.value = cost.categoryName;
		selectBig.dataset.id = cost.categoryId;
		
		costChage(cost.categoryId, cost.costName);
		
		//let selectSm = itemForm.querySelector('#categorySm');
		//selectSm.value = cost.costName;

		itemForm.querySelector("[name='amount']").value = reportItems.amount;
		itemForm.querySelector("[name='itemDesc']").value = reportItems.itemDesc;
		
		fetch('/reportItemsApi/previewShow/' + receipt.attachId, {
				method: 'GET'
			}).then(response => response.blob())
			  .then(blob => {
			  	console.log(blob);
			  	let url = window.URL.createObjectURL(blob);
			  	
			  	// 이미지 태그에 설정
	            let imgElement = document.getElementById("fileShow");
	            imgElement.src = url;
	            imgElement.alt = receipt.attachOrgName;
	            document.querySelector('#fileOrg').textContent = receipt.attachOrgName;
	            
	            imgElement.onload = () => {
				    window.URL.revokeObjectURL(url);
				};
				
			}).catch(error => {
				console.error('항목 추가 error:', error);
			});	
		
		 document.querySelector('#itemUpdate').onclick = function(){
			//let form = new FormData(itemForm);
	    	
	    	fetch('/reportItemsApi/update/' + reportItems.itemId, {
				method: 'PATCH',
		  		body: form,  // FormData는 자동으로 적절한 형식으로 전송됨
			}).then(response => response.json())
			  .then(data => {
			  	alert("수정 되었습니다.");
			  	addCancel();
			    //목록불러오기
			    reList();
			}).catch(error => {
				console.error('항목 추가 error:', error);
			});		 
		 }
	}
}
