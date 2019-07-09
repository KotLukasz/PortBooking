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
        <th>Booking price for one Space</th>
        <th>Choose Space to Reserve</th>
        <th>Date</th>
        <th>Action</th>
    </tr>
    <tr>
        <td>${reservation.portReservation.portName}</td>
        <td>${reservation.portReservation.price}</td>
        <td>
            <form:form method="post" modelAttribute="reservation">
            <form:select path="reservedSpace">
                <form:options items="${spaceLeft}"/>
            </form:select>

        </td>
        <td>
            <input path="reservedDate" value = "${reservation.reservedDate}" readonly="true"/></td>
        <td>
            <input type="submit" value="Save"/>
            </form:form>
        </td>

    </tr>


</table>
