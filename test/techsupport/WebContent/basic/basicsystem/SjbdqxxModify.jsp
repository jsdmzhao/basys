<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_sjbdqxxid").attr("value",dataid);
		$("#m_sjbdqxxid").attr("value",dataid);
		setDetail();
		$("#m_djrq").attr("readonly","true");
		$("#m_djrq").datepicker();
	});
	
	$("#m_pp").attr("readonly","true").click(function(){ //品牌
		getDict_item("m_pp","","dm_sjpp");
	});
	$('#m_xzqh').attr("readonly","true").click(function(){ //行政区划
		getDict_item("m_xzqh","m_xzqhbm","dm_xzqh");
	});
	$('#m_ajlb').attr("readonly","true").click(function(){ //案件类别
		//getDict_item("m_ajlb","m_ajlbbm","dm_ajlb(gb)");
		getDict_item("m_ajlb","m_ajlbbm","dm_ajlx");
	});
	$('#m_ladq').attr("readonly","true").click(function(){ //立案地区
		getDict_item("m_ladq","m_ladqbm","dm_xzqh");
	});
	
	function updatediv (json) { 
		$("#m_sjbdqxxid").attr("value",setNull(json.LSjbdqxx[0].sjbdqxxid));
		$("#m_xzqhbm").attr("value",setNull(json.LSjbdqxx[0].xzqhbm));
		$("#m_xzqh").attr("value",setNull(json.LSjbdqxx[0].xzqh));
		$("#m_sjch").attr("value",setNull(json.LSjbdqxx[0].sjch));
		$("#m_pp").attr("value",setNull(json.LSjbdqxx[0].pp));
		$("#m_xh").attr("value",setNull(json.LSjbdqxx[0].xh));
		$("#m_ys").attr("value",setNull(json.LSjbdqxx[0].ys));
		$("#m_ajjbbm").attr("value",setNull(json.LSjbdqxx[0].ajjbbm));
		$("#m_ajjb").attr("value",setNull(json.LSjbdqxx[0].ajjb));
		$("#m_ajlbbm").attr("value",setNull(json.LSjbdqxx[0].ajlbbm));
		$("#m_ajlb").attr("value",setNull(json.LSjbdqxx[0].ajlb));
		$("#m_jyaq").attr("value",setNull(json.LSjbdqxx[0].jyaq));
		$("#m_djrq").attr("value",setNull(json.LSjbdqxx[0].djrq));
		$("#m_djr").attr("value",setNull(json.LSjbdqxx[0].djr));
		$("#m_ladqbm").attr("value",setNull(json.LSjbdqxx[0].ladqbm));
		$("#m_ladq").attr("value",setNull(json.LSjbdqxx[0].ladq));
		$("#m_badwbm").attr("value",setNull(json.LSjbdqxx[0].badwbm));
		$("#m_badw").attr("value",setNull(json.LSjbdqxx[0].badw));
		$("#m_tbr").attr("value",setNull(json.LSjbdqxx[0].tbr));
		$("#m_lxr").attr("value",setNull(json.LSjbdqxx[0].lxr));
		$("#m_lxfs").attr("value",setNull(json.LSjbdqxx[0].lxfs));
		$("#m_lxrsfhm").attr("value",setNull(json.LSjbdqxx[0].lxrsfhm));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_sjch","String",1,30,null,1,"手机串号"))
			return false;
		exitSjch();
		if(!canCommit)
			return false;
		if (!checkControlValue("m_pp","String",1,100,null,1,"品牌"))
			return false;
		if (!checkControlValue("m_ys","String",1,60,null,0,"颜色"))
			return false;
		if (!checkControlValue("m_xh","String",1,100,null,0,"型号"))
			return false;
		if (!checkControlValue("m_tbr","String",1,100,null,1,"填表人"))
			return false;
		if (!checkControlValue("m_lxr","String",1,100,null,1,"联系人"))
			return false;
		if (!checkControlValue("m_lxrsfhm","String",1,20,null,1,"联系人身份号码"))
			return false;
		if (!checkControlValue("m_lxfs","String",1,300,null,1,"联系方式"))
			return false;
		if (!checkControlValue("m_jyaq","String",1,2000,null,1,"简要案情"))
			return false;
		return true;
	}
	
	function exitSjch(){
		var msjbdqxxid = $("#m_sjbdqxxid").attr("value");
		var msjch = $("#m_sjch").attr("value");
		var sUrl="basicsystem/sjbdqxxExist_sjbdqxx.action";
		jQuery.ajax({
			type: 'POST',
			url: sUrl,
			data: {vsjch:msjch,vsjbdqxxid:msjbdqxxid},
			async: false,
			dataType: 'json',
			success: function(result){
				var rows  = eval(result);
				valSjchBack(rows);
			}
		});
	}
	function valSjchBack(json){
		if(json.result=="success"){
			if(json.exitResult=="1"){
				jAlert('此手机串号已存在!','验证信息',null,'m_sjch');
				canCommit=false;
			}else{
				canCommit=true;
			}
		}else{
			jAlert(json.result,'提示信息');
			canCommit=false;
		}
	}
	var canCommit = true;
</script>
<input type="hidden" id="q_sjbdqxxid">
<input type="hidden" id="m_sjbdqxxid">

<input type="hidden" id="m_xzqhbm">
<input type="hidden" id="m_ladqbm">
<input type="hidden" id="m_ajlbbm">
<input type="hidden" id="m_badwbm">

<span id="closeFlag"></span>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">&nbsp;修改</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#closeFlag").parent().hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td width="18%" class="red">手机串号</td>
		<td width="35%" class="pagetd1"><input type="text" id="m_sjch" class="inputstyle"></td>
		<td width="15%" class="red">品牌</td>
		<td width="32%" class="pagetd1"><input type="text" id="m_pp" class="inputstyle"></td>
	</tr>
	<tr height="20">
		<td class="pagedistd1">颜色</td>
		<td class="pagetd1"><input type="text" id="m_ys" class="inputstyle"></td>
		<td class="pagedistd1">型号</td>
		<td class="pagetd1"><input type="text" id="m_xh" class="inputstyle"></td>
	</tr>
	<tr height="20">
		<td class="pagedistd1">行政区划</td>
		<td class="pagetd1"><input type="text" id="m_xzqh" class="inputstyle"></td>
		<td class="pagedistd1">立案地区</td>
		<td class="pagetd1"><input type="text" id="m_ladq" class="inputstyle"></td>
	</tr>
	<tr height="20">
		<td class="pagedistd1">案件类别</td>
		<td class="pagetd1"><input type="text" id="m_ajlb" class="inputstyle"></td>
		<td class="red">填表人</td>
		<td class="pagetd1"><input type="text" id="m_tbr" class="inputstyle"></td>
	</tr>
	<tr height="20">
		<td class="red">联系人</td>
		<td class="pagetd1"><input type="text" id="m_lxr" class="inputstyle"></td>
		<td class="red">联系人身份号码</td>
		<td class="pagetd1"><input type="text" id="m_lxrsfhm" class="inputstyle" onblur="valSfzCardIsRight('m_lxrsfhm','请正确填写联系人身份号码!','0');"></td>
	</tr>
	<tr height="20">
		<td class="red">联系方式</td>
		<td class="pagetd1" colspan="3"><input type="text" id="m_lxfs" class="inputstyle3" style="width:449px"></td>
	</tr>
	<tr height="20">
		<td class="red" valign="top">简要案情</td>
		<td class="pagetd1" colspan="3"><textarea id="m_jyaq" cols="54" rows="3"></textarea></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
