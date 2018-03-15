<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ include file="Head.jsp" %>

<script type="text/javascript">
const API_MAIN_PATH ="/staff";
  function funAclEdit(obj,Id,strMenu){ 
        var strUrl = ($('#menuReg').val() =="UPDATE") ? API_MAIN_PATH + "/groupMenuAclUpdate": API_MAIN_PATH + "/groupMenuAclRegister";        
        var json_data = funJsonReplace(JSON.stringify(funGetJson(obj,Id,strMenu))); 
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
  function funAclReg(obj){
	 var strAcl; 
	  var j = 0;
	  strAcl = "";
	    $("input[name='"+ obj+ "']:checked").each(function(i) {
	    	if(j == 0)
	    		strAcl = strAcl +  '' + $(this).val() + '';
	    	else
	    		strAcl = strAcl + ',' + $(this).val() + '';	       
	        j++;
	    });	  
	    strAcl = strAcl + "";
	  return strAcl;
 }
  function funGetJson(frm,Id,strMenu){
      var obj = new Object();
      funSetHidden(Id,strMenu);
	  //alert(funGetAcl());
      obj.menuId= ($('#menuId').val() == "")? 0 : $('#menuId').val();
      obj.roleCode= $('#roleCode').val();
      obj.groupCode= $('#groupCode').val();
      obj.menuCode = $('#menuCode').val();
      obj.menuName = $('#menuName').val();
      obj.aclJsonData =funAclReg(frm)
      //obj.aclJsonData = JSON.stringify(JSON.parse(funGetAcl()));          
      return obj;
  }
  
  function funSetHidden(Id,strMenu){
	   $('#menuId').val(Id);
       $('#menuCode').val(strMenu);
  }
 
 </script>
<div class="container">
<div><h3>ADMIN메뉴관리</h3></div>
     <form  method="post" name="frmMain" id="frmMain">
     <input type="hidden" id="menuReg" name="menuReg"> 
      <input type="hidden" id="menuId" name="menuId"> 
      <input type="hidden" id="roleCode" name="roleCode" value="${groupEdit.roleCode}"> 
      <input type="hidden" id="groupCode" name="groupCode" value="${groupEdit.groupCode}">  
      <input type="hidden" id="menuCode" name="menuCode"> 
       
      <div class="form-group">
        <!-- <label for=content">메뉴타입</label>
        <select id="menuType" name="menuType"  class="form-control" style="width:200px">
        	<option value="">--메뉴타입--</option>
        <c:forEach var="objMenuType" items="${menuTypeList}"> 
	    	 <option value="${objMenuType.typeCode}">${objMenuType.typeName}&nbsp;&nbsp;&nbsp;&nbsp;</option>
	    </c:forEach>   
        </select>-->
      </div>  
      <div class="form-group">
        <h4>
        <div><label for="writer">권한그룹</label> : [${groupEdit.roleCode}]-[${groupEdit.groupCode}]</div>
        <div><label for="writer">그룹명</label>    : ${groupEdit.groupName}</div>
        </h4>
      </div>
      <c:if test="${groupEdit.roleCode !='' }" >
      <div class="form-group" style="float:right;">
       <button type="button" class="btn btn-primary" name="btnRegister" id="btnRegister" onClick="funAllReg()" >등록</button>
       <button type="reset" class="btn btn-primary" name="btnReset" id="btnReset" >취소</button>
       <button type="button" class="btn btn-primary" name="btnGroup" id="btnGroup" onClick="document.location.href='/staff/groupEdit'" >그룹관리</button>
      </div> 
      </c:if>
 	<table class="table table-hover" id="tree-2" >  
    	<thead>
	    	<tr class="alert alert-info">
	    		<!-- <th>번호</th> -->
	    		<th>메 뉴</th>
	    		<th>메뉴코드</th>
	    		<th>권 한</th> 
	    		<th>Specific</th>
	    		<!--<th>Url</th>  
	    		<th>메뉴종류</th>
		   		<th>메뉴코드</th>
		   		<th>사용</th>--> 
		   		<th>비고</th> 
	    	</tr>
	    </thead>
	    <c:if test="${groupEdit.roleCode !='' }" >
    	<tbody style="cursor:pointer">
    	    <c:set var="j" value="0" />
    		<c:forEach var="board" items="${menuList}">
	    	<tr  class="treegrid-alfa${board.menuId}<c:if test="${board.menuParents != 0}"> treegrid-parent-alfa${board.menuParents}</c:if>" >
	    		<!--<td>${board.menuId}</td> -->
	    		<td>
	    			<c:forEach var="item" varStatus="i" begin="1" end="${board.menuDepth}" step="1">
    		    	</c:forEach>${board.menuName}</td>  
    		    	<td>${board.menuCode}</td>
    		    
    		    <td>     		       
    		       <c:set var="aclNameArray" value="${fn:split(board.menuAclName,',')}" />
    		        <c:forEach items="${board.menuAcl}" var="item" varStatus="idx"> 
					    <input type="checkbox" id="chkAcl_${board.menuId}" name="chkAcl_${board.menuId}" value="${item}" <c:forEach var="result" items="${board.aclJsonData}" varStatus="status"> 
					    		<c:if test="${item == result}">checked</c:if>
							</c:forEach>>${aclNameArray[idx.index]}
					</c:forEach> 
					<!--<c:if test="${fn:length(board.aclJsonData) > 1 }" >-->
					<!-- ${fn:length(board.aclJsonData)} -->
					<!--</c:if>-->
					<!--<c:if test="${empty board.aclJsonData}" >
    		       <c:set var="aclNameArray" value="${fn:split(board.menuAclName,',')}" />
    		        <c:forEach items="${board.menuAcl}" var="item" varStatus="idx"> 
					    <input type="checkbox" id="chkAcl_${board.menuId}" name="chkAcl_${board.menuId}" value="${item}" checked>${aclNameArray[idx.index]}
					</c:forEach> 
				  ${board.aclJsonData}  
					</c:if> -->           
    		    </td>         		    
		  
    		    <!--<td>${board.aclJsonData}</td>    		        		     
    		     <td>${board.menuType}</td>
	    		<c:if test="${board.menuUse == 1}">  
	    		<td>사용</td> 
	    		</c:if>
	    		<c:if test="${board.menuUse == 0}">  		
	    		<td>사용대기</td> 
	    		</c:if>-->
	    		<td>
	    		<span class="btn btn-default btn-xs" onclick="funAclEdit('chkAcl_${board.menuId}',${board.menuId},'${board.menuCode}')">등록</span>	    		
				</td>
	    	</tr>   
	    	 <c:set var="j" value="${j+1}" />    	   
	        </c:forEach>  
        </tbody>
        </c:if>
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