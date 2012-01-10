<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
	daggleDiv(detailid);
	}); 
	function addVerify(){
		if (!checkControlValue("a_qyfltjid","Integer",-9999999999,9999999999,null,0,"企业分类统计ID"))
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
		if (!checkControlValue("a_gwyl","Integer",-999999,999999,null,0,"歌舞娱乐"))
			return false;
		if (!checkControlValue("a_jb","Integer",-999999,999999,null,0,"酒吧"))
			return false;
		if (!checkControlValue("a_glxxhdcs","Integer",-999999,999999,null,0,"各类休闲活动场所"))
			return false;
		if (!checkControlValue("a_yysdzyxt","Integer",-999999,999999,null,0,"游艺室、电子游戏厅"))
			return false;
		if (!checkControlValue("a_snxy","Integer",-999999,999999,null,0,"桑拿、洗浴"))
			return false;
		if (!checkControlValue("a_am","Integer",-999999,999999,null,0,"按摩"))
			return false;
		if (!checkControlValue("a_zs","Integer",-999999,999999,null,0,"住宿"))
			return false;
		if (!checkControlValue("a_wsfw","Integer",-999999,999999,null,0,"网上服务（网吧）"))
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
      <td><a href="#" id="closeDiv" onclick='$("#Qyfltj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="add">
	<tr height="20">
		<td class="distd">企业分类统计ID</td>
		<td class="detailtd"><input type="text" id="a_qyfltjid" value="0"></td>
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
		<td class="distd">歌舞娱乐</td>
		<td class="detailtd"><input type="text" id="a_gwyl" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">酒吧</td>
		<td class="detailtd"><input type="text" id="a_jb" value="0"></td>
		<td class="distd">各类休闲活动场所</td>
		<td class="detailtd"><input type="text" id="a_glxxhdcs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">游艺室、电子游戏厅</td>
		<td class="detailtd"><input type="text" id="a_yysdzyxt" value="0"></td>
		<td class="distd">桑拿、洗浴</td>
		<td class="detailtd"><input type="text" id="a_snxy" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">按摩</td>
		<td class="detailtd"><input type="text" id="a_am" value="0"></td>
		<td class="distd">住宿</td>
		<td class="detailtd"><input type="text" id="a_zs" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">网上服务（网吧）</td>
		<td class="detailtd"><input type="text" id="a_wsfw" value="0"></td>
		<td class="distd">其他</td>
		<td class="detailtd"><input type="text" id="a_qt" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">合计</td>
		<td class="detailtd"><input type="text" id="a_hj" value="0"></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table>