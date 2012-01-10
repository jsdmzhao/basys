<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
	}); 
	function addVerify(){
		if (!checkControlValue("a_gjcxfaid","Integer",-9999999999,9999999999,null,0,"高级查询方案ID"))
			return false;
		if (!checkControlValue("a_gjcxfamc","String",1,100,null,0,"高级查询方案名称"))
			return false;
		if (!checkControlValue("a_ssyhzh","String",1,60,null,0,"所属用户帐号"))
			return false;
		if (!checkControlValue("a_ssgnmc","String",1,100,null,0,"所属功能名称"))
			return false;
		if (!checkControlValue("a_gjcxlx","String",1,20,null,0,"高级查询类型"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#Gjcxfa_detail&quot;).hide(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">高级查询方案ID</td>
		<td class="detailtd"><input type="text" id="a_gjcxfaid" value="0"></td>
		<td class="distd">高级查询方案名称</td>
		<td class="detailtd"><input type="text" id="a_gjcxfamc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">所属用户帐号</td>
		<td class="detailtd"><input type="text" id="a_ssyhzh" value=""></td>
		<td class="distd">所属功能名称</td>
		<td class="detailtd"><input type="text" id="a_ssgnmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">高级查询类型</td>
		<td class="detailtd"><input type="text" id="a_gjcxlx" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>