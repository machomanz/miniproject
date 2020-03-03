<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="css/style_nav.css" rel="stylesheet">
</head>
<body>
	<nav class="nav">
		<div class="logo">
			<h4>MUSINSA</h4>
		</div>
		<ul class="nav-links">
			<li><a href="#">Home</a></li>
			<li><a href="#">About</a></li>
			<li><a href="#">Board</a></li>			
		</ul> 		
  		<div class="wrap">
  			<a href="login.jsp" class="button"> 로그인 </a>	
  		</div>
  	</nav>
  	
  	<div class="userMenu-wrapper toggleBox">
		<ul class="userMenu-list-notLogin userMenu-list clearfix">
			<li class="listItem loginBtn"><a
				href="login.jsp">로그인</a></li>
			<li class="listItem login toggle-btn btn" data-for="loginBox"
				style="display: none"><span>로그인<b class="openLogin">▼</b><b
					class="closeLogin">▲</b></span></li>
			<li class="listItem"><a href="" title="회원가입"
				onclick="window.open('signUp.jsp','','statusbar=no,scrollbars=yes,toolbar=no');"><span>회원가입</span></a>
			</li>
			
			<li class="listItem"><a href="/?m=banner&a=linkmove&uid=3499"
				class="event2018Link" style="color: #000"><span>회원 가입
						EVENT. 신규 가입 시, 15% 쿠폰 3,000원 적립금 지급 / 무신사 스탠다드 이벤트 상품 990원 구매 기회
						제공</span></a>
			</li>
		</ul>
	</div>	
  	
  		
  	</body>
</html>