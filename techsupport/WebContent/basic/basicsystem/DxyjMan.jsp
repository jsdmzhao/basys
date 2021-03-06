<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_dxyj.action";
	divnid="DxyjData";
	tableid="DxyjTable";
	addUrl="basicsystem/insert_dxyj.action";
	addHtml="basic/basicsystem/DxyjAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_dxyj.action";
	delid="d_yjgzid";
	modHtml="basic/basicsystem/DxyjModify.jsp";
	modUrl="basicsystem/modify_dxyj.action";
	modWidth="500";
	detailHtml="basic/basicsystem/DxyjDetail.jsp";
	detailid="dxyj_detail";
	detailUrl="basicsystem/query_dxyj.action";
	detailWidth="300";
	loadPage(divnid);
		$("#p_dycfssj").attr("readonly","true");
		$("#p_dycfssj").datepicker();
		$("#p_zhycfssj").attr("readonly","true");
		$("#p_zhycfssj").datepicker();
	
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
										colWidths: ["11%","11%","11%","11%","11%","11%","11%","11%","11%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_yjgzid","Integer",-9999999999,9999999999,null,0,"预警规则ID"))
			return false;
		if (!checkControlValue("p_yjxxid","Integer",-9999999999,9999999999,null,0,"预警信息ID"))
			return false;
		if (!checkControlValue("p_dxyjid","Integer",-9999999999,9999999999,null,0,"短信预警ID"))
			return false;
		if (!checkControlValue("p_dxhm","String",1,20,null,0,"短信号码"))
			return false;
		if (!checkControlValue("p_dycfssj","Date",null,null,null,0,"第一次发送时间"))
			return false;
		if (!checkControlValue("p_zhycfssj","Date",null,null,null,0,"最后一次发送时间"))
			return false;
		if (!checkControlValue("p_fscs","Integer",-999999,999999,null,0,"发送次数"))
			return false;
		if (!checkControlValue("p_dxzt","String",1,2,null,0,"短信状态"))
			return false;
		if (!checkControlValue("p_dxnr","String",1,300,null,0,"短信内容"))
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
					<td width="10%" class="pagedistd">预警信息ID</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_yjxxid" value="0"></td>
					<td width="10%" class="pagedistd">短信预警ID</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_dxyjid" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">短信号码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_dxhm" value=""></td>
					<td width="10%" class="pagedistd">第一次发送时间</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_dycfssj" value=""></td>
					<td width="10%" class="pagedistd">最后一次发送时间</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_zhycfssj" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">发送次数</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_fscs" value="0"></td>
					<td width="10%" class="pagedistd">短信状态</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_dxzt" value=""></td>
					<td width="10%" class="pagedistd">短信内容</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_dxnr" value=""></td>
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
<div id="dxyj_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="DxyjData" style="width:100%;">
	<table id="DxyjTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_yjxxid">预警信息ID</th>
	     	<th name="l_dxyjid">短信预警ID</th>
	     	<th name="l_dxhm">短信号码</th>
	     	<th name="l_dycfssj">第一次发送时间</th>
	     	<th name="l_zhycfssj">最后一次发送时间</th>
	     	<th name="l_fscs">发送次数</th>
	     	<th name="l_dxzt">短信状态</th>
	     	<th name="l_dxnr">短信内容</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>