<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qycfid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qyid").append(setNull(json.LQyjcxx[0].qyid));
		$("#qycfid").append(setNull(json.LQyjcxx[0].qycfid));
		$("#hylbdm").append(setNull(json.LQyjcxx[0].hylbdm));
		$("#hylb").append(setNull(json.LQyjcxx[0].hylb));
		$("#qyjcrq").append(setNull(json.LQyjcxx[0].qyjcrq));
		$("#cfdjxh").append(setNull(json.LQyjcxx[0].cfdjxh));
		$("#cflbbm").append(setNull(json.LQyjcxx[0].cflbbm));
		$("#cflb").append(setNull(json.LQyjcxx[0].cflb));
		$("#jcmxlbdm").append(setNull(json.LQyjcxx[0].jcmxlbdm));
		$("#jcmxlb").append(setNull(json.LQyjcxx[0].jcmxlb));
		$("#xzcfpzwh").append(setNull(json.LQyjcxx[0].xzcfpzwh));
		$("#pzjgdm").append(setNull(json.LQyjcxx[0].pzjgdm));
		$("#pzjg").append(setNull(json.LQyjcxx[0].pzjg));
		$("#pzrbh").append(setNull(json.LQyjcxx[0].pzrbh));
		$("#pzrxm").append(setNull(json.LQyjcxx[0].pzrxm));
		$("#pzrq").append(setNull(json.LQyjcxx[0].pzrq));
		$("#zxrbh").append(setNull(json.LQyjcxx[0].zxrbh));
		$("#zxrxm").append(setNull(json.LQyjcxx[0].zxrxm));
		$("#zxrq").append(setNull(json.LQyjcxx[0].zxrq));
		$("#qkms").append(setNull(json.LQyjcxx[0].qkms));
		$("#yjly").append(setNull(json.LQyjcxx[0].yjly));
		$("#jcfd").append(setNull(json.LQyjcxx[0].jcfd));
		$("#bjcr").append(setNull(json.LQyjcxx[0].bjcr));
		$("#qymc").append(setNull(json.LQyjcxx[0].qymc));
		$("#qybm").append(setNull(json.LQyjcxx[0].qybm));
	}	
</script>
<input type="hidden" id="q_qycfid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#qyjcxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="detail" class="detail">
	<tr height="20">
			<td class="distd1" width="20%">行业类别</td>
		<td class="detailtd2" width="30%">
		<span   id="hylb" value="">
		</td>
			<td class="distd1" width="20%"> </td>
		<td class="detailtd2" width="30%">
		 
		</td>
		
	</tr>
    <tr height="20">
			<td class="distd1" width="20%">企业名称</td>
		<td class="detailtd2" width="30%">
		<span type="text"class="spanstyle" id="qymc" value="" readonly="readonly">
		</td>
			<td class="distd1" width="20%">企业编码</td>
		<td class="detailtd2" width="30%">
		<span type="text"class="spanstyle" id="qybm" value="" readonly="readonly">
		</td>
		
	</tr>
	<tr height="20"> 
		<td class="distd1" width="20%">奖惩登记序号</td>
		<td class="detailtd2" style="word-break : break-all; width:200px;  " width="30%"><span  id="cfdjxh" value=""></td>
	<td class="distd1" width="20%">行政奖惩批准文号</td>
		<td class="detailtd2" width="30%" style="width: 150px;"><span   id="xzcfpzwh" value=""></td>
	</tr>
	
	<tr height="20">
		<td class="distd1" width="20%">奖惩类别</td>
		<td class="detailtd2" width="30%">
		<span   id="cflb" >
		
		</td>
		<td class="distd1" width="20%">奖惩明细类别</td>
		<td class="detailtd2" width="30%">
		<span   id="jcmxlb" value="">
		</td>
	</tr>
	<tr height="20">
		<td class="distd1" width="20%">批准机构</td>
		<td class="detailtd2" width="30%">
		<span   id="pzjg" value=""  >
		</td>
		<td class="distd1" width="20%">批准人编号</td>
		<td class="detailtd2" width="30%" style="width: 150px;"><span type="text"class="spanstyle" id="pzrbh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd1" width="20%">批准人姓名</td>
		<td class="detailtd2" width="30%" style="width: 200px;"><span type="text"class="spanstyle" id="pzrxm" value=""></td>
		<td class="distd1" width="20%">批准日期</td>
		<td class="detailtd2" width="30%"><span type="text"class="spanstyle" id="pzrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd1" width="20%">执行人编号</td>
		<td class="detailtd2" width="30%"><span type="text"class="spanstyle" id="zxrbh" value=""></td>
		<td class="distd1" width="20%">执行人姓名</td>
		<td class="detailtd2" width="30%" style="width: 150px;"><span type="text"  id="zxrxm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd1" width="20%">执行日期</td>
		<td class="detailtd2" width="30%"><span type="text"  id="zxrq" value=""></td>
		<td class="distd1" width="20%">奖惩幅度</td>
		<td class="detailtd2" width="30%" style="width: 150px;"><span type="text"  id="jcfd" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd1" width="20%" >被奖惩人</td>
		<td class="detailtd2" width="30%" style="width: 200px;"><span type="text"  id="bjcr" value=""></td>
		<td class="distd1" width="20%">企业奖惩日期</td>
		<td class="detailtd2" width="30%"><span type="text"  id="qyjcrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd1">情况描述</td>
		<td colspan="5" class="detailtd2">
		  <textarea name="textarea" id="qkms"  cols="55" rows="5" readonly="readonly"></textarea>
    </td>
	</tr>
	<tr height="20">
		<td class="distd1">依据理由</td>
		<td colspan="5" class="detailtd2">
		  <textarea name="textarea" id="yjly"  cols="55" rows="5" readonly="readonly"></textarea>
    </td>
	</tr>
</table>