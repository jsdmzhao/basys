<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(36); 
		$("#q_tjxxid").attr("value",dataid);
		$("#m_ryid").val($("#get_ryid").val());
		$("#m_qyid").val($("#get_qyid").val());
		$("#m_tjxxid").val(dataid);
		setDetail_cyry_tjxx();
		$("#m_tijianrq").attr("readonly","true");
		$("#m_tijianrq").datepicker();
	}); 
		
	function modifyVerify_cyry_tjxx(){
		if (!checkControlValue("m_tijianrq","Date",null,null,null,1,"体检日期"))
			return false;
		if (!checkControlValue("m_tjzkjms","String",1,2000,null,1,"体检状况及描述"))
			return false;
		return true;
	}
	
	
	function updateAll_cyry_tjxx(){
	setUpdate_cyry_tjxx();
	}
	
function setUpdate_cyry_tjxx(){
	if (modifyVerify_cyry_tjxx()){
		setParams("m_");
		jQuery.post(modUrl_cyry_tjxx,params,updateback_cyry_tjxx,"json");
	}else{
		return modifyVerify_cyry_tjxx();
	}	
}	

function updateback_cyry_tjxx(json){
	if  (json.result=="success"){
		jAlert("修改成功",'提示信息');
		setPageList_cyry_tjxx($("#pageNo").attr("value"));
		$("#"+detailid_cyry_tjxx).hide("slow");
	}else{
		jAlert(json.result,'错误信息');
	}		
}	
	
function setDetail_cyry_tjxx(){
	setParams("q_");
	jQuery.post(detailUrl_cyry_tjxx,params,updatediv_cyry_tjxx,"json");
}

function updatediv_cyry_tjxx(json){
	$("#m_tijianrq").attr("value",setNull(json.LQyry_tjxx[0].tijianrq).substr(0,10));
	$("#m_tjzkjms").attr("value",setNull(json.LQyry_tjxx[0].tjzkjms));
	$("#lrr").attr("value",setNull(json.LQyry_tjxx[0].lrr));
	$("#lrrq").attr("value",setNull(json.LQyry_tjxx[0].lrrq).substr(0,10));
}
</script>
<input type="hidden" id="q_tjxxid">
<input type="hidden" id="m_ryid">
<input type="hidden" id="m_tjxxid">
<input type="hidden" id="m_qyid">
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">体检信息修改</td>
      <td><a href="#" id="closeDiv" onclick='$("#cyry_tjxx_detail").hide("show");'class="close"></a>
    </tr>
     <tr>
      <td align="left"></td>
      <td></td>
    </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="6"></td>
		</tr>
	</table></div>
<table width="100%" id="modify">
	<tr height="20">
		<td class="red">体检日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_tijianrq" value=""></td>
	</tr>
	<tr height="20">
	  <td class="red">体检状况及描述</td>
	  <td class="detailtd">
	    <textarea name="textarea"  id="m_tjzkjms" cols="55" rows="5"></textarea>
   </td>
  </tr>
	<tr height="20">
		<td class="distd">录入人</td>
		<td class="detailtd"><input type="text" class="readonly" id="lrr" readonly /></td>
	</tr>
	<tr height="20">
	  <td class="distd">录入日期</td>
	  <td class="detailtd"><input type="text" class="readonly"" id="lrrq" readonly /></td>
  </tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='updateAll_cyry_tjxx();'>保存</a></td>
	</tr>
</table>
