<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_sjbdqxxkz.action";
	divnid="SjbdqxxkzData";
	tableid="SjbdqxxkzTable";
	addUrl="basicsystem/insert_sjbdqxxkz.action";
	addHtml="business/basicsystem/SjbdqxxkzAdd.jsp";
	addWidth="800";
	delUrl="basicsystem/delete_sjbdqxxkz.action";
	delid="d_bjxxid2";
	modHtml="business/basicsystem/SjbdqxxkzModify.jsp";
	modUrl="basicsystem/modify_sjbdqxxkz.action";
	modWidth="800";
	detailHtml="business/basicsystem/SjbdqxxkzDetail.jsp";
	detailid="sjbdqxxkz_detail";
	detailUrl="basicsystem/query_sjbdqxxkz.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_djrq").attr("readonly","true");
		$("#p_djrq").datepicker();
	
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
										colWidths: ["4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%","4%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("p_sjbdqxxkzid","Integer",-9999999999,9999999999,null,0,"手机被盗抢信息快照ID"))
			return false;
		if (!checkControlValue("p_xzqhbm","String",1,6,null,0,"行政区划编码"))
			return false;
		if (!checkControlValue("p_xzqh","String",1,100,null,0,"行政区划"))
			return false;
		if (!checkControlValue("p_sjch","String",1,30,null,0,"手机串号"))
			return false;
		if (!checkControlValue("p_pp","String",1,100,null,0,"品牌"))
			return false;
		if (!checkControlValue("p_xh","String",1,100,null,0,"型号"))
			return false;
		if (!checkControlValue("p_ys","String",1,60,null,0,"颜色"))
			return false;
		if (!checkControlValue("p_ajjbbm","String",1,2,null,0,"案件级别编码"))
			return false;
		if (!checkControlValue("p_ajjb","String",1,20,null,0,"案件级别"))
			return false;
		if (!checkControlValue("p_ajlbbm","String",1,30,null,0,"案件类别编码"))
			return false;
		if (!checkControlValue("p_ajlb","String",1,60,null,0,"案件类别"))
			return false;
		if (!checkControlValue("p_jyaq","String",1,2000,null,0,"简要案情"))
			return false;
		if (!checkControlValue("p_djrq","Date",null,null,null,0,"登记日期"))
			return false;
		if (!checkControlValue("p_djr","String",1,30,null,0,"登记人"))
			return false;
		if (!checkControlValue("p_ladqbm","String",1,6,null,0,"立案地区编码"))
			return false;
		if (!checkControlValue("p_ladq","String",1,300,null,0,"立案地区"))
			return false;
		if (!checkControlValue("p_badwbm","String",1,20,null,0,"办案单位编码"))
			return false;
		if (!checkControlValue("p_badw","String",1,100,null,0,"办案单位"))
			return false;
		if (!checkControlValue("p_tbr","String",1,100,null,0,"填表人"))
			return false;
		if (!checkControlValue("p_lxr","String",1,100,null,0,"联系人"))
			return false;
		if (!checkControlValue("p_lxfs","String",1,300,null,0,"联系方式"))
			return false;
		if (!checkControlValue("p_lxrsfhm","String",1,20,null,0,"联系人身份号码"))
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
					<td width="10%" class="pagedistd">手机被盗抢信息快照ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sjbdqxxkzid" value="0"></td>
					<td width="10%" class="pagedistd">行政区划编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xzqhbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">行政区划</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xzqh" value=""></td>
					<td width="10%" class="pagedistd">手机串号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sjch" value=""></td>
					<td width="10%" class="pagedistd">品牌</td>
					<td width="23%" class="pagetd"><input type="text" id="p_pp" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">型号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xh" value=""></td>
					<td width="10%" class="pagedistd">颜色</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ys" value=""></td>
					<td width="10%" class="pagedistd">案件级别编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ajjbbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">案件级别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ajjb" value=""></td>
					<td width="10%" class="pagedistd">案件类别编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ajlbbm" value=""></td>
					<td width="10%" class="pagedistd">案件类别</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ajlb" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">简要案情</td>
					<td width="23%" class="pagetd"><input type="text" id="p_jyaq" value=""></td>
					<td width="10%" class="pagedistd">登记日期</td>
					<td width="23%" class="pagetd"><input type="text" id="p_djrq" value=""></td>
					<td width="10%" class="pagedistd">登记人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_djr" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">立案地区编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ladqbm" value=""></td>
					<td width="10%" class="pagedistd">立案地区</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ladq" value=""></td>
					<td width="10%" class="pagedistd">办案单位编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_badwbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">办案单位</td>
					<td width="23%" class="pagetd"><input type="text" id="p_badw" value=""></td>
					<td width="10%" class="pagedistd">填表人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tbr" value=""></td>
					<td width="10%" class="pagedistd">联系人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lxr" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">联系方式</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lxfs" value=""></td>
					<td width="10%" class="pagedistd">联系人身份号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lxrsfhm" value=""></td>
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
<div id="sjbdqxxkz_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="SjbdqxxkzData" style="width:100%;">
	<table id="SjbdqxxkzTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_sjbdqxxkzid">手机被盗抢信息快照ID</th>
	     	<th name="l_xzqhbm">行政区划编码</th>
	     	<th name="l_xzqh">行政区划</th>
	     	<th name="l_sjch">手机串号</th>
	     	<th name="l_pp">品牌</th>
	     	<th name="l_xh">型号</th>
	     	<th name="l_ys">颜色</th>
	     	<th name="l_ajjbbm">案件级别编码</th>
	     	<th name="l_ajjb">案件级别</th>
	     	<th name="l_ajlbbm">案件类别编码</th>
	     	<th name="l_ajlb">案件类别</th>
	     	<th name="l_jyaq">简要案情</th>
	     	<th name="l_djrq">登记日期</th>
	     	<th name="l_djr">登记人</th>
	     	<th name="l_ladqbm">立案地区编码</th>
	     	<th name="l_ladq">立案地区</th>
	     	<th name="l_badwbm">办案单位编码</th>
	     	<th name="l_badw">办案单位</th>
	     	<th name="l_tbr">填表人</th>
	     	<th name="l_lxr">联系人</th>
	     	<th name="l_lxfs">联系方式</th>
	     	<th name="l_lxrsfhm">联系人身份号码</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>