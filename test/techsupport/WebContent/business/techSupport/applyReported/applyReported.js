/**
 * ApplyReported.js 技术支持单录入填报或申请
 */

var windowClientHeight = $(window).height();
//onload

$(function(){
	
	//设置内容自动高度
	setTimeout(autoHeight,5);
	
	//设置所有日期参数
	$('.datero').each(function(){
		$(this).attr('readonly',true);
		$(this).datepicker();
	});
	
	//设置只读
	$('.ro').attr('readonly',true);
//	设置申请人
	$('#applicantName').click(function(){
		getUserofDept('applicantName','applicantId',gxdwbm,ST_ROLE_NAME_APPLICANT);
	});
	//设置大区
	$('#regionName').click(function(){
		getDict_item('regionName','regionCode',ST_REGION_DICT_CODE);
	});
	
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
		
		//加载等待效果
		showloading(true,"正在处理中,请稍后......");
		
		$.post(BUSNEISS_PATH+'/save_apply.action',params,function(data){
			dataobj=eval("("+data+")");
			
//			关闭等待效果
			showloading(false);
			
			if(dataobj.returnNo==0){
				jAlert(dataobj.returnMsg,"提示 ");
				fieldreset();
			}
			
			jAlert(dataobj.returnMsg,"提示 ");
		});
		
	});
	
	$('#savebtn').attr('disabled',true);
	
	
	//设置技术支持单编号
	stNoSetting();
	
	var uploadURL="techsupport/uploadFile_tscommon.action?"+'uploadId='+$('#uploadId').val();
	//设置上传
//	$('#uploadFile').uploadify({
//		'uploader'  : 'business/techSupport/common/javascript/uploadify/uploadify.swf',  
//                  'script'    : uploadURL,  
//                  'cancelImg' : 'business/techSupport/common/javascript/uploadify/cancel.png',  
//                  'fileDataName':'uploadFileX',
////                  'queueID' : 'fileUploadPanel',
//                  'folder':'/uploadTemp',
//                  //解决中文按钮名的好方式  
//                  //'buttonImg' : 'common/javascript/uploadify/select.jpg',  
//                  //可选  
////                  'height'    : 20,  
//                  //可选  
////                  'width'     : 50,  
//                  //设置允许上传的文件格式  
//                  'fileExt'   : '*.txt;',  
//                  //设置允许上传的文件格式后，必须加上下面这行代码才能帮你过滤  
//                  'fileDesc'    : 'txt',  
//                  //允许连续上传多个文件  
//                  'multi':'true',  
//                  //一次性最多允许上传多少个,不设置的话默认为999个  
//                  'queueSizeLimit' : 3,  
//                  //每个文件允许上传的大小(字节)  
//                  'sizeLimit'   : 10240,
//                  auto:false
//                  
//	});
//	$('#uploadButton').click(function(){
//		$('#uploadFile').uploadifyUpload();
////		alert($('#uploadFile').val());
////		$.ajax({
////		type:'POST',
////		url:uploadURL,
////		data:{"upload":$('#uploadFile').val()},
////		success:function(json){
////			alert(json);
////		}
////		});
//		
//	});
});


function autoHeight(){
	//设置内容自动高度
	$('#applyReportedCt').height(windowClientHeight
		-$('#mainDIV > table').eq(0).height()
		-($('#applyReportedCt').outerHeight(true)-$('#applyReportedCt').height()));
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