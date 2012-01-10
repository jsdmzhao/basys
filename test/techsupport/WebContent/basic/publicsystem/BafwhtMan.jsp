<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<html>
<head>
<script type="text/javascript">
    var bafwht_tables = "";
	var bafwht_dataid = "";
	var bafwht_rowselect = 0;
	var bafwht_pageUrl="publicsystem/querylist_bafwht.action";
	var bafwht_divnid="BafwhtListData";
	var bafwht_tableid="lBafwht";
	var bafwht_addUrl="publicsystem/insert_bafwht.action";
	var bafwht_addHtml="basic/publicsystem/BafwhtAdd.jsp";
	var bafwht_addWidth="360";
	var bafwht_delUrl="publicsystem/delete_bafwht.action";
	var bafwht_delid="d_bafwhtid";
	var bafwht_modHtml="basic/publicsystem/BafwhtModify.jsp";
	var bafwht_modUrl="publicsystem/modify_bafwht.action";
	var bafwht_modWidth="600";
	var bafwht_detailHtml="basic/publicsystem/BafwhtDetail.jsp";
	var bafwht_detailid="bafwht_detail";
	var bafwht_detailUrl="publicsystem/query_bafwht.action";
	var bafwht_detailWidth="450";
	
$(document).ready(function() {
    $("#p_bafwhtRequetType").attr("value",qyjbxx_requestType);
		bafwht_loadPage(bafwht_divnid);
		dataid="sPmtid"; //公用变量 目的取得pmtID
		if(qyjbxx_requestType!='add'){ //非添加都请求
			createXML("p_"); //主要获取场所ID和请求动作
			bafwht_setPageList(1);
		}
		if(qyjbxx_requestType=='detail'){ //详细信息不给添加按钮 ‘操作’隐藏
			document.getElementById('bafwht_add').style.display='none';
		}
	daggleDiv(bafwht_detailid);
}); 
	
function bafwht_setPageList(pageno,url){
		url=bafwht_setList(pageno,url);
		var hideCol=[7,8,9,10];
		var colWidth=["17%","15%","10%","10%","10%","12%","18%","0%","0%","0%","0%","8%"];

		if(qyjbxx_requestType=='detail'){
		    hideCol=[7,8,9,10,11];
		    colWidth=["19%","15%","11%","11%","11%","13%","19%","0%","0%","0%","0%","0%"];
		}
		var bafwht_mygrid1 = $("#"+bafwht_tableid).ingrid({
										ingridPageParams:sXML,
										ingridPageWidth: 998,
										ingridPageRows: 100,
										url: url,	
										height: 100,
										pageNumber: pageno,
										sorting: false,
										paging: false,
										isPlayResultNull: false,
										//bafwht_setQuery($(tr).attr('rowindex')-1);
										changeHref:function(table){
											$(table).find("tr").each(function(){
												$(this).append("<td><a href='#' class='fontbutton' onclick='bafwht_setModify("+$(table).find("tr").index(this)+")'>修改</a>"+
												"&nbsp;&nbsp;<a href='#' class='fontbutton' onclick='bafwht_setDelete("+$(table).find("tr").index(this)+")'>删除</a></td>"
												);
											});
										},
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
												if($(tr).find("td").index(this)!=11){
													bafwht_setQuery($(tr).attr('rowindex')-1);
												}
											});
										},
										onRowSelect: null,
										hideColIndex:hideCol,
										colWidths: colWidth
									});				
	}
	
	function bafwht_loadPage(divpageid){
		bafwht_tables=$("#"+divpageid).html();
		$("#"+bafwht_detailid).hide();
		bafwht_setPageList(1,'#');
	}
	function bafwht_setList(pageno,url){
		$("#"+bafwht_divnid).html(bafwht_tables);
		if (url==null || url=="undefined"){
			url=bafwht_pageUrl;
		}
		return url;
	}
	function bafwht_setAddPage(){
		closeAllDiv();
		bafwhtSetWidth(bafwht_detailid,bafwht_addWidth);
		setUrl(bafwht_detailid,bafwht_addHtml);
		//bindDocument(bafwht_detailid);
	}
	function bafwht_setAdd(){ //添加
		if (bafwht_addVerify()){
			var child=new Array(bafwht_divnid);
			setParams("a_",child);
			bafwht_setPageList(1,bafwht_addUrl);
			if($("#bafwht_checkbox").attr("checked")==false){
				$("#bafwht_detail").hide("show");
			}
		}else{
			return bafwht_addVerify();
		}	
	}
	function bafwht_setQuery(id){ //查看
		closeAllDiv();
		bafwht_dataid=id;
		bafwhtSetWidth(bafwht_detailid,bafwht_detailWidth);
		setUrl(bafwht_detailid,bafwht_detailHtml);
		//bindDocument(bafwht_detailid);
	}
	function bafwht_setQuery1(id){ //查看
		closeAllDiv();
		bafwht_dataid=id;
		bafwhtSetWidth(bafwht_detailid,bafwht_detailWidth);
		setUrl(bafwht_detailid,bafwht_detailHtml);
		//bindDocument(bafwht_detailid);
	}
	function bafwht_setDetail(){
		var child=new Array(bafwht_divnid);
		setParams("q_",child);
		jQuery.post(bafwht_detailUrl,params,bafwht_updatediv,"json");
	}
	function bafwht_setDelete(id){ //删除
		sFlag="false";
		jConfirm('确定删除吗？', '删除提示', function(r) {
	    	if(r==true){
	    		bafwht_rowselect = id;
				$("#d_bafwhtid").attr("value",''+bafwht_rowselect);
				$("#d_qyid").attr("value",'0');
				var child=new Array(bafwht_divnid);
				setParams("d_",child);
				bafwht_setPageList(1,bafwht_delUrl);
			}else{
			   return false;
			}
		});
	}
	
	function bafwht_setModify(id){ //修改
		closeAllDiv();
	    bafwht_rowselect=id;
	    bafwht_dataid=bafwht_rowselect;
		bafwhtSetWidth(bafwht_detailid,bafwht_addWidth);
		setUrl(bafwht_detailid,bafwht_modHtml);
	}
	function bafwht_modify(){ //修改
		if (bafwht_modifyVerify()){
		    $("#xx_bafwhtid").attr("value",''+bafwht_rowselect);
			var child=new Array(bafwht_divnid);
			setParams("xx_",child);
			bafwht_setPageList(1,bafwht_modUrl);
			$("#bafwht_detail").hideAndRemove("show");
		}else{
			return false;
		}	
	}
	function bafwhtSetWidth(){
		$("#"+bafwht_detailid).css("width",bafwht_detailWidth+"px");
		var ylcsQyd = setNull($("#ylcsQyd").attr("value"));
		var leftOption=280;
		if(ylcsQyd!=''){ //企业端
			leftOption=ForDight((parseFloat(allPageWidth)-parseFloat(bafwht_detailWidth))/2,2)-3;
		}
		$("#"+bafwht_detailid).css("left",leftOption+"px");
	}
</script>
</head>
<body>
	
<input type="hidden" id="d_bafwhtid" value="">
<input type="hidden" id="p_bafwhtRequetType" value="">
<table width="998px" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td style="color:#004499; font-size:12px; font-weight:bold;">&nbsp;保安服务信息</td>
    <td align="right" id="bafwht_add">
    <table width="62" border="0" align="right" cellpadding="0" cellspacing="0">
		<tr>
			<td style="padding-right: 15px;"><a href="#" class="addbutton"  onclick='bafwht_setAddPage();'>添加</a></td>
		</tr>
	</table>
    </td>
  </tr>
</table>
<div id="bafwht_detail"  class="page-layout" src="#" style="top:150px; left:100px; width:500px;">
</div>

<div id="BafwhtListData" style="width:100%;">
	<table id="lBafwht" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_bafwgsmc">保安服务公司名称</th>
	     	<th name="l_htbh">合同编号</th>
	     	<th name="l_qdrq">签订日期</th>
	     	<th name="l_jsrq">结束日期</th>
	     	<th name="l_htyxq">合同有效期(年)</th>
	     	<th name="l_balxmc">保安类型</th>
			<th name="l_fzjgmc">发证机构</th>
			<th name="l_balxdm">保安类型代码</th>
			<th name="l_barypxjsrq">保安人员培训结束日期</th>
			<th name="l_baryzgzsmc">保安员资格证书编号</th>
			<th name="l_barypxnr">保安人员培训内容</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>