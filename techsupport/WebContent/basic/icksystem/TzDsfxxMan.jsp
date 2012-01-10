<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%
User user = (User)session.getAttribute(Constants.userKey);
String departCode = user.getDepartment().getDepartcode();
%>
<script type="text/javascript">
	var js_departCode = '<%=departCode %>';
	var dsftables;
	$(document).ready(function() {
	   dsftables=$("#dsftabledata").html();
	   $("#p_ssdsbm").attr("value",js_departCode.substr(0,7));
	   $("#p_cjdbm").attr("value",js_departCode);
       setPageList_dsfxx(1,"icksystem/tzDsfzkTjList_icksl.action");
	});
	
	function setPageList_dsfxx(pageno,url){
		$("#dsftabledata").html(dsftables);	
		setParams("p_"); //传参
		var mygrid1 = $("#dsftable").ingrid({
				ingridPageParams:sXML,
				url: url,
				ingridPageWidth : pageWidth-415,
				height: pageHeight-212,
				pageNumber: pageno,
				isPlayResultNull: false,
				colWidths: ["10%","10%","10%","10%","10%","10%","10%","10%","10%","10%"],
				onRowSelect: function(tr, selected){},
				sorting: false
		});
	}
	
	
</script>

<body>
<input type="hidden" id="p_deptCode">
<input type="hidden" id="p_ssdsbz" value="1">
<input type="hidden" id="p_ssdsbm">
<input type="hidden" id="p_cjdbz" value="1">
<input type="hidden" id="p_cjdbm">

<div id="dsftabledata" style="width:100%;">
	<table id="dsftable" width="100%">
	  <thead>
	    <tr>
	     	<th>&nbsp;地市</th>
	     	<th>采集点</th>
	     	<th>已录入企业</th>
	     	<th>已录入人员</th>
	     	<th>已受理IC卡</th>
	     	<th>已发送数</th>
	     	<th>已反馈数</th>
	     	<th>已制卡数</th>
	     	<th>反馈失败数</th>
	     	<th>已发放数</th>
	    </tr>
	  </thead>
	</table>
</div>
</body>