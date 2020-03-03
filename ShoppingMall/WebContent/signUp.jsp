<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<link href="css/style.css" rel="stylesheet">	
</head>
<body>
	<div class="loginBoxWrap">
		<div class="loginBox">
		 	MUSINSA
			<form action="signUp.do">
				<span class="id"> <input type="text" name="cust_id" id="cust_id"
					class="inputV3" placeholder="아이디를 입력해 주세요.">
				</span> 							
				<span class="name"> <input type="password" name="cust_pw" id="cust_pw"
					class="inputV3" placeholder="비밀번호를 입력해 주세요.">
				</span> 
				<span class="name"> <input type="text" name="cust_name" id="cust_name"
					class="inputV3" placeholder="이름을 입력해 주세요.">
				</span> 
				<span class="addr"> <input type="text" name="cust_addr" id="cust_addr"
					class="inputV3" placeholder="주소를 입력해 주세요.">
				</span> 
				<span class="tel"> <input type="text" name="cust_tel" id="cust_tel"
					class="inputV3" placeholder="전화번호를 입력해주세요.">					
				</span> 
				<span class="submit"> <input type="submit" value="회 원 가 입">
				</span>
			</form>
		</div>			
	</div>
</body>
</html>
