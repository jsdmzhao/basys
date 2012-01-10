<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_ickyjid").attr("value",dataid);
		$("#m_ickyjid").attr("value",dataid);
		setDetail();
		$("#m_sksj").attr("readonly","true");
		$("#m_sksj").datepicker();
		$("#m_sxsj").attr("readonly","true");
		$("#m_sxsj").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_ickyjid").attr("value",setNull(json.LIckyj[0].ickyjid));
		$("#m_qyid").attr("value",setNull(json.LIckyj[0].qyid));
		$("#m_qybm").attr("value",setNull(json.LIckyj[0].qybm));
		$("#m_qymc").attr("value",setNull(json.LIckyj[0].qymc));
		$("#m_sksj").attr("value",setNull(json.LIckyj[0].sksj));
		$("#m_dsjgdm").attr("value",setNull(json.LIckyj[0].dsjgdm));
		$("#m_dsjgmc").attr("value",setNull(json.LIckyj[0].dsjgmc));
		$("#m_fxjdm").attr("value",setNull(json.LIckyj[0].fxjdm));
		$("#m_fxjmc").attr("value",setNull(json.LIckyj[0].fxjmc));
		$("#m_gxdwdm").attr("value",setNull(json.LIckyj[0].gxdwdm));
		$("#m_gxdwmc").attr("value",setNull(json.LIckyj[0].gxdwmc));
		$("#m_cyrybh").attr("value",setNull(json.LIckyj[0].cyrybh));
		$("#m_xm").attr("value",setNull(json.LIckyj[0].xm));
		$("#m_xmpy").attr("value",setNull(json.LIckyj[0].xmpy));
		$("#m_ickh").attr("value",setNull(json.LIckyj[0].ickh));
		$("#m_kh").attr("value",setNull(json.LIckyj[0].kh));
		$("#m_xb").attr("value",setNull(json.LIckyj[0].xb));
		$("#m_ywm").attr("value",setNull(json.LIckyj[0].ywm));
		$("#m_ywx").attr("value",setNull(json.LIckyj[0].ywx));
		$("#m_wgrjyxkz").attr("value",setNull(json.LIckyj[0].wgrjyxkz));
		$("#m_cyzjdm").attr("value",setNull(json.LIckyj[0].cyzjdm));
		$("#m_cyzj").attr("value",setNull(json.LIckyj[0].cyzj));
		$("#m_zjhm").attr("value",setNull(json.LIckyj[0].zjhm));
		$("#m_cylbdm").attr("value",setNull(json.LIckyj[0].cylbdm));
		$("#m_cylb").attr("value",setNull(json.LIckyj[0].cylb));
		$("#m_yjyy").attr("value",setNull(json.LIckyj[0].yjyy));
		$("#m_sxsj").attr("value",setNull(json.LIckyj[0].sxsj));
		$("#m_ryid").attr("value",setNull(json.LIckyj[0].ryid));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_ickyjid","Integer",-9999999999,9999999999,null,0,"IC卡预警ID"))
			return false;
		if (!checkControlValue("m_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("m_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("m_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("m_sksj","Date",null,null,null,0,"刷卡时间"))
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
		if (!checkControlValue("m_cyrybh","String",1,30,null,0,"从业人员编号"))
			return false;
		if (!checkControlValue("m_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("m_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("m_ickh","String",1,100,null,0,"卡ID号"))
			return false;
		if (!checkControlValue("m_kh","String",1,20,null,0,"卡号"))
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
		if (!checkControlValue("m_cylbdm","String",1,4,null,0,"从业类别代码"))
			return false;
		if (!checkControlValue("m_cylb","String",1,60,null,0,"从业类别"))
			return false;
		if (!checkControlValue("m_yjyy","String",1,300,null,0,"预警原因"))
			return false;
		if (!checkControlValue("m_sxsj","Date",null,null,null,0,"ic卡失效时间"))
			return false;
		if (!checkControlValue("m_ryid","Integer",-9999999999,9999999999,null,0,"从业人员ID"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_ickyjid">
<input type="hidden" id="m_ickyjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#ickyj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">IC卡预警ID</td>
		<td class="detailtd"><input type="text" id="m_ickyjid" class="inputstyle" value="0"></td>
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="m_qyid" class="inputstyle" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">企业编码</td>
		<td class="detailtd"><input type="text" id="m_qybm" class="inputstyle" value=""></td>
		<td class="distd">企业名称</td>
		<td class="detailtd"><input type="text" id="m_qymc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">刷卡时间</td>
		<td class="detailtd"><input type="text" id="m_sksj" class="inputstyle" value=""></td>
		<td class="distd">地市机关代码</td>
		<td class="detailtd"><input type="text" id="m_dsjgdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">地市机关名称</td>
		<td class="detailtd"><input type="text" id="m_dsjgmc" class="inputstyle" value=""></td>
		<td class="distd">分县局代码</td>
		<td class="detailtd"><input type="text" id="m_fxjdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">分县局名称</td>
		<td class="detailtd"><input type="text" id="m_fxjmc" class="inputstyle" value=""></td>
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" id="m_gxdwdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" id="m_gxdwmc" class="inputstyle" value=""></td>
		<td class="distd">从业人员编号</td>
		<td class="detailtd"><input type="text" id="m_cyrybh" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" id="m_xm" class="inputstyle" value=""></td>
		<td class="distd">姓名拼音</td>
		<td class="detailtd"><input type="text" id="m_xmpy" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">卡ID号</td>
		<td class="detailtd"><input type="text" id="m_ickh" class="inputstyle" value=""></td>
		<td class="distd">卡号</td>
		<td class="detailtd"><input type="text" id="m_kh" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" id="m_xb" class="inputstyle" value=""></td>
		<td class="distd">英文名</td>
		<td class="detailtd"><input type="text" id="m_ywm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">英文姓</td>
		<td class="detailtd"><input type="text" id="m_ywx" class="inputstyle" value=""></td>
		<td class="distd">外国人就业许可证号</td>
		<td class="detailtd"><input type="text" id="m_wgrjyxkz" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">常用证件代码</td>
		<td class="detailtd"><input type="text" id="m_cyzjdm" class="inputstyle" value=""></td>
		<td class="distd">常用证件</td>
		<td class="detailtd"><input type="text" id="m_cyzj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">证件号码</td>
		<td class="detailtd"><input type="text" id="m_zjhm" class="inputstyle" value=""></td>
		<td class="distd">从业类别代码</td>
		<td class="detailtd"><input type="text" id="m_cylbdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">从业类别</td>
		<td class="detailtd"><input type="text" id="m_cylb" class="inputstyle" value=""></td>
		<td class="distd">预警原因</td>
		<td class="detailtd"><input type="text" id="m_yjyy" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">ic卡失效时间</td>
		<td class="detailtd"><input type="text" id="m_sxsj" class="inputstyle" value=""></td>
		<td class="distd">从业人员ID</td>
		<td class="detailtd"><input type="text" id="m_ryid" class="inputstyle" value="0"></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
