<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var exportState = 0;
var dataid_cyryCsid;
var currPageHeight = pageHeight-234;
//离线页面高度
if($("#offineFlag").attr("value")=='1'){
	currPageHeight = pageHeight-165;
}
$(document).ready(function() {
	pageUrl="publicsystem/querylist_qyryxx.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="publicsystem/insert_qyryxx.action";
	addHtml="basic/publicsystem/QyryxxAdd-gzth.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_qyryxx.action";
	delid="d_ryid";
	modHtml="basic/publicsystem/QyryxxModify-gzth.jsp";
	modUrl="publicsystem/modify_qyryxx.action";
	modWidth="800";
	detailHtml="basic/publicsystem/QyryxxDetail-gzth.jsp";
	detailid="cyryxx_detail";
	detailUrl="publicsystem/query_qyryxx.action";
	detailWidth="800";
   
  	$("#p_xbdm").selectBox({code:"dm_xb"});
 	$("#p_zt").selectBox({code:"dm_jlzt(public)"});
 	
	//导出功能
	tabletitle = "";
	geteExcelHead("tabledata");
	loadPage("tabledata");
	//ExcelURL
	excelUrl="publicsystem/excelCreate_qyryxx.action";
	
	daggleDiv("cyryxx_detail");
});

function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML, 
										ingridPageWidth: pageWidth,
										url: url,	
										height: pageHeight-256,
										pageNumber: pageno,
										changeHref:function(table){
											var trList = table.find("tr");
											if(trList.length>0){
												exportState = 1;
											}
											trList.each(function(){
												var trId = $(this).attr("id");
												//删除设置
												var ickslId = $(this).find("input[name='sl"+trId+"']").val();
												var delLink = $(this).find("td:last").find("a:last");
												if(ickslId!=null && ickslId!=""){
													delLink.css("color","black");
													delLink.attr("onclick","");
													delLink.text("");
												}
												//修改设置
												var kaiguan = $(this).find("input[name='zkd"+trId+"']").val();
												var zkzt = $(this).find("input[name='zkzt"+trId+"']").val();
												var ryzt = $(this).find("input[name='ryzt"+trId+"']").val();
												var updLink = $(this).find("td:last").find("a:first");
													if(ryzt==1){
														//只能改服务场所
														//updLink.attr("onclick","updateCs('"+trId+"')");
														updLink.text("");
														updLink.attr("onclick","");
													}else if(ryzt==5){
														//只能改照片
														updLink.attr("onclick","updateZp('"+trId+"')");
													}else if(ryzt==3 || ryzt==4 || ryzt==10 || ryzt==12 || ryzt==13){
														//不能修改
														updLink.text("");
														updLink.attr("onclick","");
													}else if(ryzt==6 || ryzt==7){
															updLink.text("");
															updLink.attr("onclick","");
															delLink.attr("onclick","");
															delLink.text("");
													}
											});
										},
										onRowSelect:null,
										onTdSelect: function(tr){
													$(tr).find("td").click(function(){
														var numIn = $(tr).find("td").index(this);
														if(numIn!=$(tr).find("td").length-1){
															setQuery($(tr).attr("id"),detailHtml,detailWidth); 	
														}
													});	
										},
										hideColIndex:[5],
										colWidths: ["19%","9%","14%","8%","9%","0%","11%","13%","17%"]									
									});			
	}

}	
	function manVerify(){
		if (!checkControlValue("p_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_cyrybh","String",1,20,null,0,"人员编号"))
			return false;
		if (!checkControlValue("p_xbdm","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("p_zjhm","String",1,20,null,0,"公民身份号码"))
			return false;
		if (!checkControlValue("p_zt","String",1,2,null,0,"记录状态"))
			return false;
		return true;
	}

function setDelete(id){
	$("#icksl_detail").hide();
	sFlag="false";
	jConfirm('确定删除吗？', '删除提示', function(r) {
    	if(r==true){
			var rylbInput = $("#grid").find("tr[id='"+id+"']").find("input[name='cs"+id+"']");
			var rylbValue = rylbInput.val();
			$("#d_qyid").val(rylbValue);
			$("#"+delid).attr("value",id);
			setParams("d_");
	        jQuery.post(delUrl,params,deleteback,"json");
		}else{
		   return false;
		}
	});
}

function updateCs(id){
	$("#icksl_detail").hide();
	//detailUrl="ylfwzagl/query_cyryxx.action";
	dataid=id;
	setWidth(detailid,modWidth);
	setUrl(detailid,"basic/publicsystem/CyryxxcsDetail.jsp");
	bindDocument(detailid);
}

function getDetail(id){
	$("#icksl_detail").hide();
	detailUrl="ylfwzagl/query_cyryxx.action";
	setQuery(id,detailHtml,detailWidth);
	bindDocument(detailid);
}

function updateZp(id){
	$("#icksl_detail").hide();
	dataid=id;
	setWidth(detailid,modWidth);
	setUrl(detailid,"basic/publicsystem/CyryxxcsDetail.jsp");
}
function updateCyryxx(id){
	$("#icksl_detail").hide();
	detailUrl="ylfwzagl/query_cyryxx.action";
	dataid=id;
	sFlag="false";
	setWidth(detailid,modWidth);
	setUrl(detailid,"basic/publicsystem/CyryxxcsDetail.jsp");
	bindDocument(detailid);
}

$("#p_csmc").click(function(){
	getYlcs_item("p_csmc","");
});


//高级查询
function getGaoJiChaXun(){
	//sjbid:数据表id;loadDiv:加载高级查询页面的div
	// gaojichaxun(sjbid,loadDiv);
	gaojichaxun("48,44",detailid);
}

function setExportExcel(){
	if(exportState){	
		if (manVerify()){
			//报表标题
			var bbmc="从业人员信息查询";
			//报表请求
			setExcel("cyryxxexcel",bbmc);	
		 }
	 }else{
		jAlert("请先查询数据","提示信息");
	}
 }
 //从业人员体检信息
function detailTjxx(id){
	detailHeight=$("#"+detailid).css("height");
	dataid_cyryCsid = $("#tabledata").find("tr[id='"+id+"']").find("input[id='qyid']").val();
	dataid=id;
	sFlag="false";
	setWidth(detailid,modWidth);
	setUrl(detailid,"basic/publicsystem/Cyry_tjxxMan.jsp");
	var cyrytjxx_detailidOffset = $("#"+detailid).offset();	
	bindDocument(detailid);
}
</script>

<body>
	<input type="hidden" id="d_ryid" value="">
	<input type="hidden" id="d_qyid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">国内从业人员管理</td>
  </tr>
  <tr>
    <td valign="top" class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">姓名</td>
			      <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_xm"/></td>
			      <td width="10%" class="pagedistd">身份证号</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_zjhm"/></td>
					 <td width="10%" class="pagedistd">状态</td>
			      <td width="23%" class="pagetd">
			        <select name="select2"   id="p_zt">
				  	<option></option>
                    </select></td>
		  </tr>
				<tr>
					<td width="10%" class="pagedistd">性别</td>
				  <td width="23%" class="pagetd">
				    <select name="select"  id="p_xbdm">
				  	<option></option>
		          </select></td>
				  <td width="10%" class="pagedistd">人员编号</td>
				  <td width="23%" class="pagetd">
				    <input type="text" class="inputstyle"  id="p_cyrybh"/></td>
				  	<td width="10%" class="pagedistd">&nbsp;</td>
				  <td width="23%" class="pagetd">&nbsp;</td>
		  </tr>
		  <tr>
		    <td width="20%" class="pagetd" colspan="6"><table width="200" border="0" align="right" cellpadding="2" cellspacing="0">
        <tr>
                      <td ><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
                      <td ><a href="#" class="submitbutton"   onclick='setAddPage();'>新增</a></td>
                      <td ><a href="#" class="exceldcbutton" onClick="setExportExcel()" id="cyryxxexcel">导出</a></td>
                    </tr>
                  </table></td>
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
<div id="cyryxx_detail"  class="page-layout" src="#"
		style="top:20px; left:160px; width:500px;">
</div>	
<div id="icksl_detail"  class="page-layout" src="#"
		style="display:none;top:20px; left:160px; width:500px;">
</div>	
<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_cyrybh" datatype="string" sumflag="0">人员编号</th>
	     	<th name="l_xm" datatype="string" sumflag="0">姓名</th>
	     	<th name="l_zjhm" datatype="string" sumflag="0">身份证号</th>
	     	<th name="l_xb" datatype="string" sumflag="0">性别</th>
	     	<th name="l_minzu" datatype="string" sumflag="0">民族</th>
	     	<th name="l_gwmc" datatype="string" sumflag="0">岗位类别</th>
	     	<th name="l_zt" datatype="string" sumflag="0">状态</th>
	     	<th name="l_cyryzt" datatype="string" sumflag="0">从业人员状态</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>