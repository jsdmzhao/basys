<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	daggleDiv(detailid);
	}); 
	function addVerify(){
		if (!checkControlValue("a_khxxid","Integer",-9999999999,9999999999,null,0,"客户信息ID"))
			return false;
		if (!checkControlValue("a_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("a_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("a_mzdm","String",1,40,null,0,"民族代码"))
			return false;
		if (!checkControlValue("a_minzu","String",1,20,null,0,"民族"))
			return false;
		if (!checkControlValue("a_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("a_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("a_hjdxz","String",1,200,null,0,"户籍地详址"))
			return false;
		if (!checkControlValue("a_cyzjdm","String",1,40,null,0,"常用证件代码"))
			return false;
		if (!checkControlValue("a_cyzj","String",1,100,null,0,"常用证件"))
			return false;
		if (!checkControlValue("a_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("a_biduiflag","String",1,1,null,0,"比对标志"))
			return false;
		if (!checkControlValue("a_zt","String",1,10,null,0,"状态"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Khxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">客户信息ID</td>
		<td class="detailtd"><input type="text" id="a_khxxid" value="0"></td>
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" id="a_xm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">联系电话</td>
		<td class="detailtd"><input type="text" id="a_lxdh" value=""></td>
		<td class="distd">民族代码</td>
		<td class="detailtd"><input type="text" id="a_mzdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">民族</td>
		<td class="detailtd"><input type="text" id="a_minzu" value=""></td>
		<td class="distd">性别代码</td>
		<td class="detailtd"><input type="text" id="a_xbdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" id="a_xb" value=""></td>
		<td class="distd">户籍地详址</td>
		<td class="detailtd"><input type="text" id="a_hjdxz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">常用证件代码</td>
		<td class="detailtd"><input type="text" id="a_cyzjdm" value=""></td>
		<td class="distd">常用证件</td>
		<td class="detailtd"><input type="text" id="a_cyzj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">证件号码</td>
		<td class="detailtd"><input type="text" id="a_zjhm" value=""></td>
		<td class="distd">比对标志</td>
		<td class="detailtd"><input type="text" id="a_biduiflag" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">状态</td>
		<td class="detailtd"><input type="text" id="a_zt" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>