<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>회원아이디</th>
				<th>회원비밀번호</th>
				<th>회원전화번호</th>
				<th>회원주소</th>
				<th>회원이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="customer" items="${customerList}" varStatus="status">
				<tr>
					<td>#&nbsp;${status.count}</td>
					<td>${customer.cust_id}</td>
					<td>${customer.cust_pw}</td>
					<td>${customer.cust_tel}</td>
					<td>${customer.user_addr}</td>
					<td>${customer.cust_name}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td>번호</td>
				<td>회원아이디</td>
				<td>회원비밀번호</td>
				<td>회원전화번호</td>
				<td>회원주소</td>
				<td>회원이름</td>
			</tr>
		</tfoot>
	</table>

</body>
</html>