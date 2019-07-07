<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css"
      integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
      crossorigin=""/>
<img src="<c:url value="/resources/images/topMainImage.jpg"/> " alt="topMainImage" class="image">
<script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js"
        integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og=="
        crossorigin=""></script>
<div id="mapid"></div>
<script type="text/javascript">
    var mymap = L.map('mapid').setView([53.931837, 21.706238], 9);
    L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw', {
        maxZoom: 18,
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
            '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
            'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        id: 'mapbox.streets'
    }).addTo(mymap);

    var popup = L.popup();

    function onMapClick(e) {
        popup
            .setLatLng(e.latlng)
            .setContent("You clicked the map at " + e.latlng.toString())
            .openOn(mymap);
    }

    mymap.on('click', onMapClick);
</script>

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



