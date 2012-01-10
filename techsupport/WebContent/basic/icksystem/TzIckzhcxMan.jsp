<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var gnRyHtml,gwRyHtml,QyHtml;
var clickNum = 0;
var ickzhcx_pageUrl="";
var ickzhcx_divnid="tzzhcx_tabledata";
var ickzhcx_tableid="tzzhcx_table";
var ickzhcx_detailHtml="basic/icksystem/IckzhcxDetail.jsp";
var ickzhcx_detailid="tzzhcxickzh_detail";
var ickzhcx_detailUrl="icksystem/query_icksl.action";
var ickzhcx_detailWidth="800";
var ickzhcx_tables="";
$(document).ready(function() {
    if(dataid=='yfficklist'){
        ickzhcx_pageUrl="icksystem/yfficklist_icksl.action";
        $("#tzzhcxtitle").html("已发放IC卡信息");
        if(typeof(cjdtjrq)!='undefined'){
            $("#p_ffsj").val(cjdtjrq);
        }
    }else if(dataid=='yzxicklist'){
        ickzhcx_pageUrl="icksystem/yzxicklist_icksl.action";
        $("#tzzhcxtitle").html("已注销IC卡信息");
        if(typeof(cjdtjrq)!='undefined'){
            $("#p_ickzxsj").val(cjdtjrq);
        }
    }else if(dataid=='bhicklist'){
        ickzhcx_pageUrl="icksystem/bhicklist_icksl.action";
        $("#tzzhcxtitle").html("补换IC卡信息");
        if(typeof(cjdtjrq)!='undefined'){
            $("#p_ickzxsj").val(cjdtjrq);
        }
    }
	//从业人员详细信息页面
	gnRyHtml="business/Ylfwzagl/CyryxxDetail-cjd.jsp";
	gwRyHtml="business/Ylfwzagl/CyryxxDetail-wg-cjd.jsp";
	//场所详细信息页面
	QyHtml="business/Ylfwzagl/YlcsjbxxDetail.jsp";
	$("#z_hylbdm").selectBoxinhylb({code:"J"});
	ickzhcx_loadPage(ickzhcx_divnid);
	
	daggleDiv(ickzhcx_detailid);
	daggleDiv("tzzhcxqyjbxx_detail");
}); 
function ickzhcx_loadPage(divpageid){
    ickzhcx_tables=$("#"+divpageid).html();
	$("#"+ickzhcx_detailid).hide(); 	
	ickzhcx_setPageList(1);
}
function ickzhcx_setList(pageno,url){	
		$("#"+ickzhcx_divnid).html(ickzhcx_tables);	
		createXML("z_");
		if (url==null || url=="undefined"){
			url=ickzhcx_pageUrl;
		}
		return url;
}
function ickzhcx_setPageList(pageno,url){	
		url=ickzhcx_setList(pageno,url);
		var mygrid1 = $("#"+ickzhcx_tableid).ingrid({ 
										ingridPageParams:sXML,
										ingridPageWidth: pageWidth-120,
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
										height: pageHeight-300,
										pageNumber: pageno,
										colWidths: ["21%","8%","5%","8%","8%","14%","16%","12%","8%"]									
									});				
}	
	
//人员详细查询	
function setRyDetail(obj){
	dataid=$(obj).find("input[name='ryid"+$(obj).attr("id")+"']").val();
	sFlag="false";
	$("#"+ickzhcx_detailid).css("width","800px");
	$("#"+ickzhcx_detailid).css("left","40px");
	var rylbInput = $(obj).find("input[name='"+$(obj).attr("id")+"']");
	var rylbValue = rylbInput.val();
	$("#f_rylbbm").val(rylbValue);
	if(rylbValue == 0){
		detailUrl="publicsystem/query_qyryxx.action";
		setUrl(ickzhcx_detailid,gnRyHtml);
	}else{
		detailUrl="publicsystem/query_publicwgcyryxx.action";
		setUrl(ickzhcx_detailid,gwRyHtml);
	}
	bindDocument(ickzhcx_detailid);
}

//场所详细查询
var qyjbxx_requestType;
var qyjbxx_dataid;
var qyjbxx_detailWidth="990";

function setQyDetail(obj){
	detailUrl="publicsystem/query_qyjbxx.action";
	qyjbxx_requestType="detail";
	qyjbxx_dataid=$(obj).find("input[name='qy"+$(obj).attr("id")+"']").val();
	$("#tzzhcxqyjbxx_detail").css("width","1000px");
	$("#tzzhcxqyjbxx_detail").css("left","-50px");
	setUrl("tzzhcxqyjbxx_detail",QyHtml);
	sFlag="false";
	bindDocument("tzzhcxqyjbxx_detail");
}
function qyjbxx_setDetail(){
	setParams("q_");
	jQuery.post("publicsystem/query_qyjbxx.action",params,qyjbxx_updatediv,"json");
}

//IC卡详细查询
function setIckDetail(obj){
	dataid=$(obj).attr("id");
	detailUrl="icksystem/queryZh_icksl.action";
	$("#"+ickzhcx_detailid).css("width","800px");
	$("#"+ickzhcx_detailid).css("left","40px");
	setUrl(ickzhcx_detailid,ickzhcx_detailHtml);
	bindDocument(ickzhcx_detailid);
}

function setIckxq(id){
	dataid=id;
	detailUrl="icksystem/queryZh_icksl.action";
	$("#"+ickzhcx_detailid).css("width","800px");
	$("#"+ickzhcx_detailid).css("left","0px");
	setUrl(ickzhcx_detailid,ickzhcx_detailHtml);
	bindDocument(ickzhcx_detailid);
}

</script>

<body>
<input type="hidden" id="z_ffsj">
<input type="hidden" id="z_ickzxsj">
<div style="display:none;">
<select id="z_hylbdm"></select>
</div>
<div id="tzzhcxClose"></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1" id="tzzhcxtitle"></td>
      <td align="right" class="title1"><a href="#" onclick="$('#tzzhcxClose').parent().hideAndRemove(&quot;show&quot;);" class="close"></a></td>
    </tr>
</table>
<div id="tzzhcxickzh_detail"  class="page-layout" src="#"
		style="top:-30px;">
</div>	
	
<div id="tzzhcxqyjbxx_detail"  class="page-layout" src="#"
		style="display:none;top:-50px;">
</div>
<div id="tzzhcx_tabledata" style="width:100%;">
	<table id="tzzhcx_table" width="100%">
	  <thead>
	    <tr>       
	     	<!--  <th name="l_ickslid">序号</th>-->
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