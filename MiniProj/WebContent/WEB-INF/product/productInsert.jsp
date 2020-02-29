<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품등록</title>
<link rel="stylesheet" href="style.css">
<style>
	.nav_img img {
		width:400px;
		margin:20px 0;
	}
</style>
</head>
<body>
	<div class="nav">
		<form action="/productInsert.do" method="post">
			제품코드 : <input type="text" name="product_code"> <br>
			제품이름 : <input type="text" name="product_name"> <br>
			제품가격 : <input type="number" name="product_price"> <br>
			카테고리 : <input type="text" name="category"> <br>
			이미지 : <input type="file" id="product_img" name="product_img"> <br>
			<div class="nav_img">
				<img id="select_img" src=""/>
			</div>
			<script>		
				var img = document.getElementById('product_img');
				img.onchange = function(e) {
					var reader = new FileReader();
					reader.onload = function(e) {
						document.getElementById('select_img').src = e.target.result;
					}
					reader.readAsDataURL(e.target.files[0]);
				}
			</script>
				
			<button type="submit">제품등록</button>
		</form>	
	</div>
</body>
</html>