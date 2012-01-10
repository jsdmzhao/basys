<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/dictDropDown.js"></script>
<script type="text/javascript">
var xctb_detailidTopOffset;
var xctb_detailidLeftOffset;
$(document).ready(function() {
	pageUrl="basicsystem/querylistcsMain_xctb.action";
	divnid="XctbData";
	tableid="XctbTable";
	addUrl="basicsystem/insert_xctb.action";
	addHtml="basic/basicsystem/XctbAdd.jsp";
	addWidth="680";
	delUrl="basicsystem/delete_xctb.action";
	delid="d_tbid";
	modHtml="basic/basicsystem/XctbModify.jsp";
	modUrl="basicsystem/modify_xctb.action";
	modWidth="680";
	detailHtml="basic/basicsystem/XctbDetailcs.jsp";
	detailid="xctb_detail";
	detailUrl="basicsystem/query_xctb.action";
	detailWidth="680";
	loadPage("XctbData");
	setPageList(1);
			
	daggleDiv("xctb_detail");
}); 
	
function setPageList(pageno,url){	
	url=setList(pageno,url);
	var mygrid1 = $("#"+tableid).ingrid({ 
										isPlayResultNull: false,
									ingridPageParams:sXML,
									ingridPageWidth: pageWidth,
									url: url,	
									height: 200,
									pageNumber: pageno,
									sorting:false,
									paging:false,
									onRowSelect: function(tr, selected){
											var str 		= selected ? 'SELECTED' : 'UNSELECTED';
											if (sFlag=="true"){
												if ($(tr).attr('_selected')=="true"){
												 	getXctbDetail(tr);
												}
											}else{
												sFlag="true";
											}					
											rowselect=$(tr).attr('rowindex');
										},
									colWidths: ["25%","25%","25%","25%"]									
								});				
}	

function getXctbDetail(tr){
	setQuery($(tr).attr("id"),detailHtml,detailWidth); 
	var xctb_detailidOffset = $("#"+detailid).offset();
	xctb_detailidTopOffset=xctb_detailidOffset.top;
	xctb_detailidLeftOffset=xctb_detailidOffset.left;
}
</script>

<body>
	
<input type="hidden" id="d_tbid" value="">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="6"></td>
	</tr>
</table>
<div id="xctb_detail"  class="page-layout" src="#"
		style="top:10px; left:160px; width:550px;">
</div>	

<div id="XctbData" style="width:100%;">
	<table id="XctbTable" width="100%">
	  <thead>
	    <tr>   
	     	<th name="l_rowno">序号</th>
	     	<th name="l_bt">标题</th>
	       <th name="l_fbdw">发布单位</th>  
	       <th name="l_fbsj">发布时间</th>  
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
