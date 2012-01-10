<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var gnRyHtml,gwRyHtml,QyHtml;
var clickNum = 0;
$(document).ready(function() {
	//从业人员详细信息页面
	gnRyHtml="business/Ylfwzagl/CyryxxDetail-cjd.jsp";
	gwRyHtml="business/Ylfwzagl/CyryxxDetail-wg-cjd.jsp";
	//场所详细信息页面
	QyHtml="business/Ylfwzagl/YlcsjbxxDetail.jsp";
	
	pageUrl="icksystem/ickcswbllist_icksl.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="icksystem/insert_ickyj.action";
	addHtml="basic/icksystem/IckyjAdd.jsp";
	addWidth="500";
	delUrl="icksystem/delete_ickyj.action";
	delid="d_ickyjid";
	modHtml="basic/icksystem/IckyjModify.jsp";
	modUrl="icksystem/modify_ickyj.action";
	modWidth="800";
	detailHtml="basic/icksystem/IckzhcxDetail.jsp";
	detailid="ickzh_detail";
	detailUrl="icksystem/query_icksl.action";
	detailWidth="800";
	ickzhcx_loadPage("tabledata");
	
	daggleDiv("ickzh_detail");
	daggleDiv("qyjbxx_detail");
}); 
function ickzhcx_loadPage(divpageid){
    tables=$("#"+divpageid).html();
	$("#"+detailid).hide(); 	
	setPageList(1);
}
function setPageList(pageno,url){	
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML,
										ingridPageWidth: pageWidth-340,
										onRowSelect: null,	
										colClasses: ['grid-col-style2','grid-col-style2','grid-col-style2','grid-col-style2'],
										colIndex: [0,1,6,7],
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
													var tdnum = $(tr).find("td").index(this);
													if(tdnum!=$(tr).find("td").length-1){
														if(tdnum==1 || tdnum==0)
															setRyDetail(tr);
														else if(tdnum==6)
															setQyDetail(tr);
														else if(tdnum==7)
															setIckDetail(tr);
													}
											});
										},
										url: url,	
										height: ((pageHeight-225)/2-34),
										pageNumber: pageno,
										isPlayResultNull: false,
										hideColIndex:[3],
										colWidths: ["18%","10%","5%","0%","8%","20%","14%","14%","8%"]									
									});				
}
	
//人员详细查询	
function setRyDetail(obj){
	dataid=$(obj).find("input[name='ryid"+$(obj).attr("id")+"']").val();
	sFlag="false";
	setWidth(detailid,modWidth);
	var rylbInput = $(obj).find("input[name='"+$(obj).attr("id")+"']");
	var rylbValue = rylbInput.val();
	$("#f_rylbbm").val(rylbValue);
	if(rylbValue == 0){
		detailUrl="publicsystem/query_qyryxx.action";
		setUrl(detailid,gnRyHtml);
	}else{
		detailUrl="publicsystem/query_publicwgcyryxx.action";
		setUrl(detailid,gwRyHtml);
	}
	bindDocument(detailid);
}

//场所详细查询
var qyjbxx_requestType;
var qyjbxx_dataid;
var qyjbxx_detailWidth="990";

function setQyDetail(obj){
	detailUrl="publicsystem/query_qyjbxx.action";
	qyjbxx_requestType="detail";
	qyjbxx_dataid=$(obj).find("input[name='qy"+$(obj).attr("id")+"']").val();
	setWidth("qyjbxx_detail",qyjbxx_detailWidth);
	setUrl("qyjbxx_detail",QyHtml);
	sFlag="false";
	bindDocument("qyjbxx_detail");
}
function qyjbxx_setDetail(){
	setParams("q_");
	jQuery.post("publicsystem/query_qyjbxx.action",params,qyjbxx_updatediv,"json");
}

//IC卡详细查询
function setIckDetail(obj){
	dataid=$(obj).attr("id");
	detailUrl="icksystem/queryZh_icksl.action";
	setWidth(detailid,modWidth);
	setUrl(detailid,detailHtml);
	bindDocument(detailid);
}

function setIckxq(id){
	dataid=id;
	detailUrl="icksystem/queryZh_icksl.action";
	setWidth(detailid,modWidth);
	setUrl(detailid,detailHtml);
	bindDocument("ickzh_detail");
}
</script>

<body>
    <input type="hidden" id="p_qybm">
	<input type="hidden" id="f_rylbbm" />
<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
<div id="ickzh_detail"  class="page-layout" src="#"
		style="top:20px;">
</div>	
	
<div id="qyjbxx_detail"  class="page-layout" src="#"
		style="display:none;top:20px; left:0px; width:500px;">
</div>
<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_cyrybh">人员编号</th>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_xb" nowrap>性别</th>
	     	<th name="l_csrq">出生日期</th>
	     	<th name="l_gj">国籍</th>
	     	<th name="l_zjhm">证件号码</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_kh">IC卡卡号</th>
	     	<th name="l_zkztbs">制卡状态</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>