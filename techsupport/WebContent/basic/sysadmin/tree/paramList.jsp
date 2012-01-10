<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script>
$(document).ready(function() {
	paramListQuery();
}); 
function paramListQuery(){
	setParams("v_");
	jQuery.post("sysadmin/queryParamListNoPage_param.action",params,getAllParamList,"json");
}

function getAllParamList(json){
	$("#queryParamList_table").empty();
	if(json.LParam!=null && json.LParam.length>0){
		var paramList = json.LParam;
		var length = paramList.length;
		for(var index=0;index<length;index++){
			var tableHtml = "<tr>";
			tableHtml += "<td height='20' valign='top'><a class='linkOperate' href='#' onclick='fnquery(\""+paramList[index].paramcode+"\")'>"+paramList[index].paramname+"</a></td>";
			tableHtml += "<tr>";
			$("#queryParamList_table").append($(tableHtml));
		}
		
	}
}

</script>

 <table id="queryParamList_table">
</table>