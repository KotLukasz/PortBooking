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
<form:form class="login" method="post" modelAttribute="viewMode" >
    Email
    <br/>
    <form:input path="email" placeholder="Your email.."/>
    <br/>
    Password
    <br/> <form:password path="password" placeholder="Your password.."/>
    <br/>
    <input type="submit" value = "Login"/>
</form:form>