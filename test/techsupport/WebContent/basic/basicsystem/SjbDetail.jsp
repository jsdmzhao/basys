<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_sjbid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#sjbid").append(setNull(json.LSjb[0].sjbid));
		$("#sjbm").append(setNull(json.LSjb[0].sjbm));
		$("#sjbzwm").append(setNull(json.LSjb[0].sjbzwm));
		$("#dyldx").append(setNull(json.LSjb[0].dyldx));
		$("#sfjlczrz").append(setNull(json.LSjb[0].sfjlczrz));
		$("#sfxtzd").append(setNull(json.LSjb[0].sfxtzd));
		$("#sssjkyh").append(setNull(json.LSjb[0].sssjkyh));
		$("#zj").append(setNull(json.LSjb[0].zj));
	}	
</script>
<input type="hidden" id="q_sjbid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#Sjb_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="detail">
	<tr height="20">
		<td class="distd">数据表ID</td>
		<td class="detailtd"><span id="sjbid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">数据表名</td>
		<td class="detailtd"><span id="sjbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">数据表中文名</td>
		<td class="detailtd"><span id="sjbzwm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">对应类对象</td>
		<td class="detailtd"><span id="dyldx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">是否记录操作日志</td>
		<td class="detailtd"><span id="sfjlczrz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">是否系统字典</td>
		<td class="detailtd"><span id="sfxtzd"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">所属数据库用户</td>
		<td class="detailtd"><span id="sssjkyh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">主键</td>
		<td class="detailtd"><span id="zj"></span></td>
	</tr>
</table>