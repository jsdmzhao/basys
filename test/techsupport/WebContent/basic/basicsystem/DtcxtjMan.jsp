<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_dtcxtj.action";
	divnid="DtcxtjData";
	tableid="DtcxtjTable";
	addUrl="basicsystem/insert_dtcxtj.action";
	addHtml="business/basicsystem/DtcxtjAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_dtcxtj.action";
	delid="d_dtcxtjid";
	modHtml="business/basicsystem/DtcxtjModify.jsp";
	modUrl="basicsystem/modify_dtcxtj.action";
	modWidth="500";
	detailHtml="business/basicsystem/DtcxtjDetail.jsp";
	detailid="dtcxtj_detail";
	detailUrl="basicsystem/query_dtcxtj.action";
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
		if (!checkControlValue("p_dtcxtjid","Integer",-9999999999,9999999999,null,0,"动态查询条件ID"))
			return false;
		if (!checkControlValue("p_gjcxfaid","Integer",-9999999999,9999999999,null,0,"高级查询方案ID"))
			return false;
		if (!checkControlValue("p_sjbm","String",1,30,null,0,"数据表名"))
			return false;
		if (!checkControlValue("p_zdm","String",1,30,null,0,"字段名"))
			return false;
		if (!checkControlValue("p_zdzwm","String",1,30,null,0,"字段中文名"))
			return false;
		if (!checkControlValue("p_zdlx","String",1,10,null,0,"字段类型"))
			return false;
		if (!checkControlValue("p_zdz","String",1,300,null,0,"字段值"))
			return false;
		if (!checkControlValue("p_xsz","String",1,300,null,0,"显示值"))
			return false;
		if (!checkControlValue("p_ppf","String",1,20,null,0,"匹配符"))
			return false;
		if (!checkControlValue("p_kskh","String",1,1,null,0,"开始括号"))
			return false;
		if (!checkControlValue("p_jskh","String",1,1,null,0,"结束括号"))
			return false;
		if (!checkControlValue("p_gxf","String",1,20,null,0,"关系符"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_dtcxtjid" value="">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="6"></td>
  </tr>
</table>
<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#c1d0dd">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">动态查询条件ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dtcxtjid" value="0"></td>
					<td width="10%" class="pagedistd">高级查询方案ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gjcxfaid" value="0"></td>
					<td width="10%" class="pagedistd">数据表名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sjbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">字段名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zdm" value=""></td>
					<td width="10%" class="pagedistd">字段中文名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zdzwm" value=""></td>
					<td width="10%" class="pagedistd">字段类型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zdlx" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">字段值</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zdz" value=""></td>
					<td width="10%" class="pagedistd">显示值</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xsz" value=""></td>
					<td width="10%" class="pagedistd">匹配符</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ppf" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">开始括号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_kskh" value=""></td>
					<td width="10%" class="pagedistd">结束括号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jskh" value=""></td>
					<td width="10%" class="pagedistd">关系符</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gxf" value=""></td>
				</tr>
    		<tr>
    		  <td colspan="6">
    		  	<table width="124" border="0" align="right" cellpadding="0" cellspacing="0">
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
		<td height="6"></td>
	</tr>
</table>
<div id="dtcxtj_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="DtcxtjData" style="width:97%; padding-right:17px;">
	<table id="DtcxtjTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_gjcxfaid">高级查询方案ID</th>
	     	<th name="l_sjbm">数据表名</th>
	     	<th name="l_zdm">字段名</th>
	     	<th name="l_zdzwm">字段中文名</th>
	     	<th name="l_zdlx">字段类型</th>
	     	<th name="l_zdz">字段值</th>
	     	<th name="l_xsz">显示值</th>
	     	<th name="l_ppf">匹配符</th>
	     	<th name="l_kskh">开始括号</th>
	     	<th name="l_jskh">结束括号</th>
	     	<th name="l_gxf">关系符</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>