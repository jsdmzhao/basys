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
		$("#m_slsj").attr("readonly","true");
		$("#m_slsj").datepicker();
		$("#m_lrsj").attr("readonly","true");
		$("#m_lrsj").datepicker();
		$("#m_cxsj").attr("readonly","true");
		$("#m_cxsj").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_cljbxxid").attr("value",setNull(json.LCljbxx[0].cljbxxid));
		$("#m_cldjxh").attr("value",setNull(json.LCljbxx[0].cldjxh));
		$("#m_cllxbm").attr("value",setNull(json.LCljbxx[0].cllxbm));
		$("#m_cllx").attr("value",setNull(json.LCljbxx[0].cllx));
		$("#m_clppbm").attr("value",setNull(json.LCljbxx[0].clppbm));
		$("#m_clpp").attr("value",setNull(json.LCljbxx[0].clpp));
		$("#m_cszsbm").attr("value",setNull(json.LCljbxx[0].cszsbm));
		$("#m_cszs").attr("value",setNull(json.LCljbxx[0].cszs));
		$("#m_dyfsbm").attr("value",setNull(json.LCljbxx[0].dyfsbm));
		$("#m_dyfs").attr("value",setNull(json.LCljbxx[0].dyfs));
		$("#m_drfsbm").attr("value",setNull(json.LCljbxx[0].drfsbm));
		$("#m_drfs").attr("value",setNull(json.LCljbxx[0].drfs));
		$("#m_cph").attr("value",setNull(json.LCljbxx[0].cph));
		$("#m_sfycphbz").attr("value",setNull(json.LCljbxx[0].sfycphbz));
		$("#m_wcphyybm").attr("value",setNull(json.LCljbxx[0].wcphyybm));
		$("#m_wcphyy").attr("value",setNull(json.LCljbxx[0].wcphyy));
		$("#m_wcphyyms").attr("value",setNull(json.LCljbxx[0].wcphyyms));
		$("#m_hpzlbm").attr("value",setNull(json.LCljbxx[0].hpzlbm));
		$("#m_hpzl").attr("value",setNull(json.LCljbxx[0].hpzl));
		$("#m_fdjh").attr("value",setNull(json.LCljbxx[0].fdjh));
		$("#m_cjh").attr("value",setNull(json.LCljbxx[0].cjh));
		$("#m_slsj").attr("value",setNull(json.LCljbxx[0].slsj));
		$("#m_slr").attr("value",setNull(json.LCljbxx[0].slr));
		$("#m_lrsj").attr("value",setNull(json.LCljbxx[0].lrsj));
		$("#m_lrr").attr("value",setNull(json.LCljbxx[0].lrr));
		$("#m_cxsj").attr("value",setNull(json.LCljbxx[0].cxsj));
		$("#m_cxbz").attr("value",setNull(json.LCljbxx[0].cxbz));
		$("#m_cxr").attr("value",setNull(json.LCljbxx[0].cxr));
		$("#m_clxz").attr("value",setNull(json.LCljbxx[0].clxz));
		$("#m_czm").attr("value",setNull(json.LCljbxx[0].czm));
		$("#m_czdh").attr("value",setNull(json.LCljbxx[0].czdh));
		$("#m_czgjdm").attr("value",setNull(json.LCljbxx[0].czgjdm));
		$("#m_czgj").attr("value",setNull(json.LCljbxx[0].czgj));
		$("#m_czhjdz").attr("value",setNull(json.LCljbxx[0].czhjdz));
		$("#m_czxzqhdm").attr("value",setNull(json.LCljbxx[0].czxzqhdm));
		$("#m_czxzqh").attr("value",setNull(json.LCljbxx[0].czxzqh));
		$("#m_czxbdm").attr("value",setNull(json.LCljbxx[0].czxbdm));
		$("#m_czxb").attr("value",setNull(json.LCljbxx[0].czxb));
		$("#m_czcyzjlxdm").attr("value",setNull(json.LCljbxx[0].czcyzjlxdm));
		$("#m_czcyzj").attr("value",setNull(json.LCljbxx[0].czcyzj));
		$("#m_czzjhm").attr("value",setNull(json.LCljbxx[0].czzjhm));
		$("#m_xslc").attr("value",setNull(json.LCljbxx[0].xslc));
		$("#m_clzt").attr("value",setNull(json.LCljbxx[0].clzt));
		$("#m_bz").attr("value",setNull(json.LCljbxx[0].bz));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_cljbxxid","Integer",-9999999999,9999999999,null,0,"车辆基本信息ID"))
			return false;
		if (!checkControlValue("m_cldjxh","String",1,24,null,0,"车辆登记序号"))
			return false;
		if (!checkControlValue("m_cllxbm","String",1,1,null,0,"车辆类型编码"))
			return false;
		if (!checkControlValue("m_cllx","String",1,32,null,0,"车辆类型"))
			return false;
		if (!checkControlValue("m_clppbm","String",1,10,null,0,"车辆品牌编码"))
			return false;
		if (!checkControlValue("m_clpp","String",1,32,null,0,"车辆品牌"))
			return false;
		if (!checkControlValue("m_cszsbm","String",1,3,null,0,"车身主色编码"))
			return false;
		if (!checkControlValue("m_cszs","String",1,4,null,0,"车身主色"))
			return false;
		if (!checkControlValue("m_dyfsbm","String",1,3,null,0,"第一辅色编码"))
			return false;
		if (!checkControlValue("m_dyfs","String",1,4,null,0,"第一辅色"))
			return false;
		if (!checkControlValue("m_drfsbm","String",1,3,null,0,"第二辅色编码"))
			return false;
		if (!checkControlValue("m_drfs","String",1,4,null,0,"第二辅色"))
			return false;
		if (!checkControlValue("m_cph","String",1,15,null,0,"车牌号"))
			return false;
		if (!checkControlValue("m_sfycphbz","String",1,1,null,0,"是否有车牌标志"))
			return false;
		if (!checkControlValue("m_wcphyybm","String",1,2,null,0,"无车牌号原因编码"))
			return false;
		if (!checkControlValue("m_wcphyy","String",1,32,null,0,"无车牌号原因"))
			return false;
		if (!checkControlValue("m_wcphyyms","String",1,100,null,0,"无车牌号原因描述"))
			return false;
		if (!checkControlValue("m_hpzlbm","String",1,2,null,0,"号牌种类编码"))
			return false;
		if (!checkControlValue("m_hpzl","String",1,24,null,0,"号牌种类"))
			return false;
		if (!checkControlValue("m_fdjh","String",1,30,null,0,"发动机号"))
			return false;
		if (!checkControlValue("m_cjh","String",1,30,null,0,"车架号"))
			return false;
		if (!checkControlValue("m_slsj","Date",null,null,null,0,"受理时间"))
			return false;
		if (!checkControlValue("m_slr","String",1,100,null,0,"受理人"))
			return false;
		if (!checkControlValue("m_lrsj","Date",null,null,null,0,"录入时间"))
			return false;
		if (!checkControlValue("m_lrr","String",1,100,null,0,"录入人"))
			return false;
		if (!checkControlValue("m_cxsj","Date",null,null,null,0,"撤销时间"))
			return false;
		if (!checkControlValue("m_cxbz","String",1,2,null,0,"撤销标志"))
			return false;
		if (!checkControlValue("m_cxr","String",1,30,null,0,"撤销人"))
			return false;
		if (!checkControlValue("m_clxz","String",1,1,null,0,"车辆性质"))
			return false;
		if (!checkControlValue("m_czm","String",1,50,null,0,"车主"))
			return false;
		if (!checkControlValue("m_czdh","String",1,20,null,0,"车主电话"))
			return false;
		if (!checkControlValue("m_czgjdm","String",1,3,null,0,"车主国籍代码"))
			return false;
		if (!checkControlValue("m_czgj","String",1,40,null,0,"车主国籍"))
			return false;
		if (!checkControlValue("m_czhjdz","String",1,200,null,0,"车主户籍地址"))
			return false;
		if (!checkControlValue("m_czxzqhdm","String",1,6,null,0,"车主行政区划代码"))
			return false;
		if (!checkControlValue("m_czxzqh","String",1,200,null,0,"车主行政区划"))
			return false;
		if (!checkControlValue("m_czxbdm","String",1,1,null,0,"车主性别代码"))
			return false;
		if (!checkControlValue("m_czxb","String",1,2,null,0,"车主性别"))
			return false;
		if (!checkControlValue("m_czcyzjlxdm","String",1,4,null,0,"车主常用证件类型代码"))
			return false;
		if (!checkControlValue("m_czcyzj","String",1,40,null,0,"车主常用证件"))
			return false;
		if (!checkControlValue("m_czzjhm","String",1,20,null,0,"车主证件号码"))
			return false;
		if (!checkControlValue("m_xslc","Integer",-9999999999,9999999999,null,0,"行驶里程"))
			return false;
		if (!checkControlValue("m_clzt","String",1,2,null,0,"车辆状态"))
			return false;
		if (!checkControlValue("m_bz","String",1,2000,null,0,"备注"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_cljbxxid">
<input type="hidden" id="m_cljbxxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Cljbxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">车辆基本信息ID</td>
		<td class="detailtd"><input type="text" id="m_cljbxxid" value="0"></td>
		<td class="distd">车辆登记序号</td>
		<td class="detailtd"><input type="text" id="m_cldjxh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车辆类型编码</td>
		<td class="detailtd"><input type="text" id="m_cllxbm" value=""></td>
		<td class="distd">车辆类型</td>
		<td class="detailtd"><input type="text" id="m_cllx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车辆品牌编码</td>
		<td class="detailtd"><input type="text" id="m_clppbm" value=""></td>
		<td class="distd">车辆品牌</td>
		<td class="detailtd"><input type="text" id="m_clpp" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车身主色编码</td>
		<td class="detailtd"><input type="text" id="m_cszsbm" value=""></td>
		<td class="distd">车身主色</td>
		<td class="detailtd"><input type="text" id="m_cszs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">第一辅色编码</td>
		<td class="detailtd"><input type="text" id="m_dyfsbm" value=""></td>
		<td class="distd">第一辅色</td>
		<td class="detailtd"><input type="text" id="m_dyfs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">第二辅色编码</td>
		<td class="detailtd"><input type="text" id="m_drfsbm" value=""></td>
		<td class="distd">第二辅色</td>
		<td class="detailtd"><input type="text" id="m_drfs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车牌号</td>
		<td class="detailtd"><input type="text" id="m_cph" value=""></td>
		<td class="distd">是否有车牌标志</td>
		<td class="detailtd"><input type="text" id="m_sfycphbz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">无车牌号原因编码</td>
		<td class="detailtd"><input type="text" id="m_wcphyybm" value=""></td>
		<td class="distd">无车牌号原因</td>
		<td class="detailtd"><input type="text" id="m_wcphyy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">无车牌号原因描述</td>
		<td class="detailtd"><input type="text" id="m_wcphyyms" value=""></td>
		<td class="distd">号牌种类编码</td>
		<td class="detailtd"><input type="text" id="m_hpzlbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">号牌种类</td>
		<td class="detailtd"><input type="text" id="m_hpzl" value=""></td>
		<td class="distd">发动机号</td>
		<td class="detailtd"><input type="text" id="m_fdjh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车架号</td>
		<td class="detailtd"><input type="text" id="m_cjh" value=""></td>
		<td class="distd">受理时间</td>
		<td class="detailtd"><input type="text" id="m_slsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">受理人</td>
		<td class="detailtd"><input type="text" id="m_slr" value=""></td>
		<td class="distd">录入时间</td>
		<td class="detailtd"><input type="text" id="m_lrsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入人</td>
		<td class="detailtd"><input type="text" id="m_lrr" value=""></td>
		<td class="distd">撤销时间</td>
		<td class="detailtd"><input type="text" id="m_cxsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤销标志</td>
		<td class="detailtd"><input type="text" id="m_cxbz" value=""></td>
		<td class="distd">撤销人</td>
		<td class="detailtd"><input type="text" id="m_cxr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车辆性质</td>
		<td class="detailtd"><input type="text" id="m_clxz" value=""></td>
		<td class="distd">车主</td>
		<td class="detailtd"><input type="text" id="m_czm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车主电话</td>
		<td class="detailtd"><input type="text" id="m_czdh" value=""></td>
		<td class="distd">车主国籍代码</td>
		<td class="detailtd"><input type="text" id="m_czgjdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车主国籍</td>
		<td class="detailtd"><input type="text" id="m_czgj" value=""></td>
		<td class="distd">车主户籍地址</td>
		<td class="detailtd"><input type="text" id="m_czhjdz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车主行政区划代码</td>
		<td class="detailtd"><input type="text" id="m_czxzqhdm" value=""></td>
		<td class="distd">车主行政区划</td>
		<td class="detailtd"><input type="text" id="m_czxzqh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车主性别代码</td>
		<td class="detailtd"><input type="text" id="m_czxbdm" value=""></td>
		<td class="distd">车主性别</td>
		<td class="detailtd"><input type="text" id="m_czxb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车主常用证件类型代码</td>
		<td class="detailtd"><input type="text" id="m_czcyzjlxdm" value=""></td>
		<td class="distd">车主常用证件</td>
		<td class="detailtd"><input type="text" id="m_czcyzj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车主证件号码</td>
		<td class="detailtd"><input type="text" id="m_czzjhm" value=""></td>
		<td class="distd">行驶里程</td>
		<td class="detailtd"><input type="text" id="m_xslc" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">车辆状态</td>
		<td class="detailtd"><input type="text" id="m_clzt" value=""></td>
		<td class="distd">备注</td>
		<td class="detailtd"><input type="text" id="m_bz" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
