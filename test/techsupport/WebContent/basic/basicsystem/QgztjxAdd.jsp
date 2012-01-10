<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_csrq").attr("readonly","true");
		$("#a_csrq").datepicker();
		$("#a_djrq").attr("readonly","true");
		$("#a_djrq").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_qgztjxid","Integer",-9999999999,9999999999,null,0,"全国在逃简项ID"))
			return false;
		if (!checkControlValue("a_tbbh","String",1,20,null,0,"通报编号"))
			return false;
		if (!checkControlValue("a_xzqhbm","String",1,6,null,0,"行政区划编码"))
			return false;
		if (!checkControlValue("a_xzqh","String",1,100,null,0,"行政区划"))
			return false;
		if (!checkControlValue("a_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("a_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("a_bm","String",1,30,null,0,"别名"))
			return false;
		if (!checkControlValue("a_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("a_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("a_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("a_gmsfhm","String",1,20,null,0,"公民身份号码"))
			return false;
		if (!checkControlValue("a_hjdbm","String",1,6,null,0,"户籍地编码"))
			return false;
		if (!checkControlValue("a_hjd","String",1,300,null,0,"户籍地"))
			return false;
		if (!checkControlValue("a_hjxxdz","String",1,300,null,0,"户籍详细地址"))
			return false;
		if (!checkControlValue("a_xzdqbm","String",1,6,null,0,"现住地区编码"))
			return false;
		if (!checkControlValue("a_xzdq","String",1,300,null,0,"现住地区"))
			return false;
		if (!checkControlValue("a_xzdxxdz","String",1,300,null,0,"现住地详细地址"))
			return false;
		if (!checkControlValue("a_qtzjlx","String",1,20,null,0,"其他证件类型"))
			return false;
		if (!checkControlValue("a_qtzjhm","String",1,20,null,0,"其他证件号码"))
			return false;
		if (!checkControlValue("a_ajjbbm","String",1,2,null,0,"案件级别编码"))
			return false;
		if (!checkControlValue("a_ajjb","String",1,20,null,0,"案件级别"))
			return false;
		if (!checkControlValue("a_ajlbbm","String",1,20,null,0,"案件类别编码"))
			return false;
		if (!checkControlValue("a_ajlb","String",1,60,null,0,"案件类别"))
			return false;
		if (!checkControlValue("a_jyaq","String",1,2000,null,0,"简要案情"))
			return false;
		if (!checkControlValue("a_djrq","Date",null,null,null,0,"登记日期"))
			return false;
		if (!checkControlValue("a_djr","String",1,30,null,0,"登记人"))
			return false;
		if (!checkControlValue("a_ladqbm","String",1,6,null,0,"立案地区编码"))
			return false;
		if (!checkControlValue("a_ladq","String",1,300,null,0,"立案地区"))
			return false;
		if (!checkControlValue("a_badwbm","String",1,20,null,0,"办案单位编码"))
			return false;
		if (!checkControlValue("a_badw","String",1,100,null,0,"办案单位"))
			return false;
		if (!checkControlValue("a_tbr","String",1,100,null,0,"填表人"))
			return false;
		if (!checkControlValue("a_lxr","String",1,100,null,0,"联系人"))
			return false;
		if (!checkControlValue("a_lxfs","String",1,60,null,0,"联系方式"))
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
		<td class="distd">全国在逃简项ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_qgztjxid" value="0"></td>
		<td class="distd">通报编号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_tbbh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行政区划编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xzqhbm" value=""></td>
		<td class="distd">行政区划</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xzqh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名拼音</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xmpy" value=""></td>
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">别名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bm" value=""></td>
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
		<td class="distd">公民身份号码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_gmsfhm" value=""></td>
		<td class="distd">户籍地编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_hjdbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">户籍地</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_hjd" value=""></td>
		<td class="distd">户籍详细地址</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_hjxxdz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">现住地区编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xzdqbm" value=""></td>
		<td class="distd">现住地区</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xzdq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">现住地详细地址</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xzdxxdz" value=""></td>
		<td class="distd">其他证件类型</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_qtzjlx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">其他证件号码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_qtzjhm" value=""></td>
		<td class="distd">案件级别编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ajjbbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">案件级别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ajjb" value=""></td>
		<td class="distd">案件类别编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ajlbbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">案件类别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ajlb" value=""></td>
		<td class="distd">简要案情</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_jyaq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">登记日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_djrq" value=""></td>
		<td class="distd">登记人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_djr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">立案地区编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ladqbm" value=""></td>
		<td class="distd">立案地区</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ladq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">办案单位编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_badwbm" value=""></td>
		<td class="distd">办案单位</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_badw" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">填表人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_tbr" value=""></td>
		<td class="distd">联系人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_lxr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">联系方式</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_lxfs" value=""></td>
	</tr>
	<tr height="25" align="center"><td colspan="4"><a href="#" id="addbutton" onclick='setAdd();'><img src="images/submit.gif"  border="0"/></a></td></tr>
</table>