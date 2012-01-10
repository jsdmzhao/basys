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
	pageUrl="publicsystem/querylist_publicwgcyryxx.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="publicsystem/insert_publicwgcyryxx.action";
	addHtml="basic/publicsystem/WgcyryxxAdd-gzth.jsp";
	addWidth="800";
	delUrl="publicsystem/delete_qyryxx.action";
	delid="d_ryid";
	modHtml="basic/publicsystem/WgcyryxxModify-gzth.jsp";
	modUrl="publicsystem/modify_publicwgcyryxx.action";
	modWidth="800";
	detailHtml="basic/publicsystem/WgcyryxxDetail-gzth.jsp";
	detailid="wgcyryxx_detail";
	detailUrl="publicsystem/query_publicwgcyryxx.action";
	detailWidth="800";
	
	//$("#p_cjsjf").attr("readonly","true");
	//$("#p_cjsjf").datepicker();
	//$("#p_cjsjt").attr("readonly","true");
	//$("#p_cjsjt").datepicker();
	$("#p_xbdm").selectBox({code:"dm_xb"});
	//$("#p_gwbh").selectBox({code:"dm_cyrylb"});
	//gy_getselectBox("p_gwbh");
  	//	if($('#gy_hylbdm').val()=='J'){
 	//		$("#p_zt").selectBox({code:"dm_jlzt"});
	// 	}else{
	$("#p_zt").selectBox({code:"dm_jlzt(public)"});
	// 	}
  	
	//导出功能
	tabletitle = "";
	geteExcelHead("tabledata");
	//ExcelURL
	excelUrl="publicsystem/excelCreate_publicwgcyryxx.action";
	loadPage("tabledata");
	daggleDiv("wgcyryxx_detail");
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML,
										ingridPageWidth: pageWidth,
										url: url,	
										height: pageHeight-232,
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
										hideColIndex:[6],	
										colWidths: ["14%","10%","14%","7%","10%","14%","0%","7%","10%","14%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_cyrybh","String",1,30,null,0,"从业人员编号"))
			return false;
		if (!checkControlValue("p_ywx","String",1,60,null,0,"英文姓"))
			return false;
		if (!checkControlValue("p_ywm","String",1,60,null,0,"英文名"))
			return false;
		//if (!checkControlValue("p_csmc","String",1,40,null,0,"场所名称"))
		//	return false;
		if (!checkControlValue("p_zjhm","String",1,20,null,0,"护照号"))
			return false;
			
		//var cjsjf = $("#p_cjsjf").val();
		//var cjsjt = $("#p_cjsjt").val();
		//if(cjsjf!=null && cjsjf!="" && cjsjt!=null && cjsjt!=""){
		//	if(cjsjf>cjsjt){
		//		jAlert("采集时间必须大于采集时间至","验证信息",null,"p_cjsjf");
		//		return false;
		//	}
		//}
		
		return true;
	}
	
$("#p_gj").click(function(){
	getDict_item("p_gj","p_gjdm","dm_gj(lgy)");
});

function setDelete(id){
	sFlag="false";
	jConfirm('确定删除吗？', '删除提示', function(r) {
    	if(r==true){
			var rylbInput = $("#grid").find("tr[id='"+id+"']").find("input[name='cs"+id+"']");
			var rylbValue = rylbInput.val();
			$("#d_csid").val(rylbValue);
			$("#"+delid).attr("value",id);
			setParams("d_");
	        jQuery.post(delUrl,params,deleteback,"json");
		}else{
		   return false;
		}
	});
}

function updateCs(id){
	detailUrl="ylfwzagl/query_wgcyryxx.action";
	dataid=id;
	setWidth(detailid,modWidth);
	setUrl(detailid,"business/Ylfwzagl/WgcyryxxcsDetail.jsp");
	bindDocument(detailid);
}

function getDetail(id){
	detailUrl="ylfwzagl/query_wgcyryxx.action";
	setQuery(id,detailHtml,detailWidth);
	bindDocument(detailid);
}

function updateZp(id){
	//detailUrl="ylfwzagl/query_wgcyryxx.action";
	dataid=id;
	setWidth(detailid,modWidth);
	setUrl(detailid,"basic/publicsystem/WgcyryxxzpDetail.jsp");
	bindDocument(detailid);
}
	
function updateWgcyryxx(id){
	detailUrl="ylfwzagl/query_wgcyryxx.action";
	dataid=id;
	sFlag="false";
	setWidth(detailid,modWidth);
	setUrl(detailid,modHtml);
	bindDocument(detailid);
}
	
	
$("#p_csmc").click(function(){
	getYlcs_item("p_csmc","");
});

//高级查询
function getGaoJiChaXun(){
	//sjbid:数据表id;loadDiv:加载高级查询页面的div
	// gaojichaxun(sjbid,loadDiv);
	gaojichaxun("61,48,44",detailid);
}

function setExportExcel(){
	if(exportState){
		if (manVerify()){
			//报表标题
			var bbmc="境外从业人员信息查询";
			//报表请求
			setExcel("wgcyryexcel",bbmc);	
		 }
	}else{
		jAlert("请先查询数据","提示信息");
	}
}
 //从业人员体检信息
function detailTjxx(id){
	detailHeight=$("#"+detailid).css("height");
	//bindDocument(detailid);
	dataid_cyryCsid = $("#tabledata").find("tr[id='"+id+"']").find("input[id='qyid']").val();
	dataid=id;
	sFlag="false";
	setWidth(detailid,modWidth);
	setUrl(detailid,"basic/publicsystem/Cyry_tjxxMan.jsp");
	var cyrytjxx_detailidOffset = $("#"+detailid).offset();	
	//detailidTopOffset=cyrytjxx_detailidOffset.top;
	//detailidLeftOffset=cyrytjxx_detailidOffset.left;
	bindDocument(detailid);
}
</script>

 
 
	
	<input type="hidden" id="d_ryid" value="">
	<input type="hidden" id="d_csid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">境外从业人员管理</td>
  </tr>
  <tr>
    <td valign="top" class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="2">
      <tr>
        <td width="9%" class="pagedistd">英文姓</td>
        <td width="18%" class="pagetd"><input type="text" class="inputstyle" id="p_ywx" /></td>
        <td width="10%" class="pagedistd">英文名</td>
        <td width="17%" class="pagetd"><input type="text" class="inputstyle" id="p_ywm" /></td>
        <td width="6%" class="pagedistd">性别</td>
        <td width="16%" class="pagetd">
        <select id="p_xbdm">
        	<option></option>
        </select></td>
        <td width="7%" class="pagedistd">记录状态</td>
        <td width="17%" class="pagetd"> <select id="p_zt">
        	<option></option>
        </select></td>
      </tr>
      <tr>
        <td width="9%" class="pagedistd">国籍</td>
        <td width="18%" class="pagetd">
			<input type="text"  id="p_gj" class="inputstyle" readonly /><input type="hidden" id="p_gjdm" />		</td>
        <td width="10%" class="pagedistd">从业人员编号</td>
        <td width="17%" class="pagetd"><input type="text" class="inputstyle" id="p_cyrybh"></td>
        <td width="6%" class="pagedistd">护照号</td>
        <td width="16%" class="pagetd"><input type="text" class="inputstyle" id="p_zjhm" value=""></td>
        <!-- <td width="7%" class="pagedistd">岗位类别</td>
        <td width="17%" class="pagetd">
        	<select id="p_gwbh">
        		<option></option>
       		</select>       	</td>
       		 -->
        <td colspan="2">
        <table width="200" border="0" align="right" cellpadding="2" cellspacing="0">
         <tr>
                     <td ><a href="#" class="searchbutton"  id="querys" onClick="setPageList(1);">查询</a></td>
                     <td ><a href="#" class="submitbutton"   onclick='setAddPage()'>新增</a></td>
                     <td><a href="#" class="exceldcbutton" onClick="setExportExcel()" id="wgcyryexcel">导出</a></td>
                   </tr>
         </table>        </td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
	</tr>
</table>
<div id="wgcyryxx_detail"  class="page-layout" src="#"
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
	     	<th name="l_zjhm" datatype="string" sumflag="0">护照号</th>
	     	<th name="l_xb" datatype="string" sumflag="0">性别</th>
	     	<th name="l_gj" datatype="string" sumflag="0">国籍</th>
	     	<th name="l_qymc" datatype="string" sumflag="0">企业名称</th>
	     	<th name="l_gwmc" datatype="string" sumflag="0">岗位类别</th>
	     	<th name="l_zt" datatype="string" sumflag="0">状态</th>
	     	<th name="l_cyryzt" datatype="string" sumflag="0">从业人员状态</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>

 