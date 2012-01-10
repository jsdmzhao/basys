<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjjxh").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#bjjxh").append(setNull(json.LBjjsx[0].bjjxh));
		$("#gajgbm").append(setNull(json.LBjjsx[0].gajgbm));
		$("#gajgmc").append(setNull(json.LBjjsx[0].gajgmc));
		$("#bjjipdz").append(setNull(json.LBjjsx[0].bjjipdz));
		$("#bjjsxj").append(setNull(json.LBjjsx[0].bjjsxj));
		$("#yscsxsjdjg").append(setNull(json.LBjjsx[0].yscsxsjdjg));
	}	
</script>
<input type="hidden" id="q_bjjxh">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="detailtd2">报警机序号</td>
		<td class="detailtd1"><span id="bjjxh"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">公安机关编码</td>
		<td class="detailtd1"><span id="gajgbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">公安机关名称</td>
		<td class="detailtd1"><span id="gajgmc"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">报警机IP地址</td>
		<td class="detailtd1"><span id="bjjipdz"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">报警机刷新时间</td>
		<td class="detailtd1"><span id="bjjsxj"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">与上次刷新时间间隔</td>
		<td class="detailtd1"><span id="yscsxsjdjg"></span></td>
	</tr>
</table>