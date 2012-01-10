<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
    var cjdtjrq;
    var cjdrb_pageUrl="icksystem/queryCjdrblist_cjdtjrb.action";
	var cjdrb_divnid="cjdrb_tabledata";
	var cjdrb_tableid="cjdrb_table1";
	var cjdrb_detailid="cjdrb_detail";
	$(document).ready(function() {
	    cjdrb_loadPage("cjdrb_tabledata");
		// 初期化日期控件
        initTJDate();
		$("#t_qssj").attr("readonly","true").attr("value",tomorrowDate).datepicker();
		$("#t_jzsj").attr("readonly","true").attr("value",currentDate).datepicker();
		daggleDiv(cjdrb_detailid);
	});

    function cjdrb_loadPage(divpageid){
        tables=$("#"+divpageid).html();
	    $("#"+cjdrb_detailid).hide(); 	
	    cjdrb_setPageList(1,'#');
    }

    function cjdrb_setList(pageno,url){	
	    $("#"+cjdrb_divnid).html(tables);	
	    createXML("p_");
	    if (url==null || url=="undefined"){
		    url=cjdrb_pageUrl;
	}
	    return url;
    }
    
	function cjdrb_setPageList(pageno,url){
		url=cjdrb_setList(pageno,url);
		setParams("t_"); //传参
		var mygrid1 = $("#"+cjdrb_tableid).ingrid({
				ingridPageParams:sXML,
				url: url,
				height: pageHeight-200,
				pageNumber: pageno,
				colWidths: ["12%","14%","14%","12%","12%","12%","12%","12%"],
				colClasses: ['grid-col-style2','grid-col-style2','grid-col-style2','grid-col-style2','grid-col-style2','grid-col-style2','grid-col-style2'],
				colIndex: [1,2,3,4,5,6,7],
				onRowSelect: null,
				onTdSelect: function(tr){
							$(tr).find("td").click(function(){
								var tdnum = $(tr).find("td").index(this);
								if(tdnum==1){
								    xxtjDeatil(tr,"business/Ylfwzagl/TzYcjCsxxMan.jsp");
								}else if(tdnum==2){
								    xxtjDeatil(tr,"business/Ylfwzagl/TzYcjCyryxxMan.jsp");
								}else if(tdnum==3){
								    xxtjDeatil(tr,"basic/icksystem/TzIckYslMan.jsp");
								}else if(tdnum==5){
								    xxtjDeatil(tr,"basic/icksystem/TzYjswlbxxMan.jsp");
								}else if(tdnum==4){
								    tzzhcxDeatil(tr,'basic/icksystem/TzIckzhcxMan.jsp','yfficklist');
								}else if(tdnum==6){
								    tzzhcxDeatil(tr,'basic/icksystem/TzIckzhcxMan.jsp','yzxicklist');
								}else if(tdnum==7){
								    tzzhcxDeatil(tr,'basic/icksystem/TzIckzhcxMan.jsp','bhicklist');
								}
							});
				},
				sorting: false
		});
	}
	
	function xxtjDeatil(obj,url){
	    cjdtjrq = $(obj).find("td:nth(0)").text();
	    setWidth(cjdrb_detailid,"900");
	    setUrl(cjdrb_detailid,url);
	    bindDocument(detailid);
	}
	function tzzhcxDeatil(obj,url,zhcxflag){
	    cjdtjrq = $(obj).find("td:nth(0)").text();
	    dataid=zhcxflag;
	    setWidth(cjdrb_detailid,"900");
	    setUrl(cjdrb_detailid,url);
	    bindDocument(detailid);
	}
	
	function startTjcx(){ //查询
		if(manVerify()){
			cjdrb_setPageList(1);
		}
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
<input type="hidden" id="p_tjrq">

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
			<td><a href="#" class="searchbutton" id="querys2" onClick="startTjcx();">查询</a></td>
		</tr>
    	</table>
    </td>
  </tr>
</table>	
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<div id="cjdrb_detail" class="page-layout" src="#"
		style="z-index: 2000; top: 60px; left: 0px;"></div>
<div id="cjdrb_tabledata" style="width:100%;">
	<table id="cjdrb_table1" width="100%">
	  <thead>
	    <tr>
	     	<th>日期</th>
	     	<th>已采集场所信息</th>
	     	<th>已采集从业人员信息</th>
	     	<th>已受理IC卡</th>
	     	<th>已发放IC卡</th>
	     	<th>已接收物流包</th>
	     	<th>已注销IC卡</th>
	     	<th>已补换IC卡</th>
	    </tr>
	  </thead>
	</table>
</div>
</body>