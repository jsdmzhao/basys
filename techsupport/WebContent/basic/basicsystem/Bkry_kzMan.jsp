<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_bkry_kz.action";
	divnid="Bkry_kzData";
	tableid="Bkry_kzTable";
	addUrl="basicsystem/insert_bkry_kz.action";
	addHtml="basic/basicsystem/Bkry_kzAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_bkry_kz.action";
	delid="d_bjgzid";
	modHtml="basic/basicsystem/Bkry_kzModify.jsp";
	modUrl="basicsystem/modify_bkry_kz.action";
	modWidth="500";
	detailHtml="basic/basicsystem/Bkry_kzDetail.jsp";
	detailid="bkry_kz_detail";
	detailUrl="basicsystem/query_bkry_kz.action";
	detailWidth="300";
	loadPage(divnid);
		$("#p_csrq").attr("readonly","true");
		$("#p_csrq").datepicker();
		$("#p_tbsj").attr("readonly","true");
		$("#p_tbsj").datepicker();
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
										colWidths: ["1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_bjgzid","Integer",-9999999999,9999999999,null,0,"报警规则ID"))
			return false;
		if (!checkControlValue("p_bjxxid","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("p_bkryid","Integer",-9999999999,9999999999,null,0,"布控人员ID"))
			return false;
		if (!checkControlValue("p_bkrykzid","Integer",-9999999999,9999999999,null,0,"布控人员快照ID"))
			return false;
		if (!checkControlValue("p_tbbh","String",1,20,null,0,"通报编号"))
			return false;
		if (!checkControlValue("p_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_cym","String",1,100,null,0,"曾用名"))
			return false;
		if (!checkControlValue("p_gmsfhm","String",1,20,null,0,"公民身份号码"))
			return false;
		if (!checkControlValue("p_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("p_jgdm","String",1,6,null,0,"籍贯代码"))
			return false;
		if (!checkControlValue("p_jg","String",1,100,null,0,"籍贯"))
			return false;
		if (!checkControlValue("p_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("p_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("p_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("p_mzdm","String",1,40,null,0,"民族代码"))
			return false;
		if (!checkControlValue("p_minzu","String",1,20,null,0,"民族"))
			return false;
		if (!checkControlValue("p_kybm","String",1,6,null,0,"口音编码"))
			return false;
		if (!checkControlValue("p_ky","String",1,100,null,0,"口音"))
			return false;
		if (!checkControlValue("p_shengao","Float",-999.99,999.99,2,0,"身高"))
			return false;
		if (!checkControlValue("p_tzbm","String",1,10,null,0,"体征编码"))
			return false;
		if (!checkControlValue("p_tz","String",1,100,null,0,"体征"))
			return false;
		if (!checkControlValue("p_ttbm","String",1,20,null,0,"体态编码"))
			return false;
		if (!checkControlValue("p_tt","String",1,100,null,0,"体态"))
			return false;
		if (!checkControlValue("p_yz","String",1,200,null,0,"衣着"))
			return false;
		if (!checkControlValue("p_zz","String",1,300,null,0,"住址"))
			return false;
		if (!checkControlValue("p_fwdw","String",1,100,null,0,"发文单位"))
			return false;
		if (!checkControlValue("p_fwdwbm","String",1,60,null,0,"发文单位编码"))
			return false;
		if (!checkControlValue("p_ajlbbm","String",1,20,null,0,"案件类别编码"))
			return false;
		if (!checkControlValue("p_ajlb","String",1,60,null,0,"案件类别"))
			return false;
		if (!checkControlValue("p_tbsj","Date",null,null,null,0,"通报时间"))
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
		if (!checkControlValue("p_lxfs","String",1,60,null,0,"联系方式"))
			return false;
		if (!checkControlValue("p_sftyfb","String",1,2,null,0,"是否同意发布"))
			return false;
		if (!checkControlValue("p_spdw","String",1,100,null,0,"审批单位"))
			return false;
		if (!checkControlValue("p_spr","String",1,100,null,0,"审批人"))
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
		if (!checkControlValue("p_xzqhbm","String",1,6,null,0,"行政区划编码"))
			return false;
		if (!checkControlValue("p_xzqh","String",1,100,null,0,"行政区划"))
			return false;
		if (!checkControlValue("p_fsbs","String",1,2,null,0,"发送标识"))
			return false;
		if (!checkControlValue("p_bkdxzp","byte[]",,,,0,"布控对象照片"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_bjgzid" value="">
<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">报警规则ID</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bjgzid" value="0"></td>
					<td width="10%" class="pagedistd">报警信息ID</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bjxxid" value="0"></td>
					<td width="10%" class="pagedistd">布控人员ID</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bkryid" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">布控人员快照ID</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bkrykzid" value="0"></td>
					<td width="10%" class="pagedistd">通报编号</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_tbbh" value=""></td>
					<td width="10%" class="pagedistd">姓名</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">曾用名</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_cym" value=""></td>
					<td width="10%" class="pagedistd">公民身份号码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_gmsfhm" value=""></td>
					<td width="10%" class="pagedistd">姓名拼音</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xmpy" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">籍贯代码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_jgdm" value=""></td>
					<td width="10%" class="pagedistd">籍贯</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_jg" value=""></td>
					<td width="10%" class="pagedistd">出生日期</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_csrq" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">性别代码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xbdm" value=""></td>
					<td width="10%" class="pagedistd">性别</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xb" value=""></td>
					<td width="10%" class="pagedistd">民族代码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_mzdm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">民族</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_minzu" value=""></td>
					<td width="10%" class="pagedistd">口音编码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_kybm" value=""></td>
					<td width="10%" class="pagedistd">口音</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ky" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">身高</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_shengao" value="0"></td>
					<td width="10%" class="pagedistd">体征编码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_tzbm" value=""></td>
					<td width="10%" class="pagedistd">体征</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_tz" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">体态编码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ttbm" value=""></td>
					<td width="10%" class="pagedistd">体态</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_tt" value=""></td>
					<td width="10%" class="pagedistd">衣着</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_yz" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">住址</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_zz" value=""></td>
					<td width="10%" class="pagedistd">发文单位</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_fwdw" value=""></td>
					<td width="10%" class="pagedistd">发文单位编码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_fwdwbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">案件类别编码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ajlbbm" value=""></td>
					<td width="10%" class="pagedistd">案件类别</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ajlb" value=""></td>
					<td width="10%" class="pagedistd">通报时间</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_tbsj" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">简要案情</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_jyaq" value=""></td>
					<td width="10%" class="pagedistd">处理结果</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_cljg" value=""></td>
					<td width="10%" class="pagedistd">布控人</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bkr" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">布控操作员</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bkczy" value=""></td>
					<td width="10%" class="pagedistd">布控操作时间</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bkczsj" value=""></td>
					<td width="10%" class="pagedistd">布控到期时间</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bkdqsj" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">布控范围编码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bkfwbm" value=""></td>
					<td width="10%" class="pagedistd">布控范围</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bkfw" value=""></td>
					<td width="10%" class="pagedistd">布控审批意见</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bkspyj" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">联系人</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_lxr" value=""></td>
					<td width="10%" class="pagedistd">联系方式</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_lxfs" value=""></td>
					<td width="10%" class="pagedistd">是否同意发布</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_sftyfb" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">审批单位</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_spdw" value=""></td>
					<td width="10%" class="pagedistd">审批人</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_spr" value=""></td>
					<td width="10%" class="pagedistd">审批日期</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_sprq" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">请求撤控标识</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_qqckbs" value=""></td>
					<td width="10%" class="pagedistd">撤控标识</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ckbs" value=""></td>
					<td width="10%" class="pagedistd">撤控原因</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ckyy" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">撤控时间</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_cksj" value=""></td>
					<td width="10%" class="pagedistd">撤控人</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ckr" value=""></td>
					<td width="10%" class="pagedistd">撤控操作员</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ckczy" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">撤控操作时间</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ckczsj" value=""></td>
					<td width="10%" class="pagedistd">撤控部门编码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ckbmbm" value=""></td>
					<td width="10%" class="pagedistd">撤控部门名称</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ckbmmc" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">撤控审批单位</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ckspdw" value=""></td>
					<td width="10%" class="pagedistd">撤控审批人</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ckspr" value=""></td>
					<td width="10%" class="pagedistd">撤控审批意见</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ckspyj" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">撤控审批日期</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_cksprq" value=""></td>
					<td width="10%" class="pagedistd">行政区划编码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xzqhbm" value=""></td>
					<td width="10%" class="pagedistd">行政区划</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xzqh" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">发送标识</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_fsbs" value=""></td>
					<td width="10%" class="pagedistd">布控对象照片</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bkdxzp" value=""></td>
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
<div id="bkry_kz_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="Bkry_kzData" style="width:100%;">
	<table id="Bkry_kzTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_bjxxid">报警信息ID</th>
	     	<th name="l_bkryid">布控人员ID</th>
	     	<th name="l_bkrykzid">布控人员快照ID</th>
	     	<th name="l_tbbh">通报编号</th>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_cym">曾用名</th>
	     	<th name="l_gmsfhm">公民身份号码</th>
	     	<th name="l_xmpy">姓名拼音</th>
	     	<th name="l_jgdm">籍贯代码</th>
	     	<th name="l_jg">籍贯</th>
	     	<th name="l_csrq">出生日期</th>
	     	<th name="l_xbdm">性别代码</th>
	     	<th name="l_xb">性别</th>
	     	<th name="l_mzdm">民族代码</th>
	     	<th name="l_minzu">民族</th>
	     	<th name="l_kybm">口音编码</th>
	     	<th name="l_ky">口音</th>
	     	<th name="l_shengao">身高</th>
	     	<th name="l_tzbm">体征编码</th>
	     	<th name="l_tz">体征</th>
	     	<th name="l_ttbm">体态编码</th>
	     	<th name="l_tt">体态</th>
	     	<th name="l_yz">衣着</th>
	     	<th name="l_zz">住址</th>
	     	<th name="l_fwdw">发文单位</th>
	     	<th name="l_fwdwbm">发文单位编码</th>
	     	<th name="l_ajlbbm">案件类别编码</th>
	     	<th name="l_ajlb">案件类别</th>
	     	<th name="l_tbsj">通报时间</th>
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
	     	<th name="l_spr">审批人</th>
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
	     	<th name="l_xzqhbm">行政区划编码</th>
	     	<th name="l_xzqh">行政区划</th>
	     	<th name="l_fsbs">发送标识</th>
	     	<th name="l_bkdxzp">布控对象照片</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>