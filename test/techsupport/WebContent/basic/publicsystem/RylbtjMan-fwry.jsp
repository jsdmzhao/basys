<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#f_dsjgbz").attr("value",$("#t_dsjgbz").attr("value"));
		$("#f_fxjbz").attr("value",$("#t_fxjbz").attr("value"));
		$("#f_gxdwbz").attr("value",$("#t_gxdwbz").attr("value"));
		$("#f_csbz").attr("value",$("#t_csbz").attr("value"));
		$("#f_"+passKey).attr("value",passValue);
		
		setParams("f_");
		var ryxxtjGlry_pageUrl="publicsystem/querylistFwry_rylbtj.action";
		jQuery.post(ryxxtjGlry_pageUrl,params,glryBackdiv,"json");
	});
	function glryBackdiv (json) {
		$("#ybfwrys").append(setNull(json.LRylbtj[0].ybfwrys));
		$("#lsfwrys").append(setNull(json.LRylbtj[0].lsfwrys));
		$("#yyrys").append(setNull(json.LRylbtj[0].yyrys));
		$("#qtfwrys").append(setNull(json.LRylbtj[0].qtfwrys));
	}
</script>

<body>
<input type="hidden" id="k_deptCode">

<input type="hidden" id="f_dsjgbz" value="0">
<input type="hidden" id="f_dsjgdm">
<input type="hidden" id="f_fxjbz" value="0">
<input type="hidden" id="f_fxjdm">
<input type="hidden" id="f_gxdwbz" value="0">
<input type="hidden" id="f_gxdwdm">
<input type="hidden" id="f_csbz" value="0">
<input type="hidden" id="f_csbm">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">服务人员</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#ryxxtj_detail").hideAndRemove("show");' class="close"></a>
      </td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1" width="35%">一般服务人员</td>
		<td class="detailtd2" width="65%"><span id="ybfwrys"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">临时服务人员</td>
		<td class="detailtd2"><span id="lsfwrys"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">演艺人员</td>
	  <td class="detailtd2"><span id="yyrys"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">其他服务人员</td>
	  <td class="detailtd2"><span id="qtfwrys"></span></td>
	</tr>
</table>
</body>