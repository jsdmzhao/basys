<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_wlid").attr("value",dataid);
		setParams("q_");
		jQuery.post("icksystem/query_wldj.action",params,updatediv,"json");
	}); 
	function updatediv (json) { 
		$("#wlpc").append(setNull(json.LWldj[0].wlpc));
		$("#djr").append(setNull(json.LWldj[0].djr));
		$("#zbsj").append(setNull(json.LWldj[0].zbsj));
		$("#mbsldbh").append(setNull(json.LWldj[0].mbsldbh));
		$("#mbsldmc").append(setNull(json.LWldj[0].mbsldmc));
		$("#ztdmmc").append(setNull(json.LWldj[0].ztdmmc));
		$("#fkxx").append(setNull(json.LWldj[0].fkxx));
		$("#fksj").append(setNull(json.LWldj[0].fksj));
		$("#fsr").append(setNull(json.LWldj[0].fsr));
		$("#fssj").append(setNull(json.LWldj[0].fssj));
		$("#szds").append(setNull(json.LWldj[0].szds));
		$("#jsr").append(setNull(json.LWldj[0].jsr));
		$("#jssj").append(setNull(json.LWldj[0].jssj));
		$("#bz").append(setNull(json.LWldj[0].bz));
		$("#wlgs").append(setNull(json.LWldj[0].wlgs));
		$("#ydh").append(setNull(json.LWldj[0].ydh));
		$("#bnksl").append(setNull(json.LWldj[0].bnksl));
	}	
</script>
<input type="hidden" id="q_wlid">
<div id="wldjdetailClose"></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">物流详细信息</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#wldjdetailClose").parent().hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>

<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1" width="20%">物流批次</td>
		<td class="detailtd2" width="30%"><span id="wlpc"></span></td>
		<td class="distd1" width="20%">登记人</td>
		<td class="detailtd2" width="30%"><span id="djr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">组包时间</td>
		<td class="detailtd2"><span id="zbsj"></span></td>
		<td class="distd1">目标受理点编号</td>
		<td class="detailtd2"><span id="mbsldbh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">目标受理点名称</td>
		<td class="detailtd2" width="480px"><span id="mbsldmc"></span></td>
		<td class="distd1">状态代码名称</td>
		<td class="detailtd2" width="480px"><span id="ztdmmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">发送人</td>
		<td class="detailtd2"><span id="fsr"></span></td>
		<td class="distd1">发送时间</td>
		<td class="detailtd2"><span id="fssj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">接收人</td>
		<td class="detailtd2"><span id="jsr"></span></td>
		<td class="distd1">接收时间</td>
		<td class="detailtd2"><span id="jssj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">包内卡数量</td>
		<td class="detailtd2"><span id="bnksl"></span></td>
		<td class="distd1">反馈时间</td>
		<td class="detailtd2"><span id="fksj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">所在地市</td>
		<td class="detailtd2" colspan="3" width="480px"><span id="szds"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">物流公司</td>
		<td class="detailtd2"><span id="wlgs"></span></td>
		<td class="distd1">运单号码</td>
		<td class="detailtd2"><span id="ydh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">反馈信息</td>
		<td class="detailtd2" colspan="3" width="480px"><span id="fkxx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">备注</td>
		<td class="detailtd2" colspan="3" width="480px"><span id="bz"></span></td>
	</tr>
</table>