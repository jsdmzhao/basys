<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="publicsystem/querylistGadsc_publicwgcyryxx.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="ylfwzagl/insert_wgcyryxx.action";
	addHtml="business/Ylfwzagl/CyryxxAdd.jsp";
	addWidth="800";
	delUrl="ylfwzagl/delete_wgcyryxx.action";
	delid="d_ryid";
	modHtml="business/Ylfwzagl/CyryxxModify.jsp";
	modUrl="ylfwzagl/modify_wgcyryxx.action";
	modWidth="500";
	detailHtml="basic/publicsystem/WgcyryxxDetail-gzth.jsp";
	detailid="wgcyryxx_detail";
	detailUrl="publicsystem/query_publicwgcyryxx.action";
	detailWidth="800";
	loadPage("tabledata");
	$("#p_csrq").attr("readonly","true");
	$("#p_csrq").datepicker();
		
  	$("#p_xbdm").selectBox({code:"dm_xb"});
 	//$("#p_cylbdm").selectBox({code:"dm_cyrylb"});
 	//hy_gwselectBox("p_hylbdm","p_gwbh");
    //$('#p_hylbdm').change(function(){
 	//	hy_gwselectBox("p_hylbdm","p_gwbh");
 	//});
 	// 行业类别	
		$("#p_hylbdm").selectBoxhylb({code:"ggmk"});
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
										height: pageHeight-280,
										pageNumber: pageno,
										sorting: true,
										onRowSelect:function(tr,selected){
											setWgcyryXq($(tr).attr("id"));
										},
										hideColIndex: [6],
										colWidths: ["10%","12%","12%","8%","12%","20%","0%","8%","8%","10%"]									
									});				
		}
}	
	function manVerify(){
		return true;
	}
	
	
//国籍筛选框
$("#p_gj").click(function(){
	getDict_item("p_gj","p_gjdm","dm_gj(lgy)");
});

//服务场所筛选框
 $("#p_qymc").click(function(){
 	dataid=$('#p_hylbdm').val();
	getTy_item("p_qymc","p_qybm");
});
//从业人员详情
function setWgcyryXq(id){
	dataid=id;
	setWidth(detailid,detailWidth);
	setUrl(detailid,detailHtml);
	bindDocument(detailid); 
}
	
//高级查询
function getGaoJiChaXun(){
	//sjbid:数据表id;loadDiv:加载高级查询页面的div
	// gaojichaxun(sjbid,loadDiv);
	gaojichaxun("61,48,44",detailid);
}
</script>

<body>
	
	<input type="hidden" id="d_ryid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">境外人员删除查询</td>
  </tr>
  <tr>
    <td valign="top" class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">英文姓</td>
			      <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_ywx" /></td>
			      <td width="10%" class="pagedistd">证件号码</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_zjhm" /></td>
				  <td width="10%" class="pagedistd">从业人员编号</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_cyrybh" /></td>
		  </tr>
				<tr>
					<td width="10%" class="pagedistd">英文名</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_ywm" /></td>
				  <td width="10%" class="pagedistd">出生日期</td>
				  <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_csrq" /></td>
				  <td width="10%" class="pagedistd">企业名称</td>
				  <td width="23%" class="pagetd"><input type="hidden" id="p_qybm" /><input type="text" id="p_qymc" class="inputstyle" readonly /></td>
		  </tr>
				<tr>
					<td width="10%" class="pagedistd">国籍</td>
			        <td width="23%" class="pagetd"><input type="hidden" id="p_gjdm" /><input type="text" id="p_gj" class="inputstyle" readonly /></td>
		          <td width="10%" class="pagedistd">性别</td>
				  <td width="23%" class="pagetd"><select id="p_xbdm"><option></option>
                  </select></td>
				  <td width="10%" class="pagedistd">从业类别</td>
				  <td width="23%" class="pagetd"><select name="cylb" id="p_hylbdm">
				    </select>  </td>
		  </tr>
          				<tr>
          				 <!--  <td width="10%" class="pagedistd">岗位类别</td>
				  <td width="25%" class="pagetd"><select name="cylb" id="p_gwbh">
				    <option></option></select></td> -->
				     <td width="10%" class="pagedistd">&nbsp;</td>
		          <td width="23%" class="pagetd">&nbsp;</td>
					<td colspan="4"><table width="120" border="0" align="right" cellpadding="2" cellspacing="0">
                      <tr>
                        <td width="52"></td>
                        <td width="68" ><a href="#" class="searchbutton"id="querys2" onClick="setPageList(1);">查询</a></td>
                      </tr>
                    </table></td>
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
	     	<!-- <th name="l_ryid">序号</th> -->
	     	<th name="l_xm">姓名</th>
	     	<th name="l_zjhm">证件号码</th>
	     	<th name="l_cyrybh">从业人员编号</th>
	     	<th name="l_xb">性别</th>
	     	<th name="l_gj">国籍</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_gwmc">岗位类别</th>
	     	<th name="l_zxr">删除人</th>
	     	<th name="l_zxsj">删除时间</th>
	     	<th name="l_cyryzt">从业人员状态</th>
	    </tr>
	  </thead>
	  
	</table>	
</div> 
</body>