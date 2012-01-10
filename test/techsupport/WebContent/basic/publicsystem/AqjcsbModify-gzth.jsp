<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(4);
		$("#aqjcsbzl").selectBox({code:"dm_aqjcsbzl"});
		aqjcsbzlOnchange();
		$("#q_anjcsbid").attr("value",aqjcsb_modifyrowid);
		$("#x_oldanjcsbid").attr("value",aqjcsb_dataid);
		aqjcsb_setDetail();
	}); 
	function aqjcsbzlOnchange(){
		var aqjcsbzlkey = $("#aqjcsbzl").attr("value");
		var aqjcsbzlval = $("#aqjcsbzl").attr("title");
		$("#x_aqjcsbzlbm").attr("value",aqjcsbzlkey);
		$("#x_aqjcsbzlmc").attr("value",aqjcsbzlval);
	}
	function aqjcsb_updatediv (json) { 
	    $("#aqjcsbzl").setValue(setNull(json.LAqjcsb[0].aqjcsbzlbm));
		$("#x_aqjcsbzlbm").attr("value",setNull(json.LAqjcsb[0].aqjcsbzlbm));
		$("#x_aqjcsbzlmc").attr("value",setNull(json.LAqjcsb[0].aqjcsbzlmc));
		$("#x_ggxh").attr("value",setNull(json.LAqjcsb[0].ggxh));
		$("#x_sbmc").attr("value",setNull(json.LAqjcsb[0].sbmc));
		$("#x_azsl").attr("value",setNull(json.LAqjcsb[0].azsl));
		$("#x_bz").attr("value",setNull(json.LAqjcsb[0].bz));
		$("#x_zt").attr("value",setNull(json.LAqjcsb[0].zt));
		$("#x_hylb").attr("value",setNull(json.LAqjcsb[0].hylb));
		$("#x_qymc").attr("value",setNull(json.LAqjcsb[0].qymc));
		$("#x_lrr").attr("value",setNull(json.LAqjcsb[0].lrr));
		$("#x_lrsj").attr("value",setNull(json.LAqjcsb[0].lrsj));
	}	
	function aqjcsb_modifyVerify(){
		if (!checkControlValue("x_sbmc","String",1,100,null,1,"设备名称"))
			return false;
		if (!checkControlValue("x_ggxh","String",1,100,null,1,"规格型号"))
			return false;
		if (!checkControlValue("x_aqjcsbzlbm","String",1,20,null,1,"技防设备种类"))
			return false;
		if (!checkControlValue("x_azsl","Integer",0,999999,null,1,"数量"))
			return false;
		if (!checkControlValue("x_bz","String",1,2000,null,0,"备注"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_anjcsbid">
<input type="hidden" id="x_oldanjcsbid">
<input type="hidden" id="x_hylb">
<input type="hidden" id="x_qymc">
<input type="hidden" id="x_lrr">
<input type="hidden" id="x_lrsj">
<input type="hidden" id="x_zt">
<input type="hidden" id="x_listtype" value="jfsb">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">技防设备修改</td>
      <td  align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#aqjcsb_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr>
	    <td class="red" width="12%">设备名称</td>
		<td class="pagetd1" width="21%"><input type="text" class="inputstyle"  id="x_sbmc" value=""></td>
		<td class="red" width="11%">规格型号</td>
        <td class="pagetd1" width="22%"><input type="text" class="inputstyle"  id="x_ggxh" value=""></td>
		<td class="red" width="13%">技防设备种类</td>
		<td class="pagetd1" width="21%">
		<select name="select" id="aqjcsbzl" onchange="aqjcsbzlOnchange();">
		</select></td>
		<input type="hidden" id="x_aqjcsbzlbm" value="">
		<input type="hidden" id="x_aqjcsbzlmc" value="">
	</tr>
	<tr>
	<td class="red" width="10%">数量</td>
      <td class="pagetd1"><input type="text" class="inputstyle"  id="x_azsl" onkeyup="value=value.replace(/[^\d]/g,'')"
      							onblur="value=value.replace(/[^\d]/g,'')"/></td>
      <td class="pagedistd1">&nbsp;</td>
      <td class="pagetd1">&nbsp;</td>
      <td class="pagedistd1">&nbsp;</td>
      <td class="pagetd1">&nbsp;</td>
    </tr>
	<tr>
	  <td class="distd">备注</td>
      <td class="detailtd" colspan="5"><textarea name="textarea" id="x_bz" cols="83" rows="2" style="width:98.7%" ></textarea></td>
  </tr>
<tr height="25" align="center"><td  colspan="6"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='aqjcsb_modify();'>保存</a></td></tr>
</table>
