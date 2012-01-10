<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants"%>
<%
	User user = (User) session.getAttribute(Constants.userKey);
%>
<script type="text/javascript">
	$(document).ready(function() {
	
		// 读取报警信息数据
		setParams("m_");
		jQuery.post("basicsystem/query_bjxxb.action",params,bjxxDetaildiv,"json"); // 提交到BjxxbAction中,调用其中的query方法
	
	}); 
	function bjxxDetaildiv (json) {                         
		$("#bjxxDetail_show_sfqrbj").append(setNull(json.LBjxxb[0].show_sfqrbj));
		$("#bjxxDetail_show_sfcj").append(setNull(json.LBjxxb[0].show_sfcj));
		$("#bjxxDetail_bjgzid").append(setNull(json.LBjxxb[0].bjgzid));
		$("#bjxxDetail_bjxxid").append(setNull(json.LBjxxb[0].bjxxid));
		$("#bjxxDetail_ssqymc").append(setNull(json.LBjxxb[0].ssqymc));
		$("#bjxxDetail_ssqydz").append(setNull(json.LBjxxb[0].ssqydz));
		$("#bjxxDetail_gxdwbm").append(setNull(json.LBjxxb[0].gxdwbm));
		$("#bjxxDetail_gxdwmc").append(setNull(json.LBjxxb[0].gxdwmc));
		$("#bjxxDetail_bjlx").append(setNull(json.LBjxxb[0].bjlx));
		$("#bjxxDetail_bjsj").append(setNull(json.LBjxxb[0].bjsj));
		$("#bjxxDetail_bdbm").append(setNull(json.LBjxxb[0].bdbm));
		$("#bjxxDetail_ywbm").append(setNull(json.LBjxxb[0].ywbm));
		$("#bjxxDetail_hylb").append(setNull(json.LBjxxb[0].hylb));
		$("#bjxxDetail_xm").append(setNull(json.LBjxxb[0].xm));
		$("#bjxxDetail_gmsfhm").append(setNull(json.LBjxxb[0].gmsfhm));
		$("#bjxxDetail_jyaq").append(setNull(json.LBjxxb[0].jyaq));
		$("#bjxxDetail_ladwbm").append(setNull(json.LBjxxb[0].ladwbm));
		$("#bjxxDetail_ladwmc").append(setNull(json.LBjxxb[0].ladwmc));
		$("#bjxxDetail_gxbbh").append(setNull(json.LBjxxb[0].gxbbh));
		$("#bjxxDetail_ywlb").append(setNull(json.LBjxxb[0].ywlb));
		$("#bjxxDetail_pjbmdm").append(setNull(json.LBjxxb[0].pjbmdm));
		$("#bjxxDetail_pjbmmc").append(setNull(json.LBjxxb[0].pjbmmc));
		$("#bjxxDetail_pjr").append(setNull(json.LBjxxb[0].pjr));
		$("#bjxxDetail_pjsj").append(setNull(json.LBjxxb[0].pjsj));
		$("#bjxxDetail_jqzt").append(setNull(json.LBjxxb[0].jqzt));
		$("#bjxxDetail_cjbm").append(setNull(json.LBjxxb[0].cjbm));
		$("#bjxxDetail_cjbmdm").append(setNull(json.LBjxxb[0].cjbmdm));
		$("#bjxxDetail_chjsj").append(setNull(json.LBjxxb[0].chjsj));
		$("#bjxxDetail_cjfzr").append(setNull(json.LBjxxb[0].cjfzr));
		$("#bjxxDetail_lxdh").append(setNull(json.LBjxxb[0].lxdh));
		$("#bjxxDetail_cjfklb").append(setNull(json.LBjxxb[0].cjfklb));
		$("#bjxxDetail_cjfkbz").append(setNull(json.LBjxxb[0].cjfkbz));
		$("#bjxxDetail_fkdw").append(setNull(json.LBjxxb[0].fkdw));
		$("#bjxxDetail_fkdwbm").append(setNull(json.LBjxxb[0].fkdwbm));
		$("#bjxxDetail_fkrq").append(setNull(json.LBjxxb[0].fkrq));
		$("#bjxxDetail_fkr").append(setNull(json.LBjxxb[0].fkr));
		$("#bjxxDetail_cjjg").append(setNull(json.LBjxxb[0].cjjg));
		$("#bjxxDetail_chjjg").append(setNull(json.LBjxxb[0].chjjg));
		$("#bjxxDetail_zhsj").append(setNull(json.LBjxxb[0].zhsj));
		$("#bjxxDetail_wxyy").append(setNull(json.LBjxxb[0].wxyy));
		$("#bjxxDetail_sfyxbj").append(setNull(json.LBjxxb[0].sfyxbj));
		$("#bjxxDetail_ywbzj").val(setNull(json.LBjxxb[0].ywbzj));
		$("#bjxxDetail_hylbdm").val(setNull(json.LBjxxb[0].hylbdm));
		showOtherJsp();
	}	
	
function showOtherJsp(){
	// 读取本地布控或者全国在逃人员数据
	$("#div_bdxx").empty();
	if($("#current_recordBjlx").attr("value")=="全国在逃报警"){
		$("#div_bdxx").load("basic/basicsystem/BjxxDetailQgztjyxxKz.jsp");
	}else if($("#current_recordBjlx").attr("value")=="本地布控报警"){
		$("#div_bdxx").load("basic/basicsystem/BjxxDetailBdbkryxxKz.jsp");
	}
	$("#div_bdxx").show("slow");
	
	dataid = $("#bjxxDetail_ywbzj").attr("value");
	var hylbdm = $("#bjxxDetail_hylbdm").attr("value");
	// 读取国内旅客历史信息或从业人员历史信息
	$("#div_ywxx").empty();
	if(hylbdm=="A"){
		$("#div_ywxx").load("business/Lgyzagl/Gnlk_lsxxDetail.jsp");
	}else if(hylbdm=="J"){
		$("#div_ywxx").load("business/Ylfwzagl/Cyryxx_lsxxDetailKz.jsp");
	}
	$("#div_ywxx").show("slow");
}
<!--打印的方法-->
function printpage(myDiv){ 
   var content = document.all.item(myDiv).innerHTML;
    var title = "报警详细信息"; //标题信息
    params={con:content,titlecon:title};
    jQuery.post("basicsystem/printCon_publicPrint.action",params,printback,"json");
    return false; 
} 

function printback(){
    var url = window.location.href;
   var len = url.lastIndexOf('/');
   url = url.substring(0, len)+"/public/printHtml.jsp";
   window.open(url);
}
</script>
<input type="hidden" id="bjxxDetail_ywbzj">
<input type="hidden" id="bjxxDetail_hylbdm">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			报警信息详细信息
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='divclear($("#bjxxbStats_detail"));' class="close"></a>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="5"></td>
	</tr>
</table>
<div id="printDiv" class="scrollbarface" style="overflow-y: auto; overflow-x: hidden; height: 500">
	<table width="100%" cellpadding="0" cellspacing="0" class="tableborder">
		<tr>
			<td width="28%" colspan="6">
				<div style="width: 100%" id="div_bdxx"></div>
			</td>
		</tr>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="5"></td>
		</tr>
	</table>
	<table width="100%" cellpadding="0" cellspacing="0" class="tableborder">
		<tr>
			<td width="28%" colspan="6">
				<div style="width: 100%" id="div_ywxx"></div>
			</td>
		</tr>
	</table>

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
	<table width="100%" cellpadding="0" cellspacing="0" class="tableborder">
		<tr>
			<td colspan="6" height="8" class="queryfont">
				接处警基本情况
			</td>
		</tr>
		<tr align="center">
			<td colspan="6" class="tdbg">
				<table width="100%" cellpadding="4" cellspacing="0" class="detail"
					id="detail2">
					<tr>
						<td width="13%" class="distd1">
							是否确认报警
						</td>
						<td width="20%" class="detailtd2">
							<span id="bjxxDetail_show_sfqrbj" /></span>
						</td>
						<td width="13%" class="distd1">
							是否有效报警
						</td>
						<td width="20%" class="detailtd2">
							<span id="bjxxDetail_sfyxbj" /></span>
						</td>
						<td width="13%" class="distd1">
							是否处警
						</td>
						<td width="20%" class="detailtd2">
							<span id="bjxxDetail_show_sfcj" /></span>
						</td>
					</tr>
					<tr>
						<td class="distd1">
							处警时间
						</td>
						<td class="detailtd2">
							<span id="bjxxDetail_chjsj" /></span>
						</td>
						<td class="distd1">
							处警部门
						</td>
						<td class="detailtd2">
							<span id="bjxxDetail_cjbm" /></span>
						</td>
						<td class="distd1">
							是否抓获
						</td>
						<td class="detailtd2">
							<span id="bjxxDetail_chjjg" /></span>
						</td>
					</tr>
					<tr>
						<td class="distd1">
							处警反馈情况
						</td>
						<td colspan="3" class="detailtd2">
							<span id="bjxxDetail_cjfkbz" /></span>
						</td>
					</tr>
					<tr>
						<td class="distd1">
							登记单位
						</td>
						<td class="detailtd2">
							<span id="bjxxDetail_fkdw" /></span>
						</td>
						<td class="distd1">
							登记人员
						</td>
						<td class="detailtd2">
							<span id="bjxxDetail_fkr" /></span>
						</td>
						<td class="distd1">
							登记时间
						</td>
						<td class="detailtd2">
							<span id="bjxxDetail_fkrq" /></span>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
	</tr>
</table>
<tr align="center">
	<td colspan="6">
		<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
			title="打印" onclick='printpage("printDiv");'>打印</a>
	</td>
</tr>
</table>