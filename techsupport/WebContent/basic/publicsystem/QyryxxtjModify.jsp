<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qyryxxtj").attr("value",dataid);
		$("#m_qyryxxtj").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_qyryxxtj").attr("value",setNull(json.LQyryxxtj[0].qyryxxtj));
		$("#m_hylbdm").attr("value",setNull(json.LQyryxxtj[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LQyryxxtj[0].hylb));
		$("#m_dsjgdm").attr("value",setNull(json.LQyryxxtj[0].dsjgdm));
		$("#m_dsjgmc").attr("value",setNull(json.LQyryxxtj[0].dsjgmc));
		$("#m_fxjdm").attr("value",setNull(json.LQyryxxtj[0].fxjdm));
		$("#m_fxjmc").attr("value",setNull(json.LQyryxxtj[0].fxjmc));
		$("#m_gxdwdm").attr("value",setNull(json.LQyryxxtj[0].gxdwdm));
		$("#m_gxdwmc").attr("value",setNull(json.LQyryxxtj[0].gxdwmc));
		$("#m_qymc").attr("value",setNull(json.LQyryxxtj[0].qymc));
		$("#m_qybm").attr("value",setNull(json.LQyryxxtj[0].qybm));
		$("#m_zrs").attr("value",setNull(json.LQyryxxtj[0].zrs));
		$("#m_dyzcrs").attr("value",setNull(json.LQyryxxtj[0].dyzcrs));
		$("#m_dylzrs").attr("value",setNull(json.LQyryxxtj[0].dylzrs));
		$("#m_zjqrzcrs").attr("value",setNull(json.LQyryxxtj[0].zjqrzcrs));
		$("#m_zjqrlzrs").attr("value",setNull(json.LQyryxxtj[0].zjqrlzrs));
		$("#m_dqzzrs").attr("value",setNull(json.LQyryxxtj[0].dqzzrs));
		$("#m_zdskb").attr("value",setNull(json.LQyryxxtj[0].zdskb));
		$("#m_qyrsks").attr("value",setNull(json.LQyryxxtj[0].qyrsks));
		$("#m_ztdm").attr("value",setNull(json.LQyryxxtj[0].ztdm));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qyryxxtj","Integer",-9999999999,9999999999,null,0,"企业人员信息统计ID"))
			return false;
		if (!checkControlValue("m_hylbdm","String",1,2,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("m_hylb","String",1,40,null,0,"行业类别"))
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
		if (!checkControlValue("m_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("m_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("m_zrs","Integer",-999999,999999,null,0,"总人数"))
			return false;
		if (!checkControlValue("m_dyzcrs","Integer",-999999,999999,null,0,"当月注册人数"))
			return false;
		if (!checkControlValue("m_dylzrs","Integer",-999999,999999,null,0,"当月离职人数"))
			return false;
		if (!checkControlValue("m_zjqrzcrs","Integer",-999999,999999,null,0,"最近7日注册人数"))
			return false;
		if (!checkControlValue("m_zjqrlzrs","Integer",-999999,999999,null,0,"最近7日离职人数"))
			return false;
		if (!checkControlValue("m_dqzzrs","Integer",-999999,999999,null,0,"当前在职人数"))
			return false;
		if (!checkControlValue("m_zdskb","Float",-999.99,999.99,2,0,"最低刷卡比"))
			return false;
		if (!checkControlValue("m_qyrsks","Integer",-999999,999999,null,0,"前一日刷卡数"))
			return false;
		if (!checkControlValue("m_ztdm","String",1,2,null,0,"状态代码"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qyryxxtj">
<input type="hidden" id="m_qyryxxtj">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Qyryxxtj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业人员信息统计ID</td>
		<td class="detailtd"><input type="text" id="m_qyryxxtj" value="0"></td>
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="m_hylbdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="m_hylb" value=""></td>
		<td class="distd">地市机关代码</td>
		<td class="detailtd"><input type="text" id="m_dsjgdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">地市机关名称</td>
		<td class="detailtd"><input type="text" id="m_dsjgmc" value=""></td>
		<td class="distd">分县局代码</td>
		<td class="detailtd"><input type="text" id="m_fxjdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">分县局名称</td>
		<td class="detailtd"><input type="text" id="m_fxjmc" value=""></td>
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" id="m_gxdwdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" id="m_gxdwmc" value=""></td>
		<td class="distd">企业名称</td>
		<td class="detailtd"><input type="text" id="m_qymc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业编码</td>
		<td class="detailtd"><input type="text" id="m_qybm" value=""></td>
		<td class="distd">总人数</td>
		<td class="detailtd"><input type="text" id="m_zrs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">当月注册人数</td>
		<td class="detailtd"><input type="text" id="m_dyzcrs" value="0"></td>
		<td class="distd">当月离职人数</td>
		<td class="detailtd"><input type="text" id="m_dylzrs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">最近7日注册人数</td>
		<td class="detailtd"><input type="text" id="m_zjqrzcrs" value="0"></td>
		<td class="distd">最近7日离职人数</td>
		<td class="detailtd"><input type="text" id="m_zjqrlzrs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">当前在职人数</td>
		<td class="detailtd"><input type="text" id="m_dqzzrs" value="0"></td>
		<td class="distd">最低刷卡比</td>
		<td class="detailtd"><input type="text" id="m_zdskb" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">前一日刷卡数</td>
		<td class="detailtd"><input type="text" id="m_qyrsks" value="0"></td>
		<td class="distd">状态代码</td>
		<td class="detailtd"><input type="text" id="m_ztdm" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
