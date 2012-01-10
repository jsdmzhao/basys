<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	
	pageUrl="publicsystem/querylist_lhjc.action";
	divnid="LhjcData";
	tableid="LhjcTable";
	addUrl="publicsystem/insert_lhjc.action";
	addHtml="basic/publicsystem/LhjcAdd.jsp"; 
	addWidth="550";
	delUrl="publicsystem/delete_lhjc.action";
	delid="d_lhjcid";
	modHtml="basic/publicsystem/LhjcModify.jsp";
	modUrl="publicsystem/modify_lhjc.action";
	modWidth="550";
	detailHtml="basic/publicsystem/LhjcDetail.jsp";
	detailid="lhjc_detail";
	detailUrl="publicsystem/query_lhjc.action";
	detailWidth="550";
	
	$("#p_lcsj").attr("readonly","true");
	$("#p_lcsj").datepicker();
	$("#p_lcsjzhi").attr("readonly","true");
	$("#p_lcsjzhi").datepicker();
	$("#p_lcjgjbdm").selectBox({code:"dm_lcjgjb"});
	$("#p_lcjglxdm").selectBox({code:"dm_lcjglx"});
	$("#p_hylbdm").selectBoxhylb();//行业类别	
	
	
	$("#p_gxdwmc").click(function(){ //管辖单位
			getGxdw("p_gxdwmc","p_gxdwbm");
	});
	daggleDiv(detailid);
	loadPage(divnid);
	// 根据行业类别设定表示信息
	setHyxx();
}); 
	function setList(pageno,url){	
	$("#"+divnid).html(tables);	
	createXML("p_");
	if (url==null || url=="undefined"){
		url=pageUrl;
	}
	return url;
}	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageWidth: pageWidth,
										url: url,	
										height: pageHeight-278,
										pageNumber: pageno,
										hideColIndex: [7],
										ingridPageParams: sXML,
										colWidths: ["20%","20%","15%","15%","10%","10%","10%","0%"]									
									});				
		setHyxx();
		}
}	
	function manVerify(){
	/**
		if (!checkControlValue("p_qyid","Integer",-9999999999,9999999999,null,0,"企业ID"))
			return false;
		if (!checkControlValue("p_lhjcid","Integer",-9999999999,9999999999,null,0,"联合检查ID"))
			return false;
		if (!checkControlValue("p_glbmlhjcdjxh","String",1,30,null,0,"管理部门联合检查登记序号"))
			return false;
		if (!checkControlValue("p_lcjgjbdm","String",1,1,null,0,"联查机构级别代码"))
			return false;
		if (!checkControlValue("p_lcjgjb","String",1,30,null,0,"联查机构级别"))
			return false;
		if (!checkControlValue("p_lcjglxdm","String",1,1,null,0,"联查机构类型代码"))
			return false;
		if (!checkControlValue("p_lcjglx","String",1,30,null,0,"联查机构类型"))
			return false;
		if (!checkControlValue("p_lcjgdm","String",1,30,null,0,"联查机构代码"))
			return false;
		if (!checkControlValue("p_lcjgmc","String",1,100,null,0,"联查机构名称"))
			return false;
		if (!checkControlValue("p_lcsj","Date",null,null,null,0,"联查时间"))
			return false;
		if (!checkControlValue("p_lcryxm","String",1,300,null,0,"联查人员姓名"))
			return false;
		if (!checkControlValue("p_lcsx","String",1,200,null,0,"联查事项"))
			return false;
		if (!checkControlValue("p_fxwt","String",1,300,null,0,"发现问题"))
			return false;
		if (!checkControlValue("p_lcjg","String",1,200,null,0,"联查结果"))
			return false;
			*/
		return true;
	}
		  //企业筛选框
 $("#p_qymc").click(function(){
	 dataid=$('#p_hylbdm').val();
	 getTy_item("p_qymc","","p_qyid");
  });
  //设定行业信息表示
    function setHyxx(){
        var hylb=$("#p_hylbdm").val();
		if(hylb=='J'||hylb=='K'){
			$('#td_qymc').text('场所名称');
			$('#td_qybm').text('场所备案编号');
			$('#LhjcData').find('thead').find('th[@name=l_qymc]').find('DIV').html('场所名称');
		}else{
		    $('#td_qymc').text('企业名称');
		    $('#td_qybm').text('企业编号');
			$('#LhjcData').find('thead').find('th[@name=l_qymc]').find('DIV').html('企业名称');
		}
    }
</script>

<body>
	<input type="hidden" id="p_qyid">
	<input type="hidden" id="p_gxdwbm">
	<input type="hidden" id="d_lhjcid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">联合检查管理</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
				
					<td width="10%" class="pagedistd">管理部门联合检查登记序号</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_glbmlhjcdjxh" value=""></td>
						<td width="10%" class="pagedistd">联查机构级别</td>
					<td width="23%" class="pagetd">
					<select type="text" id="p_lcjgjbdm" value="">
					<option></option>
					</select>
					</td>
					<td width="10%" class="pagedistd">联查机构类型</td>
					<td width="23%" class="pagetd"><select type="text" id="p_lcjglxdm" value="">
					<option></option>
					</select>
					</td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">联查机构名称</td>
					<td width="23%" class="pagetd"><input type="text"  class="inputstyle" id="p_lcjgmc" value=""></td>
					<td width="10%" class="pagedistd">联查时间</td>
					<td width="23%" class="pagetd"><input type="text"  class="inputstyle" id="p_lcsj" value=""></td>
					<td width="10%" class="pagedistd">联查时间至</td>
					<td width="23%" class="pagetd"><input type="text"  class="inputstyle" id="p_lcsjzhi" value=""></td>
					</tr>
					<tr>
					<td width="10%" class="pagedistd">联查人员姓名</td>
					<td width="23%" class="pagetd"><input type="text"  class="inputstyle" id="p_lcryxm" value=""></td>
					  <td width="10%" class="pagedistd">管辖单位</td>
					<td width="23%" class="pagetd"><input type="text" id="p_gxdwmc" class="inputstyle" value="" readonly></td>
					 <td width="10%" class="pagedistd">行业类别</td>
					<td width="23%" class="pagetd"><select  id="p_hylbdm"  onchange="setHyxx();"></select></td>
					</tr>
					<tr>
					<td width="10%" class="pagedistd" id="td_qymc">企业名称</td>
					<td width="23%" class="pagetd"><input type="text"  class="inputstyle" id="p_qymc" value="" readonly="readonly"></td>
					<td width="10%" class="pagedistd" id="td_qybm">企业编号</td>
					<td width="23%" class="pagetd"><input type="text"  class="inputstyle" id="p_qybm" value=""></td>
					<td colspan="2" align="right">
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
<div id="lhjc_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="LhjcData" style="width:100%;">
	<table id="LhjcTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_glbmlhjcdjxh">登记序号</th>
	     	<th name="l_lcjgjb">机构级别</th>
	     	<th name="l_lcjglx">机构类型</th>
	     	<th name="l_lcjgmc">机构名称</th>
	     	<th name="l_lcsj">联查时间</th>
	     	<th name="l_lcryxm">联查人员姓名</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
