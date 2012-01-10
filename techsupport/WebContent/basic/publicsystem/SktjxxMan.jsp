<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>

<script type="text/javascript">
var tablesxx;
	var initColWidthsxx1 = ["12%","18%","7%","6%","8%","6%","8%","6%","6%","6%","6%","11%"];
	var initColWidthsxx2 = ["10%","9%","9%","6%","10%","10%","10%","10%","8%","6%","12%"];
	var initColWidthsxx3 = ["10%","10%","10%","6%","10%","10%","10%","12%","10%","12%"];

	var thePlayColWidthsxx =initColWidthsxx3;
	if(jb!=null&&jb!=''){
	
		
			var ganjColxx = "";
					if(jb=='ds'){
						thePlayColWidthsxx = initColWidthsxx2;
						ganjColxx = "<th name='l_dsjgmc' datatype='String' sumflag='0'>地市公安机关</th>";
					}
					if(jb=='fxj'){
						thePlayColWidthsxx = initColWidthsxx2;
						ganjColxx = "<th name='l_fxjmc' datatype='String' sumflag='0'>分县局公安机关</th>";
					}
					if(jb=='gxdw'){
						thePlayColWidthsxx = initColWidthsxx2;
						ganjColxx = "<th name='l_gxdwmc' datatype='String' sumflag='0'>科所队</th>";
					}
					if(jb=='qy'){
						thePlayColWidthsxx = initColWidthsxx1;
						ganjColxx = "<th name='l_qybm' datatype='String' sumflag='0'>场所编码</th>";
						ganjColxx += "<th name='l_qymc' datatype='String' sumflag='0'>服务场所</th>";
						thePlayColWidthsxx = initColWidthsxx1;
						
					}
			if(ganjColxx==''){
				thePlayColWidthsxx = initColWidthsxx3;
				
			}
			var resultxx = "<table id='table2' width='100%'><thead><tr>";
			resultxx += ganjColxx;
		    resultxx += "<th name='l_zrs' datatype='Integer' sumflag='0'>总人数汇总</th>";
	     	resultxx += "<th name='l_gzrs' datatype='Integer' sumflag='0'>工作人数汇总</th>";
	     	resultxx += "<th name='l_sskrs' datatype='Integer' sumflag='0'>实际刷卡人数</th>";
	     	resultxx += "<th name='l_ztskrs' datatype='Integer' sumflag='0'>走台人次</th>";
	     	resultxx += "<th name='l_zskbstring' datatype='String' sumflag='0'>总刷卡比(%)</th>";
	     	resultxx += "<th name='l_ycskrs' datatype='Integer' sumflag='0'>一次刷卡人数</th>";
	        resultxx += "<th name='l_ycskbstring' datatype='String' sumflag='0'>一次刷卡率(%)</th>";
	     	resultxx +="<th name='l_dcskrs' datatype='Integer' sumflag='0'>多次刷卡人数</th>";
	        resultxx += "<th name='l_dcskbstring' datatype='String' sumflag='0'>多次刷卡率(%)</th>";
	        resultxx += "<th name='l_tjrqString' datatype='String' sumflag='0'>日期</th>";
			
			resultxx += "</tr></thead><tbody></tbody></table>";
			$("#tabledata2").html(resultxx);
					
					 
					
				}

	var ztxxxx_detail = "ztxxxx_detail";

	
	$(document).ready(function() {
		//csbm=dataid;
		//$("#x_csbm").val(csbm);
		$("#"+ztxxxx_detail).hide();
		pageUrlxx="publicsystem/querylistsktjxx_qysctj.action";
		divnidxx="tabledata2";
		tableidxx="table2";
		loadPagexx("tabledata2");
		//ExcelURL
		excelUrlxx="publicsystem/querylistExcelxx_qysctj.action";
		searchLongUrlxx="publicsystem/querylistExcelTempxx_qysctj.action";
	    daggleDiv("ztxxxx_detail");
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
				ingridPageWidth:1000,
				url: url,
				height: pageHeight-263,
				pageNumber: pageno,
				colWidths: thePlayColWidthsxx,
				
				 changeHref:function(table){
					         if(jb!=null&&jb!=''){
													$(table).find("tr").each(function(){
													var temp1=$(this).attr('id');
													var temprq=$(this).find("td:last").text();
													  if(jb=='ds'||jb=='fxj'||jb=='gxdw'){
														  if($(this).find("td:nth(4)").text()>0){
																var temp=$(this).find("td:nth(4)").text();
																	
																$(this).find("td:nth(4)").html('<a href="#" class="fontbutton" onclick=setZtxxxxQuery("'+temp1+'","'+temprq+'")>'+temp+'</a>');
															}
													    }
													   else if(jb=='qy'){
													      if($(this).find("td:nth(5)").text()>0){
																var temp=$(this).find("td:nth(5)").text();
																$(this).find("td:nth(5)").html('<a href="#" class="fontbutton" onclick=setZtxxxxQuery("'+temp1+'","'+temprq+'")>'+temp+'</a>');
															}
													   }
					
													});
												}
											},
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
	
	


	

	
	function setExportExcelxx(){
		if(manVerify()){
			thePlayColWidthsxx = initColWidthsxx2;
	
			var ganjColxx = "";
		
		if(jb!=null&&jb!=''){
					if(jb=='ds'){
						ganjColxx = "<th name='l_dsjgmc' datatype='String' sumflag='0'>地市公安机关</th>";
					}
					if(jb=='fxj'){
						ganjColxx = "<th name='l_fxjmc' datatype='String' sumflag='0'>分县局公安机关</th>";
					}
					if(jb=='gxdw'){
						ganjColxx = "<th name='l_gxdwmc' datatype='String' sumflag='0'>科所队</th>";
					}
					if(jb=='qy'){
						ganjColxx = "<th name='l_qybm' datatype='String' sumflag='0'>场所编码</th>";
						ganjColxx += "<th name='l_qymc' datatype='String' sumflag='0'>服务场所</th>";
						thePlayColWidthsxx = initColWidthsxx1;
						
					}
				}
			
			if(ganjColxx==''){
				thePlayColWidthsxx = initColWidthsxx3;
			
			}
			var resultxx = "<table id='table2' width='100%'><thead><tr>";
			resultxx += ganjColxx;
		    resultxx += "<th name='l_zrs' datatype='Integer' sumflag='0'>总人数汇总</th>";
	     	resultxx += "<th name='l_gzrs' datatype='Integer' sumflag='0'>工作人数汇总</th>";
	     	resultxx += "<th name='l_sskrs' datatype='Integer' sumflag='0'>实际刷卡人数</th>";
	     	resultxx += "<th name='l_ztskrs' datatype='Integer' sumflag='0'>走台人次</th>";
	     	resultxx += "<th name='l_zskbstring' datatype='String' sumflag='0'>总刷卡比(%)</th>";
	     	resultxx += "<th name='l_ycskrs' datatype='Integer' sumflag='0'>一次刷卡人数</th>";
	        resultxx += "<th name='l_ycskbstring' datatype='String' sumflag='0'>一次刷卡率(%)</th>";
	     	resultxx +="<th name='l_dcskrs' datatype='Integer' sumflag='0'>多次刷卡人数</th>";
	        resultxx += "<th name='l_dcskbstring' datatype='String' sumflag='0'>多次刷卡率(%)</th>";
			resultxx += "<th name='l_tjrqString' datatype='String' sumflag='0'>日期</th>";
			resultxx += "</tr></thead><tbody></tbody></table>";
			$("#tabledata2").html(resultxx);
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
		var bbmc="刷卡详细信息统计";
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
	function manVerifyxx(){
		return true;
	}
	function formatDate(strDate){ //转换成日期格式

		var riqi = strDate.split("-");
		return new Date(riqi[0],(riqi[1]-1),riqi[2]);
	}
	function setZtxxxxQuery(id,zttjrqString){
		$("#x_zttjrqString").attr("value", zttjrqString);
	     sktjfalg="no";
	     detailid="ztxxxx_detail";
	     dataid=id;
	     setWidth(detailid,"900");
	     $('#'+detailid).css('left','30').css('top','50');
	    $("#x_ztjbdm").attr("value", id);
	
		 var url="basic/publicsystem/ZtryxxMan.jsp";
		 setUrl(detailid,url);
		
	}
	function closeAndRemove(){
	$("#skxxtj_detail").children().remove();
	$("#skxxtj_detail").hideAndRemove("show");
}
</script>

<body>
<input type="hidden" id="x_zttjrqString">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">刷卡详细信息统计</td>
      <td align="right"><a href="#" id="closeDiv" onclick='closeAndRemove();' class="close"></a></td>
    </tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<div id="ztxxxx_detail" class="page-layout" src="#" style="top:235px; left:160px; width:800px;"></div>
<div id="tabledata2" style="width:100%;">
	<table id="table2" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_zrs" datatype="Integer" sumflag="0">总人数汇总</th>
	     	<th name="l_gzrs" datatype="Integer" sumflag="0">工作人数汇总</th>
	     	<th name="l_sskrs" datatype="Integer" sumflag="0">实际刷卡人数</th>
	     	<th name="l_ztskrs" datatype="Integer" sumflag="0">走台人次</th>
	     	<th name="l_zskbstring" datatype="String" sumflag="0">总刷卡比(%)</th>
	     	<th name="l_ycskrs" datatype="Integer" sumflag="0">一次刷卡人数</th>
	     	<th name="l_ycskbstring" datatype="String" sumflag="0">一次刷卡率(%)</th>
	     	<th name="l_dcskrs" datatype="Integer" sumflag="0">多次刷卡人数</th>
	     	<th name="l_dcskbstring" datatype="String" sumflag="0">多次刷卡率(%)</th>
	     	<th name="l_tjrqString" datatype="String" sumflag="0">日期</th>
	    </tr>
	  </thead>
	</table>
</div>
</body>