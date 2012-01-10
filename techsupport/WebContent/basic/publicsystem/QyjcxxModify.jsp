<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	    bc_bottonMoveRight(3); 
		daggleDiv(detailid);
		$("#q_qycfid").attr("value",dataid);
		$("#m_qycfid").attr("value",dataid);
		setDetail();
		$("#m_qyjcrq").attr("readonly","true");
		$("#m_qyjcrq").datepicker();
		$("#m_pzrq").attr("readonly","true");
		$("#m_pzrq").datepicker();
		$("#m_zxrq").attr("readonly","true");
		$("#m_zxrq").datepicker();
			$("#m_hylbdm").selectBoxhylb({code:"flgy"});//行业类别	
			$("#m_cflbbm").selectBox({code:"dm_jclb"});
		$("#m_jcmxlbdm").selectBox({code:"dm_qyjllb"});//明细 奖励
		$("#m_jcmxlb").val($("#m_jcmxlbdm").attr('title'));
		$("#m_cflb").val($("#m_cflbbm").attr('title'));
		$("#m_cflbbm").change(function(){
			$("#m_cflb").val($("#m_cflbbm").attr('title'));
			if($("#m_cflbbm").val()==0){
				$("#m_jcmxlbdm").selectBox({code:"dm_qyjllb"});//明细 奖励
			}else{
				$("#m_jcmxlbdm").selectBox({code:"dm_qycflb(jxy)"});//明细 处罚
			}
			$("#m_jcmxlb").val($("#m_jcmxlbdm").attr('title'));
		});
		$("#m_jcmxlbdm").change(function(){
			$("#m_jcmxlb").val($("#m_jcmxlbdm").attr('title'));
		});
		$("#m_pzjg").click(function(){ //管辖单位
			getGxdw("m_pzjg","m_pzjgdm");
		});
		$('#m_qymc').click(function(){
			if($("#m_hylbdm").val()!=''){
					dataid=$("#m_hylbdm").val();
					getTy_item("m_qymc","m_qybm");
			}
		});
		$('#m_hylb').val($("#m_hylbdm").attr('title'));
		$("#m_hylbdm").change(function(){
			$("#m_hylb").val($('#m_hylbdm').attr('title'));
		});
		$("#m_hylbdm").setAttr("readonly",true);
	}).unbind("keydown");
	function updatediv (json) { 
		$("#m_qyid").attr("value",setNull(json.LQyjcxx[0].qyid));
		$("#m_qycfid").attr("value",setNull(json.LQyjcxx[0].qycfid));
		$("#m_hylbdm").setValue(setNull(json.LQyjcxx[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LQyjcxx[0].hylb));
		$("#m_qyjcrq").attr("value",setNull(json.LQyjcxx[0].qyjcrq));
		$("#m_cfdjxh").attr("value",setNull(json.LQyjcxx[0].cfdjxh));
		$("#m_cflbbm").setValue(setNull(json.LQyjcxx[0].cflbbm));
		if($("#m_cflbbm").val()==0){
			$("#m_jcmxlbdm").selectBox({code:"dm_qyjllb"});//明细 奖励
			$("#m_jcmxlbdm").setValue(setNull(json.LQyjcxx[0].jcmxlbdm));
		}else{
			$("#m_jcmxlbdm").selectBox({code:"dm_qycflb(jxy)"});//明细 处罚
			$("#m_jcmxlbdm").setValue(setNull(json.LQyjcxx[0].jcmxlbdm));
		}
		$("#m_qybm").attr("value",setNull(json.LQyjcxx[0].qybm));
		$("#m_qymc").attr("value",setNull(json.LQyjcxx[0].qymc));
		$("#m_cflb").attr("value",setNull(json.LQyjcxx[0].cflb));
		$("#m_jcmxlb").attr("value",setNull(json.LQyjcxx[0].jcmxlb));
		$("#m_xzcfpzwh").attr("value",setNull(json.LQyjcxx[0].xzcfpzwh));
		$("#m_pzjgdm").attr("value",setNull(json.LQyjcxx[0].pzjgdm));
		$("#m_pzjg").attr("value",setNull(json.LQyjcxx[0].pzjg));
		$("#m_pzrbh").attr("value",setNull(json.LQyjcxx[0].pzrbh));
		$("#m_pzrxm").attr("value",setNull(json.LQyjcxx[0].pzrxm));
		$("#m_pzrq").attr("value",setNull(json.LQyjcxx[0].pzrq));
		$("#m_zxrbh").attr("value",setNull(json.LQyjcxx[0].zxrbh));
		$("#m_zxrxm").attr("value",setNull(json.LQyjcxx[0].zxrxm));
		$("#m_zxrq").attr("value",setNull(json.LQyjcxx[0].zxrq));
		$("#m_qkms").attr("value",setNull(json.LQyjcxx[0].qkms));
		$("#m_yjly").attr("value",setNull(json.LQyjcxx[0].yjly));
		$("#m_jcfd").attr("value",setNull(json.LQyjcxx[0].jcfd));
		$("#m_bjcr").attr("value",setNull(json.LQyjcxx[0].bjcr));
		hylbOnchangeModify();
	}	
	function modifyVerify(){
		if (!checkControlValue("m_xzcfpzwh","String",1,20,null,0,"行政处罚批准文号"))
			return false;
		if (!checkControlValue("m_hylb","String",1,40,null,1,"行业类别"))
			return false;
		if (!checkControlValue("m_qymc","String",1,40,null,1,"企业名称"))
			return false;
		if (!checkControlValue("m_cflb","String",1,100,null,1,"奖惩类别"))
			return false;
		if (!checkControlValue("m_jcmxlb","String",1,100,null,1,"奖惩明细类别"))
			return false;
		if (!checkControlValue("m_pzjg","String",1,100,null,1,"批准机构"))
			return false;
		if (!checkControlValue("m_pzrbh","String",1,30,null,1,"批准人编号"))
			return false;
		if (!checkControlValue("m_pzrxm","String",1,100,null,1,"批准人姓名"))
			return false;
		if (!checkControlValue("m_pzrq","Date",null,null,null,0,"批准日期"))
			return false;
		if (!checkControlValue("m_zxrbh","String",1,30,null,1,"执行人编号"))
			return false;
		if (!checkControlValue("m_zxrxm","String",1,100,null,1,"执行人姓名"))
			return false;
		if (!checkControlValue("m_zxrq","Date",null,null,null,0,"执行日期"))
			return false;
		if (!checkControlValue("m_jcfd","String",1,100,null,1,"奖惩幅度"))
			return false;
		if (!checkControlValue("m_bjcr","String",1,100,null,0,"被奖惩人"))
			return false;
		if (!checkControlValue("m_qyjcrq","Date",null,null,null,1,"企业奖惩日期"))
			return false;
		if (!checkControlValue("m_qkms","String",1,2000,null,1,"情况描述"))
			return false;
		if (!checkControlValue("m_yjly","String",1,2000,null,0,"依据理由"))
			return false;
		return true;
	}
	function hylbOnchangeModify(){
		var hylb=$("#m_hylbdm").val();
		var csorqymc = "企业名称";
		var csorqybm = "企业编码";
		var jcdjxh = "奖惩登记序号";
		var xzjcpwh = "行政奖惩批准文号";
		var jclb = "奖惩类别";
		var jcmclb = "奖惩明细类别";
		var jcfd = "奖惩幅度";
		var qyjcrq = "企业奖惩日期";
		var yjly = "依据理由";
		if(hylb=='J'){
			csorqymc = "场所名称";
			csorqybm = "场所编码";
			jcdjxh = "处罚/奖励登记序号";
			xzjcpwh = "处罚/奖励行政批准文号";
			jclb = "处罚/奖励类别";
			jcmclb = "处罚/奖励明细类别";
			jcfd = "处罚/奖励结果";
			qyjcrq = "处罚/奖励日期";
			yjly = "处罚/奖励依据";
		}
		$('#qymc_mod').text(csorqymc);
		$('#qybm_mod').text(csorqybm);
		$('#jcdjxh_mod').text(jcdjxh);
		$('#xzjcpwh_mod').text(xzjcpwh);
		$('#jclb_mod').text(jclb);
		$('#jcmclb_mod').text(jcmclb);
		$('#jcfd_mod').text(jcfd);
		$('#qyjcrq_mod').text(qyjcrq);
		$('#yjly_mod').text(yjly);
	}
</script>
<input type="hidden" id="q_qycfid">
<input type="hidden" id="m_qycfid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyjcxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">行业类别</td>
		<td class="detailtd"><select id="m_hylbdm" onchange="hylbOnchangeModify();"></select>
		<input type="hidden"class="inputstyle" id="m_hylb" value=""></td>
		<td class="red"></td>
		<td class="detailtd"></td>
	</tr>
	<tr height="20">
		<td class="red" width="18%" id="qymc_mod">企业名称</td>
		<td class="detailtd" width="29%"><input type="text" class="inputstyle" id="m_qymc" value="" readonly="readonly"></td>
		<td class="distd" width="22%" id="qybm_mod">企业编码</td>
		<td class="detailtd" width="31%"><input type="text" readonly class="readonly" id="m_qybm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd" id="jcdjxh_mod">奖惩登记序号</td>
		<td class="detailtd"><input type="text"class="readonly" id="m_cfdjxh" value=""></td>
		<td class="distd" id="xzjcpwh_mod">奖惩处罚批准文号</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="m_xzcfpzwh"
			onkeyup="htjdOnkeyupVal('m_xzcfpzwh','pwh');" onblur="htjdOnBlurNotOnlyZfVal('m_xzcfpzwh','pwh');"></td>
	</tr>
	<tr height="20">
		<td class="distd" id="jclb_mod">奖惩类别</td>
		<td class="detailtd"><select id="m_cflbbm"></select>
		<input type="hidden"class="inputstyle" id="m_cflb" value=""></td>
		<td class="distd" id="jcmclb_mod">奖惩明细类别</td>
		<td class="detailtd"><select id="m_jcmxlbdm"></select>
		<input type="hidden"class="inputstyle" id="m_jcmxlb" value=""></td>
	</tr>
	<tr height="20">
		<td class="red">批准机构</td>
		<td class="detailtd">
		<input type="text"class="inputstyle" id="m_pzjg" value="" readonly="readonly">
		<input type="hidden" id="m_pzjgdm"></td>
		<td class="red">批准人编号</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="m_pzrbh"
			onkeyup="htjdOnkeyupVal('m_pzrbh','shuzi');" onblur="htjdOnBlurNotOnlyZfVal('m_pzrbh','shuzi');"></td>
	</tr>
	<tr height="20">
		<td class="red">批准人姓名</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="m_pzrxm"
			onkeyup="htjdOnkeyupVal('m_pzrxm','xingming');" onblur="htjdOnBlurNotOnlyZfVal('m_pzrxm','xingming');"></td>
		<td class="distd">批准日期</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="m_pzrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="red">执行人编号</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="m_zxrbh"
			onkeyup="htjdOnkeyupVal('m_zxrbh','shuzi');" onblur="htjdOnBlurNotOnlyZfVal('m_zxrbh','shuzi');"></td>
		<td class="red">执行人姓名</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="m_zxrxm"
			onkeyup="htjdOnkeyupVal('m_zxrxm','xingming');" onblur="htjdOnBlurNotOnlyZfVal('m_zxrxm','xingming');"></td>
	</tr>
	<tr height="20">
		<td class="distd">执行日期</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="m_zxrq" value=""></td>
		<td class="red" id="jcfd_mod">奖惩幅度</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="m_jcfd" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">被奖惩人</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="m_bjcr"
			onkeyup="htjdOnkeyupVal('m_bjcr','xingming');" onblur="htjdOnBlurNotOnlyZfVal('m_bjcr','xingming');"></td>
		<td class="red" id="qyjcrq_mod">企业奖惩日期</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="m_qyjcrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="red">情况描述</td>
		<td colspan="5" class="detailtd"><textarea name="textarea" id="m_qkms" cols="55" rows="4"></textarea></td>
	</tr>
	<tr height="20">
		<td class="distd" id="yjly_mod">依据理由</td>
		<td colspan="5" class="detailtd"><textarea name="textarea" id="m_yjly" cols="55" rows="4"></textarea></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
