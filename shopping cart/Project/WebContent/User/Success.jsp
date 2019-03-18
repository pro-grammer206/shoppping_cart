<%@page import="Dacl.UserInfoValidation"%>
<%@ page language="java" import="Dacl.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <jsp:include page="Header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Success</title>
</head>
<body>
<c:out value="Registration is successful"/>
<a href="Login.jsp">Go to Login page</a>

</body>
</html>