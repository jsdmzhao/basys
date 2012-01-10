<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_globalparcode").attr("value",dataid);
		$("#m_globalparcode").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_globalparcode").append(setNull(json.LGlobalpar[0].globalparcode));
		$("#m_globalparname").append(setNull(json.LGlobalpar[0].globalparname));
		$("#m_globalparvalue").append(setNull(json.LGlobalpar[0].globalparvalue));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_globalparcode","String",1,50,null,0,"参数编码"))
			return false;
		if (!checkControlValue("m_globalparname","String",1,50,null,0,"参数名称"))
			return false;
		if (!checkControlValue("m_globalparvalue","String",1,1000,null,0,"参数值"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_globalparcode">
<input type="hidden" id="m_globalparcode">
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">全局参数修改</td>
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
<table width="100%" id="modify">
<tr height="20">
		<td class="distd">参数编码</td>
		<td colspan="3" class="detailtd"><input type="text" class="inputstyle"  id="m_globalparcode" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">参数名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_globalparname" value="" /></td>
	</tr>
	<tr height="20">
	  <td class="distd">参数值</td>
	  <td class="detailtd"><input type="text" class="inputstyle"  id="m_globalparvalue" value="" /></td>
  </tr>
	<tr height="25" align="center"><td colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>

