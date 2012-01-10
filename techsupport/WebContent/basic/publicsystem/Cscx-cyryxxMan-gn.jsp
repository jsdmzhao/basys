<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var detailidTopOffset;
	var detailidLeftOffset;
	var gzrzPageDiv = "cyryxx_detail"; //关闭工作日志的div名字

	var cscxCyrx_tables = "";
	var cscxCyrx_dataid = "";
	var cscxCyrx_pageUrl="publicsystem/querylistGadCscx_qyryxx.action";
	var cscxCyrx_divnid="cscxCyrxListData";
	var cscxCyrx_tableid="cscxCyryxx";
	var cscxCyrx_detailHtml="basic/publicsystem/CyryxxDetail.jsp";
	var cscxCyrx_detailid="cyryxx_detail";
	var cscxCyrx_detailUrl="publicsystem/query_qyryxx.action";
	var cscxCyrx_detailWidth="700";
	
	var cscxCyrx_gnRyHtml="basic/publicsystem/QyryxxDetail.jsp"; //国内人员信息
	var cscxCyrx_gnRyWidth="700";
	var cscxCyrx_gzrzHtml="business/Ylfwzagl/CyrygzrzMan.jsp"; //国内人员工作日志
	var cscxCyrx_gzrzWidth="700";
	var detailWidth = 700;
	$(document).ready(function() {
		$("#c_qyid").attr("value",qyjbxx_dataid);
		cscxCyrx_loadPage(cscxCyrx_divnid);
		cscxCyrx_setPageList(1);
		 daggleDiv("cyryxx_detail");
	});

	function cscxCyrx_setPageList(pageno,url){
		url=cscxCyrx_setList(pageno,url);
		var mygrid1 = $("#"+cscxCyrx_tableid).ingrid({ 
										url: url,
										ingridPageWidth: 800,
										height: 400,
										pageNumber: pageno,
										colClasses: ['grid-col-style2','grid-col-style2'],
										colIndex: [0,1],
										hideColIndex:[5],	
										onRowSelect: function(tr, selected){
										},
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
												if (sFlag=="true"){
													var tdnum = $(tr).find("td").index(this);
													if(tdnum!=$(tr).find("td").length-1&&(tdnum==0||tdnum==1)){
														cscx_setryxx($(tr).attr("id"));
													}
												}else{
													sFlag="true";
												}
											});	
										},
										ingridPageParams:sXML,
										colWidths: ["20%","26%","23%","13%","19%","0%"]
									});			
	}
	function cscxCyrx_loadPage(divpageid){
		cscxCyrx_tables=$("#"+divpageid).html();
		$("#"+cscxCyrx_detailid).hide();
		cscxCyrx_setPageList(1,'#');
	}
	function cscxCyrx_setList(pageno,url){
		$("#"+cscxCyrx_divnid).html(cscxCyrx_tables);
		setParams("c_");
		if (url==null || url=="undefined"){
			url=cscxCyrx_pageUrl;
		}
		return url;
	}
	var gncyry_timeFlag = true;
	function cscx_setryxx(id){ //人员信息
		if(gncyry_timeFlag){
			gncyry_timeFlag = false;
			dataid=id;
		 	detailUrl="publicsystem/query_qyryxx.action";
			cyrysetWidth(cscxCyrx_detailid,cscxCyrx_gnRyWidth);
			setUrl(cscxCyrx_detailid,cscxCyrx_gnRyHtml);
			//bindDocument(cscxCyrx_detailid);
			setTimeout(function(){gncyry_timeFlag = true;},800);
		}
	}
	function set_CscxCygj(id){ //从业轨迹
		if(gncyry_timeFlag){
			gncyry_timeFlag = false;
			detailHeight=$("#"+cscxCyrx_detailid).css("height");
			dataid=$("#"+id).find("td").eq(1).text();
			cyrysetWidth(cscxCyrx_detailid,cscxCyrx_gnRyWidth);
			setUrl(cscxCyrx_detailid,"business/Ylfwzagl/CyrycygjMan.jsp");
			var cyryxx_detailidOffset = $("#"+cscxCyrx_detailid).offset();
			detailidTopOffset=cyryxx_detailidOffset.top;
			detailidLeftOffset=cyryxx_detailidOffset.left;
			//bindDocument(cscxCyrx_detailid);
			setTimeout(function(){gncyry_timeFlag = true;},800);
		}
	}
	function set_CscxGzrz(id){ //工作日志
		if(gncyry_timeFlag){
			gncyry_timeFlag = false;
			var cyrybh = $("#"+id).find("td").eq(2).text();
			dataid=cyrybh;
			cyrysetWidth(cscxCyrx_detailid,cscxCyrx_gzrzWidth);
			setUrl(cscxCyrx_detailid,cscxCyrx_gzrzHtml);
			var cyryxx_detailidOffset = $("#"+cscxCyrx_detailid).offset();
			detailidTopOffset=cyryxx_detailidOffset.top;
			detailidLeftOffset=cyryxx_detailidOffset.left;
			//bindDocument(cscxCyrx_detailid);
			setTimeout(function(){gncyry_timeFlag = true;},800);
		}
	}
	function cyrysetWidth(divid,sWidth){
		$("#"+divid).css("width",sWidth+"px");
		$("#"+divid).css("left","50px");
	}

	//下面是页签
	var bq2FirstComeIn =0;
	var cscxJwrr = "jwgcyryxx";
	var cscxJwrrUrl = "basic/publicsystem/Cscx-wgcyryxxMan-gn.jsp";
	function show_biaoqian(obj){ //显示隐藏 ‘其他’标签
		if(obj=='biaoqian_1'){ //设置关闭工作日志的div名字
			gzrzPageDiv = "cyryxx_detail";
		}else{
			gzrzPageDiv = "wgcyryxx_detail";
		}
		$("#cyryxx_detail").hide();
		$("#cyryxx_detail").empty();
		$("#wgcyryxx_detail").hide();
		$("#wgcyryxx_detail").empty();
		document.getElementById('biaoqian_1').style.display='none';
		document.getElementById('biaoqian_2').style.display='none';
		if(bq2FirstComeIn==0&&obj=='biaoqian_2'){
			bq2FirstComeIn = 1;
			$("#"+cscxJwrr).empty();
			$("#"+cscxJwrr).load(cscxJwrrUrl);
			$("#"+cscxJwrr).show("slow"); 
		}
		document.getElementById(obj).style.display='block';
	}
	var detailUrl="publicsystem/query_qyryxx.action";
	function Qyryxx_setDetail(){
		var child=new Array(cscxCyrx_detailid);
		setParams("q_",child);
		jQuery.post(detailUrl,params,updatediv,"json");
	}
</script>

</head>
<body>
<input type="hidden" id="d_ryid" value="">
<input type="hidden" id="d_qyid" value="">
<input type="hidden" id="c_qyid" value="">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">从业人员</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#d_ryid").parent().hideAndRemove("show");' class="close"></a></td>
    </tr>
</table>
<!--国内从业人员开始-->
<table width="100%" border="0" align="center"  cellpadding="0" cellspacing="0" id=biaoqian_1 style="DISPLAY: block">
<tr>
<td valign="middle">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
		<tr>
	    <td width="100%" valign="top" align="left">
	    	<table width="100%"  border="0" align="left" cellpadding="0" cellspacing="0">
	      	<tr>
        		<td width="25" valign="bottom">
        			<table width="100%" border="0" cellspacing="0" cellpadding="0"  class="navbg">
            		<tr><td></td></tr>
            		</table>
            	</td>
       			<td width="78" valign="bottom">
       				<table width="100%" border="0"  align="right" cellpadding="0" cellspacing="0" class="nav11">
            		<tr><td><a  href="#" onMouseDown="show_biaoqian('biaoqian_1')" class="navfont" hidefocus="true">国内人员</a></td></tr>
            		</table>
            	</td>
        		<td width="78">
        			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0"  class="nav1" >
            		<tr><td align="center"><a href="#" onMouseDown="show_biaoqian('biaoqian_2')" class="navfont" hidefocus="true">境外人员</a></td></tr>
        			</table>
        		</td>
        		<td width="1048" valign="bottom">
        			<table width="100%" border="0" cellspacing="0" cellpadding="0"  class="navbg">
            		<tr><td></td></tr>
        			</table>
        		</td>
      		</tr>
    		</table>
    	</td>
  		</tr>
	</table>
	
	<table width="100%" cellspacing="0" cellpadding="0" class="line">
	<tr>
	<td valign="top" align="left">
	
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
			<td height="3"></td>
			</tr>
		</table>
		
		<div id="cscxCyrxListData" style="width:100%;">
			<table id="cscxCyryxx" width="100%">
			  <thead>
			    <tr>
			     	<th name="l_xm">姓名</th>
			     	<th name="l_zjhm">公民身份号码</th>
			     	<th name="l_cyrybh">从业人员编号</th>
			     	<th name="l_xb">性别</th>
			     	<th name="l_cylb">从业类别</th>
					<th name="">操作</th>
			    </tr>
			  </thead>
			</table>
		</div>
	
	</td>
	</tr>
	</table>
</td>
</tr>
</table>
<!--国内从业人员结束-->
<!--境外从业人员开始-->
<table width="100%" border="0" align="center"  cellpadding="0" cellspacing="0" id=biaoqian_2 style="DISPLAY: none">
<tr>
<td valign="middle">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
		<tr>
	    <td width="100%" valign="top" align="left">
	    	<table width="100%"  border="0" align="left" cellpadding="0" cellspacing="0">
	      	<tr>
        		<td width="25" valign="bottom">
        			<table width="100%" border="0" cellspacing="0" cellpadding="0"  class="navbg">
            		<tr><td></td></tr>
            		</table>
            	</td>
       			<td width="78" valign="bottom">
       				<table width="100%" border="0"  align="right" cellpadding="0" cellspacing="0" class="nav1">
            		<tr><td><a  href="#" onMouseDown="show_biaoqian('biaoqian_1')" class="navfont" hidefocus="true">国内人员</a></td></tr>
            		</table>
            	</td>
        		<td width="78">
        			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0"  class="nav11">
            		<tr><td align="center"><a href="#" onMouseDown="show_biaoqian('biaoqian_2')" class="navfont" hidefocus="true" >境外人员</a></td></tr>
        			</table>
        		</td>
        		<td width="1048" valign="bottom">
        			<table width="100%" border="0" cellspacing="0" cellpadding="0"  class="navbg">
            		<tr><td></td></tr>
        			</table>
        		</td>
      		</tr>
    		</table>
    	</td>
  		</tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0" class="line">
	<tr>
	<td valign="top" align="left">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
			<td height="3"></td>
			</tr>
		</table>
		<div style="width:100%" id=jwgcyryxx></div>
	</td>
	</tr>
	</table>
</td>
</tr>
</table>
<!--境外从业人员结束-->
<div id="cyryxx_detail"  class="page-layout" src="#"
		style="top:15px;">
</div>
</body>
</html>