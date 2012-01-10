<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		var date = new Date();
		var nowMonth = (date.getMonth()+1)+'';
		var nowDate = date.getDate()+'';
		if(nowMonth.length==1) nowMonth = '0'+nowMonth;
		if(nowDate.length==1)  nowDate = '0'+nowDate;
		var nowTime = date.getYear()+'-'+nowMonth+'-'+nowDate;
		$("#a_djrq").attr("value",nowTime);
	});
	
	$("#a_pp").attr("readonly","true").click(function(){ //品牌
		getDict_item("a_pp","","dm_sjpp");
	});
	$('#a_xzqh').attr("readonly","true").click(function(){ //行政区划
		getDict_item("a_xzqh","a_xzqhbm","dm_xzqh");
	});
	$('#a_ajlb').attr("readonly","true").click(function(){ //案件类别
		//getDict_item("a_ajlb","a_ajlbbm","dm_ajlb(gb)");
		getDict_item("a_ajlb","a_ajlbbm","dm_ajlx");
	});
	$('#a_ladq').attr("readonly","true").click(function(){ //立案地区
		getDict_item("a_ladq","a_ladqbm","dm_xzqh");
	});
	
	function addVerify(){
		if (!checkControlValue("a_sjch","String",1,30,null,1,"手机串号"))
			return false;
		exitSjch();
		if(!canCommit)
			return false;
		if (!checkControlValue("a_pp","String",1,100,null,1,"品牌"))
			return false;
		if (!checkControlValue("a_ys","String",1,60,null,0,"颜色"))
			return false;
		if (!checkControlValue("a_xh","String",1,100,null,0,"型号"))
			return false;
		if (!checkControlValue("a_tbr","String",1,100,null,1,"填表人"))
			return false;
		if (!checkControlValue("a_lxr","String",1,100,null,1,"联系人"))
			return false;
		if (!checkControlValue("a_lxrsfhm","String",1,20,null,1,"联系人身份号码"))
			return false;
		if (!checkControlValue("a_lxfs","String",1,300,null,1,"联系方式"))
			return false;
		if (!checkControlValue("a_jyaq","String",1,2000,null,1,"简要案情"))
			return false;
		return true;
	}
	
	function exitSjch(){
		var asjch = $("#a_sjch").attr("value");
		var sUrl="basicsystem/sjbdqxxExist_sjbdqxx.action";
		jQuery.ajax({
			type: 'POST',
			url: sUrl,
			data: {vsjch:asjch},
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
				jAlert('此手机串号已存在!','验证信息',null,'a_sjch');
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
<input type="hidden" id="a_xzqhbm">
<input type="hidden" id="a_ladqbm">
<input type="hidden" id="a_ajlbbm">
<input type="hidden" id="a_badwbm">
<input type="hidden" id="a_djrq">

<span id="closeFlag"></span>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">&nbsp;新增</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#closeFlag").parent().hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td width="18%" class="red">手机串号</td>
		<td width="35%" class="pagetd1"><input type="text" id="a_sjch" class="inputstyle"></td>
		<td width="15%" class="red">品牌</td>
		<td width="32%" class="pagetd1"><input type="text" id="a_pp" class="inputstyle"></td>
	</tr>
	<tr height="20">
		<td class="pagedistd1">颜色</td>
		<td class="pagetd1"><input type="text" id="a_ys" class="inputstyle"></td>
		<td class="pagedistd1">型号</td>
		<td class="pagetd1"><input type="text" id="a_xh" class="inputstyle"></td>
	</tr>
	<tr height="20">
		<td class="pagedistd1">行政区划</td>
		<td class="pagetd1"><input type="text" id="a_xzqh" class="inputstyle"></td>
		<td class="pagedistd1">立案地区</td>
		<td class="pagetd1"><input type="text" id="a_ladq" class="inputstyle"></td>
	</tr>
	<tr height="20">
		<td class="pagedistd1">案件类别</td>
		<td class="pagetd1"><input type="text" id="a_ajlb" class="inputstyle"></td>
		<td class="red">填表人</td>
		<td class="pagetd1"><input type="text" id="a_tbr" class="inputstyle"></td>
	</tr>
	<tr height="20">
		<td class="red">联系人</td>
		<td class="pagetd1"><input type="text" id="a_lxr" class="inputstyle"></td>
		<td class="red">联系人身份号码</td>
		<td class="pagetd1"><input type="text" id="a_lxrsfhm" class="inputstyle" onblur="valSfzCardIsRight('a_lxrsfhm','请正确填写联系人身份号码!','0');"></td>
	</tr>
	<tr height="20">
		<td class="red">联系方式</td>
		<td class="pagetd1" colspan="3"><input type="text" id="a_lxfs" class="inputstyle3" style="width:449px"></td>
	</tr>
	<tr height="20">
		<td class="red" valign="top">简要案情</td>
		<td class="pagetd1" colspan="3"><textarea id="a_jyaq" cols="54" rows="3"></textarea></td>
	</tr>
	<tr height="25" align="center">
		<td colspan="4">
		<a href="#" hidefocus="true" class="submitbutton" title="保存" onclick='setAdd();'>保存</a></td>
	</tr>
</table>