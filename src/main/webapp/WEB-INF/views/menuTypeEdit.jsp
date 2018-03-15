<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="Head.jsp" %>
<script type="text/javascript">
const API_MAIN_PATH ="/staff";
  function funEdit(){	  
        var strUrl = ($('#typeId').val().length > 0) ? API_MAIN_PATH +  "/menuTypeUpdate": API_MAIN_PATH + "/menuTypeRegister";        
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
      obj.typeId = $('#typeId').val();
      obj.typeCode = $('#typeCode').val();
      obj.typeName = $('#typeName').val();
      obj.typeUse = $('#typeUse').val();
      return obj;
  }
  function funFormSet(objValue){
	  $('#typeId').val(objValue.typeId);
	  $('#typeCode').val(objValue.typeCode);
	  $('#typeName').val(objValue.typeName); 
	  $('#typeUse').val(objValue.typeUse);	  
  }
  function funGetData(id){
	   var strUrl= API_MAIN_PATH + '/menuTypeListOne/' + id;
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
     var strUrl= API_MAIN_PATH + '/menuTypeAllList';
	var request = $.ajax({
 		url : strUrl,
    	 type : 'get',
     	data : '',
   		success: function(data) { 
	   		var results  = data;
	   		var str = '';
       		$.each(results , function(i){
           		str += '<TR onclick="funGetData(\'' + results[i].typeCode + '\')" style="cursor:hand"><TD>'
           		+ results[i].typeId + '</TD><TD>' + results[i].typeCode + '</TD><TD>' + results[i].typeName 
           		+ '</TD><TD>' + ((results[i].typeUse == 1) ? '사용':'사용대기') + '</TD>'
           		+ '</TD><TD>&nbsp;</TD>';
          		 str += '</TR>';
	      });
	       funTbodyReset();
	       //alert(str);
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
<div><h3>메뉴타입관리</h3></div>
     <form  method="post" name="frmMain" id="frmMain">
      <input type="hidden" id="typeId" name="typeId">
      <div class="form-group">
        <label for="writer">메뉴Type_CODE</label>
        <input type="text" class="form-control" id="typeCode" name="typeCode" placeholder="menuType코드를 입력하세요.영문자만 입력 [크기제한varchar(30) PK]" style="width:500px" >
      </div>
      <div class="form-group">
        <label for="writer">메뉴타입명</label>
        <input type="text" class="form-control" id="typeName" name="typeName" placeholder="menuType명을 입력하세요.[크기제한varchar(50])"  style="width:500px" >
      </div>         
       <div class="form-group" >
        <label for=content">사용유무</label>
        <select id="typeUse" name="roleUse" class="form-control" style="width:300px">
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
    		<c:forEach var="board" items="${menuTypeList}">
	    	<tr onclick="funGetData('${board.typeCode}')" >
	    		<td>${board.typeId}</td> 
	    		<td>${board.typeCode}</td>
	    		<td>${board.typeName}</td>  
	    		<c:if test="${board.typeUse == 1}">  
	    		<td>사용</td> 
	    		</c:if>
	    		<c:if test="${board.typeUse == 0}">  		
	    		<td>사용대기</td> 
	    		</c:if>
	    		<td><!--  <button type="button" class="btn btn-primary"  onClick="funGetData('${board.typeId}')">수정</button> --></td>
	    	</tr>       	   
	        </c:forEach> 
        </tbody>
    </table>   
  </form>     
</div>     

<%@ include file="bootstrap.jsp" %>
</body>
</html>