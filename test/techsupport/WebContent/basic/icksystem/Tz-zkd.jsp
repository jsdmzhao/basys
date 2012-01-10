<%@ page language="java" pageEncoding="UTF-8"%>
<style>
</style>
<script type="text/javascript">
	var pageDetailUrlId = "tzYlyZkd_detail";
	var zkd_tzxxtj="icksystem/zkdtzxxtj_icksl.action";
	$(document).ready(function() {
		$("#"+pageDetailUrlId).hide();
		$("#tzzkxx_detail").empty();
		$("#tzzkxx_detail").load("basic/icksystem/TzZkxxMan.jsp");
		$("#tzwlzb_detail").empty();
		$("#tzwlzb_detail").load("basic/icksystem/TzWlzbMan.jsp");
		//$("#tzxxtj_detail").empty();
		//$("#tzxxtj_detail").load("basic/icksystem/TzXxtj.jsp");
		//$("#tzdclxx_detail").empty();
		//$("#tzdclxx_detail").load("basic/icksystem/tzDclxx.jsp");
		//信息统计&待处理信息
		jQuery.post(zkd_tzxxtj,params,tzxxtj_updatediv,"json");
	});
	function tzxxtj_updatediv (json) {
	    $("#yshzp").append(setNull(json.LIcksl[0].yshzpsl));
	    $("#yzb").append(setNull(json.LIcksl[0].yzbsl));
	    $("#yys").append(setNull(json.LIcksl[0].yyssl));
	    $("#ydxr").append(setNull(json.LIcksl[0].ydxrsl));
	    $("#ickwlyfs").append(setNull(json.LIcksl[0].ickwlyfssl));
	    $("#ickwlyzb").append(setNull(json.LIcksl[0].ickwlyzbsl));
	    $("#ickwlyjs").append(setNull(json.LIcksl[0].ickwlyjssl));
	    $("#dshzp").append(setNull(json.LIcksl[0].dshzpsl));
	    $("#dzbxx").append(setNull(json.LIcksl[0].dzbsl));
	    $("#dysxx").append(setNull(json.LIcksl[0].dyssl));
	    $("#ddxrxx").append(setNull(json.LIcksl[0].ddxrsl));
	}
	
	function xxtjDeatil(url){
	    dataid = "xxtjFlag";
	    $(window.top.document.getElementById("iframes")).load(url);
	}
</script>
<body>

	<div style="float: left; margin-top: 0px;">
		<fieldset style="width: 615">
			<legend style="font-size: 13px;">
				&nbsp;制卡信息&nbsp;
			</legend>
			<div id="tzzkxx_detail"></div>
		</fieldset>

		<fieldset style="width: 615;">
			<legend style="font-size: 13px;">
				&nbsp;物流组包信息&nbsp;
			</legend>
			<div id="tzwlzb_detail"></div>
		</fieldset>
	</div>
	<div style="float: left; margin-top: 0px; margin-left: 7px">
		<fieldset style="width: 371">
			<legend style="font-size: 13px;">
				&nbsp;信息统计&nbsp;
			</legend>
			<table width="100%" bordercolordark='#FFFFFF'
				bordercolorlight='#cccccc' border='1' cellpadding='0'
				cellspacing='0'>
				<tr height="22">
					<td width="34%" align="right" style="padding-right: 5px">
						已审核照片信息
					</td>
					<td width="76%" align="left" style="padding-left: 3px">
						<span id="yshzp"></span>
					</td>
				</tr>
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						已组包
					</td>
					<td align="left" style="padding-left: 3px">
						<span id="yzb"></span>
					</td>
				</tr>
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						已印刷
					</td>
					<td align="left" style="padding-left: 3px">
						<span id="yys"></span>
					</td>
				</tr>
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						已电写入
					</td>
					<td align="left" style="padding-left: 3px">
						<span id="ydxr"></span>
					</td>
				</tr>
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						IC卡物流已发送
					</td>
					<td align="left" style="padding-left: 3px">
						<span id="ickwlyfs"></span>
					</td>
				</tr>
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						IC卡物流已组包
					</td>
					<td align="left" style="padding-left: 3px">
						<span id="ickwlyzb"></span>
					</td>
				</tr>
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						IC卡物流已接收
					</td>
					<td align="left" style="padding-left: 3px">
						<span id="ickwlyjs"></span>
					</td>
				</tr>
			</table>
		</fieldset>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="31"></td></tr>
</table>
		<fieldset style="width: 371">
			<legend style="font-size: 13px;">
				&nbsp;待处理信息&nbsp;
			</legend>
			<table width="100%" bordercolordark='#FFFFFF'
				bordercolorlight='#cccccc' border='1' cellpadding='0'
				cellspacing='0'>
				<tr height="22">
					<td width="34%" align="right" style="padding-right: 5px">
						待审核照片信息
					</td>
					<td width="76%" align="left" style="padding-left: 3px">
						<span id="dshzp"></span>
					</td>
				</tr>
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						待组包信息
					</td>
					<td align="left" style="padding-left: 3px">
						<span id="dzbxx"></span>
					</td>
				</tr>
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						待印刷信息
					</td>
					<td align="left" style="padding-left: 3px">
						<span id="dysxx"></span>
					</td>
				</tr>
				<tr height="22">
					<td align="right" style="padding-right: 5px">
						待电写入信息
					</td>
					<td align="left" style="padding-left: 3px">
						<span id="ddxrxx"></span>
					</td>
				</tr>
			</table>
		</fieldset>
	</div>

	<div id="tzYlyZkd_detail" class="page-layout" src="#"
		style="z-index: 2000; top: 60px; left: 0px;"></div>
</body>