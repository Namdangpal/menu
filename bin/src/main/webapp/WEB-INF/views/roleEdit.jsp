<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="Head.jsp" %>

<script role="text/javascript">
  const API_MAIN_PATH ="/staff";
  function funEdit(){	  
	    
        var strUrl = ($('#roleId').val().length > 0) ? API_MAIN_PATH + "/roleUpdate": API_MAIN_PATH +"/roleRegister";        
        var json_data = JSON.stringify(funGetJson()); 
        var request = $.ajax({
	    	url : strUrl,
	        type : 'post',
	        data : json_data,
	        contentType: "application/json",
		      success: function(data) { 
		    	  funAllList();
		    	  alert("요청하신 작업이 완료되었습니다.");
		    	  //$("#frmMain").reset();
		    	  } ,
		    	  error:function(request,status,error){
		    		        //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    		  alert("[에러][관리자에게 문의하세요]\n"+"error:"+request.responseText);
		    		       } 
		       });
  }
  
  function funGetJson(){
	  var obj = new Object();
      obj.roleId = $('#roleId').val();
      obj.roleCode = $('#roleCode').val();
      obj.roleName = $('#roleName').val();
      obj.roleUse = $('#roleUse').val();
      return obj;
  }
  function funFormSet(objValue){
	  $('#roleId').val(objValue.roleId);
	  $('#roleCode').val(objValue.roleCode);
	  $('#roleName').val(objValue.roleName); 
	  $('#roleUse').val(objValue.roleUse);	  
  }
  function funGetData(id){
	         var strUrl= API_MAIN_PATH + '/roleListOne/' + id;
       var request = $.ajax({
	    	url : strUrl,
	        type : 'get',
	        data : '',
	      success: function(data) { 
	    	  funFormSet(data); 
	    	  } ,
	    	  error:function(request,status,error){
	    		  alert("[에러][관리자에게 문의하세요]\n"+"error:"+request.responseText);
  		       } 
	       });
 } 
  
  
  function funAllList(){
     var strUrl= API_MAIN_PATH + '/roleAllList';
	var request = $.ajax({
 		url : strUrl,
    	 type : 'get',
     	data : '',
   		success: function(data) { 
	   		var results  = data;
	   		var str = '';
       		$.each(results , function(i){
           		str += '<TR onclick="funGetData(' + results[i].roleId + ')" style="cursor:hand"><TD>'
           		+ results[i].roleId + '</TD><TD>' + results[i].roleCode + '</TD><TD>' + results[i].roleName 
           		+ '</TD><TD>' + ((results[i].roleUse == 1) ? '사용':'사용대기') + '</TD>'
           		+ '</TD><TD>&nbsp;</TD>';
          		 str += '</TR>';
	      });
	       funTbodyReset();
	      $("#boardList").append(str); 
	 	  } ,
	 	 error:function(request,status,error){
		        //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	 		 alert("[에러][관리자에게 문의하세요]\n"+"error:"+request.responseText);
		       } 
  	  });
} 
 function funTbodyReset(){
	 var intRow = $('#boardList tbody tr').length;
	 for(var i =0; i < intRow ; i++) 
		 	$('#boardList > tbody:last > tr:last').remove(); 
 }  
 </script>
 
<div class="container">
<div><h3>ADMIN ROLE관리</h3></div>
     <form  method="post" name="frmMain" id="frmMain">
      <input type="hidden" id="roleId" name="roleId">
      <div class="form-group">
        <label for="writer">메뉴role_CODE</label>
        <input type="text" class="form-control" id="roleCode" name="roleCode" placeholder="menurole코드를 입력하세요.영문자만 입력 [크기제한varchar(30) PK]" style="width:500px" >
      </div>
      <div class="form-group">
        <label for="writer">메뉴타입명</label>
        <input type="text" class="form-control" id="roleName" name="roleName" placeholder="menurole명을 입력하세요.[크기제한varchar(50)]"  style="width:500px" >
      </div>         
       <div class="form-group" >
        <label for=content">사용유무</label>
        <select id="roleUse" name="roleUse" class="form-control" style="width:300px">
        	<option value="">--------[사용:1,사용대기:0]----------</option>
        	<option value="1">사용</option>
        	<option value="0">사용대기</option>
        </select>
      </div> 
      <div class="form-group" >
       <button type="button" class="btn btn-primary" name="btnRegister" id="btnRegister" onClick="funEdit()" >등록</button>
       <button type="reset" class="btn btn-primary" name="btnReset" id="btnReset" >취소</button>
      </div> 
 <table class="table table-hover" id="boardList" >  
    	<thead>
	    	<tr class="alert alert-info">
	    		<th>번호</th> 
		   		<th>메뉴타입코드</th>
		   		<th>메뉴타입</th>
		   		<th>사용</th> 
		   		<th>비고</th> 
	    	</tr>
	    </thead>
    	<tbody style="cursor:pointer">
    		<c:forEach var="board" items="${RoleList}">
	    	<tr onclick="funGetData('${board.roleId}')" >
	    		<td>${board.roleId}</td> 
	    		<td>${board.roleCode}</td>
	    		<td>${board.roleName}</td>  
	    		<c:if test="${board.roleUse == 1}">  
	    		<td>사용</td> 
	    		</c:if>
	    		<c:if test="${board.roleUse == 0}">  		
	    		<td>사용대기</td> 
	    		</c:if>
	    		<td><!--  <button type="button" class="btn btn-primary"  onClick="funGetData('${board.roleId}')">수정</button> --></td>
	    	</tr>       	   
	        </c:forEach> 
        </tbody>
    </table>   
  </form>     
</div>     

<%@ include file="bootstrap.jsp" %>
</body>
</html>