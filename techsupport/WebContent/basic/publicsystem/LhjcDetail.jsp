<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_lhjcid").attr("value",dataid);
			setDetail();
	}); 
	
	 function setHyxx_detail(){
	        var hylb=$("#a_hylbdm").attr("value");
			if(hylb=='J'||hylb=='K'){
				$('#atd_qymc').text('场所名称');
			}else{
			    $('#atd_qymc').text('企业名称');
			}
	    }
		
	function updatediv (json) { 
		$("#m_qyid").attr("value",setNull(json.LLhjc[0].qyid));
		$("#m_lhjcid").append(setNull(json.LLhjc[0].lhjcid));
		$("#m_glbmlhjcdjxh").append(setNull(json.LLhjc[0].glbmlhjcdjxh));
		$("#m_lcjgjbdm").append(setNull(json.LLhjc[0].lcjgjbdm));
		$("#m_lcjgjb").append(setNull(json.LLhjc[0].lcjgjb));
		$("#m_lcjglxdm").append(setNull(json.LLhjc[0].lcjglxdm));
		$("#m_lcjglx").append(setNull(json.LLhjc[0].lcjglx));
		$("#m_lcjgdm").append(setNull(json.LLhjc[0].lcjgdm));
		$("#m_lcjgmc").append(setNull(json.LLhjc[0].lcjgmc));
		$("#m_lcsj").append(setNull(json.LLhjc[0].lcsj));
		$("#m_lcryxm").append(setNull(json.LLhjc[0].lcryxm));
		$("#m_lcsx").append(setNull(json.LLhjc[0].lcsx));
		$("#m_qymc").append(setNull(json.LLhjc[0].qymc));
		$("#m_fxwt").attr("value",setNull(json.LLhjc[0].fxwt));
		$("#m_lcjg").attr("value",setNull(json.LLhjc[0].lcjg));
		
		
		if(setNull(json.LLhjc[0].hylbdm)=='J'||setNull(json.LLhjc[0].hylbdm)=='K'){
			$('#atd_qymc').text('场所名称');
		}
	}	
</script>
<input type="hidden" id="q_lhjcid">
<input type="hidden" id="a_hylbdm" value="">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#lhjc_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td width='15%' style="border:1px dotted  #d7d7d7;text-align:right;">管理部门联合检查登记序号</td>
		<td width='35%'  class="detailtd2" ><span  id="m_glbmlhjcdjxh" value=""/></td>
		<td width='20%'  class="distd1">联查机构级别</td>
		<td width='30%' class="detailtd2" >
		<span id="m_lcjgjb" value=""/>
		</td>
	</tr>
	<tr height="20">
		<td class="distd1" >联查机构类型</td>
		<td class="detailtd2">
		<span id="m_lcjglx" value=""/>
		</td>
		<td class="distd1">联查机构名称</td>
		<td class="detailtd2" style="width: 160px;"><span id="m_lcjgmc" value=""/></td>
	</tr>
	<tr height="20">
		
		<td class="distd1" width="20%">联查时间</td>
		<td class="detailtd2" width="30%"><span id="m_lcsj" value=""/></td>
		<td class="distd1" width="20%">联查人员姓名</td>
		<td class="detailtd2" width="30%"><span  id="m_lcryxm" value=""/></td>
	</tr>
	<tr height="20">
		
		<td class="distd1" width="20%">联查事项</td>
		<td class="detailtd2" width="30%" style="width: 200px;" ><span id="m_lcsx" value=""/></td>
		<td class="distd1" id="atd_qymc" width="20%">企业名称</td>
		<td class="detailtd2" width="30%" style="width: 100px;" ><span id="m_qymc" value=""/></td>
	</tr>
	
	<tr height="20">
		<td class="distd1" valign="top">发现问题</td>
		<td class="detailtd2" colspan="3"><textarea id="m_fxwt" cols="49" rows="5" readonly="readonly"></textarea></td>
	</tr>
	<tr height="20">
		<td class="distd1" valign="top">联查结果</td>
		<td class="detailtd2" colspan="3"><textarea id="m_lcjg" cols="49" rows="5" readonly="readonly"></textarea></td>
	</tr>
</table>