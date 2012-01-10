<%@ page language="java" pageEncoding="UTF-8" import="com.aisino2.sysadmin.domain.*,java.util.*,java.text.*,com.aisino2.sysadmin.Constants"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%

User user = (User)session.getAttribute(Constants.userKey);
String name=user.getUsername();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
String da=sdf.format(new Date());
 %>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(36); 
		$("#a_ryid").val($("#get_ryid").val());
		$("#a_qyid").val($("#get_qyid").val());
		$("#a_tijianrq").attr("readonly","true");
		$("#a_tijianrq").datepicker();
	//	setDetail_cyry_tjxx();
	}); 
	function addVerify_cyry_tjxx(){
		if (!checkControlValue("a_tijianrq","Date",null,null,null,1,"体检日期"))
			return false;
		if (!checkControlValue("a_tjzkjms","String",1,2000,null,1,"体检状况及描述"))
			return false;
		return true;
	}
	
	function addAll_cyry_tjxx(){
	setAdd_cyry_tjxx();
	}
	
function setAdd_cyry_tjxx(){
	if (addVerify_cyry_tjxx()){
		setParams("a_");
		jQuery.post(addUrl_cyry_tjxx,params,addback_cyry_tjxx,"json");
	}else{
		return addVerify_cyry_tjxx();
	}	
}	

function addback_cyry_tjxx(json){
	if  (json.result=="success"){
		jAlert(addMessage,'提示信息');
		$("#a_tijianrq").val("");
		$("#a_tjzkjms").val("");
		setPageList_cyry_tjxx($("#pageNo").attr("value"));
	}else{
		jAlert(json.result,'错误信息');
	}		
}	
	
function setDetail_cyry_tjxx(){
	setParams("q_");
	jQuery.post(detailUrl_cyry_tjxx,params,updatediv_cyry_tjxx,"json");
}

function updatediv_cyry_tjxx(json){
	$("#a_lrr").val(setNull(json.LQyry_tjxx[0].lrr));
	$("#a_lrrq").val(setNull(json.LQyry_tjxx[0].lrrq).substr(0,10));
}
</script>
<input type="hidden" id="a_ryid" value="">
<input type="hidden" id="a_qyid" value="">
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">体检信息添加</td>
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
<table width="100%" id="add">
	<tr height="20">
		<td class="red">体检日期</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_tijianrq" value=""></td>
	</tr>
	<tr height="20">
	  <td class="red">体检状况及描述</td>
	  <td class="detailtd">
	    <textarea name="textarea"  id="a_tjzkjms" cols="55" rows="5"></textarea>
   </td>
  </tr>
	<tr height="20">
		<td class="distd">录入人</td>
		<td class="detailtd"><input type="text" class="readonly" id="a_lrr" readonly value="<%=name %>"/></td>
	</tr>
	<tr height="20">
	  <td class="distd">录入日期</td>
	  <td class="detailtd"><input type="text" class="readonly"" id="a_lrrq" readonly value="<%=da %>" /></td>
  </tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='addAll_cyry_tjxx();'>保存</a></td>
	</tr>
</table>
