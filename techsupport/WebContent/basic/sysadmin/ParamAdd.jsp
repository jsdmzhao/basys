<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
	}); 
	function addVerify(){
		if (!checkControlValue("a_paramcode","String",1,50,null,0,"参数编码"))
			return false;
		if (!checkControlValue("a_paramname","String",1,50,null,0,"参数名称"))
			return false;
		if (!checkControlValue("a_paramvalue","String",1,1000,null,0,"参数值"))
			return false;
		return true;
	}
</script>
<div align="right"><a href="#" id="closeDiv" onclick='$("#param_detail").hideAndRemove("show");' class="close"></a></div>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">参数名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_paramname" value="" /></td>
	</tr>
	<tr height="20">
	  <td class="distd">参数编码</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="a_paramcode" value="" /></td>
  </tr>
	<tr height="20">
		<td class="distd">参数值</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_paramvalue" value=""></td>
	</tr>
	<tr height="25" align="center"><td colspan="4"><a href="#" id="addbutton" onclick='setAdd();'><img src="images/submit.gif"  border="0"/></a></td></tr>
</table>
