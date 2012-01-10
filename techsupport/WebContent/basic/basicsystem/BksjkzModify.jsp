<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(); //将保存按钮右移
		$("#q_bjxxid2").attr("value",dataid);
		$("#m_bjxxid2").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_bjxxid2").attr("value",setNull(json.LBksjkz[0].bjxxid2));
		$("#m_bkwpjbxxkzid").attr("value",setNull(json.LBksjkz[0].bkwpjbxxkzid));
		$("#m_bksjkzid").attr("value",setNull(json.LBksjkz[0].bksjkzid));
		$("#m_sjch").attr("value",setNull(json.LBksjkz[0].sjch));
		$("#m_pp").attr("value",setNull(json.LBksjkz[0].pp));
		$("#m_xh").attr("value",setNull(json.LBksjkz[0].xh));
		$("#m_ys").attr("value",setNull(json.LBksjkz[0].ys));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("m_bkwpjbxxkzid","Integer",-9999999999,9999999999,null,0,"布控物品基本信息快照ID"))
			return false;
		if (!checkControlValue("m_bksjkzid","Integer",-9999999999,9999999999,null,0,"布控手机快照ID"))
			return false;
		if (!checkControlValue("m_sjch","String",1,30,null,0,"手机串号"))
			return false;
		if (!checkControlValue("m_pp","String",1,100,null,0,"品牌"))
			return false;
		if (!checkControlValue("m_xh","String",1,100,null,0,"型号"))
			return false;
		if (!checkControlValue("m_ys","String",1,60,null,0,"颜色"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_bjxxid2">
<input type="hidden" id="m_bjxxid2">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Bksjkz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">报警信息ID</td>
		<td class="detailtd"><input type="text" id="m_bjxxid2" value="0"></td>
		<td class="distd">布控物品基本信息快照ID</td>
		<td class="detailtd"><input type="text" id="m_bkwpjbxxkzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">布控手机快照ID</td>
		<td class="detailtd"><input type="text" id="m_bksjkzid" value="0"></td>
		<td class="distd">手机串号</td>
		<td class="detailtd"><input type="text" id="m_sjch" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">品牌</td>
		<td class="detailtd"><input type="text" id="m_pp" value=""></td>
		<td class="distd">型号</td>
		<td class="detailtd"><input type="text" id="m_xh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">颜色</td>
		<td class="detailtd"><input type="text" id="m_ys" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
