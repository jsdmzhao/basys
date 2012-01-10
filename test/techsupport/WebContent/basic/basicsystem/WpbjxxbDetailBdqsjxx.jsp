<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
	    setParams("m_");
		jQuery.post("basicsystem/query_sjbdqxxkz.action",params,bdqsjkzdiv,"json"); // 提交到SjbdqxxkzAction中,调用其中的query方法
	}); 
		
	function bdqsjkzdiv (json) {
		$("#bd_xzqh").append(setNull(json.LSjbdqxxkz[0].xzqh));
		$("#bd_sjch").append(setNull(json.LSjbdqxxkz[0].sjch));
		$("#bd_pp").append(setNull(json.LSjbdqxxkz[0].pp));
		$("#bd_xh").append(setNull(json.LSjbdqxxkz[0].xh));
		$("#bd_ys").append(setNull(json.LSjbdqxxkz[0].ys));
		$("#bd_ajlb").append(setNull(json.LSjbdqxxkz[0].ajlb));
		$("#bd_jyaq").append(setNull(json.LSjbdqxxkz[0].jyaq));
		$("#bd_djrq").append(setNull(json.LSjbdqxxkz[0].djrq).substr(0,10));
		$("#bd_djr").append(setNull(json.LSjbdqxxkz[0].djr));
		$("#bd_ladq").append(setNull(json.LSjbdqxxkz[0].ladq));
		$("#bd_badw").append(setNull(json.LSjbdqxxkz[0].badw));
		$("#bd_tbr").append(setNull(json.LSjbdqxxkz[0].tbr));
		$("#bd_lxr").append(setNull(json.LSjbdqxxkz[0].lxr));
		$("#bd_lxfs").append(setNull(json.LSjbdqxxkz[0].lxfs));
		$("#bd_lxrsfhm").append(setNull(json.LSjbdqxxkz[0].lxrsfhm));
	}	
</script>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr><td class="queryfont">&nbsp;被盗抢手机简要信息</td></tr>
	<tr><td  class="tdbg">
<table width="100%" border="0" cellspacing="0" cellpadding="2" class="detail">
	<tr height="20">
		<td width="18%" class="distd1">手机串号</td>
		<td width="35%" class="detailtd2" width="190px"><span id="bd_sjch"></span></td>
		<td width="15%" class="distd1">品牌</td>
		<td width="32%" class="detailtd2" width="190px"><span id="bd_pp"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">颜色</td>
		<td class="detailtd2" width="190px"><span id="bd_ys"></span></td>
		<td class="distd1">型号</td>
		<td class="detailtd2" width="190px"><span id="bd_xh"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">行政区划</td>
		<td class="detailtd2" width="190px"><span id="bd_xzqh"></span></td>
		<td class="distd1">立案地区</td>
		<td class="detailtd2" width="190px"><span id="bd_ladq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">案件类别</td>
		<td class="detailtd2" width="190px"><span id="bd_ajlb"></span></td>
		<td class="distd1">办案单位</td>
		<td class="detailtd2" width="190px"><span id="bd_badw"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">填表人</td>
		<td class="detailtd2" width="190px"><span id="bd_tbr"></span></td>
		<td class="distd1">登记人</td>
		<td class="detailtd2" width="190px"><span id="bd_djr"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">联系人</td>
		<td class="detailtd2" width="190px"><span id="bd_lxr"></span></td>
		<td class="distd1">联系人身份号码</td>
		<td class="detailtd2" width="190px"><span id="bd_lxrsfhm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">登记日期</td>
		<td class="detailtd2" colspan="3" width="470px"><span id="bd_djrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">联系方式</td>
		<td class="detailtd2" colspan="3" width="470px"><span id="bd_lxfs"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1" valign="top">简要案情</td>
		<td class="detailtd2" colspan="3" width="470px"><span id="bd_jyaq"></span></td>
	</tr>
</table>
        </td>
    </tr>
</table>