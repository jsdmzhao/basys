
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_rycfid").attr("value",dataid);
		$("#m_ryjcrq").attr("readonly","true");
		$("#m_ryjcrq").datepicker();	
		setDetail_rycf();
		$("#m_cflbbm").selectBox({code:"dm_jclb"});
		$("#m_jcmxlbdm").selectBox({code:"1"});//明细 处罚
		$("#m_cflbbm").change(function(){
			if($("#m_cflbbm").val()==0){
				$("#m_jcmxlbdm").selectBox({code:"dm_ryjllb"});//明细 奖励
			}
			if($("#m_cflbbm").val()==1){
				$("#m_jcmxlbdm").selectBox({code:"dm_rycflb"});//明细 处罚
			}
			if($("#m_cflbbm").val()==''){
				$("#m_jcmxlbdm").selectBox({code:"1"});//明细 处罚
			}
		});
		
		$("#m_jcmxlbdm").change(function(){
			$("#m_jcmxlb").val($("#m_jcmxlbdm").attr('title'));
		});
		hylbOnchangeMod();
		$("#m_pzjg").click(function(){// 管辖单位
			getGxdw("m_pzjg","m_pzjgdm");
		});
	}); 
	

	function updatediv (json) { 
		$("#m_cflb").attr("value",setNull(json.LRyjcxx[0].cflb));
	
		$("#m_cflbbm").setValue(setNull(json.LRyjcxx[0].cflbbm));
		
			if($("#m_cflbbm").val()=='0'){
				$("#m_jcmxlbdm").selectBox({code:"dm_ryjllb"});//明细 奖励
			}
			if($("#m_cflbbm").val()==1){
				$("#m_jcmxlbdm").selectBox({code:"dm_rycflb"});//明细 处罚
			}
			if($("#m_cflbbm").val()==''){
				$("#m_jcmxlbdm").selectBox({code:"1"});//明细 处罚
			}
		$("#m_cfdjxh").attr("value",setNull(json.LRyjcxx[0].cfdjxh));
		$("#m_qkms").attr("value",setNull(json.LRyjcxx[0].qkms));
		$("#m_yjly").attr("value",setNull(json.LRyjcxx[0].yjly));
		$("#m_jcfd").attr("value",setNull(json.LRyjcxx[0].jcfd));
		$("#m_pzjgdm").attr("value",setNull(json.LRyjcxx[0].pzjgdm));
		$("#m_pzjg").attr("value",setNull(json.LRyjcxx[0].pzjg));
		$("#m_pzrbh").attr("value",setNull(json.LRyjcxx[0].pzrbh));
		$("#m_pzrxm").attr("value",setNull(json.LRyjcxx[0].pzrxm));
		$("#m_zxrbh").attr("value",setNull(json.LRyjcxx[0].zxrbh));
		$("#m_zxrxm").attr("value",setNull(json.LRyjcxx[0].zxrxm));
		$("#m_ryjcrq").attr("value",setNull(json.LRyjcxx[0].ryjcrq));
		$("#m_jcmxlb").attr("value",setNull(json.LRyjcxx[0].jcmxlb));
		$("#m_jcmxlbdm").setValue(setNull(json.LRyjcxx[0].jcmxlbdm)); 
	}	
	function modifyVerify(){
		if (!checkControlValue("m_cflbbm","Select",1,4,null,0,"处罚类别代码"))
			return false;
		if (!checkControlValue("m_cflb","String",1,100,null,0,"处罚类别"))
			return false;
		if (!checkControlValue("m_qkms","String",1,2000,null,1,"违规情形"))
			return false;
		if (!checkControlValue("m_yjly","String",1,2000,null,0,"依据理由"))
			return false;
		if (!checkControlValue("m_jcfd","String",1,100,null,0,"处罚幅度"))
			return false;
		if (!checkControlValue("m_pzjgdm","String",1,20,null,0,"批准机构代码"))
			return false;
		if (!checkControlValue("m_pzjg","String",1,100,null,0,"批准机构"))
			return false;
		if (!checkControlValue("m_pzrbh","String",1,30,null,0,"批准人编号"))
			return false;
		if (!checkControlValue("m_pzrxm","String",1,100,null,0,"批准人姓名"))
			return false;
		if (!checkControlValue("m_zxrbh","String",1,30,null,0,"执行人编号"))
			return false;
		if (!checkControlValue("m_zxrxm","String",1,100,null,0,"执行人姓名"))
			return false;
		if (!checkControlValue("m_ryjcrq","Date",null,null,null,0,"处罚日期"))
			return false;
			
		$("#m_cflb").val($("#m_cflbbm").attr("title"));	
		$("#m_jcmxlb").val($("#m_jcmxlbdm").attr("title"));	
			
		return true;
	}
	
function setRycfUpdate(){
	if (modifyVerify()){
		setParams("m_");
		jQuery.post(cf_modUrl,params,updateback_rycf,"json"); 
		return true;
	}else{
		return false;
	}	
}

function updateback_rycf(json){
	if  (json.result=="success"){
		jAlert(modMessage,'保存信息');
		setPageList($("#pageNo").attr("value"));
		$("#"+cf_detailid).hideAndRemove("slow"); 
	}else{
		jAlert(json.result,'错误信息');
	}		
}
	
	function hylbOnchangeMod(){
		var hylb=$("#p_hylbdm").val();
		var jclb = "奖惩类别";
		var jcmx = "奖惩明细";
		var jcfd = "奖惩幅度";
		var yjly = "依据理由";
		var qyjcrq = "奖惩日期";
		if(hylb=='J'||hylb=='H'){
			jclb = "处罚/奖励类别";
			jcmx = "从业人员处理类型";
			jcfd = "处罚结果";
			yjly = "处罚依据";
			qyjcrq = "处罚日期";
		}
		//$('#jclb_add').text(jclb);
		$('#jcmx_add').text(jcmx);
		$('#jcfd_add').text(jcfd);
		$('#yjly_add').text(yjly);
		$('#qyjcrq_add').text(qyjcrq);
	}
</script>
<input type="hidden" id="q_rycfid">
<input type="hidden" id="m_cflb">
<input type="hidden" id="m_pzjgdm">
<input type="hidden" id="m_jcmxlb">
<div style="display:none">
<select type="select" id="m_cflbbm">
			
			</select>
</div>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			人员处罚信息修改
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='$("#rycfxx_detail").hideAndRemove("show");'class="close"></a>
		</td>
	</tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="red" id="jclb_add">
			人员处罚登记序号
		</td>
		<td class="detailtd" colspan="3">
			<input type="text" id="m_cfdjxh" class="readonly" style="width: 417px" />
		</td>
		</tr>
		<tr>
		<td class="red" id="jcmx_add">
			奖惩明细
		</td>
		<td class="detailtd" colspan="3">
			<select id="m_jcmxlbdm">
			</select>
		</td>
	</tr>
	<tr height="20">
		<td class="distd" id="jcfd_add" width="19%">
			处罚幅度
		</td>
		<td class="detailtd" width="28%">
			<input type="text" id="m_jcfd" value="">
		</td>
		<td class="distd" id="yjly_add" width="20%" >
			依据理由
		</td>
		<td class="detailtd" width="33%">
			<input type="text" id="m_yjly" value="">
		</td>
	</tr>
	<tr height="20">
		<td class="distd">
			批准机构
		</td>
		<td class="detailtd">
			<input type="text" id="m_pzjg" readonly>
		</td>
		<td class="distd">
			批准人编号
		</td>
		<td class="detailtd">
			<input type="text" id="m_pzrbh"
				onkeyup="htjdOnkeyupVal('m_pzrbh','shuzi');" onblur="htjdOnBlurNotOnlyZfVal('m_pzrbh','shuzi');">
		</td>
	</tr>
	<tr height="20">
		<td class="distd">
			批准人姓名
		</td>
		<td class="detailtd">
			<input type="text" id="m_pzrxm"
				onkeyup="htjdOnkeyupVal('m_pzrxm','xingming');" onblur="htjdOnBlurNotOnlyZfVal('m_pzrxm','xingming');">
		</td>
		<td class="distd">
			执行人编号
		</td>
		<td class="detailtd">
			<input type="text" id="m_zxrbh"
				onkeyup="htjdOnkeyupVal('m_zxrbh','shuzi');" onblur="htjdOnBlurNotOnlyZfVal('m_zxrbh','shuzi');">
		</td>
	</tr>
	<tr height="20">
		<td class="distd">
			执行人姓名
		</td>
		<td class="detailtd">
			<input type="text" id="m_zxrxm"
				onkeyup="htjdOnkeyupVal('m_zxrxm','xingming');" onblur="htjdOnBlurNotOnlyZfVal('m_zxrxm','xingming');">
		</td>
		<td class="distd" id="qyjcrq_add">
			处罚日期
		</td>
		<td class="detailtd">
			<input type="text" id="m_ryjcrq" value="">
		</td>
	</tr>
	<tr>
		<td class="red">
			违规情形
		</td>
		<td class="detailtd" colspan="3">
			<input style="width: 417px" type="text" id="m_qkms"  value="">
		</td>
	</tr>
	<tr height="25" align="center">
		<td colspan="4">
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="保存" onclick='setRycfUpdate();'>保存</a>
		</td>
	</tr>
</table>
