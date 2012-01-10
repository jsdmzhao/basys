<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_tbid").attr("value",dataid);
		$("#m_tbid").attr("value",dataid);
		setDetail();
		$("#m_hfsj").attr("readonly","true");
		$("#m_hfsj").datepicker();
	}); 
	function updatediv (json) { 
		$("#m_tbid").attr("value",setNull(json.LXctbhf[0].tbid));
		$("#m_jsdwid").attr("value",setNull(json.LXctbhf[0].jsdwid));
		$("#m_hfid").attr("value",setNull(json.LXctbhf[0].hfid));
		$("#m_hfsj").attr("value",setNull(json.LXctbhf[0].hfsj));
		$("#m_hfnr").attr("value",setNull(json.LXctbhf[0].hfnr));
		$("#m_hfr").attr("value",setNull(json.LXctbhf[0].hfr));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_tbid","Integer",-9999999999,9999999999,null,0,"通报ID"))
			return false;
		if (!checkControlValue("m_jsdwid","Integer",-9999999999,9999999999,null,0,"接收单位ID"))
			return false;
		if (!checkControlValue("m_hfid","Integer",-9999999999,9999999999,null,0,"回复ID"))
			return false;
		if (!checkControlValue("m_hfsj","Date",null,null,null,0,"回复时间"))
			return false;
		if (!checkControlValue("m_hfnr","String",1,2000,null,0,"回复内容"))
			return false;
		if (!checkControlValue("m_hfr","String",1,100,null,0,"回复人"))
			return false;
		return true;
	}
</script>
<input type="hidden" id="q_tbid">
<input type="hidden" id="m_tbid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">撤销</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" id="modify">
	<tr height="20">
		<td class="distd">人员姓名</td>
		<td class="detailtd"><span type="text" id="m_tbid" value="0"></span></td>
  </tr>
	<tr height="20">
		<td class="distd">身份证号码</td>
		<td class="detailtd"><span type="text" id="m_hfid" value="0"></span></td>
  </tr>
	<tr height="20">
		<td class="distd">注销原因</td>
		<td class="detailtd"><input type="text" class="inputstyle"  id="m_hfnr" value=""></td>
  </tr>
	<tr align="center">
		<td >
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="保存" onclick='xbjUpdate();'>保存</a>
		</td>
		<td >
			<a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="打印" onclick='setAdd();'>取消</a>
		</td>
	</tr>
</table>
