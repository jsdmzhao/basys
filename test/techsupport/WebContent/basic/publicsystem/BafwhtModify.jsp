<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		 bc_bottonMoveRight(35); 
		$("#xx_barypxjsrq").attr("readonly","true").datepicker();
		$("#xx_qdrq").attr("readonly","true").datepicker();
		$("#xx_balxdm").selectBox({code:"dm_balx"});
		$("#q_bafwhtid").attr("value",bafwht_rowselect);
		bafwht_setDetail();
	}); 
	function bafwht_updatediv (json) { 
		$("#xx_balxdm").setValue(setNull(json.LBafwht[0].balxdm));
		$("#xx_bafwgsmc").attr("value",setNull(json.LBafwht[0].bafwgsmc));
		$("#xx_baryzgzsmc").attr("value",setNull(json.LBafwht[0].baryzgzsmc));
		$("#xx_barypxjsrq").attr("value",setNull(json.LBafwht[0].barypxjsrq).substr(0,10));
		$("#xx_htbh").attr("value",setNull(json.LBafwht[0].htbh));
		$("#xx_qdrq").attr("value",setNull(json.LBafwht[0].qdrq).substr(0,10));
		$("#xx_jsrq").attr("value",setNull(json.LBafwht[0].jsrq).substr(0,10));
		$("#xx_htyxq").attr("value",setNull(json.LBafwht[0].htyxq));
		$("#xx_barypxnr").attr("value",setNull(json.LBafwht[0].barypxnr));
		$("#xx_balxmc").attr("value",setNull(json.LBafwht[0].balxmc));
		$("#xx_fzjgmc").attr("value",setNull(json.LBafwht[0].fzjgmc));
		$("#xx_barypxjsrq").attr("value",setNull(json.LBafwht[0].barypxjsrq));
		$("#xx_baryzgzsmc").attr("value",setNull(json.LBafwht[0].baryzgzsmc));
	}	
	function bafwht_modifyVerify(){
		if (!checkControlValue("xx_bafwgsmc","String",1,200,null,1,"保安服务公司名称"))
			return false;
		if (!checkControlValue("xx_htbh","String",1,30,null,1,"合同编号"))
			return false;
		if (!checkControlValue("xx_qdrq","Date",null,null,null,1,"签订日期"))
			return false;
		if (!checkControlValue("xx_htyxq","Integer",1,99,null,1,"合同有效期"))
		    return false;
		if (!checkControlValue("xx_balxdm","Select",1,32,null,1,"保安类型"))
			return false;
		if (!checkControlValue("xx_fzjgmc","String",1,64,null,0,"发证机构"))
			return false;
		if (!checkControlValue("xx_barypxjsrq","Date",1,64,null,0,"保安人员培训结束日期"))
			return false;
		if (!checkControlValue("xx_baryzgzsmc","String",1,50,null,0,"保安员资格证书编号"))
			return false;
		if (!checkControlValue("xx_barypxnr","String",1,2000,null,0,"保安人员培训内容"))
			return false;
		var strDate = $("#xx_qdrq").val();
		var strYear = strDate.substring(0,4);
		var strMonth = strDate.substring(5,7);
		var strDay = strDate.substring(8,10);
		var intYear = parseInt(strYear) + parseInt($("#xx_htyxq").val());
		$("#xx_jsrq").val(intYear+"-"+strMonth+"-"+strDay);
		$("#xx_balxmc").val($("#xx_balxdm").attr("title"));
		return true;
	}
</script>
<input type="hidden" id="q_bafwhtid">
<input type="hidden" id="xx_bafwhtid">
<input type="hidden" id="xx_jsrq" />
<input type="hidden" id="xx_balxmc" />

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">保安服务信息修改</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#bafwht_detail").hide("show");'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr><td height="10"></td></tr>
	<tr height="20">
	  <td width="45%" class="red">保安服务公司名称</td>
	  <td width="55%" class="detailtd"><input type="text" class="inputstyle"  id="xx_bafwgsmc" value="" /></td>
	</tr>
	<tr height="20">
		<td class="red">合同编号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="xx_htbh" value="" /></td>
	</tr>
	<tr height="20">
	  <td class="red">签订日期</td>
      <td class="detailtd"><input type="text" class="inputstyle"  id="xx_qdrq" value="" /></td>
	</tr>
	<tr height="20">
      <td class="red">合同有效期</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="xx_htyxq" value="" /></td>
	</tr>
	<tr height="20">
      <td class="red">保安类型</td>
	  <td class="detailtd"><select id="xx_balxdm"><option></option></select></td>
	</tr>
	<tr height="20">
      <td class="distd">发证机构</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="xx_fzjgmc" value="" /></td>
	</tr>
	<tr height="20">
      <td class="distd">保安人员培训结束日期</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="xx_barypxjsrq" value="" /></td>
	</tr>
	<tr height="20">
      <td class="distd">保安员资格证书编号</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="xx_baryzgzsmc" value="" /></td>
	</tr>
	<tr height="20">
		<td class="distd">保安人员培训内容</td>
		<td class="detailtd"><textarea name="textarea" id="xx_barypxnr" cols="17" rows="2"></textarea></td>
	</tr>
	<tr height="25" align="center"><td colspan="4">
	<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='bafwht_modify();'>保存</a>
	</td></tr>
	<tr><td height="10"></td></tr>
</table>
