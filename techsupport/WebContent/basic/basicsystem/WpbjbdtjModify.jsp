<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjxxid2").attr("value",dataid);
		$("#m_bjxxid2").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_bjxxid2").attr("value",setNull(json.LWpbjbdtj[0].bjxxid2));
		$("#m_wpbjgzid").attr("value",setNull(json.LWpbjbdtj[0].wpbjgzid));
		$("#m_wpbjbdtjid").attr("value",setNull(json.LWpbjbdtj[0].wpbjbdtjid));
		$("#m_tjlx").attr("value",setNull(json.LWpbjbdtj[0].tjlx));
		$("#m_ywbzdm").attr("value",setNull(json.LWpbjbdtj[0].ywbzdm));
		$("#m_bdbzdm").attr("value",setNull(json.LWpbjbdtj[0].bdbzdm));
		$("#m_bdgx").attr("value",setNull(json.LWpbjbdtj[0].bdgx));
		$("#m_gxc").attr("value",setNull(json.LWpbjbdtj[0].gxc));
		$("#m_zxsx").attr("value",setNull(json.LWpbjbdtj[0].zxsx));
		$("#m_ljgx").attr("value",setNull(json.LWpbjbdtj[0].ljgx));
		$("#m_jibie").attr("value",setNull(json.LWpbjbdtj[0].jibie));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("m_wpbjgzid","Integer",-9999999999,9999999999,null,0,"物品报警规则ID"))
			return false;
		if (!checkControlValue("m_wpbjbdtjid","Integer",-9999999999,9999999999,null,0,"物品报警比对条件ID"))
			return false;
		if (!checkControlValue("m_tjlx","String",1,2,null,0,"条件类型"))
			return false;
		if (!checkControlValue("m_ywbzdm","String",1,60,null,0,"业务表字段名"))
			return false;
		if (!checkControlValue("m_bdbzdm","String",1,60,null,0,"比对表字段名"))
			return false;
		if (!checkControlValue("m_bdgx","String",1,20,null,0,"比对关系"))
			return false;
		if (!checkControlValue("m_gxc","String",1,200,null,0,"关系串"))
			return false;
		if (!checkControlValue("m_zxsx","String",1,100,null,0,"执行顺序"))
			return false;
		if (!checkControlValue("m_ljgx","String",1,100,null,0,"逻辑关系"))
			return false;
		if (!checkControlValue("m_jibie","Integer",-999999,999999,null,0,"级别"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_bjxxid2">
<input type="hidden" id="m_bjxxid2">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Wpbjbdtj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">报警信息ID</td>
		<td class="detailtd"><input type="text" id="m_bjxxid2" value="0"></td>
		<td class="distd">物品报警规则ID</td>
		<td class="detailtd"><input type="text" id="m_wpbjgzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">物品报警比对条件ID</td>
		<td class="detailtd"><input type="text" id="m_wpbjbdtjid" value="0"></td>
		<td class="distd">条件类型</td>
		<td class="detailtd"><input type="text" id="m_tjlx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">业务表字段名</td>
		<td class="detailtd"><input type="text" id="m_ywbzdm" value=""></td>
		<td class="distd">比对表字段名</td>
		<td class="detailtd"><input type="text" id="m_bdbzdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">比对关系</td>
		<td class="detailtd"><input type="text" id="m_bdgx" value=""></td>
		<td class="distd">关系串</td>
		<td class="detailtd"><input type="text" id="m_gxc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">执行顺序</td>
		<td class="detailtd"><input type="text" id="m_zxsx" value=""></td>
		<td class="distd">逻辑关系</td>
		<td class="detailtd"><input type="text" id="m_ljgx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">级别</td>
		<td class="detailtd"><input type="text" id="m_jibie" value="0"></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
