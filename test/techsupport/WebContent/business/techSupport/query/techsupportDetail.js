/**
 * archive.js
 * 归档结单或者例外
 * */

var processUrl2;
var ingridUrl;
var ingridWidth=750;

/**保存验证*/
function saveVerify() {
	return true;
}

/** onload */
$(function(){
	//只读化控件
	$('.ro').attr('readOnly',true);
	//设置时间控件
	$('.date').each(function(){
		$(this).datepicker();
		$(this).attr('readOnly',true);
	});
	
	//非阶段性隐藏
	relateHide('devstage');
	relateHide('psgstage');
	
	//非阶段性隐藏
	relateHide('devcpstage');
	relateHide('psgcpstage');
	
	
	//初始化该页面值
	$('#id').val(dataid);
	
	
	processUrl2=getContextPath()+ "/techsupport/query_supportTicket.action";
	//追踪批复查询URL
	ingridUrl=getContextPath() + "/techsupport/querylistOnlyTracking_tracking.action";
	
	divnid="trackingTableDiv";//查询内容容器ID
	tableid="trackingTable";//查询内容格式表格ID
	
	
	loadPageTrackingQuery(divnid);
	
	
	loadData();
	
});

function loadPageTrackingQuery(divpageid){
	tables=$("#"+divpageid).html();
	$(detailWindow).hide(); 	
	trackingQuery(1,'#');
}	
function setTrackingList(pageno,url){	
	$("#"+divnid).html(tables);	
	createXML("track_");
	if (url==null || url=="undefined"){
		url=pageUrl;
	}
	return url;
}

/**
 * 查询函数
 * */
function trackingQuery(pageno,url){
	
	if (true){
		url=setTrackingList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid2 = $("#"+tableid).ingrid({ 
										url: url,	
										height:70,
										ingridPageWidth:ingridWidth,
										isPlayResultNull: false,
										havaWaiDivGunDong: true,
                                      	ingridPageParams:sXML,
                                      	onRowSelect:null,
										pageNumber: pageno,
										colWidths: ["14%","70%","16%"]				
									});				
		}
}

/**
 * 初始化页面数据
 */
function loadData(){
	var paramsss = {'supportTicket.id':$('#id').val()};
	
	$.post(processUrl2,paramsss,function(data){
		data = eval("("+data+")");
		$('input[name^=st.]').each(function(){
			try{
				$(this).val(setNull(eval("("+"data.lSupportTicket[0]"+$(this).attr('name').substring($(this).attr('name').indexOf('.'))+")")));
			}catch(e){
				
			}
			
		});
		$('textarea[name^=st.]').each(function(){
			try{
				$(this).val(eval("("+"data.lSupportTicket[0]"+$(this).attr('name').substring($(this).attr('name').indexOf('.'))+")"));
			}catch(e){
				
			}
			
		});
//		提起反馈时间
		var applyingFeedbackDate=$('#applyingFeedbackDate').val();
		if(applyingFeedbackDate){
			applyingFeedbackDate=/^(\d{4}-\d{2}-\d{2}) \d{2}:\d{2}:\d{2}$/.exec(applyingFeedbackDate)[1];
			$('#applyingFeedbackDate').val(applyingFeedbackDate);
		}
			
//		反馈确认时间
		var feedbackConfirmDate=$('#feedbackConfirmDate').val();
		if(feedbackConfirmDate){
			feedbackConfirmDate=/^(\d{4}-\d{2}-\d{2}) \d{2}:\d{2}:\d{2}$/.exec(feedbackConfirmDate)[1];
			$('#feedbackConfirmDate').val(feedbackConfirmDate);
		}
		
		//		初始化单位信息
		var deptNameStr="";
		var deptList = data.lSupportTicket[0].supportDeptList;
		for(i=0;i<deptList.length;i++){
			deptNameStr += ","+deptList[i].departname;
		}
		deptNameStr = deptNameStr.substring(1,deptNameStr.length);
		
		$('#deptName').val(deptNameStr);
		
		//		初始化技术负责人
		if(data.lSupportTicket[0].lstSupportLeaders){
			var sSlNames="";
		
			for(i=0;i<data.lSupportTicket[0].lstSupportLeaders.length;i++)
				sSlNames+=","+data.lSupportTicket[0].lstSupportLeaders[i].username;
			sSlNames=sSlNames.length > 0? sSlNames.substring(1) : sSlNames;
			$('#slName').val(sSlNames);
		}
		
		var regionCode = $('#region').val();
		var region = getDictitem({dictcode:ST_REGION_DICT_CODE,value:regionCode})[0];
		$('#region').val(region.display_name);
		$('#track_stId').val(data.lSupportTicket[0].id);
		trackingQuery(1,ingridUrl);
		
		divnid="queryContent";//查询内容容器ID
		tableid="queryContentTable";//查询内容格式表格ID
	});
	
	
}

