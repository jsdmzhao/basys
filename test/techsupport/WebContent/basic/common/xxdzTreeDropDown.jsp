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
		<div class="treediv" style='width:400px'>
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

 tree=new dhtmlXTreeObject("dictItem_treeDropDown","100%","100%",0);
  //tree=new dhtmlXTreeObject("depart_treeDropDown","100%","100%",parentID);
  tree.setImagePath("<c:out value="${pageContext.request.contextPath}"/>/images/tree/");
  //显示checkBoxes
  /////////////tree.enableCheckBoxes(1);
  //子父连带
  //tree.tscheck=true;
  tree.setOnClickHandler(doOnClick);
  tree.setXMLAutoLoading("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/dictItemTreexxdz_tree.action?dict_code="+gdictCode);
  //tree.loadXML("<c:out value="${pageContext.request.contextPath}"/>/privisys/department.do?method=tree&id=0");
  tree.loadXML("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/dictItemTreexxdz_tree.action?dict_code="+gdictCode);
  function doOnClick(itemId)
  {
  		if(!tree.hasChildren(itemId)){
	  		
	  		//获得userdata
	  		var userdatavalue = tree.getUserData(itemId,itemId);
	  		
	  		//jQuery.post("sysadmin/insert_tree.action",params,update_caijidianback,"json"); 
	  		
	  		
	  		 var url ="<c:out value="${pageContext.request.contextPath}"/>/sysadmin/tDictItemallvalue_dict_item.action";
             var params = {itemId:itemId};
	         jQuery.ajax({
				type: 'POST',
				url: url,
				data: params,
				async: false,
				dataType: 'json',
				success: function(json){
				    //alert(json.allFact_value);
					$("#"+gmcId).val(json.allFact_value);					
				}
			});
	  		
	  		
	  		
	  		//返回管辖单位名称
	  		//$("#"+gmcId).val(tree.getItemText(itemId));
	  		
	  		
	  		$("#divs_" + gmcId).remove();
	  	}
  }
  
  //点击清除按钮，清除调用框及相应隐藏框的值
	function fnclear()
	{
		if($("#" + gmcId).attr("id")!=null&&$("#" + gmcId).attr("id")!=undefined )
 		{
 			$("#" + gmcId).val("");
 		}

    }
  
</script>
<script>

</script>
</html>