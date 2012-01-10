<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_rybtjid").attr("value",dataid);
		$("#m_rybtjid").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_rybtjid").attr("value",setNull(json.LRylbtj[0].rybtjid));
		$("#m_hylbdm").attr("value",setNull(json.LRylbtj[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LRylbtj[0].hylb));
		$("#m_dsjgdm").attr("value",setNull(json.LRylbtj[0].dsjgdm));
		$("#m_dsjgmc").attr("value",setNull(json.LRylbtj[0].dsjgmc));
		$("#m_fxjdm").attr("value",setNull(json.LRylbtj[0].fxjdm));
		$("#m_fxjmc").attr("value",setNull(json.LRylbtj[0].fxjmc));
		$("#m_gxdwdm").attr("value",setNull(json.LRylbtj[0].gxdwdm));
		$("#m_gxdwmc").attr("value",setNull(json.LRylbtj[0].gxdwmc));
		$("#m_qybm").attr("value",setNull(json.LRylbtj[0].qybm));
		$("#m_qymc").attr("value",setNull(json.LRylbtj[0].qymc));
		$("#m_glry").attr("value",setNull(json.LRylbtj[0].glry));
		$("#m_fddbr").attr("value",setNull(json.LRylbtj[0].fddbr));
		$("#m_zygdzcry").attr("value",setNull(json.LRylbtj[0].zygdzcry));
		$("#m_zafzr").attr("value",setNull(json.LRylbtj[0].zafzr));
		$("#m_qtglry").attr("value",setNull(json.LRylbtj[0].qtglry));
		$("#m_fwry").attr("value",setNull(json.LRylbtj[0].fwry));
		$("#m_ybfwry").attr("value",setNull(json.LRylbtj[0].ybfwry));
		$("#m_lsfwry").attr("value",setNull(json.LRylbtj[0].lsfwry));
		$("#m_yyry").attr("value",setNull(json.LRylbtj[0].yyry));
		$("#m_qtfwry").attr("value",setNull(json.LRylbtj[0].qtfwry));
		$("#m_bary").attr("value",setNull(json.LRylbtj[0].bary));
		$("#m_aqjcry").attr("value",setNull(json.LRylbtj[0].aqjcry));
		$("#m_qt").attr("value",setNull(json.LRylbtj[0].qt));
		$("#m_hj").attr("value",setNull(json.LRylbtj[0].hj));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_rybtjid","Integer",-9999999999,9999999999,null,0,"人员类别统计ID"))
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
		if (!checkControlValue("m_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("m_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("m_glry","Integer",-999999,999999,null,0,"管理人员"))
			return false;
		if (!checkControlValue("m_fddbr","Integer",-999999,999999,null,0,"法定代表人或主要负责人"))
			return false;
		if (!checkControlValue("m_zygdzcry","Integer",-999999,999999,null,0,"主要股东组成人员"))
			return false;
		if (!checkControlValue("m_zafzr","Integer",-999999,999999,null,0,"治安负责人"))
			return false;
		if (!checkControlValue("m_qtglry","Integer",-999999,999999,null,0,"其他管理人员"))
			return false;
		if (!checkControlValue("m_fwry","Integer",-999999,999999,null,0,"服务人员"))
			return false;
		if (!checkControlValue("m_ybfwry","Integer",-999999,999999,null,0,"一般服务人员"))
			return false;
		if (!checkControlValue("m_lsfwry","Integer",-999999,999999,null,0,"临时服务人员"))
			return false;
		if (!checkControlValue("m_yyry","Integer",-999999,999999,null,0,"演艺人员"))
			return false;
		if (!checkControlValue("m_qtfwry","Integer",-999999,999999,null,0,"其他服务人员"))
			return false;
		if (!checkControlValue("m_bary","Integer",-999999,999999,null,0,"保安人员"))
			return false;
		if (!checkControlValue("m_aqjcry","Integer",-999999,999999,null,0,"安全检查人员"))
			return false;
		if (!checkControlValue("m_qt","Integer",-999999,999999,null,0,"其他"))
			return false;
		if (!checkControlValue("m_hj","Integer",-999999,999999,null,0,"合计"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_rybtjid">
<input type="hidden" id="m_rybtjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Rylbtj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">人员类别统计ID</td>
		<td class="detailtd"><input type="text" id="m_rybtjid" value="0"></td>
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
		<td class="distd">企业编码</td>
		<td class="detailtd"><input type="text" id="m_qybm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业名称</td>
		<td class="detailtd"><input type="text" id="m_qymc" value=""></td>
		<td class="distd">管理人员</td>
		<td class="detailtd"><input type="text" id="m_glry" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">法定代表人或主要负责人</td>
		<td class="detailtd"><input type="text" id="m_fddbr" value="0"></td>
		<td class="distd">主要股东组成人员</td>
		<td class="detailtd"><input type="text" id="m_zygdzcry" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">治安负责人</td>
		<td class="detailtd"><input type="text" id="m_zafzr" value="0"></td>
		<td class="distd">其他管理人员</td>
		<td class="detailtd"><input type="text" id="m_qtglry" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">服务人员</td>
		<td class="detailtd"><input type="text" id="m_fwry" value="0"></td>
		<td class="distd">一般服务人员</td>
		<td class="detailtd"><input type="text" id="m_ybfwry" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">临时服务人员</td>
		<td class="detailtd"><input type="text" id="m_lsfwry" value="0"></td>
		<td class="distd">演艺人员</td>
		<td class="detailtd"><input type="text" id="m_yyry" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">其他服务人员</td>
		<td class="detailtd"><input type="text" id="m_qtfwry" value="0"></td>
		<td class="distd">保安人员</td>
		<td class="detailtd"><input type="text" id="m_bary" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">安全检查人员</td>
		<td class="detailtd"><input type="text" id="m_aqjcry" value="0"></td>
		<td class="distd">其他</td>
		<td class="detailtd"><input type="text" id="m_qt" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">合计</td>
		<td class="detailtd"><input type="text" id="m_hj" value="0"></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
