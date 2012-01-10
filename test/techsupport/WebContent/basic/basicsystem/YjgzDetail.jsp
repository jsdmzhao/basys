<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_yjgzid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#yjgzid").append(setNull(json.LYjgz[0].yjgzid));
		$("#ywbm").append(setNull(json.LYjgz[0].ywbm));
		$("#bdbm").append(setNull(json.LYjgz[0].bdbm));
		$("#bdlx").append(setNull(json.LYjgz[0].bdlx));
		$("#sfyx").append(setNull(json.LYjgz[0].sfyx));
		$("#fbcl").append(setNull(json.LYjgz[0].fbcl));
		$("#fbfs").append(setNull(json.LYjgz[0].fbfs));
		$("#txdwzd").append(setNull(json.LYjgz[0].txdwzd));
		$("#gxdwzd").append(setNull(json.LYjgz[0].gxdwzd));
		$("#yjjb").append(setNull(json.LYjgz[0].yjjb));
		$("#yjfs").append(setNull(json.LYjgz[0].yjfs));
		$("#yjlx").append(setNull(json.LYjgz[0].yjlx));
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
		<td class="detailtd2">预警级别</td>
		<td class="detailtd1"><span id="yjjb"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">预警方式</td>
		<td class="detailtd1"><span id="yjfs"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">预警类型</td>
		<td class="detailtd1"><span id="yjlx"></span></td>
	</tr>
</table>