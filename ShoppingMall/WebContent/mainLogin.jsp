<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="google-site-verification" content="NqB0BDAEWJTvAPCCxzrckJYnS7-xJILFU40FvSmh5S8">
<title>무신사 - 스트릿패션, 패션잡지, 멀티샵, 중고장터</title>
<link type="text/css" rel="stylesheet" charset="utf-8" href="//static.musinsa.com/mfile_outsrc/css/common/normalizer.css?v=9.21384">
<link type="text/css" rel="stylesheet" charset="utf-8" href="//static.musinsa.com/mfile_outsrc/css/common/header.css?v=9.21384">

		<div class="top-column column">
			<!--헤더 header start-->
			<div class="header clearfix">
				<div class="main-wrapper wrapper">
					<a href="/"><h1 class="title"></h1></a>
				</div>
   				<div class="userMenu-wrapper toggleBox">
	        		<ul class="userMenu-list-notLogin userMenu-list clearfix">
			    		<li class="listItem loginBtn">
			    		<c:forEach items="${customerList}" var="customer" varStatus="stat">
			    			<a href="login.jsp">${customer.cust_name}님 환영합니다.</a> 
			    		</c:forEach>   
			    		   	
			    		</li> 		
            			<li class="listItem"><a href="#" title="로그아웃"><span>로그아웃</span></a></li>
            			<li class="listItem"><a href="update.do" title="마이페이지"><span>마이페이지</span></a></li>
            			<li class="listItem"><a href="#" title="장바구니"><span>장바구니</span></a></li>
            			<li class="listItem"><span>&nbsp;&nbsp;EVENT. 신규 가입 시, 10% 할인 이벤트 진행중</span></li>
          			</ul>
	    		</div>    
			</div>
		</div>
	
</body>
</html>