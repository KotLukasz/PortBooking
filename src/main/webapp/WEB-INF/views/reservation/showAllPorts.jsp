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
    <script src="<c:url value="/resources/js/showAllPorts.js"/>"></script>
</head>
<body>
<div id="mapid"></div>
<br/>
<button id="buttonGoBack">Go Back</button>
<select id="selectLake" name="selectLake">
    <option>Show All</option>
    <c:forEach items="${filterByLakes}" var="temp">
        <option>${temp}</option>
    </c:forEach>
</select>
<button id="submitFilter">Filter by Lake</button>
<br/>
<table class="tableClass">
    Pick a date:
    <input id="reservedDate" type="date" min="${date}" value="${date}"/>
    <tr>
        <th>Port Name</th>
        <th>Lake</th>
        <th>Overall Space</th>
        <th>Description</th>
        <th>Booking Price for one space</th>
        <th>Port Owner</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${findAllPorts}" var="temp">
        <tr class="map">
            <td id="portName">${temp.portName}</td>
            <td id="lakeName">${temp.lake}</td>
            <td>${temp.space}</td>
            <td>${temp.description}</td>
            <td>${temp.price} PLN</td>
            <td>${temp.portOwner.fullName}</td>
            <td id="markerPositionLat" hidden>${temp.markerPositionLat}</td>
            <td id="markerPositionLng" hidden>${temp.markerPositionLng}</td>
            <td>
                <a class="reservationHref" href="/PortBooking_war_exploded/reservation/makeReservation/${temp.id}/${userId}/">Make Reservation </a>
            </td>
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

</style>