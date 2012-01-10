<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_bjsj").attr("readonly","true");
		$("#a_bjsj").datepicker();
		$("#a_pjsj").attr("readonly","true");
		$("#a_pjsj").datepicker();
		$("#a_chjsj").attr("readonly","true");
		$("#a_chjsj").datepicker();
		$("#a_fkrq").attr("readonly","true");
		$("#a_fkrq").datepicker();
		$("#a_zhsj").attr("readonly","true");
		$("#a_zhsj").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_bjgzid","Integer",-9999999999,9999999999,null,0,"报警规则ID"))
			return false;
		if (!checkControlValue("a_bjxxid","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("a_ssqymc","String",1,100,null,0,"所属企业名称"))
			return false;
		if (!checkControlValue("a_ssqydz","String",1,200,null,0,"所属企业地址"))
			return false;
		if (!checkControlValue("a_gxdwbm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("a_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("a_bjlx","String",1,60,null,0,"报警类型"))
			return false;
		if (!checkControlValue("a_bjsj","Date",null,null,null,0,"报警时间"))
			return false;
		if (!checkControlValue("a_bdbm","String",1,100,null,0,"比对表名"))
			return false;
		if (!checkControlValue("a_ywbm","String",1,100,null,0,"业务表名"))
			return false;
		if (!checkControlValue("a_hylb","String",1,100,null,0,"行业类别"))
			return false;
		if (!checkControlValue("a_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("a_gmsfhm","String",1,20,null,0,"公民身份号码"))
			return false;
		if (!checkControlValue("a_jyaq","String",1,2000,null,0,"简要案情"))
			return false;
		if (!checkControlValue("a_ladwbm","String",1,20,null,0,"立案单位编码"))
			return false;
		if (!checkControlValue("a_ladwmc","String",1,100,null,0,"立案单位名称"))
			return false;
		if (!checkControlValue("a_gxbbh","Integer",-999999,999999,null,0,"更新版本号"))
			return false;
		if (!checkControlValue("a_ywlb","String",1,30,null,0,"业务类别"))
			return false;
		if (!checkControlValue("a_pjbmdm","String",1,20,null,0,"派警部门代码"))
			return false;
		if (!checkControlValue("a_pjbmmc","String",1,100,null,0,"派警部门名称"))
			return false;
		if (!checkControlValue("a_pjr","String",1,100,null,0,"派警人"))
			return false;
		if (!checkControlValue("a_pjsj","Date",null,null,null,0,"派警时间"))
			return false;
		if (!checkControlValue("a_jqzt","String",1,2,null,0,"警情状态"))
			return false;
		if (!checkControlValue("a_cjbm","String",1,100,null,0,"出警部门"))
			return false;
		if (!checkControlValue("a_cjbmdm","String",1,20,null,0,"出警部门代码"))
			return false;
		if (!checkControlValue("a_chjsj","Date",null,null,null,0,"出警时间"))
			return false;
		if (!checkControlValue("a_cjfzr","String",1,100,null,0,"出警负责人"))
			return false;
		if (!checkControlValue("a_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("a_cjfklb","String",1,2,null,0,"处警反馈类别"))
			return false;
		if (!checkControlValue("a_cjfkbz","String",1,2000,null,0,"处警反馈备注"))
			return false;
		if (!checkControlValue("a_fkdw","String",1,100,null,0,"反馈单位"))
			return false;
		if (!checkControlValue("a_fkdwbm","String",1,20,null,0,"反馈单位编码"))
			return false;
		if (!checkControlValue("a_fkrq","Date",null,null,null,0,"反馈日期"))
			return false;
		if (!checkControlValue("a_cjjg","String",1,2000,null,0,"处警经过"))
			return false;
		if (!checkControlValue("a_chjjg","String",1,2000,null,0,"处警结果"))
			return false;
		if (!checkControlValue("a_zhsj","Date",null,null,null,0,"抓获时间"))
			return false;
		if (!checkControlValue("a_wxyy","String",1,2000,null,0,"无效原因"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">报警规则ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bjgzid" value="0"></td>
		<td class="distd">报警信息ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bjxxid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">所属企业名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ssqymc" value=""></td>
		<td class="distd">所属企业地址</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ssqydz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_gxdwbm" value=""></td>
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_gxdwmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">报警类型</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bjlx" value=""></td>
		<td class="distd">报警时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bjsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">比对表名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_bdbm" value=""></td>
		<td class="distd">业务表名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ywbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_hylb" value=""></td>
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_xm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">公民身份号码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_gmsfhm" value=""></td>
		<td class="distd">简要案情</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_jyaq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">立案单位编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ladwbm" value=""></td>
		<td class="distd">立案单位名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ladwmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">更新版本号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_gxbbh" value="0"></td>
		<td class="distd">业务类别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ywlb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">派警部门代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_pjbmdm" value=""></td>
		<td class="distd">派警部门名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_pjbmmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">派警人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_pjr" value=""></td>
		<td class="distd">派警时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_pjsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">警情状态</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_jqzt" value=""></td>
		<td class="distd">出警部门</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_cjbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">出警部门代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_cjbmdm" value=""></td>
		<td class="distd">出警时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_chjsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">出警负责人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_cjfzr" value=""></td>
		<td class="distd">联系电话</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_lxdh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">处警反馈类别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_cjfklb" value=""></td>
		<td class="distd">处警反馈备注</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_cjfkbz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">反馈单位</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_fkdw" value=""></td>
		<td class="distd">反馈单位编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_fkdwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">反馈日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_fkrq" value=""></td>
		<td class="distd">处警经过</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_cjjg" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">处警结果</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_chjjg" value=""></td>
		<td class="distd">抓获时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_zhsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">无效原因</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_wxyy" value=""></td>
	</tr>
	<tr height="25" align="center"><td colspan="4"><a href="#" id="addbutton" onclick='setAdd();'><img src="images/submit.gif"  border="0"/></a></td></tr>
</table>