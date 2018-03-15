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
<div><h3>Role관리및 그룹관리</h3></div>
      <div class="form-group">
        <label for="subject">ROLE</label>
        <select id="apiRole" name="apiRole"  >
        	<option value="">--------</option> 
        	<option value="ADMIN">ADMIN</option>
        	<option value="CS">CS</option>
        	<option value="MARKETING">MARKETING</option>
        	<option value="SALES">SALES</option>
        	<option value="SERVICE">SERVICE</option>
        	<option value="IT">IT</option>
        </select>
      </div>
      <div class="form-group">
        <label for="writer">GROUP_CODE</label>
        <input type="text" class="form-control" id="apiPath" name="apiPath" placeholder="그룹코드를 입력하세요.">
      </div>
      <div class="form-group">
        <label for="writer">GROUP_NAME</label>
        <input type="text" class="form-control" id="apiPath" name="apiCode" placeholder="그룹명을 입력하세요.">
      </div>  
     <div class="form-group">
        <label for="writer">Description</label>
       <textarea class="form-control" id="content" name="content" rows="3"></textarea>
      </div>    
       <div class="form-group">
        <label for=content">사용유무</label>
        <select id="apiUse" name="apiUse"  >
        	<option value="">------</option>
        	<option value="Y">사용</option>
        	<option value="N">사용대기</option>
        </select>
      </div> 
      <div class="form-group" style="float:right">
       <button type="submit" class="btn btn-primary">등록</button>
       <button type="reset" class="btn btn-primary">취소</button>
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
   		<td> </td> 
   	</tr>
   	<tr>
   		<td>2</td> 
   		<td>ADMIN</td>
   		<td>SK</td> 
   		<td>AIA Vitality Potal 운영 총괄_SK</td>
   		<td> </td> 
   	</tr>    	
   	<tr>
   		<td>3</td> 
   		<td>CS</td>
   		<td>상담그룹1</td> 
   		<td>모바일 1:1문의 상담</td>
   		<td> </td> 
   	</tr>
   	<tr>
   		<td>4</td> 
   		<td>CS</td>
   		<td>상담그룹2</td> 
   		<td>기타 채널 문의 상담(모바일 1:1문의 제외)</td>
   		<td> </td> 
   	</tr>
   	<tr>
   		<td>5</td> 
   		<td>CS</td>
   		<td>CS관리자그룹</td> 
   		<td>모바일 1:1문의 상담 실장</td>
   		<td> </td> 
   	</tr>
   	<tr>
   		<td>6</td> 
   		<td>MARKETING</td>
   		<td>AIA</td> 
   		<td>온라인 제휴 및 이벤트 기획/운영 AIA 실무 그룹</td>
   		<td> </td> 
   	</tr>
   	<tr>
   		<td>7</td> 
   		<td>MARKETING</td>
   		<td>SK</td> 
   		<td>온라인 제휴 및 이벤트 기획/운영 SK 실무 그룹</td>
   		<td> </td> 
   	</tr>
   	<tr>
   		<td>8</td> 
   		<td>MARKETING</td>
   		<td>BP기획사1</td> 
   		<td>모바일 1:1문의 상담 실장</td>
   		<td> </td> 
   	</tr>
   	<tr>
   		<td>9</td> 
   		<td>MARKETING</td>
   		<td>BP기획사2</td> 
   		<td>모바일 1:1문의 상담 실장</td>
   		<td> </td> 
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
    

<%@ include file="bootstrap.jsp" %>
</body>
</html>