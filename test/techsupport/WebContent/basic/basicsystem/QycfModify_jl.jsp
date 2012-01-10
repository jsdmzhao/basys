<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qycfid").attr("value",dataid);
		$("#m_qycfid").attr("value",dataid);
		detailUrl="basicsystem/query_qycf.action";
		setDetail();
		$("#m_cfrq").attr("readonly","true");
		$("#m_cfrq").datepicker();
		$("#m_djsj").attr("readonly","true");
		$("#m_djsj").datepicker();
		$("#m_hylbdm").setAttr("readonly",true)
		
		$("#m_hylbdm").selectBox({code:"dm_hylb"});
		
		//$("#m_cfjgdm").selectBox({code:"dm_cljg"});
		$("#a_cfjgdm").selectBox({state:"dm_qyjllb"});
	}); 
	function updatediv (json) { 
		$("#m_qycfid").attr("value",setNull(json.LQycf[0].qycfid));
		
		
		if(json.LQycf[0].hylbdm==null || json.LQycf[0].hylbdm.length ==0 ){
	        $("#m_cfjgdm").selectBox({clear:"1"});
	        
	     }else if(json.LQycf[0].hylbdm == "B"){ ///机修业
	     
	       $("#m_cfjgdm").selectBox({code:"dm_qyjllb"});
	      
	     }else if(json.LQycf[0].hylbdm == "C"){ ///机修业
	        
	        $("#m_cfjgdm").selectBox({code:"dm_qyjllb"});
	        
	     }else{
	     
	        $("#m_cfjgdm").selectBox({code:"dm_qyjllb"});
	     }
	    $("#m_hylbdm").setValue(setNull(json.LQycf[0].hylbdm));
		
		$("#m_qybm").attr("value",setNull(json.LQycf[0].qybm));
		$("#m_qymc").attr("value",setNull(json.LQycf[0].qymc));
		$("#m_ssdwbm").attr("value",setNull(json.LQycf[0].ssdwbm));
		$("#m_ssdwmc").attr("value",setNull(json.LQycf[0].ssdwmc));
		$("#m_wgqkms").attr("value",setNull(json.LQycf[0].wgqkms));
		
		$("#m_cfjgdm").setValue(setNull(json.LQycf[0].cfjgdm));
		$("#m_cfzxrxm").attr("value",setNull(json.LQycf[0].cfzxrxm));
		$("#m_cfrq").attr("value",setNull(json.LQycf[0].cfrq));
		$("#m_djsj").attr("value",setNull(json.LQycf[0].djsj));
		$("#m_djr").attr("value",setNull(json.LQycf[0].djr));
		$("#m_bz").attr("value",setNull(json.LQycf[0].bz));
		
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qycfid","Integer",-9999999999,9999999999,null,0,"奖励ID"))
			return false;
		if (!checkControlValue("m_hylbdm","Select",1,3,null,1,"行业类别"))
			return false;
		if (!checkControlValue("m_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("m_qymc","String",1,200,null,0,"企业名称"))
			return false;
		if (!checkControlValue("m_ssdwbm","String",1,20,null,0,"所属单位编码"))
			return false;
		if (!checkControlValue("m_ssdwmc","String",1,100,null,0,"所属单位名称"))
			return false;
		if (!checkControlValue("m_wgqkms","String",1,2000,null,1,"奖励原因"))
			return false;
		if (!checkControlValue("m_cfjgdm","Select",1,20,null,1,"奖励结果"))
			return false;
		if (!checkControlValue("m_cfzxrxm","String",1,100,null,1,"奖励人"))
			return false;
		if (!checkControlValue("m_cfrq","Date",null,null,null,0,"奖励日期"))
			return false;
			
		//判断奖励日期不能大于今天
		if(!compare_now($("#m_cfrq").attr("value"),"奖励日期")){
			jAlert('奖励日期不能大于今天!','验证信息');
			//$("#m_cfrq").attr("value","");//不清空
			return false;
		}
			
		if (!checkControlValue("m_djsj","Date",null,null,null,0,"登记时间"))
			return false;
		if (!checkControlValue("m_djr","String",1,30,null,0,"登记人"))
			return false;
		if (!checkControlValue("m_bz","String",1,2000,null,0,"备注"))
			return false;
		$("#m_cfjg").val($("#m_cfjgdm").attr("title"));		
		$("#m_hylb").val($("#m_hylbdm").attr("title"));	
		return true;
	}
</script>
<input type="hidden" id="q_qycfid">
<input type="hidden" id="m_qycfid">
<input type="hidden" id="m_cfjg">
<input type="hidden" id="m_hylb">
<input type="hidden" id="m_qybm">
<input type="hidden" id="m_ssdwbm">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			企业奖励修改
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='$("#qycf_detail").hideAndRemove(&quot;show&quot;);' class="close">
			</a>
		</td>
	</tr>
</table>
<table width="100%" id="modify">
	<tr>
		<td class="red">
			企业名称
		</td>
		<td colspan="3" class="detailtd">
			<input type="text" readonly="readonly" class="readonly" id="m_qymc"
				style="width:410px;" value="">
		</td>
	</tr>
	<tr>
		<td width="17%" class="distd">
			奖励日期
		</td>
		<td width="32%" class="detailtd">
			<input type="text" class="inputstyle" id="m_cfrq" value="">
		</td>
		<td class="red" width="14%">
			行业类别		</td>
  <td width="37%" class="detailtd">
<select type="select" id="m_hylbdm">
				<option></option>
			</select>
		</td>
  </tr>
	<tr>
		<td class="red">
			奖励人
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="m_cfzxrxm" value="">
		</td>
		<td class="red">
			奖励结果
		</td>
		<td class="detailtd">
			<select type="select" id="m_cfjgdm" value="">
				<option></option>
			</select>
		</td>
	</tr>
	<tr>
		<td class="distd">
			登记人
		</td>
		<td class="detailtd">
			<input type="text" readonly="readonly" class="readonly" id="m_djr"
				value="">
		</td>
		<td class="distd">
			登记时间
		</td>
		<td class="detailtd">
			<input type="text" readonly="readonly" class="readonly" id="m_djsj"
				value="">
		</td>
	</tr>
	<tr>
		<td class="distd">
			所属单位名称
		</td>
		<td class="detailtd" colspan="3">
			<input type="text" readonly="readonly" class="readonly"
				style="width:410px;" id="m_ssdwmc" value="">
		</td>
	</tr>
	<tr>
		<td class="red">
			奖励原因
		</td>
		<td colspan="3" class="detailtd">
			<textarea name="textarea" id="m_wgqkms" style="width:410px;"></textarea>
		</td>
	</tr>
	<tr>
		<td class="distd">
			备注
		</td>
		<td colspan="3" class="detailtd">
			<textarea name="textarea" id="m_bz" style="width:410px;"></textarea>
		</td>
	</tr>
	<tr align="center">
		<td colspan="6" height="8"></td>
	</tr>
	<tr align="center">
		<td colspan="6">
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="保存" onclick='setUpdate();'>保存</a>
		</td>
	</tr>
</table>

