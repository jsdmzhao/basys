<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjxxid2").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#bjxxid2").append(setNull(json.LWpbjgz[0].bjxxid2));
		$("#wpbjgzid").append(setNull(json.LWpbjgz[0].wpbjgzid));
		$("#ywbm").append(setNull(json.LWpbjgz[0].ywbm));
		$("#ywbzdm").append(setNull(json.LWpbjgz[0].ywbzdm));
		$("#bdbm").append(setNull(json.LWpbjgz[0].bdbm));
		$("#bdbzdm").append(setNull(json.LWpbjgz[0].bdbzdm));
		$("#bdlxdm").append(setNull(json.LWpbjgz[0].bdlxdm));
		$("#bdlx").append(setNull(json.LWpbjgz[0].bdlx));
		$("#sfyx").append(setNull(json.LWpbjgz[0].sfyx));
		$("#fbcl").append(setNull(json.LWpbjgz[0].fbcl));
		$("#fbfs").append(setNull(json.LWpbjgz[0].fbfs));
		$("#txdwzd").append(setNull(json.LWpbjgz[0].txdwzd));
		$("#gxdwzd").append(setNull(json.LWpbjgz[0].gxdwzd));
		$("#bjjb").append(setNull(json.LWpbjgz[0].bjjb));
		$("#bjfs").append(setNull(json.LWpbjgz[0].bjfs));
		$("#bjlxdm").append(setNull(json.LWpbjgz[0].bjlxdm));
		$("#bjlx").append(setNull(json.LWpbjgz[0].bjlx));
		$("#hylbdm").append(setNull(json.LWpbjgz[0].hylbdm));
		$("#hylb").append(setNull(json.LWpbjgz[0].hylb));
	}	
</script>
<input type="hidden" id="q_bjxxid2">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Wpbjgz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="detail">
	<tr height="20">
		<td class="distd1">报警信息ID</td>
		<td class="detailtd2"><span id="bjxxid2"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">物品报警规则ID</td>
		<td class="detailtd2"><span id="wpbjgzid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">业务表名</td>
		<td class="detailtd2"><span id="ywbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">业务表字段名</td>
		<td class="detailtd2"><span id="ywbzdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">比对表名</td>
		<td class="detailtd2"><span id="bdbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">比对表字段名</td>
		<td class="detailtd2"><span id="bdbzdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">比对类型代码</td>
		<td class="detailtd2"><span id="bdlxdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">比对类型</td>
		<td class="detailtd2"><span id="bdlx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">是否有效</td>
		<td class="detailtd2"><span id="sfyx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">发布策略</td>
		<td class="detailtd2"><span id="fbcl"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">发布方式</td>
		<td class="detailtd2"><span id="fbfs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">特行单位字段</td>
		<td class="detailtd2"><span id="txdwzd"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">管辖单位字段</td>
		<td class="detailtd2"><span id="gxdwzd"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">报警级别</td>
		<td class="detailtd2"><span id="bjjb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">报警方式</td>
		<td class="detailtd2"><span id="bjfs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">报警类型代码</td>
		<td class="detailtd2"><span id="bjlxdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">报警类型</td>
		<td class="detailtd2"><span id="bjlx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">行业类别代码</td>
		<td class="detailtd2"><span id="hylbdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">行业类别</td>
		<td class="detailtd2"><span id="hylb"></span></td>
	</tr>
</table>