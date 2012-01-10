<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_qgztjx_kz.action";
	divnid="Qgztjx_kzData";
	tableid="Qgztjx_kzTable";
	addUrl="basicsystem/insert_qgztjx_kz.action";
	addHtml="basic/basicsystem/Qgztjx_kzAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_qgztjx_kz.action";
	delid="d_qgztjxid";
	modHtml="basic/basicsystem/Qgztjx_kzModify.jsp";
	modUrl="basicsystem/modify_qgztjx_kz.action";
	modWidth="500";
	detailHtml="basic/basicsystem/Qgztjx_kzDetail.jsp";
	detailid="qgztjx_kz_detail";
	detailUrl="basicsystem/query_qgztjx_kz.action";
	detailWidth="300";
	loadPage(divnid);
		$("#p_csrq").attr("readonly","true");
		$("#p_csrq").datepicker();
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
										colWidths: ["2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%","2%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_qgztjxid","Integer",-9999999999,9999999999,null,0,"全国在逃简项ID"))
			return false;
		if (!checkControlValue("p_bjgzid","Integer",-9999999999,9999999999,null,0,"报警规则ID"))
			return false;
		if (!checkControlValue("p_bjxxid","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("p_qgztjxkzid","Integer",-9999999999,9999999999,null,0,"全国在逃简项快照ID"))
			return false;
		if (!checkControlValue("p_tbbh","String",1,20,null,0,"通报编号"))
			return false;
		if (!checkControlValue("p_xzqhbm","String",1,6,null,0,"行政区划编码"))
			return false;
		if (!checkControlValue("p_xzqh","String",1,100,null,0,"行政区划"))
			return false;
		if (!checkControlValue("p_xmpy","String",1,60,null,0,"姓名拼音"))
			return false;
		if (!checkControlValue("p_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_bm","String",1,30,null,0,"别名"))
			return false;
		if (!checkControlValue("p_xbdm","String",1,2,null,0,"性别代码"))
			return false;
		if (!checkControlValue("p_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("p_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("p_gmsfhm","String",1,20,null,0,"公民身份号码"))
			return false;
		if (!checkControlValue("p_hjdbm","String",1,6,null,0,"户籍地编码"))
			return false;
		if (!checkControlValue("p_hjd","String",1,300,null,0,"户籍地"))
			return false;
		if (!checkControlValue("p_hjxxdz","String",1,300,null,0,"户籍详细地址"))
			return false;
		if (!checkControlValue("p_xzdqbm","String",1,6,null,0,"现住地区编码"))
			return false;
		if (!checkControlValue("p_xzdq","String",1,300,null,0,"现住地区"))
			return false;
		if (!checkControlValue("p_xzdxxdz","String",1,300,null,0,"现住地详细地址"))
			return false;
		if (!checkControlValue("p_qtzjlx","String",1,20,null,0,"其他证件类型"))
			return false;
		if (!checkControlValue("p_qtzjhm","String",1,20,null,0,"其他证件号码"))
			return false;
		if (!checkControlValue("p_ajjbbm","String",1,2,null,0,"案件级别编码"))
			return false;
		if (!checkControlValue("p_ajjb","String",1,20,null,0,"案件级别"))
			return false;
		if (!checkControlValue("p_ajlbbm","String",1,20,null,0,"案件类别编码"))
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
		if (!checkControlValue("p_lxfs","String",1,60,null,0,"联系方式"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_qgztjxid" value="">
<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">全国在逃简项ID</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_qgztjxid" value="0"></td>
					<td width="10%" class="pagedistd">报警规则ID</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bjgzid" value="0"></td>
					<td width="10%" class="pagedistd">报警信息ID</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bjxxid" value="0"></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">全国在逃简项快照ID</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_qgztjxkzid" value="0"></td>
					<td width="10%" class="pagedistd">通报编号</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_tbbh" value=""></td>
					<td width="10%" class="pagedistd">行政区划编码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xzqhbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">行政区划</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xzqh" value=""></td>
					<td width="10%" class="pagedistd">姓名拼音</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xmpy" value=""></td>
					<td width="10%" class="pagedistd">姓名</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">别名</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_bm" value=""></td>
					<td width="10%" class="pagedistd">性别代码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xbdm" value=""></td>
					<td width="10%" class="pagedistd">性别</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xb" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">出生日期</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_csrq" value=""></td>
					<td width="10%" class="pagedistd">公民身份号码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_gmsfhm" value=""></td>
					<td width="10%" class="pagedistd">户籍地编码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_hjdbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">户籍地</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_hjd" value=""></td>
					<td width="10%" class="pagedistd">户籍详细地址</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_hjxxdz" value=""></td>
					<td width="10%" class="pagedistd">现住地区编码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xzdqbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">现住地区</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xzdq" value=""></td>
					<td width="10%" class="pagedistd">现住地详细地址</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_xzdxxdz" value=""></td>
					<td width="10%" class="pagedistd">其他证件类型</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_qtzjlx" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">其他证件号码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_qtzjhm" value=""></td>
					<td width="10%" class="pagedistd">案件级别编码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ajjbbm" value=""></td>
					<td width="10%" class="pagedistd">案件级别</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ajjb" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">案件类别编码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ajlbbm" value=""></td>
					<td width="10%" class="pagedistd">案件类别</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ajlb" value=""></td>
					<td width="10%" class="pagedistd">简要案情</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_jyaq" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">登记日期</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_djrq" value=""></td>
					<td width="10%" class="pagedistd">登记人</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_djr" value=""></td>
					<td width="10%" class="pagedistd">立案地区编码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ladqbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">立案地区</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_ladq" value=""></td>
					<td width="10%" class="pagedistd">办案单位编码</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_badwbm" value=""></td>
					<td width="10%" class="pagedistd">办案单位</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_badw" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">填表人</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_tbr" value=""></td>
					<td width="10%" class="pagedistd">联系人</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_lxr" value=""></td>
					<td width="10%" class="pagedistd">联系方式</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_lxfs" value=""></td>
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
<div id="qgztjx_kz_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="Qgztjx_kzData" style="width:100%;">
	<table id="Qgztjx_kzTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_bjgzid">报警规则ID</th>
	     	<th name="l_bjxxid">报警信息ID</th>
	     	<th name="l_qgztjxkzid">全国在逃简项快照ID</th>
	     	<th name="l_tbbh">通报编号</th>
	     	<th name="l_xzqhbm">行政区划编码</th>
	     	<th name="l_xzqh">行政区划</th>
	     	<th name="l_xmpy">姓名拼音</th>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_bm">别名</th>
	     	<th name="l_xbdm">性别代码</th>
	     	<th name="l_xb">性别</th>
	     	<th name="l_csrq">出生日期</th>
	     	<th name="l_gmsfhm">公民身份号码</th>
	     	<th name="l_hjdbm">户籍地编码</th>
	     	<th name="l_hjd">户籍地</th>
	     	<th name="l_hjxxdz">户籍详细地址</th>
	     	<th name="l_xzdqbm">现住地区编码</th>
	     	<th name="l_xzdq">现住地区</th>
	     	<th name="l_xzdxxdz">现住地详细地址</th>
	     	<th name="l_qtzjlx">其他证件类型</th>
	     	<th name="l_qtzjhm">其他证件号码</th>
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
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>