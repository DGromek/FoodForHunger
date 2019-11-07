<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html lang="pl">
<head>
    <script>
        function clearPasswordInputs() {
            document.getElementById('password-1').value = '';
            document.getElementById('password-2').value = '';
        }
    </script>
    <title>Zarejestruj</title>
</head>
<body onload="clearPasswordInputs()">

<%@ include file="../core/header.jsp" %>

<div class="container-fluid">
    <div class="row bg-register">
        <div class="col-lg-4 mt-5 mb-auto mx-auto p-5 shadow rounded bg-page">
        <h5 class="pb-2">Zarejestruj się</h5>

        <form:form action="/register" method="post" modelAttribute="userToRegister">

            <!-- Inputs -->
            <div class="form-group" id="register-form">
                <label>Podaj login</label>
                <form:input class="form-control" path="username"/>
                <small><form:errors class="error-message d-block form-text" path="username"/></small>
            </div>
            <div class="form-group">
                <label>Podaj email</label>
                <form:input class="form-control" type="email" path="email"/>
                <small><form:errors class="error-message d-block form-text" path="email"/></small>
            </div>
            <div class="form-group">
                <label>Podaj hasło</label>
                <form:input value="" class="form-control" type="password" path="password" alt="password" id="password-1"/>
                <small><form:errors class="error-message d-block form-text" path="password"/></small>
            </div>
            <div class="form-group">
                <label>Powtórz hasło</label>
                <form:input class="form-control" type="password" path="repeatedPassword" id="password-2"/>
                <small><form:errors class="error-message d-block form-text" path="repeatedPassword"/></small>
            </div>

            <!-- Checkboxes -->
            <div class="form-check">
                <form:checkbox class="form-check-input big-checkbox" path="accepted"/>
                <label class="form-check-label">
                    Akceptuje <a href="">regulamin serwisu</a>.
                </label>
            </div>
            <small><form:errors class="error-message d-block form-text" path="accepted"/></small>

            <!-- Submit button -->
            <form:button class="btn btn-primary btn-lg mt-4 px-4" type="submit">Wyślij</form:button>

        </form:form>
        </div>
    </div>
</div>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
