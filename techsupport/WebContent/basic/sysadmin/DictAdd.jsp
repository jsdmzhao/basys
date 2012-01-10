<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/dictDropDown.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(26); //按钮右对齐
		$("#a_dict_type").selectBox({state:"1"});
	}); 
	function addVerify(){
		if (!checkControlValue("a_super_dict_code","String",1,10,null,0,"上级字典"))
			return false;
		if (!checkControlValue("a_dict_type","String",1,2,null,0,"字典类型"))
			return false;
		if (!checkControlValue("a_dict_name","String",1,50,null,0,"字典名称"))
			return false;
		if (!checkControlValue("a_dict_versionid","String",1,20,null,0,"版本号"))
			return false;
		if (!checkControlValue("a_dict_code","String",1,20,null,1,"字典代码"))
			return false;
		if (!checkControlValue("a_sib_order","Integer",-99999,99999,null,0,"排列顺序"))
			return false;
		return true;
	}
	
//字典类型为联动时，出现上级字典
function displaySuper(){
	var dict_type = $("#a_dict_type").val();
	if(dict_type=="03")
		$("#superDictCode").css("display","block");
	else
		$("#superDictCode").css("display","none");
}

//字典筛选框
 $("#a_super_dict_code").click(function(){
	getDict_liandong("a_super_dict_code","a_super_dict_code");
});

</script>
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">字典新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#dict_detail").hideAndRemove("show");'class="close"></a></td>
    </tr>
     <tr>
      <td align="left"></td>
      <td></td>
    </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table></div>
<table width="100%" id="add">
	<input type="hidden" id="a_maintFlag" value="0"/>
	<input type="hidden" id="a_dictItemTableName" value="T_DICT_ITEM"/>
	<input type="hidden" id="a_leaf_flag" value="Y"/>
	<tr height="20">
		<td class="distd">字典名称：</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dict_name" value="" /></td>
	</tr>
	<tr height="20">
		<td class="distd">字典代码：</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dict_code" /></td>
	</tr>
	<tr height="20">
		<td class="distd">字典类型：</td>
		<td class="detailtd">
			<select id="a_dict_type" onchange="displaySuper();">
				<option value="01">简单</option>
				<option value="02">树状</option>
				<option value="11">联动</option>
			</select>
		</td>
	</tr>
	<tr id="superDictCode" height="20" style="display:none">
		<td class="distd">上级字典：</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_super_dict_code" readonly></td>
	</tr>
	<tr height="20">
		<td class="distd">版本号：</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dict_versionid" value="" /></td>
	</tr>
	<tr height="20">
		<td class="distd">排列顺序：</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_sib_order" value="0" /></td>
	</tr>
	<tr height="25" align="center"><td colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setAdd();'>保存</a></tr>
</table>
