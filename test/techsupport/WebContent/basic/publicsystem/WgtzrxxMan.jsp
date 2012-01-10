<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<html>
<head>
<script type="text/javascript">
	var wgtzrxx_tables = "";
	var wgtzrxx_dataid = "";
	var wgtzrxx_rowselect = 0;
	var wgtzrxx_pageUrl="publicsystem/querylist_wgtzrxx.action";
	var wgtzrxx_divnid="WgtzrxxListData";
	var wgtzrxx_tableid="table1";
	var wgtzrxx_addUrl="publicsystem/insert_wgtzrxx.action";
	var wgtzrxx_addHtml="basic/publicsystem/WgtzrxxAdd.jsp";
	var wgtzrxx_addWidth="360";
	var wgtzrxx_delUrl="publicsystem/delete_wgtzrxx.action";
	var wgtzrxx_delid="d_wgtzrxxid";
	var wgtzrxx_modHtml="basic/publicsystem/WgtzrxxModify.jsp";
	var wgtzrxx_modUrl="publicsystem/modify_wgtzrxx.action";
	var wgtzrxx_modWidth="500";
	var wgtzrxx_detailHtml="basic/publicsystem/WgtzrxxDetail.jsp";
	var wgtzrxx_detailid="wgtzrxx_detail";
	var wgtzrxx_detailUrl="publicsystem/query_wgtzrxx.action";
	var wgtzrxx_detailWidth="400";
$(document).ready(function() {
	$("#p_wgtzrxxRequetType").attr("value",qyjbxx_requestType);
		wgtzrxx_loadPage(wgtzrxx_divnid);
		dataid="sPmtid"; //公用变量 目的取得pmtID
		if(qyjbxx_requestType!='add'){ //非添加都请求
			createXML("p_"); //主要获取场所ID和请求动作
			wgtzrxx_setPageList(1);
		}
		if(qyjbxx_requestType=='detail'){ //详细信息不给添加按钮
			document.getElementById('wgtzrxx_add').style.display='none';
		}
	daggleDiv(wgtzrxx_detailid);
}); 
	
function wgtzrxx_setPageList(pageno,url){
		url=wgtzrxx_setList(pageno,url);
		var hideCol=[7,8,9];
		var colWidth=["11%","15%","15%","15%","15%","15%","10%","0%","0%","0%","4%"];

		if(qyjbxx_requestType=='detail'){
		    hideCol=[7,8,9,10];
		    colWidth=["11%","16%","15%","16%","16%","16%","10%","0%","0%","0%","0%"];
		}
		var mygrid1 = $("#"+wgtzrxx_tableid).ingrid({ 
										ingridPageParams:sXML,
										ingridPageWidth: 998,
										ingridPageRows: 100,
										url: url,	
										height: 167,
										pageNumber: pageno,
										sorting: false,
										paging: false,
										isPlayResultNull: false,
										onRowSelect: function(tr, selected){
											var str = selected ? 'SELECTED' : 'UNSELECTED';
											if (sFlag=="true"){
												if ($(tr).attr('_selected')=="true"){
													wgtzrxx_setQuery($(tr).attr('rowindex')-1); 	
												}
											}else{
												sFlag="true";
											}					
											wgtzrxx_rowselect=$(tr).attr('rowindex')-1;
										},
										hideColIndex:hideCol,
										colWidths: colWidth
									});	
	}
	function wgtzrxx_loadPage(divpageid){
		wgtzrxx_tables=$("#"+divpageid).html();
		$("#"+wgtzrxx_detailid).hide();
		wgtzrxx_setPageList(1,'#');
	}
	function wgtzrxx_setList(pageno,url){	
		$("#"+wgtzrxx_divnid).html(wgtzrxx_tables);
		//createXML("p_");
		if (url==null || url=="undefined"){
			url=wgtzrxx_pageUrl;
		}
		return url;
	}
	function wgtzrxx_setAddPage(){
		closeAllDiv();
		wgtzrSetWidth(wgtzrxx_detailid,wgtzrxx_addWidth);
		setUrl(wgtzrxx_detailid,wgtzrxx_addHtml);
		//bindDocument(wgtzrxx_detailid);
	}
	function wgtzrxx_setAdd(){ //添加
		if (wgtzrxx_addVerify()){
			var child=new Array(wgtzrxx_divnid);
			setParams("a_",child);
			wgtzrxx_setPageList(1,wgtzrxx_addUrl);
			if($("#wgtzrxx_checkbox").attr("checked")==false){
				$("#wgtzrxx_detail").hideAndRemove("show");
			}
		}else{
			return wgtzrxx_addVerify();
		}	
	}
	function wgtzrxx_setQuery1(id){ //查看
		closeAllDiv();
		wgtzrxx_dataid=id;
		wgtzrSetWidth(wgtzrxx_detailid,wgtzrxx_detailWidth);
		setUrl(wgtzrxx_detailid,wgtzrxx_detailHtml);
		//bindDocument(wgtzrxx_detailid);
	}
	function wgtzrxx_setQuery(id){ //查看
		closeAllDiv();
		wgtzrxx_dataid=id;
		wgtzrSetWidth(wgtzrxx_detailid,wgtzrxx_detailWidth);
		setUrl(wgtzrxx_detailid,wgtzrxx_detailHtml);
		//bindDocument(wgtzrxx_detailid);
	}
	function wgtzrxx_setDetail(){
		var child=new Array(wgtzrxx_divnid);
		setParams("q_",child);
		jQuery.post(wgtzrxx_detailUrl,params,wgtzrxx_updatediv,"json");
	}
	function wgtzrxx_setDelete(){ //删除
		sFlag="false";
		jConfirm('确定删除吗？', '删除提示', function(r) {
	    	if(r==true){
				$("#d_wgtzrxxid").attr("value",''+wgtzrxx_rowselect);
				$("#d_qyid").attr("value",'0');
				var child=new Array(wgtzrxx_divnid);
				setParams("d_",child);
				wgtzrxx_setPageList(1,wgtzrxx_delUrl);
			}else{
			   return false;
			}
		});
	}	
	function abc(){
		$("#abc").css('top','50');
	}
	function wgtzrSetWidth(){
		$("#"+wgtzrxx_detailid).css("width",wgtzrxx_detailWidth+"px");
		var ylcsQyd = setNull($("#ylcsQyd").attr("value"));
		var leftOption=310;
		if(ylcsQyd!=''){ //企业端
			leftOption=ForDight((parseFloat(allPageWidth)-parseFloat(wgtzrxx_detailWidth))/2,2)-3;
		}
		$("#"+wgtzrxx_detailid).css("left",leftOption+"px");
	}
</script>

</head>
<body>
<input type="hidden" id="d_wgtzrxxid" value="">
<input type="hidden" id="p_wgtzrxxRequetType" value="">
<table width="998px" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td style="color:#004499; font-size:12px; font-weight:bold;">&nbsp;境外投资者信息</td>
    <td align="right" id="wgtzrxx_add">
    <table width="62" border="0" align="right" cellpadding="0" cellspacing="0">
		<tr>
			<td style="padding-right: 15px;"><a href="#" class="addbutton"  onclick='wgtzrxx_setAddPage();'>添加</a></td>
		</tr>
	</table>
    </td>
  </tr>
</table>
<div id="wgtzrxx_detail"  class="page-layout" src="#"
		style="top:180px; left:160px; width:500px;">
</div>	
<div id="WgtzrxxListData" style="100%">
	<table id="table1" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_tzzxm">境外投资者名称</th>
	     	<th name="l_gj">国家和地区</th>
	     	<th name="l_hzzlmc">有效证件种类</th>
	     	<th name="l_hzhm">有效证件号码</th>
	     	<th name="l_qzzlmc">签证签注种类</th>
	     	<th name="l_qzhm">签证签注号码</th>
	     	<th name="l_lxdh">联系电话</th>
	     	<th name="l_gjdm">国籍代码</th>
	     	<th name="l_qzzldm">签证种类代码</th>
	     	<th name="l_hzzldm">护照种类代码</th>
			<th name="" id="wgtzrxx_oper">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>