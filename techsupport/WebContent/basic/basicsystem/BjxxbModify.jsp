<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bjgzid").attr("value",dataid);
		$("#m_bjgzid").attr("value",dataid);
		setDetail();
		$("#m_bjsj").attr("readonly","true");
		$("#m_bjsj").datepicker();
		$("#m_pjsj").attr("readonly","true");
		$("#m_pjsj").datepicker();
		$("#m_chjsj").attr("readonly","true");
		$("#m_chjsj").datepicker();
		$("#m_fkrq").attr("readonly","true");
		$("#m_fkrq").datepicker();
		$("#m_zhsj").attr("readonly","true");
		$("#m_zhsj").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_bjgzid").attr("value",setNull(json.LBjxxb[0].bjgzid));
		$("#m_bjxxid").attr("value",setNull(json.LBjxxb[0].bjxxid));
		$("#m_ssqymc").attr("value",setNull(json.LBjxxb[0].ssqymc));
		$("#m_ssqydz").attr("value",setNull(json.LBjxxb[0].ssqydz));
		$("#m_gxdwbm").attr("value",setNull(json.LBjxxb[0].gxdwbm));
		$("#m_gxdwmc").attr("value",setNull(json.LBjxxb[0].gxdwmc));
		$("#m_bjlx").attr("value",setNull(json.LBjxxb[0].bjlx));
		$("#m_bjsj").attr("value",setNull(json.LBjxxb[0].bjsj));
		$("#m_bdbm").attr("value",setNull(json.LBjxxb[0].bdbm));
		$("#m_ywbm").attr("value",setNull(json.LBjxxb[0].ywbm));
		$("#m_hylb").attr("value",setNull(json.LBjxxb[0].hylb));
		$("#m_xm").attr("value",setNull(json.LBjxxb[0].xm));
		$("#m_gmsfhm").attr("value",setNull(json.LBjxxb[0].gmsfhm));
		$("#m_jyaq").attr("value",setNull(json.LBjxxb[0].jyaq));
		$("#m_ladwbm").attr("value",setNull(json.LBjxxb[0].ladwbm));
		$("#m_ladwmc").attr("value",setNull(json.LBjxxb[0].ladwmc));
		$("#m_gxbbh").attr("value",setNull(json.LBjxxb[0].gxbbh));
		$("#m_ywlb").attr("value",setNull(json.LBjxxb[0].ywlb));
		$("#m_pjbmdm").attr("value",setNull(json.LBjxxb[0].pjbmdm));
		$("#m_pjbmmc").attr("value",setNull(json.LBjxxb[0].pjbmmc));
		$("#m_pjr").attr("value",setNull(json.LBjxxb[0].pjr));
		$("#m_pjsj").attr("value",setNull(json.LBjxxb[0].pjsj));
		$("#m_jqzt").attr("value",setNull(json.LBjxxb[0].jqzt));
		$("#m_cjbm").attr("value",setNull(json.LBjxxb[0].cjbm));
		$("#m_cjbmdm").attr("value",setNull(json.LBjxxb[0].cjbmdm));
		$("#m_chjsj").attr("value",setNull(json.LBjxxb[0].chjsj));
		$("#m_cjfzr").attr("value",setNull(json.LBjxxb[0].cjfzr));
		$("#m_lxdh").attr("value",setNull(json.LBjxxb[0].lxdh));
		$("#m_cjfklb").attr("value",setNull(json.LBjxxb[0].cjfklb));
		$("#m_cjfkbz").attr("value",setNull(json.LBjxxb[0].cjfkbz));
		$("#m_fkdw").attr("value",setNull(json.LBjxxb[0].fkdw));
		$("#m_fkdwbm").attr("value",setNull(json.LBjxxb[0].fkdwbm));
		$("#m_fkrq").attr("value",setNull(json.LBjxxb[0].fkrq));
		$("#m_cjjg").attr("value",setNull(json.LBjxxb[0].cjjg));
		$("#m_chjjg").attr("value",setNull(json.LBjxxb[0].chjjg));
		$("#m_zhsj").attr("value",setNull(json.LBjxxb[0].zhsj));
		$("#m_wxyy").attr("value",setNull(json.LBjxxb[0].wxyy));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_bjgzid","Integer",-9999999999,9999999999,null,0,"报警规则ID"))
			return false;
		if (!checkControlValue("m_bjxxid","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("m_ssqymc","String",1,100,null,0,"所属企业名称"))
			return false;
		if (!checkControlValue("m_ssqydz","String",1,200,null,0,"所属企业地址"))
			return false;
		if (!checkControlValue("m_gxdwbm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("m_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("m_bjlx","String",1,60,null,0,"报警类型"))
			return false;
		if (!checkControlValue("m_bjsj","Date",null,null,null,0,"报警时间"))
			return false;
		if (!checkControlValue("m_bdbm","String",1,100,null,0,"比对表名"))
			return false;
		if (!checkControlValue("m_ywbm","String",1,100,null,0,"业务表名"))
			return false;
		if (!checkControlValue("m_hylb","String",1,100,null,0,"行业类别"))
			return false;
		if (!checkControlValue("m_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("m_gmsfhm","String",1,20,null,0,"公民身份号码"))
			return false;
		if (!checkControlValue("m_jyaq","String",1,2000,null,0,"简要案情"))
			return false;
		if (!checkControlValue("m_ladwbm","String",1,20,null,0,"立案单位编码"))
			return false;
		if (!checkControlValue("m_ladwmc","String",1,100,null,0,"立案单位名称"))
			return false;
		if (!checkControlValue("m_gxbbh","Integer",-999999,999999,null,0,"更新版本号"))
			return false;
		if (!checkControlValue("m_ywlb","String",1,30,null,0,"业务类别"))
			return false;
		if (!checkControlValue("m_pjbmdm","String",1,20,null,0,"派警部门代码"))
			return false;
		if (!checkControlValue("m_pjbmmc","String",1,100,null,0,"派警部门名称"))
			return false;
		if (!checkControlValue("m_pjr","String",1,100,null,0,"派警人"))
			return false;
		if (!checkControlValue("m_pjsj","Date",null,null,null,0,"派警时间"))
			return false;
		if (!checkControlValue("m_jqzt","String",1,2,null,0,"警情状态"))
			return false;
		if (!checkControlValue("m_cjbm","String",1,100,null,0,"出警部门"))
			return false;
		if (!checkControlValue("m_cjbmdm","String",1,20,null,0,"出警部门代码"))
			return false;
		if (!checkControlValue("m_chjsj","Date",null,null,null,0,"出警时间"))
			return false;
		if (!checkControlValue("m_cjfzr","String",1,100,null,0,"出警负责人"))
			return false;
		if (!checkControlValue("m_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("m_cjfklb","String",1,2,null,0,"处警反馈类别"))
			return false;
		if (!checkControlValue("m_cjfkbz","String",1,2000,null,0,"处警反馈备注"))
			return false;
		if (!checkControlValue("m_fkdw","String",1,100,null,0,"反馈单位"))
			return false;
		if (!checkControlValue("m_fkdwbm","String",1,20,null,0,"反馈单位编码"))
			return false;
		if (!checkControlValue("m_fkrq","Date",null,null,null,0,"反馈日期"))
			return false;
		if (!checkControlValue("m_cjjg","String",1,2000,null,0,"处警经过"))
			return false;
		if (!checkControlValue("m_chjjg","String",1,2000,null,0,"处警结果"))
			return false;
		if (!checkControlValue("m_zhsj","Date",null,null,null,0,"抓获时间"))
			return false;
		if (!checkControlValue("m_wxyy","String",1,2000,null,0,"无效原因"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_bjgzid">
<input type="hidden" id="m_bjgzid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">报警规则ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bjgzid" value="0"></td>
		<td class="distd">报警信息ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bjxxid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">所属企业名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ssqymc" value=""></td>
		<td class="distd">所属企业地址</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ssqydz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_gxdwbm" value=""></td>
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_gxdwmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">报警类型</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bjlx" value=""></td>
		<td class="distd">报警时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bjsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">比对表名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bdbm" value=""></td>
		<td class="distd">业务表名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ywbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_hylb" value=""></td>
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">公民身份号码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_gmsfhm" value=""></td>
		<td class="distd">简要案情</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_jyaq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">立案单位编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ladwbm" value=""></td>
		<td class="distd">立案单位名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ladwmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">更新版本号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_gxbbh" value="0"></td>
		<td class="distd">业务类别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ywlb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">派警部门代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_pjbmdm" value=""></td>
		<td class="distd">派警部门名称</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_pjbmmc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">派警人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_pjr" value=""></td>
		<td class="distd">派警时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_pjsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">警情状态</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_jqzt" value=""></td>
		<td class="distd">出警部门</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_cjbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">出警部门代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_cjbmdm" value=""></td>
		<td class="distd">出警时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_chjsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">出警负责人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_cjfzr" value=""></td>
		<td class="distd">联系电话</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_lxdh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">处警反馈类别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_cjfklb" value=""></td>
		<td class="distd">处警反馈备注</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_cjfkbz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">反馈单位</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_fkdw" value=""></td>
		<td class="distd">反馈单位编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_fkdwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">反馈日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_fkrq" value=""></td>
		<td class="distd">处警经过</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_cjjg" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">处警结果</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_chjjg" value=""></td>
		<td class="distd">抓获时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_zhsj" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">无效原因</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_wxyy" value=""></td>
	</tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="subDiv" onclick='setUpdate();'><img src="images/submit.gif"  border="0"/></a></td>
	</tr>
</table>
