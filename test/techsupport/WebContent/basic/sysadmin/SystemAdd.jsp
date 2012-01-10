<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	var canCommit=false;
	$(document).ready(function() {
		bc_bottonMoveRight(13); //按钮右对齐
		$("#a_parentsystemcode").attr("value",dataid);
		var nsystemname = $("#n_systemname").attr("value");
		if(nsystemname==null||nsystemname==''){
			$("#aparentsystemName").attr("value",'顶级');
		}else {
			$("#aparentsystemName").attr("value",nsystemname);
		}
		queryNextOrder();
	});
	function queryNextOrder(){ //获取兄弟节点最大排序号
		setParams("a_");
		var nextOrderUrl="sysadmin/nextNodeorder_system.action";
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
		if (!checkControlValue("a_systemcode","String",1,20,null,1,"系统代码"))
			return false;
		if (!checkControlValue("a_systemname","String",1,50,null,1,"系统名称"))
			return false;
		if (!checkControlValue("a_systemdefine","String",1,200,null,0,"系统定义"))
			return false;
		if (!checkControlValue("a_picturepath","String",1,200,null,0,"图片路径"))
			return false;
		if (!checkControlValue("a_parentsystemcode","String",1,20,null,0,"上级系统"))
			return false;
		if (!checkControlValue("a_nodeorder","Integer",-999999999,999999999,null,1,"排列顺序"))
			return false;
		if (!checkControlValue("a_fullcode","String",1,50,null,0,"系统全路径代码"))
			return false;
		valadateCode();
		if(!canCommit)
			return false;
		return true;
	}
	function valadateCode(){ //验证代码
		var syscode = $("#a_systemcode").attr("value");
		if(syscode=='0'){
			canCommit=false;
			jAlert('请正确输入系统代码!','验证信息');
			return;
		}
		setParams("a_");
		var sUrl="sysadmin/validateSystem_system.action";
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
				jAlert('此系统代码已存在!','验证信息');
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
			$("#a_systemname").attr("value",""); //系统名称
			$("#a_systemcode").attr("value",""); //系统代码
			$("#a_systemdefine").attr("value",""); //系统定义
			$("#a_picturepath").attr("value",""); //图片路径
			setPageList($("#pageNo").attr("value"));
			saveOnClick($("#a_parentsystemcode").attr("value")); //刷新树
		}else{
			jAlert(json.result,'错误信息');
		}
	}
</script>
<input type="hidden" id="a_parentsystemcode">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">系统添加</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#system_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>

<table width="100%" id="add">
	<tr height="20">
		<td class="distd" width="15%">系统名称</td>
		<td class="detailtd" width="30%"><input type="text" class="inputstyle"  id="a_systemname" value=""/></td>
		<td class="distd" width="20%">系统代码</td>
		<td class="detailtd" width="35%"><input type="text" class="inputstyle"  id="a_systemcode" value="" onblur="valadateCode();"/></td>
	</tr>
	<tr height="20">
        <td class="distd">系统定义</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_systemdefine" value=""></td>
		<td class="distd">上级系统</td>
		<td class="detailtd"><input type="text" readonly   class="readonly" id="aparentsystemName" value=""></td>
	</tr>
	<tr height="20">
	  <td class="distd">排列顺序</td>
      <td class="detailtd"><input type="text" class="inputstyle"  id="a_nodeorder" value="0" /></td>
	  <td height="20" class="distd">系统全路径代码</td>
	  <td class="detailtd"><input readonly   class="readonly" type="text" id="a_fullcode" value="" /></td>
	</tr>
	<tr height="20">
		<td class="distd">图片路径</td>
		<td class="detailtd" colspan="3"><input type="text" class="inputstyle"  id="a_picturepath" value="" style="width:405;"/></td>
	</tr>
	<tr height="25" align="center"><td colspan="4">
	<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setAdd();'>保存</a>
	</td></tr>
</table>