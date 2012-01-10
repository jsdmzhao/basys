<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="icksystem/querylist_ztryskxxtj.action";
	divnid="ZtryskxxtjData";
	tableid="ZtryskxxtjTable";
	addUrl="icksystem/insert_ztryskxxtj.action";
	addHtml="business/icksystem/ZtryskxxtjAdd.jsp";
	addWidth="800";
	delUrl="icksystem/delete_ztryskxxtj.action";
	delid="d_qyryskxxtjmxid";
	modHtml="business/icksystem/ZtryskxxtjModify.jsp";
	modUrl="icksystem/modify_ztryskxxtj.action";
	modWidth="800";
	detailHtml="business/icksystem/ZtryskxxtjDetail.jsp";
	detailid="ztryskxxtj_detail";
	detailUrl="icksystem/query_ztryskxxtj.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_sksj").attr("readonly","true");
		$("#p_sksj").datepicker();
		$("#p_scsj").attr("readonly","true");
		$("#p_scsj").datepicker();
		$("#p_csrq").attr("readonly","true");
		$("#p_csrq").datepicker();
		$("#p_rzrq").attr("readonly","true");
		$("#p_rzrq").datepicker();
		$("#p_lzrq").attr("readonly","true");
		$("#p_lzrq").datepicker();
		$("#p_cxsj").attr("readonly","true");
		$("#p_cxsj").datepicker();
		$("#p_lrsj").attr("readonly","true");
		$("#p_lrsj").datepicker();
		$("#p_hcsj").attr("readonly","true");
		$("#p_hcsj").datepicker();
		$("#p_bcsj").attr("readonly","true");
		$("#p_bcsj").datepicker();
		$("#p_zatlq").attr("readonly","true");
		$("#p_zatlq").datepicker();
		$("#p_rjrq").attr("readonly","true");
		$("#p_rjrq").datepicker();
		$("#p_slsj").attr("readonly","true");
		$("#p_slsj").datepicker();
		$("#p_yxsksrq").attr("readonly","true");
		$("#p_yxsksrq").datepicker();
		$("#p_yxqhzrq").attr("readonly","true");
		$("#p_yxqhzrq").datepicker();
		$("#p_ickcjsj").attr("readonly","true");
		$("#p_ickcjsj").datepicker();
		$("#p_jssj").attr("readonly","true");
		$("#p_jssj").datepicker();
		$("#p_ffsj").attr("readonly","true");
		$("#p_ffsj").datepicker();
		$("#p_lqsj").attr("readonly","true");
		$("#p_lqsj").datepicker();
		$("#p_ickzxsj").attr("readonly","true");
		$("#p_ickzxsj").datepicker();
		$("#p_njsj").attr("readonly","true");
		$("#p_njsj").datepicker();
		$("#p_yssj").attr("readonly","true");
		$("#p_yssj").datepicker();
		$("#p_dxrsj").attr("readonly","true");
		$("#p_dxrsj").datepicker();
		$("#p_cyssj").attr("readonly","true");
		$("#p_cyssj").datepicker();
		$("#p_cdxrsj").attr("readonly","true");
		$("#p_cdxrsj").datepicker();
		$("#p_tjrq").attr("readonly","true");
		$("#p_tjrq").datepicker();
	
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										height: 250,
                                       ingridPageParams:sXML,
										pageNumber: pageno,
										colWidths: ["0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%","0%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_qyryskxxtjmxid","Integer",-9999999999,9999999999,null,0,"企业人员刷卡信息统计明细ID"))
			return false;
		if (!checkControlValue("p_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("p_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("p_qyzflbm","String",1,30,null,0,"企业主分类编码"))
			return false;
		if (!checkControlValue("p_qyzflmc","String",1,300,null,0,"企业主分类名称"))
			return false;
		if (!checkControlValue("p_qyfflbm","String",1,200,null,0,"企业副分类编码"))
			return false;
		if (!checkControlValue("p_qyfflmc","String",1,300,null,0,"企业副分类名称"))
			return false;
		if (!checkControlValue("p_gxdwbm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("p_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("p_ssqyid","Integer",-9999999999,9999999999,null,0,"所属企业ID"))
			return false;
		if (!checkControlValue("p_ssqybm","String",1,20,null,0,"所属企业编码"))
			return false;
		if (!checkControlValue("p_ssqymc","String",1,120,null,0,"所属企业名称"))
			return false;
		if (!checkControlValue("p_ssqygxdwdm","String",1,20,null,0,"所属企业管辖单位代码"))
			return false;
		if (!checkControlValue("p_ssqygxdwmc","String",1,60,null,0,"所属企业管辖单位名称"))
			return false;
		if (!checkControlValue("p_ssqyzfldm","String",1,300,null,0,"所属企业主分类代码"))
			return false;
		if (!checkControlValue("p_ssqyzflmc","String",1,300,null,0,"所属企业主分类名称"))
			return false;
		if (!checkControlValue("p_hylbdm","String",1,3,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("p_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("p_sksj","Date",null,null,null,0,"刷卡时间"))
			return false;
		if (!checkControlValue("p_scsj","Date",null,null,null,0,"上传时间"))
			return false;
		if (!checkControlValue("p_ryid","Integer",-9999999999,9999999999,null,0,"从业人员ID"))
			return false;
		if (!checkControlValue("p_cyrybh","String",1,30,null,0,"从业人员编号"))
			return false;
		if (!checkControlValue("p_cyrylbdm","String",1,2,null,0,"从业人员类别代码"))
			return false;
		if (!checkControlValue("p_cyrylbmc","String",1,30,null,0,"从业人员类别名称"))
			return false;
		if (!checkControlValue("p_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_qm","String",1,100,null,0,"全名"))
			return false;
		if (!checkControlValue("p_bm","String",1,30,null,0,"别名"))
			return false;
		if (!checkControlValue("p_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("p_gjdm","String",1,40,null,0,"国籍代码"))
			return false;
		if (!checkControlValue("p_gj","String",1,100,null,0,"国籍"))
			return false;
		if (!checkControlValue("p_mzdm","String",1,40,null,0,"民族代码"))
			return false;
		if (!checkControlValue("p_minzu","String",1,20,null,0,"民族"))
			return false;
		if (!checkControlValue("p_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("p_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("p_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("p_hyzkdm","String",1,2,null,0,"婚姻状况代码"))
			return false;
		if (!checkControlValue("p_hyzk","String",1,4,null,0,"婚姻状况"))
			return false;
		if (!checkControlValue("p_shengao","Float",-999.99,999.99,2,0,"身高"))
			return false;
		if (!checkControlValue("p_tizh","Float",-999.99,999.99,2,0,"体重"))
			return false;
		if (!checkControlValue("p_xxdm","String",1,2,null,0,"血型代码"))
			return false;
		if (!checkControlValue("p_xx","String",1,10,null,0,"血型"))
			return false;
		if (!checkControlValue("p_hjdxzqh","String",1,200,null,0,"户籍地行政区划"))
			return false;
		if (!checkControlValue("p_hjdxzqhdm","String",1,10,null,0,"户籍地行政区划代码"))
			return false;
		if (!checkControlValue("p_hjdxz","String",1,200,null,0,"户籍地详址"))
			return false;
		if (!checkControlValue("p_cyzjdm","String",1,40,null,0,"常用证件代码"))
			return false;
		if (!checkControlValue("p_cyzj","String",1,100,null,0,"常用证件"))
			return false;
		if (!checkControlValue("p_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("p_zzzhm","String",1,20,null,0,"暂住证号码"))
			return false;
		if (!checkControlValue("p_zzdz","String",1,200,null,0,"暂住地址"))
			return false;
		if (!checkControlValue("p_gwbh","String",1,4,null,0,"岗位编号"))
			return false;
		if (!checkControlValue("p_gwmc","String",1,60,null,0,"岗位名称"))
			return false;
		if (!checkControlValue("p_gwzrms","String",1,2000,null,0,"岗位责任描述"))
			return false;
		if (!checkControlValue("p_shouji","String",1,20,null,0,"手机"))
			return false;
		if (!checkControlValue("p_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("p_jjlxr","String",1,30,null,0,"紧急联系人"))
			return false;
		if (!checkControlValue("p_jjlxrdh","String",1,20,null,0,"紧急联系人电话"))
			return false;
		if (!checkControlValue("p_gzdm","String",1,4,null,0,"工种代码"))
			return false;
		if (!checkControlValue("p_gz","String",1,60,null,0,"工种"))
			return false;
		if (!checkControlValue("p_zhiwu","String",1,20,null,0,"职务"))
			return false;
		if (!checkControlValue("p_rzrq","Date",null,null,null,0,"入职日期"))
			return false;
		if (!checkControlValue("p_lzrq","Date",null,null,null,0,"离职日期"))
			return false;
		if (!checkControlValue("p_cyryztdm","String",1,2,null,0,"从业人员状态代码"))
			return false;
		if (!checkControlValue("p_cyryzt","String",1,4,null,0,"从业人员状态"))
			return false;
		if (!checkControlValue("p_cxr","String",1,30,null,0,"撤销人"))
			return false;
		if (!checkControlValue("p_zxbz","String",1,2,null,0,"注销标志"))
			return false;
		if (!checkControlValue("p_cxsj","Date",null,null,null,0,"撤销时间"))
			return false;
		if (!checkControlValue("p_lrsj","Date",null,null,null,0,"录入时间"))
			return false;
		if (!checkControlValue("p_lrr","String",1,100,null,0,"录入人"))
			return false;
		if (!checkControlValue("p_lrdwbm","String",1,20,null,0,"录入单位编码"))
			return false;
		if (!checkControlValue("p_lrdwmc","String",1,60,null,0,"录入单位名称"))
			return false;
		if (!checkControlValue("p_hcdw","String",1,100,null,0,"核查单位"))
			return false;
		if (!checkControlValue("p_hcr","String",1,30,null,0,"核查人"))
			return false;
		if (!checkControlValue("p_hcsj","Date",null,null,null,0,"核查时间"))
			return false;
		if (!checkControlValue("p_zxyy","String",1,200,null,0,"注销原因"))
			return false;
		if (!checkControlValue("p_zkzt","String",1,4,null,0,"制卡状态"))
			return false;
		if (!checkControlValue("p_bcsj","Date",null,null,null,0,"保存时间"))
			return false;
		if (!checkControlValue("p_dcbs","Integer",-99,99,null,0,"导出标识"))
			return false;
		if (!checkControlValue("p_bz","String",1,2000,null,0,"备注"))
			return false;
		if (!checkControlValue("p_scbz","Integer",-99,99,null,0,"删除标志"))
			return false;
		if (!checkControlValue("p_biduiflag","String",1,1,null,0,"比对标志"))
			return false;
		if (!checkControlValue("p_zpwtgyy","String",1,2000,null,0,"照片未通过原因"))
			return false;
		if (!checkControlValue("p_zt","String",1,2,null,0,"状态"))
			return false;
		if (!checkControlValue("p_ywx","String",1,60,null,0,"英文姓"))
			return false;
		if (!checkControlValue("p_ywm","String",1,60,null,0,"英文名"))
			return false;
		if (!checkControlValue("p_wgrjyxkz","String",1,60,null,0,"外国人就业许可证号"))
			return false;
		if (!checkControlValue("p_qzzldm","String",1,40,null,0,"签证种类代码"))
			return false;
		if (!checkControlValue("p_qzhm","String",1,20,null,0,"签证号码"))
			return false;
		if (!checkControlValue("p_zatlq","Date",null,null,null,0,"在华停留期至"))
			return false;
		if (!checkControlValue("p_qfjg","String",1,120,null,0,"签发机关"))
			return false;
		if (!checkControlValue("p_rjrq","Date",null,null,null,0,"入境日期"))
			return false;
		if (!checkControlValue("p_rjka","String",1,60,null,0,"入境口岸"))
			return false;
		if (!checkControlValue("p_kh","String",1,20,null,0,"卡号"))
			return false;
		if (!checkControlValue("p_ickh","String",1,100,null,0,"卡ID号"))
			return false;
		if (!checkControlValue("p_slyy","String",1,200,null,0,"申领原因"))
			return false;
		if (!checkControlValue("p_slr","String",1,30,null,0,"受理人"))
			return false;
		if (!checkControlValue("p_slsj","Date",null,null,null,0,"受理时间"))
			return false;
		if (!checkControlValue("p_yxsksrq","Date",null,null,null,0,"有效期开始日期"))
			return false;
		if (!checkControlValue("p_yxqhzrq","Date",null,null,null,0,"有效期截至日期"))
			return false;
		if (!checkControlValue("p_ickcjsj","Date",null,null,null,0,"IC卡采集时间"))
			return false;
		if (!checkControlValue("p_ickcjr","String",1,30,null,0,"IC卡采集人"))
			return false;
		if (!checkControlValue("p_ickcjdbm","String",1,20,null,0,"IC卡采集点编码"))
			return false;
		if (!checkControlValue("p_ickcjdmc","String",1,100,null,0,"IC卡采集点名称"))
			return false;
		if (!checkControlValue("p_jssj","Date",null,null,null,0,"接收时间"))
			return false;
		if (!checkControlValue("p_jsbmc","String",1,20,null,0,"接收包名称"))
			return false;
		if (!checkControlValue("p_ffr","String",1,30,null,0,"发放人"))
			return false;
		if (!checkControlValue("p_ffsj","Date",null,null,null,0,"发放时间"))
			return false;
		if (!checkControlValue("p_lqr","String",1,30,null,0,"领取人"))
			return false;
		if (!checkControlValue("p_lqsj","Date",null,null,null,0,"领取时间"))
			return false;
		if (!checkControlValue("p_lqrzjlx","String",1,40,null,0,"领取人证件类型"))
			return false;
		if (!checkControlValue("p_lqrzjhm","String",1,20,null,0,"领取人证件号码"))
			return false;
		if (!checkControlValue("p_ickzxr","String",1,30,null,0,"IC卡注销人"))
			return false;
		if (!checkControlValue("p_ickzxsj","Date",null,null,null,0,"IC卡注销时间"))
			return false;
		if (!checkControlValue("p_ickzxyy","String",1,200,null,0,"IC卡注销原因"))
			return false;
		if (!checkControlValue("p_njr","String",1,30,null,0,"年检人"))
			return false;
		if (!checkControlValue("p_njsj","Date",null,null,null,0,"年检时间"))
			return false;
		if (!checkControlValue("p_zkztbs","String",1,2,null,0,"制卡状态标识"))
			return false;
		if (!checkControlValue("p_sfqr","String",1,1,null,0,"是否确认"))
			return false;
		if (!checkControlValue("p_ysr","String",1,100,null,0,"印刷人"))
			return false;
		if (!checkControlValue("p_yssj","Date",null,null,null,0,"印刷时间"))
			return false;
		if (!checkControlValue("p_dxrr","String",1,100,null,0,"电写入人"))
			return false;
		if (!checkControlValue("p_dxrsj","Date",null,null,null,0,"电写入时间"))
			return false;
		if (!checkControlValue("p_cyssj","Date",null,null,null,0,"重印刷时间"))
			return false;
		if (!checkControlValue("p_cysyy","String",1,200,null,0,"重印刷原因"))
			return false;
		if (!checkControlValue("p_cdxrsj","Date",null,null,null,0,"重电写入时间"))
			return false;
		if (!checkControlValue("p_cdxryy","String",1,200,null,0,"重电写入原因"))
			return false;
		if (!checkControlValue("p_bhkyy","String",1,200,null,0,"补换卡原因"))
			return false;
		if (!checkControlValue("p_yksfsh","String",1,1,null,0,"原卡是否收回"))
			return false;
		if (!checkControlValue("p_ztryskxxtjmxid","Integer",-9999999999,9999999999,null,0,"走台人员刷卡信息统计明细id"))
			return false;
		if (!checkControlValue("p_skid3","Integer",-9999999999,9999999999,null,0,"刷卡ID"))
			return false;
		if (!checkControlValue("p_tjrq","Date",null,null,null,0,"统计日期"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_qyryskxxtjmxid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">企业人员刷卡信息统计明细ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyryskxxtjmxid" class="inputstyle" value="0"></td>
					<td width="10%" class="pagedistd">企业编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qybm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">企业名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qymc" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">企业主分类编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyzflbm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">企业主分类名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyzflmc" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">企业副分类编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyfflbm" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">企业副分类名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyfflmc" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">管辖单位代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gxdwbm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">管辖单位名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gxdwmc" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">所属企业ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ssqyid" class="inputstyle" value="0"></td>
					<td width="10%" class="pagedistd">所属企业编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ssqybm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">所属企业名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ssqymc" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">所属企业管辖单位代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ssqygxdwdm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">所属企业管辖单位名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ssqygxdwmc" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">所属企业主分类代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ssqyzfldm" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">所属企业主分类名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ssqyzflmc" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">行业类别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hylbdm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">行业类别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hylb" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">刷卡时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sksj" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">上传时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_scsj" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">从业人员ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ryid" class="inputstyle" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">从业人员编号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyrybh" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">从业人员类别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyrylbdm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">从业人员类别名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyrylbmc" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">姓名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">全名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">别名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bm" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">姓名拼音</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xmpy" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">国籍代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gjdm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">国籍</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gj" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">民族代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_mzdm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">民族</td>
					<td width="23%" class="pagetd"><input type="text" id="p_minzu" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">性别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xbdm" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">性别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xb" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">出生日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_csrq" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">婚姻状况代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hyzkdm" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">婚姻状况</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hyzk" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">身高</td>
					<td width="23%" class="pagetd"><input type="text" id="p_shengao" class="inputstyle" value="0"></td>
					<td width="10%" class="pagedistd">体重</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tizh" class="inputstyle" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">血型代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xxdm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">血型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xx" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">户籍地行政区划</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hjdxzqh" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">户籍地行政区划代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hjdxzqhdm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">户籍地详址</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hjdxz" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">常用证件代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyzjdm" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">常用证件</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyzj" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">证件号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zjhm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">暂住证号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zzzhm" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">暂住地址</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zzdz" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">岗位编号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gwbh" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">岗位名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gwmc" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">岗位责任描述</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gwzrms" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">手机</td>
					<td width="23%" class="pagetd"><input type="text" id="p_shouji" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">联系电话</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lxdh" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">紧急联系人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jjlxr" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">紧急联系人电话</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jjlxrdh" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">工种代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gzdm" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">工种</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gz" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">职务</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zhiwu" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">入职日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_rzrq" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">离职日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lzrq" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">从业人员状态代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyryztdm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">从业人员状态</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyryzt" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">撤销人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cxr" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">注销标志</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zxbz" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">撤销时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cxsj" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">录入时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrsj" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">录入人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrr" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">录入单位编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrdwbm" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">录入单位名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrdwmc" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">核查单位</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hcdw" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">核查人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hcr" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">核查时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hcsj" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">注销原因</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zxyy" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">制卡状态</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zkzt" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">保存时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bcsj" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">导出标识</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dcbs" class="inputstyle" value="0"></td>
					<td width="10%" class="pagedistd">备注</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bz" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">删除标志</td>
					<td width="23%" class="pagetd"><input type="text" id="p_scbz" class="inputstyle" value="0"></td>
					<td width="10%" class="pagedistd">比对标志</td>
					<td width="23%" class="pagetd"><input type="text" id="p_biduiflag" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">照片未通过原因</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zpwtgyy" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">状态</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zt" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">英文姓</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ywx" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">英文名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ywm" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">外国人就业许可证号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_wgrjyxkz" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">签证种类代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qzzldm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">签证号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qzhm" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">在华停留期至</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zatlq" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">签发机关</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qfjg" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">入境日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_rjrq" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">入境口岸</td>
					<td width="23%" class="pagetd"><input type="text" id="p_rjka" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">卡号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_kh" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">卡ID号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ickh" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">申领原因</td>
					<td width="23%" class="pagetd"><input type="text" id="p_slyy" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">受理人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_slr" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">受理时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_slsj" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">有效期开始日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_yxsksrq" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">有效期截至日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_yxqhzrq" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">IC卡采集时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ickcjsj" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">IC卡采集人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ickcjr" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">IC卡采集点编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ickcjdbm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">IC卡采集点名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ickcjdmc" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">接收时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jssj" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">接收包名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jsbmc" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">发放人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ffr" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">发放时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ffsj" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">领取人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lqr" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">领取时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lqsj" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">领取人证件类型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lqrzjlx" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">领取人证件号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lqrzjhm" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">IC卡注销人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ickzxr" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">IC卡注销时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ickzxsj" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">IC卡注销原因</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ickzxyy" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">年检人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_njr" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">年检时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_njsj" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">制卡状态标识</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zkztbs" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">是否确认</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sfqr" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">印刷人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ysr" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">印刷时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_yssj" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">电写入人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dxrr" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">电写入时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dxrsj" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">重印刷时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyssj" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">重印刷原因</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cysyy" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">重电写入时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cdxrsj" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">重电写入原因</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cdxryy" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">补换卡原因</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bhkyy" class="inputstyle" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">原卡是否收回</td>
					<td width="23%" class="pagetd"><input type="text" id="p_yksfsh" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">走台人员刷卡信息统计明细id</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ztryskxxtjmxid" class="inputstyle" value="0"></td>
					<td width="10%" class="pagedistd">刷卡ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_skid3" class="inputstyle" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">统计日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tjrq" class="inputstyle" value=""></td>
				</tr>
    		<tr>
    		  <td colspan="6">
    		  	<table  border="0" align="right"  cellpadding="2"  cellspacing="0">
    		    	<tr>
    		    	  <td width="50%" ><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
    		    	  <td width="50%" ><a href="#" class="addbutton"  onclick='setAddPage()'>添加</a></td>
    		    	</tr>
    		  	</table>
    		  </td>
    		</tr>
    	</table>
    </td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
	</tr>
</table>
<div id="ztryskxxtj_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="ZtryskxxtjData" style="width:100%;">
	<table id="ZtryskxxtjTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_qybm">企业编码</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_qyzflbm">企业主分类编码</th>
	     	<th name="l_qyzflmc">企业主分类名称</th>
	     	<th name="l_qyfflbm">企业副分类编码</th>
	     	<th name="l_qyfflmc">企业副分类名称</th>
	     	<th name="l_gxdwbm">管辖单位代码</th>
	     	<th name="l_gxdwmc">管辖单位名称</th>
	     	<th name="l_ssqyid">所属企业ID</th>
	     	<th name="l_ssqybm">所属企业编码</th>
	     	<th name="l_ssqymc">所属企业名称</th>
	     	<th name="l_ssqygxdwdm">所属企业管辖单位代码</th>
	     	<th name="l_ssqygxdwmc">所属企业管辖单位名称</th>
	     	<th name="l_ssqyzfldm">所属企业主分类代码</th>
	     	<th name="l_ssqyzflmc">所属企业主分类名称</th>
	     	<th name="l_hylbdm">行业类别代码</th>
	     	<th name="l_hylb">行业类别</th>
	     	<th name="l_sksj">刷卡时间</th>
	     	<th name="l_scsj">上传时间</th>
	     	<th name="l_ryid">从业人员ID</th>
	     	<th name="l_cyrybh">从业人员编号</th>
	     	<th name="l_cyrylbdm">从业人员类别代码</th>
	     	<th name="l_cyrylbmc">从业人员类别名称</th>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_qm">全名</th>
	     	<th name="l_bm">别名</th>
	     	<th name="l_xmpy">姓名拼音</th>
	     	<th name="l_gjdm">国籍代码</th>
	     	<th name="l_gj">国籍</th>
	     	<th name="l_mzdm">民族代码</th>
	     	<th name="l_minzu">民族</th>
	     	<th name="l_xbdm">性别代码</th>
	     	<th name="l_xb">性别</th>
	     	<th name="l_csrq">出生日期</th>
	     	<th name="l_hyzkdm">婚姻状况代码</th>
	     	<th name="l_hyzk">婚姻状况</th>
	     	<th name="l_shengao">身高</th>
	     	<th name="l_tizh">体重</th>
	     	<th name="l_xxdm">血型代码</th>
	     	<th name="l_xx">血型</th>
	     	<th name="l_hjdxzqh">户籍地行政区划</th>
	     	<th name="l_hjdxzqhdm">户籍地行政区划代码</th>
	     	<th name="l_hjdxz">户籍地详址</th>
	     	<th name="l_cyzjdm">常用证件代码</th>
	     	<th name="l_cyzj">常用证件</th>
	     	<th name="l_zjhm">证件号码</th>
	     	<th name="l_zzzhm">暂住证号码</th>
	     	<th name="l_zzdz">暂住地址</th>
	     	<th name="l_gwbh">岗位编号</th>
	     	<th name="l_gwmc">岗位名称</th>
	     	<th name="l_gwzrms">岗位责任描述</th>
	     	<th name="l_shouji">手机</th>
	     	<th name="l_lxdh">联系电话</th>
	     	<th name="l_jjlxr">紧急联系人</th>
	     	<th name="l_jjlxrdh">紧急联系人电话</th>
	     	<th name="l_gzdm">工种代码</th>
	     	<th name="l_gz">工种</th>
	     	<th name="l_zhiwu">职务</th>
	     	<th name="l_rzrq">入职日期</th>
	     	<th name="l_lzrq">离职日期</th>
	     	<th name="l_cyryztdm">从业人员状态代码</th>
	     	<th name="l_cyryzt">从业人员状态</th>
	     	<th name="l_cxr">撤销人</th>
	     	<th name="l_zxbz">注销标志</th>
	     	<th name="l_cxsj">撤销时间</th>
	     	<th name="l_lrsj">录入时间</th>
	     	<th name="l_lrr">录入人</th>
	     	<th name="l_lrdwbm">录入单位编码</th>
	     	<th name="l_lrdwmc">录入单位名称</th>
	     	<th name="l_hcdw">核查单位</th>
	     	<th name="l_hcr">核查人</th>
	     	<th name="l_hcsj">核查时间</th>
	     	<th name="l_zxyy">注销原因</th>
	     	<th name="l_zkzt">制卡状态</th>
	     	<th name="l_bcsj">保存时间</th>
	     	<th name="l_dcbs">导出标识</th>
	     	<th name="l_bz">备注</th>
	     	<th name="l_scbz">删除标志</th>
	     	<th name="l_biduiflag">比对标志</th>
	     	<th name="l_zpwtgyy">照片未通过原因</th>
	     	<th name="l_zt">状态</th>
	     	<th name="l_ywx">英文姓</th>
	     	<th name="l_ywm">英文名</th>
	     	<th name="l_wgrjyxkz">外国人就业许可证号</th>
	     	<th name="l_qzzldm">签证种类代码</th>
	     	<th name="l_qzhm">签证号码</th>
	     	<th name="l_zatlq">在华停留期至</th>
	     	<th name="l_qfjg">签发机关</th>
	     	<th name="l_rjrq">入境日期</th>
	     	<th name="l_rjka">入境口岸</th>
	     	<th name="l_kh">卡号</th>
	     	<th name="l_ickh">卡ID号</th>
	     	<th name="l_slyy">申领原因</th>
	     	<th name="l_slr">受理人</th>
	     	<th name="l_slsj">受理时间</th>
	     	<th name="l_yxsksrq">有效期开始日期</th>
	     	<th name="l_yxqhzrq">有效期截至日期</th>
	     	<th name="l_ickcjsj">IC卡采集时间</th>
	     	<th name="l_ickcjr">IC卡采集人</th>
	     	<th name="l_ickcjdbm">IC卡采集点编码</th>
	     	<th name="l_ickcjdmc">IC卡采集点名称</th>
	     	<th name="l_jssj">接收时间</th>
	     	<th name="l_jsbmc">接收包名称</th>
	     	<th name="l_ffr">发放人</th>
	     	<th name="l_ffsj">发放时间</th>
	     	<th name="l_lqr">领取人</th>
	     	<th name="l_lqsj">领取时间</th>
	     	<th name="l_lqrzjlx">领取人证件类型</th>
	     	<th name="l_lqrzjhm">领取人证件号码</th>
	     	<th name="l_ickzxr">IC卡注销人</th>
	     	<th name="l_ickzxsj">IC卡注销时间</th>
	     	<th name="l_ickzxyy">IC卡注销原因</th>
	     	<th name="l_njr">年检人</th>
	     	<th name="l_njsj">年检时间</th>
	     	<th name="l_zkztbs">制卡状态标识</th>
	     	<th name="l_sfqr">是否确认</th>
	     	<th name="l_ysr">印刷人</th>
	     	<th name="l_yssj">印刷时间</th>
	     	<th name="l_dxrr">电写入人</th>
	     	<th name="l_dxrsj">电写入时间</th>
	     	<th name="l_cyssj">重印刷时间</th>
	     	<th name="l_cysyy">重印刷原因</th>
	     	<th name="l_cdxrsj">重电写入时间</th>
	     	<th name="l_cdxryy">重电写入原因</th>
	     	<th name="l_bhkyy">补换卡原因</th>
	     	<th name="l_yksfsh">原卡是否收回</th>
	     	<th name="l_ztryskxxtjmxid">走台人员刷卡信息统计明细id</th>
	     	<th name="l_skid3">刷卡ID</th>
	     	<th name="l_tjrq">统计日期</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>