<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var daochuNum = 0;//是否可以导出Excle标志，0-无法导出，1-可以导出	
$(document).ready(function() {

	
	pageUrl="sysadmin/queryDltjlist_loginlog.action";
	divnid="DltjData";
	tableid="DltjTable";
	detailid="dltj_detail";
	detailWidth="800";
	
	//导出
	/**
	searchLongUrl="yzyzagl/queryYzxxForExcel_tjyzy.action";  //超长参数后台Action对应url
	tabletitle = "";	 
	geteExcelHead(divnid);	
	excelUrl="yzyzagl/querylistExcel_tjyzy.action"; **/
	
    loadPage(divnid);
    
    
    $("#p_gxdwmc").attr("readonly","true");
	/////管辖单位tree
	$("#p_gxdwmc").click(function(){
	    getGxdwTree("p_gxdwmc","p_gxdwbm");
	    
	    //$("p_gxdwbm").val($("#p_gxdwmc").attr("titile"));
	   //alert($("p_gxdwbm").attr("value"));
	 });
	$("#p_kssj").attr("readonly","true");
	$("#p_kssj").datepicker();
	$("#p_jssj").attr("readonly","true");
	$("#p_jssj").datepicker();
    
    
}); 
	
function setPageList(pageno,url){	
		url=setList(pageno,url);
		setParams("p_");
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML, 
										url: url,	
										height: pageHeight-210,
										pageNumber: pageno,
										onRowSelect:null,
										sumFlag :true,  //汇总
										sorting :false, //不排序
										changeHref:function(table){//若表格无数据，则点击导出不起作用
											//$("#gnlkexcel").unbind("click");
											if($(table).find("tr").length==0){
													daochuNum = 0;
												}else{
													daochuNum = 1;
												}	
										},
										colWidths: ["50%","50%"]									
									});				
}	

function submitList(pageno,url){
	if (manVerify()){
		setPageList(pageno,url);
	}
}
	function manVerify(){
	     
		if (!checkControlValue("p_gxdwmc","String",1,120,null,1,"公安机关"))
			return false;
		if (!checkControlValue("p_kssj","String",1,10,null,1,"起始日期"))
			return false;
		if (!checkControlValue("p_jssj","String",1,10,null,1,"截止日期"))
			return false;
		var sprq = $("#p_kssj").val();
		var sprq2 = $("#p_jssj").val();
		
	    if(sprq>sprq2){
				jAlert("录入时间范围不正确","验证信息",null,"p_qssj");
				return false;
			}
		
		return true;
	}
	
/****
		//导出Excel
function setExportExcel(){	
  	//alert(daochuNum);
  	if(daochuNum==1){
		if (manVerify()){
  			setSearchLong(); //传全部参数将查询结果放入json，对应后台Action方法中将结果集放入session，用于处理超长参数的数据导出
  		}
  	}else{
  		alert('无查询结果不能导出！');
  	}		
}


//导出前对应setSearchLong()的回调方法  由于执行查询时候有延迟，故将导出放入回调函数
function searchLongBack(json){  
		//报表标题
			var bbmc="印章信息统计";
		//报表请求	
			setExcelLong("qycfexcel",bbmc);	
}


****/
</script>

<body>
	
<input type="hidden" id="p_gxdwbm" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">公安部门登录统计信息</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="red">公安机关</td>
				  <td width="19%" class="pagetd"><input type="text" class="inputstyle" id="p_gxdwmc" value=""></td>
					<td width="10%" class="red">起始日期</td>
				  <td width="20%" class="pagetd"><input type="text" class="inputstyle" id="p_kssj" value=""></td>
					<td width="10%" class="red">截止日期</td>
				  <td width="20%" class="pagetd"><input type="text" class="inputstyle" id="p_jssj" value=""></td>
		    <td width="23%" class="pagetd"><table  border="0" align="right"  cellpadding="2"  cellspacing="0">
                      <tr>
                        <td width="50%" class="querybutton"><a href="#" class="searchbutton" id="querys" onClick="submitList(1);">统计</a></td>
                     <!-- <td width="50%" class="querybutton"><a href="#" class="exceldcbutton" id="querys" onClick="setExportExcel();">导出</a></td>
                     -->
              </tr>
                    </table></td>
				</tr>
    	</table>
    </td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
	</tr>
</table>
<div id="dltj_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="DltjData" style="width:100%;">
	<table id="DltjTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_departname" datatype='String' sumflag='0'>单位</th>
	     	<th name="l_bjzs" datatype='String' sumflag='0'>登录数</th>
	    </tr>
	  </thead>
	</table>	
</div>

</body>