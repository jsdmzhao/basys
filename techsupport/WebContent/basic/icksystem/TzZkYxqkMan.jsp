<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%
User user = (User)session.getAttribute(Constants.userKey);
String departCode = user.getDepartment().getDepartcode();
%>
<script type="text/javascript">
var js_departCode = '<%=departCode %>';
$(document).ready(function() {
	pageUrl="icksystem/querylist_cjdtjrb.action";
	divnid="tabledata";
	tableid="table1";
	tables=$("#tabledata").html();
	$("#t_ssdsbm").attr("value",js_departCode.substr(0,7));
	$("#t_cjdbm").attr("value",js_departCode);
	setPageList_zkxx(1,"icksystem/querylist_cjdtjrb.action");	
}); 
	
function setPageList_zkxx(pageno,url){	
		url=setList(pageno,url);
		setParams("t_"); //传参
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML,
										ingridPageWidth: pageWidth-415,
										url: url,	
										height: pageHeight-212,
										pageNumber: pageno,
										onRowSelect: null,
										sorting: false,
										isPlayResultNull: false,
										colWidths: ["14%","14%","14%","14%","14%","14%","16%"]									
									});				
}	

</script>
<body>
<input type="hidden" id="t_ssdsbz" value="1">
<input type="hidden" id="t_ssdsbm">
<input type="hidden" id="t_cjdbz" value="1">
<input type="hidden" id="t_cjdbm">
	<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>
	     	<th>地市</th>
	     	<th>采集点</th>
	     	<th>已录入企业</th>
	     	<th>已录入人员</th>
	     	<th>已受理IC卡</th>
	     	<th>已接收IC卡</th>
	     	<th>已发放IC卡</th>
	    </tr>
	  </thead>
	</table>
</div>
</body>