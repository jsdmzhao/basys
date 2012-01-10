<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<html>
<head>
<script type="text/javascript">
	var aqjcsb_tables = "";
	var aqjcsb_dataid = "";
	var aqjcsb_rowselect = 0;
	var aqjcsb_pageUrl="publicsystem/querylist_aqjcsb.action";
	var aqjcsb_divnid="AqjcsbListData";
	var aqjcsb_tableid="table1";
	var aqjcsb_addUrl="publicsystem/insert_aqjcsb.action";
	var aqjcsb_addHtml="basic/publicsystem/AqjcsbAdd.jsp";
	var aqjcsb_addWidth="360";
	var aqjcsb_delUrl="publicsystem/delete_aqjcsb.action";
	var aqjcsb_delid="d_qyid";
	var aqjcsb_modHtml="basic/publicsystem/AqjcsbModify.jsp";
	var aqjcsb_modUrl="publicsystem/modify_aqjcsb.action";
	var aqjcsb_modWidth="360";
	var aqjcsb_detailHtml="basic/publicsystem/AqjcsbDetail.jsp";
	var aqjcsb_detailid="aqjcsb_detail";
	var aqjcsb_detailUrl="publicsystem/query_aqjcsb.action";
	var aqjcsb_detailWidth="360";
	var ylcsModQydAqjc = $("#ylcsModyQyd").attr("value"); //娱乐业企业端修改
	$(document).ready(function() {
		$("#p_aqjcsbRequetType").attr("value",qyjbxx_requestType);
		aqjcsb_loadPage(aqjcsb_divnid);
		dataid="sPmtid"; //公用变量 目的取得pmtID
		if(qyjbxx_requestType!='add'){ //非添加都请求
			createXML("p_"); //主要获取场所ID和请求动作
			aqjcsb_setPageList(1);
		}
		if(qyjbxx_requestType=='detail'){ //详细信息不给添加按钮
			document.getElementById('aqjcsb_add').style.display='none';
		}
		if(ylcsModQydAqjc=='1'){ //娱乐业企业端修改
			$("#p_aqjcsbRequetType").attr("value","modify");
			document.getElementById('aqjcsb_add').style.display='block';
		}	
		daggleDiv(aqjcsb_detailid);
	}); 
	function aqjcsb_setPageList(pageno,url){
		url=aqjcsb_setList(pageno,url);
		var hideCol=[4];
		var colWidth=["25%","25%","25%","17%","0%","8%"];

		if(qyjbxx_requestType=='detail'){
		    hideCol=[4,5];
		    var colWidth=["27%","27%","27%","19%","0%","0%"];
		}
		if(ylcsModQydAqjc=='1'){ //娱乐业企业端修改
			colWidth=["25%","25%","25%","17%","0%","8%"];
		}
		var aqjcsb_mygrid1 = $("#"+aqjcsb_tableid).ingrid({ 
										ingridPageParams:sXML,
										ingridPageWidth: 998,
										ingridPageRows: 100,
										url: url,
										height: 100,
										pageNumber: pageno,
										sorting: false,
										paging: false,
										isPlayResultNull: false,
										changeHref:function(table){
											$(table).find("tr").each(function(){
												$(this).append("<td><a href='#' class='fontbutton' onclick='aqjcsb_setModify("+$(table).find("tr").index(this)+")'>修改</a>"+
												"&nbsp;&nbsp;<a href='#' class='fontbutton' onclick='aqjcsb_setDelete("+$(table).find("tr").index(this)+")'>删除</a></td>"
												);
											});
										},
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
												if($(tr).find("td").index(this)!=5){
													aqjcsb_setQuery($(tr).attr('rowindex')-1);
												}
												});
										},
										onRowSelect: null,
										hideColIndex:hideCol,
										colWidths: colWidth
									});
	}
	function aqjcsb_loadPage(divpageid){
		aqjcsb_tables=$("#"+divpageid).html();
		$("#"+aqjcsb_detailid).hide();
		aqjcsb_setPageList(1,'#');
	}
	function aqjcsb_setList(pageno,url){	
		$("#"+aqjcsb_divnid).html(aqjcsb_tables);
		//createXML("p_");
		if (url==null || url=="undefined"){
			url=aqjcsb_pageUrl;
		}
		return url;
	}
	function aqjcsb_setAddPage(){
		closeAllDiv();
		aqjcsbSetWidth(aqjcsb_detailid,aqjcsb_addWidth);
		setUrl(aqjcsb_detailid,aqjcsb_addHtml);
		//bindDocument(aqjcsb_detailid);
	}
	function aqjcsb_setAdd(){ //添加
		if (aqjcsb_addVerify()){
			var child=new Array(aqjcsb_divnid);
			setParams("z_",child);
			aqjcsb_setPageList(1,aqjcsb_addUrl);
			if($("#aqjcsb_checkbox").attr("checked")==false){
				$("#aqjcsb_detail").hideAndRemove("show");
			}
		}else{
			return false;
		}
	}
	function aqjcsb_setQuery(id){ //查看
		closeAllDiv();
		aqjcsb_dataid=id;
		aqjcsbSetWidth(aqjcsb_detailid,aqjcsb_detailWidth);
		setUrl(aqjcsb_detailid,aqjcsb_detailHtml);
		//bindDocument(aqjcsb_detailid);
	}
	function aqjcsb_setQuery1(id){ //查看
		closeAllDiv();
		aqjcsb_dataid=id;
		aqjcsbSetWidth(aqjcsb_detailid,aqjcsb_detailWidth);
		setUrl(aqjcsb_detailid,aqjcsb_detailHtml);
		//bindDocument(aqjcsb_detailid);
	}
	function aqjcsb_setDetail(){
		var child=new Array(aqjcsb_divnid);
		setParams("q_",child);
		jQuery.post(aqjcsb_detailUrl,params,aqjcsb_updatediv,"json");
	}
	function aqjcsb_setDelete(id){ //删除
		sFlag="false";
		jConfirm('确定删除吗？', '删除提示', function(r) {
	    	if(r==true){
	    	    aqjcsb_rowselect=id;
				$("#d_anjcsbid").attr("value",''+aqjcsb_rowselect);
				var child=new Array(aqjcsb_divnid);
				setParams("d_",child);
				aqjcsb_setPageList(1,aqjcsb_delUrl);
			}else{
			   return false;
			}
		});
	}
	function aqjcsb_setModify(id){ //修改
	    closeAllDiv();
	    aqjcsb_rowselect=id;
	    aqjcsb_dataid=aqjcsb_rowselect;
	    aqjcsbSetWidth(aqjcsb_detailid,aqjcsb_modWidth);
		setUrl(aqjcsb_detailid,aqjcsb_modHtml);
	}
	function aqjcsb_modify(){ //修改
		if (aqjcsb_modifyVerify()){
		    $("#x_anjcsbid").attr("value",''+aqjcsb_rowselect);
			var child=new Array(aqjcsb_divnid);
			setParams("x_",child);
			aqjcsb_setPageList(1,aqjcsb_modUrl);
			$("#aqjcsb_detail").hideAndRemove("show");
		}else{
			return false;
		}	
	}
	function aqjcsbSetWidth(){
		$("#"+aqjcsb_detailid).css("width",aqjcsb_modWidth+"px");
		var ylcsQyd = setNull($("#ylcsQyd").attr("value"));
		var leftOption=310;
		if(ylcsQyd!=''){ //企业端
			leftOption=ForDight((parseFloat(allPageWidth)-parseFloat(aqjcsb_modWidth))/2,2)-3;
		}
		$("#"+aqjcsb_detailid).css("left",leftOption+"px");
		
	}
</script>

</head>
<body>
<input type="hidden" id="d_anjcsbid" value="">
<input type="hidden" id="x_anjcsbid" value="">
<input type="hidden" id="p_aqjcsbRequetType" value="">
<table width="998px" cellpadding="0" cellspacing="0"  class="tableborder">
      <tr>
        <td width="918" style="color:#004499; font-size:12px; font-weight:bold;">&nbsp;安全检查设备信息</td>
        <td width="68" align="right" >
        <table width="62" border="0" align="right" cellpadding="0" cellspacing="0" id="aqjcsb_add"  >
			<tr>
				<td style="padding-right: 15px;"><a href="#" class="addbutton"  onclick='aqjcsb_setAddPage();'>添加</a></td>
			</tr>
		</table>
        </td>
  </tr>
</table>

<div id="aqjcsb_detail"  class="page-layout" src="#"
		style="top:180px; left:160px; width:500px;">
</div>	

<div id="AqjcsbListData" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_sbmc">设备名称</th>
	     	<th name="l_ggxh">规格型号</th>
	     	<th name="l_aqjcsbzlmc">安全检查设备种类</th>
	     	<th name="l_azsl">安装数量</th>
	     	<th name="l_aqjcsbzlbm">安全检查设备种类编码</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>