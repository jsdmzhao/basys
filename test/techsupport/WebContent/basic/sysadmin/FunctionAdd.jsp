<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	var canCommit=false;
	$(document).ready(function() {
		bc_bottonMoveRight(21); //按钮右对齐
		$("#a_systemcode").attr("value",dataid);
	}); 
	function addVerify(){
		if (!checkControlValue("a_funccode","String",1,50,null,1,"功能代码"))
			return false;
		if (!checkControlValue("a_funcname","String",1,100,null,1,"功能名称"))
			return false;
		if (!checkControlValue("a_funcdefine","String",1,200,null,0,"功能链接"))
			return false;
		if (!checkControlValue("a_functype","Integer",0,9,null,0,"功能类别"))
			return false;
		valadateCode();
		if(!canCommit)
			return false;
		return true;
	}
	function valadateCode(){ //验证代码
		setParams("a_");
		var sUrl="sysadmin/validateFunction_function.action";
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
				jAlert('此功能代码已存在!','验证信息');
				canCommit=false;
			}else{
				canCommit=true;
			}
		}else{
			canCommit=false;
		}
	}
</script>
<input type="hidden" id="a_systemcode" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">功能添加</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#function_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>

<table width="100%" id="add">
	<tr height="20">
		<td class="distd" width="15%">功能名称</td>
		<td class="detailtd" width="30%"><input type="text" class="inputstyle"  id="a_funcname" value="" /></td>
		<td class="distd" width="15%">功能代码</td>
		<td class="detailtd" width="35%"><input type="text" class="inputstyle"  id="a_funccode" value="" onblur="valadateCode();"/></td>
	</tr>
	<tr height="20">
		<td class="distd">功能类别</td>
		<td class="detailtd" colspan="3">
		<select id="a_functype">
		  <option value='1'>类别1</option>
		  <option value='2'>类别2</option>
		  <option value='3'>类别3</option>
		  <option value='4'>类别4</option>
		  <option value='5'>类别5</option>
		  <option value='6'>类别6</option>
		  <option value='7'>类别7</option>
		  <option value='8'>类别8</option>
		  <option value='9'>类别9</option>
		  <option value='10'>类别10</option>
		  </select></td>
	</tr>
	<tr height="20">
		<td class="distd">功能链接</td>
		<td class="detailtd" colspan="3"><input type="text" class="inputstyle"  id="a_funcdefine" value="" style="width:390;"/></td>
	</tr>
	<tr height="25" align="center"><td colspan="4">
	<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setAdd();'>保存</a>
	</td></tr>
</table>
