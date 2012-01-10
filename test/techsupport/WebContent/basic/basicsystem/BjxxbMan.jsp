<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants"%>
<%
	User user = (User) session.getAttribute(Constants.userKey);
	int depLev=user.getDepartment().getDepartlevel().intValue();
	String isleaf=user.getDepartment().getIsleaf().toString();
%>
<script type="text/javascript">
var daochuNum = 0;//是否可以导出Excle标志，0-无法导出，1-可以导出
$(document).ready(function() {
	searchLongUrl="basicsystem/queryForExport_bjxxb.action";
	pageUrl="basicsystem/querylist_bjxxb.action";
	divnid="BjxxbData";
	tableid="BjxxbTable";
	addUrl="basicsystem/insert_bjxxb.action";
	addHtml="basic/basicsystem/BjxxbAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_bjxxb.action";
	delid="d_bjgzid";
	modHtml="basic/basicsystem/XbjModify.jsp";
	modUrl="basicsystem/modify_bjxxb.action";
	modWidth="900";
	detailHtml="basic/basicsystem/BjxxDetail.jsp";
	detailid="bjxxb_detail";
	detailUrl="basicsystem/query_bjxxb.action";
	detailWidth="300";
	
	tabletitle = "";
	geteExcelHead("BjxxbData");
	//alert(tabletitle);
	//ExcelURL
	excelUrl="basicsystem/getExcelCreateRz_bjxxb.action";
	
	loadPage("BjxxbData");
	
	// 添加日期属性
	$("#p_bjsj1").datepicker(true);
	$("#p_bjsj2").datepicker(true);
	
	// 添加只读属性
	$("#p_bjsj1").attr("readonly","true");
	$("#p_bjsj2").attr("readonly","true");
	$("#s_gxdwmc").attr("readonly","true");
	$("#s_cjbm").attr("readonly","true");
	$("#s_pjbmmc").attr("readonly","true");
	
	$("#p_gxdwlevel").val("<%=depLev%>");
	$("#p_isleaf").val("<%=isleaf%>");
	// 添加下拉框
	$("#s_gxdwmc").click(function(){ 
		getGxdwTree("s_gxdwmc",null,"p_gxdwbm","p_gxdwlevel",null,null,null,"p_isleaf");
	});
	$("#s_cjbm").click(function(){//getGxdwTree("s_cjbm","p_cjbmbm","0");
	getGxdwTree("s_cjbm","p_cjbmbm",null,null,null,null,null,null);});
	$("#s_pjbmmc").click(function(){//getGxdwTree("s_pjbmmc","p_pjbmbm","0");
	getGxdwTree("s_pjbmmc","p_pjbmbm",null,null,null,null,null,null);});
	$("#p_cjjgdm").selectBox({code:"dm_cjjg"}); // 处警结果选择框
	$("#p_bjlxdm").selectBox({code:"dm_bjlx"}); // 报警类型选择框
	$("#p_jqztdm").selectBox({code:"dm_jqzt"}); // 警情状态选择框
	$("#p_sfyxbjdm").selectBox({code:"dm_bez"}); // 警情是否有效选择框
	//$("#p_hylbdm").selectBox({code:"dm_hylb"}); // 行业类别选择框
	$("#p_ywlbdm").selectBox({state:"dm_ywlb"}); // 业务类别选择框
	
	$("#p_hylbdm").selectBoxhylb({code:"dm_hylb"});// 行业类别选择框
	if($("#p_hylbdm").find("option").length<=2){
		$("#p_hylbdm").setValue($("#p_hylbdm").find("option:nth(1)").val());
		//$("#p_hylbdm").setAttr("readonly",true);
		if($("#p_hylbdm").attr("value")=="A"){
			$("#p_ywlbdm").selectBox({code:"dm_ywlb"}); // 业务类别选择框		
		}else if($("#p_hylbdm").attr("value")=="N"){
			$("#p_ywlbdm").selectBox({code:"dm_nbdw_hyfl"}); // 业务类别选择框		
		}else{
			//$("#p_ywlbdm").find("option:not(option[value=''])").remove(); // 业务类别选择框
			 var roptions=$("#p_ywlbdm").find("option").length;
				  var delid=0;
				  for (var a=0;a<roptions;a++){
					  if ($("#p_ywlbdm").find("option").eq(a).val()!=''){
					  	$("#p_ywlbdm").get(0).options.remove(delid);
					  }else
						delid=1;  
				  }
			$("#p_ywlbdm").selectBox({state:"dm_ywlb"}); // 业务类别选择框
		}
	}
	
	$("#p_hylbdm").change(function(){
		if($("#p_hylbdm").attr("value")=="A"){
			$("#p_ywlbdm").selectBox({code:"dm_ywlb"}); // 业务类别选择框		
		}else if($("#p_hylbdm").attr("value")=="N"){
			$("#p_ywlbdm").selectBox({code:"dm_nbdw_hyfl"}); // 业务类别选择框		
		}else{
			//$("#p_ywlbdm").find("option:not(option[value=''])").remove(); // 业务类别选择框
			 var roptions=$("#p_ywlbdm").find("option").length;
				  var delid=0;
				  for (var a=0;a<roptions;a++){
					  if ($("#p_ywlbdm").find("option").eq(a).val()!=''){
					  	$("#p_ywlbdm").get(0).options.remove(delid);
					  }else
						delid=1;  
				  }
			$("#p_ywlbdm").selectBox({state:"dm_ywlb"}); // 业务类别选择框
		}
	});
	
	
	   
	daggleDiv("bjxxb_detail");
}); 

function getObject(obj){
	sFlag="false";
	//alert($(obj).attr("id")+"="+$(obj).text());
	if($(obj).text()=="派警"){
		xbj($(obj).attr("id").substr(1,$(obj).attr("id").length-1));
	}
	if($(obj).text()=="回复"){
		var id = $(obj).attr("id").substr(1,$(obj).attr("id").length-1);
		if($("#"+id).find("td").eq(3).text()=="<%=user.getDepartment().getDepartname()%>"){
			cjhf(id);
		}else{
			return false;
		}
	}
	if($(obj).text()=="修改回复"){
		cjhf($(obj).attr("id").substr(1,$(obj).attr("id").length-1));
	}
	if($(obj).text()=="无效报警"){
		wxbj($(obj).attr("id").substr(1,$(obj).attr("id").length-1));
	}
}

function xbj(id){
	$("#current_recordBjlx").attr("value",$("#BjxxbData").find("tr[id='"+id+"']").find("td").eq(5).text()); //保存本记录的报警类型
	$("#q_idcard").attr("value",$("#BjxxbData").find("tr[id='"+id+"']").find("td").eq(1).text()); //保存本记录的身份证号码
	$("#m_bjxxid").attr("value",id); // 保存本记录的报警信息id

	sFlag="false";
	setWidth(detailid,modWidth);

	$("#bjxxb_detail").empty();
	$("#bjxxb_detail").load("basic/basicsystem/BjxxXbj.jsp");
	$("#bjxxb_detail").show("slow"); 
   
	bindDocument("bjxxb_detail");

	//alert($("#current_recordBjlx").attr("value"));
	//alert($("#current_bjxxid").attr("value"));
	//alert($("#m_bjxxid").attr("value"));
}

function wxbj(id){
	$("#current_recordBjlx").attr("value",$("#BjxxbData").find("tr[id='"+id+"']").find("td").eq(5).text()); //保存本记录的报警类型
	$("#q_idcard").attr("value",$("#BjxxbData").find("tr[id='"+id+"']").find("td").eq(1).text()); //保存本记录的身份证号码
	$("#m_bjxxid").attr("value",id); // 保存本记录的报警信息id

	sFlag="false";
	setWidth(detailid,modWidth);

	$("#bjxxb_detail").empty();
	$("#bjxxb_detail").load("basic/basicsystem/BjxxWxbjDetail.jsp");
	$("#bjxxb_detail").show("slow"); 
   
	bindDocument("bjxxb_detail");
}

function detail(id){
	$("#current_recordBjlx").attr("value",$("#BjxxbData").find("tr[id='"+id+"']").find("td").eq(5).text()); //保存本记录的报警类型
	$("#q_idcard").attr("value",$("#BjxxbData").find("tr[id='"+id+"']").find("td").eq(1).text()); //保存本记录的身份证号码
	$("#m_bjxxid").attr("value",id); // 保存本记录的报警信息id

	sFlag="false";
	setWidth(detailid,modWidth);

	$("#bjxxb_detail").empty();
	$("#bjxxb_detail").load("basic/basicsystem/BjxxDetail.jsp");
	$("#bjxxb_detail").show("slow"); 
   
	bindDocument("bjxxb_detail");
}

function cjhf(id){
	$("#current_recordBjlx").attr("value",$("#BjxxbData").find("tr[id='"+id+"']").find("td").eq(5).text()); //保存本记录的报警类型
	$("#q_idcard").attr("value",$("#BjxxbData").find("tr[id='"+id+"']").find("td").eq(1).text()); //保存本记录的身份证号码
	$("#m_bjxxid").attr("value",id); // 保存本记录的报警信息id

	sFlag="false";
	setWidth(detailid,modWidth);

	$("#bjxxb_detail").empty();
	$("#bjxxb_detail").load("basic/basicsystem/BjxxCjhf.jsp");
	$("#bjxxb_detail").show("slow"); 
   
	bindDocument("bjxxb_detail");
}



function setPageList(pageno,url){
	//if(url!='#')
	if (manVerify()){
		url=setList(pageno,url);
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										height: pageHeight-280,
										ingridPageParams:sXML,
										changeHref:function(table){
											var deptLevel = "<%=user.getDepartment().getDepartlevel().intValue()%>";
											if(deptLevel=="5") { // 派出所
												table.find("a").each(function(){
													var aText = $(this).text();
													if(aText=='派警')
														$(this).text("");
												});
											}
										},
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
												if($(tr).find("td").index(this)!=9){
													detail($(tr).attr("id")); 
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
										onRowSelect: null,
										//onRowSelect: function(tr, selected){
											//detail($(tr).attr("id")); 				
											//rowselect=$(tr).attr('rowindex');
										//},
										pageNumber: pageno,
										
										colWidths: ["11%","14%","11%","11%","12%","11%","10%","11%","11%","11%"]									
									});				
		}
}
function getQyDetail1(obj){
	//dataid = "";
	//detailUrl="lgyzagl/query_lvguan.action";
	//ylcsjbxx_requestType="detail";
	//ylcsjbxx_dataid=$(obj).find("input[name='cs"+$(obj).attr("id")+"']").val();
	
//	lvguanbianm = $(obj).find("input[name='cs"+$(obj).attr("id")+"']").val();
	
//	setWidth("lvguan_detail",modWidth);
//	var CsHtml = "business/Lgyzagl/LvguanDetail.jsp";
//	setUrl("lvguan_detail",CsHtml);
//	var ylcsjbxx_detailidOffset = $("#lvguan_detail").offset();
//	ylcsjbxx_detailidTopOffset=ylcsjbxx_detailidOffset.top;
//	ylcsjbxx_detailidLeftOffset=ylcsjbxx_detailidOffset.left;
//	sFlag="false";
   var hylbdm = $(obj).find("input[name='hylbdm"+$(obj).attr("id")+"']").val();
 // alert(hylbdm);
   if(hylbdm == "A")
   {
	   setWidth(detailid,modWidth);
		$("#bjxxb_detail").empty();
		$("#bjxxb_detail").load("basic/basicsystem/BjxxCjhf.jsp");
		$("#bjxxb_detail").show("slow");
   }
   if(hylbdm == "J")
   {
	   setWidth(detailid,modWidth);
		$("#bjxxb_detail").empty();
		$("#bjxxb_detail").load("basic/basicsystem/BjxxCjhf.jsp");
		$("#bjxxb_detail").show("slow");
   }
   
	bindDocument("bjxxb_detail");
}	
	function manVerify(){
		if (!checkControlValue("p_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_gmsfhm","String",1,18,null,0,"证件号码"))
			return false;
		if (!checkDateEarlier("p_bjsj1","报警时间（开始）","p_bjsj1","报警时间（结束）"))
			return false;
		if(!dateTimeCompare("p_bjsj1","p_bjsj2","报警时间")){
         return false;
     	}			
		return true;
	}
	
	//导出Excel
function setExportExcel(){	
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
			var bbmc="报警信息";
		//报表请求
			//setExcel("gnlkexcel",bbmc);	
			setExcelLong("bjxxExcel",bbmc);	
}

function querybj(){
   if (!checkControlValue("p_hylbdm","Select",1,100,null,1,"行业类别"))
			return false;
	if($("#s_gxdwmc").val()==""){
		$("#p_gxdwbm").val("");
		$("#p_gxdwlevel").val("");
	}
    setPageList(1);
}
</script>
<html>
	<body>
	<input type="hidden" id="p_gxdwlevel">
	<input type="hidden" id="p_isleaf">
	    <input type="hidden" id="q_idcard">
		<input type="hidden" id="current_recordBjlx" value="">
		<%-- 当前选择的记录的报警类型，用来给子div用 --%>
		<input type="hidden" id="current_bjxxid" value="">
		<%-- 当前选择的记录的报警信息ID，用来给子div用 --%>
		<input type="hidden" id="m_bjxxid" value="">
		<%-- 当前选择的记录的报警信息ID，用来给子div用 --%>
		<table width="100%" cellpadding="0" cellspacing="0"
			class="tableborder">
			<tr>
				<td class="queryfont">
					报警信息查询
				</td>
			</tr>
			<tr>
				<td class="tdbg">
					<table width="100%" border="0" cellspacing="0" cellpadding="2">
						<tr>
							<td width="5%" class="pagedistd">
								姓名
							</td>
							<td width="21%" class="pagetd">
								<input type="text" class="inputstyle"  id="p_xm" value="">
							</td>
							<td width="9%" class="pagedistd">
								证件号码
							</td>
							<td width="17%" class="pagetd">
								<input type="text" class="inputstyle"  id="p_gmsfhm" value="">
							</td>
							<td width="8%" class="pagedistd">
								行业类别
							</td>
							<td width="17%" class="pagetd">
								<select type="select" id="p_hylbdm">
								</select>
							</td>
							<td width="8%" class="pagedistd">
								业务类别
							</td>
							<td width="16%" class="pagetd">
								<select type="select" id="p_ywlbdm">
									<option></option>
								</select>
							</td>
						</tr>
						<tr>
							<td  class="pagedistd">
								企业名称
							</td>
							<td  class="pagetd">
								<input type="text" class="inputstyle"  id="p_ssqymc" value="">
							</td>
							<td class="pagedistd">
								治安管辖机构
							</td>
							<td class="pagetd">
								<input type="hidden" id="p_gxdwbm" value="">
								<input type="text" class="inputstyle"  id="s_gxdwmc" value="">
							</td>
							<td class="pagedistd">
								报警时间
							</td>
							<td  class="pagetd">
								<input type="text" class="inputstyle"  id="p_bjsj1" value="">
							</td>
							<td class="pagedistd">
								至
							</td>
							<td  class="pagetd">
								<input type="text" class="inputstyle"  id="p_bjsj2" value="">
							</td>
						</tr>
						<tr>
							<td class="pagedistd">
								处警结果
							</td>
							<td  class="pagetd">
								<%-- <input type="hidden" id="p_chjjg" value="">  --%>
								<select type="select" id="p_cjjgdm" value="">
									<option></option>
								</select>
							</td>
							<td class="pagedistd">
								报警类型
							</td>
							<td class="pagetd">
							<%-- <input type="hidden" id="p_bjlx" value=""> --%>
								<select type="select" id="p_bjlxdm" value="">
									<option></option>
								</select>
							</td>
							<td class="pagedistd">
								出警部门
							</td>
							<td  class="pagetd">
								<input type="hidden" id="p_cjbmbm" value="">
								<input type="text" class="inputstyle"  id="s_cjbm" value="">
							</td>
							<td  class="pagedistd">
								派警部门
							</td>
							<td  class="pagetd">
								<input type="hidden" id="p_pjbmbm" value="">
								<input type="text" class="inputstyle"  id="s_pjbmmc" value="">
							</td>
						</tr>
						<tr>
							<td  class="pagedistd">
								警情状态
							</td>
							<td  class="pagetd">
								<%-- <input type="hidden" id="p_jqzt" value=""> --%>
								<select type="select" id="p_jqztdm" value="">
									<option></option>
								</select>
							</td>
							<td  class="pagedistd">
								警情是否有效
							</td>
							<td  class="pagetd">
								<%-- <input type="hidden" id="p_sfyxbj" value=""> --%>
								<select type="select" id="p_sfyxbjdm">
									<option></option>
								</select>
							</td>
							<td colspan="5">
								<table width="150" border="0" align="right" cellpadding="2"
									cellspacing="0">
	  <tr>
										<td width="25%" >
											<a href="#" class="searchbutton" id="querys"
												onClick="querybj();">查询</a>
										</td>
										<td width="25%" >
											<a href="#" class="exceldcbutton" id='bjxxExcel' onclick='setExportExcel();'>导出</a>
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

		<div id="bjxxb_detail"  class="page-layout" src="#"
		style="top: 40px; left: 160px; width: 500px;">
		</div>


<!--Excel表头 
 	name domain的属性以l_开头；
 	datatyoe 数据类型 （字符 string,数字 number,日期 date）;
 	sumflag 0不合计，1合计-->
		<div id="BjxxbData" style="width: 100%;">
			<table id="BjxxbTable" width="100%">
				<thead>
					<tr>
						<th name="l_xm" datatype="string" sumflag="0">
							姓名
						</th>
						<th name="l_gmsfhm" datatype="string" sumflag="0">
							公民身份号码
						</th>
						<th name="l_ssqymc" datatype="string" sumflag="0">
							所属企业名称
						</th>
						<th name="l_gxdwmc" datatype="string" sumflag="0">
							治安管辖机构名称
						</th>
						<th name="l_bjsj" datatype="string" sumflag="0">
							报警时间
						</th>
						<th name="l_bjlx" datatype="string" sumflag="0">
							报警类型
						</th>
						<th name="l_sfyxbj" datatype="string" sumflag="0">
							警情是否有效
						</th>
						<th name="l_jqzt" datatype="string" sumflag="0">
							警情状态
						</th>
						<th name="l_chjjg" datatype="string" sumflag="0">
							处警结果
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