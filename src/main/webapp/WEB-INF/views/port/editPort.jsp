<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<form:form method="post" modelAttribute="port">
    Port Name <form:input path="portName"/>
    <br/>
    Lake <form:input path="lake"/>
    <br/>
    Available space for booking <form:input path="space"/>
    <br/>
    Port Description <form:input path="description"/>
    <br/>
    <input type="submit" value="Update"/>
</form:form>