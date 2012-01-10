<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_sPmtid").attr("value",pmt_dataid);
		pmt_setDetail();
		$("#pmtImg").attr("src","publicsystem/getCyryzpImg_pmt.action?pmtId="+pmt_dataid);
	});
	function pmt_updatediv (json) {
		$("#pmtlxmc").append(setNull(json.LPmt[0].pmtlxmc));
	}
</script>
<input type="hidden" id="q_sPmtid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" >平面图详细信息</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#pmt_detail").hide("show");'class="close"></a>
      </td>
    </tr>
</table>

<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1" width="40%">平面图类型名称</td>
		<td class="detailtd2" width="60%"><span id="pmtlxmc"></span></td>
	</tr>
	<tr align="center">
		<td colspan="2"><img id="pmtImg" width="300px" height="250px"></td>
	</tr>
</table>