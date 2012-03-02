/**
 * 待办工作单
 * filename:worksheet.js
 * encoding:utf8
 * 
 */
 
// var detailID;

var ingridHeight = 180;
var trackingDetailWidth=850;
var feedbackDetailWidth=trackingDetailWidth;
var archiveDetailWidth=trackingDetailWidth;
var ce_appr_detail_width = 800;

var usingDetailWidth;
//弹出窗口
var detailWindow;
var worksheet_tables;
var worksheet_div_id;
var worksheet_table_id;
var worksheet_page_url;
function lazyLoad() {
	queryPanelHeight = $("#queryPanel").outerHeight(true);
	ingridHeight=$('#iframes').height()-queryPanelHeight
		-$('#title').outerHeight(true)-80;
	
	loadPageWorksheetQuery(worksheet_div_id);
	
	//	 ++添加流程筛选
	$('#p_activityName').selectBox({code:ST_WORKFLOW_NAME_DICT_CODE});
}
 $(document).ready(function(){

 	//设置自动高度
 	setTimeout(lazyLoad,10);
 	
 	worksheet_div_id="queryContent";//查询内容容器ID
	worksheet_table_id="queryContentTable";//查询内容格式表格ID
	worksheet_page_url=BUSNEISS_PATH +"/querylist_worksheet.action";//查询待办工作单
	workSheetUrl=BUSNEISS_PATH+"/worksheet_worksheet.action";//查询单个工作单
	detailWidth=950;
	detailid = "detailCt";
	detailWindow=$('#'+detailid).get(0);
	//查询按钮动作
	$('#queryBtn').click(function(){
		worksheetQuery(1);
	});
	
	//设置大区
	$('#rgName').click(function(){
		getDict_item('rgName','p_regionCode',ST_REGION_DICT_CODE);
	});
	//设置技术负责人 ###修妖修改角色下拉菜单
	$('#slName').click(function(){
		getUserofDept('slName','p_supportLeaderId',null,ST_ROLE_NAME_STLEADER);
	});

	//控制宽度
//	$('#div_p_activeName ul').width($('#p_activityName').width());
//	 --添加流程筛选 
	daggleDiv(detailid);
 });
 
 /**
  * 表单验证
  * */
 function validate(){
 	return true;
 }
 
 function loadPageWorksheetQuery(divpageid){
	worksheet_tables=$("#"+divpageid).html();
	worksheetQuery(1,'#');
}	
 function worksheetQueryList(pageno,url){
 	$("#"+worksheet_div_id).html(worksheet_tables);
	createXML("p_");
	if (url==null || url=="undefined"){
		url=worksheet_page_url;
	}
	return url;
 }
 /**
  * 查询函数
  * */
 function worksheetQuery(pageno,url){

 	if (validate()){
		url=worksheetQueryList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+worksheet_table_id).ingrid({
										url: url,	
										height:ingridHeight,
										ingridPageWidth:1000,
                                       	ingridPageParams:sXML,
                                       	noSortColIndex:[7],
                                       	onRowSelect:null,
										pageNumber: pageno,
										colWidths: ["14%","10%","12%","12%","12%","12%","12%","12%"]				
									});				
		}
}

/** 
 * 处理流程环节
 * @param taskId  任务ID
 *  */
function setProcess(taskId){
	
	var worksheet;
	
	$.post(workSheetUrl,{'taskId':taskId},function(data){
		worksheet=eval("("+data+")")['worksheet'];
		if(!worksheet){
			alert('获取工作单信息发送错误(开发人员详见LOG)');
			return;
		}
		
		processURL=getContextPath()+worksheet.formResourceName;
		dataid=taskId;
		if(worksheet.activityName=="追踪批复")
			usingDetailWidth=trackingDetailWidth;
		else if(worksheet.activityName=='反馈确认' 
				|| worksheet.activityName=='重指派部门' 
				|| worksheet.activityName=='重指派支持单负责人')
			usingDetailWidth=feedbackDetailWidth;
		else if(worksheet.activityName=='归档')
			usingDetailWidth=archiveDetailWidth;
		else
			usingDetailWidth=detailWidth;
		detailDialog(detailid,usingDetailWidth,processURL,null);
		
	});
	
}

/** 
 * 发送短信 
 * @param taskId 任务ID 
 * */
function sendSMS(taskId){
	var worksheet;
	$(workSheetUrl,{'taskId':taskId},function(data){
		worksheet=eval("("+data+")")['worksheet'];
		
		if(!worksheet){
			alert('获取工作单信息发送错误(开发人员详见LOG)');
			return;
		}
		
	});
}

