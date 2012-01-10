<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(); //将保存按钮右移
		$("#a_ccdjrq").attr("readonly","true");
		$("#a_ccdjrq").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("a_bkwpjbxxkzid","Integer",-9999999999,9999999999,null,0,"布控物品基本信息快照ID"))
			return false;
		if (!checkControlValue("a_bkclkzid","Integer",-9999999999,9999999999,null,0,"布控车辆快照ID"))
			return false;
		if (!checkControlValue("a_cllxdm","String",1,10,null,0,"车辆类型代码"))
			return false;
		if (!checkControlValue("a_cllx","String",1,32,null,0,"车辆类型"))
			return false;
		if (!checkControlValue("a_clpp","String",1,64,null,0,"车辆品牌"))
			return false;
		if (!checkControlValue("a_clxh","String",1,64,null,0,"车辆型号"))
			return false;
		if (!checkControlValue("a_hpzldm","String",1,4,null,0,"号牌种类代码"))
			return false;
		if (!checkControlValue("a_hpzl","String",1,32,null,0,"号牌种类"))
			return false;
		if (!checkControlValue("a_hphm","String",1,32,null,0,"号牌号码"))
			return false;
		if (!checkControlValue("a_csys","String",1,32,null,0,"车身颜色"))
			return false;
		if (!checkControlValue("a_syr","String",1,512,null,0,"机动车所有人"))
			return false;
		if (!checkControlValue("a_ccdjrq","Date",null,null,null,0,"初次登记时间"))
			return false;
		if (!checkControlValue("a_fdjh","String",1,60,null,0,"发动机号"))
			return false;
		if (!checkControlValue("a_clsbdh","String",1,50,null,0,"车辆识别代号"))
			return false;
		if (!checkControlValue("a_cjh","String",1,50,null,0,"车架号"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Bkclkz_detail").hideAndRemove("show");' class="close"></a></td>
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
		<td class="distd">布控车辆快照ID</td>
		<td class="detailtd"><input type="text" id="a_bkclkzid" value="0"></td>
		<td class="distd">车辆类型代码</td>
		<td class="detailtd"><input type="text" id="a_cllxdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车辆类型</td>
		<td class="detailtd"><input type="text" id="a_cllx" value=""></td>
		<td class="distd">车辆品牌</td>
		<td class="detailtd"><input type="text" id="a_clpp" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车辆型号</td>
		<td class="detailtd"><input type="text" id="a_clxh" value=""></td>
		<td class="distd">号牌种类代码</td>
		<td class="detailtd"><input type="text" id="a_hpzldm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">号牌种类</td>
		<td class="detailtd"><input type="text" id="a_hpzl" value=""></td>
		<td class="distd">号牌号码</td>
		<td class="detailtd"><input type="text" id="a_hphm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车身颜色</td>
		<td class="detailtd"><input type="text" id="a_csys" value=""></td>
		<td class="distd">机动车所有人</td>
		<td class="detailtd"><input type="text" id="a_syr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">初次登记时间</td>
		<td class="detailtd"><input type="text" id="a_ccdjrq" value=""></td>
		<td class="distd">发动机号</td>
		<td class="detailtd"><input type="text" id="a_fdjh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车辆识别代号</td>
		<td class="detailtd"><input type="text" id="a_clsbdh" value=""></td>
		<td class="distd">车架号</td>
		<td class="detailtd"><input type="text" id="a_cjh" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>