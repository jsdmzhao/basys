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
    bc_bottonMoveRight(1); //将保存按钮右移
	// 读取报警信息数据
	setParams("m_");
	jQuery.post("basicsystem/query_wpbjxxb.action",params,wpbjxxDetaildiv,"json"); // 提交到WpbjxxbAction中,调用其中的query方法
	$("#m_sfyxbjdm").selectBox({code:"dm_bez"}); // 是否有效选择框
	$("#m_wxyydm").selectBox({code:"dm_wxyy"}); // 无效原因选择框
	
	$("#m_cjbm").attr("readonly","true");
	$("#m_cjbm").click(function(){//getGxdwTree("m_cjbm","m_cjbmbm","0");
			getGxdwTree("m_cjbm","m_cjbmbm",null,null,null,null,null,null);});
	
	$("#m_sfyxbjdm").change(function(){ // 是否有效为“是”时，清空无效原因，为“否”时，清空处警部门
			$("#m_cjbm").unbind("click");
		if($("#m_sfyxbjdm").attr("value")==1){ // 有效
			$("#m_cjbm").click(function(){//getGxdwTree("m_cjbm","m_cjbmbm","0");
			getGxdwTree("m_cjbm","m_cjbmbm",null,null,null,null,null,null);});
			
			$("#m_sfyxbj").attr("value","是"); // 是否有效标记设为“是”
			
			$("#m_wxyydm").setValue("");
			$("#m_wxyy").attr("value","");
			
			$("#m_wxyydm").setAttr("readonly",true);
			//$("#m_cjbm").attr("readonly","false");
		}else{ // 无效		
			
			$("#m_sfyxbj").attr("value","否"); // 是否有效标记设为“否”
			
			$("#m_cjbmbm").attr("value","");
			$("#m_cjbm").attr("value","");
			
			//$("#m_cjbm").attr("readonly","true");
			$("#m_wxyydm").setAttr("readonly",false);
			$("#m_wxyydm").setAttr("readonly",false);
		}
	});
	// 从Session中获取登录用户相关信息
	$("#m_pjbmmc").val("<%=user.getDepartment().getDepartname()%>");
	$("#m_pjbmbm").val("<%=user.getDepartment().getDepartcode()%>");
	$("#m_pjr").val("<%=user.getUsername()%>");

	});
	function wpbjxxDetaildiv(json){
		$("#wpbjxxbDetail_ywbzj").val(setNull(json.LWpbjxxb[0].ywbzj));
	    $("#wpbjxxbDetail_hylbdm").val(setNull(json.LWpbjxxb[0].hylbdm));
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

	function modifyVerify(){
	if (!checkControlValue("m_sfyxbjdm","Select",1,100,null,1,"警情是否有效")){
		return false;
	} else {
		if($("#m_sfyxbjdm").attr("value")=="1"){ // 有效
			if (!checkControlValue("m_cjbm","String",1,100,null,1,"此报警处警单位"))
				return false;
		}else{
			if (!checkControlValue("m_wxyydm","Select",1,100,null,1,"无效原因"))
				return false;
		}
		$("#m_sfyxbj").val($("#m_sfyxbjdm").attr("title"));
		$("#m_wxyy").val($("#m_wxyydm").attr("title"));
	}
	return true;
}

function xbjUpdate(){
	if (modifyVerify()){
		if($("#m_sfyxbjdm").attr("value")==1){
			$("#m_jqzt").attr("value","未回复报警");
			$("#m_jqztdm").attr("value","1");
			// 管辖单位等于处警部门
			$("#m_gxdwbm").attr("value",$("#m_cjbmbm").attr("value"));
			$("#m_gxdwmc").attr("value",$("#m_cjbm").attr("value"));
		}else{
			$("#m_jqzt").attr("value","");
			$("#m_jqztdm").attr("value","");
		}
		
		setParams("m_");
		jQuery.post("basicsystem/xbjUpdate_wpbjxxb.action",params,xbjupdateback,"json"); 
	}else{
		return modifyVerify();
	}		
}

  function xbjupdateback(json){
	if  (json.result=="success"){
		jAlert("操作成功",'保存信息');
		setPageList($("#pageNo").attr("value"));
		$("#"+detailid).hideAndRemove("slow"); 
	}else{
		jAlert(json.result,'错误信息');
	}		
  }
</script>
<input type="hidden" id="wpbjxxbDetail_ywbzj">
<input type="hidden" id="wpbjxxbDetail_hylbdm">

<input type="hidden" id="m_jqzt"/>
<input type="hidden" id="m_jqztdm"/>
<input type="hidden" id="m_pjbmmc"/>
<input type="hidden" id="m_pjbmbm"/>
<input type="hidden" id="m_pjr"/>
<input type="hidden" id="m_gxdwbm" value=""/>
<input type="hidden" id="m_gxdwmc" value=""/>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			新报警
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
		<td class="detailtd2">
			<input type="hidden" id="m_sfyxbj" />
			<select type="select" id="m_sfyxbjdm">
				<option></option>
			</select>		</td>
		<td width="7%" class="distd1">无效原因</td>
		<td class="detailtd2">
			<input type="hidden" id="m_wxyy" />
			<select type="select" id="m_wxyydm">
				<option></option>
			</select>		</td>
		<td width="9%" class="distd1">此警情出警单位</td>
		<td class="detailtd2">
			<input type="hidden" id="m_cjbmbm" />
			<input type="text" class="inputstyle"  id="m_cjbm" value="" /></td>
  </tr>
</table>
			</td>
			</tr>
		</table>
<table width="100%" border="0" cellspacing="0" cellpadding="2">
<tr align="center">
	  <td><a href="#" id="addbutton2" hidefocus="true" class="submitbutton"
				title="保存" onclick='xbjUpdate();'>保存</a></td>
  </tr>
</table>