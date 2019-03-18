<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bill</title>
</head>
<body>
<%String[] items = (String[])request.getAttribute("itemlist");%>
<%double[] prices = (double[])request.getAttribute("pricelist"); %>

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
    <%int i=1; %>
    <%for(int j=0;j<items.length;j++){ %>
		<tr class="w3-blue w3-hover-red">
		<td><%=i %></td>
<%i++; %>
		<td><%=items[j]%></td>
		<td><%=prices[j]+"₹" %></td>
		</tr>
<%} %>
		<tr class ="w3-green ">
		<td colspan="2"><c:out value="TOTAL"/></td>
		 <td><%=request.getAttribute("total")+ "₹"%></td>
		<tr>
		</table>
</div>

</body>
</html>