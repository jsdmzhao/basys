<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
	String dict_code = request.getParameter("dict_code");
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/css/dhtmlXTree.css">
<link href="<c:out value="${pageContext.request.contextPath}"/>/css/style.css" rel="stylesheet" type="text/css">
<script  src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXCommon.js"></script>
<script  src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXTree.js"></script>
</head>
<body>	
<table id="di_treeTable" width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
<div class="treediv">
<!--表单样式开始 -->
	<!--表单样式开始 -->
<table width="100%" border='0' align="center" cellpadding="1" cellspacing="3" class="titleTable" >
  <tr>
    <td style="font-weight:bold" >字典项列表</td>
  </tr>
</table>
             <table width="100%"  border='0'  align="center" cellpadding="1" cellspacing="1" class="listTable">
  <tr>
    <td class="listTD" valign="top"><table width="100%" cellspacing="0" cellpadding="0"  border='0'>
  <tr >
              
	    <td>
	     	<div id="dictionaryItem_tree" class="titleTablenei"></div>
	   </td>
	  </tr>
				
				
</table>

                </td>
                
            </tr>
         	
       
            </table>
</div>
</td><td width="4"><img name="" src="" width="4" height="1" alt=""></td>
      <td valign="top">

<div class="textdiv" id="dictItemManager" onload='$("dictItemManager").show("slow");'>
      </div>
      
      </td>
        </tr>
</table>
</body>

<script>
$("#dictionaryItem_tree").height(pageHeight-137);
			
/*
$("#di_treeTable").height($("#d_treeTable").height()).
	width($("#d_treeTable").width()).
		css("left",$("#d_treeTable").position().left+$("#d_treeTable").width()).
			css("top",$("#d_treeTable").position().top);*/

var d='<%=dict_code%>';
  tree=new dhtmlXTreeObject("dictionaryItem_tree","100%","100%",0);
  tree.setImagePath("<c:out value="${pageContext.request.contextPath}"/>/images/tree/");
  tree.setOnClickHandler(onNodeSelect);
  tree.setXMLAutoLoading("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/dictItemTree_tree.action?dict_code="+d);
  tree.loadXML("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/dictItemTree_tree.action?id=0&dict_code="+d);

function saveSuccess(parentItemId,id){
 	tree.refreshItem(parentItemId);
    if(id != 0){
    tree.selectItem(id,true);
    }
  }
  
function onNodeSelect(id){
 treeitem_id =id;
 treeitem_fact_value= tree.getUserData(id,id);
  rightMain(treeitem_id,treeitem_fact_value);
}
</script>
<script>
					
//var treeitem_id =100;
function rightMain(treeitem_id,treeitem_fact_value){
	$("#dictItemManager").width(pageWidth-$("#dictionaryItem_tree").width()-$("#list1").width()-20).css("left",59);
	$("#dictItemManager").empty();
			$("#dictItemManager").load("sysadminDefault/manageTree_dict_item.action?dict_code="+d+"&item_id="+treeitem_id+"&fact_value="+treeitem_fact_value);
			$("#dictItemManager").show("slow"); 
}
   rightMain(0);
	
</script>
</html>