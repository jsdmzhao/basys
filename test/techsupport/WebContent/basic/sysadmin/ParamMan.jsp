<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="sysadmin/querylist_param.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="sysadmin/insert_param.action";
	addHtml="basic/sysadmin/ParamAdd.jsp";
	addWidth="500";
	delUrl="sysadmin/delete_param.action";
	modHtml="basic/sysadmin/ParamModify.jsp";
	modUrl="sysadmin/modify_param.action";
	modWidth="500";
	detailHtml="basic/sysadmin/ParamDetail.jsp";
	detailid="param_detail";
	detailUrl="sysadmin/query_param.action";
	detailWidth="300";
	loadPage("tabledata");
	
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
										colWidths: ["33%","33%","33%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_paramcode","String",1,50,null,0,"参数编码"))
			return false;
		if (!checkControlValue("p_paramname","String",1,50,null,0,"参数名称"))
			return false;
		if (!checkControlValue("p_paramvalue","String",1,1000,null,0,"参数值"))
			return false;
		return true;
	}
</script>

</head>
<body>
	
	<input type="hidden" id="d_paramcode" value="">	
<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">参数编码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_paramcode" value=""></td>
					<td width="10%" class="pagedistd">参数名称</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_paramname" value=""></td>
					<td width="10%" class="pagedistd">参数值</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_paramvalue" value=""></td>
				</tr>
    		<tr>
    		  <td colspan="6">
    		  	<table width="80" border="0" align="right" cellpadding="0" cellspacing="0">
    		    	<tr>
    		    	  <td height="28px"><a href="#" class="querybuttom" id="querys" onClick="setPageList(1);">查询</a></td>
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
<div id="param_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	
<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_paramname">参数名称</th>
	     	<th name="l_paramvalue">参数值</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>