<%--
  Created by IntelliJ IDEA.
  User: A754379
  Date: 10/16/2019
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" href="../css/style.css">

    <title></title>
</head>
<body>

<%@ include file="core/header.jsp" %>

<!--Content-->
<div class="container-fluid">
    <div class="bg-image1 row">
        <div class="align-self-center col-12 text-dark text-center">
            <h1 class="p-4">Bacon ipsum dolor amet biltong shoulder</h1>
            <button class="btn btn-lg btn-info">Zarejestruj się teraz!</button>
        </div>
    </div>
</div>

<div class="container py-5">
    <h2 class = "text-center">Lorem ipsum dolor sit amet</h2>
    <p>
        Mauris scelerisque blandit ligula at semper. Proin ac euismod purus. Suspendisse potenti. Cras augue felis, hendrerit ultrices pharetra non, posuere vel odio. In ultrices sagittis ante, sit amet condimentum neque iaculis iaculis. Suspendisse potenti. Suspendisse turpis lacus, tincidunt in ligula vitae, sollicitudin ornare massa. Curabitur ipsum velit, tristique non congue sit amet, viverra sed ipsum. Nulla vitae augue ut turpis fringilla interdum eget id tortor. Sed cursus quam quis nibh facilisis, consectetur commodo sapien condimentum. Suspendisse potenti. Integer sagittis lectus ac turpis finibus, ut imperdiet libero tempus. Cras erat magna, scelerisque in magna sit amet, feugiat aliquam nisl. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur sagittis sem, ac ultricies orci mollis et
    </p>
</div>

<!-- Cards -->
<div class="bg-page">
    <div class="container py-4">
        <div class="row card-deck">

            <div class="card col-md-4 border-0 shadow">
                <div class="card-body text-center">
                    <img class="card-img-top img-fluid icon" src="img/instagram-icon.png">
                    <h4 class="card-title pt-2">Card title 1</h4>
                    <p class="card-text">Mauris scelerisque blandit ligula at semper. Proin ac euismod purus. Suspendisse potenti. Cras augue felis, hendrerit ultrices pharetra non, posuere vel odio. In ultrices sagittis ante, sit amet condimentum neque iaculis iaculis.</p>
                </div>
            </div>

            <div class="card col-md-4 border-0 shadow">
                <div class="card-body text-center">
                    <img class="card-img-top img-fluid icon" src="img/instagram-icon.png">
                    <h4 class="card-title pt-2">Card title 1</h4>
                    <p class="card-text">Mauris scelerisque blandit ligula at semper. Proin ac euismod purus. Suspendisse potenti. Cras augue felis, hendrerit ultrices pharetra non, posuere vel odio. In ultrices sagittis ante, sit amet condimentum neque iaculis iaculis.</p>
                </div>
            </div>

            <div class="card col-md-4 border-0 shadow">
                <div class="card-body text-center">
                    <img class="card-img-top img-fluid icon" src="img/instagram-icon.png">
                    <h4 class="card-title pt-2">Card title 1</h4>
                    <p class="card-text">Mauris scelerisque blandit ligula at semper. Proin ac euismod purus. Suspendisse potenti. Cras augue felis, hendrerit ultrices pharetra non, posuere vel odio. In ultrices sagittis ante, sit amet condimentum neque iaculis iaculis.</p>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container py-5 ">
    <div class="row">
        <div class="col-md-6">
            <h2>Lorem ipsum dolor sit amet</h2>
            <p>
                Mauris scelerisque blandit ligula at semper. Proin ac euismod purus. Suspendisse potenti. Cras augue felis, hendrerit ultrices pharetra non, posuere vel odio. In ultrices sagittis ante, sit amet condimentum neque iaculis iaculis. Suspendisse potenti. Suspendisse turpis lacus, tincidunt in ligula vitae, sollicitudin ornare massa.
        </div>

        <!-- Carousel -->
        <div class="col-md-6">
            <div id="carouselExampleControls" class="shadow-lg w-75 m-auto carousel slide carousel" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="img/food-1.jpg" class="d-block w-100">
                    </div>
                    <div class="carousel-item">
                        <img src="img/food-2.jpg" class="d-block w-100">
                    </div>
                    <div class="carousel-item">
                        <img src="img/food-3.jpg" class="d-block w-100">
                    </div>
                </div>

                <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
</div>

<%@ include file="core/footer.jsp" %>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
