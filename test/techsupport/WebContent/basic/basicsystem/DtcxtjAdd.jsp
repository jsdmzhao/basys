<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
	}); 
	function addVerify(){
		if (!checkControlValue("a_dtcxtjid","Integer",-9999999999,9999999999,null,0,"动态查询条件ID"))
			return false;
		if (!checkControlValue("a_gjcxfaid","Integer",-9999999999,9999999999,null,0,"高级查询方案ID"))
			return false;
		if (!checkControlValue("a_sjbm","String",1,30,null,0,"数据表名"))
			return false;
		if (!checkControlValue("a_zdm","String",1,30,null,0,"字段名"))
			return false;
		if (!checkControlValue("a_zdzwm","String",1,30,null,0,"字段中文名"))
			return false;
		if (!checkControlValue("a_zdlx","String",1,10,null,0,"字段类型"))
			return false;
		if (!checkControlValue("a_zdz","String",1,300,null,0,"字段值"))
			return false;
		if (!checkControlValue("a_xsz","String",1,300,null,0,"显示值"))
			return false;
		if (!checkControlValue("a_ppf","String",1,20,null,0,"匹配符"))
			return false;
		if (!checkControlValue("a_kskh","String",1,1,null,0,"开始括号"))
			return false;
		if (!checkControlValue("a_jskh","String",1,1,null,0,"结束括号"))
			return false;
		if (!checkControlValue("a_gxf","String",1,20,null,0,"关系符"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#Dtcxtj_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">动态查询条件ID</td>
		<td class="detailtd"><input type="text" id="a_dtcxtjid" value="0"></td>
		<td class="distd">高级查询方案ID</td>
		<td class="detailtd"><input type="text" id="a_gjcxfaid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">数据表名</td>
		<td class="detailtd"><input type="text" id="a_sjbm" value=""></td>
		<td class="distd">字段名</td>
		<td class="detailtd"><input type="text" id="a_zdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">字段中文名</td>
		<td class="detailtd"><input type="text" id="a_zdzwm" value=""></td>
		<td class="distd">字段类型</td>
		<td class="detailtd"><input type="text" id="a_zdlx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">字段值</td>
		<td class="detailtd"><input type="text" id="a_zdz" value=""></td>
		<td class="distd">显示值</td>
		<td class="detailtd"><input type="text" id="a_xsz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">匹配符</td>
		<td class="detailtd"><input type="text" id="a_ppf" value=""></td>
		<td class="distd">开始括号</td>
		<td class="detailtd"><input type="text" id="a_kskh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">结束括号</td>
		<td class="detailtd"><input type="text" id="a_jskh" value=""></td>
		<td class="distd">关系符</td>
		<td class="detailtd"><input type="text" id="a_gxf" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>