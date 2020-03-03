<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>멤 버 목 록</h1>
	<table border="1">
		<thead>
			<tr>				
				<th>아이디</th>			
				<th>이름</th>
				<th>주소</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>			
			<c:forEach items="${customerList}" var="customer" varStatus="stat">
				<tr>					
					<td>${customer.cust_id }</td>				
					<td>${customer.cust_name }</td>
					<td>${customer.cust_addr}</td>
					<td>${customer.cust_tel}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>