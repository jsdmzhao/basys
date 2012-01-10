<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_gjcxfaid").attr("value",dataid);
		$("#m_gjcxfaid").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_gjcxfaid").attr("value",setNull(json.LGjcxfa[0].gjcxfaid));
		$("#m_gjcxfamc").attr("value",setNull(json.LGjcxfa[0].gjcxfamc));
		$("#m_ssyhzh").attr("value",setNull(json.LGjcxfa[0].ssyhzh));
		$("#m_ssgnmc").attr("value",setNull(json.LGjcxfa[0].ssgnmc));
		$("#m_gjcxlx").attr("value",setNull(json.LGjcxfa[0].gjcxlx));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_gjcxfaid","Integer",-9999999999,9999999999,null,0,"高级查询方案ID"))
			return false;
		if (!checkControlValue("m_gjcxfamc","String",1,100,null,0,"高级查询方案名称"))
			return false;
		if (!checkControlValue("m_ssyhzh","String",1,60,null,0,"所属用户帐号"))
			return false;
		if (!checkControlValue("m_ssgnmc","String",1,100,null,0,"所属功能名称"))
			return false;
		if (!checkControlValue("m_gjcxlx","String",1,20,null,0,"高级查询类型"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_gjcxfaid">
<input type="hidden" id="m_gjcxfaid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#Gjcxfa_detail&quot;).hide(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">高级查询方案ID</td>
		<td class="detailtd"><input type="text" id="m_gjcxfaid" value="0"></td>
		<td class="distd">高级查询方案名称</td>
		<td class="detailtd"><input type="text" id="m_gjcxfamc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">所属用户帐号</td>
		<td class="detailtd"><input type="text" id="m_ssyhzh" value=""></td>
		<td class="distd">所属功能名称</td>
		<td class="detailtd"><input type="text" id="m_ssgnmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">高级查询类型</td>
		<td class="detailtd"><input type="text" id="m_gjcxlx" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
