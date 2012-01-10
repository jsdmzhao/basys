<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	daggleDiv(detailid);
		$("#a_czsj").attr("readonly","true");
		$("#a_czsj").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_ryxxczrzid","Integer",-9999999999,9999999999,null,0,"人员信息操作日志ID"))
			return false;
		if (!checkControlValue("a_czsj","Date",null,null,null,0,"操作时间"))
			return false;
		if (!checkControlValue("a_czlx","String",1,40,null,0,"操作类型"))
			return false;
		if (!checkControlValue("a_cznr","String",1,2000,null,0,"操作内容"))
			return false;
		if (!checkControlValue("a_czr","String",1,30,null,0,"操作人"))
			return false;
		if (!checkControlValue("a_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("a_cyrybh","String",1,20,null,0,"从业人员编号"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Ryxxczrz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">人员信息操作日志ID</td>
		<td class="detailtd"><input type="text" id="a_ryxxczrzid" value="0"></td>
		<td class="distd">操作时间</td>
		<td class="detailtd"><input type="text" id="a_czsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">操作类型</td>
		<td class="detailtd"><input type="text" id="a_czlx" value=""></td>
		<td class="distd">操作内容</td>
		<td class="detailtd"><input type="text" id="a_cznr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">操作人</td>
		<td class="detailtd"><input type="text" id="a_czr" value=""></td>
		<td class="distd">企业编码</td>
		<td class="detailtd"><input type="text" id="a_qybm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员编号</td>
		<td class="detailtd"><input type="text" id="a_cyrybh" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>