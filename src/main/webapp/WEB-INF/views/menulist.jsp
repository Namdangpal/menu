<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Form</title>
</head>
<body> 
<%@ include file="top.jsp" %>
<!-- <button class="btn btn-primary" onclick="location.href='/insert'">등록</button>   -->
<div class="container">
<div>
<h2> 메뉴관리 </h2>
</div> 
<div style="float:right"> 
<button type="submit" class="btn btn-primary">작성</button>
</div>
    <table class="table table-hover" >  
    	<tr class="alert alert-info">
    		<th>번호</th> 
    		<th>메뉴명</th>
    		<th>메뉴유형 / 메뉴코드</th> 
    		<th>페이지경로</th> 
    		<th>서비스유무</th>
    		<th>기능</th>
    	</tr>
    	<c:forEach var="board" items="${MenuList}">
    	<tr style="cursor:hand">
    		<td>${board.menuid}</td> 
    		<td><c:forEach var="item" varStatus="i" begin="1" end="${board.menudepth}" step="1"> &nbsp;&nbsp;&nbsp;&nbsp;
    		    </c:forEach>${board.menuname}</td>
    		<td>${board.menutype} / ${board.menucode}</td>	
    		<td>${board.menuurl}</td>	
    		<td>${board.menuuse}</td>
    		<td>[등록][하위메뉴추가][삭제]</td>
    	</tr>      	   
        </c:forEach> 
    </table> 
</div>
<%@ include file="bootstrap.jsp" %>
</body>
</html> 