/**
 * ApplyReported.js 技术支持单录入填报或申请
 */

var windowClientHeight = $(window).height();

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
										height:60,
										ingridPageWidth:627,
										isPlayResultNull: false,
										havaWaiDivGunDong: true,
                                      	ingridPageParams:sXML,
                                      	onRowSelect:null,
										pageNumber: pageno,
										colWidths: ["60%","10%","10%","20%"]				
									});
		}
}
//onload

$(function(){
	
	//设置内容自动高度
	//setTimeout(autoHeight,5);
	var supportContentHeight = 140;
	$('#supportContent').height(supportContentHeight);
	$('#supportContent').parent().css('line-height',supportContentHeight+"px");
	//设置所有日期参数
	$('.datero').each(function(){
		$(this).attr('readonly',true);
		$(this).datepicker();
	});
	
	//设置只读
	$('.ro').attr('readonly',true);
//	设置申请人
//	$('#applicantName').click(function(){
//		getUserofDept('applicantName','applicantId',gxdwbm,ST_ROLE_NAME_APPLICANT);
//	});
	$('#applicantName').val(username);
	$('#applicantId').val(userid);
	//设置大区
	$('#regionName').click(function(){
		//getDict_item('regionName','regionCode',ST_REGION_DICT_CODE);
		getRegionWithRole('regionName','regionCode');
	});
	//设置批号
//	generateBatchNumber(); //废弃
	
	//附件显示框
	load_page_attachment_query(attachment_div_id);
	//按钮动作
	$('#savebtn').click(function(){
		if(!saveVerify())
			return;
		
		var allfields=[];
		
		fields=$('#applyReportedCt input:text[name^=st.]');
		for(i=0;i<fields.length;i++){
			allfields.push(fields.eq(i));
		}
		fields=$('#applyReportedCt input:hidden[name^=st.]');
		for(i=0;i<fields.length;i++){
			allfields.push(fields.eq(i));
		}
		fields=$('#applyReportedCt input:checked[name^=st.]');
		for(i=0;i<fields.length;i++){
			allfields.push(fields.eq(i));
		}
		fields=$('#applyReportedCt select[name^=st.]');
		for(i=0;i<fields.length;i++){
			allfields.push(fields.eq(i));
		}
		fields=$('#applyReportedCt textarea[name^=st.]');
		for(i=0;i<fields.length;i++){
			allfields.push(fields.eq(i));
		}
		var params={};
		
		for(i=0;i<allfields.length;i++){
			params[allfields[i].attr('name')]=allfields[i].val();
		}
		
		//添加附件批号信息
		params['attachment.batchNumber'] = $('#att_batchNumber').val();
		//加载等待效果
		showloading(true,"正在处理中,请稍后......");
		
		$.post(BUSNEISS_PATH+'/save_apply.action',params,function(dataobj){
//			dataobj=$.parseJSON(data);
			
//			关闭等待效果
			showloading(false);
			
			if(dataobj.returnNo==0){
				jAlert(dataobj.returnMsg,"提示 ");
//				fieldreset();
//				generateBatchNumber();
				//重载本页面获取新的UPLOADID，UPLOADID不能通过JS方式更新,uploadify组件无法获取到动态更新后的属性
				$('#iframes').load("business/techSupport/applyReported/applyReported.jsp");
			}
			
			jAlert(dataobj.returnMsg,"提示 ");
		},'json');
		
	});
	
	$('#savebtn').attr('disabled',true);
	
	
	//设置技术支持单编号
	stNoSetting();
	//上传地址
	var uploadURL="techsupport/common_upload.action?"+'uploadId='+$('#att_batchNumber').val();
	//上传队列容器id
	var queue_id = 'fileUploadPanel';
	//上传组件名字
	var upload_name = 'upload';
	//上传文件存放地址
	var upload_folder = '/upload';
	//允许上传大小 字节
	var allow_max_size = 1024000000;
	
	
	//设置上传
	$('#uploadFile').uploadify({
				  'uploader'  : 'business/techSupport/common/javascript/uploadify/uploadify.swf',  
                  'script'    : uploadURL,  
                  'cancelImg' : 'business/techSupport/common/javascript/uploadify/cancel.png',  
                  'fileDataName':upload_name,
                  'queueID' : queue_id,
                  'folder': upload_folder,
                  //解决中文按钮名的好方式  
                  //'buttonImg' : 'common/javascript/uploadify/select.jpg',  
                  //可选  
//                  'height'    : 20,  
                  //可选  
//                  'width'     : 50,  
                  //设置允许上传的文件格式  
//                  'fileExt'   : '*;',  
                  //设置允许上传的文件格式后，必须加上下面这行代码才能帮你过滤  
//                  'fileDesc'    : 'txt',  
                  //允许连续上传多个文件  
                  'multi':true,  
                  //一次性最多允许上传多少个,不设置的话默认为999个  
//                  'queueSizeLimit' : 3,  
                  //每个文件允许上传的大小(字节)  
                  'sizeLimit'   : allow_max_size,
                  'onSelect' : function(file) {
                      var left = document.documentElement.clientWidth / 2 - $('#'+queue_id).width() / 2 ;
                      var top = document.documentElement.clientHeight / 2 - $('#'+queue_id).height() / 2 ;
                      $('#'+queue_id).css('top',top).css('left',left)
                      				.show();
                  },
                  'onAllComplete'  : function(event,data) {
                      attachment_query(1);
                  },
//                  'onComplete'  : function(event,data) {
//                	  alert(2)
//                   },
                  auto:false
	});
	$('#uploadButton').click(function(){
		$('#uploadFile').uploadifyUpload();
	});
	//取消上传队列
//	$('#uploadCancelQueueButton').click(function(){
//		$('#uploadFile').uploadify('cancel','*');
//	});
});



function autoHeight(){
	//设置内容自动高度
	$('#applyReportedCt').height(windowClientHeight
		-$('#allDiv').height());
	$('#contentCt').height($('#applyReportedCt').height()
		-$('#title').outerHeight(true)-$('#footerCt').outerHeight(true));
}
//序列号生成器
function snGenerater(obj,func){
	func();
	var url=BUSNEISS_PATH + "/generateSN_apply.action";
	var param={'st.stNo':$('#stNo').val()};
	$('#savebtn').attr('disabled',true);
	$.post(url,param,function(data){
		$(obj).val(data.st.serialNumber);
		$('#savebtn').attr('disabled',false);
		func();
	},'json');
}
//设置批号
function generateBatchNumber(){ //废弃
	$.post('techsupport/generateBatchNumber_tscommon.action',null,function(res){
		$('#uploadId').val(res.batchNumber);
	},'json');
}
//回填取消
function fieldreset(){
//	@fixed 修复每次填入后保留那些基本数据
//	$('#applyReportedCt input:text').each(function(){
//		$(this).val('');
//	});
	$('#applyReportedCt input:checked').each(function(){
		//重新点击取消
		$(this).click();
	});
	$('#applyReportedCt select').each(function(){
		$(this).val('1');
	});
	$('#applyReportedCt textarea').each(function(){
		$(this).val('');
	});
	
	//设置序号
		snGenerater($('#serialNumber'),stNoGenerater);
}

//	河北-20110113-01
function stNoGenerater(){
	var serialNumber=$('#serialNumber').val();
	var regionName=$('#regionName').val();
	var nowDate=new Date();
	var month=((nowDate.getMonth()+1)+'').length==1?'0'+(nowDate.getMonth()+1):(nowDate.getMonth()+1);
	var day=((nowDate.getDate())+'').length==1?'0'+(nowDate.getDate()):(nowDate.getDate());
	var stNo=regionName+'-'+nowDate.getFullYear()+(month)+day+'-'+serialNumber;
	
	$('#stNo').val(stNo);
}
	
/**
 * 生成技术支持单编号*/
function stNoSetting(){
	//propertychange 实时监视属性的变化
	$('#regionName').bind('propertychange',function(){
		snGenerater($('#serialNumber'),stNoGenerater);
	});
	$('#stNo').bind('change',function(){
		snGenerater($('#serialNumber'),stNoGenerater);
	});
}

function saveVerify() {
	if (!checkControlValue("stNo","String",1,100,null,1,"技术支持单编号"))
		return false;
	if (!checkControlValue("applicantName","String",1,50,null,1,"申请人"))
		return false;
	if (!checkControlValue("regionName","String",1,100,null,1,"大区/区域"))
		return false;
	if (!checkControlValue("serialNumber","Integer",1,100,null,1,"序号"))
		return false;
	if (!checkControlValue("supportContent","String",1,6000,null,1,"技术支持单内容"))
		return false;
//	if(checkStNoisValid())
//		return false;
		
	return true;
}

function checkStNoisValid(){
	var ret=false;
	$.ajax({
		url:BUSNEISS_PATH+'/checkStNoisValid_apply.action',
		async:false,
		type:'post',
		dataType:'json',
		data:{'st.stNo':$('#stNo').val()},
		success:function(json){
//			已存在
			if(json.returnNo){
				jAlert(json.returnMsg,"提示");
				ret=true;
			}
		}
	});
	
	return ret;
}