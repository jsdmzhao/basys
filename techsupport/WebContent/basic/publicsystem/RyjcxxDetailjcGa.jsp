<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_rycfid").attr("value",dataid);
		setDetail_rycf();
		hylbOnchangeMod();
	}); 
	function ryxx_setDetail(){
	setParams("q_");
	jQuery.post("publicsystem/query_qyryxx.action",params,ryxx_updatediv,"json");
}
	function ryxx_updatediv (json){
		$("#cyrybh").append(setNull(json.LQyryxx[0].cyrybh)+"&nbsp;");
		$("#xm").append(setNull(json.LQyryxx[0].xm)+"&nbsp;");
		$("#zjhm").append(setNull(json.LQyryxx[0].zjhm)+"&nbsp;");
		$("#qybm").append(setNull(json.LQyryxx[0].qybm)+"&nbsp;");
		$("#xb").append(setNull(json.LQyryxx[0].xb)+"&nbsp;");
		$("#csrq").append(setNull(json.LQyryxx[0].csrq)+"&nbsp;");
		$("#shouji").append(setNull(json.LQyryxx[0].shouji)+"&nbsp;");
		$("#qymc").append(setNull(json.LQyryxx[0].qymc)+"&nbsp;");
		$("#cyrylbmc").append(setNull(json.LQyryxx[0].cyrylbmc)+"&nbsp;");
		$("#cyryzt").append(setNull(json.LQyryxx[0].cyryzt)+"&nbsp;");
	}
	function updatediv (json) { 
		$("#q_ryid").val(setNull(json.LRyjcxx[0].ryid));
		ryxx_setDetail();
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
		var cflbbm = setNull(json.LRyjcxx[0].cflbbm);
		if(cflbbm==0){
			$("#trWGQX").hide();
		}
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
			jcmx = "处罚/奖励处理类型";
			jcfd = "处罚/奖励结果";
			yjly = "处罚/奖励依据";
			qyjcrq = "处罚/奖励日期";
		}
		$('#jclb_add').text(jclb);
		$('#jcmx_add').text(jcmx);
		$('#jcfd_add').text(jcfd);
		$('#yjly_add').text(yjly);
		$('#qyjcrq_add').text(qyjcrq);
	}
</script>
<input type="hidden" id="q_rycfid">
<input type="hidden" id="q_ryid">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			人员奖惩详情
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='$("#rycfxx_detail").hideAndRemove(&quot;show&quot;);'class="close"></a>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
		    <td class="queryfont">从业人员基本信息</td>
		  </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1"  width="20%">
			从业人员编号
		</td>
		<td class="detailtd2" width="30%">
			<span id="cyrybh">
			
			</span>
		</td>
		<td class="distd1"  width="20%">
			姓名
		</td>
		<td class="detailtd2" width="30%">
			<span id="xm">
			
			</span>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1" >
			公民身份号码
		</td>
		<td class="detailtd2" >
			<span id="zjhm">
			</span>
		</td>
		<td class="distd1" >
			企业编码
		</td>
		<td class="detailtd2" >
			<span id="qybm">
			</span>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1" >
			性别
		</td>
		<td class="detailtd2" >
			<span id="xb">
			</span>
		</td>
		<td class="distd1"  >
			出生日期
		</td>
		<td class="detailtd2" >
			<span id="csrq">
			</span>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1"  >
			联系电话
		</td>
		<td class="detailtd2" >
			<span id="shouji">
			</span>
		</td>
		<td class="distd1"  >
			企业名称
		</td>
		<td class="detailtd2" >
			<span id="qymc">
			</span>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1"  >
			人员类别
		</td>
		<td class="detailtd2" >
			<span id="cyrylbmc">
			</span>
		</td>
		<td class="distd1"  >
			从业状态
		</td>
		<td class="detailtd2" >
			<span id="cyryzt">
			</span>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
		    <td class="queryfont">奖惩信息</td>
		  </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1" width="20%">
			人员处罚/奖励登记序号
		</td>
		<td class="detailtd2" colspan="3" width="80%">
			<span id="cfdjxh_"></span>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1" id="jclb_add" width="20%">
			处罚/奖励类别
		</td>
		<td class="detailtd2" width="30%">
			<span id="cflb">
			
			</span>
		</td>
		<td class="distd1" id="jcmx_add" width="20%">
			处罚/奖励处理类型
		</td>
		<td class="detailtd2" width="30%">
			<span id="jcmxlb">
			</span>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1" id="jcfd_add">
			处罚/奖励结果
		</td>
		<td class="detailtd2">
			<span id="jcfd"></span>
		</td>
		<td class="distd1" id="yjly_add">
			处罚/奖励依据
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
			处罚/奖励日期
		</td>
		<td class="detailtd2">
			<span id="ryjcrq"></span>
		</td>
	</tr>
	<tr id="trWGQX">
		<td class="distd1">
			违规情形
		</td>
		<td class="detailtd2" colspan="3">
			<span id="qkms" ></span>
		</td>
	</tr>

	
</table>
