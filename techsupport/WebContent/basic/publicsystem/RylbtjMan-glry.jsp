<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#g_dsjgbz").attr("value",$("#t_dsjgbz").attr("value"));
		$("#g_fxjbz").attr("value",$("#t_fxjbz").attr("value"));
		$("#g_gxdwbz").attr("value",$("#t_gxdwbz").attr("value"));
		$("#g_csbz").attr("value",$("#t_csbz").attr("value"));
		$("#g_"+passKey).attr("value",passValue);
		
		setParams("g_");
		var ryxxtjGlry_pageUrl="publicsystem/querylistGlry_rylbtj.action";
		jQuery.post(ryxxtjGlry_pageUrl,params,glryBackdiv,"json");
	});
	function glryBackdiv (json) {
		$("#fddbrhzyfzrs").append(setNull(json.LRylbtj[0].fddbrhzyfzrs));
		$("#zygdzcrys").append(setNull(json.LRylbtj[0].zygdzcrys));
		$("#zafzrs").append(setNull(json.LRylbtj[0].zafzrs));
		$("#qtglrys").append(setNull(json.LRylbtj[0].qtglrys));
	}
</script>

<body>
<input type="hidden" id="k_deptCode">

<input type="hidden" id="g_dsjgbz" value="0">
<input type="hidden" id="g_dsjgdm">
<input type="hidden" id="g_fxjbz" value="0">
<input type="hidden" id="g_fxjdm">
<input type="hidden" id="g_gxdwbz" value="0">
<input type="hidden" id="g_gxdwdm">
<input type="hidden" id="g_csbz" value="0">
<input type="hidden" id="g_csbm">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">管理人员</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#ryxxtj_detail").hideAndRemove("show");' class="close"></a>
      </td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1" width="35%">法定代表人或主要负责人</td>
		<td class="detailtd2" width="65%"><span id="fddbrhzyfzrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">主要股东组成人员</td>
		<td class="detailtd2"><span id="zygdzcrys"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">治安负责人</td>
	  <td class="detailtd2"><span id="zafzrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">其他管理人员</td>
	  <td class="detailtd2"><span id="qtglrys"></span></td>
	</tr>
</table>
</body>