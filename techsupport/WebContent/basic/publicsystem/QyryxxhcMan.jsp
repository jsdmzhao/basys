<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_qyryxxhc.action";
	divnid="QyryxxhcData";
	tableid="QyryxxhcTable";
	addUrl="publicsystem/insert_qyryxxhc.action";
	addHtml="business/publicsystem/QyryxxhcAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_qyryxxhc.action";
	delid="d_garkktbsjid";
	modHtml="business/publicsystem/QyryxxhcModify.jsp";
	modUrl="publicsystem/modify_qyryxxhc.action";
	modWidth="800";
	detailHtml="business/publicsystem/QyryxxhcDetail.jsp";
	detailid="qyryxxhc_detail";
	detailUrl="publicsystem/query_qyryxxhc.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_bdsj").attr("readonly","true");
		$("#p_bdsj").datepicker();
		$("#p_hcsj").attr("readonly","true");
		$("#p_hcsj").datepicker();
	
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
										colWidths: ["3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_garkktbsjid","Integer",-9999999999,9999999999,null,0,"公安人口库同步数据ID"))
			return false;
		if (!checkControlValue("p_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("p_ryid","Integer",-9999999999,9999999999,null,0,"从业人员ID"))
			return false;
		if (!checkControlValue("p_hcid","Integer",-9999999999,9999999999,null,0,"核查ID"))
			return false;
		if (!checkControlValue("p_dsjgdm","String",1,20,null,0,"地市机关代码"))
			return false;
		if (!checkControlValue("p_dsjgmc","String",1,60,null,0,"地市机关名称"))
			return false;
		if (!checkControlValue("p_fxjdm","String",1,20,null,0,"分县局代码"))
			return false;
		if (!checkControlValue("p_fxjmc","String",1,60,null,0,"分县局名称"))
			return false;
		if (!checkControlValue("p_gxdwdm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("p_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("p_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("p_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("p_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("p_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("p_ywm","String",1,60,null,0,"英文名"))
			return false;
		if (!checkControlValue("p_ywx","String",1,60,null,0,"英文姓"))
			return false;
		if (!checkControlValue("p_wgrjyxkz","String",1,60,null,0,"外国人就业许可证号"))
			return false;
		if (!checkControlValue("p_cyzjdm","String",1,40,null,0,"常用证件代码"))
			return false;
		if (!checkControlValue("p_cyzj","String",1,100,null,0,"常用证件"))
			return false;
		if (!checkControlValue("p_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("p_gwbh","String",1,4,null,0,"岗位编号"))
			return false;
		if (!checkControlValue("p_gemc","String",1,60,null,0,"岗位名称"))
			return false;
		if (!checkControlValue("p_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("p_bdsj","Date",null,null,null,0,"比对时间"))
			return false;
		if (!checkControlValue("p_hcsj","Date",null,null,null,0,"核查时间"))
			return false;
		if (!checkControlValue("p_hcwt","String",1,100,null,0,"核查问题"))
			return false;
		if (!checkControlValue("p_hcyj","String",1,300,null,0,"核查意见"))
			return false;
		if (!checkControlValue("p_hcr","String",1,30,null,0,"核查人"))
			return false;
		if (!checkControlValue("p_hcdw","String",1,100,null,0,"核查单位"))
			return false;
		if (!checkControlValue("p_hcdwdm","String",1,30,null,0,"核查单位代码"))
			return false;
		if (!checkControlValue("p_hczt","String",1,100,null,0,"核查状态"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_garkktbsjid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">公安人口库同步数据ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_garkktbsjid" value="0"></td>
					<td width="10%" class="pagedistd">企业ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qyid" value="0"></td>
					<td width="10%" class="pagedistd">从业人员ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ryid" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">核查ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hcid" value="0"></td>
					<td width="10%" class="pagedistd">地市机关代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dsjgdm" value=""></td>
					<td width="10%" class="pagedistd">地市机关名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dsjgmc" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">分县局代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_fxjdm" value=""></td>
					<td width="10%" class="pagedistd">分县局名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_fxjmc" value=""></td>
					<td width="10%" class="pagedistd">管辖单位代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gxdwdm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">管辖单位名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gxdwmc" value=""></td>
					<td width="10%" class="pagedistd">企业编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qybm" value=""></td>
					<td width="10%" class="pagedistd">企业名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qymc" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">姓名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xm" value=""></td>
					<td width="10%" class="pagedistd">性别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xbdm" value=""></td>
					<td width="10%" class="pagedistd">性别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xb" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">英文名</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ywm" value=""></td>
					<td width="10%" class="pagedistd">英文姓</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ywx" value=""></td>
					<td width="10%" class="pagedistd">外国人就业许可证号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_wgrjyxkz" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">常用证件代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyzjdm" value=""></td>
					<td width="10%" class="pagedistd">常用证件</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cyzj" value=""></td>
					<td width="10%" class="pagedistd">证件号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zjhm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">岗位编号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gwbh" value=""></td>
					<td width="10%" class="pagedistd">岗位名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gemc" value=""></td>
					<td width="10%" class="pagedistd">姓名拼音</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xmpy" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">比对时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bdsj" value=""></td>
					<td width="10%" class="pagedistd">核查时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hcsj" value=""></td>
					<td width="10%" class="pagedistd">核查问题</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hcwt" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">核查意见</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hcyj" value=""></td>
					<td width="10%" class="pagedistd">核查人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hcr" value=""></td>
					<td width="10%" class="pagedistd">核查单位</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hcdw" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">核查单位代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hcdwdm" value=""></td>
					<td width="10%" class="pagedistd">核查状态</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hczt" value=""></td>
				</tr>
    		<tr>
    		  <td colspan="6">
    		  	<table  border="0" align="right"  cellpadding="2"  cellspacing="0">
    		    	<tr>
    		    	  <td width="50%" ><a href="#" class="searchbutton" id="querys" onclick="setPageList(1);">查询</a></td>
    		    	  <td width="50%" ><a href="#" class="addbutton" onclick='setAddPage()'>添加</a></td>
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
<div id="qyryxxhc_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="QyryxxhcData" style="width:100%;">
	<table id="QyryxxhcTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_qyid">企业ID</th>
	     	<th name="l_ryid">从业人员ID</th>
	     	<th name="l_hcid">核查ID</th>
	     	<th name="l_dsjgdm">地市机关代码</th>
	     	<th name="l_dsjgmc">地市机关名称</th>
	     	<th name="l_fxjdm">分县局代码</th>
	     	<th name="l_fxjmc">分县局名称</th>
	     	<th name="l_gxdwdm">管辖单位代码</th>
	     	<th name="l_gxdwmc">管辖单位名称</th>
	     	<th name="l_qybm">企业编码</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_xbdm">性别代码</th>
	     	<th name="l_xb">性别</th>
	     	<th name="l_ywm">英文名</th>
	     	<th name="l_ywx">英文姓</th>
	     	<th name="l_wgrjyxkz">外国人就业许可证号</th>
	     	<th name="l_cyzjdm">常用证件代码</th>
	     	<th name="l_cyzj">常用证件</th>
	     	<th name="l_zjhm">证件号码</th>
	     	<th name="l_gwbh">岗位编号</th>
	     	<th name="l_gemc">岗位名称</th>
	     	<th name="l_xmpy">姓名拼音</th>
	     	<th name="l_bdsj">比对时间</th>
	     	<th name="l_hcsj">核查时间</th>
	     	<th name="l_hcwt">核查问题</th>
	     	<th name="l_hcyj">核查意见</th>
	     	<th name="l_hcr">核查人</th>
	     	<th name="l_hcdw">核查单位</th>
	     	<th name="l_hcdwdm">核查单位代码</th>
	     	<th name="l_hczt">核查状态</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>