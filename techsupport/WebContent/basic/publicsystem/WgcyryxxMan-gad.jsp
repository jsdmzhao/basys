<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
var publicHylbdm="";
	$(document).ready(function() {
		pageUrl="publicsystem/querylistGadGl_publicwgcyryxx.action";
		divnid="tabledata";
		tableid="table1";
		addUrl="publicsystem/insertGad_publicwgcyryxx.action";
		addHtml="basic/publicsystem/WgcyryxxAdd-gad.jsp";
		addWidth="800";
		delUrl="publicsystem/delete_qyryxx.action";
		delid="d_ryid";
		modHtml="basic/publicsystem/WgcyryxxModify-gad-gzth.jsp";
		modUrl="publicsystem/modify_publicwgcyryxx.action";
		modWidth="800";
		detailHtml="basic/publicsystem/WgcyryxxDetail-gzth.jsp";
		detailid="wgcyryxx_detail";
		detailUrl="publicsystem/query_publicwgcyryxx.action";
		detailWidth="800";
		
		
		//hy_gwselectBox("p_hylbdm","p_gwbh");
		loadPage("tabledata");
		$("#p_xbdm").selectBox({code:"dm_xb"});
		// 行业类别	
		$("#p_hylbdm").selectBoxhylb({code:"ggmk"});
		daggleDiv("wgcyryxx_detail");
	});
	
	//$('#p_hylbdm').change(function(){
	//	hy_gwselectBox("p_hylbdm","p_gwbh");
	//});
	$("#p_gj").click(function(){
		getDict_item("p_gj","p_gjdm","dm_gj(lgy)");
	});
	$("#p_csmc").click(function(){
		getYlcs_item("p_csmc","");
	});
	$("#p_qymc").click(function(){ //服务场所筛选框
	 	dataid=$('#p_hylbdm').val();
		getTy_item("p_qymc","p_qybm","","",$("#p_gxdwbm").attr("value"));
	});
	$("#p_gxdw").click(function(){ //管辖单位所筛选框
		$("#p_qybm").attr("value","");
		$("#p_qymc").attr("value","");
		getGxdwTree("p_gxdw","p_gxdwbm",'1');
	});
	
	function setPageList(pageno,url){
		url=setList(pageno,url);
		var mygrid1 = $("#"+tableid).ingrid({
			ingridPageParams:sXML,
			ingridPageWidth: pageWidth,
			url: url,
			height: pageHeight-255,
			pageNumber: pageno,
			onRowSelect:null,
			onTdSelect: function(tr){
				$(tr).find("td").click(function(){
					var numIn = $(tr).find("td").index(this);
					if(numIn!=$(tr).find("td").length-1){
						setQuery($(tr).attr("id"),detailHtml,detailWidth);
					}
				});
			},
			hideColIndex: [6],
			colWidths: ["11%","15%","15%","6%","10%","20%","0%","7%","8%","8%"]
		});
	}

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
	
	function updateWgcyryxx(id){
		dataid=id;
		sFlag="false";
		setWidth(detailid,modWidth);
		setUrl(detailid,modHtml);
		bindDocument(detailid);
	}
	function selectHylbPage(url){
	    setWidth(detailid,addWidth);
	    setUrl(detailid,url);
	    bindDocument(detailid);
	}
</script>
<input type="hidden" id="d_ryid">
<input type="hidden" id="d_csid">
<input type="hidden" id="p_gjdm"/>
<input type="hidden" id="p_gxdwbm">
<input type="hidden" id="p_qybm">

<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
	<tr><td class="queryfont">境外从业人员管理</td></tr>
	<tr>
    <td valign="top" class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td width="8%" class="pagedistd">行业类别</td>
			<td width="17%" class="pagetd"><select type="select" id="p_hylbdm"></select></td>
	        <td width="8%" class="pagedistd">从业人员编号</td>
	        <td width="17%" class="pagetd"><input type="text" class="inputstyle" id="p_cyrybh"></td>
	        <td width="8%" class="pagedistd">管辖单位</td>
			<td width="17%" class="pagetd"><input type="text" class="inputstyle" id="p_gxdw" readonly></td>
			<td width="8%" class="pagedistd">企业名称</td>
			<td width="17%" class="pagetd"><input type="text" class="inputstyle" id="p_qymc" readonly/></td>
		</tr>
		<tr>
	        <td class="pagedistd">英文姓</td>
	        <td class="pagetd"><input type="text" class="inputstyle" id="p_ywx"/></td>
	        <td class="pagedistd">英文名</td>
	        <td class="pagetd"><input type="text" class="inputstyle" id="p_ywm"/></td>
	        <td class="pagedistd">国籍</td>
	        <td class="pagetd"><input type="text" class="inputstyle" id="p_gj" readonly/></td>
	        <td class="pagedistd">护照号</td>
	        <td class="pagetd"><input type="text" class="inputstyle" id="p_zjhm"></td>
		</tr>
		<tr>
	        <td class="pagedistd">性别</td>
	        <td class="pagetd"><select id="p_xbdm"><option></option></select></td>
	        <!-- <td class="pagedistd">岗位类别</td>
	        <td class="pagetd"><select id="p_gwbh"><option></option></select></td> -->
	        <td colspan="6">
	        <table border="0" align="right" cellpadding="1" cellspacing="0">
				<tr>
					<td width="61px"><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
					<td width="61px"><a href="#" class="addbutton" onclick='setAddPage()'>新增</a></td>
				</tr>
			</table></td>
		</tr>
    	</table>
    </td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>

<div id="wgcyryxx_detail"  class="page-layout" src="#" style="top:20px; left:160px; width:500px;"></div>
	
<div id="icksl_detail"  class="page-layout" src="#" style="display:none;top:20px; left:160px; width:500px;"></div>
	
<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	<thead>
	    <tr>       
	     	<th>姓名</th>
	     	<th>护照号</th>
	     	<th>人员编号</th>
	     	<th>性别</th>
	     	<th>国籍</th>
	     	<th>企业名称</th>
	     	<th>岗位类别</th>
	     	<th>状态</th>
	     	<th>人员状态</th>
			<th>操作</th>
	    </tr>
	</thead>
	</table>	
</div>
 