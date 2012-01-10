<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_tjrq").attr("readonly","true");
		$("#a_tjrq").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_qycftjid","Integer",-9999999999,9999999999,null,0,"企业处罚统计ID"))
			return false;
		if (!checkControlValue("a_hylbdm","String",1,2,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("a_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("a_tjrq","Date",null,null,null,0,"统计日期"))
			return false;
		if (!checkControlValue("a_dsjgdm","String",1,20,null,0,"地市机关代码"))
			return false;
		if (!checkControlValue("a_dsjgmc","String",1,60,null,0,"地市机关名称"))
			return false;
		if (!checkControlValue("a_fxjdm","String",1,20,null,0,"分县局代码"))
			return false;
		if (!checkControlValue("a_fxjmc","String",1,60,null,0,"分县局名称"))
			return false;
		if (!checkControlValue("a_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("a_gxdwdm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("a_csbm","String",1,20,null,0,"场所编码"))
			return false;
		if (!checkControlValue("a_csmc","String",1,120,null,0,"场所名称"))
			return false;
		if (!checkControlValue("a_jgcs","Integer",-999999,999999,null,0,"警告次数"))
			return false;
		if (!checkControlValue("a_fmcs","Integer",-999999,999999,null,0,"罚没次数"))
			return false;
		if (!checkControlValue("a_tdcs","Integer",-999999,999999,null,0,"停吊次数"))
			return false;
		if (!checkControlValue("a_zjcs","Integer",-999999,999999,null,0,"追究次数"))
			return false;
		if (!checkControlValue("a_qtfmcs","Integer",-999999,999999,null,0,"其他处罚次数"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Qycftj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">企业处罚统计ID</td>
		<td class="detailtd"><input type="text" id="a_qycftjid" value="0"></td>
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="a_hylbdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="a_hylb" value=""></td>
		<td class="distd">统计日期</td>
		<td class="detailtd"><input type="text" id="a_tjrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">地市机关代码</td>
		<td class="detailtd"><input type="text" id="a_dsjgdm" value=""></td>
		<td class="distd">地市机关名称</td>
		<td class="detailtd"><input type="text" id="a_dsjgmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">分县局代码</td>
		<td class="detailtd"><input type="text" id="a_fxjdm" value=""></td>
		<td class="distd">分县局名称</td>
		<td class="detailtd"><input type="text" id="a_fxjmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" id="a_gxdwmc" value=""></td>
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" id="a_gxdwdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">场所编码</td>
		<td class="detailtd"><input type="text" id="a_csbm" value=""></td>
		<td class="distd">场所名称</td>
		<td class="detailtd"><input type="text" id="a_csmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">警告次数</td>
		<td class="detailtd"><input type="text" id="a_jgcs" value="0"></td>
		<td class="distd">罚没次数</td>
		<td class="detailtd"><input type="text" id="a_fmcs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">停吊次数</td>
		<td class="detailtd"><input type="text" id="a_tdcs" value="0"></td>
		<td class="distd">追究次数</td>
		<td class="detailtd"><input type="text" id="a_zjcs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">其他处罚次数</td>
		<td class="detailtd"><input type="text" id="a_qtfmcs" value="0"></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>