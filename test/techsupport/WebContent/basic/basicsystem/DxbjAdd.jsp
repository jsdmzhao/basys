<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_dycfssj").attr("readonly","true");
		$("#a_dycfssj").datepicker();
		$("#a_zhycfssj").attr("readonly","true");
		$("#a_zhycfssj").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_bjgzid","Integer",-9999999999,9999999999,null,0,"报警规则ID"))
			return false;
		if (!checkControlValue("a_bjxxid","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("a_dxbjid","Integer",-9999999999,9999999999,null,0,"短信报警ID"))
			return false;
		if (!checkControlValue("a_dxhm","String",1,20,null,0,"短信号码"))
			return false;
		if (!checkControlValue("a_dycfssj","Date",null,null,null,0,"第一次发送时间"))
			return false;
		if (!checkControlValue("a_zhycfssj","Date",null,null,null,0,"最后一次发送时间"))
			return false;
		if (!checkControlValue("a_fscs","Integer",-999999,999999,null,0,"发送次数"))
			return false;
		if (!checkControlValue("a_dxzt","String",1,2,null,0,"短信状态"))
			return false;
		if (!checkControlValue("a_dxnr","String",1,300,null,0,"短信内容"))
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
		<td class="distd">报警规则ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bjgzid" value="0"></td>
		<td class="distd">报警信息ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bjxxid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">短信报警ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dxbjid" value="0"></td>
		<td class="distd">短信号码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dxhm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">第一次发送时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dycfssj" value=""></td>
		<td class="distd">最后一次发送时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_zhycfssj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发送次数</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_fscs" value="0"></td>
		<td class="distd">短信状态</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dxzt" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">短信内容</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dxnr" value=""></td>
	</tr>
	<tr height="25" align="center"><td colspan="4"><a href="#" id="addbutton" onclick='setAdd();'><img src="images/submit.gif"  border="0"/></a></td></tr>
</table>