<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품등록</title>
<link rel="stylesheet" href="style.css">
<style>
form {
	margin-left:40%;
}

img {
	margin-top:20px;
	margin-bottom:20px;
	width:300px;
	height:200px;
}
</style>
</head>
<body>
<%@ include file="indexLogin.jsp" %> <br>
	<form action="/upload.do" method="post">
		<input type="file" id="product_img">
		<div>
			<img id="select_img" src="">
		</div>
		<input type="submit" value="이미지 업로드">
		
		<script>
			var product_img = document.getElementById('product_img');
			var img = document.getElementById('select_img');
			product_img.onchange = function(e){
				var reader = new FileReader();
				reader.onload = function(e){
					var img_src = e.target.result;
					img.src = img_src;
				}
				reader.readAsDataURL(e.target.files[0]);
			}
		</script>
		
		
	</form>

</body>
</html>