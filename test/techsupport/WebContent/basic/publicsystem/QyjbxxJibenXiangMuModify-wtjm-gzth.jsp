<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<HTML>
<script type="text/javascript">
	$(document).ready(function() {
		$("#bq_frdbzj").selectBox({code:"dm_frdbzjlb(ylcs)",width:"118px"});
		$("#m_sfazsxt").selectBox({code:"dm_bez",width:"118px"});
		
		$("#m_thbajg").click(function(){ //特行备案机构
			getGxdw("m_thbajg","m_thbajgdm");
		});
		$("#m_jjlxmc").click(function(){ //经济类型筛选
			getDict_item("m_jjlxmc","m_jjlxbm","dm_jjlx");
		});
		
		$("#m_kyrq").attr("readonly","true").datepicker();
		$("#m_djrq").attr("readonly","true").datepicker();
		
	});

	var canCommit = true;
	function qyjbxxXiangxi_updatediv(){
		$("#m_qyzflbm").attr("value",setNull(jsonResultMes.LQyjbxx[0].qyzflbm));
		$("#m_qyzflmc").attr("value",setNull(jsonResultMes.LQyjbxx[0].qyzflmc));
		//$("#m_zabdm").attr("value",setNull(jsonResultMes.LQyjbxx[0].zabdm));
		//$("#m_zajbmc").attr("value",setNull(jsonResultMes.LQyjbxx[0].zajbmc));
		//$("#m_yyztdm").attr("value",setNull(jsonResultMes.LQyjbxx[0].yyztdm));
		//$("#m_yyztmc").attr("value",setNull(jsonResultMes.LQyjbxx[0].yyztmc));
		$("#m_frdbzjlb").attr("value",setNull(jsonResultMes.LQyjbxx[0].frdbzjlb));
		
		$("#m_qyfflbm").attr("value",setNull(jsonResultMes.LQyjbxx[0].qyfflbm));
		$("#m_qyfflmc").attr("value",setNull(jsonResultMes.LQyjbxx[0].qyfflmc));
		
		$("#m_qyid").attr("value",setNull(jsonResultMes.LQyjbxx[0].qyid));
		$("#m_qybm").attr("value",setNull(jsonResultMes.LQyjbxx[0].qybm));
		$("#m_qymc").attr("value",setNull(jsonResultMes.LQyjbxx[0].qymc));
		$("#m_gxdwmc").attr("value",setNull(jsonResultMes.LQyjbxx[0].gxdwmc));
		$("#m_gxdwbm").attr("value",setNull(jsonResultMes.LQyjbxx[0].gxdwbm));
		$("#m_qyzzjgdm").attr("value",setNull(jsonResultMes.LQyjbxx[0].qyzzjgdm));
		$("#m_lxdh").attr("value",setNull(jsonResultMes.LQyjbxx[0].lxdh));
		$("#m_yzbm").attr("value",setNull(jsonResultMes.LQyjbxx[0].yzbm));
		$("#m_chzh").attr("value",setNull(jsonResultMes.LQyjbxx[0].chzh));
		//$("#m_jwdzb").attr("value",setNull(jsonResultMes.LQyjbxx[0].jwdzb));
		$("#m_jjlxmc").attr("value",setNull(jsonResultMes.LQyjbxx[0].jjlxmc));
		$("#m_jjlxbm").attr("value",setNull(jsonResultMes.LQyjbxx[0].jjlxbm));
		$("#m_jyfwzy").attr("value",setNull(jsonResultMes.LQyjbxx[0].jyfwzy));
		$("#m_zczj").attr("value",setNull(jsonResultMes.LQyjbxx[0].zczj));
		$("#m_jymj").attr("value",setNull(jsonResultMes.LQyjbxx[0].jymj));
		//$("#m_jyfwjy").attr("value",setNull(jsonResultMes.LQyjbxx[0].jyfwjy));
		$("#m_frdb").attr("value",setNull(jsonResultMes.LQyjbxx[0].frdb));
		$("#m_frdbzjhm").attr("value",setNull(jsonResultMes.LQyjbxx[0].frdbzjhm));
		$("#m_frdblxfs").attr("value",setNull(jsonResultMes.LQyjbxx[0].frdblxfs));
		$("#m_kyrq").attr("value",setNull(jsonResultMes.LQyjbxx[0].kyrq));
		//$("#m_yysj").attr("value",setNull(jsonResultMes.LQyjbxx[0].yysj));
		$("#m_babh").attr("value",setNull(jsonResultMes.LQyjbxx[0].babh));
		$("#m_barq").attr("value",setNull(jsonResultMes.LQyjbxx[0].barq));
		$("#m_jydz").attr("value",setNull(jsonResultMes.LQyjbxx[0].jydz));
		$("#m_dwfzrzjhm").attr("value",setNull(jsonResultMes.LQyjbxx[0].dwfzrzjhm));
		$("#m_dwfzr").attr("value",setNull(jsonResultMes.LQyjbxx[0].dwfzr));
		$("#m_dwfzrlxfs").attr("value",setNull(jsonResultMes.LQyjbxx[0].dwfzrlxfs));
		//$("#m_xfshdw").attr("value",setNull(jsonResultMes.LQyjbxx[0].xfshdw));
		//$("#m_xfhgzh").attr("value",setNull(jsonResultMes.LQyjbxx[0].xfhgzh));
		//$("#m_gdxx").attr("value",setNull(jsonResultMes.LQyjbxx[0].gdxx));
		//$("#m_zdskb").attr("value",setNull(jsonResultMes.LQyjbxx[0].zdskb));
		
		//$("#m_jqbm").attr("value",setNull(jsonResultMes.LQyjbxx[0].jqbm));
		//$("#m_tyrq").attr("value",setNull(jsonResultMes.LQyjbxx[0].tyrq));
		
		//$("#m_bwbmdh").attr("value",setNull(jsonResultMes.LQyjbxx[0].bwbmdh));
		$("#m_thbajgdm").attr("value",setNull(jsonResultMes.LQyjbxx[0].thbajgdm));
		$("#m_thbajg").attr("value",setNull(jsonResultMes.LQyjbxx[0].thbajg));
		//$("#m_azsxtsl").attr("value",setNull(jsonResultMes.LQyjbxx[0].azsxtsl));
		//$("#m_sfazsxt").setValue(setNull(jsonResultMes.LQyjbxx[0].sfazsxt),115);
		//$("#m_jyxkFzjgdm").attr("value",setNull(jsonResultMes.LQyjbxx[1].jyxkFzjgdm));
		
		//营业执照、经营许可证
		$("#m_yyzzZjbh").attr("value",setNull(jsonResultMes.LQyjbxx[1].yyzzZjbh));
		$("#m_yyzzFzjg").attr("value",setNull(jsonResultMes.LQyjbxx[1].yyzzFzjg));
		$("#m_djrq").attr("value",setNull(jsonResultMes.LQyjbxx[0].djrq));
		//$("#m_yyzzQsrq").attr("value",setNull(jsonResultMes.LQyjbxx[1].yyzzQsrq));
		//$("#m_yyzzJzrq").attr("value",setNull(jsonResultMes.LQyjbxx[1].yyzzJzrq));
		
		$("#m_jyxkZjbh").attr("value",setNull(jsonResultMes.LQyjbxx[1].jyxkZjbh));
		$("#m_jyxkFzjg").attr("value",setNull(jsonResultMes.LQyjbxx[1].jyxkFzjg));
		//$("#m_jyxkQsrq").attr("value",setNull(jsonResultMes.LQyjbxx[1].jyxkQsrq));
		//$("#m_jyxkJzrq").attr("value",setNull(jsonResultMes.LQyjbxx[1].jyxkJzrq));
		
		//$("#m_thxkZjbh").attr("value",setNull(jsonResultMes.LQyjbxx[1].thxkZjbh));
		//$("#m_thxkFzjg").attr("value",setNull(jsonResultMes.LQyjbxx[1].thxkFzjg));
		//$("#m_thxkQsrq").attr("value",setNull(jsonResultMes.LQyjbxx[1].thxkQsrq));
		//$("#m_thxkJzrq").attr("value",setNull(jsonResultMes.LQyjbxx[1].thxkJzrq));
		
		$("#m_swdjZjbh").attr("value",setNull(jsonResultMes.LQyjbxx[1].swdjZjbh));
		$("#m_swdjFzjg").attr("value",setNull(jsonResultMes.LQyjbxx[1].swdjFzjg));
		//$("#m_swdjQsrq").attr("value",setNull(jsonResultMes.LQyjbxx[1].swdjQsrq));
		//$("#m_swdjJzrq").attr("value",setNull(jsonResultMes.LQyjbxx[1].swdjJzrq));
		
		//人员信息
		//$("#m_zrs").attr("value",setNull(jsonResultMes.LQyjbxx[0].zrs));
		//$("#m_hdrs").attr("value",setNull(jsonResultMes.LQyjbxx[0].hdrs));
		$("#m_bafzrxm").attr("value",setNull(jsonResultMes.LQyjbxx[0].bafzrxm));
		$("#m_bafzrgmsfhm").attr("value",setNull(jsonResultMes.LQyjbxx[0].bafzrgmsfhm));
		$("#m_bafzrdh").attr("value",setNull(jsonResultMes.LQyjbxx[0].bafzrdh));
		//$("#m_bars").attr("value",setNull(jsonResultMes.LQyjbxx[0].bars));
		//$("#m_jgpxrs").attr("value",setNull(jsonResultMes.LQyjbxx[0].jgpxrs));
		//$("#m_cksl").attr("value",setNull(jsonResultMes.LQyjbxx[0].cksl));
		//$("#m_bxbjsl").attr("value",setNull(jsonResultMes.LQyjbxx[0].bxbjsl));
		//$("#m_bagsyj").attr("value",setNull(jsonResultMes.LQyjbxx[0].bagsyj));
		$("#m_nsrq").attr("value",setNull(jsonResultMes.LQyjbxx[0].nsrq));
		$("#m_bz").attr("value",setNull(jsonResultMes.LQyjbxx[0].bz));
		//默认赋值
		$("#bq_hylb").setValue(setNull(jsonResultMes.LQyjbxx[0].hylbdm),115); //value：根据代码赋下拉框值 text：是根据内容赋下拉框值
		$("#bq_ylcsfl").setValue(setNull(jsonResultMes.LQyjbxx[0].qyzflbm),115);
		$("#bq_zajb").setValue(setNull(jsonResultMes.LQyjbxx[0].zabdm),115);
		$("#bq_frdbzj").setText(setNull(jsonResultMes.LQyjbxx[0].frdbzjlb),115);
		$("#bq_yyzt").setValue(setNull(jsonResultMes.LQyjbxx[0].yyztdm),115);
		$("#bq_hylb").setAttr("readonly","true"); //除了添加都需锁定行业类别
		$("#bq_zjzt").setValue(setNull(jsonResultMes.LQyjbxx[0].zjztdm),115);
	}
	
	function qyjbxx_modifyVerify_wtjm(){ //验证
		if (!checkControlValue("m_qymc","String",1,120,null,1,"经营名称"))
			return false;
		if (!checkControlValue("m_jydz","String",1,200,null,1,"经营地址"))
			return false;
		if (!htjdOnBlurNotOnlyZfVal('m_qyzzjgdm','jyxk','1','‘组织机构代码’','1','0')){
			return false;
		}
		if (!checkControlValue("m_qyzzjgdm","String",1,10,null,0,"组织机构代码"))
			return false;
		if (!checkControlValue("m_jyfwzy","String",1,200,null,1,"经营范围"))
			return false;
		if (!checkControlValue("m_lxdh","String",1,30,null,1,"联系电话"))
			return false;
		if (!checkControlValue("m_chzh","String",1,30,null,0,"传真"))
			return false;
		if (!checkControlValue("m_yzbm","String",1,6,null,0,"邮政编码")) //4.27 罗波提 所有非必填
			return false;
		if (!checkControlValue("m_kyrq","Date",null,null,null,1,"开业日期"))
			return false;
		if (!checkControlValue("m_jjlxmc","String",1,100,null,1,"经济类型"))
			return false;
		if (!checkControlValue("m_jymj","Float",-99999999.99,99999999.99,2,1,"占地面积(平米)"))
			return false;
		if (!checkControlValue("m_zczj","Float",-99999999.99,99999999.99,2,0,"注册资本(万元)"))
			return false;
		if (!checkControlValue("m_frdb","String",1,30,null,1,"法定代表人"))
			return false;
		if (!checkControlValue("m_frdbzjhm","String",1,30,null,1,"法人证件号码"))
			return false;
		if (!checkControlValue("m_frdblxfs","String",1,30,null,1,"法人联系方式"))
			return false;
		if (!checkControlValue("m_thbajg","String",1,60,null,1,"特行备案管理机构"))
			return false;
		if (!checkControlValue("m_yyzzZjbh","String",1,60,null,0,"营业执照编号"))
			return false;
		if (!checkControlValue("m_yyzzFzjg","String",1,60,null,0,"营业执照发证机关"))
			return false;
		if (!checkControlValue("m_djrq","Date",null,null,null,0,"营业执照发证日期"))
			return false;	
		if (!checkControlValue("m_swdjZjbh","String",1,60,null,0,"税务登记证编号"))
			return false
		if (!checkControlValue("m_swdjFzjg","String",1,60,null,0,"税务登记证发证机构名称"))
			return false;
		if (!checkControlValue("m_jyxkZjbh","String",1,60,null,0,"经营许可证编号"))
			return false;
		if (!checkControlValue("m_jyxkFzjg","String",1,60,null,0,"经营许可证发证机关"))
			return false;
		if (!checkControlValue("m_dwfzr","String",1,30,null,1,"经营负责人"))
			return false;
		if (!checkControlValue("m_dwfzrlxfs","String",1,30,null,1,"经营人联系方式"))
			return false;
		if (!checkControlValue("m_dwfzrzjhm","String",1,30,null,1,"经营负责人身份证号"))
			return false;
		if (!checkControlValue("m_bafzrxm","String",1,30,null,1,"治安负责人"))
			return false;
		if (!checkControlValue("m_bafzrgmsfhm","String",1,30,null,1,"治安负责人身份证号"))
			return false; 
		if (!checkControlValue("m_bafzrdh","String",1,30,null,1," 治安负责人联系方式"))
			return false;
		
		/*
		if (!checkControlValue("a_bwbmdh","String",1,30,null,0,"保卫部门电话"))
			return false;
		if (!checkControlValue("a_sfazsxt","Select",1,30,null,0,"是否安装摄像头"))
			return false;
		if (!checkControlValue("a_azsxtsl","Integer",0,999999,null,0,"摄像头数量"))
			return false;
		if (!checkControlValue("a_bz","String",1,2000,null,0,"备注"))
			return false;
		*/
		valadateYyzz();
		if(!canCommit)
			return false;
		if(qyjbxx_requestType=='biangeng'){
			if (!checkControlValue("m_bgyy","String",1,2000,null,1,"变更原因"))
				return false;
		}
		return true;
	}
	function valadateYyzz(){ //营业执照编号
		var yyzzZjbh = $("#m_yyzzZjbh").attr("value");
		if(yyzzZjbh!=''){
			setParams("m_");
			var sUrl="publicsystem/valadateYyzz_qyjbxx.action";
			jQuery.ajax({
				type: 'POST',
				url: sUrl,
				data: params,
				async: false,
				dataType: 'json',
				success: function(result){						
					var rows  = eval(result);
					valadateYyzzBack(rows);
				}
			});
		}
		
	}
	function valadateYyzzBack(json){
		if(json.result=="success"){
			if(json.valiResult=="1"){
				jAlert('此营业执照编号已存在!','验证信息',null,'m_yyzzZjbh');
				canCommit=false;
			}else{
				canCommit=true;
			}
		}else{
			jAlert('error!','提示信息');
			canCommit=false;
		}
	}
	var canCommit = true;
	
	function frdbzjOnchange(){ //法人证件类型
		var frdbzjlbkey = $("#bq_frdbzj").attr("value");
		var frdbzjlbval = $("#bq_frdbzj").attr("title");
		$("#m_frdbzjlb").attr("value",frdbzjlbval);
	}
	
	$("#m_frdbzjhm").blur(function(){
		var zjhmValue = $(this).val();
		var zjlxValue = $("#bq_frdbzj").val();
		if(zjlxValue=="111" || zjlxValue=="112"){
			if(!checkIdCardNo("m_frdbzjhm")){
				jAlert("“法人证件号码”不正确！","提示信息");
			}
		}
	});
	 
	$("#m_dwfzrzjhm").blur(function(){
		var zjhmValue = $(this).val();
		if(!checkIdCardNo("m_dwfzrzjhm")){
			jAlert("“经营负责人身份证码”不正确！","提示信息");
		}
	});

	$("#m_bafzrgmsfhm").blur(function(){
		var zjhmValue = $(this).val();
		if(!checkIdCardNo("m_bafzrgmsfhm")){
			jAlert("“ 治安负责人身份证号”不正确！","提示信息");
		}
	});
</script>
<BODY>

<input type="hidden" id="m_frdbzjlb"/>
<input type="hidden" id="m_zabdm"/>
<input type="hidden" id="m_jjlxbm"/>

	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr><td class="queryfont">企业基本信息</td></tr>
		<tr>
		<td valign="top" class="tdbg">
			<table width="100%" border="0" cellspacing="0" cellpadding="1">
			<tr height="25">
		        <td class="red">经营名称</td>
		        <td class="pagetd1" colspan="3"><input style="width:490px" type="text" class="inputstyle1" id="m_qymc"/></td>
		        <td class="red">企业代码</td>
				<td class="pagetd1"><input style="width:120px" type="text" class="readonly" id="m_qybm" readonly/></td>
			</tr>
			<tr height="25">
		        <td class="red">经营地址</td>
		        <td class="pagetd1" colspan="3"><input style="width:490px" type="text" class="inputstyle1" id="m_jydz"/></td>
		        <td class="pagedistd1"  >组织机构代码</td>
		        <td class="pagetd1"  ><input style="width:120px" type="text" class="inputstyle1" id="m_qyzzjgdm" maxlength="9"
					onkeyup="htjdOnkeyupVal('m_qyzzjgdm','jyxk');" onBlur="htjdOnBlurNotOnlyZfVal('m_qyzzjgdm','jyxk','0','‘组织机构代码’','1','0');"/></td>
			</tr>
			<tr height="25">
		        <td class="red">经营范围</td>
		        <td class="pagetd1" colspan="3"><input style="width:490px" type="text" class="inputstyle1" id="m_jyfwzy"/></td>
				<td class="red">联系电话</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_lxdh"/></td>
		    </tr>
			<tr height="25">
		        <td class="pagedistd1" width="12%">传真</td>
				<td class="pagetd1" width="14%"><input style="width:120px" type="text" class="inputstyle1" id="m_chzh"/></td>
		        <td class="pagedistd1" width="20%">邮政编码</td>
		        <td class="pagetd1" width="20%"><input style="width:120px" type="text" class="inputstyle1" id="m_yzbm" maxlength="6" onKeyUp="value=value.replace(/[^\d]/g,'')"/></td>
		        <td class="red" width="11%">开业日期</td>
		        <td class="pagetd1" width="15%"><input style="width:120px" type="text" class="inputstyle1" id="m_kyrq"/></td>
			</tr>
			<tr height="25">
				<td class="red">经济类型</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_jjlxmc" readonly/></td>
		        <td class="red">占地面积(平米)</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_jymj"/></td>
		        <td class="pagedistd1">注册资金(万元)</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_zczj"/></td>
			</tr>
			<tr height="25">
				<td class="red">法定代表人</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_frdb"
		        	onkeyup="htjdOnkeyupVal('m_frdb','xingming');" onBlur="htjdOnBlurNotOnlyZfVal('m_frdb','xingming','0','‘法定代表人’','1','0');"/></td>
				<td class="red">法人证件类型</td>
		        <td class="pagetd1"><select name="select4" id="bq_frdbzj" onChange="frdbzjOnchange();"></select></td>
		        <td class="red">法人证件号码</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_frdbzjhm"/></td>
			</tr>
			<tr height="25">
		        <td class="red">法人联系方式</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_frdblxfs"/></td>
		        <td class="red">特行备案管理机构</td>
				<td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_thbajg" readonly/>
					<input type="hidden" id="m_thbajgdm"/></td>
				<td class="pagedistd1" style='display:none;'>特行备案编号</td>
		        <td class="pagetd1" style='display:none;'><input style="width:120px" type="text" class="inputstyle1" id="m_babh"/></td>
				<td class="pagedistd1">营业执照编号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_yyzzZjbh"/></td>
			</tr>
			<tr height="25">
		        <td class="pagedistd1">营业执照发证机关</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_yyzzFzjg"
		        	onkeyup="htjdOnkeyupVal('m_yyzzFzjg','zhongwen');"/></td>
		        <td class="pagedistd1">营业执照发证日期</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="m_djrq"/></td>
				<td class="pagedistd1">税务登记证编号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_swdjZjbh"/></td>
			</tr>
			<tr height="25">
			    <td class="pagedistd1">税务登记证发证机关</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_swdjFzjg"
		        	onkeyup="htjdOnkeyupVal('m_swdjFzjg','zhongwen');"/></td>
				<td class="pagedistd1">经营许可证编号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_jyxkZjbh"/></td>
		        <td class="pagedistd1" nowrap>经营许可证发证机关</td>
		        <td id="jyxk_fzjgConte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_jyxkFzjg"
		        	onkeyup="htjdOnkeyupVal('m_jyxkFzjg','zhongwen');"/></td>
			</tr>
			<tr height="25">
			    <td class="red">经营负责人</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_dwfzr"
		        	onkeyup="htjdOnkeyupVal('m_dwfzr','xingming');" onBlur="htjdOnBlurNotOnlyZfVal('m_dwfzr','xingming','0','‘单位负责人’','1','0');"/></td>
		        <td class="pagedistd1" style='display:none;'>行业许可证<br>发证机构代码</td>
				<td class="pagetd1" style='display:none;'><input style="width:120px" type="text" class="inputstyle1" id="m_jyxkFzjgdm"/></td>
		        <td class="red" nowrap>经营负责人身份证号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_dwfzrzjhm"/></td>
		        <td class="red">经营负责人联系方式</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_dwfzrlxfs"/></td>
			</tr>
			<tr height="25">
			    <td class="red">治安负责人</td>
				<td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_bafzrxm"
				onkeyup="htjdOnkeyupVal('m_bafzrxm','xingming');" onBlur="htjdOnBlurNotOnlyZfVal('m_bafzrxm','xingming','0','‘治安负责人’','1','0');"/></td>
		        <td class="red" nowrap>治安负责人身份证号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_bafzrgmsfhm"/></td>
				<td class="red">治安负责人联系方式</td>
		        <td class="pagetd1" colspan="3"><input style="width:120px" type="text" class="inputstyle1" id="m_bafzrdh"/></td>
         </tr>
			<tr  style='display:none;'>
				<td class="red">保卫部门电话</td>
				<td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_bwbmdh"/></td>
				<td class="red">是否安装摄像头</td>
				<td class="pagetd1"><select id="m_sfazsxt"><option></option></select></td>
				<td class="pagedistd1">摄像头数量</td>
				<td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_azsxtsl"/></td>
			</tr>
			<tr height="25">
				<td id="bz_title" class="pagedistd1">备注</td>
				<td id="bz_conte" colspan="5" class="pagetd1"><textarea name="textarea" id="m_bz" cols="102" rows="5"></textarea></td>
			</tr>
			</table>
		</td>
		</tr>
	</table>	

</BODY>
</HTML>