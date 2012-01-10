<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_bkwpkbxxkz.action";
	divnid="BkwpkbxxkzData";
	tableid="BkwpkbxxkzTable";
	addUrl="basicsystem/insert_bkwpkbxxkz.action";
	addHtml="business/basicsystem/BkwpkbxxkzAdd.jsp";
	addWidth="800";
	delUrl="basicsystem/delete_bkwpkbxxkz.action";
	delid="d_bjxxid2";
	modHtml="business/basicsystem/BkwpkbxxkzModify.jsp";
	modUrl="basicsystem/modify_bkwpkbxxkz.action";
	modWidth="800";
	detailHtml="business/basicsystem/BkwpkbxxkzDetail.jsp";
	detailid="bkwpkbxxkz_detail";
	detailUrl="basicsystem/query_bkwpkbxxkz.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_tbsj2").attr("readonly","true");
		$("#p_tbsj2").datepicker();
		$("#p_bkczsj").attr("readonly","true");
		$("#p_bkczsj").datepicker();
		$("#p_bkdqsj").attr("readonly","true");
		$("#p_bkdqsj").datepicker();
		$("#p_sprq").attr("readonly","true");
		$("#p_sprq").datepicker();
		$("#p_cksj").attr("readonly","true");
		$("#p_cksj").datepicker();
		$("#p_ckczsj").attr("readonly","true");
		$("#p_ckczsj").datepicker();
		$("#p_cksprq").attr("readonly","true");
		$("#p_cksprq").datepicker();
	
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
										colWidths: ["2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("p_bkwpjbxxkzid","Integer",-9999999999,9999999999,null,0,"布控物品基本信息快照ID"))
			return false;
		if (!checkControlValue("p_hylbdm","String",1,2,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("p_hylb","String",1,100,null,0,"行业类别"))
			return false;
		if (!checkControlValue("p_bkwplxdm","String",1,2,null,0,"布控物品类型代码"))
			return false;
		if (!checkControlValue("p_bkwplx","String",1,20,null,0,"布控物品类型"))
			return false;
		if (!checkControlValue("p_bkwpmc","String",1,30,null,0,"布控物品名称"))
			return false;
		if (!checkControlValue("p_bkwpms","String",1,2000,null,0,"布控物品描述"))
			return false;
		if (!checkControlValue("p_fwdw","String",1,100,null,0,"发文单位"))
			return false;
		if (!checkControlValue("p_fwdwbm","String",1,60,null,0,"发文单位编码"))
			return false;
		if (!checkControlValue("p_ajlbbm","String",1,30,null,0,"案件类别编码"))
			return false;
		if (!checkControlValue("p_ajlb","String",1,60,null,0,"案件类别"))
			return false;
		if (!checkControlValue("p_tbbh","String",1,30,null,0,"通报编号"))
			return false;
		if (!checkControlValue("p_tbsj2","Date",null,null,null,0,"通报时间"))
			return false;
		if (!checkControlValue("p_jyaq","String",1,2000,null,0,"简要案情"))
			return false;
		if (!checkControlValue("p_cljg","String",1,2000,null,0,"处理结果"))
			return false;
		if (!checkControlValue("p_bkr","String",1,100,null,0,"布控人"))
			return false;
		if (!checkControlValue("p_bkczy","String",1,100,null,0,"布控操作员"))
			return false;
		if (!checkControlValue("p_bkczsj","Date",null,null,null,0,"布控操作时间"))
			return false;
		if (!checkControlValue("p_bkdqsj","Date",null,null,null,0,"布控到期时间"))
			return false;
		if (!checkControlValue("p_bkfwbm","String",1,2,null,0,"布控范围编码"))
			return false;
		if (!checkControlValue("p_bkfw","String",1,300,null,0,"布控范围"))
			return false;
		if (!checkControlValue("p_bkspyj","String",1,2000,null,0,"布控审批意见"))
			return false;
		if (!checkControlValue("p_lxr","String",1,100,null,0,"联系人"))
			return false;
		if (!checkControlValue("p_lxfs","String",1,300,null,0,"联系方式"))
			return false;
		if (!checkControlValue("p_sftyfb","String",1,2,null,0,"是否同意发布"))
			return false;
		if (!checkControlValue("p_spdw","String",1,100,null,0,"审批单位"))
			return false;
		if (!checkControlValue("p_spr2","String",1,100,null,0,"审批人"))
			return false;
		if (!checkControlValue("p_sprq","Date",null,null,null,0,"审批日期"))
			return false;
		if (!checkControlValue("p_qqckbs","String",1,2,null,0,"请求撤控标识"))
			return false;
		if (!checkControlValue("p_ckbs","String",1,2,null,0,"撤控标识"))
			return false;
		if (!checkControlValue("p_ckyy","String",1,2000,null,0,"撤控原因"))
			return false;
		if (!checkControlValue("p_cksj","Date",null,null,null,0,"撤控时间"))
			return false;
		if (!checkControlValue("p_ckr","String",1,100,null,0,"撤控人"))
			return false;
		if (!checkControlValue("p_ckczy","String",1,100,null,0,"撤控操作员"))
			return false;
		if (!checkControlValue("p_ckczsj","Date",null,null,null,0,"撤控操作时间"))
			return false;
		if (!checkControlValue("p_ckbmbm","String",1,60,null,0,"撤控部门编码"))
			return false;
		if (!checkControlValue("p_ckbmmc","String",1,100,null,0,"撤控部门名称"))
			return false;
		if (!checkControlValue("p_ckspdw","String",1,100,null,0,"撤控审批单位"))
			return false;
		if (!checkControlValue("p_ckspr","String",1,100,null,0,"撤控审批人"))
			return false;
		if (!checkControlValue("p_ckspyj","String",1,2000,null,0,"撤控审批意见"))
			return false;
		if (!checkControlValue("p_cksprq","Date",null,null,null,0,"撤控审批日期"))
			return false;
		if (!checkControlValue("p_xzqh","String",1,100,null,0,"行政区划"))
			return false;
		if (!checkControlValue("p_fsbs","String",1,2,null,0,"发送标识"))
			return false;
		if (!checkControlValue("p_bkdxzp","byte[]",,,,0,"布控对象照片"))
			return false;
		if (!checkControlValue("p_wpjp","String",1,200,null,0,"物品简拼"))
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
					<td width="10%" class="pagedistd">布控物品基本信息快照ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bkwpjbxxkzid" value="0"></td>
					<td width="10%" class="pagedistd">行业类别代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hylbdm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">行业类别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hylb" value=""></td>
					<td width="10%" class="pagedistd">布控物品类型代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bkwplxdm" value=""></td>
					<td width="10%" class="pagedistd">布控物品类型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bkwplx" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">布控物品名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bkwpmc" value=""></td>
					<td width="10%" class="pagedistd">布控物品描述</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bkwpms" value=""></td>
					<td width="10%" class="pagedistd">发文单位</td>
					<td width="23%" class="pagetd"><input type="text" id="p_fwdw" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">发文单位编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_fwdwbm" value=""></td>
					<td width="10%" class="pagedistd">案件类别编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ajlbbm" value=""></td>
					<td width="10%" class="pagedistd">案件类别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ajlb" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">通报编号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tbbh" value=""></td>
					<td width="10%" class="pagedistd">通报时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tbsj2" value=""></td>
					<td width="10%" class="pagedistd">简要案情</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jyaq" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">处理结果</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cljg" value=""></td>
					<td width="10%" class="pagedistd">布控人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bkr" value=""></td>
					<td width="10%" class="pagedistd">布控操作员</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bkczy" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">布控操作时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bkczsj" value=""></td>
					<td width="10%" class="pagedistd">布控到期时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bkdqsj" value=""></td>
					<td width="10%" class="pagedistd">布控范围编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bkfwbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">布控范围</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bkfw" value=""></td>
					<td width="10%" class="pagedistd">布控审批意见</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bkspyj" value=""></td>
					<td width="10%" class="pagedistd">联系人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lxr" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">联系方式</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lxfs" value=""></td>
					<td width="10%" class="pagedistd">是否同意发布</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sftyfb" value=""></td>
					<td width="10%" class="pagedistd">审批单位</td>
					<td width="23%" class="pagetd"><input type="text" id="p_spdw" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">审批人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_spr2" value=""></td>
					<td width="10%" class="pagedistd">审批日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sprq" value=""></td>
					<td width="10%" class="pagedistd">请求撤控标识</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qqckbs" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">撤控标识</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ckbs" value=""></td>
					<td width="10%" class="pagedistd">撤控原因</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ckyy" value=""></td>
					<td width="10%" class="pagedistd">撤控时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cksj" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">撤控人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ckr" value=""></td>
					<td width="10%" class="pagedistd">撤控操作员</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ckczy" value=""></td>
					<td width="10%" class="pagedistd">撤控操作时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ckczsj" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">撤控部门编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ckbmbm" value=""></td>
					<td width="10%" class="pagedistd">撤控部门名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ckbmmc" value=""></td>
					<td width="10%" class="pagedistd">撤控审批单位</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ckspdw" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">撤控审批人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ckspr" value=""></td>
					<td width="10%" class="pagedistd">撤控审批意见</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ckspyj" value=""></td>
					<td width="10%" class="pagedistd">撤控审批日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cksprq" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">行政区划</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xzqh" value=""></td>
					<td width="10%" class="pagedistd">发送标识</td>
					<td width="23%" class="pagetd"><input type="text" id="p_fsbs" value=""></td>
					<td width="10%" class="pagedistd">布控对象照片</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bkdxzp" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">物品简拼</td>
					<td width="23%" class="pagetd"><input type="text" id="p_wpjp" value=""></td>
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
<div id="bkwpkbxxkz_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="BkwpkbxxkzData" style="width:100%;">
	<table id="BkwpkbxxkzTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_bkwpjbxxkzid">布控物品基本信息快照ID</th>
	     	<th name="l_hylbdm">行业类别代码</th>
	     	<th name="l_hylb">行业类别</th>
	     	<th name="l_bkwplxdm">布控物品类型代码</th>
	     	<th name="l_bkwplx">布控物品类型</th>
	     	<th name="l_bkwpmc">布控物品名称</th>
	     	<th name="l_bkwpms">布控物品描述</th>
	     	<th name="l_fwdw">发文单位</th>
	     	<th name="l_fwdwbm">发文单位编码</th>
	     	<th name="l_ajlbbm">案件类别编码</th>
	     	<th name="l_ajlb">案件类别</th>
	     	<th name="l_tbbh">通报编号</th>
	     	<th name="l_tbsj2">通报时间</th>
	     	<th name="l_jyaq">简要案情</th>
	     	<th name="l_cljg">处理结果</th>
	     	<th name="l_bkr">布控人</th>
	     	<th name="l_bkczy">布控操作员</th>
	     	<th name="l_bkczsj">布控操作时间</th>
	     	<th name="l_bkdqsj">布控到期时间</th>
	     	<th name="l_bkfwbm">布控范围编码</th>
	     	<th name="l_bkfw">布控范围</th>
	     	<th name="l_bkspyj">布控审批意见</th>
	     	<th name="l_lxr">联系人</th>
	     	<th name="l_lxfs">联系方式</th>
	     	<th name="l_sftyfb">是否同意发布</th>
	     	<th name="l_spdw">审批单位</th>
	     	<th name="l_spr2">审批人</th>
	     	<th name="l_sprq">审批日期</th>
	     	<th name="l_qqckbs">请求撤控标识</th>
	     	<th name="l_ckbs">撤控标识</th>
	     	<th name="l_ckyy">撤控原因</th>
	     	<th name="l_cksj">撤控时间</th>
	     	<th name="l_ckr">撤控人</th>
	     	<th name="l_ckczy">撤控操作员</th>
	     	<th name="l_ckczsj">撤控操作时间</th>
	     	<th name="l_ckbmbm">撤控部门编码</th>
	     	<th name="l_ckbmmc">撤控部门名称</th>
	     	<th name="l_ckspdw">撤控审批单位</th>
	     	<th name="l_ckspr">撤控审批人</th>
	     	<th name="l_ckspyj">撤控审批意见</th>
	     	<th name="l_cksprq">撤控审批日期</th>
	     	<th name="l_xzqh">行政区划</th>
	     	<th name="l_fsbs">发送标识</th>
	     	<th name="l_bkdxzp">布控对象照片</th>
	     	<th name="l_wpjp">物品简拼</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>