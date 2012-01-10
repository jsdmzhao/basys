<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.common.DateUtil"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants"%>
<%@include file="../../public/common.jsp" %>
<%
User user = new User();
String userName = null;
//获得登录用户session
user = (User) session.getAttribute(Constants.userKey);
if (user == null)
	response.sendRedirect("login.jsp");
else
	userName = user.getUsername(); 
String lrsj = DateUtil.getDateTime();
%>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(4); 
	    $("#a_balxbm").selectBox({code:"dm_balx"});
		$("#a_sgrq").attr("readonly","true");
		$("#a_sgrq").datepicker();
	}); 
	$("#a_gmsfhm").blur(function(){
	    var sfzh = $("#a_gmsfhm").val();
	    if(sfzh==''){
	        return true;
	    }
		var returnCardNo = checkIdCardNo("a_gmsfhm");
		if(!returnCardNo){
			jAlert("身份证号码不正确","验证信息");
		}
		getHjsxDD($(this).val(),"dm_xzqh","a_hjdxzqhdm","a_hjdxzqh")
	});
	$("#a_hjdxzqh").click(function(){
		getDict_item("a_hjdxzqh","a_hjdxzqhdm","dm_xzqh");
	});
	$("#a_balxbm").change(function(){
		$("#a_balx").val($("#a_balxbm").attr("title"));
	});
	function bary_addVerify(){
		if (!checkControlValue("a_xm","String",1,100,null,1,"姓名"))
			return false;
		if(!isChinese("a_xm","姓名"))
			return false;
		if (!checkControlValue("a_gmsfhm","String",1,20,null,1,"身份证号"))
			return false;
		if(!bary_valCyryZjhmFront($("#a_gmsfhm").val(),null))
			return false;
		if (!checkControlValue("a_hjdxzqh","String",1,200,null,1,"户籍地省市县"))
			return false;
		if (!checkControlValue("a_hjdxz","String",1,200,null,1,"户籍地详址"))
			return false;
		if (!checkControlValue("a_sgrq","Date",null,null,null,1,"上岗日期"))
			return false;
		if (!checkControlValue("a_balx","String",1,10,null,1,"保安类型"))
			return false;
		if (!checkControlValue("a_fzjg","String",1,60,null,1,"发证机构"))
			return false;
		if (!checkControlValue("a_bz","String",1,2000,null,0,"备注"))
			return false;
		var returnCardNo = checkIdCardNo("a_gmsfhm");
		if(returnCardNo){
			$("#a_zt").val(0);
		}else{
			$("#a_zt").val(1);
		}
		return true;
	}
</script>
<input type="hidden" id="a_hjdxzqhdm"/>
<input type="hidden" id="a_balx"/>
<input type="hidden" id="a_zt"/>
<input type="hidden" id="b_sfzhm_fd"/>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">保安人员信息添加</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#baryxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="red" width="12%">姓名</td>
		<td class="pagetd1" width="21%"><input type="text" id="a_xm" class="inputstyle" value=""></td>
		<td class="red" width="11%">身份证号</td>
		<td class="pagetd1" width="22%"><input type="text" id="a_gmsfhm" class="inputstyle" value=""></td>
		<td class="red" width="13%">户籍地省市县</td>
		<td class="pagetd1" width="21%"><input type="text" id="a_hjdxzqh" class="inputstyle" readonly></td>
	</tr>
	<tr height="20">
		<td class="red">户籍地详址</td>
		<td class="pagetd1" colspan="3"><input type="text" id="a_hjdxz" class="inputstyle3" style="width:98.7%" value=""></td>
		<td class="red">上岗日期</td>
		<td class="pagetd1"><input type="text" id="a_sgrq" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="red">保安类型</td>
		<td class="pagetd1"><select id="a_balxbm"><option></option></select></td>
		<td class="red">发证机构</td>
		<td class="pagetd1"><input type="text" id="a_fzjg" class="inputstyle" value=""></td>
	</tr>
	<tr height="20" style="display:none">
		<td class="pagedistd1">填报人</td>
		<td class="pagetd1"><input type="text" id="a_lrr" class="readonly" value="<%=userName %>" /></td>
		<td class="pagedistd1">填报时间</td>
		<td class="pagetd1" colspan="3"><input type="text" id="a_lrsj" class="readonly" value="<%=lrsj %>" /></td>
	</tr>
	<tr height="20">
		<td class="pagedistd1">备注</td>
		<td class="pagetd1" colspan="5"><textarea name="textarea" id="a_bz" cols="83" rows="2" style="width:98.7%" ></textarea></td>
	</tr>
<tr height="25" align="center"><td  colspan="6"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='bary_setAdd();'>保存</a></td></tr>
</table>