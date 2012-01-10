<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_tbid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#tbid").append(setNull(json.LXctb_fj[0].tbid));
		$("#附件id").append(setNull(json.LXctb_fj[0].附件id));
		$("#附件名称").append(setNull(json.LXctb_fj[0].附件名称));
		$("#附件类型").append(setNull(json.LXctb_fj[0].附件类型));
		$("#附件内容").append(setNull(json.LXctb_fj[0].附件内容));
		$("#附件序号").append(setNull(json.LXctb_fj[0].附件序号));
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
		<td class="distd">附件ID</td>
		<td class="detailtd"><span id="附件id"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">附件名称</td>
		<td class="detailtd"><span id="附件名称"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">附件类型</td>
		<td class="detailtd"><span id="附件类型"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">附件内容</td>
		<td class="detailtd"><span id="附件内容"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">附件序号</td>
		<td class="detailtd"><span id="附件序号"></span></td>
	</tr>
</table>