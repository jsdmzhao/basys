<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<html>
<head>
<script type="text/javascript">
    var bldsjksb_tables = "";
	var bldsjksb_dataid = "";
	var bldsjksb_rowselect = 0;
	var bldsjksb_pageUrl="publicsystem/querylist_bldsjksb.action";
	var bldsjksb_divnid="BldsjksbListData";
	var bldsjksb_tableid="table1";
	var bldsjksb_addUrl="publicsystem/insert_bldsjksb.action";
	var bldsjksb_addHtml="basic/publicsystem/BldsjksbAdd.jsp";
	var bldsjksb_addWidth="600";
	var bldsjksb_delUrl="publicsystem/delete_bldsjksb.action";
	var bldsjksb_delid="d_qyid";
	var bldsjksb_modHtml="basic/publicsystem/BldsjksbModify.jsp";
	var bldsjksb_modUrl="publicsystem/modify_bldsjksb.action";
	var bldsjksb_modWidth="600";
	var bldsjksb_detailHtml="basic/publicsystem/BldsjksbDetail.jsp";
	var bldsjksb_detailid="bldsjksb_detail";
	var bldsjksb_detailUrl="publicsystem/query_bldsjksb.action";
	var bldsjksb_detailWidth="650";
	var bldsjksb_ingrid_height = 100;
	
	var ylcsModQydBlds = $("#ylcsModyQyd").attr("value"); //娱乐业企业端修改
	$(document).ready(function() {
		$("#p_bldsjkRequetType").attr("value",qyjbxx_requestType);
		bldsjksb_loadPage(bldsjksb_divnid);
		dataid="sPmtid"; //公用变量 目的取得pmtID
		if(qyjbxx_requestType!='add'){ //非添加都请求
			createXML("p_"); //主要获取场所ID和请求动作
			bldsjksb_setPageList(1);
		}
		if(qyjbxx_requestType=='detail'){ //详细信息不给添加按钮
			document.getElementById('bldsjksb_add').style.display='none';
			bldsjksb_ingrid_height = 110;
		}
		if(ylcsModQydBlds=='1'){ //娱乐业企业端修改
			$("#p_bldsjkRequetType").attr("value","modify");
			document.getElementById('bldsjksb_add').style.display='block';
		}
		daggleDiv(bldsjksb_detailid);
	}); 
	function bldsjksb_setPageList(pageno,url){
		url=bldsjksb_setList(pageno,url);
		var hideCol=[];
		var colWidth=["10%","13%","10%","12%","10%","10%","9%","8%","10%","8%"];

		if(qyjbxx_requestType=='detail'){
		    hideCol=[9];
		    colWidth=["12%","14%","11%","12%","11%","11%","10%","8%","11%","0%"];
		}
		if(ylcsModQydBlds=='1'){ //娱乐业企业端修改
			colWidth=["10%","13%","10%","12%","10%","10%","9%","8%","10%","8%"];
		}
		var mygrid1 = $("#"+bldsjksb_tableid).ingrid({ 
		                                tableid:"bldsjksbTable",
										ingridPageParams:sXML,
										ingridPageWidth: 998,
										ingridPageRows: 100,
										url: url,	
										height: bldsjksb_ingrid_height,
										pageNumber: pageno,
										sorting: false,
										paging: false,
										changeHref:function(table){
											$(table).find("tr").each(function(){
												$(this).append("<td><a href='#' class='fontbutton' onclick='bldsjksb_setModify("+$(table).find("tr").index(this)+")'>修改</a>"+
												"&nbsp;&nbsp;<a href='#' class='fontbutton' onclick='bldsjksb_setDelete("+$(table).find("tr").index(this)+")'>删除</a></td>"
												);
											});
										},
										isPlayResultNull: false,
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
												if($(tr).find("td").index(this)!=9){
													bldsjksb_setQuery($(tr).attr('rowindex')-1);
												}
												});
										},
										onRowSelect: null,
										hideColIndex:hideCol,
										colWidths: colWidth
									});				
	}
	function bldsjksb_loadPage(divpageid){
		bldsjksb_tables=$("#"+divpageid).html();
		$("#"+bldsjksb_detailid).hide();
		bldsjksb_setPageList(1,'#');
	}
	function bldsjksb_setList(pageno,url){	
		$("#"+bldsjksb_divnid).html(bldsjksb_tables);
		//createXML("p_");
		if (url==null || url=="undefined"){
			url=bldsjksb_pageUrl;
		}
		return url;
	}
	function bldsjksb_setAddPage(){
		closeAllDiv();
		bldsSetWidth(bldsjksb_detailid,bldsjksb_addWidth);
		setUrl(bldsjksb_detailid,bldsjksb_addHtml);
		//bindDocument(bldsjksb_detailid);
	}
	function bldsjksb_setAdd(){ //添加
		if (bldsjksb_addVerify()){
			var child=new Array(bldsjksb_divnid);
			setParams("a_",child);
			bldsjksb_setPageList(1,bldsjksb_addUrl);
			if($("#bldsjksb_checkbox").attr("checked")==false){
				$("#bldsjksb_detail").hideAndRemove("show");
			}
		}else{
			return false;
		}	
	}
	function bldsjksb_setQuery(id){ //查看
		closeAllDiv();
		bldsjksb_dataid=id;
		bldsSetWidth(bldsjksb_detailid,bldsjksb_detailWidth);
		setUrl(bldsjksb_detailid,bldsjksb_detailHtml);
		//bindDocument(bldsjksb_detailid);
	}
	function bldsjksb_setDetail(){
		var child=new Array(bldsjksb_divnid);
		setParams("q_",child);
		jQuery.post(bldsjksb_detailUrl,params,bldsjksb_updatediv,"json");
	}
	function bldsjksb_setDetail1(){
		var child=new Array(bldsjksb_divnid);
		setParams("q_",child);
		jQuery.post(bldsjksb_detailUrl,params,bldsjksb_updatediv,"json");
	}
	function bldsjksb_setDelete(id){ //删除
		sFlag="false";
		jConfirm('确定删除吗？', '删除提示', function(r) {
	    	if(r==true){
	    	    bldsjksb_rowselect=id;
				$("#d_bldsjksbid").attr("value",''+bldsjksb_rowselect);
				var child=new Array(bldsjksb_divnid);
				setParams("d_",child);
				bldsjksb_setPageList(1,bldsjksb_delUrl);
			}else{
			   return false;
			}
		});
	}
	function bldsjksb_setModify(id){ //修改
	    closeAllDiv();
	    bldsjksb_rowselect=id;
	    bldsjksb_dataid=bldsjksb_rowselect;
	    bldsSetWidth(bldsjksb_detailid,bldsjksb_modWidth);
		setUrl(bldsjksb_detailid,bldsjksb_modHtml);
	}
	function bldsjksb_modify(){ //修改
		if (bldsjksb_modifyVerify()){
		    $("#m_bldsjksbid").attr("value",''+bldsjksb_rowselect);
			var child=new Array(bldsjksb_divnid);
			setParams("m_",child);
			bldsjksb_setPageList(1,bldsjksb_modUrl);
			$("#bldsjksb_detail").hideAndRemove("show");
		}else{
			return false;
		}	
	}
	function bldsSetWidth(){
		$("#"+bldsjksb_detailid).css("width",bldsjksb_modWidth+"px");
		var ylcsQyd = setNull($("#ylcsQyd").attr("value"));
		var leftOption=220;
		if(ylcsQyd!=''){ //企业端
			leftOption=ForDight((parseFloat(allPageWidth)-parseFloat(bldsjksb_modWidth))/2,2)-3;
		}
		$("#"+bldsjksb_detailid).css("left",leftOption+"px");
	}
</script>

</head>
<body>
<input type="hidden" id="d_bldsjksbid" value="">
<input type="hidden" id="m_bldsjksbid" value="">
<input type="hidden" id="p_bldsjkRequetType" value="">
<table width="998px" cellpadding="0" cellspacing="0"  class="tableborder">
        <tr>
          <td style="color:#004499; font-size:12px; font-weight:bold;">视频监控设备信息</td>
          <td align="right" id="bldsjksb_add">
          <table width="62" border="0" align="right" cellpadding="0" cellspacing="0">
			<tr>
				<td style="padding-right: 15px;"><a href="#" class="addbutton"  onclick='bldsjksb_setAddPage();'>添加</a></td>
			</tr>
		  </table>
          </td>
        </tr>
</table>
<div id="bldsjksb_detail"  class="page-layout" src="#"
		style="top:180px; left:160px; width:500px;">
</div>

<div id="BldsjksbListData" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_sbmc">设备名称</th>
	     	<th name="l_sccsmc">设备生产厂商名称</th>
	     	<th name="l_ggxh">规格型号</th>
	     	<th name="l_sbjcjgmc">设备检测机构名称</th>
	     	<th name="l_anwz">安装位置</th>
	     	<th name="l_wlcslxmc">网络传输类型</th>
	     	<th name="l_azsxtsl">摄像头安装数量</th>
	     	<th name="l_sflx">是否录像</th>
	     	<th name="l_ipdz">IP地址</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>