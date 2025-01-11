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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
</head>
<body>
<jsp:include page="../template/header.jsp"></jsp:include>

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
	    <table class="table text-center">
	        <thead>
	            <tr>
	                <th>순번</th>
	                <th>날짜</th>
	                <th>비용항목</th>
	                <th>상세항목</th>
	                <th>지출금액</th>
	                <th>지원금액</th>
	                <th>본인부담금</th>
	                <th>영수증첨부</th>
	                <th>관리</th>
	            </tr>
	        </thead>
	        <tbody id="itemList">
	        
	        </tbody>
	        <tfoot>
	            <tr>
	                <th colspan="9">총 게시물 수 <span id="rowCount"></span> 건</th>
	            </tr>
	        </tfoot>
	    </table>
	    <div class="row">
	        <div class="col-md-10">
	            <!-- Button trigger modal -->
	            <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" id="openModal">항목추가</button>
	            <button type="button" class="btn btn-outline-dark">취소</button>
	        </div>
	        <div class="col-md-2">
	            <button type="button" class="btn btn-outline-success" onclick="submitList()">비용 항목 저장</button>
	        </div>
	    </div>
	</div>
	
	<!-- Modal style="width: 800px;"-->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h1 class="modal-title fs-5" id="staticBackdropLabel">비용 항목 추가</h1>
	                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	            </div>
	            <div class="modal-body">
	                <!-- 메인 콘텐츠 -->
	                <div class="container mt-4 bg-light">    
	                    <!-- 영수증 추가 섹션 -->
	                    <form id="itemForm" enctype="multipart/form-data" method="post" >
	                    	<input type="hidden" name="costId" id="costId">
	                    	<input type="hidden" name="receiptId" id="receiptId">
	                    	<input type="hidden" name="resultAmount" id="resultAmount" data-max="">
	                        <div class="mb-3">
	                            <label for="befoDate" class="form-label">날짜</label>
	                            <input type="text" name="befoDate" id="befoDate" class="flatpickr-input form-control" placeholder="날짜를 입력해주세요." required>
	                        </div>
	                        <div class="mb-3 row">
	                            <div class="col-md-6">
	                                <label for="categoryBig" class="form-label"></label>
	                                <select class="form-select" id="categoryBig" onchange="categoryChage(event)" required>
	                                    <option value="">카테고리 선택</option>
	                                    <c:forEach var="category" items="${categoryList}">
								            <option value="${category.categoryName}" data-id="${category.categoryId}">${category.categoryName}</option>
								        </c:forEach>
	                                </select>
	                            </div>
	                            <div class="col-md-6">
	                                <label for="categorySm" class="form-label"></label>
	                                <select class="form-select" id="categorySm" required>
	                                    <option value="">하위 카테고리 선택</option>
	                                </select>
	                            </div>
	                        </div>
	                        <div class="mb-3">
                                <label for="amount" class="form-label">지출금액</label>
                                <input type="number" class="form-control" id="amount" name="amount" required>
                            </div>
                            <div class="mb-3">
	                            <label for="itemDesc" class="form-label">설명</label>
	                            <input type="text" class="form-control" id="itemDesc" name="itemDesc">
	                        </div>
	                        <div class="mb-3" id="receiptImageDiv">
	                            <label for="receiptImage" class="form-label">영수증 이미지 업로드</label>
	                            <input type="file" class="form-control" id="receiptImage" name="upFile" accept="image/*">
	                        </div>
	                        <!-- 기존 파일 미리보기 및 수정, 삭제 -->
						    <div class="mb-3" id="fileShowDiv" style="display: none">
						        <label for="fileShow" class="form-label">현재 첨부파일</label>
						        <a onclick="removeFile(event)">X</a>
						        <span id="fileOrg"></span>				        
						        <img class="form-control" id="fileShow" src="" alt="" width="100%">
						    </div>
	                    </form>
	                </div>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" onclick="cancelBtn()">취소</button>
	              	<button type="button" class="btn btn-primary" id="itemAdd">추가</button>
	              	<button type="button" class="btn btn-primary" id="itemUpdate" style="display: none;">수정</button>
	            </div>
	        </div>
	    </div>
	</div>

<jsp:include page="../template/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script type="text/javascript" src="/js/report/reportItems.js"></script>
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
        let result = year + '-' + month + '-' + day;
        return result;
    };

    // Start와 End input 요소에 날짜 값 넣기
    document.getElementById('start').value = formatDate(startDay);
    document.getElementById('end').value = formatDate(endDay);
</script>
</body>
</html>