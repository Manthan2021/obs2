<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="form">



<span href="#" class="button" id="toggle-login">User Login</span>



<div id="login">
<div id="triangle"></div>
<h1>User Log in</h1>
<form:form id="eloginform" action="loginUser" method="post" modelAttribute="euser">
<input type="text" placeholder="Email" name="email"/>
<input type="password" placeholder="Password" name="password" />
<input type="submit" value="Log in" />
</form:form>
</div>

</div>
<div style="color: red">${error}</div>


</body>
</html>