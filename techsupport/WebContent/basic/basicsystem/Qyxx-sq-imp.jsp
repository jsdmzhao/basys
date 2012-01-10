<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.common.QjblUtil"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
	String qysjlyyScpt = QjblUtil.queryQjblVal("qysjlyyScpt"); //企业数据来源于社采平台
	String tishiMes = "";
	if("1".equals(qysjlyyScpt)){
		tishiMes = "<font color='green'>目前状态系统只会导入授权信息，不会导入企业信息。</font>";
	} else {
		tishiMes = "<font color='green'>系统在导入授权信息的同时会自动导入企业信息。</font>";
	}
%>
<html>
<head>
<script type="text/javascript">
	var ylcsjbxx_dataid="";
	var ylcsjbxx_tables = "";
	var ylcsjbxx_pageUrl="ylfwzagl/querylistTijiao_ylcsjbxx.action";
	var ylcsjbxx_divnid="tabledata";
	var ylcsjbxx_tableid="table1";
	var ylcsjbxx_detailHtml="business/Ylfwzagl/YlcsjbxxDetail.jsp";
	var ylcsjbxx_detailid="ylcsjbxx_detail";
	var ylcsjbxx_detailUrl="ylfwzagl/query_ylcsjbxx.action";
	var ylcsjbxx_detailWidth=990;
	
	$(document).ready(function() {
		$("#rizhi").hide();
	});
	var tijiaoKg = 0;
	var qyxxio_upload="basicsystem/uploadQyxxXml_expimp.action";
	function qyxxtijiao(){
		if (qyxxUploadVerify()&&tijiaoKg==0){
			jConfirm('提交过程中可能需要一些时间，请耐心等待', '提示', function(r) {
		    	if(r==true){
		    		jAlert("正在提交数据,请耐心等待","提示");
		    		tijiaoKg = 1;
					setParams("a_");
					jQuery.ajax({
						type: 'POST',
						url: qyxxio_upload,
						data: params,
						async: true,
						dataType: 'json',
						success: function(result){
							var rows  = eval(result);
							qyxxtijiao_addback(rows);
						}
					});
			    }else{
				   return false;
				}
			});
		}
	}
	function qyxxtijiao_addback(json){
		tijiaoKg = 0;
		if  (json.result=="success"){
			isPlayChengGong = true;
			jAlert('上传成功','提示信息');
		} else {
			playExpLog();
			jAlert("请保存并查看日志详细信息",'提示信息');
		}
		$("#sqwj").attr("value","");
		$("#a_sqwjCon").attr("value","");
	}
	function qyxxUploadVerify(){
		var sqwj = $("#sqwj").attr("value");
		if(sqwj==null||sqwj==''||sqwj=='null'){
			jAlert('请选择文件','提示信息');
			return false;
		}
		return true;
	}
	
	function openfile(){
		if(tijiaoKg==0){
			ImgerToBase1.SetFileSizeA(1600);
			ImgerToBase1.OpenFile();
			var fileName = ImgerToBase1.getFileName();
			if(fileName!='') ImgerToBase();
		}
	}
	function ImgerToBase(){
		//设置打开图片的大小
		ImgerToBase1.SetFileSize= 1600;
		//文件名称 eg: snow.jpeg
		//var fileName = ImgerToBase1.getFileName();
		//文件路径 包括文件名称
		var filePath = ImgerToBase1.getFile();
		//BASE64编码
		var base64code = ImgerToBase1.getBase64();
		var fileName = ImgerToBase1.getFileName();
		if(fileName==null||fileName==''||fileName=='null'){
			$("#sqwj").attr("value","");
		} else {
			if(valFileName(fileName)){
				$("#sqwj").attr("value",filePath);
				$("#a_sqwjCon").attr("value",base64code);
			}
		}
	}
	function valFileName(fileName){
		var len = fileName.length;
		var oneVal = fileName.indexOf(".xml");
		var twoVal = fileName.indexOf(".XML");
		if(oneVal==-1&&twoVal==-1){
			jAlert('请正确选择文件','提示信息');
			return false;
		} else if ((len-oneVal)==4||(len-twoVal)==4) {
			return true;
		} else {
			jAlert('请正确选择文件','提示信息');
			return false;
		}
	}
	function playExpLog(){
		var expxml = "basicsystem/resExpLogTxt_expimp.action";
		document.forms[0].action=expxml;
		document.forms[0].submit();
	}
</script>

</head>
<body>
<input type="hidden" id="a_sqwjCon" value="">

<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
	<tr><td class="queryfont">授权文件上传</td></tr>
	<tr>
    <td class="tdbg" colspan="2">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
			<tr>
			<td class="pagedistd">授权文件</td>
			<td width="20%" class="pagetd">
			<input type="text" class="inputstyle" id="sqwj" style="width:410;" readonly></td>
			<td>
				<table width="125" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="选图片" 
							onclick='openfile();'>选文件</a></td>
					<td><a href="#" class="submitbutton" id="alldc" onclick='qyxxtijiao();'>提交</a></td>
				</tr>
				</table>
			</td>
			<td><%=tishiMes %></td>
		</tr>
    	</table>
    </td>
	</tr>
</table>	
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<%
	String wjjName = request.getRealPath("qyrzxxTemp");
%>
<%@include file="../../public/includeImgerToBase64.jsp" %>
<form method="POST">
</form>
</body>
</html>