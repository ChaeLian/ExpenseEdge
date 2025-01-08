<%@page import="org.springframework.context.annotation.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
    body {
        background-color: white; /* #f8f9fa */
    }
    #top-title{
    	margin-top: 8%;
    	margin-bottom: 10px;
    }
    .login-container {
        max-width: 800px;
        margin-top: 50px;
        margin-left: auto;
        margin-right: auto;
        margin-bottom: 100px;
        
    }
    .card-header {
        border: none;
        background-color: white;
    }
    .card-body{
    	margin-left: 15%;
    	margin-right: 15%;
    }
</style>
</head>

<body>
	<div class="container">
		<div class="text-center" id="top-title">
			<h2>ExpenseEdge</h2>
		</div>
        <div class="login-container">
            <div class="card shadow">
                <div class="card-header py-4 text-center">
                    <h4>Login</h4>
                </div>
                <div class="card-body">
                    <form action="/login/login" method="post">
                        <div class="mb-3">
                            <label for="loginId" class="form-label">아이디</label>
                            <input type="text" class="form-control" id="loginId" name="loginId" required>
                        </div>
                        <div class="mb-3">
                            <label for="loginPassword" class="form-label">비밀번호</label>
                            <input type="password" class="form-control" id="loginPassword" name="loginPassword" required>
                        </div>
                        <!-- 
                        <div class="mb-3 form-check">
                            <input type="checkbox" class="form-check-input" id="rememberMe">
                            <label class="form-check-label" for="rememberMe">로그인 상태 유지</label>
                        </div>
                         -->
                        <button type="submit" class="btn btn-primary w-100">로그인</button>
                    </form>
                </div>
                <div class="card-footer text-center mt-4">
                	<div class="my-2 row justify-content-center">
	                    <a href="#" class="col text-decoration-none">아이디를 잊으셨나요?</a><br>
	                    <span class="col-1">|</span>
	                    <a href="#" class="col text-decoration-none">회원 가입</a>
                	</div>
                </div>
            </div>
        </div>
    </div>
	
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- <script type="text/javascript" src="/js/login/login.js"></script>  -->

</body>
</html>