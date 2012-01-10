<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
<title></title>
<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/css/dhtmlXTree.css">
<script  src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXCommon.js"></script>
<script  src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXTree.js"></script>
<SCRIPT language=JavaScript>
<!--
function SymError()
{
  return true;
}

window.onerror = SymError;

var cf=parent.document.getElementById("departFrame");
function resizeWin()
{cf.width=202;cf.height=225;}
//-->
</SCRIPT>
</head>
<body bottomMargin=0 bgColor=#DFDFDF leftMargin=0 topMargin=0 onLoad="resizeWin()" rightMargin=0>
<table border="0" width="100%" height="100%">
  <tr>
    <td valign="top" width="100%" height="100%">
      <div id="depart_tree" style="width:100%; height:100%;background-color:#DFDFDF;border:1px solid Silver;; overflow:auto;"></div>
    </td>
  </tr>
</table>
</body>
</html>
<script>
  tree=new dhtmlXTreeObject("depart_tree","100%","100%",0);
  tree.setImagePath("<c:out value="${pageContext.request.contextPath}"/>/images/tree/");
  tree.setOnClickHandler(doOnClick);
  tree.setXMLAutoLoading("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/deptTree_tree.action");
  tree.loadXML("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/deptTree_tree.action?id=0");

  function doOnClick(itemId){
    parent.fld1.value=tree.getItemText(itemId);
    parent.fld2.value=itemId;
//    parent.loadTree();
    parent.hideDrop();
  }
</script>
<SCRIPT language=javascript>
<!--//
var bCalLoaded=true;
//-->
</SCRIPT>

