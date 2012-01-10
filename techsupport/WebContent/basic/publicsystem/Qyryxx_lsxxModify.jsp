<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_rylsid").attr("value",dataid);
		$("#m_rylsid").attr("value",dataid);
		setDetail();
		$("#m_csrq").attr("readonly","true");
		$("#m_csrq").datepicker();
		$("#m_rzrq").attr("readonly","true");
		$("#m_rzrq").datepicker();
		$("#m_zxsj").attr("readonly","true");
		$("#m_zxsj").datepicker();
		$("#m_lrsj").attr("readonly","true");
		$("#m_lrsj").datepicker();
		$("#m_hcsj").attr("readonly","true");
		$("#m_hcsj").datepicker();
		$("#m_bcsj").attr("readonly","true");
		$("#m_bcsj").datepicker();
		$("#m_zatlq").attr("readonly","true");
		$("#m_zatlq").datepicker();
		$("#m_rjrq").attr("readonly","true");
		$("#m_rjrq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_rylsid").attr("value",setNull(json.LQyryxx_lsxx[0].rylsid));
		$("#m_qyid").attr("value",setNull(json.LQyryxx_lsxx[0].qyid));
		$("#m_ryid").attr("value",setNull(json.LQyryxx_lsxx[0].ryid));
		$("#m_hylbdm").attr("value",setNull(json.LQyryxx_lsxx[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LQyryxx_lsxx[0].hylb));
		$("#m_cyrybh").attr("value",setNull(json.LQyryxx_lsxx[0].cyrybh));
		$("#m_cyrylbdm").attr("value",setNull(json.LQyryxx_lsxx[0].cyrylbdm));
		$("#m_cyrylbmc").attr("value",setNull(json.LQyryxx_lsxx[0].cyrylbmc));
		$("#m_xm").attr("value",setNull(json.LQyryxx_lsxx[0].xm));
		$("#m_qm").attr("value",setNull(json.LQyryxx_lsxx[0].qm));
		$("#m_bm").attr("value",setNull(json.LQyryxx_lsxx[0].bm));
		$("#m_xmpy").attr("value",setNull(json.LQyryxx_lsxx[0].xmpy));
		$("#m_gjdm").attr("value",setNull(json.LQyryxx_lsxx[0].gjdm));
		$("#m_gj").attr("value",setNull(json.LQyryxx_lsxx[0].gj));
		$("#m_mzdm").attr("value",setNull(json.LQyryxx_lsxx[0].mzdm));
		$("#m_minzu").attr("value",setNull(json.LQyryxx_lsxx[0].minzu));
		$("#m_xbdm").attr("value",setNull(json.LQyryxx_lsxx[0].xbdm));
		$("#m_xb").attr("value",setNull(json.LQyryxx_lsxx[0].xb));
		$("#m_csrq").attr("value",setNull(json.LQyryxx_lsxx[0].csrq));
		$("#m_hyzkdm").attr("value",setNull(json.LQyryxx_lsxx[0].hyzkdm));
		$("#m_hyzk").attr("value",setNull(json.LQyryxx_lsxx[0].hyzk));
		$("#m_shengao").attr("value",setNull(json.LQyryxx_lsxx[0].shengao));
		$("#m_tizh").attr("value",setNull(json.LQyryxx_lsxx[0].tizh));
		$("#m_hjdxzqh").attr("value",setNull(json.LQyryxx_lsxx[0].hjdxzqh));
		$("#m_hjdxzqhdm").attr("value",setNull(json.LQyryxx_lsxx[0].hjdxzqhdm));
		$("#m_hjdxz").attr("value",setNull(json.LQyryxx_lsxx[0].hjdxz));
		$("#m_cyzjdm").attr("value",setNull(json.LQyryxx_lsxx[0].cyzjdm));
		$("#m_cyzj").attr("value",setNull(json.LQyryxx_lsxx[0].cyzj));
		$("#m_zjhm").attr("value",setNull(json.LQyryxx_lsxx[0].zjhm));
		$("#m_zzzhm").attr("value",setNull(json.LQyryxx_lsxx[0].zzzhm));
		$("#m_zzdz").attr("value",setNull(json.LQyryxx_lsxx[0].zzdz));
		$("#m_gwbh").attr("value",setNull(json.LQyryxx_lsxx[0].gwbh));
		$("#m_gwmc").attr("value",setNull(json.LQyryxx_lsxx[0].gwmc));
		$("#m_gwzrms").attr("value",setNull(json.LQyryxx_lsxx[0].gwzrms));
		$("#m_shouji").attr("value",setNull(json.LQyryxx_lsxx[0].shouji));
		$("#m_lxdh").attr("value",setNull(json.LQyryxx_lsxx[0].lxdh));
		$("#m_jjlxr").attr("value",setNull(json.LQyryxx_lsxx[0].jjlxr));
		$("#m_jjlxrdh").attr("value",setNull(json.LQyryxx_lsxx[0].jjlxrdh));
		$("#m_zhiwu").attr("value",setNull(json.LQyryxx_lsxx[0].zhiwu));
		$("#m_rzrq").attr("value",setNull(json.LQyryxx_lsxx[0].rzrq));
		$("#m_cyryztdm").attr("value",setNull(json.LQyryxx_lsxx[0].cyryztdm));
		$("#m_cyryzt").attr("value",setNull(json.LQyryxx_lsxx[0].cyryzt));
		$("#m_zxr").attr("value",setNull(json.LQyryxx_lsxx[0].zxr));
		$("#m_zxbz").attr("value",setNull(json.LQyryxx_lsxx[0].zxbz));
		$("#m_zxsj").attr("value",setNull(json.LQyryxx_lsxx[0].zxsj));
		$("#m_lrsj").attr("value",setNull(json.LQyryxx_lsxx[0].lrsj));
		$("#m_lrr").attr("value",setNull(json.LQyryxx_lsxx[0].lrr));
		$("#m_lrdwbm").attr("value",setNull(json.LQyryxx_lsxx[0].lrdwbm));
		$("#m_lrdwmc").attr("value",setNull(json.LQyryxx_lsxx[0].lrdwmc));
		$("#m_hcdw").attr("value",setNull(json.LQyryxx_lsxx[0].hcdw));
		$("#m_hcr").attr("value",setNull(json.LQyryxx_lsxx[0].hcr));
		$("#m_hcsj").attr("value",setNull(json.LQyryxx_lsxx[0].hcsj));
		$("#m_zxyy").attr("value",setNull(json.LQyryxx_lsxx[0].zxyy));
		$("#m_zkzt").attr("value",setNull(json.LQyryxx_lsxx[0].zkzt));
		$("#m_bcsj").attr("value",setNull(json.LQyryxx_lsxx[0].bcsj));
		$("#m_dcbs").attr("value",setNull(json.LQyryxx_lsxx[0].dcbs));
		$("#m_bz").attr("value",setNull(json.LQyryxx_lsxx[0].bz));
		$("#m_scbz").attr("value",setNull(json.LQyryxx_lsxx[0].scbz));
		$("#m_biduiflag").attr("value",setNull(json.LQyryxx_lsxx[0].biduiflag));
		$("#m_zpwtgyy").attr("value",setNull(json.LQyryxx_lsxx[0].zpwtgyy));
		$("#m_zt").attr("value",setNull(json.LQyryxx_lsxx[0].zt));
		$("#m_ywx").attr("value",setNull(json.LQyryxx_lsxx[0].ywx));
		$("#m_ywm").attr("value",setNull(json.LQyryxx_lsxx[0].ywm));
		$("#m_wgrjyxkz").attr("value",setNull(json.LQyryxx_lsxx[0].wgrjyxkz));
		$("#m_qzzldm").attr("value",setNull(json.LQyryxx_lsxx[0].qzzldm));
		$("#m_qzhm").attr("value",setNull(json.LQyryxx_lsxx[0].qzhm));
		$("#m_zatlq").attr("value",setNull(json.LQyryxx_lsxx[0].zatlq));
		$("#m_qfjg").attr("value",setNull(json.LQyryxx_lsxx[0].qfjg));
		$("#m_rjrq").attr("value",setNull(json.LQyryxx_lsxx[0].rjrq));
		$("#m_rjka").attr("value",setNull(json.LQyryxx_lsxx[0].rjka));
		$("#m_czlx").attr("value",setNull(json.LQyryxx_lsxx[0].czlx));
		$("#m_bgyy").attr("value",setNull(json.LQyryxx_lsxx[0].bgyy));
		$("#m_bglbdm").attr("value",setNull(json.LQyryxx_lsxx[0].bglbdm));
		$("#m_bglb").attr("value",setNull(json.LQyryxx_lsxx[0].bglb));
		$("#m_gzdm").attr("value",setNull(json.LQyryxx_lsxx[0].gzdm));
		$("#m_gz").attr("value",setNull(json.LQyryxx_lsxx[0].gz));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_rylsid","Integer",-9999999999,9999999999,null,0,"人员历史ID"))
			return false;
		if (!checkControlValue("m_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("m_ryid","Integer",-9999999999,9999999999,null,0,"从业人员ID"))
			return false;
		if (!checkControlValue("m_hylbdm","String",1,2,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("m_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("m_cyrybh","String",1,20,null,0,"从业人员编号"))
			return false;
		if (!checkControlValue("m_cyrylbdm","String",1,2,null,0,"从业人员类别代码"))
			return false;
		if (!checkControlValue("m_cyrylbmc","String",1,30,null,0,"从业人员类别名称"))
			return false;
		if (!checkControlValue("m_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("m_qm","String",1,100,null,0,"全名"))
			return false;
		if (!checkControlValue("m_bm","String",1,30,null,0,"别名"))
			return false;
		if (!checkControlValue("m_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("m_gjdm","String",1,40,null,0,"国籍代码"))
			return false;
		if (!checkControlValue("m_gj","String",1,100,null,0,"国籍"))
			return false;
		if (!checkControlValue("m_mzdm","String",1,40,null,0,"民族代码"))
			return false;
		if (!checkControlValue("m_minzu","String",1,20,null,0,"民族"))
			return false;
		if (!checkControlValue("m_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("m_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("m_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("m_hyzkdm","String",1,2,null,0,"婚姻状况代码"))
			return false;
		if (!checkControlValue("m_hyzk","String",1,4,null,0,"婚姻状况"))
			return false;
		if (!checkControlValue("m_shengao","Float",-999.99,999.99,2,0,"身高"))
			return false;
		if (!checkControlValue("m_tizh","Float",-999.99,999.99,2,0,"体重"))
			return false;
		if (!checkControlValue("m_hjdxzqh","String",1,200,null,0,"户籍地行政区划"))
			return false;
		if (!checkControlValue("m_hjdxzqhdm","String",1,10,null,0,"户籍地行政区划代码"))
			return false;
		if (!checkControlValue("m_hjdxz","String",1,200,null,0,"户籍地详址"))
			return false;
		if (!checkControlValue("m_cyzjdm","String",1,40,null,0,"常用证件代码"))
			return false;
		if (!checkControlValue("m_cyzj","String",1,100,null,0,"常用证件"))
			return false;
		if (!checkControlValue("m_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("m_zzzhm","String",1,20,null,0,"暂住证号码"))
			return false;
		if (!checkControlValue("m_zzdz","String",1,200,null,0,"暂住地址"))
			return false;
		if (!checkControlValue("m_gwbh","String",1,4,null,0,"岗位编号"))
			return false;
		if (!checkControlValue("m_gwmc","String",1,60,null,0,"岗位名称"))
			return false;
		if (!checkControlValue("m_gwzrms","String",1,2000,null,0,"岗位责任描述"))
			return false;
		if (!checkControlValue("m_shouji","String",1,20,null,0,"手机"))
			return false;
		if (!checkControlValue("m_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("m_jjlxr","String",1,30,null,0,"紧急联系人"))
			return false;
		if (!checkControlValue("m_jjlxrdh","String",1,20,null,0,"紧急联系人电话"))
			return false;
		if (!checkControlValue("m_zhiwu","String",1,20,null,0,"职务"))
			return false;
		if (!checkControlValue("m_rzrq","Date",null,null,null,0,"入职日期"))
			return false;
		if (!checkControlValue("m_cyryztdm","String",1,2,null,0,"从业人员状态代码"))
			return false;
		if (!checkControlValue("m_cyryzt","String",1,4,null,0,"从业人员状态"))
			return false;
		if (!checkControlValue("m_zxr","String",1,30,null,0,"注销人"))
			return false;
		if (!checkControlValue("m_zxbz","String",1,2,null,0,"注销标志"))
			return false;
		if (!checkControlValue("m_zxsj","Date",null,null,null,0,"注销时间"))
			return false;
		if (!checkControlValue("m_lrsj","Date",null,null,null,0,"录入时间"))
			return false;
		if (!checkControlValue("m_lrr","String",1,100,null,0,"录入人"))
			return false;
		if (!checkControlValue("m_lrdwbm","String",1,20,null,0,"录入单位编码"))
			return false;
		if (!checkControlValue("m_lrdwmc","String",1,60,null,0,"录入单位名称"))
			return false;
		if (!checkControlValue("m_hcdw","String",1,100,null,0,"核查单位"))
			return false;
		if (!checkControlValue("m_hcr","String",1,30,null,0,"核查人"))
			return false;
		if (!checkControlValue("m_hcsj","Date",null,null,null,0,"核查时间"))
			return false;
		if (!checkControlValue("m_zxyy","String",1,200,null,0,"注销原因"))
			return false;
		if (!checkControlValue("m_zkzt","String",1,4,null,0,"制卡状态"))
			return false;
		if (!checkControlValue("m_bcsj","Date",null,null,null,0,"保存时间"))
			return false;
		if (!checkControlValue("m_dcbs","Integer",-99,99,null,0,"导出标识"))
			return false;
		if (!checkControlValue("m_bz","String",1,2000,null,0,"备注"))
			return false;
		if (!checkControlValue("m_scbz","Integer",-99,99,null,0,"删除标志"))
			return false;
		if (!checkControlValue("m_biduiflag","String",1,1,null,0,"比对标志"))
			return false;
		if (!checkControlValue("m_zpwtgyy","String",1,2000,null,0,"照片未通过原因"))
			return false;
		if (!checkControlValue("m_zt","String",1,10,null,0,"状态"))
			return false;
		if (!checkControlValue("m_ywx","String",1,60,null,0,"英文姓"))
			return false;
		if (!checkControlValue("m_ywm","String",1,60,null,0,"英文名"))
			return false;
		if (!checkControlValue("m_wgrjyxkz","String",1,60,null,0,"外国人就业许可证号"))
			return false;
		if (!checkControlValue("m_qzzldm","String",1,40,null,0,"签证种类代码"))
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
		if (!checkControlValue("m_czlx","String",1,40,null,0,"操作类型"))
			return false;
		if (!checkControlValue("m_bgyy","String",1,2000,null,0,"变更原因"))
			return false;
		if (!checkControlValue("m_bglbdm","String",1,2,null,0,"变更类别代码"))
			return false;
		if (!checkControlValue("m_bglb","String",1,60,null,0,"变更类别"))
			return false;
		if (!checkControlValue("m_gzdm","String",1,4,null,0,"工种代码"))
			return false;
		if (!checkControlValue("m_gz","String",1,60,null,0,"工种"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_rylsid">
<input type="hidden" id="m_rylsid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Qyryxx_lsxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">人员历史ID</td>
		<td class="detailtd"><input type="text" id="m_rylsid" value="0"></td>
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="m_qyid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员ID</td>
		<td class="detailtd"><input type="text" id="m_ryid" value="0"></td>
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="m_hylbdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="m_hylb" value=""></td>
		<td class="distd">从业人员编号</td>
		<td class="detailtd"><input type="text" id="m_cyrybh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员类别代码</td>
		<td class="detailtd"><input type="text" id="m_cyrylbdm" value=""></td>
		<td class="distd">从业人员类别名称</td>
		<td class="detailtd"><input type="text" id="m_cyrylbmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" id="m_xm" value=""></td>
		<td class="distd">全名</td>
		<td class="detailtd"><input type="text" id="m_qm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">别名</td>
		<td class="detailtd"><input type="text" id="m_bm" value=""></td>
		<td class="distd">姓名拼音</td>
		<td class="detailtd"><input type="text" id="m_xmpy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">国籍代码</td>
		<td class="detailtd"><input type="text" id="m_gjdm" value=""></td>
		<td class="distd">国籍</td>
		<td class="detailtd"><input type="text" id="m_gj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">民族代码</td>
		<td class="detailtd"><input type="text" id="m_mzdm" value=""></td>
		<td class="distd">民族</td>
		<td class="detailtd"><input type="text" id="m_minzu" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">性别代码</td>
		<td class="detailtd"><input type="text" id="m_xbdm" value=""></td>
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" id="m_xb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">出生日期</td>
		<td class="detailtd"><input type="text" id="m_csrq" value=""></td>
		<td class="distd">婚姻状况代码</td>
		<td class="detailtd"><input type="text" id="m_hyzkdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">婚姻状况</td>
		<td class="detailtd"><input type="text" id="m_hyzk" value=""></td>
		<td class="distd">身高</td>
		<td class="detailtd"><input type="text" id="m_shengao" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">体重</td>
		<td class="detailtd"><input type="text" id="m_tizh" value="0"></td>
		<td class="distd">户籍地行政区划</td>
		<td class="detailtd"><input type="text" id="m_hjdxzqh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">户籍地行政区划代码</td>
		<td class="detailtd"><input type="text" id="m_hjdxzqhdm" value=""></td>
		<td class="distd">户籍地详址</td>
		<td class="detailtd"><input type="text" id="m_hjdxz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">常用证件代码</td>
		<td class="detailtd"><input type="text" id="m_cyzjdm" value=""></td>
		<td class="distd">常用证件</td>
		<td class="detailtd"><input type="text" id="m_cyzj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">证件号码</td>
		<td class="detailtd"><input type="text" id="m_zjhm" value=""></td>
		<td class="distd">暂住证号码</td>
		<td class="detailtd"><input type="text" id="m_zzzhm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">暂住地址</td>
		<td class="detailtd"><input type="text" id="m_zzdz" value=""></td>
		<td class="distd">岗位编号</td>
		<td class="detailtd"><input type="text" id="m_gwbh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">岗位名称</td>
		<td class="detailtd"><input type="text" id="m_gwmc" value=""></td>
		<td class="distd">岗位责任描述</td>
		<td class="detailtd"><input type="text" id="m_gwzrms" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">手机</td>
		<td class="detailtd"><input type="text" id="m_shouji" value=""></td>
		<td class="distd">联系电话</td>
		<td class="detailtd"><input type="text" id="m_lxdh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">紧急联系人</td>
		<td class="detailtd"><input type="text" id="m_jjlxr" value=""></td>
		<td class="distd">紧急联系人电话</td>
		<td class="detailtd"><input type="text" id="m_jjlxrdh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">职务</td>
		<td class="detailtd"><input type="text" id="m_zhiwu" value=""></td>
		<td class="distd">入职日期</td>
		<td class="detailtd"><input type="text" id="m_rzrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员状态代码</td>
		<td class="detailtd"><input type="text" id="m_cyryztdm" value=""></td>
		<td class="distd">从业人员状态</td>
		<td class="detailtd"><input type="text" id="m_cyryzt" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">注销人</td>
		<td class="detailtd"><input type="text" id="m_zxr" value=""></td>
		<td class="distd">注销标志</td>
		<td class="detailtd"><input type="text" id="m_zxbz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">注销时间</td>
		<td class="detailtd"><input type="text" id="m_zxsj" value=""></td>
		<td class="distd">录入时间</td>
		<td class="detailtd"><input type="text" id="m_lrsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入人</td>
		<td class="detailtd"><input type="text" id="m_lrr" value=""></td>
		<td class="distd">录入单位编码</td>
		<td class="detailtd"><input type="text" id="m_lrdwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入单位名称</td>
		<td class="detailtd"><input type="text" id="m_lrdwmc" value=""></td>
		<td class="distd">核查单位</td>
		<td class="detailtd"><input type="text" id="m_hcdw" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">核查人</td>
		<td class="detailtd"><input type="text" id="m_hcr" value=""></td>
		<td class="distd">核查时间</td>
		<td class="detailtd"><input type="text" id="m_hcsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">注销原因</td>
		<td class="detailtd"><input type="text" id="m_zxyy" value=""></td>
		<td class="distd">制卡状态</td>
		<td class="detailtd"><input type="text" id="m_zkzt" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">保存时间</td>
		<td class="detailtd"><input type="text" id="m_bcsj" value=""></td>
		<td class="distd">导出标识</td>
		<td class="detailtd"><input type="text" id="m_dcbs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">备注</td>
		<td class="detailtd"><input type="text" id="m_bz" value=""></td>
		<td class="distd">删除标志</td>
		<td class="detailtd"><input type="text" id="m_scbz" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">比对标志</td>
		<td class="detailtd"><input type="text" id="m_biduiflag" value=""></td>
		<td class="distd">照片未通过原因</td>
		<td class="detailtd"><input type="text" id="m_zpwtgyy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">状态</td>
		<td class="detailtd"><input type="text" id="m_zt" value=""></td>
		<td class="distd">英文姓</td>
		<td class="detailtd"><input type="text" id="m_ywx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">英文名</td>
		<td class="detailtd"><input type="text" id="m_ywm" value=""></td>
		<td class="distd">外国人就业许可证号</td>
		<td class="detailtd"><input type="text" id="m_wgrjyxkz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">签证种类代码</td>
		<td class="detailtd"><input type="text" id="m_qzzldm" value=""></td>
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
	<tr height="20">
		<td class="distd">操作类型</td>
		<td class="detailtd"><input type="text" id="m_czlx" value=""></td>
		<td class="distd">变更原因</td>
		<td class="detailtd"><input type="text" id="m_bgyy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">变更类别代码</td>
		<td class="detailtd"><input type="text" id="m_bglbdm" value=""></td>
		<td class="distd">变更类别</td>
		<td class="detailtd"><input type="text" id="m_bglb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">工种代码</td>
		<td class="detailtd"><input type="text" id="m_gzdm" value=""></td>
		<td class="distd">工种</td>
		<td class="detailtd"><input type="text" id="m_gz" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
