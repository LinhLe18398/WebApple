<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lengoclinh
  Date: 10/10/2023
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <style>


        img {
            width: 200px;
            height: 180px;
        }

        .content {
            margin-top: 100px;
        }

        /*a {*/
        /*    margin-left: 60px;*/
        /*}*/

        .d-flex {
            margin-top: 18px;
            margin-left: 26px;
        }

        .header {
            text-align: center;
            padding-top: 10px;
            background-color: whitesmoke;
        }
        #logout{
            list-style: none;
            margin-left: 30px;
            margin-top: 2px;
        }

        footer{
            margin-top: 50px;
        }

    </style>
</head>
<body>

<div class="header" style="font-family: 'Academy Engraved LET'">
    <h2>Apple Shop</h2>

</div>


<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid" style="background-color: whitesmoke">
            <a class="navbar-brand" href="/phones" style="margin-left: 30px;" >Trang chủ</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" style="margin-left: 60px;"  aria-current="page" href="#">Iphone</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="margin-left: 60px;"  href="#">Ipad</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="margin-left: 60px;"  href="#">Macbook</a>
                    </li>

<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link disabled" style="margin-left: 60px;"  href="#" tabindex="-1" aria-disabled="true">Airpod</a>--%>
<%--                    </li>--%>
                    <li class="nav-item">
                        <a class="nav-link active" href="/phones?action=create" style="margin-left: 60px;"  aria-current="page" href="#">Add</a>
                    </li>
                </ul>
                <form class="d-flex" action="/phones" method="get">
                    <input class="form-control me-2" type="search" name="keyword" placeholder="Search" aria-label="Search">
                    <input type="hidden" name="action" value="search">
                    <button class="btn btn-outline-dark" type="submit">Search</button>
                </form>

                <li class="nav-item"  id="logout">
<%--                    <a class="nav-link active" href="/index.jsp" style="margin-left: 60px;"  aria-current="page" href="#">Log out</a>--%>
                    <button type="button"  class="btn btn-outline-dark"><a style="color: black" href="index.jsp">Log out</a></button>
                </li>

            </div>
        </div>
    </nav>
</div>

<div class="container">
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://shopdunk.com/images/uploaded/banner/banner_thang10/banner%20iphone%2014%20Pro%20Max%20T10_Banner%20PC.jpg" class="d-block w-100" alt="..." style="height: 390px">
        </div>
        <div class="carousel-item">
            <img src="https://shopdunk.com/images/uploaded/banner/banner_thang10/banner%20watch%20T10_Banner%20PC.jpg" class="d-block w-100" style="height: 390px">
        </div>
        <div class="carousel-item">
            <img src="https://shopdunk.com/images/uploaded/banner/banner_thang10/banner%20macbook%20air%20t10_Banner%20PC%20(1).jpg" class="d-block w-100" style="height: 390px">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
</div>



<main class="container" style="margin-top: 40px">
    <form action="/phones" method="get">

       <div class="row mb-2">
           <c:forEach var="phone" items="${phoneList}">

                   <div class="col-md-3 col-xs-6" style="text-align: center" >
                       <p><img src="${phone.urlImage}"></p>
                       <p>${phone.name}</p>
                       <p>${phone.color}</p>
                       <p>${phone.price}$</p>

                       <button type="submit" style="margin-bottom: 10px" class="btn btn-outline-dark"> <a href="/phones?action=delete&id=${phone.id}" style="color: gray" >Delete</a></button>

                   </div>

               </c:forEach>


       </div>
    </form>
</main>


<footer  class="bg-dark text-center text-white">
    <!-- Grid container -->
    <div class="container p-4 pb-0">
        <!-- Section: Social media -->
        <section class="mb-4">
            <!-- Facebook -->
            <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
            ><i class="fab fa-facebook-f"></i
            ></a>

            <!-- Twitter -->
            <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
            ><i class="fab fa-twitter"></i
            ></a>

            <!-- Google -->
            <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
            ><i class="fab fa-google"></i
            ></a>

            <!-- Instagram -->
            <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
            ><i class="fab fa-instagram"></i
            ></a>

            <!-- Linkedin -->
            <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
            ><i class="fab fa-linkedin-in"></i
            ></a>

            <!-- Github -->
            <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
            ><i class="fab fa-github"></i
            ></a>
        </section>
        <!-- Section: Social media -->
    </div>
    <!-- Grid container -->

    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2020 Copyright:
        <a class="text-white" href="https://mdbootstrap.com/">MDBootstrap.com</a>
    </div>
    <!-- Copyright -->
</footer>


</body>
</html>
