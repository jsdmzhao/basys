<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_ryid").attr("value",dataid);
		$("#m_ryid").attr("value",dataid);
		setDetail();
 		$("#m_zxyy").selectBox({code:"dm_zxyy(cyry)"});
	}); 
	function updatediv(json) { 
		$("#m_cyrybh").attr("value",setNull(json.LQyryxx[0].cyrybh));
		$("#m_qyid").attr("value",setNull(json.LQyryxx[0].qyid));
		$("#xm").append(setNull(json.LQyryxx[0].xm));
		$("#zjhm").append(setNull(json.LQyryxx[0].zjhm));
	}	
	function modifyVerify(){
		if (!checkControlValue("m_zxyy","Select",1,20,null,1,"注销原因"))
			return false;
		return true;
	}	
	
function setUpdateZxry(){
	if (modifyVerify()){
		setParams("m_");
		jQuery.post(modUrl,params,updatebackry,"json"); 
		return true;
	}else{
		return false;
	}		
}

function updatebackry(json){
	if  (json.result=="success"){
		jAlert("注销成功！",'提示信息');
		setPageList($("#pageNo").attr("value"));
		$("#"+detailid).hideAndRemove("slow"); 
	}else{
		jAlert(json.result,'错误信息');
	}		
}
	
</script>
<input type="hidden" id="q_ryid">
<input type="hidden" id="m_ryid">
<input type="hidden" id="m_cyrybh">
<input type="hidden" id="m_qyid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">注销</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#cyryxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="4" cellspacing="0" class="detail" id="detail">
	<tr height="20">
		<td width="20%" class="distd1">人员姓名</td>
		<td width="80%" class="detailtd2"><span id="xm"></span></td>
  </tr>
	<tr height="20">
		<td class="distd1">身份证号码</td>
		<td class="detailtd2"><span id="zjhm"></span></td>
  </tr>
	<tr height="20">
		<td class="red">注销原因</td>
		<td class="detailtd2"><select id="m_zxyy"><option></option></select></td>
  </tr>
	<tr align="center">
		<td colspan="2"  align="right"><table width="60" border="0" align="center" cellpadding="2" cellspacing="0">
          <tr>
            <td><a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				title="保存" onclick='setUpdateZxry();'>保存</a></td>
            <td><a href="#" id="addbutton2" hidefocus="true" class="submitbutton"
				title="取消" onclick='$(&quot;#cyryxx_detail&quot;).hideAndRemove(&quot;show&quot;);'>取消</a></td>
          </tr>
        </table></td>
  </tr>
</table>
