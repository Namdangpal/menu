<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="Head.jsp" %>
<script type="text/javascript">
const API_MAIN_PATH ="/staff";
const INT_BLOCK_SIZE = 10;
 function funEdit(){	  
	//alert($('#menuReg').val());
    var strUrl = ($('#staffReg').val() =="UPDATE") ? API_MAIN_PATH + "/staffMemberUpdate": API_MAIN_PATH + "/staffMemberRegister";        
    var json_data = funJsonReplace(JSON.stringify(funGetJson()));   
    if($('#hidIdCheck').val() != "false" && $('#staffReg').val() !="UPDATE") {
    	alert("아이디중복을 체크해주세요");
    	return;
    }
    var request = $.ajax({
 	url : strUrl,
     type : 'post',
     data : json_data,
     contentType: "application/json",
    success: function(data) { 
       $('div.modal').modal('hide');
       funSearch(0,10);
  	  //location.reload();
  	  alert("요청하신 작업이 완료되었습니다.");
  	  } ,
  	  error:function(request,status,error){
  		        //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
  		  alert("[에러][관리자에게 문의하세요]\n"+"error:"+request.responseText);
  		       } 
     });
    
 }
  
function funJsonReplace(objValue){	  
 return objValue.replace(/\r/g, '').replace(/\\/g, "").replace(/\n/g, '').replace('"[','[').replace(']"',']');  
}
  
function funSearch(intPage,intPageSzie){	  
	var strUrl = API_MAIN_PATH + "/staffMemberDTOSearch/" + intPage + "/" + intPageSzie;
    var json_data = funJsonReplace(JSON.stringify(funSearchJson()));  
    //alert(strUrl);
    //alert(json_data);
    var request = $.ajax({
 	url : strUrl,
    type : 'post',
    data : json_data,
    contentType: "application/json",
    success: function(data) { 
       	funTbodyReset(); 
        $("#staffList").append(funTbodySet(data));
 		funPagination(data.first,data.last,data.number,data.numberOfElements,data.size,data.totalElements,data.totalPages,INT_BLOCK_SIZE);
  	  },
  	  error:function(request,status,error){
  		        //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
  		  alert("[에러][관리자에게 문의하세요]\n"+"error:"+request.responseText);
  		       } 
     });
 }
function funGetJson(){
    var obj = new Object();
 //alert(funGetAcl());
 	var objCodeArray 	= $('#staffGroup').val().split(',');
    obj.staffSeq  		= ($('#staffSeq').val() == "")? 0 : $('#staffSeq').val();
    obj.staffId   		= $('#staffId').val();
    obj.staffName 		= $('#staffName').val(); 
    obj.staffPwd  		= ($('#staffPwd').val() =="") ? $('#hidStaffPwd').val():$('#staffPwd').val();
    obj.staffMobile 	= $('#staffMobile').val();
    obj.staffCompany	= $('#staffCompany').val();
    obj.staffPart 		= $('#staffPart').val();
    obj.staffPosition 	= $('#staffPosition').val();
    obj.staffTel 		= $('#staffTel').val();
    obj.staffEmail 		= $('#staffEmail').val();
    obj.roleCode 		= objCodeArray[0];
    obj.groupCode 		= objCodeArray[1];
    obj.staffManager 	= $('#staffManager').val();
    obj.staffEtc 		= $('#staffEtc').val();
    obj.staffAccountManager 	= $('#staffAccountManager').val();
    obj.staffState 		= ($('#staffState').val() == "")? "APPLY" : $('#staffState').val(); 
    obj.staffRegDate =  $('#staffRegDate').val();
    obj.staffLastUpdate =  $('#staffLastUpdate').val();
    return obj;
  }
  
function funSearchJson(){
    var obj = new Object();
    var objCodeArray;
 //alert(funGetAcl());
 	objCodeArray 		= $('#Group').val().split(',');
 	obj.staffCompany	= $('#Company').val();
 	obj.staffName 		= $('#Name').val();     
    obj.staffId   		= $('#Id').val(); 
    obj.roleCode 		= (objCodeArray[0] == undefined || objCodeArray[0]==null) ? "" :objCodeArray[0];
    obj.groupCode 		= (objCodeArray[1] == undefined || objCodeArray[1]==null) ? "" :objCodeArray[1];
    obj.staffState 		=  $('#State').val(); 
    obj.staffManagerName = $('#ManagerName').val();     
    return obj;
  }
  
 function funFormSet(objValue){
  //alert(objValue.staffAccountManager);  
  $('#staffSeq').val(objValue.staffSeq);
  $('#staffId').val(objValue.staffId);	 
  $('#staffName').val(objValue.staffName); 
  //$('#staffPwd').val(objValue.staffPwd); 
  $('#staffMobile').val(objValue.staffMobile); 
  $('#staffCpyName').val(objValue.staffCompany);
  $('#staffCompany').val(objValue.staffCompany);	
  $('#staffPart').val(objValue.staffPart); 
  $('#staffPosition').val(objValue.staffPosition); 
  $('#staffTel').val(objValue.staffTel); 
  $('#staffEmail').val(objValue.staffEmail);	  
  $('#staffManager').val(objValue.staffManager);
  $('#staffGroup').val(objValue.roleCode + "," + objValue.groupCode);
  $('#staffEtc').val(objValue.staffEtc);
  $('#staffAccountManager').val(objValue.staffAccountManager);
  $('#staffState').val(objValue.staffState);  
  $('#staffRegDate').val(objValue.staffRegDate);
  $('#staffLastUpdate').val(objValue.staffRegDate);  
  $('#hidStaffPwd').val(objValue.staffPwd);  
  //funSetChkAcl(); 	  
 }
 
 function funFormReSet(){
	  //alert(objValue.staffAccountManager);  
	  $('#staffSeq').val('');
	  $('#staffId').val('');	 
	  $('#staffName').val(''); 
	  //$('#staffPwd').val(objValue.staffPwd); 
	  $('#staffMobile').val(''); 
	  $('#staffCpyName').val(''); 	
	  $('#staffCompany').val('');
	  $('#staffPart').val(''); 
	  $('#staffPosition').val(''); 
	  $('#staffTel').val(''); 
	  $('#staffEmail').val('');	  
	  $('#staffManager').val('');
	  $('#staffGroup').val('');
	  $('#staffEtc').val('');
	  $('#staffAccountManager').val('0');
	  $('#staffState').val('');  
	  $('#staffRegDate').val('');
	  $('#staffLastUpdate').val('');  
	  $('#hidStaffPwd').val('');  
	  $('div.modal').modal('hide');
	  $('#staffReg').val('');	
	 }
 
function funTbodySet(data)
{ 
	var board  = data.content;
	var str = '';
	var strTemp ='';
		$.each(board , function(i){
  		str += '<tr onclick="funGetData(\''+ board[i].staffId + '\',\'VIEW\')">' 
  		+ '<td>' + board[i].staffCompany + '</td>' 
  		+ '<td>' + board[i].staffName + '</td>' 
  		+ '<td>' + board[i].staffId + '</td>' 
  		+ '<td>' + board[i].roleCode + '-' + board[i].groupCode + '</td>' 
  		+ '<td>' + board[i].staffLastUpdate + '</td>' 
  		+ '<td>' + ((board[i].staffAccountManager == 0) ? "없음" : "있음") + '</td>' 
  		+ '<td>' + board[i].staffState + '</td>'
  		+ '<td>' + board[i].staffManagerName + '</td>' 
  		+ '<td><span class="btn btn-default btn-xs" onclick="funGetData(\''+ board[i].staffId+'\',\'UPDATE\')" >수정</span></td>'
  		+ '</tr>';
		});
  		//alert(str);
  	return str;
}
  
function funGetData(id,strState){
//alert(id);
  var strUrl= API_MAIN_PATH + '/staffListOne/' + id;
     var request = $.ajax({
   	url : strUrl,
       type : 'get',
       data : '',
     success: function(data) { 	   
    	 funFormSet(data);
    	 $('#staffReg').val("UPDATE");	
    	 $('div.modal').modal();
     },
     error:function(request,status,error){
   		  alert("[에러][관리자에게 문의하세요]\n"+"error:"+request.responseText);
		       } 
      });
 }   
 function funAllList(){
    var strUrl= API_MAIN_PATH + '/menuAllList';
var request = $.ajax({
		url : strUrl,
   	 type : 'get',
    	data : '',
  		success: function(data) { 
   		var results  = data;
   		var str = '';
   		var strTemp ='';
      		$.each(results , function(i){
      			strTemp = (results[i].menuParents !=0) ? ' treegrid-parent-alfa' + results[i].menuParents : '';
          		str += '<tr '
          				+ '   class="treegrid-alfa'+ results[i].menuId 
          				 + strTemp  + '"  style="cursor:hand">' 
          		+ '<TD>' + results[i].menuName
          		+ '</TD><TD>' + results[i].menuAcl 
          		+ '</TD><TD>' + results[i].menuUrl 
          		+ '</TD><TD>' + results[i].menuType 
          		+ '</TD><TD>' + results[i].menuCode 
          		+ '</TD><TD>' + ((results[i].menuUse == 1) ? '사용':'사용대기')
          		+ '</TD><TD><span class="btn btn-default btn-xs">등록</span>'
          		+ '<span class="btn btn-default btn-xs" onclick="funGetData(\''+ results[i].menuCode 
          		+ '\') >수정</span> <span class="btn btn-default btn-xs">하위등록</span></TD>';
         		 str += '</TR>';
      });
      	  funTbodyReset(); 
      $("#tree-2").append(str);
 	  } ,
 	 error:function(request,status,error){
	        //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
 		 alert("[에러][관리자에게 문의하세요]\n"+"error:"+request.responseText);
	       } 
 	  });
} 
 
 function funIdCheck(){
	 $('#hidIdCheck').val('');
	 if($("#staffId").val().replace(' ','').length < 1){
			 alert("아이디를 입력하세요");
			 return;
	 }		  
	 var strUrl= API_MAIN_PATH + '/staffMemberExists/' + $("#staffId").val().replace(' ','');
     var request = $.ajax({
	    	url : strUrl,
	        type : 'get',
	        data : '',
	      success: function(data) {  	    	  	    
	    	  		if(data){
	    	  			alert("사용중인 아이디입니다.");
	    	  		}else{
	    	  			$('#hidIdCheck').val('false');
	    	  			alert("사용중인 가능한 아이디입니다.");
	    	  		}
	      },
	      error:function(request,status,error){
	    		  alert("[에러][관리자에게 문의하세요]\n"+"error:"+request.responseText);
		       } 
	       }); 
 }
 function funCpyName(){
	 $("#staffCompany").val($("#staffCpyName").val());
 }
 function funTbodyReset(){
	 var intRow = $('#boardList tbody tr').length;
	 for(var i =0; i < intRow ; i++) 
		 	$('#boardList > tbody:last > tr:last').remove(); 
 }
 
 function funPagination(bloFirst,bloLast,intCurrentPage,intElementCount,intPageSize,intTotalCount,intTotalPageCount,intBlockSize){
    	var nowPageGroup = Math.ceil((intCurrentPage + 1) / intBlockSize);
    	var pageGroupCount = (intTotalPageCount / intBlockSize) + (1-((intTotalPageCount / intBlockSize)%1))%1;
    	var pageCount = 0;
    	var startPage = 0;
    	var endPage = 0;
    	var strPage = "";
    	
    	if(intTotalCount > 0) {
    		pageCount = intTotalCount / intPageSize + (intTotalCount  % intPageSize  == 0 ? 0 : 1);
    		startPage = intBlockSize*(nowPageGroup-1)+1;
    		endPage = startPage + intBlockSize-1;
    		endPage = (endPage > intTotalPageCount) ? intTotalPageCount :endPage;
    	}
    	if(nowPageGroup > 1)
    		strPage += '<li class="page-item"><a class="page-link" href="#" onclick="funSearch('+  ((nowPageGroup-2) * intBlockSize)  + ',' + intPageSize + ')" >Pre</a></li>';
    	if(bloFirst == false)
    		strPage += '<li><a href="#" onclick="funSearch('+  (intCurrentPage - 1) + ',' + intPageSize  + ')" ><span class="glyphicon glyphicon-chevron-left"></span></a></li>';
        for(var i = startPage; i <= endPage; i++){
        	if(intCurrentPage+1 == i)
        		strPage += '<li class="active"><a class="page-link" href="#"  onclick="funSearch('+ (((i-1) < 0) ? 0: (i-1)) + ',' + intPageSize + ')" >'+ i + '</a></li>';
        	else
        		strPage += '<li><a class="page-link" href="#" onclick="funSearch('+ (((i-1) < 0) ? 0: (i-1)) + ',' + intPageSize + ')" >'+ i+ '</a></li>';
        }
        if(bloLast == false)
    		strPage += '<li><a href="#" onclick="funSearch('+  (intCurrentPage + 1) +',' + intPageSize + ')" ><span class="glyphicon glyphicon-chevron-right"></span></a></li>';
    	if(nowPageGroup < pageGroupCount)        
    		strPage += '<li class="page-item"><a class="page-link" href="#" onclick="funSearch('+ (nowPageGroup*pageGroupSize) + ',' + intPageSize  + ')">Next</a></li>'; 
    	$(".pagination").html(strPage);
 }
 </script>
<div class="container">
<div><h3>STAFF관리</h3></div>
<div class="form-group">  
		  <div class="form-inline">
		  	<label for="writer">소속사</label>
		    <input type="text" class="form-control" id="Company" name="saffCpyName" placeholder="" style="width:200px" >
		    <label for="writer">이름</label>
		    <input type="text" class="form-control" id="Name" name="staffUserName" placeholder="" style="width:200px"  >
		    <label for="writer">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ID</label>
		    <input type="text" class="form-control" id="Id" name="staffUserId" placeholder=""  style="width:200px" >
		  </div>		  
		  <div class="form-inline">
		        <label for="writer">Role</label>&nbsp;&nbsp;&nbsp;
		           <select id="Group" name="MemberGroup"  class="form-control"  style="width:200px">
		        	<option value="">--전 체--</option>
		        <c:forEach var="objGroup" items="${groupList}"> 
			    	 <option value="${objGroup.roleCode},${objGroup.groupCode}">[${objGroup.roleCode}] - [${objGroup.groupName}]</option>
			    </c:forEach>
			    </select>			    
			    <label for=content">상태</label>
		        <select id="State" name="State"  class="form-control" style="width:200px">
		        	<option value="">---------상태---------</option>
		        	<c:forEach var="objStaffState" items="${staffStateList}"> 
		        	<option value="${objStaffState.stateCode}">${objStaffState.stateName}</option>
		        	</c:forEach>
		        </select>
		        <label for="writer">관리자이름</label>
		         <input type="text" class="form-control" id="MangerName" name="MangerName" placeholder=""  style="width:200px" >
		         <input type="button" class="btn btn-default" value="검색" onclick="funSearch(0,10)">
		 </div>  
 </div> 
 <div class="form-group"> 
  <span class="input-group-btn"><button class="btn btn-default pull-right" data-target="#layerpop" data-toggle="modal">STAFF등록</button></span> 
 </div> 
    <div class="form-group" >
   <table class="table table-hover" id="boardList" >  
    	<thead>
	    	<tr class="alert alert-info">
	    		<th>소속사</th>
	    		<th>이름</th>
		   		<th>ID</th>		   		
		   		<th>Role/Group</th>
		   		<th>Updated</th>
		   		<th>계정승인권한</th>
		   		<th>상태</th>
		   		<th>관리자</th>
		   		<th>비고</th>
	    	</tr>
	    </thead>
    	<tbody style="cursor:pointer" id="staffList">
    		<c:forEach var="board" items="${staffList.content}">
	    	<tr onclick="funGetData('${board.staffId}','VIEW')">
	    		<td>${board.staffCompany}</td> 
		   		<td>${board.staffName}</td>
		   		<td>${board.staffId}</td>
		   		<td>${board.roleCode} - ${board.staffGroupName}</td>
		   		<td>${board.staffLastUpdate}</td>
		   		<td>${(board.staffAccountManager == 0) ? "없음" : "있음"}</td>
		   		<td>${board.staffState}</td>
		   		<td>${board.staffManagerName}</td>
		   		<td><span class="btn btn-default btn-xs" onclick="funGetData('${board.staffId}','UPDATE')" >수정</span></td>
	    	</tr>       	   
	        </c:forEach> 
        </tbody>
    </table>  
    </div> 
    <div class="form-group" >
      <ul class="pagination pull-right">
    	<c:set var="pageGroupSize" value="${pageBlockSize}" />
 		<c:set var="pageGroupCount" value="${(staffList.totalPages / pageGroupSize)+(1-((staffList.totalPages / pageGroupSize)%1))%1}" />
 		<c:if test="${staffList.totalElements > 0}">
      	<c:set var="pageCount" value="${staffList.totalElements / staffList.size + (staffList.totalElements  % staffList.size == 0 ? 0 : 1)}" />
      	<c:set var="startPage" value="${pageGroupSize*(nowPageGroup-1)+1}" />
      	<c:set var="endPage" value="${startPage + pageGroupSize-1}" />       
      	<c:if test="${endPage > staffList.totalPages}">
        	<c:set var="endPage" value="${staffList.totalPages}" />
      	</c:if> 
      <div class="jb-center" >     
         <ul class="pagination">               
	           <c:if test="${nowPageGroup > 1}">
	           		<li class="page-item"><a class="page-link" href="/staff/staffMemberDTOList/${(nowPageGroup-2)*pageGroupSize }/${staffList.size}" >Pre</a></li>
	           </c:if>
		       <c:if test="${staffList.first == false}">
		       	<li><a href="/staff/staffMemberDTOList/${staffList.number-1}/${staffList.size}" ><span class="glyphicon glyphicon-chevron-left"></span></a></li>
		       </c:if>	 
	          <c:forEach var="i" begin="${startPage}" end="${endPage}">
	          	<li <c:if test="${(staffList.number + 1) == i}"> class="active" </c:if>><a class="page-link" href="/staff/staffMemberDTOList/${i-1}/${staffList.size}">${i}</a></li>
	          </c:forEach> 
	          <c:if test="${staffList.last== false}">
	          	<li><a href="/staff/staffMemberDTOList/${staffList.number+1}/${staffList.size}"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
	          </c:if>                
	          <c:if test="${nowPageGroup < pageGroupCount}">
	          	<li class="page-item"><a class="page-link" href="/staff/staffMemberDTOList/${nowPageGroup*pageGroupSize}/${staffList.size}">Next</a></li>          
	          </c:if>
         </ul>
         </div>
    	</c:if> 
	  </ul>
    </div>     
 </div> 
<form  method="post" name="frmMain" id="frmMain">
     <input type="hidden" id="staffReg" name="staffReg"> 
     <input type="hidden" id="staffSeq" name="staffSeq"> 
     <input type="hidden" id="hidStaffPwd" name="hidStaffPwd"> 
     <input type="hidden" id="staffRegDate" name="staffRegDate"> 
     <input type="hidden" id="staffLastUpdate" name="staffLastUpdate"> 
     <input type="hidden" id="hidIdCheck" name="hidIdCheck"> 
<div class="modal fade" id="layerpop" >
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <!-- header -->
      <div class="modal-header">
        <!-- 닫기(x) 버튼 -->
        <button type="button" class="close" onClick="funFormReSet()">×</button>
        <!-- header title -->
        <h4 class="modal-title">STAFF등록</h4>
      </div>
      <!-- body -->
      <div class="modal-body">
        <div class="row">
		  <div class="col-xs-6">
		       <div class="form-group">
		        <label for="writer">이름</label>
		        <input type="text" class="form-control" id="staffName" name="staffName" placeholder="이름 입력하세요.[50자이내] VARCHAR(50)"   >
		      </div> 	
		       <div class="form-group">
		        <label for="writer">비밀번호</label>
		        <input type="text" class="form-control" id="staffPwd" name="staffPwd" placeholder="비빌번호를 입력하세요.[ 8~20자이내 영문자 대/소문자,숫자,특수문자로만 입력해주세요 ]VARCHAR(100)"   >
		      </div> 
		      <div class="form-group">
		        <label for="writer">휴대폰번호</label>
		        <input type="text" class="form-control" id="staffMobile" name="staffMobile" placeholder="휴대폰번호를 입력하세요[-없이 숫자만]. VARCHAR(20)"   >
		      </div>
		      <div class="form-group">
		        <label for=content">회사명</label>
		        <select id="staffCpyName" name="staffCpyName"  class="form-control"   onchange="funCpyName()"  >
		        	<option value="">--회사명선택--</option>
		        <c:forEach var="objCompany" items="${staffCompanyList}"> 
			    	 <option value="${objCompany}">${objCompany}</option>
			    </c:forEach>   
		        </select>
		         <input type="text" class="form-control" id="staffCompany" name="staffCompany" placeholder="회사명을 입력하세요 VARCHAR(100)"   >
		      </div> 
		       <div class="form-group">
		        <label for="writer">직책</label>
		        <input type="text" class="form-control" id="staffPosition" name="staffPosition" placeholder="직책을 입력하세요. VARCHAR(50)"   >
		      </div>  
		      <div class="form-group">
		        <label for="writer">이메일</label>
		        <input type="text" class="form-control" id="staffEmail" name="staffEmail" placeholder="이메일을 입력하세요. VARCHAR(50)"   >
		      </div>  	
		      <div class="form-group">
		        <label for="writer">담당관리자</label>&nbsp;&nbsp;&nbsp;&nbsp;
		           <select id="staffManager" name="staffManager"  class="form-control" >
		        	<option value="">--담당관리자--</option> 
		        	<c:forEach var="objAccountManager" items="${staffAccountManagerList}"> 
		        	<option value="${objAccountManager.staffId}">${objAccountManager.staffName}  [${objAccountManager.roleCode} / ${objAccountManager.staffGroupName}] [${objAccountManager.staffPart} /${objAccountManager.staffPosition}] </option>
		        	</c:forEach>
			    </select> 
		      </div> 
		      
		      <div class="form-group">
		        <label for="writer">기타</label>
		        <textarea class="form-control" rows="2" id="staffEtc" name="staffEtc"  placeholder="기타사항을 입력하세요. VARCHAR(300)"></textarea>
		      </div>     
		  </div>
		  <div class="col-xs-6">
			  
			  	<div class="form-group">
		        <label for="writer">아이디</label>
		        <div class="form-inline">
		        <input type="text" class="form-control" id="staffId" name="staffId" placeholder="아이디를 입력하세요 [ 8~20자이내 영문자 대/소문자,숫자,특수문자로만 입력해주세요 ] VARCHAR(50)"  >
		        <button type="button" class="btn btn-primary" name="btnId" id="btnId" onClick="funIdCheck()" >중복확인</button>
		        </div>
		        </div>
	         <div class="form-group">
		        <label for="writer">비밀번호확인</label>
		        <input type="text" class="form-control" id="staffPwd2" name="staffPwd2" placeholder="메뉴명을 입력하세요. VARCHAR(100)" >
		      </div> 
		      <div class="form-group">
		        <label for="writer">휴대폰인증번호</label>
		        <div class="form-inline">
		        <input type="text" class="form-control" id="staffComfirmNum" name="staffComfirmNum" placeholder="메뉴명을 입력하세요. VARCHAR(100)" >
		        <button type="button" class="btn btn-primary" name="btnId" id="btnId" onClick="funIDCheck()"  >인증번호요청</button>
		        </div>
		      </div> 
		      <div class="form-group">
		        <label for="writer">부서명</label>
		        <input type="text" class="form-control" id="staffPart" name="staffPart" placeholder="메뉴명을 입력하세요. VARCHAR(100)" >
		      </div> 
		      <div class="form-group">
		        <label for="writer">사무실전화번호</label>
		        <input type="text" class="form-control" id="staffTel" name="staffTel" placeholder="메뉴명을 입력하세요. VARCHAR(100)" >
		      </div>  
		      <div class="form-group">
		        <label for="writer">업무Role/Group</label>&nbsp;&nbsp;&nbsp;&nbsp;
		           <select id="staffGroup" name="staffGroup"  class="form-control" >
		        	<option value="">--업무[Role]-[Group]--</option>
		        <c:forEach var="objGroup" items="${groupList}"> 
			    	 <option value="${objGroup.roleCode},${objGroup.groupCode}">[${objGroup.roleCode}] - [${objGroup.groupName}]</option>
			    </c:forEach>
			    </select>
		      </div>  
		        <div class="form-group">		        
			    <label for="writer">계정승인권한</label>&nbsp;&nbsp;&nbsp;&nbsp;
			    <select id="staffAccountManager" name="staffAccountManager"  class="form-control" style="width:200px" > 
		        	<option value="0">없음</option>
		        	<option value="1">있음</option> 
		        </select>
		      </div>
			 <div class="form-group">
		        <label for=content">상태</label>
		        <select id="staffState" name="staffState"  class="form-control" style="width:200px">
		        	<option value="">---------상태---------</option>
		        	<c:forEach var="objStaffState" items="${staffStateList}"> 
		        	<option value="${objStaffState.stateCode}">${objStaffState.stateName}</option>
		        	</c:forEach>
		        </select>
		      </div> 
      	  </div>      
      </div> 
      </div>
      <!-- Footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" name="btnRegister" id="btnRegister" onClick="funEdit()" >등록</button>
        <button type="reset" class="btn btn-primary" name="btnReset" id="btnReset" >취소</button>
        <button type="button" class="btn btn-primary" name="btnModalClose" onClick="funFormReSet()">닫기</button>
      </div>
    </div>
  </div>
</div> 
</form>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<%@ include file="bootstrap.jsp" %>
</body>
</html>