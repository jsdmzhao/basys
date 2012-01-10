<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants"%>
<%
	User user = (User) session.getAttribute(Constants.userKey);
%>
<script type="text/javascript">

   var ywbm = "";   //////报警信息 业务表名

	$(document).ready(function() {

		// 读取无效信息
		setParams("m_");
		jQuery.post("basicsystem/wxbj_bjxxb.action",params,wxbjdiv,"json"); // 提交到BjxxbAction中,调用其中的queryCjhf方法
	});
	
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
	//alert(hylbdm);
	// 读取国内旅客历史信息或从业人员历史信息
	$("#div_ywxx").empty();
	if(hylbdm=="A"){
		$("#div_ywxx").load("business/Lgyzagl/Gnlk_lsxxDetail.jsp");
	}else if(hylbdm=="J"){
		$("#div_ywxx").load("business/Ylfwzagl/Cyryxx_lsxxDetailKz.jsp");
		
	}else if(hylbdm=="E03"){
	      
	      if(ywbm=="t_ddkhxx"){ //典当业客户信息
	        $("#div_ywxx").load("business/Ddhyzagl/DdkhlsxxDetail.jsp");
	      }else if(ywbm=="t_ddcyryxx"){  ///典当业从业人员信息
	      
	         $("#div_ywxx").load("business/Ddhyzagl/DdcyrylsxxDetail.jsp");
	      }
	}else if(hylbdm=="C"){
	    if(ywbm=="t_jxcljbxx"){ //机修送/取车人信息
	        $("#div_ywxx").load("business/jxyzagl/JxclkhxxDetail.jsp");
	      }else if(ywbm=="t_jxcyryxx"){  ///机修从业人员信息
	         $("#div_ywxx").load("business/jxyzagl/JxcyrylsxxDetail.jsp");
	      }
	}else if(hylbdm=="B"){  //印章业
	     if(ywbm=="t_yzzzcyrxx"){ // 印章业  参与人员报警
	     
	         $("#div_ywxx").load("business/yzyzagl/YzzzcyrxxDetail.jsp");
	      }else if(ywbm=="t_yzzzdwcyryxx"){  ///印章业  从业人员报警
	      
	         $("#div_ywxx").load("business/yzyzagl/YzzzdwcyrylsxxDetail.jsp");
	      }
	}else if(hylbdm=="E01"){
	    if(ywbm=="t_escjyxx"){ //二手车交易信息
	       $("#div_ywxx").load("business/esczagl/EscjyxxDetail.jsp",function(){$("#tablehead").hide();});
	    }else if(ywbm=="t_qyryxx"){  //二手车从业人员信息
	       $("#div_ywxx").load("basic/publicsystem/Qyryxx_lsxxDetail.jsp");
	    }else if(ywbm=="t_cljbxx"){  //二手车车主信息
	       $("#div_ywxx").load("basic/publicsystem/CzjbxxDetail.jsp");
	    }
	}else if(hylbdm=="E02"){
	    if(ywbm=="t_esjtwryxx"){ //二手机摊位人员信息
	       $("#div_ywxx").load("business/esjzagl/EsjtwrylsxxDetail.jsp",function(){$("#tablehead").hide();});
	    }else if(ywbm=="t_qyryxx"){  //二手机从业人员信息
	       $("#div_ywxx").load("basic/publicsystem/Qyryxx_lsxxDetail.jsp");
	    }else if(ywbm=="t_esjjy"){  //二手机交易信息
	       $("#div_ywxx").load("business/esjzagl/EsjjyDetail.jsp",function(){$("#tablehead").hide();});
	    }else if(ywbm=="t_tyzlxx"){  //二手机摊主信息
	       $("#div_ywxx").load("business/esjzagl/TwzllsxxDetail.jsp");
	    }
	}else if(hylbdm=="Z"){ //出租房屋类型
		$("#div_ywxx").load("business/czfwzagl/Chengzuren_lsxxDetail.jsp");
		
	}else if(hylbdm=="F01"){ //出租汽车
	   if(ywbm=="t_czcjsyxx"){ //出租车驾驶员
		 $("#div_ywxx").load("business/czczagl/CzcjsyxxDetail.jsp", function(){
		 $("#czcJsytableHead").find("td:first").removeClass("title1").addClass("queryfont");
		 $("#czcJsytableHead").find("td:last").remove();
		 });
	   }else if(ywbm=="t_qyryxx"){ //从业人员
	     $("#div_ywxx").load("basic/publicsystem/Qyryxx_lsxxDetail.jsp");
	   }
	}else if(hylbdm=="F02"){ //汽车租赁
	      if(ywbm=="t_qyryxx"){  //从业人员
			$("#div_ywxx").load("basic/publicsystem/Qyryxx_lsxxDetail.jsp");
		  }else if(ywbm=="t_cljbxx"){  //车主信息
			$("#div_ywxx").load("business/qczlzagl/QczlcljbxxDetail.jsp",  function(){
			  $("#qczlkhxx").find("td:first").removeClass("title1").addClass("queryfont");
			 $("#qczlkhxx").find("td:last").remove();
			});
		  }else if(ywbm=="t_qczlkhxxb"){  //客户信息
			$("#div_ywxx").load("business/qczlzagl/QczlkhxxbDetail.jsp", function(){
			  $("#qczlkhxx").find("td:first").removeClass("title1").addClass("queryfont");
			 $("#qczlkhxx").find("td:last").remove();
		    });
	      }
	 }else if(hylbdm=="E04"){ //废旧金属
		 if(ywbm=="t_qyryxx"){  //从业人员
	  
			$("#div_ywxx").load("basic/publicsystem/Qyryxx_lsxxDetail.jsp");
			
		  }else if(ywbm=="t_fjjssgxx"){ ///出卖人员
		     $("#div_ywxx").load("business/fjjssgyzagl/FjjssgxxDetail_lsxx.jsp");
		  }
	 }
	
	
	$("#div_ywxx").show("slow");
}

function modifyVerify(){
	$("#m_sfyxbj").val($("#m_sfyxbjdm").attr("title"));
	$("#m_wxyy").val($("#m_wxyydm").attr("title"));
	return true;
}

function wxbjdiv (json) {

	$("#bjxxDetail_ywbzj").val(setNull(json.LBjxxb[0].ywbzj));
	
	// 可以修改的初始值
	$("#sfyxbj").val(setNull(json.LBjxxb[0].sfyxbj));
	$("#wxyy").val(setNull(json.LBjxxb[0].wxyy));
	$("#wxyy").val(setNull(json.LBjxxb[0].wxyy));
	$("#bjxxDetail_hylbdm").val(setNull(json.LBjxxb[0].hylbdm));
	
	$("#sfyxbj").attr("readonly","true");
	$("#wxyy").attr("readonly","true");
	
	ywbm = setNull(json.LBjxxb[0].ywbm);   ///////业务表名
	
	showOtherJsp();
}
	
</script>
<input type="hidden" id="bjxxDetail_ywbzj">
<input type="hidden" id="bjxxDetail_hylbdm">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
<tr>
		<td align="left" class="title1">
			无效报警详细信息
		</td>
		<td align="right"class="title1">
			<a href="#" id="closeDiv" onclick='$("#bjxxb_detail").hideAndRemove("show");'class="close"></a>
		</td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="3"></td>
  </tr>
</table>
<div  class="scrollbarface" style="overflow-y:auto;overflow-x:hidden;height:400">
<table width="98%" border="0"  cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="6">
			<div style="width: 100%" id="div_bdxx"></div>
		</td>
	</tr>
	<tr>
		<td colspan="6">
			<div style="width: 100%" id="div_ywxx"></div>
		</td>
	</tr>
</table>
</div>
<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td colspan="6" class="queryfont"> 警情派警
      </td>
  </tr>
  <tr>
    <td><table width="100%" cellpadding="4" cellspacing="0" class="detail" id="detail">
      <tr>
        <td width="8%" class="distd1"> 警情是否有效 </td>
        <td width="24%" class="detailtd2"><input type="text" class="inputstyle"  id="sfyxbj" />
        </td>
        <td width="6%" class="distd1"> 无效原因 </td>
        <td width="62%" class="detailtd2"><input type="text" class="inputstyle"  id="wxyy" style="width:160px;"/></td>
      </tr>
    </table></td>
  </tr>
</table>
