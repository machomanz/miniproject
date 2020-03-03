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
			<form action="login.do" method="post">
				<span class="id"> <input type="text" name="cust_id" id="cust_id"
					class="inputV3" value placeholder="아이디를 입력해 주세요.">
				</span> <span class="pw"> <input type="password" name="cust_pw" id="cust_pw"
					class="inputV3" value placeholder="비밀번호를 입력해 주세요.">
				</span> <span class="submit"> <input type="submit" value="로그인">
				</span>
			</form>
		</div>

		<ul class="loginMenu">
			<li class=join><a href="signUp.jsp" title="회원가입" id="member-join">회원
					가입</a></li>
			<span class="var"></span>
			<li class="idsearch"><a href="#" title="아이디찾기">아이디 찾기</a></li>
			<span class="var"></span>
			<li class="pwsearch"><a href="#" title="비밀번호찾기">비밀번호 찾기</a></li>
		</ul>
	</div>
</body>
</html>
