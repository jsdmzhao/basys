<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_yjbdtj.action";
	divnid="YjbdtjData";
	tableid="YjbdtjTable";
	addUrl="basicsystem/insert_yjbdtj.action";
	addHtml="basic/basicsystem/YjbdtjAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_yjbdtj.action";
	delid="d_yjgzid";
	modHtml="basic/basicsystem/YjbdtjModify.jsp";
	modUrl="basicsystem/modify_yjbdtj.action";
	modWidth="500";
	detailHtml="basic/basicsystem/YjbdtjDetail.jsp";
	detailid="yjbdtj_detail";
	detailUrl="basicsystem/query_yjbdtj.action";
	detailWidth="300";
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
										colWidths: ["10%","10%","10%","10%","10%","10%","10%","10%","10%","10%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_yjgzid","Integer",-9999999999,9999999999,null,0,"预警规则ID"))
			return false;
		if (!checkControlValue("p_yjbdtjid","Integer",-9999999999,9999999999,null,0,"预警比对条件ID"))
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
	
	<input type="hidden" id="d_yjgzid" value="">	
<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">预警规则ID</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_yjgzid" value="0"></td>
					<td width="10%" class="pagedistd">预警比对条件ID</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_yjbdtjid" value="0"></td>
					<td width="10%" class="pagedistd">条件类型</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_tjlx" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">业务表字段名</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ywbzdm" value=""></td>
					<td width="10%" class="pagedistd">比对表字段名</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bdbzdm" value=""></td>
					<td width="10%" class="pagedistd">比对关系</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bdgx" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">关系串</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_gxc" value=""></td>
					<td width="10%" class="pagedistd">执行顺序</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_zxsx" value=""></td>
					<td width="10%" class="pagedistd">逻辑关系</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ljgx" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">级别</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_jibie" value="0"></td>
				</tr>
    		<tr>
    		  <td colspan="6">
    		  	<table width="124" border="0" align="right" cellpadding="0" cellspacing="0">
    		    	<tr>
    		    	  <td width="50%" ><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
    		    	  <td width="50%" ><a href="#" class="addbutton" onclick='setAddPage()'>添加</a></td>
    		    	</tr>
    		  	</table>
    		  </td>
    		</tr>
    	</table>
    </td>
  </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
<div id="yjbdtj_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="YjbdtjData" style="width:100%;">
	<table id="YjbdtjTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_yjbdtjid">预警比对条件ID</th>
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