<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

User Information <br/>

First Name: ${user.firstName} <br/>
Last Name: ${user.lastName} <br/>
Email: ${user.email} <br/>
<br/>
<td>
    <a href="http://localhost:8080/PortBooking_war_exploded/user/edit/${user.id}">Edit Account</a> <br/>
    <a href="http://localhost:8080/PortBooking_war_exploded/user/delete/${user.id}">Delete Account</a> <br/>
    <a href="http://localhost:8080/PortBooking_war_exploded/port/showPorts">Show Ports</a> <br/>
    <a href="http://localhost:8080/PortBooking_war_exploded/">Log Out</a></td>
</tr>

