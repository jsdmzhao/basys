<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_cljbxxid").attr("value",dataid);
		setParams("q_");
		jQuery.post("publicsystem/queryAllInfo_cljbxx.action",params,escljbxx_updatediv,"json");
	}); 
	
	function escljbxx_updatediv (json) { 
		$("#wchptr")[0].style.display = "none";
		$("#clxz").append(setNull(json.LCljbxx[0].clxz));
		$("#cphjc").append(setNull(json.LCljbxx[0].cphjc));
		$("#cszs").append(setNull(json.LCljbxx[0].cszs));
		$("#dyfs").append(setNull(json.LCljbxx[0].dyfs));
		$("#drfs").append(setNull(json.LCljbxx[0].drfs));
		
		$("#cldjxh").append(setNull(json.LCljbxx[0].cldjxh));
		$("#cllx").append(setNull(json.LCljbxx[0].cllx));
		$("#clpp").append(setNull(json.LCljbxx[0].clpp));
		$("#fdjh").append(setNull(json.LCljbxx[0].fdjh));
		$("#cjh").append(setNull(json.LCljbxx[0].cjh));
		$("#xslc").append(setNull(json.LCljbxx[0].xslc));
		$("#cphxh").append(setNull(json.LCljbxx[0].cphxh));
		
		if(setNull(json.LCljbxx[0].wcphyyms)!=""){ //没有牌
			$("#chptr")[0].style.display = "none";
			$("#wchptr")[0].style.display = "block";
			$("#wcphyy").append(setNull(json.LCljbxx[0].wcphyy));
			$("#wcphyyms").append(setNull(json.LCljbxx[0].wcphyyms));
		}
		if(json.LCljbxx[0].LClxx_zpList!=null){
			for(var i=0;i<json.LCljbxx[0].LClxx_zpList.length;i++){
				$('#pmtPho'+i).attr('src','<%=request.getContextPath()%>/publicsystem/queryTp_clxx_zp.action?clxxzpid='+setNull(json.LCljbxx[0].LClxx_zpList[i].clxxzpid));
			}
		}
	}	
</script>
<input type="hidden" id="q_cljbxxid">
	<table width="100%"  border="0" cellpadding="1" cellspacing="0" class="detail" id="detail">
		<tr>
			<td colspan="6"  class="queryfont">车辆信息</td>
		</tr>
		<tr>
			<td width="12%" class="distd1">登记序号</td>
			<td width="21%" class="detailtd2"><span id="cldjxh"></span></td>
			<td width="12%" class="distd1">车辆性质</td>
			<td width="21%" class="detailtd2"><span id="clxz"></span></td>
			<td width="12%" class="distd1">车辆类型</td>
			<td class="detailtd2"><span id="cllx"></span></td>
		</tr>
		<tr>
			<td class="distd1">车辆品牌名称</td>
			<td class="detailtd2"><span id="clpp"></span></td>
			<td class="distd1">发动机号</td>
			<td class="detailtd2"><span id="fdjh"></span></td>
			<td class="distd1">车架号</td>
			<td class="detailtd2"><span id="cjh"></span></td>
		</tr>
		<tr>
			<td class="distd1">车身颜色</td>
			<td class="detailtd2">
			<span id="cszs"></span>
			</td>
			<td class="distd1">第一辅色</td>
			<td class="detailtd2">
			<span id="dyfs"></span></td>
			<td class="distd1">第二辅色</td>
			<td class="detailtd2">
			<span id="drfs"></span></td>
		</tr>
		<tr id="chptr">
		    <td class="distd1">行驶里程</td>
			<td class="detailtd2"><span id="xslc"></span></td>
			<td class="distd1">车牌号</td>
			<td class="detailtd2" colspan="3">
			<span id="cphjc"></span>
			<span id="cphxh"></span></td>
		</tr>
		<tr id="wchptr" style="display:block;">
			<td class="distd1">无车牌原因</td>
			<td class="detailtd2"><span id="wcphyy"></span></td>
			<td class="distd1">无车牌原因描述</td>
		    <td colspan="3" class="detailtd2"><span id="wcphyyms"></span></td>
		</tr>
		<tr>
			<td colspan="4" height="1"></td>
		</tr>
	</table>
	<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
		<tr>
			<td class="queryfont" colspan="5">车辆照片</td>
		</tr>
		<tr>
			<td align="center"><img id ="pmtPho0" width="80px" height="114px" src="images/pic.gif"/></td>
			<td align="center"><img id ="pmtPho1" width="80px" height="114px" src="images/pic.gif"/></td>
			<td align="center"><img id ="pmtPho2" width="80px" height="114px" src="images/pic.gif"/></td>
			<td align="center"><img id ="pmtPho3" width="80px" height="114px" src="images/pic.gif"/></td>
			<td align="center"><img id ="pmtPho4" width="80px" height="114px" src="images/pic.gif"/></td>
		</tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0">
		<tr><td height="2"></td></tr>
	</table>