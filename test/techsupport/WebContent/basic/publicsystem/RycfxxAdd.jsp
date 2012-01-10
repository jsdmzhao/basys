<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_ryjcrq").attr("readonly","true");
		$("#a_ryjcrq").datepicker();
		$("#a_zxrq").attr("readonly","true");
		$("#a_zxrq").datepicker();
		$("#a_pzrq").attr("readonly","true");
		$("#a_pzrq").datepicker();
		$("#a_ryjcrq").val(TimeObject().fullYear+"-"+TimeObject().month+"-"+TimeObject().date);
		$("#ryImage").attr("src","images/pic.gif");
		//与奖惩类别联动
		$("#a_hylbdm").selectBoxhylb();//行业类别	
		$("#a_cflbbm").selectBox({code:"dm_jclb"});
		$("#a_cflbbm").setValue("1");
		$("#a_cflbbm").setAttr("readonly",true);
		$("#a_jcmxlbdm").selectBox({code:"dm_rycflb"});//明细 处罚
		
		$("#a_jcmxlbdm").change(function(){
			$("#a_jcmxlb").val($("#a_jcmxlbdm").attr('title'));
		});
		$("#a_pzjg").click(function(){// 管辖单位
			getGxdw("a_pzjg","a_pzjgdm");
		});
		hylbOnchangeAdd();
	}); 
	function updatediv (json) { 
		$("#minzu").attr("value",setNull(json.LCyryxx[0].minzu));
		$("#xb").attr("value",setNull(json.LCyryxx[0].xb));
		$("#csrq").attr("value",setNull(json.LCyryxx[0].csrq));
		$("#hyzk").attr("value",setNull(json.LCyryxx[0].hyzk));
		$("#hjdxz").attr("value",setNull(json.LCyryxx[0].hjdxz));
		$("#zjhm").attr("value",setNull(json.LCyryxx[0].zjhm));
		$("#zzzhm").attr("value",setNull(json.LCyryxx[0].zzzhm));
		$("#zzdz").attr("value",setNull(json.LCyryxx[0].zzdz));
		$("#shouji").attr("value",setNull(json.LCyryxx[0].shouji));
		$("#qtlxdh").attr("value",setNull(json.LCyryxx[0].qtlxdh));
		$("#zxr").attr("value",setNull(json.LCyryxx[0].zxr));
		if(json.LCyryxx[0].zxsj!=null)
			$("#zxsj").attr("value",setNull(json.LCyryxx[0].zxsj.substr(0,10)));
		if(json.LCyryxx[0].cjsj!=null)
			$("#cjsj").attr("value",setNull(json.LCyryxx[0].cjsj.substr(0,10)));
		$("#cjr").attr("value",setNull(json.LCyryxx[0].cjr));
		$("#hcdw").attr("value",setNull(json.LCyryxx[0].hcdw));
		$("#zxyy").attr("value",setNull(json.LCyryxx[0].zxyy));
		$("#cyryzt").attr("value",setNull(json.LCyryxx[0].cyryzt));
		$("#scbz").attr("value",setNull(json.LCyryxx[0].scbz));
		$("#csmc").attr("value",setNull(json.LCyryxx[0].csmc));
		$("#shengao").attr("value",setNull(json.LCyryxx[0].shengao));
		$("#tizh").attr("value",setNull(json.LCyryxx[0].tizh));
		$("#bz").attr("value",setNull(json.LCyryxx[0].bz));
		$("#zpwtgyy").attr("value",setNull(json.LCyryxx[0].zpwtgyy));

		var zkzt = setNull(json.LCyryxx[0].zkzt);
		if(zkzt==11)
			$("#tr_zpwtgyy").css("display","block");
	}	
	function addVerify(){
		$("#a_cflb").val($("#a_cflbbm").attr("title"));
		$("#a_jcmxlb").val($("#a_jcmxlbbm").attr("title"));
		if (!checkControlValue("a_jcmxlbdm","Select",1,100,null,1,"奖惩明细"))
			return false;
		if (!checkControlValue("a_qkms","String",1,2000,null,1,"违规情形"))
			return false;
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
	function hylbOnchangeAdd(){
		var hylb=$("#a_hylbdm").attr("value");
		var jclb = "奖惩类别";
		var jcmx = "奖惩明细";
		var jcfd = "奖惩幅度";
		var yjly = "依据理由";
		var qyjcrq = "奖惩日期";
		if(hylb=='J'||hylb=='H'){
			jclb = "处罚类别";
			jcmx = "从业人员处理类型";
			jcfd = "处罚结果";
			yjly = "处罚依据";
			qyjcrq = "处罚日期";
			$('#atd_qymc').text('娱乐服务场所名称');
			$('#atd_qybm').text('娱乐服务场所备案编号');
		}else{
			$('#atd_qymc').text('企业名称');
		    $('#atd_qybm').text('企业编号');
		}
		//$('#jclb_add').text(jclb);
		$('#jcmx_add').text(jcmx);
		$('#jcfd_add').text(jcfd);
		$('#yjly_add').text(yjly);
		$('#qyjcrq_add').text(qyjcrq);

	}

	$("#a_qymc").click(function(){
	 	//判断行业类型选择了没，如果没有选择，需要先选择
		if (!checkControlValue("a_hylbdm","Select",1,100,null,1,"行业类别")){
		 		return false;
		}else{    ///娱乐业
		 	dataid=$('#a_hylbdm').val();
		  	getTy_item("a_qymc","a_qybm","a_qyid","kcyzx");
		}
	});
	$("#a_qyid").bind("propertychange",function(){
		$('#xm').val("");
		$('#cyrybh').val("");
	});
	$('#xm').click(function(){
		var qybm=$('#a_qybm').val()
		if(qybm!=""){
			getQyry_item("xm","cyrybh",qybm,"a_ryid");
		}else{
			var hylb=$("#a_hylbdm").attr("value");
			if(hylb=='J'||hylb=='H'){
				jAlert("请先选择场所",'提示信息');
			}else{
				jAlert("请先选择企业",'提示信息');
			}
		}	
	});
	$("#a_ryid").bind("propertychange",function(){
		dataid=$("#a_ryid").val();
		$("#q_ryid").attr("value",dataid);
		setDetail();
		$("#ryImage").attr("src","publicsystem/queryTp_ryjcxx.action?ryId="+dataid);
	});
</script>
<input type="hidden" id="q_ryid">
<input type="hidden" id="a_cflb">
<input type="hidden" id="a_ryid">
<input type="hidden" id="a_qyid">
<input type="hidden" id="a_hylb">
<input type="hidden" id="a_jcmxlb">
<div style="display:none">
<select id="a_cflbbm">
	<option></option>
</select>
</div>
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
<table width="100%" cellpadding="4" cellspacing="0" id="detail">
	<tr>
		<td width="14%"  class="red">行业类别</td>
		<td width="57%" class="detailtd" colspan="3"><input type="hidden" id="a_hylb" /><select id="a_hylbdm" onchange="hylbOnchangeAdd();"></select></td>
		<td  rowspan="15" align="center" valign="top" class="detailtd" colspan="2">
			<table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
				<tr>
					<td>
						<img id="ryImage" width="150" height="180" />
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td class="red" id="atd_qymc">企业名称</td>
		<td class="detailtd"  ><input type="text" class="inputstyle" id="a_qymc" readonly="readonly" /></td>
		<td class="distd" id="atd_qybm">企业编号</td>
		<td class="detailtd" ><input type="text" class="readonly" id="a_qybm" readonly="readonly" /></td>
	</tr>
	<tr>
		<td class="red">
			姓名
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="xm" readonly="readonly">
		</td>
		<td  class="distd">
			人员编号
		</td>
		<td  class="detailtd">
			<input type="text" class="readonly" id="cyrybh" readonly="readonly">
		</td>
	</tr>
	<tr>
		<td class="distd">
			公民身份号码
		</td>
		<td class="detailtd" >
			<input type="text" class="readonly" id="zjhm" readonly="readonly">
		</td>
		<td class="distd">
			性别
		</td>
		<td class="detailtd">
			<input type="text" class="readonly" id="xb" readonly="readonly">
		</td>
	</tr>
	<tr>
		<td class="distd">
			出生日期
		</td>
		<td class="detailtd">
			<input type="text" class="readonly" id="csrq" readonly="readonly">
		</td>
		<td class="distd">
			民族
		</td>
		<td class="detailtd">
			<input type="text" class="readonly" id="minzu" readonly="readonly">
		</td>
	</tr>
	<tr>
		<td class="distd">
			婚姻状况
		</td>
		<td class="detailtd">
			<input type="text" class="readonly" id="hyzk" readonly="readonly">
		</td>
		<td class="distd">
			联系电话
		</td>
		<td class="detailtd">
			<input type="text" class="readonly" id="shouji" readonly="readonly">
		</td>
	</tr>
	<tr>
		<td class="distd">
			户籍地详址
		</td>
		<td class="detailtd">
			<input type="text" class="readonly" id="hjdxz" readonly="readonly">
		</td>
		<td class="distd">
			紧急联系电话
		</td>
		<td class="detailtd">
			<input type="text" class="readonly" id="qtlxdh" readonly="readonly">
		</td>
	</tr>
	<tr>
		<td class="distd">
			暂住地址
		</td>
		<td class="detailtd">
			<input type="text" class="readonly" id="zzdz" readonly="readonly">
		</td>
		<td class="distd">
			暂住证号码
		</td>
		<td class="detailtd">
			<input type="text" class="readonly" id="zzzhm" readonly="readonly">
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
      <td class="queryfont">人员处罚信息</td>
    </tr>
    <tr>
      <td class="tdbg">
<table width="100%" id="add" border="0">
	<tr height="20">
		<td class="red" width="14%" id="jclb_add">
			人员处罚登记序号
		</td>
		<td class="detailtd" width="20%">
			<input type="text" class="readonly" />
		</td>
		<td class="red" width="14%" id="jcmx_add">
			奖惩明细
		</td>
		<td class="detailtd" width="20%">
			<select type="select" id="a_jcmxlbdm">
				<option></option>
			</select>
		</td>
		<td class="distd" width="10%" id="qyjcrq_add">
			奖惩日期
		</td>
		<td class="detailtd" width="22%">
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
			<input type="text" class="inputstyle" id="a_pzjg" readonly="readonly">
		</td>
	</tr>
	<tr>	
		<td class="distd">
			批准机构代码
		</td>
		<td class="detailtd">
			<input type="text"  class="readonly"  id="a_pzjgdm" value="" readonly="readonly">
		</td>
		<td class="distd">
			行政处罚批准文号
		</td>
		<td class="detailtd">
			<input type="text"  class="inputstyle"  id="a_xzcfpzwh" value="">
		</td>
		<td class="distd">批准日期</td>
		<td class="detailtd">
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
		<td class="distd">
			执行日期
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle"  id="a_zxrq" value="">
		</td>
	</tr>
	<tr height="20">
		<td class="red">
			违规情形
		</td>
		<td class="detailtd" colspan="5">
			<input type="text" id="a_qkms" class="inputstyle3"  value="" style="width:673px">
		</td>
	</tr>
	<tr>
		<td class="distd" id="yjly_add">
			依据理由
		</td>
		<td class="detailtd" colspan="5">
			<input type="text" id="a_yjly" class="inputstyle3" value="" style="width:673px">
		</td>
	</tr>
	<tr height="20">
		<td class="distd" id="jcfd_add">
			奖惩幅度
		</td>
		<td class="detailtd" colspan="5">
			<input type="text" id="a_jcfd" value="" class="inputstyle3" style="width:673px">
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