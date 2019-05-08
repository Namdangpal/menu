<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<html lang="ko">
  <head>
    <meta charset="utf-8">
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
       <!-- <li><a href="#">[메뉴관리]</a></li>
        <li><a href="#">[관리자권한관리]</a></li>
        <li><a href="#">[관리자그룹관리]</a></li>        
        <li><a href="#">[API목록관리]</a></li>-->
         <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">기초데이타관리<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">[관리자권한관리]</a></li>
            <li><a href="#">[관리자그룹관리]</a></li>
            <li><a href="#">[메뉴관리]</a></li>
            <li class="divider"></li>
            <li><a href="#">[API목록관리]</a></li>
          </ul>
        </li> 
      </ul>
    </div>
</nav>
<div class="container">
<div><h3>그룹관리</h3></div>
<div style="float:right">
<button class="btn btn-primary" onclick="location.href='/roleInsert'">등록</button>
</div>  
<table class="table table-hover"  >  
   	<tr class="alert alert-info">
   		<th>번호</th> 
   		<th>ROLE</th>
   		<th>GROUP</th> 
   		<th>Description</th>
   		<th>비고</th> 
   	</tr>
   	<tr>
   		<td>1</td> 
   		<td>ADMIN</td>
   		<td>AIA</td> 
   		<td>AIA Vitality Potal 운영 총괄_AIA</td>
   		<td><button class="btn btn-primary" onclick="location.href='/MenuAccessList'">메뉴접근관리</button> </td> 
   	</tr>
   	<tr>
   		<td>2</td> 
   		<td>ADMIN</td>
   		<td>SK</td> 
   		<td>AIA Vitality Potal 운영 총괄_SK</td>
   		<td><button class="btn btn-primary" onclick="location.href='/MenuAccessList'">메뉴접근관리</button> </td> 
   	</tr>    	
   	<tr>
   		<td>3</td> 
   		<td>CS</td>
   		<td>상담그룹1</td> 
   		<td>모바일 1:1문의 상담</td>
   		<td><button class="btn btn-primary" onclick="location.href='/MenuAccessList'">메뉴접근관리</button> </td> 
   	</tr>
   	<tr>
   		<td>4</td> 
   		<td>CS</td>
   		<td>상담그룹2</td> 
   		<td>기타 채널 문의 상담(모바일 1:1문의 제외)</td>
   		<td><button class="btn btn-primary" onclick="location.href='/MenuAccessList'">메뉴접근관리</button> </td> 
   	</tr>
   	<tr>
   		<td>5</td> 
   		<td>CS</td>
   		<td>CS관리자그룹</td> 
   		<td>모바일 1:1문의 상담 실장</td>
   		<td><button class="btn btn-primary" onclick="location.href='/MenuAccessList'">메뉴접근관리</button> </td> 
   	</tr>
   	<tr>
   		<td>6</td> 
   		<td>MARKETING</td>
   		<td>AIA</td> 
   		<td>온라인 제휴 및 이벤트 기획/운영 AIA 실무 그룹</td>
   		<td><button class="btn btn-primary" onclick="location.href='/MenuAccessList'">메뉴접근관리</button> </td> 
   	</tr>
   	<tr>
   		<td>7</td> 
   		<td>MARKETING</td>
   		<td>SK</td> 
   		<td>온라인 제휴 및 이벤트 기획/운영 SK 실무 그룹</td>
   		<td><button class="btn btn-primary" onclick="location.href='/MenuAccessList'">메뉴접근관리</button> </td>  
   	</tr>
   	<tr>
   		<td>8</td> 
   		<td>MARKETING</td>
   		<td>BP기획사1</td> 
   		<td>모바일 1:1문의 상담 실장</td>
   		<td><button class="btn btn-primary" onclick="location.href='/MenuAccessList'">메뉴접근관리</button> </td> 
   	</tr>
   	<tr>
   		<td>9</td> 
   		<td>MARKETING</td>
   		<td>BP기획사2</td> 
   		<td>모바일 1:1문의 상담 실장</td>
   		<td><button class="btn btn-primary" onclick="location.href='/MenuAccessList'">메뉴접근관리</button> </td> 
   	</tr>
  </table>
  <div class="jb-center" style="float:right">
         <ul class="pagination">
           <li><a href="#;" onclick='paging_script();' > <span class="glyphicon glyphicon-chevron-left"></span></a></li>
              <li><a href="#;" onclick='paging_script(${i},${pageSize},"boardSearchVO","/board/notice/boardList");'> 1 </a></li>
              <li><a href="#;" onclick='paging_script(${i},${pageSize},"boardSearchVO","/board/notice/boardList");'> 2 </a></li>
              <li><a href="#;" onclick='paging_script(${i},${pageSize},"boardSearchVO","/board/notice/boardList");'> 3 </a></li>
              <li><a href="#;" onclick='paging_script(${i},${pageSize},"boardSearchVO","/board/notice/boardList");'> 4 </a></li>
              <li><a href="#;" onclick='paging_script(${i},${pageSize},"boardSearchVO","/board/notice/boardList");'> 5 </a></li> 
           <li><a href="#;" onclick='paging_script();'><span class="glyphicon glyphicon-chevron-right"></span></a></li>
   	 </ul>
</div>     
</div>  

    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <!--<script src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>-->
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <!--<script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>-->
    <%@ include file="bootstrap.jsp" %>
  </body>
</html>
  