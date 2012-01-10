<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjgzid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#bjgzid").append(setNull(json.LBjgz[0].bjgzid));
		$("#ywbm").append(setNull(json.LBjgz[0].ywbm));
		$("#bdbm").append(setNull(json.LBjgz[0].bdbm));
		$("#bdlx").append(setNull(json.LBjgz[0].bdlx));
		$("#sfyx").append(setNull(json.LBjgz[0].sfyx));
		$("#fbcl").append(setNull(json.LBjgz[0].fbcl));
		$("#fbfs").append(setNull(json.LBjgz[0].fbfs));
		$("#txdwzd").append(setNull(json.LBjgz[0].txdwzd));
		$("#gxdwzd").append(setNull(json.LBjgz[0].gxdwzd));
		$("#bjjb").append(setNull(json.LBjgz[0].bjjb));
		$("#bjfs").append(setNull(json.LBjgz[0].bjfs));
		$("#bjlx").append(setNull(json.LBjgz[0].bjlx));
	}	
</script>
<input type="hidden" id="q_bjgzid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="detailtd2">报警规则ID</td>
		<td class="detailtd1"><span id="bjgzid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">业务表名</td>
		<td class="detailtd1"><span id="ywbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">比对表名</td>
		<td class="detailtd1"><span id="bdbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">比对类型</td>
		<td class="detailtd1"><span id="bdlx"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">是否有效</td>
		<td class="detailtd1"><span id="sfyx"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">发布策略</td>
		<td class="detailtd1"><span id="fbcl"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">发布方式</td>
		<td class="detailtd1"><span id="fbfs"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">特行单位字段</td>
		<td class="detailtd1"><span id="txdwzd"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">管辖单位字段</td>
		<td class="detailtd1"><span id="gxdwzd"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">报警级别</td>
		<td class="detailtd1"><span id="bjjb"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">报警方式</td>
		<td class="detailtd1"><span id="bjfs"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">报警类型</td>
		<td class="detailtd1"><span id="bjlx"></span></td>
	</tr>
</table>