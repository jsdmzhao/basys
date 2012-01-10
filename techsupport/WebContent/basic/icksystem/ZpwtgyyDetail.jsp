<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	$("#a_ickslid").attr("value",dataid);
	$("#a_zpwtgyy").focus();
}); 

function wtgyyAddValidate(){
	if (!checkControlValue("a_zpwtgyy","String",1,200,null,1,"未通过原因"))
		return false;
	return true;
}

function getWtgyy(){
	if(wtgyyAddValidate()){	
		set_ryzpwtgyy_dataXml($("#a_ickslid").val());
		$("#zpyy_detail").hideAndRemove("show");
		$("#zpyy_detail").empty();
	}
}

function hideZpwtgyy(){
	$("#checkbox_"+dataid).attr("checked",false);
	$("#zpyy_detail").hideAndRemove("show");
	$("#zpyy_detail").empty();
}
</script>
<input type="hidden" id="a_ickslid">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
 <tr>
      <td align="left" class="title1" colspan="2">照片未通过原因</td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" > 
	<tr height="40">
		<td class="distd1" valign="top">未通过原因</td>
		<td class="detailtd2"><textarea id="a_zpwtgyy"></textarea></td>
	</tr>
	<tr height="15"><td align="center" colspan="2">
		<table>
			<tr>
				<td><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='getWtgyy();'>保存</a></td>
				<td><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="关闭" onclick='hideZpwtgyy();'>关闭</a></td>
			</tr>
		</table>
	</td>
</tr>
</table>