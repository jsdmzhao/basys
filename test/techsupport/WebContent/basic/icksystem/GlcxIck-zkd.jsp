<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var qyjbxx_requestType=""; //添加、查看、修改
	var qyjbxx_detailidTopOffset=0;
	var qyjbxx_detailidLeftOffset=0;
	var qyjbxx_dataid="";
	var glcxick_tables = "";
	var glcxick_pageUrl="icksystem/queryIckZkdList_icksl.action";
	var glcxick_divnid="glcxick_tabledata";
	var glcxick_tableid="glcxick_table1";
	var glcxick_detailid="glcxick_detail";
	
	var qycxCyrx_gnRyHtml="business/Ylfwzagl/CyryxxDetail-cjd.jsp"; //国内人员信息
	var qycxCyrx_gnRyWidth="800";
	var qycxCyrx_wgRyHtml="business/Ylfwzagl/CyryxxDetail-wg-cjd.jsp"; //境外人员信息
	var qycxCyrx_wgRyWidth="800";
	var detailUrl = "";
	var detailWidth = "800";
	
	$(document).ready(function(){
		glcxick_loadPage("glcxick_tabledata");
		//glcxick_setPageList(1);
	   
		daggleDiv("glcxick_detail");
	}); 
	function glcxick_setPageList(pageno,url){
		if (glcxick_manVerify()){
			url=glcxick_setList(pageno,url);
			var mygrid1 = $("#"+glcxick_tableid).ingrid({ 
											ingridPageParams:sXML,
											ingridPageWidth: pageWidth,
											url: url,
											height: pageHeight-205,
											pageNumber: pageno,
											onRowSelect: function(tr, selected){ },
											colWidths: ["14%","10%","14%","12%","10%","10%","14%","12%"]									
										});				
			}
	}
	function glcxick_loadPage(divpageid){
		glcxick_tables=$("#"+divpageid).html();
		$("#"+glcxick_detailid).hide(); 	
		glcxick_setPageList(1,'#');
	}
	function glcxick_setList(pageno,url){	
		$("#"+glcxick_divnid).html(glcxick_tables);	
		setParams("p_");
		if (url==null || url=="undefined"){
			url=glcxick_pageUrl;
		}
		return url;
	}
	function getObject(obj){ //操作
		sFlag="false";
		var content = $(obj).text();
		var thisId = $(obj).attr("id");
		if(content=='相关从业人员'){
			cyrymess_setQuery(thisId);
		}
	}
	function cyrymess_setQuery(id){
		var gnOrgw = id.split("_")[0];
		dataid = id.split("_")[1];
		detailUrl="publicsystem/query_publicwgcyryxx.action";
		if(gnOrgw=='gn'){ //国内
			if($("#p_hylbdm").val()=="J"){
				detailUrl="publicsystem/query_qyryxx.action";
				setWidth(glcxick_detailid,qycxCyrx_gnRyWidth);
				setUrl(glcxick_detailid,qycxCyrx_gnRyHtml);
			}else{
				setWidth(glcxick_detailid,qycxCyrx_gnRyWidth);
				setUrl(glcxick_detailid,"basic/publicsystem/QyryxxDetail-gzth.jsp");
			}
			bindDocument(glcxick_detailid);
		}
		if(gnOrgw=='gw'){ //国外
			detailUrl="publicsystem/query_publicwgcyryxx.action";
			setWidth(glcxick_detailid,qycxCyrx_wgRyWidth);
			setUrl(glcxick_detailid,qycxCyrx_wgRyHtml);
			bindDocument(glcxick_detailid);
		}
	}
	function glcxick_manVerify(){
		if (!checkControlValue("p_kh","String",1,20,null,0,"企业编号"))
			return false;
		if (!checkControlValue("p_cyrybh","String",1,30,null,0,"从业人员编号"))
			return false;
		if (!checkControlValue("p_xm","String",1,30,null,0,"姓名"))
			return false;
		return true;
	}
	// 行业类别	
$("#p_hylbdm").selectBoxhylb();
</script>

</head>
<body>
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">IC卡信息查询条件</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
			<tr>
			<td width="10%" class="pagedistd">IC卡受理号</td>
			<td width="15%" class="pagetd"><input type="text" class="inputstyle"  id="p_kh" value=""></td>
			<td width="10%" class="pagedistd">行业类别</td>
			<td width="15%" class="pagetd"><select  id="p_hylbdm" ></select></td>
			<td width="10%" class="pagedistd">从业人员编号</td>
			<td width="15%" class="pagetd"><input type="text" class="inputstyle"  id="p_cyrybh" value=""></td>
			<td width="10%" class="pagedistd">姓名</td>
			<td width="15%" class="pagetd"><input type="text" class="inputstyle"  id="p_xm" value=""></td>
			<td colspan="6">
   		  	  	<table width="62" border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
					<td><a href="#" class="searchbutton" id="querys" onClick="glcxick_setPageList(1);">查询</a></td>
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
<div id="glcxick_detail" class="page-layout" src="#" style="z-index:2000; top:10px; left:0px;"></div>

<div id="glcxick_tabledata" style="width:100%;">
	<table id="glcxick_table1" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_xm">姓名</th>
			<th name="l_kh">IC卡受理号</th>
			<th name="l_cyrybh">从业人员编号</th>
	     	<th name="l_gj">国籍</th>
			<th name="l_xb">性别</th>
			<th name="l_yxqhzrq">有效截至日期</th>
	     	<th name="l_zkztbs">制卡状态</th>
	     	<th name="">操作</th>
	    </tr>
	  </thead>
	</table>
</div>
</body>
</html>