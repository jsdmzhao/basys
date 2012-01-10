<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_wpbjgz.action";
	divnid="WpbjgzData";
	tableid="WpbjgzTable";
	addUrl="basicsystem/insert_wpbjgz.action";
	addHtml="business/basicsystem/WpbjgzAdd.jsp";
	addWidth="800";
	delUrl="basicsystem/delete_wpbjgz.action";
	delid="d_bjxxid2";
	modHtml="business/basicsystem/WpbjgzModify.jsp";
	modUrl="basicsystem/modify_wpbjgz.action";
	modWidth="800";
	detailHtml="business/basicsystem/WpbjgzDetail.jsp";
	detailid="wpbjgz_detail";
	detailUrl="basicsystem/query_wpbjgz.action";
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
										colWidths: ["5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("p_wpbjgzid","Integer",-9999999999,9999999999,null,0,"物品报警规则ID"))
			return false;
		if (!checkControlValue("p_ywbm","String",1,100,null,0,"业务表名"))
			return false;
		if (!checkControlValue("p_ywbzdm","String",1,60,null,0,"业务表字段名"))
			return false;
		if (!checkControlValue("p_bdbm","String",1,100,null,0,"比对表名"))
			return false;
		if (!checkControlValue("p_bdbzdm","String",1,60,null,0,"比对表字段名"))
			return false;
		if (!checkControlValue("p_bdlxdm","String",1,2,null,0,"比对类型代码"))
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
		if (!checkControlValue("p_bjjb","String",1,2,null,0,"报警级别"))
			return false;
		if (!checkControlValue("p_bjfs","String",1,60,null,0,"报警方式"))
			return false;
		if (!checkControlValue("p_bjlxdm","String",1,4,null,0,"报警类型代码"))
			return false;
		if (!checkControlValue("p_bjlx","String",1,60,null,0,"报警类型"))
			return false;
		if (!checkControlValue("p_hylbdm","String",1,2,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("p_hylb","String",1,100,null,0,"行业类别"))
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
					<td width="10%" class="pagedistd">业务表名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ywbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">业务表字段名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ywbzdm" value=""></td>
					<td width="10%" class="pagedistd">比对表名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bdbm" value=""></td>
					<td width="10%" class="pagedistd">比对表字段名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bdbzdm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">比对类型代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bdlxdm" value=""></td>
					<td width="10%" class="pagedistd">比对类型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bdlx" value=""></td>
					<td width="10%" class="pagedistd">是否有效</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sfyx" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">发布策略</td>
					<td width="23%" class="pagetd"><input type="text" id="p_fbcl" value=""></td>
					<td width="10%" class="pagedistd">发布方式</td>
					<td width="23%" class="pagetd"><input type="text" id="p_fbfs" value=""></td>
					<td width="10%" class="pagedistd">特行单位字段</td>
					<td width="23%" class="pagetd"><input type="text" id="p_txdwzd" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">管辖单位字段</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gxdwzd" value=""></td>
					<td width="10%" class="pagedistd">报警级别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bjjb" value=""></td>
					<td width="10%" class="pagedistd">报警方式</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bjfs" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">报警类型代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bjlxdm" value=""></td>
					<td width="10%" class="pagedistd">报警类型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bjlx" value=""></td>
					<td width="10%" class="pagedistd">行业类别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hylbdm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">行业类别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hylb" value=""></td>
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
<div id="wpbjgz_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="WpbjgzData" style="width:100%;">
	<table id="WpbjgzTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_wpbjgzid">物品报警规则ID</th>
	     	<th name="l_ywbm">业务表名</th>
	     	<th name="l_ywbzdm">业务表字段名</th>
	     	<th name="l_bdbm">比对表名</th>
	     	<th name="l_bdbzdm">比对表字段名</th>
	     	<th name="l_bdlxdm">比对类型代码</th>
	     	<th name="l_bdlx">比对类型</th>
	     	<th name="l_sfyx">是否有效</th>
	     	<th name="l_fbcl">发布策略</th>
	     	<th name="l_fbfs">发布方式</th>
	     	<th name="l_txdwzd">特行单位字段</th>
	     	<th name="l_gxdwzd">管辖单位字段</th>
	     	<th name="l_bjjb">报警级别</th>
	     	<th name="l_bjfs">报警方式</th>
	     	<th name="l_bjlxdm">报警类型代码</th>
	     	<th name="l_bjlx">报警类型</th>
	     	<th name="l_hylbdm">行业类别代码</th>
	     	<th name="l_hylb">行业类别</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>