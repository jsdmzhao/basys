<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var daochuNum = 0;//是否可以导出Excle标志，0-无法导出，1-可以导出
$(document).ready(function() {
		$("#p_qssj").attr("readonly","true");
		$("#p_qssj").datepicker();
		$("#p_jzsj").attr("readonly","true");
		$("#p_jzsj").datepicker();
	pageUrl="basicsystem/querylistYz_qycftj.action";
	divnid="YzxxData";
	tableid="YzxxTable";	
	detailid="yzxx_detail";
	detailWidth="800";
	
	//导出
	searchLongUrl="basicsystem/queryqycflistExcelTemp_qycftj.action";  //超长参数后台Action对应url
	tabletitle = "";	 
	geteExcelHead(divnid);	
	excelUrl="basicsystem/querylistExcel_qycftj.action";
	
	loadPage(divnid);
	
	
	
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										height:  pageHeight - 210,
										pageNumber: pageno,
										ingridPageParams:sXML,
										onRowSelect: function(tr, selected){},
										sumFlag: true,
										changeHref:function(table){//若表格无数据，则点击导出不起作用
											//$("#gnlkexcel").unbind("click");
											if($(table).find("tr").length==0){
													daochuNum = 0;
												}else{
													daochuNum = 1;
												}	
										},
										colWidths: ["30%","20%","10%","10%","10%","10%","10%"]									
									});				
		}
}	
	function manVerify(){
	 /**
	     if (!checkControlValue("p_gxdwmc","String",1,100,null,1,"公安机关"))
			return false;
		 if (!checkControlValue("p_qssj","String",1,20,null,1,"起始日期"))
			return false;
		 if (!checkControlValue("p_jzsj","String",1,20,null,1,"截止日期"))
			return false;**/
		
		return true;
	}
	
	function qycftj(){
	    if (!checkControlValue("p_gxdwmc","String",1,100,null,1,"公安机关"))
			return false;
		 if (!checkControlValue("p_qssj","String",1,20,null,1,"起始日期"))
			return false;
		 if (!checkControlValue("p_jzsj","String",1,20,null,1,"截止日期"))
			return false;
		setPageList(1);
		return true;
	}
	
	/////管辖单位tree
	$("#p_gxdwmc").click(function(){
		getGxdwTree("p_gxdwmc","p_gxdwdm");
	 });
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
			var bbmc="企业处罚统计";
		//报表请求	
			setExcelLong("qycfexcel",bbmc);	
}
</script>

<body>
<input type="hidden" id="p_gxdwdm">
	
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">统计选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="red">公安机关</td>
				  <td width="19%" class="pagetd"><input type="text" class="inputstyle" id="p_gxdwmc" value="" readonly></td>
					<td width="10%" class="red">起始日期</td>
				  <td width="20%" class="pagetd"><input type="text" class="inputstyle" id="p_qssj" value=""></td>
					<td width="10%" class="red">截止日期</td>
				  <td width="20%" class="pagetd"><input type="text" class="inputstyle" id="p_jzsj" value=""></td>
				
					<td width="23%" class="pagetd" ><table  border="0" align="right"  cellpadding="2"  cellspacing="0">
                    <tr>
                      <td width="50%" ><a href="#" class="searchbutton" id="querys" onClick="qycftj();">统计</a></td>
                      <td width="50%" ><a href="#" class="exceldcbutton" id="querys" onClick="setExportExcel();">导出</a></td>
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
<div id="yzxx_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="YzxxData" style="width:100%;">
	<table id="YzxxTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name='l_gxdwmc' datatype='String' sumflag='0'>单位</th>
	     	<th name='l_xiaoji' datatype='String' sumflag='0'>企业处罚总数</th>
	     	<th name='l_jgcs' datatype='String' sumflag='0'>警告次数</th>
	     	<th name='l_fmcs' datatype='String' sumflag='0'>罚没次数</th>
	     	<th name='l_tdcs' datatype='String' sumflag='0'>停吊次数</th>
	     	<th name='l_zjcs' datatype='String' sumflag='0'>追究次数</th>
	     	<th name='l_qtfmcs' datatype='String' sumflag='0'>其他处罚次数</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>