<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_cljbxxid").attr("value",dataid);
		setParams("q_");
		jQuery.post("publicsystem/query_cljbxx.action",params,updatediv,"json");
	}); 
	function updatediv (json) { 
		$("#czm").append(setNull(json.LCljbxx[0].czm));
		$("#czdh").append(setNull(json.LCljbxx[0].czdh));
		$("#czgj").append(setNull(json.LCljbxx[0].czgj));
		$("#czhjdz").append(setNull(json.LCljbxx[0].czhjdz));
		$("#czxb").append(setNull(json.LCljbxx[0].czxb));
		$("#czcyzj").append(setNull(json.LCljbxx[0].czcyzj));
		$("#czzjhm").append(setNull(json.LCljbxx[0].czzjhm));
	}	
</script>
<input type="hidden" id="q_cljbxxid">
<table width="100%"  border="0" cellpadding="1" cellspacing="0"  class="detail" id="detail">
		<tr>
			<td colspan="6"  class="queryfont">车主信息</td>
		</tr>
		<tr height="20">
		<td width="13%" class="distd1">
			姓名
		</td>
		<td width="20%" class="detailtd2"><span id="czm"></span></td>
		<td width="13%" class="distd1">
				性别
			</td>
			<td width="20%" class="detailtd2"><span id="czxb"></span></td>
		<td width="13%" class="distd1">
				国籍
			</td>
		<td width="20%" class="detailtd2"><span id="czgj"></span></td>
		</tr>
		<tr height="20">
		<td class="distd1">
			常用证件
		</td>
		<td class="detailtd2"><span id="czcyzj"></span></td>
			<td class="distd1">
				证件号码
			</td>
			<td class="detailtd2"><span id="czzjhm"></span></td>
		<td class="distd1">
				联系电话
			</td>
			<td class="detailtd2"><span id="czdh"></span></td>
		</tr>
		<tr height="20">
			<td class="distd1">
				户籍地址
			</td>
			<td class="detailtd2" colspan="5"><span id="czhjdz"></span></td>
		</tr>
		<tr height="20"><td colspan="4">&nbsp;</td></tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0">
		<tr><td height="2"></td></tr>
	</table>