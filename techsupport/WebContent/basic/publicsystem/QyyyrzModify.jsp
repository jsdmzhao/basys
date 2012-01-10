<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		
		$("#q_yyrzid").attr("value",dataid);
		$("#bq_sffsaj").selectBox({code:"dm_bez"});
		$("#bq_sfglbmjc").selectBox({code:"dm_bez"});
		yyrz_setDetail();
		
		$("#m_ksyysj").attr("readonly","true");
		$("#m_ksyysj").datepicker(true);
		$("#m_jsyysj").attr("readonly","true");
		$("#m_jsyysj").datepicker(true);
		
		$("#p_hylbdm").selectBoxhylb();//行业类别
		
		if($("#p_hylbdm").val()!="J"){
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
		}
		
	}); 
	function yyrz_setDetail(){
		setParams("q_");
		jQuery.post(detailUrl,params,yyrz_updatediv,"json");
	}
	function yyrz_updatediv (json) {
		
		$("#riqi").append(setNull(json.LQyyyrz[0].riqi).replace("T"," ")); //登记日期
		$("#csfe").append(setNull(json.LQyyyrz[0].csfe)); //场所负责人姓名
		$("#zafzrxm").append(setNull(json.LQyyyrz[0].zafzrxm)); //治安负责人姓名
		$("#m_riqi").attr("value",setNull(json.LQyyyrz[0].riqi).replace("T"," ")); //登记日期
		$("#m_csfe").attr("value",setNull(json.LQyyyrz[0].csfe)); //场所负责人姓名
		$("#m_zafzrxm").attr("value",setNull(json.LQyyyrz[0].zafzrxm)); //治安负责人姓名
		$("#m_csfzrbh").attr("value",setNull(json.LQyyyrz[0].csfzrbh)); //场所负责人编号
		$("#m_zafzrbh").attr("value",setNull(json.LQyyyrz[0].zafzrbh)); //治安负责人编号
		
		$("#m_qyid").attr("value",setNull(json.LQyyyrz[0].qyid));
		$("#m_yyrzid").attr("value",setNull(json.LQyyyrz[0].yyrzid));
		$("#m_ksyysj").attr("value",setNull(json.LQyyyrz[0].ksyysj).replace("T"," "));
		$("#m_jsyysj").attr("value",setNull(json.LQyyyrz[0].jsyysj).replace("T"," "));
		$("#m_dryysj").attr("value",setNull(json.LQyyyrz[0].dryysj));
		$("#bq_sffsaj").setValue(setNull(json.LQyyyrz[0].sffsaj));
		$("#bq_sfglbmjc").setValue(setNull(json.LQyyyrz[0].sfglbmjc));
		$("#txrxm").append(setNull(json.LQyyyrz[0].txrxm).replace("T"," ")); //登记日期
		
		$("#m_cyryzs").attr("value",setNull(json.LQyyyrz[0].cyryzs));
		$("#m_dtsbrs").attr("value",setNull(json.LQyyyrz[0].dtsbrs));
		$("#m_dtxzrys").attr("value",setNull(json.LQyyyrz[0].dtxzrys));
		$("#m_dtlzrs").attr("value",setNull(json.LQyyyrz[0].dtlzrs));
		sffsajOnchange();
		sfglbfjcOnchange();
	}
	function sffsajOnchange(){ //是否有治安、刑事案件或事故发生
		var sffsaj = $("#bq_sffsaj").attr("value");
		$("#m_sffsaj").attr("value",sffsaj);
	}
	function sfglbfjcOnchange(){ //是否有管理部分检查
		var sfglbfjc = $("#bq_sfglbmjc").attr("value");;
		$("#m_sfglbmjc").attr("value",sfglbfjc);
	}
	function modifyVerify(){
		if (!checkControlValue("m_ksyysj","String",1,20,null,1,"营业开始时间"))
			return false;
		if (!checkControlValue("m_jsyysj","String",1,20,null,1,"营业结束时间"))
			return false;
		
			
		var ksyysj = $("#m_ksyysj").attr("value");
		var jsyysj = $("#m_jsyysj").attr("value");
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
		if (!checkControlValue("m_sffsaj","String",1,1,null,1,"是否有治安、刑事案件或事故发生"))
			return false;
		if (!checkControlValue("m_sfglbmjc","String",1,1,null,1,"是否有管理部门检查"))
			return false;
		if (!checkControlValue("m_cyryzs","Integer",0,999999,null,1,"从业人员总数"))
			return false;
		if (!checkControlValue("m_dtsbrs","Integer",0,999999,null,1,"当天上班人数"))
			return false;
		if (!checkControlValue("m_dtxzrys","Integer",0,999999,null,1,"当天新增人员数"))
			return false;
		if (!checkControlValue("m_dtlzrs","Integer",0,999999,null,1,"当天离职人数"))
			return false;
		if (!checkControlValue("m_dryysj","String",1,2000,null,1,"当日营业状况"))
			return false;
		
		return true;
	}
</script>
<input type="hidden" id="q_yyrzid">
<input type="hidden" id="m_qyid">
<input type="hidden" id="m_yyrzid">

<input type="hidden" id="m_riqi">
<input type="hidden" id="m_sffsaj">
<input type="hidden" id="m_sfglbmjc">
<div style="display:none"><select id="p_hylbdm"></select></div>

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">营业日志修改</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#qyyyrz_detail").hideAndRemove("show");'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd" width="26%"><div id="cs" >场所负责人</div><div id="qy" style="display:none">企业负责人</div></td>
		<td class="detailtd" width="30%"><input type="text" class="readonly"  id="m_csfe" value="" readonly="readonly"/></td>
		<td class="distd" width="20%"><div id="csbh" >场所负责人编号</div><div id="qybh" style="display:none">企业负责人编号</div></td>
		<td class="detailtd" width="24%"><input type="text" class="readonly"  id="m_csfzrbh" value="" readonly="readonly"/></td>
	</tr>
	<tr height="20">
		<td class="distd" width="26%">治安负责人</td>
		<td class="detailtd" width="30%"><input type="text" class="readonly"  id="m_zafzrxm" value="" readonly="readonly"/></td>
		<td class="distd" width="20%">治安负责人编号</td>
		<td class="detailtd" width="24%"><input type="text" class="readonly"  id="m_zafzrbh" value="" readonly="readonly"/></td>
	</tr>
	<tr height="20">
		<td class="red">营业开始时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ksyysj" value="" /></td>
	  <td class="red">营业结束时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_jsyysj" value="" /></td>
	</tr>
	<tr height="20">
		<td class="red">是否有治安、刑事案件或事故发生</td>
		<td class="detailtd"><select id="bq_sffsaj" onchange="sffsajOnchange();">
		<option value=""></option></select></td>
		<td class="red">是否有管理部门检查</td>
		<td class="detailtd"><select id="bq_sfglbmjc" onchange="sfglbfjcOnchange();">
		<option value=""></option></select></td>
	</tr>
	<tr height="20">
		<td class="distd">登记日期</td>
		<td class="detailtd"><span id="riqi"></span></td>
		<td class="distd">填写人姓名</td>
		<td class="detailtd"><span id="txrxm"></td>
	</tr>
	<tr height="20">
		<td class="red">从业人员总数</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_cyryzs" value="" /></td>
		<td class="red">上班总数</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dtsbrs" value="" /></td>
	</tr>
	<tr height="20">
		<td class="red">当天新增人员数</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dtxzrys" value="" /></td>
		<td class="red">当天离职人数</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_dtlzrs" value="" /></td>
	</tr>
	<tr height="20">
	  <td class="red">当日营业状况</td>
      <td colspan="3" class="detailtd">
        <textarea name="textarea" id="m_dryysj" cols="61" rows="5"></textarea>
      </td>
  </tr>
	<tr height="25" align="center"><td colspan="4">
	<a href="#" class="submitbutton" id="modbutton" onclick="setUpdate();" title="修改">保存</a></td></tr>
</table>

