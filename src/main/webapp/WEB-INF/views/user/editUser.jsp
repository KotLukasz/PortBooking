<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<form:form method="post" modelAttribute="user">
    First Name <form:input path="firstName"/>
    <br/>
    Last Name <form:input path="lastName"/>
    <br/>
    Email <form:input path="email"/>
    <br/>
    Password <form:input path="password"/>
    <br/>
    <input type="submit" value="Update"/>
</form:form>