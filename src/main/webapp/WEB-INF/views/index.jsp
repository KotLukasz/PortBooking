<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

<img src="<c:url value="/resources/images/topMainImage.jpg"/> " alt="topMainImage" class="image">
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