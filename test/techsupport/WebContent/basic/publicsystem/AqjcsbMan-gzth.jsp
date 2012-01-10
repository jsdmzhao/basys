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
	var aqjcsb_addHtml="basic/publicsystem/AqjcsbAdd-gzth.jsp";
	var aqjcsb_addWidth="700";
	var aqjcsb_delUrl="publicsystem/delete_aqjcsb.action";
	var aqjcsb_delid="d_qyid";
	var aqjcsb_modHtml="basic/publicsystem/AqjcsbModify-gzth.jsp";
	var aqjcsb_modUrl="publicsystem/modify_aqjcsb.action";
	var aqjcsb_modWidth="700";
	var aqjcsb_detailHtml="basic/publicsystem/AqjcsbDetail-gzth.jsp";
	var aqjcsb_detailid="aqjcsb_detail";
	var aqjcsb_detailUrl="publicsystem/query_aqjcsb.action";
	var aqjcsb_detailWidth="700";
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
		daggleDiv(aqjcsb_detailid);
	}); 
	function aqjcsb_setPageList(pageno,url){
		url=aqjcsb_setList(pageno,url);
		tableHeight = 80;
		var hideCol=[3,5,6,7,8,9,10,11,12,13];
		var colWidth=["30%","30%","20%","0%","10%","0%","0%","0%","0%","0%","0%", "0%","0%", "0%","10%"];

		if(qyjbxx_requestType=='detail'){
			tableHeight = 60;
		    hideCol=[3,5,6,7,8,9,10,11,12,13,14];
		    colWidth=["30%","30%","30%","0%","10%","0%","0%","0%","0%","0%","0%","0%","0%", "0%","0%"];
		}

		var aqjcsb_mygrid1 = $("#"+aqjcsb_tableid).ingrid({ 
				ingridPageParams:sXML,
				ingridPageWidth: 998,
				url: url,
				height: tableHeight,
				pageNumber: pageno,
				sorting: false,
				paging: false,
				isPlayResultNull: false,
				changeHref:function(table){
					$(table).find("tr").each(function(index){
					var anjcsbid = $(this).attr("id");
					var obj = $(this).find("td").eq(9); 
						var text = obj.html();
						if(text==2){
							$(this).append("<td>&nbsp;</td>");
						}else{
							if(anjcsbid==1){
								$(this).append("<td><a href='#' class='fontbutton' onclick='aqjcsb_setModify("+anjcsbid+","+index+")'>修改</a>"+
								"&nbsp;&nbsp;<a href='#' class='fontbutton' onclick='aqjcsb_setDelete("+anjcsbid+","+index+")'>删除</a></td>");
							}else {
								$(this).append("<td><a href='#' class='fontbutton' onclick='aqjcsb_setModify("+anjcsbid+","+index+")'>修改</a>"+
								"&nbsp;&nbsp;<a href='#' class='fontbutton' onclick='aqjcsb_setStop("+anjcsbid+","+index+")'>停用</a></td>");
							}
						}       
					});
				},
				onTdSelect: function(tr){
					$(tr).find("td").click(function(){
						if($(tr).find("td").index(this)!=14){
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
	    sFlag="false";
		closeAllDiv();
		setWidthSome(aqjcsb_detailid,aqjcsb_addWidth);
		setUrl(aqjcsb_detailid,aqjcsb_addHtml);
		//bindDocument(aqjcsb_detailid);
	}
	function aqjcsb_setAdd(){ //添加
		sFlag="false";
		if (aqjcsb_addVerify()){
		    dataid = 'anjcsbid';
			var child=new Array(aqjcsb_divnid);
			setParams("z_",child);
			aqjcsb_setPageList(1,aqjcsb_addUrl);
			$("#aqjcsb_detail").hideAndRemove("show");
		}else{
			return false;
		}
	}
	function aqjcsb_setQuery(id){ //查看
	    sFlag="false";
		closeAllDiv();
		aqjcsb_dataid=id;
		setWidthSome(aqjcsb_detailid,aqjcsb_detailWidth);
		setUrl(aqjcsb_detailid,aqjcsb_detailHtml);
		//bindDocument(aqjcsb_detailid);
	}
	function aqjcsb_setQuery1(id){ //查看
		sFlag="false";
		closeAllDiv();
		aqjcsb_dataid=id;
		setWidthSome(aqjcsb_detailid,aqjcsb_detailWidth);
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
	
	var aqjcsb_modifyrowid="";
	function aqjcsb_setModify(id ,modifyrowselectid){ //修改
	    sFlag="false";
	    closeAllDiv();
	    aqjcsb_dataid=id;
	    aqjcsb_modifyrowid=modifyrowselectid;
	    setWidthSome(aqjcsb_detailid,aqjcsb_modWidth);
		setUrl(aqjcsb_detailid,aqjcsb_modHtml);
	}
	function aqjcsb_modify(){ //修改
	    sFlag="false";
		if (aqjcsb_modifyVerify()){
		     dataid = 'anjcsbid';
		    $("#x_anjcsbid").attr("value",''+ aqjcsb_modifyrowid);
			var child=new Array(aqjcsb_divnid);
			setParams("x_",child);
			aqjcsb_setPageList(1,aqjcsb_modUrl);
			$("#aqjcsb_detail").hideAndRemove("show");
		}else{
			return false;
		}	
	}
	
	var aqjcsb_stoprowid="";
	function aqjcsb_setStop(id,stoprowselectid){ //停用
		sFlag="false";
	    closeAllDiv();
	    aqjcsb_dataid=id;
	    aqjcsb_stoprowid=stoprowselectid;
	    setWidthSome(aqjcsb_detailid,aqjcsb_modWidth);
		setUrl(aqjcsb_detailid,"basic/publicsystem/JfsbxxStop.jsp");
	}
	function aqjcsb_stop(){ //停用
	       dataid = 'anjcsbid';
		if (aqjcsb_modifyVerify()){
		    $("#x_anjcsbid").attr("value",''+aqjcsb_stoprowid);
			var child=new Array(aqjcsb_divnid);
			setParams("x_",child);
			aqjcsb_setPageList(1,"publicsystem/aqjStop_aqjcsb.action");
			$("#aqjcsb_detail").hideAndRemove("show");
		}else{
			return false;
		}	
	}
</script>

</head>
<body>
<input type="hidden" id="d_anjcsbid" value="">
<input type="hidden" id="x_anjcsbid" value="">
<input type="hidden" id="p_aqjcsbRequetType" value="">
<input type="hidden" id="p_listtype" value="jfsb">
<input type="hidden" id="d_listtype" value="jfsb">
<table width="998px" cellpadding="0" cellspacing="0"  class="tableborder">
      <tr>
        <td width="918" style="color:#004499; font-size:12px; font-weight:bold;">&nbsp;技防设备</td>
        <td width="68" align="right" >
        <table width="75" border="0" align="right" cellpadding="0" cellspacing="0" id="aqjcsb_add"  >
			<tr>
				<td width="60"><a href="#" class="addbutton"  onclick='aqjcsb_setAddPage();'>添加</a></td>
				<td>&nbsp;</td>
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
	     	<th name="l_aqjcsbzlmc">技防设备种类</th>
	     	<th name="l_aqjcsbzlbm">安全检查设备种类编码</th>
	     	<th name="l_azsl">数量</th>
	     	<th name="l_bz">备注</th>
	     	<th name="l_lrr">填报人</th>
		    <th name="l_lrsj">填报时间</th>
		    <th name="l_jibr">经办人</th>
	     	<th name="l_zt">设备状态</th>
	     	<th name="l_tysj">停用时间</th>
		    <th name="l_tyyy">停用原因</th>
		    <th name="l_hylb">行业类别</th>
		    <th name="l_qymc">企业名称</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>