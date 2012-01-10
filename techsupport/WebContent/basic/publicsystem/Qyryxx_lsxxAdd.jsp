<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	daggleDiv(detailid);
		$("#a_csrq").attr("readonly","true");
		$("#a_csrq").datepicker();
		$("#a_rzrq").attr("readonly","true");
		$("#a_rzrq").datepicker();
		$("#a_zxsj").attr("readonly","true");
		$("#a_zxsj").datepicker();
		$("#a_lrsj").attr("readonly","true");
		$("#a_lrsj").datepicker();
		$("#a_hcsj").attr("readonly","true");
		$("#a_hcsj").datepicker();
		$("#a_bcsj").attr("readonly","true");
		$("#a_bcsj").datepicker();
		$("#a_zatlq").attr("readonly","true");
		$("#a_zatlq").datepicker();
		$("#a_rjrq").attr("readonly","true");
		$("#a_rjrq").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_rylsid","Integer",-9999999999,9999999999,null,0,"人员历史ID"))
			return false;
		if (!checkControlValue("a_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("a_ryid","Integer",-9999999999,9999999999,null,0,"从业人员ID"))
			return false;
		if (!checkControlValue("a_hylbdm","String",1,2,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("a_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("a_cyrybh","String",1,20,null,0,"从业人员编号"))
			return false;
		if (!checkControlValue("a_cyrylbdm","String",1,2,null,0,"从业人员类别代码"))
			return false;
		if (!checkControlValue("a_cyrylbmc","String",1,30,null,0,"从业人员类别名称"))
			return false;
		if (!checkControlValue("a_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("a_qm","String",1,100,null,0,"全名"))
			return false;
		if (!checkControlValue("a_bm","String",1,30,null,0,"别名"))
			return false;
		if (!checkControlValue("a_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("a_gjdm","String",1,40,null,0,"国籍代码"))
			return false;
		if (!checkControlValue("a_gj","String",1,100,null,0,"国籍"))
			return false;
		if (!checkControlValue("a_mzdm","String",1,40,null,0,"民族代码"))
			return false;
		if (!checkControlValue("a_minzu","String",1,20,null,0,"民族"))
			return false;
		if (!checkControlValue("a_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("a_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("a_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("a_hyzkdm","String",1,2,null,0,"婚姻状况代码"))
			return false;
		if (!checkControlValue("a_hyzk","String",1,4,null,0,"婚姻状况"))
			return false;
		if (!checkControlValue("a_shengao","Float",-999.99,999.99,2,0,"身高"))
			return false;
		if (!checkControlValue("a_tizh","Float",-999.99,999.99,2,0,"体重"))
			return false;
		if (!checkControlValue("a_hjdxzqh","String",1,200,null,0,"户籍地行政区划"))
			return false;
		if (!checkControlValue("a_hjdxzqhdm","String",1,10,null,0,"户籍地行政区划代码"))
			return false;
		if (!checkControlValue("a_hjdxz","String",1,200,null,0,"户籍地详址"))
			return false;
		if (!checkControlValue("a_cyzjdm","String",1,40,null,0,"常用证件代码"))
			return false;
		if (!checkControlValue("a_cyzj","String",1,100,null,0,"常用证件"))
			return false;
		if (!checkControlValue("a_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("a_zzzhm","String",1,20,null,0,"暂住证号码"))
			return false;
		if (!checkControlValue("a_zzdz","String",1,200,null,0,"暂住地址"))
			return false;
		if (!checkControlValue("a_gwbh","String",1,4,null,0,"岗位编号"))
			return false;
		if (!checkControlValue("a_gwmc","String",1,60,null,0,"岗位名称"))
			return false;
		if (!checkControlValue("a_gwzrms","String",1,2000,null,0,"岗位责任描述"))
			return false;
		if (!checkControlValue("a_shouji","String",1,20,null,0,"手机"))
			return false;
		if (!checkControlValue("a_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("a_jjlxr","String",1,30,null,0,"紧急联系人"))
			return false;
		if (!checkControlValue("a_jjlxrdh","String",1,20,null,0,"紧急联系人电话"))
			return false;
		if (!checkControlValue("a_zhiwu","String",1,20,null,0,"职务"))
			return false;
		if (!checkControlValue("a_rzrq","Date",null,null,null,0,"入职日期"))
			return false;
		if (!checkControlValue("a_cyryztdm","String",1,2,null,0,"从业人员状态代码"))
			return false;
		if (!checkControlValue("a_cyryzt","String",1,4,null,0,"从业人员状态"))
			return false;
		if (!checkControlValue("a_zxr","String",1,30,null,0,"注销人"))
			return false;
		if (!checkControlValue("a_zxbz","String",1,2,null,0,"注销标志"))
			return false;
		if (!checkControlValue("a_zxsj","Date",null,null,null,0,"注销时间"))
			return false;
		if (!checkControlValue("a_lrsj","Date",null,null,null,0,"录入时间"))
			return false;
		if (!checkControlValue("a_lrr","String",1,100,null,0,"录入人"))
			return false;
		if (!checkControlValue("a_lrdwbm","String",1,20,null,0,"录入单位编码"))
			return false;
		if (!checkControlValue("a_lrdwmc","String",1,60,null,0,"录入单位名称"))
			return false;
		if (!checkControlValue("a_hcdw","String",1,100,null,0,"核查单位"))
			return false;
		if (!checkControlValue("a_hcr","String",1,30,null,0,"核查人"))
			return false;
		if (!checkControlValue("a_hcsj","Date",null,null,null,0,"核查时间"))
			return false;
		if (!checkControlValue("a_zxyy","String",1,200,null,0,"注销原因"))
			return false;
		if (!checkControlValue("a_zkzt","String",1,4,null,0,"制卡状态"))
			return false;
		if (!checkControlValue("a_bcsj","Date",null,null,null,0,"保存时间"))
			return false;
		if (!checkControlValue("a_dcbs","Integer",-99,99,null,0,"导出标识"))
			return false;
		if (!checkControlValue("a_bz","String",1,2000,null,0,"备注"))
			return false;
		if (!checkControlValue("a_scbz","Integer",-99,99,null,0,"删除标志"))
			return false;
		if (!checkControlValue("a_biduiflag","String",1,1,null,0,"比对标志"))
			return false;
		if (!checkControlValue("a_zpwtgyy","String",1,2000,null,0,"照片未通过原因"))
			return false;
		if (!checkControlValue("a_zt","String",1,10,null,0,"状态"))
			return false;
		if (!checkControlValue("a_ywx","String",1,60,null,0,"英文姓"))
			return false;
		if (!checkControlValue("a_ywm","String",1,60,null,0,"英文名"))
			return false;
		if (!checkControlValue("a_wgrjyxkz","String",1,60,null,0,"外国人就业许可证号"))
			return false;
		if (!checkControlValue("a_qzzldm","String",1,40,null,0,"签证种类代码"))
			return false;
		if (!checkControlValue("a_qzhm","String",1,20,null,0,"签证号码"))
			return false;
		if (!checkControlValue("a_zatlq","Date",null,null,null,0,"在华停留期至"))
			return false;
		if (!checkControlValue("a_qfjg","String",1,120,null,0,"签发机关"))
			return false;
		if (!checkControlValue("a_rjrq","Date",null,null,null,0,"入境日期"))
			return false;
		if (!checkControlValue("a_rjka","String",1,60,null,0,"入境口岸"))
			return false;
		if (!checkControlValue("a_czlx","String",1,40,null,0,"操作类型"))
			return false;
		if (!checkControlValue("a_bgyy","String",1,2000,null,0,"变更原因"))
			return false;
		if (!checkControlValue("a_bglbdm","String",1,2,null,0,"变更类别代码"))
			return false;
		if (!checkControlValue("a_bglb","String",1,60,null,0,"变更类别"))
			return false;
		if (!checkControlValue("a_gzdm","String",1,4,null,0,"工种代码"))
			return false;
		if (!checkControlValue("a_gz","String",1,60,null,0,"工种"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Qyryxx_lsxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">人员历史ID</td>
		<td class="detailtd"><input type="text" id="a_rylsid" value="0"></td>
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="a_qyid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员ID</td>
		<td class="detailtd"><input type="text" id="a_ryid" value="0"></td>
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="a_hylbdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="a_hylb" value=""></td>
		<td class="distd">从业人员编号</td>
		<td class="detailtd"><input type="text" id="a_cyrybh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员类别代码</td>
		<td class="detailtd"><input type="text" id="a_cyrylbdm" value=""></td>
		<td class="distd">从业人员类别名称</td>
		<td class="detailtd"><input type="text" id="a_cyrylbmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" id="a_xm" value=""></td>
		<td class="distd">全名</td>
		<td class="detailtd"><input type="text" id="a_qm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">别名</td>
		<td class="detailtd"><input type="text" id="a_bm" value=""></td>
		<td class="distd">姓名拼音</td>
		<td class="detailtd"><input type="text" id="a_xmpy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">国籍代码</td>
		<td class="detailtd"><input type="text" id="a_gjdm" value=""></td>
		<td class="distd">国籍</td>
		<td class="detailtd"><input type="text" id="a_gj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">民族代码</td>
		<td class="detailtd"><input type="text" id="a_mzdm" value=""></td>
		<td class="distd">民族</td>
		<td class="detailtd"><input type="text" id="a_minzu" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">性别代码</td>
		<td class="detailtd"><input type="text" id="a_xbdm" value=""></td>
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" id="a_xb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">出生日期</td>
		<td class="detailtd"><input type="text" id="a_csrq" value=""></td>
		<td class="distd">婚姻状况代码</td>
		<td class="detailtd"><input type="text" id="a_hyzkdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">婚姻状况</td>
		<td class="detailtd"><input type="text" id="a_hyzk" value=""></td>
		<td class="distd">身高</td>
		<td class="detailtd"><input type="text" id="a_shengao" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">体重</td>
		<td class="detailtd"><input type="text" id="a_tizh" value="0"></td>
		<td class="distd">户籍地行政区划</td>
		<td class="detailtd"><input type="text" id="a_hjdxzqh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">户籍地行政区划代码</td>
		<td class="detailtd"><input type="text" id="a_hjdxzqhdm" value=""></td>
		<td class="distd">户籍地详址</td>
		<td class="detailtd"><input type="text" id="a_hjdxz" value=""></td>
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
		<td class="distd">暂住证号码</td>
		<td class="detailtd"><input type="text" id="a_zzzhm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">暂住地址</td>
		<td class="detailtd"><input type="text" id="a_zzdz" value=""></td>
		<td class="distd">岗位编号</td>
		<td class="detailtd"><input type="text" id="a_gwbh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">岗位名称</td>
		<td class="detailtd"><input type="text" id="a_gwmc" value=""></td>
		<td class="distd">岗位责任描述</td>
		<td class="detailtd"><input type="text" id="a_gwzrms" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">手机</td>
		<td class="detailtd"><input type="text" id="a_shouji" value=""></td>
		<td class="distd">联系电话</td>
		<td class="detailtd"><input type="text" id="a_lxdh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">紧急联系人</td>
		<td class="detailtd"><input type="text" id="a_jjlxr" value=""></td>
		<td class="distd">紧急联系人电话</td>
		<td class="detailtd"><input type="text" id="a_jjlxrdh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">职务</td>
		<td class="detailtd"><input type="text" id="a_zhiwu" value=""></td>
		<td class="distd">入职日期</td>
		<td class="detailtd"><input type="text" id="a_rzrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员状态代码</td>
		<td class="detailtd"><input type="text" id="a_cyryztdm" value=""></td>
		<td class="distd">从业人员状态</td>
		<td class="detailtd"><input type="text" id="a_cyryzt" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">注销人</td>
		<td class="detailtd"><input type="text" id="a_zxr" value=""></td>
		<td class="distd">注销标志</td>
		<td class="detailtd"><input type="text" id="a_zxbz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">注销时间</td>
		<td class="detailtd"><input type="text" id="a_zxsj" value=""></td>
		<td class="distd">录入时间</td>
		<td class="detailtd"><input type="text" id="a_lrsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入人</td>
		<td class="detailtd"><input type="text" id="a_lrr" value=""></td>
		<td class="distd">录入单位编码</td>
		<td class="detailtd"><input type="text" id="a_lrdwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入单位名称</td>
		<td class="detailtd"><input type="text" id="a_lrdwmc" value=""></td>
		<td class="distd">核查单位</td>
		<td class="detailtd"><input type="text" id="a_hcdw" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">核查人</td>
		<td class="detailtd"><input type="text" id="a_hcr" value=""></td>
		<td class="distd">核查时间</td>
		<td class="detailtd"><input type="text" id="a_hcsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">注销原因</td>
		<td class="detailtd"><input type="text" id="a_zxyy" value=""></td>
		<td class="distd">制卡状态</td>
		<td class="detailtd"><input type="text" id="a_zkzt" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">保存时间</td>
		<td class="detailtd"><input type="text" id="a_bcsj" value=""></td>
		<td class="distd">导出标识</td>
		<td class="detailtd"><input type="text" id="a_dcbs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">备注</td>
		<td class="detailtd"><input type="text" id="a_bz" value=""></td>
		<td class="distd">删除标志</td>
		<td class="detailtd"><input type="text" id="a_scbz" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">比对标志</td>
		<td class="detailtd"><input type="text" id="a_biduiflag" value=""></td>
		<td class="distd">照片未通过原因</td>
		<td class="detailtd"><input type="text" id="a_zpwtgyy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">状态</td>
		<td class="detailtd"><input type="text" id="a_zt" value=""></td>
		<td class="distd">英文姓</td>
		<td class="detailtd"><input type="text" id="a_ywx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">英文名</td>
		<td class="detailtd"><input type="text" id="a_ywm" value=""></td>
		<td class="distd">外国人就业许可证号</td>
		<td class="detailtd"><input type="text" id="a_wgrjyxkz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">签证种类代码</td>
		<td class="detailtd"><input type="text" id="a_qzzldm" value=""></td>
		<td class="distd">签证号码</td>
		<td class="detailtd"><input type="text" id="a_qzhm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">在华停留期至</td>
		<td class="detailtd"><input type="text" id="a_zatlq" value=""></td>
		<td class="distd">签发机关</td>
		<td class="detailtd"><input type="text" id="a_qfjg" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">入境日期</td>
		<td class="detailtd"><input type="text" id="a_rjrq" value=""></td>
		<td class="distd">入境口岸</td>
		<td class="detailtd"><input type="text" id="a_rjka" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">操作类型</td>
		<td class="detailtd"><input type="text" id="a_czlx" value=""></td>
		<td class="distd">变更原因</td>
		<td class="detailtd"><input type="text" id="a_bgyy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">变更类别代码</td>
		<td class="detailtd"><input type="text" id="a_bglbdm" value=""></td>
		<td class="distd">变更类别</td>
		<td class="detailtd"><input type="text" id="a_bglb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">工种代码</td>
		<td class="detailtd"><input type="text" id="a_gzdm" value=""></td>
		<td class="distd">工种</td>
		<td class="detailtd"><input type="text" id="a_gz" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>