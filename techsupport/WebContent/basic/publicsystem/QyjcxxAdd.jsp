<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(3); 
		daggleDiv(detailid);
		$("#a_hylbdm").selectBoxhylb({code:"flgy"});//行业类别	
		$("#a_qyjcrq").attr("readonly","true");
		$("#a_qyjcrq").datepicker();
		$("#a_pzrq").attr("readonly","true");
		$("#a_pzrq").datepicker();
		$("#a_zxrq").attr("readonly","true");
		$("#a_zxrq").datepicker();
		$("#a_cflbbm").selectBox({code:"dm_jclb"});
		$("#a_jcmxlbdm").selectBox({code:"dm_qyjllb"});//明细 处罚
		$("#a_jcmxlb").val($("#a_jcmxlbdm").attr('title'));
		$("#a_cflb").val($("#a_cflbbm").attr('title'));
		$("#a_cflbbm").change(function(){
			$("#a_cflb").val($("#a_cflbbm").attr('title'));
			if($("#a_cflbbm").val()==0){
				$("#a_jcmxlbdm").selectBox({code:"dm_qyjllb"});//明细 奖励
			}else{
				$("#a_jcmxlbdm").selectBox({code:"dm_qycflb(jxy)"});//明细 处罚
			}
			$("#a_jcmxlb").val($("#a_jcmxlbdm").attr('title'));
		});
		$("#a_jcmxlbdm").change(function(){
			$("#a_jcmxlb").val($("#a_jcmxlbdm").attr('title'));
		});
		$("#a_pzjg").click(function(){ //管辖单位
			getGxdw("a_pzjg","a_pzjgdm");
		});
		$('#a_qymc').click(function(){
			if($("#a_hylbdm").val()!=''){
					dataid=$('#a_hylbdm').val();
					getTy_item("a_qymc","a_qybm");
			}
		});
		$('#a_hylb').val($("#a_hylbdm").attr('title'));
		$("#a_hylbdm").change(function(){
			$("#a_hylb").val($('#a_hylbdm').attr('title'));
		});
		hylbOnchangeAdd();
	}).unbind("keydown");
	function addVerify(){
		if (!checkControlValue("a_xzcfpzwh","String",1,20,null,0,"奖惩处罚批准文号"))
			return false;
		if (!checkControlValue("a_hylb","String",1,40,null,1,"行业类别"))
			return false;
		if (!checkControlValue("a_qymc","String",1,40,null,1,"企业名称"))
			return false;
		if (!checkControlValue("a_cflb","String",1,100,null,1,"奖惩类别"))
			return false;
		if (!checkControlValue("a_jcmxlb","String",1,100,null,1,"奖惩明细类别"))
			return false;
		if (!checkControlValue("a_pzjg","String",1,100,null,1,"批准机构"))
			return false;
		if (!checkControlValue("a_pzrbh","String",1,30,null,1,"批准人编号"))
			return false;
		if (!checkControlValue("a_pzrxm","String",1,100,null,1,"批准人姓名"))
			return false;
		if (!checkControlValue("a_pzrq","Date",null,null,null,0,"批准日期"))
			return false;
		if (!checkControlValue("a_zxrbh","String",1,30,null,1,"执行人编号"))
			return false;
		if (!checkControlValue("a_zxrxm","String",1,100,null,1,"执行人姓名"))
			return false;
		if (!checkControlValue("a_zxrq","Date",null,null,null,0,"执行日期"))
			return false;
		if (!checkControlValue("a_jcfd","String",1,100,null,1,"奖惩幅度"))
			return false;
		if (!checkControlValue("a_bjcr","String",1,100,null,0,"被奖惩人"))
			return false;
		if (!checkControlValue("a_qyjcrq","Date",null,null,null,1,"企业奖惩日期"))
			return false;
		if (!checkControlValue("a_qkms","String",1,2000,null,1,"情况描述"))
			return false;
		if (!checkControlValue("a_yjly","String",1,2000,null,0,"依据理由"))
			return false;
		return true;
	}
	function setAddqyjc(){
		if (addVerify()){
			setParams("a_");
			jQuery.post(addUrl,params,addback,"json");
		}
	}
	function hylbOnchangeAdd(){
		$("#a_qymc").attr("value","");
		$("#a_qybm").attr("value","");
		var hylb=$("#a_hylbdm").val();
		var csorqymc = "企业名称";
		var csorqybm = "企业编码";
		var jcdjxh = "奖惩登记序号";
		var xzjcpwh = "行政奖惩批准文号";
		var jclb = "奖惩类别";
		var jcmclb = "奖惩明细类别";
		var jcfd = "奖惩幅度";
		var qyjcrq = "企业奖惩日期";
		var yjly = "依据理由";
		if(hylb=='J'||hylb=='K'){
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
		$('#qymc_add').text(csorqymc);
		$('#qybm_add').text(csorqybm);
		$('#jcdjxh_add').text(jcdjxh);
		$('#xzjcpwh_add').text(xzjcpwh);
		$('#jclb_add').text(jclb);
		$('#jcmclb_add').text(jcmclb);
		$('#jcfd_add').text(jcfd);
		$('#qyjcrq_add').text(qyjcrq);
		$('#yjly_add').text(yjly);
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyjcxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">行业类别</td>
		<td class="detailtd"><select id="a_hylbdm" onchange="hylbOnchangeAdd();"></select>
		<input type="hidden"class="inputstyle" id="a_hylb" value=""></td>
		<td class="red"></td>
		<td class="detailtd"></td>
	</tr>
	<tr height="20">
		<td class="red" width="18%" id="qymc_add">企业名称</td>
		<td class="detailtd" width="29%"><input type="text" class="inputstyle" id="a_qymc" value="" readonly="readonly"></td>
		<td class="distd" width="22%" id="qybm_add">企业编码</td>
		<td class="detailtd" width="31%"><input type="text" readonly class="readonly" id="a_qybm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd" id="jcdjxh_add">奖惩登记序号</td>
		<td class="detailtd"><input type="text"class="readonly" id="a_cfdjxh" value=""></td>
		<td class="distd" id="xzjcpwh_add">奖惩处罚批准文号</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="a_xzcfpzwh"
			onkeyup="htjdOnkeyupVal('a_xzcfpzwh','pwh');" onblur="htjdOnBlurNotOnlyZfVal('a_xzcfpzwh','pwh');"/></td>
	</tr>
	<tr height="20">
		<td class="distd" id="jclb_add">奖惩类别</td>
		<td class="detailtd"><select id="a_cflbbm"></select>
		<input type="hidden"class="inputstyle" id="a_cflb" value=""></td>
		<td class="distd" id="jcmclb_add">奖惩明细类别</td>
		<td class="detailtd"><select id="a_jcmxlbdm"></select>
		<input type="hidden"class="inputstyle" id="a_jcmxlb" value=""></td>
	</tr>
	<tr height="20">
		<td class="red">批准机构</td>
		<td class="detailtd">
		<input type="text"class="inputstyle" id="a_pzjg" value="" readonly="readonly">
		<input type="hidden" id="a_pzjgdm"></td>
		<td class="red">批准人编号</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="a_pzrbh"
			onkeyup="htjdOnkeyupVal('a_pzrbh','shuzi');" onblur="htjdOnBlurNotOnlyZfVal('a_pzrbh','shuzi');"></td>
	</tr>
	<tr height="20">
		<td class="red">批准人姓名</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="a_pzrxm"
			onkeyup="htjdOnkeyupVal('a_pzrxm','xingming');" onblur="htjdOnBlurNotOnlyZfVal('a_pzrxm','xingming');"></td>
		<td class="distd">批准日期</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="a_pzrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="red">执行人编号</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="a_zxrbh"
			onkeyup="htjdOnkeyupVal('a_zxrbh','shuzi');" onblur="htjdOnBlurNotOnlyZfVal('a_zxrbh','shuzi');"></td>
		<td class="red">执行人姓名</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="a_zxrxm"
			onkeyup="htjdOnkeyupVal('a_zxrxm','xingming');" onblur="htjdOnBlurNotOnlyZfVal('a_zxrxm','xingming');"></td>
	</tr>
	<tr height="20">
		<td class="distd">执行日期</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="a_zxrq" value=""></td>
		<td class="red" id="jcfd_add">奖惩幅度</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="a_jcfd" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">被奖惩人</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="a_bjcr"
			onkeyup="htjdOnkeyupVal('a_bjcr','xingming');" onblur="htjdOnBlurNotOnlyZfVal('a_bjcr','xingming');"></td>
		<td class="red" id="qyjcrq_add">企业奖惩日期</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="a_qyjcrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="red">情况描述</td>
		<td colspan="5" class="detailtd"><textarea name="textarea" id="a_qkms" cols="55" rows="4"></textarea></td>
	</tr>
	<tr height="20">
		<td class="distd" id="yjly_add">依据理由</td>
		<td colspan="5" class="detailtd"><textarea name="textarea" id="a_yjly" cols="55" rows="4"></textarea></td>
	</tr>
	<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setAddqyjc();'>保存</a></td></tr>
</table>