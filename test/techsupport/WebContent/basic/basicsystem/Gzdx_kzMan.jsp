<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_gzdx_kz.action";
	divnid="Gzdx_kzData";
	tableid="Gzdx_kzTable";
	addUrl="basicsystem/insert_gzdx_kz.action";
	addHtml="basic/basicsystem/Gzdx_kzAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_gzdx_kz.action";
	delid="d_gzdxid";
	modHtml="basic/basicsystem/Gzdx_kzModify.jsp";
	modUrl="basicsystem/modify_gzdx_kz.action";
	modWidth="500";
	detailHtml="basic/basicsystem/Gzdx_kzDetail.jsp";
	detailid="gzdx_kz_detail";
	detailUrl="basicsystem/query_gzdx_kz.action";
	detailWidth="300";
	loadPage(divnid);
		$("#p_csrq").attr("readonly","true");
		$("#p_csrq").datepicker();
		$("#p_tbrq").attr("readonly","true");
		$("#p_tbrq").datepicker();
		$("#p_zxrq").attr("readonly","true");
		$("#p_zxrq").datepicker();
	
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
										colWidths: ["3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%","3%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_gzdxid","Integer",-9999999999,9999999999,null,0,"关注对象ID"))
			return false;
		if (!checkControlValue("p_yjgzid","Integer",-9999999999,9999999999,null,0,"预警规则ID"))
			return false;
		if (!checkControlValue("p_yjxxid","Integer",-9999999999,9999999999,null,0,"预警信息ID"))
			return false;
		if (!checkControlValue("p_gzdxkzid","Integer",-9999999999,9999999999,null,0,"关注对象快照ID"))
			return false;
		if (!checkControlValue("p_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_bm","String",1,30,null,0,"别名"))
			return false;
		if (!checkControlValue("p_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("p_mzdm","String",1,40,null,0,"民族代码"))
			return false;
		if (!checkControlValue("p_minzu","String",1,20,null,0,"民族"))
			return false;
		if (!checkControlValue("p_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("p_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("p_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("p_hjdxzqh","String",1,200,null,0,"户籍地行政区划"))
			return false;
		if (!checkControlValue("p_hjdxzqhdm","String",1,10,null,0,"户籍地行政区划代码"))
			return false;
		if (!checkControlValue("p_hjdxz","String",1,200,null,0,"户籍地详址"))
			return false;
		if (!checkControlValue("p_cyzjdm","String",1,40,null,0,"常用证件代码"))
			return false;
		if (!checkControlValue("p_cyzj","String",1,100,null,0,"常用证件"))
			return false;
		if (!checkControlValue("p_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("p_whcd","String",1,60,null,0,"文化程度"))
			return false;
		if (!checkControlValue("p_gzdxsf","String",1,100,null,0,"关注对象身份"))
			return false;
		if (!checkControlValue("p_shengao","Float",-999.99,999.99,2,0,"身高"))
			return false;
		if (!checkControlValue("p_xzdq","String",1,300,null,0,"现住地区"))
			return false;
		if (!checkControlValue("p_xzdqxz","String",1,2000,null,0,"现住地区祥址"))
			return false;
		if (!checkControlValue("p_tbdw","String",1,100,null,0,"填报单位"))
			return false;
		if (!checkControlValue("p_tbr","String",1,100,null,0,"填表人"))
			return false;
		if (!checkControlValue("p_tbrq","Date",null,null,null,0,"填报日期"))
			return false;
		if (!checkControlValue("p_tbdabm","String",1,60,null,0,"填报单位编码"))
			return false;
		if (!checkControlValue("p_zxbz","String",1,2,null,0,"注销标志"))
			return false;
		if (!checkControlValue("p_zxrq","Date",null,null,null,0,"注销日期"))
			return false;
		if (!checkControlValue("p_zxr","String",1,30,null,0,"注销人"))
			return false;
		if (!checkControlValue("p_bz","String",1,2000,null,0,"备注"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_gzdxid" value="">
<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">关注对象ID</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_gzdxid" value="0"></td>
					<td width="10%" class="pagedistd">预警规则ID</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_yjgzid" value="0"></td>
					<td width="10%" class="pagedistd">预警信息ID</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_yjxxid" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">关注对象快照ID</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_gzdxkzid" value="0"></td>
					<td width="10%" class="pagedistd">姓名</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xm" value=""></td>
					<td width="10%" class="pagedistd">别名</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">姓名拼音</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xmpy" value=""></td>
					<td width="10%" class="pagedistd">民族代码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_mzdm" value=""></td>
					<td width="10%" class="pagedistd">民族</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_minzu" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">性别代码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xbdm" value=""></td>
					<td width="10%" class="pagedistd">性别</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xb" value=""></td>
					<td width="10%" class="pagedistd">出生日期</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_csrq" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">户籍地行政区划</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_hjdxzqh" value=""></td>
					<td width="10%" class="pagedistd">户籍地行政区划代码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_hjdxzqhdm" value=""></td>
					<td width="10%" class="pagedistd">户籍地详址</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_hjdxz" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">常用证件代码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_cyzjdm" value=""></td>
					<td width="10%" class="pagedistd">常用证件</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_cyzj" value=""></td>
					<td width="10%" class="pagedistd">证件号码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_zjhm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">文化程度</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_whcd" value=""></td>
					<td width="10%" class="pagedistd">关注对象身份</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_gzdxsf" value=""></td>
					<td width="10%" class="pagedistd">身高</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_shengao" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">现住地区</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xzdq" value=""></td>
					<td width="10%" class="pagedistd">现住地区祥址</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xzdqxz" value=""></td>
					<td width="10%" class="pagedistd">填报单位</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_tbdw" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">填表人</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_tbr" value=""></td>
					<td width="10%" class="pagedistd">填报日期</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_tbrq" value=""></td>
					<td width="10%" class="pagedistd">填报单位编码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_tbdabm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">注销标志</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_zxbz" value=""></td>
					<td width="10%" class="pagedistd">注销日期</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_zxrq" value=""></td>
					<td width="10%" class="pagedistd">注销人</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_zxr" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">备注</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bz" value=""></td>
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
<div id="gzdx_kz_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="Gzdx_kzData" style="width:100%;">
	<table id="Gzdx_kzTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_yjgzid">预警规则ID</th>
	     	<th name="l_yjxxid">预警信息ID</th>
	     	<th name="l_gzdxkzid">关注对象快照ID</th>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_bm">别名</th>
	     	<th name="l_xmpy">姓名拼音</th>
	     	<th name="l_mzdm">民族代码</th>
	     	<th name="l_minzu">民族</th>
	     	<th name="l_xbdm">性别代码</th>
	     	<th name="l_xb">性别</th>
	     	<th name="l_csrq">出生日期</th>
	     	<th name="l_hjdxzqh">户籍地行政区划</th>
	     	<th name="l_hjdxzqhdm">户籍地行政区划代码</th>
	     	<th name="l_hjdxz">户籍地详址</th>
	     	<th name="l_cyzjdm">常用证件代码</th>
	     	<th name="l_cyzj">常用证件</th>
	     	<th name="l_zjhm">证件号码</th>
	     	<th name="l_whcd">文化程度</th>
	     	<th name="l_gzdxsf">关注对象身份</th>
	     	<th name="l_shengao">身高</th>
	     	<th name="l_xzdq">现住地区</th>
	     	<th name="l_xzdqxz">现住地区祥址</th>
	     	<th name="l_tbdw">填报单位</th>
	     	<th name="l_tbr">填表人</th>
	     	<th name="l_tbrq">填报日期</th>
	     	<th name="l_tbdabm">填报单位编码</th>
	     	<th name="l_zxbz">注销标志</th>
	     	<th name="l_zxrq">注销日期</th>
	     	<th name="l_zxr">注销人</th>
	     	<th name="l_bz">备注</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body></html>