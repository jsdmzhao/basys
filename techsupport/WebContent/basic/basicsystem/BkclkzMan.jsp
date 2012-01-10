<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_bkclkz.action";
	divnid="BkclkzData";
	tableid="BkclkzTable";
	addUrl="basicsystem/insert_bkclkz.action";
	addHtml="business/basicsystem/BkclkzAdd.jsp";
	addWidth="800";
	delUrl="basicsystem/delete_bkclkz.action";
	delid="d_bjxxid2";
	modHtml="business/basicsystem/BkclkzModify.jsp";
	modUrl="basicsystem/modify_bkclkz.action";
	modWidth="800";
	detailHtml="business/basicsystem/BkclkzDetail.jsp";
	detailid="bkclkz_detail";
	detailUrl="basicsystem/query_bkclkz.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_ccdjrq").attr("readonly","true");
		$("#p_ccdjrq").datepicker();
	
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
										colWidths: ["6%","6%","6%","6%","6%","6%","6%","6%","6%","6%","6%","6%","6%","6%","6%","6%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("p_bkwpjbxxkzid","Integer",-9999999999,9999999999,null,0,"布控物品基本信息快照ID"))
			return false;
		if (!checkControlValue("p_bkclkzid","Integer",-9999999999,9999999999,null,0,"布控车辆快照ID"))
			return false;
		if (!checkControlValue("p_cllxdm","String",1,10,null,0,"车辆类型代码"))
			return false;
		if (!checkControlValue("p_cllx","String",1,32,null,0,"车辆类型"))
			return false;
		if (!checkControlValue("p_clpp","String",1,64,null,0,"车辆品牌"))
			return false;
		if (!checkControlValue("p_clxh","String",1,64,null,0,"车辆型号"))
			return false;
		if (!checkControlValue("p_hpzldm","String",1,4,null,0,"号牌种类代码"))
			return false;
		if (!checkControlValue("p_hpzl","String",1,32,null,0,"号牌种类"))
			return false;
		if (!checkControlValue("p_hphm","String",1,32,null,0,"号牌号码"))
			return false;
		if (!checkControlValue("p_csys","String",1,32,null,0,"车身颜色"))
			return false;
		if (!checkControlValue("p_syr","String",1,512,null,0,"机动车所有人"))
			return false;
		if (!checkControlValue("p_ccdjrq","Date",null,null,null,0,"初次登记时间"))
			return false;
		if (!checkControlValue("p_fdjh","String",1,60,null,0,"发动机号"))
			return false;
		if (!checkControlValue("p_clsbdh","String",1,50,null,0,"车辆识别代号"))
			return false;
		if (!checkControlValue("p_cjh","String",1,50,null,0,"车架号"))
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
					<td width="10%" class="pagedistd">布控车辆快照ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bkclkzid" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">车辆类型代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cllxdm" value=""></td>
					<td width="10%" class="pagedistd">车辆类型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cllx" value=""></td>
					<td width="10%" class="pagedistd">车辆品牌</td>
					<td width="23%" class="pagetd"><input type="text" id="p_clpp" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">车辆型号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_clxh" value=""></td>
					<td width="10%" class="pagedistd">号牌种类代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hpzldm" value=""></td>
					<td width="10%" class="pagedistd">号牌种类</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hpzl" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">号牌号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hphm" value=""></td>
					<td width="10%" class="pagedistd">车身颜色</td>
					<td width="23%" class="pagetd"><input type="text" id="p_csys" value=""></td>
					<td width="10%" class="pagedistd">机动车所有人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_syr" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">初次登记时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ccdjrq" value=""></td>
					<td width="10%" class="pagedistd">发动机号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_fdjh" value=""></td>
					<td width="10%" class="pagedistd">车辆识别代号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_clsbdh" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">车架号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cjh" value=""></td>
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
<div id="bkclkz_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="BkclkzData" style="width:100%;">
	<table id="BkclkzTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_bkwpjbxxkzid">布控物品基本信息快照ID</th>
	     	<th name="l_bkclkzid">布控车辆快照ID</th>
	     	<th name="l_cllxdm">车辆类型代码</th>
	     	<th name="l_cllx">车辆类型</th>
	     	<th name="l_clpp">车辆品牌</th>
	     	<th name="l_clxh">车辆型号</th>
	     	<th name="l_hpzldm">号牌种类代码</th>
	     	<th name="l_hpzl">号牌种类</th>
	     	<th name="l_hphm">号牌号码</th>
	     	<th name="l_csys">车身颜色</th>
	     	<th name="l_syr">机动车所有人</th>
	     	<th name="l_ccdjrq">初次登记时间</th>
	     	<th name="l_fdjh">发动机号</th>
	     	<th name="l_clsbdh">车辆识别代号</th>
	     	<th name="l_cjh">车架号</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>