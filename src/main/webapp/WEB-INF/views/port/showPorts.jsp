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
    <script src="<c:url value="/resources/js/showMyPorts.js"/>"></script>
</head>
<div id="mapid"></div>
<br/>
<button id="buttonGoBack">Go Back</button>
<table width="550x" >
    <tr>
        <th>Port Name</th>
        <th>Lake</th>
        <th>Booking price for one space</th>
        <th>Description</th>
        <th>Port Owner</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${ports}" var="temp">
        <tr class="map">
            <td id="portName">${temp.portName}</td>
            <td>${temp.lake}</td>
            <td>${temp.price}</td>
            <td>${temp.description}</td>
            <td>${temp.portOwner.fullName}</td>
            <td id="markerPositionLat" hidden>${temp.markerPositionLat}</td>
            <td id="markerPositionLng" hidden>${temp.markerPositionLng}</td>
            <td><a href="http://localhost:8080/PortBooking_war_exploded/port/editPort/${temp.id}/${temp.portOwner.id}">Update</a>
                <a href="http://localhost:8080/PortBooking_war_exploded/port/deletePort/${temp.id}/${temp.portOwner.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

