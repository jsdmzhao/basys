/**
 * ceApproval.js 技术支持单 总工审批
 */


//onload
var processUrl2=BUSNEISS_PATH+"/init_ceApproval.action";
var saveURL=BUSNEISS_PATH+'/save_ceApproval.action';
var ingridWidth=400;
//进展
//追踪批复查询URL
var	ingridUrl=getContextPath() + "/techsupport/querylist_tracking.action";
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

$(function(){
	
	divnid="trackingTableDiv";//查询内容容器ID
	tableid="trackingTable";//查询内容格式表格ID
	loadPageTrackingQuery(divnid);
	
	//初始化该页面值
	$('#p_taskId').val(dataid);
	
	//设置日期
	$('.datero').each(function(){
		$(this).attr('readonly',true);
		$(this).datepicker();
		
	});
	
	//设置只读
	$('.ro').attr('readonly',true);
	
	//设置技术负责单位
		
	//按钮动作
	$('#savebtn').click(function(){
		if(!submitVerity())
			return;
		if($("#ceApprovalRadioPanel  input").eq(1).attr("checked"))
			if(!confirm("您确认本支持单不通过审批吗？"))
				return;
		var allfields=[];
		
		fields=$('#ceApprovalCt input:text[name^=ceApprovalSt.]');
		for(i=0;i<fields.length;i++){
			allfields.push(fields.get(i));
		}
		fields=$('#ceApprovalCt input:checked[name^=ceApprovalSt.]');
		for(i=0;i<fields.length;i++){
			allfields.push(fields.get(i));
		}
		fields=$('#ceApprovalCt input:hidden[name^=ceApprovalSt.]');
		for(i=0;i<fields.length;i++){
			allfields.push(fields.get(i));
		}
		fields=$('#ceApprovalCt select[name^=ceApprovalSt.]');
		for(i=0;i<fields.length;i++){
			allfields.push(fields.get(i));
		}
		fields=$('#ceApprovalCt textarea[name^=ceApprovalSt.]');
		for(i=0;i<fields.length;i++){
			allfields.push(fields.get(i));
		}
		
		var params={};
		
		for(i=0;i<allfields.length;i++){
			params[$(allfields[i]).attr('name')]=$(allfields[i]).val();
		}

//		设置TASKID 任务号
		params['taskId']=$('#p_taskId').val();
		
		$.post(saveURL,params,function(data){
			if(!data){
				alert("传输错误，管理人员");
			}
			data = eval("("+data+")");
			
			if(data.returnNo == 0){
				$(detailWindow).hideAndRemove("show");
				worksheetQuery(1);
			}
			jAlert(data.returnMsg,"提示");
		});
		
	});
	
	
//	总工审批单选
//	<input type="radio" class=" item " name="st.ceApprovalCode" id="ceApprovalCodeLess">通过
	buildHTMLComponentByDict('<label><input type="radio" class=" item " name="ceApprovalSt.trackList[0].approvalCode" value="{fact_value}">{display}</label>',$('#ceApprovalRadioPanel'),ST_APPR_TYPE_DICT_CODE,'dict_item.fact_value == 0');
	$('input:radio','#ceApproval ').eq(0).attr('checked',true);
	
	loadData();
});

/**
 * 初始化页面数据
 */
function loadData(){
	var paramsss = {'taskId':$('#p_taskId').val()};
	$.post(processUrl2,paramsss,function(data){
		data = eval("("+data+")");
		$('input[name^=st.][type!=checkbox]').each(function(){
			$(this).val(setNull(eval("("+"data."+$(this).attr('name')+")")));
		});
		$('textarea[name^=st.]').each(function(){
			$(this).val(setNull(eval("("+"data."+$(this).attr('name')+")")));
		});
		
		$('#region').val(getDictitem({dictcode:ST_REGION_DICT_CODE,value:$('#region').val()})[0].display_name);
		
		$('input:checkbox','#deptApprovalPanel').each(function(idx){
			var deptlist = eval("("+'data.st.supportDeptList'+")");
			
			for(i=0;i<deptlist.length;i++){
				if(deptlist[i].departcode==$(this).val()){
					$(this).attr('checked',true);
				}
			}
		});
		
		$('input:hidden[name=ceApprovalSt.id]').val(data['st']['id']);
		$('#tracklist_stId').val(data['st']['id']);
		//督办
		$('#sv_st_id').val(data.st.id);
		
		supervision_query(1);
		//进展
		trackingQuery(1,ingridUrl);
	});
}

/**
 * 提交验证
 * */
function submitVerity(){
	if (!checkControlValue("tracklist_stId","String",1,100,null,1,"技术支持单编号"))
		return false;
	if (!checkControlValue("ceName","String",1,50,null,1,"总工名称"))
		return false;
	if (!checkControlValue("ceApprovalDate","Date",1,100,null,1,"总工审批日期"))
		return false;
	
	if($('#ceApprovalRadioPanel input:checked').length == 0){
		jAlert('总工审批 必须选择','提示');
		return false;
	}
	// fixed bug 在选择不通过的时候，也要选择指派的单位
	if($("#ceApprovalRadioPanel  input").eq(0).attr("checked")){
		if($('#deptApprovalPanel input:checked').length == 0){
			jAlert('技术支持部门必须至少选择一个','提示');
			return false;
		}
	}
	
	
	//总工意见
	if(!checkControlValue("ceReply","String",1,4000,null,1,"总工意见"))
		return false;
		
	
	return true;
}