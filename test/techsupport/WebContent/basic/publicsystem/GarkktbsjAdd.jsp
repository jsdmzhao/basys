<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	daggleDiv(detailid);
		$("#a_csrq").attr("readonly","true");
		$("#a_csrq").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_garkktbsjid","Integer",-9999999999,9999999999,null,0,"公安人口库同步数据ID"))
			return false;
		if (!checkControlValue("a_gmsfzhm","String",1,20,null,0,"公民身份证号码"))
			return false;
		if (!checkControlValue("a_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("a_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("a_mz","String",1,30,null,0,"民族"))
			return false;
		if (!checkControlValue("a_hyzk","String",1,4,null,0,"婚姻状况"))
			return false;
		if (!checkControlValue("a_hjsx","String",1,20,null,0,"户籍省县"))
			return false;
		if (!checkControlValue("a_hjdxz","String",1,200,null,0,"户籍地详址"))
			return false;
		if (!checkControlValue("a_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("a_zp","byte[]",,,,0,"照片"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Garkktbsj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">公安人口库同步数据ID</td>
		<td class="detailtd"><input type="text" id="a_garkktbsjid" value="0"></td>
		<td class="distd">公民身份证号码</td>
		<td class="detailtd"><input type="text" id="a_gmsfzhm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" id="a_xm" value=""></td>
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" id="a_xb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">民族</td>
		<td class="detailtd"><input type="text" id="a_mz" value=""></td>
		<td class="distd">婚姻状况</td>
		<td class="detailtd"><input type="text" id="a_hyzk" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">户籍省县</td>
		<td class="detailtd"><input type="text" id="a_hjsx" value=""></td>
		<td class="distd">户籍地详址</td>
		<td class="detailtd"><input type="text" id="a_hjdxz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">出生日期</td>
		<td class="detailtd"><input type="text" id="a_csrq" value=""></td>
		<td class="distd">照片</td>
		<td class="detailtd"><input type="text" id="a_zp" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>