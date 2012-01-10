<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		daggleDiv(detailid);
		$("#q_garkktbsjid").attr("value",dataid);
			setDetail();
	}); 
	
	
		
	function updatediv (json) { 
		$("#garkktbsjid").append(setNull(json.LGarkktbsj[0].garkktbsjid));
		$("#gmsfzhm").append(setNull(json.LGarkktbsj[0].gmsfzhm));
		$("#xm").append(setNull(json.LGarkktbsj[0].xm));
		$("#xb").append(setNull(json.LGarkktbsj[0].xb));
		$("#mz").append(setNull(json.LGarkktbsj[0].mz));
		$("#hyzk").append(setNull(json.LGarkktbsj[0].hyzk));
		$("#hjsx").append(setNull(json.LGarkktbsj[0].hjsx));
		$("#hjdxz").append(setNull(json.LGarkktbsj[0].hjdxz));
		$("#csrq").append(setNull(json.LGarkktbsj[0].csrq));
		$("#zp").append(setNull(json.LGarkktbsj[0].zp));
	}	
</script>
<input type="hidden" id="q_garkktbsjid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">明细</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#Garkktbsj_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="3" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td class="distd1">公安人口库同步数据ID</td>
		<td class="detailtd2"><span id="garkktbsjid"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">公民身份证号码</td>
		<td class="detailtd2"><span id="gmsfzhm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">姓名</td>
		<td class="detailtd2"><span id="xm"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">性别</td>
		<td class="detailtd2"><span id="xb"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">民族</td>
		<td class="detailtd2"><span id="mz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">婚姻状况</td>
		<td class="detailtd2"><span id="hyzk"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">户籍省县</td>
		<td class="detailtd2"><span id="hjsx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">户籍地详址</td>
		<td class="detailtd2"><span id="hjdxz"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">出生日期</td>
		<td class="detailtd2"><span id="csrq"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">照片</td>
		<td class="detailtd2"><span id="zp"></span></td>
	</tr>
</table>