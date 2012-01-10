<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(13); //按钮右对齐
		$("#q_systemcode").attr("value",dataid);
		//$("#m_systemcode").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_systemcode").attr("value",setNull(json.LSystem[0].systemcode));
		$("#m_systemname").attr("value",setNull(json.LSystem[0].systemname));
		$("#m_systemdefine").attr("value",setNull(json.LSystem[0].systemdefine));
		$("#m_picturepath").attr("value",setNull(json.LSystem[0].picturepath));
		$("#m_nodeorder").attr("value",setNull(json.LSystem[0].nodeorder));
		$("#m_fullcode").attr("value",setNull(json.LSystem[0].fullcode));
		$("#m_parentsystemcode").attr("value",setNull(json.LSystem[0].parentsystemcode));
		$("#m_isleaf").attr("value",setNull(json.LSystem[0].isleaf));
		$("#mparentsystemname").attr("value",setNull(json.LSystem[0].parentsystemname));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_systemcode","String",1,20,null,1,"系统代码"))
			return false;
		if (!checkControlValue("m_systemname","String",1,50,null,1,"系统名称"))
			return false;
		if (!checkControlValue("m_systemdefine","String",1,200,null,0,"系统定义"))
			return false;
		if (!checkControlValue("m_picturepath","String",1,200,null,0,"图片路径"))
			return false;
		if (!checkControlValue("m_parentsystemcode","String",1,20,null,0,"上级系统"))
			return false;
		if (!checkControlValue("m_nodeorder","Integer",-999999999,999999999,null,1,"排列顺序"))
			return false;
		if (!checkControlValue("m_fullcode","String",1,50,null,0,"系统全路径代码"))
			return false;
		return true;
	}
	function updateback(json){
		if  (json.result=="success"){
			jAlert(modMessage,'保存信息');
			setPageList($("#pageNo").attr("value"));
			$("#"+detailid).hideAndRemove("slow"); 
			saveOnClickedit($("#m_parentsystemcode").attr("value"),$("#m_systemcode").attr("value")); //刷新树
		}else{
			jAlert(json.result,'错误信息');
		}		
	}
	function saveOnClickedit(parentCode,code){
	    tree.refreshItem(parentCode);
	    //alert("更新成功");
	    tree.selectItem(parentCode,true);
	}
</script>
<input type="hidden" id="q_systemcode">
<input type="hidden" id="m_parentsystemcode">
<input type="hidden" id="m_isleaf">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">系统修改</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#system_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>

<table width="100%" id="modify">
	<tr height="20">
		<td class="distd" width="15%">系统名称</td>
		<td class="detailtd" width="30%"><input type="text" class="inputstyle"  id="m_systemname" value="" /></td>
		<td class="distd" width="20%">系统代码</td>
		<td class="detailtd" width="35%"><input type="text" id="m_systemcode" value="" readonly   class="readonly" /></td>
	</tr>
	<tr height="20">
        <td class="distd">系统定义</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_systemdefine" value=""></td>
		<td class="distd">上级系统</td>
		<td class="detailtd"><input type="text" readonly   class="readonly" id="mparentsystemname" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">排列顺序</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_nodeorder" value="0" /></td>
		<td height="20" class="distd">系统全路径代码</td>
		<td class="detailtd"><input readonly   class="readonly" type="text" id="m_fullcode" value="" /></td>
	</tr>
	<tr height="20">
		<td class="distd">图片路径</td>
		<td class="detailtd" colspan="3"><input type="text" class="inputstyle"  id="m_picturepath" value="" style="width:405;"/></td>
	</tr>
	<tr height="25" align="center"><td colspan="4">
	<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a>
	</td></tr>
</table>
