<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qyid").attr("value",dataid);
		$("#m_qyid").attr("value",dataid);
		setDetail();
		$("#m_qsrq").attr("readonly","true");
		$("#m_qsrq").datepicker();
		$("#m_jzrq").attr("readonly","true");
		$("#m_jzrq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_qyid").attr("value",setNull(json.LZjb_ls[0].qyid));
		$("#m_qylsid").attr("value",setNull(json.LZjb_ls[0].qylsid));
		$("#m_zjlsid").attr("value",setNull(json.LZjb_ls[0].zjlsid));
		$("#m_fk_zjid").attr("value",setNull(json.LZjb_ls[0].fk_zjid));
		$("#m_zjfl").attr("value",setNull(json.LZjb_ls[0].zjfl));
		$("#m_zjbh").attr("value",setNull(json.LZjb_ls[0].zjbh));
		$("#m_fzjg").attr("value",setNull(json.LZjb_ls[0].fzjg));
		$("#m_qsrq").attr("value",setNull(json.LZjb_ls[0].qsrq));
		$("#m_jzrq").attr("value",setNull(json.LZjb_ls[0].jzrq));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("m_qylsid","Integer",-9999999999,9999999999,null,0,"企业历史ID"))
			return false;
		if (!checkControlValue("m_zjlsid","Integer",-9999999999,9999999999,null,0,"证件历史ID"))
			return false;
		if (!checkControlValue("m_fk_zjid","Integer",-9999999999,9999999999,null,0,"证件ID"))
			return false;
		if (!checkControlValue("m_zjfl","String",1,40,null,0,"证件分类"))
			return false;
		if (!checkControlValue("m_zjbh","String",1,60,null,0,"证件编号"))
			return false;
		if (!checkControlValue("m_fzjg","String",1,60,null,0,"发证机关"))
			return false;
		if (!checkControlValue("m_qsrq","Date",null,null,null,0,"起始日期"))
			return false;
		if (!checkControlValue("m_jzrq","Date",null,null,null,0,"截止日期"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qyid">
<input type="hidden" id="m_qyid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Zjb_ls_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="m_qyid" value="0"></td>
		<td class="distd">企业历史ID</td>
		<td class="detailtd"><input type="text" id="m_qylsid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">证件历史ID</td>
		<td class="detailtd"><input type="text" id="m_zjlsid" value="0"></td>
		<td class="distd">证件ID</td>
		<td class="detailtd"><input type="text" id="m_fk_zjid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">证件分类</td>
		<td class="detailtd"><input type="text" id="m_zjfl" value=""></td>
		<td class="distd">证件编号</td>
		<td class="detailtd"><input type="text" id="m_zjbh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发证机关</td>
		<td class="detailtd"><input type="text" id="m_fzjg" value=""></td>
		<td class="distd">起始日期</td>
		<td class="detailtd"><input type="text" id="m_qsrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">截止日期</td>
		<td class="detailtd"><input type="text" id="m_jzrq" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
