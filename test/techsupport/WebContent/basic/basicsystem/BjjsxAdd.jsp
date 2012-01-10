<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_bjjsxj").attr("readonly","true");
		$("#a_bjjsxj").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_bjjxh","Integer",-9999999999,9999999999,null,0,"报警机序号"))
			return false;
		if (!checkControlValue("a_gajgbm","String",1,20,null,0,"公安机关编码"))
			return false;
		if (!checkControlValue("a_gajgmc","String",1,100,null,0,"公安机关名称"))
			return false;
		if (!checkControlValue("a_bjjipdz","String",1,60,null,0,"报警机IP地址"))
			return false;
		if (!checkControlValue("a_bjjsxj","Date",null,null,null,0,"报警机刷新时间"))
			return false;
		if (!checkControlValue("a_yscsxsjdjg","Integer",-999999,999999,null,0,"与上次刷新时间间隔"))
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
		<td class="distd">报警机序号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bjjxh" value="0"></td>
		<td class="distd">公安机关编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_gajgbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">公安机关名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_gajgmc" value=""></td>
		<td class="distd">报警机IP地址</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bjjipdz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">报警机刷新时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bjjsxj" value=""></td>
		<td class="distd">与上次刷新时间间隔</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_yscsxsjdjg" value="0"></td>
	</tr>
	<tr height="25" align="center"><td colspan="4"><a href="#" id="addbutton" onclick='setAdd();'><img src="images/submit.gif"  border="0"/></a></td></tr>
</table>