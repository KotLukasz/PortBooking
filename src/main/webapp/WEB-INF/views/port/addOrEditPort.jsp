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
    <form:errors path="portName" />
    Port Name <form:input path="portName"/>
    <br/>
    <form:errors path="lake" />
    Lake <form:input path="lake"/>
    <br/>
    <br/>
    <form:errors path="price" />
    Booking price for one space
    <form:input path="price"/>
    <br/>
    <form:errors path="space" />
    Available space for booking
    <form:select path="space">
    <form:options items="${spaceToChoose}"/>
    </form:select>
    <br/>
    <form:errors path="description" />
    Port Description <form:textarea rows="4" cols="15" path="description"/>
    <br/>
    Port Owner
    <br/>
    <input value="${owner.fullName}" readonly/>
    <form:input path="portOwner" value="${owner.id}" type="hidden"/>
    <br/>
    <input type="submit" value="Save"/>
</form:form>