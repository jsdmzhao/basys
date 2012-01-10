<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_qyjbxx_ls.action";
	divnid="Qyjbxx_lsData";
	tableid="Qyjbxx_lsTable";
	addUrl="publicsystem/insert_qyjbxx_ls.action";
	addHtml="business/publicsystem/Qyjbxx_lsAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_qyjbxx_ls.action";
	delid="d_qyid";
	modHtml="business/publicsystem/Qyjbxx_lsModify.jsp";
	modUrl="publicsystem/modify_qyjbxx_ls.action";
	modWidth="800";
	detailHtml="business/publicsystem/Qyjbxx_lsDetail.jsp";
	detailid="qyjbxx_ls_detail";
	detailUrl="publicsystem/query_qyjbxx_ls.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_kyrq").attr("readonly","true");
		$("#p_kyrq").datepicker();
		$("#p_barq").attr("readonly","true");
		$("#p_barq").datepicker();
		$("#p_tyrq").attr("readonly","true");
		$("#p_tyrq").datepicker();
		$("#p_hcsj").attr("readonly","true");
		$("#p_hcsj").datepicker();
		$("#p_dcsj").attr("readonly","true");
		$("#p_dcsj").datepicker();
		$("#p_ztgbrq").attr("readonly","true");
		$("#p_ztgbrq").datepicker();
		$("#p_bcsj").attr("readonly","true");
		$("#p_bcsj").datepicker();
		$("#p_lrsj").attr("readonly","true");
		$("#p_lrsj").datepicker();
	
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
										colWidths: ["1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("p_qylsid","Integer",-9999999999,9999999999,null,0,"企业历史ID"))
			return false;
		if (!checkControlValue("p_hylbdm","String",1,2,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("p_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("p_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("p_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("p_qyqp","String",1,100,null,0,"企业全拼"))
			return false;
		if (!checkControlValue("p_qyjp","String",1,30,null,0,"企业简拼"))
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
		if (!checkControlValue("p_ssdxjgajgdm","String",1,20,null,0,"所属地县级公安机关机构代码"))
			return false;
		if (!checkControlValue("p_ssdxjgajgmc","String",1,200,null,0,"所属地县级公安机关名称"))
			return false;
		if (!checkControlValue("p_ssdpcsjgdm","String",1,20,null,0,"所属地派出所机构代码"))
			return false;
		if (!checkControlValue("p_ssdpcsjgmc","String",1,200,null,0,"所属地派出所机构名称"))
			return false;
		if (!checkControlValue("p_qyzzjgdm","String",1,10,null,0,"企业组织机构代码"))
			return false;
		if (!checkControlValue("p_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("p_yzbm","String",1,20,null,0,"邮政编码"))
			return false;
		if (!checkControlValue("p_chzh","String",1,30,null,0,"传真"))
			return false;
		if (!checkControlValue("p_jwdzb","String",1,100,null,0,"经纬度坐标"))
			return false;
		if (!checkControlValue("p_jjlxbm","String",1,4,null,0,"经济类型编码"))
			return false;
		if (!checkControlValue("p_jjlxmc","String",1,60,null,0,"经济类型名称"))
			return false;
		if (!checkControlValue("p_jyfwzy","String",1,200,null,0,"经营范围（主营）"))
			return false;
		if (!checkControlValue("p_jyfwjy","String",1,200,null,0,"经营范围（兼营）"))
			return false;
		if (!checkControlValue("p_zczj","Float",-99999999.99,99999999.99,2,0,"注册资金"))
			return false;
		if (!checkControlValue("p_jymj","Float",-99999999.99,99999999.99,2,0,"经营面积"))
			return false;
		if (!checkControlValue("p_zabdm","String",1,4,null,0,"治安级别代码"))
			return false;
		if (!checkControlValue("p_zajbmc","String",1,20,null,0,"治安级别名称"))
			return false;
		if (!checkControlValue("p_yyztdm","String",1,20,null,0,"营业状态代码"))
			return false;
		if (!checkControlValue("p_yyztmc","String",1,20,null,0,"营业状态名称"))
			return false;
		if (!checkControlValue("p_frdb","String",1,30,null,0,"法人代表姓名"))
			return false;
		if (!checkControlValue("p_frdbzjlb","String",1,40,null,0,"法人代表证件类别"))
			return false;
		if (!checkControlValue("p_frdbzjhm","String",1,30,null,0,"法人代表证件号码"))
			return false;
		if (!checkControlValue("p_frdblxfs","String",1,30,null,0,"法人代表联系方式"))
			return false;
		if (!checkControlValue("p_kyrq","Date",null,null,null,0,"开业日期"))
			return false;
		if (!checkControlValue("p_yysj","String",1,20,null,0,"营业时间"))
			return false;
		if (!checkControlValue("p_babh","String",1,30,null,0,"备案编号"))
			return false;
		if (!checkControlValue("p_barq","Date",null,null,null,0,"备案日期"))
			return false;
		if (!checkControlValue("p_tyrq","Date",null,null,null,0,"停业日期"))
			return false;
		if (!checkControlValue("p_jyfs","String",1,20,null,0,"经营方式"))
			return false;
		if (!checkControlValue("p_jydz","String",1,200,null,0,"经营地址"))
			return false;
		if (!checkControlValue("p_dwfzrzjlb","String",1,40,null,0,"单位负责人证件类别"))
			return false;
		if (!checkControlValue("p_dwfzrzjhm","String",1,30,null,0,"单位负责人证件号码"))
			return false;
		if (!checkControlValue("p_dwfzr","String",1,30,null,0,"单位负责人姓名"))
			return false;
		if (!checkControlValue("p_dwfzrlxfs","String",1,30,null,0,"单位负责人联系方式"))
			return false;
		if (!checkControlValue("p_xfshdw","String",1,200,null,0,"消防审核单位"))
			return false;
		if (!checkControlValue("p_xfhgzh","String",1,20,null,0,"消防合格证号"))
			return false;
		if (!checkControlValue("p_hcdw","String",1,100,null,0,"核查单位"))
			return false;
		if (!checkControlValue("p_hcr","String",1,30,null,0,"核查人"))
			return false;
		if (!checkControlValue("p_hcsj","Date",null,null,null,0,"核查时间"))
			return false;
		if (!checkControlValue("p_gdxx","String",1,2000,null,0,"股东信息"))
			return false;
		if (!checkControlValue("p_zrs","Integer",-999999,999999,null,0,"总人数"))
			return false;
		if (!checkControlValue("p_hdrs","Integer",-999999,999999,null,0,"核定人数"))
			return false;
		if (!checkControlValue("p_bagsmc","String",1,60,null,0,"保安公司名称"))
			return false;
		if (!checkControlValue("p_bafzrgmsfhm","String",1,20,null,0,"保安负责人公民身份号码"))
			return false;
		if (!checkControlValue("p_bafzrxm","String",1,30,null,0,"保安负责人姓名"))
			return false;
		if (!checkControlValue("p_bafzrdh","String",1,30,null,0,"保安负责人电话"))
			return false;
		if (!checkControlValue("p_bars","Integer",-999999,999999,null,0,"保安人数"))
			return false;
		if (!checkControlValue("p_jgpxrs","Integer",-999999,999999,null,0,"经岗位培训人数"))
			return false;
		if (!checkControlValue("p_bagsyj","String",1,2000,null,0,"保安公司意见"))
			return false;
		if (!checkControlValue("p_cksl","Integer",-999999,999999,null,0,"出口数量"))
			return false;
		if (!checkControlValue("p_bxbjsl","Integer",-999999,999999,null,0,"包厢包间数量"))
			return false;
		if (!checkControlValue("p_bz","String",1,2000,null,0,"备注"))
			return false;
		if (!checkControlValue("p_dcbs","Integer",-99,99,null,0,"导出标识"))
			return false;
		if (!checkControlValue("p_dcsj","Date",null,null,null,0,"导出时间"))
			return false;
		if (!checkControlValue("p_zt","String",1,10,null,0,"状态"))
			return false;
		if (!checkControlValue("p_ztgbrq","Date",null,null,null,0,"状态改变日期"))
			return false;
		if (!checkControlValue("p_scbz","Integer",-99,99,null,0,"删除标志"))
			return false;
		if (!checkControlValue("p_jqbm","String",1,10,null,0,"机器编码"))
			return false;
		if (!checkControlValue("p_zxbz","String",1,2,null,0,"注销标志"))
			return false;
		if (!checkControlValue("p_zxyy","String",1,200,null,0,"注销原因"))
			return false;
		if (!checkControlValue("p_zdskb","Float",-999.99,999.99,2,0,"最低刷卡比"))
			return false;
		if (!checkControlValue("p_bcsj","Date",null,null,null,0,"保存时间"))
			return false;
		if (!checkControlValue("p_lrsj","Date",null,null,null,0,"录入时间"))
			return false;
		if (!checkControlValue("p_lrr","String",1,100,null,0,"录入人"))
			return false;
		if (!checkControlValue("p_lrdwbm","String",1,20,null,0,"录入单位编码"))
			return false;
		if (!checkControlValue("p_lrdwmc","String",1,60,null,0,"录入单位名称"))
			return false;
		if (!checkControlValue("p_czlx","String",1,40,null,0,"操作类型"))
			return false;
		if (!checkControlValue("p_bgyy","String",1,2000,null,0,"变更原因"))
			return false;
		if (!checkControlValue("p_bglbdm","String",1,2,null,0,"变更类别代码"))
			return false;
		if (!checkControlValue("p_bglb","String",1,60,null,0,"变更类别"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_qyid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">企业ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyid" value="0"></td>
					<td width="10%" class="pagedistd">企业历史ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qylsid" value="0"></td>
					<td width="10%" class="pagedistd">行业类别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hylbdm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">行业类别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hylb" value=""></td>
					<td width="10%" class="pagedistd">企业编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qybm" value=""></td>
					<td width="10%" class="pagedistd">企业名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qymc" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">企业全拼</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyqp" value=""></td>
					<td width="10%" class="pagedistd">企业简拼</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyjp" value=""></td>
					<td width="10%" class="pagedistd">企业主分类编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyzflbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">企业主分类名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyzflmc" value=""></td>
					<td width="10%" class="pagedistd">企业副分类编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyfflbm" value=""></td>
					<td width="10%" class="pagedistd">企业副分类名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyfflmc" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">管辖单位代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gxdwbm" value=""></td>
					<td width="10%" class="pagedistd">管辖单位名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gxdwmc" value=""></td>
					<td width="10%" class="pagedistd">所属地县级公安机关机构代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ssdxjgajgdm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">所属地县级公安机关名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ssdxjgajgmc" value=""></td>
					<td width="10%" class="pagedistd">所属地派出所机构代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ssdpcsjgdm" value=""></td>
					<td width="10%" class="pagedistd">所属地派出所机构名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ssdpcsjgmc" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">企业组织机构代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyzzjgdm" value=""></td>
					<td width="10%" class="pagedistd">联系电话</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lxdh" value=""></td>
					<td width="10%" class="pagedistd">邮政编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_yzbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">传真</td>
					<td width="23%" class="pagetd"><input type="text" id="p_chzh" value=""></td>
					<td width="10%" class="pagedistd">经纬度坐标</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jwdzb" value=""></td>
					<td width="10%" class="pagedistd">经济类型编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jjlxbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">经济类型名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jjlxmc" value=""></td>
					<td width="10%" class="pagedistd">经营范围（主营）</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jyfwzy" value=""></td>
					<td width="10%" class="pagedistd">经营范围（兼营）</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jyfwjy" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">注册资金</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zczj" value="0"></td>
					<td width="10%" class="pagedistd">经营面积</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jymj" value="0"></td>
					<td width="10%" class="pagedistd">治安级别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zabdm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">治安级别名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zajbmc" value=""></td>
					<td width="10%" class="pagedistd">营业状态代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_yyztdm" value=""></td>
					<td width="10%" class="pagedistd">营业状态名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_yyztmc" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">法人代表姓名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_frdb" value=""></td>
					<td width="10%" class="pagedistd">法人代表证件类别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_frdbzjlb" value=""></td>
					<td width="10%" class="pagedistd">法人代表证件号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_frdbzjhm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">法人代表联系方式</td>
					<td width="23%" class="pagetd"><input type="text" id="p_frdblxfs" value=""></td>
					<td width="10%" class="pagedistd">开业日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_kyrq" value=""></td>
					<td width="10%" class="pagedistd">营业时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_yysj" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">备案编号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_babh" value=""></td>
					<td width="10%" class="pagedistd">备案日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_barq" value=""></td>
					<td width="10%" class="pagedistd">停业日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tyrq" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">经营方式</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jyfs" value=""></td>
					<td width="10%" class="pagedistd">经营地址</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jydz" value=""></td>
					<td width="10%" class="pagedistd">单位负责人证件类别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dwfzrzjlb" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">单位负责人证件号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dwfzrzjhm" value=""></td>
					<td width="10%" class="pagedistd">单位负责人姓名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dwfzr" value=""></td>
					<td width="10%" class="pagedistd">单位负责人联系方式</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dwfzrlxfs" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">消防审核单位</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xfshdw" value=""></td>
					<td width="10%" class="pagedistd">消防合格证号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xfhgzh" value=""></td>
					<td width="10%" class="pagedistd">核查单位</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hcdw" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">核查人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hcr" value=""></td>
					<td width="10%" class="pagedistd">核查时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hcsj" value=""></td>
					<td width="10%" class="pagedistd">股东信息</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gdxx" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">总人数</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zrs" value="0"></td>
					<td width="10%" class="pagedistd">核定人数</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hdrs" value="0"></td>
					<td width="10%" class="pagedistd">保安公司名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bagsmc" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">保安负责人公民身份号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bafzrgmsfhm" value=""></td>
					<td width="10%" class="pagedistd">保安负责人姓名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bafzrxm" value=""></td>
					<td width="10%" class="pagedistd">保安负责人电话</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bafzrdh" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">保安人数</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bars" value="0"></td>
					<td width="10%" class="pagedistd">经岗位培训人数</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jgpxrs" value="0"></td>
					<td width="10%" class="pagedistd">保安公司意见</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bagsyj" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">出口数量</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cksl" value="0"></td>
					<td width="10%" class="pagedistd">包厢包间数量</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bxbjsl" value="0"></td>
					<td width="10%" class="pagedistd">备注</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bz" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">导出标识</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dcbs" value="0"></td>
					<td width="10%" class="pagedistd">导出时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dcsj" value=""></td>
					<td width="10%" class="pagedistd">状态</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zt" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">状态改变日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ztgbrq" value=""></td>
					<td width="10%" class="pagedistd">删除标志</td>
					<td width="23%" class="pagetd"><input type="text" id="p_scbz" value="0"></td>
					<td width="10%" class="pagedistd">机器编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jqbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">注销标志</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zxbz" value=""></td>
					<td width="10%" class="pagedistd">注销原因</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zxyy" value=""></td>
					<td width="10%" class="pagedistd">最低刷卡比</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zdskb" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">保存时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bcsj" value=""></td>
					<td width="10%" class="pagedistd">录入时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrsj" value=""></td>
					<td width="10%" class="pagedistd">录入人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrr" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">录入单位编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrdwbm" value=""></td>
					<td width="10%" class="pagedistd">录入单位名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrdwmc" value=""></td>
					<td width="10%" class="pagedistd">操作类型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_czlx" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">变更原因</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bgyy" value=""></td>
					<td width="10%" class="pagedistd">变更类别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bglbdm" value=""></td>
					<td width="10%" class="pagedistd">变更类别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bglb" value=""></td>
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
<div id="qyjbxx_ls_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="Qyjbxx_lsData" style="width:100%;">
	<table id="Qyjbxx_lsTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_qylsid">企业历史ID</th>
	     	<th name="l_hylbdm">行业类别代码</th>
	     	<th name="l_hylb">行业类别</th>
	     	<th name="l_qybm">企业编码</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_qyqp">企业全拼</th>
	     	<th name="l_qyjp">企业简拼</th>
	     	<th name="l_qyzflbm">企业主分类编码</th>
	     	<th name="l_qyzflmc">企业主分类名称</th>
	     	<th name="l_qyfflbm">企业副分类编码</th>
	     	<th name="l_qyfflmc">企业副分类名称</th>
	     	<th name="l_gxdwbm">管辖单位代码</th>
	     	<th name="l_gxdwmc">管辖单位名称</th>
	     	<th name="l_ssdxjgajgdm">所属地县级公安机关机构代码</th>
	     	<th name="l_ssdxjgajgmc">所属地县级公安机关名称</th>
	     	<th name="l_ssdpcsjgdm">所属地派出所机构代码</th>
	     	<th name="l_ssdpcsjgmc">所属地派出所机构名称</th>
	     	<th name="l_qyzzjgdm">企业组织机构代码</th>
	     	<th name="l_lxdh">联系电话</th>
	     	<th name="l_yzbm">邮政编码</th>
	     	<th name="l_chzh">传真</th>
	     	<th name="l_jwdzb">经纬度坐标</th>
	     	<th name="l_jjlxbm">经济类型编码</th>
	     	<th name="l_jjlxmc">经济类型名称</th>
	     	<th name="l_jyfwzy">经营范围（主营）</th>
	     	<th name="l_jyfwjy">经营范围（兼营）</th>
	     	<th name="l_zczj">注册资金</th>
	     	<th name="l_jymj">经营面积</th>
	     	<th name="l_zabdm">治安级别代码</th>
	     	<th name="l_zajbmc">治安级别名称</th>
	     	<th name="l_yyztdm">营业状态代码</th>
	     	<th name="l_yyztmc">营业状态名称</th>
	     	<th name="l_frdb">法人代表姓名</th>
	     	<th name="l_frdbzjlb">法人代表证件类别</th>
	     	<th name="l_frdbzjhm">法人代表证件号码</th>
	     	<th name="l_frdblxfs">法人代表联系方式</th>
	     	<th name="l_kyrq">开业日期</th>
	     	<th name="l_yysj">营业时间</th>
	     	<th name="l_babh">备案编号</th>
	     	<th name="l_barq">备案日期</th>
	     	<th name="l_tyrq">停业日期</th>
	     	<th name="l_jyfs">经营方式</th>
	     	<th name="l_jydz">经营地址</th>
	     	<th name="l_dwfzrzjlb">单位负责人证件类别</th>
	     	<th name="l_dwfzrzjhm">单位负责人证件号码</th>
	     	<th name="l_dwfzr">单位负责人姓名</th>
	     	<th name="l_dwfzrlxfs">单位负责人联系方式</th>
	     	<th name="l_xfshdw">消防审核单位</th>
	     	<th name="l_xfhgzh">消防合格证号</th>
	     	<th name="l_hcdw">核查单位</th>
	     	<th name="l_hcr">核查人</th>
	     	<th name="l_hcsj">核查时间</th>
	     	<th name="l_gdxx">股东信息</th>
	     	<th name="l_zrs">总人数</th>
	     	<th name="l_hdrs">核定人数</th>
	     	<th name="l_bagsmc">保安公司名称</th>
	     	<th name="l_bafzrgmsfhm">保安负责人公民身份号码</th>
	     	<th name="l_bafzrxm">保安负责人姓名</th>
	     	<th name="l_bafzrdh">保安负责人电话</th>
	     	<th name="l_bars">保安人数</th>
	     	<th name="l_jgpxrs">经岗位培训人数</th>
	     	<th name="l_bagsyj">保安公司意见</th>
	     	<th name="l_cksl">出口数量</th>
	     	<th name="l_bxbjsl">包厢包间数量</th>
	     	<th name="l_bz">备注</th>
	     	<th name="l_dcbs">导出标识</th>
	     	<th name="l_dcsj">导出时间</th>
	     	<th name="l_zt">状态</th>
	     	<th name="l_ztgbrq">状态改变日期</th>
	     	<th name="l_scbz">删除标志</th>
	     	<th name="l_jqbm">机器编码</th>
	     	<th name="l_zxbz">注销标志</th>
	     	<th name="l_zxyy">注销原因</th>
	     	<th name="l_zdskb">最低刷卡比</th>
	     	<th name="l_bcsj">保存时间</th>
	     	<th name="l_lrsj">录入时间</th>
	     	<th name="l_lrr">录入人</th>
	     	<th name="l_lrdwbm">录入单位编码</th>
	     	<th name="l_lrdwmc">录入单位名称</th>
	     	<th name="l_czlx">操作类型</th>
	     	<th name="l_bgyy">变更原因</th>
	     	<th name="l_bglbdm">变更类别代码</th>
	     	<th name="l_bglb">变更类别</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>