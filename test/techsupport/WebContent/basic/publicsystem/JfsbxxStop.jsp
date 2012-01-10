<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(4);
		$("#x_sbzt").selectBox({code:"dm_sbzt"});
		$("#q_anjcsbid").attr("value",aqjcsb_stoprowid);
		$("#x_oldanjcsbid").attr("value",aqjcsb_dataid);
		$("#x_sbzt").setValue("2");
		$("#x_tysj").datepicker();
		aqjcsb_setDetail();
	}); 
	function sbztchange(){ //设备是否停用
		var sbzt = $("#x_sbzt").attr("value");
		$("#x_zt").attr("value",sbzt);
		if($("#x_zt").attr("value")==2 )
        {
	        $("#x_tysj").attr("disabled",false);
	        $("#x_jibr").attr("readonly",false);
	        $("#x_tyyy").attr("readonly",false);
			     
		  }else{
		      $("#x_tysj").attr("value","");
			  $("#x_jibr").attr("value","");
			  $("#x_tyyy").attr("value","");
		      $("#x_tysj").attr("disabled",true);
			  $("#x_jibr").attr("readonly",true);
			  $("#x_tyyy").attr("readonly",true);
		        }
	}
	function aqjcsb_updatediv (json) { 
	    $("#aqjcsbzl").setValue(setNull(json.LAqjcsb[0].aqjcsbzlbm));
		$("#x_aqjcsbzlbm").attr("value",setNull(json.LAqjcsb[0].aqjcsbzlbm));
		$("#x_aqjcsbzlmc").attr("value",setNull(json.LAqjcsb[0].aqjcsbzlmc));
		$("#x_ggxh").attr("value",setNull(json.LAqjcsb[0].ggxh));
		$("#x_sbmc").attr("value",setNull(json.LAqjcsb[0].sbmc));
		$("#x_lrr").attr("value",setNull(json.LAqjcsb[0].lrr));
		$("#x_lrsj").attr("value",setNull(json.LAqjcsb[0].lrsj));
		$("#x_azsl").attr("value",setNull(json.LAqjcsb[0].azsl));
		$("#x_hylb").attr("value",setNull(json.LAqjcsb[0].hylb));
		$("#x_qymc").attr("value",setNull(json.LAqjcsb[0].qymc));
		$("#x_tysj").attr("value",setNull(json.LAqjcsb[0].tysj));
		$("#x_jibr").attr("value",setNull(json.LAqjcsb[0].jibr));
		$("#x_tyyy").attr("value",setNull(json.LAqjcsb[0].tyyy));
	}	
	function aqjcsb_modifyVerify(){
	  if($("#x_zt").attr("value")==2){
		  if (!checkControlValue("x_jibr","String",1,20,null,1,"经办人"))
				return false;
		  if (!checkControlValue("x_tysj","Date",1,20,null,1,"停用时间"))
				return false;
		  if (!checkControlValue("x_tyyy","String",1,200,null,1,"停用原因"))
				return false;
		   	}
		return true;
	}
</script>
<input type="hidden" id="q_anjcsbid">
<input type="hidden" id="x_oldanjcsbid">
<span id="closeFlag"></span>
<input type="hidden" id="x_listtype" value="jfsb">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">技防设备停用</td>
      <td  align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#closeFlag").parent().hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
   <tr>
      <td >行业类别</td>
	  <td ><input type="text" class="readonly"   id="x_hylb" /></td>
		<td>企业名称</td>
	  <td  colspan="3"><input type="text" class="readonly"  style="width:98.7%" id="x_qymc" /></td>
	</tr>
	<tr >
	    <td width="12%">设备名称</td>  
		<td class="pagetd1" width="21%"><input type="text" class="readonly"  id="x_sbmc" value="">
		<input type="text" style="display:none" class="readonly"  id="x_azsl" value=""></td>
		<td  width="11%">规格型号</td>
        <td class="pagetd1" width="22%"><input type="text" class="readonly" id="x_ggxh" value=""></td>
		<td  width="13%" >技防设备种类</td>
		<td  width="21%" ><input type="text" class="readonly" id="x_aqjcsbzlmc" >
		</td>
		<input type="hidden" id="x_aqjcsbzlbm" value="">
	</tr>
	<tr >
		<td  class="pagedistd1" >填报人</td>
		<td class="pagetd1"><input type="text" id="x_lrr" class="readonly" /></td>
		<td  class="pagedistd1">填报时间</td>
		<td class="pagetd1" ><input type="text" id="x_lrsj" class="readonly" /></td>
		<td  class="red">设备状态</td>
        <td class="detailtd" ><select id="x_sbzt" onchange="sbztchange();"></select></td>
	</tr>
	<tr >
		<td  class="red">经办人</td>
      <td  width="20%"><input type="text" class="inputstyle"  id="x_jibr" /></td>
      <input type="hidden" id="x_zt" value="2"/>
	    <td  class="red" width="13%">停用时间</td>
	    <td  width="20%"><input type="text" class="readonly"  id="x_tysj" /></td>
	</tr>
	<tr>
		<td  class="red" valign="top">停用原因</td>
      <td  colspan="5"><textarea id="x_tyyy" style="width:98.7%"></textarea></td>
  </tr>
<tr height="25" align="center"><td  colspan="6"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='aqjcsb_stop();'>保存</a></td></tr>
</table>
