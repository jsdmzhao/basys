<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qgztjxid").attr("value",dataid);
			setDetail();
	}); 
		
	function updatediv (json) { 
		$("#tbbh").append(setNull(json.LQgztjx[0].tbbh));
		$("#xzqh").append(setNull(json.LQgztjx[0].xzqh));
		$("#xm").append(setNull(json.LQgztjx[0].xm));
		$("#bm").append(setNull(json.LQgztjx[0].bm));
		$("#xb").append(setNull(json.LQgztjx[0].xb));
		$("#csrq").append(setNull(json.LQgztjx[0].csrq));
		$("#gmsfhm").append(setNull(json.LQgztjx[0].gmsfhm));
		$("#hjd").append(setNull(json.LQgztjx[0].hjd));
		$("#hjxxdz").append(setNull(json.LQgztjx[0].hjxxdz));
		$("#xzdq").append(setNull(json.LQgztjx[0].xzdq));
		$("#xzdxxdz").append(setNull(json.LQgztjx[0].xzdxxdz));
		$("#qtzjlx").append(setNull(json.LQgztjx[0].qtzjlx));
		$("#qtzjhm").append(setNull(json.LQgztjx[0].qtzjhm));
		$("#ladq").append(setNull(json.LQgztjx[0].ladq));
		$("#badw").append(setNull(json.LQgztjx[0].badw));
		$("#tbr").append(setNull(json.LQgztjx[0].tbr));
		$("#lxr").append(setNull(json.LQgztjx[0].lxr));
		$("#lxfs").append(setNull(json.LQgztjx[0].lxfs));
		$("#ajlb").append(setNull(json.LQgztjx[0].ajlb));
		$("#djrq").append(setNull(json.LQgztjx[0].djrq));
	}
	function hideAll(){
		$("#qgztjx_detail").empty();
		$("#qgztjx_detail").hideAndRemove("show");
	}		
</script>
<input type="hidden" id="q_qgztjxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			全国在逃人员详细信息
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='hideAll();'class="close"></a>
		</td>
	</tr>
</table>
<div id="printDiv" class="scrollbarface"  style="overflow-y:auto;overflow-x:hidden;height:240">
<table width="100%" border="0" cellpadding="2" cellspacing="0" class="detail" id="detail" >
<tr height="20">
		<td width="12%" class="distd1">
			姓名
		</td>
		<td width="21%" class="detailtd2">
			<span id="xm"></span>
		</td>
		<td width="12%" class="distd1">
			别名
		</td>
		<td width="21%" class="detailtd2">
			<span id="bm"></span>
		</td>
		<td width="13%" class="distd1">
			公民身份号码
		</td>
		<td width="21%" class="detailtd2">
			<span id="gmsfhm"></span>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1">
			性别
		</td>
		<td class="detailtd2">
			<span id="xb"></span>
		</td>
		<td class="distd1">
			出生日期
		</td>
		<td class="detailtd2">
			<span id="csrq"></span>
		</td>
		<td class="distd1">
			其他证件类型
		</td>
		<td class="detailtd2">
			<span id="qtzjlx"></span>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1">
			其他证件号码
		</td>
		<td class="detailtd2">
			<span id="qtzjhm"></span>
		</td>
		<td class="distd1">
			通报编号
		</td>
		<td class="detailtd2">
			<span id="tbbh"></span>
		</td>
		<td class="distd1">
			案件类别
		</td>
		<td class="detailtd2">
			<span id="ajlb"></span>
		</td>
	</tr>	
	<tr height="20">
		<td class="distd1">
			户籍地
		</td>
		<td class="detailtd2">
			<span id="hjd"></span>
		</td>
		<td class="distd1">
			户籍详细地址
		</td>
		<td class="detailtd2" colspan="3">
			<span id="hjxxdz"></span>
		</td>
	</tr>
	<tr height="20">	
		<td class="distd1">
			现住地区
		</td>
		<td class="detailtd2">
			<span id="xzdq"></span>
		</td>
		<td class="distd1">
			现住地详细地址
		</td>
		<td class="detailtd2" colspan="3">
			<span id="xzdxxdz"></span>
		</td>
	</tr>
	<tr height="20">		
		<td class="distd1">
			行政区划
		</td>
		<td class="detailtd2">
			<span id="xzqh"></span>
		</td>
		<td class="distd1">
			立案地区
		</td>
		<td class="detailtd2">
			<span id="ladq"></span>
		</td>
		<td class="distd1">
			办案单位
		</td>
		<td class="detailtd2">
			<span id="badw"></span>
		</td>
	</tr>
	<tr height="20">	
		<td class="distd1">
			登记日期
		</td>
		<td class="detailtd2">
			<span id="djrq"></span>
		</td>
		<td class="distd1">
			填表人
		</td>
		<td class="detailtd2">
			<span id="tbr"></span>
		</td>
		<td class="distd1">
			联系人
		</td>
		<td class="detailtd2">
			<span id="lxr"></span>
		</td>
	</tr>
	<tr height="20">	
		<td class="distd1">
			联系方式
		</td>
		<td class="detailtd2">
			<span id="lxfs"></span>
		</td>
	</tr>
</table>
</div>
<table>
	<tr align="center">
		<td colspan="6" height="8"></td>
	</tr>
	<tr align="center">
		<td colspan="6">
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="打印" onclick='printpage("printDiv");'>打印</a>
		</td>
	</tr>
</table>

<!--打印的方法-->
<script type="text/javascript">
function printpage(myDiv){ 
   var content = document.all.item(myDiv).innerHTML;
    var title = "全国在逃详细信息"; //标题信息
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
