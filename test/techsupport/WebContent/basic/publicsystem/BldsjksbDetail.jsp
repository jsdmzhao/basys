<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bldsjksbid").attr("value",bldsjksb_dataid);
		bldsjksb_setDetail();
	}); 
	function bldsjksb_updatediv (json) { 
		$("#bldsjksb_sbjcjgmc").append(setNull(json.LBldsjksb[0].sbjcjgmc));
		$("#bldsjksb_wlcslxbm").append(setNull(json.LBldsjksb[0].wlcslxbm));
		$("#bldsjksb_wlcslxmc").append(setNull(json.LBldsjksb[0].wlcslxmc));
		$("#bldsjksb_azsxtsl").append(setNull(json.LBldsjksb[0].azsxtsl));
		$("#bldsjksb_sbxh").append(setNull(json.LBldsjksb[0].sbxh));
		$("#bldsjksb_sccsmc").append(setNull(json.LBldsjksb[0].sccsmc));
		$("#bldsjksb_ggxh").append(setNull(json.LBldsjksb[0].ggxh));
		$("#bldsjksb_azsl").append(setNull(json.LBldsjksb[0].azsl));
		$("#bldsjksb_sbmc").append(setNull(json.LBldsjksb[0].sbmc));
		$("#bldsjksb_sflx").append(setNull(json.LBldsjksb[0].sflx));
		$("#bldsjksb_ipdz").append(setNull(json.LBldsjksb[0].ipdz));
		$("#bldsjksb_anwz").append(setNull(json.LBldsjksb[0].anwz));
	}	
</script>
<input type="hidden" id="q_bldsjksbid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">视频监控设备详细信息</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#q_bldsjksbid").parent().hideAndRemove("show");' class="close"></a>
      </td>
    </tr>
</table>

<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
      	<td class="distd1" width="15%">设备名称</td>
	  	<td class="detailtd2" width="34%"><span id="bldsjksb_sbmc"></span></td>
		<td class="distd1" width="17%">设备生产厂商名称</td>
      	<td class="detailtd2" width="34%"><span id="bldsjksb_sccsmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">规格型号</td>
      	<td class="detailtd2"><span id="bldsjksb_ggxh"></span></td>
      	<td class="distd1">设备检测机构名称</td>
		<td class="detailtd2"><span id="bldsjksb_sbjcjgmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">安装位置</td>
      	<td class="detailtd2"><span id="bldsjksb_anwz"></span></td>
		<td class="distd1">网络传输类型</td>
      	<td class="detailtd2"><span id="bldsjksb_wlcslxmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">安装摄像头数量</td>
      	<td class="detailtd2"><span id="bldsjksb_azsxtsl"></span></td>
		<td class="distd1">是否录像</td>
      	<td class="detailtd2"><span id="bldsjksb_sflx"></span></td>
	</tr>
	<tr height="20">
	    <td class="distd1">IP地址</td>
	    <td class="detailtd2"><span id="bldsjksb_ipdz"></span></td>
	    <td class="distd1">&nbsp;</td>
	    <td class="detailtd2">&nbsp;</td>
	</tr>
</table>