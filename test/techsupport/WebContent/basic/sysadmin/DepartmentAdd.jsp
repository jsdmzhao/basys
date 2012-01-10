<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	var canCommit=false;
	$(document).ready(function() {
		bc_bottonMoveRight(2); //按钮右对齐
		$("#a_parentdepartid").attr("value",dataid);
		var ndepartname = $("#n_departname").attr("value");
		if(ndepartname==null||ndepartname==''){
			$("#ndepartname").attr("value",'顶级');
		}else {
			$("#ndepartname").attr("value",ndepartname);
		}
		
		queryNextOrder();
	}); 
	function queryNextOrder(){ //获取兄弟节点最大排序号
		setParams("a_");
		var nextOrderUrl="sysadmin/nextNodeorder_department.action";
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
	function nextOrderInfo(json){ //获取兄弟节点最大排序号-回调函数
		$("#a_nodeorder").attr("value",json.strResult);
	}
	function addVerify(){
		if (!checkControlValue("a_departcode","String",1,20,null,1,"机构代码"))
			return false;
		if (!checkControlValue("a_departname","String",1,50,null,1,"机构名称"))
			return false;
		if (!checkControlValue("a_parentdepartid","Integer",-999999999,999999999,null,0,"父机构ID"))
			return false;
		if (!checkControlValue("a_departfullcode","String",1,200,null,0,"机构全路径代码"))
			return false;
		if (!checkControlValue("a_nodeorder","Integer",-999999999,999999999,null,1,"节点顺序"))
			return false;
		valadateCode();
		if(!canCommit)
			return false;
		return true;
	}
	function valadateCode(){ //验证代码
		setParams("a_");
		var sUrl="sysadmin/validateDepartment_department.action";
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
				jAlert('此机构代码已存在!','验证信息');
				canCommit=false;
			}else{
				canCommit=true;
			}
		}else{
			canCommit=false;
		}
	}
	function addback(json){
		if (json.result=="success"){
			jAlert(addMessage,'提示信息');
			queryNextOrder();
			setPageList($("#pageNo").attr("value"));
			saveOnClick($("#a_parentdepartid").attr("value")); //刷新树
			
			$("#a_departname").attr("value",""); //机构名称
			$("#a_departcode").attr("value",""); //机构代码
		}else{
			jAlert(json.result,'错误信息');
		}		
	}
</script>
<input type="hidden" id="a_parentdepartid">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">机构添加</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#department_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>

<table width="100%" id="add">
	<tr height="20">
		<td class="distd" width="18%">机构名称</td>
	    <td class="detailtd" width="35%"><input type="text" class="inputstyle"  id="a_departname" value="" /></td>
		<td class="distd" width="15%">机构代码</td>
        <td class="detailtd" width="32%"><input type="text" class="inputstyle"  id="a_departcode" value="" onblur="valadateCode();"/></td>
	</tr>
	<tr>
		<td class="distd">上级机构</td>
        <td class="detailtd"><input type="text"  readonly   class="readonly" id="ndepartname" value="11" /></td>
	    <td class="distd">排列顺序</td>
        <td class="detailtd"><input type="text" class="inputstyle"  id="a_nodeorder" value="0" /></td>
    </tr>
	<tr>
		<td class="distd">机构全路径代码</td>
        <td colspan="3" class="detailtd"><input type="text" id="a_departfullcode" style="width:400px" readonly class="readonly"/></td>
    </tr>
	<tr height="25" align="center"><td colspan="4">
	<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setAdd();'>保存</a></td></tr>
</table>
