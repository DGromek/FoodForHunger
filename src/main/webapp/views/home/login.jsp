<%--
  Created by IntelliJ IDEA.
  User: A754379
  Date: 10/16/2019
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title></title>
</head>
<body>

<%@ include file="../core/header.jsp" %>

<div class="bg-register container-fluid main-box">
    <div class="row">
        <div class="col-md-4 align-self-center mt-5 mb-auto mx-auto p-5 shadow rounded box-size bg-page">

            <c:if test="${!empty param.error}">
                <div class="alert alert-danger">
                    Wprowadzono nieprawidłowe dane logowania.
                </div>
            </c:if>

            <h5 class="pb-2">Zaloguj się</h5>
            <form method="post">
                <!-- Inputs -->
                <div class="form-group">
                    <label>Podaj login</label>
                    <input class="form-control" name="username">
                </div>
                <div class="form-group">
                    <label>Podaj hasło</label>
                    <input class="form-control" type="password" name="password">
                </div>

                <!-- Submit button -->
                <button class="btn btn-primary btn-lg mt-4 px-4" type="submit">Wyślij</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>
    </div>
</div>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
