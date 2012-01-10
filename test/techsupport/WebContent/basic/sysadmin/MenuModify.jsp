<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(13); //按钮右对齐
		$("#q_menucode").attr("value",dataid);
		//$("#m_menucode").attr("value",dataid);
			$("#cdlb").selectBox({code:"dm_cdlb"});
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_menucode").attr("value",setNull(json.LMenu[0].menucode));
		$("#m_menuname").attr("value",setNull(json.LMenu[0].menuname));
		$("#m_funcentry").attr("value",setNull(json.LMenu[0].funcentry));
		$("#m_parentmenucode").attr("value",setNull(json.LMenu[0].parentmenucode));
		$("#m_menufullcode").attr("value",setNull(json.LMenu[0].menufullcode));
		$("#m_nodeorder").attr("value",setNull(json.LMenu[0].nodeorder));
		
		$("#m_systemcode").attr("value",setNull(json.LMenu[0].systemcode));
		$("#m_menulevel").attr("value",setNull(json.LMenu[0].menulevel));
		$("#m_isleaf").attr("value",setNull(json.LMenu[0].isleaf));
		$("#mparentmenuname").attr("value",setNull(json.LMenu[0].parentmenuname));
	     $("#cdlb").setValue(setNull(json.LMenu[0].menuTypeCode));
	     cdlbOnchange();
	}	
	function modifyVerify(){
		if (!checkControlValue("m_menucode","String",1,40,null,1,"菜单代码"))
			return false;
		if (!checkControlValue("m_menuname","String",1,50,null,1,"菜单名称"))
			return false;
		if (!checkControlValue("m_funcentry","String",1,500,null,1,"菜单连接"))
			return false;
		if (!checkControlValue("m_parentmenucode","String",1,40,null,0,"上级菜单"))
			return false;
		if (!checkControlValue("m_menufullcode","String",1,400,null,0,"菜单全路径代码"))
			return false;
		if (!checkControlValue("m_nodeorder","Integer",-999999999,999999999,null,1,"排列顺序"))
			return false;
		return true;
	}
	function updateback(json){
		if  (json.result=="success"){
			jAlert(modMessage,'保存信息');
			setPageList($("#pageNo").attr("value"));
			$("#"+detailid).hideAndRemove("slow"); 
			var parCode = $("#m_parentmenucode").attr("value");
			if(parCode=='0'){
				saveOnClick('sysfalg'+$("#m_systemcode").attr("value")); //刷系统新树
			} else {
				saveOnClick($("#m_parentmenucode").attr("value")); //刷菜单新树
			}
		}else{
			jAlert(json.result,'错误信息');
		}		
	}
	
	function cdlbOnchange(){
		var m_menuTypeCode = $("#cdlb").attr("value");
		var m_menuTypeName = $("#cdlb").attr("title");
		$("#m_menuTypeCode").attr("value",m_menuTypeCode);
		$("#m_menuTypeName").attr("value",m_menuTypeName);
		
	}
</script>
<input type="hidden" id="q_menucode">
<input type="hidden" id="m_systemcode">
<input type="hidden" id="m_menulevel">
<input type="hidden" id="m_parentmenucode">
<input type="hidden" id="m_isleaf">
<input type="hidden" id="m_menuTypeCode">
<input type="hidden" id="m_menuTypeName">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">菜单修改</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#menu_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd" width="15%">菜单名称</td>
		<td class="detailtd" width="30%"><input type="text" class="inputstyle"  id="m_menuname" value="" /></td>
		<td class="distd" width="20%">菜单代码</td>
		<td class="detailtd" width="35%"><input type="text"  id="m_menucode" value="" readonly   class="readonly" /></td>
	</tr>
	<tr height="20">
		<td class="distd">排列顺序</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_nodeorder" value="0" /></td>
		 <td class="distd">菜单类别</td>
	<td class="detailtd"><select id="cdlb" onchange="cdlbOnchange();"></select></td>
	</tr>

	<tr height="20">
	  <td class="distd">菜单连接</td>
	  <td class="detailtd" colspan="3"><input type="text" class="inputstyle"  id="m_funcentry" value="" style="width:405;"/></td>
	</tr>
		<tr height="20">
	 <td class="distd">全路径代码</td>
		<td class="detailtd" colspan="3"><input type="text"  id="m_menufullcode" readonly   style="width:405;" class="readonly"  value=""></td>
	</tr>
	
    <tr height="20">
	  <td class="distd">上级菜单</td>
	  <td class="detailtd" colspan="3"><input type="text"  id="mparentmenuname" readonly  style="width:405;"  class="readonly"  value="" /></td>
	</tr>
	<tr height="25" align="center"><td colspan="4">
	<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>