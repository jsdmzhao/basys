<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants"%>

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
<table width="100%" border="0" cellpadding="0" cellspacing="0"  background="images/toolbar.gif">
    <tr>
    	<td width="85%"  style="text-align:left"><input id='t_query_simplepin' class="inputstyle3" type='text' style="width:98%" /></td>
    	<td width="15%" style="text-align:center"><img src="images/clear.gif" width="16" height="16" /><a href="#" id='b_clear'  class="fontbutton1" onclick='fnclear();'>[清除]</a></td>
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
       								<div id="depart_treeDropDown" style="width:100%;background-color:#eef6ff; border :0px solid Silver; overflow:auto;"></div>
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
$("#depart_treeDropDown").css({height:300});
var itemSelect = 0;
//var parentdeptid = "<c:out value='${parentdeptid}'/>";
var parentdeptid = '<%=parentdeptid%>';
 tree=new dhtmlXTreeObject("depart_treeDropDown","100%","100%",parentdeptid);
  //tree=new dhtmlXTreeObject("depart_treeDropDown","100%","100%",parentID);
  tree.setImagePath("<c:out value="${pageContext.request.contextPath}"/>/images/tree/");
  //显示checkBoxes
  /////////////tree.enableCheckBoxes(1);
  //子父连带
  //tree.tscheck=true;
  tree.setOnClickHandler(doOnClick);
  tree.setXMLAutoLoading("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/deptTree_tree.action?");
  //tree.loadXML("<c:out value="${pageContext.request.contextPath}"/>/privisys/department.do?method=tree&id=0");
  tree.loadXML("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/deptTree_tree.action");
  function doOnClick(itemId)
  {
  		//返回管辖单位名称
  		$("#"+gmcId).val(tree.getItemText(itemId));
  		//获得userdata
  		var userdatavalue = tree.getUserData(itemId,itemId);
  		if(userdatavalue == null || userdatavalue==undefined)
  			userdatavalue = "";
  		var userdatavalueArr = userdatavalue.split(",");
 		//返回完整管辖单位代码
  		if(gdmId!=null&&gdmId!=undefined&&gdmId!="undefined")
  			$("#"+gdmId).val(userdatavalueArr[0]);
  		//返回去掉尾部偶数个0的管辖单位代码
  		if(gjsdmId!=null&&gjsdmId!=undefined&&gjsdmId!="undefined")
  			$("#"+gjsdmId).val(userdatavalueArr[1]);
  		//返回级别
  		if(glevel!=null&&glevel!=undefined&&glevel!="undefined")
  			$("#"+glevel).val(userdatavalueArr[2]);
  		//返回节点ID
  		if(gitemid!=null&&gitemid!=undefined&&gitemid!="undefined")
  			$("#"+gitemid).val(itemId);
  		//返回父节点ID
  		if(gparentItemId!=null&&gparentItemId!=undefined&&gparentItemId!="undefined")
  			$("#"+gparentItemId).val(userdatavalueArr[3]);
  		//返回全路径代码
  		if(gfullcode!=null&&gfullcode!=undefined&&gfullcode!="undefined")
  			$("#"+gfullcode).val(userdatavalueArr[4]);
  		//返回是否叶节点
  		if(gisLeaf!=null&&gisLeaf!=undefined&&gisLeaf!="undefined")
  			$("#"+gisLeaf).val(userdatavalueArr[5]);
  		
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