<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_cljbxxid").attr("value",dataid);
		$("#m_cljbxxid").attr("value",dataid);
		setDetail();
		$("#m_zatlq").attr("readonly","true");
		$("#m_zatlq").datepicker();
		$("#m_rjrq").attr("readonly","true");
		$("#m_rjrq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_cljbxxid").attr("value",setNull(json.LClxxwgryxx[0].cljbxxid));
		$("#m_wgrxxid").attr("value",setNull(json.LClxxwgryxx[0].wgrxxid));
		$("#m_wgrylb").attr("value",setNull(json.LClxxwgryxx[0].wgrylb));
		$("#m_ywx").attr("value",setNull(json.LClxxwgryxx[0].ywx));
		$("#m_ywm").attr("value",setNull(json.LClxxwgryxx[0].ywm));
		$("#m_qzzldm").attr("value",setNull(json.LClxxwgryxx[0].qzzldm));
		$("#m_qzzl").attr("value",setNull(json.LClxxwgryxx[0].qzzl));
		$("#m_qzhm").attr("value",setNull(json.LClxxwgryxx[0].qzhm));
		$("#m_zatlq").attr("value",setNull(json.LClxxwgryxx[0].zatlq));
		$("#m_qfjg").attr("value",setNull(json.LClxxwgryxx[0].qfjg));
		$("#m_rjrq").attr("value",setNull(json.LClxxwgryxx[0].rjrq));
		$("#m_rjka").attr("value",setNull(json.LClxxwgryxx[0].rjka));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_cljbxxid","Integer",-9999999999,9999999999,null,0,"车辆基本信息ID"))
			return false;
		if (!checkControlValue("m_wgrxxid","Integer",-9999999999,9999999999,null,0,"外国人信息ID"))
			return false;
		if (!checkControlValue("m_wgrylb","String",1,2,null,0,"外国人员类别"))
			return false;
		if (!checkControlValue("m_ywx","String",1,60,null,0,"英文姓"))
			return false;
		if (!checkControlValue("m_ywm","String",1,60,null,0,"英文名"))
			return false;
		if (!checkControlValue("m_qzzldm","String",1,40,null,0,"签证种类代码"))
			return false;
		if (!checkControlValue("m_qzzl","String",1,100,null,0,"签证种类"))
			return false;
		if (!checkControlValue("m_qzhm","String",1,20,null,0,"签证号码"))
			return false;
		if (!checkControlValue("m_zatlq","Date",null,null,null,0,"在华停留期至"))
			return false;
		if (!checkControlValue("m_qfjg","String",1,120,null,0,"签发机关"))
			return false;
		if (!checkControlValue("m_rjrq","Date",null,null,null,0,"入境日期"))
			return false;
		if (!checkControlValue("m_rjka","String",1,60,null,0,"入境口岸"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_cljbxxid">
<input type="hidden" id="m_cljbxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Clxxwgryxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">车辆基本信息ID</td>
		<td class="detailtd"><input type="text" id="m_cljbxxid" value="0"></td>
		<td class="distd">外国人信息ID</td>
		<td class="detailtd"><input type="text" id="m_wgrxxid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">外国人员类别</td>
		<td class="detailtd"><input type="text" id="m_wgrylb" value=""></td>
		<td class="distd">英文姓</td>
		<td class="detailtd"><input type="text" id="m_ywx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">英文名</td>
		<td class="detailtd"><input type="text" id="m_ywm" value=""></td>
		<td class="distd">签证种类代码</td>
		<td class="detailtd"><input type="text" id="m_qzzldm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">签证种类</td>
		<td class="detailtd"><input type="text" id="m_qzzl" value=""></td>
		<td class="distd">签证号码</td>
		<td class="detailtd"><input type="text" id="m_qzhm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">在华停留期至</td>
		<td class="detailtd"><input type="text" id="m_zatlq" value=""></td>
		<td class="distd">签发机关</td>
		<td class="detailtd"><input type="text" id="m_qfjg" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">入境日期</td>
		<td class="detailtd"><input type="text" id="m_rjrq" value=""></td>
		<td class="distd">入境口岸</td>
		<td class="detailtd"><input type="text" id="m_rjka" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
