<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_garkktbsjid").attr("value",dataid);
		$("#m_garkktbsjid").attr("value",dataid);
		setDetail();
		$("#m_csrq").attr("readonly","true");
		$("#m_csrq").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_garkktbsjid").attr("value",setNull(json.LGarkktbsj[0].garkktbsjid));
		$("#m_gmsfzhm").attr("value",setNull(json.LGarkktbsj[0].gmsfzhm));
		$("#m_xm").attr("value",setNull(json.LGarkktbsj[0].xm));
		$("#m_xb").attr("value",setNull(json.LGarkktbsj[0].xb));
		$("#m_mz").attr("value",setNull(json.LGarkktbsj[0].mz));
		$("#m_hyzk").attr("value",setNull(json.LGarkktbsj[0].hyzk));
		$("#m_hjsx").attr("value",setNull(json.LGarkktbsj[0].hjsx));
		$("#m_hjdxz").attr("value",setNull(json.LGarkktbsj[0].hjdxz));
		$("#m_csrq").attr("value",setNull(json.LGarkktbsj[0].csrq));
		$("#m_zp").attr("value",setNull(json.LGarkktbsj[0].zp));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_garkktbsjid","Integer",-9999999999,9999999999,null,0,"公安人口库同步数据ID"))
			return false;
		if (!checkControlValue("m_gmsfzhm","String",1,20,null,0,"公民身份证号码"))
			return false;
		if (!checkControlValue("m_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("m_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("m_mz","String",1,30,null,0,"民族"))
			return false;
		if (!checkControlValue("m_hyzk","String",1,4,null,0,"婚姻状况"))
			return false;
		if (!checkControlValue("m_hjsx","String",1,20,null,0,"户籍省县"))
			return false;
		if (!checkControlValue("m_hjdxz","String",1,200,null,0,"户籍地详址"))
			return false;
		if (!checkControlValue("m_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("m_zp","byte[]",,,,0,"照片"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_garkktbsjid">
<input type="hidden" id="m_garkktbsjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改</td>
      <td ><a href="#" id="closeDiv" onclick='$("#Garkktbsj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">公安人口库同步数据ID</td>
		<td class="detailtd"><input type="text" id="m_garkktbsjid" value="0"></td>
		<td class="distd">公民身份证号码</td>
		<td class="detailtd"><input type="text" id="m_gmsfzhm" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">姓名</td>
		<td class="detailtd"><input type="text" id="m_xm" value=""></td>
		<td class="distd">性别</td>
		<td class="detailtd"><input type="text" id="m_xb" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">民族</td>
		<td class="detailtd"><input type="text" id="m_mz" value=""></td>
		<td class="distd">婚姻状况</td>
		<td class="detailtd"><input type="text" id="m_hyzk" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">户籍省县</td>
		<td class="detailtd"><input type="text" id="m_hjsx" value=""></td>
		<td class="distd">户籍地详址</td>
		<td class="detailtd"><input type="text" id="m_hjdxz" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">出生日期</td>
		<td class="detailtd"><input type="text" id="m_csrq" value=""></td>
		<td class="distd">照片</td>
		<td class="detailtd"><input type="text" id="m_zp" value=""></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdate();'>保存</a></td></tr>
</table>
