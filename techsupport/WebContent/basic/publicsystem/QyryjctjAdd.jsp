<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	daggleDiv(detailid);
		$("#a_tjrq").attr("readonly","true");
		$("#a_tjrq").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_qyryjctjid","Integer",-9999999999,9999999999,null,0,"企业人员奖惩统计ID"))
			return false;
		if (!checkControlValue("a_hylbdm","String",1,2,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("a_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("a_tjrq","Date",null,null,null,0,"统计日期"))
			return false;
		if (!checkControlValue("a_cyrybh","String",1,20,null,0,"从业人员编号"))
			return false;
		if (!checkControlValue("a_cyrylbdm","String",1,2,null,0,"从业人员类别代码"))
			return false;
		if (!checkControlValue("a_cyrylbmc","String",1,30,null,0,"从业人员类别名称"))
			return false;
		if (!checkControlValue("a_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("a_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("a_dsjgmc","String",1,60,null,0,"地市机关名称"))
			return false;
		if (!checkControlValue("a_fxjdm","String",1,20,null,0,"分县局代码"))
			return false;
		if (!checkControlValue("a_dsjgdm","String",1,20,null,0,"地市机关代码"))
			return false;
		if (!checkControlValue("a_fxjmc","String",1,60,null,0,"分县局名称"))
			return false;
		if (!checkControlValue("a_gxdwdm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("a_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("a_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("a_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("a_jg","Integer",-999999,999999,null,0,"警告"))
			return false;
		if (!checkControlValue("a_fk","Integer",-999999,999999,null,0,"罚款"))
			return false;
		if (!checkControlValue("a_jl","Integer",-999999,999999,null,0,"拘留"))
			return false;
		if (!checkControlValue("a_jlbfk","Integer",-999999,999999,null,0,"拘留并罚款"))
			return false;
		if (!checkControlValue("a_zjxszr","Integer",-999999,999999,null,0,"追究刑事责任"))
			return false;
		if (!checkControlValue("a_xqcjhqzcj","Integer",-999999,999999,null,0,"限期出境或驱逐出境"))
			return false;
		if (!checkControlValue("a_qtfklx","Integer",-999999,999999,null,0,"其他处罚类型"))
			return false;
		if (!checkControlValue("a_xj","Integer",-999999,999999,null,0,"小计"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Qyryjctj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">企业人员奖惩统计ID</td>
		<td class="detailtd"><input type="text" id="a_qyryjctjid" value="0"></td>
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
		<td class="distd">从业人员编号</td>
		<td class="detailtd"><input type="text" id="a_cyrybh" value=""></td>
		<td class="distd">从业人员类别代码</td>
		<td class="detailtd"><input type="text" id="a_cyrylbdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员类别名称</td>
		<td class="detailtd"><input type="text" id="a_cyrylbmc" value=""></td>
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" id="a_xm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">证件号码</td>
		<td class="detailtd"><input type="text" id="a_zjhm" value=""></td>
		<td class="distd">地市机关名称</td>
		<td class="detailtd"><input type="text" id="a_dsjgmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">分县局代码</td>
		<td class="detailtd"><input type="text" id="a_fxjdm" value=""></td>
		<td class="distd">地市机关代码</td>
		<td class="detailtd"><input type="text" id="a_dsjgdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">分县局名称</td>
		<td class="detailtd"><input type="text" id="a_fxjmc" value=""></td>
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" id="a_gxdwdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" id="a_gxdwmc" value=""></td>
		<td class="distd">企业名称</td>
		<td class="detailtd"><input type="text" id="a_qymc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业编码</td>
		<td class="detailtd"><input type="text" id="a_qybm" value=""></td>
		<td class="distd">警告</td>
		<td class="detailtd"><input type="text" id="a_jg" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">罚款</td>
		<td class="detailtd"><input type="text" id="a_fk" value="0"></td>
		<td class="distd">拘留</td>
		<td class="detailtd"><input type="text" id="a_jl" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">拘留并罚款</td>
		<td class="detailtd"><input type="text" id="a_jlbfk" value="0"></td>
		<td class="distd">追究刑事责任</td>
		<td class="detailtd"><input type="text" id="a_zjxszr" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">限期出境或驱逐出境</td>
		<td class="detailtd"><input type="text" id="a_xqcjhqzcj" value="0"></td>
		<td class="distd">其他处罚类型</td>
		<td class="detailtd"><input type="text" id="a_qtfklx" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">小计</td>
		<td class="detailtd"><input type="text" id="a_xj" value="0"></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>