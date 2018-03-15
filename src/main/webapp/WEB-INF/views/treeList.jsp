<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Form</title>
</head>
<body> 
<div>
<h2> API 접근권한관리 </h2>
</div> 
<div class="container">
    <form action="/insertProc" method="post">
      
      <div class="form-group">
        <label for="subject">API서비스명</label>
        <input type="text" class="form-control" id="subject" name="subject" placeholder="API 서비스명을 입력하세요.">
      </div>
      <div class="form-group">
        <label for="writer">서비스경로</label>
        <input type="text" class="form-control" id="writer" name="writer" placeholder="서비스경로를 입력하세요.">
      </div>
      <div class="form-group">
        <label for="apitype">접근권한</label>
        <select id="accesstype" name="accesstype"  >
        	<option value="">--------</option> 
        	<option value="admin">관리자만</option>
        	<option value="user">사용자만</option>
        	<option value="permit">관리자또는사용자</option>
        	<option value="anyone">모두</option>
        </select>
      </div>
      <!--<div class="form-group">
        <label for="access">접근권한</label>
        <input type="text" class="form-control" id="writer" name="writer" placeholder="접근권한을 선택하세요.">
      </div>-->      
       <div class="form-group">
        <label for=content">사용유무</label>
        <select id="usechoice" name="usechoice"  >
        	<option value="">------</option>
        	<option value="Y">사용</option>
        	<option value="N">사용대기</option>
        </select>
      </div>
      <div class="form-group">
        <label for=content">내용</label>
        <textarea class="form-control" id="content" name="content" rows="3"></textarea>
      </div>
      <button type="submit" class="btn btn-primary">작성</button>
      <button type="reset" class="btn btn-primary">취소</button>
    </form>    
</div>

<button class="btn btn-primary" onclick="location.href='/insert'">API목록등록</button>  
<div class="container">
    <table class="table table-hover" > 
    	<tr>
    		<th>번호</th> 
    		<th>API서비스명</th>
    		<th>서비스경로</th>
    		<th>접근권한</th>
    		<th>서비스유무</th>
    		<th>등록일</th>
    	</tr>
    	<c:forEach var="board" items="${MenuList}">
    	<tr >
    		<td>1</td> 
    		<td>사용자로그인</td>
    		<td>adv-member.sk.kr.mybluemix.net/member/v1/login</td>
    		<td>anyone</td>
    		<td>사용중</td>
    		<td>2018-02-19</td>
    	</tr>      	   
        </c:forEach> 
    	 
    	
    </table>
    
    <div class="jb-center" >     
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