<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:include page="../../public/publicGADTJ.jsp" flush="true"></jsp:include>
<html>
<head>
<script type="text/javascript">
	var initColWidths1 = ["15%","15%","15%","15%","15%","15%","10%"];
	var initColWidths2 = ["17%","17%","17%","17%","17%","15%"];
	var initColWidths3 = ["20%","20%","20%","20%","20%"];
	var thePlayColWidths = initColWidths1;
$(document).ready(function() {
    $("#"+detailid).hide();
    detailid="bdbjtj_detail";
	pageUrl="basicsystem/querylist_bdbjtj.action";
	divnid="BdbjtjData";
	tableid="BdbjtjTable";
	//ExcelURL
	excelUrl="basicsystem/querylistExcel_bdbjtj.action";
	searchLongUrl="basicsystem/querylistExcelTemp_bdbjtj.action";

    tabletitle = "";
	geteExcelHead(divnid);
	// 初期化页面
	loadPage(divnid);
    // 控件联动机能初期化
	csxxtjInit();
	// 初期化日期控件
    initTJDate();
	$("#t_tjrq").attr("readonly","true").datepicker();
	$("#t_tjrqzhi").attr("readonly","true").datepicker();
	$("#t_tjrq").attr("value",tomorrowDate);
	$("#t_tjrqzhi").attr("value",currentDate);
		
	$("#p_csmc").click(function(){
			if($("#ch_csbm").attr("checked")){
			    dataid=$("#t_hylbdm").val();
			    var gxdw='';
	            if($("#t_gxdwdm").attr("value")!=''){
	                gxdw=$("#t_gxdwdm").attr("value");
	            }else if($("#t_fxjdm").attr("value")!=''){
	                gxdw=$("#t_fxjdm").attr("value");
	            }else if($("#t_dsjgdm").attr("value")!=''){
	                gxdw=$("#t_dsjgdm").attr("value");
	            }
			    getTy_item_super("p_csmc","t_csbm","","",gxdw,"","");
			}
		});
		$("#t_hylbdm").selectBoxhylb({code:"dm_hylb"});// 行业类别选择框
    
    daggleDiv(detailid);
}); 

function setPageList(pageno,url){
		url=setList(pageno,url);
		setParams("t_"); //传参
		var mygrid1 = $("#"+tableid).ingrid({
				ingridPageParams:sXML,
				url: url,
				height: pageHeight-263,
				pageNumber: pageno,
				colWidths: thePlayColWidths,
				onRowSelect: function(tr, selected){}
		});
	}
	
function startTjcx(){ //查询
		if(manVerify()){
			thePlayColWidths = initColWidths2;
			var ganjCol = "";
			$("#gajgAll").find("input[type='checkbox']").each(function(){
				if($(this).attr("checked")==true){
					if($(this).attr("dataKey")=='dsjgdm'){
						ganjCol = "<th name='l_dsjgmc' datatype='Integer' sumflag='0'>地市公安机关</th>";
					}
					if($(this).attr("dataKey")=='fxjdm'){
						ganjCol = "<th name='l_fxjmc' datatype='Integer' sumflag='0'>分县局公安机关</th>";
					}
					if($(this).attr("dataKey")=='gxdwdm'){
						ganjCol = "<th name='l_gxdwmc' datatype='Integer' sumflag='0'>科所队</th>";
					}
					if($(this).attr("dataKey")=='csbm'){
					    ganjCol = "<th name='l_csbm' datatype='Integer' sumflag='0'>企业编码</th>";
						ganjCol += "<th name='l_csmc' datatype='Integer' sumflag='0'>企业名称</th>";
						thePlayColWidths = initColWidths1;
					}
				}
			});
			if(ganjCol==''){
				thePlayColWidths = initColWidths3;
			}
			var result = "<table id='BdbjtjTable' width='100%'><thead><tr>";
			result += ganjCol;
			result += "<th name='l_clbjcs' datatype='String' sumflag='0'>车辆报警次数</th>";
			result += "<th name='l_cyrybjcs' datatype='String' sumflag='0'>从业人员报警次数</th>";
			result += "<th name='l_scrybjcs' datatype='String' sumflag='0'>涉车人员报警次数</th>";
			result += "<th name='l_kyclbjcs' datatype='String' sumflag='0'>可疑车辆报警次数</th>";
			result += "<th name='l_xiaoji' datatype='String' sumflag='0'>小计</th>";
			result += "</tr></thead><tbody></tbody></table>";
			$("#"+divnid).html(result);
			loadPage(divnid);
			setPageList(1);
		}
	}
	
function manVerify(){
        var t_qssj = $("#t_tjrq").attr("value");
		var t_jzsj = $("#t_tjrqzhi").attr("value");
		if(t_qssj!=''&&t_jzsj!=''&&formatDate(t_qssj)-formatDate(t_jzsj)>0){
			jAlert("请正确选择起始和截至日期!","提示信息");
			return false;
		}
        
		return true;
	}

function setExportExcel(){
		if(manVerify()){
			thePlayColWidths = initColWidths2;
			var ganjCol = "";
			$("#gajgAll").find("input[type='checkbox']").each(function(){
				if($(this).attr("checked")==true){
					if($(this).attr("dataKey")=='dsjgdm'){
						ganjCol = "<th name='l_dsjgmc' datatype='Integer' sumflag='0'>地市公安机关</th>";
					}
					if($(this).attr("dataKey")=='fxjdm'){
						ganjCol = "<th name='l_fxjmc' datatype='Integer' sumflag='0'>分县局公安机关</th>";
					}
					if($(this).attr("dataKey")=='gxdwdm'){
						ganjCol = "<th name='l_gxdwmc' datatype='Integer' sumflag='0'>科所队</th>";
					}
					if($(this).attr("dataKey")=='csbm'){
					    ganjCol = "<th name='l_csbm' datatype='Integer' sumflag='0'>企业编码</th>";
						ganjCol += "<th name='l_csmc' datatype='Integer' sumflag='0'>企业名称</th>";
						thePlayColWidths = initColWidths1;
					}
				}
			});
			if(ganjCol==''){
				thePlayColWidths = initColWidths3;
			}
			var result = "<table id='BdbjtjTable' width='100%'><thead><tr>";
			result += ganjCol;
			result += "<th name='l_clbjcs' datatype='String' sumflag='0'>车辆报警次数</th>";
			result += "<th name='l_cyrybjcs' datatype='String' sumflag='0'>从业人员报警次数</th>";
			result += "<th name='l_scrybjcs' datatype='String' sumflag='0'>涉车人员报警次数</th>";
			result += "<th name='l_kyclbjcs' datatype='String' sumflag='0'>可疑车辆报警次数</th>";
			result += "<th name='l_xiaoji' datatype='String' sumflag='0'>小计</th>";
			result += "</tr></thead><tbody></tbody></table>";
			$("#"+divnid).html(result);
			geteExcelHead(divnid);
			setSearchLong();
			loadPage(divnid);
			
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
		var bbmc="比对报警信息统计";
		//报表请求
		setExcelLong("bdbjtjExcel",bbmc);	
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
	
	function formatDate(strDate){ //转换成日期格式

		var riqi = strDate.split("-");
		return new Date(riqi[0],(riqi[1]-1),riqi[2]);
	}
	function jxqyxxQuery(strBm){
	    sFlag="false";
	    dataid=strBm;
	    setWidth(detailid,detailWidth);
	    setUrl(detailid,detailHtml);
	    bindDocument(detailid);
	}
</script>
</head>
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
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">比对报警信息统计</td>
  </tr>
  <tr  id="gajgAll">
    <td class="tdbg">
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
		</tr>
		<tr>
			<td class="pagedistd">
			<input dataKey="csbm" type="checkbox" id="ch_csbm" onClick="gajgSelect(this);">企业名称</td>
			<td class="pagetd"><input type="text" id="p_csmc" class="inputstyle" readonly="readonly"></td>
			<td class="pagedistd">起始时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_tjrq"></td>
			<td class="pagedistd">截止时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_tjrqzhi"></td>
		</tr>
    	<tr>
    	    <td class="pagedistd">行业类别</td>
			<td class="pagetd"><select type="select" id="t_hylbdm"></select></td>
			<td width="23%" class="pagetd" colspan="4">
				<table width="124px" border="0" align="right" cellpadding="2" cellspacing="0">
				<tr>
				<td><a href="#" class="searchbutton" id="querys2" onClick="startTjcx();">统计</a></td>
				<td><a href="#" class="exceldcbutton" onClick="setExportExcel();" id="bdbjtjExcel">导出</a></td>
				</tr>
				</table>
			</td>
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
<div id="bdbjtj_detail" class="page-layout" src="#"
		style="top:20px; left:20px;">
</div>	

<div id="BdbjtjData" style="width:100%;">
	<table id="BdbjtjTable" width="100%">
	  <thead>
	    <tr>
	        <th name="l_csbm" datatype='String' sumflag='0'>企业编码</th>
	     	<th name='l_csmc' datatype='String' sumflag='0'>企业名称</th>
	     	<th name='l_clbjcs' datatype='String' sumflag='0'>车辆报警次数</th>
	     	<th name='l_cyrybjcs' datatype='String' sumflag='0'>从业人员报警次数</th>
	     	<th name='l_scrybjcs' datatype='String' sumflag='0'>涉车人员报警次数</th>
	     	<th name='l_kyclbjcs' datatype='String' sumflag='0'>可疑车辆报警次数</th>
	     	<th name='l_xiaoji' datatype='String' sumflag='0'>小计</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>
</html>