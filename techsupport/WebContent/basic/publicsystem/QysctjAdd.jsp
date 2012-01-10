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
		if (!checkControlValue("a_qysctjid","Integer",-9999999999,9999999999,null,0,"企业上传统计ID"))
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
		if (!checkControlValue("a_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("a_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("a_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("a_sfdb","Integer",-99,99,null,0,"是否达标"))
			return false;
		if (!checkControlValue("a_zrs","Integer",-999999,999999,null,0,"总人数"))
			return false;
		if (!checkControlValue("a_gzrs","Integer",-999999,999999,null,0,"工作人数"))
			return false;
		if (!checkControlValue("a_sskrs","Integer",-999999,999999,null,0,"实刷卡人数"))
			return false;
		if (!checkControlValue("a_zdskb","Float",-999.99,999.99,2,0,"最低刷卡比"))
			return false;
		if (!checkControlValue("a_ycskrs","Integer",-999999,999999,null,0,"一次刷卡人数"))
			return false;
		if (!checkControlValue("a_dcskrs","Integer",-999999,999999,null,0,"多次刷卡人数"))
			return false;
		if (!checkControlValue("a_bcsskrs","Integer",-999999,999999,null,0,"本场所刷卡人数"))
			return false;
		if (!checkControlValue("a_ztskrs","Integer",-999999,999999,null,0,"走台刷卡人数"))
			return false;
		if (!checkControlValue("a_zskb","Float",-999.99,999.99,2,0,"总刷卡比"))
			return false;
		if (!checkControlValue("a_ycskb","Float",-999.99,999.99,2,0,"一次刷卡率"))
			return false;
		if (!checkControlValue("a_dcskb","Float",-999.99,999.99,2,0,"多次刷卡率"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Qysctj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">企业上传统计ID</td>
		<td class="detailtd"><input type="text" id="a_qysctjid" value="0"></td>
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
		<td class="distd">企业编码</td>
		<td class="detailtd"><input type="text" id="a_qybm" value=""></td>
		<td class="distd">企业名称</td>
		<td class="detailtd"><input type="text" id="a_qymc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">联系电话</td>
		<td class="detailtd"><input type="text" id="a_lxdh" value=""></td>
		<td class="distd">是否达标</td>
		<td class="detailtd"><input type="text" id="a_sfdb" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">总人数</td>
		<td class="detailtd"><input type="text" id="a_zrs" value="0"></td>
		<td class="distd">工作人数</td>
		<td class="detailtd"><input type="text" id="a_gzrs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">实刷卡人数</td>
		<td class="detailtd"><input type="text" id="a_sskrs" value="0"></td>
		<td class="distd">最低刷卡比</td>
		<td class="detailtd"><input type="text" id="a_zdskb" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">一次刷卡人数</td>
		<td class="detailtd"><input type="text" id="a_ycskrs" value="0"></td>
		<td class="distd">多次刷卡人数</td>
		<td class="detailtd"><input type="text" id="a_dcskrs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">本场所刷卡人数</td>
		<td class="detailtd"><input type="text" id="a_bcsskrs" value="0"></td>
		<td class="distd">走台刷卡人数</td>
		<td class="detailtd"><input type="text" id="a_ztskrs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">总刷卡比</td>
		<td class="detailtd"><input type="text" id="a_zskb" value="0"></td>
		<td class="distd">一次刷卡率</td>
		<td class="detailtd"><input type="text" id="a_ycskb" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">多次刷卡率</td>
		<td class="detailtd"><input type="text" id="a_dcskb" value="0"></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>