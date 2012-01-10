<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_yjgzid").attr("value",dataid);
		$("#m_yjgzid").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#m_yjgzid").attr("value",setNull(json.LYjgz[0].yjgzid));
		$("#m_ywbm").attr("value",setNull(json.LYjgz[0].ywbm));
		$("#m_bdbm").attr("value",setNull(json.LYjgz[0].bdbm));
		$("#m_bdlx").attr("value",setNull(json.LYjgz[0].bdlx));
		$("#m_sfyx").attr("value",setNull(json.LYjgz[0].sfyx));
		$("#m_fbcl").attr("value",setNull(json.LYjgz[0].fbcl));
		$("#m_fbfs").attr("value",setNull(json.LYjgz[0].fbfs));
		$("#m_txdwzd").attr("value",setNull(json.LYjgz[0].txdwzd));
		$("#m_gxdwzd").attr("value",setNull(json.LYjgz[0].gxdwzd));
		$("#m_yjjb").attr("value",setNull(json.LYjgz[0].yjjb));
		$("#m_yjfs").attr("value",setNull(json.LYjgz[0].yjfs));
		$("#m_yjlx").attr("value",setNull(json.LYjgz[0].yjlx));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_yjgzid","Integer",-9999999999,9999999999,null,0,"预警规则ID"))
			return false;
		if (!checkControlValue("m_ywbm","String",1,100,null,0,"业务表名"))
			return false;
		if (!checkControlValue("m_bdbm","String",1,100,null,0,"比对表名"))
			return false;
		if (!checkControlValue("m_bdlx","String",1,2,null,0,"比对类型"))
			return false;
		if (!checkControlValue("m_sfyx","String",1,2,null,0,"是否有效"))
			return false;
		if (!checkControlValue("m_fbcl","String",1,300,null,0,"发布策略"))
			return false;
		if (!checkControlValue("m_fbfs","String",1,2,null,0,"发布方式"))
			return false;
		if (!checkControlValue("m_txdwzd","String",1,60,null,0,"特行单位字段"))
			return false;
		if (!checkControlValue("m_gxdwzd","String",1,60,null,0,"管辖单位字段"))
			return false;
		if (!checkControlValue("m_yjjb","String",1,2,null,0,"预警级别"))
			return false;
		if (!checkControlValue("m_yjfs","String",1,60,null,0,"预警方式"))
			return false;
		if (!checkControlValue("m_yjlx","String",1,60,null,0,"预警类型"))
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
		<td class="distd">业务表名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ywbm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">比对表名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bdbm" value=""></td>
		<td class="distd">比对类型</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bdlx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">是否有效</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_sfyx" value=""></td>
		<td class="distd">发布策略</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_fbcl" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发布方式</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_fbfs" value=""></td>
		<td class="distd">特行单位字段</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_txdwzd" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">管辖单位字段</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_gxdwzd" value=""></td>
		<td class="distd">预警级别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_yjjb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">预警方式</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_yjfs" value=""></td>
		<td class="distd">预警类型</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_yjlx" value=""></td>
	</tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="subDiv" onclick='setUpdate();'><img src="images/submit.gif"  border="0"/></a></td>
	</tr>
</table>
