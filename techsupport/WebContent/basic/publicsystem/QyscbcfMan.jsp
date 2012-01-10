<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<jsp:include page="../../public/publicGADTJ.jsp" flush="true"></jsp:include>
<html>
<head>
<script type="text/javascript">

	var qyjbxx_detailHtml="business/Ylfwzagl/YlcsjbxxDetail.jsp";
	var qyjbxx_detailid="qyjbxxone_detail";
	var qyjbxx_detailUrl="publicsystem/query_qyjbxx.action";
	var qyjbxx_detailWidth="1000";
	var qyjbxx_requestType="detail";
	var qyjbxx_dataid="";
	

  var jb;
    var thePlayColWidths1 = ["20%","20%","20%","20%","20%"];
    var thePlayColWidths2 = ["16%","16%","16%","16%","16%","20%"];
    var thePlayColWidths = thePlayColWidths1;
	var noSortCol = [0];
	
$(document).ready(function() {
	initTJDate();
	$("#qyscbcfxx_detail").hide();
	$("#qyjbxxone_detail").hide();
 
	pageUrl="publicsystem/querylist_qyscbcf.action";
	divnid="tabledata";
	tableid="table1";
	loadPage("tabledata");
	
	ksd_csxxtjInit();
	$("#t_qssj").attr("readonly","true").attr("value",tomorrowDate).datepicker();
	$("#t_jzsj").attr("readonly","true").attr("value",currentDate).datepicker();
	//ExcelURL
	excelUrl="publicsystem/querylistExcel_qyscbcf.action";
	searchLongUrl="publicsystem/querylistExcelTemp_qyscbcf.action";
	 daggleDiv("qyscbcfxx_detail");
	  daggleDiv("qyjbxxone_detail");
	 	// 行业类别	
	$("#t_hylbdm").selectBoxhylb();
	//注销状态

  	$("#t_ztdm").selectBox({code:"dm_cszt"});
}); 
    // 建立数据列表
    function createDataTable(){
        $("#x_hylbdm").attr("value", $("#t_hylbdm").attr("value"));
		$("#x_qssj").attr("value", $("#t_qssj").attr("value"));
		$("#x_jzsj").attr("value", $("#t_jzsj").attr("value"));
    	$("#x_ztdm").attr("value", $("#t_ztdm").attr("value"));
    	ganjCol ="";
        $("#gajgAll").find("input[type='checkbox']").each(function(){
			if($(this).attr("checked")==true){
				if($(this).attr("dataKey")=='dsjgdm'){
					ganjCol = "<th name='l_dsjgmc' datatype='String' sumflag='0'>市级公安机关</th>";
					thePlayColWidths = thePlayColWidths2;
					     jb="ds";
						$("#x_dsjgbz").attr("value","1");
						$("#x_dsjgdm").attr("value", $("#t_dsjgdm").attr("value"));
						$("#x_fxjbz").attr("value","0");
						$("#x_fxjdm").attr("value", '');
						$("#x_gxdwbz").attr("value","0");
						$("#x_gxdwdm").attr("value", '');
						
					
					
				}
				if($(this).attr("dataKey")=='fxjdm'){
					ganjCol = "<th name='l_fxjmc' datatype='String' sumflag='0'>分县局公安机关</th>";
					thePlayColWidths = thePlayColWidths2;
						jb="fxj";
						$("#x_dsjgbz").attr("value","0");
						$("#x_dsjgdm").attr("value",  $("#t_dsjgdm").attr("value"));
						$("#x_fxjbz").attr("value","1");
						$("#x_fxjdm").attr("value", $("#t_fxjdm").attr("value"));
						$("#x_gxdwbz").attr("value","0");
						$("#x_gxdwdm").attr("value", '');
					
				}
				if($(this).attr("dataKey")=='gxdwdm'){
					ganjCol = "<th name='l_gxdwmc' datatype='String' sumflag='0'>科所队</th>";
					thePlayColWidths = thePlayColWidths2;
					jb="gxdw";
						$("#x_dsjgbz").attr("value","0");
						$("#x_dsjgdm").attr("value", $("#t_dsjgdm").attr("value"));
						$("#x_fxjbz").attr("value","0");
						$("#x_fxjdm").attr("value", $("#t_fxjdm").attr("value"));
						$("#x_gxdwbz").attr("value","1");
						$("#x_gxdwdm").attr("value", $("#t_gxdwdm").attr("value"));
					
				}
			}
		});
		if(ganjCol==''){
				thePlayColWidths = thePlayColWidths1;
				
			}
		var result = "<table id='table1' width='100%'><thead><tr>";
		result += ganjCol;
		result += "<th name='l_qybm' datatype='String' sumflag='0'>场所编码</th>";
		result += "<th name='l_qymc' datatype='String' sumflag='0'>场所名称</th>";
		result += "<th name='l_wdbts' datatype='Integer' sumflag='0'>未达标天数</th>";
		result += "<th name='l_yljts' datatype='Integer' sumflag='0'>月累计天数</th>";
		result += "<th name='l_nljts' datatype='Integer' sumflag='0'>年累计天数</th>";
		result += "</tr></thead><tbody></tbody></table>";
		$("#tabledata").html(result);
		
		
    }
    // 校验
    function manVerify(){
        if (!checkControlValue("t_qssj","Date",null,null,null,1,"起始日期"))
			return false;
		if (!checkControlValue("t_jzsj","Date",null,null,null,1,"截止日期"))
			return false;
        var t_qssj = $("#t_qssj").attr("value");
		var t_jzsj = $("#t_jzsj").attr("value");
		if(t_qssj!=''&&t_jzsj!=''&&formatDate(t_qssj)-formatDate(t_jzsj)>0){
			jAlert("请正确选择起始和截至日期!","提示信息");
			return false;
		}
		return true;
	}
	// 转换成日期格式

	function formatDate(strDate){ 
		var riqi = strDate.split("-");
		return new Date(riqi[0],(riqi[1]-1),riqi[2]);
	}
	// 查询
	function startTjcx(){ 
	    if(manVerify()){
		    createDataTable();
		    loadPage("tabledata");
		    setPageList(1);
		}
	}
	// 设定数据列表
	function setPageList(pageno,url){
		url=setList(pageno,url);
		setParams("t_"); 
		var mygrid1 = $("#"+tableid).ingrid({
				ingridPageParams:sXML,
				url: url,
				height: pageHeight-260,
				pageNumber: pageno,
				colWidths: thePlayColWidths,
				onRowSelect: null,
				onTdSelect: function(tr){
												   var qybm = $(tr).find("td").eq(1);
													qybm.html("<a href='#' class='hyperlink' onClick=setQyDetailone('"+qybm.text()+"');>"+qybm.text()+"</a>");
												   var qybmmc = $(tr).find("td").eq(2);
													qybmmc.html("<a href='#' class='hyperlink' onClick=setQyDetailone('"+qybm.text()+"');>"+qybmmc.text()+"</a>");
												
											
											},
										
				changeHref:function(table){
					        
										$(table).find("tr").each(function(){
													var temp1=$(this).attr('id');
													 if($(this).find("td:nth(3)").text()>0){
																var temp=$(this).find("td:nth(3)").text();
																var qybms=$(this).find("td:nth(1)").text();
																
															$(this).find("td:nth(3)").html("<a href='#' class='hyperlink' onClick=setScbcfxxQuery('"+temp1+"','"+qybms+"');>"+temp+"</a>");
															}
													});
												
											},
				
				
				
				sorting: true
				
		});
	}
	// 导出Excel
	function setExportExcel(){ 
	    if(manVerify()){
		    createDataTable();
		    geteExcelHead("tabledata");
		    setSearchLong();
		    loadPage("tabledata");
		    setPageList(1);
		}
	}
	/*
	不分页传参数将结果集返回，用于长参数导出前的查询
	*/
	function setSearchLong(){
		setParams("t_");
		jQuery.post(searchLongUrl,params,searchLongBack,"json");
	}
	//导出前对应setSearchLong()的回调方法  由于执行查询时候有延迟，故将导出放入回调函数

	function searchLongBack(json){  
		//报表标题
		var bbmc="场所上传不充分统计";
		//报表请求
		setExcelLong("csxxExcel",bbmc);	
	}
	/*setExcel 生成EXCEL,不传参数，防止超长

	 * excelid 链接id
	 * bbmc：报表标题

	 */
	function setExcelLong(excelid,bbmc){
		var surl=excelUrl+"?tabletitle="+tabletitle+"&bbmc="+bbmc;
		surl=encodeURI(surl);
		location.href = surl;
	}
	
   function setScbcfxxQuery(id,qybms){
         setXParmValue(id);
	     detailid="qyscbcfxx_detail";
		 setWidth(detailid,"1000");
	     $('#'+detailid).css('left','5').css('top','30');
	     $("#x_qybm").attr("value", qybms);
		 var url="basic/publicsystem/QyscbcfManXx.jsp";
	    setUrl(detailid,url);
	}
	
  function setQyDetailone(qybms){
		qyjbxx_dataid="qybm_"+qybms;
		detailid="qyscbcfxx_detail";
		setWidth(qyjbxx_detailid,qyjbxx_detailWidth);
		setUrl(qyjbxx_detailid,qyjbxx_detailHtml);
		bindDocument(qyjbxx_detailid);
}
function setXParmValue(id){
		if(jb!=null&&jb!=''){
					if(jb=='ds'){
						 $("#x_dsjgdm").attr("value", id);
					}
					if(jb=='fxj'){
						 $("#x_fxjdm").attr("value", id);
					}
					if(jb=='gxdw'){
						 $("#x_gxdwdm").attr("value", id);
					}
					
				}
	  }
	
	
	
</script>
</head>
<body>
<input type="hidden" id="k_deptCode">

<input type="hidden" id="t_dsjgbz" value="0">
<input type="hidden" id="t_dsjgdm">
<input type="hidden" id="t_fxjbz" value="0">
<input type="hidden" id="t_fxjdm">
<input type="hidden" id="t_gxdwbz" value="0">
<input type="hidden" id="t_gxdwdm">

<input type="hidden" id="x_dsjgbz" value="0">
<input type="hidden" id="x_dsjgdm">
<input type="hidden" id="x_fxjbz" value="0">
<input type="hidden" id="x_fxjdm">
<input type="hidden" id="x_gxdwbz" value="0">
<input type="hidden" id="x_gxdwdm">
<input type="hidden" id="x_hylbdm">
<input type="hidden" id="x_qssj">
<input type="hidden" id="x_jzsj">
<input type="hidden" id="x_ztdm">
<input type="hidden" id="x_qybm">



<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">场所上传不充分信息统计</td>
  </tr>
  <tr>
    <td valign="top" class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
		<tr id="gajgAll">
			<td width="10%" class="pagedistd">
			<input dataKey="dsjgdm" type="checkbox" id="ch_dsjgdm" onClick="ksd_gajgSelect(this);"/>市级公安机关</td>
			<td width="23%" class="pagetd">
			<select name="cylb" id="bq_dsjgdm" onChange="ksd_dsjgdmOnchange();"><option>全部</option></select>
			</td>
			<td width="10%" class="pagedistd">
			<input dataKey="fxjdm" type="checkbox" id="ch_fxjdm" onClick="ksd_gajgSelect(this);">分县局公安机关</td>
			<td width="23%" class="pagetd">
			<select name="cylb" id="bq_fxjdm" onChange="ksd_fxjdmOnchange();"><option>全部</option></select></td>
			<td width="10%" class="pagedistd">
			<input dataKey="gxdwdm" type="checkbox" id="ch_gxdwdm" onClick="ksd_gajgSelect(this);">科所队</td>
			<td width="23%" class="pagetd">
			<select name="cylb" id="bq_gxdwdm" onChange="ksd_gxdwdmOnchange();"><option>全部</option></select></td>
		</tr>
		<tr id="cszflAll">
		   <td class="pagedistd">行业类别</td>
			<td class="pagetd"><select type="select" id="t_hylbdm"></select></td>
			<td class="pagedistd">起始时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_qssj"></td>
			<td class="pagedistd">截止时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_jzsj"></td>
		</tr>
			<tr >
		    <td class="pagedistd">是否注销</td>
			<td class="pagetd"><select type="select" id="t_ztdm"><option >全部</option></select></td>
			<td class="pagedistd">&nbsp;</td>
			<td class="pagedistd">&nbsp;</td>
			<td class="pagedistd">&nbsp;</td>
			<td width="23%"  class="pagetd">
				<table width="186px" border="0" align="right" cellpadding="2" cellspacing="0">
				<tr>
				<td><a href="#" class="searchbutton" onClick="startTjcx();">查询</a></td>
				<td><a href="#" class="exceldcbutton" onClick="setExportExcel()" id="csxxExcel">导出</a></td>
				</tr>
				</table>
			</td>
		</tr>
    	</table>
    </td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<div id="qyscbcfxx_detail" class="page-layout" src="#" style="top:20px; left:160px; width:1000px;"></div>
<div id="qyjbxxone_detail" class="page-layout" src="#" style="top:20px; left:160px; width:1000px;"></div>
<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>
        <th name='l_qybm' datatype='String' sumflag='0'>场所编码</th>
        <th name='l_qymc' datatype='String' sumflag='0'>场所名称</th>
		<th name='l_wdbts' datatype='Integer' sumflag='0'>未达标天数</th>
		<th name='l_yljts' datatype='Integer' sumflag='0'>月累计天数</th>
		<th name='l_nljts' datatype='Integer' sumflag='0'>年累计天数</th>
	    </tr>
	  </thead>
	</table>
</div>
</body>
</html>