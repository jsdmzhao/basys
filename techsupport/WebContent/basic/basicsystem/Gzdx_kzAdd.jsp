<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_csrq").attr("readonly","true");
		$("#a_csrq").datepicker();
		$("#a_tbrq").attr("readonly","true");
		$("#a_tbrq").datepicker();
		$("#a_zxrq").attr("readonly","true");
		$("#a_zxrq").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_gzdxid","Integer",-9999999999,9999999999,null,0,"关注对象ID"))
			return false;
		if (!checkControlValue("a_yjgzid","Integer",-9999999999,9999999999,null,0,"预警规则ID"))
			return false;
		if (!checkControlValue("a_yjxxid","Integer",-9999999999,9999999999,null,0,"预警信息ID"))
			return false;
		if (!checkControlValue("a_gzdxkzid","Integer",-9999999999,9999999999,null,0,"关注对象快照ID"))
			return false;
		if (!checkControlValue("a_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("a_bm","String",1,30,null,0,"别名"))
			return false;
		if (!checkControlValue("a_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("a_mzdm","String",1,40,null,0,"民族代码"))
			return false;
		if (!checkControlValue("a_minzu","String",1,20,null,0,"民族"))
			return false;
		if (!checkControlValue("a_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("a_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("a_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("a_hjdxzqh","String",1,200,null,0,"户籍地行政区划"))
			return false;
		if (!checkControlValue("a_hjdxzqhdm","String",1,10,null,0,"户籍地行政区划代码"))
			return false;
		if (!checkControlValue("a_hjdxz","String",1,200,null,0,"户籍地详址"))
			return false;
		if (!checkControlValue("a_cyzjdm","String",1,40,null,0,"常用证件代码"))
			return false;
		if (!checkControlValue("a_cyzj","String",1,100,null,0,"常用证件"))
			return false;
		if (!checkControlValue("a_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("a_whcd","String",1,60,null,0,"文化程度"))
			return false;
		if (!checkControlValue("a_gzdxsf","String",1,100,null,0,"关注对象身份"))
			return false;
		if (!checkControlValue("a_shengao","Float",-999.99,999.99,2,0,"身高"))
			return false;
		if (!checkControlValue("a_xzdq","String",1,300,null,0,"现住地区"))
			return false;
		if (!checkControlValue("a_xzdqxz","String",1,2000,null,0,"现住地区祥址"))
			return false;
		if (!checkControlValue("a_tbdw","String",1,100,null,0,"填报单位"))
			return false;
		if (!checkControlValue("a_tbr","String",1,100,null,0,"填表人"))
			return false;
		if (!checkControlValue("a_tbrq","Date",null,null,null,0,"填报日期"))
			return false;
		if (!checkControlValue("a_tbdabm","String",1,60,null,0,"填报单位编码"))
			return false;
		if (!checkControlValue("a_zxbz","String",1,2,null,0,"注销标志"))
			return false;
		if (!checkControlValue("a_zxrq","Date",null,null,null,0,"注销日期"))
			return false;
		if (!checkControlValue("a_zxr","String",1,30,null,0,"注销人"))
			return false;
		if (!checkControlValue("a_bz","String",1,2000,null,0,"备注"))
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
		<td class="distd">关注对象ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_gzdxid" value="0"></td>
		<td class="distd">预警规则ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_yjgzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">预警信息ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_yjxxid" value="0"></td>
		<td class="distd">关注对象快照ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_gzdxkzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xm" value=""></td>
		<td class="distd">别名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名拼音</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xmpy" value=""></td>
		<td class="distd">民族代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_mzdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">民族</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_minzu" value=""></td>
		<td class="distd">性别代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xbdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xb" value=""></td>
		<td class="distd">出生日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_csrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">户籍地行政区划</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_hjdxzqh" value=""></td>
		<td class="distd">户籍地行政区划代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_hjdxzqhdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">户籍地详址</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_hjdxz" value=""></td>
		<td class="distd">常用证件代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_cyzjdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">常用证件</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_cyzj" value=""></td>
		<td class="distd">证件号码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_zjhm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">文化程度</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_whcd" value=""></td>
		<td class="distd">关注对象身份</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_gzdxsf" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">身高</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_shengao" value="0"></td>
		<td class="distd">现住地区</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xzdq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">现住地区祥址</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xzdqxz" value=""></td>
		<td class="distd">填报单位</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_tbdw" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">填表人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_tbr" value=""></td>
		<td class="distd">填报日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_tbrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">填报单位编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_tbdabm" value=""></td>
		<td class="distd">注销标志</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_zxbz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">注销日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_zxrq" value=""></td>
		<td class="distd">注销人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_zxr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">备注</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bz" value=""></td>
	</tr>
	<tr height="25" align="center"><td colspan="4"><a href="#" id="addbutton" onclick='setAdd();'><img src="images/submit.gif"  border="0"/></a></td></tr>
</table>