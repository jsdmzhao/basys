<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var tableName = "";
var syzd_tables,syzd_pageUrl,syzd_tableid;
$(document).ready(function() {
	$("#g_sjbidSet").val(dataid);
	syzd_detailUrl = "basicsystem/query_sjb.action";
	syzd_pageUrl="basicsystem/querylistXszd_sjbjg.action";
	//divnid="tabledata";
	syzd_tableid="syzd_table1";
	setDetail_syzd();
}); 

//依据sjbid查询数据表单条信息
function setDetail_syzd(){
	setParams("g_");
	jQuery.post(syzd_detailUrl,params,updatediv_syzd,"json");
}

function updatediv_syzd(json){
	var lSjb = json.LSjb;
	if(lSjb!=null){
		var sjbidSet = '',sjbid = null;
		for(var i=0,length=lSjb.length;i<length;i++){
			sjbid = lSjb[i].sjbid;
			sjbidSet += ','+sjbid;
			$("#select_sjbm").append($("<option value='"+sjbid+"'>"+lSjb[i].sjbzwm+"</option>"));
		}
		
		//$("#syzd_table1").find("th[name='l_sjbzwm']").text(lSjb[0].sjbzwm);
		if(sjbid != null)sjbidSet = sjbidSet.substring(sjbidSet.indexOf(",")+1);
		tableName = lSjb[0].sjbzwm;
		$("#g_sjbid").val(lSjb[0].sjbid);
		$("#g_sjbidSet").val(sjbidSet);
		loadPage_syzd("syzd_tabledata");
	}
}

function setPageList_syzd(pageno,url){	
		url=setList_syzd(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+syzd_tableid).ingrid({ 	
										ingridPageParams:sXML,						// height of our datagrid (scrolling body area)
										tableid : "syzdTable",
										barTopOffset:-(gjcx_loadDivTopOffset+1),
										ingridPageWidth: 160,
										url: url,	
										height: 260,
										pageNumber: pageno,
										onRowSelect: function(tr, selected){
											var allTrId = $(tr).attr("id");
											var ziduanLeixing = allTrId.split("_||_");
											if(selected){
												addTableTr = "";
												var pptjTableTrLen;
													if(xuanzemianban == 0){
														pptjTableTrLen = $("#pptjTable").find("tr").length - 1;
													}else{ 
														pptjTableTrLen = $("#pxgzTable").find("tr").length - 1;
													}
														
													var tr_class = "grid-row-style1";
													if(pptjTableTrLen%2==1)
														tr_class = "grid-row-style2";
													var ziduanName = $(tr).find("td").text();
												if(xuanzemianban == 0){
													var currDataLx = ziduanLeixing[1];
													var currDataNr = ziduanLeixing[2];
													$("#pptjTable").width("617");
													addTableTr += "<tr _selected='false' class='"+tr_class+"' id='"+ziduanLeixing[0]+"'>";
													addTableTr += "<td class='grid-col-style1' style='WIDTH:11%' onclick='addKuohaoFir(this)'><div> </div></td>";
													addTableTr += "<td class='grid-col-style1' style='WIDTH:19%'>"+tableName+"</td>";
													addTableTr += "<td class='grid-col-style1' style='WIDTH:20%'>"+ziduanName+"</td>";
													addTableTr += "<td class='grid-col-style1' style='WIDTH:14%' onclick='addPipeifu(this,\""+currDataLx+"\")'> </td>";
													addTableTr += "<td class='grid-col-style1' style='WIDTH:14%' onclick='addPipeizhi(this,\""+currDataLx+"\",\""+currDataNr+"\")'> </td>";
													addTableTr += "<td class='grid-col-style1' style='WIDTH:11%' onclick='addKuohaoLas(this)'> </td>";
													addTableTr += "<td class='grid-col-style1' style='WIDTH:10%' onclick='addLuojifu(this)'> </td>";
													addTableTr += "</tr>";
												}else if(xuanzemianban == 1){
													$("#pxgzTable").width("617");
													addTableTr += "<tr class='"+tr_class+"' id='"+ziduanLeixing[0]+"'>";
													addTableTr += "<td class='grid-col-style1' style='WIDTH:40%'>"+tableName+"</td>";
													addTableTr += "<td class='grid-col-style1' style='WIDTH:40%'>"+ziduanName+"</td>";
													addTableTr += "<td class='grid-col-style1' style='WIDTH:20%' onclick='addPaixuFir(this)'></td>";
												}
												$(tr).dblclick(function(){
													if(addTableTr!=""){
														if(xuanzemianban == 0){
															$("#pptjTable").append(addTableTr);
															addTrEvent($("#pptjTable").find("tr:last"));
														}else if(xuanzemianban == 1){
															$("#pxgzTable").append(addTableTr);
															addTrEvent($("#pxgzTable").find("tr:last"));
														}
													}
													addTableTr = "";
												});
												
											}
										},
										paging:false,
										sorting:false,
										colWidths: ["100%"]									
									});				

}	

function loadPage_syzd(divpageid){
	syzd_tables=$("#"+divpageid).html();
	setPageList_syzd(1);
}
	
function setList_syzd(pageno,url){	
	$("#syzd_tabledata").html(syzd_tables);	
	createXML("g_");
	if (url==null || url=="undefined"){
		url=syzd_pageUrl;
	}
	return url;
}

function changeOption(obj){
	$("#g_sjbid").val($(obj).val());
	tableName = $(obj).find("option[value='"+$(obj).val()+"']").text();
	setPageList_syzd(1);
}
</script>

<body>
	<!--  <textarea id="ddddd"></textarea>-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
	</tr>
</table>
<table width="100%">
	  <thead>
	    <tr>       
	     	<!-- <th name="l_skid">刷卡ID</th> -->
	     	<th name="l_sjbzwm"><select onchange="changeOption(this);" style="width:100%" id="select_sjbm"></select></th>
	    </tr>
	  </thead>
	  
	</table>	
<div id="syzd_tabledata" style="width:100%;">

	<table id="syzd_table1" width="100%">
	  <thead>
	    <tr>       
	     	<!-- <th name="l_skid">刷卡ID</th> -->
	     	<th name="l_sjbzwm"></th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
</body>