<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%
	Date da=new Date(); long lo=da.getTime();
 %>
<script type="text/javascript">
var clxxry_zpUrl="publicsystem/queryTp_clxxry_zp.action";
	$(document).ready(function() {
		$("#q_cljbxxid").attr("value",dataid);
		setParams("q_");
		jQuery.post("publicsystem/queryAllInfo_cljbxx.action",params,updatediv,"json");
	}); 
	function updatediv (json) {
		$("#czm").append(setNull(json.LCljbxx[0].czm));
		$("#czxb").append(setNull(json.LCljbxx[0].czxb));
		$("#czdh").append(setNull(json.LCljbxx[0].czdh));
		$("#czcyzj").append(setNull(json.LCljbxx[0].czcyzj));
		$("#czzjhm").append(setNull(json.LCljbxx[0].czzjhm));
		$("#czxzqh").append(setNull(json.LCljbxx[0].czxzqh));
		$("#czhjdz").append(setNull(json.LCljbxx[0].czhjdz));
		$("#qymc").append(setNull(json.LCljbxx[0].qymc));
	 	$("#dhzp_img").attr('src',clxxry_zpUrl+"?clryzpid="+setNull(json.LCljbxx[0].LClxxry_zpList[0].clxxryzpid));
	}	
</script>
<input type="hidden" id="q_cljbxxid">
   <table width="100%"  border="0" cellpadding="1" cellspacing="0" class="detail" id="detail">
		<tr>
			<td colspan="6"  class="queryfont"><span id="hylb"></span>车主信息</td>
		</tr>
		<tr height="25">
			<td width="10%" class="distd1">车主姓名</td>
			<td width="25%" class="detailtd2"><span id="czm"></span></td>
			<td width="9%" class="distd1">性别</td>
			<td width="24%" class="detailtd2"><span id="czxb"></span></td>
			<td width="32%" rowspan="4" align="center"><img id="dhzp_img" src="images/pic.gif" width="80" height="114" /></td>
		</tr>
		<tr height="25">
			<td class="distd1">证件类型</td>
			<td class="detailtd2"><span id="czcyzj"></span></td>
			<td class="distd1">证件号码</td>
			<td class="detailtd2"><span id="czzjhm"></span></td>
		</tr>
		<tr height="25">
			<td class="distd1">电话</td>
			<td class="detailtd2"><span id="czdh"></span></td>
			<td class="distd1">户籍地行政区划</td>
			<td class="detailtd2"><span id="czxzqh"></span></td>
		</tr>
		<tr height="25">
			<td class="distd1">现住地详址</td>
			<td class="detailtd2"><span id="czhjdz"></span></td>
			<td class="distd1">企业名称</td>
			<td class="detailtd2"><span id="qymc"></span></td>
		</tr>
	</table>