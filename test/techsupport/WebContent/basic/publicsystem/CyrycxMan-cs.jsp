<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var dataid_cyryCsid;
var currPageHeight = pageHeight-234;
//离线页面高度
if($("#offineFlag").attr("value")=='1'){
	currPageHeight = pageHeight-165;
}

$(document).ready(function() {
	pageUrl="publicsystem/querylistCs_qyryxx.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="ylfwzagl/insert_cyryxx.action";
	addHtml="business/Ylfwzagl/CyryxxAdd.jsp";
	addWidth="800";
	delUrl="ylfwzagl/delete_cyryxx.action";
	delid="d_ryid";
	modHtml="basic/publicsystem/QyryxxModify.jsp";
	modUrl="publicsystem/modify_qyryxx.action";
	modWidth="800";
	detailHtml="basic/publicsystem/QyryxxDetail-gzth.jsp";
	detailid="cyryxx_detail";
	detailUrl="publicsystem/query_qyryxx.action";
	detailWidth="800";
	loadPage("tabledata");
  	$("#p_xbdm").selectBox({code:"dm_xb"});
  	// 行业类别	
	$("#p_hylbdm").selectBoxhylb();

	daggleDiv("cyryxx_detail");
}); 

function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML,
										ingridPageWidth: pageWidth,
										onRowSelect: null,
										colClasses: ['grid-col-style2','grid-col-style2'],
										colIndex: [1,2],
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
													var tdnum = $(tr).find("td").index(this);
													if(tdnum!=$(tr).find("td").length-1){
															setCyryXq($(tr).attr("id")); 	
													}
											});
										},
										changeHref:function(table){
											$(table).find("tr").each(function(){
												if($(this).find("td:nth(9)").text()==20){
													$(this).find("td:last").text("");
												}
											});
										},
										
										url: url,	
										height: currPageHeight,
										pageNumber: pageno,
										hideColIndex:[5,9,10],	
										colWidths: ["10%","20%","8%","10%","20%","0%","12%","8%","12%","0%","0%"]									
									});				
		}
}	
	function manVerify(){
		return true;
	}
	
	
//从业人员详情
function setCyryXq(id){
	dataid=id;
	setWidth(detailid,detailWidth);
	setUrl(detailid,detailHtml);
	bindDocument(detailid);
}

//从业人员修改
function updateCyryxx(id){
	detailUrl="publicsystem/query_qyryxx.action";
	dataid=id;
	sFlag="false";
	setWidth(detailid,modWidth);
	setUrl(detailid,modHtml);
	bindDocument(detailid);
}

var detailHeight,detailidTopOffset,detailidLeftOffset;
//从业人员体检信息
function detailTjxx(id){
	detailHeight=$("#"+detailid).css("height");
	//bindDocument(detailid);
	dataid_cyryCsid = $("#tabledata").find("tr[id='"+id+"']").find("input[name='ry"+id+"']").val();
	dataid=id;
	sFlag="false";
	setWidth(detailid,modWidth);
	setUrl(detailid,"basic/publicsystem/Cyry_tjxxMan.jsp");
	var cyrytjxx_detailidOffset = $("#"+detailid).offset();	
	detailidTopOffset=cyrytjxx_detailidOffset.top;
	detailidLeftOffset=cyrytjxx_detailidOffset.left;
	bindDocument(detailid);
}
</script>

<body>
	<input type="hidden" id="d_ryid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">国内从业人员管理</td>
  </tr>
  <tr>
    <td valign="top" class="tdbg">
    <table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">行业类别</td>
			      <td width="27%" class="pagetd"><select name="cylb" id="p_hylbdm"> 
				    </select></td>
				  <td width="10%" class="pagedistd">姓名</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_xm" /></td>
				  <td width="10%" class="pagedistd">性别</td>
				  <td width="23%" class="pagetd">
				   <select name="select"  id="p_xbdm"><option></option>
                  </select></td>
		  </tr>
				<tr>
				  <td width="10%" class="pagedistd">公民身份号码</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_zjhm" /></td>
				  <td width="10%" class="pagedistd">&nbsp;</td>
				  <td width="23%" class="pagetd">&nbsp;</td>
				  <td width="10%" class="pagedistd">&nbsp;</td>
				  <td width="23%" class="pagetd">
    		  	<table width="60" border="0" align="right" cellpadding="0" cellspacing="0">
    		    	<tr>
    		    	  <td height="28px"><a href="#"  class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
   		    	  </tr>
   		  	  </table>  </td>
		  </tr>
    	</table>
    </td>
  </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
<div id="cyryxx_detail"  class="page-layout" src="#"
		style="top:20px; left:160px; width:500px;">
</div>	

<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_xm">姓名</th>
	     	<th name="l_zjhm">公民身份证号码</th>
	     	<th name="l_xb">性别</th>
	     	<th name="l_mingzu">民族</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_gwmc">岗位类别</th>
	     	<th name="l_rzrq">注册时间</th>
	     	<th name="l_zt">状态</th>
	     	<th name="l_cyryzt">从业人员状态</th>
	     	<th name="l_cyryztdm"></th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div> 
</body>