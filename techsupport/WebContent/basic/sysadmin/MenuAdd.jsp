<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	var canCommit=false;
	$(document).ready(function() {
		bc_bottonMoveRight(13); //按钮右对齐
		$("#a_parentmenucode").attr("value",dataid);
		$("#a_systemcode").attr("value",$("#p_systemcode").attr("value"));
		var nmenuname = $("#n_menuname").attr("value");
		if(nmenuname==null||nmenuname==''){
			$("#aparentmenuname").attr("value",'顶级');
		}else {
			$("#aparentmenuname").attr("value",nmenuname);
		}
		$("#cdlb").selectBox({code:"dm_cdlb"});
		cdlbOnchange();
		queryNextOrder();
	}); 
	function queryNextOrder(){ //获取兄弟节点最大排序号
		setParams("a_");
		var nextOrderUrl="sysadmin/nextNodeorder_menu.action";
		jQuery.ajax({
			type: 'POST',
			url: nextOrderUrl,
			data: params,
			async: false,
			dataType: 'json',
			success: function(result){						
				var rows  = eval(result);
				nextOrderInfo(rows);
			}
		});
	}
	function nextOrderInfo(json){ //获取兄弟节点最大排序号
		$("#a_nodeorder").attr("value",json.strResult);
	}
	function addVerify(){
		if (!checkControlValue("a_menuname","String",1,50,null,1,"菜单名称"))
			return false;
        if (!checkControlValue("a_parentmenucode","String",1,40,null,0,"上级菜单"))
			return false;
		if (!checkControlValue("a_menucode","String",1,40,null,1,"菜单代码"))
			return false;
		if (!checkControlValue("a_menufullcode","String",1,400,null,0,"菜单全路径代码"))
			return false;
		if (!checkControlValue("a_nodeorder","Integer",-999999999,999999999,null,1,"排列顺序"))
			return false;
		if (!checkControlValue("a_funcentry","String",1,500,null,1,"菜单连接"))
			return false;
		valadateCode();
		if(!canCommit)
			return false;
		return true;
	}
	function valadateCode(){ //验证代码
		var menucode = $("#a_menucode").attr("value");
		if(menucode=='0'){
			canCommit=false;
			jAlert('请正确输入菜单代码!','验证信息');
			return;
		}
		setParams("a_");
		var sUrl="sysadmin/validateMenu_menu.action";
		jQuery.ajax({
			type: 'POST',
			url: sUrl,
			data: params,
			async: false,
			dataType: 'json',
			success: function(result){						
				var rows  = eval(result);
				valadateCodeBack(rows);
			}
		});
	}
	function valadateCodeBack(json){
		if(json.result=="success"){
			if(json.strResult=="1"){
				jAlert('此菜单代码已存在!','验证信息');
				canCommit=false;
			}else{
				canCommit=true;
			}
		}else{
			canCommit=false;
		}
	}
	function addback(json){
		if  (json.result=="success"){
			jAlert(addMessage,'提示信息');
			queryNextOrder();
			setPageList($("#pageNo").attr("value"));
			
			$("#a_menuname").attr("value","");
			$("#a_menucode").attr("value","");
			$("#a_funcentry").attr("value","");
			
			var parCode = $("#a_parentmenucode").attr("value");
			if(parCode=='0'){
				saveOnClick('sysfalg'+$("#a_systemcode").attr("value")); //刷系统新树
			} else {
				saveOnClick($("#a_parentmenucode").attr("value")); //刷菜单新树
			}
		}else{
			jAlert(json.result,'错误信息');
		}		
	}
	
	
	function cdlbOnchange(){
		var a_menuTypeCode = $("#cdlb").attr("value");
		var a_menuTypeName = $("#cdlb").attr("title");
		$("#a_menuTypeCode").attr("value",a_menuTypeCode);
		$("#a_menuTypeName").attr("value",a_menuTypeName);
		
	}
</script>
<input type="hidden" id="a_systemcode">
<input type="hidden" id="a_parentmenucode">
<input type="hidden" id="a_menuTypeCode">
<input type="hidden" id="a_menuTypeName">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">菜单添加</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#menu_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>

<table width="100%" id="add">
	<tr height="20">
		<td class="distd" width="15%">菜单名称</td>
		<td class="detailtd" width="30%"><input type="text" class="inputstyle"  id="a_menuname" value="" /></td>
		<td class="distd" width="20%">菜单代码</td>
		<td class="detailtd" width="35%"><input type="text" class="inputstyle"  id="a_menucode" value="" onblur="valadateCode();"/></td>
	</tr>
	<tr height="20">
		<td class="distd">排列顺序</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_nodeorder" value="0" /></td>
		 <td class="distd">菜单类别</td>
	     <td class="detailtd"><select id="cdlb" onchange="cdlbOnchange();"></select></td>
	</tr>
	
	<tr height="20">
	  <td class="distd">菜单连接</td>
	  <td class="detailtd"  colspan="3"><input type="text" class="inputstyle"  style="width:405;"  id="a_funcentry" value="" /></td>
	</tr>
	<tr height="20">
	    <td class="distd">全路径代码</td>
		<td class="detailtd"  colspan="3"><input type="text"id="a_menufullcode" readonly   class="readonly" style="width:405;"   value=""></td>
	</tr>
	<tr height="20">
	  <td class="distd">上级菜单</td>
	  <td class="detailtd" colspan="3"><input type="text"  id="aparentmenuname" readonly   class="readonlytext" style="width:405;" value="" /></td>
	</tr>
	<tr height="25" align="center"><td colspan="4">
	<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setAdd();'>保存</a>
	</td></tr>
</table>