<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_loginlogid").attr("value",dataid);
		$("#m_loginlogid").attr("value",dataid);
		setDetail();
		$("#m_logintiime").attr("readonly","true");
		$("#m_logintiime").datepicker();
		$("#m_quittime").attr("readonly","true");
		$("#m_quittime").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_loginlogid").append(setNull(json.LLoginlog[0].loginlogid));
		$("#m_loginuserid").append(setNull(json.LLoginlog[0].loginuserid));
		$("#m_useraccount").append(setNull(json.LLoginlog[0].useraccount));
		$("#m_username").append(setNull(json.LLoginlog[0].username));
		$("#m_loginunitcode").append(setNull(json.LLoginlog[0].loginunitcode));
		$("#m_loginunitname").append(setNull(json.LLoginlog[0].loginunitname));
		$("#m_loginip").append(setNull(json.LLoginlog[0].loginip));
		$("#m_loginmac").append(setNull(json.LLoginlog[0].loginmac));
		$("#m_logintiime").append(setNull(json.LLoginlog[0].logintiime));
		$("#m_quittime").append(setNull(json.LLoginlog[0].quittime));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_loginlogid","Integer",-9999999999,9999999999,null,0,"登录日志ID"))
			return false;
		if (!checkControlValue("m_loginuserid","Integer",-9999999999,9999999999,null,0,"登录用户ID"))
			return false;
		if (!checkControlValue("m_useraccount","String",1,200,null,0,"登录用户名"))
			return false;
		if (!checkControlValue("m_username","String",1,30,null,0,"姓名"))
			return false;
		if (!checkControlValue("m_loginunitcode","String",1,200,null,0,"登录单位代码"))
			return false;
		if (!checkControlValue("m_loginunitname","String",1,300,null,0,"登录单位名称"))
			return false;
		if (!checkControlValue("m_loginip","String",1,20,null,0,"登录IP"))
			return false;
		if (!checkControlValue("m_loginmac","String",1,20,null,0,"登录MAC"))
			return false;
		if (!checkControlValue("m_logintiime","Date",null,null,null,0,"登录时间"))
			return false;
		if (!checkControlValue("m_quittime","Date",null,null,null,0,"退出时间"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_loginlogid">
<input type="hidden" id="m_loginlogid">
<div align="right"><a href="#" id="closeDiv" onclick='$("#loginlog_detail").hideAndRemove("show");' class="close"></a></div>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">登录日志ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_loginlogid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">登录用户名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_useraccount" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">登录单位代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_loginunitcode" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">登录IP</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_loginip" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">登录时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_logintiime" value=""></td>
	</tr>
	<tr height="20">
	  <td class="distd">登录用户ID</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="m_loginuserid" value="0" /></td>
  </tr>
	<tr height="20">
	  <td class="distd">姓名</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="m_username" value="" /></td>
  </tr>
	<tr height="20">
	  <td class="distd">登录单位名称</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="m_loginunitname" value="" /></td>
  </tr>
	<tr height="20">
	  <td class="distd">登录MAC</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="m_loginmac" value="" /></td>
  </tr>
	<tr height="20">
	  <td class="distd">退出时间</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="m_quittime" value="" /></td>
  </tr>
	<tr height="20">
  </tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td>
	</tr>
</table>
