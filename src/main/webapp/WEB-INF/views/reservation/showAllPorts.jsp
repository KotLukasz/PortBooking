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
<div id="mapid"></div>
<br/>
<button id="buttonGoBack">Go Back</button>
<table width="550x">
            <select id="selectLake" name="selectLake">
                <option>Show All</option>
                <c:forEach  items="${filterByLakes}" var="temp" >
                    <option value="${temp}">${temp}</option>
                </c:forEach>
            </select>
            <button id="submitFilter" value="${temp}">Filter by Lake</button>

    <tr>
        <th>Port Name</th>
        <th>Lake</th>
        <th>Description</th>
        <th>Booking Price for one space</th>
        <th>Port Owner</th>

        <th>Action</th>
            Pick a date:
            <form:form method="post" modelAttribute="reservation" action="/PortBooking_war_exploded/reservation/showAllPorts/${userId}">
            <form:errors path="reservedDate"/>
            <form:input min="${date}" path="reservedDate" value="${date}" type="date"/>
    </tr>
    <c:forEach items="${findAllPorts}" var="port">
        <tr class="map">
            <td id="portName">${port.portName}</td>
            <td id="lakeName">${port.lake}</td>
            <td>${port.description}</td>
            <td>${port.price}</td>
            <td>${port.portOwner.fullName}</td>
            <td id="markerPositionLat" hidden>${port.markerPositionLat}</td>
            <td id="markerPositionLng" hidden>${port.markerPositionLng}</td>
            <td>
                <form:input path="portReservation" value="${port.id}" type="hidden"/>
                <input type="submit" value="Make Reservation"/>

            </td>
        </tr>
    </c:forEach>

    </form:form>
</table>
