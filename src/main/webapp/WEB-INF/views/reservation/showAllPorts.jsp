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

        <form:form method="post" modelAttribute="port" action="/PortBooking_war_exploded/reservation/showFilterPorts/${userId}">
        <form:select path="lake">
            <form:option value="-" label="--Filter By--"/>
            <form:options items="${filterByLakes}" />
            <input type="submit" value="Filter"/>
        </form:select>
        </form:form>
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
        <tr>
            <td>${port.portName}</td>
            <td>${port.lake}</td>
            <td>${port.description}</td>
            <td>${port.price}</td>
            <td>${port.portOwner.fullName}</td>

            <td>
                <form:input path="portReservation" value="${port.id}" type="hidden"/>
                <input type="submit" value="Make Reservation"/>

            </td>
        </tr>
    </c:forEach>

    </form:form>
</table>
