<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/dictDropDown.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery.mypagination.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery.lightbox-0.5.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery.lightbox-0.5.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mypagination.css" type="text/css"></link>
<script type="text/javascript">
rows = Math.ceil((pageHeight-329)/22);
var rowOfNum = Math.round(pageWidth/160);
var gzrzPageDiv = "wgcyryxx_detail";
$(document).ready(function() {
	pageUrl="publicsystem/querylistGad_publicwgcyryxx.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="ylfwzagl/insert_cyryxx.action";
	addHtml="business/Ylfwzagl/CyryxxAdd.jsp";
	addWidth="800";
	delUrl="ylfwzagl/delete_cyryxx.action";
	delid="d_ryid";
	modHtml="business/Ylfwzagl/CyryxxModify.jsp";
	modUrl="ylfwzagl/modify_cyryxx.action";
	modWidth="500";
	detailHtml="basic/publicsystem/WgcyryxxDetail-gzth.jsp";
	detailid="wgcyryxx_detail";
	detailUrl="publicsystem/query_publicwgcyryxx.action";
	detailWidth="800";
	loadPage("tabledata");
		$("#p_cjsjf").attr("readonly","true");
		$("#p_cjsjf").datepicker();
		$("#p_cjsjt").attr("readonly","true");
		$("#p_cjsjt").datepicker();
  	$("#p_xbdm").selectBox({code:"dm_xb"});
 	//$("#p_cylbdm").selectBox({code:"dm_cyrylb"});
  	$("#p_zxbz").selectBox({code:"dm_cszt"});
  	$("#p_sfyzp").selectBox({state:"1"});
	//	hy_gwselectBox("p_hylbdm","p_gwbh");
    //$('#p_hylbdm').change(function(){
 	//	hy_gwselectBox("p_hylbdm","p_gwbh");
 	//});	
 	// 行业类别	
		$("#p_hylbdm").selectBoxhylb({code:"ggmk"});
	daggleDiv("wgcyryxx_detail");	
	daggleDiv("cyryxx_detail");	
}); 
	
function setPageList(pageno,url){	
	$("#tabledata").show();
	$("#allImageList").hide();
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML,
										ingridPageWidth: pageWidth,
										url: url,	
										height: pageHeight-327,
										pageNumber: pageno,
										hideColIndex: [6,9],
										extraParams: {dataxml:sXML,pagesize:pageno,pagerow:rows},	
										colWidths: ["10%","12%","12%","10%","12%","20%","0%","12%","10%","0%"]											
									});				
		}
}	
	function manVerify(){
			
		return true;
	}
	
//照片显示回调方法
function pageImageBack(json){
	$("#imageList").empty();
	var lwgcyryxx = json.LWgcyryxx;
	if(lwgcyryxx.length>0){
		var imageTable = "<table id='imgtable'>";
		imageTable += "<tr>";
		for(var ryNum=0;ryNum<lwgcyryxx.length;ryNum++){
			var ryid = lwgcyryxx[ryNum].ryid;
			imageTable += "<td><table>";
			imageTable += "<tr><td><a href='publicsystem/queryTp_qyryxx.action?ryId="+ryid+"' title='' rel='gallery-plants'><img id='img"+ryid+"' src='publicsystem/queryTp_qyryxx.action?ryId="+ryid+"' style='border:solid  #999999 1px;' width='140' height='160' /></a></td></tr>";
			imageTable += "<tr><td><a href='#' class='fontbutton1' onclick='setWgcyryXq("+lwgcyryxx[ryNum].ryid+");'>"+lwgcyryxx[ryNum].cyrybh+"</a></td></tr>";
			imageTable += "<tr><td><a href='#' class='fontbutton1' onclick='setWgcyryXq("+lwgcyryxx[ryNum].ryid+");'>"+lwgcyryxx[ryNum].xm+"</a></td></tr>";
			imageTable += "</table></td>";
			if(ryNum>0 && (ryNum+1)%rowOfNum==0){
				imageTable += "</tr><tr>";
			}
		}
		imageTable += "</tr></table>";
		$("#imageList").append($(imageTable));
	}
	  $('#imgtable a[rel="gallery-plants"]').lightBox();
	  
	  if($("#mypage").attr("id")==null){
	  	$("#allImageList").append($("<div id='mypage' class='mypagination'></div>"));
	  }
	  
	 $('#mypage').mypagination(json.totalrows,{
	  			perPage:rows,
	  			currPage:json.myPageSize,
				callback:function(page){
					setPageImage(page);
				}
	});
}

//照片显示方法
function setPageImage(pageno,url){
	setParams("p_");
	var imageData = jQuery.extend(params,{pagesize:pageno,pagerow:rows});
	jQuery.post(pageUrl,imageData,pageImageBack,"json");
	$("#imgpageno").val(pageno);
	currPage = pageno;
}

//以列表形式显示
$("#listMethod").click(function(){
	$("#cyry_querys").attr("onclick","");
	$("#cyry_querys").unbind("click");
	$("#cyry_querys").click(function(){setPageList(1);});
	var	imgPageNo = $("#imgpageno").val();
	if(imgPageNo==null || imgPageNo=="")
		imgPageNo = 1;
	setPageList(imgPageNo);
});	

//以照片形式显示
$("#imageMethod").click(function(){
	$("#cyry_querys").attr("onclick","");
	$("#cyry_querys").unbind("click");
	$("#cyry_querys").click(function(){setPageImage(1);});
	//$("#imageList").show();
	$("#tabledata").hide();
	if($("#allImageList").attr("id")==null){
		var imageDiv_height = pageHeight-324+25+25;
		$("#tabledata").after($("<div id='allImageList'><div style='overflow-y:auto;height:"+(imageDiv_height-28)+"px' id='imageList'><div><div>"));
	}else{
		$("#allImageList").show();
	}
	var pageno = $("#pageNo").val();
	if(pageno==null || pageno=="")pageno=1;
	setPageImage(pageno);	
});

//国籍筛选框
$("#p_gj").click(function(){
	getDict_item("p_gj","p_gjdm","dm_gj(lgy)");
});

//服务场所筛选框
 $("#p_qymc").click(function(){
 	dataid=$('#p_hylbdm').val();
	getTy_item("p_qymc","p_qybm");
});

//管辖单位所筛选框
 $("#p_gxdw").click(function(){
	getGxdwTree("p_gxdw","p_gxdwbm",'1');
});

//从业人员详情
function setWgcyryXq(id){
	dataid=id;
	setWidth(detailid,detailWidth);
	setUrl(detailid,detailHtml);
	bindDocument(detailid); 
}

var detailHeight,detailidTopOffset,detailidLeftOffset;
//从业人员工作日志
function setWgcyryGzrz(id){
	sFlag="false";
	detailHeight=$("#"+detailid).css("height");
	$("#gzrz_cyrybh").val($("#"+id).find("td").eq(2).text());
	dataid=$("#"+id).find("td").eq(2).text();
	setWidth("cyryxx_detail",detailWidth);
	setUrl("cyryxx_detail","business/Ylfwzagl/CyrygzrzMan.jsp");
	var cyryxx_detailidOffset = $("#"+detailid).offset();	
	detailidTopOffset=cyryxx_detailidOffset.top;
	detailidLeftOffset=cyryxx_detailidOffset.left;
	bindDocument("cyryxx_detail"); 
}

//从业人员从业轨迹
function setWgcyryCygj(id){
	sFlag="false";
	detailHeight=$("#"+detailid).css("height");
	dataid=$("#"+id).find("td").eq(1).text();
	setWidth(detailid,detailWidth);
	setUrl(detailid,"business/Ylfwzagl/CyrycygjMan.jsp");
	var cyryxx_detailidOffset = $("#"+detailid).offset();	
	detailidTopOffset=cyryxx_detailidOffset.top;
	detailidLeftOffset=cyryxx_detailidOffset.left;
	bindDocument(detailid); 
}
//高级查询
function getGaoJiChaXun(){
	//sjbid:数据表id;loadDiv:加载高级查询页面的div
	// gaojichaxun(sjbid,loadDiv);
	gaojichaxun("61,48,44",detailid);
}
</script>
	
<input type="hidden" id="d_ryid" value="">
<input type="hidden" id="gzrz_cyrybh" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">境外人员查询</td>
  </tr>
  <tr>
    <td valign="top" class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">英文姓</td>
			      <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_ywx" /></td>
<td width="10%" class="pagedistd">行业类别</td>
			      <td width="27%" class="pagetd"><select name="cylb" id="p_hylbdm">
				    </select></td>
			      <!-- <td width="10%" class="pagedistd">岗位类别</td>
				  <td width="25%" class="pagetd"><select name="cylb" id="p_gwbh">
				    <option></option></select></td> -->
				     <td width="10%" class="pagedistd">状态</td>
		          <td width="23%" class="pagetd"><select id="p_zxbz"><option></option></select></td>
		  </tr>
				<tr>
					<td width="10%" class="pagedistd">英文名</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_ywm" /></td>
				  <td width="10%" class="pagedistd">证件号码</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_zjhm" /></td>
				  <td width="10%" class="pagedistd">企业名称</td>
				  <td width="23%" class="pagetd"><input type="hidden" id="p_qybm" /><input type="text" class="inputstyle" id="p_qymc" readonly /></td>
		  </tr>
				<tr>
					<td width="10%" class="pagedistd">国籍</td>
			        <td width="23%" class="pagetd"><input type="hidden" id="p_gjdm" /><input type="text" class="inputstyle" id="p_gj" readonly></td>
		          <td width="10%" class="pagedistd">性别</td>
				  <td width="23%" class="pagetd"><select name="select2" id="p_xbdm"><option></option>
                  </select></td>
				  <td width="10%" class="pagedistd">从业人员编号</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_cyrybh" />  </td>
		 </tr>
				<tr>
				  <td class="pagedistd">管辖单位</td>
		          <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_gxdw" readonly /><input type="hidden" id="p_gxdwbm" /></td>
		          <td width="10%" class="pagedistd">是否有照片</td>
		          <td width="23%" class="pagetd"><select id="p_sfyzp"><option></option><option value="1">是</option><option value="0">否</option>
                  </select></td>
		         <td width="10%" class="pagedistd">&nbsp;</td>
		          <td width="23%" class="pagetd">&nbsp;</td>
		  </tr>
				<tr>
				  <td class="pagedistd">年龄段</td>
		          <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_nianlingF" /></td>
		          <td width="10%" class="pagedistd">至</td>
		          <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_nianlingT" /></td>
		          <td width="10%" class="pagedistd">&nbsp;</td>
		          <td width="23%" class="pagetd">&nbsp;</td>
		  </tr>
    	</table>
    </td>
  </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
   <td align="left" nowrap><input style="width:14px" type="radio" name="radio" id="listMethod" value="0">以列表方式显示 </td>
      <td align="left" nowrap><input style="width:14px" type="radio" name="radio" id="imageMethod" value="1"> 以照片方式显示</td>
    <td width="75%">
      <table width="120" border="0" align="right" cellpadding="2" cellspacing="0">
        <tr>
          <td width="52" ></td>
          <td width="68" >
          <!--  <a href="#" class="submitbutton" id="querys3" onClick="getGaoJiChaXun();">高级查询</a>-->
          <a href="#" class="searchbutton"id="cyry_querys" onClick="setPageList(1);">查询</a>
          </td>
        </tr>
      </table></td>
  </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
<div id="wgcyryxx_detail"  class="page-layout" src="#"
		style="top:20px; left:160px; width:500px;">
</div>	
<div id="cyryxx_detail"  class="page-layout" src="#"
		style="display:none;top:20px; left:160px; width:500px;">
</div>
<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_xm">姓名</th>
	     	<th name="l_zjhm">证件号码</th>
	     	<th name="l_cyrybh">从业人员编号</th>
	     	<th name="l_xb">性别</th>
	     	<th name="l_gj">国籍</th>
	     	<th name="l_csmc">企业名称</th>
	     	<th name="l_gwmc">岗位类别</th>
	     	<th name="l_zt">状态</th>
	     	<th name="l_cyryzt">从业人员状态</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div> 