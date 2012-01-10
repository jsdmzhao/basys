<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<script type="text/javascript">
var cyryxx_detailWidth="990";
var qyjbxx_dataid="";
$(document).ready(function() {
	pageUrl="publicsystem/ryCfquerylist_ryjcxx.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="publicsystem/insert_ryjcxx.action";
	addHtml="basic/publicsystem/RycfxxAdd.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_ryjcxx.action";
	delid="d_ryid";
	modHtml="basic/publicsystem/RycfxxModify.jsp";
	modUrl="publicsystem/modify_ryjcxx.action";
	modWidth="800";
	detailHtml="basic/publicsystem/CyryxxDetail.jsp";
	detailid="cyryxx_detail";
	detailUrl="ylfwzagl/query_cyryxx.action";
	detailWidth="800";
	loadPage(divnid);
	//行业类别	
	$("#p_hylbdm").selectBoxhylb();
	$("#p_ryjcrqf").attr("readonly","true");
	$("#p_ryjcrqf").datepicker();
	$("#p_ryjcrqt").attr("readonly","true");
	$("#p_ryjcrqt").datepicker();
	$("#p_jcmxlbdm").selectBox({code:"dm_rycflb"});
	//场所详细信息页面
	QyHtml="basic/publicsystem/QyjbxxDetail.jsp";
	daggleDiv("cyryxx_detail");	
	hylbOnchangeMan();
}); 
	
	function setPageList(pageno,url){	
		url=setList(pageno,url);
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageWidth: pageWidth,
										onRowSelect: null,
										colClasses: ['grid-col-style2','grid-col-style2'],
										colIndex: [0,3],
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
													var tdnum = $(tr).find("td").index(this);
													if(tdnum!=$(tr).find("td").length-1){
														if(tdnum==3)
															getQyDetail(tr);
														if(tdnum==0)
															setQueryXq(tr);
													}
											});
										},
										url: url,	
										ingridPageParams:sXML,
										height: pageHeight-258,
										pageNumber: pageno,
										colWidths: ["7%","12%","4%","11%","12%","7%","12%","9%","7%","7%","10%"]									
									});
	}	
	
	 //企业筛选框
 $("#p_qymc").click(function(){
 dataid=$('#p_hylbdm').val();
	getTy_item("p_qymc","p_qybm");
  });

//人员处罚信息登记
	function setDengji(){
	detailUrl="publicsystem/query_ryjcxx.action";
	detailHtml="basic/publicsystem/RycfxxAdd.jsp";
	detailWidth="820";
	setWidth("cyryxx_detail",detailWidth);
	setUrl("cyryxx_detail",detailHtml);
	bindDocument("cyryxx_detail");
	}
	
	function setChufaxx(id){
	//sFlag = "false";
	dataid = id;
	detailHtml="basic/publicsystem/RycfxxMan.jsp";
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

	//详情、修改、删除的连接
	cf_modHtml="basic/publicsystem/RycfxxModify.jsp";
	cf_modUrl="publicsystem/modify_ryjcxx.action";
	cf_modWidth="550";
	cf_detailHtml="basic/publicsystem/RycfxxDetailcf.jsp";
	cf_detailid="cyryxx_detail";
	cf_detailWidth="600";
	cf_detailUrl="publicsystem/queryForby_ryjcxx.action";
	
	cf_delUrl="publicsystem/delete_ryjcxx.action";
	
	cf_delid="f_rycfid";

	//查询详情
	function setDetail_rycf(){
		setParams("q_");
		jQuery.post(cf_detailUrl,params,updatediv,"json");
	}
	//详情页面
	function setQuery_rycf(id){
		$("#"+cf_detailid).empty();
		dataid=id;
		$("#"+cf_detailid).css("top",200);
		setWidth(cf_detailid,cf_detailWidth);
		setUrl(cf_detailid,cf_detailHtml);
	}
	//修改
	function setUpdate_rycf(id){
		sFlag="false";
		dataid = id;
		$("#"+cf_detailid).css("top",200);
		setWidth(cf_detailid,cf_detailWidth);
		setUrl(cf_detailid,cf_modHtml);
	}
	//删除
	function setDelete_rycf(id){
		sFlag="false";
		jConfirm('确定删除吗？', '删除提示', function(r) {
	    	if(r==true){
				$("#"+cf_delid).attr("value",id);
				setParams("f_");
		        jQuery.post(cf_delUrl,params,deleteback_rycf,"json");
			}else{
			   return false;
			}
		});
	}
	//删除返回
	function deleteback_rycf(json){
		if  (json.result=="success"){
			jAlert(delMessage,'提示信息');
			var pageno=$("#pageNo").attr("value");
			if ($("#startno").html()==$("#endno").html()){
				if ($("#pageNo").attr("value")>1){
					pageno=""+(parseInt(pageno)-1);
				}
			}
			setPageList(pageno);
		}else{
			jAlert(json.result,'错误信息');
		}	
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
	function setQueryXq(obj){
	dataid=$(obj).find("input[name='ry"+$(obj).attr("id")+"']").val();
	detailHtml="basic/publicsystem/RyjcxxDetail.jsp";
	detailid="cyryxx_detail";
	detailUrl="publicsystem/query_ryjcxx.action";
	detailWidth="800";
	setWidth(detailid,detailWidth);
	setUrl(detailid,detailHtml);
	bindDocument(detailid);
}

//页面字体变化
	function hylbOnchangeMan(){
		var hylb=$("#p_hylbdm").val();
		var csorqymc = "企业名称";
		var csorqybm ="企业编码";
		if(hylb=='J'){
			csorqymc = "娱乐服务场所名称";
			csorqybm = "娱乐服务场所备案编号";
		}
		$('#qymc_man').text(csorqymc);
		$('#qybm_man').text(csorqybm);
		setTableText();
	}
	function setTableText(){
		var hylb=$("#p_hylbdm").val();
		var csorqymc = "企业名称";
		if(hylb=='J'){
			csorqymc = "娱乐服务场所名称";
		}
		$('#tabledata').find('thead').find('th[@name=l_qymc]').find('DIV').html(csorqymc);
	}
</script>
<html>
	<body>

		<input type="hidden" id="d_ryid" value="">
		<input type="hidden" id="f_rycfid" value="">
		<input type="hidden" id="p_cflbbm" value="1">
		<table width="100%" cellpadding="0" cellspacing="0"
			class="tableborder">
			<tr>
				<td class="queryfont">
					人员处罚查询
				</td>
			</tr>
			<tr>
				<td valign="top" class="tdbg">
					<table width="100%" border="0" cellspacing="0" cellpadding="2">
						<tr>
							<td width="14%" class="pagedistd" id="qymc_man">
								企业名称
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" readonly="readonly"
									id="p_qymc" value="">
							</td>
							<td width="10%" class="pagedistd" id="qybm_man">
								企业编码
							</td>
							<td width="21%" class="pagetd">
								<input type="text" class="inputstyle" readonly="readonly"
									id="p_qybm" value="">
							</td>
							<td width="10%" class="pagedistd">
								姓名
							</td>
							<td width="21%" class="pagetd">
								<input type="text" class="inputstyle" id="p_xm" value="">
							</td>
						</tr>
						<tr>
							<td class="pagedistd">
								处罚类型
							</td>
							<td class="pagetd">
									<select id="p_jcmxlbdm">
									<option></option>
								</select>
							</td>
							<td class="pagedistd">
								行业类别
							</td>
							<td class="pagetd" colspan="3">
								<select name="cylb" id="p_hylbdm" onChange="hylbOnchangeMan();">
								</select>
							</td>
						</tr>
						<tr>
							<td class="pagedistd">
								处罚日期
							</td>
							<td class="pagetd"><input type="text" class="inputstyle" id="p_ryjcrqf" value=""></td>
							<td class="pagedistd">
								至
							</td>
							<td class="pagetd">
								<input type="text" class="inputstyle" id="p_ryjcrqt" value="">
							</td>
							<td  class="pagetd" colspan="2">
								<table width="60" border="0" align="right" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="28px">
											<a href="#" class="searchbutton" id="querys"
												onClick="setPageList(1);">查询</a>
										</td>
										<td height="28px">
											<a href="#" class="addbutton"  id="add"
												onClick="setDengji();">添加</a>
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
						<th name="l_zjhm">
							证件号码
						</th>
						<th name="l_xb">
							性别
						</th>
						<th name="l_qymc">
							企业名称
						</th>
						<th name="l_gxdwmc">
							管辖单位
						</th>
						<th name="l_cflb">
							处罚类别
						</th>
						<th name="l_pzjg">
							批准机构
						</th>
						<th name="l_pzrxm">
							批准人
						</th>
						<th name="l_zxrxm">
							执行人
						</th>
						<th name="l_ryjcrq">
							处罚日期
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