<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#all_ryid").val(dataid);
		setParams("all_");
		jQuery.post("publicsystem/query_qyryxx.action",params,update_all_div,"json");
		dataid="";
	});

	function update_all_div(json){
		var hylbdm = setNull(json.LQyryxx[0].hylbdm);
		var detail_div_loadHtml;
		if(hylbdm=="E03"){
			detail_div_loadHtml = "basic/publicsystem/QyryxxDetail-dd.jsp";
		}else if(hylbdm=="B"){
			detail_div_loadHtml = "basic/publicsystem/QyryxxDetail-yz.jsp";
		}else if(hylbdm =="N"){
			detail_div_loadHtml = "basic/publicsystem/QyryxxDetail-nb.jsp";
		}else{
			detail_div_loadHtml = "basic/publicsystem/QyryxxDetail.jsp";
		}
		$("#cyryxx_detail_div").load(detail_div_loadHtml,function(){
			updatediv(json);
		});
	}
	
	function Qyryxx_setDetail(){} //杨波加空方法 配合qyjbxxDetail.jsp这个公共的页面 不然报方法找不到
</script>
<input type="hidden" id="all_ryid">
<input type="hidden" id="all_scbz" value="9999">
<div id="cyryxx_detail_div"></div>
