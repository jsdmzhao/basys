<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_yjgzid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#yjgzid").append(setNull(json.LYjbdtj[0].yjgzid));
		$("#yjbdtjid").append(setNull(json.LYjbdtj[0].yjbdtjid));
		$("#tjlx").append(setNull(json.LYjbdtj[0].tjlx));
		$("#ywbzdm").append(setNull(json.LYjbdtj[0].ywbzdm));
		$("#bdbzdm").append(setNull(json.LYjbdtj[0].bdbzdm));
		$("#bdgx").append(setNull(json.LYjbdtj[0].bdgx));
		$("#gxc").append(setNull(json.LYjbdtj[0].gxc));
		$("#zxsx").append(setNull(json.LYjbdtj[0].zxsx));
		$("#ljgx").append(setNull(json.LYjbdtj[0].ljgx));
		$("#jibie").append(setNull(json.LYjbdtj[0].jibie));
	}	
</script>
<input type="hidden" id="q_yjgzid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="detailtd2">预警规则ID</td>
		<td class="detailtd1"><span id="yjgzid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">预警比对条件ID</td>
		<td class="detailtd1"><span id="yjbdtjid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">条件类型</td>
		<td class="detailtd1"><span id="tjlx"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">业务表字段名</td>
		<td class="detailtd1"><span id="ywbzdm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">比对表字段名</td>
		<td class="detailtd1"><span id="bdbzdm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">比对关系</td>
		<td class="detailtd1"><span id="bdgx"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">关系串</td>
		<td class="detailtd1"><span id="gxc"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">执行顺序</td>
		<td class="detailtd1"><span id="zxsx"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">逻辑关系</td>
		<td class="detailtd1"><span id="ljgx"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">级别</td>
		<td class="detailtd1"><span id="jibie"></span></td>
	</tr>
</table>