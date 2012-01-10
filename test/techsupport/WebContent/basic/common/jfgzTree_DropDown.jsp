<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/css/dhtmlXTree.css">
<link href="<c:out value="${pageContext.request.contextPath}"/>/css/style.css" rel="stylesheet" type="text/css">
<script  src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXCommon.js"></script>
<script  src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXTree.js"></script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0"  background="images/toolbar.gif">
    <tr>
    	<td width="70%"  style="text-align:left"></td>
    	<td width="30%" style="text-align:center"><img src="images/clear.gif" width="16" height="16" /><a href="#" id='b_clear'  class="fontbutton1" onclick='fnclear();'>[清除]</a></td>
   	</tr>
</table> 
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
		<div class="treediv" style='width:200px'>
			<!--表单样式开始 -->
			<table width="100%" align="center" cellpadding="1" cellspacing="3" class="titleTable" >
            	<tr>
                	<td class="tdContent" >
                  		<table width="100%" border='0'  align="center" cellpadding="1" cellspacing="1" class="listTable">
  							
  							<tr>
    							<td valign="top">
       								<div id="dictItem_treeDropDown" style="width:100%;background-color:#eef6ff; border :0px solid Silver; overflow:auto;"></div>
	    						</td>
							</tr>	
       					</table>   
                	</td>
            	</tr>
        	</table>
		</div>
	</td>
  </tr>
</table>
</body>

<script>
$("#dictItem_treeDropDown").css({height:300});
var itemSelect = 0;

 jfgztree=new dhtmlXTreeObject("dictItem_treeDropDown","100%","100%",0);
  //tree=new dhtmlXTreeObject("depart_treeDropDown","100%","100%",parentID);
  jfgztree.setImagePath("<c:out value="${pageContext.request.contextPath}"/>/images/tree/");
  //显示checkBoxes
  /////////////tree.enableCheckBoxes(1);
  //子父连带
  //tree.tscheck=true;
  jfgztree.setOnClickHandler(doOnClick);
  jfgztree.setXMLAutoLoading("<c:out value="${pageContext.request.contextPath}"/>/jfgltree/jfgzTree_jfgz.action?treepar="+dataid);
  //tree.loadXML("<c:out value="${pageContext.request.contextPath}"/>/privisys/department.do?method=tree&id=0");
  jfgztree.loadXML("<c:out value="${pageContext.request.contextPath}"/>/jfgltree/jfgzTree_jfgz.action?treepar="+dataid);
  function doOnClick(itemId)
  {
	  		//返回名称、gzqlj+gzjb+gzpx、id
	  		$("#"+gmcId).val(jfgztree.getItemText(itemId));
	  		$("#"+gdmId).val(jfgztree.getUserData(itemId,itemId));
	  		$("#"+gitemid).val(itemId);
	  		$("#divs_" + gmcId).remove();
  }
  
  //点击清除按钮，清除调用框及相应隐藏框的值
	function fnclear()
	{
		if($("#" + gmcId).attr("id")!=null&&$("#" + gmcId).attr("id")!=undefined )
 		{
 			$("#" + gmcId).val("");
 		}
 		if($("#" + gdmId).attr("id")!=null&&$("#" + gdmId).attr("id")!=undefined )
 		{
 			$("#" + gdmId).val("");
 		}
 		if($("#" + gjsdmId).attr("id")!=null&&$("#" + gjsdmId).attr("id")!=undefined )
 		{
 			$("#" + gjsdmId).val("");
 		}
 		if($("#" + glevel).attr("id")!=null&&$("#" + glevel).attr("id")!=undefined )
 		{
 			$("#" + glevel).val("");
 		}
 		if($("#" + gitemid).attr("id")!=null&&$("#" + gitemid).attr("id")!=undefined )
 		{
 			$("#" + gitemid).val("");
 		}
 		if($("#" + gparentItemId).attr("id")!=null&&$("#" + gparentItemId).attr("id")!=undefined )
 		{
 			$("#" + gparentItemId).val("");
 		}
 		if($("#" + gfullcode).attr("id")!=null&&$("#" + gfullcode).attr("id")!=undefined )
 		{
 			$("#" + gfullcode).val("");
 		}
 		if($("#" + gisLeaf).attr("id")!=null&&$("#" + gisLeaf).attr("id")!=undefined )
 		{
 			$("#" + gisLeaf).val("");
 		}
    }
  
</script>
<script>

</script>
</html>