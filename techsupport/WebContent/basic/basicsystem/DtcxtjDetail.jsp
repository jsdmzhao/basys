<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_dtcxtjid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#dtcxtjid").append(setNull(json.LDtcxtj[0].dtcxtjid));
		$("#gjcxfaid").append(setNull(json.LDtcxtj[0].gjcxfaid));
		$("#sjbm").append(setNull(json.LDtcxtj[0].sjbm));
		$("#zdm").append(setNull(json.LDtcxtj[0].zdm));
		$("#zdzwm").append(setNull(json.LDtcxtj[0].zdzwm));
		$("#zdlx").append(setNull(json.LDtcxtj[0].zdlx));
		$("#zdz").append(setNull(json.LDtcxtj[0].zdz));
		$("#xsz").append(setNull(json.LDtcxtj[0].xsz));
		$("#ppf").append(setNull(json.LDtcxtj[0].ppf));
		$("#kskh").append(setNull(json.LDtcxtj[0].kskh));
		$("#jskh").append(setNull(json.LDtcxtj[0].jskh));
		$("#gxf").append(setNull(json.LDtcxtj[0].gxf));
	}	
</script>
<input type="hidden" id="q_dtcxtjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#Dtcxtj_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="detail">
	<tr height="20">
		<td class="distd">动态查询条件ID</td>
		<td class="detailtd"><span id="dtcxtjid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">高级查询方案ID</td>
		<td class="detailtd"><span id="gjcxfaid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">数据表名</td>
		<td class="detailtd"><span id="sjbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">字段名</td>
		<td class="detailtd"><span id="zdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">字段中文名</td>
		<td class="detailtd"><span id="zdzwm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">字段类型</td>
		<td class="detailtd"><span id="zdlx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">字段值</td>
		<td class="detailtd"><span id="zdz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">显示值</td>
		<td class="detailtd"><span id="xsz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">匹配符</td>
		<td class="detailtd"><span id="ppf"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">开始括号</td>
		<td class="detailtd"><span id="kskh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">结束括号</td>
		<td class="detailtd"><span id="jskh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">关系符</td>
		<td class="detailtd"><span id="gxf"></span></td>
	</tr>
</table>