<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(56);
		$("#aqjcsbzl").selectBox({code:"dm_aqjcsbzl"});
		aqjcsbzlOnchange();
		$("#q_anjcsbid").attr("value",aqjcsb_dataid);
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
		$("#x_sbxh").attr("value",setNull(json.LAqjcsb[0].sbxh));
		$("#x_ggxh").attr("value",setNull(json.LAqjcsb[0].ggxh));
		$("#x_sbmc").attr("value",setNull(json.LAqjcsb[0].sbmc));
		$("#x_azsl").attr("value",setNull(json.LAqjcsb[0].azsl));
	}	
	function aqjcsb_modifyVerify(){
		if (!checkControlValue("x_sbmc","String",1,100,null,1,"设备名称"))
			return false;
		if (!checkControlValue("x_ggxh","String",1,100,null,1,"规格型号"))
			return false;
		if (!checkControlValue("x_azsl","Integer",0,6,null,0,"安装数量"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_anjcsbid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">安全检查设备信息修改</td>
      <td  align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#aqjcsb_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr>
		<td class="red">设备名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="x_sbmc" value=""></td>
	</tr>
	<tr>
	  <td class="red">规格型号</td>
      <td class="detailtd"><input type="text" class="inputstyle"  id="x_ggxh" value=""></td>
	</tr>
	<tr>
		<td class="red" width="40%">安全检查设备种类</td>
		<td class="detailtd" width="60%">
		<select name="select" id="aqjcsbzl" onchange="aqjcsbzlOnchange();">
		</select></td>
		<input type="hidden" id="x_aqjcsbzlbm" value="">
		<input type="hidden" id="x_aqjcsbzlmc" value="">
	</tr>
	<tr>
	  <td class="distd">安装数量</td>
      <td class="detailtd"><input type="text" class="inputstyle"  id="x_azsl" value=""></td>
  </tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='aqjcsb_modify();'>保存</a></td></tr>
</table>
