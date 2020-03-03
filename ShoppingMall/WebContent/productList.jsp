<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품목록</title>
<link rel="stylesheet" href="style.css">
<style>
table {
	display: table;
	table-layout: fixed;
	border-collapse: collapse;
	width: 80%;
	text-align: center;
	clear:both;
	margin:auto;
}

caption {
	display: table-caption;
	caption-side: bottom;
}

thead {
	display: table-header-group;
}

tbody {
	display: table-row-group;
}

tr {
	display: table-row;
}

th {
	display: table-cell;
	background: #333;
	border: 1px solid #333;
	color: #fff;
}

td {
	display: table-cell;
	border: 1px solid #333;
	vertical-align: middle;
	height: 50px;
}

.button{
	margin-left:45%;
	margin-top:20px;
}

.button button{
	width: 148px;
    height: 28px;
    text-align: center;
    line-height: 28px;
    border: 1px solid #000 !important;
    padding: 0 !important;
    margin-top: -5px;
    font-weight: bold;
    display: inline-block;
    position: relative;
    vertical-align: middle;
    -webkit-transform: perspective(1px) translateZ(0);
    transform: perspective(1px) translateZ(0);
    box-shadow: 0 0 1px transparent;
    -webkit-transition-property: color;
    transition-property: color;
    -webkit-transition-duration: 0.3s;
    transition-duration: 0.3s;
}
</style>
</head>
<body>
	<%@ include file="indexLogin.jsp"%>
	<br>
	<form action="/productDelete.do" method="post">
		<table border="1">
			<thead>
				<tr>
					<th>선택</th>
					<th>번호</th>
					<th>제품코드</th>
					<th>제품이름</th>
					<th>제품가격</th>
					<th>카테고리</th>
					<th>관리자아이디</th>
					<th>제품이미지</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${productList}" varStatus="status">
					<tr>
						<td><input type="checkbox" name="product_code" value="${product.product_code}"></td>
						<td>${status.count}</td>
						<td>${product.product_code}</td>
						<td>${product.product_name}</td>
						<td>${product.product_price}</td>
						<td>${product.category}</td>
						<td>${product.sell_id }</td>
						<td><img img="product_img" src="${product.product_img}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="button"><button type="submit">삭제</button></div>
	</form>
</body>
</html>