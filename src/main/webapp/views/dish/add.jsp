<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj danie</title>
</head>
<body>

<%@ include file="../core/header.jsp" %>

<div class="container p-4 my-4 bg-page shadow rounded">
    <h2>Dodaj danie</h2>
    <hr>

    <form:form method="post" modelAttribute="dishToAdd" enctype="multipart/form-data" id="dish-form">

        <form:hidden path="id"/>
        <div class="form-group">
            <label>*Podaj nazwę</label>
            <form:input type="text" class="form-control" path="name"/>
        </div>

        <div class="form-group">
            <label>*Podaj opis</label>
            <form:textarea class="form-control" rows="4" path="description"/>
            <small class="form-text text-muted" id="description-hint">Podaj krótki opis, który zachęci użytkowników do kupna!</small>
        </div>

        <div class="form-row">
            <div class="col-sm-6">
                <div class="form-group">
                    <label>Wybierz zdjęcie</label>
                    <input type="file" class="form-control-file" name="dishPhoto" id="dishPhoto">
                    <small class="form-text text-muted" id="dishPhoto-hint">Maksymalny rozmiar: 16MB. Akceptowane rozszerzenia: .jpg, .jpeg, .png.</small>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label>*Podaj cenę</label>
                    <form:input type="number" step="0.01" min="0" class="form-control" path="price"/>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label>*Podaj wielkość porcji</label>
                    <form:input type="number" step="1" min="0" class="form-control" path="portionSize"/>
                    <small class="form-text text-muted" id="portionSize-hint">Wyrażoną w gramach!</small>
                </div>
            </div>
        </div>

        <h4>Podaj miejsce odbioru</h4>
        <hr>
        <div class="form-row">

            <div class="col-sm-4">
                <div class="form-group">
                    <label>*Miasto</label>
                    <form:input type="text" class="form-control" path="city"/>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>*Ulica</label>
                    <form:input type="text" class="form-control" path="street"/>
                </div>
            </div>
            <div class="col-sm-2">
                <div class="form-group">
                    <label>*Numer domu</label>
                    <form:input type="text" class="form-control" path="houseNr"/>
                </div>
            </div>
            <div class="col-sm-2">
                <div class="form-group">
                    <label>Numer lokalu</label>
                    <form:input type="number" step="1" min="0" class="form-control" path="flatNumber"/>
                </div>
            </div>

        </div>
        <div class="d-flex justify-content-end">
            <form:button type="submit" class="btn btn-primary mt-3 px-4">Wyślij</form:button>
        </div>
    </form:form>
</div>

<%@ include file="../core/footer.jsp" %>
<script src="../../js/form-validation/dishValidation.js"></script>
<script src="../../js/form-validation/validationProperties.js"></script>
</body>
</html>
