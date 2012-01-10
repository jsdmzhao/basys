<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_qyryxx_lsxx.action";
	divnid="Qyryxx_lsxxData";
	tableid="Qyryxx_lsxxTable";
	addUrl="publicsystem/insert_qyryxx_lsxx.action";
	addHtml="business/publicsystem/Qyryxx_lsxxAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_qyryxx_lsxx.action";
	delid="d_rylsid";
	modHtml="business/publicsystem/Qyryxx_lsxxModify.jsp";
	modUrl="publicsystem/modify_qyryxx_lsxx.action";
	modWidth="800";
	detailHtml="business/publicsystem/Qyryxx_lsxxDetail.jsp";
	detailid="qyryxx_lsxx_detail";
	detailUrl="publicsystem/query_qyryxx_lsxx.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_csrq").attr("readonly","true");
		$("#p_csrq").datepicker();
		$("#p_rzrq").attr("readonly","true");
		$("#p_rzrq").datepicker();
		$("#p_zxsj").attr("readonly","true");
		$("#p_zxsj").datepicker();
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
	
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										height: 250,
										pageNumber: pageno,
										colWidths: ["1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_rylsid","Integer",-9999999999,9999999999,null,0,"人员历史ID"))
			return false;
		if (!checkControlValue("p_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("p_ryid","Integer",-9999999999,9999999999,null,0,"从业人员ID"))
			return false;
		if (!checkControlValue("p_hylbdm","String",1,2,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("p_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("p_cyrybh","String",1,20,null,0,"从业人员编号"))
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
		if (!checkControlValue("p_zhiwu","String",1,20,null,0,"职务"))
			return false;
		if (!checkControlValue("p_rzrq","Date",null,null,null,0,"入职日期"))
			return false;
		if (!checkControlValue("p_cyryztdm","String",1,2,null,0,"从业人员状态代码"))
			return false;
		if (!checkControlValue("p_cyryzt","String",1,4,null,0,"从业人员状态"))
			return false;
		if (!checkControlValue("p_zxr","String",1,30,null,0,"注销人"))
			return false;
		if (!checkControlValue("p_zxbz","String",1,2,null,0,"注销标志"))
			return false;
		if (!checkControlValue("p_zxsj","Date",null,null,null,0,"注销时间"))
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
		if (!checkControlValue("p_zt","String",1,10,null,0,"状态"))
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
		if (!checkControlValue("p_czlx","String",1,40,null,0,"操作类型"))
			return false;
		if (!checkControlValue("p_bgyy","String",1,2000,null,0,"变更原因"))
			return false;
		if (!checkControlValue("p_bglbdm","String",1,2,null,0,"变更类别代码"))
			return false;
		if (!checkControlValue("p_bglb","String",1,60,null,0,"变更类别"))
			return false;
		if (!checkControlValue("p_gzdm","String",1,4,null,0,"工种代码"))
			return false;
		if (!checkControlValue("p_gz","String",1,60,null,0,"工种"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_rylsid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">人员历史ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_rylsid" value="0"></td>
					<td width="10%" class="pagedistd">企业ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyid" value="0"></td>
					<td width="10%" class="pagedistd">从业人员ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ryid" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">行业类别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hylbdm" value=""></td>
					<td width="10%" class="pagedistd">行业类别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hylb" value=""></td>
					<td width="10%" class="pagedistd">从业人员编号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyrybh" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">从业人员类别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyrylbdm" value=""></td>
					<td width="10%" class="pagedistd">从业人员类别名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyrylbmc" value=""></td>
					<td width="10%" class="pagedistd">姓名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">全名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qm" value=""></td>
					<td width="10%" class="pagedistd">别名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bm" value=""></td>
					<td width="10%" class="pagedistd">姓名拼音</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xmpy" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">国籍代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gjdm" value=""></td>
					<td width="10%" class="pagedistd">国籍</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gj" value=""></td>
					<td width="10%" class="pagedistd">民族代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_mzdm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">民族</td>
					<td width="23%" class="pagetd"><input type="text" id="p_minzu" value=""></td>
					<td width="10%" class="pagedistd">性别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xbdm" value=""></td>
					<td width="10%" class="pagedistd">性别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xb" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">出生日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_csrq" value=""></td>
					<td width="10%" class="pagedistd">婚姻状况代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hyzkdm" value=""></td>
					<td width="10%" class="pagedistd">婚姻状况</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hyzk" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">身高</td>
					<td width="23%" class="pagetd"><input type="text" id="p_shengao" value="0"></td>
					<td width="10%" class="pagedistd">体重</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tizh" value="0"></td>
					<td width="10%" class="pagedistd">户籍地行政区划</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hjdxzqh" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">户籍地行政区划代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hjdxzqhdm" value=""></td>
					<td width="10%" class="pagedistd">户籍地详址</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hjdxz" value=""></td>
					<td width="10%" class="pagedistd">常用证件代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyzjdm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">常用证件</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyzj" value=""></td>
					<td width="10%" class="pagedistd">证件号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zjhm" value=""></td>
					<td width="10%" class="pagedistd">暂住证号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zzzhm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">暂住地址</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zzdz" value=""></td>
					<td width="10%" class="pagedistd">岗位编号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gwbh" value=""></td>
					<td width="10%" class="pagedistd">岗位名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gwmc" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">岗位责任描述</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gwzrms" value=""></td>
					<td width="10%" class="pagedistd">手机</td>
					<td width="23%" class="pagetd"><input type="text" id="p_shouji" value=""></td>
					<td width="10%" class="pagedistd">联系电话</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lxdh" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">紧急联系人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jjlxr" value=""></td>
					<td width="10%" class="pagedistd">紧急联系人电话</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jjlxrdh" value=""></td>
					<td width="10%" class="pagedistd">职务</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zhiwu" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">入职日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_rzrq" value=""></td>
					<td width="10%" class="pagedistd">从业人员状态代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyryztdm" value=""></td>
					<td width="10%" class="pagedistd">从业人员状态</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyryzt" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">注销人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zxr" value=""></td>
					<td width="10%" class="pagedistd">注销标志</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zxbz" value=""></td>
					<td width="10%" class="pagedistd">注销时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zxsj" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">录入时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrsj" value=""></td>
					<td width="10%" class="pagedistd">录入人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrr" value=""></td>
					<td width="10%" class="pagedistd">录入单位编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrdwbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">录入单位名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrdwmc" value=""></td>
					<td width="10%" class="pagedistd">核查单位</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hcdw" value=""></td>
					<td width="10%" class="pagedistd">核查人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hcr" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">核查时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hcsj" value=""></td>
					<td width="10%" class="pagedistd">注销原因</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zxyy" value=""></td>
					<td width="10%" class="pagedistd">制卡状态</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zkzt" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">保存时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bcsj" value=""></td>
					<td width="10%" class="pagedistd">导出标识</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dcbs" value="0"></td>
					<td width="10%" class="pagedistd">备注</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bz" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">删除标志</td>
					<td width="23%" class="pagetd"><input type="text" id="p_scbz" value="0"></td>
					<td width="10%" class="pagedistd">比对标志</td>
					<td width="23%" class="pagetd"><input type="text" id="p_biduiflag" value=""></td>
					<td width="10%" class="pagedistd">照片未通过原因</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zpwtgyy" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">状态</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zt" value=""></td>
					<td width="10%" class="pagedistd">英文姓</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ywx" value=""></td>
					<td width="10%" class="pagedistd">英文名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ywm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">外国人就业许可证号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_wgrjyxkz" value=""></td>
					<td width="10%" class="pagedistd">签证种类代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qzzldm" value=""></td>
					<td width="10%" class="pagedistd">签证号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qzhm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">在华停留期至</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zatlq" value=""></td>
					<td width="10%" class="pagedistd">签发机关</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qfjg" value=""></td>
					<td width="10%" class="pagedistd">入境日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_rjrq" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">入境口岸</td>
					<td width="23%" class="pagetd"><input type="text" id="p_rjka" value=""></td>
					<td width="10%" class="pagedistd">操作类型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_czlx" value=""></td>
					<td width="10%" class="pagedistd">变更原因</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bgyy" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">变更类别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bglbdm" value=""></td>
					<td width="10%" class="pagedistd">变更类别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bglb" value=""></td>
					<td width="10%" class="pagedistd">工种代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gzdm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">工种</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gz" value=""></td>
				</tr>
    		<tr>
    		  <td colspan="6">
    		  	<table  border="0" align="right"  cellpadding="2"  cellspacing="0">
    		    	<tr>
    		    	  <td width="50%" ><a href="#" class="searchbutton" id="querys" onclick="setPageList(1);">查询</a></td>
    		    	  <td width="50%" ><a href="#" class="addbutton" onclick='setAddPage()'>添加</a></td>
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
<div id="qyryxx_lsxx_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="Qyryxx_lsxxData" style="width:100%;">
	<table id="Qyryxx_lsxxTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_qyid">企业ID</th>
	     	<th name="l_ryid">从业人员ID</th>
	     	<th name="l_hylbdm">行业类别代码</th>
	     	<th name="l_hylb">行业类别</th>
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
	     	<th name="l_zhiwu">职务</th>
	     	<th name="l_rzrq">入职日期</th>
	     	<th name="l_cyryztdm">从业人员状态代码</th>
	     	<th name="l_cyryzt">从业人员状态</th>
	     	<th name="l_zxr">注销人</th>
	     	<th name="l_zxbz">注销标志</th>
	     	<th name="l_zxsj">注销时间</th>
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
	     	<th name="l_czlx">操作类型</th>
	     	<th name="l_bgyy">变更原因</th>
	     	<th name="l_bglbdm">变更类别代码</th>
	     	<th name="l_bglb">变更类别</th>
	     	<th name="l_gzdm">工种代码</th>
	     	<th name="l_gz">工种</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>