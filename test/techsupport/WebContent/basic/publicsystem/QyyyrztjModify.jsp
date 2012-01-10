<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qyid").attr("value",dataid);
		$("#m_qyid").attr("value",dataid);
		setDetail();
		$("#m_riqi").attr("readonly","true");
		$("#m_riqi").datepicker();
		$("#m_ksyysj").attr("readonly","true");
		$("#m_ksyysj").datepicker();
		$("#m_jsyysj").attr("readonly","true");
		$("#m_jsyysj").datepicker();
		$("#m_kyrq").attr("readonly","true");
		$("#m_kyrq").datepicker();
		$("#m_barq").attr("readonly","true");
		$("#m_barq").datepicker();
		$("#m_tyrq").attr("readonly","true");
		$("#m_tyrq").datepicker();
		$("#m_hcsj").attr("readonly","true");
		$("#m_hcsj").datepicker();
		$("#m_dcsj").attr("readonly","true");
		$("#m_dcsj").datepicker();
		$("#m_ztgbrq").attr("readonly","true");
		$("#m_ztgbrq").datepicker();
		$("#m_bcsj").attr("readonly","true");
		$("#m_bcsj").datepicker();
		$("#m_lrsj").attr("readonly","true");
		$("#m_lrsj").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_qyid").attr("value",setNull(json.LQyyyrztj[0].qyid));
		$("#m_yyrzid").attr("value",setNull(json.LQyyyrztj[0].yyrzid));
		$("#m_yyrztjid").attr("value",setNull(json.LQyyyrztj[0].yyrztjid));
		$("#m_riqi").attr("value",setNull(json.LQyyyrztj[0].riqi));
		$("#m_ksyysj").attr("value",setNull(json.LQyyyrztj[0].ksyysj));
		$("#m_jsyysj").attr("value",setNull(json.LQyyyrztj[0].jsyysj));
		$("#m_csfzrbh").attr("value",setNull(json.LQyyyrztj[0].csfzrbh));
		$("#m_csfe").attr("value",setNull(json.LQyyyrztj[0].csfe));
		$("#m_zafzrbh").attr("value",setNull(json.LQyyyrztj[0].zafzrbh));
		$("#m_zafzrxm").attr("value",setNull(json.LQyyyrztj[0].zafzrxm));
		$("#m_sffsaj").attr("value",setNull(json.LQyyyrztj[0].sffsaj));
		$("#m_sfglbmjc").attr("value",setNull(json.LQyyyrztj[0].sfglbmjc));
		$("#m_dryysj").attr("value",setNull(json.LQyyyrztj[0].dryysj));
		$("#m_hylbdm").attr("value",setNull(json.LQyyyrztj[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LQyyyrztj[0].hylb));
		$("#m_qybm").attr("value",setNull(json.LQyyyrztj[0].qybm));
		$("#m_qymc").attr("value",setNull(json.LQyyyrztj[0].qymc));
		$("#m_qyqp").attr("value",setNull(json.LQyyyrztj[0].qyqp));
		$("#m_qyjp").attr("value",setNull(json.LQyyyrztj[0].qyjp));
		$("#m_qyzflbm").attr("value",setNull(json.LQyyyrztj[0].qyzflbm));
		$("#m_qyzflmc").attr("value",setNull(json.LQyyyrztj[0].qyzflmc));
		$("#m_qyfflbm").attr("value",setNull(json.LQyyyrztj[0].qyfflbm));
		$("#m_qyfflmc").attr("value",setNull(json.LQyyyrztj[0].qyfflmc));
		$("#m_gxdwbm").attr("value",setNull(json.LQyyyrztj[0].gxdwbm));
		$("#m_gxdwmc").attr("value",setNull(json.LQyyyrztj[0].gxdwmc));
		$("#m_ssdxjgajgdm").attr("value",setNull(json.LQyyyrztj[0].ssdxjgajgdm));
		$("#m_ssdxjgajgmc").attr("value",setNull(json.LQyyyrztj[0].ssdxjgajgmc));
		$("#m_ssddsjgdm").attr("value",setNull(json.LQyyyrztj[0].ssddsjgdm));
		$("#m_ssddsjgmc").attr("value",setNull(json.LQyyyrztj[0].ssddsjgmc));
		$("#m_qyzzjgdm").attr("value",setNull(json.LQyyyrztj[0].qyzzjgdm));
		$("#m_lxdh").attr("value",setNull(json.LQyyyrztj[0].lxdh));
		$("#m_yzbm").attr("value",setNull(json.LQyyyrztj[0].yzbm));
		$("#m_chzh").attr("value",setNull(json.LQyyyrztj[0].chzh));
		$("#m_jwdzb").attr("value",setNull(json.LQyyyrztj[0].jwdzb));
		$("#m_jjlxbm").attr("value",setNull(json.LQyyyrztj[0].jjlxbm));
		$("#m_jjlxmc").attr("value",setNull(json.LQyyyrztj[0].jjlxmc));
		$("#m_jyfwzy").attr("value",setNull(json.LQyyyrztj[0].jyfwzy));
		$("#m_jyfwjy").attr("value",setNull(json.LQyyyrztj[0].jyfwjy));
		$("#m_zczj").attr("value",setNull(json.LQyyyrztj[0].zczj));
		$("#m_jymj").attr("value",setNull(json.LQyyyrztj[0].jymj));
		$("#m_zabdm").attr("value",setNull(json.LQyyyrztj[0].zabdm));
		$("#m_zajbmc").attr("value",setNull(json.LQyyyrztj[0].zajbmc));
		$("#m_yyztdm").attr("value",setNull(json.LQyyyrztj[0].yyztdm));
		$("#m_yyztmc").attr("value",setNull(json.LQyyyrztj[0].yyztmc));
		$("#m_frdb").attr("value",setNull(json.LQyyyrztj[0].frdb));
		$("#m_frdbzjlb").attr("value",setNull(json.LQyyyrztj[0].frdbzjlb));
		$("#m_frdbzjhm").attr("value",setNull(json.LQyyyrztj[0].frdbzjhm));
		$("#m_frdblxfs").attr("value",setNull(json.LQyyyrztj[0].frdblxfs));
		$("#m_kyrq").attr("value",setNull(json.LQyyyrztj[0].kyrq));
		$("#m_yysj").attr("value",setNull(json.LQyyyrztj[0].yysj));
		$("#m_babh").attr("value",setNull(json.LQyyyrztj[0].babh));
		$("#m_barq").attr("value",setNull(json.LQyyyrztj[0].barq));
		$("#m_tyrq").attr("value",setNull(json.LQyyyrztj[0].tyrq));
		$("#m_jyfs").attr("value",setNull(json.LQyyyrztj[0].jyfs));
		$("#m_jydz").attr("value",setNull(json.LQyyyrztj[0].jydz));
		$("#m_dwfzrzjlb").attr("value",setNull(json.LQyyyrztj[0].dwfzrzjlb));
		$("#m_dwfzrzjhm").attr("value",setNull(json.LQyyyrztj[0].dwfzrzjhm));
		$("#m_dwfzr").attr("value",setNull(json.LQyyyrztj[0].dwfzr));
		$("#m_dwfzrlxfs").attr("value",setNull(json.LQyyyrztj[0].dwfzrlxfs));
		$("#m_xfshdw").attr("value",setNull(json.LQyyyrztj[0].xfshdw));
		$("#m_xfhgzh").attr("value",setNull(json.LQyyyrztj[0].xfhgzh));
		$("#m_hcdw").attr("value",setNull(json.LQyyyrztj[0].hcdw));
		$("#m_hcr").attr("value",setNull(json.LQyyyrztj[0].hcr));
		$("#m_hcsj").attr("value",setNull(json.LQyyyrztj[0].hcsj));
		$("#m_gdxx").attr("value",setNull(json.LQyyyrztj[0].gdxx));
		$("#m_zrs").attr("value",setNull(json.LQyyyrztj[0].zrs));
		$("#m_hdrs").attr("value",setNull(json.LQyyyrztj[0].hdrs));
		$("#m_bagsmc").attr("value",setNull(json.LQyyyrztj[0].bagsmc));
		$("#m_bafzrgmsfhm").attr("value",setNull(json.LQyyyrztj[0].bafzrgmsfhm));
		$("#m_bafzrxm").attr("value",setNull(json.LQyyyrztj[0].bafzrxm));
		$("#m_bafzrdh").attr("value",setNull(json.LQyyyrztj[0].bafzrdh));
		$("#m_bars").attr("value",setNull(json.LQyyyrztj[0].bars));
		$("#m_jgpxrs").attr("value",setNull(json.LQyyyrztj[0].jgpxrs));
		$("#m_bagsyj").attr("value",setNull(json.LQyyyrztj[0].bagsyj));
		$("#m_cksl").attr("value",setNull(json.LQyyyrztj[0].cksl));
		$("#m_bxbjsl").attr("value",setNull(json.LQyyyrztj[0].bxbjsl));
		$("#m_bz").attr("value",setNull(json.LQyyyrztj[0].bz));
		$("#m_dcbs").attr("value",setNull(json.LQyyyrztj[0].dcbs));
		$("#m_dcsj").attr("value",setNull(json.LQyyyrztj[0].dcsj));
		$("#m_zt").attr("value",setNull(json.LQyyyrztj[0].zt));
		$("#m_ztgbrq").attr("value",setNull(json.LQyyyrztj[0].ztgbrq));
		$("#m_scbz").attr("value",setNull(json.LQyyyrztj[0].scbz));
		$("#m_jqbm").attr("value",setNull(json.LQyyyrztj[0].jqbm));
		$("#m_zxbz").attr("value",setNull(json.LQyyyrztj[0].zxbz));
		$("#m_zxyy").attr("value",setNull(json.LQyyyrztj[0].zxyy));
		$("#m_zdskb").attr("value",setNull(json.LQyyyrztj[0].zdskb));
		$("#m_bcsj").attr("value",setNull(json.LQyyyrztj[0].bcsj));
		$("#m_lrsj").attr("value",setNull(json.LQyyyrztj[0].lrsj));
		$("#m_lrr").attr("value",setNull(json.LQyyyrztj[0].lrr));
		$("#m_lrdwbm").attr("value",setNull(json.LQyyyrztj[0].lrdwbm));
		$("#m_lrdwmc").attr("value",setNull(json.LQyyyrztj[0].lrdwmc));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("m_yyrzid","Integer",-9999999999,9999999999,null,0,"营业日志ID"))
			return false;
		if (!checkControlValue("m_yyrztjid","Integer",-9999999999,9999999999,null,0,"营业日志统计ID"))
			return false;
		if (!checkControlValue("m_riqi","Date",null,null,null,0,"日期"))
			return false;
		if (!checkControlValue("m_ksyysj","Date",null,null,null,0,"营业开始时间"))
			return false;
		if (!checkControlValue("m_jsyysj","Date",null,null,null,0,"营业结束时间"))
			return false;
		if (!checkControlValue("m_csfzrbh","String",1,20,null,0,"场所负责人编号"))
			return false;
		if (!checkControlValue("m_csfe","String",1,30,null,0,"场所负责人姓名"))
			return false;
		if (!checkControlValue("m_zafzrbh","String",1,20,null,0,"治安负责人编号"))
			return false;
		if (!checkControlValue("m_zafzrxm","String",1,30,null,0,"治安负责人姓名"))
			return false;
		if (!checkControlValue("m_sffsaj","String",1,1,null,0,"是否有治安、刑事案件或事故发生"))
			return false;
		if (!checkControlValue("m_sfglbmjc","String",1,1,null,0,"是否有管理部门检查"))
			return false;
		if (!checkControlValue("m_dryysj","String",1,2000,null,0,"当日营业状况"))
			return false;
		if (!checkControlValue("m_hylbdm","String",1,3,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("m_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("m_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("m_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("m_qyqp","String",1,100,null,0,"企业全拼"))
			return false;
		if (!checkControlValue("m_qyjp","String",1,30,null,0,"企业简拼"))
			return false;
		if (!checkControlValue("m_qyzflbm","String",1,30,null,0,"企业主分类编码"))
			return false;
		if (!checkControlValue("m_qyzflmc","String",1,300,null,0,"企业主分类名称"))
			return false;
		if (!checkControlValue("m_qyfflbm","String",1,200,null,0,"企业副分类编码"))
			return false;
		if (!checkControlValue("m_qyfflmc","String",1,300,null,0,"企业副分类名称"))
			return false;
		if (!checkControlValue("m_gxdwbm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("m_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("m_ssdxjgajgdm","String",1,20,null,0,"所属地县级公安机关机构代码"))
			return false;
		if (!checkControlValue("m_ssdxjgajgmc","String",1,200,null,0,"所属地县级公安机关名称"))
			return false;
		if (!checkControlValue("m_ssddsjgdm","String",1,20,null,0,"所属地地市机构代码"))
			return false;
		if (!checkControlValue("m_ssddsjgmc","String",1,200,null,0,"所属地地市机构名称"))
			return false;
		if (!checkControlValue("m_qyzzjgdm","String",1,10,null,0,"企业组织机构代码"))
			return false;
		if (!checkControlValue("m_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("m_yzbm","String",1,20,null,0,"邮政编码"))
			return false;
		if (!checkControlValue("m_chzh","String",1,30,null,0,"传真"))
			return false;
		if (!checkControlValue("m_jwdzb","String",1,100,null,0,"经纬度坐标"))
			return false;
		if (!checkControlValue("m_jjlxbm","String",1,4,null,0,"经济类型编码"))
			return false;
		if (!checkControlValue("m_jjlxmc","String",1,60,null,0,"经济类型名称"))
			return false;
		if (!checkControlValue("m_jyfwzy","String",1,2000,null,0,"经营范围（主营）"))
			return false;
		if (!checkControlValue("m_jyfwjy","String",1,2000,null,0,"经营范围（兼营）"))
			return false;
		if (!checkControlValue("m_zczj","Float",-99999999.99,99999999.99,2,0,"注册资金"))
			return false;
		if (!checkControlValue("m_jymj","Float",-99999999.99,99999999.99,2,0,"经营面积"))
			return false;
		if (!checkControlValue("m_zabdm","String",1,4,null,0,"治安级别代码"))
			return false;
		if (!checkControlValue("m_zajbmc","String",1,20,null,0,"治安级别名称"))
			return false;
		if (!checkControlValue("m_yyztdm","String",1,2,null,0,"营业状态代码"))
			return false;
		if (!checkControlValue("m_yyztmc","String",1,20,null,0,"营业状态名称"))
			return false;
		if (!checkControlValue("m_frdb","String",1,30,null,0,"法人代表姓名"))
			return false;
		if (!checkControlValue("m_frdbzjlb","String",1,40,null,0,"法人代表证件类别"))
			return false;
		if (!checkControlValue("m_frdbzjhm","String",1,30,null,0,"法人代表证件号码"))
			return false;
		if (!checkControlValue("m_frdblxfs","String",1,30,null,0,"法人代表联系方式"))
			return false;
		if (!checkControlValue("m_kyrq","Date",null,null,null,0,"开业日期"))
			return false;
		if (!checkControlValue("m_yysj","String",1,20,null,0,"营业时间"))
			return false;
		if (!checkControlValue("m_babh","String",1,30,null,0,"备案编号"))
			return false;
		if (!checkControlValue("m_barq","Date",null,null,null,0,"备案日期"))
			return false;
		if (!checkControlValue("m_tyrq","Date",null,null,null,0,"停业日期"))
			return false;
		if (!checkControlValue("m_jyfs","String",1,20,null,0,"经营方式"))
			return false;
		if (!checkControlValue("m_jydz","String",1,200,null,0,"经营地址"))
			return false;
		if (!checkControlValue("m_dwfzrzjlb","String",1,40,null,0,"单位负责人证件类别"))
			return false;
		if (!checkControlValue("m_dwfzrzjhm","String",1,30,null,0,"单位负责人证件号码"))
			return false;
		if (!checkControlValue("m_dwfzr","String",1,30,null,0,"单位负责人姓名"))
			return false;
		if (!checkControlValue("m_dwfzrlxfs","String",1,30,null,0,"单位负责人联系方式"))
			return false;
		if (!checkControlValue("m_xfshdw","String",1,200,null,0,"消防审核单位"))
			return false;
		if (!checkControlValue("m_xfhgzh","String",1,20,null,0,"消防合格证号"))
			return false;
		if (!checkControlValue("m_hcdw","String",1,100,null,0,"核查单位"))
			return false;
		if (!checkControlValue("m_hcr","String",1,30,null,0,"核查人"))
			return false;
		if (!checkControlValue("m_hcsj","Date",null,null,null,0,"核查时间"))
			return false;
		if (!checkControlValue("m_gdxx","String",1,2000,null,0,"股东信息"))
			return false;
		if (!checkControlValue("m_zrs","Integer",-999999,999999,null,0,"总人数"))
			return false;
		if (!checkControlValue("m_hdrs","Integer",-999999,999999,null,0,"核定人数"))
			return false;
		if (!checkControlValue("m_bagsmc","String",1,60,null,0,"保安公司名称"))
			return false;
		if (!checkControlValue("m_bafzrgmsfhm","String",1,20,null,0,"保安负责人公民身份号码"))
			return false;
		if (!checkControlValue("m_bafzrxm","String",1,30,null,0,"保安负责人姓名"))
			return false;
		if (!checkControlValue("m_bafzrdh","String",1,30,null,0,"保安负责人电话"))
			return false;
		if (!checkControlValue("m_bars","Integer",-999999,999999,null,0,"保安人数"))
			return false;
		if (!checkControlValue("m_jgpxrs","Integer",-999999,999999,null,0,"经岗位培训人数"))
			return false;
		if (!checkControlValue("m_bagsyj","String",1,2000,null,0,"保安公司意见"))
			return false;
		if (!checkControlValue("m_cksl","Integer",-999999,999999,null,0,"出口数量"))
			return false;
		if (!checkControlValue("m_bxbjsl","Integer",-999999,999999,null,0,"包厢包间数量"))
			return false;
		if (!checkControlValue("m_bz","String",1,2000,null,0,"备注"))
			return false;
		if (!checkControlValue("m_dcbs","Integer",-99,99,null,0,"导出标识"))
			return false;
		if (!checkControlValue("m_dcsj","Date",null,null,null,0,"导出时间"))
			return false;
		if (!checkControlValue("m_zt","String",1,10,null,0,"状态"))
			return false;
		if (!checkControlValue("m_ztgbrq","Date",null,null,null,0,"状态改变日期"))
			return false;
		if (!checkControlValue("m_scbz","Integer",-99,99,null,0,"删除标志"))
			return false;
		if (!checkControlValue("m_jqbm","String",1,10,null,0,"机器编码"))
			return false;
		if (!checkControlValue("m_zxbz","String",1,2,null,0,"注销标志"))
			return false;
		if (!checkControlValue("m_zxyy","String",1,200,null,0,"注销原因"))
			return false;
		if (!checkControlValue("m_zdskb","Float",-999.99,999.99,2,0,"最低刷卡比"))
			return false;
		if (!checkControlValue("m_bcsj","Date",null,null,null,0,"保存时间"))
			return false;
		if (!checkControlValue("m_lrsj","Date",null,null,null,0,"录入时间"))
			return false;
		if (!checkControlValue("m_lrr","String",1,100,null,0,"录入人"))
			return false;
		if (!checkControlValue("m_lrdwbm","String",1,20,null,0,"录入单位编码"))
			return false;
		if (!checkControlValue("m_lrdwmc","String",1,60,null,0,"录入单位名称"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qyid">
<input type="hidden" id="m_qyid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyyyrztj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="m_qyid" value="0"></td>
		<td class="distd">营业日志ID</td>
		<td class="detailtd"><input type="text" id="m_yyrzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">营业日志统计ID</td>
		<td class="detailtd"><input type="text" id="m_yyrztjid" value="0"></td>
		<td class="distd">日期</td>
		<td class="detailtd"><input type="text" id="m_riqi" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">营业开始时间</td>
		<td class="detailtd"><input type="text" id="m_ksyysj" value=""></td>
		<td class="distd">营业结束时间</td>
		<td class="detailtd"><input type="text" id="m_jsyysj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">场所负责人编号</td>
		<td class="detailtd"><input type="text" id="m_csfzrbh" value=""></td>
		<td class="distd">场所负责人姓名</td>
		<td class="detailtd"><input type="text" id="m_csfe" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">治安负责人编号</td>
		<td class="detailtd"><input type="text" id="m_zafzrbh" value=""></td>
		<td class="distd">治安负责人姓名</td>
		<td class="detailtd"><input type="text" id="m_zafzrxm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">是否有治安、刑事案件或事故发生</td>
		<td class="detailtd"><input type="text" id="m_sffsaj" value=""></td>
		<td class="distd">是否有管理部门检查</td>
		<td class="detailtd"><input type="text" id="m_sfglbmjc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">当日营业状况</td>
		<td class="detailtd"><input type="text" id="m_dryysj" value=""></td>
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="m_hylbdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="m_hylb" value=""></td>
		<td class="distd">企业编码</td>
		<td class="detailtd"><input type="text" id="m_qybm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业名称</td>
		<td class="detailtd"><input type="text" id="m_qymc" value=""></td>
		<td class="distd">企业全拼</td>
		<td class="detailtd"><input type="text" id="m_qyqp" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业简拼</td>
		<td class="detailtd"><input type="text" id="m_qyjp" value=""></td>
		<td class="distd">企业主分类编码</td>
		<td class="detailtd"><input type="text" id="m_qyzflbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业主分类名称</td>
		<td class="detailtd"><input type="text" id="m_qyzflmc" value=""></td>
		<td class="distd">企业副分类编码</td>
		<td class="detailtd"><input type="text" id="m_qyfflbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业副分类名称</td>
		<td class="detailtd"><input type="text" id="m_qyfflmc" value=""></td>
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" id="m_gxdwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" id="m_gxdwmc" value=""></td>
		<td class="distd">所属地县级公安机关机构代码</td>
		<td class="detailtd"><input type="text" id="m_ssdxjgajgdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">所属地县级公安机关名称</td>
		<td class="detailtd"><input type="text" id="m_ssdxjgajgmc" value=""></td>
		<td class="distd">所属地地市机构代码</td>
		<td class="detailtd"><input type="text" id="m_ssddsjgdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">所属地地市机构名称</td>
		<td class="detailtd"><input type="text" id="m_ssddsjgmc" value=""></td>
		<td class="distd">企业组织机构代码</td>
		<td class="detailtd"><input type="text" id="m_qyzzjgdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">联系电话</td>
		<td class="detailtd"><input type="text" id="m_lxdh" value=""></td>
		<td class="distd">邮政编码</td>
		<td class="detailtd"><input type="text" id="m_yzbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">传真</td>
		<td class="detailtd"><input type="text" id="m_chzh" value=""></td>
		<td class="distd">经纬度坐标</td>
		<td class="detailtd"><input type="text" id="m_jwdzb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">经济类型编码</td>
		<td class="detailtd"><input type="text" id="m_jjlxbm" value=""></td>
		<td class="distd">经济类型名称</td>
		<td class="detailtd"><input type="text" id="m_jjlxmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">经营范围（主营）</td>
		<td class="detailtd"><input type="text" id="m_jyfwzy" value=""></td>
		<td class="distd">经营范围（兼营）</td>
		<td class="detailtd"><input type="text" id="m_jyfwjy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">注册资金</td>
		<td class="detailtd"><input type="text" id="m_zczj" value="0"></td>
		<td class="distd">经营面积</td>
		<td class="detailtd"><input type="text" id="m_jymj" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">治安级别代码</td>
		<td class="detailtd"><input type="text" id="m_zabdm" value=""></td>
		<td class="distd">治安级别名称</td>
		<td class="detailtd"><input type="text" id="m_zajbmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">营业状态代码</td>
		<td class="detailtd"><input type="text" id="m_yyztdm" value=""></td>
		<td class="distd">营业状态名称</td>
		<td class="detailtd"><input type="text" id="m_yyztmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">法人代表姓名</td>
		<td class="detailtd"><input type="text" id="m_frdb" value=""></td>
		<td class="distd">法人代表证件类别</td>
		<td class="detailtd"><input type="text" id="m_frdbzjlb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">法人代表证件号码</td>
		<td class="detailtd"><input type="text" id="m_frdbzjhm" value=""></td>
		<td class="distd">法人代表联系方式</td>
		<td class="detailtd"><input type="text" id="m_frdblxfs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">开业日期</td>
		<td class="detailtd"><input type="text" id="m_kyrq" value=""></td>
		<td class="distd">营业时间</td>
		<td class="detailtd"><input type="text" id="m_yysj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">备案编号</td>
		<td class="detailtd"><input type="text" id="m_babh" value=""></td>
		<td class="distd">备案日期</td>
		<td class="detailtd"><input type="text" id="m_barq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">停业日期</td>
		<td class="detailtd"><input type="text" id="m_tyrq" value=""></td>
		<td class="distd">经营方式</td>
		<td class="detailtd"><input type="text" id="m_jyfs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">经营地址</td>
		<td class="detailtd"><input type="text" id="m_jydz" value=""></td>
		<td class="distd">单位负责人证件类别</td>
		<td class="detailtd"><input type="text" id="m_dwfzrzjlb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">单位负责人证件号码</td>
		<td class="detailtd"><input type="text" id="m_dwfzrzjhm" value=""></td>
		<td class="distd">单位负责人姓名</td>
		<td class="detailtd"><input type="text" id="m_dwfzr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">单位负责人联系方式</td>
		<td class="detailtd"><input type="text" id="m_dwfzrlxfs" value=""></td>
		<td class="distd">消防审核单位</td>
		<td class="detailtd"><input type="text" id="m_xfshdw" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">消防合格证号</td>
		<td class="detailtd"><input type="text" id="m_xfhgzh" value=""></td>
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
		<td class="distd">股东信息</td>
		<td class="detailtd"><input type="text" id="m_gdxx" value=""></td>
		<td class="distd">总人数</td>
		<td class="detailtd"><input type="text" id="m_zrs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">核定人数</td>
		<td class="detailtd"><input type="text" id="m_hdrs" value="0"></td>
		<td class="distd">保安公司名称</td>
		<td class="detailtd"><input type="text" id="m_bagsmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">保安负责人公民身份号码</td>
		<td class="detailtd"><input type="text" id="m_bafzrgmsfhm" value=""></td>
		<td class="distd">保安负责人姓名</td>
		<td class="detailtd"><input type="text" id="m_bafzrxm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">保安负责人电话</td>
		<td class="detailtd"><input type="text" id="m_bafzrdh" value=""></td>
		<td class="distd">保安人数</td>
		<td class="detailtd"><input type="text" id="m_bars" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">经岗位培训人数</td>
		<td class="detailtd"><input type="text" id="m_jgpxrs" value="0"></td>
		<td class="distd">保安公司意见</td>
		<td class="detailtd"><input type="text" id="m_bagsyj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">出口数量</td>
		<td class="detailtd"><input type="text" id="m_cksl" value="0"></td>
		<td class="distd">包厢包间数量</td>
		<td class="detailtd"><input type="text" id="m_bxbjsl" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">备注</td>
		<td class="detailtd"><input type="text" id="m_bz" value=""></td>
		<td class="distd">导出标识</td>
		<td class="detailtd"><input type="text" id="m_dcbs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">导出时间</td>
		<td class="detailtd"><input type="text" id="m_dcsj" value=""></td>
		<td class="distd">状态</td>
		<td class="detailtd"><input type="text" id="m_zt" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">状态改变日期</td>
		<td class="detailtd"><input type="text" id="m_ztgbrq" value=""></td>
		<td class="distd">删除标志</td>
		<td class="detailtd"><input type="text" id="m_scbz" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">机器编码</td>
		<td class="detailtd"><input type="text" id="m_jqbm" value=""></td>
		<td class="distd">注销标志</td>
		<td class="detailtd"><input type="text" id="m_zxbz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">注销原因</td>
		<td class="detailtd"><input type="text" id="m_zxyy" value=""></td>
		<td class="distd">最低刷卡比</td>
		<td class="detailtd"><input type="text" id="m_zdskb" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">保存时间</td>
		<td class="detailtd"><input type="text" id="m_bcsj" value=""></td>
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
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
