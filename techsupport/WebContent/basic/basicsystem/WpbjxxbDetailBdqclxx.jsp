<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		setParams("m_");
		jQuery.post("basicsystem/query_bdqclxxkz.action",params,bdqclkzdiv,"json"); // 提交到BdqclxxkzAction中,调用其中的query方法
	}); 
	
	function bdqclkzdiv (json) {
		$("#bd_ajbh").append(setNull(json.LBdqclxxkz[0].id));
		$("#bd_lasj").append(setNull(json.LBdqclxxkz[0].lasj));
		$("#bd_clpp").append(setNull(json.LBdqclxxkz[0].clpp));
		$("#bd_clxh").append(setNull(json.LBdqclxxkz[0].clxh));
		$("#bd_hpzl").append(setNull(json.LBdqclxxkz[0].hpzl));
		$("#bd_hphm").append(setNull(json.LBdqclxxkz[0].hphm));
		$("#bd_fdjh").append(setNull(json.LBdqclxxkz[0].fdjh));
		$("#bd_cjh").append(setNull(json.LBdqclxxkz[0].cjh));
		$("#bd_clsbdh").append(setNull(json.LBdqclxxkz[0].clsbdh));
		$("#bd_ccdjrq").append(setNull(json.LBdqclxxkz[0].ccdjrq));
		$("#bd_csys").append(setNull(json.LBdqclxxkz[0].csys));
		$("#bd_sfbx").append(setNull(json.LBdqclxxkz[0].sfbx));
		$("#bd_syr").append(setNull(json.LBdqclxxkz[0].syr));
		//$("#ajxz").append(setNull(json.LBdqclxxkz[0].ajxz));
		$("#bd_ajxz").append("刑事案件");
		$("#bd_basj").append(setNull(json.LBdqclxxkz[0].lasj));
		$("#bd_bar").append(setNull(json.LBdqclxxkz[0].bar));
		$("#bd_tbdwmc").append(setNull(json.LBdqclxxkz[0].tbdwmc));
		$("#bd_tbtbr").append(setNull(json.LBdqclxxkz[0].tbtbr));
		$("#bd_tbsj3").append(setNull(json.LBdqclxxkz[0].tbsj3));
		$("#bd_spr3").append(setNull(json.LBdqclxxkz[0].spr3));
		$("#bd_spyj").append(setNull(json.LBdqclxxkz[0].spyj));
		$("#bd_lrdw").append(setNull(json.LBdqclxxkz[0].lrdw));
		$("#bd_lrr").append(setNull(json.LBdqclxxkz[0].lrr));
		$("#bd_lrsj").append(setNull(json.LBdqclxxkz[0].lrsj));
	}	
</script> 
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr><td class="queryfont">&nbsp;被盗抢车辆简要信息</td>
			</tr>
			<tr><td  class="tdbg">
<table width="100%"  class="detail" id="detail">
	<tr height="20">
		<td width="9%" class="distd1">案件编号</td>
		<td width="24%" class="detailtd2"><span id="bd_ajbh"></span></td>
		<td width="10%" class="distd1">立案时间</td>
		<td width="25%" class="detailtd2"><span id="bd_lasj"></span></td>
		<td width="11%" class="distd1">车辆品牌</td>
		<td width="21%" class="detailtd2"><span id="bd_clpp"></span></td>
  </tr>
	<tr height="20">
		<td class="distd1">车辆型号</td>
		<td class="detailtd2"><span id="bd_clxh"></span></td>
		<td class="distd1">号牌种类</td>
		<td class="detailtd2"><span id="bd_hpzl"></span></td>
		<td class="distd1">车辆号牌</td>
	    <td class="detailtd2"><span id="bd_hphm"></span></td>
	</tr>
    	<tr height="20">
		<td class="distd1">发动机号</td>
		<td class="detailtd2"><span id="bd_fdjh"></span></td>
		<td class="distd1">车架号</td>
		<td class="detailtd2"><span id="bd_cjh"></span></td>
		<td class="distd1">车辆识别代号</td>
		<td class="detailtd2"><span id="bd_clsbdh"></span></td>
	</tr>
    <tr height="20">
		<td class="distd1">初次登记时间</td>
		<td class="detailtd2"><span id="bd_ccdjrq"></span></td>
		<td class="distd1">车身颜色</td>
		<td class="detailtd2"><span id="bd_csys"></span></td>
		<td class="distd1">是否参加被盗抢险</td>
		<td class="detailtd2"><span id="bd_sfbx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">机动车所有人</td>
		<td class="detailtd2"><span id="bd_syr"></span></td>
		<td class="distd1">案件性质</td>
		<td class="detailtd2"><span id="bd_ajxz"></span></td>
		<td class="distd1">报案时间</td>
		<td class="detailtd2"><span id="bd_basj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">报案人</td>
		<td class="detailtd2"><span id="bd_bar"></span></td>
		<td class="distd1">填报单位</td>
		<td class="detailtd2"><span id="bd_tbdwmc"></span></td>
		<td class="distd1">填表人</td>
		<td class="detailtd2"><span id="bd_tbtbr"></span></td>
	</tr>
    	<tr height="20">
		<td class="distd1">填报时间</td>
	  <td class="detailtd2"><span id="bd_tbdwbm"></span></td>
		<td class="distd1">审批人</td>
		<td class="detailtd2" colspan="3"><span id="bd_spr3"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">审批意见</td>
		<td class="detailtd2" colspan="5"><span id="bd_spyj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">录入单位</td>
		<td class="detailtd2"><span id="bd_lrdw"></span></td>
		<td class="distd1">录入人</td>
		<td class="detailtd2"><span id="bd_lrr"></span></td>
		<td class="distd1">录入时间</td>
		<td class="detailtd2"><span id="bd_lrsj"></span></td>
	</tr>
</table>
			</td>
			</tr>
		</table>