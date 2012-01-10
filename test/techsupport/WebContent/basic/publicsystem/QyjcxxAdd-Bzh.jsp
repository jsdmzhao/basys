<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(3); 
		$("#a_hylbdm").selectBoxhylb({code:"flgy"});//行业类别	
		$("#a_qyjcrq").attr("readonly","true");
		$("#a_qyjcrq").datepicker();
		$("#a_pzrq").attr("readonly","true");
		$("#a_pzrq").datepicker();
		$("#a_zxrq").attr("readonly","true");
		$("#a_zxrq").datepicker();
		$("#a_jcmxlbdm").selectBox({code:"dm_qycflb(jxy)"});//明细 处罚
		$("#a_jcmxlb").val($("#a_jcmxlbdm").attr('title'));
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
	}).unbind("keydown");
	function addVerify(){
		if (!checkControlValue("a_xzcfpzwh","String",1,20,null,1,"行政处罚批准文号"))
			return false;
		if (!checkControlValue("a_hylb","String",1,40,null,1,"行业类别"))
			return false;
		if (!checkControlValue("a_qymc","String",1,40,null,1,"场所名称"))
			return false;
		if (!checkControlValue("a_jcmxlb","String",1,100,null,1,"处罚类别"))
			return false;
		if (!checkControlValue("a_pzjg","String",1,100,null,1,"批准机构"))
			return false;
		if (!checkControlValue("a_pzrbh","String",1,30,null,1,"批准人编号"))
			return false;
		if (!checkControlValue("a_pzrxm","String",1,100,null,1,"批准人姓名"))
			return false;
		if (!checkControlValue("a_pzrq","Date",null,null,null,1,"批准日期"))
			return false;
		if (!checkControlValue("a_zxrbh","String",1,30,null,1,"执行人编号"))
			return false;
		if (!checkControlValue("a_zxrxm","String",1,100,null,1,"执行人姓名"))
			return false;
		if (!checkControlValue("a_zxrq","Date",null,null,null,1,"执行日期"))
			return false;
		if (!checkControlValue("a_jcfd","String",1,100,null,1,"处罚结果"))
			return false;
		if (!checkControlValue("a_bjcr","String",1,100,null,1,"被处罚人"))
			return false;
		if (!checkControlValue("a_qyjcrq","Date",null,null,null,1,"处罚日期"))
			return false;
		if (!checkControlValue("a_qkms","String",1,2000,null,1,"违规情形"))
			return false;
		if (!checkControlValue("a_yjly","String",1,2000,null,0,"处罚依据"))
			return false;
		return true;
	}
	function setAddqyjc(){
		if (addVerify()){
			setParams("a_");
			jQuery.post(addUrl,params,addback,"json");
		}
	}
</script>
<input type="hidden" id="a_cflbbm" value="1">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyjcxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="red" width="18%" id="qymc_add">场所名称</td>
		<td class="detailtd" width="29%"><input type="text" class="inputstyle" id="a_qymc" value="" readonly="readonly"></td>
		<td class="distd" width="22%" id="qybm_add">场所编码</td>
		<td class="detailtd" width="31%"><input type="text" readonly class="readonly" id="a_qybm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd" id="jcdjxh_add">处罚登记序号</td>
		<td class="detailtd"><input type="text"class="readonly" id="a_cfdjxh" value=""></td>
		<td class="red" id="xzjcpwh_add">行政处罚批准文号</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="a_xzcfpzwh"
			onkeyup="htjdOnkeyupVal('a_xzcfpzwh','pwh');" onblur="htjdOnBlurNotOnlyZfVal('a_xzcfpzwh','pwh');"/></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别</td>
		<td class="detailtd"><select id="a_hylbdm" onchange="hylbOnchangeAdd();"></select>
		<input type="hidden"class="inputstyle" id="a_hylb" value=""></td>
		<td class="distd" id="jcmclb_add">行政处罚类别</td>
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
		<td class="red">批准日期</td>
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
		<td class="red">执行日期</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="a_zxrq" value=""></td>
		<td class="red" id="jcfd_add">处罚结果</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="a_jcfd" value=""></td>
	</tr>
	<tr height="20">
		<td class="red">被处罚人</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="a_bjcr"
			onkeyup="htjdOnkeyupVal('a_bjcr','xingming');" onblur="htjdOnBlurNotOnlyZfVal('a_bjcr','xingming');"></td>
		<td class="red" id="qyjcrq_add">处罚日期</td>
		<td class="detailtd"><input type="text"class="inputstyle" id="a_qyjcrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="red">违规情形</td>
		<td colspan="5" class="detailtd"><textarea name="textarea" id="a_qkms" cols="55" rows="4"></textarea></td>
	</tr>
	<tr height="20">
		<td class="distd" id="yjly_add">处罚依据</td>
		<td colspan="5" class="detailtd"><textarea name="textarea" id="a_yjly" cols="55" rows="4"></textarea></td>
	</tr>
	<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setAddqyjc();'>保存</a></td></tr>
</table>