<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	}); 
	function addVerify(){
		if (!checkControlValue("a_qyzlxxfjid","Integer",-9999999999,9999999999,null,0,"企业质量信息附件ID"))
			return false;
		if (!checkControlValue("a_qyzlxxid","Integer",-9999999999,9999999999,null,0,"企业质量信息ID"))
			return false;
		if (!checkControlValue("a_fjmc","String",1,100,null,0,"附件名称"))
			return false;
		if (!checkControlValue("a_fjlx","String",1,60,null,0,"附件类型"))
			return false;
		if (!checkControlValue("a_fjnr","byte[]",,,,0,"附件内容"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyzlxxfj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">企业质量信息附件ID</td>
		<td class="detailtd"><input type="text" id="a_qyzlxxfjid" class="inputstyle" value="0"></td>
		<td class="distd">企业质量信息ID</td>
		<td class="detailtd"><input type="text" id="a_qyzlxxid" class="inputstyle" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">附件名称</td>
		<td class="detailtd"><input type="text" id="a_fjmc" class="inputstyle" value=""></td>
		<td class="distd">附件类型</td>
		<td class="detailtd"><input type="text" id="a_fjlx" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">附件内容</td>
		<td class="detailtd"><input type="text" id="a_fjnr" class="inputstyle" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>