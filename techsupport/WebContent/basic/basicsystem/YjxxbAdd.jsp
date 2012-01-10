<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_yjsj").attr("readonly","true");
		$("#a_yjsj").datepicker();
	}); 
	function addVerify(){
		if (!checkControlValue("a_yjgzid","Integer",-9999999999,9999999999,null,0,"预警规则ID"))
			return false;
		if (!checkControlValue("a_yjxxid","Integer",-9999999999,9999999999,null,0,"预警信息ID"))
			return false;
		if (!checkControlValue("a_ssqymc","String",1,100,null,0,"所属企业名称"))
			return false;
		if (!checkControlValue("a_ssqydz","String",1,200,null,0,"所属企业地址"))
			return false;
		if (!checkControlValue("a_gxdwbm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("a_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("a_yjlx","String",1,60,null,0,"预警类型"))
			return false;
		if (!checkControlValue("a_yjsj","Date",null,null,null,0,"预警时间"))
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
		if (!checkControlValue("a_gxbbh","Integer",-999999,999999,null,0,"更新版本号"))
			return false;
		if (!checkControlValue("a_ywlb","String",1,30,null,0,"业务类别"))
			return false;
		if (!checkControlValue("a_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("a_qkms","String",1,2000,null,0,"情况描述"))
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
		<td class="distd">预警规则ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_yjgzid" value="0"></td>
		<td class="distd">预警信息ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_yjxxid" value="0"></td>
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
		<td class="distd">预警类型</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_yjlx" value=""></td>
		<td class="distd">预警时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_yjsj" value=""></td>
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
		<td class="distd">更新版本号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_gxbbh" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">业务类别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_ywlb" value=""></td>
		<td class="distd">联系电话</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_lxdh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">情况描述</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="a_qkms" value=""></td>
	</tr>
	<tr height="25" align="center"><td colspan="4"><a href="#" id="addbutton" onclick='setAdd();'><img src="images/submit.gif"  border="0"/></a></td></tr>
</table>