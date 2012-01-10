<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_tbid").attr("value",dataid);
		$("#m_tbid").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_tbid").attr("value",setNull(json.LXctb_fj[0].tbid));
		$("#m_附件id").attr("value",setNull(json.LXctb_fj[0].附件id));
		$("#m_附件名称").attr("value",setNull(json.LXctb_fj[0].附件名称));
		$("#m_附件类型").attr("value",setNull(json.LXctb_fj[0].附件类型));
		$("#m_附件内容").attr("value",setNull(json.LXctb_fj[0].附件内容));
		$("#m_附件序号").attr("value",setNull(json.LXctb_fj[0].附件序号));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_tbid","Integer",-9999999999,9999999999,null,0,"通报ID"))
			return false;
		if (!checkControlValue("m_附件id","Integer",-9999999999,9999999999,null,0,"附件ID"))
			return false;
		if (!checkControlValue("m_附件名称","String",1,100,null,0,"附件名称"))
			return false;
		if (!checkControlValue("m_附件类型","String",1,60,null,0,"附件类型"))
			return false;
		if (!checkControlValue("m_附件内容","byte[]",,,,0,"附件内容"))
			return false;
		if (!checkControlValue("m_附件序号","Integer",-9999999999,9999999999,null,0,"附件序号"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_tbid">
<input type="hidden" id="m_tbid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">通报ID</td>
		<td class="detailtd"><input type="text" id="m_tbid" value="0"></td>
		<td class="distd">附件ID</td>
		<td class="detailtd"><input type="text" id="m_附件id" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">附件名称</td>
		<td class="detailtd"><input type="text" id="m_附件名称" value=""></td>
		<td class="distd">附件类型</td>
		<td class="detailtd"><input type="text" id="m_附件类型" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">附件内容</td>
		<td class="detailtd"><input type="text" id="m_附件内容" value=""></td>
		<td class="distd">附件序号</td>
		<td class="detailtd"><input type="text" id="m_附件序号" value="0"></td>
	</tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="subDiv" onclick='setUpdate();'><img src="images/submit.gif"  border="0"/></a></td>
	</tr>
</table>
