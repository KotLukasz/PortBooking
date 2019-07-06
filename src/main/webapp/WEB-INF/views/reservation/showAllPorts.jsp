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

<form:form method="post" modelAttribute="port">
    <form:select path="lake" items="${filterByLakes}"/>
    <input type="submit" value="Filter"/>
</form:form>
    <tr>
        <th>Port Name</th>
        <th>Lake</th>
        <th>Description</th>
        <th>Port Owner</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${findAllPorts}" var="temp">
        <tr>
            <td>${temp.portName}</td>
            <td>${temp.lake}</td>
            <td>${temp.description}</td>
            <td>${temp.portOwner.fullName}</td>
            <td><a href="http://localhost:8080/PortBooking_war_exploded/reservation/makeReservation/${temp.id}/${user.id}">Make Reservation</a>
            </td>
        </tr>
    </c:forEach>
</table>
