<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	daggleDiv(detailid);
		$("#a_bbgzrq").attr("readonly","true");
		$("#a_bbgzrq").datepicker();
		$("#a_bbwcrq").attr("readonly","true");
		$("#a_bbwcrq").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("a_qybaxxid","Integer",-9999999999,9999999999,null,0,"企业备案信息ID"))
			return false;
		if (!checkControlValue("a_bbgzrq","Date",null,null,null,0,"补备告知日期"))
			return false;
		if (!checkControlValue("a_bbyy","String",1,2000,null,0,"补备原因"))
			return false;
		if (!checkControlValue("a_bbwcrq","Date",null,null,null,0,"补备完成日期"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Qybcbaxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="a_qyid" value="0"></td>
		<td class="distd">企业备案信息ID</td>
		<td class="detailtd"><input type="text" id="a_qybaxxid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">补备告知日期</td>
		<td class="detailtd"><input type="text" id="a_bbgzrq" value=""></td>
		<td class="distd">补备原因</td>
		<td class="detailtd"><input type="text" id="a_bbyy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">补备完成日期</td>
		<td class="detailtd"><input type="text" id="a_bbwcrq" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>