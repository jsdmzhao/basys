<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	daggleDiv(detailid);
	pageUrl="publicsystem/querylist_qysctj.action";
	divnid="QysctjData";
	tableid="QysctjTable";
	addUrl="publicsystem/insert_qysctj.action";
	addHtml="business/publicsystem/QysctjAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_qysctj.action";
	delid="d_qysctjid";
	modHtml="business/publicsystem/QysctjModify.jsp";
	modUrl="publicsystem/modify_qysctj.action";
	modWidth="800";
	detailHtml="business/publicsystem/QysctjDetail.jsp";
	detailid="qysctj_detail";
	detailUrl="publicsystem/query_qysctj.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_tjrq").attr("readonly","true");
		$("#p_tjrq").datepicker();
	
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
										colWidths: ["4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_qysctjid","Integer",-9999999999,9999999999,null,0,"企业上传统计ID"))
			return false;
		if (!checkControlValue("p_hylbdm","String",1,2,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("p_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("p_tjrq","Date",null,null,null,0,"统计日期"))
			return false;
		if (!checkControlValue("p_dsjgdm","String",1,20,null,0,"地市机关代码"))
			return false;
		if (!checkControlValue("p_dsjgmc","String",1,60,null,0,"地市机关名称"))
			return false;
		if (!checkControlValue("p_fxjdm","String",1,20,null,0,"分县局代码"))
			return false;
		if (!checkControlValue("p_fxjmc","String",1,60,null,0,"分县局名称"))
			return false;
		if (!checkControlValue("p_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("p_gxdwdm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("p_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("p_qymc","String",1,120,null,0,"企业名称"))
			return false;
		if (!checkControlValue("p_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("p_sfdb","Integer",-99,99,null,0,"是否达标"))
			return false;
		if (!checkControlValue("p_zrs","Integer",-999999,999999,null,0,"总人数"))
			return false;
		if (!checkControlValue("p_gzrs","Integer",-999999,999999,null,0,"工作人数"))
			return false;
		if (!checkControlValue("p_sskrs","Integer",-999999,999999,null,0,"实刷卡人数"))
			return false;
		if (!checkControlValue("p_zdskb","Float",-999.99,999.99,2,0,"最低刷卡比"))
			return false;
		if (!checkControlValue("p_ycskrs","Integer",-999999,999999,null,0,"一次刷卡人数"))
			return false;
		if (!checkControlValue("p_dcskrs","Integer",-999999,999999,null,0,"多次刷卡人数"))
			return false;
		if (!checkControlValue("p_bcsskrs","Integer",-999999,999999,null,0,"本场所刷卡人数"))
			return false;
		if (!checkControlValue("p_ztskrs","Integer",-999999,999999,null,0,"走台刷卡人数"))
			return false;
		if (!checkControlValue("p_zskb","Float",-999.99,999.99,2,0,"总刷卡比"))
			return false;
		if (!checkControlValue("p_ycskb","Float",-999.99,999.99,2,0,"一次刷卡率"))
			return false;
		if (!checkControlValue("p_dcskb","Float",-999.99,999.99,2,0,"多次刷卡率"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_qysctjid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">企业上传统计ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qysctjid" value="0"></td>
					<td width="10%" class="pagedistd">行业类别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hylbdm" value=""></td>
					<td width="10%" class="pagedistd">行业类别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hylb" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">统计日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tjrq" value=""></td>
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
					<td width="10%" class="pagedistd">管辖单位名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gxdwmc" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">管辖单位代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gxdwdm" value=""></td>
					<td width="10%" class="pagedistd">企业编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qybm" value=""></td>
					<td width="10%" class="pagedistd">企业名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qymc" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">联系电话</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lxdh" value=""></td>
					<td width="10%" class="pagedistd">是否达标</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sfdb" value="0"></td>
					<td width="10%" class="pagedistd">总人数</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zrs" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">工作人数</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gzrs" value="0"></td>
					<td width="10%" class="pagedistd">实刷卡人数</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sskrs" value="0"></td>
					<td width="10%" class="pagedistd">最低刷卡比</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zdskb" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">一次刷卡人数</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ycskrs" value="0"></td>
					<td width="10%" class="pagedistd">多次刷卡人数</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dcskrs" value="0"></td>
					<td width="10%" class="pagedistd">本场所刷卡人数</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bcsskrs" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">走台刷卡人数</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ztskrs" value="0"></td>
					<td width="10%" class="pagedistd">总刷卡比</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zskb" value="0"></td>
					<td width="10%" class="pagedistd">一次刷卡率</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ycskb" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">多次刷卡率</td>
					<td width="23%" class="pagetd"><input type="text" id="p_dcskb" value="0"></td>
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
<div id="qysctj_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="QysctjData" style="width:100%;">
	<table id="QysctjTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_hylbdm">行业类别代码</th>
	     	<th name="l_hylb">行业类别</th>
	     	<th name="l_tjrq">统计日期</th>
	     	<th name="l_dsjgdm">地市机关代码</th>
	     	<th name="l_dsjgmc">地市机关名称</th>
	     	<th name="l_fxjdm">分县局代码</th>
	     	<th name="l_fxjmc">分县局名称</th>
	     	<th name="l_gxdwmc">管辖单位名称</th>
	     	<th name="l_gxdwdm">管辖单位代码</th>
	     	<th name="l_qybm">企业编码</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_lxdh">联系电话</th>
	     	<th name="l_sfdb">是否达标</th>
	     	<th name="l_zrs">总人数</th>
	     	<th name="l_gzrs">工作人数</th>
	     	<th name="l_sskrs">实刷卡人数</th>
	     	<th name="l_zdskb">最低刷卡比</th>
	     	<th name="l_ycskrs">一次刷卡人数</th>
	     	<th name="l_dcskrs">多次刷卡人数</th>
	     	<th name="l_bcsskrs">本场所刷卡人数</th>
	     	<th name="l_ztskrs">走台刷卡人数</th>
	     	<th name="l_zskb">总刷卡比</th>
	     	<th name="l_ycskb">一次刷卡率</th>
	     	<th name="l_dcskb">多次刷卡率</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>