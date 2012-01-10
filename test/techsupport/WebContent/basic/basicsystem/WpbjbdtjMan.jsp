<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_wpbjbdtj.action";
	divnid="WpbjbdtjData";
	tableid="WpbjbdtjTable";
	addUrl="basicsystem/insert_wpbjbdtj.action";
	addHtml="business/basicsystem/WpbjbdtjAdd.jsp";
	addWidth="800";
	delUrl="basicsystem/delete_wpbjbdtj.action";
	delid="d_bjxxid2";
	modHtml="business/basicsystem/WpbjbdtjModify.jsp";
	modUrl="basicsystem/modify_wpbjbdtj.action";
	modWidth="800";
	detailHtml="business/basicsystem/WpbjbdtjDetail.jsp";
	detailid="wpbjbdtj_detail";
	detailUrl="basicsystem/query_wpbjbdtj.action";
	detailWidth="800";
	loadPage(divnid);
	
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
										colWidths: ["9%","9%","9%","9%","9%","9%","9%","9%","9%","9%","9%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("p_wpbjgzid","Integer",-9999999999,9999999999,null,0,"物品报警规则ID"))
			return false;
		if (!checkControlValue("p_wpbjbdtjid","Integer",-9999999999,9999999999,null,0,"物品报警比对条件ID"))
			return false;
		if (!checkControlValue("p_tjlx","String",1,2,null,0,"条件类型"))
			return false;
		if (!checkControlValue("p_ywbzdm","String",1,60,null,0,"业务表字段名"))
			return false;
		if (!checkControlValue("p_bdbzdm","String",1,60,null,0,"比对表字段名"))
			return false;
		if (!checkControlValue("p_bdgx","String",1,20,null,0,"比对关系"))
			return false;
		if (!checkControlValue("p_gxc","String",1,200,null,0,"关系串"))
			return false;
		if (!checkControlValue("p_zxsx","String",1,100,null,0,"执行顺序"))
			return false;
		if (!checkControlValue("p_ljgx","String",1,100,null,0,"逻辑关系"))
			return false;
		if (!checkControlValue("p_jibie","Integer",-999999,999999,null,0,"级别"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_bjxxid2" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">报警信息ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bjxxid2" value="0"></td>
					<td width="10%" class="pagedistd">物品报警规则ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_wpbjgzid" value="0"></td>
					<td width="10%" class="pagedistd">物品报警比对条件ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_wpbjbdtjid" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">条件类型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tjlx" value=""></td>
					<td width="10%" class="pagedistd">业务表字段名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ywbzdm" value=""></td>
					<td width="10%" class="pagedistd">比对表字段名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bdbzdm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">比对关系</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bdgx" value=""></td>
					<td width="10%" class="pagedistd">关系串</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gxc" value=""></td>
					<td width="10%" class="pagedistd">执行顺序</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zxsx" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">逻辑关系</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ljgx" value=""></td>
					<td width="10%" class="pagedistd">级别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jibie" value="0"></td>
				</tr>
    		<tr>
    		  <td colspan="6">
    		  	<table  border="0" align="right"  cellpadding="2"  cellspacing="0">
    		    	<tr>
    		    	  <td width="50%" class="querybutton"><a href="#" class="querybuttonfont" id="querys" onclick="setPageList(1);">查询</a></td>
    		    	  <td width="50%" class="addbutton"><a href="#" class="addbutton" onclick='setAddPage()'>添加</a></td>
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
<div id="wpbjbdtj_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="WpbjbdtjData" style="width:100%;">
	<table id="WpbjbdtjTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_wpbjgzid">物品报警规则ID</th>
	     	<th name="l_wpbjbdtjid">物品报警比对条件ID</th>
	     	<th name="l_tjlx">条件类型</th>
	     	<th name="l_ywbzdm">业务表字段名</th>
	     	<th name="l_bdbzdm">比对表字段名</th>
	     	<th name="l_bdgx">比对关系</th>
	     	<th name="l_gxc">关系串</th>
	     	<th name="l_zxsx">执行顺序</th>
	     	<th name="l_ljgx">逻辑关系</th>
	     	<th name="l_jibie">级别</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>