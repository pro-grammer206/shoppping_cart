<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
<jsp:include page="Header.jsp"/><br><hr>
<div align="center">
<form method="post" action="/Project/userValidation">
Enter Name:     <input type="text" name="fullname" placeholder="enter full name"><br>
Enter Email:    <input type="text" name="email" placeholder="enter valid email"><br>
Enter mobile no:<input type="text" name="mobile" placeholder="enter valid mobile"><br>
Enter Password: <input type="text" name="pass" placeholder="enter password"><br>
Confirm password:<input type="text" name="confirm_pass" placeholder="reenter password"><br>
<input type="submit" value="Register">
</form>
<c:out value="${request.getAttribute('error')}"/>
</div>


</body>
</html>