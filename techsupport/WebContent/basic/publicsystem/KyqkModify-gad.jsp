<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		bc_bottonMoveRight(); //将保存按钮右移
		$("#q_kyqkid").attr("value",dataid);
		$("#m_kyqkid").attr("value",dataid);
		setDetail();
		$("#m_jjsj").attr("readonly","true");
	    $("#m_jjsj").datepicker(true);
	    
	}); 
	function updatediv (json) { 
		$("#djxh").append(setNull(json.LKyqk[0].kyqkdjxh));
		$("#kyqklx").append(setNull(json.LKyqk[0].kyqklx));
		$("#bgsj").append(setNull(json.LKyqk[0].tbsj));
		$("#s_bgsj").val(setNull(json.LKyqk[0].tbsj));
		$("#bgrbh").append(setNull(json.LKyqk[0].tbrbh));
		$("#bgrxm").append(setNull(json.LKyqk[0].tbrxm));
		$("#ydxxms").attr("value",setNull(json.LKyqk[0].ydxxms));
		$("#m_jjrxm").attr("value",setNull(json.LKyqk[0].jjrxm));
		$("#m_jjsj").attr("value",setNull(json.LKyqk[0].jjsj));
		$("#m_jjcljg").attr("value",setNull(json.LKyqk[0].jjcljg));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_jjrxm","String",1,100,null,1,"接警人姓名"))
			return false;
		
		if (!checkControlValue("m_jjsj","Datetime",null,null,null,1,"接警时间"))
			return false;
	
		if (!checkControlValue("m_jjcljg","String",1,2000,null,1,"接警处理结果"))
			return false;
	  	if (!checkDateEarlier("s_bgsj","填报时间","s_jjsj","接警时间","DATE"))
			return false;
		return true;
	}
	$('#m_jjsj').change(function(){
		$('#s_jjsj').val($('#m_jjsj').val().substring(0,10));
		$('#s_bgsj').val($('#s_bgsj').val().substring(0,10));
	});
</script>
<input type="hidden" id="q_kyqkid">
<input type="hidden" id="m_kyqkid">
<input type="hidden" id="s_bgsj">
<input type="hidden" id="s_jjsj">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">可疑情况处理</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#kyqk_detail").hideAndRemove("show");'class="close"></a>
      </td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr height="20">
		<td class="distd1" width="20%">可疑情况登记序号</td>
		<td class="detailtd2" width="30%" style="width: 150px;"><span id="djxh"></span></td>
		<td class="distd1" width="20%">可疑情况类型</td>
		<td colspan="3"  width="30%"style="width: 100px;"class="detailtd2"><span id="kyqklx"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1" >填报人编号</td>
		<td class="detailtd2"  ><span id="bgrbh"></span></td>
	  <td class="distd1"  >填报人姓名</td>
	  <td  class="detailtd2" style="width: 50px;" width="14%"><span id="bgrxm"></span></td>
	  <td   class="distd1">填报时间</td>
		<td   style="width: 200px;" class="detailtd2"><span id="bgsj"></span></td>
	</tr>
	<tr height="20">
		<td class="distd1">疑点详细描述</td>
		<td colspan="5" class="detailtd2">
		  <textarea name="textarea" id="ydxxms"  cols="70" rows="5" readonly="true" ></textarea>    </td>
	</tr>
	
	<tr height="20">
	  <td class="red" >接警人姓名</td>
	  <td  class="detailtd"><input type="text" class="inputstyle" value="" id="m_jjrxm" /></td>
	  <td class="red">接警时间</td>
	  <td class="detailtd" colspan="3"><input type="text" class="inputstyle" value=""  id="m_jjsj" /></td>
	</tr>
	<tr height="20">
		<td valign="top" class="red">接警处理结果</td>
<td colspan="5" class="detailtd">
		  <textarea name="textarea2" id="m_jjcljg"  cols="70" rows="5"></textarea>    </td>
	</tr>
	<tr height="25" align="center"><td colspan="6"><a href="#" id="addbutton"  class="submitbutton"  onclick='setUpdate();'>保存</a></td></tr>
</table>
