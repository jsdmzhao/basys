<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_sjbjgid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#sjbjgid").append(setNull(json.LSjbjg[0].sjbjgid));
		$("#sjbid").append(setNull(json.LSjbjg[0].sjbid));
		$("#zdm").append(setNull(json.LSjbjg[0].zdm));
		$("#zdzwm").append(setNull(json.LSjbjg[0].zdzwm));
		$("#zdlx").append(setNull(json.LSjbjg[0].zdlx));
		$("#zdcd").append(setNull(json.LSjbjg[0].zdcd));
		$("#qsz").append(setNull(json.LSjbjg[0].qsz));
		$("#px").append(setNull(json.LSjbjg[0].px));
		$("#gs").append(setNull(json.LSjbjg[0].gs));
		$("#sfdjhwb").append(setNull(json.LSjbjg[0].sfdjhwb));
		$("#sfbt").append(setNull(json.LSjbjg[0].sfbt));
		$("#sfzd").append(setNull(json.LSjbjg[0].sfzd));
		$("#sfkj").append(setNull(json.LSjbjg[0].sfkj));
		$("#sfcx").append(setNull(json.LSjbjg[0].sfcx));
		$("#xlklx").append(setNull(json.LSjbjg[0].xlklx));
		$("#dzxlkdqy").append(setNull(json.LSjbjg[0].dzxlkdqy));
		$("#xlkkd").append(setNull(json.LSjbjg[0].xlkkd));
		$("#xlkgd").append(setNull(json.LSjbjg[0].xlkgd));
		$("#bz").append(setNull(json.LSjbjg[0].bz));
	}	
</script>
<input type="hidden" id="q_sjbjgid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#Sjbjg_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="detail">
	<tr height="20">
		<td class="distd">数据表结构ID</td>
		<td class="detailtd"><span id="sjbjgid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">数据表ID</td>
		<td class="detailtd"><span id="sjbid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">字段名</td>
		<td class="detailtd"><span id="zdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">字段中文名</td>
		<td class="detailtd"><span id="zdzwm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">字段类型</td>
		<td class="detailtd"><span id="zdlx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">字段长度</td>
		<td class="detailtd"><span id="zdcd"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">缺省值</td>
		<td class="detailtd"><span id="qsz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">排序</td>
		<td class="detailtd"><span id="px"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">格式</td>
		<td class="detailtd"><span id="gs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">是否多行文本</td>
		<td class="detailtd"><span id="sfdjhwb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">是否必填</td>
		<td class="detailtd"><span id="sfbt"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">是否只读</td>
		<td class="detailtd"><span id="sfzd"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">是否可见</td>
		<td class="detailtd"><span id="sfkj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">是否查询</td>
		<td class="detailtd"><span id="sfcx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">下拉框类型</td>
		<td class="detailtd"><span id="xlklx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">定制下拉框读取域列表</td>
		<td class="detailtd"><span id="dzxlkdqy"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">下拉框宽度</td>
		<td class="detailtd"><span id="xlkkd"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">下拉框高度</td>
		<td class="detailtd"><span id="xlkgd"></span></td>
	</tr>
	<tr height="20">
		<td class="distd">备注</td>
		<td class="detailtd"><span id="bz"></span></td>
	</tr>
</table>