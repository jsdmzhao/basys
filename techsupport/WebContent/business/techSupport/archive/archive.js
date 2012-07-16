/**
 * archive.js
 * 归档结单或者例外
 * */

var processUrl2;
var ingridUrl;
var ingridWidth=400;

//附件
var attachment_div_id="attachment_list_div";
var attachment_table_id="attachment_list_table";
var attachment_tables;
//附件查询路径
var attachment_query_url = BUSNEISS_PATH +"/querylistAttachment_tscommon.action";


function load_page_attachment_query(divpageid){
	attachment_tables=$("#"+divpageid).html();
	attachment_query(1,'#');
}

function set_attachment_list(pageno,url){	
	$("#"+attachment_div_id).html(attachment_tables);
	createXML("att_");
	if (url==null || url=="undefined"){
		url=attachment_query_url;
	}
	return url;
}
/**
 * 查询函数
 * */
function attachment_query(pageno,url){
	
	if (true){
		url=set_attachment_list(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid2 = $("#"+attachment_table_id).ingrid({ 
										url: url,	
										height:40,
										ingridPageWidth:820,
										isPlayResultNull: false,
										havaWaiDivGunDong: true,
                                      	ingridPageParams:sXML,
                                      	onRowSelect:null,
										pageNumber: pageno,
										noSortColIndex:[3],
										colWidths: ["60%","10%","10%","20%"]				
									});
		}
}

//督办
var supervision_div_id="supervision_list_div";
var supervision_table_id="supervision_list_table";
var supervision_tables;
//督办查询路径
var supervision_query_url = BUSNEISS_PATH +"/querylist_supervision.action";

function load_page_supervision_query(divpageid){
	supervision_tables=$("#"+divpageid).html();
	supervision_query(1,'#');
}

function set_supervision_list(pageno,url){	
	$("#"+supervision_div_id).html(supervision_tables);
	createXML("sv_");
	if (url==null || url=="undefined"){
		url=supervision_query_url;
	}
	return url;
}

/**
 * 查询函数
 * */
function supervision_query(pageno,url){
	
	if (true){
		url=set_supervision_list(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid2 = $("#"+supervision_table_id).ingrid({ 
										url: url,	
										height:60,
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
/**保存验证*/
function saveVerify() {
	if (!checkControlValue("p_comments","String",1,3000,null,1,"备注"))
		return false;
	if (!checkControlValue("p_archive_code","String",1,100,null,1,"版本出库领用单编号"))
		return false;
	return true;
}

/** onload */
$(function(){
	//保存连接
	var saveURL = getContextPath()+"/techsupport/archive_archive.action";
	//只读化控件
	$('.ro').attr('readOnly',true);
	//设置时间控件
	$('.date').each(function(){
		$(this).datepicker();
		$(this).attr('readOnly',true);
	});
	
	
	//初始化该页面值
	$('#p_taskId').val(dataid);
	
	
	processUrl2=getContextPath()+ "/techsupport/init_archive.action";
	//追踪批复查询URL
	ingridUrl=getContextPath() + "/techsupport/querylist_tracking.action";
	
	divnid="trackingTableDiv";//查询内容容器ID
	tableid="trackingTable";//查询内容格式表格ID
	
	
	loadPageTrackingQuery(divnid);
	
	
	loadData();
	//附件显示框
	load_page_attachment_query(attachment_div_id);
	//设置保存按钮
	$('#saveBtn').click(function(){
		if(!saveVerify()){
			return;
		}
		
		var params = {};
		
				
		//设置archiveSt,保存环节信息
		params['archiveSt.id']=$('input:hidden[name=st.id]').val();
//		设置备注信息
		params['archiveSt.comments']=$('#p_comments').val();
		//设置任务号
		params.taskId = $('#p_taskId').val();
		//设置归档领取编号
		params['archiveSt.archive_code'] = $('#p_archive_code').val();
		
		$.post(saveURL,params,function(data){
			if(!data){
				alert("传输错误，联系管理人员");
			}
			
			if(data.returnNo == 0){
//				alert(data.returnMsg);
				$(detailWindow).empty();
				$(detailWindow).hideAndRemove("show");
				worksheetQuery(1);
				
				
				
			}
		},'json');
		
	});
});

function loadPageTrackingQuery(divpageid){
	tables=$("#"+divpageid).html();
	trackingQuery(1,'#');
}	

/**
 * 查询函数
 * */
function trackingQuery(pageno,url){
	
	if (true){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid2 = $("#"+tableid).ingrid({ 
										url: url,	
										height:60,
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
	var paramsss = {'taskId':$('#p_taskId').val()};
	
	$.post(processUrl2,paramsss,function(data){
		
		$('input[name^=st.]').each(function(){
			try{
				$(this).val(setNull(eval("("+"data."+$(this).attr('name')+")")));
			}catch(e){
				
			}
		});
		$('textarea[name^=st.]').each(function(){
			try{
				$(this).val(setNull(eval("("+"data."+$(this).attr('name')+")")));
			}catch(e){
				
			}
		});
		
		//非阶段性隐藏
		relateHide('devstage');
		relateHide('psgstage');
		
		//非阶段性隐藏
		relateHide('devcpstage');
		relateHide('psgcpstage');
	
		
//		提起反馈时间
		var applyingFeedbackDate=$('#p_applyingFeedbackDate').val();
		applyingFeedbackDate=/^(\d{4}-\d{2}-\d{2}) \d{2}:\d{2}:\d{2}$/.exec(applyingFeedbackDate)[1];
		$('#p_applyingFeedbackDate').val(applyingFeedbackDate);
//		反馈确认时间
		var feedbackConfirmDate=$('#p_feedbackConfirmDate').val();
		feedbackConfirmDate=/^(\d{4}-\d{2}-\d{2}) \d{2}:\d{2}:\d{2}$/.exec(feedbackConfirmDate)[1];
		$('#p_feedbackConfirmDate').val(feedbackConfirmDate);
		//		初始化单位信息
		var deptNameStr="";
		var deptList = data.st.supportDeptList;
		for(i=0;i<deptList.length;i++){
			deptNameStr += ","+deptList[i].departname;
		}
		deptNameStr = deptNameStr.substring(1,deptNameStr.length);
		
		
		$('#p_deptName').val(deptNameStr);
		
		//		初始化技术负责人
		var sSlNames="";
		for(i=0;i<data.st.lstSupportLeaders.length;i++)
			sSlNames+=","+data.st.lstSupportLeaders[i].username;
		sSlNames=sSlNames.length > 0? sSlNames.substring(1) : sSlNames;
		$('#p_slName').val(sSlNames);
		
		
		$('#p_region').val(getDictitem({dictcode:ST_REGION_DICT_CODE,value:$('#p_region').val()})[0].display_name);
		trackingQuery(1,ingridUrl);
		//督办
		$('#sv_st_id').val(data.st.id);
		
		supervision_query(1);
		//附件
		$('#att_stId').val(data.st.id);
		attachment_query(1);
	},'json');
	
	
}

