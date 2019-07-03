<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<script>
    function goBack() {
        window.history.back()
    }
</script>
<button onclick="goBack()">Go Back</button>

<form:form method="post" modelAttribute="viewMode">
    Email: <form:input path="email"/>
    <br/>
    Password: <form:password path="password"/>
    <br/>
    <input type = "submit" value = "Login"/>
</form:form>
