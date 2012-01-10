<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
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
					<td id="systemRole_td" style="font-weight:bold" >系统列表</td>
				</tr>
				<tr>
					<td class="tdContent">
						<table width="100%" border='0' align="center" cellpadding="1" cellspacing="1" class="listTable">
						<tr>
							<td valign="top">
							<div id="system_tree" class="titleTablenei"></div>
							</td>
						</tr>	
						</table>
					</td>
				</tr>
				</table>  
			</div>
		</td><td width="4"><img name="" src="" width="4" height="1" alt=""></td>
		<td valign="top" align="left">
			<div class="textdiv" id="systemManager" onload='$("systemManager").show("slow");'></div>
		</td>
	</tr>
	</table>
</body>

<script>
$("#system_tree").css({height:pageHeight-142});
$("#system_tree").css({width:pageWidth-838});
tree=new dhtmlXTreeObject("system_tree","100%","100%",0);
  tree.setImagePath("<c:out value="${pageContext.request.contextPath}"/>/images/tree/");
  tree.setOnClickHandler(doOnClick);
  //显示checkBoxes
 ////////// tree.enableCheckBoxes(1);
  //子父连带
  //tree.tscheck=true;
  tree.setXMLAutoLoading("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/systemTree_tree.action");
  tree.loadXML("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/systemTree_tree.action?id=0");

  function saveOnClick(parentCode){
    tree.refreshItem(parentCode);
  }
  function saveOnClickedit(parentCode,code){
  
    tree.refreshItem(parentCode);
    alert("更新成功");
    tree.selectItem(code,true);
  } 
  function saveOnClickdel(parentCode){
    tree.refreshItem(parentCode);
    tree.selectItem(parentCode,true);
  }
  
    function doOnClick(itemId){
      var systemTreeFalg="<c:out value='${systemTreeFalg}'/>";
      treesystemcode = itemId;
	if(systemTreeFalg=='system'){
	rightMainSystem();
	}
	
   if(systemTreeFalg=='function'){
    rightMainFunction();
	}
	
   if(systemTreeFalg=='role'){
    	rightMainRoleSystem();
	}
  }
  
</script>
<script>
var treesystemcode ="";
  var systemTreeFalgTwo="<c:out value='${systemTreeFalg}'/>";
 //alert(systemTreeFalgTwo);
function rightMainSystem(){
	$("#systemManager").empty();
			$("#systemManager").load("sysadminDefault/querySystem_system.action?systemcode="+treesystemcode);
			$("#systemManager").show("slow"); 
			}
   function rightMainFunction(){
	$("#systemManager").empty();
			$("#systemManager").load("sysadminDefault/queryFunction_function.action?systemcode="+treesystemcode);
			$("#systemManager").show("slow"); 
			} 
function rightMainRoleSystem(){
	$("#system_tree").height(pageHeight*0.2);
	$("#systemRole_td").addClass("queryfont");
	$("#systemManager").empty();
			$("#systemManager").load("sysadminDefault/queryFuncForRole_function.action?systemcode="+treesystemcode);
			$("#systemManager").show("slow"); 
}
  
 if(systemTreeFalgTwo=='system'){
  rightMainSystem();
 }			
   if(systemTreeFalgTwo=='function'){
   rightMainFunction();
 }	   
 
 if(systemTreeFalgTwo=='role'){
   rightMainRoleSystem();
 }			
  	
</script>
</html>