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

	<div class="container mt-3">
	    <div class="row">
	        <div class="col-md-6">
	            <h3 class="my-3">지출 예정 항목</h3>
	        </div>
	        <div class="col-md-6">
	            <div class="d-flex">
	                <div class="d-flex align-items-center botomline mx-4">
	                    <label for="start" class="form-label mt-2">Start</label>
	                    <input type="text" id="start" class="form-control-plaintext mx-3" readonly>
	                </div>
	                <div class="d-flex align-items-center botomline mx-4">
	                    <label for="end"  class="form-label mt-2">End</label>
	                    <input type="text" id="end" class="form-control-plaintext mx-3" readonly>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	
	<div class="container my-3">
	    <table class="table text-center caption-top">
	        <thead>
	            <tr>
	                <th>순번</th>
	                <th>날짜</th>
	                <th>비용항목</th>
	                <th>상세항목</th>
	                <th>지출금액</th>
	                <th>환급액</th>
	                <th>영수증첨부</th>
	            </tr>
	        </thead>
	        <tbody>
	            <tr>
	                <th>1</th>
	                <th>2024-7-1</th>
	                <th>국내출장</th>
	                <th>식사</th>
	                <th>12000</th>
	                <th>1000</th>
	                <th>O</th>
	            </tr>
	        </tbody>
	        <tfoot>
	            <caption>총 게시물 수 0 건</caption>
	        </tfoot>
	    </table>
	    <div class="row">
	        <div class="col-md-10">
	            <button type="button" class="btn btn-outline-dark">수정</button>
	        </div>
	        <div class="col-md-2 d-flex justify-content-end">
	            <button type="button" class="btn btn-outline-success">제출</button>
	        </div>
	    </div>
	</div>

<jsp:include page="../template/header.jsp"></jsp:include>

	

<jsp:include page="../template/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

<script>
    // 현재 날짜를 구함
    var today = new Date();

    // 현재 달의 첫째 날 (1일)
    var startDay = new Date(today.getFullYear(), today.getMonth(), 1);
    // 현재 달의 마지막 날
    var endDay = new Date(today.getFullYear(), today.getMonth() + 1, 0);

    // 날짜를 yyyy-mm-dd 형식으로 변환하는 함수
    var formatDate = (date) => {
        let year = date.getFullYear();
        let month = String(date.getMonth() + 1).padStart(2, '0'); // 월은 0부터 시작하므로 +1
        let day = String(date.getDate()).padStart(2, '0');
        let result = `${year}-${month}-${day}`;
        return result;
    };

    // Start와 End input 요소에 날짜 값 넣기
    document.getElementById('start').value = formatDate(startDay);
    document.getElementById('end').value = formatDate(endDay);
</script>

</body>
</html>