<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<sec:authentication var="loggedUser" property="principal.username"/>
<html>

<head>
    <title>${user.username}</title>
</head>

<body onload="getProfileDishPage('${user.username}', 0)">

<%@ include file="../core/header.jsp" %>

<div class="container p-4 my-4 bg-page shadow rounded">
    <div class="row">
        <div class="col-md-3 col-lg-2 pb-2 px-2 d-flex justify-content-center">
            <img src="/user/getImage/${user.id}" id="user-avatar" class="img-fluid">
        </div>
        <div class="col-md-9 col-lg-10">
            <div class="row">
                <div class="col-6">
                    <h2 class="m-0">${user.username}</h2>
                </div>
                <div class="col-6 d-flex justify-content-end">
                    <c:if test="${loggedUser eq user.username}">
                    <button class="btn btn-primary" onclick="window.location.href='/user/update'">Zaktualizuj</button>
                    </c:if>
                </div>
            </div>
            <hr>
            <p>${user.description}</p>
        </div>
    </div>

    <!-- Content -->
    <!-- Card tabs -->
    <div class="card my-4">
        <div class="card-header">
            <ul class="nav nav-tabs card-header-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" data-toggle="tab" href="#dishes" role="tab">Przepisy</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#comments" role="tab">Komentarze</a>
                </li>
            </ul>
        </div>

        <!-- Cards content -->
        <div class="card-body">
            <div class="tab-content">

                <!-- Dishes section -->
                <div class="tab-pane fade show active" id="dishes" role="tabpanel" aria-labelledby="home-tab">
                    <div class="row card-deck" id="dish-display">
                        <!-- Here goes data from getProfileDishPage script -->
                    </div>

                    <nav>
                        <ul class="pagination pagination-sm justify-content-center" id="dish-browser-pagination">
                            <!-- Here goes data from getProfileDishPage script -->
                        </ul>
                    </nav>

                </div>

                <!-- Comments section -->
                <div class="tab-pane fade" id="comments" role="tabpanel" aria-labelledby="profile-tab">
                    <c:forEach items="${commentPage.content}" var="row">
                        <div class="row card-deck">
                            <c:forEach items="${row.content}" var="comment">
                                <div class="card col-md-6 my-3 border shadow bg-light rounded p-0">
                                    <div class="card-header">
                                        <div class="row">
                                            <div class="px-2">
                                                <img src="/user/getImage/${comment.author.id}"
                                                     class="img-fluid rounded-circle pr-1"
                                                     id="user-avatar-thumbnail">
                                            </div>
                                            <div class="col m-auto p-0">
                                                <a href="/user/profile/${comment.author.username}/0/0">${comment.author.username}</a>
                                            </div>
                                            <div class="col m-auto text-right">
                                                <c:forEach step="1" begin="1" end="${comment.rating}">
                                                    <i class="fa fa-star"></i>
                                                </c:forEach>
                                                <c:forEach step="1" begin="1" end="${5 - comment.rating}">
                                                    <i class="fa fa-star-o"></i>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card-body pb-0">
                                        <div class="card-text">
                                            <p>${comment.content}</p>
                                        </div>
                                    </div>
                                    <div class="card-footer border-0 bg-light pt-0">
                                        <small>Dodano: ${comment.created}</small>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </c:forEach>

                    <!-- Comments paggination -->
                    <nav>
                        <ul class="pagination pagination-sm justify-content-center">
                            <c:if test="${commentPage.number eq 1}">
                                <li class="page-item"><a
                                        href="/user/profile/${user.username}/${dishPage.number}/${commentPage.number - 1}"
                                        class="page-link">&laquo;</a></li>
                                <li class="page-item"><a
                                        href="/user/profile/${user.username}/${dishPage.number}/${commentPage.number - 1}"
                                        class="page-link">${commentPage.number}</a></li>
                            </c:if>

                            <li class="page-item active"><a class="page-link">${commentPage.number + 1}</a></li>

                            <c:if test="${commentPage.number < commentPage.totalPages - 1}">
                                <li class="page-item"><a
                                        href="/user/profile/${user.username}/${dishPage.number}/${commentPage.number + 1}"
                                        class="page-link">${commentPage.number + 2}</a></li>
                                <li class="page-item"><a
                                        href="/user/profile/${user.username}/${dishPage.number}/${commentPage.number + 1}"
                                        class="page-link">&raquo;</a></li>
                            </c:if>
                        </ul>
                    </nav>

                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../core/footer.jsp" %>
<script src="../../js/getProfileDishPage.js"></script>

</body>
</html>
