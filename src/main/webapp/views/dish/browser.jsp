<%--
  Created by IntelliJ IDEA.
  User: A754379
  Date: 10/17/2019
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ include file="../core/header.jsp" %>

<!-- Result filters -->
<div class="container">
    <nav class="">
        <form>
            <!-- Filter bar -->
            <div class="row btn-toolbar d-flex justify-content-center" role="toolbar"
                 aria-label="Toolbar with button groups">

                <!-- Dropdown allergens -->


                <div class="btn-group col-sm-4 col-lg-2 mt-3">
                    <button class="btn btn-info dropdown-toggle" role="button" id="dropdownAllergens"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Rodzaj diety
                    </button>

                    <div class="dropdown-menu p-2" aria-labelledby="dropdownAllergens">
                        <label>
                            <input type="checkbox"> Wegetariańska
                        </label> <br>
                        <label>
                            <input type="checkbox"> Wegańska
                        </label> <br>
                        <label>
                            <input type="checkbox"> Bezlaktozy
                        </label> <br>
                        <label>
                            <input type="checkbox"> Bezglutenowa
                        </label> <br>
                    </div>
                </div>


                <!-- Dropdown city -->
                <div class="btn-group col-sm-4 col-lg-2 mt-3">
                    <button class="btn btn-info dropdown-toggle" role="button" id="dropdownCity" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">Miasto
                    </button>

                    <div class="dropdown-menu p-2" aria-labelledby="dropdownCity">
                        <label>
                            <input type="checkbox"> Łódź
                        </label> <br>
                        <label>
                            <input type="checkbox"> Warszawa
                        </label> <br>
                    </div>
                </div>

                <!-- Dropdown dish category -->
                <div class="btn-group col-sm-4 col-lg-2 mt-3">
                    <button class="btn btn-info dropdown-toggle" role="button" id="dropdownDishCategory"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Rodzaj posiłku
                    </button>

                    <div class="dropdown-menu p-2" aria-labelledby="dropdownDishCategory">
                        <label>
                            <input type="checkbox"> Śniadanie
                        </label> <br>
                        <label>
                            <input type="checkbox"> Obiad
                        </label> <br>
                        <label>
                            <input type="checkbox"> Kolacja
                        </label> <br>
                        <label>
                            <input type="checkbox"> Deser
                        </label> <br>
                    </div>
                </div>

                <!-- Name Filter -->
                <div class="col-sm-8 col-lg-4 mt-3">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <div class="input-group-text" id="btnGroupAddon2">Szukaj:</div>
                        </div>
                        <input type="text" class="form-control" aria-label="Input group example"
                               aria-describedby="btnGroupAddon2">
                    </div>
                </div>
                <div class="col-sm-4 col-lg-2 text-center mt-3">
                    <div class="btn-group btn-block">
                        <button class="btn btn-success">Filtruj!</button>
                    </div>
                </div>
            </div>
        </form>
    </nav>

    <!-- Results -->


<c:forEach items="${dishPage.iterator()}" var="dish" varStatus="iteration">

    <c:if test="${(iteration.count % 3 == 1)}">
        <div class="row card-deck p-4">
    </c:if>
        <div class="card col-md-4 border-0 shadow pt-3">
            <img class="card-img-top img-fluid" src="/dish/getImage/${dish.id}" id="browser-dish-thumbnail">
            <div class="card-body">
                <h4 class="card-title">${dish.name}</h4>
                <h6 class="card-subtitle mb-2 text-muted">By <a href="/user/profile/${dish.user.id}/0/0">${dish.user.login}</a></h6>
                <p class="card-text">${dish.description}</p>
                <a href="/dish/details/${dish.id}" class="btn btn-info">Zobacz więcej!</a>
            </div>
        </div>
    <c:if test="${(iteration.count % 3 == 0) || (!dishPage.iterator().hasNext())}">
        </div>
    </c:if>
</c:forEach>
</div>

<!-- Results pagination -->
<nav>
    <ul class="pagination justify-content-center pb-4">
        <c:if test="${dishPage.number eq 1}">
            <li class="page-item"><a
                    href="/user/profile/${user.id}/${dishPage.number - 1}/${commentPage.number}"
                    class="page-link">&laquo;</a></li>
            <li class="page-item"><a
                    href="/user/profile/${user.id}/${dishPage.number - 1}/${commentPage.number}"
                    class="page-link">${dishPage.number}</a></li>
        </c:if>

        <li class="page-item active"><a class="page-link">${dishPage.number + 1}</a></li>

        <c:if test="${dishPagePage.number < dishPage.totalPages - 1}">
            <li class="page-item"><a
                    href="/user/profile/${user.id}/${dishPage.number + 1}/${commentPage.number}"
                    class="page-link">${dishPage.number + 2}</a></li>
            <li class="page-item"><a
                    href="/user/profile/${user.id}/${dishPage.number + 1}/${commentPage.number}"
                    class="page-link">&raquo;</a></li>
        </c:if>
    </ul>
</nav>

<%@ include file="../core/footer.jsp" %>

</body>
</html>