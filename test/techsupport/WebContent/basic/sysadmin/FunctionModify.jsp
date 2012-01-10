<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(21); //按钮右对齐
		$("#q_funccode").attr("value",dataid);
		//$("#m_funccode").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_funccode").attr("value",setNull(json.LFunction[0].funccode));
		$("#m_funcname").attr("value",setNull(json.LFunction[0].funcname));
		$("#m_funcdefine").attr("value",setNull(json.LFunction[0].funcdefine));
		$("#m_functype").attr("value",setNull(json.LFunction[0].functype));
		$("#m_systemcode").attr("value",setNull(json.LFunction[0].systemcode));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_funccode","String",1,50,null,1,"功能代码"))
			return false;
		if (!checkControlValue("m_funcname","String",1,100,null,1,"功能名称"))
			return false;
		if (!checkControlValue("m_funcdefine","String",1,200,null,0,"功能连接"))
			return false;
		if (!checkControlValue("m_functype","Integer",0,9,null,0,"功能类别"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_funccode">
<input type="hidden" id="m_systemcode">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">功能修改</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#function_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd" width="15%">功能名称</td>
		<td class="detailtd" width="30%"><input type="text" class="inputstyle"  id="m_funcname" value="" /></td>
		<td class="distd" width="15%">功能代码</td>
		<td class="detailtd" width="35%"><input type="text"   id="m_funccode" value="" readonly   class="readonly" /></td>
	</tr>
    <tr height="20">
		<td class="distd">功能类别</td>
		<td class="detailtd" colspan="3">
		<select id="m_functype">
		  <option value='1'>类别1</option>
		  <option value='2'>类别2</option>
		  <option value='3'>类别3</option>
		  <option value='4'>类别4</option>
		  <option value='5'>类别5</option>
		  <option value='6'>类别6</option>
		  <option value='7'>类别7</option>
		  <option value='8'>类别8</option>
		  <option value='9'>类别9</option>
		  <option value='10'>类别10</option>
		  </select></td>
	</tr>
	<tr height="20">
		<td class="distd">功能链接</td>
		<td class="detailtd" colspan="3"><input type="text" class="inputstyle"  id="m_funcdefine" value="" style="width:390;"/></td>
	</tr>
	<tr height="25" align="center"><td colspan="4">
	<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a>
	</td></tr>
</table>