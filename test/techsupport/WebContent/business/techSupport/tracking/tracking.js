/**
 * tracking.js
 * 追踪批复
 * 
 * */

var processUrl2;
var ingridUrl;
var ingridWidth=400;
var trackingWindowWidth=850;
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
	if (!checkControlValue("p_newProcess","String",1,3000,null,1,"进展填写"))
		return false;
	if (!checkControlValue("p_trackingDate","Date",null,null,null,1,"日期"))
		return false;
	return true;
}

/** 提请反馈验证 */
function toFeedbackVerify(){
	if(gxdwmc.indexOf('方案部') > -1){
		if (!checkControlValue("p_psgCompDate","Date",null,null,null,1,"产品方案部实际完成时间"))
			return false;
		// ++ bug 在阶段选项打开的时候，内容为必填
		if($('#psgcpstage').attr("checked")){
			if (!checkControlValue("p_psgDsCompDate","Date",null,null,null,1,"产品方案部实际需求完成时间"))
				return false;
			if (!checkControlValue("p_psgIsCompDate","Date",null,null,null,1,"产品方案部实际实施完成时间"))
				return false;
		}
		// -- bug 在阶段选项打开的时候，内容为必填	
	}
	if(gxdwmc.indexOf('开发部') > -1){
		if (!checkControlValue("p_devCompDate","Date",null,null,null,1,"技术研发部实际完成时间"))
				return false;
		// ++ bug 在阶段选项打开的时候，内容为必填
		if($('#devcpstage').attr("checked")){
			
			if (!checkControlValue("p_devDsCompDate","Date",null,null,null,1,"技术研发部实际设计完成时间"))
				return false;
			if (!checkControlValue("p_devDdCompDate","Date",null,null,null,1,"技术研发部实际开发完成时间"))
				return false;
			if (!checkControlValue("p_devDtCompDate","Date",null,null,null,1,"技术研发部实际测试完成时间"))
				return false;
		}
	}
		if (!checkControlValue("p_newProcess","String",1,3000,null,1,"进展填写"))
			return false;
		if (!checkControlValue("p_trackingDate","Date",null,null,null,1,"日期"))
			return false;
		
		// -- bug 在阶段选项打开的时候，内容为必填	
		return true;
	}
	
	var comp_time_div_id='comp_time_div';
	//保存连接
	var saveURL = getContextPath()+"/techsupport/save_tracking.action";
	//反馈链接
	var toFeedbackURL = getContextPath() + "/techsupport/applyFeedback_tracking.action";
/** onload */
$(function(){
	
	
	//只读化控件
	$('.ro').attr('readOnly',true);
	//设置时间控件
	$('.date').each(function(){
		$(this).datepicker();
		$(this).attr('readOnly',true);
	});
	
	
	//初始化该页面值
	$('#p_taskId').val(dataid);
	
	
	
	processUrl2=getContextPath()+ "/techsupport/init_tracking.action";
	//追踪批复查询URL
	ingridUrl=getContextPath() + "/techsupport/querylist_tracking.action";
	
	divnid="trackingTableDiv";//查询内容容器ID
	tableid="trackingTable";//查询内容格式表格ID
	
	
	loadPageTrackingQuery(divnid);
	
	
	loadData();
	
	
	//设置保存按钮
	$('#saveBtn').click(function(){
		if(!saveVerify()){
			return;
		}
		
		var params = {};
		
		$('[name^=track.]').each(function(){
			params[$(this).attr('name')]=$(this).val();
		});
		
		//设置当前的track.stId
		params['track.stId']=$('input:hidden[name=st.id]').val();
		
		$.post(saveURL,params,function(data){
			if(!data){
				alert("传输错误，管理人员");
			}
			data = eval("("+data+")");
			
			if(data.returnNo == 0){
				$(detailWindow).hideAndRemove("show");
				
			}
			else
				jAlert(data.returnMsg,"提示");
		});
		
	});
	//设置反馈按钮
	$('#toFeedbackBtn').click(function(){
		
		detailDialog(comp_time_div_id,400,'business/techSupport/tracking/tracking_comp_time.jsp');
	});
	
	daggleDiv(comp_time_div_id);
	
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
										colWidths: ["15%","69%","16%"]				
									});				
		}
}

/**
 * 初始化页面数据
 */
function loadData(){
	var paramsss = {'taskId':$('#p_taskId').val()};
	
	$.post(processUrl2,paramsss,function(data){
		
		data = eval("("+data+")");
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
	});
	
	
}
