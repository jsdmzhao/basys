<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
var detailBalanceUrl="publicsystem/queryLsBalance_qyryxx.action";
var detailLsUrl="publicsystem/queryLs_qyryxx.action";
	$(document).ready(function() {
		$("#all_rylsid").attr("value",dataid);
		$("#all_ryid").attr("value",$("#q_ryid").val());
		setParams("all_");
		jQuery.post(detailBalanceUrl,params,update_all_div,"json");
	});

	function update_all_div(json){
		var hylbdm = setNull(json.LQyryxx_lsxx[0].hylbdm);
		var detail_div_loadHtml;
		if(hylbdm=="E03"){
			detail_div_loadHtml = "basic/publicsystem/QyrylsxxDetail-gn-dd.jsp";
		}else if(hylbdm=="B"){
			detail_div_loadHtml = "basic/publicsystem/QyrylsxxDetail-gn-yz.jsp";
		}else{
			detail_div_loadHtml = "basic/publicsystem/QyrylsxxDetail-gn.jsp";
		}
		$("#qyryxx_lsxx_detail_div").load(detail_div_loadHtml,function(){
			bgqkbalance_updatediv(json);
		});
	}	
	
	function addtotempList(key,value){
		var objOption = "<option value='"+key+"'>"+value+"</option>";
		$("#bdqylsxx").append($(objOption));
	}
	function getValueByKey(key){
		var result = "";
		$("#bdqylsxx option").each(function(){
			if($(this).attr("value")==key){
				result =  $(this).text();
				return false;
			}
		});
		return result;
	}
	function changeAndWriteRedFont(key,value){ //不同时 红色字体
		$("#"+key).append(value); //赋值
		var values = getValueByKey(key); //获取对比值
		if(values!=value){
			$("td[id^='"+key+"']").each(function(){
				$(this).addClass("red");
			});
			$("span[id^='"+key+"']").each(function(){
				$(this).addClass("red");
			});
			if(key=="tyrq_"){
				showOrHideYlQitaxxbq('tyrq_','block');
			}
		}
	}
</script>
<input type="hidden" id="all_rylsid">
<input type="hidden" id="all_ryid">
<input type="hidden" id="all_scbz" value="9999">
<select id="bdqylsxx" style="DISPLAY:none"></select>
<div id="qyryxx_lsxx_detail_div"></div>
