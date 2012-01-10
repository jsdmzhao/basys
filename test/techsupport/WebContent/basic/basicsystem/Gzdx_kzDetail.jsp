<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_gzdxid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#gzdxid").append(setNull(json.LGzdx_kz[0].gzdxid));
		$("#yjgzid").append(setNull(json.LGzdx_kz[0].yjgzid));
		$("#yjxxid").append(setNull(json.LGzdx_kz[0].yjxxid));
		$("#gzdxkzid").append(setNull(json.LGzdx_kz[0].gzdxkzid));
		$("#xm").append(setNull(json.LGzdx_kz[0].xm));
		$("#bm").append(setNull(json.LGzdx_kz[0].bm));
		$("#xmpy").append(setNull(json.LGzdx_kz[0].xmpy));
		$("#mzdm").append(setNull(json.LGzdx_kz[0].mzdm));
		$("#minzu").append(setNull(json.LGzdx_kz[0].minzu));
		$("#xbdm").append(setNull(json.LGzdx_kz[0].xbdm));
		$("#xb").append(setNull(json.LGzdx_kz[0].xb));
		$("#csrq").append(setNull(json.LGzdx_kz[0].csrq));
		$("#hjdxzqh").append(setNull(json.LGzdx_kz[0].hjdxzqh));
		$("#hjdxzqhdm").append(setNull(json.LGzdx_kz[0].hjdxzqhdm));
		$("#hjdxz").append(setNull(json.LGzdx_kz[0].hjdxz));
		$("#cyzjdm").append(setNull(json.LGzdx_kz[0].cyzjdm));
		$("#cyzj").append(setNull(json.LGzdx_kz[0].cyzj));
		$("#zjhm").append(setNull(json.LGzdx_kz[0].zjhm));
		$("#whcd").append(setNull(json.LGzdx_kz[0].whcd));
		$("#gzdxsf").append(setNull(json.LGzdx_kz[0].gzdxsf));
		$("#shengao").append(setNull(json.LGzdx_kz[0].shengao));
		$("#xzdq").append(setNull(json.LGzdx_kz[0].xzdq));
		$("#xzdqxz").append(setNull(json.LGzdx_kz[0].xzdqxz));
		$("#tbdw").append(setNull(json.LGzdx_kz[0].tbdw));
		$("#tbr").append(setNull(json.LGzdx_kz[0].tbr));
		$("#tbrq").append(setNull(json.LGzdx_kz[0].tbrq));
		$("#tbdabm").append(setNull(json.LGzdx_kz[0].tbdabm));
		$("#zxbz").append(setNull(json.LGzdx_kz[0].zxbz));
		$("#zxrq").append(setNull(json.LGzdx_kz[0].zxrq));
		$("#zxr").append(setNull(json.LGzdx_kz[0].zxr));
		$("#bz").append(setNull(json.LGzdx_kz[0].bz));
	}	
</script>
<input type="hidden" id="q_gzdxid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="detailtd2">关注对象ID</td>
		<td class="detailtd1"><span id="gzdxid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">预警规则ID</td>
		<td class="detailtd1"><span id="yjgzid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">预警信息ID</td>
		<td class="detailtd1"><span id="yjxxid"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">关注对象快照ID</td>
		<td class="detailtd1"><span id="gzdxkzid"></span></td>
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
		<td class="detailtd2">姓名拼音</td>
		<td class="detailtd1"><span id="xmpy"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">民族代码</td>
		<td class="detailtd1"><span id="mzdm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">民族</td>
		<td class="detailtd1"><span id="minzu"></span></td>
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
		<td class="detailtd2">户籍地行政区划</td>
		<td class="detailtd1"><span id="hjdxzqh"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">户籍地行政区划代码</td>
		<td class="detailtd1"><span id="hjdxzqhdm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">户籍地详址</td>
		<td class="detailtd1"><span id="hjdxz"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">常用证件代码</td>
		<td class="detailtd1"><span id="cyzjdm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">常用证件</td>
		<td class="detailtd1"><span id="cyzj"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">证件号码</td>
		<td class="detailtd1"><span id="zjhm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">文化程度</td>
		<td class="detailtd1"><span id="whcd"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">关注对象身份</td>
		<td class="detailtd1"><span id="gzdxsf"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">身高</td>
		<td class="detailtd1"><span id="shengao"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">现住地区</td>
		<td class="detailtd1"><span id="xzdq"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">现住地区祥址</td>
		<td class="detailtd1"><span id="xzdqxz"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">填报单位</td>
		<td class="detailtd1"><span id="tbdw"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">填表人</td>
		<td class="detailtd1"><span id="tbr"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">填报日期</td>
		<td class="detailtd1"><span id="tbrq"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">填报单位编码</td>
		<td class="detailtd1"><span id="tbdabm"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">注销标志</td>
		<td class="detailtd1"><span id="zxbz"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">注销日期</td>
		<td class="detailtd1"><span id="zxrq"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">注销人</td>
		<td class="detailtd1"><span id="zxr"></span></td>
	</tr>
	<tr height="20">
		<td class="detailtd2">备注</td>
		<td class="detailtd1"><span id="bz"></span></td>
	</tr>
</table>