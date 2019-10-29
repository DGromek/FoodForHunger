<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: A754379
  Date: 10/29/2019
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ include file="../core/header.jsp" %>

<div class="container p-4 my-4 bg-page shadow rounded">
    <h2>Edytuj profil</h2>
    <hr>
    <form:form modelAttribute="updateUserDTO">

        <div class="form-group">
            <label>Zmień adres email</label>
            <form:input type="email" class="form-control" path="email"/>
        </div>

        <div class="form-group">
            <label>Podaj opis</label>
            <form:textarea class="form-control" rows="4" path="description"/>
            <small class="form-text text-muted">Powiedz nam coś o sobie!</small>
        </div>

        <div class="form-group">
            <label>Zmień avatar</label>
            <input type="file" class="form-control-file">
        </div>


        <h5 class="pt-2">Zmień hasło</h5>
        <hr>
        <div class="form-row">
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Podaj stare hasło</label>
                    <input type="password" class="form-control">
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Podaj nowe hasło</label>
                    <input type="password" class="form-control">
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label>Powtórz nowe hasło</label>
                    <input type="password" class="form-control">
                </div>
            </div>
        </div>

        <div class="d-flex justify-content-end">
            <button type="submit" class="btn btn-primary mt-3 px-4">Wyślij</button>
        </div>
    </form:form>
</div>

<%@ include file="../core/footer.jsp" %>

</body>
</html>
