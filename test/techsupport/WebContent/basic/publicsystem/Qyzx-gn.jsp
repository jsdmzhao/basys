<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_qyid").attr("value",qyjbxx_dataid);
		$("#manbq_zxyy").selectBox({code:"dm_zxyy(ylcs)"});
		qyjbxx_zxsetDetail();
	});
	function qyjbxx_zxupdatediv(json){
		$("#zx_qybm").append(setNull(json.LQyjbxx[0].qybm));
		$("#zx_qymc").append(setNull(json.LQyjbxx[0].qymc));
		
		$("#m_qyid").attr("value",setNull(json.LQyjbxx[0].qyid));
	}
	function manzxyyOnchange(){ //注销原因
		var zxyy = $("#manbq_zxyy").attr("title");
		$("#m_zxyy").attr("value",zxyy);
	}
	function qyjbxx_zxmodifyVerify(){
		var zxyy = $("#m_zxyy").attr("value");
		if(zxyy==null||zxyy==''||zxyy=='null'){
			jAlert('请选择注销原因','提示信息',null,"div_manbq_zxyy");
			return false;
		}
		return true;
	}
</script>
</head>

<body>
<input type="hidden" id="q_qyid">
<input type="hidden" id="m_qyid">
<input type="hidden" id="m_zxyy">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">企业注销</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#qyjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="2"></td>
		</tr>
	</table>
<table width="100%" border="0" cellspacing="0" cellpadding="2" class="detail">
  <tr>
    <td width="35%" class="distd1">企业名称</td>
    <td width="65%" class="detailtd2"><span type="text" id="zx_qymc"></span></td>
  </tr>
  <tr>
    <td class="distd1">企业编码</td>
    <td class="detailtd2"><span type="text" id="zx_qybm"></span></td>
  </tr>
  <tr>
    <td class="red">注销原因</td>
    <td class="detailtd2"><select name="select" id="manbq_zxyy" onchange="manzxyyOnchange();">
	<option></option></select></td>
  </tr>
  <tr>
    <td colspan="2"><a href="#" hidefocus="true" class="submitbutton" title="注销保存" onclick='qyjbxx_zhuxiao();'>保存</a></td>
  </tr>
</table>
</body>
</html>
