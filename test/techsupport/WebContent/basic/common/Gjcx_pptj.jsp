<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var sourceSelect;
var strSelect;
var pptj_tables,pptj_pageUrl,pptj_tableid;
$(document).ready(function() {
	//$("#g_sjbid").val(dataid);
	//pptj_detailUrl = "basicsystem/query_sjb.action";
	pptj_pageUrl="basicsystem/querylistByFa_dtcxtj.action";
	pptj_tableid="pptj_table1";
	loadPage_pptj("Pptj_tableData");
}); 

function setPageList_pptj(pageno,url){	
		url=setList_pptj(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+pptj_tableid).ingrid({ 	
										isPlayResultNull: false,
										ingridPageParams:sXML,						// height of our datagrid (scrolling body area)
										tableid : "pptjTable",
										barTopOffset:-(gjcx_loadDivTopOffset+1),
										ingridPageWidth: 628,
										url: url,	
										height: 260,
										pageNumber: pageno,
										onRowSelect:null,
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
													var tdnum = $(tr).find("td").index(this);
													var ziduanLeixing = $(tr).find("input[name='lx']").val();
														if(tdnum==0){
															addKuohaoFir(this);
														}else if(tdnum==3){
															addPipeifu(this,ziduanLeixing);
														}else if(tdnum==4){
															var xialakuangneirong = $(tr).find("input[name='nr']").val();
															addPipeizhi(this,ziduanLeixing,xialakuangneirong);
														}else if(tdnum==5){
															addKuohaoLas(this);
														}else if(tdnum==6){
															addLuojifu(this);
														}
											});
										},
										paging:false,
										sorting:false,
										colWidths: ["11%","19%","20%","14%","14%","11%","10%"]									
									});				

}	

function loadPage_pptj(divpageid){
	var fanganid = $("#h_gjcxfaid").val();
	pptj_tables=$("#"+divpageid).html();
	if(fanganid==null || fanganid==""){
		setPageList_pptj(1,"#");
	}else{
		setPageList_pptj(1);
	}
}
	
function setList_pptj(pageno,url){	
	$("#Pptj_tableData").html(pptj_tables);	
	createXML("h_");
	if (url==null || url=="undefined"){
		url=pptj_pageUrl;
	}
	return url;
}	
//添加右括号
function addKuohaoFir(obj){
	var objText = $(obj).text();
	strSelect = "<select name='first_kuohao' style='width:100%' onblur='getSelectVal(this)'><option value=''></option><option value='('>(</option><option value='(('>((</option><option value='((('>(((</option></select>";
	if($(obj).find("select").length==0){
		$(obj).text("");
		$(obj).append(strSelect);
		sourceSelect = $(obj).find("select");
		getSelectValAndFocus(sourceSelect,objText);
	}

}
//添加左括号
function addKuohaoLas(obj){
	var objText = $(obj).text();
	strSelect = "<select name='last_kuohao' style='width:100%' onblur='getSelectVal(this)'><option value=''></option><option value=')'>)</option><option value='))'>))</option><option value=')))'>)))</option></select>";
	if($(obj).find("select").length==0){
		$(obj).text("");
		$(obj).append(strSelect);
		sourceSelect = $(obj).find("select");
		getSelectValAndFocus(sourceSelect,objText);
	}

}

//添加匹配符
function addPipeifu(obj,ziduanLeixing){
	var objText = $(obj).text();
	
	strSelect = "<select name='first_pipeifu' style='width:100%' onblur='getSelectVal(this,1)'><option></option></select>";
	if($(obj).find("select").length==0){
		$(obj).text("");
		$(obj).append(strSelect);
		sourceSelect = $(obj).find("select");
		selectOptionsAdd({dict_code:"dm_ppf"},ziduanLeixing);
		getSelectValAndFocus(sourceSelect,objText);
	}

}


function getSelectVal(obj,level){
	if(level==null)
		$(obj).parent().text($(obj).val());
	else{
		var currValue = $(obj).val();
		$(obj).parent().text($(obj).find("option[value='"+currValue+"']").text());
		
	}
	$(obj).remove();
}
//添加逻辑符
function addLuojifu(obj){
	var objText = $(obj).text();
	strSelect = "<select name='first_luojifu' style='width:100%' onblur='getSelectVal(this,1)'><option value=''></option></select>";
	if($(obj).find("select").length==0){
		$(obj).text("");
		$(obj).append(strSelect);
		sourceSelect = $(obj).find("select");
		selectOptionsAdd({dict_code:"dm_ljf"});
		getSelectValAndFocus(sourceSelect,objText);
	}

}

//添加匹配符文本框或select框
function addPipeizhi(obj,dataType,xlknr){
	if(xlknr==""){
			getPiPeiZhiInput(obj,dataType);
	}else{
		if($(obj).find("select").length==0){
			selectPpfOptionsAdd(obj,{dict_code:xlknr},dataType);
		}
	}
}

//添加匹配符文本框实现
function getPiPeiZhiInput(obj,dataType){
	var objText = $(obj).text();
	var currType = dataType.toUpperCase();
	strSelect = "";
	if(currType=="VARCHAR2"){
		strSelect = "<input type='text' name='frist_pipeizhi' onblur='getInputVal(this)' class='inputstyle' style='width:98%'/>";
	}else if(currType=="NUMBER"){
		strSelect = "<input type='text' name='frist_pipeizhi' onblur='getInputVal(this)' class='inputstyle' style='width:98%'/>";
	}else if(currType=="DATE"){
		strSelect = "<input type='text' name='frist_pipeizhi' class='inputstyle' readonly style='width:96%' />";
	}else if(currType=="CHAR"){
		strSelect = "<input type='text' name='frist_pipeizhi' onblur='getInputVal(this)' class='inputstyle' style='width:98%'/>";
	}
		
	if($(obj).find("input").length==0){
		var currDiv = $(obj);
		currDiv.text("");
		currDiv.append(strSelect);
		currDiv.find("input").val(objText);
		if(currType=="DATE"){
			currDiv.find("input").eq(0).datepicker();
			
			currDiv.find("input").bind("propertychange",function(){
				$(this).parent().text($(this).val());
				$(this).remove();
			});

		}
		currDiv.find("input").get(0).select();
	}
}

//依据objText选中select框选项
function getSelectValAndFocus(sourceObj,objText){
	sourceObj.focus();
	sourceObj.find("option").each(function(){
		if(objText == $(this).text()){
			sourceObj.val($(this).val());
		}
	});
}

function getInputVal(obj){
	var currValue = $(obj).val();
	$(obj).parent().text(currValue);
	$(obj).remove();
}

function qingKong_pptj(){
	$("#pptjTable").find("tr:not(tr:first)").remove();
}

function selectOptionsAdd(selData,currDataLx){
	$.ajax({
		  type: "POST",
		  url: "sysadmin/querySelDict_dict_item.action",
		  async: false,
		  data: selData,
		  dataType:"json",
		  timeout:1000,
		  success: function(result){
			 
			var itemLength = result.ldata.length;
			for(var i=0;i<itemLength;i++){
				sourceSelect.get(0).options.add(new Option(result.ldata[i].display_name,result.ldata[i].fact_value));	
			}
			
			if(currDataLx!=null){
				if(currDataLx=="DATE" || currDataLx=="NUMBER"){
					sourceSelect.find("option[value*='like']").remove();
				}
			}
		  }
	});
}

//添加匹配符select框实现
function selectPpfOptionsAdd(obj,selData,dataType){
	$.ajax({
		  type: "POST",
		  url: "sysadmin/querySelDict_dict_item.action",
		  async: false,
		  data: selData,
		  dataType:"json",
		  timeout:1000,
		  success: function(result){
			 
			var itemLength = result.ldata.length;
			
			if(itemLength>0){
				var objText = $(obj).text();
				strSelect = "<select name='first_luojifu' style='width:100%' onblur='getSelectVal(this,1)'><option value=''></option></select>";
				var currDiv = $(obj);
				currDiv.text("");
				currDiv.append(strSelect);
				sourceSelect = $(obj).find("select");
				for(var i=0;i<itemLength;i++){
					sourceSelect.get(0).options.add(new Option(result.ldata[i].display_name,result.ldata[i].fact_value));	
				}
				getSelectValAndFocus(sourceSelect,objText);
			}else{
				getPiPeiZhiInput(obj,dataType);
			}
		  }
	});
}

//添加匹配条件行
function tianjia_pptj(){
	if(addTableTr != ""){
		var trListLen = $("#pptjTable").find("tr").length - 1;
		if(trListLen%2==0)				
			addTableTr = addTableTr.replace("grid-row-style2","grid-row-style1");
		else if(trListLen%2==1)
			addTableTr = addTableTr.replace("grid-row-style1","grid-row-style2");
		
		$("#pptjTable").append(addTableTr);
		addTrEvent($("#pptjTable").find("tr:last"));
	}

}

function shanchu_pptj(){
	var shanchuTr = $("#pptjTable").find("tr[_selected='true']");
	var shanchuTrParent = shanchuTr.parent();
	shanchuTr.remove();
	var tr_class;
	shanchuTrParent.find("tr").each(function(i){
			if(i%2==1)
				tr_class = "grid-row-style2";
			else
				tr_class = "grid-row-style1";
				
			jQuery(this).attr("class",tr_class);
		});
}
</script>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3">
	<img src="images/new.gif" width="16" height="16" /><a href="#"  class="fontbutton1"  onClick="tianjia_pptj();">添加</a> <img src="images/delete.gif" width="16" height="16" /> <a  class="fontbutton1"  href="#"  onClick="shanchu_pptj();">删除</a> <img src="images/clear.gif" width="16" height="16" /> <a href="#"  class="fontbutton1"  onClick="qingKong_pptj();">清空</a>
		</td>
	</tr>
</table><table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
	</tr>
</table>

<div id="Pptj_tableData" style="width:628px;">
	<table id="pptj_table1" width="628">
	  <thead>
	    <tr>       
	     	<!-- <th name="l_skid">刷卡ID</th> -->
	     	<th name="l_kskh">括号</th>
	     	<th name="l_sjbzwm">表名</th>
	     	<th name="l_zdzwm">字段描述</th>
	     	<th name="l_ppf">匹配符</th>
	     	<th name="l_xsz">匹配值</th>
	     	<th name="l_jskh">括号</th>
	     	<th name="l_gxf">逻辑符</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
</body>