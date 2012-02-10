/**
 * tracking.js
 * 追踪批复
 * 
 * */

var processUrl2;
var ingridUrl;
var ingridWidth=750;
var trackingWindowWidth=850;

/**保存验证*/
function saveVerify() {
	if (!checkControlValue("p_newProcess","String",1,3000,null,1,"进展填写"))
		return false;
	if (!checkControlValue("p_trackingDate","Date",null,null,null,1,"日期"))
		return false;
	return true;
}
	
/** onload */
$(function(){

	//保存连接
	var saveURL = getContextPath()+"/techsupport/save_tracking.action";
	//反馈链接
	var toFeedbackURL = getContextPath() + "/techsupport/applyFeedback_tracking.action";
	
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
		if(!prompt("您确认变更技术支持部门吗？"))
			return;
		
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
				jAlert(data.returnMsg,"提示")
		});
		
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
				
		//非阶段性隐藏
		relateHide('devcpstage');
		relateHide('psgcpstage');
		
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
		
		//	初始化提请反馈必填项颜色信息
		if($('#p_deptName').val().indexOf('方案部') > -1){
			$('#p_psgCompDate').prev('label').addClass('blue');
			// 修正bug 添加必要的颜色信息
			$("#psgcpstage").blur(function() {
				if ($(this).attr('checked')) {
					$('.' + this.id).addClass('blue');
				} else {
					$('.' + this.id).removeClass("blue");
				}
			});
		}
		if($('#p_deptName').val().indexOf('开发部') > -1){
			$('#p_devCompDate').prev('label').addClass('blue');
			// 修正bug 添加必要的颜色信息
			$("#devcpstage").blur(function() {
				if ($(this).attr('checked')) {
					$('.' + this.id).addClass('blue');
				} else {
					$('.' + this.id).removeClass("blue");
				}
			});
		}
		
		$('#p_region').val(getDictitem({dictcode:ST_REGION_DICT_CODE,value:$('#p_region').val()})[0].display_name);
		
		trackingQuery(1,ingridUrl);
		
	});
	
	
}
