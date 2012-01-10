<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var dataid_cyryCsid;
var currPageHeight = pageHeight-251;
//离线页面高度
if($("#offineFlag").attr("value")=='1'){
	currPageHeight = pageHeight-182;
}

$(document).ready(function() {
	pageUrl="publicsystem/querylistCs_publicwgcyryxx.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="ylfwzagl/insert_publicwgcyryxx.action";
	addHtml="basic/publicsystem/WgcyryxxAdd-gzth.jsp";
	addWidth="800";
	delUrl="ylfwzagl/delete_publicwgcyryxx.action";
	delid="d_ryid";
	modHtml="basic/publicsystem/WgcyryxxModify-gzth.jsp";
	modUrl="publicsystem/modify_publicwgcyryxx.action";
	modWidth="800";
	detailHtml="basic/publicsystem/WgcyryxxDetail-gzth.jsp";
	detailid="wgcyryxx_detail";
	detailUrl="publicsystem/query_publicwgcyryxx.action";
	detailWidth="800";
	loadPage("tabledata");
  	$("#p_xbdm").selectBox({code:"dm_xb"});
  	// 行业类别	
	$("#p_hylbdm").selectBoxhylb({code:"ggmk"});
 	//$("#p_cylbdm").selectBox({code:"dm_cyrylb"});
 	//hy_gwselectBox("p_hylbdm","p_gwbh");
    //$('#p_hylbdm').change(function(){
 	//	hy_gwselectBox("p_hylbdm","p_gwbh");
 	//});
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
										onRowSelect: null,
										colClasses: ['grid-col-style2','grid-col-style2'],
										colIndex: [1,2],
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
													var tdnum = $(tr).find("td").index(this);
													if(tdnum!=$(tr).find("td").length-1){
															seWgcyryXq($(tr).attr("id")); 	
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
										height:currPageHeight ,
										pageNumber: pageno,
										hideColIndex:[5,9,10],	
										colWidths: ["20%","12%","6%","12%","20%","0%","10%","10%","10%","0%","0%"]									
									});				
		}
}	
	
//境外从业人员详情
function seWgcyryXq(id){
	dataid=id;
	setWidth(detailid,detailWidth);
	setUrl(detailid,detailHtml);
	bindDocument(detailid);
}

//从业人员修改
function updateWgyryxx(id){
	detailUrl="publicsystem/query_publicwgcyryxx.action";
	dataid=id;
	sFlag="false";
	setWidth(detailid,modWidth);
	setUrl(detailid,modHtml);
	bindDocument(detailid);
}

var detailHeight,detailidTopOffset,detailidLeftOffset;
//境外从业人员体检信息
function detailTjxx(id){
	detailHeight=$("#"+detailid).css("height");
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

function manVerify(){
	return true;
}
	
//国籍筛选框
$("#p_gj").click(function(){
	getDict_item("p_gj","p_gjdm","dm_gj(lgy)");
});
	
</script>

<body>
	
	<input type="hidden" id="d_ryid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">境外人员查询</td>
  </tr>
  <tr>
    <td valign="top" class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">英文名</td>
			      <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_ywm" /></td>
			      <td width="10%" class="pagedistd">英文姓</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_ywx" /></td>
				  <td width="10%" class="pagedistd">护照号</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_zjhm" />	  </td>
		  </tr>
				<tr>
				<td width="10%" class="pagedistd">行业类别</td>
			      <td width="27%" class="pagetd"><select name="cylb" id="p_hylbdm">
				    </select></td>
			      <!-- <td width="10%" class="pagedistd">岗位类别</td>
				  <td width="25%" class="pagetd"><select name="cylb" id="p_gwbh">
				    <option></option></select></td>
				     -->
				     <td width="10%" class="pagedistd"> 性别</td>
				  <td width="23%" class="pagetd">  <select name="select2"  id="p_xbdm"><option></option>
		          </select> </td>
				  <td width="10%" class="pagedistd">国籍</td>
				  <td width="23%" class="pagetd"><input type="hidden" id="p_gjdm" /><input type="text" class="inputstyle"  id="p_gj" readonly></td>
		  </tr>
				<tr>
					<td width="10%" class="pagedistd">从业人员编号</td>
			      <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_cyrybh" /></td>
			      <td width="10%" class="pagedistd">&nbsp;</td>
		          <td width="23%" class="pagetd">&nbsp;</td>
				  <td width="10%" class="pagedistd">&nbsp;</td>
				  <td width="23%" class="pagetd">
                  <table width="62" border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
                      <td ><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
                    </tr>
                </table>
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
<div id="wgcyryxx_detail"  class="page-layout" src="#"
		style="top:20px; left:160px; width:500px;">
</div>	

<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_xm">英文名/英文姓</th>
	     	<th name="l_zjhm">护照号码</th>
	     	<th name="l_xb">性别</th>
	     	<th name="l_mingzu">国籍</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_gwmc">岗位类别</th>
	     	<th name="l_zcsj">注册时间</th>
	     	<th name="l_zcsj">状态</th>
	     	<th name="l_cyryzt">从业人员状态</th>
	     	<th name="l_cyryztdm"></th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div> 
</body>