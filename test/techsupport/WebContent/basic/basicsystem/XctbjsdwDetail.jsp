<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_tbid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#tbid").append(setNull(json.LXctbjsdw[0].tbid));
		$("#jsdwid").append(setNull(json.LXctbjsdw[0].jsdwid));
		$("#jsdwbm").append(setNull(json.LXctbjsdw[0].jsdwbm));
		$("#jsdwmc").append(setNull(json.LXctbjsdw[0].jsdwmc));
		$("#sqsj").append(setNull(json.LXctbjsdw[0].sqsj));
	}	
</script>
<input type="hidden" id="q_tbid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="detail">
	<tr height="20">
		<td class="distd">通报ID</td>
		<td class="detailtd"><span id="tbid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">接收单位ID</td>
		<td class="detailtd"><span id="jsdwid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">接收单位编码</td>
		<td class="detailtd"><span id="jsdwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">接收单位名称</td>
		<td class="detailtd"><span id="jsdwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">收取时间</td>
		<td class="detailtd"><span id="sqsj"></span></td>
	</tr>
</table>