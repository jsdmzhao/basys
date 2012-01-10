/**
 * ceApproval.js 技术支持单 总工审批
 */


//onload
var processUrl2=BUSNEISS_PATH+"/init_ceApproval.action";
var saveURL=BUSNEISS_PATH+'/save_ceApproval.action';
$(function(){
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
	if($('#deptApprovalPanel input:checked').length==0){
		jAlert('技术支持部门必须至少选择一个','提示');
		return false;
	}
	
	return true;
}