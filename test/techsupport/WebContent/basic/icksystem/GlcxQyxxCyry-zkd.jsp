<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var qyjbxx_requestType=""; //添加、查看、修改
	var qyjbxx_dataid="";
	var glcxcyry_dataid = "";
	var glcxcyry_tables = "";
	var glcxcyry_pageUrl="publicsystem/queryCyryZkdList_qyryxx.action";
	var glcxcyry_divnid="glcxcyry_tabledata";
	var glcxcyry_tableid="glcxcyry_table1";
	
	var glcxcyry_detailHtml="basic/publicsystem/QyjbxxDetail.jsp";
	var glcxcyry_detailid="glcxcyry_detail";
	var ylcsjbxx_detailUrl="publicsystem/query_qyjbxx.action";
	var glcxcyry_detailWidth="990";
	
	var glcxcyry_ickHtml="basic/icksystem/GlcxCyryIck-zkd.jsp";
	var glcxcyry_ickWidth="650";
	
	var qycxCyrx_gnRyHtml="business/Ylfwzagl/CyryxxDetail-cjd.jsp"; //国内人员信息
	var qycxCyrx_gnRyWidth="800";
	var qycxCyrx_wgRyHtml="business/Ylfwzagl/CyryxxDetail-wg-cjd.jsp"; //境外人员信息
	var qycxCyrx_wgRyWidth="800";
	var detailUrl = "";
	detailWidth="800";
	var csxxcyry_timeFlag = true;
	
	$(document).ready(function(){
		
		$("#c_qybm").attr("value",glcxcsxx_dataid.split("$$$")[0]);
		$("#show_qymc").append(glcxcsxx_dataid.split("$$$")[1]);
		glcxcyry_loadPage("glcxcyry_tabledata");
		$("#bq_xb").selectBox({code:"dm_xb"});
		glcxcyry_setPageList(1);
		
		daggleDiv("glcxcyry_detail");
	}); 
	function glcxcyry_setPageList(pageno,url){
		if (glcxcyry_manVerify()){
			url=glcxcyry_setList(pageno,url);
			var mygrid1 = $("#"+glcxcyry_tableid).ingrid({ 
											ingridPageParams:sXML,
											ingridPageWidth: 900,
											barTopPosition:$("#qyjbxx_detail").position().top+90,
											url: url,
											pageNumber: pageno,
											height: 300,
											onRowSelect: function(tr, selected){ },
											colWidths: ["17%","22%","14%","6%","14%","12%","13%"]									
										});				
			}
	}	
	function glcxcyry_loadPage(divpageid){
		glcxcyry_tables=$("#"+divpageid).html();
		$("#"+glcxcyry_detailid).hide(); 	
		glcxcyry_setPageList(1,'#');
	}
	function glcxcyry_setList(pageno,url){	
		$("#"+glcxcyry_divnid).html(glcxcyry_tables);	
		setParams("c_");
		if (url==null || url=="undefined"){
			url=glcxcyry_pageUrl;
		}
		return url;
	}
	function glcxcyry_manVerify(){
		if (!checkControlValue("c_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("c_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("bq_xb","Select",1,20,null,0,"性别"))
			return false;
		return true;
	}
	function getObject(obj){ //操作
		sFlag="false";
		if(csxxcyry_timeFlag){
			csxxcyry_timeFlag = false;
			var content = $(obj).text();
			var thisId = $(obj).attr("id");
			if(content=='IC卡'){
				cyryIck_setQuery(thisId);
			}
			if(content=='查看'){
				cyrymess_setQuery(thisId);
			}
			setTimeout(function(){csxxcyry_timeFlag = true;},800);
		}
	}
	function cyrymess_setQuery(id){
		var gnOrgw = id.split("_")[0];
		dataid = id.split("_")[1];
		detailUrl="publicsystem/query_publicwgcyryxx.action";
		if(gnOrgw=='gn'){ //国内
			if($("#p_hylbdm").val()=="J"){
				detailUrl="publicsystem/query_qyryxx.action";
				setWidthGlcx(glcxcyry_detailid,qycxCyrx_gnRyWidth);
				setUrl(glcxcyry_detailid,qycxCyrx_gnRyHtml);
			}else{
				setWidthGlcx(glcxcyry_detailid,qycxCyrx_gnRyWidth);
				setUrl(glcxcyry_detailid,"basic/publicsystem/QyryxxDetail-gzth.jsp");
			}
			bindDocument(glcxcyry_detailid);
		}
		if(gnOrgw=='gw'){ //国外
			detailUrl="publicsystem/query_publicwgcyryxx.action";
			setWidthGlcx(glcxcyry_detailid,qycxCyrx_wgRyWidth);
			setUrl(glcxcyry_detailid,qycxCyrx_wgRyHtml);
			bindDocument(glcxcyry_detailid);
		}
	}
	function cyryIck_setQuery(id){
		var rowid = id.split("_")[1];
		var cyrybh = $("#"+rowid).find("td").eq(1).text();
		var xm = $("#"+rowid).find("td").eq(0).text();
		glcxcyry_dataid = cyrybh+"$$$"+xm;
		setWidthGlcx(glcxcyry_detailid,glcxcyry_ickWidth);
		
		setUrl(glcxcyry_detailid,glcxcyry_ickHtml);
		bindDocument(glcxcyry_detailid);
	}
	function xbOnchange(){ //性别
		var xb = $("#bq_xb").attr("value");
		$("#c_xbdm").attr("value",xb);
	}
	function qyxxCyryColse(){
		$("#qyjbxx_detail").hideAndRemove("show");
		$("#qyjbxx_detail").empty();
	}
	function setWidthGlcx(divid,sWidth){
	    $("#"+divid).css("width",sWidth+"px");
	    //sLeft=ForDight((parseFloat(allPageWidth)-parseFloat(sWidth))/2,2)-3;
	    $("#"+divid).css("left","50px");
	}
</script>

</head>
<body>
<input type="hidden" id="c_zkdQyxxCyry" value="1"/>
<input type="hidden" id="c_qybm" value="">
<input type="hidden" id="c_xbdm" value="">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1"><span id="show_qymc"></span></td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onClick="qyxxCyryColse();" class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="4"></td></tr>
</table>
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">从业人员查询条件</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
			<tr>
			<td width="8%" class="pagedistd">姓名</td>
			<td width="15%" class="pagetd"><input type="text" class="inputstyle" id="c_xm" value=""></td>
			<td width="10%" class="pagedistd">证件号码</td>
			<td width="15%" class="pagetd"><input type="text" class="inputstyle" id="c_zjhm" value=""></td>
			<td width="10%" class="pagedistd">性别</td>
			<td width="15%" class="pagetd"><select name="select2" id="bq_xb" onChange="xbOnchange();">
		        <option value=""></option></select></td>
			<td colspan="2">
   		  	  	<table width="62" border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
					<td><a href="#" class="searchbutton" id="querys" onClick="glcxcyry_setPageList(1);">查询</a></td>
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
<div id="glcxcyry_detail"  class="page-layout" src="#" style="top:0px;">
</div>

<div id="glcxcyry_tabledata" style="width:100%;">
	<table id="glcxcyry_table1" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_cyrybh">从业人员编号</th>
	     	<th name="l_gj">国籍</th>
			<th name="l_xb">性别</th>
			<th name="l_cylb">从业类别</th>
	     	<th name="l_cyryzt">状态</th>
	     	<th name="">操作</th>
	    </tr>
	  </thead>
	</table>
</div>
</body>
</html>