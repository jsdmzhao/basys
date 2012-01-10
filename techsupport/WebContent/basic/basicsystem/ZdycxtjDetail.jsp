<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_zdycxtjid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#zdycxtjid").append(setNull(json.LZdycxtj[0].zdycxtjid));
		$("#gjcxfaid").append(setNull(json.LZdycxtj[0].gjcxfaid));
		$("#cxtj").append(setNull(json.LZdycxtj[0].cxtj));
		$("#cxpx").append(setNull(json.LZdycxtj[0].cxpx));
	}	
</script>
<input type="hidden" id="q_zdycxtjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#Zdycxtj_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="detail">
	<tr height="20">
		<td class="distd">自定义查询条件ID</td>
		<td class="detailtd"><span id="zdycxtjid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">高级查询方案ID</td>
		<td class="detailtd"><span id="gjcxfaid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">查询条件</td>
		<td class="detailtd"><span id="cxtj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">查询排序</td>
		<td class="detailtd"><span id="cxpx"></span></td>
	</tr>
</table>