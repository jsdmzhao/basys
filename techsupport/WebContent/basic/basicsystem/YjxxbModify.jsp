<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_yjgzid").attr("value",dataid);
		$("#m_yjgzid").attr("value",dataid);
		setDetail();
		$("#m_yjsj").attr("readonly","true");
		$("#m_yjsj").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_yjgzid").attr("value",setNull(json.LYjxxb[0].yjgzid));
		$("#m_yjxxid").attr("value",setNull(json.LYjxxb[0].yjxxid));
		$("#m_ssqymc").attr("value",setNull(json.LYjxxb[0].ssqymc));
		$("#m_ssqydz").attr("value",setNull(json.LYjxxb[0].ssqydz));
		$("#m_gxdwbm").attr("value",setNull(json.LYjxxb[0].gxdwbm));
		$("#m_gxdwmc").attr("value",setNull(json.LYjxxb[0].gxdwmc));
		$("#m_yjlx").attr("value",setNull(json.LYjxxb[0].yjlx));
		$("#m_yjsj").attr("value",setNull(json.LYjxxb[0].yjsj));
		$("#m_bdbm").attr("value",setNull(json.LYjxxb[0].bdbm));
		$("#m_ywbm").attr("value",setNull(json.LYjxxb[0].ywbm));
		$("#m_hylb").attr("value",setNull(json.LYjxxb[0].hylb));
		$("#m_xm").attr("value",setNull(json.LYjxxb[0].xm));
		$("#m_gmsfhm").attr("value",setNull(json.LYjxxb[0].gmsfhm));
		$("#m_gxbbh").attr("value",setNull(json.LYjxxb[0].gxbbh));
		$("#m_ywlb").attr("value",setNull(json.LYjxxb[0].ywlb));
		$("#m_lxdh").attr("value",setNull(json.LYjxxb[0].lxdh));
		$("#m_qkms").attr("value",setNull(json.LYjxxb[0].qkms));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_yjgzid","Integer",-9999999999,9999999999,null,0,"预警规则ID"))
			return false;
		if (!checkControlValue("m_yjxxid","Integer",-9999999999,9999999999,null,0,"预警信息ID"))
			return false;
		if (!checkControlValue("m_ssqymc","String",1,100,null,0,"所属企业名称"))
			return false;
		if (!checkControlValue("m_ssqydz","String",1,200,null,0,"所属企业地址"))
			return false;
		if (!checkControlValue("m_gxdwbm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("m_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("m_yjlx","String",1,60,null,0,"预警类型"))
			return false;
		if (!checkControlValue("m_yjsj","Date",null,null,null,0,"预警时间"))
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
		if (!checkControlValue("m_gxbbh","Integer",-999999,999999,null,0,"更新版本号"))
			return false;
		if (!checkControlValue("m_ywlb","String",1,30,null,0,"业务类别"))
			return false;
		if (!checkControlValue("m_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("m_qkms","String",1,2000,null,0,"情况描述"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_yjgzid">
<input type="hidden" id="m_yjgzid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">预警规则ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_yjgzid" value="0"></td>
		<td class="distd">预警信息ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_yjxxid" value="0"></td>
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
		<td class="distd">预警类型</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_yjlx" value=""></td>
		<td class="distd">预警时间</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_yjsj" value=""></td>
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
		<td class="distd">更新版本号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_gxbbh" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">业务类别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ywlb" value=""></td>
		<td class="distd">联系电话</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_lxdh" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">情况描述</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_qkms" value=""></td>
	</tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="subDiv" onclick='setUpdate();'><img src="images/submit.gif"  border="0"/></a></td>
	</tr>
</table>
