<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_garkktbsjid").attr("value",dataid);
		$("#m_garkktbsjid").attr("value",dataid);
		setDetail();
		$("#m_bdsj").attr("readonly","true");
		$("#m_bdsj").datepicker();
		$("#m_hcsj").attr("readonly","true");
		$("#m_hcsj").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_garkktbsjid").attr("value",setNull(json.LQyryxxhc[0].garkktbsjid));
		$("#m_qyid").attr("value",setNull(json.LQyryxxhc[0].qyid));
		$("#m_ryid").attr("value",setNull(json.LQyryxxhc[0].ryid));
		$("#m_hcid").attr("value",setNull(json.LQyryxxhc[0].hcid));
		$("#m_dsjgdm").attr("value",setNull(json.LQyryxxhc[0].dsjgdm));
		$("#m_dsjgmc").attr("value",setNull(json.LQyryxxhc[0].dsjgmc));
		$("#m_fxjdm").attr("value",setNull(json.LQyryxxhc[0].fxjdm));
		$("#m_fxjmc").attr("value",setNull(json.LQyryxxhc[0].fxjmc));
		$("#m_gxdwdm").attr("value",setNull(json.LQyryxxhc[0].gxdwdm));
		$("#m_gxdwmc").attr("value",setNull(json.LQyryxxhc[0].gxdwmc));
		$("#m_qybm").attr("value",setNull(json.LQyryxxhc[0].qybm));
		$("#m_qymc").attr("value",setNull(json.LQyryxxhc[0].qymc));
		$("#m_xm").attr("value",setNull(json.LQyryxxhc[0].xm));
		$("#m_xbdm").attr("value",setNull(json.LQyryxxhc[0].xbdm));
		$("#m_xb").attr("value",setNull(json.LQyryxxhc[0].xb));
		$("#m_ywm").attr("value",setNull(json.LQyryxxhc[0].ywm));
		$("#m_ywx").attr("value",setNull(json.LQyryxxhc[0].ywx));
		$("#m_wgrjyxkz").attr("value",setNull(json.LQyryxxhc[0].wgrjyxkz));
		$("#m_cyzjdm").attr("value",setNull(json.LQyryxxhc[0].cyzjdm));
		$("#m_cyzj").attr("value",setNull(json.LQyryxxhc[0].cyzj));
		$("#m_zjhm").attr("value",setNull(json.LQyryxxhc[0].zjhm));
		$("#m_gwbh").attr("value",setNull(json.LQyryxxhc[0].gwbh));
		$("#m_gemc").attr("value",setNull(json.LQyryxxhc[0].gemc));
		$("#m_xmpy").attr("value",setNull(json.LQyryxxhc[0].xmpy));
		$("#m_bdsj").attr("value",setNull(json.LQyryxxhc[0].bdsj));
		$("#m_hcsj").attr("value",setNull(json.LQyryxxhc[0].hcsj));
		$("#m_hcwt").attr("value",setNull(json.LQyryxxhc[0].hcwt));
		$("#m_hcyj").attr("value",setNull(json.LQyryxxhc[0].hcyj));
		$("#m_hcr").attr("value",setNull(json.LQyryxxhc[0].hcr));
		$("#m_hcdw").attr("value",setNull(json.LQyryxxhc[0].hcdw));
		$("#m_hcdwdm").attr("value",setNull(json.LQyryxxhc[0].hcdwdm));
		$("#m_hczt").attr("value",setNull(json.LQyryxxhc[0].hczt));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_garkktbsjid","Integer",-9999999999,9999999999,null,0,"公安人口库同步数据ID"))
			return false;
		if (!checkControlValue("m_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("m_ryid","Integer",-9999999999,9999999999,null,0,"从业人员ID"))
			return false;
		if (!checkControlValue("m_hcid","Integer",-9999999999,9999999999,null,0,"核查ID"))
			return false;
		if (!checkControlValue("m_dsjgdm","String",1,20,null,0,"地市机关代码"))
			return false;
		if (!checkControlValue("m_dsjgmc","String",1,60,null,0,"地市机关名称"))
			return false;
		if (!checkControlValue("m_fxjdm","String",1,20,null,0,"分县局代码"))
			return false;
		if (!checkControlValue("m_fxjmc","String",1,60,null,0,"分县局名称"))
			return false;
		if (!checkControlValue("m_gxdwdm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("m_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("m_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("m_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("m_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("m_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("m_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("m_ywm","String",1,60,null,0,"英文名"))
			return false;
		if (!checkControlValue("m_ywx","String",1,60,null,0,"英文姓"))
			return false;
		if (!checkControlValue("m_wgrjyxkz","String",1,60,null,0,"外国人就业许可证号"))
			return false;
		if (!checkControlValue("m_cyzjdm","String",1,40,null,0,"常用证件代码"))
			return false;
		if (!checkControlValue("m_cyzj","String",1,100,null,0,"常用证件"))
			return false;
		if (!checkControlValue("m_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("m_gwbh","String",1,4,null,0,"岗位编号"))
			return false;
		if (!checkControlValue("m_gemc","String",1,60,null,0,"岗位名称"))
			return false;
		if (!checkControlValue("m_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("m_bdsj","Date",null,null,null,0,"比对时间"))
			return false;
		if (!checkControlValue("m_hcsj","Date",null,null,null,0,"核查时间"))
			return false;
		if (!checkControlValue("m_hcwt","String",1,100,null,0,"核查问题"))
			return false;
		if (!checkControlValue("m_hcyj","String",1,300,null,0,"核查意见"))
			return false;
		if (!checkControlValue("m_hcr","String",1,30,null,0,"核查人"))
			return false;
		if (!checkControlValue("m_hcdw","String",1,100,null,0,"核查单位"))
			return false;
		if (!checkControlValue("m_hcdwdm","String",1,30,null,0,"核查单位代码"))
			return false;
		if (!checkControlValue("m_hczt","String",1,100,null,0,"核查状态"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_garkktbsjid">
<input type="hidden" id="m_garkktbsjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Qyryxxhc_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">公安人口库同步数据ID</td>
		<td class="detailtd"><input type="text" id="m_garkktbsjid" value="0"></td>
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="m_qyid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员ID</td>
		<td class="detailtd"><input type="text" id="m_ryid" value="0"></td>
		<td class="distd">核查ID</td>
		<td class="detailtd"><input type="text" id="m_hcid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">地市机关代码</td>
		<td class="detailtd"><input type="text" id="m_dsjgdm" value=""></td>
		<td class="distd">地市机关名称</td>
		<td class="detailtd"><input type="text" id="m_dsjgmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">分县局代码</td>
		<td class="detailtd"><input type="text" id="m_fxjdm" value=""></td>
		<td class="distd">分县局名称</td>
		<td class="detailtd"><input type="text" id="m_fxjmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" id="m_gxdwdm" value=""></td>
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" id="m_gxdwmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业编码</td>
		<td class="detailtd"><input type="text" id="m_qybm" value=""></td>
		<td class="distd">企业名称</td>
		<td class="detailtd"><input type="text" id="m_qymc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" id="m_xm" value=""></td>
		<td class="distd">性别代码</td>
		<td class="detailtd"><input type="text" id="m_xbdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" id="m_xb" value=""></td>
		<td class="distd">英文名</td>
		<td class="detailtd"><input type="text" id="m_ywm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">英文姓</td>
		<td class="detailtd"><input type="text" id="m_ywx" value=""></td>
		<td class="distd">外国人就业许可证号</td>
		<td class="detailtd"><input type="text" id="m_wgrjyxkz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">常用证件代码</td>
		<td class="detailtd"><input type="text" id="m_cyzjdm" value=""></td>
		<td class="distd">常用证件</td>
		<td class="detailtd"><input type="text" id="m_cyzj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">证件号码</td>
		<td class="detailtd"><input type="text" id="m_zjhm" value=""></td>
		<td class="distd">岗位编号</td>
		<td class="detailtd"><input type="text" id="m_gwbh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">岗位名称</td>
		<td class="detailtd"><input type="text" id="m_gemc" value=""></td>
		<td class="distd">姓名拼音</td>
		<td class="detailtd"><input type="text" id="m_xmpy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">比对时间</td>
		<td class="detailtd"><input type="text" id="m_bdsj" value=""></td>
		<td class="distd">核查时间</td>
		<td class="detailtd"><input type="text" id="m_hcsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">核查问题</td>
		<td class="detailtd"><input type="text" id="m_hcwt" value=""></td>
		<td class="distd">核查意见</td>
		<td class="detailtd"><input type="text" id="m_hcyj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">核查人</td>
		<td class="detailtd"><input type="text" id="m_hcr" value=""></td>
		<td class="distd">核查单位</td>
		<td class="detailtd"><input type="text" id="m_hcdw" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">核查单位代码</td>
		<td class="detailtd"><input type="text" id="m_hcdwdm" value=""></td>
		<td class="distd">核查状态</td>
		<td class="detailtd"><input type="text" id="m_hczt" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
