<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_item_id").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#item_id").text(setNull(json.LDict_item[0].item_id));
		$("#dict_code").text(setNull(json.LDict_item[0].dict_code));
		$("#display_name").text(setNull(json.LDict_item[0].display_name));
		$("#fact_value").text(setNull(json.LDict_item[0].fact_value));
		$("#append_value").text(setNull(json.LDict_item[0].append_value));
		$("#super_item_id").text(setNull(json.LDict_item[0].super_item_id));
		$("#sib_order").text(setNull(json.LDict_item[0].sib_order));
		$("#leaf_flag").text(setNull(json.LDict_item[0].leaf_flag));
		$("#display_flag").text(setNull(json.LDict_item[0].display_flag));
		$("#valid_flag").text(setNull(json.LDict_item[0].valid_flag));
		$("#item_simplepin").text(setNull(json.LDict_item[0].item_simplepin));
		$("#item_allpin").text(setNull(json.LDict_item[0].item_allpin));
	}	
</script>
<input type="hidden" id="q_item_id">
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">字典项详细</td>
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
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1">字典项ID</td>
		<td class="detailtd2"><span id="item_id"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">字典编码</td>
		<td class="detailtd2"><span id="dict_code"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">显示名称</td>
		<td class="detailtd2"><span id="display_name"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">实际值</td>
		<td class="detailtd2"><span id="fact_value"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">附加值</td>
		<td class="detailtd2"><span id="append_value"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">上级字典项ID</td>
		<td class="detailtd2"><span id="super_item_id"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">兄弟排序</td>
		<td class="detailtd2"><span id="sib_order"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">叶节点标志</td>
		<td class="detailtd2"><span id="leaf_flag"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">显示标志</td>
		<td class="detailtd2"><span id="display_flag"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">有效标志</td>
		<td class="detailtd2"><span id="valid_flag"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">字典项名称简拼</td>
		<td class="detailtd2"><span id="item_simplepin"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">字典项名称全拼</td>
		<td class="detailtd2"><span id="item_allpin"></span></td>
	</tr>
</table>