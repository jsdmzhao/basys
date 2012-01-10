<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(); //将保存按钮右移
		$("#q_bkwpjbxxid").attr("value",dataid);
		$("#m_bkwpjbxxid").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_bkwpjbxxid").attr("value",setNull(json.LBksj[0].bkwpjbxxid));
		$("#m_bksjid").attr("value",setNull(json.LBksj[0].bksjid));
		$("#m_sjch").attr("value",setNull(json.LBksj[0].sjch));
		$("#m_pp").attr("value",setNull(json.LBksj[0].pp));
		$("#m_xh").attr("value",setNull(json.LBksj[0].xh));
		$("#m_ys").attr("value",setNull(json.LBksj[0].ys));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_bkwpjbxxid","Integer",-9999999999,9999999999,null,0,"布控物品基本信息ID"))
			return false;
		if (!checkControlValue("m_bksjid","Integer",-9999999999,9999999999,null,0,"布控手机ID"))
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
<input type="hidden" id="q_bkwpjbxxid">
<input type="hidden" id="m_bkwpjbxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Bksj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">布控物品基本信息ID</td>
		<td class="detailtd"><input type="text" id="m_bkwpjbxxid" value="0"></td>
		<td class="distd">布控手机ID</td>
		<td class="detailtd"><input type="text" id="m_bksjid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">手机串号</td>
		<td class="detailtd"><input type="text" id="m_sjch" value=""></td>
		<td class="distd">品牌</td>
		<td class="detailtd"><input type="text" id="m_pp" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">型号</td>
		<td class="detailtd"><input type="text" id="m_xh" value=""></td>
		<td class="distd">颜色</td>
		<td class="detailtd"><input type="text" id="m_ys" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
