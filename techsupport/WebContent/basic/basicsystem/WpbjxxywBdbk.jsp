<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
	    $("[id^='yw_clDetail_']").hide();
	    $("[id^='yw_sjDetail_']").hide();
	    setParams("m_");
		jQuery.post("<%=request.getContextPath()%>/ddhyzagl/queryWpbjYw_ddxx.action",params,bdqcldiv,"json"); // 提交到WpbjxxbAction中,调用其中的queryWpbjYw方法
	}); 
	function bdqcldiv (json) {
	$("#yw_ddqymc").append(setNull(json.LDdxx[0].ddqymc));
	$("#yw_dphm").append(setNull(json.LDdxx[0].dphm));
	$("#yw_dhxm").append(setNull(json.LDdxx[0].dhxm));
	$("#yw_wtrxm").append(setNull(json.LDdxx[0].wtrxm));
	$("#yw_slsj").append(setNull(json.LDdxx[0].slsj));
	$("#yw_ddlx").append(setNull(json.LDdxx[0].ddwpxx.ddlx));
	$("#yw_sl").append(setNull(json.LDdxx[0].ddwpxx.sl));
	$("#yw_zl").append(setNull(json.LDdxx[0].ddwpxx.zl));
	if(setNull(json.LDdxx[0].ddwpxx.wpdldm) == "2"){// 物品类型车辆
	    $("#yw_lxname").append("车架号");
	    $("#yw_lxvalue").append(setNull(json.LDdxx[0].ddwpxx.ddwpcl.cjh));
	    $("#yw_cllx").append(setNull(json.LDdxx[0].ddwpxx.ddwpcl.cllx));
	    $("#yw_clpp").append(setNull(json.LDdxx[0].ddwpxx.ddwpcl.clpp));
	    $("#yw_clxh").append(setNull(json.LDdxx[0].ddwpxx.ddwpcl.clxh));
	    $("#yw_fdjh").append(setNull(json.LDdxx[0].ddwpxx.ddwpcl.fdjh));
	    $("#yw_hpzl").append(setNull(json.LDdxx[0].ddwpxx.ddwpcl.hpzl));
	    $("#yw_hphm").append(setNull(json.LDdxx[0].ddwpxx.ddwpcl.hphm));
	    $("#yw_csys").append(setNull(json.LDdxx[0].ddwpxx.ddwpcl.csys));
	    $("#yw_syr").append(setNull(json.LDdxx[0].ddwpxx.ddwpcl.syr));
	    $("#yw_ccdjrq").append(setNull(json.LDdxx[0].ddwpxx.ddwpcl.ccdjrq));
	    $("[id^='yw_clDetail_']").show();
	}
	if(setNull(json.LDdxx[0].ddwpxx.wpdldm) == "1") {// 物品类型手机
	    $("#yw_pp").append(setNull(json.LDdxx[0].ddwpxx.ddwpsj.pp));
		$("#yw_xh").append(setNull(json.LDdxx[0].ddwpxx.ddwpsj.xh));
		$("#yw_lxname").append("手机串号");
		$("#yw_lxvalue").append(setNull(json.LDdxx[0].ddwpxx.ddwpsj.sjch));
		$("#yw_ys").append(setNull(json.LDdxx[0].ddwpxx.ddwpsj.ys));
	    $("[id^='yw_sjDetail_']").show();
	}
	if(json.LDdxx[0].ddwpxx.sdwpxx != null){
	    $("#yw_xm").append(setNull(json.LDdxx[0].ddwpxx.sdwpxx.xm));
	    $("#yw_cyzj").append(setNull(json.LDdxx[0].ddwpxx.sdwpxx.cyzj));
	    $("#yw_zjhm").append(setNull(json.LDdxx[0].ddwpxx.sdwpxx.zjhm));
	    $("#yw_hjdxzqh").append(setNull(json.LDdxx[0].ddwpxx.sdwpxx.hjdxzqh));
	    $("#yw_xb").append(setNull(json.LDdxx[0].ddwpxx.sdwpxx.xb));
	    $("#yw_lxdh").append(setNull(json.LDdxx[0].ddwpxx.sdwpxx.lxdh));
	    $("#yw_sdsj").append(setNull(json.LDdxx[0].ddwpxx.sdwpxx.sdsj));
	    $("#yw_hjdxz").append(setNull(json.LDdxx[0].ddwpxx.sdwpxx.hjdxz));
	}
	}
</script>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr><td class="queryfont">比对信息</td>
			</tr>
			<tr><td  class="tdbg">
<table width="100%" class="detail" id="detail">
	<tr height="20">
		<td width="10%" class="distd1">典当企业</td>
		<td width="23%" class="detailtd2"><span id="yw_ddqymc"></span></td>
		<td width="10%" class="distd1">当票号码</td>
		<td width="23%" class="detailtd2"><span id="yw_dphm"></span></td>
		<td width="10%" class="distd1">典当人</td>
		<td width="23%" class="detailtd2"><span id="yw_dhxm"></span></td>
  </tr>
	<tr height="20">
		<td width="10%" class="distd1">委托人</td>
		<td width="23%" class="detailtd2"><span id="yw_wtrxm"></td>
		<td width="10%" class="distd1">典当时间</td>
		<td width="23%" class="detailtd2"><span id="yw_slsj"></td>
    <td width="10%" class="distd1">物品归属类型</td>
    <td width="23%" class="detailtd2"><span id="yw_ddlx"></span></td>
        </tr>
 <tr height="20">
    <td width="10%" class="distd1">数量</td>
    <td width="23%" class="detailtd2"><span id="yw_sl"></span></td>
    <td width="10%" class="distd1">重量</td>
    <td width="23%" class="detailtd2"><span id="yw_zl"></span></td>
    <td width="10%" class="reddistd1" id="yw_lxname"></td>
    <td width="23%" class="detailtd2"><span id="yw_lxvalue"></span></td>
    
 </tr>
  <tr height="20" id="yw_clDetail_1">
    <td width="10%" class="distd1">车辆类型</td>
    <td width="23%" class="detailtd2"><span id="yw_cllx"></span></td>
    <td width="10%" class="distd1">车辆品牌</td>
    <td width="23%" class="detailtd2"><span id="yw_clpp"></span></td>
      <td width="10%" class="distd1">车辆型号</td>
    <td width="23%" class="detailtd2"><span id="yw_clxh"></span></td>
  </tr>
  <tr height="20" id="yw_clDetail_2">
    <td width="10%" class="reddistd1">发动机号</td>
    <td width="23%" class="detailtd2"><span id="yw_fdjh"></span></td>
    <td width="10%" class="reddistd1">号牌种类</td>
    <td width="23%" class="detailtd2"><span id="yw_hpzl"></span></td>
    <td width="10%" class="reddistd1">号牌号码</td>
    <td width="23%" class="detailtd2"><span id="yw_hphm"></span></td>
  </tr>
  <tr height="20" id="yw_sjDetail_1">
    <td width="10%" class="distd1">手机品牌</td>
    <td width="23%" class="detailtd2"><span id="yw_pp"></span></td>
    <td width="10%" class="distd1">手机型号</td>
    <td width="23%" class="detailtd2"><span id="yw_xh"></span></td>
    <td width="10%" class="distd1">手机颜色</td>
    <td width="23%" class="detailtd2"><span id="yw_ys"></span></td>
  </tr>
  <tr height="20" id="yw_clDetail_3">
    <td width="10%" class="distd1">车身颜色</td>
    <td width="23%" class="detailtd2"><span id="yw_csys"></span></td>
    <td width="10%" class="reddistd1">机动车所有人</td>
    <td width="23%" class="detailtd2"><span id="yw_syr"></span></td>
    <td width="10%" class="reddistd1">初次登记时间</td>
    <td width="23%" class="detailtd2"><span id="yw_ccdjrq"></span></td>
  </tr>
  <tr><td class="queryfont" colspan="6">赎当人信息</td>
	</tr>
    <tr height="20">
    <td width="9%" class="reddistd1">姓名</td>
    <td width="26%" class="detailtd2"><span   id="yw_xm" ></span></td>
    <td width="12%" class="reddistd1">证件类型</td>
    <td width="21%" class="detailtd2"><span id="yw_cyzj"> </td>
    <td class="reddistd1">证件号码</td>
    <td class="detailtd2"><span   id="yw_zjhm" ></span></td>
      </tr>
  <tr height="20">
    <td class="reddistd1">行政区划</td>
    <td class="detailtd2"><span   id="yw_hjdxzqh" ></span></td>
    <td class="reddistd1">性别</td>
    <td class="detailtd2"><span id="yw_xb" ></span> </td>
    <td class="reddistd1">联系电话</td>
    <td class="detailtd2"><span   id="yw_lxdh" ></span></td>
  </tr>
  <tr height="20">
    <td class="reddistd1">赎当时间</td>
    <td class="detailtd2"><span  id="yw_sdsj" ></span></td>
    <td class="reddistd1">详细地址</td>
    <td class="detailtd2"><span id="yw_hjdxz" ></span></td>
   <td class="reddistd1">&nbsp;</td>
    <td class="detailtd2"></td>
  </tr>
</table>
			</td>
			</tr>
		</table>