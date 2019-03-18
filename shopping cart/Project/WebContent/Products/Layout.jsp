<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/Project/w3.css">
<style>
body {
    background-image: url("/Project/images/coffee.jpg");
}
</style>
</head>
<body>
<header class="w3-container w3-red">
  <h1>CartZone</h1>
</header>
<div class="w3-container">

<div class="w3-bar w3-border w3-light-grey">
  <a href="/Project/Products/Home.jsp" class="w3-bar-item w3-button">Home</a>
  <form method="post" action="/Project/filter">
   <div class="w3-dropdown-hover">
    <button class="w3-button w3-blue">Browse</button>
    <div class="w3-dropdown-content w3-bar-block w3-border">
      <input type="submit" class="w3-bar-item w3-button" name="category" value="All">
      <input type="submit" class="w3-bar-item w3-button" name="category" value="laptop">
     <input type="submit" class="w3-bar-item w3-button" name="category" value="electronics">
     <input type="submit" class="w3-bar-item w3-button" name="category" value="mobile">
    </div>
  </div>
  </form>
  <a href="#" class="w3-bar-item w3-button w3-hover-blue">About</a>
  <a href="#" class="w3-bar-item w3-button w3-hover-teal">Sign out</a>
</div>

</div>

</body>
</html>