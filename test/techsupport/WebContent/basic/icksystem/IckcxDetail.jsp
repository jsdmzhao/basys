<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	$("#m_ickslid").attr("value",dataid);
	$("#m_ryid").attr("value",delid);
	$("#m_cdxryy").selectBox({code:"dm_ickcxryy"});
}); 

function modifyVerify(){
	if (!checkControlValue("m_cdxryy","Select",1,200,null,1,"重电写入原因"))
		return false;
	return true;
}

function getIckCxr(){
		setUpdate();
}

function updateback(json){
	if  (json.result=="success"){
		jAlert('重写成功','保存信息');
		setPageList($("#pageNo").attr("value"));
		$("#"+detailid).hideAndRemove("slow"); 
	}else{
		jAlert(json.result,'错误信息');
	}		
}

function hideIckCxr(){
	$("#zkxxlb_detail").hideAndRemove("show");
}
</script>
<input type="hidden" id="m_ickslid">
<input type="hidden" id="m_ryid">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
 <tr>
      <td align="left" class="title1" colspan="2">IC卡重电写入原因</td>
    </tr>
</table>
<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" > 
	<tr>
		<td class="distd1">重电写入原因</td>
		<td class="detailtd2"><select id="m_cdxryy"><option></option></select></td>
	</tr>
	<tr height="15"><td align="center" colspan="2">
		<table>
			<tr>
				<td><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='getIckCxr();'>保存</a></td>
				<td><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="关闭" onclick='hideIckCxr();'>关闭</a></td>
			</tr>
		</table>
	</td>
</tr>
</table>