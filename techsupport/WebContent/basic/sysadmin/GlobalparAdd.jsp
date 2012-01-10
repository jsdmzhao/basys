<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(36); //按钮右对齐
	}); 
	function addVerify(){
		if (!checkControlValue("a_globalparcode","String",1,50,null,0,"参数编码"))
			return false;
		if (!checkControlValue("a_globalparname","String",1,50,null,0,"参数名称"))
			return false;
		if (!checkControlValue("a_globalparvalue","String",1,1000,null,0,"参数值"))
			return false;
		return true;
	}
</script>
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">全局参数新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#globalpar_detail").hideAndRemove("show");'class="close"></a></td>
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
	<tr height="20">
		<td class="distd">参数编码</td>
		<td colspan="3" class="detailtd"><input type="text" class="inputstyle"  id="a_globalparcode" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">参数名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_globalparname" value="" /></td>
	</tr>
	<tr height="20">
	  <td class="distd">参数值</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="a_globalparvalue" value="" /></td>
  </tr>
	<tr height="25" align="center"><td colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setAdd();'>保存</a></td></tr>
</table>
