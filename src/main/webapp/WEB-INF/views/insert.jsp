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
<script type="text/javascript">
  function insert_action(){
   var mForm = document.insert; // form의 값을 가져오기 위함
   var obj = new Object(); // JSON형식으로 변환 할 오브젝트
   obj.user_id = mForm.user_id.value; // form의 값을 오브젝트에 저장
   obj.user_password = mForm.user_password.value;    
   var json_data = JSON.stringify(obj); // form의 값을 넣은 오브젝트를 JSON형식으로 변환
    
   var request = $.ajax({
    url:"값을 전송할 URL",
    type:"POST",
    data:json_data, // {“user_id”:”입력값”, “user_password”:”입력값”} 형식으로 전달 됨
    dataType:"json"
   });
   request.done(function(data){ // 전송 후, 결과 값 받아오는 부분
    if (data != null){
     if (data.error == 2) { // 임의 값 JSON 형식의 {“error”:2} 값을 서버에서 전달
                                                                         // data 오브젝트에 error의 값이 2일 때의 이벤트 처리
      alert("이미 등록되어 있는 아이디 입니다.");
     } else if (data.submit == true) {
      alert("등록 완료! 로그인 하시기 바랍니다.");
     }
    }
   });
   request.fail(function(jqXHR, textStatus){ // 에러 발생
    alert("등록 오류 발생!");
   });
  }
 
  function funTest(){
	   /* var obj = new Object();
        obj.id = 'id';
        obj.password = '#pw';
        obj.idStore = 'on'; 
        var jsonData = JSON.stringify(obj); 
        alert(jsonData);
        */
        var strUrl = ($('#apiId').val().length > 0) ? "/apiUpdate":"/apiRegister"; 
        var insertData = $('[name=frmMain]').serialize(); //commentInsertForm의 내용을 가져옴
	    alert(insertData);
        var request = $.ajax({
	    	url : strUrl,
	        type : 'post',
	        data : insertData
	       });
	       request.done(function(data){ // 전송 후, 결과 값 받아오는 부분	    	   
	        if (data != null){
	         if (data.error == 2) { // 임의 값 JSON 형식의 {“error”:2} 값을 서버에서 전달
	                                                                             // data 오브젝트에 error의 값이 2일 때의 이벤트 처리
	          alert("이미 등록되어 있는 아이디 입니다.");
	         } else {
	        	 funTrTest();
	          
	          //document.location.href='/insert';
	         }
	        }
	       });
	       request.fail(function(jqXHR, textStatus){ // 에러 발생
	        alert("등록 오류 발생!");
	       });
  }
  
  function funFormSet(objValue){
	  $('#apiId').val(objValue.apiId);
	  $('#apiName').val(objValue.apiName);
	  $('#apiPath').val(objValue.apiPath);
	  $('#apiRole').val(objValue.apiRole);
	  $('#apiUse').val(objValue.apiUse);
	  $('#apiDesc').val(objValue.apiDesc);	 
	  
  }
  function funGetData(id){
	         var strUrl= '/apiListOne/' + id;
       var request = $.ajax({
	    	url : strUrl,
	        type : 'get',
	        data : '',
	      success: function(data) { 
	    	  funFormSet(data); 
	    	  } ,
	    	  error:function(data){
	            } 
	       });
 } 
  
  
  function funTrTest(){
      var strUrl= '/apiAllList';
var request = $.ajax({
 	url : strUrl,
     type : 'get',
     data : '',
   success: function(data) { 
	   var results  = data;
	   var str = '';
       $.each(results , function(i){
           str += '<TR onclick="funGetData(' + results[i].apiId + ')" style="cursor:hand"><TD>' + results[i].apiId + '</TD><TD>' + results[i].apiName + '</TD><TD>' + results[i].apiPath + '</TD><TD>' + results[i].apiRole + '</TD><TD>' + results[i].apiUse + '</TD>';
           str += '</TR>';
      });
       funTbodyReset();
      $("#boardList").append(str); 
 	  } ,
 	  error:function(data){
         } 
    });
} 
 function funTbodyReset(){
	 var intRow = $('#boardList tbody tr').length;
	 for(var i =0; i < intRow ; i++) 
		 	$('#boardList > tbody:last > tr:last').remove(); 
 }
 function funSearch(){
	 if($("#txtSearch").val().length > 0){
		  var strUrl= '/apiSearchList/' + $("#txtSearch").val() ;
		  var request = $.ajax({
		   	   url : strUrl,
		       type : 'get',
		       data : '',
		     success: function(data) { 
		  	   var results  = data;
		  	   var str = '';
		         $.each(results , function(i){
		             str += '<TR onclick="funGetData(' + results[i].apiId + ')" style="cursor:hand"><TD>' + results[i].apiId + '</TD><TD>' + results[i].apiName + '</TD><TD>' + results[i].apiPath + '</TD><TD>' + results[i].apiRole + '</TD><TD>' + results[i].apiUse + '</TD>';
		             str += '</TR>';
		        });
		         funTbodyReset();
		        $("#boardList").append(str); 
		   	  } ,
		   	  error:function(data){
		           } 
		      });
		 
	 }
	 else{
		 funTrTest();	 
	}
 }
 
 
 </script>
<body> 
 <%@ include file="top.jsp" %>
<div class="container">
	<div>
		<h2> API서비스접근권한등록 </h2>
	</div> 
    <form  method="post" name="frmMain">
      <input type="hidden" id="apiId" name="apiId">
      <div class="form-group">
        <label for="subject">API서비스명</label>
        <input type="text" class="form-control" id="apiName" name="apiName" placeholder="API 서비스명을 입력하세요.">
      </div>
      <div class="form-group">
        <label for="writer">API서비스경로</label>
        <input type="text" class="form-control" id="apiPath" name="apiPath" placeholder="서비스경로를 입력하세요.">
      </div>
      <div class="form-group">
        <label for="apitype">접근권한</label>
        <select id="apiRole" name="apiRole"  >
        	<option value="">--------</option> 
        	<option value="ADMIN">관리자만</option>
        	<option value="USER">사용자만</option>
        	<option value="ADMIN,USER">관리자,사용자</option>
        	<option value="EVERYONE">모두</option>
        </select>
      </div>
      <!--<div class="form-group">
        <label for="access">접근권한</label>
        <input type="text" class="form-control" id="writer" name="writer" placeholder="접근권한을 선택하세요.">
      </div>-->      
       <div class="form-group">
        <label for=content">사용유무</label>
        <select id="apiUse" name="apiUse"  >
        	<option value="">------</option>
        	<option value="Y">사용</option>
        	<option value="N">사용대기</option>
        </select>
      </div>
      <div class="form-group">
        <label for=content">내용</label>
        <textarea class="form-control" id="content" name="content" rows="3"></textarea>
      </div>
      <div class="form-group" style="float:left">
       	<input type="text"  class="form-control" id="txtSearch" name="txtSearch" onkeyup="funSearch()" placeholder="API서비스명 검색하세요." >
       </div>
       <button type="button" id ="btnSerch" class="btn btn-primary" onClick="funSearch()">검색</button>
      <div class="form-group" style="float:right">
       <button type="submit" class="btn btn-primary">작성</button>
       <button type="reset" class="btn btn-primary">취소</button>
       <button type="button" class="btn btn-primary" name="btnRegister" id="btnRegister" onClick="funTest()" >jsonTest</button>
       <button type="button" class="btn btn-primary" name="btnRegister" id="btnRegister" onClick="funTrTest()" >TrTest</button>
      </div> 
    </form>    
</div> 
<div class="container">
 <table class="table table-hover" id="boardList" >  
    	<thead>
	    	<tr class="alert alert-info">
	    		<th>번호</th> 
	    		<th>API서비스명</th>
	    		<th>서비스경로</th>
	    		<th>접근권한</th>
	    		<th>서비스유무</th>
	    		<th>삭제</th>
	    	</tr>
	    </thead>
    	<tbody>
    		<c:forEach var="board" items="${ApiList}">
	    	<tr onclick="funGetData('${board.apiId}')">
	    		<td>${board.apiId}</td> 
	    		<td>${board.apiName}</td>
	    		<td>${board.apiPath}</td>    		
	    		<td>${board.apiRole}</td>
	    		<td>${board.apiUse}</td>
	    		<td><button class="btn btn-primary" onclick="location.href='/apiStop/${board.apiId}'">삭제</button> </td>
	    	</tr>       	   
	        </c:forEach> 
        </tbody>
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
<script type="text/javascript">

</script>
<%@ include file="bootstrap.jsp" %>
</body>
</html> 