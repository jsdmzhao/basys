<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String wlpc = (String)request.getParameter("WLPC");
%>
<html>
<head>
<title>物流信息打印</title>
<style media="print">
	.noprint {display:none}
</style>
<style media="all"></style>
<style type="text/css">
	tr{height:20;}
</style>
<style>
	P{page-break-after:always}
</style>
<script type="text/javascript" src="<%=basePath %>javascript/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>javascript/htmlConfig.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		var wlpc = '<%=wlpc %>';
		$("#t_wlpc").attr("value",wlpc);
		setParams("t_");
		jQuery.post('<%=basePath %>icksystem/printMessage_wldj.action',params,printMessageLastBack,"json")
	});
	function printMessageLastBack(json){ //物流打印信息
		var content = "";
		var pageSize = 14; //一个打印页 多少 条记录
		var tableNum = 0;
		var endRows = 0;
		for(var csIndex=0,csmax=json.LWldj.length;csIndex<csmax;csIndex++){
			tableNum = Math.ceil(json.LWldj[csIndex].length/pageSize);
			for(var tableIndex=0;tableIndex<tableNum;tableIndex++){ //一个场所有多个table
				endRows = (tableIndex==(tableNum-1))?(json.LWldj[csIndex].length):((tableIndex+1)*pageSize);
				content += "<P>"
				content += "<table border='1' bordercolordark='#FFFFFF' bordercolorlight='#cccccc' width='98%' cellpadding='0' cellspacing='0'>";
				content += "<caption style='height:25px;text-align:center; font:11pt;'>"+json.LWldj[csIndex][0].qymc+"</caption>";
				content += "<tr>";
				content += "<th bgcolor='#f0f0f0' height='25' width='5%'>序号</th>";
				content += "<th bgcolor='#f0f0f0' width='24%'>从业人员编号</th>";
				content += "<th bgcolor='#f0f0f0' width='10%'>姓名</th>";
				content += "<th bgcolor='#f0f0f0' width='19%'>证件号码</th>";
				content += "<th bgcolor='#f0f0f0' width='13%'>受理时间</th>";
				content += "<th bgcolor='#f0f0f0' width='9%'>签名</th>";
				content += "</tr>";
				for(var ickIndex=tableIndex*pageSize;ickIndex<endRows;ickIndex++){
					content += "<tr>";
					content += "<td height='20'>"+(ickIndex+1)+"</th>";
					content += "<td>"+setPrintNull(json.LWldj[csIndex][ickIndex].cyrybh)+"</td>";
					content += "<td>"+setPrintNull(json.LWldj[csIndex][ickIndex].xm)+"</td>";
					content += "<td>"+setPrintNull(json.LWldj[csIndex][ickIndex].zjhm)+"</td>";
					content += "<td>"+setPrintNull(json.LWldj[csIndex][ickIndex].slsj)+"</td>";
					content += "<td>&nbsp;</td>";
					content += "</tr>";
				}
				content += "<caption valign='bottom' style='height:25px;text-align:center; font:10pt;'>本场所，第"+(tableIndex+1)+"页/共"+tableNum+"页</caption>";
				content += "</table>";
				content += "</P>";
			}
		}
		$("#printContentLast").append(content);
	}
	function setPrintNull(sValue){
		if (sValue==null){
			sValue="";
		}else{
			var patrn = /^(\d{4})\-(\d{2})\-(\d{2})T(\d{2}):(\d{2}):(\d{2})$/;
			if (patrn.test(sValue)){
				sValue = sValue.replace('T',' ');
			}
		}
		if(sValue==''){
			sValue="&nbsp;";
		}
		return sValue;
	}
</script>

<body topMargin="20" leftMargin="10" rightMargin="10" bottomMargin="10">
<input type="hidden" id="t_wlpc"/>

<div id="printContentLast"></div>

</body>
</html>
