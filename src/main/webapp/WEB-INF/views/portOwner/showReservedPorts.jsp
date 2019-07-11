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
    <script src="<c:url value="/resources/js/showPorts.js"/>"></script>
</head>
<body>
<div id="mapid"></div>
<br/>
<button id="buttonGoBack">Go Back</button>
<table class="tableClass">
    <tr>
        <th>Port Name</th>
        <th>Lake</th>
        <th>Reserved Space</th>
        <th>Price for Reservation</th>
        <th>Description</th>
        <th>Reserved by</th>
        <th>Date of Reservation</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${reservation}" var="temp">
        <tr class="map">
            <td>${temp.portReservation.portName}</td>
            <td>${temp.portReservation.lake}</td>
            <td>${temp.reservedSpace}</td>
            <td>${temp.fullPrice} PLN</td>
            <td>${temp.portReservation.description}</td>
            <td>${temp.userReservation.fullName}</td>
            <td>${temp.reservedDate}</td>
            <td id="markerPositionLat" hidden>${temp.portReservation.markerPositionLat}</td>
            <td id="markerPositionLng" hidden>${temp.portReservation.markerPositionLng}</td>
            <td><a href="http://localhost:8080/PortBooking_war_exploded/reservation/deleteReservationPortOwner/${temp.id}/${temp.portReservation.id}">Delete Reservation</a>
        </tr>
    </c:forEach>
</table>
</body>

<style>
    .tableClass {
        border: solid 1px #DDEEEE;
        border-collapse: collapse;
        border-spacing: 0;
        font: normal 13px Arial, sans-serif;
        width: 700px;
    }

    .tableClass tr th {
        background-color: #DDEFEF;
        border: solid 1px #DDEEEE;
        color: #336B6B;
        padding: 10px;
        text-align: center;
        text-shadow: 1px 1px 1px #fff;
    }

    .tableClass tr td {
        border: solid 1px #DDEEEE;
        color: #333;
        padding: 10px;
        text-shadow: 1px 1px 1px #fff;
        text-align: center;
    }

    #mapid {
        display: inline-block;
        width: 600px;
        height: 450px;
        position: relative;
        outline: none;
    }
</style>