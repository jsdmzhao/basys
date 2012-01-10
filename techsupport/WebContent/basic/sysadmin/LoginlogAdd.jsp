<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_logintiime").attr("readonly","true");
		$("#a_logintiime").datepicker();
		$("#a_quittime").attr("readonly","true");
		$("#a_quittime").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_loginlogid","Integer",-9999999999,9999999999,null,0,"登录日志ID"))
			return false;
		if (!checkControlValue("a_loginuserid","Integer",-9999999999,9999999999,null,0,"登录用户ID"))
			return false;
		if (!checkControlValue("a_useraccount","String",1,200,null,0,"登录用户名"))
			return false;
		if (!checkControlValue("a_username","String",1,30,null,0,"姓名"))
			return false;
		if (!checkControlValue("a_loginunitcode","String",1,200,null,0,"登录单位代码"))
			return false;
		if (!checkControlValue("a_loginunitname","String",1,300,null,0,"登录单位名称"))
			return false;
		if (!checkControlValue("a_loginip","String",1,20,null,0,"登录IP"))
			return false;
		if (!checkControlValue("a_loginmac","String",1,20,null,0,"登录MAC"))
			return false;
		if (!checkControlValue("a_logintiime","Date",null,null,null,0,"登录时间"))
			return false;
		if (!checkControlValue("a_quittime","Date",null,null,null,0,"退出时间"))
			return false;
		return true;
	}
</script>
<div align="right"><a href="#" id="closeDiv" onclick='$("#loginlog_detail").hideAndRemove("show");' class="close"></a></div>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">登录日志ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_loginlogid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">登录用户名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_useraccount" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">登录单位代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_loginunitcode" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">登录IP</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_loginip" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">登录时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_logintiime" value=""></td>
	</tr>
	<tr height="20">
	  <td class="distd">登录用户ID</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="a_loginuserid" value="0" /></td>
  </tr>
	<tr height="20">
	  <td class="distd">姓名</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="a_username" value="" /></td>
  </tr>
	<tr height="20">
	  <td class="distd">登录单位名称</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="a_loginunitname" value="" /></td>
  </tr>
	<tr height="20">
	  <td class="distd">登录MAC</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="a_loginmac" value="" /></td>
  </tr>
	<tr height="20">
	  <td class="distd">退出时间</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="a_quittime" value="" /></td>
  </tr>
	<tr height="20">
  </tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setAdd();'>保存</a></td>
	</tr>
</table>