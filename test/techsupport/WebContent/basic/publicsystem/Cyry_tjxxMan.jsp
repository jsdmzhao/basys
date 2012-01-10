<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var cyry_tjxxLeft;
$(document).ready(function() {
	$("#p_ryid").val(dataid);
	$("#p_qyid").val(dataid_cyryCsid);
	$("#get_ryid").val(dataid);
	$("#get_qyid").val(dataid_cyryCsid);
	pageUrl_cyry_tjxx="publicsystem/querylist_qyry_tjxx.action";
	addUrl_cyry_tjxx="publicsystem/insert_qyry_tjxx.action";
	addHtml_cyry_tjxx="basic/publicsystem/Cyry_tjxxAdd.jsp";
	addWidth_cyry_tjxx="600";
	delUrl_cyry_tjxx="publicsystem/delete_cyry_tjxx.action";
	delid_cyry_tjxx="d_tjxxid";
	modHtml_cyry_tjxx="basic/publicsystem/Cyry_tjxxModify.jsp";
	modUrl_cyry_tjxx="publicsystem/modify_qyry_tjxx.action";
	modWidth_cyry_tjxx="600";
	detailHtml_cyry_tjxx="basic/publicsystem/Cyry_tjxxDetail.jsp";
	detailid_cyry_tjxx="cyry_tjxx_detail";
	detailUrl_cyry_tjxx="publicsystem/query_qyry_tjxx.action";
	detailWidth_cyry_tjxx="600";
	loadPage_cyry_tjxx("tabledata_cyry_tjxx");
	cyry_tjxxLeft = $("#p_ryid").parent().css("left");
	
	 daggleDiv(detailid_cyry_tjxx);
}); 

function setPageList_cyry_tjxx(pageno,url){	
		url=setList_cyry_tjxx(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#table_cyry_tjxx").ingrid({ 
										ingridPageParams:sXML,
										//barTopOffset:-(detailidTopOffset+1),
										//barLeftOffset:-(detailidLeftOffset+1),
										//barWidthOffset:detailWidth,
										//barTopPosition:$("#"+detailid).position().top+38+25,
										ingridPageWidth: modWidth,
										onRowSelect: null,
										url: url,	
										height: 250,
										pageNumber: pageno,
										colWidths: ["10%","58%","12%","10%","10%"]									
									});				
}	
function setList_cyry_tjxx(pageno,url){	
	$("#tabledata_cyry_tjxx").html(tables_cyry_tjxx);	
	createXML("p_");
	if (url==null || url=="undefined"){
		url=pageUrl_cyry_tjxx;
	}
	return url;
}	
function loadPage_cyry_tjxx(divpageid){
	tables_cyry_tjxx=$("#"+divpageid).html();
	$("#cyry_tjxx_detail").hide(); 	
	setPageList_cyry_tjxx(1);
}	

function setAddPage_cyryTj(){
	$("#"+detailid_cyry_tjxx).css("width",addWidth_cyry_tjxx);
	$("#"+detailid_cyry_tjxx).css("left",100);
	setUrl(detailid_cyry_tjxx,addHtml_cyry_tjxx);
}

function setCyry_tjxxXg(id){
	dataid = id;
	$("#"+detailid_cyry_tjxx).css("width",modWidth_cyry_tjxx);
	$("#"+detailid_cyry_tjxx).css("left",100);
	setUrl(detailid_cyry_tjxx,modHtml_cyry_tjxx);
}

function closeParentDiv(){
$("#d_tjxxid").parent().hideAndRemove("show");
}
</script>
	<input type="hidden" id="d_tjxxid" value="">
	<input type="hidden" id="p_ryid" value="">
	<input type="hidden" id="p_qyid" value="">
	<input type="hidden" id="get_ryid" value="">
	<input type="hidden" id="get_qyid" value="">
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">从业人员体检信息</td>
      <td><a href="#" id="closeDiv" onclick='closeParentDiv();'class="close"></a>
    </tr>
     <tr>
      <td align="left"></td>
      <td></td>
    </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="6"></td>
		</tr>
	</table></div>
<table width="100%" border="0" cellpadding="0" cellspacing="1" >
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
    		<tr>
    		  <td width="99%">
    		  	<table width="60" border="0" align="right" cellpadding="0" cellspacing="0">
    		    	<tr>
    		    	  <td height="28px"><a href="#" class="addbutton"   onclick='setAddPage_cyryTj()'>添加</a></td>
   		    	    </tr>
    		  	</table>    		  </td>
    		</tr>
    	</table>
    </td>
  </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
<div id="cyry_tjxx_detail"  class="page-layout" src="#"
		style="top:30px; left:0px; width:500px;">
</div>	

<div id="tabledata_cyry_tjxx" style="width:100%;">
	<table id="table_cyry_tjxx" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_tijianrq">体检日期</th>
	     	<th name="l_tjzkjms">体检状况及描述</th>
	     	<th name="l_lrr">录入人</th>
	     	<th name="l_lrrq">录入日期</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>