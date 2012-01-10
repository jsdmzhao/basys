<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var wlzbtables;
	var tzwlzb_detailWidth="600";
	var tzwlzb_detailid="tzYlyZkd_detail";
	var tzwlzb_detailHtml="basic/icksystem/WldjDetail.jsp";
	var tzwlzb_pageUrl="icksystem/querylistTzWlzb_wldj.action";
	$(document).ready(function() {
	    tzwlzb_loadPage("wlzbxxdata");
	    setPageList_wlzb(1);
	    daggleDiv("tzYlyZkd_detail");
	}); 
	
	function tzwlzb_loadPage(divpageid){
		wlzbtables=$("#"+divpageid).html();
		setPageList_wlzb(1,'#');
	}	
	
	function tzwlzb_setList(pageno,url){	
		$("#wlzbxxdata").html(wlzbtables);	
		createXML("p_");
		if (url==null || url=="undefined"){
			url=tzwlzb_pageUrl;
		}
		return url;
	}	
	
	
	function setPageList_wlzb(pageno,url){
	    url = tzwlzb_setList(pageno,url);
		var mygrid1 = $("#wlzbxxtable").ingrid({
												url: url,
												ingridPageParams:sXML,
												ingridPageWidth : pageWidth-415,
												height: ((pageHeight-280)/2),
												pageNumber: pageno,
												onRowSelect: function(tr, selected){
													var str = selected ? 'SELECTED' : 'UNSELECTED';
													if(sFlag=="true"){
														if ($(tr).attr('_selected')=="true"){
															tzwlzb_setQuery($(tr).attr("id"),tzwlzb_detailHtml); 	
														}
													}else{
														sFlag="true";
													}
												},
												sorting: false,
												isPlayResultNull: false,
												colWidths: ["20%","20%","12%","16%","12%","20%"]
		});	
	}

function tzwlzb_setQuery(id,url){
	$("#"+tzwlzb_detailid).empty();
	dataid=id;
	setWidth(tzwlzb_detailid,tzwlzb_detailWidth);
	setUrl(tzwlzb_detailid,url);
	bindDocument(tzwlzb_detailid);
}
</script>

</head>
<body>
<div id="wlzbxxdata" style="width:100%;">
	<table id="wlzbxxtable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_wlpc">物流批次</th>
	     	<th name="l_fssj">发送时间</th>
	     	<th name="l_bnksl">包内卡数量</th>
	     	<th name="l_mbsldmc">采集点</th>
	     	<th name="l_ztdm">状态</th>
	     	<th name="l_jssj">接收时间</th>
	    </tr>
	  </thead>
	</table>	
</div>

</body>
</html>