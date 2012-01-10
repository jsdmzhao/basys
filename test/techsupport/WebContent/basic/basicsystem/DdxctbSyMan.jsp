<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	var ingridHeights = 158;
	$(document).ready(function() {
		ddxctb_pageUrl="basicsystem/querylistcs_xctb.action";
		ddxctb_divnid="XctbData";
		ddxctb_tableid="XctbTable";
		ddxctb_detailHtml="basic/basicsystem/XctbDetailDdsy.jsp";
		ddxctb_detailid="xctb_detail";
		ddxctb_detailUrl="basicsystem/query_xctb.action";
		ddxctb_detailWidth="700";
		var xctbsyFlag = setNull($("#xctbSyFlag").attr("value"));
		if(xctbsyFlag!=''){
			ingridHeights = xctbsyFlag;
		}
		ddxctb_loadPage(ddxctb_divnid);
		daggleDiv("xctb_detail");
		ddxctb_setPageList(1);
	});
	
	function ddxctb_setPageList(pageno,url){
		url=ddxctb_setList(pageno,url);
		var mygrid1 = $("#"+ddxctb_tableid).ingrid({ 
						url: url,	
						height: ingridHeights*1,
						pageNumber: pageno,
						ingridPageWidth : pageWidth-16,
						onRowSelect: function(tr, selected){
						var str = selected ? 'SELECTED' : 'UNSELECTED';
							if (sFlag=="true"){
								if ($(tr).attr('_selected')=="true"){
									setQuery_xctbcs($(tr).attr("id")); 	
								}
							}else{
								sFlag="true";
							}
					   	},
					   	sorting: false,
					    ingridPageParams: sXML,
					    isPlayResultNull: false,
					    hideColIndex: [4],
					   	colWidths: ["10%","35%","40%","15%","0%"]
				});				
	}
	function ddxctb_loadPage(divpageid){
		ddxctb_tables=$("#"+divpageid).html();
		$("#"+ddxctb_detailid).hide(); 	
		ddxctb_setPageList(1,'#');
	}
	function ddxctb_setList(pageno,url){
		$("#"+ddxctb_divnid).html(ddxctb_tables);	
		createXML("p_");
		if (url==null || url=="undefined"){
			url=ddxctb_pageUrl;
		}
		return url;
	}
	
	function setQuery_xctbcs(id){
		dataid=id;
		setWidth(ddxctb_detailid,ddxctb_detailWidth);
		setUrl(ddxctb_detailid,ddxctb_detailHtml);
    }
    
</script>

<body>
<div id="xctb_detail"  class="page-layout" src="#" style="top:10px; left:160px; width:550px;"></div>	

<div id="XctbData" style="width:100%; ">
	<table id="XctbTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_fbsj">发布时间</th>
	     	<th name="l_fbdw">发布单位</th>
	     	<th name="l_bt">标题</th>
	     	<th name="l_fbr">发布人</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
