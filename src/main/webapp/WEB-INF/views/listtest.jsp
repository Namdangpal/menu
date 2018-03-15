<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div><h3>관리자목록</h3></div>
<table class="table table-hover"  >  
    	<tr class="alert alert-info">
    		<th>번호</th> 
    		<th>관리자이름</th>
    		<th>관리자아이디</th> 
    		<th>권한</th>
    		<th>상태</th> 
    	</tr>
    	<tr>
    		<td>1</td> 
    		<td>홍길동</td>
    		<td>superman</td> 
    		<td>ROLE_ADMIN</td>
    		<td>INACTIVE</td> 
    	</tr>
 		<tr>
    		<td>2</td> 
    		<td>정길동</td>
    		<td>superjung</td> 
    		<td>ROLE_ADMIN_IT</td>
    		<td>INACTIVE</td> 
    	</tr>
  </table>
</div>  
<div class="container">
<div><h3>관리자별권한</h3></div>
    <table class="table table-hover"  >  
    	<tr class="success">
    		<th>번호</th> 
    		<th>메뉴명</th>
    		<th>읽기</th> 
    		<th>쓰기</th>
    		<th>수정</th>
    		<th>삭제</th>
    		<th>파일다운</th>
    	</tr>
    	<c:forEach var="board" items="${MenuList}">
    	<tr style="cursor:auto">
    		<td>${board.menuid}</td> 
    		<td>${board.menuname}</td>    	
    		<td>
    			<div class="form-check">
					<label>
						<input type="checkbox" name="checkread" checked> 
					</label>
				</div>
			</td>	
			<td>
    			<div class="form-check">
					<label>
						<input type="checkbox" name="checkwrite" checked> 
					</label>
				</div>
			</td>	
			<td>
    			<div class="form-check">
					<label>
						<input type="checkbox" name="checkupdate" checked> 
					</label>
				</div>
			</td>	
			<td>
    			<div class="form-check">
					<label>
						<input type="checkbox" name="checkdel" > 
					</label>
				</div>
			</td>	
			<td>
    			<div class="form-check">
					<label>
						<input type="checkbox" name="checkfiledown" > 
					</label>
				</div>
			</td>	
				
    	</tr>      	   
        </c:forEach> 
    </table> 
</div>
<%@ include file="bootstrap.jsp" %>
</body>
</html>