<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<script type="text/javascript">
var gnIckSlHtml,gwIckSlHtml,gnRyHtml,gwRyHtml,CsHtml;
var cyryxx_detailWidth="990";
var qyjbxx_dataid="";
$(document).ready(function() {
	pageUrl="publicsystem/ryquerylist_ryjcxx.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="publicsystem/insert_ryjcxx.action";
	addHtml="basic/publicsystem/RyjcxxAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_ryjcxx.action";
	delid="d_ryid";
	modHtml="basic/publicsystem/RyjcxxModify.jsp";
	modUrl="publicsystem/modify_ryjcxx.action";
	modWidth="800";
	detailHtml="basic/publicsystem/CyryxxDetail.jsp";
	detailid="cyryxx_detail";
	detailUrl="ylfwzagl/query_cyryxx.action";
	detailWidth="800";
	
	//行业类别	
	$("#p_hylbdm").selectBoxhylb({code:"flgy"});
	//场所详细信息页面
	QyHtml="basic/publicsystem/QyjbxxDetail.jsp";
	//$("#p_cyrylbdm").selectBox({code:"dm_cyrylb"});		
	daggleDiv("cyryxx_detail");	
	loadPage(divnid);
	hylbOnchangeMan();
	setTableText();
}); 
	
	function setPageList(pageno,url){	
		url=setList(pageno,url);
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageWidth: pageWidth,
										onRowSelect: null,
										colClasses: ['grid-col-style2'],
										colIndex: [5],
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
													var tdnum = $(tr).find("td").index(this);
													if(tdnum!=$(tr).find("td").length-1){
														if(tdnum==5)
															getQyDetail(tr);
													}
											});
										},
										url: url,	
										ingridPageParams:sXML,
										height: pageHeight-224,
										pageNumber: pageno,
										colWidths: ["8%","14%","12%","8%","12%","18%","16%","12%"]									
									});
		setTableText();
	}	
	
	 //企业筛选框
 $("#p_qymc").click(function(){
 dataid=$('#p_hylbdm').val();
	getTy_item("p_qymc","p_qybm");
  });


	function setDengji(id){
	detailUrl="publicsystem/query_ryjcxx.action";
	dataid = id;
	detailHtml="basic/publicsystem/RyjcxxAdd.jsp";
	detailWidth="820";
	setWidth("cyryxx_detail",detailWidth);
	setUrl("cyryxx_detail",detailHtml);
	bindDocument("cyryxx_detail");
	}
	
	function setChufaxx(id){
	//sFlag = "false";
	dataid = id;
	detailHtml="basic/publicsystem/RyjcxxMan.jsp";
	detailUrl="";
	setWidth("cyryxx_detail",detailWidth);
	setUrl("cyryxx_detail",detailHtml);
	bindDocument("cyryxx_detail");
	}
	
	function relsetDetailUrl(){

	detailHtml="basic/publicsystem/RyjcxxDetail.jsp";
	detailid="cyryxx_detail";
	detailUrl="publicsystem/query_ryjcxx.action";
	detailWidth="800";
	
	}
	
	
	//场所详细查询
	var qyjbxx_requestType;
	var qyjbxx_dataid;
	var cyryxx_detailidTopOffset=0;
	var cyryxx_detailidLeftOffset=0;

	function getQyDetail(obj){
	qyjbxx_requestType="detail";
	qyjbxx_dataid=$(obj).find("input[name='qy"+$(obj).attr("id")+"']").val();
	setWidth("cyryxx_detail",cyryxx_detailWidth);
	setUrl("cyryxx_detail",QyHtml);
	var cyryxx_detailidOffset = $("#cyryxx_detail").offset();
	cyryxx_detailidTopOffset=cyryxx_detailidOffset.top;
	cyryxx_detailidLeftOffset=cyryxx_detailidOffset.left;
	sFlag="false";
	bindDocument("cyryxx_detail");
}

	function qyjbxx_setDetail(){
		setParams("q_");
		jQuery.post("publicsystem/query_qyjbxx.action",params,qyjbxx_updatediv,"json");
	}

	//从业人员详情
	function setQueryXq(id){
		detailHtml="basic/publicsystem/QyryxxDetail-gzth.jsp";
		detailUrl="publicsystem/query_qyryxx.action";
		var hylb=$("#p_hylbdm").val();
		if(hylb=='J'||hylb=='K'){
			detailHtml="business/Ylfwzagl/CyryxxDetail-gad.jsp";
			detailUrl="publicsystem/query_qyryxx.action";
		}
		dataid=id;
		detailid="cyryxx_detail";
		detailWidth="800";
		setWidth(detailid,detailWidth);
		setUrl(detailid,detailHtml);
		bindDocument(detailid);
	}
	function hylbOnchangeMan(){
		var hylb=$("#p_hylbdm").val();
		var csorqymc = "企业名称";
		QyHtml="basic/publicsystem/QyjbxxDetail-gzth.jsp";
		if(hylb=='J'||hylb=='K'){
			csorqymc = "场所名称";
			QyHtml="basic/publicsystem/QyjbxxDetail.jsp";
		}
		$('#qymc_man').text(csorqymc);
		
	}
	function setTableText(){
		var hylb=$("#p_hylbdm").val();
		var csorqymc = "企业名称";
		if(hylb=='J'||hylb=='K'){
			csorqymc = "场所名称";
		}
		$('#tabledata').find('thead').find('th[@name=l_qymc]').find('DIV').html(csorqymc);
	}
	function addback(json){
		if  (json.result=="success"){
			jAlert(addMessage,'提示信息');
			setPageList($("#pageNo").attr("value"));
			$("#"+detailid).hideAndRemove("slow"); 
			//setAddPage();
		}else{
			jAlert(json.result,'错误信息');
		}		
	}	
</script>
<html>
<body>
<input type="hidden" id="d_ryid" value="">

		<table width="100%" cellpadding="0" cellspacing="0"
			class="tableborder">
			<tr>
				<td class="queryfont">
					从业人员奖惩管理
				</td>
			</tr>
			<tr>
				<td valign="top" class="tdbg">
					<table width="100%" border="0" cellspacing="0" cellpadding="2">
						<tr>
							<td width="10%" class="pagedistd">
								行业类别
							</td>
							<td width="27%" class="pagetd">
								<select name="cylb" id="p_hylbdm" onchange="hylbOnchangeMan();">
								</select>
							</td>
							<td width="10%" class="pagedistd">
								姓名
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" id="p_xm" value="">
							</td>
							<td width="10%" class="pagedistd">
								证件号码
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" id="p_zjhm" value="">
							</td>
							
						</tr>
						<tr>
							<td width="10%" class="pagedistd">
								人员编号
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" id="p_cyrybh" value="">
							</td>
							<td width="10%" class="pagedistd" id="qymc_man">
								企业名称
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" readonly="readonly"
									id="p_qymc" value="">
							</td>
							<td colspan="6">
								<table width="60" border="0" align="right" cellpadding="0"
									cellspacing="0">
									<tr>
										<td>
											<a href="#" class="searchbutton" id="querys"
												onClick="setPageList(1);">查询</a>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						
					</table>
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="3"></td>
			</tr>
		</table>
		<div id="cyryxx_detail" class="page-layout" src="#"
			style="top: 10px; left: 160px; width: 500px;">
		</div>


		<div id="tabledata" style="width: 100%;">
			<table id="table1" width="100%">
				<thead>
					<tr>
						<th name="l_xm">
							姓名
						</th>
						<th name="l_cyrybh">
							从业人员编号
						</th>
						<th name="l_zjhm">
							证件号码
						</th>
						<th name="l_xb">
							性别
						</th>
						<th name="l_hylb">
							从业类别
						</th>
						<th name="l_qymc">
							企业名称
						</th>
						<th name="l_gxdwmc">
							管辖单位
						</th>
						<th name="">
							操作
						</th>
					</tr>
				</thead>

			</table>
		</div>



	</body>
</html>