<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_qyfltjid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qyfltjid").append(setNull(json.LQyfltj[0].qyfltjid));
		$("#hylbdm").append(setNull(json.LQyfltj[0].hylbdm));
		$("#hylb").append(setNull(json.LQyfltj[0].hylb));
		$("#dsjgdm").append(setNull(json.LQyfltj[0].dsjgdm));
		$("#dsjgmc").append(setNull(json.LQyfltj[0].dsjgmc));
		$("#fxjdm").append(setNull(json.LQyfltj[0].fxjdm));
		$("#fxjmc").append(setNull(json.LQyfltj[0].fxjmc));
		$("#gxdwdm").append(setNull(json.LQyfltj[0].gxdwdm));
		$("#gxdwmc").append(setNull(json.LQyfltj[0].gxdwmc));
		$("#gwyl").append(setNull(json.LQyfltj[0].gwyl));
		$("#jb").append(setNull(json.LQyfltj[0].jb));
		$("#glxxhdcs").append(setNull(json.LQyfltj[0].glxxhdcs));
		$("#yysdzyxt").append(setNull(json.LQyfltj[0].yysdzyxt));
		$("#snxy").append(setNull(json.LQyfltj[0].snxy));
		$("#am").append(setNull(json.LQyfltj[0].am));
		$("#zs").append(setNull(json.LQyfltj[0].zs));
		$("#wsfw").append(setNull(json.LQyfltj[0].wsfw));
		$("#qt").append(setNull(json.LQyfltj[0].qt));
		$("#hj").append(setNull(json.LQyfltj[0].hj));
	}	
</script>
<input type="hidden" id="q_qyfltjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Qyfltj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">企业分类统计ID</td>
		<td class="detailtd2"><span id="qyfltjid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">行业类别代码</td>
		<td class="detailtd2"><span id="hylbdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">行业类别</td>
		<td class="detailtd2"><span id="hylb"></span></td>
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
		<td class="distd1">歌舞娱乐</td>
		<td class="detailtd2"><span id="gwyl"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">酒吧</td>
		<td class="detailtd2"><span id="jb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">各类休闲活动场所</td>
		<td class="detailtd2"><span id="glxxhdcs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">游艺室、电子游戏厅</td>
		<td class="detailtd2"><span id="yysdzyxt"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">桑拿、洗浴</td>
		<td class="detailtd2"><span id="snxy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">按摩</td>
		<td class="detailtd2"><span id="am"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">住宿</td>
		<td class="detailtd2"><span id="zs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">网上服务（网吧）</td>
		<td class="detailtd2"><span id="wsfw"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">其他</td>
		<td class="detailtd2"><span id="qt"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">合计</td>
		<td class="detailtd2"><span id="hj"></span></td>
	</tr>
</table>