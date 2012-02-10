/**
 * ceApproval.js 技术支持单 总工审批
 */

//onload
var processUrl2=BUSNEISS_PATH +"/init_deptApproval.action";
var saveURL=BUSNEISS_PATH+'/save_deptApproval.action';
var trackingInfoURL=BUSNEISS_PATH+"/querylistNoPage_tracking.action";

$(function(){
	
	
	//初始化该页面值
	$('#p_taskId').val(dataid);
	
	//设置所有日期参数
	$('.datero').each(function(){
		$(this).attr('readonly',true);
		$(this).datepicker();
	});
	
	//设置只读
	$('.ro').attr('readonly',true);
	
	
	//默认隐藏计划时间
	$('#devAppr').hide();
	$('#psgAppr').hide();
	
	//非阶段性隐藏
	relateHide('devstage');
	relateHide('psgstage');
	
	//设置大区
//	$('#regionName').click(function(){
//		getDict_item('regionName','regionCode',ST_REGION_DICT_CODE);
//	});
	//设置技术负责人
	$('#supportLeaderName').click(function(){
		getUserofDept('supportLeaderName','supportLeaderCode',gxdwbm,[ST_ROLE_NAME_STLEADER]);
	});
	
	//按钮动作
	$('#savebtn').click(function(){
		if(!submitVerity())
			return;
		
		var allfields=[];
		
		fields=$('#deptApproval input:text[name^=st.]');
		for(i=0;i<fields.length;i++){
			allfields.push(fields.get(i));
		}
		fields=$('#deptApproval input:checked[name^=st.]');
		for(i=0;i<fields.length;i++){
			allfields.push(fields.get(i));
		}
		fields=$('#deptApproval textarea[name^=st.]');
		for(i=0;i<fields.length;i++){
			allfields.push(fields.get(i));
		}
		fields=$('#deptApproval input:hidden[name^=st.]');
		for(i=0;i<fields.length;i++){
			allfields.push(fields.get(i));
		}
		
		var params={};
		
		for(i=0;i<allfields.length;i++){
			params[$(allfields[i]).attr('name')]=$(allfields[i]).val();
		}

//		设置任务号
		params['taskId']=$('#p_taskId').val();

		$.post(saveURL,params,function(data){
			dataobj=eval("("+data+")");
			if(dataobj.returnNo==0){
				$(detailWindow).hideAndRemove("show");
				worksheetQuery(1);
			}
			
			jAlert(dataobj.returnMsg,"提示");
		});
		
	});
	
//	部门审批单选
//	<input type="radio" class=" item " name="st.devApprovalCode" id="devApprovalCodeLess">通过
	buildHTMLComponentByDict('<input type="radio" class=" item " name="st.trackList[0].approvalCode" value="{fact_value}">{display}',$('#deptRadioPanel'),ST_APPR_TYPE_DICT_CODE,'dict_item.fact_value == 0');
//	默认选中通过
	$('#deptRadioPanel input:radio').eq(0).attr('checked',true);
	if(gxdwmc=="技术开发部"){
		$('#devAppr').show();
		$('#devAppr').append('<input type="hidden" name="st.trackList[0].type" value="'+TRACKING_TYPE_HDEVREPLY+'">');
	}
	else if(gxdwmc=="产品方案部"){
		$('#psgAppr').show();
		$('#devAppr').append('<input type="hidden" name="st.trackList[0].type" value="'+TRACKING_TYPE_PGMREPLY+'">');
	}
	
	loadData();
});


/**
 * 初始化页面数据
 */
function loadData(){
	var paramsss = {'taskId':$('#p_taskId').val()};
	$.post(processUrl2,paramsss,function(data){
		data = eval("("+data+")");
		$('input:text[name^=st.]').each(function(){
			try{ 
				$(this).val(setNull(eval("("+"data."+$(this).attr('name')+")")));
			}catch(e){
				
			}
			
		});
		
		$('input:hidden[name^=st.]').each(function(){
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
		
		$('#region').val(getDictitem({dictcode:ST_REGION_DICT_CODE,value:$('#region').val()})[0].display_name);
		$('#tracklist_stId').val(data['st']['id']);
//		初始化技术负责人
//		if(data.st.supportLeader){
//			$('#supportLeaderName').val(setNull(data.st.supportLeader.username));
//			$('#supportLeaderCode').val(setNull(data.st.supportLeader.userid));
//		}
		
		setParams("p_");
		$.post(trackingInfoURL,params,function(result){
			if(result == null){
				return;
			}
			var trackinglist = result.lTracking;
			for(i in trackinglist){
				var t=trackinglist[i];
				if(t.type==TRACKING_TYPE_CEREPLY){
					$('#ceApprovalDate').val(setNull(t.trackingDate));
					$('#ceReply').val(setNull(t.newProcess));
					$('#ceName').val(setNull(t.processor.username));
					dictitem=getDictitem({dictcode:ST_APPR_TYPE_DICT_CODE , value : t.approvalCode});
					$('#ceApprovalRadioPanel span').text(dictitem[0].display_name);
				}
			}
			
		},'json');
		
	});
}

/**
 * 提交验证
 */
function submitVerity() {
	if (!checkControlValue("deptApprovalDate","Date",1,100,null,1,"经理审批日期"))
		return false;
	if (!checkControlValue("deptName","String",1,50,null,1,"经理名称"))
		return false;

	//在部门审批通过的时候验证。
	if ($('#deptRadioPanel > input').eq(0).attr('checked')) {
		
		if (!checkControlValue("supportLeaderName","String",1,100,null,1,"技术负责人"))
			return false;
		
		if (gxdwmc == '产品方案部') {

			if (!checkControlValue("psgScheDate", "Date", 1, 100, null, 1,
					"计划完成时间"))
				return false;
			if ($('#psgstage').attr('checked')) {
				if (!checkControlValue("psgDsScheDate", "Date", 1, 100, null,
						1, "计划需求时间"))
					return false;
				if (!checkControlValue("psgIsScheDate", "Date", 1, 100, null,
						1, "计划实施时间"))
					return false;
					
				if(!($('#psgDsScheDate').val() < $('#psgIsScheDate').val()
				&& $('#psgIsScheDate').val() == $('#psgScheDate').val())){
				
					jAlert('计划需求时间必须小于计划实施时间,计划实施时间必须等于计划完成时间','提示');
					return false;
				}
			}
		} else if (gxdwmc == '技术开发部') {
			if (!checkControlValue("devScheDate", "Date", 1, 100, null, 1,
					"计划完成时间"))
				return false;
			if ($('#devstage').attr('checked')) {
				if (!checkControlValue("devDsScheDate", "Date", 1, 100, null,
						1, "计划设计时间"))
					return false;
				if (!checkControlValue("devDdScheDate", "Date", 1, 100, null,
						1, "计划开发时间"))
					return false;
				if (!checkControlValue("devDtScheDate", "Date", 1, 100, null,
					1, "计划测试时间"))
					return false;
					
				if(!($('#devDsScheDate').val() < $('#devDdScheDate').val() &&
					$('#devDdScheDate').val() < $('#devDtScheDate').val() && 
					$('#devScheDate').val() == $('#devDtScheDate').val())){
					jAlert('计划设计时间必须小于计划开发时间必须小于计划测试时间，测试时间必须等于计划完成时间','提示');
					return false;
				}
			}
		}
	}
	  
	
	//部门意见
	if(!checkControlValue("deptReply","String",1,4000,null,1,"部门意见"))
		return false;
		
	
	return true;
}