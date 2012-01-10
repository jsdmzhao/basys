<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_riqi").attr("readonly","true");
		$("#a_riqi").datepicker();
		$("#a_ksyysj").attr("readonly","true");
		$("#a_ksyysj").datepicker();
		$("#a_jsyysj").attr("readonly","true");
		$("#a_jsyysj").datepicker();
		$("#a_kyrq").attr("readonly","true");
		$("#a_kyrq").datepicker();
		$("#a_barq").attr("readonly","true");
		$("#a_barq").datepicker();
		$("#a_tyrq").attr("readonly","true");
		$("#a_tyrq").datepicker();
		$("#a_hcsj").attr("readonly","true");
		$("#a_hcsj").datepicker();
		$("#a_dcsj").attr("readonly","true");
		$("#a_dcsj").datepicker();
		$("#a_ztgbrq").attr("readonly","true");
		$("#a_ztgbrq").datepicker();
		$("#a_bcsj").attr("readonly","true");
		$("#a_bcsj").datepicker();
		$("#a_lrsj").attr("readonly","true");
		$("#a_lrsj").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("a_yyrzid","Integer",-9999999999,9999999999,null,0,"营业日志ID"))
			return false;
		if (!checkControlValue("a_yyrztjid","Integer",-9999999999,9999999999,null,0,"营业日志统计ID"))
			return false;
		if (!checkControlValue("a_riqi","Date",null,null,null,0,"日期"))
			return false;
		if (!checkControlValue("a_ksyysj","Date",null,null,null,0,"营业开始时间"))
			return false;
		if (!checkControlValue("a_jsyysj","Date",null,null,null,0,"营业结束时间"))
			return false;
		if (!checkControlValue("a_csfzrbh","String",1,20,null,0,"场所负责人编号"))
			return false;
		if (!checkControlValue("a_csfe","String",1,30,null,0,"场所负责人姓名"))
			return false;
		if (!checkControlValue("a_zafzrbh","String",1,20,null,0,"治安负责人编号"))
			return false;
		if (!checkControlValue("a_zafzrxm","String",1,30,null,0,"治安负责人姓名"))
			return false;
		if (!checkControlValue("a_sffsaj","String",1,1,null,0,"是否有治安、刑事案件或事故发生"))
			return false;
		if (!checkControlValue("a_sfglbmjc","String",1,1,null,0,"是否有管理部门检查"))
			return false;
		if (!checkControlValue("a_dryysj","String",1,2000,null,0,"当日营业状况"))
			return false;
		if (!checkControlValue("a_hylbdm","String",1,3,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("a_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("a_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("a_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("a_qyqp","String",1,100,null,0,"企业全拼"))
			return false;
		if (!checkControlValue("a_qyjp","String",1,30,null,0,"企业简拼"))
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
		if (!checkControlValue("a_ssdxjgajgdm","String",1,20,null,0,"所属地县级公安机关机构代码"))
			return false;
		if (!checkControlValue("a_ssdxjgajgmc","String",1,200,null,0,"所属地县级公安机关名称"))
			return false;
		if (!checkControlValue("a_ssddsjgdm","String",1,20,null,0,"所属地地市机构代码"))
			return false;
		if (!checkControlValue("a_ssddsjgmc","String",1,200,null,0,"所属地地市机构名称"))
			return false;
		if (!checkControlValue("a_qyzzjgdm","String",1,10,null,0,"企业组织机构代码"))
			return false;
		if (!checkControlValue("a_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("a_yzbm","String",1,20,null,0,"邮政编码"))
			return false;
		if (!checkControlValue("a_chzh","String",1,30,null,0,"传真"))
			return false;
		if (!checkControlValue("a_jwdzb","String",1,100,null,0,"经纬度坐标"))
			return false;
		if (!checkControlValue("a_jjlxbm","String",1,4,null,0,"经济类型编码"))
			return false;
		if (!checkControlValue("a_jjlxmc","String",1,60,null,0,"经济类型名称"))
			return false;
		if (!checkControlValue("a_jyfwzy","String",1,2000,null,0,"经营范围（主营）"))
			return false;
		if (!checkControlValue("a_jyfwjy","String",1,2000,null,0,"经营范围（兼营）"))
			return false;
		if (!checkControlValue("a_zczj","Float",-99999999.99,99999999.99,2,0,"注册资金"))
			return false;
		if (!checkControlValue("a_jymj","Float",-99999999.99,99999999.99,2,0,"经营面积"))
			return false;
		if (!checkControlValue("a_zabdm","String",1,4,null,0,"治安级别代码"))
			return false;
		if (!checkControlValue("a_zajbmc","String",1,20,null,0,"治安级别名称"))
			return false;
		if (!checkControlValue("a_yyztdm","String",1,2,null,0,"营业状态代码"))
			return false;
		if (!checkControlValue("a_yyztmc","String",1,20,null,0,"营业状态名称"))
			return false;
		if (!checkControlValue("a_frdb","String",1,30,null,0,"法人代表姓名"))
			return false;
		if (!checkControlValue("a_frdbzjlb","String",1,40,null,0,"法人代表证件类别"))
			return false;
		if (!checkControlValue("a_frdbzjhm","String",1,30,null,0,"法人代表证件号码"))
			return false;
		if (!checkControlValue("a_frdblxfs","String",1,30,null,0,"法人代表联系方式"))
			return false;
		if (!checkControlValue("a_kyrq","Date",null,null,null,0,"开业日期"))
			return false;
		if (!checkControlValue("a_yysj","String",1,20,null,0,"营业时间"))
			return false;
		if (!checkControlValue("a_babh","String",1,30,null,0,"备案编号"))
			return false;
		if (!checkControlValue("a_barq","Date",null,null,null,0,"备案日期"))
			return false;
		if (!checkControlValue("a_tyrq","Date",null,null,null,0,"停业日期"))
			return false;
		if (!checkControlValue("a_jyfs","String",1,20,null,0,"经营方式"))
			return false;
		if (!checkControlValue("a_jydz","String",1,200,null,0,"经营地址"))
			return false;
		if (!checkControlValue("a_dwfzrzjlb","String",1,40,null,0,"单位负责人证件类别"))
			return false;
		if (!checkControlValue("a_dwfzrzjhm","String",1,30,null,0,"单位负责人证件号码"))
			return false;
		if (!checkControlValue("a_dwfzr","String",1,30,null,0,"单位负责人姓名"))
			return false;
		if (!checkControlValue("a_dwfzrlxfs","String",1,30,null,0,"单位负责人联系方式"))
			return false;
		if (!checkControlValue("a_xfshdw","String",1,200,null,0,"消防审核单位"))
			return false;
		if (!checkControlValue("a_xfhgzh","String",1,20,null,0,"消防合格证号"))
			return false;
		if (!checkControlValue("a_hcdw","String",1,100,null,0,"核查单位"))
			return false;
		if (!checkControlValue("a_hcr","String",1,30,null,0,"核查人"))
			return false;
		if (!checkControlValue("a_hcsj","Date",null,null,null,0,"核查时间"))
			return false;
		if (!checkControlValue("a_gdxx","String",1,2000,null,0,"股东信息"))
			return false;
		if (!checkControlValue("a_zrs","Integer",-999999,999999,null,0,"总人数"))
			return false;
		if (!checkControlValue("a_hdrs","Integer",-999999,999999,null,0,"核定人数"))
			return false;
		if (!checkControlValue("a_bagsmc","String",1,60,null,0,"保安公司名称"))
			return false;
		if (!checkControlValue("a_bafzrgmsfhm","String",1,20,null,0,"保安负责人公民身份号码"))
			return false;
		if (!checkControlValue("a_bafzrxm","String",1,30,null,0,"保安负责人姓名"))
			return false;
		if (!checkControlValue("a_bafzrdh","String",1,30,null,0,"保安负责人电话"))
			return false;
		if (!checkControlValue("a_bars","Integer",-999999,999999,null,0,"保安人数"))
			return false;
		if (!checkControlValue("a_jgpxrs","Integer",-999999,999999,null,0,"经岗位培训人数"))
			return false;
		if (!checkControlValue("a_bagsyj","String",1,2000,null,0,"保安公司意见"))
			return false;
		if (!checkControlValue("a_cksl","Integer",-999999,999999,null,0,"出口数量"))
			return false;
		if (!checkControlValue("a_bxbjsl","Integer",-999999,999999,null,0,"包厢包间数量"))
			return false;
		if (!checkControlValue("a_bz","String",1,2000,null,0,"备注"))
			return false;
		if (!checkControlValue("a_dcbs","Integer",-99,99,null,0,"导出标识"))
			return false;
		if (!checkControlValue("a_dcsj","Date",null,null,null,0,"导出时间"))
			return false;
		if (!checkControlValue("a_zt","String",1,10,null,0,"状态"))
			return false;
		if (!checkControlValue("a_ztgbrq","Date",null,null,null,0,"状态改变日期"))
			return false;
		if (!checkControlValue("a_scbz","Integer",-99,99,null,0,"删除标志"))
			return false;
		if (!checkControlValue("a_jqbm","String",1,10,null,0,"机器编码"))
			return false;
		if (!checkControlValue("a_zxbz","String",1,2,null,0,"注销标志"))
			return false;
		if (!checkControlValue("a_zxyy","String",1,200,null,0,"注销原因"))
			return false;
		if (!checkControlValue("a_zdskb","Float",-999.99,999.99,2,0,"最低刷卡比"))
			return false;
		if (!checkControlValue("a_bcsj","Date",null,null,null,0,"保存时间"))
			return false;
		if (!checkControlValue("a_lrsj","Date",null,null,null,0,"录入时间"))
			return false;
		if (!checkControlValue("a_lrr","String",1,100,null,0,"录入人"))
			return false;
		if (!checkControlValue("a_lrdwbm","String",1,20,null,0,"录入单位编码"))
			return false;
		if (!checkControlValue("a_lrdwmc","String",1,60,null,0,"录入单位名称"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyyyrztj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">企业ID</td>
		<td class="detailtd"><input type="text" id="a_qyid" value="0"></td>
		<td class="distd">营业日志ID</td>
		<td class="detailtd"><input type="text" id="a_yyrzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">营业日志统计ID</td>
		<td class="detailtd"><input type="text" id="a_yyrztjid" value="0"></td>
		<td class="distd">日期</td>
		<td class="detailtd"><input type="text" id="a_riqi" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">营业开始时间</td>
		<td class="detailtd"><input type="text" id="a_ksyysj" value=""></td>
		<td class="distd">营业结束时间</td>
		<td class="detailtd"><input type="text" id="a_jsyysj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">场所负责人编号</td>
		<td class="detailtd"><input type="text" id="a_csfzrbh" value=""></td>
		<td class="distd">场所负责人姓名</td>
		<td class="detailtd"><input type="text" id="a_csfe" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">治安负责人编号</td>
		<td class="detailtd"><input type="text" id="a_zafzrbh" value=""></td>
		<td class="distd">治安负责人姓名</td>
		<td class="detailtd"><input type="text" id="a_zafzrxm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">是否有治安、刑事案件或事故发生</td>
		<td class="detailtd"><input type="text" id="a_sffsaj" value=""></td>
		<td class="distd">是否有管理部门检查</td>
		<td class="detailtd"><input type="text" id="a_sfglbmjc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">当日营业状况</td>
		<td class="detailtd"><input type="text" id="a_dryysj" value=""></td>
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="a_hylbdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="a_hylb" value=""></td>
		<td class="distd">企业编码</td>
		<td class="detailtd"><input type="text" id="a_qybm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业名称</td>
		<td class="detailtd"><input type="text" id="a_qymc" value=""></td>
		<td class="distd">企业全拼</td>
		<td class="detailtd"><input type="text" id="a_qyqp" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业简拼</td>
		<td class="detailtd"><input type="text" id="a_qyjp" value=""></td>
		<td class="distd">企业主分类编码</td>
		<td class="detailtd"><input type="text" id="a_qyzflbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业主分类名称</td>
		<td class="detailtd"><input type="text" id="a_qyzflmc" value=""></td>
		<td class="distd">企业副分类编码</td>
		<td class="detailtd"><input type="text" id="a_qyfflbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业副分类名称</td>
		<td class="detailtd"><input type="text" id="a_qyfflmc" value=""></td>
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" id="a_gxdwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" id="a_gxdwmc" value=""></td>
		<td class="distd">所属地县级公安机关机构代码</td>
		<td class="detailtd"><input type="text" id="a_ssdxjgajgdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">所属地县级公安机关名称</td>
		<td class="detailtd"><input type="text" id="a_ssdxjgajgmc" value=""></td>
		<td class="distd">所属地地市机构代码</td>
		<td class="detailtd"><input type="text" id="a_ssddsjgdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">所属地地市机构名称</td>
		<td class="detailtd"><input type="text" id="a_ssddsjgmc" value=""></td>
		<td class="distd">企业组织机构代码</td>
		<td class="detailtd"><input type="text" id="a_qyzzjgdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">联系电话</td>
		<td class="detailtd"><input type="text" id="a_lxdh" value=""></td>
		<td class="distd">邮政编码</td>
		<td class="detailtd"><input type="text" id="a_yzbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">传真</td>
		<td class="detailtd"><input type="text" id="a_chzh" value=""></td>
		<td class="distd">经纬度坐标</td>
		<td class="detailtd"><input type="text" id="a_jwdzb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">经济类型编码</td>
		<td class="detailtd"><input type="text" id="a_jjlxbm" value=""></td>
		<td class="distd">经济类型名称</td>
		<td class="detailtd"><input type="text" id="a_jjlxmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">经营范围（主营）</td>
		<td class="detailtd"><input type="text" id="a_jyfwzy" value=""></td>
		<td class="distd">经营范围（兼营）</td>
		<td class="detailtd"><input type="text" id="a_jyfwjy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">注册资金</td>
		<td class="detailtd"><input type="text" id="a_zczj" value="0"></td>
		<td class="distd">经营面积</td>
		<td class="detailtd"><input type="text" id="a_jymj" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">治安级别代码</td>
		<td class="detailtd"><input type="text" id="a_zabdm" value=""></td>
		<td class="distd">治安级别名称</td>
		<td class="detailtd"><input type="text" id="a_zajbmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">营业状态代码</td>
		<td class="detailtd"><input type="text" id="a_yyztdm" value=""></td>
		<td class="distd">营业状态名称</td>
		<td class="detailtd"><input type="text" id="a_yyztmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">法人代表姓名</td>
		<td class="detailtd"><input type="text" id="a_frdb" value=""></td>
		<td class="distd">法人代表证件类别</td>
		<td class="detailtd"><input type="text" id="a_frdbzjlb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">法人代表证件号码</td>
		<td class="detailtd"><input type="text" id="a_frdbzjhm" value=""></td>
		<td class="distd">法人代表联系方式</td>
		<td class="detailtd"><input type="text" id="a_frdblxfs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">开业日期</td>
		<td class="detailtd"><input type="text" id="a_kyrq" value=""></td>
		<td class="distd">营业时间</td>
		<td class="detailtd"><input type="text" id="a_yysj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">备案编号</td>
		<td class="detailtd"><input type="text" id="a_babh" value=""></td>
		<td class="distd">备案日期</td>
		<td class="detailtd"><input type="text" id="a_barq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">停业日期</td>
		<td class="detailtd"><input type="text" id="a_tyrq" value=""></td>
		<td class="distd">经营方式</td>
		<td class="detailtd"><input type="text" id="a_jyfs" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">经营地址</td>
		<td class="detailtd"><input type="text" id="a_jydz" value=""></td>
		<td class="distd">单位负责人证件类别</td>
		<td class="detailtd"><input type="text" id="a_dwfzrzjlb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">单位负责人证件号码</td>
		<td class="detailtd"><input type="text" id="a_dwfzrzjhm" value=""></td>
		<td class="distd">单位负责人姓名</td>
		<td class="detailtd"><input type="text" id="a_dwfzr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">单位负责人联系方式</td>
		<td class="detailtd"><input type="text" id="a_dwfzrlxfs" value=""></td>
		<td class="distd">消防审核单位</td>
		<td class="detailtd"><input type="text" id="a_xfshdw" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">消防合格证号</td>
		<td class="detailtd"><input type="text" id="a_xfhgzh" value=""></td>
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
		<td class="distd">股东信息</td>
		<td class="detailtd"><input type="text" id="a_gdxx" value=""></td>
		<td class="distd">总人数</td>
		<td class="detailtd"><input type="text" id="a_zrs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">核定人数</td>
		<td class="detailtd"><input type="text" id="a_hdrs" value="0"></td>
		<td class="distd">保安公司名称</td>
		<td class="detailtd"><input type="text" id="a_bagsmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">保安负责人公民身份号码</td>
		<td class="detailtd"><input type="text" id="a_bafzrgmsfhm" value=""></td>
		<td class="distd">保安负责人姓名</td>
		<td class="detailtd"><input type="text" id="a_bafzrxm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">保安负责人电话</td>
		<td class="detailtd"><input type="text" id="a_bafzrdh" value=""></td>
		<td class="distd">保安人数</td>
		<td class="detailtd"><input type="text" id="a_bars" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">经岗位培训人数</td>
		<td class="detailtd"><input type="text" id="a_jgpxrs" value="0"></td>
		<td class="distd">保安公司意见</td>
		<td class="detailtd"><input type="text" id="a_bagsyj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">出口数量</td>
		<td class="detailtd"><input type="text" id="a_cksl" value="0"></td>
		<td class="distd">包厢包间数量</td>
		<td class="detailtd"><input type="text" id="a_bxbjsl" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">备注</td>
		<td class="detailtd"><input type="text" id="a_bz" value=""></td>
		<td class="distd">导出标识</td>
		<td class="detailtd"><input type="text" id="a_dcbs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">导出时间</td>
		<td class="detailtd"><input type="text" id="a_dcsj" value=""></td>
		<td class="distd">状态</td>
		<td class="detailtd"><input type="text" id="a_zt" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">状态改变日期</td>
		<td class="detailtd"><input type="text" id="a_ztgbrq" value=""></td>
		<td class="distd">删除标志</td>
		<td class="detailtd"><input type="text" id="a_scbz" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">机器编码</td>
		<td class="detailtd"><input type="text" id="a_jqbm" value=""></td>
		<td class="distd">注销标志</td>
		<td class="detailtd"><input type="text" id="a_zxbz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">注销原因</td>
		<td class="detailtd"><input type="text" id="a_zxyy" value=""></td>
		<td class="distd">最低刷卡比</td>
		<td class="detailtd"><input type="text" id="a_zdskb" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">保存时间</td>
		<td class="detailtd"><input type="text" id="a_bcsj" value=""></td>
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
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>