<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
	String userName = "";
	String departName = "";
	String departCode = "";
	User user = (User)session.getAttribute(Constants.userKey);
	if(user!=null){
		userName = user.getUsername();
		departName = user.getDepartment().getDepartname();
		departCode = user.getDepartment().getDepartcode();
	}
%>
<script type="text/javascript">
	var newTableWidth = 990;
	$(document).ready(function(){
		$("#x_barq").attr("readonly","true");
		$("#x_barq").datepicker();
		$("#tjclxx").empty();
		$("#tjclxx").load("basic/publicsystem/BaxxtjclMan-gn.jsp"); //提交材料信息
		ylcsjbxx_setDetail();
		
	});
	function CompleteEnd(){
		var date = new Date();
		var newTime = date.getYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		$("#grid_baxxtjTable").find("input[@id^='tjrq']").attr("value",newTime).attr("readonly","true").datepicker().end();
	}

	function csbaxx_add(){
		if (csbaxx_addVerify()){
			csbaxx_setAdd();
		}
	}
	function csbaxx_addVerify(){
		var isCanPlay = 1;
		if (!checkControlValue("x_barq","Date",null,null,null,1,"备案日期"))
			return false;
		if (!checkControlValue("x_babmmc","String",1,200,null,1,"备案机构"))
			return false;
		$("#grid_baxxtjTable").find("input[type='checkbox']").each(function(){
			if($(this).attr("checked")==true){
				var thisid = $(this).attr("id").replace('sftj_','');
				if (!checkControlValue("tjr_"+thisid,"String",1,200,null,1,"提交人"))
					isCanPlay = 0;
				if (!checkControlValue("tjrq_"+thisid,"Date",null,null,null,1,"提交日期"))
					isCanPlay = 0;
			}
		});
		if(isCanPlay == 0){
			return false;
		}
		$("#grid_baxxtjTable").find("input[type='checkbox']").each(function(){
			if($(this).attr("checked")==true){
				var lxmc = $(this).attr("name");
				var thisid = $(this).attr("id").replace('sftj_','');
				var tjrval = $("#tjr_"+thisid).attr("value");
				var tjrqval = $("#tjrq_"+thisid).attr("value");
				
				$("#x_tjcllx").attr("value",$("#x_tjcllx").attr("value")+lxmc+"|");
				$("#x_tjcllxdm").attr("value",$("#x_tjcllxdm").attr("value")+thisid+"|");
				$("#x_tjrxm").attr("value",$("#x_tjrxm").attr("value")+tjrval+"|");
				$("#x_pageSort").attr("value",$("#x_pageSort").attr("value")+tjrqval+"|"); //提交日期
			}
		});
		
		if($("#sftjwz").attr("checked")==true){
			$("#x_sftjwz").attr("value","1");
		}else{
			$("#x_sftjwz").attr("value","0");
		}
		return true;
	}
</script>
<input type="hidden" id="q_qyid" value="">
<input type="hidden" id="x_qyid" value="">
<input type="hidden" id="x_qybm" value="">
<input type="hidden" id="x_tjcllxdm" value="">
<input type="hidden" id="x_tjcllx" value="">
<input type="hidden" id="x_tjrxm" value="">
<input type="hidden" id="x_pageSort" value="">
<input type="hidden" id="tjclqyjbxx" value="290">
<input type="hidden" id="x_babmbm" value="<%=departCode %>">
<input type="hidden" id="x_sftjwz" value="">

<input type="hidden" id="qybaxxtoqyjbadd" value="1">

<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
	<tr>
	  <td class="queryfont">备案信息</td>
	</tr>
	<tr><td class="tdbg">
		<table width="100%" border="0" cellspacing="0" cellpadding="3">
		      <tr>
		        <td width="8%" class="pagedistd1">备案编号</td>
		        <td width="17%" class="pagetd1"><input type="text" readonly class="readonly"/></td>
		        <td class="red" width="8%">备案日期</td>
		        <td class="pagetd1" width="17%"><input id="x_barq" type="text" class="inputstyle"/></td>
		        <td width="8%"class="pagedistd1">备案机构</td>
		        <td class="pagetd1" width="17%"><input type="text" id="x_babmmc" value="<%=departName %>" readonly class="readonly"/></td>
		        <td class="pagedistd1" width="8%">备案人</td>
		        <td class="pagetd1" width="17%"><input value="<%=userName %>" id="x_bar" type="text" readonly class="readonly"/></td>
	          </tr>
                    <tr>
		        <td colspan="8" class="pagetd1">
		        <div style="width:100%; height:390;" id=tjclxx></div>
		        </td>
              </tr>
                    <tr>
		      <td class="pagedistd1">
		          <input type="checkbox" name="checkbox" id="sftjwz"/></td>
	            <td colspan="3" class="pagetd1">备案信息提交完整</td>
              </tr>          
		</table>
	</td>
	</tr>
</table>
	