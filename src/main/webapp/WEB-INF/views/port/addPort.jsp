<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<script>
    function goBack() {
        window.history.back()
    }
</script>
<button onclick="goBack()">Go Back</button>

<form:form method="post" modelAttribute="port">
    Port Name <form:input path="portName"/>
    <br/>
    Lake <form:input path="lake"/>
    <br/>
    Available space for booking <form:input path="space"/>
    <br/>
    Port Description <form:input path="description"/>
    <br/>
    Port Owner
    <br/>
    <input value="${owner.fullName}"/>
    <form:input path="portOwner" value="${owner.id}" type="hidden"/>
    <br/>
    <input type="submit" value="Add Port"/>
</form:form>