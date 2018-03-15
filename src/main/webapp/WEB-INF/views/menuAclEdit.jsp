<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="Head.jsp" %>

<script role="text/javascript">
  const API_MAIN_PATH ="/staff";
  function funEdit(){	  
        var strUrl = ($('#aclId').val().length > 0) ? API_MAIN_PATH + "/aclUpdate": API_MAIN_PATH + "/aclRegister";        
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
      obj.aclId = $('#aclId').val();
      obj.aclCode = $('#aclCode').val();
      obj.aclName = $('#aclName').val();
      obj.aclDesc = $('#aclDesc').val();
      obj.aclUse = $('#aclUse').val();
      return obj;
  }
  function funFormSet(objValue){
	  $('#aclId').val(objValue.aclId);
	  $('#aclCode').val(objValue.aclCode);
	  $('#aclName').val(objValue.aclName); 
	  $('#aclUse').val(objValue.aclUse);	  
  }
  function funGetData(id){
	         var strUrl= API_MAIN_PATH +  '/aclListOne/' + id;
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
     var strUrl= API_MAIN_PATH + '/aclAllList';
	var request = $.ajax({
 		url : strUrl,
    	 type : 'get',
     	data : '',
   		success: function(data) { 
	   		var results  = data;
	   		var str = '';
       		$.each(results , function(i){
           		str += '<TR onclick="funGetData(\'' + results[i].aclCode + '\')" style="cursor:hand"><TD>'
           		+ results[i].aclId + '</TD><TD>' + results[i].aclCode + '</TD><TD>' + results[i].aclName 
           		+ '</TD><TD>' + ((results[i].aclUse == 1) ? '사용':'사용대기') + '</TD>'
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
<div><h3>접근권한관리</h3></div>
     <form  method="post" name="frmMain" id="frmMain">
      <input type="hidden" id="aclId" name="aclId">
      <div class="form-group">
        <label for="writer">메뉴role_CODE</label>
        <input type="text" class="form-control" id="aclCode" name="aclCode" placeholder="acl코드를 입력하세요.영문자만 입력 [크기제한varchar(30) PK]" style="width:500px" >
      </div>
      <div class="form-group">
        <label for="writer">메뉴타입명</label>
        <input type="text" class="form-control" id="aclName" name="aclName" placeholder="acl명을 입력하세요. 크기제한varchar(50)]"  style="width:500px" >
      </div>         
       <div class="form-group" >
        <label for=content">사용유무</label>
        <select id="aclUse" name="aclUse" class="form-control" style="width:300px">
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
		   		<th>Acl코드</th>
		   		<th>Acl명</th>
		   		<th>사용</th> 
		   		<th>비고</th> 
	    	</tr>
	    </thead>
    	<tbody style="cursor:pointer">
    		<c:forEach var="board" items="${menuAclList}">
	    	<tr onclick="funGetData('${board.aclCode}')" >
	    		<td>${board.aclId}</td> 
	    		<td>${board.aclCode}</td>
	    		<td>${board.aclName}</td>  
	    		<c:if test="${board.aclUse == 1}">  
	    		<td>사용</td> 
	    		</c:if>
	    		<c:if test="${board.aclUse == 0}">  		
	    		<td>사용대기</td> 
	    		</c:if>
	    		<td><!--  <button type="button" class="btn btn-primary"  onClick="funGetData('${board.aclId}')">수정</button> --></td>
	    	</tr>       	   
	        </c:forEach> 
        </tbody>
    </table>   
  </form>     
</div>     

<%@ include file="bootstrap.jsp" %>
</body>
</html>