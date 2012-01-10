<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_sjbjgid").attr("value",dataid);
		$("#m_sjbjgid").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_sjbjgid").attr("value",setNull(json.LSjbjg[0].sjbjgid));
		$("#m_sjbid").attr("value",setNull(json.LSjbjg[0].sjbid));
		$("#m_zdm").attr("value",setNull(json.LSjbjg[0].zdm));
		$("#m_zdzwm").attr("value",setNull(json.LSjbjg[0].zdzwm));
		$("#m_zdlx").attr("value",setNull(json.LSjbjg[0].zdlx));
		$("#m_zdcd").attr("value",setNull(json.LSjbjg[0].zdcd));
		$("#m_qsz").attr("value",setNull(json.LSjbjg[0].qsz));
		$("#m_px").attr("value",setNull(json.LSjbjg[0].px));
		$("#m_gs").attr("value",setNull(json.LSjbjg[0].gs));
		$("#m_sfdjhwb").attr("value",setNull(json.LSjbjg[0].sfdjhwb));
		$("#m_sfbt").attr("value",setNull(json.LSjbjg[0].sfbt));
		$("#m_sfzd").attr("value",setNull(json.LSjbjg[0].sfzd));
		$("#m_sfkj").attr("value",setNull(json.LSjbjg[0].sfkj));
		$("#m_sfcx").attr("value",setNull(json.LSjbjg[0].sfcx));
		$("#m_xlklx").attr("value",setNull(json.LSjbjg[0].xlklx));
		$("#m_dzxlkdqy").attr("value",setNull(json.LSjbjg[0].dzxlkdqy));
		$("#m_xlkkd").attr("value",setNull(json.LSjbjg[0].xlkkd));
		$("#m_xlkgd").attr("value",setNull(json.LSjbjg[0].xlkgd));
		$("#m_bz").attr("value",setNull(json.LSjbjg[0].bz));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_sjbjgid","Integer",-9999999999,9999999999,null,0,"数据表结构ID"))
			return false;
		if (!checkControlValue("m_sjbid","Integer",-9999999999,9999999999,null,0,"数据表ID"))
			return false;
		if (!checkControlValue("m_zdm","String",1,30,null,0,"字段名"))
			return false;
		if (!checkControlValue("m_zdzwm","String",1,30,null,0,"字段中文名"))
			return false;
		if (!checkControlValue("m_zdlx","String",1,10,null,0,"字段类型"))
			return false;
		if (!checkControlValue("m_zdcd","String",1,10,null,0,"字段长度"))
			return false;
		if (!checkControlValue("m_qsz","String",1,100,null,0,"缺省值"))
			return false;
		if (!checkControlValue("m_px","Integer",-9999999999,9999999999,null,0,"排序"))
			return false;
		if (!checkControlValue("m_gs","String",1,100,null,0,"格式"))
			return false;
		if (!checkControlValue("m_sfdjhwb","String",1,1,null,0,"是否多行文本"))
			return false;
		if (!checkControlValue("m_sfbt","String",1,1,null,0,"是否必填"))
			return false;
		if (!checkControlValue("m_sfzd","String",1,1,null,0,"是否只读"))
			return false;
		if (!checkControlValue("m_sfkj","String",1,1,null,0,"是否可见"))
			return false;
		if (!checkControlValue("m_sfcx","String",1,1,null,0,"是否查询"))
			return false;
		if (!checkControlValue("m_xlklx","String",1,20,null,0,"下拉框类型"))
			return false;
		if (!checkControlValue("m_dzxlkdqy","String",1,100,null,0,"定制下拉框读取域列表"))
			return false;
		if (!checkControlValue("m_xlkkd","Integer",-999999,999999,null,0,"下拉框宽度"))
			return false;
		if (!checkControlValue("m_xlkgd","Integer",-999999,999999,null,0,"下拉框高度"))
			return false;
		if (!checkControlValue("m_bz","String",1,2000,null,0,"备注"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_sjbjgid">
<input type="hidden" id="m_sjbjgid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#Sjbjg_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">数据表结构ID</td>
		<td class="detailtd"><input type="text" id="m_sjbjgid" value="0"></td>
		<td class="distd">数据表ID</td>
		<td class="detailtd"><input type="text" id="m_sjbid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">字段名</td>
		<td class="detailtd"><input type="text" id="m_zdm" value=""></td>
		<td class="distd">字段中文名</td>
		<td class="detailtd"><input type="text" id="m_zdzwm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">字段类型</td>
		<td class="detailtd"><input type="text" id="m_zdlx" value=""></td>
		<td class="distd">字段长度</td>
		<td class="detailtd"><input type="text" id="m_zdcd" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">缺省值</td>
		<td class="detailtd"><input type="text" id="m_qsz" value=""></td>
		<td class="distd">排序</td>
		<td class="detailtd"><input type="text" id="m_px" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">格式</td>
		<td class="detailtd"><input type="text" id="m_gs" value=""></td>
		<td class="distd">是否多行文本</td>
		<td class="detailtd"><input type="text" id="m_sfdjhwb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">是否必填</td>
		<td class="detailtd"><input type="text" id="m_sfbt" value=""></td>
		<td class="distd">是否只读</td>
		<td class="detailtd"><input type="text" id="m_sfzd" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">是否可见</td>
		<td class="detailtd"><input type="text" id="m_sfkj" value=""></td>
		<td class="distd">是否查询</td>
		<td class="detailtd"><input type="text" id="m_sfcx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">下拉框类型</td>
		<td class="detailtd"><input type="text" id="m_xlklx" value=""></td>
		<td class="distd">定制下拉框读取域列表</td>
		<td class="detailtd"><input type="text" id="m_dzxlkdqy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">下拉框宽度</td>
		<td class="detailtd"><input type="text" id="m_xlkkd" value="0"></td>
		<td class="distd">下拉框高度</td>
		<td class="detailtd"><input type="text" id="m_xlkgd" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">备注</td>
		<td class="detailtd"><input type="text" id="m_bz" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
