<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
	$("#printbutton").css('margin-right', 5); //将保存按钮右移
		// 读取报警信息数据
		setParams("m_");
		jQuery.post("basicsystem/query_wpbjxxb.action",params,wpbjxxDetaildiv,"json"); // 提交到WpbjxxbAction中,调用其中的query方法
	
	}); 
	
	function wpbjxxDetaildiv (json) { 
	    $("#wpbjxxbDetail_ywbzj").val(setNull(json.LWpbjxxb[0].ywbzj));
	    $("#wpbjxxbDetail_hylbdm").val(setNull(json.LWpbjxxb[0].hylbdm));
		$("#wpbjxxDetail_show_sfqrbj").append(setNull(json.LWpbjxxb[0].show_sfqrbj));
		$("#wpbjxxDetail_show_zby").append(setNull(json.LWpbjxxb[0].pjr));
		$("#wpbjxxDetail_show_sfcj").append(setNull(json.LWpbjxxb[0].show_sfcj));
		$("#wpbjxxDetail_chjsj").append(setNull(json.LWpbjxxb[0].chjsj));
		$("#wpbjxxDetail_cjbmbm").append(setNull(json.LWpbjxxb[0].pjbmbm));
		$("#wpbjxxDetail_cjbmmc").append(setNull(json.LWpbjxxb[0].pjbmmc));
		$("#wpbjxxDetail_show_sfcx").append(setNull(json.LWpbjxxb[0].show_sfcx));
		$("#wpbjxxDetail_show_cxsj").append(setNull(json.LWpbjxxb[0].show_cxsj));
		$("#wpbjxxDetail_fkdw").append(setNull(json.LWpbjxxb[0].fkdw));
		$("#wpbjxxDetail_fkrq").append(setNull(json.LWpbjxxb[0].fkrq));
		$("#wpbjxxDetail_sfyxbj").append(setNull(json.LWpbjxxb[0].sfyxbj));
		$("#wpbjxxDetail_sfzh").append(setNull(json.LWpbjxxb[0].chjjg));
		$("#wpbjxxDetail_cjfkbz").append(setNull(json.LWpbjxxb[0].cjfkbz));
		$("#wpbjxxDetail_show_sflw").append(setNull(json.LWpbjxxb[0].show_sflw));
		$("#wpbjxxDetail_show_djdw").append(setNull(json.LWpbjxxb[0].fkdw));
		$("#wpbjxxDetail_show_djry").append(setNull(json.LWpbjxxb[0].fkr));
		$("#wpbjxxDetail_show_djsj").append(setNull(json.LWpbjxxb[0].fkrq));
		$("#wpbjxxbDetail_ywbm").val(setNull(json.LWpbjxxb[0].ywbm));
		showOtherJsp();
	}
function showOtherJsp(){
	// 读取本地布控或者被盗抢车辆报警数据
	$("#div_bdxx").empty();
	$("#div_ywxx").empty();
	var bjlx = $("#current_recordBjlx").attr("value");
	dataid = $("#wpbjxxbDetail_ywbzj").attr("value");
	var hylbdm = $("#wpbjxxbDetail_hylbdm").attr("value");
	var ywbm = $("#wpbjxxbDetail_ywbm").attr("value");
	if(bjlx=="6"){// 被盗抢车辆报警
		$("#div_bdxx").load("basic/basicsystem/WpbjxxbDetailBdqclxx.jsp");
		if(hylbdm=="E03"){// 典当
		    $("#div_ywxx").load("basic/basicsystem/WpbjxxywBdqcl.jsp");
		}else if(hylbdm=="C"){// 机修
			if(ywbm=="t_cljbxx"){
				$("#div_ywxx").load("basic/publicsystem/CljbxxDetail.jsp");
			}else if(ywbm=="t_jxcljbxx"){
				$("#div_ywxx").load("business/jxyzagl/JxclbjywDetail.jsp");
			}
		}else if(hylbdm=="E01"){// 二手车
		    $("#div_ywxx").load("basic/publicsystem/CljbxxDetail.jsp");
		}else if(hylbdm=="F01"){// 出租汽车
		    $("#div_ywxx").load("basic/publicsystem/CljbxxDetail.jsp");
		}else if(hylbdm=="F02"){// 汽车租赁
		    $("#div_ywxx").load("basic/publicsystem/CljbxxDetail.jsp");
		}
	}else if(bjlx=="2"){// 本地布控报警
		$("#div_bdxx").load("basic/basicsystem/WpbjxxbDetailBkwpxx.jsp");
		if(hylbdm=="E03"){// 典当
		    $("#div_ywxx").load("basic/basicsystem/WpbjxxywBdbk.jsp");
		}else if(hylbdm=="C"){// 机修
		    if(ywbm=="t_cljbxx"){
				$("#div_ywxx").load("basic/publicsystem/CljbxxDetail.jsp");
			}else if(ywbm=="t_jxcljbxx"){
				$("#div_ywxx").load("business/jxyzagl/JxclbjywDetail.jsp");
			}
		}else if(hylbdm=="E01"){// 二手车
		    $("#div_ywxx").load("basic/publicsystem/CljbxxDetail.jsp");
		}else if(hylbdm=="E02"){// 二手机
		    $("#div_ywxx").load("business/esjzagl/EsjjyDetail.jsp",function(){$("#tablehead").hide();});
		}else if(hylbdm=="F01"){// 出租汽车
		    $("#div_ywxx").load("basic/publicsystem/CljbxxDetail.jsp");
		}else if(hylbdm=="F02"){// 汽车租赁
		    $("#div_ywxx").load("basic/publicsystem/CljbxxDetail.jsp");
		}
	}else if(bjlx=="7"){// 被盗抢报警手机
		$("#div_bdxx").load("basic/basicsystem/WpbjxxbDetailBdqsjxx.jsp");
		if(hylbdm=="E03"){// 典当
		    $("#div_ywxx").load("basic/basicsystem/WpbjxxywBdqsj.jsp");
		}else if(hylbdm=="E02"){// 二手机
		    $("#div_ywxx").load("business/esjzagl/EsjjyDetail.jsp",function(){$("#tablehead").hide();});
		}
	}
	$("#div_bdxx").show("slow");
	$("#div_ywxx").show("slow");
}
<!--打印的方法-->
function printpage(myDiv){ 
   var content = document.all.item(myDiv).innerHTML;
    var title = "报警信息详细信息"; //标题信息
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
<input type="hidden" id="wpbjxxbDetail_ywbzj">
<input type="hidden" id="wpbjxxbDetail_hylbdm">
<input type="hidden" id="wpbjxxbDetail_ywbm">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">报警信息详细信息</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#wpbjxxb_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<div id="printDiv" class="scrollbarface"  style="overflow-y:auto;height:500">
<table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="5"></td>
  </tr>
</table>
<table width="98%" cellpadding="0" cellspacing="0">
 <tr>
      <td width="28%" colspan="6" ><div style="width:100%" id="div_bdxx"></div></td>
    </tr>
</table>
<table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="5"></td>
  </tr>
</table>
<table width="98%" cellpadding="0" cellspacing="0" >
 <tr>
      <td width="28%" colspan="6" ><div style="width:100%" id="div_ywxx"></div></td>
    </tr>
</table>
<table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="3"></td>
  </tr>
</table>
  <table width="98%" class="detail" id="detail">
    <tr>
      <td valign="top">
      <table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">   
    <tr><td  height="8" class="queryfont">接处警基本情况</td></tr>
  <tr><td  class="tdbg">
  <table width="100%" cellpadding="4" cellspacing="0" class="detail"  id="detail2">
    <tr>
      <td width="13%" class="distd1">是否确认报警</td>
      <td width="20%" class="detailtd2"><span id="wpbjxxDetail_show_sfqrbj"/></span></td>
     <td width="13%" class="distd1">值班员</td>
      <td width="20%" class="detailtd2"><span id="wpbjxxDetail_show_zby"/></span></td>
      <td width="13%" class="distd1">是否出警</td>
      <td width="20%" class="detailtd2"><span id="wpbjxxDetail_show_sfcj"/></span></td>
          </tr>
    <tr>
      <td class="distd1">出警时间</td>
      <td class="detailtd2"><span id="wpbjxxDetail_chjsj"/></span></td>
       <td class="distd1">处警部门代码</td>
      <td class="detailtd2"><span id="wpbjxxDetail_cjbmbm"/></span></td>
     <td class="distd1">处警部门</td>
      <td class="detailtd2"><span id="wpbjxxDetail_cjbmmc"/></span></td>
          </tr>
        <tr>
      <td class="distd1">是否撤销</td>
      <td class="detailtd2"><span id="wpbjxxDetail_show_sfcx"/></span></td>
     <td class="distd1">撤销时间</td>
      <td class="detailtd2"><span id="wpbjxxDetail_show_cxsj"/></span></td>
      <td class="distd1">反馈单位</td>
      <td class="detailtd2"><span id="wpbjxxDetail_fkdw"/></span></td>
                </tr>
        <tr>
     <td class="distd1">反馈日期</td>
      <td class="detailtd2"><span id="wpbjxxDetail_fkrq"/></span></td>
	  <td width="13%" class="distd1">是否有效报警</td>
      <td width="20%" class="detailtd2"><span id="wpbjxxDetail_sfyxbj"/></span></td>
      <td class="distd1">是否抓获</td>
      <td class="detailtd2"><span id="wpbjxxDetail_sfzh"/></span></td>
    </tr>
    <tr>
      <td class="distd1">处警反馈情况</td>
      <td colspan="5" class="detailtd2"><span id="wpbjxxDetail_cjfkbz"/></span></td>
    </tr>
        <tr>
      <td class="distd1">是否漏网</td>
      <td class="detailtd2"><span id="wpbjxxDetail_show_sflw"/></span></td>
      <td class="distd1">登记单位</td>
      <td class="detailtd2"><span id="wpbjxxDetail_show_djdw"/></span></td>
      <td class="distd1">登记人员</td>
      <td class="detailtd2"><span id="wpbjxxDetail_show_djry"/></span></td>
      </tr>
      <tr>
      <td class="distd1">登记时间</td>
      <td class="detailtd2"  colspan="5"><span id="wpbjxxDetail_show_djsj"/></span></td>
    </tr>
  </table></td></tr>
</table>        </td>
    </tr>
  </table>
</div>
<table width="98%" border="0" cellspacing="0" cellpadding="2">
    <tr align="center">
	<td>
    <a href="#" id="printbutton" hidefocus="true" class="submitbutton"
				 title="打印" onclick='printpage(&quot;printDiv&quot;);'>打印</a>
	</td>
	</tr>
</table>
