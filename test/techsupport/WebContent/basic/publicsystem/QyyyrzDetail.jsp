<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		qyryrzdetail_setDetail(dataid);
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
	function qyryrzdetail_setDetail(id){
		$("#q_yyrzid").val(id);
		setParams("q_");
		jQuery.post("publicsystem/query_qyyyrz.action",params,yyrz_updatediv,"json");
	}
	function yyrz_updatediv(json) {
		
		$("#qymc").append(setNull(json.LQyyyrz[0].qymc));
		$("#riqi").append(setNull(json.LQyyyrz[0].riqi));
		$("#ksyysj").append(setNull(json.LQyyyrz[0].ksyysj));
		$("#jsyysj").append(setNull(json.LQyyyrz[0].jsyysj));
		$("#csfe").append(setNull(json.LQyyyrz[0].csfe));
		$("#zafzrxm").append(setNull(json.LQyyyrz[0].zafzrxm));
		$("#csfzrbh").append(setNull(json.LQyyyrz[0].csfzrbh));
		$("#zafzrbh").append(setNull(json.LQyyyrz[0].zafzrbh));
		if(setNull(json.LQyyyrz[0].sffsaj)==1){
		    $("#sffsaj").append("是");
		}else{
		    $("#sffsaj").append("否");
		}
		if(setNull(json.LQyyyrz[0].sfglbmjc)==1){
		    $("#sfglbfjc").append("是");
		}else{
		    $("#sfglbfjc").append("否");
		}
		$("#dryysj").append(setNull(json.LQyyyrz[0].dryysj));
		$("#txrxm").append(setNull(json.LQyyyrz[0].txrxm));
		$("#cyryzs").append(setNull(json.LQyyyrz[0].cyryzs));
		$("#dtsbrs").append(setNull(json.LQyyyrz[0].dtsbrs));
		$("#dtxzrys").append(setNull(json.LQyyyrz[0].dtxzrys));
		$("#dtlzrs").append(setNull(json.LQyyyrz[0].dtlzrs));
	}	
</script>
<input type="hidden" id="q_yyrzid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">营业日志详细信息</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyyyrz_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1" width="40%">场所名称</td>
		<td class="detailtd2" width="60%"><span id="qymc"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1" width="40%">登记日期</td>
		<td class="detailtd2" width="60%"><span id="riqi"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">开始营业时间</td>
		<td class="detailtd2"><span id="ksyysj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">结束营业时间</td>
		<td class="detailtd2"><span id="jsyysj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1"><div id="cs" >场所负责人</div><div id="qy" style="display:none">企业负责人</div></td>
		<td class="detailtd2"><span id="csfe"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1"><div id="csbh" >场所负责人编号</div><div id="qybh" style="display:none">企业负责人编号</div></td>
		<td class="detailtd2"><span id="csfzrbh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">治安负责人</td>
		<td class="detailtd2"><span id="zafzrxm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">治安负责人编号</td>
		<td class="detailtd2"><span id="zafzrbh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">治安、刑事或事故</td>
		<td class="detailtd2"><span id="sffsaj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">管理部门检查</td>
		<td class="detailtd2"><span id="sfglbfjc"></span></td>
	</tr>
	
	<tr height="20">
		<td class="distd1">当日营业状况</td>
		<td class="detailtd2" width="210px"><span id="dryysj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">填写人姓名</td>
		<td class="detailtd2"><span id="txrxm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">从业人员总数</td>
		<td class="detailtd2"><span id="cyryzs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">当天上班人数</td>
		<td class="detailtd2"><span id="dtsbrs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">当天新增人员数</td>
		<td class="detailtd2"><span id="dtxzrys"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">当天离职人数</td>
		<td class="detailtd2"><span id="dtlzrs"></span></td>
	</tr>
	
	
	
</table>