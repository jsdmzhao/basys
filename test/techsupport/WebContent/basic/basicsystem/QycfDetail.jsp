<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qycfid").attr("value",dataid);
			setDetail();
	}); 
		
	function updatediv (json) { 
		$("#qycfid").append(setNull(json.LQycf[0].qycfid));
		$("#hylb").append(setNull(json.LQycf[0].hylb));
		$("#qybm").append(setNull(json.LQycf[0].qybm));
		$("#qymc").append(setNull(json.LQycf[0].qymc));
		$("#ssdwbm").append(setNull(json.LQycf[0].ssdwbm));
		$("#ssdwmc").append(setNull(json.LQycf[0].ssdwmc));
		$("#wgqkms").append(setNull(json.LQycf[0].wgqkms));
		$("#cfjg").append(setNull(json.LQycf[0].cfjg));
		$("#cfzxrxm").append(setNull(json.LQycf[0].cfzxrxm));
		$("#cfrq").append(setNull(json.LQycf[0].cfrq));
		$("#djsj").append(setNull(json.LQycf[0].djsj));
		$("#djr").append(setNull(json.LQycf[0].djr));
		$("#bz").append(setNull(json.LQycf[0].bz));
	}	
</script>
<input type="hidden" id="q_qycfid">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			企业处罚详细信息
		</td>
  <td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='$("#qycf_detail").hideAndRemove(&quot;show&quot;);'class="close"></a>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellpadding="4" cellspacing="0" class="detail" id="detail" >
<tr>
		<td width="20%" class="distd1">
			企业名称		</td>
		<td colspan="3" class="detailtd2">
			<span id="qymc" style="width:410px;"></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			行业类别
		</td>
		<td width="31%" class="detailtd2">
			<span id="hylb"></span>		</td>
		<td class="distd1">
			企业编码
		</td>
		<td class="detailtd2">
			<span id="qybm"></span>
	  </td>
	</tr>
	<tr>
		<td class="distd1">
			处罚人
		</td>
		<td class="detailtd2">
			<span id="cfzxrxm"></span>
		</td>
		<td class="distd1">
			处罚结果
		</td>
		<td class="detailtd2">
			<span id="cfjg"></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			登记人
		</td>
		<td class="detailtd2">
			<span id="djr"></span>
		</td>
		<td class="distd1">
			登记时间
		</td>
		<td class="detailtd2">
			<span id="djsj"></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			所属单位名称
		</td>
		<td class="detailtd2">
			<span id="ssdwmc"></span>
		</td>
		<td width="13%" class="distd1">
			处罚日期		</td>
		<td width="36%" class="detailtd2">
			<span id="cfrq"></span>		</td>
	</tr>
	<tr>
		<td class="distd1">
			处罚原因
		</td>
		<td colspan="3" class="detailtd2">
			<%--<textarea name="textarea" id="wgqkms" style="width:410px;"></textarea>--%>
			<span id="wgqkms" cols="49" rows="5"></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			备注
		</td>
		<td colspan="3" class="detailtd2">
			<%--<textarea name="textarea2" id="textarea" style="width:410px;"></textarea>
			--%><span id="bz" cols="49" rows="5"></span>
		</td>
	</tr>
	<tr align="center">
		<td colspan="6" height="8"></td>
	</tr>
	<tr align="center">
		<td colspan="6">
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="关闭" onclick='$("#qycf_detail").hideAndRemove(&quot;show&quot;);'>关闭</a>
		</td>
	</tr>
</table>
