<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
	}); 
	function addVerify(){
		if (!checkControlValue("a_zdycxtjid","Integer",-9999999999,9999999999,null,0,"自定义查询条件ID"))
			return false;
		if (!checkControlValue("a_gjcxfaid","Integer",-9999999999,9999999999,null,0,"高级查询方案ID"))
			return false;
		if (!checkControlValue("a_cxtj","String",1,2000,null,0,"查询条件"))
			return false;
		if (!checkControlValue("a_cxpx","String",1,2000,null,0,"查询排序"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#Zdycxtj_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">自定义查询条件ID</td>
		<td class="detailtd"><input type="text" id="a_zdycxtjid" value="0"></td>
		<td class="distd">高级查询方案ID</td>
		<td class="detailtd"><input type="text" id="a_gjcxfaid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">查询条件</td>
		<td class="detailtd"><input type="text" id="a_cxtj" value=""></td>
		<td class="distd">查询排序</td>
		<td class="detailtd"><input type="text" id="a_cxpx" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>