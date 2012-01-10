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
		$("#m_yjgzid").attr("value",setNull(json.LYjbdtj[0].yjgzid));
		$("#m_yjbdtjid").attr("value",setNull(json.LYjbdtj[0].yjbdtjid));
		$("#m_tjlx").attr("value",setNull(json.LYjbdtj[0].tjlx));
		$("#m_ywbzdm").attr("value",setNull(json.LYjbdtj[0].ywbzdm));
		$("#m_bdbzdm").attr("value",setNull(json.LYjbdtj[0].bdbzdm));
		$("#m_bdgx").attr("value",setNull(json.LYjbdtj[0].bdgx));
		$("#m_gxc").attr("value",setNull(json.LYjbdtj[0].gxc));
		$("#m_zxsx").attr("value",setNull(json.LYjbdtj[0].zxsx));
		$("#m_ljgx").attr("value",setNull(json.LYjbdtj[0].ljgx));
		$("#m_jibie").attr("value",setNull(json.LYjbdtj[0].jibie));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_yjgzid","Integer",-9999999999,9999999999,null,0,"预警规则ID"))
			return false;
		if (!checkControlValue("m_yjbdtjid","Integer",-9999999999,9999999999,null,0,"预警比对条件ID"))
			return false;
		if (!checkControlValue("m_tjlx","String",1,2,null,0,"条件类型"))
			return false;
		if (!checkControlValue("m_ywbzdm","String",1,60,null,0,"业务表字段名"))
			return false;
		if (!checkControlValue("m_bdbzdm","String",1,60,null,0,"比对表字段名"))
			return false;
		if (!checkControlValue("m_bdgx","String",1,20,null,0,"比对关系"))
			return false;
		if (!checkControlValue("m_gxc","String",1,200,null,0,"关系串"))
			return false;
		if (!checkControlValue("m_zxsx","String",1,100,null,0,"执行顺序"))
			return false;
		if (!checkControlValue("m_ljgx","String",1,100,null,0,"逻辑关系"))
			return false;
		if (!checkControlValue("m_jibie","Integer",-999999,999999,null,0,"级别"))
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
		<td class="distd">预警比对条件ID</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_yjbdtjid" value="0"></td>
	</tr>
	<tr height="20">
		<td class="distd">条件类型</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_tjlx" value=""></td>
		<td class="distd">业务表字段名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ywbzdm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">比对表字段名</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bdbzdm" value=""></td>
		<td class="distd">比对关系</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_bdgx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">关系串</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_gxc" value=""></td>
		<td class="distd">执行顺序</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_zxsx" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">逻辑关系</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_ljgx" value=""></td>
		<td class="distd">级别</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_jibie" value="0"></td>
	</tr>
	<tr height="25" align="center">
		<td colspan="4"><a href="#" id="subDiv" onclick='setUpdate();'><img src="images/submit.gif"  border="0"/></a></td>
	</tr>
</table>
