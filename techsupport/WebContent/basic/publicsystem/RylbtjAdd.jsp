<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	daggleDiv(detailid);
	}); 
	function addVerify(){
		if (!checkControlValue("a_rybtjid","Integer",-9999999999,9999999999,null,0,"人员类别统计ID"))
			return false;
		if (!checkControlValue("a_hylbdm","String",1,2,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("a_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("a_dsjgdm","String",1,20,null,0,"地市机关代码"))
			return false;
		if (!checkControlValue("a_dsjgmc","String",1,60,null,0,"地市机关名称"))
			return false;
		if (!checkControlValue("a_fxjdm","String",1,20,null,0,"分县局代码"))
			return false;
		if (!checkControlValue("a_fxjmc","String",1,60,null,0,"分县局名称"))
			return false;
		if (!checkControlValue("a_gxdwdm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("a_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("a_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("a_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("a_glry","Integer",-999999,999999,null,0,"管理人员"))
			return false;
		if (!checkControlValue("a_fddbr","Integer",-999999,999999,null,0,"法定代表人或主要负责人"))
			return false;
		if (!checkControlValue("a_zygdzcry","Integer",-999999,999999,null,0,"主要股东组成人员"))
			return false;
		if (!checkControlValue("a_zafzr","Integer",-999999,999999,null,0,"治安负责人"))
			return false;
		if (!checkControlValue("a_qtglry","Integer",-999999,999999,null,0,"其他管理人员"))
			return false;
		if (!checkControlValue("a_fwry","Integer",-999999,999999,null,0,"服务人员"))
			return false;
		if (!checkControlValue("a_ybfwry","Integer",-999999,999999,null,0,"一般服务人员"))
			return false;
		if (!checkControlValue("a_lsfwry","Integer",-999999,999999,null,0,"临时服务人员"))
			return false;
		if (!checkControlValue("a_yyry","Integer",-999999,999999,null,0,"演艺人员"))
			return false;
		if (!checkControlValue("a_qtfwry","Integer",-999999,999999,null,0,"其他服务人员"))
			return false;
		if (!checkControlValue("a_bary","Integer",-999999,999999,null,0,"保安人员"))
			return false;
		if (!checkControlValue("a_aqjcry","Integer",-999999,999999,null,0,"安全检查人员"))
			return false;
		if (!checkControlValue("a_qt","Integer",-999999,999999,null,0,"其他"))
			return false;
		if (!checkControlValue("a_hj","Integer",-999999,999999,null,0,"合计"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Rylbtj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">人员类别统计ID</td>
		<td class="detailtd"><input type="text" id="a_rybtjid" value="0"></td>
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="a_hylbdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="a_hylb" value=""></td>
		<td class="distd">地市机关代码</td>
		<td class="detailtd"><input type="text" id="a_dsjgdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">地市机关名称</td>
		<td class="detailtd"><input type="text" id="a_dsjgmc" value=""></td>
		<td class="distd">分县局代码</td>
		<td class="detailtd"><input type="text" id="a_fxjdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">分县局名称</td>
		<td class="detailtd"><input type="text" id="a_fxjmc" value=""></td>
		<td class="distd">管辖单位代码</td>
		<td class="detailtd"><input type="text" id="a_gxdwdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位名称</td>
		<td class="detailtd"><input type="text" id="a_gxdwmc" value=""></td>
		<td class="distd">企业编码</td>
		<td class="detailtd"><input type="text" id="a_qybm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业名称</td>
		<td class="detailtd"><input type="text" id="a_qymc" value=""></td>
		<td class="distd">管理人员</td>
		<td class="detailtd"><input type="text" id="a_glry" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">法定代表人或主要负责人</td>
		<td class="detailtd"><input type="text" id="a_fddbr" value="0"></td>
		<td class="distd">主要股东组成人员</td>
		<td class="detailtd"><input type="text" id="a_zygdzcry" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">治安负责人</td>
		<td class="detailtd"><input type="text" id="a_zafzr" value="0"></td>
		<td class="distd">其他管理人员</td>
		<td class="detailtd"><input type="text" id="a_qtglry" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">服务人员</td>
		<td class="detailtd"><input type="text" id="a_fwry" value="0"></td>
		<td class="distd">一般服务人员</td>
		<td class="detailtd"><input type="text" id="a_ybfwry" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">临时服务人员</td>
		<td class="detailtd"><input type="text" id="a_lsfwry" value="0"></td>
		<td class="distd">演艺人员</td>
		<td class="detailtd"><input type="text" id="a_yyry" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">其他服务人员</td>
		<td class="detailtd"><input type="text" id="a_qtfwry" value="0"></td>
		<td class="distd">保安人员</td>
		<td class="detailtd"><input type="text" id="a_bary" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">安全检查人员</td>
		<td class="detailtd"><input type="text" id="a_aqjcry" value="0"></td>
		<td class="distd">其他</td>
		<td class="detailtd"><input type="text" id="a_qt" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">合计</td>
		<td class="detailtd"><input type="text" id="a_hj" value="0"></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>