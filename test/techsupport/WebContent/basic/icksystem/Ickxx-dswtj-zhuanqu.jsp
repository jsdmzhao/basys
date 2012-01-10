<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var glcxick_tables = "";
	var glcxick_pageUrl="icksystem/queryIckZhuanQuList_icksl.action";
	var glcxick_divnid="glcxick_tabledata";
	var glcxick_tableid="glcxick_table1";
	var glcxick_detailid="glcxick_detail";
	
	$(document).ready(function(){
		$("#zhuanquid").html(dataid);
		glcxick_loadPage("glcxick_tabledata");
		glcxick_setPageList(1);
	}); 
	function glcxick_setPageList(pageno,url){
			url=glcxick_setList(pageno,url);
			var mygrid1 = $("#"+glcxick_tableid).ingrid({ 
											ingridPageParams:sXML,
											ingridPageWidth: 800,
											url: url,
											height: pageHeight-205,
											pageNumber: pageno,
											onRowSelect: function(tr, selected){ },
											hideColIndex: [7],
											colWidths: ["16%","12%","16%","14%","10%","12%","16%","0%"]
										});				
	}
	function glcxick_loadPage(divpageid){
		glcxick_tables=$("#"+divpageid).html();
		glcxick_setPageList(1,'#');
	}
	function glcxick_setList(pageno,url){	
		$("#"+glcxick_divnid).html(glcxick_tables);	
		setParams("z_");
		if (url==null || url=="undefined"){
			url=glcxick_pageUrl;
		}
		return url;
	}
</script>

</head>
<body>
<span id="closeFlag"></span>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" >
    <tr>
      <td align="left" class="title1" id="zhuanquid"></td>
      <td align="right" class="title1">
      <a href="#" id="closeWtgyy" onClick='$("#closeFlag").parent().hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<div id="glcxick_tabledata" style="width:100%;">
	<table id="glcxick_table1" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_xm">姓名</th>
			<th name="l_kh">IC卡受理号</th>
			<th name="l_cyrybh">从业人员编号</th>
	     	<th name="l_gj">国籍</th>
			<th name="l_xb">性别</th>
			<th name="l_yxqhzrq">有效截至日期</th>
	     	<th name="l_zkztbs">制卡状态</th>
	     	<th name="">操作</th>
	    </tr>
	  </thead>
	</table>
</div>
</body>
</html>