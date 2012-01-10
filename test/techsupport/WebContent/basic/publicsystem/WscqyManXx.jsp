<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html>
<head>
<script type="text/javascript">
  var tablesxx;
    var thePlayColWidthsxx1 = ["33.3%","33.3%","33.4%"];
    var thePlayColWidthsxx2 = ["25%","25%","25%","25%"];
    var thePlayColWidthsxx = thePlayColWidthsxx1;
	// 建立数据列表
    function createDataTablexx(){
    var ganjColxx="";
       if(jb!=null&&jb!=''){
		      thePlayColWidthsxx = thePlayColWidthsxx2;
				if(jb=='ds'){
					ganjColxx = "<th name='l_dsjgmc' datatype='String' sumflag='0'>地市公安机关</th>";
				}
				if(jb=='fxj'){
					ganjColxx = "<th name='l_fxjmc' datatype='String' sumflag='0'>分县局公安机关</th>";
				}
				if(jb=='gxdw'){
					ganjColxx = "<th name='l_gxdwmc' datatype='String' sumflag='0'>科所队</th>";
				}
			
		}
		if(ganjColxx==''){
				thePlayColWidthsxx = initColWidthsxx1;
				
			}
		var resultxx = "<table id='table2' width='100%'><thead><tr>";
		resultxx += ganjColxx;
		resultxx += "<th name='l_qybm' datatype='Integer' sumflag='0'>场所编码</th>";
		resultxx += "<th name='l_qymc' datatype='Integer' sumflag='0'>场所名称</th>";
		resultxx += "<th name='l_wscrq' datatype='Integer' sumflag='0'>未上传日期</th>";
		resultxx += "</tr></thead><tbody></tbody></table>";
		$("#tabledata2").html(resultxx);
    }
    
    
	var noSortCol = [0];
$(document).ready(function() {
    createDataTablexx();
	pageUrlxx="publicsystem/querylistxx_wscqy.action";
	divnidxx="tabledata2";
	tableidxx="table2";
	loadPagexx("tabledata2");
	
	//ExcelURL
	excelUrlxx="publicsystem/querylistExcelxx_wscqy.action";
	searchLongUrlxx="publicsystem/querylistExcelTempxx_wscqy.action";
}); 

 function loadPagexx(divpageid){
	    tablesxx=$("#"+divpageid).html();
	    setPageListxx(1);
    }	
    function setListxx(pageno,url){	
	$("#"+divnidxx).html(tablesxx);	
	createXML("x_");
	if (url==null || url=="undefined"){
		url=pageUrlxx;
	}
	return url;
}	
    
    // 校验
    function manVerifyxx(){
       
		return true;
	}
	// 转换成日期格式

	function formatDate(strDate){ 
		var riqi = strDate.split("-");
		return new Date(riqi[0],(riqi[1]-1),riqi[2]);
	}

	// 设定数据列表
	function setPageListxx(pageno,url){
		url=setListxx(pageno,url);
		setParams("x_"); //传参 
		var mygrid1 = $("#"+tableidxx).ingrid({
				ingridPageParams:sXML,
				ingridPageWidth:1000,
				url: url,
				height: pageHeight-236,
				pageNumber: pageno,
				colWidths: thePlayColWidthsxx,
				onRowSelect: null,
				sorting: false
				
		});
	}
	// 导出Excel
	function setExportExcelxx(){ 
	    if(manVerifyxx()){
		    createDataTablexx();
		    geteExcelHead("tabledata2");
		    setSearchLongxx();
		    loadPagexx("tabledata2");
		    setPageListxx(1);
		}
	}
	/*
	不分页传参数将结果集返回，用于长参数导出前的查询
	*/
	function setSearchLongxx(){
		setParams("x_");
		jQuery.post(searchLongUrlxx,params,searchLongBackxx,"json");
	}
	//导出前对应setSearchLong()的回调方法  由于执行查询时候有延迟，故将导出放入回调函数

	function searchLongBackxx(json){  
		//报表标题
		var bbmc="场所未上传详细信息";
		//报表请求
		setExcelLongxx("csxxExcel",bbmc);	
	}
	/*setExcel 生成EXCEL,不传参数，防止超长

	 * excelid 链接id
	 * bbmc：报表标题

	 */
	function setExcelLongxx(excelid,bbmc){
		var surl=excelUrlxx+"?tabletitle="+tabletitle+"&bbmc="+bbmc;
		surl=encodeURI(surl);
		location.href = surl;
	}
	
  function closeAndRemove(){
	$("#wscxx_detail").children().remove();
	$("#wscxx_detail").hideAndRemove("show");
}
</script>
</head>
<body>



<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">场所未上传详细信息</td>
      <td align="right"><a href="#" id="closeDiv" onclick='closeAndRemove();' class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<div id="tabledata2" style="width:100%;">
	<table id="table2" width="100%">
	  <thead>
	    <tr>
        <th name='l_qybm' datatype='Integer' sumflag='0'>场所编码</th>
        <th name='l_qymc' datatype='Integer' sumflag='0'>场所名称</th>
		<th name='l_wscrq' datatype='Integer' sumflag='0'>未上传日期</th>
	    </tr>
	  </thead>
	</table>
</div>
</body>
</html>