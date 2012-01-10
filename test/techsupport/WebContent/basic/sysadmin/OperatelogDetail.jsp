<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_operatelogid").attr("value",dataid);
		setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#operatelogid").append(setNull(json.LOperatelog[0].operatelogid));
		$("#operateunitcode").append(setNull(json.LOperatelog[0].operateunitcode));
		$("#operateunitname").append(setNull(json.LOperatelog[0].operateunitname));
		$("#operateuserid").append(setNull(json.LOperatelog[0].operateuserid));
		$("#useraccount").append(setNull(json.LOperatelog[0].useraccount));
		$("#username").append(setNull(json.LOperatelog[0].username));
		$("#operatesystem").append(setNull(json.LOperatelog[0].operatesystem));
		$("#operatemodule").append(setNull(json.LOperatelog[0].operatemodule));
		$("#operatesql").append(setNull(json.LOperatelog[0].operatesql));
		$("#operatetype").append(setNull(json.LOperatelog[0].operatetype));
		$("#operatedate").append(setNull(json.LOperatelog[0].operatedate));
	}	
</script>
<input type="hidden" id="q_operatelogid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">操作日志明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#operatelog_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr>
		<td class="distd1">操作单位代码</td>
		<td class="detailtd2"><span id="operateunitcode"></span></td>
	</tr>
	<tr>
		<td class="distd1">操作单位名称</td>
		<td class="detailtd2"><span id="operateunitname"></span></td>
	</tr>
	<tr>
		<td class="distd1">登录用户名</td>
		<td class="detailtd2"><span id="useraccount"></span></td>
	</tr>
	<tr>
		<td class="distd1">姓名</td>
		<td class="detailtd2"><span id="username"></span></td>
	</tr>
	<tr>
		<td class="distd1">操作子系统</td>
		<td class="detailtd2"><span id="operatesystem"></span></td>
	</tr>
	<tr>
		<td class="distd1">操作模块</td>
		<td class="detailtd2"><span id="operatemodule"></span></td>
	</tr>
	<tr>
		<td class="distd1">操作类型</td>
		<td class="detailtd2"><span id="operatetype"></span></td>
	</tr>
	<tr>
		<td class="distd1">操作sql语句</td>
		<td class="detailtd2"><span id="operatesql"></span></td>
	</tr>
	<tr>
		<td class="distd1">操作时间</td>
		<td class="detailtd2"><span id="operatedate"></span></td>
	</tr>
</table>