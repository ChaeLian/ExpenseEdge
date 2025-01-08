<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="ms-3">
            <a class="navbar-brand" href="#">ExpenseEdge</a>
        </div>
        <div class="collapse navbar-collapse" id="navbarNav">
            <div class="mr-auto">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" id="introService">소개</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">공지사항</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Q&amp;A</a></li>
                </ul>
            </div>
            <div class="ms-auto">
                <c:choose>
                    <c:when test="${not empty sessionScope.loginUser}">
                        <li class="nav-item dropdown dropstart noDeco me-3" id="user-item">
                            <button class="btn btn-light dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                                ${sessionScope.loginUser.loginId}
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <li><a class="dropdown-item" href="#">마이페이지</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="/login/logout">로그아웃</a></li>
                            </ul>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <ul class="navbar-nav me-3">
                            <li class="nav-item" id="login-item">
                                <a class="nav-link" href="/login/login">로그인</a>
                            </li>
                        </ul>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </nav>
</header>