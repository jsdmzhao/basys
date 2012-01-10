<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%
User user = (User)session.getAttribute(Constants.userKey);
	String userCount = "";
	if (user != null) {
		userCount = user.getSsdwbm();
	}
%>
<script type="text/javascript">
	var date = new Date();
	var nowMonth = (date.getMonth()+1)+'';
	var nowDate = date.getDate()+'';
	if(nowMonth.length==1) nowMonth = '0'+nowMonth;
	if(nowDate.length==1)  nowDate = '0'+nowDate;
	var nowTime = date.getYear()+'-'+nowMonth+'-'+nowDate;
	
	date.setDate(date.getDate() - 1);
	var nowMonth = (date.getMonth()+1)+'';
	var nowDate = date.getDate()+'';
	if(nowMonth.length==1) nowMonth = '0'+nowMonth;
	if(nowDate.length==1) nowDate = '0'+nowDate;
	var oldTime = date.getYear()+'-'+nowMonth+'-'+nowDate;
	
	$(document).ready(function() {
		divnid="tabledata";
		tableid="table1";
		loadPage("tabledata");
	
		//csxxtjInit();
		$("#t_qssj").attr("readonly","true").attr("value",oldTime).datepicker();
		$("#t_jzsj").attr("readonly","true").attr("value",nowTime).datepicker();
		//$("#t_deptCode").attr("value",departCode);
		//$("#z_deptCode").attr("value",departCode);
		
		pageUrl="icksystem/queryDsfzkTjListQyd_icksl.action";
		//ExcelURL
		excelUrl="icksystem/queryIckZhuanQuListExcelQyd_icksl.action";
		searchLongUrl="icksystem/queryIckZhuanQuListExcelQydTemp_icksl.action";
		$("#btgyyOrHisDetail").hide();
		daggleDiv("btgyyOrHisDetail");
	});
	
	function setPageList(pageno,url){
		url=setList(pageno,url);
		setParams("t_"); //传参
		var mygrid1 = $("#"+tableid).ingrid({
				ingridPageParams:sXML,
				url: url,
				height: pageHeight-210,
				pageNumber: pageno,
				colWidths: ['20%','20%','20%','20%','20%'],
				onRowSelect: function(tr, selected){},
				sorting: false
		});
	}
	
	function startTjcx(){ //查询
		if(manVerify()){
			var result = "<table id='table1' width='100%'><thead><tr>";
			result += "<th>已发送数</th>";
			result += "<th>已反馈数</th>";
			result += "<th>已制卡数</th>";
			result += "<th>反馈失败数</th>";
			result += "<th>已发放数</th>";
			result += "</tr></thead><tbody></tbody></table>";
			$("#tabledata").html(result);
			loadPage("tabledata");
			setPageList(1);
		}
	}
	function setExportExcel(){
		if(manVerify()){
			var result = "<table id='table1' width='100%'><thead><tr>";
			result += "<th name='l_yfssl' datatype='String' sumflag='0'>已发送数</th>";
			result += "<th name='l_yfksl' datatype='String' sumflag='0'>已反馈数</th>";
			result += "<th name='l_yzksl' datatype='String' sumflag='0'>已制卡数</th>";
			result += "<th name='l_fksbsl' datatype='String' sumflag='0'>反馈失败数</th>";
			result += "<th name='l_yffsl' datatype='String' sumflag='0'>已发放数</th>";
			result += "</tr></thead><tbody></tbody></table>";
			$("#tabledata").html(result);
			geteExcelHead("tabledata");
			setSearchLong();
			loadPage("tabledata");
			setPageList(1);
		}
	}
	/*
	不分页传参数将结果集返回，用于长参数导出前的查询
	*/
	function setSearchLong(){
		setParams("t_");
		jQuery.post(searchLongUrl,params,searchLongBack,"json");
	}
	//导出前对应setSearchLong()的回调方法  由于执行查询时候有延迟，故将导出放入回调函数
	function searchLongBack(json){
		//报表标题
		var bbmc="第三方制卡统计";
		//报表请求
		setExcelLong("csxxExcel",bbmc);	
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
	function manVerify(){
		var p_qssj = $("#t_qssj").attr("value");
		var p_jzsj = $("#t_jzsj").attr("value");
		if(p_qssj!=''&&p_jzsj!=''&&formatDate(p_qssj)-formatDate(p_jzsj)>0){
			jAlert("请正确选择起始和截至日期!","提示信息");
			return false;
		}
		return true;
	}
	function formatDate(strDate){ //转换成日期格式
		var riqi = strDate.split("-");
		return new Date(riqi[0],(riqi[1]-1),riqi[2]);
	}
</script>

<body>
<input type="hidden" id="t_cjdbm" value="<%=userCount%>">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询条件</td>
  </tr>
  <tr id="gajgAll">
    <td valign="top" class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td class="pagedistd">起始时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_qssj"></td>
			<td class="pagedistd">截止时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_jzsj"></td>
			<td width="23%" class="pagetd">
				<table width="124px" border="0" align="right" cellpadding="2" cellspacing="0">
				<tr>
				<td><a href="#" class="searchbutton" id="querys2" onClick="startTjcx();">查询</a></td>
				<td><a href="#" class="exceldcbutton" onClick="setExportExcel()" id="csxxExcel">导出</a></td>
				</tr>
				</table>
			</td>
		</tr>
    	</table>
    </td>
  </tr>
</table>	
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>
	     	<th>已发送数</th>
	     	<th>已反馈数</th>
	     	<th>已制卡数</th>
	     	<th>反馈失败数</th>
	     	<th>已发放数</th>
	    </tr>
	  </thead>
	</table>
</div>
<div id="btgyyOrHisDetail" class="page-layout" src="#" style="z-index:2000; top:50px; left:110px;">
</body>