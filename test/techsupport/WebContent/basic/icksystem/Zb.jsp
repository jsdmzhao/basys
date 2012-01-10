<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var dzb_tables,yzb_tables;
var listHeight = pageHeight - 329;
var initFlag = true;
$(document).ready(function() {
	$("#ickZb_table").find("select").height(listHeight);
	pageUrl="icksystem/querylist_ickzb.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="icksystem/insertZy_ickzb.action";
	addHtml="basic/icksystem/CjdtjrbAdd.jsp";
	addWidth="500";
	delUrl="icksystem/delete_ickzb.action";
	delid="d_cjdtjrbid";
	modHtml="basic/icksystem/CjdtjrbModify.jsp";
	modUrl="icksystem/modify_ickzb.action";
	modWidth="850";
	detailHtml="basic/icksystem/CjdtjrbDetail.jsp";
	detailid="ickzb_detail";
	detailUrl="icksystem/query_ickzb.action";
	detailWidth="300";
	loadPage("tabledata");
	setPageList(1,"icksystem/querylist_ickzb.action");	
	$("#p_slsjf").attr("readonly","true");
	$("#p_slsjf").datepicker();
	$("#p_slsjt").attr("readonly","true");
	$("#p_slsjt").datepicker();
	//listOfCjd();
	//listOfdzb();
	
	//loadPage_zb("dzb_listdata","dzb_table","icksystem/listOfIck_icksl.action",true);
	loadPage_zb("dzb_listdata","dzb_table","#",true);
	loadPage_zb("ZbListData","zb_table","#",false);
}); 

function setPageList(pageno,url){	
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML,
										ingridPageWidth: pageWidth-475,
										url: url,	
										height: pageHeight-154,
										pageNumber: pageno,
										onRowSelect: null,
										changeHref:function(table){
											table.find("a").attr("title","");
										},
										ingridComplete:listOfCjd,
										colWidths: ["28%","14%","22%","30%","20%"]									
									});				
}	
	function manVerify(){
		if (!checkControlValue("p_cjdbm","String",1,20,null,0,"受理点"))
			return false;
		if (!checkControlValue("p_slsjf","Date",null,null,null,0,"受理起始时间"))
			return false;
		if (!checkControlValue("p_slsjt","Date",null,null,null,0,"受理结束时间"))
			return false;
		if (!checkControlValue("p_cyrybh","String",1,30,null,0,"从业人员编号"))
			return false;
		var slsjf = $("#p_slsjf").val();
		var slsjt = $("#p_slsjt").val();
		if (slsjf!='' && slsjt!='' && formatDate(slsjf)-formatDate(slsjt)>0){
			jAlert("受理起始时间范围不正确","验证信息",null,"p_slsjf");
			return false;
		}
		return true;
	}
// 转换成日期格式
function formatDate(strDate){ 
	var riqi = strDate.split("-");
	return new Date(riqi[0],(riqi[1]-1),riqi[2]);
}

/*
//查询出未组包的IC卡受理信息放入未组包下拉列表	
function listOfIck(){//sys_zbsj
	if (manVerify()){
		createXML("p_");
		$.ajax({
			  type: "POST",
			  url: "icksystem/listOfIck_icksl.action",
			  data: {dataxml:sXML},
			  dataType:"json",
			  success: function(result){
			  $("#sys_dzbsj").find("option").remove();
			  	if(result.LIcksl!=null)
					for(var i=0;i<result.LIcksl.length;i++){
						var objOption = "<option value='"+result.LIcksl[i].ickslid+"' title='"+
							result.LIcksl[i].ryid+"' name='"+result.LIcksl[i].qyid+"' lang='"+result.LIcksl[i].cjdbm+"'>"+result.LIcksl[i].zjhm+"   "+result.LIcksl[i].xm+"</option>";
						$("#sys_dzbsj").append($(objOption));
					}
					$("#sys_dzbsj").find("option").each(function(){
						var optionlist = $("#sys_zbsj").find("option");
						var optionlistLength = optionlist.length;
						if(optionlistLength>0){
							for(var i=0;i<optionlistLength;i++){
								var oneOption = optionlist.eq(i);
								var optionValue = oneOption.attr("value");
								if($(this).val()==optionValue){
									$(this).remove();
								}
							}
						}
					});
					
			  }
		});
		listOfdzb();
	}
}
*/
///////////////////////////////////////////////////////////////////////////////////////////////
function loadPage_zb(divpageid,zb_tableid,loadUrl,paging){
		if(paging)
			dzb_tables=$("#"+divpageid).html();
		else
			yzb_tables=$("#"+divpageid).html();
		setPageList_zb(1,loadUrl,divpageid,zb_tableid,paging);
	}
	
function setPageList_zb(pageno,url,divpageid,zb_tableid,paging){	

    if (manVerify()){
		url=setList_zb(divpageid,pageno,url,paging);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+zb_tableid).ingrid({ 	
							ingridPageParams:sXML,						// height of our datagrid (scrolling body area)
							tableid : zb_tableid,
							ingridPageWidth: 222,
							url: url,	
							height: pageHeight-378,
							onRowSelect:null,
							changeHref:function(table){
								var addTdHtml,currTdId;
								table.find("tr").each(function(){
									currTdId = $(this).attr("id");
									if($("#zb_table #"+currTdId+"").length==0)
										addTdHtml = "<td><input type='checkbox' name='"+ currTdId +"'/></td>";
									else
										addTdHtml = "<td></td>";
									$(this).find("td:first").before($(addTdHtml));
								});
							},
							paging:false,
							sorting:false,
							hideColIndex:[3,4,5],
							//gridMoreDateMesFlag: true,						//数据条数过多提示开关
		                    //gridMoreDateMesLen: 200,						//数据条数过多数据标准 默认500条
		                    //gridMoreDateMes: '待组包数据量过大，请采用自由组包方式或缩小查询范围！',							//数据条数过多提示信息
							colWidths: ["4%","62%","34%","0%","0%","0%"],
							ingridComplete:function(){
							    dataTJ();
							}								
						});	
	}		

}	

	function setList_zb(divpageid,pageno,url,paging){	
		if(paging){
			$("#"+divpageid).html(dzb_tables);	
			createXML("p_");	
		}
		else{
			$("#"+divpageid).html(yzb_tables);	
		}
		//createXML("g_");
		if (url==null || url=="undefined"){
			url="#";
		}
		return url;
	}
	// 待组包数据查询
	function chaXunDaiZuBaoList(){
		if($("#p_allhylbdm").val().split(",").length !="1"){
			jAlert("请选择行业类别！","提示信息");
			return;
		}else{
			setPageList_zb(1,"icksystem/listOfIck_icksl.action","dzb_listdata","dzb_table",true);
			}
		}
	
	//移动到已组包数据
	function moveOptionUp(){
		var checkboxList = $("#dzb_table").find("tbody").find("input:checked");
		var length = checkboxList.length;
		if(length>0){
			if(length==$("#dzb_table").find("tbody").find("input").length)
				$("#daizubao").attr("checked",false);
			
			var checkBoxName;
			checkboxList.each(function(){
				checkBoxName = $(this).attr("name");
				if($("#zb_table #"+checkBoxName+"").length==0)
					$("#zb_table").append($("#dzb_table #"+checkBoxName+""));
			});
			
			dataTJ();
		}else{
			jAlert("请选择待组包数据！","提示信息");
		}
	}
	
	//移动到待组包数据	
	function moveOptionDown(){
		var checkboxList = $("#zb_table").find("tbody").find("input:checked");
		var length = checkboxList.length;
		if(checkboxList.length>0){
			if(length==$("#zb_table").find("tbody").find("input").length)
				$("#yizubao").attr("checked",false);
				
			var checkBoxName;	
			var moveTdHtml;
			checkboxList.each(function(){
				checkBoxName = $(this).attr("name");
				moveTdHtml = $("#zb_table #"+checkBoxName+"")
				if($("#dzb_table #"+checkBoxName+"").length==0)
					$("#dzb_table").append(moveTdHtml);
				else
					$("#dzb_table #"+checkBoxName+"").replaceWith(moveTdHtml);
			});
			
			dataTJ();
		}else{
			jAlert("请选择组包数据！","提示信息");
		}
	}
	
	//是否选中所有项	
	function checkOrNot(objId,tableId){
		$("#"+tableId).find("input[type='checkbox']").attr("checked",$("#"+objId).attr("checked"));
	}
///////////////////////////////////////////////////////////////////////////////////////////////
/**
//向右移动实现方法
function moveUp(objOption){
	var isHave = 0;
	var optionlist = $("#sys_zbsj").find("option");
	var optionLength = optionlist.length;
	for(var i=0;i<optionLength;i++){
		oneOption = optionlist.eq(i);
		if($(objOption).attr("value")==oneOption.attr("value"))
			isHave = 1;
	}
	if(isHave==0){
		var newOption = "<option value='"+$(objOption).attr("value")+"' title='"+
				$(objOption).attr("title")+"' name='"+$(objOption).attr("name")+"' lang='"+$(objOption).attr("lang")+"'>"+$(objOption).text()+"</option>";
		$("#sys_zbsj").append($(newOption));
	}
	$(objOption).remove();
	//listOfIck();
}
	
//往右移动选中部分
function moveOptionUp(){
	if($("#sys_zbsj option").length<80){
		$("#sys_dzbsj option:selected").each(function(){
			moveUp(this);
		});
	}else{
		jAlert("组包数据必须小于80条","提示信息");
	}
}

//往右移动全部
function moveOptionUpAll(){
	if($("#sys_zbsj option").length<80){
		$("#sys_dzbsj option").each(function(){
			moveUp(this);
		});
	}else{
		jAlert("组包数据必须小于80条","提示信息");
	}
}


//向左移动实现方法
function moveDown(objOption){
	var isHave = 0;
	var optionlist = $("#sys_dzbsj").find("option");
	var optionLength = optionlist.length;
	for(var i=0;i<optionLength;i++){
		oneOption = optionlist.eq(i);
		if($(objOption).attr("value")==oneOption.attr("value"))
			isHave = 1;
	}
	if(isHave==0){
		var newOption = "<option value='"+$(objOption).attr("value")+"' title='"+
				$(objOption).attr("title")+"' name='"+$(objOption).attr("name")+"' lang='"+$(objOption).attr("lang")+"'>"+$(objOption).text()+"</option>";
		$("#sys_dzbsj").append($(newOption));
	}
	$(objOption).remove();
}
	
//往左移动选中部分
function moveOptionDown(){
	$("#sys_zbsj option:selected").each(function(){
		moveDown(this);
	});
}

//往左移动全部
function moveOptionDownAll(){
	$("#sys_zbsj option").each(function(){
		moveDown(this);
	});
}
**/
//查询采集点列表方法	
function listOfCjd(){
if(initFlag){
	createXML("s_");
	if(!window.XMLHttpRequest){ //IE6
		//selectOptionsAdd("p_cjdbm",{dataxml:sXML});
		//selectOptionsAdd("a_cjdbm",{dataxml:sXML});
		selectOptionsAdd({dataxml:sXML},"");
	}else{
		if(window.ActiveXObject){//IE7
      	 	$("#p_cjdbm").selectBox({url:"sysadmin/querySelDepart_department.action"});
			$("#a_cjdbm").selectBox({url:"sysadmin/querySelDepart_department.action"});
		}
	}
	initFlag=false;
}
}

function zyzbAdd(){
	jConfirm('确定组包吗？', '组包提示', function(r) {
		if(r==true){
		if (addVerify()){
			allPageUp();
			setParams("a_");
			setZbAdd("icksystem/insertZy_ickzb.action");
		}else{
			return addVerify();
		}
		}else{
			return false;
		}	
	});
}

function zdyzbAdd(){
	//var optionList = $("#sys_zbsj").find("option");
	var optionList = $("#zb_table").find("tbody").find("input:checkbox");
	
	var optionLength = optionList.length;
	if(optionLength<1){
		jAlert("组包数据不能为空","提示信息");
		return;
	}else if(optionLength>80){
		jAlert("组包数据不能大于80条","提示信息");
		return;
	}
	
	jConfirm('确定组包吗？', '组包提示', function(r) {
    	if(r==true){
			allPageUp();
			var ryidSet = "";
			var ickslidSet = "";
			var qyidSet = "";
			var cjdbmSet = "";
/*			optionList.each(function(i){
					ryidSet += $(this).attr("title")+"_,,";
					ickslidSet += $(this).attr("value")+"_,,";
					qyidSet += $(this).attr("name")+"_,,";
					cjdbmSet += $(this).attr("lang")+"_,,";
			});
*/
			$("#zb_table").find("tbody").find("tr").each(function(){
				ryidSet += $(this).find("td:nth(3)").text()+"_,,";
				ickslidSet += $(this).attr("id")+"_,,";
				qyidSet += $(this).find("td:nth(4)").text()+"_,,";
				cjdbmSet += $(this).find("td:nth(5)").text()+"_,,";
			});
			$("#z_ryidSet").val(ryidSet);
			$("#z_ickslidSet").val(ickslidSet);
			$("#z_qyidSet").val(qyidSet);
			$("#z_cjdbmSet").val(cjdbmSet);
			
			setParams("z_");
			setZbAdd("icksystem/insertZdy_ickzb.action");
		}else{
		   return false;
		}
	});
}


function setZbAdd(url){
	jQuery.post(url,params,addzyzbback,"json");
}	

function addzyzbback(json){
	if(json.result=="success"){
		jAlert("组包成功",'提示信息');
		//$("#sys_zbsj option").remove();
		$("#zb_table").find("tbody").remove();
		setPageList(1,"icksystem/querylist_ickzb.action");
	}else{
		jAlert(json.result,'错误信息');
	}	
		$('#jquery-overlay').remove();	
}

function addVerify(){
		if (!checkControlValue("a_cjdbm","String",1,60,null,0,"受理点"))
			return false;
		return true;
}

function allPageUp(){
	$("body").append('<div id="jquery-overlay"></div>');
	$("#jquery-overlay").css({
		backgroundColor: 	"#FFFFFF",
		opacity:			0.5, 
		width:				pageWidth,
		height:				pageHeight
	}).fadeIn();	
}

function listOfdzb(){
	//$("#sys_dzbsj").multiple({state:"1"});
	//$("#sys_dzbsj").multiSelect("#sys_zbsj", {trigger: "#options_right"});
	//$("#sys_zbsj").multiSelect("#sys_dzbsj", {trigger: "#options_left"});
}

function getObject(obj){ //点击链接方法(判断是否注销)
	sFlag="false";
	if($(obj).text()=="印刷"){
		if($(obj).find("font").get(0)==null)
			delid="zb_0";
		else
			delid="zb_1";
			
		loadIckYs($(obj).attr("id").split("_")[1]);
	}else{
		loadIckDxr($(obj).attr("id").split("_")[1]);
	}
}

//跳转到IC卡印刷页面
function loadIckYs(id){
	dataid = id;
	$("#password_modify").empty();
	$("#iframes").empty();
	$("#iframes").load("basic/icksystem/YsMan.jsp");
	$("#iframes").show("slow"); 
}

//跳转到IC卡电写入页面
function loadIckDxr(id){
	dataid=id;
	sFlag="false";
	$("#iframes").empty();
	$("#iframes").load("basic/icksystem/DxrMan-pxr.jsp");
	$("#iframes").show("slow"); 
}

function selectOptionsAdd(selData,selectCon){
	$.ajax({
		  type: "POST",
		  url: "sysadmin/querySelDepart_department.action",
		  async: true,
		  data: selData,
		  dataType:"json",
		  //timeout:1000,
		  success: function(result){
			 
			var itemLength = result.ldata.length;
			for(var i=0;i<itemLength;i++){
				$("#p_cjdbm").get(0).options.add(new Option(result.ldata[i].display_name,result.ldata[i].fact_value));	
				$("#a_cjdbm").get(0).options.add(new Option(result.ldata[i].display_name,result.ldata[i].fact_value));
			}
			$("#p_cjdbm").selectBox({state:"1"});
			$("#a_cjdbm").selectBox({state:"1"});
		}
	});
}
function hylbdmchange(){
$("#p_qymc").val("");
}	
// 行业类别	
$("#p_allhylbdm").selectBoxinhylb();
$("#a_allhylbdm").selectBoxinhylb();
// 企业筛选框
$("#p_qymc").click(function(){
    allhybz=$('#p_allhylbdm').val();  
 	getTy_item("p_qymc","p_qybm","","","",allhybz);
  });

// 数据统计
function dataTJ(){
    // 待组包数量
    var dzbDataCount = $("#dzb_table").find("tbody tr").length;
    // 组包数量
    var zbDataCount = $("#zb_table").find("tbody tr").length;
    $("#dzbs").html(''+dzbDataCount);
    $("#zbs").html(''+zbDataCount);
    
}
</script>
<body>
	<input type="hidden" id="s_isCjd" value="1" />
	<input type="hidden" id="d_cjdtjrbid" />
	<input type="hidden" id="p_qybm" value="">
	<div style="display:none;"><select  id="a_allhylbdm"></select></div>
<div id="ickzb_detail"  class="page-layout" src="#"
		style="display:none;top:10px;">
</div>	
	<table id="ickZb_table" width="100%"  border="0"
		cellspacing="0" cellpadding="0" >
		<tr>
			<td width="473" valign="top">
				<table width="100%" cellpadding="0" cellspacing="0"
					class="tableborder">
					<tr>
						<td class="queryfont">
							自由组包
						</td>
					</tr>
					<tr>
						<td class="tdbg">
							<table width="100%" border="0" cellspacing="0"  cellpadding="2">
								<tr >
									<td width="17%" class="pagedistd">
										请选择受理点
									</td>
									<td width="41%" class="pagetd">
										<select id="a_cjdbm" class="select1">
											<option></option>
										</select>
									</td>
									<td width="17%" class="pagedistd">
										每包记录数
									</td>
									<td width="25%" class="pagetd">
										<input type="text" readonly class="readonly" id="a_mbjls"
											value="80" />
									</td>
								</tr>
								<tr>
									<td colspan="3" class="pagedistd">&nbsp;									</td>
									<td width="25%" height="25" class="pagetd">
								  <table width="64" border="0" align="right" cellpadding="0"
											cellspacing="0">
											<tr>
												<td>
													<a href="#" class="submitbutton" id="querys"
														onClick="zyzbAdd();">组包</a>
												</td>
											</tr>
										</table>
									</td>
							  </tr>

							</table>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="3">	</td>
					</tr>
				</table>
				<table width="100%" cellpadding="0" cellspacing="0"
					class="tableborder">
					<tr>
						<td class="queryfont">
							自定义组包
						</td>
					</tr>
					<tr>
						<td class="tdbg">
							<input type="hidden" id="z_ryidSet" />
							<input type="hidden" id="z_ickslidSet" />
							<input type="hidden" id="z_qyidSet" />
							<input type="hidden" id="z_cjdbmSet" />
							<table width="100%" border="0" cellspacing="0" cellpadding="2">
							<tr>
							<td width="17%" class="pagedistd">行业类别</td>
		<td width="41%" class="pagetd"><select  id="p_allhylbdm" class="select1" onchange="hylbdmchange();"></select></td>
        <td width="17%" class="pagedistd">受理企业名称</td>
        <td width="41%" class="pagetd"><input id="p_qymc" type="text" readonly class="inputstyle"></td>
        </tr>
								<tr >
									<td width="17%" class="pagedistd">
										受理点
									</td>
									<td width="41%" class="pagetd">
										<select id="p_cjdbm" class="select1">
											<option></option>
										</select>
									</td>
									<td width="17%" class="pagedistd">
										从业人员编号
									</td>
									<td width="25%" class="pagetd">
										<input type="text" class="inputstyle" id="p_cyrybh" />
									</td>
								</tr>
								<tr >
									<td width="17%" class="pagedistd">
										受理起始时间
									</td>
									<td width="41%" class="pagetd">
										<input type="text" class="inputstyle" id="p_slsjf" />
									</td>
									<td width="17%" class="pagedistd">
										至
									</td>
									<td width="25%" class="pagetd">
										<input type="text" class="inputstyle" id="p_slsjt" />
									</td>
								</tr>
								<tr >
									<td width="17%" class="pagedistd">&nbsp;
										
									</td>
									<td width="41%" class="pagetd">&nbsp;
										
									</td>
									<td width="17%" class="pagedistd">&nbsp;
										
									</td>
									<td width="25%" class="pagetd">
										<table width="62" border="0" align="right" cellpadding="0"
											cellspacing="0">
									  <tr>
												<td>
													<a href="#" class="searchbutton" id="querys3"
														onClick="chaXunDaiZuBaoList();">查询</a>
												</td>
											</tr>
										</table>
								  </td>
								</tr>
								<tr>
									<td colspan="4" class="pagedistd">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="40%" align="left" class="pagedistd">
													待组包数据(<span id="dzbs">0</span>条)									</td>
												<td width="41%" colspan="2" class="pagetd">&nbsp;												</td>
												<td width="40%" align="left" class="pagedistd">
													组包数据(<span id="zbs">0</span>条)											</td>
												<td width="25%" class="pagetd">&nbsp;												</td>
											</tr>
											<tr>
												<td colspan="5" valign="top" class="pagetd"><table width="100%" cellpadding="0" cellspacing="0"
					class="tableborder">
                                                  <tr>
                                                    <td width="46%" align="left" valign="top"  class="tableborder">
                                                    <div id="dzb_listdata" style="width: 100%;">
                                                        <table id="dzb_table" width="100%">
                                                          <thead>
                                                            <tr>
                                                              <th name=""> <input type="checkbox" id="daizubao" onclick="checkOrNot('daizubao','dzb_table');" />
                                                              </th>
                                                              <th name="l_zjhm">证件号码</th>
                                                              <th name="l_xm">姓名</th>
                                                              <th name="l_ryid">人员ID</th>
                                                              <th name="l_qyid">企业ID</th>
                                                              <th name="l_cjdbm">采集点编码</th>
                                                            </tr>
                                                          </thead>
                                                        </table>
                                                    </div></td>
                                                    <td width="8%" class="tableborder"><table width="100%" border="0" align="center" cellpadding="0"
								cellspacing="0">
                                                        <tr>
                                                          <td height="30">
                                                           <a href="#" class="rightbutton" id="querys4" onClick="moveOptionUp();"></a>
											             </td>
                                                        </tr>
                                                        <tr>
                                                          <td height="30">
                                                          <a href="#" class="leftbutton" id="querys5" onClick="moveOptionDown();"></a>
                                                          </td>
                                                        </tr>
                                                    </table></td>
                                                    <td width="46%" align="right" valign="top"  class="tableborder"><div id="ZbListData" style="width: 100%;">
                                                        <table id="zb_table" width="100%">
                                                          <thead>
                                                            <tr>
                                                              <th name=""> <input type="checkbox" id="yizubao"  onclick="checkOrNot('yizubao','zb_table');" />
                                                              </th>
                                                              <th name="l_zjhm">证件号码</th>
                                                              <th name="l_xm">姓名</th>
                                                              <th name="l_ryid">人员ID</th>
                                                              <th name="l_qyid">企业ID</th>
                                                              <th name="l_cjdbm">采集点编码</th>
                                                            </tr>
                                                          </thead>
                                                        </table>
                                                    </div></td>
                                                  </tr>
                                                </table></td>
										  </tr>
										</table>
								  </td>
								</tr>
								<tr>
									<td colspan="3" class="pagedistd">&nbsp;
										
									</td>
									<td width="25%" class="pagetd">
										<table width="64" border="0" align="right" cellpadding="0"
											cellspacing="0">
											<tr>
												<td>
													<a href="#" class="submitbutton" id="querys2"
														onClick="zdyzbAdd();">组包</a>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
			<td width="2">&nbsp;
				
			</td>
			<td width="*" valign="top">
				<div id="tabledata" style="width: 100%;">
					<table id="table1" width="100%">
						<thead>
							<tr>
								<th name="l_cjdtjrq">
									批次号
								</th>
								<th name="l_ssdsbm">
									数量
								</th>
								<th name="l_ssdsmc">
									组包人
								</th>
								<th name="l_cjdbm">
									组包时间
								</th>
								<th name="">
									操作
								</th>
							</tr>
						</thead>

					</table>
				</div>
			</td>
		</tr>
	</table>
</body>