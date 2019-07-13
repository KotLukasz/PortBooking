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
        <th>Booking price for one Space</th>
        <th>Choose Space to Reserve</th>
        <th>Date</th>
        <th>Action</th>
    </tr>
    <tr class="map">
        <td id="portName">${port.portName}</td>
        <td>${port.price} PLN</td>
        <td id="markerPositionLat" hidden>${port.markerPositionLat}</td>
        <td id="markerPositionLng" hidden>${port.markerPositionLng}</td>
        <td>
            <form:form method="post" modelAttribute="reservation">
            <form:select path="reservedSpace">
                <form:options items="${spaceLeft}"/>
            </form:select>
        </td>
        <td>
            <input path="reservedDate" value="${reservedDate}" readonly="true"/></td>
        <td>
            <input type="submit" value="Save"/>
            </form:form>
        </td>
    </tr>
</table>
</body>