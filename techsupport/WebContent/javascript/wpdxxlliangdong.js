	/** 物品大小细类联动 */
	function wpdaxiaoxileiLiandong(dlSelId,xlSelId,xilSelId,dlHideDmId,dlHideMcId,xlHideDmId,xlHideMcId,xilHideDmId,xilHideMcId){
		
		$("#"+dlSelId).selectBox({code:"dm_ddwpzl",query:"0"});
		$("#"+xlSelId).selectBox();
		$("#"+xilSelId).selectBox();
		$("#"+dlSelId).change(function(){
			$("#"+xlSelId).empty();
			$("#"+xilSelId).empty();
			$("#"+xlHideDmId).attr("value","");
			$("#"+xlHideMcId).attr("value","");
			$("#"+xilHideDmId).attr("value","");
			$("#"+xilHideMcId).attr("value","");
			var seldm = $("#"+dlSelId).attr("value");
			$("#"+dlHideDmId).attr("value",seldm);
			$("#"+dlHideMcId).attr("value",$("#"+dlSelId).attr("title"));
			
			if(seldm!=null&&seldm!=""){
				var itemid = $("#"+dlSelId).find("option[value='"+seldm+"']").attr("item");
				$("#"+xlSelId).selectBox({code:"dm_ddwpzl",query:itemid});
			} else {
				$("#"+xlSelId).selectBox();
				$("#"+xilSelId).selectBox();
			}
		});
		$("#"+xlSelId).change(function(){
			$("#"+xilSelId).empty();
			$("#"+xilHideDmId).attr("value","");
			$("#"+xilHideMcId).attr("value","");
			var seldm = $("#"+xlSelId).attr("value");
			$("#"+xlHideDmId).attr("value",seldm);
			$("#"+xlHideMcId).attr("value",$("#"+xlSelId).attr("title"));
			
			if(seldm!=null&&seldm!=""){
				var itemid = $("#"+xlSelId).find("option[value='"+seldm+"']").attr("item");
				$("#"+xilSelId).selectBox({code:"dm_ddwpzl",query:itemid});
			} else {
				$("#"+xilSelId).selectBox();
			}
		});
		$("#"+xilSelId).change(function(){
			$("#"+xilHideDmId).attr("value",$("#"+xilSelId).attr("value"));
			$("#"+xilHideMcId).attr("value",$("#"+xilSelId).attr("title"));
		});
	}
	