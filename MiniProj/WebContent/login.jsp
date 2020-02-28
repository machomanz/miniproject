<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link href="style.css" rel="stylesheet" type="tex/css" />
<style>
</style>
</head>
<body>
	<form action="login.do" method="post">
		아이디 : <input type="text" name="id"> <br>
		암&nbsp;&nbsp;&nbsp;호 : <input type="password" name="pw">
		<br>
		<button type="submit">로그인</button>
		<button type="button" onClick="location.href='memberjoin.jsp'">회원가입</button>
	</form>
</body>
</html>