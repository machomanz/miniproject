<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<link href="css/style.css" rel="stylesheet">	
</head>
<body>
	${errorMsg }
	<div class="loginBoxWrap">
		<div class="loginBox">
		 	MUSINSA
		 	
			<form action="update.do" method="post">
				
				<span class="id"> <input type="text" name="cust_id" id="cust_id"
					class="inputV3" value="${customerList.cust_id }"readonly ="readonly">
				</span> 							
				
				<span class="name"> <input type="text" name="cust_name" id="cust_name"
					class="inputV3" value="${customerList.cust_name }">
				</span> 
				<span class="addr"> <input type="text" name="cust_addr" id="cust_addr"
					class="inputV3" value="${customerList.cust_addr}">
				</span> 
				<span class="tel"> <input type="text" name="cust_tel" id="cust_tel"
					class="inputV3" value="${customerList.cust_tel }">					
				</span> 
				<span class="submit"> <input type="submit" value="수 정">
				</span>
				
			</form>
			
		</div>			
	</div>
</body>
</html>
