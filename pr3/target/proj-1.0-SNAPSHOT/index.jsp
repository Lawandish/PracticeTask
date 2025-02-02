<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<div id="header">
    <%@include file="./WEB-INF/jspf/header.jspf"%>
</div>

<form action="hello-servlet" method="get">
    Name:<input type="text" name="username"/><br/><br/>
    Password:<input type="password" name="userpass"/><br/><br/>

    <input type="submit" value="login"/>

</form>
</html>