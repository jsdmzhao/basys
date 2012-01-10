<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	daggleDiv(detailid);
		$("#a_slsj").attr("readonly","true");
		$("#a_slsj").datepicker();
		$("#a_lrsj").attr("readonly","true");
		$("#a_lrsj").datepicker();
		$("#a_cxsj").attr("readonly","true");
		$("#a_cxsj").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_cljbxxid","Integer",-9999999999,9999999999,null,0,"车辆基本信息ID"))
			return false;
		if (!checkControlValue("a_cldjxh","String",1,24,null,0,"车辆登记序号"))
			return false;
		if (!checkControlValue("a_cllxbm","String",1,1,null,0,"车辆类型编码"))
			return false;
		if (!checkControlValue("a_cllx","String",1,32,null,0,"车辆类型"))
			return false;
		if (!checkControlValue("a_clppbm","String",1,10,null,0,"车辆品牌编码"))
			return false;
		if (!checkControlValue("a_clpp","String",1,32,null,0,"车辆品牌"))
			return false;
		if (!checkControlValue("a_cszsbm","String",1,3,null,0,"车身主色编码"))
			return false;
		if (!checkControlValue("a_cszs","String",1,4,null,0,"车身主色"))
			return false;
		if (!checkControlValue("a_dyfsbm","String",1,3,null,0,"第一辅色编码"))
			return false;
		if (!checkControlValue("a_dyfs","String",1,4,null,0,"第一辅色"))
			return false;
		if (!checkControlValue("a_drfsbm","String",1,3,null,0,"第二辅色编码"))
			return false;
		if (!checkControlValue("a_drfs","String",1,4,null,0,"第二辅色"))
			return false;
		if (!checkControlValue("a_cph","String",1,15,null,0,"车牌号"))
			return false;
		if (!checkControlValue("a_sfycphbz","String",1,1,null,0,"是否有车牌标志"))
			return false;
		if (!checkControlValue("a_wcphyybm","String",1,2,null,0,"无车牌号原因编码"))
			return false;
		if (!checkControlValue("a_wcphyy","String",1,32,null,0,"无车牌号原因"))
			return false;
		if (!checkControlValue("a_wcphyyms","String",1,100,null,0,"无车牌号原因描述"))
			return false;
		if (!checkControlValue("a_hpzlbm","String",1,2,null,0,"号牌种类编码"))
			return false;
		if (!checkControlValue("a_hpzl","String",1,24,null,0,"号牌种类"))
			return false;
		if (!checkControlValue("a_fdjh","String",1,30,null,0,"发动机号"))
			return false;
		if (!checkControlValue("a_cjh","String",1,30,null,0,"车架号"))
			return false;
		if (!checkControlValue("a_slsj","Date",null,null,null,0,"受理时间"))
			return false;
		if (!checkControlValue("a_slr","String",1,100,null,0,"受理人"))
			return false;
		if (!checkControlValue("a_lrsj","Date",null,null,null,0,"录入时间"))
			return false;
		if (!checkControlValue("a_lrr","String",1,100,null,0,"录入人"))
			return false;
		if (!checkControlValue("a_cxsj","Date",null,null,null,0,"撤销时间"))
			return false;
		if (!checkControlValue("a_cxbz","String",1,2,null,0,"撤销标志"))
			return false;
		if (!checkControlValue("a_cxr","String",1,30,null,0,"撤销人"))
			return false;
		if (!checkControlValue("a_clxz","String",1,1,null,0,"车辆性质"))
			return false;
		if (!checkControlValue("a_czm","String",1,50,null,0,"车主"))
			return false;
		if (!checkControlValue("a_czdh","String",1,20,null,0,"车主电话"))
			return false;
		if (!checkControlValue("a_czgjdm","String",1,3,null,0,"车主国籍代码"))
			return false;
		if (!checkControlValue("a_czgj","String",1,40,null,0,"车主国籍"))
			return false;
		if (!checkControlValue("a_czhjdz","String",1,200,null,0,"车主户籍地址"))
			return false;
		if (!checkControlValue("a_czxzqhdm","String",1,6,null,0,"车主行政区划代码"))
			return false;
		if (!checkControlValue("a_czxzqh","String",1,200,null,0,"车主行政区划"))
			return false;
		if (!checkControlValue("a_czxbdm","String",1,1,null,0,"车主性别代码"))
			return false;
		if (!checkControlValue("a_czxb","String",1,2,null,0,"车主性别"))
			return false;
		if (!checkControlValue("a_czcyzjlxdm","String",1,4,null,0,"车主常用证件类型代码"))
			return false;
		if (!checkControlValue("a_czcyzj","String",1,40,null,0,"车主常用证件"))
			return false;
		if (!checkControlValue("a_czzjhm","String",1,20,null,0,"车主证件号码"))
			return false;
		if (!checkControlValue("a_xslc","Integer",-9999999999,9999999999,null,0,"行驶里程"))
			return false;
		if (!checkControlValue("a_clzt","String",1,2,null,0,"车辆状态"))
			return false;
		if (!checkControlValue("a_bz","String",1,2000,null,0,"备注"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Cljbxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">车辆基本信息ID</td>
		<td class="detailtd"><input type="text" id="a_cljbxxid" value="0"></td>
		<td class="distd">车辆登记序号</td>
		<td class="detailtd"><input type="text" id="a_cldjxh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车辆类型编码</td>
		<td class="detailtd"><input type="text" id="a_cllxbm" value=""></td>
		<td class="distd">车辆类型</td>
		<td class="detailtd"><input type="text" id="a_cllx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车辆品牌编码</td>
		<td class="detailtd"><input type="text" id="a_clppbm" value=""></td>
		<td class="distd">车辆品牌</td>
		<td class="detailtd"><input type="text" id="a_clpp" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车身主色编码</td>
		<td class="detailtd"><input type="text" id="a_cszsbm" value=""></td>
		<td class="distd">车身主色</td>
		<td class="detailtd"><input type="text" id="a_cszs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">第一辅色编码</td>
		<td class="detailtd"><input type="text" id="a_dyfsbm" value=""></td>
		<td class="distd">第一辅色</td>
		<td class="detailtd"><input type="text" id="a_dyfs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">第二辅色编码</td>
		<td class="detailtd"><input type="text" id="a_drfsbm" value=""></td>
		<td class="distd">第二辅色</td>
		<td class="detailtd"><input type="text" id="a_drfs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车牌号</td>
		<td class="detailtd"><input type="text" id="a_cph" value=""></td>
		<td class="distd">是否有车牌标志</td>
		<td class="detailtd"><input type="text" id="a_sfycphbz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">无车牌号原因编码</td>
		<td class="detailtd"><input type="text" id="a_wcphyybm" value=""></td>
		<td class="distd">无车牌号原因</td>
		<td class="detailtd"><input type="text" id="a_wcphyy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">无车牌号原因描述</td>
		<td class="detailtd"><input type="text" id="a_wcphyyms" value=""></td>
		<td class="distd">号牌种类编码</td>
		<td class="detailtd"><input type="text" id="a_hpzlbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">号牌种类</td>
		<td class="detailtd"><input type="text" id="a_hpzl" value=""></td>
		<td class="distd">发动机号</td>
		<td class="detailtd"><input type="text" id="a_fdjh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车架号</td>
		<td class="detailtd"><input type="text" id="a_cjh" value=""></td>
		<td class="distd">受理时间</td>
		<td class="detailtd"><input type="text" id="a_slsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">受理人</td>
		<td class="detailtd"><input type="text" id="a_slr" value=""></td>
		<td class="distd">录入时间</td>
		<td class="detailtd"><input type="text" id="a_lrsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入人</td>
		<td class="detailtd"><input type="text" id="a_lrr" value=""></td>
		<td class="distd">撤销时间</td>
		<td class="detailtd"><input type="text" id="a_cxsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">撤销标志</td>
		<td class="detailtd"><input type="text" id="a_cxbz" value=""></td>
		<td class="distd">撤销人</td>
		<td class="detailtd"><input type="text" id="a_cxr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车辆性质</td>
		<td class="detailtd"><input type="text" id="a_clxz" value=""></td>
		<td class="distd">车主</td>
		<td class="detailtd"><input type="text" id="a_czm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车主电话</td>
		<td class="detailtd"><input type="text" id="a_czdh" value=""></td>
		<td class="distd">车主国籍代码</td>
		<td class="detailtd"><input type="text" id="a_czgjdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车主国籍</td>
		<td class="detailtd"><input type="text" id="a_czgj" value=""></td>
		<td class="distd">车主户籍地址</td>
		<td class="detailtd"><input type="text" id="a_czhjdz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车主行政区划代码</td>
		<td class="detailtd"><input type="text" id="a_czxzqhdm" value=""></td>
		<td class="distd">车主行政区划</td>
		<td class="detailtd"><input type="text" id="a_czxzqh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车主性别代码</td>
		<td class="detailtd"><input type="text" id="a_czxbdm" value=""></td>
		<td class="distd">车主性别</td>
		<td class="detailtd"><input type="text" id="a_czxb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车主常用证件类型代码</td>
		<td class="detailtd"><input type="text" id="a_czcyzjlxdm" value=""></td>
		<td class="distd">车主常用证件</td>
		<td class="detailtd"><input type="text" id="a_czcyzj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">车主证件号码</td>
		<td class="detailtd"><input type="text" id="a_czzjhm" value=""></td>
		<td class="distd">行驶里程</td>
		<td class="detailtd"><input type="text" id="a_xslc" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">车辆状态</td>
		<td class="detailtd"><input type="text" id="a_clzt" value=""></td>
		<td class="distd">备注</td>
		<td class="detailtd"><input type="text" id="a_bz" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>