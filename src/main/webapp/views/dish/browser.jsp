<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zjedz coś!</title>
</head>
<body onload="dishBrowserPagination(0)">

<%@ include file="../core/header.jsp" %>

<!-- Result filters -->
<div class="container">
    <nav>
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

    <div class="card-deck my-3" id="browser-results">
        <!-- Here goes data from dishBrowserPagination script -->
    </div>

</div>

<!-- Results pagination -->
<nav>
    <ul class="pagination justify-content-center pb-4" id="browser-pagination">
        <!-- Here goes data from dishBrowserPagination script -->
    </ul>
</nav>

<%@ include file="../core/footer.jsp" %>
<script src="../../js/dishBrowserPagination.js"></script>

</body>
</html>
