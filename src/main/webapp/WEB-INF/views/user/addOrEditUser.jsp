<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script>
    function goBack() {
        window.history.back()
    }
</script>
<button onclick="goBack()">Go Back</button>
<br/>
<form:form method="post" modelAttribute="user" class="login">
    <form:errors path="firstName" class="error"/>
    <br/>
    First Name
    <br/>
    <form:input path="firstName"/>
    <br/>
    <form:errors path="lastName" class="error"/>
    <br/>
    Last Name
    <br/>
    <form:input path="lastName"/>
    <br/>
    <form:errors path="email" class="error"/>
    <br/>
    Email
    <br/>
    <form:input path="email"/>
    <br/>
    <form:errors path="password" class="error"/>
    <br/>
    Password
    <br/>
    <form:password path="password"/>
    <br/>
    <input type="submit" value="Save"/>
</form:form>