<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(36); //按钮右对齐
		$("#bq_jzlbdm_add").selectBox({code:"dm_jzlb"});
		if(jzlbdm!=''){
			$("#bq_jzlbdm_add").setValue(jzlbdm);
			$("#a_jzlbmc").attr("value",jzlbmc);
			$("#a_jzlbdm").attr("value",jzlbdm);
		}
		if(isSjyh=='1'){ //非省级用户锁定
			$("#bq_jzlbdm_add").setAttr("readonly","true"); //锁定
			yincangJz(); //隐藏警种字段 20100329 杨提出
		}
		$("#a_departid").val($("#p_departid").val());
	}); 
	function addVerify(){
		if (!checkControlValue("a_rolename","String",1,50,null,1,"角色名称"))
			return false;
		if (!checkControlValue("a_roledescription","String",1,100,null,0,"角色描述"))
			return false;
		if (!checkControlValue("a_roletype","Integer",-9,9,null,0,"角色类别"))
			return false;
		return true;
	}
	function jzlbOnchangeAdd(){
		var jzlbdm = $("#bq_jzlbdm_add").attr("value");
		var jzlbmc = $("#bq_jzlbdm_add").attr("title");
		$("#a_jzlbdm").attr("value",jzlbdm);
		$("#a_jzlbmc").attr("value",jzlbmc);
	}
	function yincangJz(){ //隐藏警种字段 20100329 杨提出
		$("#jz_tr").hide();
	}
</script>
<input type="hidden" id="a_departid">
<input type="hidden" id="a_roletype" value="0">
<input type="hidden" id="a_jzlbdm"/>
<input type="hidden" id="a_jzlbmc"/>
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">角色添加</td>
      <td><a href="#" id="closeDiv" onclick='$("#role_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
     <tr>
      <td align="left"></td>
      <td></td>
    </tr>
</table></div>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">角色名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_rolename" value=""></td>
	</tr>
	<!--  
	<tr height="20">
		<td class="distd">角色类别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_roletype" value="0"></td>
	</tr>
	-->
	<tr height="20">
	  <td class="distd">角色描述</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="a_roledescription" value="" /></td>
	</tr>
	<tr height="20" id="jz_tr">
		<td class="distd">警种</td>
	    <td class="detailtd"><select id="bq_jzlbdm_add" onchange="jzlbOnchangeAdd();"><option></option></select></td>
	</tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setAdd();'>保存</a></td>
	</tr>
</table>