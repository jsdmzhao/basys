<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var zjhm;
$(document).ready(function() {
		$("#q_gzdxid").attr("value",dataid);
		setParams("q_");
		jQuery.post("basicsystem/query_gzdx.action",params,updatediv,"json");
	}); 
	function updatediv (json) { 
		$("#gzdxid").append(setNull(json.LGzdx[0].gzdxid));
		$("#xm").append(setNull(json.LGzdx[0].xm));
		$("#bm").append(setNull(json.LGzdx[0].bm));
		$("#minzu").append(setNull(json.LGzdx[0].minzu));
		$("#xb").append(setNull(json.LGzdx[0].xb));
		$("#csrq").append(setNull(json.LGzdx[0].csrq));
		$("#hjdxzqh").append(setNull(json.LGzdx[0].hjdxzqh));
		$("#hjdxz").append(setNull(json.LGzdx[0].hjdxz));
		$("#zjhm").append(setNull(json.LGzdx[0].zjhm))
		$("#whcd").append(setNull(json.LGzdx[0].whcd));
		$("#shengao").append(setNull(json.LGzdx[0].shengao));
		$("#xzdq").append(setNull(json.LGzdx[0].xzdq));
		$("#xzdqxz").append(setNull(json.LGzdx[0].xzdqxz));
		$("#zc").append(setNull(json.LGzdx[0].zc));
		$("#tbdw").append(setNull(json.LGzdx[0].tbdw));
		$("#tbdabm").append(setNull(json.LGzdx[0].tbdabm));
		$("#tbr").append(setNull(json.LGzdx[0].tbr));
		$("#tbrq").append(setNull(json.LGzdx[0].tbrq));
		$("#zxbz").append(setNull(json.LGzdx[0].zxbz));
		$("#bz").append(setNull(json.LGzdx[0].bz));
		$("#hylb").append(setNull(json.LGzdx[0].hylb));
		$("#hylbdm").attr("value",setNull(json.LGzdx[0].hylbdm));
		$("#h_zjhm").attr("value",setNull(json.LGzdx[0].zjhm));
		$("#m_lxdh").append(setNull(json.LGzdx[0].lxdh));
	}
	//采集信息，要根据行业来分，如果是旅馆业，则根据证件号去国内旅客里找，相当于是轨迹信息
	function cjxx(){
		if($("#hylbdm").attr("value") == "A"){
			setQueryGJ($("#h_zjhm").attr("value"));
		}else{
			setCyryCygj($("#h_zjhm").attr("value"))
		}
	}	
	
//旅客轨迹
function setQueryGJ(ozjhm){
	zjhm = ozjhm;
	//setWidth("gnlk_detail",detailWidth);
	$("#gnlk_detail").css("width","820px");
	//sLeft=ForDight((parseFloat(pageWidth)-parseFloat(sWidth))/2,2);
	$("#gnlk_detail").css("left","-100px");
	setUrl("gnlk_detail","business/Lgyzagl/Gnlk_lsxxMan.jsp");
	}
//从业人员从业轨迹
function setCyryCygj(zjhm){
	sFlag = "false";
	detailHeight=$("#gnlk_detail").css("height");
	dataid=zjhm;
	setWidth("gnlk_detail",detailWidth);
	$("#gnlk_detail").css("width",detailWidth);
	//sLeft=ForDight((parseFloat(pageWidth)-parseFloat(sWidth))/2,2);
	$("#gnlk_detail").css("left","0px");
	
	setUrl("gnlk_detail","business/Ylfwzagl/CyryxxCygjMan.jsp");
	var cyryxx_detailidOffset = $("#gnlk_detail").offset();	
	detailidTopOffset=cyryxx_detailidOffset.top;
	detailidLeftOffset=cyryxx_detailidOffset.left;
}
	
</script>
<input type="hidden" id="q_gzdxid">
<input type="hidden" id="hylbdm">
<input type="hidden" id="h_zjhm">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			关注对象详细
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='$("#gzdx_detail").hideAndRemove(&quot;show&quot;);' class="close"></a>
		</td>
	</tr>
</table>
<div id="printDiv" class="scrollbarface"  style="overflow-y:auto;overflow-x:hidden;height:320">
<table width="100%" cellpadding="4" cellspacing="0" class="detail"
	id="detail">
<tr>
		<td width="20%" class="distd1">
			姓名		</td>
		<td width="29%" class="detailtd2">
			<span id="xm"></span>		</td>
		<td width="17%" class="distd1">
			身份证号码		</td>
		<td width="34%" class="detailtd2">
			<span id="zjhm"></span>		</td>
	</tr>
	<tr>
		<td class="distd1">
			性别		</td>
		<td class="detailtd2">
			<span id="xb"></span>		</td>
		<td class="distd1">
			出生日期		</td>
		<td class="detailtd2">
			<span id="csrq"></span>		</td>
	</tr>
	<tr>
		<td class="distd1">
			民族		</td>
		<td class="detailtd2">
			<span id="minzu"></span>		</td>
		<td class="distd1">
			户籍地行政区划		</td>
		<td class="detailtd2">
			<span id="hjdxzqh"></span>		</td>
	</tr>
	<tr>
		<td class="distd1">
			别名		</td>
		<td class="detailtd2">
			<span id="bm"></span>		</td>
		<td class="distd1">
			文化程度		</td>
		<td class="detailtd2">
			<span id="whcd"></span>		</td>
	</tr>
		<td class="distd1">
			现住地区		</td>
		<td class="detailtd2">
			<span id="xzdq"></span>		</td>
		<td class="distd1">
			专长		</td>
		<td class="detailtd2">
			<span id="zc"></span>		</td>
	</tr>
	<tr>
		<td class="distd1">
			户籍地详址		</td>
		<td colspan="3" class="detailtd2">
			<span style="width:360" id="hjdxz"></span>		</td>
	</tr>
	<tr>
		<td class="distd1">
			现住地区详址		</td>
		<td colspan="3" class="detailtd2">
			<span style="width:360" id="xzdqxz"></span>		</td>
	</tr>
	<tr>
		<td class="distd1">
			身高		</td>
		<td class="detailtd2">
			<span id="shengao"></span>		</td>
		<td class="distd1">
			填报人		</td>
		<td class="detailtd2">
			<span id="tbr"></span>		</td>
	</tr><tr>
		<td class="distd1">
			联系电话
		</td>
		<td class="detailtd2" colspan="3"><span id="m_lxdh"></span>	
		</td></tr>
	<tr>
		<td class="distd1">
			填报日期		</td>
		<td class="detailtd2">
			<span id="tbrq"></span>		</td>
		<td class="distd1">
			填报单位编码		</td>
		<td class="detailtd2">
			<span id="tbdabm"></span>		</td>
	</tr>
		<tr>
			<td class="distd1">
				填报单位
			</td>
			<td colspan="3" class="detailtd2">
				<span id="tbdw" style="width:410"></span>
			</td>
		</tr>
	<tr>
		<td class="distd1">
			关注原因		</td>
		<td colspan="3" class="detailtd2">
			<span id="bz" style="width:360"></span>		</td>
	</tr>
	<tr>
		<td class="distd1">
			行业类别		</td>
		<td colspan="3" class="detailtd2">
			<span id="hylb"></span>			</td>
	</tr>
</table>	
</div>
<table border="0" cellpadding="2" cellspacing="0">
<tr align="center">
		<td colspan="2" align="right">
			<a href="#" id="addbutton" hidefocus="true"
				class="submitbutton" title="采集信息" onclick='cjxx();'>采集信息</a>
		</td>
		<td colspan="1" align="center">
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="打印" onclick='printpage("printDiv");'>打印</a>
		</td>
		<td colspan="1" align="right">&nbsp;
			
		</td>
	</tr>
</table>
<div id="gnlk_detail"  class="page-layout" src="#"
	style="display:none;top:-80px; left:160px;">
</div>
<!--打印的方法-->
<script type="text/javascript">
function printpage(myDiv){ 
   var content = document.all.item(myDiv).innerHTML;
    var title = "关注对象详细信息"; //标题信息
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
