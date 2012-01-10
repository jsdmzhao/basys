<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#all_ryid").val(dataid);
		setParams("all_");
		jQuery.post(detailUrl,params,update_all_div,"json");
	});

	function update_all_div(json){
		var hylbdm = setNull(json.LWgcyryxx[0].hylbdm);
		var modify_div_loadHtml;
		if(hylbdm=="E03"){
			modify_div_loadHtml = "basic/publicsystem/WgcyryxxModify-gad-dd.jsp";
		}else if(hylbdm=="N"){
			modify_div_loadHtml = "basic/publicsystem/WgcyryxxModify-gad-nb.jsp";
		}else{
			modify_div_loadHtml = "basic/publicsystem/WgcyryxxModify-gad.jsp";
		}
		$("#wgcyryxx_Modify_div").load(modify_div_loadHtml,function(){
			updatediv(json);
		});
	}

	function setUpdate_cyry(){
		if (modifyVerify()){
			setParams("m_");
			jQuery.post(modUrl,params,updateback,"json");
		}	
	}	
	
</script>
<input type="hidden" id="all_ryid">
<div id="wgcyryxx_Modify_div"></div>
