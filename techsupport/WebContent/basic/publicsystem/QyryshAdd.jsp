<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	daggleDiv(detailid);
		$("#a_shsj").attr("readonly","true");
		$("#a_shsj").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_ryshid","Integer",-9999999999,9999999999,null,0,"人员审核ID"))
			return false;
		if (!checkControlValue("a_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("a_ryid","Integer",-9999999999,9999999999,null,0,"从业人员ID"))
			return false;
		if (!checkControlValue("a_shsj","Date",null,null,null,0,"审核时间"))
			return false;
		if (!checkControlValue("a_shr","String",1,60,null,0,"审核人"))
			return false;
		if (!checkControlValue("a_shdwdm","String",1,20,null,0,"审核单位代码"))
			return false;
		if (!checkControlValue("a_shdwmc","String",1,60,null,0,"审核单位名称"))
			return false;
		if (!checkControlValue("a_shsbyy","String",1,2000,null,0,"审核失败原因"))
			return false;
		if (!checkControlValue("a_sjshid","Integer",-9999999999,9999999999,null,0,"上级审核ID"))
			return false;
		if (!checkControlValue("a_shzt","String",1,2,null,0,"审核状态"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Qyrysh_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">人员审核ID</td>
		<td class="detailtd"><input type="text" id="a_ryshid" value="0"></td>
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="a_qyid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员ID</td>
		<td class="detailtd"><input type="text" id="a_ryid" value="0"></td>
		<td class="distd">审核时间</td>
		<td class="detailtd"><input type="text" id="a_shsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">审核人</td>
		<td class="detailtd"><input type="text" id="a_shr" value=""></td>
		<td class="distd">审核单位代码</td>
		<td class="detailtd"><input type="text" id="a_shdwdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">审核单位名称</td>
		<td class="detailtd"><input type="text" id="a_shdwmc" value=""></td>
		<td class="distd">审核失败原因</td>
		<td class="detailtd"><input type="text" id="a_shsbyy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">上级审核ID</td>
		<td class="detailtd"><input type="text" id="a_sjshid" value="0"></td>
		<td class="distd">审核状态</td>
		<td class="detailtd"><input type="text" id="a_shzt" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>