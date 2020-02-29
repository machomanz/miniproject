<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품목록</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제품코드</th>
				<th>제품이름</th>
				<th>제품가격</th>
				<th>카테고리</th>
				<th>제품이미지</th>
				<th>등록한관리자아이디</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${productList}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${product.product_code}</td>
					<td>${product.product_name}</td>
					<td>${product.product_price}</td>
					<td>${product.category}</td>
					<td><img src="${product.product_img}"/></td>
					<td>${product.sell_id }</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td>번호</td>
				<td>제품코드</td>
				<td>제품이름</td>
				<td>제품가격</td>
				<td>카테고리</td>
				<td>제품이미지</td>
				<td>등록한관리자아이디</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>