<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:include page="../../public/publicGADTJ.jsp" flush="true"></jsp:include>
<script type="text/javascript">
var qyjbxx_detailHtml="business/Ylfwzagl/YlcsjbxxDetail.jsp";
	var qyjbxx_detailid="qyxx_detail";
	var qyjbxx_detailUrl="publicsystem/query_qyjbxx.action";
	var qyjbxx_detailWidth="1000";
	var qyjbxx_requestType="detail";
	var qyjbxx_dataid="";

	var jb;
	var initColWidths1 = ["16%","16%","16%","16%","16%","20%"];
	var initColWidths2 = ["20%","20%","20%","20%","20%"];
    var initColWidths3 = ["25%","25%","25%","25%"];
    
	var thePlayColWidths = initColWidths1;
	var changsuoCanPlay = false;
	var qyxx_detail = "qyxx_detail";
	
	$(document).ready(function() {
		$("#"+qyxx_detail).hide();
		pageUrl="publicsystem/querylist_qyryxxtj.action";
		divnid="tabledata";
		tableid="table1";
		loadPage("tabledata");
		csxxtjInit();
		//ExcelURL
		excelUrl="publicsystem/querylistExcel_qyryxxtj.action";
		searchLongUrl="publicsystem/querylistExcelTemp_qyryxxtj.action";
		$("#p_csmc").click(function(){
			if(changsuoCanPlay&&$("#ch_csbm").attr("checked")){
			   	dataid=$("#t_hylbdm").val();
			  getTy_item_super("p_csmc","t_csbm","","",$("#t_gxdwdm").attr("value"),"1","");
				//getQY_item("p_csmc","t_csbm","1",$("#t_gxdwdm").attr("value"));
			}
		});
		$("#t_hylbdm").selectBoxhylb({code:"dm_hylb"});// 行业类别选择框

		//注销状态

  	   $("#t_ztdm").selectBox({code:"dm_cszt"});
		 daggleDiv("qyxx_detail");
		 
	});
	
	function setPageList(pageno,url){
		url=setList(pageno,url);
		setParams("t_"); //传参
		var mygrid1 = $("#"+tableid).ingrid({
				ingridPageParams:sXML,
				url: url,
				height: pageHeight-232,
				pageNumber: pageno,
				colWidths: thePlayColWidths,
				onRowSelect: function(tr){
				             if(jb=='qy'){
												   var qybm = $(tr).find("td").eq(0);
													qybm.html("<a href='#' class='hyperlink' onClick=setQyDetailone('"+qybm.text()+"');>"+qybm.text()+"</a>");
												    var qybmmc = $(tr).find("td").eq(1);
													qybmmc.html("<a href='#' class='hyperlink' onClick=setQyDetailone('"+qybm.text()+"');>"+qybmmc.text()+"</a>");
												
												}
											
											},
				
					 
				
				
				
				sorting: false
		});
	}
	
	
	
	function startTjcx(){ //查询
		if(manVerify()){
		$("#x_hylbdm").attr("value", $("#t_hylbdm").attr("value"));
		$("#x_ztdm").attr("value", $("#t_ztdm").attr("value"));
		
		
			thePlayColWidths = initColWidths2;
			
			var ganjCol = "";
			$("#gajgAll").find("input[type='checkbox']").each(function(){
				if($(this).attr("checked")==true){
					if($(this).attr("dataKey")=='dsjgdm'){
						ganjCol = "<th name='l_dsjgmc' datatype='String' sumflag='0'>地市公安机关</th>";
						jb="ds";
						$("#x_dsjgbz").attr("value","1");
						$("#x_dsjgdm").attr("value", $("#t_dsjgdm").attr("value"));
						$("#x_fxjbz").attr("value","0");
						$("#x_fxjdm").attr("value", '');
						$("#x_gxdwbz").attr("value","0");
						$("#x_gxdwdm").attr("value", '');
						$("#x_csbz").attr("value","0");
						$("#x_csbm").attr("value", '');
						
					}
					if($(this).attr("dataKey")=='fxjdm'){
						ganjCol = "<th name='l_fxjmc' datatype='String' sumflag='0'>分县局公安机关</th>";
							jb="fxj";
						$("#x_dsjgbz").attr("value","0");
						$("#x_dsjgdm").attr("value",  $("#t_dsjgdm").attr("value"));
						$("#x_fxjbz").attr("value","1");
						$("#x_fxjdm").attr("value", $("#t_fxjdm").attr("value"));
						$("#x_gxdwbz").attr("value","0");
						$("#x_gxdwdm").attr("value", '');
						$("#x_csbz").attr("value","0");
						$("#x_csbm").attr("value", '');
					}
					if($(this).attr("dataKey")=='gxdwdm'){
						ganjCol = "<th name='l_gxdwmc' datatype='String' sumflag='0'>科所队</th>";
						jb="gxdw";
						$("#x_dsjgbz").attr("value","0");
						$("#x_dsjgdm").attr("value", $("#t_dsjgdm").attr("value"));
						$("#x_fxjbz").attr("value","0");
						$("#x_fxjdm").attr("value", $("#t_fxjdm").attr("value"));
						$("#x_gxdwbz").attr("value","1");
						$("#x_gxdwdm").attr("value", $("#t_gxdwdm").attr("value"));
						$("#x_csbz").attr("value","0");
						$("#x_csbm").attr("value", '');
					}
					if($(this).attr("dataKey")=='csbm'){
						ganjCol = "<th name='l_qybm' datatype='String' sumflag='0'>场所编码</th>";
						ganjCol += "<th name='l_qymc' datatype='String' sumflag='0'>场所名称</th>";
						thePlayColWidths = initColWidths1;
						
						jb="qy";
						$("#x_dsjgbz").attr("value","0");
						$("#x_dsjgdm").attr("value", $("#t_dsjgdm").attr("value"));
						$("#x_fxjbz").attr("value","0");
						$("#x_fxjdm").attr("value", $("#t_fxjdm").attr("value"));
						$("#x_gxdwbz").attr("value","0");
						$("#x_gxdwdm").attr("value", $("#t_gxdwdm").attr("value"));
						$("#x_csbz").attr("value","1");
						$("#x_csbm").attr("value", $("#t_csbm").attr("value"));
					}
				}
			});
			if(ganjCol==''){
				thePlayColWidths = initColWidths3;
				
			}
			var result = "<table id='table1' width='100%'><thead><tr>";
			result += ganjCol;
		    result += "<th name='l_zrs' datatype='Integer' sumflag='0'>累计总人数</th>";
	     	result += "<th name='l_dqzzrs' datatype='Integer' sumflag='0'>当前在职</th>";
	     	result += "<th name='l_dyzcrs' datatype='Integer' sumflag='0'>当月注册</th>";
	     	result += "<th name='l_zjqrzcrs' datatype='Integer' sumflag='0'>最近7日注册</th>";
			result += "</tr></thead><tbody></tbody></table>";
			$("#tabledata").html(result);
			loadPage("tabledata");
			setPageList(1);
		}
	}
	
	function setExportExcel(){
		if(manVerify()){
			thePlayColWidths = initColWidths2;
			
			var ganjCol = "";
			$("#gajgAll").find("input[type='checkbox']").each(function(){
				if($(this).attr("checked")==true){
					if($(this).attr("dataKey")=='dsjgdm'){
						ganjCol = "<th name='l_dsjgmc' datatype='String' sumflag='0'>地市公安机关</th>";
					}
					if($(this).attr("dataKey")=='fxjdm'){
						ganjCol = "<th name='l_fxjmc' datatype='String' sumflag='0'>分县局公安机关</th>";
					}
					if($(this).attr("dataKey")=='gxdwdm'){
						ganjCol = "<th name='l_gxdwmc' datatype='String' sumflag='0'>科所队</th>";
					}
					if($(this).attr("dataKey")=='csbm'){
						ganjCol = "<th name='l_qybm' datatype='String' sumflag='0'>场所编码</th>";
						ganjCol += "<th name='l_qymc' datatype='String' sumflag='0'>场所名称</th>";
						thePlayColWidths = initColWidths1;
						
					}
				}
			});
			if(ganjCol==''){
				thePlayColWidths = initColWidths3;
				
			}
			var result = "<table id='table1' width='100%'><thead><tr>";
			result += ganjCol;
		    result += "<th name='l_zrs' datatype='Integer' sumflag='0'>累计总人数</th>";
	     	result += "<th name='l_dqzzrs' datatype='Integer' sumflag='0'>当前在职</th>";
	     	result += "<th name='l_dyzcrs' datatype='Integer' sumflag='0'>当月注册</th>";
	     	result += "<th name='l_zjqrzcrs' datatype='Integer' sumflag='0'>最近7日注册</th>";
			result += "</tr></thead><tbody></tbody></table>";
			$("#tabledata").html(result);
			geteExcelHead("tabledata");
			setSearchLong();
			loadPage("tabledata");
			setPageList(1);
			
		
			
		}
	}
	/*
	不分页传参数将结果集返回，用于长参数导出前的查询
	*/
	function setSearchLong(){
		setParams("t_");
		jQuery.post(searchLongUrl,params,searchLongBack,"json");
	}
	//导出前对应setSearchLong()的回调方法  由于执行查询时候有延迟，故将导出放入回调函数


	function searchLongBack(json){
		//报表标题
		var bbmc="人员状态信息统计";
		//报表请求
		setExcelLong("csxxExcel",bbmc);	
	}
	/*setExcel 生成EXCEL,不传参数，防止超长


	 * excelid 链接id
	 * bbmc：报表标题


	 */
	function setExcelLong(excelid,bbmc){
		var surl=excelUrl+"?tabletitle="+tabletitle+"&bbmc="+bbmc;
		surl=encodeURI(surl);
		location.href = surl;
	}
	function manVerify(){
	  
		return true;
	}
	function formatDate(strDate){ //转换成日期格式


		var riqi = strDate.split("-");
		return new Date(riqi[0],(riqi[1]-1),riqi[2]);
	}
	function setQyxxQuery(id){
	     detailid="qyxx_detail";
	     dataid=id;
		  var url="basic/publicsystem/SktjxxMan.jsp";
		 setUrl(detailid,url);
		
	}
	
	  function setQyDetailone(qybms){
		qyjbxx_dataid="qybm_"+qybms;
		setWidth(qyjbxx_detailid,qyjbxx_detailWidth);
		setUrl(qyjbxx_detailid,qyjbxx_detailHtml);
		bindDocument(qyjbxx_detailid);
}

</script>

<body>
<input type="hidden" id="k_deptCode">
<input type="hidden" id="t_dsjgbz" value="0">
<input type="hidden" id="t_dsjgdm">
<input type="hidden" id="t_fxjbz" value="0">
<input type="hidden" id="t_fxjdm">
<input type="hidden" id="t_gxdwbz" value="0">
<input type="hidden" id="t_gxdwdm">
<input type="hidden" id="t_csbz" value="0">
<input type="hidden" id="t_csbm">

<input type="hidden" id="x_dsjgbz" value="0">
<input type="hidden" id="x_dsjgdm">
<input type="hidden" id="x_fxjbz" value="0">
<input type="hidden" id="x_fxjdm">
<input type="hidden" id="x_gxdwbz" value="0">
<input type="hidden" id="x_gxdwdm">
<input type="hidden" id="x_csbz" value="0">
<input type="hidden" id="x_csbm">
<input type="hidden" id="x_hylbdm">
<input type="hidden" id="x_ztdm">

<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">人员状态信息统计</td>
  </tr>
  <tr id="gajgAll">
    <td valign="top" class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td width="10%" class="pagedistd">
			<input dataKey="dsjgdm" type="checkbox" id="ch_dsjgdm" onClick="gajgSelect(this);"/>地市公安机关</td>
			<td width="23%" class="pagetd">
			<select name="cylb" id="bq_dsjgdm" onChange="dsjgdmOnchange();"><option>全部</option></select>
			</td>
			<td width="10%" class="pagedistd">
			<input dataKey="fxjdm" type="checkbox" id="ch_fxjdm" onClick="gajgSelect(this);">分县局公安机关</td>
			<td width="23%" class="pagetd">
			<select name="cylb" id="bq_fxjdm" onChange="fxjdmOnchange();"><option>全部</option></select></td>
			<td width="10%" class="pagedistd">
			<input dataKey="gxdwdm" type="checkbox" id="ch_gxdwdm" onClick="gajgSelect(this);">科所队</td>
			<td width="23%" class="pagetd">
			<select name="cylb" id="bq_gxdwdm" onChange="gxdwdmOnchange();"><option>全部</option></select></td>
			<td class="pagedistd">
			<input dataKey="csbm" type="checkbox" id="ch_csbm" onClick="gajgSelect(this);">场所</td>
			<td class="pagetd"><input type="text" id="p_csmc" class="inputstyle" readonly="readonly"></td>
		</tr>
		<tr>
	    	<td class="pagedistd">行业类别</td>
			<td class="pagetd"><select type="select" id="t_hylbdm"></select></td>
	        <td class="pagedistd">是否注销</td>
			<td class="pagetd"><select type="select" id="t_ztdm"><option >全部</option></select></td>
			<td width="23%" class="pagetd" colspan="4">
				<table width="124px" border="0" align="right" cellpadding="2" cellspacing="0">
				<tr>
				<td><a href="#" class="searchbutton" id="querys2" onClick="startTjcx();">查询</a></td>
				<td><a href="#" class="exceldcbutton" onClick="setExportExcel()" id="csxxExcel">导出</a></td>
				</tr>
				</table>
			</td>
			
		</tr>
		
    	</table>
    </td>
  </tr>
</table>	
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="3"></td></tr>
</table>
<div id="qyxx_detail"  class="page-layout" src="#" style="top:20px; left:160px; width:800px;"></div>
<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_qybm" datatype="String" sumflag="0">场所编码</th>
	     	<th name="l_qymc" datatype="String" sumflag="0">场所名称</th>
	     	<th name="l_zrs" datatype="Integer" sumflag="0">累计总人数</th>
	     	<th name="l_dqzzrs" datatype="Integer" sumflag="0">当前在职</th>
	     	<th name="l_dyzcrs" datatype="Integer" sumflag="0">当月注册</th>
	     	<th name="l_zjqrzcrs" datatype="Integer" sumflag="0">最近7日注册</th>
	    </tr>
	  </thead>
	</table>
</div>
</body>