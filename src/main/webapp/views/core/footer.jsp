<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<!--Footer-->
<footer class="bg-light footer text-dark">

    <!--Higher part of footer-->
    <div class="container-fluid px-5">
        <div class="row py-3 justify-content-between">
            <div class="col-md-12 col-lg-8 pr-4">
                <h5>Sample heading</h5>
                <p>
                    Mauris scelerisque blandit ligula at semper. Proin ac euismod purus. Suspendisse potenti. Cras augue
                    felis, hendrerit ultrices pharetra non, posuere vel odio. In ultrices sagittis ante, sit amet
                    condimentum neque iaculis iaculis.
                </p>
            </div>
            <div class="col-6 col-lg-2">
                <h6><strong>We don't have!</strong></h6>
                <a class="fa fa-facebook-square"></a> Facebook<br>
                <a class="fa fa-twitter-square"></a> Twitter<br>
                <a class="fa fa-instagram"></a> Instagram<br>
            </div>
            <div class="col-6 col-lg-2">
                <h6><strong>But we have!</strong></h6>
                <a class="fa fa-envelope-square"></a> <a class="text-dark"
                                                         href="mailto:dawidgromek.1997@gmail.com">Mail</a><br>
                <a class="fa fa-github-square"></a> <a class="text-dark" href="https://github.com/DGromek"
                                                       target="_blank">Github</a><br>
                <a class="fa fa-linkedin-square"></a> <a class="text-dark" href=""
                                                         target="_blank">Linked in</a><br>
            </div>
        </div>
    </div>

    <!--Lower part of footer-->
    <div class="py-2 container-fluid text-center lower-footer">
        <div class="row">
            <div class="col">
                Made by Dawid Gromek <br>
                &copy; All rights reserved. Or something like that.
            </div>
        </div>
    </div>
</footer>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/additional-methods.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script>
    $(function () {
        const token = $("meta[name='_csrf']").attr("content");
        const header = $("meta[name='_csrf_header']").attr("content");
        $(document).ajaxSend(function(e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    });
</script>
</body>
</html>
