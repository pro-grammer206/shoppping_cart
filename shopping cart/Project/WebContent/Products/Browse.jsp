<%@ page language="java" import="java.util.*,Dacl.Product" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product list</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/Project/w3.css">
</head>
<body>
<jsp:include page="Layout.jsp"/>
<%ArrayList<Product> pr = (ArrayList)request.getAttribute("ProductList");%>
/*<c:set var="cat" value="${request.getAtrribute('category')}"/>*/

  <h2 align="center" style="color:blue;" class="w3-wide"><b><%=request.getAttribute("category").toString().toUpperCase()%></b></h2>
<form method="post" action="/Project/selecteditems">
<%for (Product pro:pr) {%>

      
      
  <div class="w3-container w3-row-padding w3-margin-top w3-large">
   <div class="w3-card-4" style="width:50%;">
    <header class="w3-container w3-blue">
       <h5><%=pro.getName()%></h5>
    </header>
    
   
    <div class="w3-card w3-center ">
      <img src="/Project/images/<%=pro.getImage()%>" style="width:50%">
      <p><b><%=pro.getDescription()%></b></p>
      <p class="w3-large"><b>Price:<%=pro.getPrice()%></b></p>
      <input type="checkbox" name="pname" value="<%=pro.getName()%>"/>Add to cart
    </div>
   </div>
   
  </div>
<%} %>
<div class="w3-container w3-row-padding w3-margin-top w3-center">
<div class="w3-bar">
  <input type="submit" class="w3-green w3-center w3-large" name="payment" value="wishlist"/>
</div>
</div>


</form>
</body>
</html>