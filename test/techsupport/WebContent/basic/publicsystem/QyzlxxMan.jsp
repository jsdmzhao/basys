<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_qyzlxx.action";
	divnid="QyzlxxData";
	tableid="QyzlxxTable";
	addUrl="publicsystem/insert_qyzlxx.action";
	addHtml="basic/publicsystem/QyzlxxAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_qyzlxx.action";
	delid="d_qyzlxxid";
	modHtml="basic/publicsystem/QyzlxxModify.jsp";
	modUrl="publicsystem/modify_qyzlxx.action";
	modWidth="800";
	detailHtml="basic/publicsystem/QyzlxxDetail.jsp";
	detailid="qyzlxx_detail";
	detailUrl="publicsystem/query_qyzlxx.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_fbsj").attr("readonly","true");
		$("#p_fbsj").datepicker();
		$("#p_fbjzsj").attr("readonly","true");
		$("#p_fbjzsj").datepicker();
		
		$("#p_fbdwmc").click(function(){ //所属单位
			// getGxdw("p_ssdxjgajgmc","p_ssdxjgajgdm");
			getGxdwTree("p_fbdwmc","p_fbdwdm",null,null,null,null,null,null);
		});
		 $("#p_hylbdm").selectBoxhylb();//行业类别
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										onRowSelect:null,										
										url: url,	
										height: pageHeight-230,
                                       ingridPageParams:sXML,
										pageNumber: pageno,
										colWidths: ["25%","25%","25%","25%"]									
									});	
					// downloadFJ();
		}
}	
	function manVerify(){
		/*if (!checkControlValue("p_qyzlxxid","Integer",-9999999999,9999999999,null,0,"企业质量信息ID"))
			return false;
		if (!checkControlValue("p_hylbdm","String",1,3,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("p_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("p_fbdwdm","String",1,20,null,0,"发布单位代码"))
			return false;
		if (!checkControlValue("p_fbdwmc","String",1,60,null,0,"发布单位名称"))
			return false;
		if (!checkControlValue("p_fbr","String",1,30,null,0,"发布人"))
			return false;
		if (!checkControlValue("p_fbsj","Date",null,null,null,0,"发布时间"))
			return false;
		if (!checkControlValue("p_scbz","Integer",-99,99,null,0,"删除标志"))
			return false; */
		
			if (!checkControlValue("p_hylbdm","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("p_fbdwmc","String",1,60,null,0,"发布单位"))
			return false;			
		if (!checkControlValue("p_fbsj","Date",null,null,null,0,"发布时间"))
			return false;
			
		return true;
	}
	// 给附件名称加上链接
	function downloadFJ(id){
	var downloadURL="publicsystem/download_qyzlxx.action";
	var qyzlxxid=$("#"+id).attr("id");
	// var fjmc=$("#"+id).find("a").eq(0).text();
	// alert(fjmc);
	// alert(qyzlxxid);
	location.href=downloadURL+"?qyzlxxid="+qyzlxxid;
	}
	
	function setDeleteqyzlxx(id){
	sFlag="false";
	jConfirm('确定删除吗？', '删除提示', function(r) {
    	if(r==true){
			$("#"+delid).attr("value",id);
			setParams("d_");
	        jQuery.post(delUrl,params,deleteback,"json");
		}else{
		   return false;
		}
	});
}
</script>

<body>
	
	<input type="hidden" id="d_qyzlxxid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">				
				<tr>					
					<td width="10%" class="pagedistd">发布单位</td>
					<td width="23%" class="pagetd"><input type="text" id="p_fbdwmc" class="inputstyle" value="" readonly="readonly">
					<input type="hidden" id="p_fbdwdm" class="inputstyle" value="">
					</td>
									
					  <td class="pagetd" colspan="2">发布时间
		    			 <input type="text" class="inputstyle1" id="p_fbsj" readonly="readonly"> 至  
						 <input type="text" class="inputstyle1" id="p_fbjzsj" readonly="readonly"></td>
						 
						 <td width="10%" class="pagedistd">附件名称</td>
						<td width="23%" class="pagetd"><input type="text" id="p_fjmc" class="inputstyle" value=""></td>									
						 
				</tr>
				<tr>
									<!-- 	
					<td width="10%" class="pagedistd">行业类别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hylb" class="inputstyle" value="">
					<input type="hidden" id="p_hylbdm" class="inputstyle" value="">  
					</td>  
					-->
					<td class="pagedistd" width="10%">
							   行业类别
							</td>
							  <td class="pagetd" width="23%">
							       <select type="select" id="p_hylbdm" value="">
					               </select>
	                 </td>
	                  <td colspan="5">
    		  	<table  border="0" align="right"  cellpadding="2"  cellspacing="0">
    		    	<tr>
    		    	  <td width="50%" ><a href="#" class="searchbutton" id="querys" onclick="setPageList(1);">查询</a></td>
    		    	  <td width="50%" ><a href="#" class="addbutton" onclick='setAddPage()'>添加</a></td>
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
<div id="qyzlxx_detail" class="page-layout" src="#"
		style="top:180px; left:160px; height:300px;">
</div>	

<div id="QyzlxxData" style="width:100%;">
	<table id="QyzlxxTable" width="100%">
	  <thead>
	    <tr>       	     
	     	<th name="l_fbdwmc" >发布名称</th>	     	
	     	<th name="l_fbsj" >发布时间</th>
	     	<th name="l_fjmc">附件名称</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>