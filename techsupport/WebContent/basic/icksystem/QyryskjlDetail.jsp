<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qyid").attr("value",dataid);
			setDetail();
			
		$("#p_hylbdm").selectBoxhylb();//行业类别

		if($("#p_hylbdm").val()!="J"){
			$('body').find('div [@id=qy]').each(function(){
				$(this).show();
			});
			$('body').find('div [@id=cs]').each(function(){
				$(this).hide();
			});
		}
	}); 
	
	
		
	function updatediv (json) { 
		$("#csid").append(setNull(json.LCsryskjl[0].qyid));
		$("#skid").append(setNull(json.LCsryskjl[0].skid));
		$("#ickh").append(setNull(json.LCsryskjl[0].ickh));
		$("#sksj").append(setNull(json.LCsryskjl[0].sksj));
		$("#scsj").append(setNull(json.LCsryskjl[0].scsj));
		$("#kh").append(setNull(json.LCsryskjl[0].kh));
		$("#cyrybh").append(setNull(json.LCsryskjl[0].cyrybh));
		$("#icksllsh").append(setNull(json.LCsryskjl[0].icksllsh));
	}	
</script>
<div style="display:none"><select id="p_hylbdm"></select></div>
<div align="right"><a href="#" id="closeDiv" onclick='$("#csryskjl_detail").hideAndRemove("show");' class="close"></a></div>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1"><div id="cs" >场所ID</div><div id="qy" style="display:none">企业ID</div></td>
		<td class="detailtd2"><span id="qyid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">刷卡ID</td>
		<td class="detailtd2"><span id="skid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">卡ID号</td>
		<td class="detailtd2"><span id="ickh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">刷卡时间</td>
		<td class="detailtd2"><span id="sksj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">上传时间</td>
		<td class="detailtd2"><span id="scsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">卡号</td>
		<td class="detailtd2"><span id="kh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员编号</td>
		<td class="detailtd2"><span id="cyrybh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">IC卡受理流水号</td>
		<td class="detailtd2"><span id="icksllsh"></span></td>
	</tr>
</table>