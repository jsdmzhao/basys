<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	daggleDiv(detailid);
		$("#a_bdsj").attr("readonly","true");
		$("#a_bdsj").datepicker();
		$("#a_hcsj").attr("readonly","true");
		$("#a_hcsj").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_garkktbsjid","Integer",-9999999999,9999999999,null,0,"公安人口库同步数据ID"))
			return false;
		if (!checkControlValue("a_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("a_ryid","Integer",-9999999999,9999999999,null,0,"从业人员ID"))
			return false;
		if (!checkControlValue("a_hcid","Integer",-9999999999,9999999999,null,0,"核查ID"))
			return false;
		if (!checkControlValue("a_dsjgdm","String",1,20,null,0,"地市机关代码"))
			return false;
		if (!checkControlValue("a_dsjgmc","String",1,60,null,0,"地市机关名称"))
			return false;
		if (!checkControlValue("a_fxjdm","String",1,20,null,0,"分县局代码"))
			return false;
		if (!checkControlValue("a_fxjmc","String",1,60,null,0,"分县局名称"))
			return false;
		if (!checkControlValue("a_gxdwdm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("a_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("a_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("a_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("a_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("a_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("a_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("a_ywm","String",1,60,null,0,"英文名"))
			return false;
		if (!checkControlValue("a_ywx","String",1,60,null,0,"英文姓"))
			return false;
		if (!checkControlValue("a_wgrjyxkz","String",1,60,null,0,"外国人就业许可证号"))
			return false;
		if (!checkControlValue("a_cyzjdm","String",1,40,null,0,"常用证件代码"))
			return false;
		if (!checkControlValue("a_cyzj","String",1,100,null,0,"常用证件"))
			return false;
		if (!checkControlValue("a_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("a_gwbh","String",1,4,null,0,"岗位编号"))
			return false;
		if (!checkControlValue("a_gemc","String",1,60,null,0,"岗位名称"))
			return false;
		if (!checkControlValue("a_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("a_bdsj","Date",null,null,null,0,"比对时间"))
			return false;
		if (!checkControlValue("a_hcsj","Date",null,null,null,0,"核查时间"))
			return false;
		if (!checkControlValue("a_hcwt","String",1,100,null,0,"核查问题"))
			return false;
		if (!checkControlValue("a_hcyj","String",1,300,null,0,"核查意见"))
			return false;
		if (!checkControlValue("a_hcr","String",1,30,null,0,"核查人"))
			return false;
		if (!checkControlValue("a_hcdw","String",1,100,null,0,"核查单位"))
			return false;
		if (!checkControlValue("a_hcdwdm","String",1,30,null,0,"核查单位代码"))
			return false;
		if (!checkControlValue("a_hczt","String",1,100,null,0,"核查状态"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Qyryxxhc_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">公安人口库同步数据ID</td>
		<td class="detailtd"><input type="text" id="a_garkktbsjid" value="0"></td>
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="a_qyid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员ID</td>
		<td class="detailtd"><input type="text" id="a_ryid" value="0"></td>
		<td class="distd">核查ID</td>
		<td class="detailtd"><input type="text" id="a_hcid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">地市机关代码</td>
		<td class="detailtd"><input type="text" id="a_dsjgdm" value=""></td>
		<td class="distd">地市机关名称</td>
		<td class="detailtd"><input type="text" id="a_dsjgmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">分县局代码</td>
		<td class="detailtd"><input type="text" id="a_fxjdm" value=""></td>
		<td class="distd">分县局名称</td>
		<td class="detailtd"><input type="text" id="a_fxjmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" id="a_gxdwdm" value=""></td>
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" id="a_gxdwmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业编码</td>
		<td class="detailtd"><input type="text" id="a_qybm" value=""></td>
		<td class="distd">企业名称</td>
		<td class="detailtd"><input type="text" id="a_qymc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" id="a_xm" value=""></td>
		<td class="distd">性别代码</td>
		<td class="detailtd"><input type="text" id="a_xbdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" id="a_xb" value=""></td>
		<td class="distd">英文名</td>
		<td class="detailtd"><input type="text" id="a_ywm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">英文姓</td>
		<td class="detailtd"><input type="text" id="a_ywx" value=""></td>
		<td class="distd">外国人就业许可证号</td>
		<td class="detailtd"><input type="text" id="a_wgrjyxkz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">常用证件代码</td>
		<td class="detailtd"><input type="text" id="a_cyzjdm" value=""></td>
		<td class="distd">常用证件</td>
		<td class="detailtd"><input type="text" id="a_cyzj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">证件号码</td>
		<td class="detailtd"><input type="text" id="a_zjhm" value=""></td>
		<td class="distd">岗位编号</td>
		<td class="detailtd"><input type="text" id="a_gwbh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">岗位名称</td>
		<td class="detailtd"><input type="text" id="a_gemc" value=""></td>
		<td class="distd">姓名拼音</td>
		<td class="detailtd"><input type="text" id="a_xmpy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">比对时间</td>
		<td class="detailtd"><input type="text" id="a_bdsj" value=""></td>
		<td class="distd">核查时间</td>
		<td class="detailtd"><input type="text" id="a_hcsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">核查问题</td>
		<td class="detailtd"><input type="text" id="a_hcwt" value=""></td>
		<td class="distd">核查意见</td>
		<td class="detailtd"><input type="text" id="a_hcyj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">核查人</td>
		<td class="detailtd"><input type="text" id="a_hcr" value=""></td>
		<td class="distd">核查单位</td>
		<td class="detailtd"><input type="text" id="a_hcdw" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">核查单位代码</td>
		<td class="detailtd"><input type="text" id="a_hcdwdm" value=""></td>
		<td class="distd">核查状态</td>
		<td class="detailtd"><input type="text" id="a_hczt" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>