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
        <th>Description</th>
        <th>Reserved by</th>
    </tr>
    <c:forEach items="${reservation}" var="temp">
        <tr>
            <td>${temp.portReservation.portName}</td>
            <td>${temp.portReservation.lake}</td>
            <td>${temp.reservedSpace}</td>
            <td>${temp.portReservation.description}</td>
            <td>${temp.userReservation.fullName}</td>
        </tr>
    </c:forEach>
</table>