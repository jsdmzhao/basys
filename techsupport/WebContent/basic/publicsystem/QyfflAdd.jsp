<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	daggleDiv(detailid);
	}); 
	function addVerify(){
		if (!checkControlValue("a_qyflid","Integer",-9999999999,9999999999,null,0,"企业分类ID"))
			return false;
		if (!checkControlValue("a_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("a_qyflbm","String",1,4,null,0,"企业分类编码"))
			return false;
		if (!checkControlValue("a_sjcsflmc","String",1,200,null,0,"上级场所分类名称"))
			return false;
		if (!checkControlValue("a_qyflmc","String",1,300,null,0,"企业分类名称"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Qyffl_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">企业分类ID</td>
		<td class="detailtd"><input type="text" id="a_qyflid" value="0"></td>
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="a_qyid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">企业分类编码</td>
		<td class="detailtd"><input type="text" id="a_qyflbm" value=""></td>
		<td class="distd">上级场所分类名称</td>
		<td class="detailtd"><input type="text" id="a_sjcsflmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业分类名称</td>
		<td class="detailtd"><input type="text" id="a_qyflmc" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>