<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_ickyjid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#ickyjid").append(setNull(json.LIckyj[0].ickyjid));
		$("#qyid").append(setNull(json.LIckyj[0].qyid));
		$("#qybm").append(setNull(json.LIckyj[0].qybm));
		$("#qymc").append(setNull(json.LIckyj[0].qymc));
		$("#sksj").append(setNull(json.LIckyj[0].sksj));
		$("#dsjgdm").append(setNull(json.LIckyj[0].dsjgdm));
		$("#dsjgmc").append(setNull(json.LIckyj[0].dsjgmc));
		$("#fxjdm").append(setNull(json.LIckyj[0].fxjdm));
		$("#fxjmc").append(setNull(json.LIckyj[0].fxjmc));
		$("#gxdwdm").append(setNull(json.LIckyj[0].gxdwdm));
		$("#gxdwmc").append(setNull(json.LIckyj[0].gxdwmc));
		$("#cyrybh").append(setNull(json.LIckyj[0].cyrybh));
		$("#xm").append(setNull(json.LIckyj[0].xm));
		$("#xmpy").append(setNull(json.LIckyj[0].xmpy));
		$("#ickh").append(setNull(json.LIckyj[0].ickh));
		$("#kh").append(setNull(json.LIckyj[0].kh));
		$("#xb").append(setNull(json.LIckyj[0].xb));
		$("#ywm").append(setNull(json.LIckyj[0].ywm));
		$("#ywx").append(setNull(json.LIckyj[0].ywx));
		$("#wgrjyxkz").append(setNull(json.LIckyj[0].wgrjyxkz));
		$("#cyzjdm").append(setNull(json.LIckyj[0].cyzjdm));
		$("#cyzj").append(setNull(json.LIckyj[0].cyzj));
		$("#zjhm").append(setNull(json.LIckyj[0].zjhm));
		$("#cylbdm").append(setNull(json.LIckyj[0].cylbdm));
		$("#cylb").append(setNull(json.LIckyj[0].cylb));
		$("#yjyy").append(setNull(json.LIckyj[0].yjyy));
		$("#sxsj").append(setNull(json.LIckyj[0].sxsj));
		$("#ryid").append(setNull(json.LIckyj[0].ryid));
	}	
</script>
<input type="hidden" id="q_ickyjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#ickyj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">IC卡预警ID</td>
		<td class="detailtd2"><span id="ickyjid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业ID</td>
		<td class="detailtd2"><span id="qyid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业编码</td>
		<td class="detailtd2"><span id="qybm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">企业名称</td>
		<td class="detailtd2"><span id="qymc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">刷卡时间</td>
		<td class="detailtd2"><span id="sksj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">地市机关代码</td>
		<td class="detailtd2"><span id="dsjgdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">地市机关名称</td>
		<td class="detailtd2"><span id="dsjgmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">分县局代码</td>
		<td class="detailtd2"><span id="fxjdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">分县局名称</td>
		<td class="detailtd2"><span id="fxjmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">管辖单位代码</td>
		<td class="detailtd2"><span id="gxdwdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">管辖单位名称</td>
		<td class="detailtd2"><span id="gxdwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员编号</td>
		<td class="detailtd2"><span id="cyrybh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">姓名</td>
		<td class="detailtd2"><span id="xm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">姓名拼音</td>
		<td class="detailtd2"><span id="xmpy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">卡ID号</td>
		<td class="detailtd2"><span id="ickh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">卡号</td>
		<td class="detailtd2"><span id="kh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">性别</td>
		<td class="detailtd2"><span id="xb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">英文名</td>
		<td class="detailtd2"><span id="ywm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">英文姓</td>
		<td class="detailtd2"><span id="ywx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">外国人就业许可证号</td>
		<td class="detailtd2"><span id="wgrjyxkz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">常用证件代码</td>
		<td class="detailtd2"><span id="cyzjdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">常用证件</td>
		<td class="detailtd2"><span id="cyzj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">证件号码</td>
		<td class="detailtd2"><span id="zjhm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业类别代码</td>
		<td class="detailtd2"><span id="cylbdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业类别</td>
		<td class="detailtd2"><span id="cylb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">预警原因</td>
		<td class="detailtd2"><span id="yjyy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">ic卡失效时间</td>
		<td class="detailtd2"><span id="sxsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员ID</td>
		<td class="detailtd2"><span id="ryid"></span></td>
	</tr>
</table>