<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_roleid").attr("value",dataid);
		if(isSjyh=='1'){ //非省级用户锁定
			yincangJz(); //隐藏警种字段 20100329 杨提出
		}
		setDetail();
	}); 
	function updatediv (json) { 
		$("#rolename").append(setNull(json.LRole[0].rolename));
		$("#roledescription").append(setNull(json.LRole[0].roledescription));
		//$("#roletype").append(setNull(json.LRole[0].roletype));
		var jz = setNull(json.LRole[0].jzlbmc);
		if(jz==""){
			jz='无警种';
		}
		$("#jzlbmc").append(jz);
	}
	function yincangJz(){ //隐藏警种字段 20100329 杨提出
		$("#jz_tr").hide();
	}
</script>
<input type="hidden" id="q_roleid">
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">角色详细</td>
      <td><a href="#" id="closeDiv" onclick='$("#role_detail").hideAndRemove("show");'class="close"></a></td>
    </tr>
     <tr>
      <td align="left"></td>
      <td></td>
    </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table></div>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1" width="30%">角色名称</td>
		<td class="detailtd2" width="70%"><span id="rolename"></span></td>
	</tr>
	
	<tr height="20">
		<td class="distd1">角色描述</td>
		<td class="detailtd2"><span id="roledescription"></span></td>
	</tr>
	<tr height="20" id="jz_tr">
		<td class="distd1">警种类别</td>
		<td class="detailtd2"><span id="jzlbmc"></span></td>
	</tr>
	<!--  
	<tr height="20">
		<td class="distd1">角色类别</td>
		<td class="detailtd2"><span id="roletype"></span></td>
	</tr>
	-->
</table>