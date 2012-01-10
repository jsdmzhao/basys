<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(); //将保存按钮右移
		$("#q_bdqclxxid").attr("value",dataid);
		$("#m_bdqclxxid").attr("value",dataid);
		setDetail();
		$("#m_ccdjrq").attr("readonly","true");
		$("#m_ccdjrq").datepicker();
		$("#m_lasj").attr("readonly","true");
		$("#m_lasj").datepicker();
		$("#m_slsj").attr("readonly","true");
		$("#m_slsj").datepicker();
		$("#m_tbsj3").attr("readonly","true");
		$("#m_tbsj3").datepicker();
		$("#m_lrsj").attr("readonly","true");
		$("#m_lrsj").datepicker();
		$("#m_xgsj").attr("readonly","true");
		$("#m_xgsj").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_bdqclxxid").attr("value",setNull(json.LBdqclxxlsb[0].bdqclxxid));
		$("#m_id").attr("value",setNull(json.LBdqclxxlsb[0].id));
		$("#m_ajbh").attr("value",setNull(json.LBdqclxxlsb[0].ajbh));
		$("#m_ajxzdm").attr("value",setNull(json.LBdqclxxlsb[0].ajxzdm));
		$("#m_ajxz").attr("value",setNull(json.LBdqclxxlsb[0].ajxz));
		$("#m_cllxdm").attr("value",setNull(json.LBdqclxxlsb[0].cllxdm));
		$("#m_cllx").attr("value",setNull(json.LBdqclxxlsb[0].cllx));
		$("#m_clpp").attr("value",setNull(json.LBdqclxxlsb[0].clpp));
		$("#m_clxh").attr("value",setNull(json.LBdqclxxlsb[0].clxh));
		$("#m_hpzldm").attr("value",setNull(json.LBdqclxxlsb[0].hpzldm));
		$("#m_hpzl").attr("value",setNull(json.LBdqclxxlsb[0].hpzl));
		$("#m_hphm").attr("value",setNull(json.LBdqclxxlsb[0].hphm));
		$("#m_csys").attr("value",setNull(json.LBdqclxxlsb[0].csys));
		$("#m_syr").attr("value",setNull(json.LBdqclxxlsb[0].syr));
		$("#m_ccdjrq").attr("value",setNull(json.LBdqclxxlsb[0].ccdjrq));
		$("#m_fdjh").attr("value",setNull(json.LBdqclxxlsb[0].fdjh));
		$("#m_clsbdh").attr("value",setNull(json.LBdqclxxlsb[0].clsbdh));
		$("#m_cjh").attr("value",setNull(json.LBdqclxxlsb[0].cjh));
		$("#m_sfbx").attr("value",setNull(json.LBdqclxxlsb[0].sfbx));
		$("#m_bar").attr("value",setNull(json.LBdqclxxlsb[0].bar));
		$("#m_ladwqhbm").attr("value",setNull(json.LBdqclxxlsb[0].ladwqhbm));
		$("#m_ladwqh").attr("value",setNull(json.LBdqclxxlsb[0].ladwqh));
		$("#m_ladwbm").attr("value",setNull(json.LBdqclxxlsb[0].ladwbm));
		$("#m_ladwmc").attr("value",setNull(json.LBdqclxxlsb[0].ladwmc));
		$("#m_lasj").attr("value",setNull(json.LBdqclxxlsb[0].lasj));
		$("#m_lajbr").attr("value",setNull(json.LBdqclxxlsb[0].lajbr));
		$("#m_ladh").attr("value",setNull(json.LBdqclxxlsb[0].ladh));
		$("#m_sldwqhbm").attr("value",setNull(json.LBdqclxxlsb[0].sldwqhbm));
		$("#m_sldwqh").attr("value",setNull(json.LBdqclxxlsb[0].sldwqh));
		$("#m_sldwbm").attr("value",setNull(json.LBdqclxxlsb[0].sldwbm));
		$("#m_sldwmc").attr("value",setNull(json.LBdqclxxlsb[0].sldwmc));
		$("#m_slsj").attr("value",setNull(json.LBdqclxxlsb[0].slsj));
		$("#m_sljbr").attr("value",setNull(json.LBdqclxxlsb[0].sljbr));
		$("#m_sldh").attr("value",setNull(json.LBdqclxxlsb[0].sldh));
		$("#m_bz").attr("value",setNull(json.LBdqclxxlsb[0].bz));
		$("#m_tbdwqhbm").attr("value",setNull(json.LBdqclxxlsb[0].tbdwqhbm));
		$("#m_tbdwqh").attr("value",setNull(json.LBdqclxxlsb[0].tbdwqh));
		$("#m_tbdwbm").attr("value",setNull(json.LBdqclxxlsb[0].tbdwbm));
		$("#m_tbdwmc").attr("value",setNull(json.LBdqclxxlsb[0].tbdwmc));
		$("#m_tbtbr").attr("value",setNull(json.LBdqclxxlsb[0].tbtbr));
		$("#m_tbsj3").attr("value",setNull(json.LBdqclxxlsb[0].tbsj3));
		$("#m_zt").attr("value",setNull(json.LBdqclxxlsb[0].zt));
		$("#m_scbz").attr("value",setNull(json.LBdqclxxlsb[0].scbz));
		$("#m_lrdwbm").attr("value",setNull(json.LBdqclxxlsb[0].lrdwbm));
		$("#m_lrdw").attr("value",setNull(json.LBdqclxxlsb[0].lrdw));
		$("#m_lrr").attr("value",setNull(json.LBdqclxxlsb[0].lrr));
		$("#m_lrsj").attr("value",setNull(json.LBdqclxxlsb[0].lrsj));
		$("#m_xgdwbm").attr("value",setNull(json.LBdqclxxlsb[0].xgdwbm));
		$("#m_xgdw").attr("value",setNull(json.LBdqclxxlsb[0].xgdw));
		$("#m_xgr").attr("value",setNull(json.LBdqclxxlsb[0].xgr));
		$("#m_xgsj").attr("value",setNull(json.LBdqclxxlsb[0].xgsj));
		$("#m_spr3").attr("value",setNull(json.LBdqclxxlsb[0].spr3));
		$("#m_spyj").attr("value",setNull(json.LBdqclxxlsb[0].spyj));
		$("#m_sydwbm").attr("value",setNull(json.LBdqclxxlsb[0].sydwbm));
		$("#m_sydw").attr("value",setNull(json.LBdqclxxlsb[0].sydw));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_bdqclxxid","Integer",-9999999999,9999999999,null,0,"被盗抢车辆信息ID"))
			return false;
		if (!checkControlValue("m_id","String",1,46,null,0,"序号"))
			return false;
		if (!checkControlValue("m_ajbh","String",1,60,null,0,"案件编号"))
			return false;
		if (!checkControlValue("m_ajxzdm","String",1,6,null,0,"案件性质代码"))
			return false;
		if (!checkControlValue("m_ajxz","String",1,60,null,0,"案件性质"))
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
		if (!checkControlValue("m_sfbx","String",1,4,null,0,"是否参加被盗抢险"))
			return false;
		if (!checkControlValue("m_bar","String",1,128,null,0,"报案人"))
			return false;
		if (!checkControlValue("m_ladwqhbm","String",1,20,null,0,"立案单位区划编码"))
			return false;
		if (!checkControlValue("m_ladwqh","String",1,24,null,0,"立案单位区划"))
			return false;
		if (!checkControlValue("m_ladwbm","String",1,20,null,0,"立案单位编码"))
			return false;
		if (!checkControlValue("m_ladwmc","String",1,100,null,0,"立案单位名称"))
			return false;
		if (!checkControlValue("m_lasj","Date",null,null,null,0,"立案时间"))
			return false;
		if (!checkControlValue("m_lajbr","String",1,128,null,0,"立案经办人"))
			return false;
		if (!checkControlValue("m_ladh","String",1,128,null,0,"立案单位联系电话"))
			return false;
		if (!checkControlValue("m_sldwqhbm","String",1,20,null,0,"受理单位区划编码"))
			return false;
		if (!checkControlValue("m_sldwqh","String",1,24,null,0,"受理单位区划"))
			return false;
		if (!checkControlValue("m_sldwbm","String",1,24,null,0,"受理单位编码"))
			return false;
		if (!checkControlValue("m_sldwmc","String",1,128,null,0,"受理单位名称"))
			return false;
		if (!checkControlValue("m_slsj","Date",null,null,null,0,"受理时间"))
			return false;
		if (!checkControlValue("m_sljbr","String",1,128,null,0,"受理经办人"))
			return false;
		if (!checkControlValue("m_sldh","String",1,128,null,0,"受理单位联系电话"))
			return false;
		if (!checkControlValue("m_bz","String",1,2000,null,0,"备注"))
			return false;
		if (!checkControlValue("m_tbdwqhbm","String",1,24,null,0,"填报单位区划编码"))
			return false;
		if (!checkControlValue("m_tbdwqh","String",1,24,null,0,"填报单位区划"))
			return false;
		if (!checkControlValue("m_tbdwbm","String",1,24,null,0,"填报单位编码"))
			return false;
		if (!checkControlValue("m_tbdwmc","String",1,128,null,0,"填报单位名称"))
			return false;
		if (!checkControlValue("m_tbtbr","String",1,128,null,0,"填表人"))
			return false;
		if (!checkControlValue("m_tbsj3","Date",null,null,null,0,"填表时间"))
			return false;
		if (!checkControlValue("m_zt","String",1,2,null,0,"状态"))
			return false;
		if (!checkControlValue("m_scbz","Integer",-99,99,null,0,"删除标志"))
			return false;
		if (!checkControlValue("m_lrdwbm","String",1,20,null,0,"录入单位编码"))
			return false;
		if (!checkControlValue("m_lrdw","String",1,128,null,0,"录入单位"))
			return false;
		if (!checkControlValue("m_lrr","String",1,30,null,0,"录入人"))
			return false;
		if (!checkControlValue("m_lrsj","Date",null,null,null,0,"录入时间"))
			return false;
		if (!checkControlValue("m_xgdwbm","String",1,24,null,0,"修改单位编码"))
			return false;
		if (!checkControlValue("m_xgdw","String",1,128,null,0,"修改单位"))
			return false;
		if (!checkControlValue("m_xgr","String",1,128,null,0,"修改人"))
			return false;
		if (!checkControlValue("m_xgsj","Date",null,null,null,0,"修改时间"))
			return false;
		if (!checkControlValue("m_spr3","String",1,128,null,0,"审批人"))
			return false;
		if (!checkControlValue("m_spyj","String",1,512,null,0,"审批意见"))
			return false;
		if (!checkControlValue("m_sydwbm","String",1,24,null,0,"使用单位编码"))
			return false;
		if (!checkControlValue("m_sydw","String",1,128,null,0,"使用单位"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_bdqclxxid">
<input type="hidden" id="m_bdqclxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Bdqclxxlsb_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">被盗抢车辆信息ID</td>
		<td class="detailtd"><input type="text" id="m_bdqclxxid" value="0"></td>
		<td class="distd">序号</td>
		<td class="detailtd"><input type="text" id="m_id" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">案件编号</td>
		<td class="detailtd"><input type="text" id="m_ajbh" value=""></td>
		<td class="distd">案件性质代码</td>
		<td class="detailtd"><input type="text" id="m_ajxzdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">案件性质</td>
		<td class="detailtd"><input type="text" id="m_ajxz" value=""></td>
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
	<tr height="20">
		<td class="distd">是否参加被盗抢险</td>
		<td class="detailtd"><input type="text" id="m_sfbx" value=""></td>
		<td class="distd">报案人</td>
		<td class="detailtd"><input type="text" id="m_bar" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">立案单位区划编码</td>
		<td class="detailtd"><input type="text" id="m_ladwqhbm" value=""></td>
		<td class="distd">立案单位区划</td>
		<td class="detailtd"><input type="text" id="m_ladwqh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">立案单位编码</td>
		<td class="detailtd"><input type="text" id="m_ladwbm" value=""></td>
		<td class="distd">立案单位名称</td>
		<td class="detailtd"><input type="text" id="m_ladwmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">立案时间</td>
		<td class="detailtd"><input type="text" id="m_lasj" value=""></td>
		<td class="distd">立案经办人</td>
		<td class="detailtd"><input type="text" id="m_lajbr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">立案单位联系电话</td>
		<td class="detailtd"><input type="text" id="m_ladh" value=""></td>
		<td class="distd">受理单位区划编码</td>
		<td class="detailtd"><input type="text" id="m_sldwqhbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">受理单位区划</td>
		<td class="detailtd"><input type="text" id="m_sldwqh" value=""></td>
		<td class="distd">受理单位编码</td>
		<td class="detailtd"><input type="text" id="m_sldwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">受理单位名称</td>
		<td class="detailtd"><input type="text" id="m_sldwmc" value=""></td>
		<td class="distd">受理时间</td>
		<td class="detailtd"><input type="text" id="m_slsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">受理经办人</td>
		<td class="detailtd"><input type="text" id="m_sljbr" value=""></td>
		<td class="distd">受理单位联系电话</td>
		<td class="detailtd"><input type="text" id="m_sldh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">备注</td>
		<td class="detailtd"><input type="text" id="m_bz" value=""></td>
		<td class="distd">填报单位区划编码</td>
		<td class="detailtd"><input type="text" id="m_tbdwqhbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">填报单位区划</td>
		<td class="detailtd"><input type="text" id="m_tbdwqh" value=""></td>
		<td class="distd">填报单位编码</td>
		<td class="detailtd"><input type="text" id="m_tbdwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">填报单位名称</td>
		<td class="detailtd"><input type="text" id="m_tbdwmc" value=""></td>
		<td class="distd">填表人</td>
		<td class="detailtd"><input type="text" id="m_tbtbr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">填表时间</td>
		<td class="detailtd"><input type="text" id="m_tbsj3" value=""></td>
		<td class="distd">状态</td>
		<td class="detailtd"><input type="text" id="m_zt" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">删除标志</td>
		<td class="detailtd"><input type="text" id="m_scbz" value="0"></td>
		<td class="distd">录入单位编码</td>
		<td class="detailtd"><input type="text" id="m_lrdwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入单位</td>
		<td class="detailtd"><input type="text" id="m_lrdw" value=""></td>
		<td class="distd">录入人</td>
		<td class="detailtd"><input type="text" id="m_lrr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入时间</td>
		<td class="detailtd"><input type="text" id="m_lrsj" value=""></td>
		<td class="distd">修改单位编码</td>
		<td class="detailtd"><input type="text" id="m_xgdwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">修改单位</td>
		<td class="detailtd"><input type="text" id="m_xgdw" value=""></td>
		<td class="distd">修改人</td>
		<td class="detailtd"><input type="text" id="m_xgr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">修改时间</td>
		<td class="detailtd"><input type="text" id="m_xgsj" value=""></td>
		<td class="distd">审批人</td>
		<td class="detailtd"><input type="text" id="m_spr3" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">审批意见</td>
		<td class="detailtd"><input type="text" id="m_spyj" value=""></td>
		<td class="distd">使用单位编码</td>
		<td class="detailtd"><input type="text" id="m_sydwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">使用单位</td>
		<td class="detailtd"><input type="text" id="m_sydw" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
