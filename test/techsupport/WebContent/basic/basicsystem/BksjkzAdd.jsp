<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(); //将保存按钮右移
	}); 
	function addVerify(){
		if (!checkControlValue("a_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("a_bkwpjbxxkzid","Integer",-9999999999,9999999999,null,0,"布控物品基本信息快照ID"))
			return false;
		if (!checkControlValue("a_bksjkzid","Integer",-9999999999,9999999999,null,0,"布控手机快照ID"))
			return false;
		if (!checkControlValue("a_sjch","String",1,30,null,0,"手机串号"))
			return false;
		if (!checkControlValue("a_pp","String",1,100,null,0,"品牌"))
			return false;
		if (!checkControlValue("a_xh","String",1,100,null,0,"型号"))
			return false;
		if (!checkControlValue("a_ys","String",1,60,null,0,"颜色"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Bksjkz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">报警信息ID</td>
		<td class="detailtd"><input type="text" id="a_bjxxid2" value="0"></td>
		<td class="distd">布控物品基本信息快照ID</td>
		<td class="detailtd"><input type="text" id="a_bkwpjbxxkzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">布控手机快照ID</td>
		<td class="detailtd"><input type="text" id="a_bksjkzid" value="0"></td>
		<td class="distd">手机串号</td>
		<td class="detailtd"><input type="text" id="a_sjch" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">品牌</td>
		<td class="detailtd"><input type="text" id="a_pp" value=""></td>
		<td class="distd">型号</td>
		<td class="detailtd"><input type="text" id="a_xh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">颜色</td>
		<td class="detailtd"><input type="text" id="a_ys" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>