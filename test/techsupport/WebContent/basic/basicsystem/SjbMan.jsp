<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_sjb.action";
	divnid="SjbData";
	tableid="SjbTable";
	addUrl="basicsystem/insert_sjb.action";
	addHtml="business/basicsystem/SjbAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_sjb.action";
	delid="d_sjbid";
	modHtml="business/basicsystem/SjbModify.jsp";
	modUrl="basicsystem/modify_sjb.action";
	modWidth="500";
	detailHtml="business/basicsystem/SjbDetail.jsp";
	detailid="sjb_detail";
	detailUrl="basicsystem/query_sjb.action";
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
										colWidths: ["12%","12%","12%","12%","12%","12%","12%","12%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_sjbid","Integer",-9999999999,9999999999,null,0,"数据表ID"))
			return false;
		if (!checkControlValue("p_sjbm","String",1,30,null,0,"数据表名"))
			return false;
		if (!checkControlValue("p_sjbzwm","String",1,30,null,0,"数据表中文名"))
			return false;
		if (!checkControlValue("p_dyldx","String",1,30,null,0,"对应类对象"))
			return false;
		if (!checkControlValue("p_sfjlczrz","Integer",-99,99,null,0,"是否记录操作日志"))
			return false;
		if (!checkControlValue("p_sfxtzd","Integer",-99,99,null,0,"是否系统字典"))
			return false;
		if (!checkControlValue("p_sssjkyh","String",1,20,null,0,"所属数据库用户"))
			return false;
		if (!checkControlValue("p_zj","String",1,30,null,0,"主键"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_sjbid" value="">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="6"></td>
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
					<td width="10%" class="pagedistd">数据表ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sjbid" value="0"></td>
					<td width="10%" class="pagedistd">数据表名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sjbm" value=""></td>
					<td width="10%" class="pagedistd">数据表中文名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sjbzwm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">对应类对象</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dyldx" value=""></td>
					<td width="10%" class="pagedistd">是否记录操作日志</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sfjlczrz" value="0"></td>
					<td width="10%" class="pagedistd">是否系统字典</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sfxtzd" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">所属数据库用户</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sssjkyh" value=""></td>
					<td width="10%" class="pagedistd">主键</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zj" value=""></td>
				</tr>
    		<tr>
    		  <td colspan="6">
    		  	<table width="124" border="0" align="right" cellpadding="0" cellspacing="0">
    		    	<tr>
    		    	  <td width="50%" class="querybutton"><a href="#" class="querybuttonfont" id="querys" onClick="setPageList(1);">查询</a></td>
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
		<td height="6"></td>
	</tr>
</table>
<div id="sjb_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="SjbData" style="width:100%; ">
	<table id="SjbTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_sjbm">数据表名</th>
	     	<th name="l_sjbzwm">数据表中文名</th>
	     	<th name="l_dyldx">对应类对象</th>
	     	<th name="l_sfjlczrz">是否记录操作日志</th>
	     	<th name="l_sfxtzd">是否系统字典</th>
	     	<th name="l_sssjkyh">所属数据库用户</th>
	     	<th name="l_zj">主键</th>
				<th name="">操作</th>
                <td width="15px" >&nbsp;</td>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>