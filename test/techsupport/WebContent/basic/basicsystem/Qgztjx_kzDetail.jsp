<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qgztjxid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#qgztjxid").append(setNull(json.LQgztjx_kz[0].qgztjxid));
		$("#bjgzid").append(setNull(json.LQgztjx_kz[0].bjgzid));
		$("#bjxxid").append(setNull(json.LQgztjx_kz[0].bjxxid));
		$("#qgztjxkzid").append(setNull(json.LQgztjx_kz[0].qgztjxkzid));
		$("#tbbh").append(setNull(json.LQgztjx_kz[0].tbbh));
		$("#xzqhbm").append(setNull(json.LQgztjx_kz[0].xzqhbm));
		$("#xzqh").append(setNull(json.LQgztjx_kz[0].xzqh));
		$("#xmpy").append(setNull(json.LQgztjx_kz[0].xmpy));
		$("#xm").append(setNull(json.LQgztjx_kz[0].xm));
		$("#bm").append(setNull(json.LQgztjx_kz[0].bm));
		$("#xbdm").append(setNull(json.LQgztjx_kz[0].xbdm));
		$("#xb").append(setNull(json.LQgztjx_kz[0].xb));
		$("#csrq").append(setNull(json.LQgztjx_kz[0].csrq));
		$("#gmsfhm").append(setNull(json.LQgztjx_kz[0].gmsfhm));
		$("#hjdbm").append(setNull(json.LQgztjx_kz[0].hjdbm));
		$("#hjd").append(setNull(json.LQgztjx_kz[0].hjd));
		$("#hjxxdz").append(setNull(json.LQgztjx_kz[0].hjxxdz));
		$("#xzdqbm").append(setNull(json.LQgztjx_kz[0].xzdqbm));
		$("#xzdq").append(setNull(json.LQgztjx_kz[0].xzdq));
		$("#xzdxxdz").append(setNull(json.LQgztjx_kz[0].xzdxxdz));
		$("#qtzjlx").append(setNull(json.LQgztjx_kz[0].qtzjlx));
		$("#qtzjhm").append(setNull(json.LQgztjx_kz[0].qtzjhm));
		$("#ajjbbm").append(setNull(json.LQgztjx_kz[0].ajjbbm));
		$("#ajjb").append(setNull(json.LQgztjx_kz[0].ajjb));
		$("#ajlbbm").append(setNull(json.LQgztjx_kz[0].ajlbbm));
		$("#ajlb").append(setNull(json.LQgztjx_kz[0].ajlb));
		$("#jyaq").append(setNull(json.LQgztjx_kz[0].jyaq));
		$("#djrq").append(setNull(json.LQgztjx_kz[0].djrq));
		$("#djr").append(setNull(json.LQgztjx_kz[0].djr));
		$("#ladqbm").append(setNull(json.LQgztjx_kz[0].ladqbm));
		$("#ladq").append(setNull(json.LQgztjx_kz[0].ladq));
		$("#badwbm").append(setNull(json.LQgztjx_kz[0].badwbm));
		$("#badw").append(setNull(json.LQgztjx_kz[0].badw));
		$("#tbr").append(setNull(json.LQgztjx_kz[0].tbr));
		$("#lxr").append(setNull(json.LQgztjx_kz[0].lxr));
		$("#lxfs").append(setNull(json.LQgztjx_kz[0].lxfs));
	}	
</script>
<input type="hidden" id="q_qgztjxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="detailtd2">全国在逃简项ID</td>
		<td class="detailtd1"><span id="qgztjxid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">报警规则ID</td>
		<td class="detailtd1"><span id="bjgzid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">报警信息ID</td>
		<td class="detailtd1"><span id="bjxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">全国在逃简项快照ID</td>
		<td class="detailtd1"><span id="qgztjxkzid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">通报编号</td>
		<td class="detailtd1"><span id="tbbh"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">行政区划编码</td>
		<td class="detailtd1"><span id="xzqhbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">行政区划</td>
		<td class="detailtd1"><span id="xzqh"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">姓名拼音</td>
		<td class="detailtd1"><span id="xmpy"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">姓名</td>
		<td class="detailtd1"><span id="xm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">别名</td>
		<td class="detailtd1"><span id="bm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">性别代码</td>
		<td class="detailtd1"><span id="xbdm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">性别</td>
		<td class="detailtd1"><span id="xb"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">出生日期</td>
		<td class="detailtd1"><span id="csrq"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">公民身份号码</td>
		<td class="detailtd1"><span id="gmsfhm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">户籍地编码</td>
		<td class="detailtd1"><span id="hjdbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">户籍地</td>
		<td class="detailtd1"><span id="hjd"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">户籍详细地址</td>
		<td class="detailtd1"><span id="hjxxdz"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">现住地区编码</td>
		<td class="detailtd1"><span id="xzdqbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">现住地区</td>
		<td class="detailtd1"><span id="xzdq"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">现住地详细地址</td>
		<td class="detailtd1"><span id="xzdxxdz"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">其他证件类型</td>
		<td class="detailtd1"><span id="qtzjlx"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">其他证件号码</td>
		<td class="detailtd1"><span id="qtzjhm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">案件级别编码</td>
		<td class="detailtd1"><span id="ajjbbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">案件级别</td>
		<td class="detailtd1"><span id="ajjb"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">案件类别编码</td>
		<td class="detailtd1"><span id="ajlbbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">案件类别</td>
		<td class="detailtd1"><span id="ajlb"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">简要案情</td>
		<td class="detailtd1"><span id="jyaq"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">登记日期</td>
		<td class="detailtd1"><span id="djrq"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">登记人</td>
		<td class="detailtd1"><span id="djr"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">立案地区编码</td>
		<td class="detailtd1"><span id="ladqbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">立案地区</td>
		<td class="detailtd1"><span id="ladq"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">办案单位编码</td>
		<td class="detailtd1"><span id="badwbm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">办案单位</td>
		<td class="detailtd1"><span id="badw"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">填表人</td>
		<td class="detailtd1"><span id="tbr"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">联系人</td>
		<td class="detailtd1"><span id="lxr"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">联系方式</td>
		<td class="detailtd1"><span id="lxfs"></span></td>
	</tr>
</table>