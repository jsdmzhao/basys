<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_gjcxfaid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#gjcxfaid").append(setNull(json.LGjcxfa[0].gjcxfaid));
		$("#gjcxfamc").append(setNull(json.LGjcxfa[0].gjcxfamc));
		$("#ssyhzh").append(setNull(json.LGjcxfa[0].ssyhzh));
		$("#ssgnmc").append(setNull(json.LGjcxfa[0].ssgnmc));
		$("#gjcxlx").append(setNull(json.LGjcxfa[0].gjcxlx));
	}	
</script>
<input type="hidden" id="q_gjcxfaid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#Gjcxfa_detail&quot;).hide(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="detail">
	<tr height="20">
		<td class="distd">高级查询方案ID</td>
		<td class="detailtd"><span id="gjcxfaid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">高级查询方案名称</td>
		<td class="detailtd"><span id="gjcxfamc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">所属用户帐号</td>
		<td class="detailtd"><span id="ssyhzh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">所属功能名称</td>
		<td class="detailtd"><span id="ssgnmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">高级查询类型</td>
		<td class="detailtd"><span id="gjcxlx"></span></td>
	</tr>
</table>