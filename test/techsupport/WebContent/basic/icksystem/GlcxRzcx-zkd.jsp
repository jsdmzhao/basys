<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var glcxrzcx_tables = "";
	var glcxrzcx_pageUrl="icksystem/queryRzcxZkdList_icksl.action";
	var glcxrzcx_divnid="glcxrzcx_tabledata";
	var glcxrzcx_tableid="glcxrzcx_table1";
	
	$(document).ready(function(){
		// 行业类别	
 		$("#p_hylbdm").selectBoxhylb({code:"dm_hylb"});
		glcxrzcx_loadPage("glcxrzcx_tabledata");
	}); 
	function glcxrzcx_setPageList(pageno,url){
		if (glcxrzcx_manVerify()){
			url=glcxrzcx_setList(pageno,url);
			var mygrid1 = $("#"+glcxrzcx_tableid).ingrid({ 
											ingridPageParams:sXML,
											ingridPageWidth: pageWidth,
											url: url,
											height: pageHeight-205,
											pageNumber: pageno,
											hideColIndex:[0],
											onRowSelect: function(tr, selected){ },
											colWidths: ["0%","18%","18%","10%","16%","22%","16%"]									
										});				
		}
	}
	function glcxrzcx_loadPage(divpageid){
		glcxrzcx_tables=$("#"+divpageid).html();
		glcxrzcx_setPageList(1,'#');
	}
	function glcxrzcx_setList(pageno,url){
		$("#"+glcxrzcx_divnid).html(glcxrzcx_tables);
		setParams("p_");
		if (url==null || url=="undefined"){
			url=glcxrzcx_pageUrl;
		}
		return url;
	}
	function glcxrzcx_manVerify(){
		if (!checkControlValue("p_xm","String",1,20,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_cyrybh","String",1,30,null,0,"从业人员编号"))
			return false;
		if (!checkControlValue("p_czlb","String",1,30,null,0,"操作类别"))
			return false;
		return true;
	}
</script>

</head>
<body>
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">日志查询条件</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
			<tr>
			<td width="8%" class="pagedistd">行业类别</td>
			<td width="15%" class="pagetd"><select name="select" id="p_hylbdm"><option></option></select></td>
			<td width="8%" class="pagedistd">姓名</td>
			<td width="15%" class="pagetd"><input type="text" class="inputstyle"  id="p_xm" value=""></td>
			<td width="8%" class="pagedistd">从业人员编号</td>
			<td width="15%" class="pagetd"><input type="text" class="inputstyle"  id="p_cyrybh" value=""></td>
			<td width="8%" class="pagedistd">操作类别</td>
			<td width="12%" class="pagetd"><input type="text" class="inputstyle"  id="p_czlb" value=""></td>
			<td colspan="4">
   		  	  	<table width="62" border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
					<td><a href="#" class="searchbutton" id="querys" onClick="glcxrzcx_setPageList(1);">查询</a></td>
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

<div id="glcxrzcx_tabledata" style="width:100%;">
	<table id="glcxrzcx_table1" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_glbh">关联编号</th>
	     	<th name="l_pch">批次号</th>
	     	<th name="l_cyrybh">从业人员编号</th>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_czlb">操作类别</th>
	     	<th name="l_czr">操作人</th>
	     	<th name="l_czsj">操作时间</th>
	    </tr>
	  </thead>
	</table>
</div>
</body>
</html>