<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css"
          integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
          crossorigin=""/>
    <script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js"
            integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og=="
            crossorigin=""></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/index.js"/>"></script>
</head>
<body>
<img src="<c:url value="/resources/images/topMainImage.jpg"/> " alt="topMainImage" class="image">
<div id="mapid"></div>

<br/>
<p class="welcomeText">Welcome to the PortBooking application for Masurian Lake District</p>
<br/>
<div class="indexDiv">
    <p class="indexP">
        Users <br/>
        <button class="link"
                onclick=location.href="http://localhost:8080/PortBooking_war_exploded/authentication/loginUser">Login as
            User
        </button>
        <br/>
        <button class="link" onclick=location.href="http://localhost:8080/PortBooking_war_exploded/user/add">Create
            User
        </button>

    </p>
</div>

<div class="indexDiv">
    <p class="indexP">
        Port Owners <br/>
        <button class="link"
                onclick=location.href="http://localhost:8080/PortBooking_war_exploded/authentication/loginPortOwner">
            Login as Port Owner
        </button>
        <br/>
        <button class="link" onclick=location.href="http://localhost:8080/PortBooking_war_exploded/portOwner/add">Create
            Port Owner
        </button>
    </p>
</div>
</body>
