<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1"> 
     <title></title>
    <!-- 부트스트랩 -->
    <!--<link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet">-->
    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
 <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">ADMIN</a>
    </div>
      <ul class="nav navbar-nav navbar-right">      
         <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">기초데이타관리<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="/staff/roleEdit">[관리자권한관리]</a></li>
            <li><a href="/staff/groupEdit">[관리자그룹관리]</a></li>
            <li><a href="/staff/menuEdit">[메뉴관리]</a></li> 
            <li><a href="/staff/menuAclEdit">[메뉴접근권한관리]</a></li>         
            <li><a href="/staff/menuTypeEdit">[메뉴타입관리]</a></li> 
            <li class="divider"></li>
            <li><a href="/staff/staffMemberEdit">[Staff관리]</a></li>
            <li><a href="/staff/staffStateEdit">[Staff활동상태관리]</a></li>
          </ul>
        </li> 
      </ul>
    </div>
</nav>