<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>
	
	
<html>
<head>
<script type="text/javascript">

   var fivefalg="yes";

	var skjl_tables="";
	var skjl_pageUrl="icksystem/querylistFiveSkjl_qyryskjl.action";
	var skjl_divnid="tabledata";
	var skjl_tableid="table1";
	
	
	$(document).ready(function(){
		$("#ickknxx").empty();
		$("#ickknxx").load("public/skOne.jsp");
		$("#ickknxx").show("slow");
	});
	
	
	function skjlslxxx(cyrybh){
	    $("#p_cyrybh").attr("value",cyrybh);
		 skjl_loadPage("tabledata");
	}
	
	function skjl_setPageList(pageno,url){	
		url=skjl_setList(pageno,url);
		var mygrid1 = $("#"+skjl_tableid).ingrid({ 
							url: url,
							ingridPageParams:sXML,
							height: pageHeight-206,
							pageNumber: pageno,
							paging: false,
							sorting: false,
							onRowSelect: null,
							colWidths: ["20%","20%","20%","20%","20%"]
					});				
	}
	function skjl_loadPage(divpageid){
	    ctreatTable();
		skjl_tables=$("#"+divpageid).html();
		skjl_setPageList(1);
	}
	
		function ctreatTable(){
	       $("#tabledata").empty();
	        var result = "<table id='table1' width='100%'><thead><tr>";
		     result += "<th name='l_qymc' datatype='Integer' sumflag='0'>刷卡场所</th>";
		    result += "<th name='l_cyrybh' datatype='Integer' sumflag='0'>从业人员编号</th>";
	     	result += "<th name='l_xm' datatype='Integer' sumflag='0'>姓名</th>";
	     	result += "<th name='l_zjhm' datatype='Integer' sumflag='0'>证件号码</th>";
	     	result += "<th name='l_sksj' datatype='Integer' sumflag='0'>刷卡时间</th>";
			result += "</tr></thead><tbody></tbody></table>";
			$("#tabledata").html(result);
	}
	
	function skjl_setList(pageno,url){	
		$("#"+skjl_divnid).html(skjl_tables);
		setParams("p_");
		if (url==null || url=="undefined"){
			url=skjl_pageUrl;
		}
		return url;
	}

</script>
</head>
<body>
<input type="hidden" id="p_cyrybh">
<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
		<tr>
        	<td class="queryfont">从业人员信息</td>
		</tr>
		<tr>
			<td class="tdbg">
				<div id="ickknxx"></div>
			</td>
		</tr>
    </table>
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">最近5条刷卡记录</td>
  </tr>
</table>

<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>
	       	<th name="l_qymc">刷卡场所</th>
	     	<th name="l_cyrybh">从业人员编号</th>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_zjhm">证件号码</th>
	     	<th name="l_sksj">刷卡时间</th>
	    </tr>
	  </thead>
	</table>	
</div>

</body>
</html>