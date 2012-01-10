<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<html>
<head>
<script type="text/javascript">
	var qyjbxx_requestType=""; //请求类型 添加、查看、修改
	var qyjbxx_dataid="";
	
	$(document).ready(function() {
		//导出功能
		tabletitle = "";
		geteExcelHead("IckyjData");
		initTJDate();
		
		pageUrl="icksystem/querylist_ickyj.action";
		divnid="IckyjData";
		tableid="IckyjTable";
		addUrl="icksystem/insert_ickyj.action";
		addHtml="business/icksystem/IckyjAdd.jsp";
		addWidth="1000";
		delUrl="icksystem/delete_ickyj.action";
		delid="d_ickyjid";
		modHtml="business/icksystem/IckyjModify.jsp";
		modUrl="icksystem/modify_ickyj.action";
		modWidth="1000";
		detailHtml="";
		detailid="qyjbxx_detail";
		detailUrl="";
		detailWidth="1000";
		loadPage(divnid);
		
		$("#p_sksjf").attr("readonly","true").attr("value",tomorrowDate).datepicker();
		$("#p_sksjt").attr("readonly","true").attr("value",currentDate).datepicker();
		
		$("#p_hylbdm").selectBoxhylb();
		setqyxx();
		$("#"+detailid).hide();
		
		daggleDiv(detailid);
	}); 
	function setqyxx(){
		if($("#p_hylbdm").val()=="J"||$("#p_hylbdm").val()=="K"){
		$("#td_qymc").text("场所名称");
		} else {
		$("#td_qymc").text("企业名称");
		}
		
	}
	function setPageList(pageno,url){	
		if (manVerify()){
			url=setList(pageno,url);
			// create the grid
			// returns a jQ object with a 'g' property - that's ingrid
			var mygrid1 = $("#"+tableid).ingrid({ 
											url: url,	
											height: pageHeight-228,
	                                       ingridPageParams:sXML,
											pageNumber: pageno,
											onRowSelect: function(tr, selected){},
											onTdSelect: function(tr){
												var thisIds = $(tr).attr("id"); 
												var qyid = thisIds.split("___")[1].split("---")[0];
												var hylbdm = thisIds.split("___")[1].split("---")[1];
												var qymc = $(tr).find("td").eq(4);
												qymc.html("<a href='#' class='hyperlink' onClick=qyjbxxDetail('"+qyid+"','"+hylbdm+"');>"+qymc.text()+"</a>");
											},
											colWidths: ["15%","15%","15%","15%","20%","20%"],
											sorting: false								
										});				
			}
	}	
	
	function manVerify(){
		var p_sksjf = $("#p_sksjf").attr("value");
		var p_sksjt = $("#p_sksjt").attr("value");
		if(formatDate(p_sksjf)-formatDate(p_sksjt)>0){
			jAlert("查询截止时间不能大于其实时间!","提示信息");
			return false;
		}
		return true;
	}
	
	function formatDate(strDate){ //转换成日期格式
		var riqi = strDate.split("-");
		return new Date(riqi[0],(riqi[1]-1),riqi[2]);
	}
	qyjbxx_dataid="";
	function qyjbxxDetail(qyid,hylbdm){ //企业详情
		qyjbxx_dataid=qyid;
		//根据不同的行业类别显示不同的人员详细页面
		if(hylbdm=='J')
		{
			detailUrl="publicsystem/query_qyjbxx.action";
			detailHtml="business/Ylfwzagl/YlcsjbxxDetail.jsp";
			setWidth(detailid,detailWidth);
			$('#'+detailid).css('left','5').css('top','30');
			setUrl(detailid,detailHtml);
			bindDocument(detailid);
		}
		else
		{
			detailUrl="publicsystem/query_qyjbxx.action";
			detailHtml="basic/publicsystem/QyjbxxDetail.jsp";
			setWidth(detailid,detailWidth);
			setUrl(detailid,detailHtml);
			bindDocument(detailid);
		}
	}
	
	
	var excelUrl="icksystem/querylistExcel_ickyj.action";
	var searchLongUrl="icksystem/querylistExcelTemp_ickyj.action";
	
	/*
	不分页传参数将结果集返回，用于长参数导出前的查询
	*/
	function setSearchLongQyxx(){
		setParams("p_");
		jQuery.post(searchLongUrl,params,searchLongBack,"json");
	}
	//导出前对应setSearchLong()的回调方法  由于执行查询时候有延迟，故将导出放入回调函数
	function searchLongBack(json){
		//报表标题
		var bbmc="费卡刷卡查询";
		//报表请求
		setExcelLong("fkcxDoExcel",bbmc);
	}
	/*setExcel 生成EXCEL,不传参数，防止超长
	 * excelid 链接id
	 * bbmc：报表标题
	 */
	function setExcelLong(excelid,bbmc){
		var surl=excelUrl+"?tabletitle="+tabletitle+"&bbmc="+bbmc;
		surl=encodeURI(surl);
		location.href = surl;
	}
</script>
</head>
<body>
	
	<input type="hidden" id="d_ickyjid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">废卡刷卡查询</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd" id="td_qymc">企业名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qymc" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">刷卡时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sksjf" class="inputstyle" value=""></td>
					<td width="10%" class="pagedistd">至</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sksjt" class="inputstyle" value=""></td>
				</tr>
    		<tr>
    			<td width="10%" class="pagedistd">行业类别</td>
					<td width="23%" class="pagetd"><select type="select" id="p_hylbdm" onchange="setqyxx();"></td>
    		  	<td colspan="4">
    		  	<table border="0" align="right" cellpadding="2" cellspacing="0">
    		    	<tr>
    		    	  <td width="62px"><a href="#" class="searchbutton" id="querys" onclick="setPageList(1);">查询</a></td>
    		    	  <td width="62px"><a href="#" class="exceldcbutton" onClick="setSearchLongQyxx()" id="fkcxDoExcel">导出</a></td>
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
<div id="qyjbxx_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="IckyjData" style="width:100%;">
	<table id="IckyjTable" width="100%">
	  <thead>
	    <tr>
	    	<th name="l_xm" datatype="string" sumflag="0">姓名</th>
	    	<th name="l_kh" datatype="string" sumflag="0">从业人员编号</th>
	    	<th name="l_sksj" datatype="string" sumflag="0">刷卡时间</th>
	     	<th name="l_sxsj" datatype="string" sumflag="0">失效时间</th>
	     	<th name="l_qymc" datatype="string" sumflag="0">刷卡场所</th>
	     	<th name="l_gxdwmc" datatype="string" sumflag="0">管辖单位</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>

</body>
</html>