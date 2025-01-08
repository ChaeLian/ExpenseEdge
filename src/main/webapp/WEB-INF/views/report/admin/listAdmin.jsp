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
<jsp:include page="../../template/header.jsp"></jsp:include>

	<!-- 영수증 요약 카드 -->
    <div class="container my-3">
        <h2>My Report</h2>
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
                            <h5 class="card-title">승인 거절 보고서</h5>
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
                    <a class="list-group-item list-group-item-action" href="#list-item-1">보고서 목록</a>
                    <a class="list-group-item list-group-item-action" href="#list-item-2">비용 항목 등록</a>
                    <a class="list-group-item list-group-item-action" href="#list-item-3">비용 항목 조회</a>
                    <a class="list-group-item list-group-item-action" href="#list-item-4">Q&A</a>
                </div>
            </div>

            <div class="col-10">
                <div class="mt-5 d-flex">
                    <div class="col-2 ms-2 me-5">
                        <button type="button" class="btn btn-outline-danger">검색 초기화</button>
                    </div>
                    <div class="col-2 ms-4 me-3">
                        <select class="form-select">
                            <option selected>검색 월 선택</option>
                            <option value="1">1월</option>
                            <option value="2">2월</option>
                            <option value="3">3월</option>
                            <option value="4">4월</option>
                            <option value="5">5월</option>
                            <option value="6">6월</option>
                            <option value="7">7월</option>
                            <option value="8">8월</option>
                            <option value="9">9월</option>
                            <option value="10">10월</option>
                            <option value="11">11월</option>
                            <option value="12">12월</option>
                        </select>
                    </div>
            
                    <div class="col-6 me-3">
                        <div class="input-group">
                            <label for="searchValue" class="form-label"></label>
                            <input type="text" class="form-control" id="searchValue" placeholder="사용자의 이름을 검색하세요."/>
                        </div>
                    </div>
            
                    <div class="col">
                        <button type="button" class="btn btn-outline-primary">검색</button>
                    </div>
                </div>

                <div class="tab-container mt-4 caption-top">
                    <div class="tab active">승인 대기 중</div>
                    <div class="tab">승인 완료</div>
                    <div class="tab">승인 거절</div>
                </div>
                
                <table class="table" border="1">
                    <thead>
                        <tr>    
                            <th>순번</th>
                            <th>제출일</th>
                            <th>이름</th>
                            <th>환급액</th>
                            <th>상태</th>
                            <th>비고</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="pend" items="${pend}" varStatus="status">
	                        <tr>
	                            <td><c:out value="${status.count}"></c:out></td>
	                            <td style="width: 210px;"><fmt:formatDate value="${pend.reportDate}" pattern="yyyy년 MM월 dd일" /></td>
	                            <td><c:out value="${pend.memberName}"></c:out></td>
	                            <td><c:out value="${pend.totalAmount}"></c:out></td>
	                            <td><c:out value="${pend.reportStatus}"></c:out></td>                            
	                            <td>
	                                <!-- <button class="btn btn-outline-success" type="button" data-id="${pend.reportId}" onclick="checkReport(this)">확인</button> -->
	                                <a href=""><button class="btn btn-outline-success" type="button">확인</button></a>
	                            </td>
	                        </tr>
	                   	</c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

<jsp:include page="../../template/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

<script>
	function checkReport(event){
		var reportId = event.dataset.id;
	}
</script>
</body>
</html>