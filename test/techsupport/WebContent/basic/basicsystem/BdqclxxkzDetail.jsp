<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjxxid2").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#bjxxid2").append(setNull(json.LBdqclxxkz[0].bjxxid2));
		$("#bdqclxxkzid").append(setNull(json.LBdqclxxkz[0].bdqclxxkzid));
		$("#id").append(setNull(json.LBdqclxxkz[0].id));
		$("#cllxdm").append(setNull(json.LBdqclxxkz[0].cllxdm));
		$("#cllx").append(setNull(json.LBdqclxxkz[0].cllx));
		$("#clpp").append(setNull(json.LBdqclxxkz[0].clpp));
		$("#clxh").append(setNull(json.LBdqclxxkz[0].clxh));
		$("#hpzldm").append(setNull(json.LBdqclxxkz[0].hpzldm));
		$("#hpzl").append(setNull(json.LBdqclxxkz[0].hpzl));
		$("#hphm").append(setNull(json.LBdqclxxkz[0].hphm));
		$("#csys").append(setNull(json.LBdqclxxkz[0].csys));
		$("#syr").append(setNull(json.LBdqclxxkz[0].syr));
		$("#ccdjrq").append(setNull(json.LBdqclxxkz[0].ccdjrq));
		$("#fdjh").append(setNull(json.LBdqclxxkz[0].fdjh));
		$("#clsbdh").append(setNull(json.LBdqclxxkz[0].clsbdh));
		$("#cjh").append(setNull(json.LBdqclxxkz[0].cjh));
		$("#sfbx").append(setNull(json.LBdqclxxkz[0].sfbx));
		$("#bar").append(setNull(json.LBdqclxxkz[0].bar));
		$("#ladwqhbm").append(setNull(json.LBdqclxxkz[0].ladwqhbm));
		$("#ladwqh").append(setNull(json.LBdqclxxkz[0].ladwqh));
		$("#ladwbm").append(setNull(json.LBdqclxxkz[0].ladwbm));
		$("#ladwmc").append(setNull(json.LBdqclxxkz[0].ladwmc));
		$("#lasj").append(setNull(json.LBdqclxxkz[0].lasj));
		$("#lajbr").append(setNull(json.LBdqclxxkz[0].lajbr));
		$("#ladh").append(setNull(json.LBdqclxxkz[0].ladh));
		$("#sldwqhbm").append(setNull(json.LBdqclxxkz[0].sldwqhbm));
		$("#sldwqh").append(setNull(json.LBdqclxxkz[0].sldwqh));
		$("#sldwbm").append(setNull(json.LBdqclxxkz[0].sldwbm));
		$("#sldwmc").append(setNull(json.LBdqclxxkz[0].sldwmc));
		$("#slsj").append(setNull(json.LBdqclxxkz[0].slsj));
		$("#sljbr").append(setNull(json.LBdqclxxkz[0].sljbr));
		$("#sldh").append(setNull(json.LBdqclxxkz[0].sldh));
		$("#bz").append(setNull(json.LBdqclxxkz[0].bz));
		$("#tbdwqhbm").append(setNull(json.LBdqclxxkz[0].tbdwqhbm));
		$("#tbdwqh").append(setNull(json.LBdqclxxkz[0].tbdwqh));
		$("#tbdwbm").append(setNull(json.LBdqclxxkz[0].tbdwbm));
		$("#tbdwmc").append(setNull(json.LBdqclxxkz[0].tbdwmc));
		$("#tbtbr").append(setNull(json.LBdqclxxkz[0].tbtbr));
		$("#tbsj3").append(setNull(json.LBdqclxxkz[0].tbsj3));
		$("#zt").append(setNull(json.LBdqclxxkz[0].zt));
		$("#scbz").append(setNull(json.LBdqclxxkz[0].scbz));
		$("#lrdwbm").append(setNull(json.LBdqclxxkz[0].lrdwbm));
		$("#lrdw").append(setNull(json.LBdqclxxkz[0].lrdw));
		$("#lrr").append(setNull(json.LBdqclxxkz[0].lrr));
		$("#lrsj").append(setNull(json.LBdqclxxkz[0].lrsj));
		$("#xgdwbm").append(setNull(json.LBdqclxxkz[0].xgdwbm));
		$("#xgdw").append(setNull(json.LBdqclxxkz[0].xgdw));
		$("#xgr").append(setNull(json.LBdqclxxkz[0].xgr));
		$("#xgsj").append(setNull(json.LBdqclxxkz[0].xgsj));
		$("#spr3").append(setNull(json.LBdqclxxkz[0].spr3));
		$("#spyj").append(setNull(json.LBdqclxxkz[0].spyj));
		$("#sydwbm").append(setNull(json.LBdqclxxkz[0].sydwbm));
		$("#sydw").append(setNull(json.LBdqclxxkz[0].sydw));
	}	
</script>
<input type="hidden" id="q_bjxxid2">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Bdqclxxkz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="detail">
	<tr height="20">
		<td class="distd1">报警信息ID</td>
		<td class="detailtd2"><span id="bjxxid2"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">被盗抢车辆信息快照ID</td>
		<td class="detailtd2"><span id="bdqclxxkzid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">序号</td>
		<td class="detailtd2"><span id="id"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">车辆类型代码</td>
		<td class="detailtd2"><span id="cllxdm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">车辆类型</td>
		<td class="detailtd2"><span id="cllx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">车辆品牌</td>
		<td class="detailtd2"><span id="clpp"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">车辆型号</td>
		<td class="detailtd2"><span id="clxh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">号牌种类代码</td>
		<td class="detailtd2"><span id="hpzldm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">号牌种类</td>
		<td class="detailtd2"><span id="hpzl"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">号牌号码</td>
		<td class="detailtd2"><span id="hphm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">车身颜色</td>
		<td class="detailtd2"><span id="csys"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">机动车所有人</td>
		<td class="detailtd2"><span id="syr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">初次登记时间</td>
		<td class="detailtd2"><span id="ccdjrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">发动机号</td>
		<td class="detailtd2"><span id="fdjh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">车辆识别代号</td>
		<td class="detailtd2"><span id="clsbdh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">车架号</td>
		<td class="detailtd2"><span id="cjh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">是否参加被盗抢险</td>
		<td class="detailtd2"><span id="sfbx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">报案人</td>
		<td class="detailtd2"><span id="bar"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">立案单位区划编码</td>
		<td class="detailtd2"><span id="ladwqhbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">立案单位区划</td>
		<td class="detailtd2"><span id="ladwqh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">立案单位编码</td>
		<td class="detailtd2"><span id="ladwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">立案单位名称</td>
		<td class="detailtd2"><span id="ladwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">立案时间</td>
		<td class="detailtd2"><span id="lasj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">立案经办人</td>
		<td class="detailtd2"><span id="lajbr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">立案单位联系电话</td>
		<td class="detailtd2"><span id="ladh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">受理单位区划编码</td>
		<td class="detailtd2"><span id="sldwqhbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">受理单位区划</td>
		<td class="detailtd2"><span id="sldwqh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">受理单位编码</td>
		<td class="detailtd2"><span id="sldwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">受理单位名称</td>
		<td class="detailtd2"><span id="sldwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">受理时间</td>
		<td class="detailtd2"><span id="slsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">受理经办人</td>
		<td class="detailtd2"><span id="sljbr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">受理单位联系电话</td>
		<td class="detailtd2"><span id="sldh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">备注</td>
		<td class="detailtd2"><span id="bz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">填报单位区划编码</td>
		<td class="detailtd2"><span id="tbdwqhbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">填报单位区划</td>
		<td class="detailtd2"><span id="tbdwqh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">填报单位编码</td>
		<td class="detailtd2"><span id="tbdwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">填报单位名称</td>
		<td class="detailtd2"><span id="tbdwmc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">填表人</td>
		<td class="detailtd2"><span id="tbtbr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">填表时间</td>
		<td class="detailtd2"><span id="tbsj3"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">状态</td>
		<td class="detailtd2"><span id="zt"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">删除标志</td>
		<td class="detailtd2"><span id="scbz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">录入单位编码</td>
		<td class="detailtd2"><span id="lrdwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">录入单位</td>
		<td class="detailtd2"><span id="lrdw"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">录入人</td>
		<td class="detailtd2"><span id="lrr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">录入时间</td>
		<td class="detailtd2"><span id="lrsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">修改单位编码</td>
		<td class="detailtd2"><span id="xgdwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">修改单位</td>
		<td class="detailtd2"><span id="xgdw"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">修改人</td>
		<td class="detailtd2"><span id="xgr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">修改时间</td>
		<td class="detailtd2"><span id="xgsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">审批人</td>
		<td class="detailtd2"><span id="spr3"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">审批意见</td>
		<td class="detailtd2"><span id="spyj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">使用单位编码</td>
		<td class="detailtd2"><span id="sydwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">使用单位</td>
		<td class="detailtd2"><span id="sydw"></span></td>
	</tr>
</table>