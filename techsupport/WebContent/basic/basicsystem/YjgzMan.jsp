<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_yjgz.action";
	divnid="YjgzData";
	tableid="YjgzTable";
	addUrl="basicsystem/insert_yjgz.action";
	addHtml="basic/basicsystem/YjgzAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_yjgz.action";
	delid="d_yjgzid";
	modHtml="basic/basicsystem/YjgzModify.jsp";
	modUrl="basicsystem/modify_yjgz.action";
	modWidth="500";
	detailHtml="basic/basicsystem/YjgzDetail.jsp";
	detailid="yjgz_detail";
	detailUrl="basicsystem/query_yjgz.action";
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
										colWidths: ["8%","8%","8%","8%","8%","8%","8%","8%","8%","8%","8%","8%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_yjgzid","Integer",-9999999999,9999999999,null,0,"预警规则ID"))
			return false;
		if (!checkControlValue("p_ywbm","String",1,100,null,0,"业务表名"))
			return false;
		if (!checkControlValue("p_bdbm","String",1,100,null,0,"比对表名"))
			return false;
		if (!checkControlValue("p_bdlx","String",1,2,null,0,"比对类型"))
			return false;
		if (!checkControlValue("p_sfyx","String",1,2,null,0,"是否有效"))
			return false;
		if (!checkControlValue("p_fbcl","String",1,300,null,0,"发布策略"))
			return false;
		if (!checkControlValue("p_fbfs","String",1,2,null,0,"发布方式"))
			return false;
		if (!checkControlValue("p_txdwzd","String",1,60,null,0,"特行单位字段"))
			return false;
		if (!checkControlValue("p_gxdwzd","String",1,60,null,0,"管辖单位字段"))
			return false;
		if (!checkControlValue("p_yjjb","String",1,2,null,0,"预警级别"))
			return false;
		if (!checkControlValue("p_yjfs","String",1,60,null,0,"预警方式"))
			return false;
		if (!checkControlValue("p_yjlx","String",1,60,null,0,"预警类型"))
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
					<td width="10%" class="pagedistd">业务表名</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ywbm" value=""></td>
					<td width="10%" class="pagedistd">比对表名</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bdbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">比对类型</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bdlx" value=""></td>
					<td width="10%" class="pagedistd">是否有效</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_sfyx" value=""></td>
					<td width="10%" class="pagedistd">发布策略</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_fbcl" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">发布方式</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_fbfs" value=""></td>
					<td width="10%" class="pagedistd">特行单位字段</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_txdwzd" value=""></td>
					<td width="10%" class="pagedistd">管辖单位字段</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_gxdwzd" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">预警级别</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_yjjb" value=""></td>
					<td width="10%" class="pagedistd">预警方式</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_yjfs" value=""></td>
					<td width="10%" class="pagedistd">预警类型</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_yjlx" value=""></td>
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
<div id="yjgz_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="YjgzData" style="width:100%;">
	<table id="YjgzTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_ywbm">业务表名</th>
	     	<th name="l_bdbm">比对表名</th>
	     	<th name="l_bdlx">比对类型</th>
	     	<th name="l_sfyx">是否有效</th>
	     	<th name="l_fbcl">发布策略</th>
	     	<th name="l_fbfs">发布方式</th>
	     	<th name="l_txdwzd">特行单位字段</th>
	     	<th name="l_gxdwzd">管辖单位字段</th>
	     	<th name="l_yjjb">预警级别</th>
	     	<th name="l_yjfs">预警方式</th>
	     	<th name="l_yjlx">预警类型</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>