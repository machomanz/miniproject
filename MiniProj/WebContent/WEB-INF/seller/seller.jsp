<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 화면</title>
</head>
<body>
	<button type="button" onClick="productList()">제품목록</button>
	<button type="button" onClick="location.href='productInsert.jsp'">제품등록</button>
	<button type="button" onClick="customerList()">회원목록</button>

	<script>
		function productList() {
			var productListForm = document.createElement("form");
			document.body.appendChild(productListForm);
			productListForm.setAttribute("action", "/productList.do");
			productListForm.setAttribute("method", "post");
			productListForm.submit();
		}
	
		function customerList() {
			var customerListForm = document.createElement("form");
			document.body.appendChild(customerListForm);
			customerListForm.setAttribute("action", "/customerList.do");
			customerListForm.setAttribute("method", "post");
			customerListForm.submit();
		}
	</script>
</body>
</html>