<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_gzdxid").attr("value",dataid);
		$("#m_gzdxid").attr("value",dataid);
		setDetail();
		$("#m_csrq").attr("readonly","true");
		$("#m_csrq").datepicker();
		$("#m_tbrq").attr("readonly","true");
		$("#m_tbrq").datepicker();
		$("#m_zxrq").attr("readonly","true");
		$("#m_zxrq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_gzdxid").attr("value",setNull(json.LGzdx_kz[0].gzdxid));
		$("#m_yjgzid").attr("value",setNull(json.LGzdx_kz[0].yjgzid));
		$("#m_yjxxid").attr("value",setNull(json.LGzdx_kz[0].yjxxid));
		$("#m_gzdxkzid").attr("value",setNull(json.LGzdx_kz[0].gzdxkzid));
		$("#m_xm").attr("value",setNull(json.LGzdx_kz[0].xm));
		$("#m_bm").attr("value",setNull(json.LGzdx_kz[0].bm));
		$("#m_xmpy").attr("value",setNull(json.LGzdx_kz[0].xmpy));
		$("#m_mzdm").attr("value",setNull(json.LGzdx_kz[0].mzdm));
		$("#m_minzu").attr("value",setNull(json.LGzdx_kz[0].minzu));
		$("#m_xbdm").attr("value",setNull(json.LGzdx_kz[0].xbdm));
		$("#m_xb").attr("value",setNull(json.LGzdx_kz[0].xb));
		$("#m_csrq").attr("value",setNull(json.LGzdx_kz[0].csrq));
		$("#m_hjdxzqh").attr("value",setNull(json.LGzdx_kz[0].hjdxzqh));
		$("#m_hjdxzqhdm").attr("value",setNull(json.LGzdx_kz[0].hjdxzqhdm));
		$("#m_hjdxz").attr("value",setNull(json.LGzdx_kz[0].hjdxz));
		$("#m_cyzjdm").attr("value",setNull(json.LGzdx_kz[0].cyzjdm));
		$("#m_cyzj").attr("value",setNull(json.LGzdx_kz[0].cyzj));
		$("#m_zjhm").attr("value",setNull(json.LGzdx_kz[0].zjhm));
		$("#m_whcd").attr("value",setNull(json.LGzdx_kz[0].whcd));
		$("#m_gzdxsf").attr("value",setNull(json.LGzdx_kz[0].gzdxsf));
		$("#m_shengao").attr("value",setNull(json.LGzdx_kz[0].shengao));
		$("#m_xzdq").attr("value",setNull(json.LGzdx_kz[0].xzdq));
		$("#m_xzdqxz").attr("value",setNull(json.LGzdx_kz[0].xzdqxz));
		$("#m_tbdw").attr("value",setNull(json.LGzdx_kz[0].tbdw));
		$("#m_tbr").attr("value",setNull(json.LGzdx_kz[0].tbr));
		$("#m_tbrq").attr("value",setNull(json.LGzdx_kz[0].tbrq));
		$("#m_tbdabm").attr("value",setNull(json.LGzdx_kz[0].tbdabm));
		$("#m_zxbz").attr("value",setNull(json.LGzdx_kz[0].zxbz));
		$("#m_zxrq").attr("value",setNull(json.LGzdx_kz[0].zxrq));
		$("#m_zxr").attr("value",setNull(json.LGzdx_kz[0].zxr));
		$("#m_bz").attr("value",setNull(json.LGzdx_kz[0].bz));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_gzdxid","Integer",-9999999999,9999999999,null,0,"关注对象ID"))
			return false;
		if (!checkControlValue("m_yjgzid","Integer",-9999999999,9999999999,null,0,"预警规则ID"))
			return false;
		if (!checkControlValue("m_yjxxid","Integer",-9999999999,9999999999,null,0,"预警信息ID"))
			return false;
		if (!checkControlValue("m_gzdxkzid","Integer",-9999999999,9999999999,null,0,"关注对象快照ID"))
			return false;
		if (!checkControlValue("m_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("m_bm","String",1,30,null,0,"别名"))
			return false;
		if (!checkControlValue("m_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("m_mzdm","String",1,40,null,0,"民族代码"))
			return false;
		if (!checkControlValue("m_minzu","String",1,20,null,0,"民族"))
			return false;
		if (!checkControlValue("m_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("m_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("m_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("m_hjdxzqh","String",1,200,null,0,"户籍地行政区划"))
			return false;
		if (!checkControlValue("m_hjdxzqhdm","String",1,10,null,0,"户籍地行政区划代码"))
			return false;
		if (!checkControlValue("m_hjdxz","String",1,200,null,0,"户籍地详址"))
			return false;
		if (!checkControlValue("m_cyzjdm","String",1,40,null,0,"常用证件代码"))
			return false;
		if (!checkControlValue("m_cyzj","String",1,100,null,0,"常用证件"))
			return false;
		if (!checkControlValue("m_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("m_whcd","String",1,60,null,0,"文化程度"))
			return false;
		if (!checkControlValue("m_gzdxsf","String",1,100,null,0,"关注对象身份"))
			return false;
		if (!checkControlValue("m_shengao","Float",-999.99,999.99,2,0,"身高"))
			return false;
		if (!checkControlValue("m_xzdq","String",1,300,null,0,"现住地区"))
			return false;
		if (!checkControlValue("m_xzdqxz","String",1,2000,null,0,"现住地区祥址"))
			return false;
		if (!checkControlValue("m_tbdw","String",1,100,null,0,"填报单位"))
			return false;
		if (!checkControlValue("m_tbr","String",1,100,null,0,"填表人"))
			return false;
		if (!checkControlValue("m_tbrq","Date",null,null,null,0,"填报日期"))
			return false;
		if (!checkControlValue("m_tbdabm","String",1,60,null,0,"填报单位编码"))
			return false;
		if (!checkControlValue("m_zxbz","String",1,2,null,0,"注销标志"))
			return false;
		if (!checkControlValue("m_zxrq","Date",null,null,null,0,"注销日期"))
			return false;
		if (!checkControlValue("m_zxr","String",1,30,null,0,"注销人"))
			return false;
		if (!checkControlValue("m_bz","String",1,2000,null,0,"备注"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_gzdxid">
<input type="hidden" id="m_gzdxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">关注对象ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_gzdxid" value="0"></td>
		<td class="distd">预警规则ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_yjgzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">预警信息ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_yjxxid" value="0"></td>
		<td class="distd">关注对象快照ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_gzdxkzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xm" value=""></td>
		<td class="distd">别名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名拼音</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xmpy" value=""></td>
		<td class="distd">民族代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_mzdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">民族</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_minzu" value=""></td>
		<td class="distd">性别代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xbdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xb" value=""></td>
		<td class="distd">出生日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_csrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">户籍地行政区划</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_hjdxzqh" value=""></td>
		<td class="distd">户籍地行政区划代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_hjdxzqhdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">户籍地详址</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_hjdxz" value=""></td>
		<td class="distd">常用证件代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_cyzjdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">常用证件</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_cyzj" value=""></td>
		<td class="distd">证件号码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_zjhm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">文化程度</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_whcd" value=""></td>
		<td class="distd">关注对象身份</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_gzdxsf" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">身高</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_shengao" value="0"></td>
		<td class="distd">现住地区</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xzdq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">现住地区祥址</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xzdqxz" value=""></td>
		<td class="distd">填报单位</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_tbdw" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">填表人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_tbr" value=""></td>
		<td class="distd">填报日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_tbrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">填报单位编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_tbdabm" value=""></td>
		<td class="distd">注销标志</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_zxbz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">注销日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_zxrq" value=""></td>
		<td class="distd">注销人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_zxr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">备注</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bz" value=""></td>
	</tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="subDiv" onclick='setUpdate();'><img src="images/submit.gif"  border="0"/></a></td>
	</tr>
</table>
