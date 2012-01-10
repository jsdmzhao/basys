<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
//var tableName = "";
var fangan_tables,fangan_pageUrl,fangan_tableid;
$(document).ready(function() {
	$("#g_sjbid").val(dataid);
	fangan_pageUrl="basicsystem/querylist_gjcxfa.action";
	//divnid="tabledata";
	fangan_tableid="fangan_table1";
	loadPage_fangan("fangan_tabledata");
	
}); 

function setPageList_fangan(pageno,url){	
		url=setList_fangan(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+fangan_tableid).ingrid({ 	
										ingridPageParams:sXML,						// height of our datagrid (scrolling body area)
										tableid : "fanganTable",
										barTopOffset:-(gjcx_loadDivTopOffset+1),
										ingridPageWidth: 400,
										url: url,	
										height: 140,
										pageNumber: pageno,
										sorting:false,
										onRowSelect:function(tr,selected){
											$(tr).find("td").click(function(){
												var numIn = $(tr).find("td").index(this);
												if(numIn==0){
													var hidId = $("input:hidden").eq(0).attr("id").substr(2);
													htmVal = $(this).text();
													if(htmVal!=null&&htmVal!=''){
														var inp = "<input class='inputstyle'style='width:95%' type='text' id='v_gjcxfamc' value='"+$(this).text()+"' />";
														inp += "<input type='hidden' id='v_gjcxfaid' value='"+$(tr).attr("id")+"' />";
														$(this).html($(inp));
														$(this).find("input").get(0).select();
													}else{
														htmVal = $(this).find("input").eq(0).val();
													}
												
													$(this).find("input").eq(0).blur(function(){
														if(htmVal==$(this).val()){
															$(this).parent().html(htmVal);
														}else{
															setParams("v_");
															jQuery.post("basicsystem/modify_gjcxfa.action",params,updatefamcback,"json"); 
														}	
													});
												}
											});
										
											$(tr).dblclick(function(){
													getFanganZbxx($(tr).attr("id"));
											});
										},		
										colWidths: ["40%","40%","20%"]									
									});				

}	

function loadPage_fangan(divpageid){
	fangan_tables=$("#"+divpageid).html();
	setPageList_fangan(1);
}
	
function setList_fangan(pageno,url){	
	$("#fangan_tabledata").html(fangan_tables);	
	createXML("b_");
	if (url==null || url=="undefined"){
		url=fangan_pageUrl;
	}
	return url;
}
//关闭当前div
function hideFanganPage(){
	$("#gjcx_detail").hide("show");
}

function updatefamcback(json){
	if(json.result=="success"){
		jAlert("修改成功","提示信息");
		setPageList_fangan(1);
		createXML("b_");
		$("#fangan_list").selectBox({url:"basicsystem/listNoPage_gjcxfa.action"});
	}else{
		jAlert(json.result,"错误信息");
	}
}

function setDelete_fa(id){
jConfirm('确定删除吗？', '删除提示', function(r) {
    	if(r==true){
			$("#u_gjcxfaid").val(id);
			if($("#biaoqian_4").css("display")!="block"){
				dataid = "sjbjgid";
				var pptjList = new Array("Pptj_tableData","Pxgz_tableData");
				$("#u_gjcxlx").val("动态");
				$("#Pptj_tableData").find("input").remove();
				setParams("a_",pptjList);
			}else{
				$("#u_gjcxlx").val("SQL");
				setParams("a_");
			}
			setParams("u_");
			jQuery.post("basicsystem/delete_gjcxfa.action",params,deletefaback,"json"); 
		}else{
		   return false;
		}
	});
	
														
}

function deletefaback(json){
	if(json.result=="success"){
		jAlert("删除成功","提示信息");
		setPageList_fangan(1);
		createXML("b_");
		$("#fangan_list").selectBox({url:"basicsystem/listNoPage_gjcxfa.action"});
	}else{
		jAlert(json.result,"错误信息");
	}
}
</script>

<body>
<input type="hidden" id="u_gjcxfaid" />
<input type="hidden" id="u_gjcxlx" />
<table width="100%" border="0" cellpadding="0" cellspacing="0">
 <tr>
      <td align="left" class="title1">高级查询方案列表</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='hideFanganPage();'class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
	</tr>
</table>

<div id="fangan_tabledata" style="width:100%;">
	<table id="fangan_table1" width="100%">
	  <thead>
	    <tr>       
	     	<!-- <th name="l_skid">刷卡ID</th> -->
	     	<th name="l_sjbzwm">方案名称</th>
	     	<th name="l_sjbzwm">功能名称</th>
	     	<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
</body>