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
    <h2>Edytuj danie</h2>
    <hr>

    <form:form action="/dish/update" method="post" modelAttribute="dishToUpdate" enctype="multipart/form-data">

        <form:hidden path="id"/>
        <form:hidden path="user"/>
        <div class="form-group">
            <label>*Podaj nazwę</label>
            <form:input type="text" class="form-control" path="name"/>
            <small class="error-message d-block form-text"><form:errors path="name"/></small>
        </div>

        <div class="form-group">
            <label>*Podaj opis</label>
            <form:textarea class="form-control" rows="4" path="description"/>
            <small class="form-text text-muted">Podaj krótki opis, który zachęci użytkowników do kupna!</small>
            <small class="error-message d-block form-text"><form:errors path="description"/></small>
        </div>

        <div class="form-row">
            <div class="col-sm-8">
                <div class="form-group">
                    <label>Wybierz zdjęcie</label>
                    <input type="file" class="form-control-file" name="dishPhoto">
                    <small class="form-text text-muted">Maksymalny rozmiar: 16MB. Akceptowane rozszerzenia: .jpg, .jpeg, .png.</small>
                    <small class="error-message d-block form-text"/></small>
                </div>
            </div>
            <div class="col-sm-2">
                <div class="form-group">
                    <label>*Podaj cenę</label>
                    <form:input type="number" class="form-control" step="0.01" min="0" path="price"/>
                    <small class="error-message d-block form-text"><form:errors path="price"/></small>
                </div>
            </div>
            <div class="col-sm-2">
                <div class="form-group">
                    <label>*Podaj wielkość porcji</label>
                    <form:input type="number" class="form-control" step="1" min="0" path="portionSize"/>
                    <small class="form-text text-muted">Wyrażoną w gramach!</small>
                    <small class="error-message d-block form-text"><form:errors path="portionSize"/></small>
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
                    <small class="error-message d-block form-text"><form:errors path="city"/></small>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>*Ulica</label>
                    <form:input type="text" class="form-control" path="street"/>
                    <small class="error-message d-block form-text"><form:errors path="street"/></small>
                </div>
            </div>
            <div class="col-sm-2">
                <div class="form-group">
                    <label>*Numer domu</label>
                    <form:input type="text" class="form-control" path="houseNr"/>
                    <small class="error-message d-block form-text"><form:errors path="houseNr"/></small>
                </div>
            </div>
            <div class="col-sm-2">
                <div class="form-group">
                    <label>Numer lokalu</label>
                    <form:input type="text" class="form-control" path="flatNumber"/>
                    <small class="error-message d-block form-text"><form:errors path="flatNumber"/></small>
                </div>
            </div>

        </div>
        <div class="d-flex justify-content-end">
            <form:button type="submit" class="btn btn-primary mt-3 px-4">Wyślij</form:button>
        </div>
    </form:form>
</div>

<%@ include file="../core/footer.jsp" %>
<script src="../../js/uploadFileValidation.js"></script>

</body>
</html>
