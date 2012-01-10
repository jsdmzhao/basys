<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
	}); 
	function addVerify(){
		if (!checkControlValue("a_sjbjgid","Integer",-9999999999,9999999999,null,0,"数据表结构ID"))
			return false;
		if (!checkControlValue("a_sjbid","Integer",-9999999999,9999999999,null,0,"数据表ID"))
			return false;
		if (!checkControlValue("a_zdm","String",1,30,null,0,"字段名"))
			return false;
		if (!checkControlValue("a_zdzwm","String",1,30,null,0,"字段中文名"))
			return false;
		if (!checkControlValue("a_zdlx","String",1,10,null,0,"字段类型"))
			return false;
		if (!checkControlValue("a_zdcd","String",1,10,null,0,"字段长度"))
			return false;
		if (!checkControlValue("a_qsz","String",1,100,null,0,"缺省值"))
			return false;
		if (!checkControlValue("a_px","Integer",-9999999999,9999999999,null,0,"排序"))
			return false;
		if (!checkControlValue("a_gs","String",1,100,null,0,"格式"))
			return false;
		if (!checkControlValue("a_sfdjhwb","String",1,1,null,0,"是否多行文本"))
			return false;
		if (!checkControlValue("a_sfbt","String",1,1,null,0,"是否必填"))
			return false;
		if (!checkControlValue("a_sfzd","String",1,1,null,0,"是否只读"))
			return false;
		if (!checkControlValue("a_sfkj","String",1,1,null,0,"是否可见"))
			return false;
		if (!checkControlValue("a_sfcx","String",1,1,null,0,"是否查询"))
			return false;
		if (!checkControlValue("a_xlklx","String",1,20,null,0,"下拉框类型"))
			return false;
		if (!checkControlValue("a_dzxlkdqy","String",1,100,null,0,"定制下拉框读取域列表"))
			return false;
		if (!checkControlValue("a_xlkkd","Integer",-999999,999999,null,0,"下拉框宽度"))
			return false;
		if (!checkControlValue("a_xlkgd","Integer",-999999,999999,null,0,"下拉框高度"))
			return false;
		if (!checkControlValue("a_bz","String",1,2000,null,0,"备注"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#Sjbjg_detail&quot;).hide(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">数据表结构ID</td>
		<td class="detailtd"><input type="text" id="a_sjbjgid" value="0"></td>
		<td class="distd">数据表ID</td>
		<td class="detailtd"><input type="text" id="a_sjbid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">字段名</td>
		<td class="detailtd"><input type="text" id="a_zdm" value=""></td>
		<td class="distd">字段中文名</td>
		<td class="detailtd"><input type="text" id="a_zdzwm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">字段类型</td>
		<td class="detailtd"><input type="text" id="a_zdlx" value=""></td>
		<td class="distd">字段长度</td>
		<td class="detailtd"><input type="text" id="a_zdcd" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">缺省值</td>
		<td class="detailtd"><input type="text" id="a_qsz" value=""></td>
		<td class="distd">排序</td>
		<td class="detailtd"><input type="text" id="a_px" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">格式</td>
		<td class="detailtd"><input type="text" id="a_gs" value=""></td>
		<td class="distd">是否多行文本</td>
		<td class="detailtd"><input type="text" id="a_sfdjhwb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">是否必填</td>
		<td class="detailtd"><input type="text" id="a_sfbt" value=""></td>
		<td class="distd">是否只读</td>
		<td class="detailtd"><input type="text" id="a_sfzd" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">是否可见</td>
		<td class="detailtd"><input type="text" id="a_sfkj" value=""></td>
		<td class="distd">是否查询</td>
		<td class="detailtd"><input type="text" id="a_sfcx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">下拉框类型</td>
		<td class="detailtd"><input type="text" id="a_xlklx" value=""></td>
		<td class="distd">定制下拉框读取域列表</td>
		<td class="detailtd"><input type="text" id="a_dzxlkdqy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">下拉框宽度</td>
		<td class="detailtd"><input type="text" id="a_xlkkd" value="0"></td>
		<td class="distd">下拉框高度</td>
		<td class="detailtd"><input type="text" id="a_xlkgd" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">备注</td>
		<td class="detailtd"><input type="text" id="a_bz" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>