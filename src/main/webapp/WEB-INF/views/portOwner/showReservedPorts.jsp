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
        <th>Reserved Space</th>
        <th>Price for Reservation</th>
        <th>Description</th>
        <th>Reserved by</th>
        <th>Date of Reservation</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${reservation}" var="temp">
        <tr>
            <td>${temp.portReservation.portName}</td>
            <td>${temp.portReservation.lake}</td>
            <td>${temp.reservedSpace}</td>
            <td>${temp.fullPrice}</td>
            <td>${temp.portReservation.description}</td>
            <td>${temp.userReservation.fullName}</td>
            <td>${temp.reservedDate}</td>
            <td><a href="http://localhost:8080/PortBooking_war_exploded/reservation/deleteReservation/${temp.id}/${temp.portReservation.id}">Delete Reservation</a>
        </tr>
    </c:forEach>
</table>