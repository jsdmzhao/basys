<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(2); //按钮右对齐
		$("#q_departid").attr("value",dataid);
		//$("#m_departid").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_departid").attr("value",setNull(json.LDepartment[0].departid));
		$("#m_departcode").attr("value",setNull(json.LDepartment[0].departcode));
		$("#m_departname").attr("value",setNull(json.LDepartment[0].departname));
		$("#m_departlevel").attr("value",setNull(json.LDepartment[0].departlevel));
		$("#m_parentdepartid").attr("value",setNull(json.LDepartment[0].parentdepartid));
		$("#m_departfullcode").attr("value",setNull(json.LDepartment[0].departfullcode));
		$("#m_nodeorder").attr("value",setNull(json.LDepartment[0].nodeorder));
		$("#m_isleaf").attr("value",setNull(json.LDepartment[0].isleaf));
		$("#m_departsimplepin").attr("value",setNull(json.LDepartment[0].departsimplepin));
		$("#m_departallpin").attr("value",setNull(json.LDepartment[0].departallpin));
		$("#mparentdepartname").attr("value",setNull(json.LDepartment[0].parentdepartname));
		
	}	
	function modifyVerify(){
		if (!checkControlValue("m_departcode","String",1,20,null,1,"机构代码"))
			return false;
		if (!checkControlValue("m_departname","String",1,50,null,1,"机构名称"))
			return false;
		if (!checkControlValue("m_parentdepartid","Integer",-999999999,999999999,null,0,"父机构ID"))
			return false;
		if (!checkControlValue("m_departfullcode","String",1,200,null,0,"机构全路径代码"))
			return false;
		if (!checkControlValue("m_nodeorder","Integer",-999999999,999999999,null,1,"节点顺序"))
			return false;
		return true;
	}
	function updateback(json){
		if  (json.result=="success"){
			jAlert(modMessage,'保存信息');
			setPageList($("#pageNo").attr("value"));
			$("#"+detailid).hideAndRemove("slow"); 
			saveOnClick($("#m_parentdepartid").attr("value")); //刷新树
		}else{
			jAlert(json.result,'错误信息');
		}		
	}
</script>
<input type="hidden" id="q_departid">
<input type="hidden" id="m_departid">
<input type="hidden" id="m_departlevel">
<input type="hidden" id="m_parentdepartid">
<input type="hidden" id="m_isleaf">
<input type="hidden" id="m_departsimplepin">
<input type="hidden" id="m_departallpin">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">机构修改</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#department_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>

<table width="100%" id="modify">
	<tr height="20">
		<td class="distd" width="18%">机构名称</td>
		<td class="detailtd" width="35%"><input type="text" class="inputstyle"  id="m_departname" value=""></td>
		<td class="distd" width="15%">机构代码</td>
		<td class="detailtd" width="32%"><input type="text" id="m_departcode" value="" readonly class="readonly"></td>
	<tr height="20">
		<td class="distd">上级机构</td>
		<td class="detailtd"><input type="text" readonly   class="readonly" id="mparentdepartname" value=""></td>
		<td class="distd">排列数序</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_nodeorder" value=""></td>
	<tr height="20">
		<td class="distd">机构全路径代码</td>
		<td colspan="3" class="detailtd"><input type="text" style="width:400px" readonly class="readonly" id="m_departfullcode"></td></tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td>
	</tr>
</table>
