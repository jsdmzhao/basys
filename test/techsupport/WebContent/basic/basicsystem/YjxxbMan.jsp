<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_yjxxb.action";
	divnid="YjxxbData";
	tableid="YjxxbTable";
	addUrl="basicsystem/insert_yjxxb.action";
	addHtml="basic/basicsystem/YjxxbAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_yjxxb.action";
	delid="d_yjgzid";
	modHtml="basic/basicsystem/YjxxbModify.jsp";
	modUrl="basicsystem/modify_yjxxb.action";
	modWidth="500";
	detailHtml="basic/basicsystem/YjxxbDetail.jsp";
	detailid="yjxxb_detail";
	detailUrl="basicsystem/query_yjxxb.action";
	detailWidth="300";
	loadPage(divnid);
		$("#p_yjsj").attr("readonly","true");
		$("#p_yjsj").datepicker();
	
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
										colWidths: ["5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%","5%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_yjgzid","Integer",-9999999999,9999999999,null,0,"预警规则ID"))
			return false;
		if (!checkControlValue("p_yjxxid","Integer",-9999999999,9999999999,null,0,"预警信息ID"))
			return false;
		if (!checkControlValue("p_ssqymc","String",1,100,null,0,"所属企业名称"))
			return false;
		if (!checkControlValue("p_ssqydz","String",1,200,null,0,"所属企业地址"))
			return false;
		if (!checkControlValue("p_gxdwbm","String",1,20,null,0,"管辖单位代码"))
			return false;
		if (!checkControlValue("p_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("p_yjlx","String",1,60,null,0,"预警类型"))
			return false;
		if (!checkControlValue("p_yjsj","Date",null,null,null,0,"预警时间"))
			return false;
		if (!checkControlValue("p_bdbm","String",1,100,null,0,"比对表名"))
			return false;
		if (!checkControlValue("p_ywbm","String",1,100,null,0,"业务表名"))
			return false;
		if (!checkControlValue("p_hylb","String",1,100,null,0,"行业类别"))
			return false;
		if (!checkControlValue("p_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_gmsfhm","String",1,20,null,0,"公民身份号码"))
			return false;
		if (!checkControlValue("p_gxbbh","Integer",-999999,999999,null,0,"更新版本号"))
			return false;
		if (!checkControlValue("p_ywlb","String",1,30,null,0,"业务类别"))
			return false;
		if (!checkControlValue("p_lxdh","String",1,30,null,0,"联系电话"))
			return false;
		if (!checkControlValue("p_qkms","String",1,2000,null,0,"情况描述"))
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
					<td width="10%" class="pagedistd">所属企业名称</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ssqymc" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">所属企业地址</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ssqydz" value=""></td>
					<td width="10%" class="pagedistd">管辖单位代码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_gxdwbm" value=""></td>
					<td width="10%" class="pagedistd">管辖单位名称</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_gxdwmc" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">预警类型</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_yjlx" value=""></td>
					<td width="10%" class="pagedistd">预警时间</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_yjsj" value=""></td>
					<td width="10%" class="pagedistd">比对表名</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bdbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">业务表名</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ywbm" value=""></td>
					<td width="10%" class="pagedistd">行业类别</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_hylb" value=""></td>
					<td width="10%" class="pagedistd">姓名</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">公民身份号码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_gmsfhm" value=""></td>
					<td width="10%" class="pagedistd">更新版本号</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_gxbbh" value="0"></td>
					<td width="10%" class="pagedistd">业务类别</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ywlb" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">联系电话</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_lxdh" value=""></td>
					<td width="10%" class="pagedistd">情况描述</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_qkms" value=""></td>
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
<div id="yjxxb_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="YjxxbData" style="width:100%;">
	<table id="YjxxbTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_yjxxid">预警信息ID</th>
	     	<th name="l_ssqymc">所属企业名称</th>
	     	<th name="l_ssqydz">所属企业地址</th>
	     	<th name="l_gxdwbm">管辖单位代码</th>
	     	<th name="l_gxdwmc">管辖单位名称</th>
	     	<th name="l_yjlx">预警类型</th>
	     	<th name="l_yjsj">预警时间</th>
	     	<th name="l_bdbm">比对表名</th>
	     	<th name="l_ywbm">业务表名</th>
	     	<th name="l_hylb">行业类别</th>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_gmsfhm">公民身份号码</th>
	     	<th name="l_gxbbh">更新版本号</th>
	     	<th name="l_ywlb">业务类别</th>
	     	<th name="l_lxdh">联系电话</th>
	     	<th name="l_qkms">情况描述</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>