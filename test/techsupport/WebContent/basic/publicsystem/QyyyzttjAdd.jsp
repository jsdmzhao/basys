<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_tjrq").attr("readonly","true");
		$("#a_tjrq").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_qyyyzttjid","Integer",-9999999999,9999999999,null,0,"企业营业状态统计ID"))
			return false;
		if (!checkControlValue("a_tjrq","Date",null,null,null,0,"统计日期"))
			return false;
		if (!checkControlValue("a_hylbdm","String",1,3,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("a_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("a_dsjgdm","String",1,20,null,0,"地市机关代码"))
			return false;
		if (!checkControlValue("a_dsjgmc","String",1,60,null,0,"地市机关名称"))
			return false;
		if (!checkControlValue("a_fxjdm","String",1,20,null,0,"分县局代码"))
			return false;
		if (!checkControlValue("a_fxjmc","String",1,60,null,0,"分县局名称"))
			return false;
		if (!checkControlValue("a_gxdwdm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("a_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("a_yy","Integer",-999999,999999,null,0,"营业"))
			return false;
		if (!checkControlValue("a_zzty","Integer",-999999,999999,null,0,"自主停业"))
			return false;
		if (!checkControlValue("a_llty","Integer",-999999,999999,null,0,"勒令停业"))
			return false;
		if (!checkControlValue("a_xy","Integer",-999999,999999,null,0,"歇业"))
			return false;
		if (!checkControlValue("a_zx","Integer",-999999,999999,null,0,"注销"))
			return false;
		if (!checkControlValue("a_qt","Integer",-999999,999999,null,0,"其他"))
			return false;
		if (!checkControlValue("a_hj","Integer",-999999,999999,null,0,"合计"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyyyzttj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">企业营业状态统计ID</td>
		<td class="detailtd"><input type="text" id="a_qyyyzttjid" class="inputstyle" value="0"></td>
		<td class="distd">统计日期</td>
		<td class="detailtd"><input type="text" id="a_tjrq" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="a_hylbdm" class="inputstyle" value=""></td>
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="a_hylb" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">地市机关代码</td>
		<td class="detailtd"><input type="text" id="a_dsjgdm" class="inputstyle" value=""></td>
		<td class="distd">地市机关名称</td>
		<td class="detailtd"><input type="text" id="a_dsjgmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">分县局代码</td>
		<td class="detailtd"><input type="text" id="a_fxjdm" class="inputstyle" value=""></td>
		<td class="distd">分县局名称</td>
		<td class="detailtd"><input type="text" id="a_fxjmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" id="a_gxdwdm" class="inputstyle" value=""></td>
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" id="a_gxdwmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">营业</td>
		<td class="detailtd"><input type="text" id="a_yy" class="inputstyle" value="0"></td>
		<td class="distd">自主停业</td>
		<td class="detailtd"><input type="text" id="a_zzty" class="inputstyle" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">勒令停业</td>
		<td class="detailtd"><input type="text" id="a_llty" class="inputstyle" value="0"></td>
		<td class="distd">歇业</td>
		<td class="detailtd"><input type="text" id="a_xy" class="inputstyle" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">注销</td>
		<td class="detailtd"><input type="text" id="a_zx" class="inputstyle" value="0"></td>
		<td class="distd">其他</td>
		<td class="detailtd"><input type="text" id="a_qt" class="inputstyle" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">合计</td>
		<td class="detailtd"><input type="text" id="a_hj" class="inputstyle" value="0"></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>