<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjjxh").attr("value",dataid);
		$("#m_bjjxh").attr("value",dataid);
		setDetail();
		$("#m_bjjsxj").attr("readonly","true");
		$("#m_bjjsxj").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_bjjxh").attr("value",setNull(json.LBjjsx[0].bjjxh));
		$("#m_gajgbm").attr("value",setNull(json.LBjjsx[0].gajgbm));
		$("#m_gajgmc").attr("value",setNull(json.LBjjsx[0].gajgmc));
		$("#m_bjjipdz").attr("value",setNull(json.LBjjsx[0].bjjipdz));
		$("#m_bjjsxj").attr("value",setNull(json.LBjjsx[0].bjjsxj));
		$("#m_yscsxsjdjg").attr("value",setNull(json.LBjjsx[0].yscsxsjdjg));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_bjjxh","Integer",-9999999999,9999999999,null,0,"报警机序号"))
			return false;
		if (!checkControlValue("m_gajgbm","String",1,20,null,0,"公安机关编码"))
			return false;
		if (!checkControlValue("m_gajgmc","String",1,100,null,0,"公安机关名称"))
			return false;
		if (!checkControlValue("m_bjjipdz","String",1,60,null,0,"报警机IP地址"))
			return false;
		if (!checkControlValue("m_bjjsxj","Date",null,null,null,0,"报警机刷新时间"))
			return false;
		if (!checkControlValue("m_yscsxsjdjg","Integer",-999999,999999,null,0,"与上次刷新时间间隔"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_bjjxh">
<input type="hidden" id="m_bjjxh">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">报警机序号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bjjxh" value="0"></td>
		<td class="distd">公安机关编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_gajgbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">公安机关名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_gajgmc" value=""></td>
		<td class="distd">报警机IP地址</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bjjipdz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">报警机刷新时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bjjsxj" value=""></td>
		<td class="distd">与上次刷新时间间隔</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_yscsxsjdjg" value="0"></td>
	</tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="subDiv" onclick='setUpdate();'><img src="images/submit.gif"  border="0"/></a></td>
	</tr>
</table>
