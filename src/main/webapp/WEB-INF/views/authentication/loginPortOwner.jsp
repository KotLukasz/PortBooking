<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<form:form method="post" modelAttribute="viewMode">
    Email: <form:input path="email"/>
    Password: <form:password path="password"/>
    <input type = "submit" value = "Login"/>
</form:form>