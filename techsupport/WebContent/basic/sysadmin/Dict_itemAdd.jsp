<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(26); //按钮右对齐
		$("#a_dict_code").val($("#p_dict_code").val());
		$("#s_dict_code").val($("#p_dict_code").val());
		$("#a_super_item_id").val($("#s_super_item_id").val());
		getNextSibOrder();
	}); 
	function addVerify(){
		if (!checkControlValue("a_display_name","String",1,100,null,0,"显示值"))
			return false;
		if (!checkControlValue("a_fact_value","String",1,50,null,0,"实际值"))
			return false;
		if (!checkControlValue("a_append_value","String",1,50,null,0,"附加值"))
			return false;
		if (!checkControlValue("a_sib_order","Integer",-99999,99999,null,0,"排列顺序"))
			return false;
		return true;
	}
	
	function getNextSibOrder(){
		setParams("s_");
		jQuery.post("sysadmin/nextNodeorder_dict_item.action",params,nextSibOrder,"json");
	}
	
	function nextSibOrder(json){
		if  (json.result=="success"){
			$("#a_sib_order").val(json.dict_item.sib_order);
		}		
	}	
	
function setDict_itemAdd(){
	if (addVerify()){
		setParams("a_");
		jQuery.post(addUrl,params,addDict_itemback,"json");
	}else{
		return addVerify();
	}	
}	

function addDict_itemback(json){
	if  (json.result=="success"){
		jAlert(addMessage,'提示信息');
		setPageList($("#pageNo").attr("value"));
		$("#add").find("input[type='text']").val("");
		if($("#dictionaryItem_tree").attr("id")!=null){
			$("#dictionaryItem_tree").width(oldWidth);
			saveSuccess($("#p_super_item_id").attr("value"),0); //刷新树
		}
		getNextSibOrder();
	}else{
		jAlert(json.result,'错误信息');
	}		
}	
</script>
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">字典项新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#dict_item_detail").hideAndRemove("show");'  class="close"></a></td>
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
	<input type="hidden" id="s_dict_code" />
	<input type="hidden" id="a_dict_code" />
	<input type="hidden" id="a_super_item_id" />
	<input type="hidden" id="a_leaf_flag" value="Y"/>
	<input type="hidden" id="a_display_flag" value="0"/>
	<input type="hidden" id="a_valid_flag" value="0"/>
	<tr height="20">
		<td class="distd">显示值：</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_display_name" value=""></td>
	</tr>
	<tr height="20">
	  <td class="distd">实际值：</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="a_fact_value" value="" /></td>
  </tr>
	<tr height="20">
		<td class="distd">附加值：</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_append_value" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">排列顺序：</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_sib_order" value="0"></td>
	</tr>
	<tr height="25" align="center"><td colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setDict_itemAdd();'>保存</a></td></tr>
</table>
