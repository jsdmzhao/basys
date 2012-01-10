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
			<table width="100%" align="left" cellpadding="1" cellspacing="3" class="titleTable" >
				<tr>
	                <td style="font-weight:bold" >菜单列表</td>
	            </tr>
				<tr>
				 	<td class="tdContent">
		                <table width="100%" border='0'  align="center" cellpadding="1" cellspacing="1" class="listTable">
		  					<tr>
		    					<td valign="top" >
		       						<div id="menu_tree" class="titleTablenei"></div>
		       					</td>
							</tr>	
		       			</table>
	       			</td>           
	        	</tr>
        	</table>        
		</div>
	</td><td width="4"><img name="" src="" width="4" height="1" alt=""></td>
    <td valign="top" align="left">
		<div class="textdiv" id="menuManager" onload='$("menuManager").show("slow");'>
      	</div>
    </td>
  </tr>
</table>
</body>

<script>
$("#menu_tree").css({height:pageHeight-142});
$("#menu_tree").css({width:pageWidth-838});
 tree2=new dhtmlXTreeObject("menu_tree","100%","100%",0);
  tree2.setImagePath("<c:out value="${pageContext.request.contextPath}"/>/images/tree/");
    //显示checkBoxes
    //tree2.enableCheckBoxes(1);
  //子父连带
  //tree2.tscheck=true;
  tree2.setOnClickHandler(doOnClick);
  tree2.setXMLAutoLoading("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/menuTree_tree.action");
  tree2.loadXML("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/menuTree_tree.action?id=0");
	
  function doOnClick(itemId)
  {
    //treesystemcode = "<c:out value='${systemcode}'/>";
    var treesystemcode = '';//选中节点所在的系统
    var treemenucode = '';//选中节点的菜单id
    var treelevel;//选中几点的level
    var rootid;//选中节点的根节点id
    var tempItemid;//itemId的临时值
    //菜单节点
    if(itemId.indexOf('sysfalg')==-1)
    {
      	treemenucode =itemId;
      	//获得菜单节点所在的系统
      	treelevel = tree2.getLevel(itemId);
      	tempItemid = itemId;
      	for(var i = treelevel;i>1;i--)
      	{
      		rootid = tree2.getParentId(tempItemid);
      		tempItemid = rootid;
      	}
      	treesystemcode = rootid.substring(7);
   	}
   	//系统节点
    else
    {
    	treesystemcode = itemId.substring(7);
      	treemenucode ="0";
    }
     rightMain(treesystemcode,treemenucode);
  }
  function loadTree(){
  	var url="<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/query_memu.action";
  	parent.infoFrame.location=url;
      var systemcode = "<c:out value='${systemcode}'/>";
    tree2.deleteChildItems(0);
    tree2.loadXML("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/menuTree_tree.action?id=0&systemcode="+systemcode);
  }
  function saveOnClick(parentCode){
   tree2.refreshItem(parentCode);
  }
  function saveOnClickedit(parentCode,code){
    tree2.refreshItem(parentCode);
    alert("更新成功");
    tree2.selectItem(code,true);
  } 
  function saveOnClickdel(parentCode,systemID){
  alert("删除成功");
    var systemcode = "<c:out value='${systemcode}'/>";
  if(parentCode==0){
    	var url="<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/query_memu.action";
  	parent.infoFrame.location=url;
    tree2.deleteChildItems(0);
    tree2.loadXML("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/menuTree_tree.action?id=0&systemcode="+systemcode);
  }else{
    tree2.refreshItem(parentCode);
    tree2.selectItem(parentCode,true);
  }
    }
</script>
<script>
var treemenucode ='';
var treesystemcode='';
function rightMain(treesystemcode,treemenucode){
	$("#menuManager").empty();
			$("#menuManager").load("sysadminDefault/queryMenu_menu.action?systemcode="+treesystemcode+"&menucode="+treemenucode);
			$("#menuManager").show("slow"); 

			}
   rightMain(treesystemcode,treemenucode);
</script>
</html>