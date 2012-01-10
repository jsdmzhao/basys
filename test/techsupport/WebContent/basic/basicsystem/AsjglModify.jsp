<%@ page language="java" pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd ");
	String currDate = sdf.format(new Date());
%>
<script type="text/javascript">
	var currDate = "<%=currDate%>";
	$(document).ready(function() {
		bc_bottonMoveRight(); //将保存按钮右移
		$("#q_asjglid").attr("value",dataid);
		$("#m_asjglid").attr("value",dataid);
		setDetail();
		$("#m_fasj").attr("readonly","true");
		$("#m_fasj").datepicker(true);
		$("#m_larq").attr("readonly","true");
		$("#m_larq").datepicker();
		$("#m_parq").attr("readonly","true");
		$("#m_parq").datepicker();
		
		$("#m_hylbdm").setAttr("readonly",true)
		
		
		$("#m_ajlbdm").selectBox({code:"dm_ajlx"});
		$("#m_ajxzdm").selectBox({code:"dm_ajxz"});
		$("#m_ajlydm").selectBox({code:"dm_ajly"});
		$("#m_hylbdm").selectBox({code:"dm_hylb"});	
		$("#m_qyzrdm").selectBox({code:"dm_cszr"});

		$("#m_fasjjt").attr("value",currDate+"23:59:59");
		$("#m_dqsj").attr("value",currDate);
		
		//$("#m_qyryjsdm").selectBox({code:"dm_cyrylb"});
		 $("#m_qyryjsdm").selectBox({state:"1"});   
	}); 
	function updatediv (json) { 
		$("#m_asjglid").attr("value",setNull(json.LAsjgl[0].asjglid));
		$("#m_larq").attr("value",setNull(json.LAsjgl[0].larq));
		$("#m_parq").attr("value",setNull(json.LAsjgl[0].parq));
		$("#m_qybm").attr("value",setNull(json.LAsjgl[0].qybm));
		$("#m_qymc").attr("value",setNull(json.LAsjgl[0].qymc));
		$("#m_ajbh").attr("value",setNull(json.LAsjgl[0].ajbh));
		$("#m_ladw").attr("value",setNull(json.LAsjgl[0].ladw));
		$("#m_ladwbm").attr("value",setNull(json.LAsjgl[0].ladwbm));
		$("#m_qkms").attr("value",setNull(json.LAsjgl[0].qkms));
		
		$("#m_hylbdm").setValue(setNull(json.LAsjgl[0].hylbdm));
		$("#m_ajxzdm").setValue(setNull(json.LAsjgl[0].ajxzdm));
		$("#m_ajlbdm").setValue(setNull(json.LAsjgl[0].ajlbdm));
		$("#m_ajlydm").setValue(setNull(json.LAsjgl[0].ajlydm));
		$("#m_qyzrdm").setValue(setNull(json.LAsjgl[0].qyzrdm));
		
		
		$("#m_fasj").attr("value",setNull(json.LAsjgl[0].fasj));
		$("#m_ssdwmc").attr("value",setNull(json.LAsjgl[0].ssdwmc));
		$("#m_djr").attr("value",setNull(json.LAsjgl[0].djr));
		$("#m_djdwmc").attr("value",setNull(json.LAsjgl[0].djdwmc));
		$("#m_djsj").attr("value",setNull(json.LAsjgl[0].djsj));
		$("#m_ssdwbm").attr("value",setNull(json.LAsjgl[0].ssdwbm));
		
		//alert(json.LAsjgl[0].hylbdm);
		var hylbdmTemp = setNull(json.LAsjgl[0].hylbdm);
		
		 hy_lbselectBox(hylbdmTemp,"m_qyryjsdm");
		/**
		if(hylbdmTemp == "J"){
		    $("#m_qyryjsdm").selectBox({clear:"1"});////清空下拉框
	        $("#m_qyryjsdm").selectBox({code:"dm_cyrylb"});
		}else if(hylbdmTemp == "A"){
		    $("#m_qyryjsdm").selectBox({clear:"1"});////清空下拉框
	        $("#m_qyryjsdm").selectBox({code:"dm_lgyrylb"});
		}else if(hylbdmTemp == "E03"){
		    $("#m_qyryjsdm").selectBox({clear:"1"});////清空下拉框
	        $("#m_qyryjsdm").selectBox({code:"dm_ddyrylb"});
		}else if(hylbdmTemp == "B"){
		    $("#m_qyryjsdm").selectBox({code:"dm_yzyrylb"});////清空下拉框
		}**/
		
		$("#m_qyryjsdm").setValue(setNull(json.LAsjgl[0].qyryjsdm));
		if($("#m_hylbdm").attr("value") == "N"){ 			
			$("#m_djsj").attr("class","readonly");
		}else{
			$("#m_djsj").attr("readonly","true");
			$("#m_djsj").datepicker();
		}
		setHyxx_modify();
	}	
	function modifyVerify(){
		$("#m_ajlb").val($("#m_ajlbdm").attr("title"));	
		$("#m_ajxz").val($("#m_ajxzdm").attr("title"));	
		$("#m_ajly").val($("#m_ajlydm").attr("title"));	
		$("#m_qyzr").val($("#m_qyzrdm").attr("title"));	
		$("#m_qyryjs").val($("#m_qyryjsdm").attr("title"));	
		$("#m_hylb").val($("#m_hylbdm").attr("title"));
		if (!checkControlValue("m_hylbdm","Select",1,4,null,1,"行业类别"))
			return false;
		if (!checkControlValue("m_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("m_qymc","String",1,200,null,1,"企业名称"))
			return false;
		//判断发案日期不能大于今天
		if (!checkControlValue("m_fasj","Datetime",null,null,null,1,"发案时间"))
			return false;
		if (!checkDateEarlier("m_fasj","发案时间","m_fasjjt","当天时间","DATETIME"))
			return false;
		//结束
		if (!checkControlValue("m_ajxz","Select",1,60,null,1,"案件性质"))
			return false;
		if (!checkControlValue("m_ajlb","Select",1,60,null,1,"案件类型"))
			return false;
		if (!checkControlValue("m_ssdwmc","String",1,100,null,1,"治安管辖机构"))
			return false;
		if (!checkControlValue("m_djr","String",1,30,null,0,"登记人"))
			return false;
		if (!checkControlValue("m_djsj","Date",null,null,null,0,"登记时间"))
			return false;
		if (!checkControlValue("m_ladw","String",1,100,null,1,"立案单位"))
			return false;
		//判断立案日期，立案日期不能小于发案日期
		if (!checkControlValue("m_larq","Datetime",null,null,null,1,"立案日期"))
			return false;
		if (!checkDateEarlier("m_larq","立案日期","m_dqsj","当天时间","DATE"))
			return false;
		if (!checkDateEarlier("m_fasj","发案时间","m_larq","立案日期","DatetimeAndDate"))
			return false;	
		//这个判断要在破案日期填写了的情况下,去检验这个时间的先后,不为空，返回true
		if(checkIsNotEmpty($("#m_parq").attr("value"))){
			if (!checkDateEarlier("m_parq","破案日期","m_dqsj","当天时间","DATE"))
				return false;
			//判断破案日期，破案日期不能小于发案日期
			if (!checkDateEarlier("m_fasj","发案日期","m_parq","破案日期","DatetimeAndDate"))
				return false;
			//判断破案日期不能小于立案日期
			if (!checkDateEarlier("m_larq","立案日期","m_parq","破案日期","DATE"))
				return false;	
		}
		return true;
	}
	
			//服务场所筛选框
 
	//管辖单位所筛选框
	 $("#m_ssdwmc").click(function(){
		//getGxdwTree("m_ssdwmc","m_ssdwbm","1");
		getGxdwTree("m_ssdwmc",null,"m_ssdwbm",null,null,null,null,null);
	});
	 $("#m_ladw").click(function(){
		//getGxdwTree("m_ladw","m_ladwbm","1");
		getGxdwTree("m_ladw",null,"m_ladwbm",null,null,null,null,null);
	});
	//设定行业信息表示
    function setHyxx_modify(){
        var hylb=$("#m_hylbdm").attr("value");
		if(hylb=='J'||hylb=='K'){
			$('#mtd_qymc').text('场所名称');
			$('#mtd_qybm').text('场所代码');
			$('#mtd_qyzr').text('场所责任');
			$('#mtd_qyryjs').text('场所/人员角色');
			$('#ajbh_title').show();
		    $('#ajbh_conte').show();
		}else{
		    $('#mtd_qymc').text('企业名称');
		    $('#mtd_qybm').text('企业代码');
		    $('#ajbh_title').hide();
		    $('#ajbh_conte').hide();
		}
    }
    $("#m_hylbdm").change(function(){
    	if($("#a_hylbdm").attr("value") == "N"){ //内保单位
			$("#m_djsj").attr("class","readonly");
	  	}else{
			$("#m_djsj").attr("readonly","true");
			$("#m_djsj").datepicker();
	  	}
    });
</script>
<input type="hidden" id="q_asjglid">
<input type="hidden" id="m_asjglid">

<input type="hidden" id="m_ajlb" />
<input type="hidden" id="m_ajxz" />
<input type="hidden" id="m_ajly" />
<input type="hidden" id="m_qyzr" />
<input type="hidden" id="m_qyryjs" />
<input type="hidden" id="m_hylb" />
<input type="hidden" id="m_ssdwbm" />
<input type="hidden" id="m_ladwbm" />
<input type="hidden" id="m_fasjjt" />
<input type="hidden" id="m_dqsj" />
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			场所发案情况修改
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='$("#asjgl_detail").hideAndRemove(&quot;show&quot;);'class="close"></a>
		</td>
	</tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td width="15%" class="red">行业类别</td>
		<td width="34%" class="detailtd">
			<select type="select" id="m_hylbdm">
			</select>
		</td>
		<td width="17%" class="red" id="mtd_qymc">企业名称		</td>
  		<td width="34%" class="detailtd">
			<input type="text" readonly="readonly" class="readonly" id="m_qymc"value="">
		</td>

  </tr>
	<tr height="20">
		<td class="red" id="mtd_qybm">企业代码</td>
		<td class="detailtd">
 			<input type="text" id="m_qybm"  readonly="readonly" class="readonly" />
		</td>
		<td class="distd" id="ajbh_title">案件编号</td>
		<td class="detailtd" id="ajbh_conte"><input type="text" id="m_ajbh" class="inputstyle"/></td>
	</tr>
	<tr height="20">	
		<td class="distd">
			案件来源
		</td>
		<td class="detailtd">
			<select type="select" id="m_ajlydm" value="">
				<option></option>
			</select>
		</td>
		<td class="red">
			发案时间
		</td>
		<td class="detailtd">
			 <input type="text" class="inputstyle" id="m_fasj" value="">
		</td>
	</tr>
	<tr height="20">
		<td class="red">
			案件性质
		</td>
		<td class="detailtd">
			<select type="select" id="m_ajxzdm" value="">
				<option></option>
			</select>
		</td>
		<td class="red">
			案件类别
		</td>
		<td class="detailtd">
			<select type="select" id="m_ajlbdm" value="">
				<option></option>
			</select>
		</td>
	</tr>
	<tr height="20">
		<td class="red">
			治安管辖机构
		</td>
		<td class="detailtd">
			<input type="text" readonly="readonly" id="m_ssdwmc" value="" class="inputstyle" >
		</td>
		<td class="distd">
			登记人
		</td>
		<td class="detailtd">
			<input type="text" readonly="readonly" class="readonly" id="m_djr"
				value="">
		</td>
	</tr>
	<tr height="20">
		<td class="distd">
			登记时间
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" readonly="readonly" id="m_djsj"
				value="">
		</td>
		<td class="red">
			立案单位
		</td>
		<td class="detailtd">
		  <input type="text" class="inputstyle" id="m_ladw" value="" readonly="readonly">
		</td>
	</tr>
	<tr height="20">
		<td class="distd">
			立案日期
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="m_larq" value="">
		</td>
		<td class="distd">
			破案日期
		</td>
		<td class="detailtd">
			<input type="text" class="inputstyle" id="m_parq" value="">
		</td>
	</tr>
	<tr height="20">
		<td class="distd" id="mtd_qyzr">
			企业责任
		</td>
		<td class="detailtd">
			<select type="select" id="m_qyzrdm" value="">
				<option></option>
			</select>
		</td>
		<td class="distd" id="mtd_qyryjs" width="16%">
			企业/人员角色
		</td>
		<td class="detailtd">
			<select type="select" id="m_qyryjsdm" value="">
				<option></option>
			</select>
		</td>
	</tr>
	<tr height="20">
		<td class="distd">
			情况描述
		</td>
		<td colspan="3" class="detailtd">
			<textarea name="textarea" id="m_qkms" style="width:425px" rows="5"></textarea>
		</td>
	</tr>
	<tr align="center">
		<td colspan="4">
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="提交" onclick='setUpdate();'>保存</a>
		</td>
	</tr>
</table>
