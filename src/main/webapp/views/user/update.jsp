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
    <form:form method="post" modelAttribute="updateUserDTO" enctype="multipart/form-data">

        <div class="form-group">
            <label>Zmień adres email</label>
            <form:input type="email" class="form-control" path="email"/>
            <small><form:errors class="error-message d-block form-text" path="email"/></small>
        </div>

        <div class="form-group">
            <label>Podaj opis</label>
            <form:textarea class="form-control" rows="4" path="description"/>
            <small class="form-text text-muted">Powiedz nam coś o sobie!</small>
            <small><form:errors class="error-message d-block form-text" path="description"/></small>
        </div>

        <div class="form-group">
            <label>Zmień avatar</label>
            <input type="file" class="form-control-file" name="avatar">
            <small class="form-text text-muted">Maksymalny rozmiar: 16MB. Akceptowane rozszerzenia: .jpg, .jpeg, .png.</small>
            <small class="error-message" id="upload-file-error" ></small>
        </div>

        <h5 class="pt-2">Zmień hasło</h5>
        <hr>
        <div class="form-row">
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Podaj stare hasło</label>
                    <form:input type="password" class="form-control" path="oldPassword"/>
                    <small><form:errors class="error-message d-block form-text" path="oldPassword"/></small>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Podaj nowe hasło</label>
                    <form:input type="password" class="form-control" path="newPassword"/>
                    <small><form:errors class="error-message d-block form-text" path="newPassword"/></small>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Powtórz nowe hasło</label>
                    <form:input type="password" class="form-control" path="newPasswordRepeated"/>
                    <small><form:errors class="error-message d-block form-text" path="newPasswordRepeated"/></small>
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
