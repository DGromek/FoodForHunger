<%--
  Created by IntelliJ IDEA.
  User: A754379
  Date: 10/16/2019
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Socialmedia icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Own styles -->
    <link rel="stylesheet" href="css/style.css">

    <title></title>
</head>
<body class="">


<!--Navigation bar-->
<nav class="navbar navbar-expand-md text-dark navbar-light bg-light p-3">

    <!--Brand-->
    <a class="navbar-brand" href="home.html">Brand name</a>

    <!--Toggle list button-->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbar">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">Zaloguj się</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Zarejestruj się</a>
            </li>
        </ul>
    </div>
</nav>


<div class="bg-register container-fluid main-box">
    <div class="row">
        <div class="col-md-4 align-self-center mt-5 mb-auto mx-auto p-5 shadow rounded box-size bg-page">
            <h5 class="pb-2">Zaloguj się</h5>
            <form>

                <!-- Inputs -->
                <div class="form-group">
                    <label>Podaj login</label>
                    <input class="form-control">
                </div>
                <div class="form-group">
                    <label>Podaj hasło</label>
                    <input class="form-control" type="password">
                </div>

                <!-- Submit button -->
                <button class="btn btn-primary btn-lg mt-4 px-4">Wyślij</button>

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
