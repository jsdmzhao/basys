<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_sjbjg.action";
	divnid="SjbjgData";
	tableid="SjbjgTable";
	addUrl="basicsystem/insert_sjbjg.action";
	addHtml="business/basicsystem/SjbjgAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_sjbjg.action";
	delid="d_sjbjgid";
	modHtml="business/basicsystem/SjbjgModify.jsp";
	modUrl="basicsystem/modify_sjbjg.action";
	modWidth="500";
	detailHtml="business/basicsystem/SjbjgDetail.jsp";
	detailid="sjbjg_detail";
	detailUrl="basicsystem/query_sjbjg.action";
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
										colWidths: ["5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_sjbjgid","Integer",-9999999999,9999999999,null,0,"数据表结构ID"))
			return false;
		if (!checkControlValue("p_sjbid","Integer",-9999999999,9999999999,null,0,"数据表ID"))
			return false;
		if (!checkControlValue("p_zdm","String",1,30,null,0,"字段名"))
			return false;
		if (!checkControlValue("p_zdzwm","String",1,30,null,0,"字段中文名"))
			return false;
		if (!checkControlValue("p_zdlx","String",1,10,null,0,"字段类型"))
			return false;
		if (!checkControlValue("p_zdcd","String",1,10,null,0,"字段长度"))
			return false;
		if (!checkControlValue("p_qsz","String",1,100,null,0,"缺省值"))
			return false;
		if (!checkControlValue("p_px","Integer",-9999999999,9999999999,null,0,"排序"))
			return false;
		if (!checkControlValue("p_gs","String",1,100,null,0,"格式"))
			return false;
		if (!checkControlValue("p_sfdjhwb","String",1,1,null,0,"是否多行文本"))
			return false;
		if (!checkControlValue("p_sfbt","String",1,1,null,0,"是否必填"))
			return false;
		if (!checkControlValue("p_sfzd","String",1,1,null,0,"是否只读"))
			return false;
		if (!checkControlValue("p_sfkj","String",1,1,null,0,"是否可见"))
			return false;
		if (!checkControlValue("p_sfcx","String",1,1,null,0,"是否查询"))
			return false;
		if (!checkControlValue("p_xlklx","String",1,20,null,0,"下拉框类型"))
			return false;
		if (!checkControlValue("p_dzxlkdqy","String",1,100,null,0,"定制下拉框读取域列表"))
			return false;
		if (!checkControlValue("p_xlkkd","Integer",-999999,999999,null,0,"下拉框宽度"))
			return false;
		if (!checkControlValue("p_xlkgd","Integer",-999999,999999,null,0,"下拉框高度"))
			return false;
		if (!checkControlValue("p_bz","String",1,2000,null,0,"备注"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_sjbjgid" value="">
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
					<td width="10%" class="pagedistd">数据表结构ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sjbjgid" value="0"></td>
					<td width="10%" class="pagedistd">数据表ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sjbid" value="0"></td>
					<td width="10%" class="pagedistd">字段名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zdm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">字段中文名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zdzwm" value=""></td>
					<td width="10%" class="pagedistd">字段类型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zdlx" value=""></td>
					<td width="10%" class="pagedistd">字段长度</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zdcd" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">缺省值</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qsz" value=""></td>
					<td width="10%" class="pagedistd">排序</td>
					<td width="23%" class="pagetd"><input type="text" id="p_px" value="0"></td>
					<td width="10%" class="pagedistd">格式</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gs" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">是否多行文本</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sfdjhwb" value=""></td>
					<td width="10%" class="pagedistd">是否必填</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sfbt" value=""></td>
					<td width="10%" class="pagedistd">是否只读</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sfzd" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">是否可见</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sfkj" value=""></td>
					<td width="10%" class="pagedistd">是否查询</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sfcx" value=""></td>
					<td width="10%" class="pagedistd">下拉框类型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xlklx" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">定制下拉框读取域列表</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dzxlkdqy" value=""></td>
					<td width="10%" class="pagedistd">下拉框宽度</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xlkkd" value="0"></td>
					<td width="10%" class="pagedistd">下拉框高度</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xlkgd" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">备注</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bz" value=""></td>
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
<div id="sjbjg_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="SjbjgData" style="width:97%; padding-right:17px;">
	<table id="SjbjgTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_sjbid">数据表ID</th>
	     	<th name="l_zdm">字段名</th>
	     	<th name="l_zdzwm">字段中文名</th>
	     	<th name="l_zdlx">字段类型</th>
	     	<th name="l_zdcd">字段长度</th>
	     	<th name="l_qsz">缺省值</th>
	     	<th name="l_px">排序</th>
	     	<th name="l_gs">格式</th>
	     	<th name="l_sfdjhwb">是否多行文本</th>
	     	<th name="l_sfbt">是否必填</th>
	     	<th name="l_sfzd">是否只读</th>
	     	<th name="l_sfkj">是否可见</th>
	     	<th name="l_sfcx">是否查询</th>
	     	<th name="l_xlklx">下拉框类型</th>
	     	<th name="l_dzxlkdqy">定制下拉框读取域列表</th>
	     	<th name="l_xlkkd">下拉框宽度</th>
	     	<th name="l_xlkgd">下拉框高度</th>
	     	<th name="l_bz">备注</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>