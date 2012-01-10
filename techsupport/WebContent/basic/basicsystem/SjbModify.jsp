<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_sjbid").attr("value",dataid);
		$("#m_sjbid").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_sjbid").attr("value",setNull(json.LSjb[0].sjbid));
		$("#m_sjbm").attr("value",setNull(json.LSjb[0].sjbm));
		$("#m_sjbzwm").attr("value",setNull(json.LSjb[0].sjbzwm));
		$("#m_dyldx").attr("value",setNull(json.LSjb[0].dyldx));
		$("#m_sfjlczrz").attr("value",setNull(json.LSjb[0].sfjlczrz));
		$("#m_sfxtzd").attr("value",setNull(json.LSjb[0].sfxtzd));
		$("#m_sssjkyh").attr("value",setNull(json.LSjb[0].sssjkyh));
		$("#m_zj").attr("value",setNull(json.LSjb[0].zj));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_sjbid","Integer",-9999999999,9999999999,null,0,"数据表ID"))
			return false;
		if (!checkControlValue("m_sjbm","String",1,30,null,0,"数据表名"))
			return false;
		if (!checkControlValue("m_sjbzwm","String",1,30,null,0,"数据表中文名"))
			return false;
		if (!checkControlValue("m_dyldx","String",1,30,null,0,"对应类对象"))
			return false;
		if (!checkControlValue("m_sfjlczrz","Integer",-99,99,null,0,"是否记录操作日志"))
			return false;
		if (!checkControlValue("m_sfxtzd","Integer",-99,99,null,0,"是否系统字典"))
			return false;
		if (!checkControlValue("m_sssjkyh","String",1,20,null,0,"所属数据库用户"))
			return false;
		if (!checkControlValue("m_zj","String",1,30,null,0,"主键"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_sjbid">
<input type="hidden" id="m_sjbid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#Sjb_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">数据表ID</td>
		<td class="detailtd"><input type="text" id="m_sjbid" value="0"></td>
		<td class="distd">数据表名</td>
		<td class="detailtd"><input type="text" id="m_sjbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">数据表中文名</td>
		<td class="detailtd"><input type="text" id="m_sjbzwm" value=""></td>
		<td class="distd">对应类对象</td>
		<td class="detailtd"><input type="text" id="m_dyldx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">是否记录操作日志</td>
		<td class="detailtd"><input type="text" id="m_sfjlczrz" value="0"></td>
		<td class="distd">是否系统字典</td>
		<td class="detailtd"><input type="text" id="m_sfxtzd" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">所属数据库用户</td>
		<td class="detailtd"><input type="text" id="m_sssjkyh" value=""></td>
		<td class="distd">主键</td>
		<td class="detailtd"><input type="text" id="m_zj" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
