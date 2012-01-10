<%@ page language="java"  pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<html>
<head>
<title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/css/dhtmlXTree.css">
<script  src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXCommon.js"></script>
<script  src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXTree.js"></script>
</head>
<body>
<table  width="100%">
  <tr>
    <td valign="top" height="1000px">
       <div id="menu_tree" class="titleTablenei"></div>
    </td>
  </tr>
</table>
</body>
</html>
<script>
 // var roleid=document.getElementById("id").value;
  var roleid=17;
  tree2=new dhtmlXTreeObject("menu_tree","100%","100%",0);
  tree2.setImagePath("<c:out value="${pageContext.request.contextPath}"/>/images/tree/");
  tree2.enableCheckBoxes(1);
  tree2.tscheck=true;
  tree2.setXMLAutoLoading("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/roleMenuTree_tree.action?open=true&roleid="+roleid);
 tree2.loadXML("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/roleMenuTree_tree.action?id=0&open=true&roleid="+roleid);
  function _setChecked(){
	checkedItems=document.getElementById("checked").value;
	arrIDs=checkedItems.split(",");
		for(i=0;i<arrIDs.length;i++){
			tree2.setCheck(arrIDs[i], true);
		}
	}
  function loadTree(){
    var sysid = document.all['systemCode'].value;
    var systemNameExit = document.all['systemName'].value;
    tree2.deleteChildItems(0);
    tree2.loadXML("<c:out value="${pageContext.request.contextPath}"/>/privisys/role.do?method=roleMenuTree&open=true&id=0&systemID="+sysid+"&roleID="+roleID+"&systemNameExit="+escape(escape(systemNameExit)));
  }

</script>

