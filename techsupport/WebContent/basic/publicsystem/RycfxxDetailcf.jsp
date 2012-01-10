<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_rycfid").attr("value",dataid);
		setDetail_rycf();
		hylbOnchangeMod();
	}); 
	
	function updatediv (json) { 
		$("#ryid").append(setNull(json.LRyjcxx[0].ryid)+"&nbsp;");
		$("#rycfid").append(setNull(json.LRyjcxx[0].rycfid)+"&nbsp;");
		$("#cflb").append(setNull(json.LRyjcxx[0].cflb)+"&nbsp;");
		$("#jcmxlb").append(setNull(json.LRyjcxx[0].jcmxlb)+"&nbsp;");
		$("#qkms").append(setNull(json.LRyjcxx[0].qkms)+"&nbsp;");
		$("#yjly").append(setNull(json.LRyjcxx[0].yjly)+"&nbsp;");
		$("#jcfd").append(setNull(json.LRyjcxx[0].jcfd)+"&nbsp;");
		$("#pzjg").append(setNull(json.LRyjcxx[0].pzjg)+"&nbsp;");
		$("#pzrxm").append(setNull(json.LRyjcxx[0].pzrxm)+"&nbsp;");
		$("#zxrbh").append(setNull(json.LRyjcxx[0].zxrbh)+"&nbsp;");
		$("#zxrxm").append(setNull(json.LRyjcxx[0].zxrxm)+"&nbsp;");
		$("#ryjcrq").append(setNull(json.LRyjcxx[0].ryjcrq)+"&nbsp;");
		$("#pzrbh").append(setNull(json.LRyjcxx[0].pzrbh)+"&nbsp;");
		$("#cfdjxh_").append(setNull(json.LRyjcxx[0].cfdjxh)+"&nbsp;");
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
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			人员处罚明细
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='$("#cyryxx_detail").hideAndRemove(&quot;show&quot;);'class="close"></a>
		</td>
	</tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1">
			人员处罚登记序号
		</td>
		<td class="detailtd2" colspan="3">
			<span id="cfdjxh_"></span>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1" id="jclb_add" width="18%">
			从业人员处理类别
		</td>
		<td class="detailtd2" width="29%">
			<span id="cflb">
			
			</span>
		</td>
		<td class="distd1" id="jcmx_add" width="20%">
			处罚明细
		</td>
		<td class="detailtd2" width="33%">
			<span id="jcmxlb">
			</span>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1" id="jcfd_add">
			处罚幅度
		</td>
		<td class="detailtd2">
			<span id="jcfd"></span>
		</td>
		<td class="distd1" id="yjly_add">
			依据理由
		</td>
		<td class="detailtd2">
			<span id="yjly" ></span>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1">
			批准机构
		</td>
		<td class="detailtd2">
			<span id="pzjg"></span>
		</td>
		<td class="distd1">
			批准人编号
		</td>
		<td class="detailtd2">
			<span id="pzrbh"></span>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1">
			批准人姓名
		</td>
		<td class="detailtd2">
			<span id="pzrxm" ></span>
		</td>
		<td class="distd1">
			执行人编号
		</td>
		<td class="detailtd2">
			<span id="zxrbh" ></span>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1">
			执行人姓名
		</td>
		<td class="detailtd2">
			<span id="zxrxm" ></span>
		</td>
		<td class="distd1" id="qyjcrq_add">
			奖惩日期
		</td>
		<td class="detailtd2">
			<span id="ryjcrq"></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			违规情形
		</td>
		<td class="detailtd2" colspan="3">
			<span id="qkms" ></span>
		</td>
	</tr>

	
</table>
