<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_yjgzid").attr("value",dataid);
		$("#m_yjgzid").attr("value",dataid);
		setDetail();
		$("#m_dycfssj").attr("readonly","true");
		$("#m_dycfssj").datepicker();
		$("#m_zhycfssj").attr("readonly","true");
		$("#m_zhycfssj").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_yjgzid").attr("value",setNull(json.LDxyj[0].yjgzid));
		$("#m_yjxxid").attr("value",setNull(json.LDxyj[0].yjxxid));
		$("#m_dxyjid").attr("value",setNull(json.LDxyj[0].dxyjid));
		$("#m_dxhm").attr("value",setNull(json.LDxyj[0].dxhm));
		$("#m_dycfssj").attr("value",setNull(json.LDxyj[0].dycfssj));
		$("#m_zhycfssj").attr("value",setNull(json.LDxyj[0].zhycfssj));
		$("#m_fscs").attr("value",setNull(json.LDxyj[0].fscs));
		$("#m_dxzt").attr("value",setNull(json.LDxyj[0].dxzt));
		$("#m_dxnr").attr("value",setNull(json.LDxyj[0].dxnr));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_yjgzid","Integer",-9999999999,9999999999,null,0,"预警规则ID"))
			return false;
		if (!checkControlValue("m_yjxxid","Integer",-9999999999,9999999999,null,0,"预警信息ID"))
			return false;
		if (!checkControlValue("m_dxyjid","Integer",-9999999999,9999999999,null,0,"短信预警ID"))
			return false;
		if (!checkControlValue("m_dxhm","String",1,20,null,0,"短信号码"))
			return false;
		if (!checkControlValue("m_dycfssj","Date",null,null,null,0,"第一次发送时间"))
			return false;
		if (!checkControlValue("m_zhycfssj","Date",null,null,null,0,"最后一次发送时间"))
			return false;
		if (!checkControlValue("m_fscs","Integer",-999999,999999,null,0,"发送次数"))
			return false;
		if (!checkControlValue("m_dxzt","String",1,2,null,0,"短信状态"))
			return false;
		if (!checkControlValue("m_dxnr","String",1,300,null,0,"短信内容"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_yjgzid">
<input type="hidden" id="m_yjgzid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">预警规则ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_yjgzid" value="0"></td>
		<td class="distd">预警信息ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_yjxxid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">短信预警ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dxyjid" value="0"></td>
		<td class="distd">短信号码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dxhm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">第一次发送时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dycfssj" value=""></td>
		<td class="distd">最后一次发送时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_zhycfssj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发送次数</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_fscs" value="0"></td>
		<td class="distd">短信状态</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dxzt" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">短信内容</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dxnr" value=""></td>
	</tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="subDiv" onclick='setUpdate();'><img src="images/submit.gif"  border="0"/></a></td>
	</tr>
</table>
