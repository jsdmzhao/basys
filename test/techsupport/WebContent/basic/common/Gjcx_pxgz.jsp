<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var sourceSelect;
var strSelect;
var pxgz_tables,pxgz_pageUrl,pxgz_tableid;
$(document).ready(function() {
	//$("#g_sjbid").val(dataid);
	//pxgz_detailUrl = "basicsystem/query_sjb.action";
	pxgz_pageUrl="basicsystem/querylistByFa_dtcxpx.action";
	pxgz_tableid="pxgz_table1";
	//setDetail_pxgz();
	loadPage_pxgz("Pxgz_tableData");
}); 

function setPageList_pxgz(pageno,url){	
		url=setList_pxgz(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+pxgz_tableid).ingrid({ 	
										isPlayResultNull: false,
										ingridPageParams:sXML,						// height of our datagrid (scrolling body area)
										tableid : "pxgzTable",
										barTopOffset:-(gjcx_loadDivTopOffset+1),
										ingridPageWidth: 628,
										url: url,	
										height: 259,
										pageNumber: pageno,
										onRowSelect:null,
										paging:false,
										sorting:false,
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
													var tdnum = $(tr).find("td").index(this);
														if(tdnum==2)
															addPaixuFir(this);
											});
										},
										colWidths: ["40%","40%","20%"]									
									});				

}	

function loadPage_pxgz(divpageid){
	var fanganid = $("#h_gjcxfaid").val();
	pxgz_tables=$("#"+divpageid).html();
	if(fanganid==null || fanganid==""){
		setPageList_pxgz(1,"#");
	}else{
		setPageList_pxgz(1);
	}
}
	
function setList_pxgz(pageno,url){	
	$("#Pxgz_tableData").html(pxgz_tables);	
	createXML("h_");
	if (url==null || url=="undefined"){
		url=pxgz_pageUrl;
	}
	return url;
}	
//添加排序
function addPaixuFir(obj){
	var objText = $(obj).text();
	strSelect = "<select name='first_paixu' style='width:100%' onblur='getSelectVal(this)'><option value=''></option></select>";
	if($(obj).find("select").length==0){
		$(obj).text("");
		$(obj).append(strSelect);
		sourceSelect = $(obj).find("select");
		selectPxgzOptionsAdd({dict_code:"dm_pxfs"});
		getSelectValAndFocus(sourceSelect,objText);
	}

}

function getSelectVal(obj){
	var currValue = $(obj).val();
	$(obj).parent().text($(obj).find("option[value='"+currValue+"']").text());
	$(obj).remove();
}

function qingKong_pxgz(){
	$("#pxgzTable").find("tr:not(tr:first)").remove();
}

function selectPxgzOptionsAdd(selData){
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
			  }
		});
}

//添加匹配条件行
function tianjia_pxgz(){
	if(addTableTr != ""){
		var trListLen = $("#pxgzTable").find("tr").length - 1;;
		if(trListLen%2==0)				
			addTableTr = addTableTr.replace("grid-row-style2","grid-row-style1");
		else if(trListLen%2==1)
			addTableTr = addTableTr.replace("grid-row-style1","grid-row-style2");
			
		$("#pxgzTable").append(addTableTr);
		addTrEvent($("#pxgzTable").find("tr:last"));
	}

}

function shanchu_pxgz(){
	$("#pxgzTable").find("tr[_selected='true']").remove();
}
</script>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3">
	<img src="images/new.gif" width="16" height="16" /><a href="#"  class="fontbutton1"  onclick="tianjia_pxgz();">添加</a> <img src="images/delete.gif" width="16" height="16" /> <a href="#"  class="fontbutton1"  onClick="shanchu_pxgz();">删除</a> <img src="images/clear.gif" width="16" height="16" /> <a href="#"  class="fontbutton1"  onclick="qingKong_pxgz();">清空</a>
		</td>
	</tr>
</table><table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
	</tr>
</table>

<div id="Pxgz_tableData" style="width:628px;">
	<table id="pxgz_table1" width="628">
	  <thead>
	    <tr>       
	     	<!-- <th name="l_skid">刷卡ID</th> -->
	     	<th name="l_sjbzwm">表名</th>
	     	<th name="l_zdzwm">字段描述</th>
	     	<th name="l_pxfs">排序规则</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
</body>