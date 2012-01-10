<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_userid").attr("value",dataid);
		if(isSjyh=='1'){ //非省级用户锁定
			yincangJz(); //隐藏警种字段 20100329 杨提出
		}
		setDetail();
	}); 
	function updatediv (json) { 
		$("#username").append(setNull(json.LUser[0].username));
		$("#useraccount").append(setNull(json.LUser[0].useraccount));
		$("#userorder").append(''+setNull(json.LUser[0].userorder));
		$("#isvalidValue").append(setNull(json.LUser[0].isvalidValue));
		$("#usertypename").append(setNull(json.LUser[0].usertypename));
		$("#idnum").append(setNull(json.LUser[0].idnum));
		$("#mobilephone").append(setNull(json.LUser[0].mobilephone));
		
		var jz = setNull(json.LUser[0].jzlbmc);
		if(jz==""){
			jz='无警种';
		}
		$("#jzlbmc").append(jz);
	}
	function yincangJz(){ //隐藏警种字段 20100329 杨提出
		$("#jz_tr").hide();
	}
</script>
<input type="hidden" id="q_userid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">用户详细信息</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#user_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>

<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1" width="30%">姓名</td>
		<td class="detailtd2" width="70%"><span id="username"></span></td>
	</tr>
	<tr height="20">
	  <td class="distd1">用户名</td>
	  <td class="detailtd2"><span id="useraccount"></span></td>
	</tr>
	<tr height="20">
	  <td class="distd1">公民身份号码</td>
	  <td class="detailtd2"><span id="idnum"></span></td>
	</tr>
	<tr height="20">
	  <td class="distd1">电话</td>
	  <td class="detailtd2"><span id="mobilephone"></span></td>
	</tr>
	<tr height="20">
	  <td class="distd1">排列顺序</td>
	  <td class="detailtd2"><span id="userorder"></span></td>
	</tr>
	<tr height="20">
	  <td class="distd1">是否有效</td>
	 <td class="detailtd2"><span id="isvalidValue"></span></td>
	</tr>
	<tr height="20" id="jz_tr">
	  <td class="distd1">警种类别</td>
	 <td class="detailtd2"><span id="jzlbmc"></span></td>
	</tr>
	<tr height="20">
	  <td class="distd1">用户类别</td>
	 <td class="detailtd2"><span id="usertypename"></span></td>
	</tr>
</table>