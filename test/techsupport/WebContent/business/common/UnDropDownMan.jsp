<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
var tables_un;
$(document).ready(function() {
	tables_un = $("#UnData").html();
	setPageListUnDropDown(1,"#");
}); 
	
function setPageListUnDropDown(pageno,url){	
	if (manVerify_un()){
		createXML("x_");
		$("#UnData").html(tables_un);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#UnTable").ingrid({ 
										tableid:"jdhxp_un_glTable",
										url:url,	
										ingridPageWidth:650,
										height: 250,
                                       	ingridPageParams:sXML,
										pageNumber: pageno,
										//hideColIndex:[2,5],
										ingridHightSpeed:true,     
										sorting:false,
										paging:false,
										onRowSelect:function(tr){
											$(tr).dblclick(function(){
												getGlUnjdhxp($(this).attr("id")); 	
											});
										},
										colWidths: ["9%","9%","40%","36%","6%"]									
			});				
		}
}	
	function manVerify_un(){
		if (!checkControlValue("x_pxh","Integer",0,999999,null,0,"名目编号"))
			return false;
		if (!checkControlValue("x_unbm","String",1,10,null,0,"UN编号"))
			return false;
		if (!checkControlValue("x_hxm","String",1,200,null,0,"涉及品名(化学名)"))
			return false;
		//if (!checkControlValue("x_bm","String",1,200,null,0,"品名（别名）"))
		//	return false;
		return true;
	}
	
function getGlUnjdhxp(id){
	if(gdmId!=null){
		var trObj = $("#jdhxp_un_glTable #"+id);
		$("#"+gdmId.unid).val(trObj.attr("id"));
		$('#z_unid').val(trObj.attr("id"));
		setParams("z_");
		//jQuery.post("jdhxpsys/query_un.action",params,jdun_updatediv,"json");
		jQuery.ajax({
						type: 'POST',
						url: "jdhxpsys/query_un.action",
						data: params,
						async: false,
						dataType: 'json',
						success: function(result){	
							jdun_updatediv(result);
						}});
		
	}
}	
function jdun_updatediv(json){
		$("#"+gmcId).val(setNull(json.LUn[0].unbm));
		$("#"+gdmId.bm).val(setNull(json.LUn[0].bm));
		$("#"+gdmId.hxm).val(setNull(json.LUn[0].hxm));
		$("#"+gdmId.ywm).val(setNull(json.LUn[0].ywm));
		$("#"+gdmId.ywbm).val(setNull(json.LUn[0].ywbm));	
		$("#jdhxppz_item").children().remove();
		$("#jdhxppz_item").hideAndRemove("show");
}
function clearGlUnjdhxp(id){
	if(gdmId!=null){
		$("#"+gdmId.unid).val("");
		$("#"+gmcId).val("");
		$("#"+gdmId.bm).val("");
		$("#"+gdmId.hxm).val("");
		$("#"+gdmId.ywm).val("");
		$("#"+gdmId.ywbm).val("");
	}
}

function closeAndRemove(){
	$("#jdhxppz_item").children().remove();
	$("#jdhxppz_item").hideAndRemove("show");
}
</script>
<input type="hidden" id="z_unid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">剧毒化学品品种选择</td>
      <td align="right"><a href="#" id="closeDiv" onclick='closeAndRemove();' class="close"></a></td>
    </tr>
</table>
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="18%" class="pagedistd">名目编号</td>
					<td width="32%" class="pagetd"><input type="text" id="x_pxh" class="inputstyle" /></td>
					<td width="18%" class="pagedistd">UN编号</td>
					<td width="32%" class="pagetd"><input type="text" id="x_unbm" class="inputstyle" /></td>
				</tr>
				<tr>
					<td class="pagedistd" nowrap>涉及品名(化学名)</td>
					<td class="pagetd"><input type="text" id="x_hxm" class="inputstyle" /></td>
					<td colspan="2">
	    		  	<table  border="0" align="right"  cellpadding="2"  cellspacing="0">
	    		    	<tr>
	    		    	  <td width="50%"><a href="#" class="searchbutton" id="querys" onclick="setPageListUnDropDown(1,'jdhxpsys/querylistXz_un.action');">查询</a></td>
	    		    	  <td width="50%"><a href="#" class="submitbutton" id="querys" onclick="clearGlUnjdhxp(1);">清除</a></td>
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
<div id="UnData" style="width:100%;">
	<table id="UnTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_pxh">名目编号</th>
	     	<th name="l_unbm">UN编号</th>
	     	<th name="l_hxm">涉及品名(化学名)</th>
	     	<th name="l_ywm">英文名</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>