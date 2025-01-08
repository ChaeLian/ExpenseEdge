<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보고서 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="/css/listForm.css"> 
</head>
<body>
<jsp:include page="../template/header.jsp"></jsp:include>

	<!-- 영수증 요약 카드 -->
    <div class="container my-3">
        <h2>Report</h2>
    </div>
    <div class="container bg-light">
        <div class="row">
            <div class="col-md-4">
                <div class="card my-4">
                    <div class="card-body">
                        <div class="d-flex">
                            <h5 class="card-title">승인 대기 중 보고서</h5>
                            <p class="card-text mx-3"><span>50</span>장</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card my-4">
                    <div class="card-body">
                       <div class="d-flex">
                            <h5 class="card-title">승인 완료 보고서</h5>
                            <p class="card-text mx-3"><span>30</span>장</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card my-4">
                    <div class="card-body">
                        <div class="d-flex">
                            <h5 class="card-title">총 보고서 수</h5>
                            <p class="card-text mx-3"><span>20</span>장</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-2">
                <div id="list-example" class="list-group my-5">
                    <a class="list-group-item list-group-item-action active" href="list">보고서 목록</a>
                    <a class="list-group-item list-group-item-action" href="/reportItems/add">보고서 등록</a>
                    <a class="list-group-item list-group-item-action" href="#">비용 항목 조회</a>
                    <a class="list-group-item list-group-item-action" href="#">Q&amp;A</a>
                </div>
            </div>
            <div class="col-10">
                <table class="table caption-top mt-3 text-center" border="1">
                    <caption>승인 대기 중 보고서</caption>
                    <thead>
                        <tr>    
                            <th>순번</th>
                            <th>제출 날짜</th>
                            <th>환급액</th>
                            <th>상태</th>
                            <th>비고</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="pend" items="${pend}" varStatus="status">
	                        <tr>
	                            <td><c:out value="${status.count}"></c:out></td>
	                            <td><fmt:formatDate value="${pend.reportDate}" pattern="yyyy년 MM월 dd일" /></td>
	                            <td><c:out value="${pend.totalAmount}"></c:out></td>
	                            <td><c:out value="${pend.reportStatus}"></c:out></td>                            
	                            <td>
	                                <button type="button" data-id="${pend.reportId}" onclick="detailCheck(event)">수정</button>
	                            </td>
	                        </tr>
	                   	</c:forEach>
                    </tbody>
                </table>
                
                <div class="tab-container mt-5">
                    <div class="tab active">All</div>
                    <div class="tab">Jan</div>
                    <div class="tab">Feb</div>
                    <div class="tab">Mar</div>
                    <div class="tab">Apr</div>
                    <div class="tab">May</div>
                    <div class="tab">Jun</div>
                    <div class="tab">Jul</div>                    
                    <div class="tab">Aug</div>
                    <div class="tab">Sep</div>
                    <div class="tab">Oct</div>
                    <div class="tab">Nov</div>
                    <div class="tab">Dec</div>
                </div>
                <table class="table caption-top text-center" border="1">
                    <thead>
                        <tr>    
                            <th>순번</th>
                            <th>제출 날짜</th>
                            <th>환급액</th>
                            <th>상태</th>
                            <th>비고</th>
                        </tr>
                    </thead>
                    <tbody id="listForm">
                    	<c:forEach var="list" items="${list}" varStatus="status">
	                        <tr>
	                            <td><c:out value="${status.count}"></c:out></td>
	                            <td><fmt:formatDate value="${list.reportDate}" pattern="yyyy년 MM월 dd일" /></td>
	                            <td><c:out value="${list.totalAmount}"></c:out></td>
                            <td><c:out value="${list.reportStatus}"></c:out></td> 
	                            <td>
	                                <button type="button" data-id="${list.reportId}" onclick="detailCheck(event)">수정</button>
	                            </td>
	                        </tr>
                        </c:forEach>
                    </tbody>
                    <caption>승인 완료 보고서</caption>
                </table>
            </div>
        </div>
    </div>

<jsp:include page="../template/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

<script>
	//tbody 내용
	var tbodyForm = document.querySelector('#listForm');
	
	//원하는 달에 해당하는 보고서 보기
	var list = document.querySelectorAll('.tab');
	list.forEach(function(v, i){
		let mon = i;
		v.onclick = function(){
			if(mon !== 0){
				removeClass();
				//해당 이벤트 발생 달에 active 클래스 추가
				v.classList.add('active');
				
				fetch('/reportApi/monthList/' + mon, {
					method: 'POST',
					headers: {'Accept' : 'application/json;charset=UTF-8'}
				}).then(resp => {
					if (!resp.ok) {
						console.log('에러입니다');
						return; // 에러 발생 시, 추가 처리하지 않음
					}
					return resp.json(); // json 프로미스를 반환하여 이어서 처리
				}).then(data => {
					console.log(JSON.stringify(data)); //JSON으로 변환된 데이터를 출력
					tbodyForm.innerHTML = ''; //기존 내용 삭제
					
					data.forEach(function(v,i){
						//날짜 변환
						let date = new Date(v.reportDate);
						let year = date.getFullYear();
						let month = date.getMonth() + 1;
						let day = date.getDate();
						
						let dateFommat = year + '년 ' + month.toString().padStart(2, '0') + '월 ' + day.toString().padStart(2, '0') + '일';
						//tr, td생성
						let tr = document.createElement('tr');
						
						let countTd = document.createElement('td');
						countTd.textContent = i+1;
						
						let dateTd = document.createElement('td');
						dateTd.textContent = dateFommat;
						
						let totalTd = document.createElement('td');
	                    totalTd.textContent = v.totalAmount;
	                    
	                    let statusTd = document.createElement('td');
	                    statusTd.textContent = v.reportStatus; 
	                    
	                    let btnTd = document.createElement('td');
	                    btnTd.innerHTML = '<button type="button" data-id="' + v.reportId + '" onclick="detailCheck(event)">수정</button>';
	                    
	                    tr.appendChild(countTd);
	                    tr.appendChild(dateTd);
	                    tr.appendChild(totalTd);
	                    tr.appendChild(statusTd);
	                    tr.appendChild(btnTd);
	                    
	                    tbodyForm.appendChild(tr);
					});	
					
				}).catch(err => {
					console.log(err); // fetch 오류나 프로미스 오류를 처리
				});
			}else{
				window.location.reload();
			}
		}
	});
	
	function removeClass(){
		//active 클래스 속성이 있는 요소
		list.forEach(v => {
			if(v.classList.contains('active')){
				//active 클래스 제거
				v.classList.remove('active');
			}
		});
	}
	
	function detailCheck(ev){
		let btn = ev.target;
		let reportId = btn.dataset.id;
		console.log(reportId);
		
		
		// 		btnGroup.forEach(v => {
// 			let reportId = v.reportId;
// 			v.onclick = function(){
// 				window.location.href = '/';
// 			}
// 		});
	}
</script>

</body>
</html>