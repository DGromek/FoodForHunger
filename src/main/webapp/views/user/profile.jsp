<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title></title>
</head>

<body>
<%@ include file="../core/header.jsp" %>

<div class="container p-4 my-4 bg-page shadow rounded">
    <div class="row">
        <div class="col-4 col-md-3 col-lg-2 px-2">
            <img src="/user/getImage/${user.id}" id="user-avatar" class="img-fluid">
        </div>

        <!-- Header -->
        <div class="col-8 col-md-9 col-lg-10 align-self-center">
            <h2>${user.login}</h2>
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
                    <div class="card-deck">

                        <div class="card my-4 p-3 border shadow bg-light">
                            <img class="card-img-top img-fluid" src="https://placehold.it/100x45">
                            <div class="card-body">
                                <h5>Sample name</h5>
                                <p class="card-text">
                                    Some quick example text to build on the card title and make up the bulk of the
                                    card's content.
                                    Some quick example text to build on the card title and make up the bulk of the
                                    card's content.
                                    Some quick example text to build on the card title and make up the bulk of the
                                    card's content.<br>
                                </p>

                            </div>
                            <div class="card-footer border-0 text-right bg-light">
                                <button class="btn btn-outline-info btn-sm">Szczegóły</button>
                            </div>
                        </div>

                        <div class="card my-4 p-3 border shadow bg-light">
                            <img class="card-img-top img-fluid" src="https://placehold.it/100x45">
                            <div class="card-body">
                                <h5>Sample name</h5>
                                <p class="card-text">
                                    Some quick example text to build on the card title and make up the bulk of the
                                    card's content.<br>
                                </p>
                            </div>
                            <div class="card-footer border-0 text-right bg-light">
                                <button class="btn btn-outline-info btn-sm">Szczegóły</button>
                            </div>
                        </div>

                    </div>

                    <!-- Dishes paggination -->
                    <nav>
                        <ul class="pagination pagination-sm justify-content-center">
                            <li class="page-item"><a class="page-link">&laquo;</a></li>
                            <li class="page-item"><a class="page-link">1</a></li>
                            <li class="page-item active"><a class="page-link">2</a></li>
                            <li class="page-item"><a class="page-link">3</a></li>
                            <li class="page-item"><a class="page-link">&raquo;</a></li>
                        </ul>
                    </nav>

                </div>

                <!-- Comments section -->
                <div class="tab-pane fade" id="comments" role="tabpanel" aria-labelledby="profile-tab">
                    <c:forEach items="${commentPage.iterator()}" var="comment" varStatus="iteration">

                        <c:if test="${(iteration.count eq 1) || (iteration.count eq 3)}">
                            <div class="card-deck">
                        </c:if>

                        <div class="card my-4 border shadow bg-light rounded">
                            <div class="card-header">
                                <img src="/user/getImage/${comment.author.id}" class="img-fluid rounded-circle pr-1"
                                     id="avatar-thumbnail">
                                <a href="/user/profile/${comment.author.id}">${comment.author.login}</a>
                            </div>
                            <div class="card-body">
                                <div class="card-text">
                                    <p>${comment.content}</p>
                                </div>
                            </div>
                        </div>

                        <c:if test="${(iteration.count eq 2) || (iteration.count eq 4)}">
                            </div>
                        </c:if>
                    </c:forEach>


                    <!-- Comments paggination -->
                    <nav>
                        <ul class="pagination pagination-sm justify-content-center">
                            <c:if test="${commentPage.number eq 1}">
                                <li class="page-item"><a href="/user/profile/${user.id}/${dishPage.number}/${commentPage.number - 1}" class="page-link">&laquo;</a></li>
                                <li class="page-item"><a href="/user/profile/${user.id}/${dishPage.number}/${commentPage.number - 1}" class="page-link">${commentPage.number}</a></li>
                            </c:if>

                            <li class="page-item active"><a class="page-link">${commentPage.number + 1}</a></li>

                            <c:if test="${commentPage.number < commentPage.totalPages - 1}">
                                <li class="page-item"><a href="/user/profile/${user.id}/${dishPage.number}/${commentPage.number + 1}" class="page-link">${commentPage.number + 2}</a></li>
                                <li class="page-item"><a href="/user/profile/${user.id}/${dishPage.number}/${commentPage.number + 1}" class="page-link">&raquo;</a></li>
                            </c:if>
                        </ul>
                    </nav>

                </div>
            </div>
        </div>
    </div>

</div>

<%@ include file="../core/footer.jsp" %>

</body>
</html>