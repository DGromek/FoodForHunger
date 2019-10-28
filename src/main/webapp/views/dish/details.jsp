<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>

<%@ include file="../core/header.jsp" %>
<!-- Content -->
<div class="container p-4 my-4 bg-page shadow rounded">
    <div class="row">
        <div class="col">
            <a href="#dishImgModal" role="button" data-toggle="modal">
                <img src="/dish/getImage/${dish.id}" class="img-fluid" id="dish-details-thumbnail">
            </a>
        </div>
    </div>
    <h2 class="pt-2">${dish.name}</h2>
    <h6>By <a href="/user/profile/${dish.user.username}/0/0">${dish.user.username}</a></h6>
    <p>${dish.description}</p>

    <div class="text-right">
        <span class="pr-2">Portion: 400g</span>
        <span class="pr-3">Price: ${dish.price} zł</span>
        <button class="btn btn-success">Kup teraz!</button>
        <button class="btn btn-warning">Edytuj</button>
        <button class="btn btn-danger" data-toggle="modal" data-target="#deleteDishModal">Usuń danie</button>
    </div>
</div>

<!-- Modal1 -->
<div class="modal fade" id="dishImgModal">
    <div class="modal-dialog modal-dialog-centered modal-xl" role="document">
        <div class="modal-content">

            <div class="modal-body">
                <!-- Exit button -->
                <button type="button" class="close pb-3" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <!-- Content -->
                <img src="/dish/getImage/${dish.id}" class="img-fluid">
            </div>

        </div>
    </div>
</div>

<!-- Modal2 -->
<div class="modal fade" id="deleteDishModal">
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
                <button class="btn btn-danger mr-1">Usuń</button>
                <button class="btn btn-success" data-dismiss="modal" aria-label="Close">Anuluj</button>
                </div>
            </div>

        </div>
    </div>
</div>

<%@ include file="../core/footer.jsp" %>

</body>
</html>
