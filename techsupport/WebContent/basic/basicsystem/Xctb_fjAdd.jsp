<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
	}); 
	function addVerify(){
		if (!checkControlValue("a_tbid","Integer",-9999999999,9999999999,null,0,"通报ID"))
			return false;
		if (!checkControlValue("a_附件id","Integer",-9999999999,9999999999,null,0,"附件ID"))
			return false;
		if (!checkControlValue("a_附件名称","String",1,100,null,0,"附件名称"))
			return false;
		if (!checkControlValue("a_附件类型","String",1,60,null,0,"附件类型"))
			return false;
		if (!checkControlValue("a_附件内容","byte[]",,,,0,"附件内容"))
			return false;
		if (!checkControlValue("a_附件序号","Integer",-9999999999,9999999999,null,0,"附件序号"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">通报ID</td>
		<td class="detailtd"><input type="text" id="a_tbid" value="0"></td>
		<td class="distd">附件ID</td>
		<td class="detailtd"><input type="text" id="a_附件id" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">附件名称</td>
		<td class="detailtd"><input type="text" id="a_附件名称" value=""></td>
		<td class="distd">附件类型</td>
		<td class="detailtd"><input type="text" id="a_附件类型" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">附件内容</td>
		<td class="detailtd"><input type="text" id="a_附件内容" value=""></td>
		<td class="distd">附件序号</td>
		<td class="detailtd"><input type="text" id="a_附件序号" value="0"></td>
	</tr>
	<tr height="25" align="center"><td colspan="4"><a href="#" id="addbutton" onclick='setAdd();'><img src="images/submit.gif"  border="0"/></a></td></tr>
</table>