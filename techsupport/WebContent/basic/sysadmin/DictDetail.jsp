<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_dict_code").attr("value",dataid);
		$("#dict_code").text(dataid);
			setDetail();
	}); 
		function updatediv (json) { 
		$("#dict_name").text(setNull(json.LDict[0].dict_name));
		$("#super_dict_code").text(setNull(json.LDict[0].super_dict_code));
		$("#sib_order").text(setNull(json.LDict[0].sib_order));
		var type = "";
		if(json.LDict[0].dict_type=="01")type="简单";
		else if(json.LDict[0].dict_type=="02")type="树状";
		else type="联动";
		$("#dict_type").text(type);
		$("#dict_versionid").text(setNull(json.LDict[0].dict_versionid));
	}

</script>
<input type="hidden" id="q_dict_code">
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">字典详细</td>
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
<table width="100%" border="0"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
<tr height="20">
		<td width="19%" class="distd1">字典名称</td>
	  <td width="81%" class="detailtd2"><span id="dict_name"></span></td>
  </tr>
	<tr height="20">
		<td class="distd1">上级字典</td>
		<td class="detailtd2"><span id="super_dict_code"></span></td>
	</tr>
    	<tr height="20">
		<td class="distd1">字典代码</td>
		<td class="detailtd2"><span id="dict_code"></span></td>
	</tr>
    	<tr height="20">
		<td class="distd1">字典类型</td>
		<td class="detailtd2"><span id="dict_type"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">版本号</td>
		<td class="detailtd2"><span id="dict_versionid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">排列顺序</td>
		<td class="detailtd2"><span id="sib_order"></span></td>
	</tr>
</table>