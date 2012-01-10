<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(26); //按钮右对齐
		$("#q_item_id").attr("value",dataid);
		$("#m_item_id").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_display_name").val(setNull(json.LDict_item[0].display_name));
		$("#m_fact_value").val(setNull(json.LDict_item[0].fact_value));
		$("#m_append_value").val(setNull(json.LDict_item[0].append_value));
		$("#m_sib_order").val(setNull(json.LDict_item[0].sib_order));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_display_name","String",1,100,null,0,"显示值"))
			return false;
		if (!checkControlValue("m_fact_value","String",1,50,null,0,"实际值"))
			return false;
		if (!checkControlValue("m_append_value","String",1,50,null,0,"附加值"))
			return false;
		if (!checkControlValue("m_sib_order","Integer",-99999,99999,null,0,"排列顺序"))
			return false;
		return true;
	}
	
	function updateAll(){
		if (modifyVerify()){
			setParams("m_");
			jQuery.post(modUrl,params,updatedict_itemback,"json"); 
			return true;
		}else{
			return false;
		}		
	}
	
	function updatedict_itemback(json){
	if  (json.result=="success"){
		jAlert(modMessage,'保存信息');
		setPageList($("#pageNo").attr("value"));
		$("#dictionaryItem_tree").width(oldWidth);
		$("#"+detailid).hideAndRemove("slow"); 
	}else{
		jAlert(json.result,'错误信息');
	}		
}
	
</script>
<input type="hidden" id="q_item_id">
<input type="hidden" id="m_item_id">
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">字典项修改</td>
      <td><a href="#" id="closeDiv" onclick='$("#dict_item_detail").hideAndRemove("show");' class="close"></a></td>
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
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">显示值：</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_display_name" value=""></td>
	</tr>
	<tr height="20">
	  <td class="distd">实际值：</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="m_fact_value" value="" /></td>
  </tr>
	<tr height="20">
		<td class="distd">附加值：</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_append_value" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">排列顺序：</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_sib_order" value="0"></td>
	</tr>
	<tr height="25" align="center"><td colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='updateAll();'>保存</a></td></tr>
</table>
