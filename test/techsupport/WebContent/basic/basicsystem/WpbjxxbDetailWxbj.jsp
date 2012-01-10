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
	jQuery.post("basicsystem/query_wpbjxxb.action",params,wxbjDetaildiv,"json"); // 提交到WpbjxxbAction中,调用其中的query方法
	});
	function wxbjDetaildiv(json){
		$("#wpbjxxbDetail_ywbzj").val(setNull(json.LWpbjxxb[0].ywbzj));
	    $("#wpbjxxbDetail_hylbdm").val(setNull(json.LWpbjxxb[0].hylbdm));
	    $("#sfyxbj").val(setNull(json.LWpbjxxb[0].sfyxbj));
	    $("#wxyy").val(setNull(json.LWpbjxxb[0].wxyy));
	
	    $("#sfyxbj").attr("readonly","true");
	    $("#wxyy").attr("readonly","true");
	    showOtherJsp();
	}
	
	function showOtherJsp(){
	// 读取本地布控或者被盗抢车辆报警数据
	$("#div_bdxx").empty();
	$("#div_ywxx").empty();
	var bjlx = $("#current_recordBjlx").attr("value");
	dataid = $("#wpbjxxbDetail_ywbzj").attr("value");
	var hylbdm = $("#wpbjxxbDetail_hylbdm").attr("value");
	if(bjlx=="6"){// 被盗抢车辆报警
		$("#div_bdxx").load("basic/basicsystem/WpbjxxbDetailBdqclxx.jsp");
		if(hylbdm=="E03"){// 典当
		    $("#div_ywxx").load("basic/basicsystem/WpbjxxywBdqcl.jsp");
		}else if(hylbdm=="C"){// 机修
		    $("#div_ywxx").load("business/jxyzagl/JxclbjywDetail.jsp");
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
		    $("#div_ywxx").load("business/jxyzagl/JxclbjywDetail.jsp");
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
</script>
<input type="hidden" id="wpbjxxbDetail_ywbzj">
<input type="hidden" id="wpbjxxbDetail_hylbdm">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			无效报警详细信息
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv" onclick='divclear($("#wpbjxxb_detail"));'class="close"></a>
		</td>
	</tr>
</table>
<table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="3"></td>
  </tr>
</table>
<div id="printDiv" class="scrollbarface" style="overflow-y:auto;overflow-x:hidden;height:400">
<table width="98%" border="0" cellspacing="0" cellpadding="0">
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
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr><td class="queryfont">派警信息</td>
			</tr>
			<tr><td  class="tdbg">
<table width="100%" id="add">
	<tr height="20">
		<td width="8%" class="distd1">警情是否有效</td>
		<td class="detailtd2"><input type="text" class="inputstyle"  id="sfyxbj" /></td>
		<td width="7%" class="distd1">无效原因</td>
		<td class="detailtd2"><input type="text" class="inputstyle"  id="wxyy" style="width:160px;"/></td>
  </tr>
</table>
			</td>
			</tr>
		</table>