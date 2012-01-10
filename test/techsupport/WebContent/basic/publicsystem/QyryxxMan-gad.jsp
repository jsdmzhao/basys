<%@ page language="java" pageEncoding="UTF-8"%>

<script type="text/javascript">
var otherTableHead="";
var publicHylbdm="";
	$(document).ready(function() {
		pageUrl="publicsystem/querylistGadGl_qyryxx.action";
		divnid="tabledata";
		tableid="table1";
		addUrl="publicsystem/insertGad_qyryxx.action";
		addHtml="basic/publicsystem/QyryxxAdd-gad.jsp";
		addWidth="800";
		delUrl="publicsystem/delete_qyryxx.action";
		delid="d_ryid";
		modHtml="basic/publicsystem/QyryxxModify-gad-gzth.jsp";
		modUrl="publicsystem/modify_qyryxx.action";
		modWidth="800";
		detailHtml="basic/publicsystem/QyryxxDetail-gzth.jsp";
		detailid="cyryxx_detail";
		detailUrl="publicsystem/query_qyryxx.action";
		detailWidth="800";
		loadPage("tabledata");
	  	$("#p_xbdm").selectBox({code:"dm_xb"});
	  	
		//hy_gwselectBox("p_hylbdm","p_gwbh");
		// 行业类别	
		$("#p_hylbdm").selectBoxhylb({code:"ggmk"});
		
		daggleDiv("cyryxx_detail");
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
	//$('#p_hylbdm').change(function(){
	//	hy_gwselectBox("p_hylbdm","p_gwbh");
	//});
	
	function setPageList(pageno,url){
		url=setList(pageno,url);
		var mygrid1 = $("#"+tableid).ingrid({
			ingridPageParams:sXML, 
			height: pageHeight-255,
			url: url,	
			pageNumber: pageno,
			onRowSelect:null,
			onTdSelect: function(tr){
						$(tr).find("td").click(function(){
							var numIndex = $(this).attr("_colid");
							if(numIndex!=$(tr).find("td").length-1){
								setQuery($(tr).attr("id"),detailHtml,detailWidth); 	
							}
						});	
			},
			hideColIndex:[5],
			colWidths: ["7%","14%","14%","5%","16%","0%","20%","7%","8%","8%"]
		});			
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

	function setModify(id){
		$("#icksl_detail").hide();
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

<body>
<input type="hidden" id="d_ryid">
<input type="hidden" id="d_qyid">
<input type="hidden" id="p_gxdwbm">
<input type="hidden" id="p_qybm">

<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
	<tr><td class="queryfont">国内从业人员管理</td></tr>
	<tr><td valign="top" class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td width="10%" class="pagedistd">行业类别</td>
			<td width="23%" class="pagetd"><select type="select" id="p_hylbdm"></select></td>
			<td width="10%" class="pagedistd">管辖单位</td>
			<td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_gxdw" readonly></td>
			<td width="10%" class="pagedistd">企业名称</td>
			<td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_qymc" readonly/></td>
		</tr>
		<tr>
			<td width="10%" class="pagedistd">人员编号</td>
			<td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_cyrybh"/></td>
			<td class="pagedistd">姓名</td>
			<td class="pagetd"><input type="text" class="inputstyle" id="p_xm"/></td>
			<td class="pagedistd">证件号码</td>
			<td class="pagetd"><input type="text" class="inputstyle" id="p_zjhm"/></td>
		  </tr>
		<tr>
			<td class="pagedistd">性别</td>
			<td class="pagetd"><select name="select" id="p_xbdm"><option></option></select></td>
			<!-- <td class="pagedistd">岗位类别</td>
			<td class="pagetd"><select id="p_gwbh"><option></option></select></td> -->
			<td width="10%" class="pagedistd">&nbsp;</td>
		    <td width="23%" class="pagetd">&nbsp;</td>
		    <td class="pagetd" colspan="6">
			    <table border="0" align="right" cellpadding="1" cellspacing="0">
				<tr><td width="61px"><a href="#" class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
				<td width="61px"><a href="#" class="addbutton" onclick='setAddPage();'>新增</a></td></tr>
				</table>
			</td>
		</tr>
    	</table>
    </td></tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>

<div id="cyryxx_detail" class="page-layout" src="#" style="top:20px; left:160px; width:500px;"></div>

<div id="icksl_detail" class="page-layout" src="#" style="display:none;top:20px; left:160px; width:500px;"></div>	

<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	<thead>
	    <tr>
	     	<th>姓名</th>
	     	<th>证件号码</th>
	     	<th>人员编号</th>
	     	<th>性别</th>
	     	<th>行政区划</th>
	     	<th>岗位类别</th>
	     	<th>企业名称</th>
	     	<th>状态</th>
	     	<th>人员状态</th>
			<th>操作</th>
	    </tr>
	</thead>
	</table>
</div>
</body>
