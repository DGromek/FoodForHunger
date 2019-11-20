<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zaktualizuj profil</title>
</head>
<body>

<%@ include file="../core/header.jsp" %>

<div class="container p-4 my-4 bg-page shadow rounded">
    <h2>Edytuj profil</h2>
    <hr>
    <form:form method="post" modelAttribute="updateUserDTO" enctype="multipart/form-data" id="user-update-form">

        <div class="form-group">
            <label>Zmień adres email</label>
            <form:input type="email" class="form-control" path="email"/>
            <small class="error-message d-block form-text"><form:errors path="email"/></small>
        </div>

        <div class="form-group">
            <label>Podaj opis</label>
            <form:textarea class="form-control" rows="4" path="description"/>
            <small class="form-text text-muted" id="description-hint">Powiedz nam coś o sobie!</small>
        </div>

        <div class="form-group">
            <label>Zmień avatar</label>
            <input type="file" class="form-control-file" name="avatar">
            <small class="form-text text-muted" id="avatar-hint">Maksymalny rozmiar: 16MB. Akceptowane rozszerzenia: .jpg, .jpeg, .png.</small>
        </div>

        <h5 class="pt-2">Zmień hasło</h5>
        <hr>
        <div class="form-row">
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Podaj stare hasło</label>
                    <form:input type="password" class="form-control" path="oldPassword"/>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Podaj nowe hasło</label>
                    <form:input type="password" class="form-control" path="newPassword" id="newPassword"/>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Powtórz nowe hasło</label>
                    <form:input type="password" class="form-control" path="newPasswordRepeated" id="newPasswordRepeated"/>
                </div>
            </div>
        </div>

        <div class="d-flex justify-content-end">
            <form:button type="submit" class="btn btn-primary mt-3 px-4">Wyślij</form:button>
        </div>
    </form:form>
</div>

<%@ include file="../core/footer.jsp" %>
<script src="../../js/form-validation/userUpdateValidation.js"></script>
<script src="../../js/form-validation/validationProperties.js"></script>

</body>
</html>
