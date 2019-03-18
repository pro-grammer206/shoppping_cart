<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
   <jsp:include page="Header.jsp"/>
<br>
<br>
<div align="center">
<form method="post" action="/Project/Login">
Enter Username: <input type="text" name="uname"><br>
Enter Password: <input type="password" name="pwd"><br>
<input type="submit" value="Login">
</form>
</div>

</body>
</html>