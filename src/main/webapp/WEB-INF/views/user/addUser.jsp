<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<script>
    function goBack() {
        window.history.back()
    }
</script>
<button onclick="goBack()">Go Back</button>

<form:form method="post" modelAttribute="user">
    <form:errors path="firstName" />
    First Name <form:input path="firstName"/>
    <br/>
    <form:errors path="lastName" />
    Last Name <form:input path="lastName"/>
    <br/>
    <form:errors path="email" />
    Email <form:input path="email"/>
    <br/>
    <form:errors path="password" />
    Password <form:password path="password"/>
    <br/>
    <input type="submit" value="Add User"/>
</form:form>