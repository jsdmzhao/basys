<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_bjjsx.action";
	divnid="BjjsxData";
	tableid="BjjsxTable";
	addUrl="basicsystem/insert_bjjsx.action";
	addHtml="basic/basicsystem/BjjsxAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_bjjsx.action";
	delid="d_bjjxh";
	modHtml="basic/basicsystem/BjjsxModify.jsp";
	modUrl="basicsystem/modify_bjjsx.action";
	modWidth="500";
	detailHtml="basic/basicsystem/BjjsxDetail.jsp";
	detailid="bjjsx_detail";
	detailUrl="basicsystem/query_bjjsx.action";
	detailWidth="300";
	loadPage(divnid);
		$("#p_bjjsxj").attr("readonly","true");
		$("#p_bjjsxj").datepicker();
	
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										height: 250,
										pageNumber: pageno,
										colWidths: ["16%","16%","16%","16%","16%","16%"]									
									});				
		}
}	
	function manVerify(){
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_bjjxh" value="">
<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
    <td class="queryfont"><table width="62" border="0" align="right" cellpadding="0" cellspacing="0">
      <tr>
        <td width="100%"><a href="#" class="submitbutton" id="querys" onClick="setPageList(1);">查询</a></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="6"></td>
	</tr>
</table>
<div id="bjjsx_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="BjjsxData" style="width:100%;">
	<table id="BjjsxTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_gajgbm">公安机关编码</th>
	     	<th name="l_gajgmc">公安机关名称</th>
	     	<th name="l_bjjipdz">报警机IP地址</th>
	     	<th name="l_bjjsxj">报警机刷新时间</th>
	     	<th name="l_yscsxsjdjg">与上次刷新时间间隔</th>
			<th name="">操作</th>
		</tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>