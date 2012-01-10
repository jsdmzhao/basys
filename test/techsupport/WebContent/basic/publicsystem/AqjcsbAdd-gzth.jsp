<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants"%>
<%@page import="com.aisino2.common.DateUtil"%>
<%@include file="../../public/common.jsp" %>
  <%
	User user = new User();
	String userName = null;
	//获得登录用户session
	user = (User) session.getAttribute(Constants.userKey);
	if (user == null)
		response.sendRedirect("login.jsp");
	else
		userName = user.getUsername(); 
	String lrsj = DateUtil.getDateTime();
	%>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(4);
		$("#aqjcsbzl").selectBox({code:"dm_aqjcsbzl"});
		aqjcsbzlOnchange();

	}); 
	function aqjcsb_addVerify(){
		if (!checkControlValue("z_sbmc","String",1,100,null,1,"设备名称"))
			return false;
		if (!checkControlValue("z_ggxh","String",1,100,null,1,"规格型号"))
			return false;
		if (!checkControlValue("z_aqjcsbzlbm","String",1,20,null,1,"技防设备种类"))
			return false;
		if (!checkControlValue("z_azsl","Integer",0,999999,null,1,"数量"))
			return false;
		if (!checkControlValue("z_bz","String",1,2000,null,0,"备注"))
			return false;
		return true;
	}
	function aqjcsbzlOnchange(){
		var aqjcsbzlkey = $("#aqjcsbzl").attr("value");
		var aqjcsbzlval = $("#aqjcsbzl").attr("title");
		$("#z_aqjcsbzlbm").attr("value",aqjcsbzlkey);
		$("#z_aqjcsbzlmc").attr("value",aqjcsbzlval);
	}
</script>
<input type="hidden" id="z_listtype" value="jfsb">
<input type="hidden" id="z_zt" value="1">
<input type="hidden" id="z_lrr"  value="<%=userName %>" />
<input type="hidden" id="z_lrsj"  value="<%=lrsj %>" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">技防设备添加</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#aqjcsb_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>

<table width="100%" id="add" border="0">
	<tr>
		<td class="red"  width="12%">设备名称</td>
		<td class="pagetd1"  width="21%"><input type="text" class="inputstyle"  id="z_sbmc" value=""></td>
		<td class="red"  width="11%">规格型号</td>
        <td class="pagetd1"  width="22%"><input type="text" class="inputstyle"  id="z_ggxh" value=""></td>
        <td class="red" width="13%">技防设备种类</td>
		<td class="pagetd1" width="21%">
		<select name="select" id="aqjcsbzl" onchange="aqjcsbzlOnchange();">
		</select></td>
		<input type="hidden" id="z_aqjcsbzlbm" value="">
		<input type="hidden" id="z_aqjcsbzlmc" value="">
	</tr>
	<tr>
	<td class="red" width="10%">数量</td>
      <td class="pagetd1"><input type="text" class="inputstyle"  id="z_azsl" onkeyup="value=value.replace(/[^\d]/g,'')"
      							onblur="value=value.replace(/[^\d]/g,'')"/></td>
      <td class="pagedistd1">&nbsp;</td>
      <td class="pagetd1">&nbsp;</td>
      <td class="pagedistd1">&nbsp;</td>
      <td class="pagetd1">&nbsp;</td>
    </tr>
	<tr>
	  <td class="pagedistd1">备注</td>
      <td class="pagetd1" colspan="5"><textarea name="textarea" id="z_bz" cols="83" rows="2"  style="width:98.7%" ></textarea></td>
  </tr>
  <tr height="25" align="center"><td colspan="6">
	<a href="#" hidefocus="true" class="submitbutton" title="保存" onclick='aqjcsb_setAdd();'>保存</a>
  </td></tr>
  <tr><td height="10"></td></tr>
</table>
