<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	
	    bc_bottonMoveRight(39); 
	
		daggleDiv(detailid);
		$("#q_lhjcid").attr("value",dataid);
		$("#m_lhjcid").attr("value",dataid);
		$("#m_lcjgjbdm").selectBox({code:"dm_lcjgjb"});
		$("#m_lcjglxdm").selectBox({code:"dm_lcjglx"});
		$("#m_lcjgjbdm").change(function(){
			$("#m_lcjgjb").val($("#m_lcjgjbdm").attr('title'));
		});
		$("#m_lcjglxdm").change(function(){
			$("#m_lcjglx").val($("#m_lcjglxdm").attr('title'));
		});
		setDetail();
		$("#m_lcsj").attr("readonly","true");
		$("#m_lcsj").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_qyid").attr("value",setNull(json.LLhjc[0].qyid));
		$("#m_lhjcid").attr("value",setNull(json.LLhjc[0].lhjcid));
		$("#m_glbmlhjcdjxh").attr("value",setNull(json.LLhjc[0].glbmlhjcdjxh));
		$("#m_lcjgjbdm").attr("value",setNull(json.LLhjc[0].lcjgjbdm));
		$("#m_lcjgjb").attr("value",setNull(json.LLhjc[0].lcjgjb));
		$("#m_lcjglxdm").attr("value",setNull(json.LLhjc[0].lcjglxdm));
		$("#m_lcjglx").attr("value",setNull(json.LLhjc[0].lcjglx));
		$("#m_lcjgdm").attr("value",setNull(json.LLhjc[0].lcjgdm));
		$("#m_lcjgmc").attr("value",setNull(json.LLhjc[0].lcjgmc));
		$("#m_lcsj").attr("value",setNull(json.LLhjc[0].lcsj));
		$("#m_lcryxm").attr("value",setNull(json.LLhjc[0].lcryxm));
		$("#m_lcsx").attr("value",setNull(json.LLhjc[0].lcsx));
		$("#m_fxwt").attr("value",setNull(json.LLhjc[0].fxwt));
		$("#m_lcjg").attr("value",setNull(json.LLhjc[0].lcjg));
		$("#m_lcjgjbdm").setValue(setNull(json.LLhjc[0].lcjgjbdm));
		$("#m_lcjglxdm").setValue(setNull(json.LLhjc[0].lcjglxdm));
		$("#m_qymc").attr("value",setNull(json.LLhjc[0].qymc));
		
		if(setNull(json.LLhjc[0].hylbdm)=='J'||setNull(json.LLhjc[0].hylbdm)=='K'){
			$('#atd_qymc').text('场所名称');
		}
	}	

	 function setHyxx_mod(){
	        var hylb=$("#a_hylbdm").attr("value");
			if(hylb=='J'||hylb=='K'){
				$('#atd_qymc').text('场所名称');
			}else{
			    $('#atd_qymc').text('企业名称');
			}
	    }
	
	function modifyVerify(){
		if (!checkControlValue("m_glbmlhjcdjxh","String",1,30,null,1,"管理部门联合检查登记序号"))
			return false;
		if (!checkControlValue("m_lcjgjb","String",1,30,null,1,"联查机构级别"))
			return false; 
		if (!checkControlValue("m_lcjglx","String",1,30,null,1,"联查机构类型"))
			return false; 
		if (!checkControlValue("m_lcjgmc","String",1,100,null,1,"联查机构名称"))
			return false; 
		if (!checkControlValue("m_lcsj","Date",null,null,null,1,"联查时间"))
			return false;
		if (!checkControlValue("m_lcryxm","String",1,300,null,1,"联查人员姓名"))
			return false;
		if (!checkControlValue("m_lcsx","String",1,200,null,1,"联查事项"))
			return false;
		if (!checkControlValue("m_fxwt","String",1,300,null,1,"发现问题"))
			return false;
		if (!checkControlValue("m_lcjg","String",1,200,null,1,"联查结果"))
			return false;
		return true;
	}
	function setUpdate(){
	if (modifyVerify()){
		setParams("m_");
		jQuery.post(modUrl,params,updateback,"json"); 
		return true;
	}else{
		return false;
	}		
}
</script>
<input type="hidden" id="q_lhjcid">
<input type="hidden" id="m_lhjcid">
<input type="hidden" id="m_qyid">
<input type="hidden" id="a_hylbdm">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#lhjc_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td width='15%' class="distd">管理部门联合检查登记序号</td>
		<td width='30%' class="detailtd"><input type="text" class="readonly" id="m_glbmlhjcdjxh" value="" readonly="readonly"></td>
		<td width='20%' class="distd">联查机构级别</td>
		<td width='35%' class="detailtd">
		<input type="hidden" class="inputstyle" id="m_lcjgjb" value="">
		<select id="m_lcjgjbdm"></select>
		</td>
	</tr>
	<tr height="20">
		<td class="distd">联查机构类型</td>
		<td class="detailtd">
		<input type="hidden" class="inputstyle" id="m_lcjglx" value="">
		<select id="m_lcjglxdm"></select>
		</td>
		<td class="red">联查机构名称</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_lcjgmc" value=""></td>
	</tr>
	<tr height="20">
		
		<td class="red">联查时间</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_lcsj" value=""></td>
		<td class="distd">联查人员姓名</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_lcryxm" value=""></td>
	</tr>
	<tr height="20">
		
		<td class="red">联查事项</td>
		<td class="detailtd"><input type="text" class="inputstyle" id="m_lcsx" value=""></td>
		<td class="distd" id="atd_qymc" >企业名称</td>
		<td class="detailtd"><input type="text" class="readonly" id="m_qymc" value="" readonly="readonly"></td>
	</tr>
	
	<tr height="20">
		<td class="red" valign="top">发现问题</td>
		<td class="detailtd" colspan="3"><textarea id="m_fxwt" cols="51" rows="5"></textarea></td>
	</tr>
	<tr height="20">
		<td class="red" valign="top">联查结果</td>
		<td class="detailtd" colspan="3"><textarea id="m_lcjg" cols="51" rows="5"></textarea></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
