<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(36); //按钮右对齐
		$("#q_roleid").attr("value",dataid);
		$("#m_roleid").attr("value",dataid);
		$("#bq_jzlbdm_mod").selectBox({code:"dm_jzlb"});
		if(jzlbdm!=''){
			$("#bq_jzlbdm_mod").setValue(jzlbdm);
			$("#m_jzlbmc").attr("value",jzlbmc);
			$("#m_jzlbdm").attr("value",jzlbdm);
		}
		if(isSjyh=='1'){ //非省级用户锁定
			$("#bq_jzlbdm_mod").setAttr("readonly","true"); //锁定
			yincangJz(); //隐藏警种字段 20100329 杨提出
		}
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_roleid").val(setNull(json.LRole[0].roleid));
		//$("#m_departid").val(setNull(json.LRole[0].departid));
		$("#m_rolename").val(setNull(json.LRole[0].rolename));
		$("#m_roledescription").val(setNull(json.LRole[0].roledescription));
		$("#m_roletype").val(setNull(json.LRole[0].roletype));
		$("#m_departid").val(setNull(json.LRole[0].departid));
		
		$("#bq_jzlbdm_mod").setValue(setNull(json.LRole[0].jzlbdm));
		$("#m_jzlbdm").attr("value",setNull(json.LRole[0].jzlbdm));
		$("#m_jzlbmc").attr("value",setNull(json.LRole[0].jzlbmc));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_rolename","String",1,50,null,1,"角色名称"))
			return false;
		if (!checkControlValue("m_roledescription","String",1,100,null,0,"角色描述"))
			return false;
		if (!checkControlValue("m_roletype","Integer",-9,9,null,0,"角色类别"))
			return false;
		return true;
	}
	function jzlbOnchangeModify(){
		var jzlbdm = $("#bq_jzlbdm_mod").attr("value");
		var jzlbmc = $("#bq_jzlbdm_mod").attr("title");
		$("#m_jzlbdm").attr("value",jzlbdm);
		$("#m_jzlbmc").attr("value",jzlbmc);
	}
	function yincangJz(){ //隐藏警种字段 20100329 杨提出
		$("#jz_tr").hide();
	}
</script>
<input type="hidden" id="q_roleid">
<input type="hidden" id="m_roleid">
<input type="hidden" id="m_departid">
<input type="hidden" id="m_roletype">
<input type="hidden" id="m_jzlbmc"/>
<input type="hidden" id="m_jzlbdm"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">角色修改</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#role_detail").hideAndRemove("show");'class="close"></a></td>
    </tr>
     <tr>
      <td align="left"></td>
      <td></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">角色名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_rolename" value=""></td>
	</tr>
	<!--  
	<tr height="20">
		<td class="distd">角色类别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_roletype" value="0"></td>
	</tr>
	-->
	<tr height="20">
	  <td class="distd">角色描述</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="m_roledescription" value="" /></td>
	</tr>
	<tr height="20" id="jz_tr">
		<td class="distd">警种</td>
	    <td class="detailtd"><select id="bq_jzlbdm_mod" onchange="jzlbOnchangeModify();"><option></option></select></td>
	</tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td>
	</tr>
</table>
