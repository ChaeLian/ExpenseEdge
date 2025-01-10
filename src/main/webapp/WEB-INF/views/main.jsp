<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EXPENSEDGE</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.3/font/bootstrap-icons.min.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/css/main.css"> 
</head>
<body>
<jsp:include page="template/header.jsp"></jsp:include>

	<!-- Hero Section -->
    <section class="mainImage">
        <div class="container">
            <h1 class="heading-text">EXPENSEDGE</h1>
            <br/>
            <p class="subheading-text">EXPENSEDGE는 효율적이고 직관적인 비용 관리 시스템을 통해,<br/>다양한 지출을 쉽게 추적하고 관리할 수 있도록 지원합니다.</p> 
            <p class="subheading-text">비용 계산과 승인 절차를 단순화하여 더 나은 재무 관리를 실현하세요.</p>
            <p class="subheading-text">간편한 비용 관리로 업무를 지원합니다.</p>
            <br/>
            <br/>
            <p style="color: white;"><a href="/reportItems/add" class="noDeco link-text">비용신청</a></p>
        </div>
    </section>

    <!-- Service Description Section -->
    <section class="service-description bg-white" id="introSection">
        <div class="container">
            <h2 class="text-center mb-4">서비스 소개</h2>
            <div class="align-items-center">
                <div class="service-item row g-0">
                    <div class="col-md-3 order-md-2 text-start align-items-end">
                        <img src="/image/board.jpg" alt="공지사항 이미지" class="img-fluid">
                    </div>
                    <div class="col-md-5 order-md-1 text-start align-items-start offset-md-1">
                        <div class="pt-5">
                            <h4 class="text-end">공지사항</h4>
                            <p class="text-end">최신 공지사항을 통해 시스템의 업데이트 및 중요 정보를 전달합니다.<br/>모든 직원이 공지사항으로 신속하게 정보를 얻을 수 있습니다.</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="align-items-center">   
                <div class="service-item row g-0">
                    <div class="col-md-3 order-md-1 text-start align-items-start offset-md-2">
                        <img src="/image/man-3653353_1280.jpg" alt="신청하기 이미지" class="img-fluid">
                    </div>
                    <div class="col-md-5 order-md-2 text-start align-items-end">
                        <div class="pt-5">
                            <h4 class="text-start">신청하기</h4>
                            <p class="text-start">간편한 신청 절차를 통해 필요한 비용을 신청할 수 있습니다.<br/>직관적인 인터페이스로 손쉽게 사용할 수 있습니다.</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="align-items-center"> 
                <div class="service-item row g-0">
                    <div class="col-md-3 order-md-2 text-start align-items-end">
                        <img src="/image/search-6819839_1280.jpg" alt="조회하기 이미지" class="img-fluid">
                    </div>
                    <div class="col-md-5 order-md-1 text-start align-items-start offset-md-1">
                        <div class="pt-5">
                            <h4 class="text-end">조회하기</h4>
                            <p class="text-end">이용 내역 및 지출을 실시간으로 조회합니다.<br/>필요할 때 언제든지 확인할 수 있습니다.</p>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="align-items-center"> 
                <div class="service-item row g-0"> 
                    <div class="col-md-3 order-md-1 text-start align-items-start offset-md-2">
                        <img src="/image/answer-3509503_1280.jpg" alt="Q&A 이미지" class="img-fluid">
                    </div>
                    <div class="col-md-5 order-md-2 text-start align-items-end">
                        <div class="pt-5">
                            <h4 class="text-start">FAQ</h4>
                            <p class="text-start">자주 묻는 질문을 통해 필요한 정보를 빠르게 찾을 수 있습니다.<br/>시스템 사용에 대한 궁금증을 쉽게 해결할 수 있는 공간입니다.</p>
                        </div>
                    </div>
                </div>
            </div>    
        </div>
    </section>

<jsp:include page="template/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

<script>
	//이동할 세션요소 선택
	var introBtn = document.querySelector('#introService');
	var intro = document.querySelector('#introSection');
	//네비게이션바의 소개 버튼 클릭 시, 소개 세션으로 스크롤내림
	introBtn.onclick = function(){
		window.scrollTo({
			top:intro.offsetTop,
			behavior: 'smooth'
		});		
	}
</script>
</body>
</html>