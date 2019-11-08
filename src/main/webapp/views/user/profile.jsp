<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<sec:authentication var="loggedUser" property="principal.username"/>
<html>

<head>
    <title>${user.username}</title>
</head>
<body onload="profileDishPagination('${user.username}', 0); profileCommentPagination('${user.username}', 0, '${loggedUser}')">

<%@ include file="../core/header.jsp" %>

<div class="container p-4 my-4 bg-page shadow rounded">
    <div class="row">
        <div class="col-md-3 col-lg-2 pb-2 px-2 d-flex justify-content-center">
            <img src="/user/getImage/${user.id}" class="img-fluid user-avatar">
        </div>
        <div class="col-md-9 col-lg-10">
            <div class="row">
                <div class="col-6">
                    <h2 class="m-0">${user.username}</h2>
                </div>
                <div class="col-6 d-flex justify-content-end">
                    <c:choose>
                        <c:when test="${loggedUser eq user.username}">
                            <button class="btn btn-primary" onclick="window.location.href='/user/update'">Zaktualizuj profil</button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-primary" data-toggle="modal" data-target="#addEditCommentModal">Dodaj komentarz</button>
                        </c:otherwise>
                    </c:choose>
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
                    <nav>
                        <ul class="pagination pagination-sm justify-content-center mb-0" id="dish-display-pagination">
                            <!-- Here goes data from profileDishPagination script -->
                        </ul>
                    </nav>
                    <div class="card-deck" id="dish-display">
                        <!-- Here goes data from profileDishPagination script -->
                    </div>
                </div>

                <!-- Comments section -->
                <div class="tab-pane fade" id="comments" role="tabpanel" aria-labelledby="profile-tab">
                    <!-- Comments paggination -->
                    <nav>
                        <ul class="pagination pagination-sm justify-content-center mb-0"
                            id="comment-display-pagination">
                            <!-- Here goes data from profileCommentPagination script -->
                        </ul>
                    </nav>
                    <!-- Comments content -->
                    <div class="card-deck" id="comment-display">
                        <!-- Here goes data from profileCommentPagination script -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Delete Comment Modal -->
<div class="modal fade" id="deleteCommentModal" role="dialog">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">

            <div class="modal-body">
                <!-- Exit button -->
                <button type="button" class="close pb-3" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <!-- Content -->
                <h5 class="py-2">Jesteś pewien?</h5>
                <div class="d-flex justify-content-end">
                    <button class="btn btn-success" data-dismiss="modal" aria-label="Close">Anuluj</button>
                    <a class="btn btn-danger ml-1" id="delete-button">Usuń</a>
                </div>
            </div>

        </div>
    </div>
</div>

<!-- Add/Edit comment modal -->
<div class="modal fade" id="addEditCommentModal" role="dialog">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">

            <div class="modal-body">
                <!-- Exit button -->
                <button type="button" class="close pb-3" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <!-- Content -->
                <h5 class="py-2"></h5>
                <form>
                    <div class="form-group">
                        <label>Wybierz ocenę</label>
                        <select class="form-control">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="col-form-label">Treść:</label>
                        <textarea class="form-control"></textarea>
                    </div>
                </form>
                <div class="d-flex justify-content-end">
                    <button class="btn btn-primary" data-dismiss="modal" aria-label="Close">Anuluj</button>
                    <button class="btn btn-success ml-1" type="submit">Zapisz</button>
                </div>
            </div>

        </div>
    </div>
</div>

<%@ include file="../core/footer.jsp" %>
<script src="../../js/profileDishPagination.js"></script>
<script src="../../js/profileCommentPagination.js"></script>

<script src="../../js/commentCRUDModals.js"></script>

</body>
</html>