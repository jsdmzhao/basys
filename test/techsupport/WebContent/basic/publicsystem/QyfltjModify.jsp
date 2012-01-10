<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qyfltjid").attr("value",dataid);
		$("#m_qyfltjid").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_qyfltjid").attr("value",setNull(json.LQyfltj[0].qyfltjid));
		$("#m_hylbdm").attr("value",setNull(json.LQyfltj[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LQyfltj[0].hylb));
		$("#m_dsjgdm").attr("value",setNull(json.LQyfltj[0].dsjgdm));
		$("#m_dsjgmc").attr("value",setNull(json.LQyfltj[0].dsjgmc));
		$("#m_fxjdm").attr("value",setNull(json.LQyfltj[0].fxjdm));
		$("#m_fxjmc").attr("value",setNull(json.LQyfltj[0].fxjmc));
		$("#m_gxdwdm").attr("value",setNull(json.LQyfltj[0].gxdwdm));
		$("#m_gxdwmc").attr("value",setNull(json.LQyfltj[0].gxdwmc));
		$("#m_gwyl").attr("value",setNull(json.LQyfltj[0].gwyl));
		$("#m_jb").attr("value",setNull(json.LQyfltj[0].jb));
		$("#m_glxxhdcs").attr("value",setNull(json.LQyfltj[0].glxxhdcs));
		$("#m_yysdzyxt").attr("value",setNull(json.LQyfltj[0].yysdzyxt));
		$("#m_snxy").attr("value",setNull(json.LQyfltj[0].snxy));
		$("#m_am").attr("value",setNull(json.LQyfltj[0].am));
		$("#m_zs").attr("value",setNull(json.LQyfltj[0].zs));
		$("#m_wsfw").attr("value",setNull(json.LQyfltj[0].wsfw));
		$("#m_qt").attr("value",setNull(json.LQyfltj[0].qt));
		$("#m_hj").attr("value",setNull(json.LQyfltj[0].hj));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qyfltjid","Integer",-9999999999,9999999999,null,0,"企业分类统计ID"))
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
		if (!checkControlValue("m_gwyl","Integer",-999999,999999,null,0,"歌舞娱乐"))
			return false;
		if (!checkControlValue("m_jb","Integer",-999999,999999,null,0,"酒吧"))
			return false;
		if (!checkControlValue("m_glxxhdcs","Integer",-999999,999999,null,0,"各类休闲活动场所"))
			return false;
		if (!checkControlValue("m_yysdzyxt","Integer",-999999,999999,null,0,"游艺室、电子游戏厅"))
			return false;
		if (!checkControlValue("m_snxy","Integer",-999999,999999,null,0,"桑拿、洗浴"))
			return false;
		if (!checkControlValue("m_am","Integer",-999999,999999,null,0,"按摩"))
			return false;
		if (!checkControlValue("m_zs","Integer",-999999,999999,null,0,"住宿"))
			return false;
		if (!checkControlValue("m_wsfw","Integer",-999999,999999,null,0,"网上服务（网吧）"))
			return false;
		if (!checkControlValue("m_qt","Integer",-999999,999999,null,0,"其他"))
			return false;
		if (!checkControlValue("m_hj","Integer",-999999,999999,null,0,"合计"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qyfltjid">
<input type="hidden" id="m_qyfltjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Qyfltj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业分类统计ID</td>
		<td class="detailtd"><input type="text" id="m_qyfltjid" value="0"></td>
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
		<td class="distd">歌舞娱乐</td>
		<td class="detailtd"><input type="text" id="m_gwyl" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">酒吧</td>
		<td class="detailtd"><input type="text" id="m_jb" value="0"></td>
		<td class="distd">各类休闲活动场所</td>
		<td class="detailtd"><input type="text" id="m_glxxhdcs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">游艺室、电子游戏厅</td>
		<td class="detailtd"><input type="text" id="m_yysdzyxt" value="0"></td>
		<td class="distd">桑拿、洗浴</td>
		<td class="detailtd"><input type="text" id="m_snxy" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">按摩</td>
		<td class="detailtd"><input type="text" id="m_am" value="0"></td>
		<td class="distd">住宿</td>
		<td class="detailtd"><input type="text" id="m_zs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">网上服务（网吧）</td>
		<td class="detailtd"><input type="text" id="m_wsfw" value="0"></td>
		<td class="distd">其他</td>
		<td class="detailtd"><input type="text" id="m_qt" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">合计</td>
		<td class="detailtd"><input type="text" id="m_hj" value="0"></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
