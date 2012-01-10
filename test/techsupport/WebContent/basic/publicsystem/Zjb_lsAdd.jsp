<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	daggleDiv(detailid);
		$("#a_qsrq").attr("readonly","true");
		$("#a_qsrq").datepicker();
		$("#a_jzrq").attr("readonly","true");
		$("#a_jzrq").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("a_qylsid","Integer",-9999999999,9999999999,null,0,"企业历史ID"))
			return false;
		if (!checkControlValue("a_zjlsid","Integer",-9999999999,9999999999,null,0,"证件历史ID"))
			return false;
		if (!checkControlValue("a_fk_zjid","Integer",-9999999999,9999999999,null,0,"证件ID"))
			return false;
		if (!checkControlValue("a_zjfl","String",1,40,null,0,"证件分类"))
			return false;
		if (!checkControlValue("a_zjbh","String",1,60,null,0,"证件编号"))
			return false;
		if (!checkControlValue("a_fzjg","String",1,60,null,0,"发证机关"))
			return false;
		if (!checkControlValue("a_qsrq","Date",null,null,null,0,"起始日期"))
			return false;
		if (!checkControlValue("a_jzrq","Date",null,null,null,0,"截止日期"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Zjb_ls_detail").hideAndRemove("show");' class="close"></a></td>
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
		<td class="distd">证件历史ID</td>
		<td class="detailtd"><input type="text" id="a_zjlsid" value="0"></td>
		<td class="distd">证件ID</td>
		<td class="detailtd"><input type="text" id="a_fk_zjid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">证件分类</td>
		<td class="detailtd"><input type="text" id="a_zjfl" value=""></td>
		<td class="distd">证件编号</td>
		<td class="detailtd"><input type="text" id="a_zjbh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发证机关</td>
		<td class="detailtd"><input type="text" id="a_fzjg" value=""></td>
		<td class="distd">起始日期</td>
		<td class="detailtd"><input type="text" id="a_qsrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">截止日期</td>
		<td class="detailtd"><input type="text" id="a_jzrq" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>