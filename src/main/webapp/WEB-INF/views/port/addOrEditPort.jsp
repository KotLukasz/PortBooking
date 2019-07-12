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
    <script src="<c:url value="/resources/js/addOrEditPort.js"/>"></script>
</head>
<body>
<div id="mapid"></div>
<br/>
<button id="buttonGoBack">Go Back</button>
<br/>
<form:form method="post" modelAttribute="port" class="login">
    Please choose position of your port on the map
    <br/>
    <form:errors path="markerPositionLat"/>
    <br/>
    <form:errors path="portName" />
    Port Name <form:input path="portName"/>
    <br/>
    <form:errors path="lake" />
    Lake <form:input path="lake"/>
    <br/>
    <form:errors path="price" />
    Booking price for one space
    <form:input path="price"/>
    <br/>
    <form:errors path="space" />
    Available space for booking
    <form:select path="space">
    <form:options items="${spaceToChoose}"/>
    </form:select>
    <br/>
    <form:errors path="description" />
    Port Description
    <br/>
     <form:textarea rows="4" cols="15" path="description"/>
    <br/>
    Port Owner
    <input value="${owner.fullName}" readonly/>
    <br/>
    <form:input path="portOwner" value="${owner.id}" type="hidden"/>
    <form:input id="markerPositionLat" path="markerPositionLat" value="" readonly="true" type="hidden"/>
    <form:input id="markerPositionLng" path="markerPositionLng" value="" readonly="true" type="hidden"/>
    <input type="submit" value="Save"/>
</form:form>
</body>

<style>
    #mapid {
        display: inline-block;
        width: 600px;
        height: 450px;
        position: relative;
        outline: none;
    }
</style>