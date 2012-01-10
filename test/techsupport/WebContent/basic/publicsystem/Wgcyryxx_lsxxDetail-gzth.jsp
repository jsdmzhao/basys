<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#all_rylsid").attr("value",dataid);
		setParams("all_");
		jQuery.post(detailUrl,params,update_all_div,"json");
		dataid="";
	});

	function update_all_div(json){
		var hylbdm = setNull(json.LWgcyryxx[0].hylbdm);
		var detail_div_loadHtml;
		if(hylbdm=="E03"){
			detail_div_loadHtml = "basic/publicsystem/Wgcyryxx_lsxxDetail-dd.jsp";
		}else{
			detail_div_loadHtml = "basic/publicsystem/Wgcyryxx_lsxxDetail.jsp";
		}
		$("#wgcyryxx_lsxx_detail_div").load(detail_div_loadHtml,function(){
			updatediv(json);
		});
	}
</script>
<input type="hidden" id="all_rylsid">
<div id="wgcyryxx_lsxx_detail_div"></div>
