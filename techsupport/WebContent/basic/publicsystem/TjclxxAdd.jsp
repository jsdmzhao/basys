<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	daggleDiv(detailid);
		$("#a_tijiaorq").attr("readonly","true");
		$("#a_tijiaorq").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_tjclxxid","Integer",-9999999999,9999999999,null,0,"提交材料信息ID"))
			return false;
		if (!checkControlValue("a_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("a_qybaxxid","Integer",-9999999999,9999999999,null,0,"企业备案信息ID"))
			return false;
		if (!checkControlValue("a_tjcllxdm","String",1,2,null,0,"提交材料类型代码"))
			return false;
		if (!checkControlValue("a_tjcllx","String",1,100,null,0,"提交材料类型"))
			return false;
		if (!checkControlValue("a_tijiaorq","Date",null,null,null,0,"提交日期"))
			return false;
		if (!checkControlValue("a_tjrxm","String",1,100,null,0,"提交人姓名"))
			return false;
		if (!checkControlValue("a_tjclnr","byte[]",,,,0,"提交材料内容"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Tjclxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">提交材料信息ID</td>
		<td class="detailtd"><input type="text" id="a_tjclxxid" value="0"></td>
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="a_qyid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">企业备案信息ID</td>
		<td class="detailtd"><input type="text" id="a_qybaxxid" value="0"></td>
		<td class="distd">提交材料类型代码</td>
		<td class="detailtd"><input type="text" id="a_tjcllxdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">提交材料类型</td>
		<td class="detailtd"><input type="text" id="a_tjcllx" value=""></td>
		<td class="distd">提交日期</td>
		<td class="detailtd"><input type="text" id="a_tijiaorq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">提交人姓名</td>
		<td class="detailtd"><input type="text" id="a_tjrxm" value=""></td>
		<td class="distd">提交材料内容</td>
		<td class="detailtd"><input type="text" id="a_tjclnr" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>