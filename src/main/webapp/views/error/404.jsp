<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>403</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Own styles -->
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>

<div class="container text-center mt-5">
    <span class="error-code font-weight-light">404</span><br>
    <p class="error-code-description">Nie możemy znaleźć tego co szukasz. Jesteś pewien, że wpisałeś poprawny adres?</p>
    <button class="btn btn-primary btn-lg" onclick="location.href='/';">Powrót</button>
</div>

</body>
</html>
