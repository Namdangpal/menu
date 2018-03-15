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
<h2> 그룹별 메뉴접근관리 </h2>
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
   		<td></td> 
   	</tr>
   	<tr>
   		<td colspan="8"> </td>  
   	</tr>
</table>
<div style="float:right"> 
<button type="submit" class="btn btn-primary">등록</button>
</div>
    <table class="table table-hover"  >  
    	<tr class="warning">
    		<th>번호</th> 
    		<th>메뉴명</th>
    		<th>읽기</th> 
    		<th>쓰기</th>
    		<th>수정</th>
    		<th>삭제</th>
    		<th>파일다운</th>
    	</tr>
    	<c:forEach var="board" items="${MenuList}">
    	<tr style="cursor:hand">
    		<td>${board.menuid}</td> 
    		<td><c:forEach var="item" varStatus="i" begin="1" end="${board.menudepth}" step="1"> &nbsp;&nbsp;&nbsp;&nbsp;
    		    </c:forEach>${board.menuname}</td>   	
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