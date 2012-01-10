<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<html>
<script type="text/javascript">
var exportState = 0;
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="icksystem/querylist_st_device.action";
	divnid="St_deviceData";
	tableid="St_deviceTable";
	
	addUrl="icksystem/insert_st_device.action";
	addHtml="basic/icksystem/St_deviceAdd.jsp";
	addWidth="800";
	
	delUrl="icksystem/delete_st_device.action";
	delid="d_dev_serial";
	
	modHtml="basic/icksystem/St_deviceModify.jsp";
	modUrl="icksystem/modify_st_device.action";
	modWidth="800";
	
	detailHtml="basic/icksystem/St_deviceDetail.jsp";
	detailid="st_device_detail";
	detailUrl="icksystem/query_st_device.action";
	detailWidth="800";
	
	
	
	
	
		//导出功能
	tabletitle = "";
	geteExcelHead("St_deviceData");
	//ExcelURL
	excelUrl="icksystem/excelCreate_st_device.action";
	
	loadPage("St_deviceData");
	daggleDiv("st_device_detail");
	
	
}); 
	
function setPageList(pageno,url){	


	if (manVerify()){
		url=setList(pageno,url);
		var mygrid1 = $("#"+tableid).ingrid({ 
		                               ingridPageParams:sXML, 
										ingridPageWidth: pageWidth,
										url: url,	
										height: pageHeight-230,
										
										colClasses: ['grid-col-style2','grid-col-style2'],
										colIndex: [4,5],
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
													var tdnum = $(tr).find("td").index(this);
													if(tdnum!=$(tr).find("td").length-1){
														if(tdnum==4)
															setCsDetail(tr);
														else if(tdnum==5)
															setCsDetail(tr);
														else {
															setServiceDetail(tr); 	
													   }
													}
											});
										},
										
										
										onRowSelect:null,
										
										pageNumber: pageno,
										colWidths: ["12%","12%","12%","12%","14%","14%","12%","12%"]									
									});				
		}
}	
	function manVerify(){
		
		if (!checkControlValue("p_dev_name","String",1,100,null,0,"设备名称"))
			return false;
			
			if (!checkControlValue("p_mac","String",1,25,null,0,"终端MAC地址"))
			return false;
			
					if (!checkControlValue("p_dev_ip","String",1,20,null,0,"设备IP"))
			return false;
				
			
			
		return true;
	}


	//场所详细查询
var qyjbxx_dataid;

function setCsDetail(obj){
	qyjbxx_dataid="qybm_"+$(obj).find("td:nth(4)").text();
	setWidth(detailid,990);
	setUrl(detailid,"basic/publicsystem/QyjbxxDetail.jsp");
	bindDocument(detailid);
}

//
function setServiceDetail(obj){
	dataid=$(obj).attr("id");
	detailUrl="icksystem/query_st_device.action";
	setWidth(detailid,modWidth);
	setUrl(detailid,detailHtml);
	bindDocument(detailid);
}
	
	
	// 行业类别	
$("#p_hylbdm").selectBoxhylb();
// 企业筛选框
$("#p_qymc").click(function(){
    dataid=$('#p_hylbdm').val();
 	getTy_item("p_qymc","p_csbm");
  });
</script>

<body>
	
	<input type="hidden" id="d_dev_serial" value="">
	<input type="hidden" id="p_csbm" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">无线终端设备管理</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
				
				    <td width="10%" class="pagedistd">行业类别</td>
				    <td width="23%" class="pagetd"><select  id="p_hylbdm" ></select></td>
		        	<td width="10%" class="pagedistd">场所名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qymc" readonly class="inputstyle"></td>
				   <td width="10%" class="pagedistd">设备名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dev_name" class="inputstyle" value=""></td>
				</tr>
				<tr>
					
				    <td width="10%" class="pagedistd">MAC地址</td>
					<td width="23%" class="pagetd"><input type="text" id="p_mac" class="inputstyle" value=""></td>
				    <td width="10%" class="pagedistd">设备IP</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dev_ip" class="inputstyle" value=""></td>
			
    		      <td  colspan="2">
    		        	<table  border="0" align="right"  cellpadding="2"  cellspacing="0">
    		    	   <tr>
    		    	   <td width="50%" ><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
    		    	   <td width="40%" ><a href="#" class="addbutton"  onclick='setAddPage()'>添加</a></td>
    		    	   	   <td width="10%" ></td>
    		       	    </tr>
    		     	</table>  
    		  	</td>
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
<div id="st_device_detail" class="page-layout" src="#" style="top:5px;">
</div>	
<div id="St_deviceData" style="width:100%;">
	<table id="St_deviceTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_dev_name">设备名称</th>
	     	<th name="l_mac">终端MAC地址</th>
	     	<th name="l_dev_ip">设备IP</th>
	    	<th name="l_port">端口号</th>
	        <th name="l_csbm">场所编码</th>
	        <th name="l_qymc">场所名称</th>
	        <th name="l_run_state">设备当前状态</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>