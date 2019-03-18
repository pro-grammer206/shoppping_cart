<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Billing info</title>
</head>
<body>
<c:set var="arr" value="${request.getAttribute('itemlist')}"/>
<jsp:include page="Layout.jsp"/>
<div class="w3-container">
  <table class="w3-table-all">
    <thead>
      <tr class="w3-light-grey w3-hover-red">
        <th>S.no</th>
        <th>Product Name</th>
        <th>Price</th>
      </tr>
    </thead>
    <c:set var="i" value="1"/>
    <c:forEach var="it" items="${arr}">
		<tr class="w3-light-blue w3-hover-red">
		<td>hello</td>
		<td><c:out value="${it}"/></td>
		</tr>
		</c:forEach>
		</table>
</div>
</body>
</html>