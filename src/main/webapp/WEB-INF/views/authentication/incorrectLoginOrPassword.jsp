<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<script>
    function goBack() {
        window.history.back()
    }
</script>

Incorrect Login or Password
<br/>

<button onclick="goBack()">Please try again</button>