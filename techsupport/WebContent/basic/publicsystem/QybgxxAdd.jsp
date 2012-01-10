<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_bgrq").attr("readonly","true");
		$("#a_bgrq").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("a_qylsid","Integer",-9999999999,9999999999,null,0,"企业历史ID"))
			return false;
		if (!checkControlValue("a_qybgxxid","Integer",-9999999999,9999999999,null,0,"企业变更信息ID"))
			return false;
		if (!checkControlValue("a_bgdjxh","String",1,30,null,0,"变更登记序号"))
			return false;
		if (!checkControlValue("a_bglxdm","String",1,2,null,0,"变更类型代码"))
			return false;
		if (!checkControlValue("a_bglx","String",1,30,null,0,"变更类型"))
			return false;
		if (!checkControlValue("a_bgrq","Date",null,null,null,0,"变更日期"))
			return false;
		if (!checkControlValue("a_bgyy","String",1,2000,null,0,"变更原因"))
			return false;
		if (!checkControlValue("a_bgqnr","String",1,300,null,0,"变更前内容"))
			return false;
		if (!checkControlValue("a_bghnr","String",1,300,null,0,"变更后内容"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qybgxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="a_qyid" value="0"></td>
		<td class="distd">企业历史ID</td>
		<td class="detailtd"><input type="text" id="a_qylsid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">企业变更信息ID</td>
		<td class="detailtd"><input type="text" id="a_qybgxxid" value="0"></td>
		<td class="distd">变更登记序号</td>
		<td class="detailtd"><input type="text" id="a_bgdjxh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">变更类型代码</td>
		<td class="detailtd"><input type="text" id="a_bglxdm" value=""></td>
		<td class="distd">变更类型</td>
		<td class="detailtd"><input type="text" id="a_bglx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">变更日期</td>
		<td class="detailtd"><input type="text" id="a_bgrq" value=""></td>
		<td class="distd">变更原因</td>
		<td class="detailtd"><input type="text" id="a_bgyy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">变更前内容</td>
		<td class="detailtd"><input type="text" id="a_bgqnr" value=""></td>
		<td class="distd">变更后内容</td>
		<td class="detailtd"><input type="text" id="a_bghnr" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>