<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
	<head>
		<script type="text/javascript">
	var ickysl_pageUrl="icksystem/queryYsllist_icksl.action";
	var ickysl_divnid="yslick_tabledata";
	var ickysl_tableid="yslick_table";
	var ickysl_detailHtml="basic/icksystem/IckslDetail.jsp";
	var ickysl_detailid="yslick_detail";
	var ickysl_detailUrl="icksystem/query_icksl.action";
	var ickysl_detailWidth="800";
	var ickysl_tables="";
$(document).ready(function() {
    if(typeof(cjdtjrq)!='undefined'){
        $("#z_lrsj").val(cjdtjrq);
    }
	gwIckSlHtml="basic/icksystem/IckslgwDetail.jsp";
	gnIckSlHtml="basic/icksystem/IckslgnDetail.jsp";
	//从业人员详细信息页面
	gnRyHtml="business/Ylfwzagl/CyryxxDetail-cjd.jsp";
	gwRyHtml="business/Ylfwzagl/CyryxxDetail-wg-cjd.jsp";
	//场所详细信息页面
	QyHtml="business/Ylfwzagl/YlcsjbxxDetail.jsp";
	$("#z_hylbdm").selectBoxinhylb({code:"J"});
	icksl_loadPage("yslick_tabledata");	
	daggleDiv("yslick_detail");
	daggleDiv("yslickqyjbxx_detail");
}); 
function icksl_loadPage(divpageid){
    ickysl_tables=$("#"+divpageid).html();
	$("#"+ickysl_detailid).hide(); 	
	ickysl_setPageList(1);
}
function ickysl_setList(pageno,url){	
		$("#"+ickysl_divnid).html(ickysl_tables);	
		createXML("z_");
		if (url==null || url=="undefined"){
			url=ickysl_pageUrl;
		}
		return url;
}
function ickysl_setPageList(pageno,url){	
		url=ickysl_setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+ickysl_tableid).ingrid({ 
										ingridPageParams:sXML,
										ingridPageWidth: pageWidth-120,
										tableid:'icksltableid',
										onRowSelect: null,
										colClasses: ['grid-col-style2','grid-col-style2','grid-col-style2'],
										colIndex: [0,1,4],
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
													var tdnum = $(tr).find("td").index(this);
													if(tdnum!=$(tr).find("td").length-1){
														if(tdnum==0||tdnum==1)
															setRyDetail(tr);
														else if(tdnum==4)
															setCsDetail(tr);
													}
											});
										},
										url: url,	
										height: pageHeight-260,
										pageNumber: pageno,
										hideColIndex:[8,9],
										colWidths: ["22%","8%","14%","5%","15%","14%","12%","10%","0%","0%"]									
									});				
}	

//人员详细查询
function setRyDetail(obj){
	dataid=$(obj).attr("id");
	sFlag="false";
	$("#yslick_detail").css("width","800px");
	$("#yslick_detail").css("left","40px");
	var rylbValue = $(obj).find("td:nth(8)").text();
	$("#f_rylbbm").val(rylbValue);
	if(rylbValue == 0){
		detailUrl="publicsystem/query_qyryxx.action";
		setUrl(ickysl_detailid,gnRyHtml);
	}else{
		detailUrl="publicsystem/query_publicwgcyryxx.action";
		setUrl(ickysl_detailid,gwRyHtml);
	}
	bindDocument(ickysl_detailid);
}

//场所详细查询
var qyjbxx_requestType;
var qyjbxx_dataid;
var qyjbxx_detailWidth="990";

function setCsDetail(obj){
	detailUrl="publicsystem/query_qyjbxx.action";
	qyjbxx_requestType="detail";
	qyjbxx_dataid=$(obj).find("td:nth(9)").text();
	$("#yslickqyjbxx_detail").css("width","1000px");
	$("#yslickqyjbxx_detail").css("left","-50px");
	setUrl("yslickqyjbxx_detail",QyHtml);
	sFlag="false";
	bindDocument("yslickqyjbxx_detail");
}
function qyjbxx_setDetail(){
	setParams("q_");
	jQuery.post("publicsystem/query_qyjbxx.action",params,qyjbxx_updatediv,"json");
}

</script>

	</head>
	<body>
	<input type="hidden" id="z_lrsj">
	<div style="display:none;">
		<select id="z_hylbdm"></select>
	</div>
	

<div id="tzickyslClose"></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">已受理IC卡信息</td>
      <td align="right" class="title1"><a href="#" onclick="$('#tzickyslClose').parent().hideAndRemove(&quot;show&quot;);" class="close"></a></td>
    </tr>
</table>
		<div id="yslick_detail" class="page-layout" src="#"
			style="top: 20px;">
		</div>

		<div id="yslickqyjbxx_detail" class="page-layout" src="#"
			style="display: none; top: -10px;">
		</div>
		<div id="yslick_tabledata" style="width: 100%;">
			<table id="yslick_table" width="100%">
				<thead>
					<tr>
						<th name="l_cyrybh">
							人员编号
						</th>
						<th name="l_xm">
							姓名
						</th>
						<th name="l_zjhm">
							证件号码
						</th>
						<th name="l_xb" nowrap>
							性别
						</th>
						<th name="l_qymc">
							企业名称
						</th>
						<th name="l_cjsj">
							采集时间
						</th>
						<th name="l_cylb">
							人员类别
						</th>
						<th name="l_cyryzt">
							状态
						</th>
						<th name="l_cyrylbdm">
							从业人员类别代码
						</th>
						<th name="l_qyid">
							企业ID
						</th>
					</tr>
				</thead>
			</table>
		</div>
	</body>
</html>