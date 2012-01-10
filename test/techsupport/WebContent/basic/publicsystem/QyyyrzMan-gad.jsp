<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	
	pageUrl="publicsystem/querylistforYlybzhGad_qyyyrz.action";
	divnid="QyyyrzData";
	tableid="QyyyrzTable";
	addUrl="publicsystem/insert_qyyyrz.action";
	addHtml="basic/publicsystem/QyyyrzAdd.jsp";
	addWidth="720";
	delUrl="publicsystem/delete_qyyyrz.action";
	delid="d_yyrzid";
	modHtml="basic/publicsystem/QyyyrzModify.jsp";
	modUrl="publicsystem/modify_qyyyrz.action";
	modWidth="720";
	detailHtml="basic/publicsystem/QyyyrzDetail.jsp";
	detailid="qyyyrz_detail";
	detailUrl="publicsystem/query_qyyyrz.action";
	detailWidth="380";
	loadPage(divnid);
	daggleDiv(detailid);
		$("#p_riqi").attr("readonly","true");
		$("#p_riqi").datepicker();
		$("#p_ksyysj").attr("readonly","true");
		$("#p_ksyysj").datepicker(true);
		$("#p_jsyysj").attr("readonly","true");
		$("#p_jsyysj").datepicker(true);
	$("#p_hylbdm").selectBoxhylb({code:"ggmk"});//行业类别

	checkmc();
	

}); 
		function checkmc(){
		if($("#p_hylbdm").val()!="J"){
			$('body').find('div [@id=qy]').each(function(r){
				$(this).show();
			});
			$('body').find('div [@id=cs]').each(function(){
				$(this).hide();
			});
		}
	}
	
	
	function setPageList(pageno,url){	
		if (manVerify()){
			url=setList(pageno,url);
			// create the grid
			// returns a jQ object with a 'g' property - that's ingrid
			var mygrid1 = $("#"+tableid).ingrid({ 
											url: url,	
											height: pageHeight-232,
	                                       ingridPageParams:sXML,
											pageNumber: pageno,
											onRowSelect: function(tr, selected){
												var str = selected?'SELECTED':'UNSELECTED';
												if(sFlag=="true"){
													if ($(tr).attr('_selected')=="true"){
														setQuery($(tr).attr("id")); 	
													}
												}else{
													sFlag="true";
												}					
											},
											colWidths: ["10%","16%","16%","23%","9%","14%","12%"]	
																			
										});				
			}
		checkmc();
}	
	function manVerify(){
		return true;
	}
	
	function setQuery(id){
		dataid=id;
		setWidth(detailid,detailWidth);
		setUrl(detailid,detailHtml);
		bindDocument(detailid);
	}

</script>

<body>
	<input type="hidden" id="d_yyrzid" value="">
	<input type="hidden" id="p_yyrzid" value="">
	<div style="display:none"><select id="p_hylbdm"></select></div>
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">营业日志</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
    		<tr>
				<td width="10%" class="pagedistd">场所治安备案编号</td>
				<td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_qybm"/></td>
				<td width="10%" class="pagedistd">场所名称</td>
				<td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_qymc"/>
				<td width="10%" class="pagedistd" >治安负责人</td>
				<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_zafzrxm" value=""></td>
			</tr>
			<tr>
				<td class="pagedistd">营业时间</td>
				<td class="pagetd" >
				<input type="text" class="inputstyle" id="p_ksyysj">
				</td>
				<td width="10%" class="pagedistd" >至  </td>
				<td width="23%" class="pagetd">
				<input type="text" class="inputstyle" id="p_jsyysj"></td>
				<td class="pagetd" colspan="2">
    		  	<table  border="0" align="right"  cellpadding="2"  cellspacing="0">
    		    	<tr>
    		    	  <td width="62px" ><a href="#" class="searchbutton" id="querys" onclick="setPageList(1);">查询</a></td>
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
<div id="qyyyrz_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="QyyyrzData" style="width:100%;">
	<table id="QyyyrzTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_riqi">登记日期</th>
	     	<th name="l_ksyysj">开始营业时间</th>
	     	<th name="l_jsyysj">结束营业时间</th>
	     	<th name="l_jsyysj">场所名称</th>
	     	<th name="l_csfe"><div id="cs" >场所负责人</div><div id="qy" style="display:none">企业负责人</div></th>
	     	<th name="l_sffsaj">治安、刑事或事故</th>
	     	<th name="l_sfglbmjc">管理部门检查</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
</body>