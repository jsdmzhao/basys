<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<HTML>
<script type="text/javascript">
	$(document).ready(function() {
		$("#bq_frdbzj").selectBox({code:"dm_frdbzjlb(ylcs)",width:"118px"});
		//$("#bq_yyzt").selectBox({code:"dm_yyzt(ylcs)",width:"118px"});
		//$("#bq_zajb").selectBox({code:"dm_cszajb",width:"118px"});
		
		$("#m_thbajg").click(function(){ //特行备案机构
			getGxdw("m_thbajg","m_thbajgdm");
		});
		$("#m_jjlxmc").click(function(){ //经济类型筛选
			getDict_item("m_jjlxmc","m_jjlxbm","dm_jjlx");
		});
		
		$("#m_kyrq").attr("readonly","true").datepicker();
		//$("#m_barq").attr("readonly","true").datepicker();
		//$("#m_yyzzQsrq").attr("readonly","true").datepicker();
		//$("#m_yyzzJzrq").attr("readonly","true").datepicker();
		//$("#m_jyxkQsrq").attr("readonly","true").datepicker();
		//$("#m_jyxkJzrq").attr("readonly","true").datepicker();
		//$("#m_thxkQsrq").attr("readonly","true").datepicker();
		//$("#m_thxkJzrq").attr("readonly","true").datepicker();
		//$("#m_swdjQsrq").attr("readonly","true").datepicker();
		//$("#m_swdjJzrq").attr("readonly","true").datepicker();
		$("#m_nsrq").attr("readonly","true").datepicker();
	});
	
	$("#m_frdbzjhm").blur(function(){//法人证件号码
	    var sfzh = $("#m_frdbzjhm").val();
	    if(sfzh==''){
	        return true;
	    }
		var returnCardNo = checkIdCardNo("m_frdbzjhm");
		if(returnCardNo){
			
		}else{
			jAlert("法人证件号码不正确","验证信息");
		}
	});
	$("#m_dwfzrzjhm").blur(function(){//经营负责人身份证号
	    var sfzh = $("#m_dwfzrzjhm").val();
	    if(sfzh==''){
	        return true;
	    }
		var returnCardNo = checkIdCardNo("m_dwfzrzjhm");
		if(returnCardNo){
			
		}else{
			jAlert("经营负责人身份证号不正确","验证信息");
		}
	});
	$("#m_bafzrgmsfhm").blur(function(){//治安负责人身份证号
	    var sfzh = $("#m_bafzrgmsfhm").val();
	    if(sfzh==''){
	        return true;
	    }
		var returnCardNo = checkIdCardNo("m_bafzrgmsfhm");
		if(returnCardNo){
			
		}else{
			jAlert("治安负责人身份证号不正确","验证信息");
		}
	});
	
	function qyjbxx_modifyVerify_fjjs(){ //验证
		if (!checkControlValue("m_qymc","String",1,120,null,1,"经营者名称"))
			return false;
		if (!checkControlValue("m_jydz","String",1,200,null,1,"经营地址"))
			return false;
		if(!yanzhengJhltlx()){
			return false;
		}
		if (!htjdOnBlurNotOnlyZfVal('m_qyzzjgdm','jyxk','1','‘组织机构代码’','1','0')){
			return false;
		}
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
		if (!checkControlValue("m_jymj","Float",-99999999.99,99999999.99,2,1,"占地面积"))
			return false;
		if (!checkControlValue("m_zczj","Float",-99999999.99,99999999.99,2,0,"注册资金"))
			return false;
		if (!checkControlValue("m_frdb","String",1,30,null,1,"法定代表人"))
			return false;
		if (!checkControlValue("m_frdbzjhm","String",1,30,null,1,"法人证件号码"))
			return false;
		if (!checkControlValue("m_frdblxfs","String",1,30,null,1,"法人联系方式"))
			return false;
		if (!checkControlValue("m_babh","String",1,30,null,1,"再生资源回收备案登记证号"))
			return false;
		if (!checkControlValue("m_thbajg","String",1,60,null,1,"再生资源回收备案登记发证公安机关"))
			return false;	
		if (!checkControlValue("m_yyzzZjbh","String",1,60,null,0,"营业执照编号"))
			return false;
		if (!checkControlValue("m_yyzzFzjg","String",1,60,null,0,"营业执照发证机关"))
			return false;
		if (!checkControlValue("m_swdjZjbh","String",1,60,null,0,"税务登记证编号"))
			return false;
		if (!checkControlValue("m_swdjFzjg","String",1,60,null,0,"税务登记证发证机关"))
			return false;
		if (!checkControlValue("m_jyxkZjbh","String",1,60,null,0,"经营许可证编号"))
			return false;
		if (!checkControlValue("m_jyxkFzjg","String",1,60,null,0,"经营许可证发证机关"))
			return false;
		if (!checkControlValue("m_dwfzr","String",1,30,null,1,"经营负责人"))
			return false;
		if (!checkControlValue("m_dwfzrzjhm","String",1,30,null,1,"经营负责人身份证号"))
			return false;
		if (!checkControlValue("m_dwfzrlxfs","String",1,30,null,1,"经营负责人联系方式"))
			return false;
		if (!checkControlValue("m_bafzrxm","String",1,30,null,1,"治安负责人"))
			return false;
		if (!checkControlValue("m_bafzrgmsfhm","String",1,30,null,1,"治安负责人身份证号"))
			return false;
		if (!checkControlValue("m_bafzrdh","String",1,30,null,1,"治安负责人联系方式"))
			return false;
		if (!checkControlValue("m_nsrq","Date",null,null,null,1,"年审日期"))
			return false;	
		if (!checkControlValue("m_bz","String",1,2000,null,0,"备注"))
			return false;
/*
		if (!checkControlValue("m_jyfwjy","String",1,200,null,0,"经营范围(兼营)"))
			return false;
		if (!checkControlValue("m_yysj","String",1,20,null,0,"营业时间"))
			return false;
		if (!checkControlValue("m_yyzzQsrq","Date",null,null,null,1,"营业执照起始日期"))
			return false;
		if (!checkControlValue("m_yyzzJzrq","Date",null,null,null,1,"营业执照截止日期"))
			return false;
		if (!checkControlValue("m_swdjQsrq","Date",null,null,null,1,"税务登记证起始日期"))
			return false;
		if (!checkControlValue("m_swdjJzrq","Date",null,null,null,1,"税务登记证截止日期"))
			return false;
		if (!checkControlValue("m_thxkZjbh","String",1,60,null,0,"特行许可证编号"))
			return false;
		if (!checkControlValue("m_thxkFzjg","String",1,60,null,0,"特行许可证发证机关"))
			return false;
		if (!checkControlValue("m_xfhgzh","String",1,20,null,0,"消防合格证号"))
			return false;
		if (!checkControlValue("m_xfshdw","String",1,200,null,0,"消防审核单位"))
			return false;
		if (!checkControlValue("m_jwdzb","String",1,100,null,0,"经纬度坐标"))
			return false;
		if (!checkControlValue("m_jqbm","String",1,10,null,0,"机器编码"))
			return false;
		if (!checkControlValue("m_hdrs","Integer",0,999999,null,0,"核定人数"))
			return false;
		if (!checkControlValue("m_bafzrxm","String",1,30,null,0,"治安负责人"))
			return false;
		if (!checkControlValue("m_bars","Integer",0,999999,null,0,"保安人数"))
			return false;
		if (!checkControlValue("m_jgpxrs","Integer",0,999999,null,0,"经岗位培训人数"))
			return false;
		if (!checkControlValue("m_bagsyj","String",1,2000,null,0,"保安公司意见"))
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
		if(yyzzZjbh==''){
			//canCommit=false;
			//jAlert('请正确输入营业执照编号!','验证信息',null,'m_yyzzZjbh');
			return;
		}
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
		
		$("#m_sgscxfjjs").attr("value",setNull(jsonResultMes.LQyjbxx[0].sgscxfjjs));
		$("#m_jhltlxdm").attr("value",setNull(jsonResultMes.LQyjbxx[0].jhltlxdm));
		$("#m_jhltlxmc").attr("value",setNull(jsonResultMes.LQyjbxx[0].jhltlxmc));
	}
	function fjjsPramSelInit(){
		var sgscxfjjs = setNull(jsonResultMes.LQyjbxx[0].sgscxfjjs);
		if(sgscxfjjs=='1'){
			sgscxfjjs = "是";
			$("#scjsYes").attr("checked",true);
		}
		if(sgscxfjjs=='0'){
			sgscxfjjs = "否";
			$("#scjsNo").attr("checked",true);
		}
		var jhltlxdm = setNull(jsonResultMes.LQyjbxx[0].jhltlxdm);
		var jhltlxArr = jhltlxdm.split(",");
		for(var index=0;index<jhltlxArr.length;index++){
			$("#jhltlx_"+jhltlxArr[index]).attr("checked",true);
		}
	}
	function frdbzjOnchange(){ //法人证件类型
		var frdbzjlbkey = $("#bq_frdbzj").attr("value");
		var frdbzjlbval = $("#bq_frdbzj").attr("title");
		$("#m_frdbzjlb").attr("value",frdbzjlbval);
	}
	function zajbOnchange(){ //治安等级
		var zajbkey = $("#bq_zajb").attr("value");
		var zajbval = $("#bq_zajb").attr("title");
		$("#m_zabdm").attr("value",zajbkey);
		$("#m_zajbmc").attr("value",zajbval);
	}
	function yyztOnchange(){ // 营业状态
		var yyztkey = $("#bq_yyzt").attr("value");
		var yyztval = $("#bq_yyzt").attr("title");
		$("#m_yyztdm").attr("value",yyztkey);
		$("#m_yyztmc").attr("value",yyztval);
	}
	
	jhltlxInit();
	function jhltlxInit(){
		var usls = 'publicsystem/findFjjsJhltType_qyjbxx.action';
		jQuery.post(usls,null,jhltlxInitBack,"json");
	}
	function jhltlxInitBack(json){ //旧货流通类别
		$("#jhltlxSpan").html(setNull(json.result));
		fjjsPramSelInit();
	}
	function yanzhengJhltlx(){ //验证
		isCanPlay = true;
		blJhltlx();
		
		var jhltlxdm = $("#m_jhltlxdm").attr("value");
		var jhltlxmc = $("#m_jhltlxmc").attr("value");
		if(jhltlxdm==null||jhltlxdm==''){
			jAlert('"旧货流通类型"必须选择',"提示");
			isCanPlay =  false;
		} else {
			$("#m_jhltlxdm").attr("value",jhltlxdm.substring(0,jhltlxdm.length-1));
			$("#m_jhltlxmc").attr("value",jhltlxmc.substring(0,jhltlxmc.length-1));
		}
		var sgscxfjjs = $("#m_sgscxfjjs").attr("value");
		if(sgscxfjjs==null||sgscxfjjs==''){
			jAlert('"收购生产性废旧金属"必须选择',"提示");
			isCanPlay =  false;
		}
		return isCanPlay;
	}
	function blJhltlx(){ //遍历
		$("#m_jhltlxdm").attr("value","");
		$("#m_jhltlxmc").attr("value","");
		$("#jhltlxSpan").find("input[type='checkbox']").each(function(){
			if($(this).attr("checked")==true){
				var thisid = $(this).attr("id").replace('jhltlx_','');
				var thisname = $(this).attr("name");
				$("#m_jhltlxdm").attr("value",$("#m_jhltlxdm").attr("value")+thisid+",");
				$("#m_jhltlxmc").attr("value",$("#m_jhltlxmc").attr("value")+thisname+"|");
			}
		});
	}
	$("#scjsYes").click(function(){
		$("#m_sgscxfjjs").attr("value","1");
	});
	$("#scjsNo").click(function(){
		$("#m_sgscxfjjs").attr("value","0");
	});
</script>
<BODY>
<input type="hidden" id="m_sgscxfjjs"/>
<input type="hidden" id="m_jhltlxdm"/>
<input type="hidden" id="m_jhltlxmc"/>

<input type="hidden" id="m_frdbzjlb"/>
<input type="hidden" id="m_jjlxbm"/>

<input type="hidden" id="m_yyztdm"/>
<input type="hidden" id="m_yyztmc"/>
<input type="hidden" id="m_zabdm"/>
<input type="hidden" id="m_zajbmc"/>

	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr><td class="queryfont">企业基本信息</td></tr>
		<tr>
		<td valign="top" class="tdbg">
			<table width="100%" border="0" cellspacing="0" cellpadding="1">
			<tr height="25">
			    <td class="red">经营者名称</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_qymc"/></td>
			    <td class="red">经营地址</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_jydz"/></td>
		        <td class="pagedistd1">企业代码</td>
				<td class="pagetd1"><input style="width:120px" type="text" class="readonly" id="m_qybm" readonly/></td>
			</tr>
			<tr height="25">
				<td class="red">收购生产性废旧金属</td>
		        <td class="pagetd1"><input type="radio" name="scjs" id="scjsYes">是&nbsp;&nbsp;&nbsp;<input type="radio" name="scjs" id="scjsNo">否</td>
			    <td class="red">旧货流通类型</td>
		        <td class="pagetd1"><span id="jhltlxSpan"></span></td>
		        <td class="pagedistd1">组织机构代码</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_qyzzjgdm" maxlength="9"
					onkeyup="htjdOnkeyupVal('m_qyzzjgdm','jyxk');" onBlur="htjdOnBlurNotOnlyZfVal('m_qyzzjgdm','jyxk','0','‘组织机构编码’','1','0');"/></td>
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
			    <td class="red">经营面积（平米）</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_jymj"/></td>
		        <td class="pagedistd1">注册资金（万元）</td>
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
			<!-- 
			<tr>
			    <td class="pagedistd1">经营范围（兼营）</td>
		        <td class="pagetd1" colspan="3"><input style="width:370px" type="text" class="inputstyle1" id="m_jyfwjy"/></td>
		        <td class="pagedistd1">营业时间</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_yysj"/></td>
		        <td class="red">营业执照起始日期</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_yyzzQsrq"/></td>
		        <td class="red">营业执照截止日期</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_yyzzJzrq"/></td>
		        <td class="red">税务登记证起始日期</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_swdjQsrq"/></td>
		        <td class="red">税务登记证截止日期</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_swdjJzrq"/></td>
		        <td class="pagedistd1">经营许可证起始日期</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_jyxkQsrq"/></td>
		        <td class="pagedistd1">经营许可证截止日期</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_jyxkJzrq"/></td>
		        <td class="pagedistd1">特行许可证起始日期</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_thxkQsrq"/></td>
		        <td class="pagedistd1">特行许可证截止日期</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_thxkJzrq"/></td>
		        <td class="pagedistd1">特行许可证编号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_thxkZjbh"/></td>
		        <td class="pagedistd1">特行许可证发证机关</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_thxkFzjg"
		        	onkeyup="htjdOnkeyupVal('m_thxkFzjg','zhongwen');"/></td>
		        <td class="pagedistd1">消防合格证号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_xfhgzh"/></td>
		        <td class="pagedistd1">消防审核单位</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_xfshdw"
		        	onkeyup="htjdOnkeyupVal('m_xfshdw','zhongwen');"/></td>
		        <td class="pagedistd1">经纬度坐标</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1"  id="m_jwdzb"/></td>
		        <td class="pagedistd1">机器编码</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1"  id="m_jqbm"/></td>
				<td class="pagedistd1">股东信息</td>
				<td colspan="7" class="pagetd1"><textarea name="textarea" id="m_gdxx" cols="106" rows="2"></textarea></td>
				<td class="red">营业状态</td>
		        <td class="pagetd1"><select name="select3" id="bq_yyzt" onchange="yyztOnchange();"></select></td>
		         <td class="pagedistd1">备案日期</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_barq"/></td>
		        <td class="pagedistd1">治安等级</td>
		        <td class="pagetd1"><select id="bq_zajb" onchange="zajbOnchange();"></select></td>
			</tr>
			 -->
			<tr height="25">
		        <td class="red">法人联系方式</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_frdblxfs"/></td>
		        <td class="red">再生资源回收备案登记证号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_babh"/></td>
		        <td class="red">再生资源回收备案<br>登记发证公安机关</td>
				<td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_thbajg" readonly/>
					<input type="hidden" id="m_thbajgdm"/></td>
			</tr>
			<tr height="25">
		        <td class="pagedistd1">营业执照编号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_yyzzZjbh"/></td>
		        <td class="pagedistd1">营业执照发证机关</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_yyzzFzjg"
		        	onkeyup="htjdOnkeyupVal('m_yyzzFzjg','zhongwen');"/></td>
		        <td class="pagedistd1">税务登记证编号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_swdjZjbh"/></td>
			</tr>
			<tr height="25">
		        <td class="pagedistd1">税务登记证发证机关</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_swdjFzjg"
		        	onkeyup="htjdOnkeyupVal('m_swdjFzjg','zhongwen');"/></td>
		        <td class="pagedistd1">经营许可证编号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_jyxkZjbh"/></td>
		        <td class="pagedistd1">经营许可证发证机关</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_jyxkFzjg"
		        	onkeyup="htjdOnkeyupVal('m_jyxkFzjg','zhongwen');"/></td>
			</tr>
			<tr height="25">
		        <td class="red">经营负责人</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_dwfzr"
		        	onkeyup="htjdOnkeyupVal('m_dwfzr','xingming');" onBlur="htjdOnBlurNotOnlyZfVal('m_dwfzr','xingming','0','‘经营负责人’','1','0');"/></td>
		        <td class="red">经营负责人身份证号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_dwfzrzjhm"/></td>
		        <td class="red">经营负责人联系方式</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_dwfzrlxfs"/></td>
			</tr>
			<tr height="25">
				<td class="red">治安负责人</td>
				<td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_bafzrxm"
				onkeyup="htjdOnkeyupVal('m_bafzrxm','xingming');" onBlur="htjdOnBlurNotOnlyZfVal('m_bafzrxm','xingming','0','‘治安负责人’','1','0');"/></td>
				<td class="red"  >治安负责人身份证号</td>
				<td class="pagetd1"  ><input style="width:120px" type="text" class="inputstyle1" id="m_bafzrgmsfhm"/></td>
				<td class="red"  >治安负责人联系方式</td>
				<td class="pagetd1"  ><input style="width:120px" type="text" class="inputstyle1" id="m_bafzrdh"/></td>
			</tr>
			<tr height="25">
		        <td class="red">年审日期</td>
				<td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_nsrq"/></td>
		    </tr>
		    <tr>
		        <td class="pagedistd1">备注</td>
			        <td colspan="5" class="pagetd1"><textarea name="textarea" id="m_bz" cols="102" rows="2"></textarea></td>
		    </tr>
			</table>
		</td>
		</tr>
	</table>	
	<!-- 
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
		<tr><td id="ryjqt_title" class="queryfont">&nbsp;人员及其他信息</td></tr>
		<tr><td class="tdbg">
			<table width="100%" border="0" cellspacing="0" cellpadding="1">
				<tr>
			        <td width="11%" class="pagedistd1">总人数</td>
			        <td width="14%" class="pagetd1"><input style="width:120px" type="text" id="m_zrs" value="" readonly class="readonly"/></td>
			        <td width="11%" class="pagedistd1" id="hdrs_title">核定人数</td>
			        <td width="14%" class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_hdrs"/></td>
			        <td width="11%" class="pagedistd1">治安负责人</td>
			        <td width="14%" class="pagetd1"><label id="bafzr_content"><input style="width:120px" type="text" class="inputstyle1" id="m_bafzrxm"
			        	onkeyup="htjdOnkeyupVal('m_bafzrxm','xingming');" onblur="htjdOnBlurNotOnlyZfVal('m_bafzrxm','xingming','0','‘治安负责人’','1','0');"/></label></td>
			        <td width="11%" class="pagedistd1">保安人数</td>
			        <td width="14%" class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_bars"/></td>
				</tr>
				<tr>
			        <td class="pagedistd1">经岗位培训人数</td>
			        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="m_jgpxrs"/></td>
			        <td class="pagedistd1">保安公司意见</td>
			        <td colspan="5" class="pagetd1"><input style="width:620px" type="text" class="inputstyle1" id="m_bagsyj"/></td>
				</tr>
				<tr>
			        <td class="pagedistd1">备注</td>
			        <td colspan="7" class="pagetd1"><textarea name="textarea" id="m_bz" cols="106" rows="2"></textarea></td>
			      </tr>
			</table>
		</td></tr>
	</table>
	 -->
</BODY>
</HTML>