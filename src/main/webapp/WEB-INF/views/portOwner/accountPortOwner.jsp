<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

Port owner Information <br/>

First Name: ${portOwner.firstName} <br/>
Last Name: ${portOwner.lastName} <br/>
Email: ${portOwner.email} <br/>
<br/>
<td>
    <a href="http://localhost:8080/PortBooking_war_exploded/portOwner/edit/${portOwner.id}">Edit Account</a> <br/>
    <a href="http://localhost:8080/PortBooking_war_exploded/portOwner/delete/${portOwner.id}">Delete Account</a> <br/>
    <a href="http://localhost:8080/PortBooking_war_exploded/portOwner/showMyPorts">Show My Ports</a> <br/>
    <a href="http://localhost:8080/PortBooking_war_exploded/portOwner/addPort">Add Port</a></td>
</tr>
