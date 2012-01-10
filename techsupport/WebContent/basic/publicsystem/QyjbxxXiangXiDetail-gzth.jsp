<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../../public/common.jsp" %>
<HTML>
<style type="text/css">
	.zhehangtd {border:1px dotted  #d7d7d7;text-align:right;}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		hyInit();
	});
</script>
<BODY>
	<table width="100%"  cellspacing="0" cellpadding="0" class="line" >
	<tr>
	<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="1" class="detail">
			<tr>
		      	<td width="13%" class="distd1">行业类别</td>
		        <td width="14%"  class="detailtd2"><span width="383px" id="hylb"></span></td>
		        <td width="21%" class="distd1"><label id="gxdw_title"></label></td>
		        <td width="51%"  class="detailtd2"><span width="383px" id="gxdwmc"></span></td>
			</tr>
			<tr id="hqZhuFuType">
		        <td class="distd1"><label id="qyorcs_title"></label>分类（主）</td>
		        <td width="383px" class="detailtd2"><span id="qyzflmc"></span></td>
		        <td class="distd1" id="yly_csffl_title" style="display:none"><label id="qyorcs_title"></label>分类（副）</td>
		        <td width="383px" class="detailtd2" id="yly_csffl_content" style="display:none"><span id="qyfflmc"></span></td>
			</tr>
		</table>
		<div id="QyJibenxiangmu"></div>
	</td>
	</tr>
	</table>
</BODY>
</HTML>