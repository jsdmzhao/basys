<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(); //将保存按钮右移
		$("#a_ccdjrq").attr("readonly","true");
		$("#a_ccdjrq").datepicker();
		$("#a_lasj").attr("readonly","true");
		$("#a_lasj").datepicker();
		$("#a_slsj").attr("readonly","true");
		$("#a_slsj").datepicker();
		$("#a_tbsj3").attr("readonly","true");
		$("#a_tbsj3").datepicker();
		$("#a_lrsj").attr("readonly","true");
		$("#a_lrsj").datepicker();
		$("#a_xgsj").attr("readonly","true");
		$("#a_xgsj").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("a_bdqclxxkzid","Integer",-9999999999,9999999999,null,0,"被盗抢车辆信息快照ID"))
			return false;
		if (!checkControlValue("a_id","String",1,46,null,0,"序号"))
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
		if (!checkControlValue("a_sfbx","String",1,4,null,0,"是否参加被盗抢险"))
			return false;
		if (!checkControlValue("a_bar","String",1,128,null,0,"报案人"))
			return false;
		if (!checkControlValue("a_ladwqhbm","String",1,20,null,0,"立案单位区划编码"))
			return false;
		if (!checkControlValue("a_ladwqh","String",1,24,null,0,"立案单位区划"))
			return false;
		if (!checkControlValue("a_ladwbm","String",1,20,null,0,"立案单位编码"))
			return false;
		if (!checkControlValue("a_ladwmc","String",1,100,null,0,"立案单位名称"))
			return false;
		if (!checkControlValue("a_lasj","Date",null,null,null,0,"立案时间"))
			return false;
		if (!checkControlValue("a_lajbr","String",1,128,null,0,"立案经办人"))
			return false;
		if (!checkControlValue("a_ladh","String",1,128,null,0,"立案单位联系电话"))
			return false;
		if (!checkControlValue("a_sldwqhbm","String",1,20,null,0,"受理单位区划编码"))
			return false;
		if (!checkControlValue("a_sldwqh","String",1,24,null,0,"受理单位区划"))
			return false;
		if (!checkControlValue("a_sldwbm","String",1,24,null,0,"受理单位编码"))
			return false;
		if (!checkControlValue("a_sldwmc","String",1,128,null,0,"受理单位名称"))
			return false;
		if (!checkControlValue("a_slsj","Date",null,null,null,0,"受理时间"))
			return false;
		if (!checkControlValue("a_sljbr","String",1,128,null,0,"受理经办人"))
			return false;
		if (!checkControlValue("a_sldh","String",1,128,null,0,"受理单位联系电话"))
			return false;
		if (!checkControlValue("a_bz","String",1,2000,null,0,"备注"))
			return false;
		if (!checkControlValue("a_tbdwqhbm","String",1,24,null,0,"填报单位区划编码"))
			return false;
		if (!checkControlValue("a_tbdwqh","String",1,24,null,0,"填报单位区划"))
			return false;
		if (!checkControlValue("a_tbdwbm","String",1,24,null,0,"填报单位编码"))
			return false;
		if (!checkControlValue("a_tbdwmc","String",1,128,null,0,"填报单位名称"))
			return false;
		if (!checkControlValue("a_tbtbr","String",1,128,null,0,"填表人"))
			return false;
		if (!checkControlValue("a_tbsj3","Date",null,null,null,0,"填表时间"))
			return false;
		if (!checkControlValue("a_zt","String",1,2,null,0,"状态"))
			return false;
		if (!checkControlValue("a_scbz","Integer",-99,99,null,0,"删除标志"))
			return false;
		if (!checkControlValue("a_lrdwbm","String",1,20,null,0,"录入单位编码"))
			return false;
		if (!checkControlValue("a_lrdw","String",1,128,null,0,"录入单位"))
			return false;
		if (!checkControlValue("a_lrr","String",1,30,null,0,"录入人"))
			return false;
		if (!checkControlValue("a_lrsj","Date",null,null,null,0,"录入时间"))
			return false;
		if (!checkControlValue("a_xgdwbm","String",1,24,null,0,"修改单位编码"))
			return false;
		if (!checkControlValue("a_xgdw","String",1,128,null,0,"修改单位"))
			return false;
		if (!checkControlValue("a_xgr","String",1,128,null,0,"修改人"))
			return false;
		if (!checkControlValue("a_xgsj","Date",null,null,null,0,"修改时间"))
			return false;
		if (!checkControlValue("a_spr3","String",1,128,null,0,"审批人"))
			return false;
		if (!checkControlValue("a_spyj","String",1,512,null,0,"审批意见"))
			return false;
		if (!checkControlValue("a_sydwbm","String",1,24,null,0,"使用单位编码"))
			return false;
		if (!checkControlValue("a_sydw","String",1,128,null,0,"使用单位"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Bdqclxxkz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">报警信息ID</td>
		<td class="detailtd"><input type="text" id="a_bjxxid2" value="0"></td>
		<td class="distd">被盗抢车辆信息快照ID</td>
		<td class="detailtd"><input type="text" id="a_bdqclxxkzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">序号</td>
		<td class="detailtd"><input type="text" id="a_id" value=""></td>
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
	<tr height="20">
		<td class="distd">是否参加被盗抢险</td>
		<td class="detailtd"><input type="text" id="a_sfbx" value=""></td>
		<td class="distd">报案人</td>
		<td class="detailtd"><input type="text" id="a_bar" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">立案单位区划编码</td>
		<td class="detailtd"><input type="text" id="a_ladwqhbm" value=""></td>
		<td class="distd">立案单位区划</td>
		<td class="detailtd"><input type="text" id="a_ladwqh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">立案单位编码</td>
		<td class="detailtd"><input type="text" id="a_ladwbm" value=""></td>
		<td class="distd">立案单位名称</td>
		<td class="detailtd"><input type="text" id="a_ladwmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">立案时间</td>
		<td class="detailtd"><input type="text" id="a_lasj" value=""></td>
		<td class="distd">立案经办人</td>
		<td class="detailtd"><input type="text" id="a_lajbr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">立案单位联系电话</td>
		<td class="detailtd"><input type="text" id="a_ladh" value=""></td>
		<td class="distd">受理单位区划编码</td>
		<td class="detailtd"><input type="text" id="a_sldwqhbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">受理单位区划</td>
		<td class="detailtd"><input type="text" id="a_sldwqh" value=""></td>
		<td class="distd">受理单位编码</td>
		<td class="detailtd"><input type="text" id="a_sldwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">受理单位名称</td>
		<td class="detailtd"><input type="text" id="a_sldwmc" value=""></td>
		<td class="distd">受理时间</td>
		<td class="detailtd"><input type="text" id="a_slsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">受理经办人</td>
		<td class="detailtd"><input type="text" id="a_sljbr" value=""></td>
		<td class="distd">受理单位联系电话</td>
		<td class="detailtd"><input type="text" id="a_sldh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">备注</td>
		<td class="detailtd"><input type="text" id="a_bz" value=""></td>
		<td class="distd">填报单位区划编码</td>
		<td class="detailtd"><input type="text" id="a_tbdwqhbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">填报单位区划</td>
		<td class="detailtd"><input type="text" id="a_tbdwqh" value=""></td>
		<td class="distd">填报单位编码</td>
		<td class="detailtd"><input type="text" id="a_tbdwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">填报单位名称</td>
		<td class="detailtd"><input type="text" id="a_tbdwmc" value=""></td>
		<td class="distd">填表人</td>
		<td class="detailtd"><input type="text" id="a_tbtbr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">填表时间</td>
		<td class="detailtd"><input type="text" id="a_tbsj3" value=""></td>
		<td class="distd">状态</td>
		<td class="detailtd"><input type="text" id="a_zt" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">删除标志</td>
		<td class="detailtd"><input type="text" id="a_scbz" value="0"></td>
		<td class="distd">录入单位编码</td>
		<td class="detailtd"><input type="text" id="a_lrdwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入单位</td>
		<td class="detailtd"><input type="text" id="a_lrdw" value=""></td>
		<td class="distd">录入人</td>
		<td class="detailtd"><input type="text" id="a_lrr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入时间</td>
		<td class="detailtd"><input type="text" id="a_lrsj" value=""></td>
		<td class="distd">修改单位编码</td>
		<td class="detailtd"><input type="text" id="a_xgdwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">修改单位</td>
		<td class="detailtd"><input type="text" id="a_xgdw" value=""></td>
		<td class="distd">修改人</td>
		<td class="detailtd"><input type="text" id="a_xgr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">修改时间</td>
		<td class="detailtd"><input type="text" id="a_xgsj" value=""></td>
		<td class="distd">审批人</td>
		<td class="detailtd"><input type="text" id="a_spr3" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">审批意见</td>
		<td class="detailtd"><input type="text" id="a_spyj" value=""></td>
		<td class="distd">使用单位编码</td>
		<td class="detailtd"><input type="text" id="a_sydwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">使用单位</td>
		<td class="detailtd"><input type="text" id="a_sydw" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>