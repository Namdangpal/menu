<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>Insert Form</title> 

</head>
<body> 
<%@ include file="top.jsp" %>
<div class="container">
<div><h3>Role관리</h3></div>
<div style="float:right">
<button class="btn btn-primary" onclick="location.href='/roleEdit'">등록</button>
</div>
 
 <table class="table table-hover" id="boardList" >  
    	<thead>
	    	<tr class="alert alert-info">
	    		<th>번호</th> 
		   		<th>ROLE</th>
		   		<th>ROLE이름</th>
		   		<th>사용</th> 
		   		<th>삭제</th>
	    	</tr>
	    </thead>
    	<tbody>
    		<c:forEach var="board" items="${RoleList}">
	    	<tr onclick="funGetData('${board.roleId}')">
	    		<td>${board.roleId}</td> 
	    		<td>${board.roleCode}</td>
	    		<td>${board.roleName}</td>    		
	    		<td>${board.roleUse}</td> 
	    		<td><button class="btn btn-primary" onclick="location.href='/roleStop/${board.roleId}'">삭제</button> </td>
	    	</tr>       	   
	        </c:forEach> 
        </tbody>
    </table>     
</div>

<%@ include file="bootstrap.jsp" %>
</body>
</html>