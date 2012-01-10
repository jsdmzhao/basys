<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjxxid2").attr("value",dataid);
		$("#m_bjxxid2").attr("value",dataid);
		setDetail();
		$("#m_djrq").attr("readonly","true");
		$("#m_djrq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_bjxxid2").attr("value",setNull(json.LSjbdqxxkz[0].bjxxid2));
		$("#m_sjbdqxxkzid").attr("value",setNull(json.LSjbdqxxkz[0].sjbdqxxkzid));
		$("#m_xzqhbm").attr("value",setNull(json.LSjbdqxxkz[0].xzqhbm));
		$("#m_xzqh").attr("value",setNull(json.LSjbdqxxkz[0].xzqh));
		$("#m_sjch").attr("value",setNull(json.LSjbdqxxkz[0].sjch));
		$("#m_pp").attr("value",setNull(json.LSjbdqxxkz[0].pp));
		$("#m_xh").attr("value",setNull(json.LSjbdqxxkz[0].xh));
		$("#m_ys").attr("value",setNull(json.LSjbdqxxkz[0].ys));
		$("#m_ajjbbm").attr("value",setNull(json.LSjbdqxxkz[0].ajjbbm));
		$("#m_ajjb").attr("value",setNull(json.LSjbdqxxkz[0].ajjb));
		$("#m_ajlbbm").attr("value",setNull(json.LSjbdqxxkz[0].ajlbbm));
		$("#m_ajlb").attr("value",setNull(json.LSjbdqxxkz[0].ajlb));
		$("#m_jyaq").attr("value",setNull(json.LSjbdqxxkz[0].jyaq));
		$("#m_djrq").attr("value",setNull(json.LSjbdqxxkz[0].djrq));
		$("#m_djr").attr("value",setNull(json.LSjbdqxxkz[0].djr));
		$("#m_ladqbm").attr("value",setNull(json.LSjbdqxxkz[0].ladqbm));
		$("#m_ladq").attr("value",setNull(json.LSjbdqxxkz[0].ladq));
		$("#m_badwbm").attr("value",setNull(json.LSjbdqxxkz[0].badwbm));
		$("#m_badw").attr("value",setNull(json.LSjbdqxxkz[0].badw));
		$("#m_tbr").attr("value",setNull(json.LSjbdqxxkz[0].tbr));
		$("#m_lxr").attr("value",setNull(json.LSjbdqxxkz[0].lxr));
		$("#m_lxfs").attr("value",setNull(json.LSjbdqxxkz[0].lxfs));
		$("#m_lxrsfhm").attr("value",setNull(json.LSjbdqxxkz[0].lxrsfhm));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("m_sjbdqxxkzid","Integer",-9999999999,9999999999,null,0,"手机被盗抢信息快照ID"))
			return false;
		if (!checkControlValue("m_xzqhbm","String",1,6,null,0,"行政区划编码"))
			return false;
		if (!checkControlValue("m_xzqh","String",1,100,null,0,"行政区划"))
			return false;
		if (!checkControlValue("m_sjch","String",1,30,null,0,"手机串号"))
			return false;
		if (!checkControlValue("m_pp","String",1,100,null,0,"品牌"))
			return false;
		if (!checkControlValue("m_xh","String",1,100,null,0,"型号"))
			return false;
		if (!checkControlValue("m_ys","String",1,60,null,0,"颜色"))
			return false;
		if (!checkControlValue("m_ajjbbm","String",1,2,null,0,"案件级别编码"))
			return false;
		if (!checkControlValue("m_ajjb","String",1,20,null,0,"案件级别"))
			return false;
		if (!checkControlValue("m_ajlbbm","String",1,30,null,0,"案件类别编码"))
			return false;
		if (!checkControlValue("m_ajlb","String",1,60,null,0,"案件类别"))
			return false;
		if (!checkControlValue("m_jyaq","String",1,2000,null,0,"简要案情"))
			return false;
		if (!checkControlValue("m_djrq","Date",null,null,null,0,"登记日期"))
			return false;
		if (!checkControlValue("m_djr","String",1,30,null,0,"登记人"))
			return false;
		if (!checkControlValue("m_ladqbm","String",1,6,null,0,"立案地区编码"))
			return false;
		if (!checkControlValue("m_ladq","String",1,300,null,0,"立案地区"))
			return false;
		if (!checkControlValue("m_badwbm","String",1,20,null,0,"办案单位编码"))
			return false;
		if (!checkControlValue("m_badw","String",1,100,null,0,"办案单位"))
			return false;
		if (!checkControlValue("m_tbr","String",1,100,null,0,"填表人"))
			return false;
		if (!checkControlValue("m_lxr","String",1,100,null,0,"联系人"))
			return false;
		if (!checkControlValue("m_lxfs","String",1,300,null,0,"联系方式"))
			return false;
		if (!checkControlValue("m_lxrsfhm","String",1,20,null,0,"联系人身份号码"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_bjxxid2">
<input type="hidden" id="m_bjxxid2">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Sjbdqxxkz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">报警信息ID</td>
		<td class="detailtd"><input type="text" id="m_bjxxid2" value="0"></td>
		<td class="distd">手机被盗抢信息快照ID</td>
		<td class="detailtd"><input type="text" id="m_sjbdqxxkzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">行政区划编码</td>
		<td class="detailtd"><input type="text" id="m_xzqhbm" value=""></td>
		<td class="distd">行政区划</td>
		<td class="detailtd"><input type="text" id="m_xzqh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">手机串号</td>
		<td class="detailtd"><input type="text" id="m_sjch" value=""></td>
		<td class="distd">品牌</td>
		<td class="detailtd"><input type="text" id="m_pp" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">型号</td>
		<td class="detailtd"><input type="text" id="m_xh" value=""></td>
		<td class="distd">颜色</td>
		<td class="detailtd"><input type="text" id="m_ys" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">案件级别编码</td>
		<td class="detailtd"><input type="text" id="m_ajjbbm" value=""></td>
		<td class="distd">案件级别</td>
		<td class="detailtd"><input type="text" id="m_ajjb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">案件类别编码</td>
		<td class="detailtd"><input type="text" id="m_ajlbbm" value=""></td>
		<td class="distd">案件类别</td>
		<td class="detailtd"><input type="text" id="m_ajlb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">简要案情</td>
		<td class="detailtd"><input type="text" id="m_jyaq" value=""></td>
		<td class="distd">登记日期</td>
		<td class="detailtd"><input type="text" id="m_djrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">登记人</td>
		<td class="detailtd"><input type="text" id="m_djr" value=""></td>
		<td class="distd">立案地区编码</td>
		<td class="detailtd"><input type="text" id="m_ladqbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">立案地区</td>
		<td class="detailtd"><input type="text" id="m_ladq" value=""></td>
		<td class="distd">办案单位编码</td>
		<td class="detailtd"><input type="text" id="m_badwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">办案单位</td>
		<td class="detailtd"><input type="text" id="m_badw" value=""></td>
		<td class="distd">填表人</td>
		<td class="detailtd"><input type="text" id="m_tbr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">联系人</td>
		<td class="detailtd"><input type="text" id="m_lxr" value=""></td>
		<td class="distd">联系方式</td>
		<td class="detailtd"><input type="text" id="m_lxfs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">联系人身份号码</td>
		<td class="detailtd"><input type="text" id="m_lxrsfhm" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
