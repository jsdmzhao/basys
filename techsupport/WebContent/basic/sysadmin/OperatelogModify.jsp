<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_operatelogid").attr("value",dataid);
		$("#m_operatelogid").attr("value",dataid);
		setDetail();
		$("#m_operatedate").attr("readonly","true");
		$("#m_operatedate").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_operatelogid").attr("value",setNull(json.LOperatelog[0].operatelogid));
		$("#m_operateunitcode").attr("value",setNull(json.LOperatelog[0].operateunitcode));
		$("#m_operateunitname").attr("value",setNull(json.LOperatelog[0].operateunitname));
		$("#m_operateuserid").attr("value",setNull(json.LOperatelog[0].operateuserid));
		$("#m_useraccount").attr("value",setNull(json.LOperatelog[0].useraccount));
		$("#m_username").attr("value",setNull(json.LOperatelog[0].username));
		$("#m_operatesystem").attr("value",setNull(json.LOperatelog[0].operatesystem));
		$("#m_operatemodule").attr("value",setNull(json.LOperatelog[0].operatemodule));
		$("#m_operatesql").attr("value",setNull(json.LOperatelog[0].operatesql));
		$("#m_operatetype").attr("value",setNull(json.LOperatelog[0].operatetype));
		$("#m_operatedate").attr("value",setNull(json.LOperatelog[0].operatedate));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_operatelogid","Integer",-9999999999,9999999999,null,0,"操作日志ID"))
			return false;
		if (!checkControlValue("m_operateunitcode","String",1,200,null,0,"操作单位代码"))
			return false;
		if (!checkControlValue("m_operateunitname","String",1,300,null,0,"操作单位名称"))
			return false;
		if (!checkControlValue("m_operateuserid","Integer",-9999999999,9999999999,null,0,"操作用户ID"))
			return false;
		if (!checkControlValue("m_useraccount","String",1,200,null,0,"登录用户名"))
			return false;
		if (!checkControlValue("m_username","String",1,30,null,0,"姓名"))
			return false;
		if (!checkControlValue("m_operatesystem","String",1,30,null,0,"操作子系统"))
			return false;
		if (!checkControlValue("m_operatemodule","String",1,30,null,0,"操作模块"))
			return false;
		if (!checkControlValue("m_operatesql","String",1,4000,null,0,"操作sql语句"))
			return false;
		if (!checkControlValue("m_operatetype","String",1,20,null,0,"操作类型"))
			return false;
		if (!checkControlValue("m_operatedate","Date",null,null,null,0,"操作时间"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_operatelogid">
<input type="hidden" id="m_operatelogid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">操作日志ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_operatelogid" value="0"></td>
		<td class="distd">操作单位代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_operateunitcode" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">操作单位名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_operateunitname" value=""></td>
		<td class="distd">操作用户ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_operateuserid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">登录用户名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_useraccount" value=""></td>
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_username" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">操作子系统</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_operatesystem" value=""></td>
		<td class="distd">操作模块</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_operatemodule" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">操作sql语句</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_operatesql" value=""></td>
		<td class="distd">操作类型</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_operatetype" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">操作时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_operatedate" value=""></td>
	</tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="subDiv" onclick='setUpdate();'><img src="images/submit.gif"  border="0"/></a></td>
	</tr>
</table>
