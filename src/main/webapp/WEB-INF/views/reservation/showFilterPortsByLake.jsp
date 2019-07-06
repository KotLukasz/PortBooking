<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<script>
    function goBack() {
        window.history.back()
    }
</script>
<button onclick="goBack()">Go Back</button>
<table width="550x">

    <tr>
        <th>Port Name</th>
        <th>Lake</th>
        <th>Space</th>
        <th>Left Space</th>
        <th>Description</th>
        <th>Port Owner</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${filter}" var="temp">
        <tr>
            <td>${temp.portName}</td>
            <td>${temp.lake}</td>
            <td>${temp.space}</td>
            <td>${temp.spaceLeftToReserve}</td>
            <td>${temp.description}</td>
            <td>${temp.portOwner.fullName}</td>
            <td><a href="http://localhost:8080/PortBooking_war_exploded/reservation/makeReservation/${temp.id}/${user.id}">Make Reservation</a>
            </td>
        </tr>
    </c:forEach>
</table>
