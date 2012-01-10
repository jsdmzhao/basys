<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_ryid").attr("value",dataid);
		$("#a_ryid").attr("value",dataid);
		$("#a_ryjcrq").attr("readonly","true");
		$("#a_ryjcrq").datepicker();
		$("#a_zxrq").attr("readonly","true");
		$("#a_zxrq").datepicker();
		$("#a_pzrq").attr("readonly","true");
		$("#a_pzrq").datepicker();
		setDetail();
		$("#ryImage").attr("src","publicsystem/queryTp_ryjcxx.action?ryId="+dataid);
		$("#a_ryjcrq").val(TimeObject().fullYear+"-"+TimeObject().month+"-"+TimeObject().date);
		//与奖惩类别联动
		
		$("#a_cflbbm").selectBox({code:"dm_jclb"});
		$("#a_jcmxlbdm").selectBox({code:"1"});//明细 处罚
		$("#a_cflbbm").change(function(){
			if($("#a_cflbbm").val()==0){
				$("#a_jcmxlbdm").selectBox({code:"dm_ryjllb"});//明细 奖励
				$("#trWGQX").hide();
			}
			if($("#a_cflbbm").val()==1){
				$("#a_jcmxlbdm").selectBox({code:"dm_rycflb"});//明细 处罚
				$("#trWGQX").show();
			}
			if($("#a_cflbbm").val()==''){
				$("#a_jcmxlbdm").selectBox({code:"1"});//明细 处罚
				$("#trWGQX").show();
			}
		});
		$("#a_jcmxlbdm").change(function(){
			$("#a_jcmxlb").val($("#a_jcmxlbdm").attr('title'));
		});
		$("#a_pzjg").click(function(){// 管辖单位
			getGxdw("a_pzjg","a_pzjgdm");
		});
	}); 
	function updatediv (json) { 
		$("#cyrybh").append(setNull(json.LCyryxx[0].cyrybh));
		$("#a_hylb").val(setNull(json.LCyryxx[0].hylb));
		$("#a_hylbdm").val(setNull(json.LCyryxx[0].hylbdm));
		$("#xm").append(setNull(json.LCyryxx[0].xm));
		$("#minzu").append(setNull(json.LCyryxx[0].minzu));
		$("#xb").append(setNull(json.LCyryxx[0].xb));
		$("#csrq").append(setNull(json.LCyryxx[0].csrq));
		$("#hyzk").append(setNull(json.LCyryxx[0].hyzk));
		$("#hjdxz").append(setNull(json.LCyryxx[0].hjdxz));
		$("#zjhm").append(setNull(json.LCyryxx[0].zjhm));
		$("#zzzhm").append(setNull(json.LCyryxx[0].zzzhm));
		$("#zzdz").append(setNull(json.LCyryxx[0].zzdz));
		$("#shouji").append(setNull(json.LCyryxx[0].shouji));
		$("#qtlxdh").append(setNull(json.LCyryxx[0].qtlxdh));
		$("#zxr").append(setNull(json.LCyryxx[0].zxr));
		if(json.LCyryxx[0].zxsj!=null)
			$("#zxsj").append(setNull(json.LCyryxx[0].zxsj.substr(0,10)));
		if(json.LCyryxx[0].cjsj!=null)
			$("#cjsj").append(setNull(json.LCyryxx[0].cjsj.substr(0,10)));
		$("#cjr").append(setNull(json.LCyryxx[0].cjr));
		$("#hcdw").append(setNull(json.LCyryxx[0].hcdw));
		$("#zxyy").append(setNull(json.LCyryxx[0].zxyy));
		$("#cyryzt").append(setNull(json.LCyryxx[0].cyryzt));
		$("#scbz").append(setNull(json.LCyryxx[0].scbz));
		$("#csmc").append(setNull(json.LCyryxx[0].csmc));
		$("#shengao").append(setNull(json.LCyryxx[0].shengao));
		$("#tizh").append(setNull(json.LCyryxx[0].tizh));
		$("#bz").append(setNull(json.LCyryxx[0].bz));
		$("#zpwtgyy").append(setNull(json.LCyryxx[0].zpwtgyy));
		
		
		$("#a_qyid").val(setNull(json.LCyryxx[0].qyid));
		$("#qybm").append(setNull(json.LCyryxx[0].qybm));
		
		var zkzt = setNull(json.LCyryxx[0].zkzt);
		if(zkzt==11)
			$("#tr_zpwtgyy").css("display","block");
		
		hylbOnchangeAdd(setNull(json.LCyryxx[0].cyrybh));
	}	
	function addVerify(){
		$("#a_cflb").val($("#a_cflbbm").attr("title"));
		$("#a_jcmxlb").val($("#a_jcmxlbbm").attr("title"));
		if (!checkControlValue("a_cflb","String",1,100,null,1,"奖惩类别"))
			return false;
		if (!checkControlValue("a_jcmxlb","String",1,100,null,1,"奖惩明细"))
			return false;
	    if($("#a_cflbbm").val()=='' || $("#a_cflbbm").val()==1){
		    if (!checkControlValue("a_qkms","String",1,2000,null,1,"违规情形"))
			    return false;
		}
		if (!checkControlValue("a_yjly","String",1,2000,null,0,"依据理由"))
			return false;
		if (!checkControlValue("a_jcfd","String",1,100,null,0,"处罚幅度"))
			return false;
		if (!checkControlValue("a_pzjg","String",1,100,null,0,"批准机构"))
			return false;
		if (!checkControlValue("a_pzrbh","String",1,30,null,0,"批准人编号"))
			return false;
		if (!checkControlValue("a_pzrxm","String",1,100,null,0,"批准人姓名"))
			return false;
		if (!checkControlValue("a_zxrbh","String",1,30,null,0,"执行人编号"))
			return false;
		if (!checkControlValue("a_zxrxm","String",1,100,null,0,"执行人姓名"))
			return false;
		if (!checkControlValue("a_ryjcrq","Date",null,null,null,0,"处罚日期"))
			return false;
		return true;
	}
	function hylbOnchangeAdd(hylb){
		hylb=hylb.substr(0,1);
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
<input type="hidden" id="q_ryid">
<input type="hidden" id="a_cflb">
<input type="hidden" id="a_ryid">
<input type="hidden" id="a_qyid">
<input type="hidden" id="a_hylb">
<input type="hidden" id="a_hylbdm">
<input type="hidden" id="a_jcmxlb">
<div align="right">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td align="left" class="title1">
				从业人员基本信息
			</td>
			<td>
				<a href="#" id="closeDiv"
					onclick='$("#q_ryid").parent().hideAndRemove("show");' class="close"></a>
			</td>
		</tr>
		<tr>
			<td align="left"></td>
			<td></td>
		</tr>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
</div>
<table width="100%" cellpadding="4" cellspacing="0" class="detail"
	id="detail">
	<tr>
		<td width="14%" class="distd1">
			人员编号
		</td>
		<td width="24%" class="detailtd2">
			<span id="cyrybh"></span>
		</td>
		<td width="14%" class="distd1">
			姓名
		</td>
		<td width="23%" class="detailtd2">
			<span id="xm"></span>
		</td>
		<td width="24%" rowspan="15" align="center" valign="top"
			class="detailtd2">
			<table width="35%" border="0" align="center" cellpadding="8"
				cellspacing="0">
				<tr>
					<td>
						<img id="ryImage" width="150" height="180" />
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			公民身份号码
		</td>
		<td class="detailtd2" >
			<span id="zjhm"></span>
		</td>
		<td class="distd1">
			企业编码
		</td>
		<td class="detailtd2" >
			<span id="qybm"></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			性别
		</td>
		<td class="detailtd2">
			<span id="xb"></span>
		</td>
		<td class="distd1">
			出生日期
		</td>
		<td class="detailtd2">
			<span id="csrq"></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			民族
		</td>
		<td class="detailtd2">
			<span id="minzu"></span>
		</td>
		<td class="distd1">
			婚姻状况
		</td>
		<td class="detailtd2">
			<span id="hyzk"></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			联系电话
		</td>
		<td class="detailtd2">
			<span id="shouji"></span>
		</td>
		<td class="distd1">
			服务单位
		</td>
		<td class="detailtd2">
			<span id="csmc"></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			户籍地详址
		</td>
		<td colspan="3" class="detailtd2">
			<span id="hjdxz"></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			紧急联系电话
		</td>
		<td class="detailtd2">
			<span id="qtlxdh"></span>
		</td>
		<td class="distd1">
			暂住证号码
		</td>
		<td class="detailtd2">
			<span id="zzzhm"></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			暂住地址
		</td>
		<td colspan="3" class="detailtd2">
			<span id="zzdz"></span>
		</td>
	</tr>
</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
  <table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
    <tr>
      <td class="queryfont">奖惩信息</td>
    </tr>
    <tr>
      <td class="tdbg">
<table width="100%" id="add" border="0">
	<tr height="20">
		<td class="red" width="10%" id="jclb_add">
			奖惩类别
		</td>
		<td class="detailtd" width="23%">
			<select type="select" id="a_cflbbm">
				<option></option>
			</select>
		</td>
		<td class="red" width="10%" id="jcmx_add">
			奖惩明细
		</td>
		<td class="detailtd" width="23%">
			<select type="select" id="a_jcmxlbdm">
				<option></option>
			</select>
		</td>
		<td class="distd" width="10%" id="qyjcrq_add">
			奖惩日期
		</td>
		<td class="detailtd" width="24%">
			<input type="text" class="inputstyle"  id="a_ryjcrq" value="">
		</td>
	</tr>
	
	<tr height="20">
		<td class="distd">
			批准人姓名
		</td>
		<td class="detailtd">
			<input type="text"  class="inputstyle" id="a_pzrxm"
				onkeyup="htjdOnkeyupVal('a_pzrxm','xingming');" onblur="htjdOnBlurNotOnlyZfVal('a_pzrxm','xingming');">
		</td>
		<td class="distd">
			批准人编号
		</td>
		<td class="detailtd">
			<input type="text"  class="inputstyle"  id="a_pzrbh"
				onkeyup="htjdOnkeyupVal('a_pzrbh','shuzi');" onblur="htjdOnBlurNotOnlyZfVal('a_pzrbh','shuzi');">
		</td>
		<td class="distd">
			批准机构
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="a_pzjg">
		</td>
	</tr>
	<tr>	
		<td>
			批准机构代码
		</td>
		<td class="detailtd">
			<input type="text"  class="readonly"  id="a_pzjgdm" value="" readonly>
		</td>
		<td class="distd" width="10%">
			行政奖惩批准文号
		</td>
		<td class="detailtd">
			<input type="text"  class="inputstyle"  id="a_xzcfpzwh" value="">
		</td>
		<td class="distd" width="10%" >批准日期</td>
		<td class="detailtd" width="24%">
			<input type="text" class="inputstyle"  id="a_pzrq" value="">
		</td>
	</tr>
	<tr height="20">
		<td class="distd">
			执行人姓名
		</td>
		<td class="detailtd">
			<input type="text"  class="inputstyle"  id="a_zxrxm"
				onkeyup="htjdOnkeyupVal('a_zxrxm','xingming');" onblur="htjdOnBlurNotOnlyZfVal('a_zxrxm','xingming');">
		</td>
		<td class="distd">
			执行人编号
		</td>
		<td class="detailtd">
			<input type="text"  class="inputstyle"  id="a_zxrbh"
				onkeyup="htjdOnkeyupVal('a_zxrbh','shuzi');" onblur="htjdOnBlurNotOnlyZfVal('a_zxrbh','shuzi');">
		</td>
		<td class="distd" width="10%">
			执行日期
		</td>
		<td class="detailtd" width="24%">
			<input type="text" class="inputstyle"  id="a_zxrq" value="">
		</td>
	</tr>
	<tr height="20" id="trWGQX">
		<td class="red">
			违规情形
		</td>
		<td class="detailtd" colspan="5">
			<input type="text" id="a_qkms" class="inputstyle3"  value="" style="width:690px">
		</td>
	</tr>
	<tr>
		<td class="distd" id="yjly_add">
			依据理由
		</td>
		<td class="detailtd" colspan="5">
			<input type="text" id="a_yjly" class="inputstyle3" value="" style="width:690px">
		</td>
	</tr>
	<tr height="20">
		<td class="distd" id="jcfd_add">
			奖惩幅度
		</td>
		<td class="detailtd" colspan="5">
			<input type="text" id="a_jcfd" value="" class="inputstyle3" style="width:690px">
		</td>
	</tr>
	<tr height="25" align="center">
		<td colspan="6">
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="保存" onclick='setAdd();'>保存</a>
		</td>
	</tr>
</table>
</td>
</tr>
</table>