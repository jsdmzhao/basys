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
	int depLev=user.getDepartment().getDepartlevel().intValue();
%>
<script type="text/javascript">
var daochuNum = 0;//是否可以导出Excle标志，0-无法导出，1-可以导出
var num = 0;
var gnIckSlHtml,gwIckSlHtml,gnRyHtml,gwRyHtml,CsHtml,lvguanbianm;
var qyjbxx_dataid,ylcsjbxx_dataid;

var ylcsjbxx_detailWidth = 850;////典当企业详细应用变量
var ylcsjbxx_requestType="detail";; //添加、查看、修改

$(document).ready(function() {
	searchLongUrl="basicsystem/queryForExport_asjgl.action";  //超长参数后台Action对应url
	pageUrl="basicsystem/querylist_asjgl.action";
	divnid="AsjglData";
	tableid="AsjglTable";
	addUrl="basicsystem/insert_asjgl.action";
	addHtml="basic/basicsystem/AsjglAdd.jsp";
	addWidth="550";
	delUrl="basicsystem/delete_asjgl.action";
	delid="d_asjglid";
	modHtml="basic/basicsystem/AsjglModify.jsp";
	modUrl="basicsystem/modify_asjgl.action";
	modWidth="550";
	detailHtml="basic/basicsystem/AsjglDetail.jsp";
	detailid="asjgl_detail";
	detailUrl="basicsystem/query_asjgl.action";
	detailWidth="550";
	
	//*****导出Excel 
	tabletitle = "";	 
	geteExcelHead("AsjglData");	
	excelUrl="basicsystem/getExcelCreate_asjgl.action";
	
	loadPage(divnid);
	$("#p_fasj").attr("readonly","true");
	$("#p_fasj").datepicker(true,"0");
	$("#p_fasj2").attr("readonly","true");
	$("#p_fasj2").datepicker(true,"1");
	$("#p_djsj").attr("readonly","true");
	$("#p_djsj").datepicker();
		
	$("#p_hylbdm").selectBoxhylb();//行业类别
		 	
	$("#p_ajxzdm").selectBox({code:"dm_ajxz"});
	$("#p_ajlbdm").selectBox({code:"dm_ajlx"});	
 	
	daggleDiv("asjgl_detail");
	daggleDiv("ylcsjbxx_detail");
	daggleDiv("lvguan_detail");
	setHyxx();
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageWidth: pageWidth,
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
											$("#asjglexcel").unbind("click");
											if($(table).find("tr").length==0){
													daochuNum = 0;
												}else{
													daochuNum = 1;
												}	
										},
										url: url,	
										ingridPageParams:sXML,
										height: pageHeight - 260,
										pageNumber: pageno,
										colWidths: ["20%","16%","16%","16%","16%","16%"]									
									});		
		setHyxx();		
		}
}	
	function manVerify(){
		if(num!=0){
			if (!checkControlValue("p_hylbdm","Select",1,100,null,1,"行业类别"))
				return false;
			if (!checkControlValue("p_qymc","String",1,200,null,0,"场所名称"))
				return false;
			if (!checkControlValue("p_ajxzdm","String",1,60,null,0,"案件性质"))
				return false;
			if (!checkControlValue("p_ajlbdm","String",1,60,null,0,"案件类别"))
				return false;
			if (!checkControlValue("p_fasj","Datetime",null,null,null,0,"发案时间"))
				return false;
			if (!checkControlValue("p_ssdwmc","String",1,100,null,0,"治安管辖机构"))
				return false;
			if(!compare_twoTime($("#p_fasj").val(),$("#p_fasj2").val(),"DATETIME")){
				jAlert("发案时间开始时间不能大于结束时间！","验证信息");
				return false;
			}
			if($("#p_ssdwlevel").val()==""){
				$("#p_ssdwlevel").val("<%=depLev%>");
			}
		}
		num =1;	
		return true;
	}
	
	//管辖单位所筛选框
	 $("#p_ssdwmc").click(function(){
		//getGxdwTree("p_ssdwmc","p_ssdwbm","1");
		getGxdwTree("p_ssdwmc",null,"p_ssdwbm","p_ssdwlevel",null,null,null,null);
	});
	
	
	
//企业（场所跟旅馆）详细查询
function getQyDetail(obj){
	
	var hylx = $("#p_hylbdm").attr("value");
	if("A"==hylx){//走旅馆的详情
		getLvguan(obj);
	}else if("J"==hylx){//走场所的详情
		getChangsuo(obj);
	}else if("B"==hylx){//走印章制作企业的详情
		getyzcs(obj);
	}else if("E03"==hylx){//  典当企业的详情
		getddqy(obj);
		
	}else if("N"==hylx){// 内保单位的详情
		var qybm = $(obj).find("input[name='cs"+$(obj).attr("id")+"']").val();
		openQyxx("",detailid,qybm);
		
	}else{    ///公共平台的行业的企业详情
	   getpublicqy(obj);
	}
}

//场所详细查询
var qyjbxx_requestType;
var ylcsjbxx_detailidTopOffset=0;
var ylcsjbxx_detailidLeftOffset=0;
var CsHtml;
var ylcsjbxx_detailWidth;

////娱乐场所详情
function getChangsuo(obj){
	ylcsjbxx_detailWidth="990";
	qyjbxx_requestType="detail";
	CsHtml="business/Ylfwzagl/YlcsjbxxDetail.jsp";
	qyjbxx_dataid="qybm_"+$(obj).find("input[name='cs"+$(obj).attr("id")+"']").val();
	
	setWidth("ylcsjbxx_detail",ylcsjbxx_detailWidth);
	setUrl("ylcsjbxx_detail",CsHtml);
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
    ///印章企业详细查询
  function getyzcs(obj){
	  dataid = "bm_"+$(obj).find("input[name='cs"+$(obj).attr("id")+"']").val(); //场所编码
	  CsHtml="business/yzyzagl/YzzzdwxxDetail.jsp";
	  setWidth("ylcsjbxx_detail","850");
	  setUrl("ylcsjbxx_detail",CsHtml);
	  bindDocument("ylcsjbxx_detail");
	}
  //机修企业详细
  function getjxqy(obj){
  
      dataid = $(obj).find("input[name='cs"+$(obj).attr("id")+"']").val(); //机修编码
	  CsHtml="business/jxyzagl/JxqyxxDetail.jsp";
	  setWidth("ylcsjbxx_detail","850");
	  setUrl("ylcsjbxx_detail",CsHtml);
	  bindDocument("ylcsjbxx_detail");
  
  }	
  //典当企业详细
  function getddqy(obj){
  
      ylcsjbxx_dataid = "qybm_"+$(obj).find("input[name='cs"+$(obj).attr("id")+"']").val(); //典当编码
	  CsHtml="business/Ddhyzagl/DdqyxxDetail.jsp";
	  setWidth("ylcsjbxx_detail","850");
	  setUrl("ylcsjbxx_detail",CsHtml);
	  bindDocument("ylcsjbxx_detail");
  }	
  
  //公共平台的行业的企业详情
  function getpublicqy(obj){
      qyjbxx_dataid = "qybm_"+$(obj).find("input[name='cs"+$(obj).attr("id")+"']").val(); //公共平台编码
	  CsHtml="basic/publicsystem/QyjbxxDetail.jsp";
	  setWidth("ylcsjbxx_detail","950");
	  setUrl("ylcsjbxx_detail",CsHtml);
	  bindDocument("ylcsjbxx_detail");
  }	

//详情
function setQueryXq(id){
	dataid=id;
	detailUrl="basicsystem/query_asjgl.action";
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
			var bbmc="案事件管理信息";
		//报表请求
			//setExcel("gnlkexcel",bbmc);	
			setExcelLong("asjglexcel",bbmc);	
}

//高级查询
function gaojichaxun_asjgl(){
	//sjbid:数据表id;loadDiv:加载高级查询页面的div
	// gaojichaxun(sjbid,loadDiv);
	gaojichaxun("19",detailid);
}
//设定行业信息表示
    function setHyxx(){
        var hylb=$("#p_hylbdm").val();
		if(hylb=='J'){
			$('#td_qymc').text('场所名称');
			$('#td_qybm').text('场所备案编号');
			$('#AsjglData').find('thead').find('th[@name=l_qymc]').find('DIV').html('场所名称');
		}else{
		    $('#td_qymc').text('企业名称');
		    $('#td_qybm').text('企业编号');
			$('#AsjglData').find('thead').find('th[@name=l_qymc]').find('DIV').html('企业名称');
		}
    }
    function setModifyAsj(id){
    	detailUrl="basicsystem/query_asjgl.action";
		dataid="";
		dataid=id;
		sFlag="false";
		setWidth(detailid,modWidth);
		setUrl(detailid,modHtml);
		bindDocument(detailid);
	}
</script>
<html>
	<body>
		<input type="hidden" id="d_asjglid" value="">
		<input type="hidden" id="p_ssdwbm">
		<input type="hidden" id="p_ssdwlevel">
		<input type="hidden" id="type" value="<%=type%>">
		<table width="100%" cellpadding="0" cellspacing="0"
			class="tableborder">
			<tr>
				<td class="queryfont">
					场所发案查询
				</td>
			</tr>
			<tr>
				<td class="tdbg">
					<table width="100%" border="0" cellspacing="0" cellpadding="2">
						<tr>
							<td width="7%" class="pagedistd">
								行业类别
							</td>
							<td width="17%" class="pagetd">
								<select type="select" id="p_hylbdm"  onchange="setHyxx();">
								</select>
							</td>
							<td width="7%" class="pagedistd" id="td_qymc">
								场所名称
							</td>
							<td width="17%" class="pagetd">
								<input type="text" class="inputstyle" id="p_qymc" value="">
							</td>
							<td width="11%" class="pagedistd" id="td_qybm">
								场所备案编号
							</td>
							<td width="16%" class="pagetd">
								<input type="text" class="inputstyle" id="p_qybm" value="">
							</td>
							<td width="7%" class="pagedistd">
								治安管辖机构
							</td>
							<td class="pagetd">
								<input type="text" class="inputstyle" readonly="readonly" id="p_ssdwmc" value="">
							</td>
						</tr>
						<tr>
							<td width="7%" class="pagedistd">
								案件性质
							</td>
							<td width="17%" class="pagetd">
								<select type="select" id="p_ajxzdm">
									<option></option>
								</select>
							</td>
							<td width="7%" class="pagedistd">
								案件类别
							</td>
							<td width="17%" class="pagetd">
								<select type="select" id="p_ajlbdm">
									<option></option>
								</select>
							</td>
							<td width="11%" class="pagedistd">
								发案时间
							</td>
							<td class="pagetd">
								<input type="text" class="inputstyle" id="p_fasj" value="">
							</td>
							<td class="pagedistd">
								至
							</td>
							<td class="pagetd">
								<input type="text" class="inputstyle" id="p_fasj2" value="">
							</td>
						</tr>
						<tr>
							<td colspan="8">
								<table width="240" border="0" align="right" cellpadding="2"
									cellspacing="0">
					  <tr>
										<td width="25%">
											&nbsp;<!-- <a href="#" class="submitbutton" onclick='gaojichaxun_asjgl();'>高级查询</a> -->
										</td>
										<td width="25%">
											<a href="#" class="searchbutton" id="querys"
												onClick="setPageList(1);">查询</a>
										</td>
										<td width="25%">
											<a href="#" class="exceldcbutton" onclick='setExportExcel();' id="asjglexcel">导出</a>
										</td>
										<td width="25%">
											<a href="#" class="addbutton" onclick='setAddPage()'>添加</a>
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
		<div id="asjgl_detail" class="page-layout"  src="#"
			style="display:none; top:80px; left:160px; width:500px; ">
		</div>

		<div id="ylcsjbxx_detail" class="page-layout"  src="#"
			style="display:none;top:0px; left:160px; width:500px;">
		</div>
		
		<div id="lvguan_detail" class="page-layout"  src="#"
			style="display:none;top:180px; left:0px; width:500px;">
		</div>
		<div id="AsjglData" style="width:100%;">
			<table id="AsjglTable" width="100%">
				<thead>
					<tr>
						<th name="l_qymc" datatype="string" sumflag="0">
							场所名称
						</th>
						<th name="l_ajxz" datatype="string" sumflag="0">
							案件性质
						</th>
						<th name="l_ajlb" datatype="string" sumflag="0">
							案件类别
						</th>
						<th name="l_fasj" datatype="string" sumflag="0">
							发案时间
						</th>
						<th name="l_ssdwmc" datatype="string" sumflag="0">
							治安管辖机构
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
