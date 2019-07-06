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
        <th>Space Left</th>
        <th>Choose Space to Reserve</th>
        <th>Date</th>
        <th>Action</th>
    </tr>
    <tr>
        <td>${port.portName}</td>
        <td>
            ${port.spaceLeftToReserve}
        </td>
        <td>
            <form:form method="post" modelAttribute="reservation">
            <form:select path="reservedSpace">
                <form:options items="${spaceLeft}"/>
            </form:select>
        </td>
        <td>
        <form:errors path="reservedDate"/>
         <form:input path="reservedDate" value = "${date}" readonly="true"/></td>
        <td>
            <input type="submit" value="Save"/>
        </td>
        </form:form>
    </tr>


</table>
