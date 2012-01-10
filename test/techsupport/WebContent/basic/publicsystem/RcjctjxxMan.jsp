<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>

<script type="text/javascript">
    detailHtml="basic/publicsystem/RcjcDetail.jsp";
	detailid="rcjc_detail";
	detailUrl="publicsystem/query_publicrcjc.action";
	detailWidth="550";
	
var tablesxx;
	var initColWidthsxx1 = ["20%","20%","20%","20%","20%"];
	var thePlayColWidthsxx =initColWidthsxx1;
	$(document).ready(function() {
		$("#rcjc_detail").hide();
		pageUrlxx="publicsystem/querylistTjxx_publicrcjc.action";
		divnidxx="tabledata2";
		tableidxx="table2";
		loadPagexx("tabledata2");
	    daggleDiv("rcjc_detail");
	});
	function loadPagexx(divpageid){
	    tablesxx=$("#"+divpageid).html();
	    setPageListxx(1);
    }	
	
	
	
	function setPageListxx(pageno,url){
		url=setListxx(pageno,url);
		setParams("x_"); //传参
		var mygrid1 = $("#"+tableidxx).ingrid({
				ingridPageParams:sXML,
				ingridPageWidth:800,
				url: url,
				height: pageHeight-263,
				pageNumber: pageno,
				colWidths: thePlayColWidthsxx,
				
				 
				onRowSelect:null,
				sorting: false
		});
	}
	
function setListxx(pageno,url){	
	$("#"+divnidxx).html(tablesxx);	
	createXML("x_");
	if (url==null || url=="undefined"){
		url=pageUrlxx;
	}
	return url;
}	
	
	


	

	function manVerifyxx(){
		return true;
	}
	function formatDate(strDate){ //转换成日期格式

		var riqi = strDate.split("-");
		return new Date(riqi[0],(riqi[1]-1),riqi[2]);
	}
	function setRcjcQuery(id){
	     dataid=id;
	     
	     setWidth(detailid,detailWidth);
	     $('#'+detailid).css('left','100').css('top','50');
		 setUrl(detailid,detailHtml);
		
	}
	function closeAndRemove(){
	$("#rcjcxxtj_detail").children().remove();
	$("#rcjcxxtj_detail").hideAndRemove("show");
}
</script>

<body>
<input type="hidden" id="x_zttjrqString">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">监督检查统计详细</td>
      <td align="right"><a href="#" id="closeDiv" onclick='closeAndRemove();' class="close"></a></td>
    </tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<div id="rcjc_detail" class="page-layout" src="#" style="top:20px; left:20px; width:800px;"></div>
<div id="tabledata2" style="width:100%;">
	<table id="table2" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_jcrq" datatype="Integer" sumflag="0">检查日期</th>
	     	<th name="l_qymc" datatype="Integer" sumflag="0">处理场所名称</th>
	     	<th name="l_cljg" datatype="Integer" sumflag="0">处理结果</th>
	     	<th name="l_jcrxm" datatype="Integer" sumflag="0">检查人姓名</th>
	     	<th name="" >操作</th>
	     
	    </tr>
	  </thead>
	</table>
</div>
</body>