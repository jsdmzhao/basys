<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_kyqkid").attr("value",dataid);
		setDetail();
	}); 
	function updatediv (json) { 
		$("#djxh").append(setNull(json.LKyqk[0].kyqkdjxh));
		$("#kyqklx").append(setNull(json.LKyqk[0].kyqklx));
		$("#bgsj").append(setNull(json.LKyqk[0].tbsj));
		$("#bgrbh").append(setNull(json.LKyqk[0].tbrbh));
		$("#bgrxm").append(setNull(json.LKyqk[0].tbrxm));
		$("#ydxxms").attr("value",setNull(json.LKyqk[0].ydxxms));
		$("#jjrxm").append(setNull(json.LKyqk[0].jjrxm));
		$("#jjsj").append(setNull(json.LKyqk[0].jjsj));
		$("#jjcljg").attr("value",setNull(json.LKyqk[0].jjcljg));
	}	
</script>
<input type="hidden" id="q_kyqkid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">可疑情况详细信息</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#kyqk_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td width="20%" class="distd1">可疑情况登记序号</td>
		<td width="65%" class="detailtd2" colspan="3"><span  style="word-break : break-all; width:100px;"
		 id="djxh"></span></td>
		<td width="15%" class="distd1">可疑情况类型</td>
		<td width="25%" class="detailtd2"><span id="kyqklx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1" width="20%" >填报人编号</td>
		<td class="detailtd2" width="35%"><span id="bgrbh" style="word-break : break-all; width:100px;"></span></td>
	  <td class="distd1" width="8%">填报人姓名</td>
	  <td  class="detailtd2" width="12%"><span id="bgrxm" style="word-break : break-all; width:50px;"></span></td>
	  <td width="10%" class="distd1">填报时间</td>
		<td width="25%" class="detailtd2"><span id="bgsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">疑点详细描述</td>
		<td colspan="5" class="detailtd2">
		  <textarea name="textarea" id="ydxxms"  cols="68" rows="5" readonly="true" ></textarea>    </td>
	</tr>
	<tr height="20">
	  <td class="distd1" width="10%">接警人姓名</td>
	  <td  class="detailtd2" width="15%"><span id="jjrxm"></span></td>
	  <td width="10%" class="distd1">接警时间</td>
	  <td width="40%" class="detailtd2" colspan="3"><span id="jjsj"></span></td>
	</tr>
	<tr height="20">
		<td valign="top" class="distd1">接警处理结果</td>
<td colspan="5" class="detailtd2">
		  <textarea name="textarea" id="jjcljg"  cols="68" rows="5" readonly="true" ></textarea>    </td>
	</tr>
</table>
