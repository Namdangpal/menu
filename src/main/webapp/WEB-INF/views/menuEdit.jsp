<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="Head.jsp" %>
<script type="text/javascript">
  function funEdit(){	  
	  	alert($('#menuReg').val());
        var strUrl = ($('#menuReg').val() =="UPDATE") ? "/menuUpdate":"/menuRegister";        
        var json_data = funJsonReplace(JSON.stringify(funGetJson())); 
        alert(json_data);
        document.write(json_data);
       // return;
        var request = $.ajax({
	    	url : strUrl,
	        type : 'post',
	        data : json_data,
	        contentType: "application/json",
		      success: function(data) { 
		    	  location.reload();
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
  
  function funGetAcl(){
	  var strAcl;
	  var j = 0;
	  strAcl = "[";
	    $("input[name='chkAcl']:checked").each(function(i) {
	    	if(j == 0)
	    		strAcl = strAcl +  '{ "aclCode": "' + $(this).val() + '" }';
	    	else
	    		strAcl = strAcl + ',{ "aclCode": "' + $(this).val() + '" }';	       
	        j++;
	    });	  
	    strAcl = strAcl + "]";
	    return strAcl;
  }
  
 function funSetChkAcl(){
	var splitCode = $("#menuAcl").val().split(",");	
	$('input:checkbox').each(function() { this.checked = false; });
	 for(var i in splitCode){	
		$("input[type=checkbox][value='" + splitCode[i].toLowerCase()+ "']").prop("checked",true);
	}  	
 }
  function funGetJson(){
      var obj = new Object();
	  //alert(funGetAcl());
      obj.menuId= ($('#menuId').val() == "")? 0 : $('#menuId').val();
      obj.menuType= $('#menuType').val();
      obj.menuCode = $('#menuCode').val();
      obj.menuName = $('#menuName').val();
      obj.menuUrl = $('#menuUrl').val();
      obj.menuGroup = ($('#menuGroup').val() == "")? 0:$('#menuGroup').val();
      obj.menuStep =  ($('#menuStep').val() == "")? 0:$('#menuStep').val();
      obj.menuDepth = ($('#menuDepth').val() == "")? 1:$('#menuDepth').val(); 
      obj.menuParents = ($('#menuParents').val() == "")? 0:$('#menuParents').val(); 
      obj.menuUrl = $('#menuUrl').val();
      obj.menuUse = $('#menuUse').val();
      obj.staffmenuacls = JSON.stringify(JSON.parse(funGetAcl()));          
      return obj;
  }
  
  function funFormSet(objValue){
	  $('#menuId').val(objValue.menuId);
	  $('#menuType').val(objValue.menuType);
	  $('#menuCode').val(objValue.menuCode);	 
	  $('#menuName').val(objValue.menuName); 
	  $('#menuUrl').val(objValue.menuUrl);	
	  $('#menuGroup').val(objValue.menuGroup); 
	  $('#menuStep').val(objValue.menuStep); 
	  $('#menuDepth').val(objValue.menuDepth); 
	  $('#menuParents').val(objValue.menuParents);	  
	  $('#menuUse').val(objValue.menuUse);	  
	  $('#menuAcl').val(objValue.menuAcl);	
	  funSetChkAcl(); 	  
  }
  
  function funSubInsert(id,strType){
	  var strUrl= '/menuDTOListJoinOne/' + id;
      var request = $.ajax({
	    	url : strUrl,
	        type : 'get',
	        data : '',
	      success: function(data) { 	    	  
	    	  funFormSet(data); 
	    	  $('#menuName').val(""); 	    	  
	    	  $('#menuUrl').val("");	
	    	  $('#menuReg').val(strType);	
	    	  } ,
	    	  error:function(request,status,error){
	    		  alert("[에러][관리자에게 문의하세요]\n"+"error:"+request.responseText);
 		       } 
	       }); 
} 
  function funGetData(id,strType){
	   var strUrl= '/menuDTOListJoinOne/' + id;
       var request = $.ajax({
	    	url : strUrl,
	        type : 'get',
	        data : '',
	      success: function(data) { 	    	  
	    	  funFormSet(data); 
	    	  $('#menuReg').val(strType);	
	    	  } ,
	    	  error:function(request,status,error){
	    		  alert("[에러][관리자에게 문의하세요]\n"+"error:"+request.responseText);
  		       } 
	       });
 }   
  function funAllList(){
     var strUrl= '/menuAllList';
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
function funSorting(objValue){
	var objArray = objValue.split(',');
	/* objArray.sort(function(a, b) { // 오름차순
	    return a.name < b.name ? -1 : a.name > b.name ? 1 : 0;
	}); */
 alert(objArray.sort());
}
 function funTbodyReset(){
	 var intRow = $('#tree-2 tbody tr').length;
	 for(var i =0; i < intRow ; i++) 
		 	$('#tree-2 > tbody:last > tr:last').remove(); 
 }  
 </script>
<div class="container">
<div><h3>ADMIN메뉴관리</h3></div>
     <form  method="post" name="frmMain" id="frmMain">
     <input type="hidden" id="menuReg" name="menuReg"> 
      <input type="hidden" id="menuId" name="menuId"> 
      <input type="hidden" id="menuGroup" name="menuGroup"> 
      <input type="hidden" id="menuStep" name="menuStep"> 
      <input type="hidden" id="menuDepth" name="menuDepth"> 
      <input type="hidden" id="menuParents" name="menuParents"> 
      <input type="hidden" id="menuAcl" name="menuAcl">
       
      <div class="form-group">
        <label for=content">메뉴타입</label>
        <select id="menuType" name="menuType"  class="form-control" style="width:200px">
        	<option value="">--메뉴타입--</option>
        <c:forEach var="objMenuType" items="${menuTypeList}"> 
	    	 <option value="${objMenuType.typeCode}">${objMenuType.typeName}&nbsp;&nbsp;&nbsp;&nbsp;</option>
	    </c:forEach>   
        </select>
      </div>  
      <div class="form-group">
        <label for="writer">메뉴명</label>
        <input type="text" class="form-control" id="menuName" name="menuName" placeholder="메뉴명을 입력하세요." >
      </div>          
      <div class="form-group">
        <label for="writer">메뉴_CODE</label>
        <input type="text" class="form-control" id="menuCode" name="menuCode" placeholder="[영문대문자 코드형식 [XX-XX-XX-XX] 두자리 대포영문조합 (예) 메뉴관리 (MENU MANAGER -> MM)" >
      </div>
     <div class="form-group">
        <label for="writer">메뉴URI</label>
        <input type="text" class="form-control" id="menuUrl" name="menuUrl" placeholder="메뉴경로를 입력하세요." >
      </div>
     <div class="form-group">
        <label for="writer">메뉴접근권한</label>&nbsp;&nbsp;&nbsp;&nbsp;
        <c:forEach var="objAcl" items="${menuAclList}"> 
	    	 <input type="checkbox" id="chkAcl" name="chkAcl" value="${objAcl.aclCode}" />${objAcl.aclName}&nbsp;&nbsp;
	    </c:forEach>  
      </div>   
      <div class="form-group">
        <label for=content">사용유무</label>
        <select id="menuUse" name="menupUse"  class="form-control" style="width:300px">
        	<option value="">--------[사용:1,사용대기:0]----------</option>
        	<option value="1">사용</option>
        	<option value="0">사용대기</option>
        </select>
      </div> 
      <div class="form-group" >
       <button type="button" class="btn btn-primary" name="btnRegister" id="btnRegister" onClick="funEdit()" >등록</button>
       <button type="reset" class="btn btn-primary" name="btnReset" id="btnReset" >취소</button>
      </div> 
 	<table class="table table-hover" id="tree-2" >  
    	<thead>
	    	<tr class="alert alert-info">
	    		<!-- <th>번호</th> -->
	    		<th>메뉴명</th>
	    		<th>접근권한</th> 
	    		<th>Url</th> 
	    		<th>메뉴종류</th>
		   		<th>메뉴코드</th>
		   		<th>사용</th> 
		   		<th>비고</th> 
	    	</tr>
	    </thead>
    	<tbody style="cursor:pointer" >
    	     <c:set var="j" value="0" />
    		<c:forEach var="board" items="${menuList}">
	    	<tr  class="treegrid-alfa${board.menuId}<c:if test="${board.menuParents != 0}"> treegrid-parent-alfa${board.menuParents}</c:if>" >
	    		<!--<td>${board.menuId}</td> -->
	    		<td><c:forEach var="item" varStatus="i" begin="1" end="${board.menuDepth}" step="1">
    		    </c:forEach>${board.menuName}</td>  
    		    <td>${board.menuAclName}</td> 
    		    <td>${board.menuUrl}</td>  
    		    <td>${board.menuType}</td>
	    		<td>${board.menuCode}</td>
	    		<c:if test="${board.menuUse == 1}">  
	    		<td>사용</td> 
	    		</c:if>
	    		<c:if test="${board.menuUse == 0}">  		
	    		<td>사용대기</td> 
	    		</c:if>
	    		<td>
	    			<c:if test="${board.menuDepth < 3}">
	    			<span class="btn btn-default btn-xs" onclick="funSubInsert('${board.menuCode}','INSERT')">하위등록</span>
	    			</c:if>
					<span class="btn btn-default btn-xs" onclick="funGetData('${board.menuCode}','UPDATE')" >수정</span>
					<!--<span class="btn btn-default btn-xs" onclick="funSorting('${board.menuAclName}') " >테스트</span>-->
				</td>
	    	</tr>   
	    	 <c:set var="j" value="${j+1}" />    	   
	        </c:forEach>  
        </tbody>
    </table>   
  </form>  
 </div> 
<link rel="stylesheet" href="/css/jquery.treegrid.css"> 
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
 <script src="js/jquery.treegrid.min.js"></script>
 <script src="js/jquery.cookie.js"></script>
 
       <script type="text/javascript">
            $('.tree').treegrid();
        </script>    
        <script type="text/javascript">
            var metas = document.getElementsByTagName('meta');
            var i;
            if (navigator.userAgent.match(/iPhone/i)) {
                for (i = 0; i < metas.length; i++) {
                    if (metas[i].name == "viewport") {
                        metas[i].content = "width=device-width, minimum-scale=1.0, maximum-scale=1.0";
                    }
                }
                document.addEventListener("gesturestart", gestureStart, false);
            }
            function gestureStart() {
                for (i = 0; i < metas.length; i++) {
                    if (metas[i].name == "viewport") {
                        metas[i].content = "width=device-width, minimum-scale=0.25, maximum-scale=1.6";
                    }
                }
            }</script>
 <script>
     var globalCounter = 0;
     var saveStateName = 'state-save-4';
     $("#tree-1").treegrid({initialState: 'collapsed'});
     $("#tree-2").treegrid({treeColumn: 0, initialState: 'expanded', 'saveState': true, 'saveStateName': saveStateName});
     $("#tree-3").treegrid({initialState: 'collapsed'});
     $("#tree-4").treegrid({onChange: function() {
             globalCounter++;
         }, onCollapse: function() {
             globalCounter++;
         }, onExpand: function() {
             globalCounter++;
         }});
 </script>
 <script src="js/qunit-1.12.0.js"></script>
 <script src="js/tests.js"></script>
<%@ include file="bootstrap.jsp" %>
</body>
</html>