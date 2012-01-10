<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants;"%>
<%
	//登录用户所在部门父节点id
	int parentdeptid = -1;
	User user = new User();
	//获得登录用户session
	user = (User)session.getAttribute(Constants.userKey);
	if(user == null)
		response.sendRedirect("login.jsp");
	else
		parentdeptid = user.getDepartment().getParentdepartid().intValue();
 %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/css/dhtmlXTree.css">
<link href="<c:out value="${pageContext.request.contextPath}"/>/css/style.css" rel="stylesheet" type="text/css">
<script  src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXCommon.js"></script>
<script  src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXTree.js"></script>
</head>
<body>	
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
		<div class="treediv">
			<!--表单样式开始 -->
			<table width="100%" align="center" cellpadding="1" cellspacing="3" class="titleTable" >
	            <tr>
	                <td style="font-weight:bold" >机构列表</td>
	            </tr>
            	<tr>
                	<td class="tdContent" >
                  		<table width="100%" border='0'  align="center" cellpadding="1" cellspacing="1" class="listTable">
  							<tr>
    							<td valign="top">
       								<div id="depart_tree" class="titleTablenei"></div>
	    						</td>
							</tr>	
       					</table>   
                	</td>
            	</tr>
        	</table>
		</div>
	</td><td width="4"><img name="" src="" width="4" height="1" alt=""></td>
    <td valign="top" align="left">
		<div class="textdiv" id="deptManager" onload='$("deptManager").show("slow");'>
      	</div>
    </td>
  </tr>
</table>
</body>

<script>
var depart_treeWidth = $("#depart_tree").width();
$("#depart_tree").css({width:pageWidth-838});
$("#depart_tree").css({height:pageHeight-142});
var itemSelect = 0;
//var parentdeptid = "<c:out value='${parentdeptid}'/>";
var parentdeptid = '<%=parentdeptid%>';
 tree=new dhtmlXTreeObject("depart_tree","100%","100%",parentdeptid);
  //tree=new dhtmlXTreeObject("depart_tree","100%","100%",parentID);
  tree.setImagePath("<c:out value="${pageContext.request.contextPath}"/>/images/tree/");
  
  //拖拽
     tree.enableDragAndDrop(1);
   tree.setDragHandler(myDragHandler);
  function myDragHandler(idFrom,idTo){
                //if we return false then drag&drop be aborted
                if(idFrom!=0){
                 deptAdjust(idFrom,idTo);
              }
       return true;
            }
            
   //部门调整
  function deptAdjust(idFrom,idTo){
  document.getElementById('colseStuts').value="no";
     if((idFrom!='')&&(idTo!='')){
	     var url ="<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/deptAdjust_tree.action";
          var pars = 'idFrom='+idFrom+'&idTo='+idTo;
           var myAjax = new Ajax.Request(
               url,
               {method: 'post', asynchronous:true, parameters: pars, onComplete: deptAdjustResponse}
               );
			}
			var surl =" <c:out value="${pageContext.request.contextPath}"/>/basic/sysadmin/tree/sudu.jsp";
		 window.showModalDialog(surl,window,"help:no;status:no;dialogWidth:220px;dialogHeight:100px;resizable:yes;scroll:no");
        }
         //部门回调函数
        function deptAdjustResponse(originalRequest){
        document.getElementById('colseStuts').value="yes";
          	      var  messages= originalRequest.responseText; 
          	     var parentIDAndId = messages.split("|,");
     		 	  var parentID  = parentIDAndId[0];
        		 var id = parentIDAndId[1];
        		 	 var idFormParent = parentIDAndId[2];
        	
        		tree.refreshItem(idFormParent);
        		
        	 tree.refreshItem(parentID);
        	 alert("调整成功");
          	     selectItem(id);
          	  return true;
    }
  
  //下移动  上下移动会调用tree.setDragHandler(myDragHandler);这个函数，不知道为什么


 function  moveDownItem(){
    tree.moveItem(this.itemSelect,"down") ;
  }
  //上移动


 function  moveUpItem(){
    tree.moveItem(this.itemSelect,"up") ;
  }
  //显示checkBoxes
  /////////////tree.enableCheckBoxes(1);
  //子父连带
  //tree.tscheck=true;
  tree.setOnClickHandler(doOnClick);
  tree.setXMLAutoLoading("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/deptTree_tree.action?");
  //tree.loadXML("<c:out value="${pageContext.request.contextPath}"/>/privisys/department.do?method=tree&id=0");
  tree.loadXML("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/deptTree_tree.action");
  function saveOnClick(parentItemId){
    tree.refreshItem(parentItemId);
    }
    function selectItem(id){
     itemSelect =id;
     tree.selectItem(id,true);
    }
    
  function saveOnClickedit(parentItemId,id){
    tree.refreshItem(parentItemId);
      alert("更新成功！");
       tree.selectItem(id,true);
    }
     function saveOnClickdel(parentItemId){
      tree.refreshItem(parentItemId);   
      tree.selectItem(parentItemId,true);
    }
  function doOnClick(itemId){
    itemSelect =itemId;
    var treeflag="<c:out value='${treeFalg}'/>";
    treeDepartid=itemId;
	if(treeflag=='department'){
	rightMaindept(treeDepartid);
	}
	if(treeflag=='user'){
	rightMainUser(treeDepartid);
	}
   if(treeflag=='role'){
	 rightMainRoleDept(treeDepartid);
	}
	if(treeflag=='user_role'){
	 rightMainUser_role(treeDepartid);
	}
	if(treeflag=='userqy'){
		rightMainUserQy(treeDepartid);
	}
	if(treeflag=='userga'){
		rightMainUserGa(treeDepartid);
	}
	
  }
  
</script>
<script>

function rightMaindept(treeDepartid)
{
	$("#deptManager").empty();
			$("#deptManager").load("sysadminDefault/queryDepartment_department.action?departid="+treeDepartid);
			$("#deptManager").show("slow"); 
}
function rightMainUser(treeDepartid){
	$("#deptManager").empty();
			$("#deptManager").load("sysadminDefault/queryUser_user.action?departid="+treeDepartid);
			$("#deptManager").show("slow"); 
}
function rightMainRoleDept(treeDepartid){
	$("#deptManager").empty();
			$("#deptManager").load("sysadminDefault/queryRole_role.action?departid="+treeDepartid);
			$("#deptManager").show("slow"); 
}
function rightMainUser_role(treeDepartid)
{
	$("#deptManager").empty();
			$("#deptManager").load("sysadminDefault/queryUserRole_user.action?departid="+treeDepartid);
			$("#deptManager").show("slow"); 
}
  //企业用户管理
function rightMainUserQy(treeDepartid){
	$("#deptManager").empty();
			$("#deptManager").load("basic/sysadmin/UserQyMan.jsp",{"departid":treeDepartid});
			$("#deptManager").show("slow"); 
}
  //公安用户管理
function rightMainUserGa(treeDepartid){
	$("#deptManager").empty();
			$("#deptManager").load("basic/sysadmin/UserGaMan.jsp",{"departid":treeDepartid});
			$("#deptManager").show("slow"); 
}
//页面加载时，自动调用方法
var treeDepartid ='';
var treeflagTwo="<c:out value='${treeFalg}'/>";
 if(treeflagTwo=='department'){
  rightMaindept(treeDepartid);
 }			
 if(treeflagTwo=='user'){
   rightMainUser(treeDepartid);
 }			
  
 if(treeflagTwo=='role'){
   rightMainRoleDept(treeDepartid);
 }	
 if(treeflagTwo=='user_role'){
   rightMainUser_role(treeDepartid);
 }
</script>
</html>