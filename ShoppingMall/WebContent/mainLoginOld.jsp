<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="css/style_nav.css" rel="stylesheet">
</head>
<body>
	<nav class="nav">
		<div class="logo">
			<h4>MUSINSA</h4>
		</div>
		<ul class="nav-links">
			<li><a href="#">Home</a></li>
			<li><a href="#">About</a></li>
			<li><a href="#">Board</a></li>		
		</ul>
		<c:forEach items="${customerList}" var="customer" varStatus="stat">
		<div class="wrap">
  			<a href="login.jsp" class="button">${customer.cust_name}</a>	
  		</div>		
  		</c:forEach>			
  	</nav>
  	
  
	
	<c:url var="dic" value="https://dic.daum.net/search.do" scope="application">
		<c:param name="q" value="당"></c:param>
	</c:url>
	<c:import url="${dic }"></c:import>
  		
  	
  	
  		
</body>
</html>