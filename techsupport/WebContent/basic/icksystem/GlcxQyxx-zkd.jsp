<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var qyjbxx_requestType=""; //添加、查看、修改
	
	var qyjbxx_dataid="";
	var glcxcsxx_dataid="";
	var glcxcsxx_tables = "";
	var glcxcsxx_pageUrl="publicsystem/queryQyMessList_qyjbxx.action";
	var glcxcsxx_divnid="glcxcsxx_tabledata";
	var glcxcsxx_tableid="glcxcsxx_table1";
	var zhcx_detailWidth="800";
	
	var glcxcsxx_detailHtml="business/Ylfwzagl/YlcsjbxxDetail.jsp";
	var glcxcsxx_detailHtml1="business/Nbdwzagl/NbdwjbxxDetailGADZHCX.jsp";
	var glcxcsxx_detailHtml2="basic/publicsystem/QyjbxxDetail-gzth.jsp";
	var glcxcsxx_detailid="qyjbxx_detail";
	var qyjbxx_detailUrl="publicsystem/query_qyjbxx.action";
	var glcxcsxx_detailWidth="990";
	
	var glcxcsxx_cyryHtml="basic/icksystem/GlcxQyxxCyry-zkd.jsp";
	var glcxcsxx_cyryWidth="900";
	var qyjbxx_detailWidth=990;
	
	var csxx_timeFlag = true;
	
	$(document).ready(function(){
		glcxcsxx_loadPage("glcxcsxx_tabledata");
		//glcxcsxx_setPageList(1);
	   
		daggleDiv("qyjbxx_detail");
	}); 
	function glcxcsxx_setPageList(pageno,url){
		if (glcxcsxx_manVerify()){
			url=glcxcsxx_setList(pageno,url);
			var mygrid1 = $("#"+glcxcsxx_tableid).ingrid({ 
											ingridPageParams:sXML,
											ingridPageWidth: pageWidth,
											tableid:"zhcxTable",
											url: url,
											height: pageHeight-205,
											pageNumber: pageno,
											onRowSelect: function(tr, selected){ },
											colWidths: ["18%","38%","17%","12%","15%"]									
										});				
			}
	}	
	function glcxcsxx_loadPage(divpageid){
		glcxcsxx_tables=$("#"+divpageid).html();
		$("#"+glcxcsxx_detailid).hide(); 	
		glcxcsxx_setPageList(1,'#');
	}
	function glcxcsxx_setList(pageno,url){	
		$("#"+glcxcsxx_divnid).html(glcxcsxx_tables);	
		setParams("p_");
		if (url==null || url=="undefined"){
			url=glcxcsxx_pageUrl;
		}
		return url;
	}
	function qyjbxx_setDetail(){
		setParams("q_");
		jQuery.post(qyjbxx_detailUrl,params,qyjbxx_updatediv,"json");
	}
	function glcxcsxx_setQuery(id){
		if(csxx_timeFlag){
			csxx_timeFlag = false;
			qyjbxx_requestType="detail";
			qyjbxx_dataid=id;
			setWidth(glcxcsxx_detailid,glcxcsxx_detailWidth);
			if($('#p_hylbdm').val()=='J'){
				setUrl(glcxcsxx_detailid,glcxcsxx_detailHtml);
			}else if($('#p_hylbdm').val()=='N'){
				var qybm=$("#zhcxTable #"+id).find("td:nth(0)").text();
				setQueryZhcx(id,glcxcsxx_detailHtml1,qybm);
			}else{
				setUrl(glcxcsxx_detailid,glcxcsxx_detailHtml2);
			}
			bindDocument(glcxcsxx_detailid);
			setTimeout(function(){csxx_timeFlag = true;},800);
		}
	}
	
	function setQueryZhcx(id,url,qybm){  //内保单位详细信息添加 20110209
		$("#"+glcxcsxx_detailid).empty();
		zhcx_dataid=''+"@_@"+qybm;
		setWidth(glcxcsxx_detailid,zhcx_detailWidth);
		setUrl(glcxcsxx_detailid,url);
		bindDocument(glcxcsxx_detailid);
	}

	function cyryqk_setQuery(id){
		if(csxx_timeFlag){
			csxx_timeFlag = false;
			var csbh = $("#"+id).find("td").eq(0).text();
			var csmc = $("#"+id).find("td").eq(1).text();
			glcxcsxx_dataid = csbh+"$$$"+csmc;
			setWidth(glcxcsxx_detailid,glcxcsxx_cyryWidth);
			setUrl(glcxcsxx_detailid,glcxcsxx_cyryHtml);
			bindDocument(glcxcsxx_detailid);
			setTimeout(function(){csxx_timeFlag = true;},800);
		}
	}
	function glcxcsxx_manVerify(){
		if (!checkControlValue("p_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("p_qymc","String",1,120,null,0,"企业名称"))
			return false;
		return true;
	}
	// 行业类别	
$("#p_hylbdm").selectBoxhylb();
// 企业筛选框
//$("#p_qymc").click(function(){
//    dataid=$('#p_hylbdm').val();
// 	getTy_item("p_qymc","p_qybm");
//  });
</script>

</head>
<body>
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">企业信息查询条件</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
			<tr>
			<td width="10%" class="pagedistd">行业类别</td>
			<td width="20%" class="pagetd"><select  id="p_hylbdm" ></select></td>
			<td width="10%" class="pagedistd">企业名称</td>
			<td width="20%" class="pagetd"><input type="text" class="inputstyle"  id="p_qymc" value=""></td>
			<td width="10%" class="pagedistd">企业编码</td>
			<td class="pagetd"><input type="text" class="inputstyle"  id="p_qybm" value=""></td>
			<td>
   		  	  	<table width="62" border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
					<td><a href="#" class="searchbutton" id="querys" onClick="glcxcsxx_setPageList(1);">查询</a></td>
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
<div id="qyjbxx_detail" class="page-layout" src="#" style="z-index:2000; top:10px; left:0px;">
</div>	

<div id="glcxcsxx_tabledata" style="width:100%;">
	<table id="glcxcsxx_table1" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_qybm">企业编码</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_frdb">法人代表</th>
	     	<th name="l_zt">状态</th>
	     	<th name="">操作</th>
	    </tr>
	  </thead>
	</table>
</div>
</body>
</html>