<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="icksystem/querylist_ickzb.action";
	divnid="tabledata";
	tableid="table1";
	detailid="ickzb_detail";
	tables=$("#tabledata").html();
	setPageList_zkxx(1,"icksystem/querylist_ickzb.action");	
}); 
	
function setPageList_zkxx(pageno,url){	
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML,
										ingridPageWidth: pageWidth-415,
										url: url,	
										height: ((pageHeight-225)/2),
										pageNumber: pageno,
										onRowSelect: null,
										sorting: false,
										isPlayResultNull: false,
										changeHref:function(table){
											table.find("a").attr("title","");
										},
										colWidths: ["28%","14%","22%","30%","20%"]									
									});				
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


</script>
<body>
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
</body>