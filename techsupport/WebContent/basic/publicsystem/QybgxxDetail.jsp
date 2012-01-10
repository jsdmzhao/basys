<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#d_qybgxxid").val(Qybgxx_dataid);
		qyxxDisplayOrNot();
		Qybgxx_setDetail();
	}); 
	
	function Qybgxx_setDetail(){
		setParams("d_");
		jQuery.post(Qybgxx_detailUrl,params,Qybgxx_updatediv,"json");
	}

	function Qybgxx_updatediv (json) {
		if($("#p_qybgGacxFlag").attr("value")=='1'){
			qyxxDisplayOrNot('show');
			$("#Qybg_qybm").append(setNull(json.LQybgxx[0].qybm));
			$("#Qybg_qymc").append(setNull(json.LQybgxx[0].qymc));
			$("#Qybg_qyzflmc").append(setNull(json.LQybgxx[0].qyzflmc));
			$("#Qybg_gxdwmc").append(setNull(json.LQybgxx[0].gxdwmc));
			$("#Qybg_lxdh").append(setNull(json.LQybgxx[0].lxdh));
			$("#Qybg_yzbm").append(setNull(json.LQybgxx[0].yzbm));
			$("#Qybg_yyztmc").append(setNull(json.LQybgxx[0].yyztmc));
			$("#Qybg_jydz").append(setNull(json.LQybgxx[0].jydz));
		}
		$("#bgdjxh").append(setNull(json.LQybgxx[0].bgdjxh));
		$("#bglx").append(setNull(json.LQybgxx[0].bglx));
		$("#bgrq").append(setNull(json.LQybgxx[0].bgrq));
		$("#bgyy").append(setNull(json.LQybgxx[0].bgyy));
		$("#bgqnr").append(setNull(json.LQybgxx[0].bgqnr));
		$("#bghnr").append(setNull(json.LQybgxx[0].bghnr));
	}
	
	function qyxxDisplayOrNot(playOrNot){
		if(playOrNot=='show'){
			$("#csjbxx_tr").show();
			$("#csjbxxXx_tr").show();
		} else {
			$("#csjbxx_tr").hide();
			$("#csjbxxXx_tr").hide();
		}
	}
</script>
<input type="hidden" id="d_qybgxxid">
<span id="QybgxxCxCloseFlag"></span>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">场所变更详情</td>
      <td align="right"><a href="#" id="closeDiv" onclick="$('#QybgxxCxCloseFlag').parent().hideAndRemove('show');" class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
	<tr id="csjbxx_tr"><td class="queryfont">场所基本信息</td></tr>
	<tr id="csjbxxXx_tr"><td class="tdbg">
		<table width="100%" cellpadding="2" cellspacing="0" class="detail" id="detail">
			<tr height="20">
				<td class="distd1" width="16%">企业备案编号</td>
				<td class="detailtd2" width="34%"><span id="Qybg_qybm"></span></td>
				<td class="distd1" width="16%">场所名称</td>
				<td class="detailtd2" width="34%"><span id="Qybg_qymc"></span></td>
			</tr>
			<tr height="20">
				<td class="distd1">场所分类</td>
				<td class="detailtd2"><span id="Qybg_qyzflmc"></span></td>
				<td class="distd1">治安管理机构</td>
				<td class="detailtd2"><span id="Qybg_gxdwmc"></span></td>
			</tr>
			<tr height="20">
				<td class="distd1">联系电话</td>
				<td class="detailtd2"><span id="Qybg_lxdh"></span></td>
				<td class="distd1">邮政编码</td>
				<td class="detailtd2"><span id="Qybg_yzbm"></span></td>
			</tr>
			<tr height="20">
				<td class="distd1">场所状态</td>
				<td class="detailtd2"><span id="Qybg_yyztmc"></span></td>
				<td class="distd1">经营地址</td>
				<td class="detailtd2"><span id="Qybg_jydz"></span></td>
			</tr>
		</table>
	</td></tr>
	<tr><td class="queryfont">场所变更信息</td></tr>
	<tr><td class="tdbg">
		<table width="100%" cellpadding="2" cellspacing="0" class="detail" id="detail">
			<tr height="20">
				<td class="distd1" width="16%">变更登记序号</td>
				<td class="detailtd2"><span id="bgdjxh"></span></td>
			</tr>
			<tr height="20">
				<td class="distd1">变更类型</td>
				<td class="detailtd2"><span id="bglx"></span></td>
			</tr>
			<tr height="20">
				<td class="distd1">变更日期</td>
				<td class="detailtd2"><span id="bgrq"></span></td>
			</tr>
			<tr height="20">
				<td class="distd1">变更原因</td>
				<td class="detailtd2"><span id="bgyy"></span></td>
			</tr>
			<tr height="20">
				<td class="distd1">变更前内容</td>
				<td class="detailtd2"><span id="bgqnr"></span></td>
			</tr>
			<tr height="20">
				<td class="distd1">变更后内容</td>
				<td class="detailtd2"><span id="bghnr"></span></td>
			</tr>
		</table>
	</td></tr>
</table>