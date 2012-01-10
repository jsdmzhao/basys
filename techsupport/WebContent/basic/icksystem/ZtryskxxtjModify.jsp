<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qyryskxxtjmxid").attr("value",dataid);
		$("#m_qyryskxxtjmxid").attr("value",dataid);
		setDetail();
		$("#m_sksj").attr("readonly","true");
		$("#m_sksj").datepicker();
		$("#m_scsj").attr("readonly","true");
		$("#m_scsj").datepicker();
		$("#m_csrq").attr("readonly","true");
		$("#m_csrq").datepicker();
		$("#m_rzrq").attr("readonly","true");
		$("#m_rzrq").datepicker();
		$("#m_lzrq").attr("readonly","true");
		$("#m_lzrq").datepicker();
		$("#m_cxsj").attr("readonly","true");
		$("#m_cxsj").datepicker();
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
		$("#m_slsj").attr("readonly","true");
		$("#m_slsj").datepicker();
		$("#m_yxsksrq").attr("readonly","true");
		$("#m_yxsksrq").datepicker();
		$("#m_yxqhzrq").attr("readonly","true");
		$("#m_yxqhzrq").datepicker();
		$("#m_ickcjsj").attr("readonly","true");
		$("#m_ickcjsj").datepicker();
		$("#m_jssj").attr("readonly","true");
		$("#m_jssj").datepicker();
		$("#m_ffsj").attr("readonly","true");
		$("#m_ffsj").datepicker();
		$("#m_lqsj").attr("readonly","true");
		$("#m_lqsj").datepicker();
		$("#m_ickzxsj").attr("readonly","true");
		$("#m_ickzxsj").datepicker();
		$("#m_njsj").attr("readonly","true");
		$("#m_njsj").datepicker();
		$("#m_yssj").attr("readonly","true");
		$("#m_yssj").datepicker();
		$("#m_dxrsj").attr("readonly","true");
		$("#m_dxrsj").datepicker();
		$("#m_cyssj").attr("readonly","true");
		$("#m_cyssj").datepicker();
		$("#m_cdxrsj").attr("readonly","true");
		$("#m_cdxrsj").datepicker();
		$("#m_tjrq").attr("readonly","true");
		$("#m_tjrq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_qyryskxxtjmxid").attr("value",setNull(json.LZtryskxxtj[0].qyryskxxtjmxid));
		$("#m_qybm").attr("value",setNull(json.LZtryskxxtj[0].qybm));
		$("#m_qymc").attr("value",setNull(json.LZtryskxxtj[0].qymc));
		$("#m_qyzflbm").attr("value",setNull(json.LZtryskxxtj[0].qyzflbm));
		$("#m_qyzflmc").attr("value",setNull(json.LZtryskxxtj[0].qyzflmc));
		$("#m_qyfflbm").attr("value",setNull(json.LZtryskxxtj[0].qyfflbm));
		$("#m_qyfflmc").attr("value",setNull(json.LZtryskxxtj[0].qyfflmc));
		$("#m_gxdwbm").attr("value",setNull(json.LZtryskxxtj[0].gxdwbm));
		$("#m_gxdwmc").attr("value",setNull(json.LZtryskxxtj[0].gxdwmc));
		$("#m_ssqyid").attr("value",setNull(json.LZtryskxxtj[0].ssqyid));
		$("#m_ssqybm").attr("value",setNull(json.LZtryskxxtj[0].ssqybm));
		$("#m_ssqymc").attr("value",setNull(json.LZtryskxxtj[0].ssqymc));
		$("#m_ssqygxdwdm").attr("value",setNull(json.LZtryskxxtj[0].ssqygxdwdm));
		$("#m_ssqygxdwmc").attr("value",setNull(json.LZtryskxxtj[0].ssqygxdwmc));
		$("#m_ssqyzfldm").attr("value",setNull(json.LZtryskxxtj[0].ssqyzfldm));
		$("#m_ssqyzflmc").attr("value",setNull(json.LZtryskxxtj[0].ssqyzflmc));
		$("#m_hylbdm").attr("value",setNull(json.LZtryskxxtj[0].hylbdm));
		$("#m_hylb").attr("value",setNull(json.LZtryskxxtj[0].hylb));
		$("#m_sksj").attr("value",setNull(json.LZtryskxxtj[0].sksj));
		$("#m_scsj").attr("value",setNull(json.LZtryskxxtj[0].scsj));
		$("#m_ryid").attr("value",setNull(json.LZtryskxxtj[0].ryid));
		$("#m_cyrybh").attr("value",setNull(json.LZtryskxxtj[0].cyrybh));
		$("#m_cyrylbdm").attr("value",setNull(json.LZtryskxxtj[0].cyrylbdm));
		$("#m_cyrylbmc").attr("value",setNull(json.LZtryskxxtj[0].cyrylbmc));
		$("#m_xm").attr("value",setNull(json.LZtryskxxtj[0].xm));
		$("#m_qm").attr("value",setNull(json.LZtryskxxtj[0].qm));
		$("#m_bm").attr("value",setNull(json.LZtryskxxtj[0].bm));
		$("#m_xmpy").attr("value",setNull(json.LZtryskxxtj[0].xmpy));
		$("#m_gjdm").attr("value",setNull(json.LZtryskxxtj[0].gjdm));
		$("#m_gj").attr("value",setNull(json.LZtryskxxtj[0].gj));
		$("#m_mzdm").attr("value",setNull(json.LZtryskxxtj[0].mzdm));
		$("#m_minzu").attr("value",setNull(json.LZtryskxxtj[0].minzu));
		$("#m_xbdm").attr("value",setNull(json.LZtryskxxtj[0].xbdm));
		$("#m_xb").attr("value",setNull(json.LZtryskxxtj[0].xb));
		$("#m_csrq").attr("value",setNull(json.LZtryskxxtj[0].csrq));
		$("#m_hyzkdm").attr("value",setNull(json.LZtryskxxtj[0].hyzkdm));
		$("#m_hyzk").attr("value",setNull(json.LZtryskxxtj[0].hyzk));
		$("#m_shengao").attr("value",setNull(json.LZtryskxxtj[0].shengao));
		$("#m_tizh").attr("value",setNull(json.LZtryskxxtj[0].tizh));
		$("#m_xxdm").attr("value",setNull(json.LZtryskxxtj[0].xxdm));
		$("#m_xx").attr("value",setNull(json.LZtryskxxtj[0].xx));
		$("#m_hjdxzqh").attr("value",setNull(json.LZtryskxxtj[0].hjdxzqh));
		$("#m_hjdxzqhdm").attr("value",setNull(json.LZtryskxxtj[0].hjdxzqhdm));
		$("#m_hjdxz").attr("value",setNull(json.LZtryskxxtj[0].hjdxz));
		$("#m_cyzjdm").attr("value",setNull(json.LZtryskxxtj[0].cyzjdm));
		$("#m_cyzj").attr("value",setNull(json.LZtryskxxtj[0].cyzj));
		$("#m_zjhm").attr("value",setNull(json.LZtryskxxtj[0].zjhm));
		$("#m_zzzhm").attr("value",setNull(json.LZtryskxxtj[0].zzzhm));
		$("#m_zzdz").attr("value",setNull(json.LZtryskxxtj[0].zzdz));
		$("#m_gwbh").attr("value",setNull(json.LZtryskxxtj[0].gwbh));
		$("#m_gwmc").attr("value",setNull(json.LZtryskxxtj[0].gwmc));
		$("#m_gwzrms").attr("value",setNull(json.LZtryskxxtj[0].gwzrms));
		$("#m_shouji").attr("value",setNull(json.LZtryskxxtj[0].shouji));
		$("#m_lxdh").attr("value",setNull(json.LZtryskxxtj[0].lxdh));
		$("#m_jjlxr").attr("value",setNull(json.LZtryskxxtj[0].jjlxr));
		$("#m_jjlxrdh").attr("value",setNull(json.LZtryskxxtj[0].jjlxrdh));
		$("#m_gzdm").attr("value",setNull(json.LZtryskxxtj[0].gzdm));
		$("#m_gz").attr("value",setNull(json.LZtryskxxtj[0].gz));
		$("#m_zhiwu").attr("value",setNull(json.LZtryskxxtj[0].zhiwu));
		$("#m_rzrq").attr("value",setNull(json.LZtryskxxtj[0].rzrq));
		$("#m_lzrq").attr("value",setNull(json.LZtryskxxtj[0].lzrq));
		$("#m_cyryztdm").attr("value",setNull(json.LZtryskxxtj[0].cyryztdm));
		$("#m_cyryzt").attr("value",setNull(json.LZtryskxxtj[0].cyryzt));
		$("#m_cxr").attr("value",setNull(json.LZtryskxxtj[0].cxr));
		$("#m_zxbz").attr("value",setNull(json.LZtryskxxtj[0].zxbz));
		$("#m_cxsj").attr("value",setNull(json.LZtryskxxtj[0].cxsj));
		$("#m_lrsj").attr("value",setNull(json.LZtryskxxtj[0].lrsj));
		$("#m_lrr").attr("value",setNull(json.LZtryskxxtj[0].lrr));
		$("#m_lrdwbm").attr("value",setNull(json.LZtryskxxtj[0].lrdwbm));
		$("#m_lrdwmc").attr("value",setNull(json.LZtryskxxtj[0].lrdwmc));
		$("#m_hcdw").attr("value",setNull(json.LZtryskxxtj[0].hcdw));
		$("#m_hcr").attr("value",setNull(json.LZtryskxxtj[0].hcr));
		$("#m_hcsj").attr("value",setNull(json.LZtryskxxtj[0].hcsj));
		$("#m_zxyy").attr("value",setNull(json.LZtryskxxtj[0].zxyy));
		$("#m_zkzt").attr("value",setNull(json.LZtryskxxtj[0].zkzt));
		$("#m_bcsj").attr("value",setNull(json.LZtryskxxtj[0].bcsj));
		$("#m_dcbs").attr("value",setNull(json.LZtryskxxtj[0].dcbs));
		$("#m_bz").attr("value",setNull(json.LZtryskxxtj[0].bz));
		$("#m_scbz").attr("value",setNull(json.LZtryskxxtj[0].scbz));
		$("#m_biduiflag").attr("value",setNull(json.LZtryskxxtj[0].biduiflag));
		$("#m_zpwtgyy").attr("value",setNull(json.LZtryskxxtj[0].zpwtgyy));
		$("#m_zt").attr("value",setNull(json.LZtryskxxtj[0].zt));
		$("#m_ywx").attr("value",setNull(json.LZtryskxxtj[0].ywx));
		$("#m_ywm").attr("value",setNull(json.LZtryskxxtj[0].ywm));
		$("#m_wgrjyxkz").attr("value",setNull(json.LZtryskxxtj[0].wgrjyxkz));
		$("#m_qzzldm").attr("value",setNull(json.LZtryskxxtj[0].qzzldm));
		$("#m_qzhm").attr("value",setNull(json.LZtryskxxtj[0].qzhm));
		$("#m_zatlq").attr("value",setNull(json.LZtryskxxtj[0].zatlq));
		$("#m_qfjg").attr("value",setNull(json.LZtryskxxtj[0].qfjg));
		$("#m_rjrq").attr("value",setNull(json.LZtryskxxtj[0].rjrq));
		$("#m_rjka").attr("value",setNull(json.LZtryskxxtj[0].rjka));
		$("#m_kh").attr("value",setNull(json.LZtryskxxtj[0].kh));
		$("#m_ickh").attr("value",setNull(json.LZtryskxxtj[0].ickh));
		$("#m_slyy").attr("value",setNull(json.LZtryskxxtj[0].slyy));
		$("#m_slr").attr("value",setNull(json.LZtryskxxtj[0].slr));
		$("#m_slsj").attr("value",setNull(json.LZtryskxxtj[0].slsj));
		$("#m_yxsksrq").attr("value",setNull(json.LZtryskxxtj[0].yxsksrq));
		$("#m_yxqhzrq").attr("value",setNull(json.LZtryskxxtj[0].yxqhzrq));
		$("#m_ickcjsj").attr("value",setNull(json.LZtryskxxtj[0].ickcjsj));
		$("#m_ickcjr").attr("value",setNull(json.LZtryskxxtj[0].ickcjr));
		$("#m_ickcjdbm").attr("value",setNull(json.LZtryskxxtj[0].ickcjdbm));
		$("#m_ickcjdmc").attr("value",setNull(json.LZtryskxxtj[0].ickcjdmc));
		$("#m_jssj").attr("value",setNull(json.LZtryskxxtj[0].jssj));
		$("#m_jsbmc").attr("value",setNull(json.LZtryskxxtj[0].jsbmc));
		$("#m_ffr").attr("value",setNull(json.LZtryskxxtj[0].ffr));
		$("#m_ffsj").attr("value",setNull(json.LZtryskxxtj[0].ffsj));
		$("#m_lqr").attr("value",setNull(json.LZtryskxxtj[0].lqr));
		$("#m_lqsj").attr("value",setNull(json.LZtryskxxtj[0].lqsj));
		$("#m_lqrzjlx").attr("value",setNull(json.LZtryskxxtj[0].lqrzjlx));
		$("#m_lqrzjhm").attr("value",setNull(json.LZtryskxxtj[0].lqrzjhm));
		$("#m_ickzxr").attr("value",setNull(json.LZtryskxxtj[0].ickzxr));
		$("#m_ickzxsj").attr("value",setNull(json.LZtryskxxtj[0].ickzxsj));
		$("#m_ickzxyy").attr("value",setNull(json.LZtryskxxtj[0].ickzxyy));
		$("#m_njr").attr("value",setNull(json.LZtryskxxtj[0].njr));
		$("#m_njsj").attr("value",setNull(json.LZtryskxxtj[0].njsj));
		$("#m_zkztbs").attr("value",setNull(json.LZtryskxxtj[0].zkztbs));
		$("#m_sfqr").attr("value",setNull(json.LZtryskxxtj[0].sfqr));
		$("#m_ysr").attr("value",setNull(json.LZtryskxxtj[0].ysr));
		$("#m_yssj").attr("value",setNull(json.LZtryskxxtj[0].yssj));
		$("#m_dxrr").attr("value",setNull(json.LZtryskxxtj[0].dxrr));
		$("#m_dxrsj").attr("value",setNull(json.LZtryskxxtj[0].dxrsj));
		$("#m_cyssj").attr("value",setNull(json.LZtryskxxtj[0].cyssj));
		$("#m_cysyy").attr("value",setNull(json.LZtryskxxtj[0].cysyy));
		$("#m_cdxrsj").attr("value",setNull(json.LZtryskxxtj[0].cdxrsj));
		$("#m_cdxryy").attr("value",setNull(json.LZtryskxxtj[0].cdxryy));
		$("#m_bhkyy").attr("value",setNull(json.LZtryskxxtj[0].bhkyy));
		$("#m_yksfsh").attr("value",setNull(json.LZtryskxxtj[0].yksfsh));
		$("#m_ztryskxxtjmxid").attr("value",setNull(json.LZtryskxxtj[0].ztryskxxtjmxid));
		$("#m_skid3").attr("value",setNull(json.LZtryskxxtj[0].skid3));
		$("#m_tjrq").attr("value",setNull(json.LZtryskxxtj[0].tjrq));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qyryskxxtjmxid","Integer",-9999999999,9999999999,null,0,"企业人员刷卡信息统计明细ID"))
			return false;
		if (!checkControlValue("m_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("m_qymc","String",1,120,null,0,"企业名称"))
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
		if (!checkControlValue("m_ssqyid","Integer",-9999999999,9999999999,null,0,"所属企业ID"))
			return false;
		if (!checkControlValue("m_ssqybm","String",1,20,null,0,"所属企业编码"))
			return false;
		if (!checkControlValue("m_ssqymc","String",1,120,null,0,"所属企业名称"))
			return false;
		if (!checkControlValue("m_ssqygxdwdm","String",1,20,null,0,"所属企业管辖单位代码"))
			return false;
		if (!checkControlValue("m_ssqygxdwmc","String",1,60,null,0,"所属企业管辖单位名称"))
			return false;
		if (!checkControlValue("m_ssqyzfldm","String",1,300,null,0,"所属企业主分类代码"))
			return false;
		if (!checkControlValue("m_ssqyzflmc","String",1,300,null,0,"所属企业主分类名称"))
			return false;
		if (!checkControlValue("m_hylbdm","String",1,3,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("m_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("m_sksj","Date",null,null,null,0,"刷卡时间"))
			return false;
		if (!checkControlValue("m_scsj","Date",null,null,null,0,"上传时间"))
			return false;
		if (!checkControlValue("m_ryid","Integer",-9999999999,9999999999,null,0,"从业人员ID"))
			return false;
		if (!checkControlValue("m_cyrybh","String",1,30,null,0,"从业人员编号"))
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
		if (!checkControlValue("m_xxdm","String",1,2,null,0,"血型代码"))
			return false;
		if (!checkControlValue("m_xx","String",1,10,null,0,"血型"))
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
		if (!checkControlValue("m_gzdm","String",1,4,null,0,"工种代码"))
			return false;
		if (!checkControlValue("m_gz","String",1,60,null,0,"工种"))
			return false;
		if (!checkControlValue("m_zhiwu","String",1,20,null,0,"职务"))
			return false;
		if (!checkControlValue("m_rzrq","Date",null,null,null,0,"入职日期"))
			return false;
		if (!checkControlValue("m_lzrq","Date",null,null,null,0,"离职日期"))
			return false;
		if (!checkControlValue("m_cyryztdm","String",1,2,null,0,"从业人员状态代码"))
			return false;
		if (!checkControlValue("m_cyryzt","String",1,4,null,0,"从业人员状态"))
			return false;
		if (!checkControlValue("m_cxr","String",1,30,null,0,"撤销人"))
			return false;
		if (!checkControlValue("m_zxbz","String",1,2,null,0,"注销标志"))
			return false;
		if (!checkControlValue("m_cxsj","Date",null,null,null,0,"撤销时间"))
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
		if (!checkControlValue("m_zt","String",1,2,null,0,"状态"))
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
		if (!checkControlValue("m_kh","String",1,20,null,0,"卡号"))
			return false;
		if (!checkControlValue("m_ickh","String",1,100,null,0,"卡ID号"))
			return false;
		if (!checkControlValue("m_slyy","String",1,200,null,0,"申领原因"))
			return false;
		if (!checkControlValue("m_slr","String",1,30,null,0,"受理人"))
			return false;
		if (!checkControlValue("m_slsj","Date",null,null,null,0,"受理时间"))
			return false;
		if (!checkControlValue("m_yxsksrq","Date",null,null,null,0,"有效期开始日期"))
			return false;
		if (!checkControlValue("m_yxqhzrq","Date",null,null,null,0,"有效期截至日期"))
			return false;
		if (!checkControlValue("m_ickcjsj","Date",null,null,null,0,"IC卡采集时间"))
			return false;
		if (!checkControlValue("m_ickcjr","String",1,30,null,0,"IC卡采集人"))
			return false;
		if (!checkControlValue("m_ickcjdbm","String",1,20,null,0,"IC卡采集点编码"))
			return false;
		if (!checkControlValue("m_ickcjdmc","String",1,100,null,0,"IC卡采集点名称"))
			return false;
		if (!checkControlValue("m_jssj","Date",null,null,null,0,"接收时间"))
			return false;
		if (!checkControlValue("m_jsbmc","String",1,20,null,0,"接收包名称"))
			return false;
		if (!checkControlValue("m_ffr","String",1,30,null,0,"发放人"))
			return false;
		if (!checkControlValue("m_ffsj","Date",null,null,null,0,"发放时间"))
			return false;
		if (!checkControlValue("m_lqr","String",1,30,null,0,"领取人"))
			return false;
		if (!checkControlValue("m_lqsj","Date",null,null,null,0,"领取时间"))
			return false;
		if (!checkControlValue("m_lqrzjlx","String",1,40,null,0,"领取人证件类型"))
			return false;
		if (!checkControlValue("m_lqrzjhm","String",1,20,null,0,"领取人证件号码"))
			return false;
		if (!checkControlValue("m_ickzxr","String",1,30,null,0,"IC卡注销人"))
			return false;
		if (!checkControlValue("m_ickzxsj","Date",null,null,null,0,"IC卡注销时间"))
			return false;
		if (!checkControlValue("m_ickzxyy","String",1,200,null,0,"IC卡注销原因"))
			return false;
		if (!checkControlValue("m_njr","String",1,30,null,0,"年检人"))
			return false;
		if (!checkControlValue("m_njsj","Date",null,null,null,0,"年检时间"))
			return false;
		if (!checkControlValue("m_zkztbs","String",1,2,null,0,"制卡状态标识"))
			return false;
		if (!checkControlValue("m_sfqr","String",1,1,null,0,"是否确认"))
			return false;
		if (!checkControlValue("m_ysr","String",1,100,null,0,"印刷人"))
			return false;
		if (!checkControlValue("m_yssj","Date",null,null,null,0,"印刷时间"))
			return false;
		if (!checkControlValue("m_dxrr","String",1,100,null,0,"电写入人"))
			return false;
		if (!checkControlValue("m_dxrsj","Date",null,null,null,0,"电写入时间"))
			return false;
		if (!checkControlValue("m_cyssj","Date",null,null,null,0,"重印刷时间"))
			return false;
		if (!checkControlValue("m_cysyy","String",1,200,null,0,"重印刷原因"))
			return false;
		if (!checkControlValue("m_cdxrsj","Date",null,null,null,0,"重电写入时间"))
			return false;
		if (!checkControlValue("m_cdxryy","String",1,200,null,0,"重电写入原因"))
			return false;
		if (!checkControlValue("m_bhkyy","String",1,200,null,0,"补换卡原因"))
			return false;
		if (!checkControlValue("m_yksfsh","String",1,1,null,0,"原卡是否收回"))
			return false;
		if (!checkControlValue("m_ztryskxxtjmxid","Integer",-9999999999,9999999999,null,0,"走台人员刷卡信息统计明细id"))
			return false;
		if (!checkControlValue("m_skid3","Integer",-9999999999,9999999999,null,0,"刷卡ID"))
			return false;
		if (!checkControlValue("m_tjrq","Date",null,null,null,0,"统计日期"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qyryskxxtjmxid">
<input type="hidden" id="m_qyryskxxtjmxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#ztryskxxtj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">企业人员刷卡信息统计明细ID</td>
		<td class="detailtd"><input type="text" id="m_qyryskxxtjmxid" class="inputstyle" value="0"></td>
		<td class="distd">企业编码</td>
		<td class="detailtd"><input type="text" id="m_qybm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业名称</td>
		<td class="detailtd"><input type="text" id="m_qymc" class="inputstyle" value=""></td>
		<td class="distd">企业主分类编码</td>
		<td class="detailtd"><input type="text" id="m_qyzflbm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业主分类名称</td>
		<td class="detailtd"><input type="text" id="m_qyzflmc" class="inputstyle" value=""></td>
		<td class="distd">企业副分类编码</td>
		<td class="detailtd"><input type="text" id="m_qyfflbm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业副分类名称</td>
		<td class="detailtd"><input type="text" id="m_qyfflmc" class="inputstyle" value=""></td>
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" id="m_gxdwbm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" id="m_gxdwmc" class="inputstyle" value=""></td>
		<td class="distd">所属企业ID</td>
		<td class="detailtd"><input type="text" id="m_ssqyid" class="inputstyle" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">所属企业编码</td>
		<td class="detailtd"><input type="text" id="m_ssqybm" class="inputstyle" value=""></td>
		<td class="distd">所属企业名称</td>
		<td class="detailtd"><input type="text" id="m_ssqymc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">所属企业管辖单位代码</td>
		<td class="detailtd"><input type="text" id="m_ssqygxdwdm" class="inputstyle" value=""></td>
		<td class="distd">所属企业管辖单位名称</td>
		<td class="detailtd"><input type="text" id="m_ssqygxdwmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">所属企业主分类代码</td>
		<td class="detailtd"><input type="text" id="m_ssqyzfldm" class="inputstyle" value=""></td>
		<td class="distd">所属企业主分类名称</td>
		<td class="detailtd"><input type="text" id="m_ssqyzflmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="m_hylbdm" class="inputstyle" value=""></td>
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="m_hylb" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">刷卡时间</td>
		<td class="detailtd"><input type="text" id="m_sksj" class="inputstyle" value=""></td>
		<td class="distd">上传时间</td>
		<td class="detailtd"><input type="text" id="m_scsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员ID</td>
		<td class="detailtd"><input type="text" id="m_ryid" class="inputstyle" value="0"></td>
		<td class="distd">从业人员编号</td>
		<td class="detailtd"><input type="text" id="m_cyrybh" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员类别代码</td>
		<td class="detailtd"><input type="text" id="m_cyrylbdm" class="inputstyle" value=""></td>
		<td class="distd">从业人员类别名称</td>
		<td class="detailtd"><input type="text" id="m_cyrylbmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" id="m_xm" class="inputstyle" value=""></td>
		<td class="distd">全名</td>
		<td class="detailtd"><input type="text" id="m_qm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">别名</td>
		<td class="detailtd"><input type="text" id="m_bm" class="inputstyle" value=""></td>
		<td class="distd">姓名拼音</td>
		<td class="detailtd"><input type="text" id="m_xmpy" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">国籍代码</td>
		<td class="detailtd"><input type="text" id="m_gjdm" class="inputstyle" value=""></td>
		<td class="distd">国籍</td>
		<td class="detailtd"><input type="text" id="m_gj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">民族代码</td>
		<td class="detailtd"><input type="text" id="m_mzdm" class="inputstyle" value=""></td>
		<td class="distd">民族</td>
		<td class="detailtd"><input type="text" id="m_minzu" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">性别代码</td>
		<td class="detailtd"><input type="text" id="m_xbdm" class="inputstyle" value=""></td>
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" id="m_xb" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">出生日期</td>
		<td class="detailtd"><input type="text" id="m_csrq" class="inputstyle" value=""></td>
		<td class="distd">婚姻状况代码</td>
		<td class="detailtd"><input type="text" id="m_hyzkdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">婚姻状况</td>
		<td class="detailtd"><input type="text" id="m_hyzk" class="inputstyle" value=""></td>
		<td class="distd">身高</td>
		<td class="detailtd"><input type="text" id="m_shengao" class="inputstyle" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">体重</td>
		<td class="detailtd"><input type="text" id="m_tizh" class="inputstyle" value="0"></td>
		<td class="distd">血型代码</td>
		<td class="detailtd"><input type="text" id="m_xxdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">血型</td>
		<td class="detailtd"><input type="text" id="m_xx" class="inputstyle" value=""></td>
		<td class="distd">户籍地行政区划</td>
		<td class="detailtd"><input type="text" id="m_hjdxzqh" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">户籍地行政区划代码</td>
		<td class="detailtd"><input type="text" id="m_hjdxzqhdm" class="inputstyle" value=""></td>
		<td class="distd">户籍地详址</td>
		<td class="detailtd"><input type="text" id="m_hjdxz" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">常用证件代码</td>
		<td class="detailtd"><input type="text" id="m_cyzjdm" class="inputstyle" value=""></td>
		<td class="distd">常用证件</td>
		<td class="detailtd"><input type="text" id="m_cyzj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">证件号码</td>
		<td class="detailtd"><input type="text" id="m_zjhm" class="inputstyle" value=""></td>
		<td class="distd">暂住证号码</td>
		<td class="detailtd"><input type="text" id="m_zzzhm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">暂住地址</td>
		<td class="detailtd"><input type="text" id="m_zzdz" class="inputstyle" value=""></td>
		<td class="distd">岗位编号</td>
		<td class="detailtd"><input type="text" id="m_gwbh" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">岗位名称</td>
		<td class="detailtd"><input type="text" id="m_gwmc" class="inputstyle" value=""></td>
		<td class="distd">岗位责任描述</td>
		<td class="detailtd"><input type="text" id="m_gwzrms" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">手机</td>
		<td class="detailtd"><input type="text" id="m_shouji" class="inputstyle" value=""></td>
		<td class="distd">联系电话</td>
		<td class="detailtd"><input type="text" id="m_lxdh" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">紧急联系人</td>
		<td class="detailtd"><input type="text" id="m_jjlxr" class="inputstyle" value=""></td>
		<td class="distd">紧急联系人电话</td>
		<td class="detailtd"><input type="text" id="m_jjlxrdh" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">工种代码</td>
		<td class="detailtd"><input type="text" id="m_gzdm" class="inputstyle" value=""></td>
		<td class="distd">工种</td>
		<td class="detailtd"><input type="text" id="m_gz" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">职务</td>
		<td class="detailtd"><input type="text" id="m_zhiwu" class="inputstyle" value=""></td>
		<td class="distd">入职日期</td>
		<td class="detailtd"><input type="text" id="m_rzrq" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">离职日期</td>
		<td class="detailtd"><input type="text" id="m_lzrq" class="inputstyle" value=""></td>
		<td class="distd">从业人员状态代码</td>
		<td class="detailtd"><input type="text" id="m_cyryztdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员状态</td>
		<td class="detailtd"><input type="text" id="m_cyryzt" class="inputstyle" value=""></td>
		<td class="distd">撤销人</td>
		<td class="detailtd"><input type="text" id="m_cxr" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">注销标志</td>
		<td class="detailtd"><input type="text" id="m_zxbz" class="inputstyle" value=""></td>
		<td class="distd">撤销时间</td>
		<td class="detailtd"><input type="text" id="m_cxsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入时间</td>
		<td class="detailtd"><input type="text" id="m_lrsj" class="inputstyle" value=""></td>
		<td class="distd">录入人</td>
		<td class="detailtd"><input type="text" id="m_lrr" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入单位编码</td>
		<td class="detailtd"><input type="text" id="m_lrdwbm" class="inputstyle" value=""></td>
		<td class="distd">录入单位名称</td>
		<td class="detailtd"><input type="text" id="m_lrdwmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">核查单位</td>
		<td class="detailtd"><input type="text" id="m_hcdw" class="inputstyle" value=""></td>
		<td class="distd">核查人</td>
		<td class="detailtd"><input type="text" id="m_hcr" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">核查时间</td>
		<td class="detailtd"><input type="text" id="m_hcsj" class="inputstyle" value=""></td>
		<td class="distd">注销原因</td>
		<td class="detailtd"><input type="text" id="m_zxyy" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">制卡状态</td>
		<td class="detailtd"><input type="text" id="m_zkzt" class="inputstyle" value=""></td>
		<td class="distd">保存时间</td>
		<td class="detailtd"><input type="text" id="m_bcsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">导出标识</td>
		<td class="detailtd"><input type="text" id="m_dcbs" class="inputstyle" value="0"></td>
		<td class="distd">备注</td>
		<td class="detailtd"><input type="text" id="m_bz" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">删除标志</td>
		<td class="detailtd"><input type="text" id="m_scbz" class="inputstyle" value="0"></td>
		<td class="distd">比对标志</td>
		<td class="detailtd"><input type="text" id="m_biduiflag" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">照片未通过原因</td>
		<td class="detailtd"><input type="text" id="m_zpwtgyy" class="inputstyle" value=""></td>
		<td class="distd">状态</td>
		<td class="detailtd"><input type="text" id="m_zt" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">英文姓</td>
		<td class="detailtd"><input type="text" id="m_ywx" class="inputstyle" value=""></td>
		<td class="distd">英文名</td>
		<td class="detailtd"><input type="text" id="m_ywm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">外国人就业许可证号</td>
		<td class="detailtd"><input type="text" id="m_wgrjyxkz" class="inputstyle" value=""></td>
		<td class="distd">签证种类代码</td>
		<td class="detailtd"><input type="text" id="m_qzzldm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">签证号码</td>
		<td class="detailtd"><input type="text" id="m_qzhm" class="inputstyle" value=""></td>
		<td class="distd">在华停留期至</td>
		<td class="detailtd"><input type="text" id="m_zatlq" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">签发机关</td>
		<td class="detailtd"><input type="text" id="m_qfjg" class="inputstyle" value=""></td>
		<td class="distd">入境日期</td>
		<td class="detailtd"><input type="text" id="m_rjrq" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">入境口岸</td>
		<td class="detailtd"><input type="text" id="m_rjka" class="inputstyle" value=""></td>
		<td class="distd">卡号</td>
		<td class="detailtd"><input type="text" id="m_kh" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">卡ID号</td>
		<td class="detailtd"><input type="text" id="m_ickh" class="inputstyle" value=""></td>
		<td class="distd">申领原因</td>
		<td class="detailtd"><input type="text" id="m_slyy" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">受理人</td>
		<td class="detailtd"><input type="text" id="m_slr" class="inputstyle" value=""></td>
		<td class="distd">受理时间</td>
		<td class="detailtd"><input type="text" id="m_slsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">有效期开始日期</td>
		<td class="detailtd"><input type="text" id="m_yxsksrq" class="inputstyle" value=""></td>
		<td class="distd">有效期截至日期</td>
		<td class="detailtd"><input type="text" id="m_yxqhzrq" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">IC卡采集时间</td>
		<td class="detailtd"><input type="text" id="m_ickcjsj" class="inputstyle" value=""></td>
		<td class="distd">IC卡采集人</td>
		<td class="detailtd"><input type="text" id="m_ickcjr" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">IC卡采集点编码</td>
		<td class="detailtd"><input type="text" id="m_ickcjdbm" class="inputstyle" value=""></td>
		<td class="distd">IC卡采集点名称</td>
		<td class="detailtd"><input type="text" id="m_ickcjdmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">接收时间</td>
		<td class="detailtd"><input type="text" id="m_jssj" class="inputstyle" value=""></td>
		<td class="distd">接收包名称</td>
		<td class="detailtd"><input type="text" id="m_jsbmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发放人</td>
		<td class="detailtd"><input type="text" id="m_ffr" class="inputstyle" value=""></td>
		<td class="distd">发放时间</td>
		<td class="detailtd"><input type="text" id="m_ffsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">领取人</td>
		<td class="detailtd"><input type="text" id="m_lqr" class="inputstyle" value=""></td>
		<td class="distd">领取时间</td>
		<td class="detailtd"><input type="text" id="m_lqsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">领取人证件类型</td>
		<td class="detailtd"><input type="text" id="m_lqrzjlx" class="inputstyle" value=""></td>
		<td class="distd">领取人证件号码</td>
		<td class="detailtd"><input type="text" id="m_lqrzjhm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">IC卡注销人</td>
		<td class="detailtd"><input type="text" id="m_ickzxr" class="inputstyle" value=""></td>
		<td class="distd">IC卡注销时间</td>
		<td class="detailtd"><input type="text" id="m_ickzxsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">IC卡注销原因</td>
		<td class="detailtd"><input type="text" id="m_ickzxyy" class="inputstyle" value=""></td>
		<td class="distd">年检人</td>
		<td class="detailtd"><input type="text" id="m_njr" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">年检时间</td>
		<td class="detailtd"><input type="text" id="m_njsj" class="inputstyle" value=""></td>
		<td class="distd">制卡状态标识</td>
		<td class="detailtd"><input type="text" id="m_zkztbs" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">是否确认</td>
		<td class="detailtd"><input type="text" id="m_sfqr" class="inputstyle" value=""></td>
		<td class="distd">印刷人</td>
		<td class="detailtd"><input type="text" id="m_ysr" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">印刷时间</td>
		<td class="detailtd"><input type="text" id="m_yssj" class="inputstyle" value=""></td>
		<td class="distd">电写入人</td>
		<td class="detailtd"><input type="text" id="m_dxrr" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">电写入时间</td>
		<td class="detailtd"><input type="text" id="m_dxrsj" class="inputstyle" value=""></td>
		<td class="distd">重印刷时间</td>
		<td class="detailtd"><input type="text" id="m_cyssj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">重印刷原因</td>
		<td class="detailtd"><input type="text" id="m_cysyy" class="inputstyle" value=""></td>
		<td class="distd">重电写入时间</td>
		<td class="detailtd"><input type="text" id="m_cdxrsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">重电写入原因</td>
		<td class="detailtd"><input type="text" id="m_cdxryy" class="inputstyle" value=""></td>
		<td class="distd">补换卡原因</td>
		<td class="detailtd"><input type="text" id="m_bhkyy" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">原卡是否收回</td>
		<td class="detailtd"><input type="text" id="m_yksfsh" class="inputstyle" value=""></td>
		<td class="distd">走台人员刷卡信息统计明细id</td>
		<td class="detailtd"><input type="text" id="m_ztryskxxtjmxid" class="inputstyle" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">刷卡ID</td>
		<td class="detailtd"><input type="text" id="m_skid3" class="inputstyle" value="0"></td>
		<td class="distd">统计日期</td>
		<td class="detailtd"><input type="text" id="m_tjrq" class="inputstyle" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
