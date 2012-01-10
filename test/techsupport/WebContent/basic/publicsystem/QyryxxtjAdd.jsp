<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	daggleDiv(detailid);
	}); 
	function addVerify(){
		if (!checkControlValue("a_qyryxxtj","Integer",-9999999999,9999999999,null,0,"企业人员信息统计ID"))
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
		if (!checkControlValue("a_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("a_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("a_zrs","Integer",-999999,999999,null,0,"总人数"))
			return false;
		if (!checkControlValue("a_dyzcrs","Integer",-999999,999999,null,0,"当月注册人数"))
			return false;
		if (!checkControlValue("a_dylzrs","Integer",-999999,999999,null,0,"当月离职人数"))
			return false;
		if (!checkControlValue("a_zjqrzcrs","Integer",-999999,999999,null,0,"最近7日注册人数"))
			return false;
		if (!checkControlValue("a_zjqrlzrs","Integer",-999999,999999,null,0,"最近7日离职人数"))
			return false;
		if (!checkControlValue("a_dqzzrs","Integer",-999999,999999,null,0,"当前在职人数"))
			return false;
		if (!checkControlValue("a_zdskb","Float",-999.99,999.99,2,0,"最低刷卡比"))
			return false;
		if (!checkControlValue("a_qyrsks","Integer",-999999,999999,null,0,"前一日刷卡数"))
			return false;
		if (!checkControlValue("a_ztdm","String",1,2,null,0,"状态代码"))
			return false;
		return true;
	}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td><a href="#" id="closeDiv" onclick='$("#Qyryxxtj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">企业人员信息统计ID</td>
		<td class="detailtd"><input type="text" id="a_qyryxxtj" value="0"></td>
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
		<td class="distd">企业名称</td>
		<td class="detailtd"><input type="text" id="a_qymc" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">企业编码</td>
		<td class="detailtd"><input type="text" id="a_qybm" value=""></td>
		<td class="distd">总人数</td>
		<td class="detailtd"><input type="text" id="a_zrs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">当月注册人数</td>
		<td class="detailtd"><input type="text" id="a_dyzcrs" value="0"></td>
		<td class="distd">当月离职人数</td>
		<td class="detailtd"><input type="text" id="a_dylzrs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">最近7日注册人数</td>
		<td class="detailtd"><input type="text" id="a_zjqrzcrs" value="0"></td>
		<td class="distd">最近7日离职人数</td>
		<td class="detailtd"><input type="text" id="a_zjqrlzrs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">当前在职人数</td>
		<td class="detailtd"><input type="text" id="a_dqzzrs" value="0"></td>
		<td class="distd">最低刷卡比</td>
		<td class="detailtd"><input type="text" id="a_zdskb" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">前一日刷卡数</td>
		<td class="detailtd"><input type="text" id="a_qyrsks" value="0"></td>
		<td class="distd">状态代码</td>
		<td class="detailtd"><input type="text" id="a_ztdm" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>