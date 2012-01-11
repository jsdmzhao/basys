/*
*控件联动
*主控件id  firstId
*辅控件id  secondId
*控件字典代码   dicDM
*/
function selectboxlink(firstId,secondId,dicDM){
    var firstdm;
    // 主控件初期化
    $("#"+firstId).selectBox({code:dicDM,query:0});
    // 辅控件初期化
    $("#"+secondId).selectBox({state:"1"});
	
    firstdm=$("#"+firstId).find("option:nth(0)").attr("item");
	$("#"+secondId).selectBox({code:dicDM,query:firstdm});

    $("#"+firstId).change(function(){
        firstdm = $("#"+firstId).find("option:selected").attr("item");
	    $("#"+secondId).selectBox({code:dicDM,query:firstdm});
    });
}
 	