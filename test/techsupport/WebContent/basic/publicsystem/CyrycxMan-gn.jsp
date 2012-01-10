<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/dictDropDown.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery.mypagination.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery.lightbox-0.5.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery.lightbox-0.5.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mypagination.css" type="text/css"></link>
<script type="text/javascript">
rows = Math.ceil(pageHeight/22);
var rowOfNum = Math.round(pageWidth/160);
var gzrzPageDiv = "cyryxx_detail";
$(document).ready(function() {
	pageUrl="publicsystem/querylistGad_qyryxx.action";
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
	detailHtml="basic/publicsystem/QyryxxDetail-gzth.jsp";
	detailid="cyryxx_detail";
	detailUrl="publicsystem/query_qyryxx.action";
	detailWidth="800";
	loadPage("tabledata");
		$("#p_csrq").attr("readonly","true");
		$("#p_csrq").datepicker();
		
  	$("#p_xbdm").selectBox({code:"dm_xb"});
 	//$("#p_cylbdm").selectBox({code:"dm_cyrylb"});
 	//hy_gwselectBox("p_hylbdm","p_gwbh");
 	// 行业类别	
		$("#p_hylbdm").selectBoxhylb({code:"ggmk"});
  	$("#p_zxbz").selectBox({code:"dm_cszt"});
  	$("#p_sfyzp").selectBox({state:"1"});
  	$("#imageList").hide();
			
	daggleDiv("cyryxx_detail");	
}); 

function manVerify(){
/*
	if (!checkControlValue("p_xm","String",1,100,null,0,"姓名"))
		return false;
	if (!checkControlValue("p_zjhm","String",1,20,null,0,"公民身份号码"))
		return false;
	if (!checkControlValue("p_cyrybh","String",1,20,null,0,"从业人员编号"))
		return false;
	if (!checkControlValue("p_kh","String",null,null,null,0,"IC卡卡号"))
		return false;
	if (!checkControlValue("p_csmc","String",1,100,null,0,"服务场所"))
		return false;
	if (!checkControlValue("p_hjdxzqh","String",1,200,null,0,"户籍省县"))
		return false;
	if (!checkControlValue("p_csrq","Date",1,30,null,0,"出生日期"))
		return false;
	if (!checkControlValue("p_gxdw","String",1,100,null,0,"管辖单位"))
		return false;
	if (!checkControlValue("p_sfyzp","String",1,2,null,0,"是否有照片"))
		return false;
	if (!checkControlValue("p_nianlingF","Integer",1,130,null,0,"年龄段开始"))
		return false;
	if (!checkControlValue("p_nianlingT","Integer",1,130,null,0,"年龄段结束"))
		return false;
	*/	
	return true;
}
		
function setPageList(pageno,url){
	$("#tabledata").show();
	$("#allImageList").hide();
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		//alert(tables);
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML,
										ingridPageWidth: pageWidth,
										url: url,	
										height: pageHeight-327,
										extraParams: {dataxml:sXML,pagesize:pageno,pagerow:rows},	
										pageNumber: pageno,
										hideColIndex: [6,9],
										colWidths: ["10%","14%","14%","8%","14%","15%","0%","15%","10%","0%"]									
									});				
		}
}
//照片显示回调方法
function pageImageBack(json){
	$("#imageList").empty();
	var lcyryxx = json.LQyryxx;
	if(lcyryxx.length>0){
		var imageTable = "<table id='imgtable'>";
		imageTable += "<tr>";
		for(var ryNum=0;ryNum<lcyryxx.length;ryNum++){
			var ryid = lcyryxx[ryNum].ryid;
			imageTable += "<td><table>";
			imageTable += "<tr><td><a href='publicsystem/queryTp_qyryxx.action?ryId="+ryid+"' title='' rel='gallery-plants'><img id='img"+ryid+"' src='publicsystem/queryTp_qyryxx.action?ryId="+ryid+"' style='border:solid  #999999 1px;' width='140' height='160' /></a></td></tr>";
			imageTable += "<tr><td><a href='#' class='fontbutton1' onclick='setCyryXq("+lcyryxx[ryNum].ryid+");'>"+lcyryxx[ryNum].cyrybh+"</a></td></tr>";
			imageTable += "<tr><td><a href='#' class='fontbutton1' onclick='setCyryXq("+lcyryxx[ryNum].ryid+");'>"+lcyryxx[ryNum].xm+"</a></td></tr>";
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

//从业人员详情
function setCyryXq(id){
	dataid=id;
	setWidth(detailid,detailWidth);
	setUrl(detailid,detailHtml);
	bindDocument(detailid);
}

//从业人员工作日志
var detailHeight,detailidTopOffset,detailidLeftOffset;
function setCyryGzrz(id){
	sFlag = "false";
	detailHeight=$("#"+detailid).css("height");
	dataid=$("#"+id).find("td").eq(2).text();
	setWidth(detailid,detailWidth);
	setUrl(detailid,"business/Ylfwzagl/CyrygzrzMan.jsp");
	var cyryxx_detailidOffset = $("#"+detailid).offset();	
	detailidTopOffset=cyryxx_detailidOffset.top;
	detailidLeftOffset=cyryxx_detailidOffset.left;
	bindDocument(detailid);
}

//从业人员从业轨迹
function setCyryCygj(id){
	sFlag = "false";
	detailHeight=$("#"+detailid).css("height");
	dataid=$("#"+id).find("td").eq(1).text();
	setWidth(detailid,detailWidth);
	setUrl(detailid,"business/Ylfwzagl/CyrycygjMan.jsp");
	var cyryxx_detailidOffset = $("#"+detailid).offset();	
	detailidTopOffset=cyryxx_detailidOffset.top;
	detailidLeftOffset=cyryxx_detailidOffset.left;
	bindDocument(detailid);
}

function setCyryDy(id){

}

//户籍省县
$("#p_hjdxzqh").click(function(){
	getDict_item("p_hjdxzqh","p_hjdxzqhdm","dm_xzqh");
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

//是否同音设置
$("#p_sfty").click(function(){
	if($(this).attr("checked"))
		$(this).val(1);
	else
		$(this).val(0);
});

//高级查询
function getGaoJiChaXun(){
	//sjbid:数据表id;loadDiv:加载高级查询页面的div
	// gaojichaxun(sjbid,loadDiv);
	gaojichaxun("48,44",detailid);
}
</script>

<body>
	
<input type="hidden" id="d_ryid" value="">
<input type="hidden" id="gzrz_cyrybh" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">国内人员查询</td>
  </tr>
  <tr>
    <td valign="top" class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
				  <td width="9%" class="pagedistd">行业类别</td>
			      <td width="23%" class="pagetd"><select name="cylb" id="p_hylbdm">
				    </select></td>
			     <!--  <td width="9%" class="pagedistd">岗位类别</td>
				  <td width="21%" class="pagetd"><select name="cylb" id="p_gwbh">
				    <option></option></select></td> -->
				      <td class="pagedistd">公民身份号码</td>
		          <td class="pagetd"><input type="text" class="inputstyle" id="p_zjhm" /></td>
				  <td width="10%" class="pagedistd">从业人员编号</td>
				  <td width="28%" class="pagetd"><input type="text" class="inputstyle" id="p_cyrybh" /></td>
		  </tr>
				<tr>
					<td class="pagedistd">状态</td>
				  <td class="pagetd"><select id="p_zxbz" ><option></option></select></td>
				  <td class="pagedistd">性别</td>
				  <td class="pagetd"><select name="select"  id="p_xbdm"><option></option>
                  </select></td>
				  <td class="pagedistd">企业名称</td>
				  <td class="pagetd"><input type="hidden" id="p_qybm" /><input type="text" class="inputstyle" id="p_qymc" readonly /></td>
		  </tr>
				<tr>
					<td class="pagedistd">户籍省县</td>
			        <td class="pagetd"><input type="hidden" id="p_hjdxzqhdm" /><input type="text" id="p_hjdxzqh" readonly class="inputstyle" /></td>
		          <td class="pagedistd">出生日期</td>
				  <td class="pagetd"><input type="text" class="inputstyle" id="p_csrq" /></td>
				  <td class="pagedistd">姓名</td>
				  <td class="pagetd"><input type="text" class="inputstyle" id="p_xm" />
			      <input  type="checkbox" id="p_sfty" value="0" />是否同音 </td>
		  </tr>
				<tr>
				  <td class="pagedistd">管辖单位</td>
		          <td class="pagetd"><input type="text" class="inputstyle" id="p_gxdw" readonly><input type="hidden" id="p_gxdwbm" value=""></td>
		          <td class="pagedistd">是否有照片</td>
		          <td class="pagetd"><select id="p_sfyzp">
                  	<option></option><option value="1">是</option><option value="0">否</option>
                  </select></td>
		        <td width="10%" class="pagedistd">&nbsp;</td>
		    <td width="23%" class="pagetd">&nbsp;</td>
		  </tr>
				<tr>
				  <td class="pagedistd">年龄段</td>
		          <td class="pagetd"><input type="text" class="inputstyle" id="p_nianlingF" /></td>
		          <td class="pagedistd">至</td>
		          <td class="pagetd"><input type="text" class="inputstyle" id="p_nianlingT" /></td>
		          <td class="pagedistd"></td>
		          <td class="pagetd"></td>
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
                     <td ></td>
                     <td >
                     <!--  <a href="#" class="submitbutton" onclick='getGaoJiChaXun();'>高级查询</a>-->
                     <a href="#" class="searchbutton" id="cyry_querys" onClick="setPageList(1);">查询</a>
                     </td>
                   </tr>
         </table>
    </td>
  </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
<div id="cyryxx_detail" class="page-layout" src="#"
		style="display:none; top:20px; left:160px;">
</div>
<!--  
<div id="allImageList">	
<div id="imageList"><div>
<div>-->
<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_xm">姓名</th>
	     	<th name="l_zjhm">公民身份证号码</th>
	     	<th name="l_cyrybh">从业人员编号</th>
	     	<th name="l_xb" nowrap>性别</th>
	     	<th name="l_hjdxzqh">户籍省县</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_gwmc">岗位类别</th>
	     	<th name="l_zt">状态</th>
	     	<th name="l_cyryzt">从业人员状态</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div> 
</body>