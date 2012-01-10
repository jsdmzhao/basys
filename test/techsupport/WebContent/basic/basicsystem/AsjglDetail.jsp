<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_asjglid").attr("value",dataid);
			setDetail();
	}); 
	function updatediv (json) { 
		$("#asjglid").append(setNull(json.LAsjgl[0].asjglid));
		$("#larq").append(setNull(json.LAsjgl[0].larq));
		$("#parq").append(setNull(json.LAsjgl[0].parq));
		$("#qybm").append(setNull(json.LAsjgl[0].qybm));
		$("#qymc").append(setNull(json.LAsjgl[0].qymc));
		$("#ajbh").append(setNull(json.LAsjgl[0].ajbh));
		$("#ladw").append(setNull(json.LAsjgl[0].ladw));
		$("#ladwbm").append(setNull(json.LAsjgl[0].ladwbm));
		$("#qkms").append(setNull(json.LAsjgl[0].qkms));
		
		$("#hylb").append(setNull(json.LAsjgl[0].hylb));
		$("#ajxz").append(setNull(json.LAsjgl[0].ajxz));
		$("#ajlb").append(setNull(json.LAsjgl[0].ajlb));
		$("#ajly").append(setNull(json.LAsjgl[0].ajly));
		$("#qyzr").append(setNull(json.LAsjgl[0].qyzr));
		$("#qyryjs").append(setNull(json.LAsjgl[0].qyryjs));
		
		$("#fasj").append(setNull(json.LAsjgl[0].fasj));
		$("#ssdwmc").append(setNull(json.LAsjgl[0].ssdwmc));
		$("#djr").append(setNull(json.LAsjgl[0].djr));
		$("#djdwmc").append(setNull(json.LAsjgl[0].djdwmc));
		$("#djsj").append(setNull(json.LAsjgl[0].djsj));
		$("#ssdwbm").append(setNull(json.LAsjgl[0].ssdwbm));
		
		if(setNull(json.LAsjgl[0].hylbdm)=='J'||setNull(json.LAsjgl[0].hylbdm)=='K'){
			$('#dtd_qymc').text('场所名称');
			$('#dtd_qybm').text('场所代码');
			$('#dtd_qyzr').text('场所责任');
			$('#dtd_qyryjs').text('场所/人员角色');
			
		}else{
		    $('#dtd_qymc').text('企业名称');
		    $('#dtd_qybm').text('企业代码');
		    $('#ajbh_title').html("&nbsp;");
		    $('#ajbh_conte').html("&nbsp;");
		}
	}
</script>
<input type="hidden" id="q_asjglid">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			场所发案情况明细
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='$("#asjgl_detail").hideAndRemove(&quot;show&quot;);' class="close"></a>
		</td>
	</tr>
</table>
<table width="100%" cellpadding="4" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">
			行业类别
		</td>
		<td class="detailtd2">
			<span id="hylb"></span>
		</td>
		<td width="15%" class="distd1" id="dtd_qymc">
			企业名称		</td>
<td width="34%" class="detailtd2">
			<span id="qymc"></span></td>
       
	</tr>
	<tr height="20">
	 	<td width="19%" class="distd1" id="dtd_qybm">
			企业代码
		</td>
		<td width="32%" class="detailtd2">
			<span id="qybm"></span>
		</td>
		<td class="distd1" id="ajbh_title">案件编号</td>
		<td class="detailtd2" id="ajbh_conte"><span id="ajbh"></span>
	</tr>
	<tr height="20">
		<td class="distd1">
			案件来源
		</td>
		<td class="detailtd2">
			<span id="ajly"></span>
		</td>
		<td class="distd1">
			发案时间
		</td>
		<td class="detailtd2">
			<span id="fasj"></span>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1">
			案件性质
		</td>
		<td class="detailtd2">
			<span id="ajxz"></span>
		</td>
		<td class="distd1">
			案件类别
		</td>
		<td class="detailtd2">
			<span id="ajlb"></span>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1">
			治安管辖机构
		</td>
		<td class="detailtd2">
			<span id="ssdwmc"></span>
		</td>
		<td class="distd1">
			登记人
		</td>
		<td class="detailtd2">
			<span id="djr"></span>
		</td>
	</tr>
	
	<tr height="20">
		<td class="distd1">
			登记时间
		</td>
		<td class="detailtd2">
			<span readonly="readonly" id="djsj"></span>
		</td>
		<td class="distd1">立案单位
		</td>
		<td class="detailtd2"><span id="ladw"></span>
		</td>
		
	</tr>
	
	<tr height="20">
		<td class="distd1">
			立案日期
		</td>
		<td class="detailtd2">
			<span id="larq"></span>
		</td>
		<td class="distd1">
			破案日期
		</td>
		<td class="detailtd2">
			<span id="parq"></span>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1" id="dtd_qyzr">
			企业责任
		</td>
		<td class="detailtd2">
			<span id="qyzr"></span>
		</td>
		<td class="distd1" id="dtd_qyryjs" width="16%">
			企业/人员角色
		</td>
		<td class="detailtd2">
			<span id="qyryjs"></span>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1">
			情况描述
		</td>
		<td colspan="3" class="detailtd2">
			<span id="qkms" cols="49" rows="5"></span>
		</td>
</table>
