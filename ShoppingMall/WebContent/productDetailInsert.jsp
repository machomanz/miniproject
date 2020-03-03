<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품상세등록</title>
<link href="css/style_productList.css" rel="stylesheet">
</head>
<body>
	<%@ include file="indexLogin.jsp"%>
	<table border="1">
		<thead>
			<tr>
				<th>분류</th>
				<th>입력</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>제품코드</td>
				<td><input type="text" name="product_code"></td>
			</tr>
			<tr>
				<td>제품이름</td>
				<td><input type="text" name="product_name"></td>
			</tr>
			<tr>
				<td>제품가격</td>
				<td><input type="number" name="product_price"></td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td><input type="text" name="category"></td>
			</tr>
		</tbody>
	</table>

</body>
</html>