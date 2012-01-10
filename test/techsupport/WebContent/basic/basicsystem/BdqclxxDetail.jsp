<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(1,'打印'); //将保存按钮右移
		$("#q_bdqclxxid").attr("value",dataid);
		setDetail();
	}); 

	function updatediv (json) {
		$("#ajbh").append(setNull(json.LBdqclxx[0].ajbh));
		$("#ajxz").append(setNull(json.LBdqclxx[0].ajxz));
		$("#clpp").append(setNull(json.LBdqclxx[0].clpp));
		$("#clxh").append(setNull(json.LBdqclxx[0].clxh));
		$("#hpzl").append(setNull(json.LBdqclxx[0].hpzl));
		$("#hphm").append(setNull(json.LBdqclxx[0].hphm));
		$("#csys").append(setNull(json.LBdqclxx[0].csys));
		$("#syr").append(setNull(json.LBdqclxx[0].syr));
		$("#ccdjrq").append(setNull(json.LBdqclxx[0].ccdjrq));
		$("#fdjh").append(setNull(json.LBdqclxx[0].fdjh));
		$("#clsbdh").append(setNull(json.LBdqclxx[0].clsbdh));
		$("#cjh").append(setNull(json.LBdqclxx[0].cjh));
		$("#sfbx").append(setNull(json.LBdqclxx[0].sfbx));
		$("#bar").append(setNull(json.LBdqclxx[0].bar));
		$("#lasj").append(setNull(json.LBdqclxx[0].lasj));
		$("#basj").append(setNull(json.LBdqclxx[0].lasj));
		$("#tbdwmc").append(setNull(json.LBdqclxx[0].tbdwmc));
		$("#tbtbr").append(setNull(json.LBdqclxx[0].tbtbr));
		$("#tbsj3").append(setNull(json.LBdqclxx[0].tbsj3));
		$("#lrdw").append(setNull(json.LBdqclxx[0].lrdw));
		$("#lrr").append(setNull(json.LBdqclxx[0].lrr));
		$("#lrsj").append(setNull(json.LBdqclxx[0].lrsj));
		$("#spr3").append(setNull(json.LBdqclxx[0].spr3));
		$("#spyj").append(setNull(json.LBdqclxx[0].spyj));
	}	
	<!--打印的方法-->
function printpage(myDiv){ 
   var content = document.all.item(myDiv).innerHTML;
    var title = "被盗抢车辆详细信息"; //标题信息
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
<input type="hidden" id="q_bdqclxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">被盗抢车辆详细信息</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#bdqclxx_detail").hideAndRemove(&quot;show&quot;);' class="close"></a></td>
    </tr>
</table>
<div id="printDiv" class="scrollbarface"  style="overflow-y:auto;height:230">
<table width="100%" class="detail" id="detail">
  <tr height="20">
    <td width="9%" class="distd1">案件编号</td>
    <td width="24%" class="detailtd2"><span id="ajbh"></span></td>
    <td width="10%" class="distd1">立案时间</td>
    <td width="25%" class="detailtd2"><span id="lasj"></span></td>
    <td width="11%" class="distd1">车辆品牌</td>
    <td width="21%" class="detailtd2"><span id="clpp"></span></td>
  </tr>
  <tr height="20">
    <td class="distd1">车辆型号</td>
    <td class="detailtd2"><span id="clxh"></span></td>
    <td class="distd1">号牌种类</td>
    <td class="detailtd2"><span id="hpzl"></span></td>
    <td class="distd1">车辆号牌</td>
    <td class="detailtd2"><span id="hphm"></span></td>
  </tr>
  <tr height="20">
    <td class="distd1">发动机号</td>
    <td class="detailtd2"><span id="fdjh"></span></td>
    <td class="distd1">车架号</td>
    <td class="detailtd2"><span id="cjh"></span></td>
    <td class="distd1">车辆识别代号</td>
    <td class="detailtd2"><span id="clsbdh"></span></td>
  </tr>
  <tr height="20">
    <td class="distd1">初次登记时间</td>
    <td class="detailtd2"><span id="ccdjrq"></span></td>
    <td class="distd1">车身颜色</td>
    <td class="detailtd2"><span id="csys"></span></td>
    <td class="distd1">是否参加被盗抢险</td>
    <td class="detailtd2"><span id="sfbx"></span></td>
  </tr>
  <tr height="20">
    <td class="distd1">机动车所有人</td>
    <td class="detailtd2"><span id="syr"></span></td>
    <td class="distd1">案件性质</td>
    <td class="detailtd2"><span id="ajxz"></span></td>
    <td class="distd1">报案时间</td>
    <td class="detailtd2"><span id="basj"></span></td>
  </tr>
  <tr height="20">
    <td class="distd1">报案人</td>
    <td class="detailtd2"><span id="bar"></span></td>
    <td class="distd1">填报单位</td>
    <td class="detailtd2"><span id="tbdwmc"></span></td>
    <td class="distd1">填表人</td>
    <td class="detailtd2"><span id="tbtbr"></span></td>
  </tr>
  <tr height="20">
    <td class="distd1">填报时间</td>
    <td class="detailtd2"><span id="tbsj3"></span></td>
    <td class="distd1">审批人</td>
    <td class="detailtd2" colspan="3"><span id="spr3"></span></td>
  </tr>
  <tr height="20">
    <td class="distd1">审批意见</td>
    <td class="detailtd2" colspan="5"><span id="spyj"></span></td>
  </tr>
  <tr height="20">
    <td class="distd1">录入单位</td>
    <td class="detailtd2"><span id="lrdw"></span></td>
    <td class="distd1">录入人</td>
    <td class="detailtd2"><span id="lrr"></span></td>
    <td class="distd1">录入时间</td>
    <td class="detailtd2"><span id="lrsj"></span></td>
  </tr>
</table>
</div>
   <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr align="center">
	            <td>
                <a href="#" id="printbutton" hidefocus="true" class="submitbutton"
				 title="打印" onclick='printpage(&quot;printDiv&quot;);'>打印</a>
				</td>
			  </tr>
    </table>