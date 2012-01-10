<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(); //将保存按钮右移
		$("#q_bkwpjbxxid").attr("value",dataid);
		$("#m_bkwpjbxxid").attr("value",dataid);
		setDetail();
		$("#m_ccdjrq").attr("readonly","true");
		$("#m_ccdjrq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_bkwpjbxxid").attr("value",setNull(json.LBkcl[0].bkwpjbxxid));
		$("#m_bkclid").attr("value",setNull(json.LBkcl[0].bkclid));
		$("#m_cllxdm").attr("value",setNull(json.LBkcl[0].cllxdm));
		$("#m_cllx").attr("value",setNull(json.LBkcl[0].cllx));
		$("#m_clpp").attr("value",setNull(json.LBkcl[0].clpp));
		$("#m_clxh").attr("value",setNull(json.LBkcl[0].clxh));
		$("#m_hpzldm").attr("value",setNull(json.LBkcl[0].hpzldm));
		$("#m_hpzl").attr("value",setNull(json.LBkcl[0].hpzl));
		$("#m_hphm").attr("value",setNull(json.LBkcl[0].hphm));
		$("#m_csys").attr("value",setNull(json.LBkcl[0].csys));
		$("#m_syr").attr("value",setNull(json.LBkcl[0].syr));
		$("#m_ccdjrq").attr("value",setNull(json.LBkcl[0].ccdjrq));
		$("#m_fdjh").attr("value",setNull(json.LBkcl[0].fdjh));
		$("#m_clsbdh").attr("value",setNull(json.LBkcl[0].clsbdh));
		$("#m_cjh").attr("value",setNull(json.LBkcl[0].cjh));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_bkwpjbxxid","Integer",-9999999999,9999999999,null,0,"布控物品基本信息ID"))
			return false;
		if (!checkControlValue("m_bkclid","Integer",-9999999999,9999999999,null,0,"布控车辆ID"))
			return false;
		if (!checkControlValue("m_cllxdm","String",1,10,null,0,"车辆类型代码"))
			return false;
		if (!checkControlValue("m_cllx","String",1,32,null,0,"车辆类型"))
			return false;
		if (!checkControlValue("m_clpp","String",1,64,null,0,"车辆品牌"))
			return false;
		if (!checkControlValue("m_clxh","String",1,64,null,0,"车辆型号"))
			return false;
		if (!checkControlValue("m_hpzldm","String",1,4,null,0,"号牌种类代码"))
			return false;
		if (!checkControlValue("m_hpzl","String",1,32,null,0,"号牌种类"))
			return false;
		if (!checkControlValue("m_hphm","String",1,32,null,0,"号牌号码"))
			return false;
		if (!checkControlValue("m_csys","String",1,32,null,0,"车身颜色"))
			return false;
		if (!checkControlValue("m_syr","String",1,512,null,0,"机动车所有人"))
			return false;
		if (!checkControlValue("m_ccdjrq","Date",null,null,null,0,"初次登记时间"))
			return false;
		if (!checkControlValue("m_fdjh","String",1,60,null,0,"发动机号"))
			return false;
		if (!checkControlValue("m_clsbdh","String",1,50,null,0,"车辆识别代号"))
			return false;
		if (!checkControlValue("m_cjh","String",1,50,null,0,"车架号"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_bkwpjbxxid">
<input type="hidden" id="m_bkwpjbxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Bkcl_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">布控物品基本信息ID</td>
		<td class="detailtd"><input type="text" id="m_bkwpjbxxid" value="0"></td>
		<td class="distd">布控车辆ID</td>
		<td class="detailtd"><input type="text" id="m_bkclid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">车辆类型代码</td>
		<td class="detailtd"><input type="text" id="m_cllxdm" value=""></td>
		<td class="distd">车辆类型</td>
		<td class="detailtd"><input type="text" id="m_cllx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车辆品牌</td>
		<td class="detailtd"><input type="text" id="m_clpp" value=""></td>
		<td class="distd">车辆型号</td>
		<td class="detailtd"><input type="text" id="m_clxh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">号牌种类代码</td>
		<td class="detailtd"><input type="text" id="m_hpzldm" value=""></td>
		<td class="distd">号牌种类</td>
		<td class="detailtd"><input type="text" id="m_hpzl" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">号牌号码</td>
		<td class="detailtd"><input type="text" id="m_hphm" value=""></td>
		<td class="distd">车身颜色</td>
		<td class="detailtd"><input type="text" id="m_csys" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">机动车所有人</td>
		<td class="detailtd"><input type="text" id="m_syr" value=""></td>
		<td class="distd">初次登记时间</td>
		<td class="detailtd"><input type="text" id="m_ccdjrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发动机号</td>
		<td class="detailtd"><input type="text" id="m_fdjh" value=""></td>
		<td class="distd">车辆识别代号</td>
		<td class="detailtd"><input type="text" id="m_clsbdh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车架号</td>
		<td class="detailtd"><input type="text" id="m_cjh" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
