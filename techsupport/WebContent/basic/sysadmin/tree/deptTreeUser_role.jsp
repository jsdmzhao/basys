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
                  		<table width="100%" border='0' id='deptTreeUser_role_table' align="center" cellpadding="1" cellspacing="1" class="listTable">
  							<tr>
    							<td valign="top">
       								<div id="depart_treeUser_role" class="titleTablenei"></div>
	    						</td>
							</tr>	
       					</table>   
                	</td>
            	</tr>
        	</table>
		</div>
	</td><td width="4"><img name="" src="" width="4" height="1" alt=""></td>
    <td valign="top" align="left">
		<div class="textdiv" id="deptManagerUser_role" onload='$("deptManagerUser_role").show("slow");'>
      	</div>
    </td>
  </tr>
</table>
</body>

<script>
//$("#depart_treeUser_role").css({height:pageHeight-148});
$("#depart_treeUser_role").height(160);
var itemSelect = 0;
//var parentdeptid = "<c:out value='${parentdeptid}'/>";
var parentdeptid = '<%=parentdeptid%>';
 tree=new dhtmlXTreeObject("depart_treeUser_role","100%","100%",parentdeptid);
  //tree=new dhtmlXTreeObject("depart_treeUser_role","100%","100%",parentID);
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
  $("#depart_tree").width(depart_treeWidth);
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
	if(treeflag=='user_role'){
	 rightMainUser_roleInner(treeDepartid);
	}
  }
  
</script>
<script>

function rightMainUser_roleInner(treeDepartid)
{
	$("#deptManagerUser_role").empty();
			$("#deptManagerUser_role").load("sysadminDefault/queryUserRole_user.action?departid="+treeDepartid);
			$("#deptManagerUser_role").show("slow"); 
}
//页面加载时，自动调用方法
var treeDepartid ='';
var treeflagTwo="<c:out value='${treeFalg}'/>";

 if(treeflagTwo=='user_role'){
   rightMainUser_roleInner(treeDepartid);
 }
</script>
</html>