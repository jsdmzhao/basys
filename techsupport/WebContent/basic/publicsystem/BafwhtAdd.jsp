<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(35); 
		$("#a_barypxjsrq").attr("readonly","true").datepicker();
		$("#a_qdrq").attr("readonly","true").datepicker();
		$("#a_balxdm").selectBox({code:"dm_balx"});
		//$("#a_jsrq").attr("readonly","true");
		//$("#a_jsrq").datepicker();
	}); 
	function bafwht_addVerify(){
		if (!checkControlValue("a_bafwgsmc","String",1,200,null,1,"保安服务公司名称"))
			return false;
		if (!checkControlValue("a_htbh","String",1,30,null,1,"合同编号"))
			return false;
		if (!checkControlValue("a_qdrq","Date",null,null,null,1,"签订日期"))
			return false;
		if (!checkControlValue("a_htyxq","Integer",1,99,null,1,"合同有效期"))
		    return false;
		if (!checkControlValue("a_balxdm","Select",1,32,null,1,"保安类型"))
			return false;
		if (!checkControlValue("a_fzjgmc","String",1,64,null,0,"发证机构"))
			return false;
		if (!checkControlValue("a_barypxjsrq","Date",1,64,null,0,"保安人员培训结束日期"))
			return false;
		if (!checkControlValue("a_baryzgzsmc","String",1,50,null,0,"保安员资格证书编号"))
			return false;
		if (!checkControlValue("a_barypxnr","String",1,2000,null,0,"保安人员培训内容"))
			return false;
		var strDate = $("#a_qdrq").val();
		var strYear = strDate.substring(0,4);
		var strMonth = strDate.substring(5,7);
		var strDay = strDate.substring(8,10);
		var intYear = parseInt(strYear) + parseInt($("#a_htyxq").val());
		$("#a_jsrq").val(intYear+"-"+strMonth+"-"+strDay);
		$("#a_balxmc").val($("#a_balxdm").attr("title"));
		return true;
	}
</script>
<input type="hidden" id="a_jsrq" />
<input type="hidden" id="a_balxmc" />

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">保安服务信息添加</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#bafwht_detail").hide("show");'class="close"></a>
      </td>
    </tr>
</table>

<table width="100%" id="add">
	<tr><td height="10"></td></tr>
	<tr height="20">
	  <td width="45%" class="red">保安服务公司名称</td>
	  <td width="55%" colspan="2" class="detailtd"><input type="text" class="inputstyle"  id="a_bafwgsmc" value="" /></td>
	</tr>
	<tr height="20">
		<td class="red">合同编号</td>
		<td colspan="2" class="detailtd"><input type="text" class="inputstyle"  id="a_htbh" value="" /></td>
	</tr>
	<tr height="20">
	  <td class="red">签订日期</td>
      <td colspan="2" class="detailtd"><input type="text" class="inputstyle"  id="a_qdrq" value="" /></td>
	</tr>
	<tr height="20">
      <td class="red">合同有效期</td>
	  <td colspan="2" class="detailtd"><input type="text" class="inputstyle"  id="a_htyxq" value="" /></td>
	</tr>
	<tr height="20">
      <td class="red">保安类型</td>
	  <td colspan="2" class="detailtd"><select id="a_balxdm"><option></option></select></td>
	</tr>
	<tr height="20">
      <td class="distd">发证机构</td>
	  <td colspan="2" class="detailtd"><input type="text" class="inputstyle"  id="a_fzjgmc" value="" /></td>
	</tr>
	<tr height="20">
      <td class="distd">保安人员培训结束日期</td>
	  <td colspan="2" class="detailtd"><input type="text" class="inputstyle"  id="a_barypxjsrq" value="" /></td>
	</tr>
	<tr height="20">
      <td class="distd">保安员资格证书编号</td>
	  <td colspan="2" class="detailtd"><input type="text" class="inputstyle"  id="a_baryzgzsmc" value="" /></td>
	</tr>
	<tr height="20">
		<td class="distd">保安人员培训内容</td>
		<td colspan="2" class="detailtd"><textarea name="textarea" id="a_barypxnr" cols="17" rows="2"></textarea></td>
	</tr>
	<tr height="20">
	  <td ></td>
	  <td style="padding-bottom:2px; text-align:left"><input type="checkbox" name="checkbox" id="bafwht_checkbox" >继续</td>
      <td align="right" style="padding-right: 50"><a href="#" hidefocus="true" class="submitbutton" title="保存" onclick='bafwht_setAdd();'>保存</a></td>
	</tr>
	<tr><td height="10"></td></tr>
</table>
