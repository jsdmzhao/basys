<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html:html>
<head>
<title></title>
<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/css/dhtmlXTree.css">
<script  src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXCommon.js"></script>
<script  src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXTree.js"></script>
<%
String dict_code = request.getParameter("dict_code");
String width = (request.getParameter("width") != null)?request.getParameter("width"):"173";
String height = (request.getParameter("height") != null)?request.getParameter("height"):"225";
%>
<script>
<!--
var d ='<%=dict_code%>';
function SymError(){
  return true;
}

window.onerror = SymError;

var cf=parent.document.getElementById('<%=dict_code%>');
function resizeWin(){
	cf.width='<%=width%>';
	cf.height='<%=height%>';
}
//-->
</script>
</head>
<body bottomMargin=0 bgcolor="#DDE3EA" leftMargin=0 topMargin=0 onLoad="resizeWin()" rightMargin=0>
<table border="0" width="100%" height="100%" >
  <tr>
    <td valign="top" width="100%" height="100%">
      <div id="dictionaryItem_tree"class="titleTablenei"></div>
    </td>
  </tr>
</table>
</body>
</html:html>
<script>
  tree=new dhtmlXTreeObject("dictionaryItem_tree","100%","100%",0);
  tree.setImagePath("<c:out value="${pageContext.request.contextPath}"/>/images/tree/");
  tree.setOnClickHandler(doOnClick);
  tree.setXMLAutoLoading("<c:out value="${pageContext.request.contextPath}"/>/dictionary/dictitem.do?method=showTree&dict_code="+d);
  tree.loadXML("<c:out value="${pageContext.request.contextPath}"/>/dictionary/dictitem.do?method=showTree&id=0&dict_code="+d);

  function doOnClick(itemId){
    parent.fld1.value=tree.getItemText(itemId);
    parent.fld2.value=tree.getUserData(itemId,itemId);
    //parent.fld2.value=itemId;
    parent.hideDrop();
    parent.loadTree();
   
  }
</script>
<SCRIPT language=javascript>
<!--//
var bCalLoaded=true;
//-->
</SCRIPT>

