<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		
		yyrz_setYlcsAndCdry();
		$("#a_hylbdm").selectBoxhylb();
		$("#bq_sffsaj").selectBox({code:"dm_bez"});
		$("#bq_sfglbfjc").selectBox({code:"dm_bez"});	
	
		$("#a_riqi").attr("readonly","true");
		$("#a_riqi").datepicker();
		$("#a_ksyysj").attr("readonly","true");
		$("#a_ksyysj").datepicker(true);
		$("#a_jsyysj").attr("readonly","true");
		$("#a_jsyysj").datepicker(true);
		
		
		if($("#a_hylbdm").val()!="J"){
		$('body').find('div [@id=qy]').each(function(){
			$(this).show();
		});
		$('body').find('div [@id=qybh]').each(function(){
			$(this).show();
		});
		$('body').find('div [@id=cs]').each(function(){
			$(this).hide();
		});
		$('body').find('div [@id=csbh]').each(function(){
			$(this).hide();
		});
		$("#tsd_ts1").hide();
		$("#tsd_ts2").hide();
	}
		
		var date = new Date();
		var newTime = date.getYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
		$("#a_pageSort").attr("value",newTime);
	}); 
	
	function yyrz_setYlcsAndCdry(){ //娱乐场所（单位负责人）和场地人员（治安负责人）
		
		jQuery.post("publicsystem/queryfzry_qyyyrz.action",params,yyrz_updatediv,"json");
	}
	
	function yyrz_updatediv (json) {
		
		$("#a_csfe").attr("value",setNull(json.LQyyyrz[0].csfe)); //场所负责人姓名
		$("#a_csfzrbh").attr("value",setNull(json.LQyyyrz[0].csfzrbh)); //场所负责人编号
		$("#a_zafzrxm").attr("value",setNull(json.LQyyyrz[0].zafzrxm)); //治安负责人姓名	
		$("#a_zafzrbh").attr("value",setNull(json.LQyyyrz[0].zafzrbh)); //治安负责人编号		
		$("#a_qyid").attr("value",setNull(json.LQyyyrz[0].qyid)); //场所ID

		if ($("#a_csfzrbh").val()=="00000000000000000000"&&$("#a_zafzrbh").val()=="00000000000000000000")
		{
		$("#tsd_ts1").show();
		$("#tsd_ts2").show();
		$("#tsd_fzr1").text("本场所企业负责人信息未采集，请及时到受理点采集信息补办从业人员信息卡");
		$("#tsd_fzr2").text("本场所治安负责人信息未采集，请及时到受理点采集信息补办从业人员信息卡");
		} else if ($("#a_csfzrbh").val()=="00000000000000000000")
		{
		$("#tsd_ts1").show();
		$("#tsd_fzr1").text("本场所企业负责人信息未采集，请及时到受理点采集信息补办从业人员信息卡");
		} else if ($("#a_zafzrbh").val()=="00000000000000000000")
		{
		$("#tsd_ts1").show();
		$("#tsd_fzr1").text("本场所治安负责人信息未采集，请及时到受理点采集信息补办从业人员信息卡");
		}

	}
	
	function sffsajOnchange(){ //是否有治安、刑事案件或事故发生
		var sffsaj = $("#bq_sffsaj").attr("value");;
		$("#a_sffsaj").attr("value",sffsaj);
	}
	function sfglbfjcOnchange(){ //是否有管理部分检查
		var sfglbfjc = $("#bq_sfglbfjc").attr("value");;
		$("#a_sfglbmjc").attr("value",sfglbfjc);
	}
	
	function addVerify(){
		
		if (!checkControlValue("a_ksyysj","String",1,20,null,1,"营业开始时间"))
			return false;
		if (!checkControlValue("a_jsyysj","String",1,20,null,1,"营业结束时间"))
			return false;
		var ksyysj = $("#a_ksyysj").attr("value");
		var jsyysj = $("#a_jsyysj").attr("value");
		ksyysj = new Date(ksyysj.replace(/-/g, "/")); 
		jsyysj = new Date(jsyysj.replace(/-/g, "/")); 
		
		if (Date.parse(ksyysj) - Date.parse(jsyysj)<=0) { 

			if((Date.parse(jsyysj) - Date.parse(ksyysj))/1000/60/60>24){
				jAlert("营业结束时间不能超过营业开始时间一天!","提示信息");
				return false;
			} 
		}else {
			jAlert("请正确选择开始和营业结束时间!","提示信息");
			return false;
		} 
		if (!checkControlValue("a_sffsaj","String",1,1,null,1,"是否有治安、刑事案件或事故发生"))
			return false;
		if (!checkControlValue("a_sfglbmjc","String",1,1,null,1,"是否有管理部门检查"))
			return false;
		if (!checkControlValue("a_txrxm","String",1,30,null,1,"填写人姓名"))
			return false;
		if (!checkControlValue("a_cyryzs","Integer",0,999999,null,1,"从业人员总数"))
			return false;
		if (!checkControlValue("a_dtsbrs","Integer",0,999999,null,1,"当天上班人数"))
			return false;
		if (!checkControlValue("a_dtxzrys","Integer",0,999999,null,1,"当天新增人员数"))
			return false;
		if (!checkControlValue("a_dtlzrs","Integer",0,999999,null,1,"当天离职人数"))
			return false;
		if (!checkControlValue("a_dryysj","String",1,2000,null,1,"当日营业状况"))
			return false;	
		$("#a_hylb").val($("#a_hylbdm").attr("title"));
			
			
		return true;
	}
</script>

<input type="hidden" id="a_qyid">
<input type="hidden" id="a_sffsaj">
<input type="hidden" id="a_sfglbmjc">
<input type="hidden" id="a_hylb">

<div style="display:none"><select id="a_hylbdm"></select></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">营业日志添加</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyyyrz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	
	<tr height="20">
		<td class="distd" width="26%"><div id="cs" >场所负责人</div><div id="qy" style="display:none">企业负责人</div></td>
		<td class="detailtd" width="30%"><input type="text" class="readonly"  id="a_csfe" value="" readonly="readonly"/></td>
		<td class="distd" width="20%"><div id="csbh" >场所负责人编号</div><div id="qybh" style="display:none">企业负责人编号</div></td>
		<td class="detailtd" width="24%"><input type="text" class="readonly"  id="a_csfzrbh" value="" readonly="readonly"/></td>
	</tr>
	<tr height="20">
		<td class="distd" width="26%">治安负责人</td>
		<td class="detailtd" width="30%"><input type="text" class="readonly"  id="a_zafzrxm" value="" readonly="readonly"/></td>
		<td class="distd" width="20%">治安负责人编号</td>
		<td class="detailtd" width="24%"><input type="text" class="readonly"  id="a_zafzrbh" value="" readonly="readonly"/></td>
	</tr>
	<tr height="20">
		<td class="red">营业开始时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ksyysj" value="" /></td>
	  <td class="red">营业结束时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_jsyysj" value="" /></td>
	</tr>
	<tr height="20">
		<td class="red">是否有治安、刑事案件或事故发生</td>
		<td class="detailtd"><select id="bq_sffsaj" onchange="sffsajOnchange();">
		<option value=""></option></select></td>
		<td class="red">是否有管理部门检查</td>
		<td class="detailtd"><select id="bq_sfglbfjc" onchange="sfglbfjcOnchange();">
		<option value=""></option></select></td>
	</tr>
	<tr height="20">
		<td class="distd">登记日期</td>
		<td class="detailtd"><input type="text" class="readonly" id="a_pageSort" readonly="readonly"/></td>
		<td class="red">填写人姓名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_txrxm" value="" /></td>
	</tr>
	<tr height="20">
		<td class="red">从业人员总数</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_cyryzs" value="" /></td>
		<td class="red">上班总数</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dtsbrs" value="" /></td>
	</tr>
	<tr height="20">
		<td class="red">当天新增人员数</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dtxzrys" value="" /></td>
		<td class="red">当天离职人数</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_dtlzrs" value="" /></td>
	</tr>
	<tr height="20">
	  <td class="red">当日营业状况</td>
      <td colspan="3" class="detailtd">
        <textarea name="textarea" id="a_dryysj" cols="61" rows="5"></textarea>
      </td>
  	</tr>
  	<tr height="20" id="tsd_ts1">
	 	<td class="distd">提示：</td>
		<td class="detailtd" colspan="3" id="tsd_fzr1"></td>
	</tr>
	<tr height="20" id="tsd_ts2">
		<td class="distd" id="tsd_blank">&nbsp;</td>
		<td class="detailtd"  colspan="3" id="tsd_fzr2"></td>
  	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick="setAdd();">保存</a></td></tr>
</table>