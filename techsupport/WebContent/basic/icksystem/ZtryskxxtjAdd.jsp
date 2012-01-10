<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_sksj").attr("readonly","true");
		$("#a_sksj").datepicker();
		$("#a_scsj").attr("readonly","true");
		$("#a_scsj").datepicker();
		$("#a_csrq").attr("readonly","true");
		$("#a_csrq").datepicker();
		$("#a_rzrq").attr("readonly","true");
		$("#a_rzrq").datepicker();
		$("#a_lzrq").attr("readonly","true");
		$("#a_lzrq").datepicker();
		$("#a_cxsj").attr("readonly","true");
		$("#a_cxsj").datepicker();
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
		$("#a_slsj").attr("readonly","true");
		$("#a_slsj").datepicker();
		$("#a_yxsksrq").attr("readonly","true");
		$("#a_yxsksrq").datepicker();
		$("#a_yxqhzrq").attr("readonly","true");
		$("#a_yxqhzrq").datepicker();
		$("#a_ickcjsj").attr("readonly","true");
		$("#a_ickcjsj").datepicker();
		$("#a_jssj").attr("readonly","true");
		$("#a_jssj").datepicker();
		$("#a_ffsj").attr("readonly","true");
		$("#a_ffsj").datepicker();
		$("#a_lqsj").attr("readonly","true");
		$("#a_lqsj").datepicker();
		$("#a_ickzxsj").attr("readonly","true");
		$("#a_ickzxsj").datepicker();
		$("#a_njsj").attr("readonly","true");
		$("#a_njsj").datepicker();
		$("#a_yssj").attr("readonly","true");
		$("#a_yssj").datepicker();
		$("#a_dxrsj").attr("readonly","true");
		$("#a_dxrsj").datepicker();
		$("#a_cyssj").attr("readonly","true");
		$("#a_cyssj").datepicker();
		$("#a_cdxrsj").attr("readonly","true");
		$("#a_cdxrsj").datepicker();
		$("#a_tjrq").attr("readonly","true");
		$("#a_tjrq").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_qyryskxxtjmxid","Integer",-9999999999,9999999999,null,0,"企业人员刷卡信息统计明细ID"))
			return false;
		if (!checkControlValue("a_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("a_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("a_qyzflbm","String",1,30,null,0,"企业主分类编码"))
			return false;
		if (!checkControlValue("a_qyzflmc","String",1,300,null,0,"企业主分类名称"))
			return false;
		if (!checkControlValue("a_qyfflbm","String",1,200,null,0,"企业副分类编码"))
			return false;
		if (!checkControlValue("a_qyfflmc","String",1,300,null,0,"企业副分类名称"))
			return false;
		if (!checkControlValue("a_gxdwbm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("a_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("a_ssqyid","Integer",-9999999999,9999999999,null,0,"所属企业ID"))
			return false;
		if (!checkControlValue("a_ssqybm","String",1,20,null,0,"所属企业编码"))
			return false;
		if (!checkControlValue("a_ssqymc","String",1,120,null,0,"所属企业名称"))
			return false;
		if (!checkControlValue("a_ssqygxdwdm","String",1,20,null,0,"所属企业管辖单位代码"))
			return false;
		if (!checkControlValue("a_ssqygxdwmc","String",1,60,null,0,"所属企业管辖单位名称"))
			return false;
		if (!checkControlValue("a_ssqyzfldm","String",1,300,null,0,"所属企业主分类代码"))
			return false;
		if (!checkControlValue("a_ssqyzflmc","String",1,300,null,0,"所属企业主分类名称"))
			return false;
		if (!checkControlValue("a_hylbdm","String",1,3,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("a_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("a_sksj","Date",null,null,null,0,"刷卡时间"))
			return false;
		if (!checkControlValue("a_scsj","Date",null,null,null,0,"上传时间"))
			return false;
		if (!checkControlValue("a_ryid","Integer",-9999999999,9999999999,null,0,"从业人员ID"))
			return false;
		if (!checkControlValue("a_cyrybh","String",1,30,null,0,"从业人员编号"))
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
		if (!checkControlValue("a_xxdm","String",1,2,null,0,"血型代码"))
			return false;
		if (!checkControlValue("a_xx","String",1,10,null,0,"血型"))
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
		if (!checkControlValue("a_gzdm","String",1,4,null,0,"工种代码"))
			return false;
		if (!checkControlValue("a_gz","String",1,60,null,0,"工种"))
			return false;
		if (!checkControlValue("a_zhiwu","String",1,20,null,0,"职务"))
			return false;
		if (!checkControlValue("a_rzrq","Date",null,null,null,0,"入职日期"))
			return false;
		if (!checkControlValue("a_lzrq","Date",null,null,null,0,"离职日期"))
			return false;
		if (!checkControlValue("a_cyryztdm","String",1,2,null,0,"从业人员状态代码"))
			return false;
		if (!checkControlValue("a_cyryzt","String",1,4,null,0,"从业人员状态"))
			return false;
		if (!checkControlValue("a_cxr","String",1,30,null,0,"撤销人"))
			return false;
		if (!checkControlValue("a_zxbz","String",1,2,null,0,"注销标志"))
			return false;
		if (!checkControlValue("a_cxsj","Date",null,null,null,0,"撤销时间"))
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
		if (!checkControlValue("a_zt","String",1,2,null,0,"状态"))
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
		if (!checkControlValue("a_kh","String",1,20,null,0,"卡号"))
			return false;
		if (!checkControlValue("a_ickh","String",1,100,null,0,"卡ID号"))
			return false;
		if (!checkControlValue("a_slyy","String",1,200,null,0,"申领原因"))
			return false;
		if (!checkControlValue("a_slr","String",1,30,null,0,"受理人"))
			return false;
		if (!checkControlValue("a_slsj","Date",null,null,null,0,"受理时间"))
			return false;
		if (!checkControlValue("a_yxsksrq","Date",null,null,null,0,"有效期开始日期"))
			return false;
		if (!checkControlValue("a_yxqhzrq","Date",null,null,null,0,"有效期截至日期"))
			return false;
		if (!checkControlValue("a_ickcjsj","Date",null,null,null,0,"IC卡采集时间"))
			return false;
		if (!checkControlValue("a_ickcjr","String",1,30,null,0,"IC卡采集人"))
			return false;
		if (!checkControlValue("a_ickcjdbm","String",1,20,null,0,"IC卡采集点编码"))
			return false;
		if (!checkControlValue("a_ickcjdmc","String",1,100,null,0,"IC卡采集点名称"))
			return false;
		if (!checkControlValue("a_jssj","Date",null,null,null,0,"接收时间"))
			return false;
		if (!checkControlValue("a_jsbmc","String",1,20,null,0,"接收包名称"))
			return false;
		if (!checkControlValue("a_ffr","String",1,30,null,0,"发放人"))
			return false;
		if (!checkControlValue("a_ffsj","Date",null,null,null,0,"发放时间"))
			return false;
		if (!checkControlValue("a_lqr","String",1,30,null,0,"领取人"))
			return false;
		if (!checkControlValue("a_lqsj","Date",null,null,null,0,"领取时间"))
			return false;
		if (!checkControlValue("a_lqrzjlx","String",1,40,null,0,"领取人证件类型"))
			return false;
		if (!checkControlValue("a_lqrzjhm","String",1,20,null,0,"领取人证件号码"))
			return false;
		if (!checkControlValue("a_ickzxr","String",1,30,null,0,"IC卡注销人"))
			return false;
		if (!checkControlValue("a_ickzxsj","Date",null,null,null,0,"IC卡注销时间"))
			return false;
		if (!checkControlValue("a_ickzxyy","String",1,200,null,0,"IC卡注销原因"))
			return false;
		if (!checkControlValue("a_njr","String",1,30,null,0,"年检人"))
			return false;
		if (!checkControlValue("a_njsj","Date",null,null,null,0,"年检时间"))
			return false;
		if (!checkControlValue("a_zkztbs","String",1,2,null,0,"制卡状态标识"))
			return false;
		if (!checkControlValue("a_sfqr","String",1,1,null,0,"是否确认"))
			return false;
		if (!checkControlValue("a_ysr","String",1,100,null,0,"印刷人"))
			return false;
		if (!checkControlValue("a_yssj","Date",null,null,null,0,"印刷时间"))
			return false;
		if (!checkControlValue("a_dxrr","String",1,100,null,0,"电写入人"))
			return false;
		if (!checkControlValue("a_dxrsj","Date",null,null,null,0,"电写入时间"))
			return false;
		if (!checkControlValue("a_cyssj","Date",null,null,null,0,"重印刷时间"))
			return false;
		if (!checkControlValue("a_cysyy","String",1,200,null,0,"重印刷原因"))
			return false;
		if (!checkControlValue("a_cdxrsj","Date",null,null,null,0,"重电写入时间"))
			return false;
		if (!checkControlValue("a_cdxryy","String",1,200,null,0,"重电写入原因"))
			return false;
		if (!checkControlValue("a_bhkyy","String",1,200,null,0,"补换卡原因"))
			return false;
		if (!checkControlValue("a_yksfsh","String",1,1,null,0,"原卡是否收回"))
			return false;
		if (!checkControlValue("a_ztryskxxtjmxid","Integer",-9999999999,9999999999,null,0,"走台人员刷卡信息统计明细id"))
			return false;
		if (!checkControlValue("a_skid3","Integer",-9999999999,9999999999,null,0,"刷卡ID"))
			return false;
		if (!checkControlValue("a_tjrq","Date",null,null,null,0,"统计日期"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#ztryskxxtj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">企业人员刷卡信息统计明细ID</td>
		<td class="detailtd"><input type="text" id="a_qyryskxxtjmxid" class="inputstyle" value="0"></td>
		<td class="distd">企业编码</td>
		<td class="detailtd"><input type="text" id="a_qybm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业名称</td>
		<td class="detailtd"><input type="text" id="a_qymc" class="inputstyle" value=""></td>
		<td class="distd">企业主分类编码</td>
		<td class="detailtd"><input type="text" id="a_qyzflbm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业主分类名称</td>
		<td class="detailtd"><input type="text" id="a_qyzflmc" class="inputstyle" value=""></td>
		<td class="distd">企业副分类编码</td>
		<td class="detailtd"><input type="text" id="a_qyfflbm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业副分类名称</td>
		<td class="detailtd"><input type="text" id="a_qyfflmc" class="inputstyle" value=""></td>
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" id="a_gxdwbm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" id="a_gxdwmc" class="inputstyle" value=""></td>
		<td class="distd">所属企业ID</td>
		<td class="detailtd"><input type="text" id="a_ssqyid" class="inputstyle" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">所属企业编码</td>
		<td class="detailtd"><input type="text" id="a_ssqybm" class="inputstyle" value=""></td>
		<td class="distd">所属企业名称</td>
		<td class="detailtd"><input type="text" id="a_ssqymc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">所属企业管辖单位代码</td>
		<td class="detailtd"><input type="text" id="a_ssqygxdwdm" class="inputstyle" value=""></td>
		<td class="distd">所属企业管辖单位名称</td>
		<td class="detailtd"><input type="text" id="a_ssqygxdwmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">所属企业主分类代码</td>
		<td class="detailtd"><input type="text" id="a_ssqyzfldm" class="inputstyle" value=""></td>
		<td class="distd">所属企业主分类名称</td>
		<td class="detailtd"><input type="text" id="a_ssqyzflmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="a_hylbdm" class="inputstyle" value=""></td>
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="a_hylb" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">刷卡时间</td>
		<td class="detailtd"><input type="text" id="a_sksj" class="inputstyle" value=""></td>
		<td class="distd">上传时间</td>
		<td class="detailtd"><input type="text" id="a_scsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员ID</td>
		<td class="detailtd"><input type="text" id="a_ryid" class="inputstyle" value="0"></td>
		<td class="distd">从业人员编号</td>
		<td class="detailtd"><input type="text" id="a_cyrybh" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员类别代码</td>
		<td class="detailtd"><input type="text" id="a_cyrylbdm" class="inputstyle" value=""></td>
		<td class="distd">从业人员类别名称</td>
		<td class="detailtd"><input type="text" id="a_cyrylbmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" id="a_xm" class="inputstyle" value=""></td>
		<td class="distd">全名</td>
		<td class="detailtd"><input type="text" id="a_qm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">别名</td>
		<td class="detailtd"><input type="text" id="a_bm" class="inputstyle" value=""></td>
		<td class="distd">姓名拼音</td>
		<td class="detailtd"><input type="text" id="a_xmpy" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">国籍代码</td>
		<td class="detailtd"><input type="text" id="a_gjdm" class="inputstyle" value=""></td>
		<td class="distd">国籍</td>
		<td class="detailtd"><input type="text" id="a_gj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">民族代码</td>
		<td class="detailtd"><input type="text" id="a_mzdm" class="inputstyle" value=""></td>
		<td class="distd">民族</td>
		<td class="detailtd"><input type="text" id="a_minzu" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">性别代码</td>
		<td class="detailtd"><input type="text" id="a_xbdm" class="inputstyle" value=""></td>
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" id="a_xb" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">出生日期</td>
		<td class="detailtd"><input type="text" id="a_csrq" class="inputstyle" value=""></td>
		<td class="distd">婚姻状况代码</td>
		<td class="detailtd"><input type="text" id="a_hyzkdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">婚姻状况</td>
		<td class="detailtd"><input type="text" id="a_hyzk" class="inputstyle" value=""></td>
		<td class="distd">身高</td>
		<td class="detailtd"><input type="text" id="a_shengao" class="inputstyle" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">体重</td>
		<td class="detailtd"><input type="text" id="a_tizh" class="inputstyle" value="0"></td>
		<td class="distd">血型代码</td>
		<td class="detailtd"><input type="text" id="a_xxdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">血型</td>
		<td class="detailtd"><input type="text" id="a_xx" class="inputstyle" value=""></td>
		<td class="distd">户籍地行政区划</td>
		<td class="detailtd"><input type="text" id="a_hjdxzqh" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">户籍地行政区划代码</td>
		<td class="detailtd"><input type="text" id="a_hjdxzqhdm" class="inputstyle" value=""></td>
		<td class="distd">户籍地详址</td>
		<td class="detailtd"><input type="text" id="a_hjdxz" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">常用证件代码</td>
		<td class="detailtd"><input type="text" id="a_cyzjdm" class="inputstyle" value=""></td>
		<td class="distd">常用证件</td>
		<td class="detailtd"><input type="text" id="a_cyzj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">证件号码</td>
		<td class="detailtd"><input type="text" id="a_zjhm" class="inputstyle" value=""></td>
		<td class="distd">暂住证号码</td>
		<td class="detailtd"><input type="text" id="a_zzzhm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">暂住地址</td>
		<td class="detailtd"><input type="text" id="a_zzdz" class="inputstyle" value=""></td>
		<td class="distd">岗位编号</td>
		<td class="detailtd"><input type="text" id="a_gwbh" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">岗位名称</td>
		<td class="detailtd"><input type="text" id="a_gwmc" class="inputstyle" value=""></td>
		<td class="distd">岗位责任描述</td>
		<td class="detailtd"><input type="text" id="a_gwzrms" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">手机</td>
		<td class="detailtd"><input type="text" id="a_shouji" class="inputstyle" value=""></td>
		<td class="distd">联系电话</td>
		<td class="detailtd"><input type="text" id="a_lxdh" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">紧急联系人</td>
		<td class="detailtd"><input type="text" id="a_jjlxr" class="inputstyle" value=""></td>
		<td class="distd">紧急联系人电话</td>
		<td class="detailtd"><input type="text" id="a_jjlxrdh" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">工种代码</td>
		<td class="detailtd"><input type="text" id="a_gzdm" class="inputstyle" value=""></td>
		<td class="distd">工种</td>
		<td class="detailtd"><input type="text" id="a_gz" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">职务</td>
		<td class="detailtd"><input type="text" id="a_zhiwu" class="inputstyle" value=""></td>
		<td class="distd">入职日期</td>
		<td class="detailtd"><input type="text" id="a_rzrq" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">离职日期</td>
		<td class="detailtd"><input type="text" id="a_lzrq" class="inputstyle" value=""></td>
		<td class="distd">从业人员状态代码</td>
		<td class="detailtd"><input type="text" id="a_cyryztdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">从业人员状态</td>
		<td class="detailtd"><input type="text" id="a_cyryzt" class="inputstyle" value=""></td>
		<td class="distd">撤销人</td>
		<td class="detailtd"><input type="text" id="a_cxr" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">注销标志</td>
		<td class="detailtd"><input type="text" id="a_zxbz" class="inputstyle" value=""></td>
		<td class="distd">撤销时间</td>
		<td class="detailtd"><input type="text" id="a_cxsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入时间</td>
		<td class="detailtd"><input type="text" id="a_lrsj" class="inputstyle" value=""></td>
		<td class="distd">录入人</td>
		<td class="detailtd"><input type="text" id="a_lrr" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">录入单位编码</td>
		<td class="detailtd"><input type="text" id="a_lrdwbm" class="inputstyle" value=""></td>
		<td class="distd">录入单位名称</td>
		<td class="detailtd"><input type="text" id="a_lrdwmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">核查单位</td>
		<td class="detailtd"><input type="text" id="a_hcdw" class="inputstyle" value=""></td>
		<td class="distd">核查人</td>
		<td class="detailtd"><input type="text" id="a_hcr" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">核查时间</td>
		<td class="detailtd"><input type="text" id="a_hcsj" class="inputstyle" value=""></td>
		<td class="distd">注销原因</td>
		<td class="detailtd"><input type="text" id="a_zxyy" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">制卡状态</td>
		<td class="detailtd"><input type="text" id="a_zkzt" class="inputstyle" value=""></td>
		<td class="distd">保存时间</td>
		<td class="detailtd"><input type="text" id="a_bcsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">导出标识</td>
		<td class="detailtd"><input type="text" id="a_dcbs" class="inputstyle" value="0"></td>
		<td class="distd">备注</td>
		<td class="detailtd"><input type="text" id="a_bz" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">删除标志</td>
		<td class="detailtd"><input type="text" id="a_scbz" class="inputstyle" value="0"></td>
		<td class="distd">比对标志</td>
		<td class="detailtd"><input type="text" id="a_biduiflag" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">照片未通过原因</td>
		<td class="detailtd"><input type="text" id="a_zpwtgyy" class="inputstyle" value=""></td>
		<td class="distd">状态</td>
		<td class="detailtd"><input type="text" id="a_zt" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">英文姓</td>
		<td class="detailtd"><input type="text" id="a_ywx" class="inputstyle" value=""></td>
		<td class="distd">英文名</td>
		<td class="detailtd"><input type="text" id="a_ywm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">外国人就业许可证号</td>
		<td class="detailtd"><input type="text" id="a_wgrjyxkz" class="inputstyle" value=""></td>
		<td class="distd">签证种类代码</td>
		<td class="detailtd"><input type="text" id="a_qzzldm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">签证号码</td>
		<td class="detailtd"><input type="text" id="a_qzhm" class="inputstyle" value=""></td>
		<td class="distd">在华停留期至</td>
		<td class="detailtd"><input type="text" id="a_zatlq" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">签发机关</td>
		<td class="detailtd"><input type="text" id="a_qfjg" class="inputstyle" value=""></td>
		<td class="distd">入境日期</td>
		<td class="detailtd"><input type="text" id="a_rjrq" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">入境口岸</td>
		<td class="detailtd"><input type="text" id="a_rjka" class="inputstyle" value=""></td>
		<td class="distd">卡号</td>
		<td class="detailtd"><input type="text" id="a_kh" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">卡ID号</td>
		<td class="detailtd"><input type="text" id="a_ickh" class="inputstyle" value=""></td>
		<td class="distd">申领原因</td>
		<td class="detailtd"><input type="text" id="a_slyy" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">受理人</td>
		<td class="detailtd"><input type="text" id="a_slr" class="inputstyle" value=""></td>
		<td class="distd">受理时间</td>
		<td class="detailtd"><input type="text" id="a_slsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">有效期开始日期</td>
		<td class="detailtd"><input type="text" id="a_yxsksrq" class="inputstyle" value=""></td>
		<td class="distd">有效期截至日期</td>
		<td class="detailtd"><input type="text" id="a_yxqhzrq" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">IC卡采集时间</td>
		<td class="detailtd"><input type="text" id="a_ickcjsj" class="inputstyle" value=""></td>
		<td class="distd">IC卡采集人</td>
		<td class="detailtd"><input type="text" id="a_ickcjr" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">IC卡采集点编码</td>
		<td class="detailtd"><input type="text" id="a_ickcjdbm" class="inputstyle" value=""></td>
		<td class="distd">IC卡采集点名称</td>
		<td class="detailtd"><input type="text" id="a_ickcjdmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">接收时间</td>
		<td class="detailtd"><input type="text" id="a_jssj" class="inputstyle" value=""></td>
		<td class="distd">接收包名称</td>
		<td class="detailtd"><input type="text" id="a_jsbmc" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发放人</td>
		<td class="detailtd"><input type="text" id="a_ffr" class="inputstyle" value=""></td>
		<td class="distd">发放时间</td>
		<td class="detailtd"><input type="text" id="a_ffsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">领取人</td>
		<td class="detailtd"><input type="text" id="a_lqr" class="inputstyle" value=""></td>
		<td class="distd">领取时间</td>
		<td class="detailtd"><input type="text" id="a_lqsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">领取人证件类型</td>
		<td class="detailtd"><input type="text" id="a_lqrzjlx" class="inputstyle" value=""></td>
		<td class="distd">领取人证件号码</td>
		<td class="detailtd"><input type="text" id="a_lqrzjhm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">IC卡注销人</td>
		<td class="detailtd"><input type="text" id="a_ickzxr" class="inputstyle" value=""></td>
		<td class="distd">IC卡注销时间</td>
		<td class="detailtd"><input type="text" id="a_ickzxsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">IC卡注销原因</td>
		<td class="detailtd"><input type="text" id="a_ickzxyy" class="inputstyle" value=""></td>
		<td class="distd">年检人</td>
		<td class="detailtd"><input type="text" id="a_njr" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">年检时间</td>
		<td class="detailtd"><input type="text" id="a_njsj" class="inputstyle" value=""></td>
		<td class="distd">制卡状态标识</td>
		<td class="detailtd"><input type="text" id="a_zkztbs" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">是否确认</td>
		<td class="detailtd"><input type="text" id="a_sfqr" class="inputstyle" value=""></td>
		<td class="distd">印刷人</td>
		<td class="detailtd"><input type="text" id="a_ysr" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">印刷时间</td>
		<td class="detailtd"><input type="text" id="a_yssj" class="inputstyle" value=""></td>
		<td class="distd">电写入人</td>
		<td class="detailtd"><input type="text" id="a_dxrr" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">电写入时间</td>
		<td class="detailtd"><input type="text" id="a_dxrsj" class="inputstyle" value=""></td>
		<td class="distd">重印刷时间</td>
		<td class="detailtd"><input type="text" id="a_cyssj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">重印刷原因</td>
		<td class="detailtd"><input type="text" id="a_cysyy" class="inputstyle" value=""></td>
		<td class="distd">重电写入时间</td>
		<td class="detailtd"><input type="text" id="a_cdxrsj" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">重电写入原因</td>
		<td class="detailtd"><input type="text" id="a_cdxryy" class="inputstyle" value=""></td>
		<td class="distd">补换卡原因</td>
		<td class="detailtd"><input type="text" id="a_bhkyy" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">原卡是否收回</td>
		<td class="detailtd"><input type="text" id="a_yksfsh" class="inputstyle" value=""></td>
		<td class="distd">走台人员刷卡信息统计明细id</td>
		<td class="detailtd"><input type="text" id="a_ztryskxxtjmxid" class="inputstyle" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">刷卡ID</td>
		<td class="detailtd"><input type="text" id="a_skid3" class="inputstyle" value="0"></td>
		<td class="distd">统计日期</td>
		<td class="detailtd"><input type="text" id="a_tjrq" class="inputstyle" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>