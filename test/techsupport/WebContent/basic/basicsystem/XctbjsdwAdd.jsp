<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_sqsj").attr("readonly","true");
		$("#a_sqsj").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_tbid","Integer",-9999999999,9999999999,null,0,"通报ID"))
			return false;
		if (!checkControlValue("a_jsdwid","Integer",-9999999999,9999999999,null,0,"接收单位ID"))
			return false;
		if (!checkControlValue("a_jsdwbm","String",1,20,null,0,"接收单位编码"))
			return false;
		if (!checkControlValue("a_jsdwmc","String",1,100,null,0,"接收单位名称"))
			return false;
		if (!checkControlValue("a_sqsj","Date",null,null,null,0,"收取时间"))
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
		<td class="distd">接收单位ID</td>
		<td class="detailtd"><input type="text" id="a_jsdwid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">接收单位编码</td>
		<td class="detailtd"><input type="text" id="a_jsdwbm" value=""></td>
		<td class="distd">接收单位名称</td>
		<td class="detailtd"><input type="text" id="a_jsdwmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">收取时间</td>
		<td class="detailtd"><input type="text" id="a_sqsj" value=""></td>
	</tr>
	<tr height="25" align="center"><td colspan="4"><a href="#" id="addbutton" onclick='setAdd();'><img src="images/submit.gif"  border="0"/></a></td></tr>
</table>