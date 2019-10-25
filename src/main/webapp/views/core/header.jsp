<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: A754379
  Date: 10/16/2019
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Socialmedia icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Own styles -->
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>

    <title></title>
</head>
<body>

<!--Navigation bar-->
<nav class="navbar navbar-expand-md text-dark navbar-light bg-light p-3">

    <!--Brand-->
    <a class="navbar-brand" href="/home">Food4Głód</a>

    <!--Toggle list button-->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbar">
        <c:choose>
            <c:when test="${empty loggedUser}">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="/login">Zaloguj się</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/register">Zarejestruj się</a>
            </li>
        </ul>
            </c:when>
            <c:otherwise>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/dish/browser/0">Wyszukaj danie</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/">Wystaw danie</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/profile/${loggedUser.id}/0/0">Twoje konto</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Wyloguj</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link">Witaj ${loggedUser.login}!</a>
                    </li>
                </ul>
            </c:otherwise>
        </c:choose>
    </div>
</nav>

</body>
</html>