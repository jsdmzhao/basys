<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script>
$(document).ready(function() {
	dictListQuery();
}); 
function dictListQuery(){
	setParams("v_");
	jQuery.post("sysadmin/queryDictListNoPage_dict.action",params,getAllDictList,"json");
}

function getAllDictList(json){
	$("#queryDictList_table").empty();
	if(json.LDict!=null && json.LDict.length>0){
		var dictList = json.LDict;
		var length = dictList.length;
		for(var index=0;index<length;index++){
			var tableHtml = "<tr>";
			tableHtml += "<td height='20' valign='top'><a class='linkOperate' href='#' onclick='fnquery(\""+dictList[index].dict_code+"\",\""+dictList[index].dict_type+"\")'>"+dictList[index].dict_name+"</a></td>";
			tableHtml += "<tr>";
			$("#queryDictList_table").append($(tableHtml));
		}
		
	}
}

</script>
 <table id="queryDictList_table">
</table>