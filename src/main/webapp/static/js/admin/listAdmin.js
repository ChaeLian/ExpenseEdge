/**
 * 
 */

    // 페이지가 로드되면 데이터를 가져오는 함수
    window.onload = function() {
        fetchPendData();
    };

    // RESTful API로 데이터를 가져오는 함수
    function fetchPendData() {
        fetch('/api/pends') // 서버의 RESTful API 엔드포인트 호출
            .then(response => response.json()) // JSON 형태로 응답 받기
            .then(data => {
                // 받아온 데이터로 테이블을 갱신
                updatePendTable(data);
            })
            .catch(error => {
                console.error('API 호출 오류:', error);
            });
    }

    // 테이블 업데이트 함수
    function updatePendTable(pends) {
        const tableBody = document.getElementById('pend-table-body');
        tableBody.innerHTML = '';  // 기존 내용을 비움
        
        // API로부터 받은 데이터로 테이블 내용 채우기
        pends.forEach((pend, index) => {
            const row = document.createElement('tr');
            
            // 행 생성
            const cell1 = document.createElement('td');
            cell1.textContent = index + 1; // 카운팅

            const cell2 = document.createElement('td');
            cell2.textContent = formatDate(pend.reportDate); // 날짜 형식화

            const cell3 = document.createElement('td');
            cell3.textContent = pend.totalAmount;

            const cell4 = document.createElement('td');
            cell4.textContent = pend.reportStatus;

            const cell5 = document.createElement('td');
            const button = document.createElement('button');
            button.type = 'button';
            button.dataset.id = pend.reportId; // 버튼에 데이터 속성 추가
            button.textContent = '수정';
            cell5.appendChild(button);

            // 각 셀을 행에 추가
            row.appendChild(cell1);
            row.appendChild(cell2);
            row.appendChild(cell3);
            row.appendChild(cell4);
            row.appendChild(cell5);

            // 행을 테이블 본문에 추가
            tableBody.appendChild(row);
        });
    }

    // 날짜 형식화 함수 (예: yyyy년 MM월 dd일)
    function formatDate(dateString) {
        const date = new Date(dateString);
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, '0');
        const day = String(date.getDate()).padStart(2, '0');
        return `${year}년 ${month}월 ${day}일`;
    }
 