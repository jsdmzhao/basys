<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qgztjxid").attr("value",dataid);
		$("#m_qgztjxid").attr("value",dataid);
		setDetail();
		$("#m_csrq").attr("readonly","true");
		$("#m_csrq").datepicker();
		$("#m_djrq").attr("readonly","true");
		$("#m_djrq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_qgztjxid").attr("value",setNull(json.LQgztjx_kz[0].qgztjxid));
		$("#m_bjgzid").attr("value",setNull(json.LQgztjx_kz[0].bjgzid));
		$("#m_bjxxid").attr("value",setNull(json.LQgztjx_kz[0].bjxxid));
		$("#m_qgztjxkzid").attr("value",setNull(json.LQgztjx_kz[0].qgztjxkzid));
		$("#m_tbbh").attr("value",setNull(json.LQgztjx_kz[0].tbbh));
		$("#m_xzqhbm").attr("value",setNull(json.LQgztjx_kz[0].xzqhbm));
		$("#m_xzqh").attr("value",setNull(json.LQgztjx_kz[0].xzqh));
		$("#m_xmpy").attr("value",setNull(json.LQgztjx_kz[0].xmpy));
		$("#m_xm").attr("value",setNull(json.LQgztjx_kz[0].xm));
		$("#m_bm").attr("value",setNull(json.LQgztjx_kz[0].bm));
		$("#m_xbdm").attr("value",setNull(json.LQgztjx_kz[0].xbdm));
		$("#m_xb").attr("value",setNull(json.LQgztjx_kz[0].xb));
		$("#m_csrq").attr("value",setNull(json.LQgztjx_kz[0].csrq));
		$("#m_gmsfhm").attr("value",setNull(json.LQgztjx_kz[0].gmsfhm));
		$("#m_hjdbm").attr("value",setNull(json.LQgztjx_kz[0].hjdbm));
		$("#m_hjd").attr("value",setNull(json.LQgztjx_kz[0].hjd));
		$("#m_hjxxdz").attr("value",setNull(json.LQgztjx_kz[0].hjxxdz));
		$("#m_xzdqbm").attr("value",setNull(json.LQgztjx_kz[0].xzdqbm));
		$("#m_xzdq").attr("value",setNull(json.LQgztjx_kz[0].xzdq));
		$("#m_xzdxxdz").attr("value",setNull(json.LQgztjx_kz[0].xzdxxdz));
		$("#m_qtzjlx").attr("value",setNull(json.LQgztjx_kz[0].qtzjlx));
		$("#m_qtzjhm").attr("value",setNull(json.LQgztjx_kz[0].qtzjhm));
		$("#m_ajjbbm").attr("value",setNull(json.LQgztjx_kz[0].ajjbbm));
		$("#m_ajjb").attr("value",setNull(json.LQgztjx_kz[0].ajjb));
		$("#m_ajlbbm").attr("value",setNull(json.LQgztjx_kz[0].ajlbbm));
		$("#m_ajlb").attr("value",setNull(json.LQgztjx_kz[0].ajlb));
		$("#m_jyaq").attr("value",setNull(json.LQgztjx_kz[0].jyaq));
		$("#m_djrq").attr("value",setNull(json.LQgztjx_kz[0].djrq));
		$("#m_djr").attr("value",setNull(json.LQgztjx_kz[0].djr));
		$("#m_ladqbm").attr("value",setNull(json.LQgztjx_kz[0].ladqbm));
		$("#m_ladq").attr("value",setNull(json.LQgztjx_kz[0].ladq));
		$("#m_badwbm").attr("value",setNull(json.LQgztjx_kz[0].badwbm));
		$("#m_badw").attr("value",setNull(json.LQgztjx_kz[0].badw));
		$("#m_tbr").attr("value",setNull(json.LQgztjx_kz[0].tbr));
		$("#m_lxr").attr("value",setNull(json.LQgztjx_kz[0].lxr));
		$("#m_lxfs").attr("value",setNull(json.LQgztjx_kz[0].lxfs));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_qgztjxid","Integer",-9999999999,9999999999,null,0,"全国在逃简项ID"))
			return false;
		if (!checkControlValue("m_bjgzid","Integer",-9999999999,9999999999,null,0,"报警规则ID"))
			return false;
		if (!checkControlValue("m_bjxxid","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("m_qgztjxkzid","Integer",-9999999999,9999999999,null,0,"全国在逃简项快照ID"))
			return false;
		if (!checkControlValue("m_tbbh","String",1,20,null,0,"通报编号"))
			return false;
		if (!checkControlValue("m_xzqhbm","String",1,6,null,0,"行政区划编码"))
			return false;
		if (!checkControlValue("m_xzqh","String",1,100,null,0,"行政区划"))
			return false;
		if (!checkControlValue("m_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("m_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("m_bm","String",1,30,null,0,"别名"))
			return false;
		if (!checkControlValue("m_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("m_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("m_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("m_gmsfhm","String",1,20,null,0,"公民身份号码"))
			return false;
		if (!checkControlValue("m_hjdbm","String",1,6,null,0,"户籍地编码"))
			return false;
		if (!checkControlValue("m_hjd","String",1,300,null,0,"户籍地"))
			return false;
		if (!checkControlValue("m_hjxxdz","String",1,300,null,0,"户籍详细地址"))
			return false;
		if (!checkControlValue("m_xzdqbm","String",1,6,null,0,"现住地区编码"))
			return false;
		if (!checkControlValue("m_xzdq","String",1,300,null,0,"现住地区"))
			return false;
		if (!checkControlValue("m_xzdxxdz","String",1,300,null,0,"现住地详细地址"))
			return false;
		if (!checkControlValue("m_qtzjlx","String",1,20,null,0,"其他证件类型"))
			return false;
		if (!checkControlValue("m_qtzjhm","String",1,20,null,0,"其他证件号码"))
			return false;
		if (!checkControlValue("m_ajjbbm","String",1,2,null,0,"案件级别编码"))
			return false;
		if (!checkControlValue("m_ajjb","String",1,20,null,0,"案件级别"))
			return false;
		if (!checkControlValue("m_ajlbbm","String",1,20,null,0,"案件类别编码"))
			return false;
		if (!checkControlValue("m_ajlb","String",1,60,null,0,"案件类别"))
			return false;
		if (!checkControlValue("m_jyaq","String",1,2000,null,0,"简要案情"))
			return false;
		if (!checkControlValue("m_djrq","Date",null,null,null,0,"登记日期"))
			return false;
		if (!checkControlValue("m_djr","String",1,30,null,0,"登记人"))
			return false;
		if (!checkControlValue("m_ladqbm","String",1,6,null,0,"立案地区编码"))
			return false;
		if (!checkControlValue("m_ladq","String",1,300,null,0,"立案地区"))
			return false;
		if (!checkControlValue("m_badwbm","String",1,20,null,0,"办案单位编码"))
			return false;
		if (!checkControlValue("m_badw","String",1,100,null,0,"办案单位"))
			return false;
		if (!checkControlValue("m_tbr","String",1,100,null,0,"填表人"))
			return false;
		if (!checkControlValue("m_lxr","String",1,100,null,0,"联系人"))
			return false;
		if (!checkControlValue("m_lxfs","String",1,60,null,0,"联系方式"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_qgztjxid">
<input type="hidden" id="m_qgztjxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">全国在逃简项ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_qgztjxid" value="0"></td>
		<td class="distd">报警规则ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bjgzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">报警信息ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bjxxid" value="0"></td>
		<td class="distd">全国在逃简项快照ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_qgztjxkzid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">通报编号</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_tbbh" value=""></td>
		<td class="distd">行政区划编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xzqhbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行政区划</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xzqh" value=""></td>
		<td class="distd">姓名拼音</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xmpy" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xm" value=""></td>
		<td class="distd">别名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">性别代码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xbdm" value=""></td>
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">出生日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_csrq" value=""></td>
		<td class="distd">公民身份号码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_gmsfhm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">户籍地编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_hjdbm" value=""></td>
		<td class="distd">户籍地</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_hjd" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">户籍详细地址</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_hjxxdz" value=""></td>
		<td class="distd">现住地区编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xzdqbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">现住地区</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xzdq" value=""></td>
		<td class="distd">现住地详细地址</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_xzdxxdz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">其他证件类型</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_qtzjlx" value=""></td>
		<td class="distd">其他证件号码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_qtzjhm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">案件级别编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ajjbbm" value=""></td>
		<td class="distd">案件级别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ajjb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">案件类别编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ajlbbm" value=""></td>
		<td class="distd">案件类别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ajlb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">简要案情</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_jyaq" value=""></td>
		<td class="distd">登记日期</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_djrq" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">登记人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_djr" value=""></td>
		<td class="distd">立案地区编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ladqbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">立案地区</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ladq" value=""></td>
		<td class="distd">办案单位编码</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_badwbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">办案单位</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_badw" value=""></td>
		<td class="distd">填表人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_tbr" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">联系人</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_lxr" value=""></td>
		<td class="distd">联系方式</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_lxfs" value=""></td>
	</tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="subDiv" onclick='setUpdate();'><img src="images/submit.gif"  border="0"/></a></td>
	</tr>
</table>
