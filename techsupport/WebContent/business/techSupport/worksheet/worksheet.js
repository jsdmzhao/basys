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

var usingDetailWidth;
//弹出窗口
var detailWindow;
function lazyLoad() {
	queryPanelHeight = $("#queryPanel").outerHeight(true);
	ingridHeight=pageHeight-queryPanelHeight
		-$('#title').outerHeight(true)
		-$('#mainDIV > table').eq(0).height()-23;
	loadPageWorksheetQuery(divnid);
	worksheetQuery(1);
}
 $(document).ready(function(){

 	//设置自动高度
 	setTimeout(lazyLoad,5);
 	
 	divnid="queryContent";//查询内容容器ID
	tableid="queryContentTable";//查询内容格式表格ID
	pageUrl=BUSNEISS_PATH +"/querylist_worksheet.action";//查询待办工作单
	workSheetUrl=BUSNEISS_PATH+"/worksheet_worksheet.action";//查询单个工作单
	detailWidth=950;
	detailid = "detailCt";
	
	detailWindow=$('#'+detailid).get(0);
	queryTable=$("#"+tableid);
	lazyLoad();
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
		getUserofDept('slName','p_supportLeaderId',HTJD_DEPT_CODE);
	});
//	 ++添加流程筛选
	$('#p_activityName').selectBox({code:ST_RD_MAP_DICT_CODE});
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
	tables=$("#"+divpageid).html();
	$("#"+detailid).hide(); 	
	worksheetQuery(1,'#');
}	

 /**
  * 查询函数
  * */
 function worksheetQuery(pageno,url){

 	if (validate()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		if($('#'+tableid).length == 0){
			$('#'+divnid).html($(queryTable));
		}
		
		var mygrid1 = $("#"+tableid).ingrid({ 
//										tableid:tableid,
										url: url,	
										height:ingridHeight,
										ingridPageWidth:1000,
										isPlayResultNull: false,
										havaWaiDivGunDong: true,
                                       	ingridPageParams:sXML,
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
		else if(worksheet.activityName=='反馈确认')
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

