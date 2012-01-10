<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants;"%>
<%
	//登录用户
	int userid = 0;
	String userType = "";
	String userTypeBuf[] = null;
	String type = "";//
	User user = new User();
	//获得登录用户session
	user = (User) session.getAttribute(Constants.userKey);
	if (user == null)
		response.sendRedirect("login.jsp");
	else
		//根据登陆用户的type决定他去哪里链结那个场所
		userType = user.getUsertype();
	if (userType.length() > 0) {
		userTypeBuf = userType.split(",");
	}
	for (int i = 0; i < userTypeBuf.length; i++) {
		if ("24".equals(userTypeBuf[i])) {
			type = "lgy";
			break;
		}
		type = "yly";
	}
%>
<script type="text/javascript">
var daochuNum = 0;//是否可以导出Excle标志，0-无法导出，1-可以导出
var num = 0;
var gnIckSlHtml,gwIckSlHtml,gnRyHtml,gwRyHtml,lvguanbianm;

var currPageHeight = pageHeight-240;
//离线页面高度
if($("#offineFlag").attr("value")=='1'){
	currPageHeight = pageHeight-164;
	isGadLogin = false;
}
$(document).ready(function() {
	searchLongUrl="basicsystem/queryForExport_qycf.action";  //超长参数后台Action对应url
	pageUrl="basicsystem/querylist_qycf.action";
	divnid="QycfData";
	tableid="QycfTable";
	addUrl="basicsystem/insert_qycf.action";
	addHtml="basic/basicsystem/QycfAdd_jl.jsp";
	addWidth="550";
	delUrl="basicsystem/delete_qycf.action";
	delid="d_qycfid";
	modHtml="basic/basicsystem/QycfModify_jl.jsp";
	modUrl="basicsystem/modify_qycf.action";
	modWidth="550";
	detailHtml="basic/basicsystem/QycfDetail_jl.jsp";
	detailid="qycf_detail";
	detailUrl="basicsystem/query_qycf.action";
	detailWidth="550";
	//*****导出Excel 
	tabletitle = "";	 
	geteExcelHead("QycfData");	
	excelUrl="basicsystem/getExcelCreate_qycf.action";

	loadPage(divnid);
		$("#p_cfrq").attr("readonly","true");
		$("#p_cfrq").datepicker();
		$("#p_cfrq2").attr("readonly","true");
		$("#p_cfrq2").datepicker();
		$("#p_djsj").attr("readonly","true");
		$("#p_djsj").datepicker();
	$("#p_hylb").selectBoxhylb({code:"flgy"});//行业类别	
	
	//$("#p_cfjg").selectBox({code:"dm_cljg"});	
	$("#p_cfjg").selectBox({state:"dm_qyjllb"});
	
		//管辖单位所筛选框
	 $("#p_ssdwmc").click(function(){
		//getGxdwTree("p_ssdwmc","p_ssdwbm",'1');
		getGxdwTree("p_ssdwmc",null,"p_ssdwbm",null,null,null,null,null);
	});
	
	daggleDiv("qycf_detail");
	daggleDiv("ylcsjbxx_detail");
	daggleDiv("lvguan_detail");
	qyjsChange();
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageWidth: pageWidth,
										ingridPageParams:sXML,
										onRowSelect: null,
										colClasses: ['grid-col-style2'],
										colIndex: [0],
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
													var tdnum = $(tr).find("td").index(this);
													if(tdnum!=$(tr).find("td").length-1){
														if(tdnum==0)
															getQyDetail(tr);
													}
											});
										},
										changeHref:function(table){//若表格无数据，则点击导出不起作用
										//alert($(table).find("tr").length);
											$("#gnlkexcel").unbind("click");
											if($(table).find("tr").length==0){
													daochuNum = 0;
												}else{
													daochuNum = 1;
												}	
										},
										url: url,	
										height: currPageHeight,
										pageNumber: pageno,
										colWidths: ["20%","16%","16%","16%","16%","16%"]									
									});				
		}
}	
	function manVerify(){
		if(num!=0){
		if (!checkControlValue("p_hylb","Select",1,100,null,1,"行业类别"))
			return false;
		if (!checkControlValue("p_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("p_qymc","String",1,200,null,0,"企业名称"))
			return false;
		if (!checkControlValue("p_ssdwmc","String",1,100,null,0,"所属单位名称"))
			return false;
		if (!checkControlValue("p_cfjg","String",1,2000,null,0,"奖励结果"))
			return false;
		}
		num =1;
		return true;
	}
	
//企业（场所跟旅馆）详细查询
function getQyDetail(obj){
	var hylx = $("#p_hylb").attr("value");
	
	if("A"==hylx){//走旅馆的详情
		getLvguan(obj);
	}
	if("J"==hylx){//走场所的详情
		getChangsuo(obj);
	}
	
	if("C"==hylx){//走机修场所的详情
		getjxcs(obj);
	}
	
	if("B"==hylx){//走印章制作企业的详情
		getyzcs(obj);
	}
}

//场所详细查询
var ylcsjbxx_requestType;
var ylcsjbxx_dataid;
var ylcsjbxx_detailidTopOffset=0;
var ylcsjbxx_detailidLeftOffset=0;
var CsHtml;
var ylcsjbxx_detailWidth;
function getChangsuo(obj){
	ylcsjbxx_detailWidth="990";
	ylcsjbxx_requestType="detail";
	CsHtml="business/Ylfwzagl/YlcsjbxxDetail.jsp";
	ylcsjbxx_dataid="csbm_"+$(obj).find("input[name='cs"+$(obj).attr("id")+"']").val();
	
	setWidth("ylcsjbxx_detail",ylcsjbxx_detailWidth);
	setUrl("ylcsjbxx_detail",CsHtml);
	var ylcsjbxx_detailidOffset = $("#ylcsjbxx_detail").offset();
	ylcsjbxx_detailidTopOffset=ylcsjbxx_detailidOffset.top;
	ylcsjbxx_detailidLeftOffset=ylcsjbxx_detailidOffset.left;
	sFlag="false";
	bindDocument("ylcsjbxx_detail");
}

function ylcsjbxx_setDetail(){
	setParams("q_");
	jQuery.post("ylfwzagl/query_ylcsjbxx.action",params,ylcsjbxx_updatediv,"json");
}

//旅馆详细查询
function getLvguan(obj){
	ylcsjbxx_detailWidth = 850;
	dataid ="";
	lvguanbianm = $(obj).find("input[name='cs"+$(obj).attr("id")+"']").val();
	qyDetail = "lvguan_detail";
	CsHtml = "business/Lgyzagl/LvguanDetail.jsp";
	ylcsjbxx_detailidOffset = $("#lvguan_detail").offset();
	detailUrl="lgyzagl/query_lvguan.action";
	
	setWidth(qyDetail,ylcsjbxx_detailWidth);
	setUrl(qyDetail,CsHtml);
	ylcsjbxx_detailidTopOffset=ylcsjbxx_detailidOffset.top;
	ylcsjbxx_detailidLeftOffset=ylcsjbxx_detailidOffset.left;
	sFlag="false";
	bindDocument(qyDetail);
}	

   ///机修企业详细查询
	function getjxcs(obj){
	  dataid = $(obj).find("input[name='cs"+$(obj).attr("id")+"']").val(); //场所编码
	  CsHtml="business/jxyzagl/JxqyxxDetail.jsp";
	  
	  setWidth("ylcsjbxx_detail","850");
	  setUrl("ylcsjbxx_detail",CsHtml);
	  bindDocument("ylcsjbxx_detail");
	}
	
	///印章企业详细查询
	function getyzcs(obj){
	  dataid = "bm_"+$(obj).find("input[name='cs"+$(obj).attr("id")+"']").val(); //场所编码
	  CsHtml="business/yzyzagl/YzzzdwxxDetail.jsp";
	  setWidth("ylcsjbxx_detail","850");
	  setUrl("ylcsjbxx_detail",CsHtml);
	  bindDocument("ylcsjbxx_detail");
	}

//企业奖励详情
function setQycfXq(id){
	dataid=id;
	detailUrl="basicsystem/query_qycf.action";
	setWidth(detailid,detailWidth);
	setUrl(detailid,detailHtml);
	bindDocument(detailid);
}
//导出Excel
function setExportExcel(){	
  	//alert(daochuNum);
  	if(daochuNum==1){
		if (manVerify()){
  			setSearchLong(); //传全部参数将查询结果放入json，对应后台Action方法中将结果集放入session，用于处理超长参数的数据导出
  		}
  	}else{
  		alert('无查询结果不能导出！');
  	}		
}


//导出前对应setSearchLong()的回调方法  由于执行查询时候有延迟，故将导出放入回调函数
function searchLongBack(json){  
		//报表标题
			var bbmc="企业奖励信息";
		//报表请求	
			setExcelLong("qycfexcel",bbmc);	
}
//高级查询
function gaojichaxun_qycf(){
	//sjbid:数据表id;loadDiv:加载高级查询页面的div
	// gaojichaxun(sjbid,loadDiv);
	gaojichaxun("20",detailid);
}
 
  /////根据不同行业 初始化奖励结果下拉框
  $("#p_cfjg").click(function(){
	   if($("#p_hylb").attr("value")==null || $("#p_hylb").attr("value").length==0 ){
	        //$("#p_cfjg").selectBox({clear:"1"});
		 	jAlert('请先选择行业类型!','验证信息');
		 	return false;
	   }
	  
  });
   
  ///根据行业类别清空角色
	function qyjsChange(){
	  if($("#p_hylb").attr("value")==null || $("#p_hylb").attr("value").length==0 ){
	  
	     $("#p_cfjg").selectBox({clear:"1"});
	    
	  }else if($("#p_hylb").attr("value") == "B"){ //印章业  cuicui
	     
	     $("#p_cfjg").selectBox({code:"dm_qyjllb"});
	     
	  }else if($("#p_hylb").attr("value") == "C"){ //机修业
	     
	     $("#p_cfjg").selectBox({code:"dm_qyjllb"});
	  }else{
	     
	     $("#p_cfjg").selectBox({code:"dm_qyjllb"});
	  }
	     $("#p_cfjg").hide();
	  
	}
  
  
</script>
<input type="hidden" id="d_qycfid" value="">
<input type="hidden" id="p_flag" value="query">
<input type="hidden" id="p_ssdwbm">
<input type="hidden" id="type" value="<%=type%>">
<input type="hidden" id="p_cflbbm" value="0">

<table width="100%" cellpadding="0" cellspacing="0" class="tableborder">
	<tr>
		<td class="queryfont">
			企业奖励查询
		</td>
	</tr>
	<tr>
		<td class="tdbg">
			<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="7%" class="red">
						行业类别
					</td>
					<td width="17%" class="pagetd">
						<select id="p_hylb" onchange="qyjsChange();">
							
						</select>
					</td>
					<td width="7%" class="pagedistd">
						企业名称
					</td>
					<td width="17%" class="pagetd">
						<input type="text" class="inputstyle" id="p_qymc" value="">
					</td>
					<td width="7%" class="pagedistd">
						企业编码
					</td>
					<td width="16%" class="pagetd">
						<input type="text" class="inputstyle" id="p_qybm" value="">
					</td>
					<td width="11%" class="pagedistd">
						所属单位名称
					</td>
					<td width="18%" class="pagetd">
						<input type="text" class="inputstyle" id="p_ssdwmc" value="">
					</td>
				</tr>
				<tr>
					<td width="7%" class="pagedistd">
						奖励日期
					</td>
					<td width="17%" class="pagetd">
						<input type="text" class="inputstyle" id="p_cfrq" value="">
					</td>
					<td width="7%" class="pagedistd">
						至
					</td>
					<td width="17%" class="pagetd">
						<input type="text" class="inputstyle" id="p_cfrq2" value="">
					</td>
					<td width="7%" class="pagedistd">
						奖励结果
					</td>
					<td width="16%" class="pagetd">
						<select id="p_cfjg">
							<option></option>
						</select>
					</td>
					<td colspan="2">
						<table width="200" border="0" align="right" cellpadding="2"
							cellspacing="0">
							<tr>
								<td width="25%">
									&nbsp;
									<!-- <a href="#" class="submitbutton"
												onclick='gaojichaxun_qycf();'>高级查询</a> -->
								</td>
								<td width="25%">
									<a href="#" class="searchbutton" id="querys"
										onClick="setPageList(1);">查询</a>
								</td>
								<td width="25%">
									<a href="#" class="exceldcbutton"
										onclick='setExportExcel();'>导出</a>
								</td>
							</tr>
						</table>
					</td>
			</table>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
	</tr>
</table>
<div id="qycf_detail" class="page-layout" src="#"
	style="top: 180px; width: 500px;">
</div>

<div id="ylcsjbxx_detail" class="page-layout" src="#"
	style="display: none; z-index: 2000; top: 0px;">
</div>

<div id="lvguan_detail" class="page-layout" src="#"
	style="display: none; z-index: 2000; top: 180px;">
</div>
<div id="QycfData" style="width: 100%;">
	<table id="QycfTable" width="100%">
		<thead>
			<tr>
				<th name="l_qymc" datatype="string" sumflag="0">
					<a> 企业名称</a>
				</th>
				<th name="l_cfjg" datatype="string" sumflag="0">
					奖励结果
				</th>
				<th name="l_cfrq" datatype="string" sumflag="0">
					奖励日期
				</th>
				<th name="l_djsj" datatype="date" sumflag="0">
					登记时间
				</th>
				<th name="l_ssdwmc" datatype="string" sumflag="0">
					所属单位名称
				</th>
				<th name="">
					操作
				</th>
			</tr>
		</thead>

	</table>
</div>
