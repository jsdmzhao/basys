<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(); //将保存按钮右移
		$("#q_bjxxid2").attr("value",dataid);
		$("#m_bjxxid2").attr("value",dataid);
		setDetail();
		$("#m_ccdjrq").attr("readonly","true");
		$("#m_ccdjrq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_bjxxid2").attr("value",setNull(json.LBkclkz[0].bjxxid2));
		$("#m_bkwpjbxxkzid").attr("value",setNull(json.LBkclkz[0].bkwpjbxxkzid));
		$("#m_bkclkzid").attr("value",setNull(json.LBkclkz[0].bkclkzid));
		$("#m_cllxdm").attr("value",setNull(json.LBkclkz[0].cllxdm));
		$("#m_cllx").attr("value",setNull(json.LBkclkz[0].cllx));
		$("#m_clpp").attr("value",setNull(json.LBkclkz[0].clpp));
		$("#m_clxh").attr("value",setNull(json.LBkclkz[0].clxh));
		$("#m_hpzldm").attr("value",setNull(json.LBkclkz[0].hpzldm));
		$("#m_hpzl").attr("value",setNull(json.LBkclkz[0].hpzl));
		$("#m_hphm").attr("value",setNull(json.LBkclkz[0].hphm));
		$("#m_csys").attr("value",setNull(json.LBkclkz[0].csys));
		$("#m_syr").attr("value",setNull(json.LBkclkz[0].syr));
		$("#m_ccdjrq").attr("value",setNull(json.LBkclkz[0].ccdjrq));
		$("#m_fdjh").attr("value",setNull(json.LBkclkz[0].fdjh));
		$("#m_clsbdh").attr("value",setNull(json.LBkclkz[0].clsbdh));
		$("#m_cjh").attr("value",setNull(json.LBkclkz[0].cjh));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("m_bkwpjbxxkzid","Integer",-9999999999,9999999999,null,0,"布控物品基本信息快照ID"))
			return false;
		if (!checkControlValue("m_bkclkzid","Integer",-9999999999,9999999999,null,0,"布控车辆快照ID"))
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
<input type="hidden" id="q_bjxxid2">
<input type="hidden" id="m_bjxxid2">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Bkclkz_detail").hideAndRemove("show");' class="close"></a></td>
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
		<td class="distd">布控车辆快照ID</td>
		<td class="detailtd"><input type="text" id="m_bkclkzid" value="0"></td>
		<td class="distd">车辆类型代码</td>
		<td class="detailtd"><input type="text" id="m_cllxdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车辆类型</td>
		<td class="detailtd"><input type="text" id="m_cllx" value=""></td>
		<td class="distd">车辆品牌</td>
		<td class="detailtd"><input type="text" id="m_clpp" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车辆型号</td>
		<td class="detailtd"><input type="text" id="m_clxh" value=""></td>
		<td class="distd">号牌种类代码</td>
		<td class="detailtd"><input type="text" id="m_hpzldm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">号牌种类</td>
		<td class="detailtd"><input type="text" id="m_hpzl" value=""></td>
		<td class="distd">号牌号码</td>
		<td class="detailtd"><input type="text" id="m_hphm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车身颜色</td>
		<td class="detailtd"><input type="text" id="m_csys" value=""></td>
		<td class="distd">机动车所有人</td>
		<td class="detailtd"><input type="text" id="m_syr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">初次登记时间</td>
		<td class="detailtd"><input type="text" id="m_ccdjrq" value=""></td>
		<td class="distd">发动机号</td>
		<td class="detailtd"><input type="text" id="m_fdjh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车辆识别代号</td>
		<td class="detailtd"><input type="text" id="m_clsbdh" value=""></td>
		<td class="distd">车架号</td>
		<td class="detailtd"><input type="text" id="m_cjh" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
