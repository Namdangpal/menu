<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="Head.jsp" %>

<script type="text/javascript">
const API_MAIN_PATH ="/staff";
  function funEdit(){	  
        var strUrl = ($('#groupId').val().length > 0) ? API_MAIN_PATH + "/groupUpdate": API_MAIN_PATH + "/groupRegister";        
        var json_data = JSON.stringify(funGetJson()); 
        //alert(json_data);
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
      obj.groupId = $('#groupId').val();
      obj.roleCode = $('#roleCode').val();
      obj.groupCode = $('#groupCode').val();
      obj.groupName = $('#groupName').val();
      obj.groupDesc = $('#groupDesc').val();
      obj.groupUse = $('#groupUse').val();
      return obj;
  }
  function funFormSet(objValue){
	  $('#groupId').val(objValue.groupId);
	  $('#roleCode').val(objValue.roleCode);
	  $('#groupCode').val(objValue.groupCode);
	  $('#groupName').val(objValue.groupName); 
	  $('#groupDesc').val(objValue.groupDesc);	
	  $('#groupUse').val(objValue.groupUse);	  
  }
  function funGetData(id){
	         var strUrl= API_MAIN_PATH + '/groupListOne/' + id;
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
     var strUrl= API_MAIN_PATH + '/groupAllList';
	var request = $.ajax({
 		url : strUrl,
    	 type : 'get',
     	data : '',
   		success: function(data) { 
	   		var results  = data;
	   		var str = '';
       		$.each(results , function(i){
           		str += '<TR onclick="funGetData(' + results[i].groupId + ')" style="cursor:hand"><TD>'+ results[i].groupId 
           		+ '</TD><TD>' + results[i].roleCode 
           		+ '</TD><TD>' + results[i].groupCode
           		+ '</TD><TD>' + results[i].groupName 
           		+ '</TD><TD>' + results[i].groupDesc 
           		+ '</TD><TD>' + ((results[i].groupUse == 1) ? '사용':'사용대기') + '</TD>'
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
<div><h3>ADMIN그룹관리</h3></div>
     <form  method="post" name="frmMain" id="frmMain">
      <input type="hidden" id="groupId" name="groupId">
      <div class="form-group">
        <label for="subject">ROLE</label>
        <select id="roleCode" name="roleCode"   placeholder="관리자 ROLE을 선택하세요." class="form-control" style="width:200px">
        	<option value="">--------</option> 
        	<c:forEach var="roleList" items="${RoleEdit}">
        	<option value="${roleList.roleCode}">${roleList.roleCode}</option>
        	</c:forEach> 
        </select>
      </div>
      <div class="form-group">
        <label for="writer">GROUP_CODE</label>
        <input type="text" class="form-control" id="groupCode" name="groupCode" placeholder="그룹코드를 입력하세요. 영문자만 입력 [크기제한varchar(30)  PK[ROLE + GROUP_CODE] ]" >
      </div>
      <div class="form-group">
        <label for="writer">그룹명</label>
        <input type="text" class="form-control" id="groupName" name="groupName" placeholder="그룹명을 입력하세요. [크기제한varchar(50)]" >
      </div>
     <div class="form-group">
        <label for="writer">Description</label>
       <textarea class="form-control" id="groupDesc" name="groupDesc" rows="3"  placeholder="  [크기제한varchar(300)]"></textarea>
      </div>    
       <div class="form-group">
        <label for=content">사용유무</label>
        <select id="groupUse" name="groupUse"  class="form-control" style="width:300px">
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
		   		<th>ROLE</th>
		   		<th>Group</th>
		   		<th>그룹명</th> 
		   		<th>Description</th> 
		   		<th>사용</th> 
		   		<th>비고</th> 
	    	</tr>
	    </thead>
    	<tbody style="cursor:pointer">
    		<c:forEach var="board" items="${GroupEdit}">
	    	<tr onclick="funGetData('${board.groupId}')" >
	    		<td>${board.groupId}</td> 
	    		<td>${board.roleCode}</td>
	    		<td>${board.groupCode}</td>  
	    		<td>${board.groupName}</td>  
	    		<td>${board.groupDesc}</td>
	    		<c:if test="${board.groupUse == 1}">  
	    		<td>사용</td> 
	    		</c:if>
	    		<c:if test="${board.groupUse == 0}">  		
	    		<td>사용대기</td> 
	    		</c:if>
	    		<td><span class="btn btn-default btn-xs" onclick="document.location.href='/staffMenuTypeEdit?roleCode=${board.roleCode}&groupCode=${board.groupCode}&Id=${board.groupId}'">메뉴관리</span></td>
	    	</tr>       	   
	        </c:forEach> 
        </tbody>
    </table>   
  </form>     
</div>     

<%@ include file="bootstrap.jsp" %>
</body>
</html>