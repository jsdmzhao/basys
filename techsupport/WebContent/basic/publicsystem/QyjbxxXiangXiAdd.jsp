<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<HTML>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_zdskb").attr("value",zdskb); //最低刷卡比
		
		$("#bq_hylb").selectBoxhylb({code:"J",width:"118px"});
		$("#bq_frdbzj").selectBox({code:"dm_frdbzjlb(ylcs)",width:"118px"});
		$("#bq_frdbzj").setValue("111",115);//默认赋值
		$("#bq_frdbzj").setText("居民身份证",115);//默认赋值
		$("#a_frdbzjlb").attr("value","居民身份证");//默认赋值
		
		$("#bq_ylcsfl").selectBox({state:"1",width:"118px"}); //动态
		$("#bq_yyzt").selectBox({state:"1",width:"118px"}); //动态
		$("#bq_zajb").selectBox({state:"1",width:"118px"}); //动态
		$("#a_gxdwmc").click(function(){ //管辖单位
			getGxdw("a_gxdwmc","a_gxdwbm");
		});
		$("#a_thbajg").click(function(){ //特行备案机构
			getGxdw("a_thbajg","a_thbajgdm");
		});
		$("#a_jjlxmc").click(function(){ //经济类型筛选
			getDict_item("a_jjlxmc","a_jjlxbm","dm_jjlx");
		});
		
		$("#a_kyrq").attr("readonly","true").datepicker();
		$("#a_barq").attr("readonly","true");
		$("#a_yyzzQsrq").attr("readonly","true").datepicker();
		$("#a_yyzzJzrq").attr("readonly","true").datepicker();
		$("#a_jyxkQsrq").attr("readonly","true").datepicker();
		$("#a_jyxkJzrq").attr("readonly","true").datepicker();
		$("#a_thxkQsrq").attr("readonly","true").datepicker();
		$("#a_thxkJzrq").attr("readonly","true").datepicker();
		$("#a_swdjQsrq").attr("readonly","true").datepicker();
		$("#a_swdjJzrq").attr("readonly","true").datepicker();
		$("#a_tyrq").attr("readonly","true").datepicker();
		$("#a_djrq").attr("readonly","true").datepicker();
	}).keydown(function(){
		var srcObj = $(event.srcElement);
		if(event.keyCode == 13){
			event.keyCode = 9;
			alert(srcObj.attr("readonly"));
			if(srcObj.attr("readonly")){
				alert();
			}
		}
		event.stopPropagation();
	});
	
	function qyjbxx_addVerify(){ //验证
		//企业基本信息验证开始
		if (!checkControlValue("a_gxdwmc","String",1,60,null,1,"治安管理机构"))
			return false;
		if (!checkControlValue("a_qyzflbm","String",1,30,null,1,"场所主分类"))
			return false;
		if (!checkControlValue("a_qymc","String",1,120,null,1,'娱乐场所名称'))
			return false;
		if (!checkControlValue("a_qyjc","String",1,120,null,1,'娱乐场所简称'))
			return false;
		if (!htjdOnBlurNotOnlyZfVal('a_qyzzjgdm','jyxk','0','‘组织机构代码’','1','0')){
			return false;
		}
		if (!checkControlValue("a_qyzzjgdm","String",1,10,null,0,"组织机构代码"))
			return false;
		if (!checkControlValue("a_lxdh","String",1,30,null,1,"联系电话"))
			return false;
		if (!checkControlValue("a_yzbm","String",1,6,null,0,"邮政编码")) //4.27 罗波提 所有非必填
			return false;
		if (!checkControlValue("a_chzh","String",1,30,null,0,"传真"))
			return false;
		if (!checkControlValue("a_jjlxmc","String",1,100,null,1,"经济类型"))
			return false;
		if (!checkControlValue("a_zczj","Float",-99999999.99,99999999.99,2,0,'注册资金(万元)'))
			return false;
		if (!checkControlValue("a_jyfwzy","String",1,200,null,1,'经营范围(主营)'))
			return false;
		if (!checkControlValue("a_jyfwjy","String",1,200,null,0,"经营范围(兼营)"))
			return false;
		if (!checkControlValue("a_jymj","Float",-99999999.99,99999999.99,2,1,'经营面积(平米)'))
			return false;
		if (!checkControlValue("a_jydz","String",1,200,null,1,'经营地址'))
			return false;
		if (!checkControlValue("a_frdb","String",1,30,null,1,"法定代表人姓名"))
			return false;
		if (!checkControlValue("a_frdbzjhm","String",1,30,null,1,"法人证件号码"))
			return false;
		if($("#a_frdbzjlb").attr("value")=='居民身份证'||$("#a_frdbzjlb").attr("value")=='临时居民身份证'){
			if(!valSfzCardIsRight("a_frdbzjhm","请正确填写法人证件号码!"))
				return false;
		}
		if (!checkControlValue("a_frdblxfs","String",1,30,null,1,"法人联系方式"))
			return false;
		if (!checkControlValue("a_kyrq","Date",null,null,null,1,"开业日期"))
			return false;
		if (!checkControlValue("a_yysj","String",1,20,null,0,"营业时间"))
			return false;
		if (!checkControlValue("a_dwfzr","String",1,30,null,1,"单位负责人"))
			return false;
		if (!checkControlValue("a_dwfzrlxfs","String",1,30,null,1,"单位负责人联系方式"))
			return false;
		if (!checkControlValue("a_dwfzrzjhm","String",1,30,null,1,"单位负责人身份证号"))
			return false;
		if(!valSfzCardIsRight("a_dwfzrzjhm","请正确填写单位负责人身份证号!"))
			return false;
		if (!checkControlValue("a_yyzzZjbh","String",1,60,null,0,"营业执照编号"))
			return false;
		if (!checkControlValue("a_yyzzFzjg","String",1,60,null,0,"营业执照发证机关"))
			return false;
		if (!checkControlValue("a_yyzzQsrq","Date",null,null,null,0,"营业执照起始日期"))
			return false;
		if (!checkControlValue("a_yyzzJzrq","Date",null,null,null,0,"营业执照截止日期"))
			return false;
		if (!checkControlValue("a_djrq","Date",null,null,null,0,"营业执照登记日期"))
			return false;
		if (!checkControlValue("a_jyxkZjbh","String",1,60,null,1,"娱乐经营许可证号"))
			return false;
		if (!checkControlValue("a_jyxkFzjg","String",1,60,null,1,"娱乐经营许可证发证机关"))
			return false;
		if (!checkControlValue("a_jyxkQsrq","Date",null,null,null,0,"娱乐经营许可证起始日期"))
			return false;
		if (!checkControlValue("a_jyxkJzrq","Date",null,null,null,0,"娱乐经营许可证截止日期"))
			return false;
		if (!checkControlValue("a_gdxx","String",1,2000,null,0,"股东信息"))
			return false;		
		if (!checkControlValue("a_bz","String",1,2000,null,1,"娱乐项目内容"))
			return false;
		if (!checkControlValue("a_xfhgzh","String",1,20,null,1,"消防合格证号"))
			return false;
		if (!checkControlValue("a_xfshdw","String",1,200,null,1,"消防审核单位"))
			return false;
		if (!checkControlValue("a_jwdzb","String",1,100,null,0,"经纬度坐标"))
			return false;
		if (!checkControlValue("a_hdrs","Integer",0,999999,null,0,"核定消费者数量(人)"))
			return false;
		if (!checkControlValue("a_cksl","Integer",0,999999,null,1,"安全出口数量(个)"))
			return false;
		if (!checkControlValue("a_bxbjsl","Integer",0,999999,null,1,"包厢包间数量(间)"))
			return false;
		if (!checkControlValue("a_bafzrxm","String",1,30,null,1,"治安负责人"))
			return false;
		if (!checkControlValue("a_bars","Integer",0,999999,null,0,"保安人数(人)"))
			return false;
		if (!checkControlValue("a_jgpxrs","Integer",0,999999,null,0,"经岗位培训人数(人)"))
			return false;
		if (!checkControlValue("a_bagsyj","String",1,2000,null,0,"保安公司意见"))
			return false;
		
		//详细验证开始
		var a_yyzzQsrq = $("#a_yyzzQsrq").attr("value");
		var a_yyzzJzrq = $("#a_yyzzJzrq").attr("value");
		if(formatDate(a_yyzzQsrq)>formatDate(a_yyzzJzrq)){
			jAlert("请正确选择‘营业执照’起始和截止日期!","提示信息",null,'a_yyzzQsrq');
			return false;
		}
		var a_jyxkQsrq = $("#a_jyxkQsrq").attr("value");
		var a_jyxkJzrq = $("#a_jyxkJzrq").attr("value");
		if(formatDate(a_jyxkQsrq)>formatDate(a_jyxkJzrq)){
			jAlert("请正确选择‘娱乐经营许可证’起始和截止日期!","提示信息",null,'a_jyxkQsrq');
			return false;
		}
		
		valadateYyzz();
		if(!canCommit)
			return false;
		return true;
	}
	function frzjhmBlurVali(){
		if($("#a_frdbzjlb").attr("value")=='居民身份证'||$("#a_frdbzjlb").attr("value")=='临时居民身份证'){
			if($("#a_frdbzjhm").attr("value")!=''){
				if(!valSfzCardIsRight("a_frdbzjhm","请正确填写法人证件号码!",0))
					return false;
			}
		}
	}
	function dwfzrzjhmBlurVali(){
		if($("#a_dwfzrzjhm").attr("value")!=''){
			if(!valSfzCardIsRight("a_dwfzrzjhm","请正确填写单位负责人公民身证号!",0))
				return false;
		}
	}
	function valadateYyzz(){ //营业执照编号
		//var yyzzZjbh = $("#a_yyzzZjbh").attr("value");
		//if(yyzzZjbh==''){
		//	canCommit=false;
		//	jAlert('请正确输入营业执照编号!','验证信息',null,'a_yyzzZjbh');
		//	return;
		//}
		setParams("a_");
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
				jAlert('此营业执照编号已存在!','验证信息',null,'a_yyzzZjbh');
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
	
</script>
<BODY>
<!-- 页面的页签及加载状态 新加业-->
<select id="yqAndZt" style="DISPLAY:none">
<option value='qyxx'>0</option>
<option value='yl_qt'>0</option>
<option value='yl_baxx'>0</option>
<option value='yl_qtxx'>0</option>
</select>

<input type="hidden" id="a_hylbdm"/>
<input type="hidden" id="a_hylb"/>
<input type="hidden" id="a_frdbzjlb"/>
<input type="hidden" id="a_yyztdm"/>
<input type="hidden" id="a_yyztmc"/>
<input type="hidden" id="a_zjztdm"/>
<input type="hidden" id="a_zjztmc"/>
<input type="hidden" id="a_zabdm"/>
<input type="hidden" id="a_zajbmc"/>
<input type="hidden" id="a_jjlxbm"/>
<input type="hidden" id="a_qyfflbm"/>
<!--  <input type="text" id="a_qyfflmc"/>-->
<input type="hidden" id="a_gxdwbm"/>
<input type="hidden" id="a_qyzflbm"/>
<!--  <input type="hidden" id="a_qyzflmc"/>-->
<input type="hidden" id="qyfflid"/><!-- 企业副分类ID -->

	<table width="100%"  cellspacing="0" cellpadding="0" class="line" >
	<tr>
	<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="1">
			<tr>
		      	<td width="11%" class="red">行业类别</td>
		        <td width="14%" class="pagetd1"><select name="select" id="bq_hylb" onChange="hylbOnchange();"></select></td>
		        <td width="11%" class="red">治安管理机构</td>
		        <td class="pagetd1"><input style="width:370px" type="text" class="inputstyle3" id="a_gxdwmc"  readonly/></td>
			</tr>
			<tr id="hqZhuFuType">
		        <td class="red">场所分类(主)</td>
		        <td class="pagetd1">
		        <select name="select" id="bq_ylcsfl" onChange="csflOnchange();">
		        <option value=""></option></select>
		         <input  type="text" class="inputstyle" id="a_qyzflmc" readonly  value=''  />
		        </td>
		        <td class="pagedistd1" id="yly_csffl_title" style="display:none">场所分类(副)</td>
		        <td class="pagetd1" id="yly_csffl_content" style="display:none"><select name="select" id="bq_csffl"></select>
		        <input style="width:370px" type="text" class="inputstyle3" id="a_qyfflmc" readonly/>
		        </td>
			</tr>
		</table>
		<div id='context_jbxx'>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td class="queryfont">&nbsp;场所基本信息</td>
		  </tr>
		  <tr>
		    <td valign="top"  class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="1">
		      <tr id="qyjbxxTr1">
		        <td class="red">场所备案编号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" id="a_qybm" readonly class="readonly"/></td>
		        <td class="red">娱乐场所名称</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_qymc"/></td>
		        <td class="red">娱乐场所简称</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_qyjc"/></td>
		        <td class="pagedistd1">组织机构代码</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_qyzzjgdm" maxlength="9"
		        		onkeyup="htjdOnkeyupVal('a_qyzzjgdm','jyxk');" onBlur="htjdOnBlurNotOnlyZfVal('a_qyzzjgdm','jyxk','0','‘组织机构编码’','1','0');"/></td>
		      </tr>
		      <tr id="qyjbxxTr2">
		        <td width="11%" class="red">联系电话</td>
		        <td width="14%" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_lxdh"/></td>
		        <td id="yzbm_title" width="11%" class="pagedistd1">邮政编码</td>
		        <td id="yzbm_conte" width="14%" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_yzbm" maxlength="6" onKeyUp="value=value.replace(/[^\d]/g,'')"/></td>
		        <td width="11%" class="pagedistd1">传真</td>
		        <td width="14%" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_chzh"/></td>
		        <td id="jjlx_title" width="11%" class="red">经济类型</td>
		        <td id="jjlx_conte" width="14%" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_jjlxmc" readonly/></td>
		      </tr>
		      <tr id="qyjbxxTr3">
		      	<td class="pagedistd1">注册资金(万元)</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_zczj"/></td>
		        <td class="red">经营范围(主营)</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_jyfwzy"/></td>
		        <td id="jyfwjy_title" class="pagedistd1">经营范围(兼营)</td>
		        <td id="jyfwjy_conte" class="pagetd1" colspan="3"><input style="width:370px" type="text" class="inputstyle3" id="a_jyfwjy"/></td>
		      </tr>
		      <tr id="qyjbxxTr4">
		        <td id="jymj_title" class="red">经营面积(平米)</td>
		        <td id="jymj_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_jymj"/></td>
		        <td id="yyzt_title" class="red">娱乐服务场所状态</td>
		        <td id="yyzt_conte" class="pagetd1"><select name="select3" id="bq_yyzt" onChange="yyztOnchange();"></select></td>
		        <td id="jydz_title" class="red">经营地址</td>
		        <td id="jydz_conte" class="pagetd1" colspan="3"><input style="width:370px" type="text" class="inputstyle3" id="a_jydz"/></td>
		      </tr>
		      <tr id="qyjbxxTr5">
		        <td class="red">法定代表人姓名</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_frdb"
		        	onkeyup="htjdOnkeyupVal('a_frdb','xingming');" onBlur="htjdOnBlurNotOnlyZfVal('a_frdb','xingming','0','‘法定代表人’','1','0');"/></td>
		        <td class="red">法人证件类型</td>
		        <td class="pagetd1"><select name="select4" id="bq_frdbzj" onChange="frdbzjOnchange();"></select></td>
		        <td class="red">法人证件号码</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_frdbzjhm" onblur="frzjhmBlurVali();"/></td>
		        <td id="frlxfs_title" class="red">法人联系方式</td>
		        <td id="frlxfs_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_frdblxfs"/></td>
		      </tr>
		      <tr id="qyjbxxTr6">
		        <td class="red">开业日期</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_kyrq"/></td>
		        <td id="yysj_title" class="pagedistd1">营业时间</td>
		        <td id="yysj_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_yysj"/></td>
		        <td class="red">单位负责人</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_dwfzr"
		        	onkeyup="htjdOnkeyupVal('a_dwfzr','xingming');" onBlur="htjdOnBlurNotOnlyZfVal('a_dwfzr','xingming','0','‘单位负责人’','1','0');"/></td>
		        <td class="red">单位负责人联系方式</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_dwfzrlxfs"/></td>
                </tr>
		      <tr id="qyjbxxTr7">
		        <td class="red">单位负责人<br>身份证号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_dwfzrzjhm" onblur="dwfzrzjhmBlurVali();"/></td>
		        <td id="zadj_title" class="red">娱乐服务场所<br>治安级别</td>
		        <td id="zadj_conte" class="pagetd1"><select name="select2" id="bq_zajb" onChange="zajbOnchange();"></select></td>
		        <td class="pagedistd1">营业执照编号</td>
		        <td class="pagetd1" valign="top"><input style="width:120px" type="text" class="inputstyle3" id="a_yyzzZjbh"/></td>
                <td class="pagedistd1">营业执照发证机关</td>
		        <td class="pagetd1" valign="top"><input style="width:120px" type="text" class="inputstyle3" id="a_yyzzFzjg"
		        	onkeyup="htjdOnkeyupVal('a_yyzzFzjg','zhongwen');"/></td>
                </tr>
		      <tr id="qyjbxxTr8">
		        <td id="yyzzqsrq_title" class="pagedistd1">营业执照起始日期</td>
		        <td id="yyzzqsrq_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_yyzzQsrq"/></td>
		        <td id="yyzzjzrq_title" class="pagedistd1">营业执照截止日期</td>
		        <td id="yyzzjzrq_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_yyzzJzrq"/></td>
                <td class="pagedistd1" id="djrq_title" valign="top">营业执照登记日期</td>
		        <td class="pagetd1" id="djrq_content" valign="top"><input style="width:120px" type="text" class="inputstyle3" id="a_djrq"/></td> 
		        <td id="jyxk_bh_" class="red">娱乐经营许可证号</td>
		        <td id="jyxk_bhConte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_jyxkZjbh"/></td>
		      </tr>
		      <tr>
		      	<td id="jyxk_fzjg_" class="red">娱乐经营许可证<br>发证机关</td>
		        <td id="jyxk_fzjgConte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_jyxkFzjg"
		        	onkeyup="htjdOnkeyupVal('a_jyxkFzjg','zhongwen');"/></td>
		        <td id="jyxk_qsrq" class="pagedistd1">娱乐经营许可证<br>起始日期</td>
		        <td id="jyxk_qsrq_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_jyxkQsrq"/></td>
		        <td id="jyxk_jzrq" class="pagedistd1">娱乐经营许可证<br>截止日期</td>
		        <td id="jyxk_jzrq_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_jyxkJzrq"/></td>
		      </tr>
			  <tr>
				<td class="pagedistd1">股东信息</td>
				<td colspan="3" class="pagetd1"><textarea name="textarea" id="a_gdxx" cols="44" rows="2"></textarea></td>
				<td class="red" valign="top">娱乐项目内容</td>
				<td colspan="3" class="pagetd1"><textarea name="textarea" id="a_bz" cols="44" rows="2"></textarea></td>
			  </tr>
		    </table></td>
		  </tr>
		</table>	
		
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td id="ryjqt_title" class="queryfont">&nbsp;场地设备及人员情况</td>
		  </tr>
		  <tr>
		    <td class="tdbg">
			    <table width="100%" border="0" cellspacing="0" cellpadding="1">
			      <tr id="ryxxTr1">
			      	<td width="11%" class="red">消防合格证号</td>
		        	<td width="14%" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_xfhgzh"/></td>
		        	<td width="11%" class="red">消防审核单位</td>
		        	<td width="14%" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_xfshdw"
		        		onkeyup="htjdOnkeyupVal('a_xfshdw','zhongwen');"/></td>
		        	<td width="11%" class="pagedistd1">经纬度坐标</td>
		        	<td width="14%" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3"  id="a_jwdzb"/></td>
		        	<td width="11%" class="pagedistd1">核定消费者数量(人)</td>
			        <td width="14%" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_hdrs"/></td>
				  </tr>
				  <tr>
			        <td class="red" id="cksl_title">安全出口数量(个)</td>
			        <td class="pagetd1" id="cksl_content"><input style="width:120px" type="text" class="inputstyle3" id="a_cksl"/></td>
			        <td class="red" id="bxbjsl_title">包厢包间数量(间)</td>
			        <td class="pagetd1" id="bxbjsl_content"><input style="width:120px" type="text" class="inputstyle3" id="a_bxbjsl"/></td>
			        <td class="pagedistd1">总人数(人)</td>
			        <td class="pagetd1"><input tabindex="1000" style="width:120px" type="text" id="a_zrs" value="" readonly class="readonly"/></td>
			        <td class="red">治安负责人</td>
			        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_bafzrxm"
			        	onkeyup="htjdOnkeyupVal('a_bafzrxm','xingming');" onBlur="htjdOnBlurNotOnlyZfVal('a_bafzrxm','xingming','0','‘治安负责人’','1','0');"/></td>
				  </tr>	
			      <tr>
			        <td class="pagedistd1"><label id="bars_title">保安人数(人)</label></td>
			        <td class="pagetd1" valign="top"><label id="bars_content"><input style="width:120px" type="text" class="inputstyle3" id="a_bars"/></label></td>
			        <td class="pagedistd1">经岗位培训人数(人)</td>
			        <td class="pagetd1" valign="top"><input style="width:120px" type="text" class="inputstyle3" id="a_jgpxrs"/></td>
			      </tr>
			      <tr>
			        <td class="pagedistd1">保安公司意见</td>
			        <td colspan="7" class="pagetd1"><textarea name="textarea" id="a_bagsyj" cols="106" rows="2"></textarea></td>
			      </tr>
			    </table>
		    </td>
		  </tr>
		</table>
		</div>
	</tr>
	</table>

</BODY>
</HTML>