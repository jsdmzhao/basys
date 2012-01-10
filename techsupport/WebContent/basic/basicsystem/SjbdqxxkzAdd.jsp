<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_djrq").attr("readonly","true");
		$("#a_djrq").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("a_sjbdqxxkzid","Integer",-9999999999,9999999999,null,0,"手机被盗抢信息快照ID"))
			return false;
		if (!checkControlValue("a_xzqhbm","String",1,6,null,0,"行政区划编码"))
			return false;
		if (!checkControlValue("a_xzqh","String",1,100,null,0,"行政区划"))
			return false;
		if (!checkControlValue("a_sjch","String",1,30,null,0,"手机串号"))
			return false;
		if (!checkControlValue("a_pp","String",1,100,null,0,"品牌"))
			return false;
		if (!checkControlValue("a_xh","String",1,100,null,0,"型号"))
			return false;
		if (!checkControlValue("a_ys","String",1,60,null,0,"颜色"))
			return false;
		if (!checkControlValue("a_ajjbbm","String",1,2,null,0,"案件级别编码"))
			return false;
		if (!checkControlValue("a_ajjb","String",1,20,null,0,"案件级别"))
			return false;
		if (!checkControlValue("a_ajlbbm","String",1,30,null,0,"案件类别编码"))
			return false;
		if (!checkControlValue("a_ajlb","String",1,60,null,0,"案件类别"))
			return false;
		if (!checkControlValue("a_jyaq","String",1,2000,null,0,"简要案情"))
			return false;
		if (!checkControlValue("a_djrq","Date",null,null,null,0,"登记日期"))
			return false;
		if (!checkControlValue("a_djr","String",1,30,null,0,"登记人"))
			return false;
		if (!checkControlValue("a_ladqbm","String",1,6,null,0,"立案地区编码"))
			return false;
		if (!checkControlValue("a_ladq","String",1,300,null,0,"立案地区"))
			return false;
		if (!checkControlValue("a_badwbm","String",1,20,null,0,"办案单位编码"))
			return false;
		if (!checkControlValue("a_badw","String",1,100,null,0,"办案单位"))
			return false;
		if (!checkControlValue("a_tbr","String",1,100,null,0,"填表人"))
			return false;
		if (!checkControlValue("a_lxr","String",1,100,null,0,"联系人"))
			return false;
		if (!checkControlValue("a_lxfs","String",1,300,null,0,"联系方式"))
			return false;
		if (!checkControlValue("a_lxrsfhm","String",1,20,null,0,"联系人身份号码"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Sjbdqxxkz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">报警信息ID</td>
		<td class="detailtd"><input type="text" id="a_bjxxid2" value="0"></td>
		<td class="distd">手机被盗抢信息快照ID</td>
		<td class="detailtd"><input type="text" id="a_sjbdqxxkzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">行政区划编码</td>
		<td class="detailtd"><input type="text" id="a_xzqhbm" value=""></td>
		<td class="distd">行政区划</td>
		<td class="detailtd"><input type="text" id="a_xzqh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">手机串号</td>
		<td class="detailtd"><input type="text" id="a_sjch" value=""></td>
		<td class="distd">品牌</td>
		<td class="detailtd"><input type="text" id="a_pp" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">型号</td>
		<td class="detailtd"><input type="text" id="a_xh" value=""></td>
		<td class="distd">颜色</td>
		<td class="detailtd"><input type="text" id="a_ys" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">案件级别编码</td>
		<td class="detailtd"><input type="text" id="a_ajjbbm" value=""></td>
		<td class="distd">案件级别</td>
		<td class="detailtd"><input type="text" id="a_ajjb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">案件类别编码</td>
		<td class="detailtd"><input type="text" id="a_ajlbbm" value=""></td>
		<td class="distd">案件类别</td>
		<td class="detailtd"><input type="text" id="a_ajlb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">简要案情</td>
		<td class="detailtd"><input type="text" id="a_jyaq" value=""></td>
		<td class="distd">登记日期</td>
		<td class="detailtd"><input type="text" id="a_djrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">登记人</td>
		<td class="detailtd"><input type="text" id="a_djr" value=""></td>
		<td class="distd">立案地区编码</td>
		<td class="detailtd"><input type="text" id="a_ladqbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">立案地区</td>
		<td class="detailtd"><input type="text" id="a_ladq" value=""></td>
		<td class="distd">办案单位编码</td>
		<td class="detailtd"><input type="text" id="a_badwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">办案单位</td>
		<td class="detailtd"><input type="text" id="a_badw" value=""></td>
		<td class="distd">填表人</td>
		<td class="detailtd"><input type="text" id="a_tbr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">联系人</td>
		<td class="detailtd"><input type="text" id="a_lxr" value=""></td>
		<td class="distd">联系方式</td>
		<td class="detailtd"><input type="text" id="a_lxfs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">联系人身份号码</td>
		<td class="detailtd"><input type="text" id="a_lxrsfhm" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>