<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%
User user = (User)session.getAttribute(Constants.userKey);
String departCode = user.getDepartment().getDepartcode();
String sdfjksdFlage = ""; //省地分局科所队 标志
if(departCode.length()==5){ //省厅
    if(!departCode.substring(3).substring(0,2).equals("11")//不属于四个直辖市
							&&!departCode.substring(3).substring(0,2).equals("12")
							&&!departCode.substring(3).substring(0,2).equals("31")
							&&!departCode.substring(3).substring(0,2).equals("50")){
	    sdfjksdFlage = "1";
	}else{
	    sdfjksdFlage = "5";
	}
	
}else if(departCode.length()==7) { //地市
	sdfjksdFlage = "2";
}else if(departCode.length()==9) { //分局
    if(!departCode.substring(3).substring(0,2).equals("11")//不属于四个直辖市
							&&!departCode.substring(3).substring(0,2).equals("12")
							&&!departCode.substring(3).substring(0,2).equals("31")
							&&!departCode.substring(3).substring(0,2).equals("50")){
	    sdfjksdFlage = "3";
	}else{
	    sdfjksdFlage = "4";
	}
}
%>
<script type="text/javascript">
	var initColWidths1 = ["14%","14%","14%","14%","14%","14%","16%"];
	var initColWidths2 = ["16%","16%","16%","16%","16%","20%"];
	var initColWidths3 = ["20%","20%","20%","20%","20%"];
	var thePlayColWidths = initColWidths1;
	var js_sdfjksdFlage = '<%=sdfjksdFlage %>';
	var js_departCode = '<%=departCode %>';
	var date = new Date();
	var nowMonth = (date.getMonth()+1)+'';
	var nowDate = date.getDate()+'';
	if(nowMonth.length==1) nowMonth = '0'+nowMonth;
	if(nowDate.length==1)  nowDate = '0'+nowDate;
	var nowTime = date.getYear()+'-'+nowMonth+'-'+nowDate;
	
	date.setDate(date.getDate() - 1);
	var nowMonth = (date.getMonth()+1)+'';
	var nowDate = date.getDate()+'';
	if(nowMonth.length==1) nowMonth = '0'+nowMonth;
	if(nowDate.length==1) nowDate = '0'+nowDate;
	var oldTime = date.getYear()+'-'+nowMonth+'-'+nowDate;
	
	$(document).ready(function() {
		divnid="tabledata";
		tableid="table1";
		loadPage("tabledata");
		csxxtjInit();
		// 行业类别	
 		$("#t_hylbdm").selectBoxhylb({code:"dm_hylb"});
		$("#t_qssj").attr("readonly","true").attr("value",oldTime).datepicker();
		$("#t_jzsj").attr("readonly","true").attr("value",nowTime).datepicker();
		
		pageUrl="icksystem/querylist_cjdtjrb.action";
		//ExcelURL
		excelUrl="icksystem/querylistExcel_cjdtjrb.action";
		searchLongUrl="icksystem/querylistExcelTemp_cjdtjrb.action";
	});
	
	function csxxtjInit(){
		$("#bq_ssdsbm").selectBox({state:"1"});
		$("#bq_cjdbm").selectBox({state:"1"});
		
		$("#bq_ssdsbm").setAttr("readonly",true);
		$("#bq_cjdbm").setAttr("readonly",true);
		
		$("#ch_ssdsbm").attr("disabled",true).attr("checked",false);
		$("#ch_cjdbm").attr("disabled",true).attr("checked",false);
		
		if(js_sdfjksdFlage=='1'){ //省厅
			$("#ch_ssdsbm").attr("disabled",false).attr("checked",true);
			gaveSelectInfo("ssdsbm",js_departCode); //赋值
			gaveSelectInfo("cjdbm","");
			checkedBox('ssdsbm');
			openRead('ssdsbm');
		} else if (js_sdfjksdFlage=='2'){ //地市
			$("#ch_cjdbm").attr("disabled",false);
			gaveSelectInfo("ssdsbm",js_departCode.substr(0,5)); //赋值
			gaveSelectValue("ssdsbm",js_departCode); //选值
			gaveSelectInfo("cjdbm",js_departCode); //赋值
			$("#ch_ssdsbm").attr("disabled",true).attr("checked",true);
			$("#t_ssdsbz").attr("value","1");
			$("#t_ssdsbm").attr("value",js_departCode);
		} else if (js_sdfjksdFlage=='3'){ //分局
			gaveSelectInfo("ssdsbm",js_departCode.substr(0,5)); //赋值
			gaveSelectValue("ssdsbm",js_departCode.substr(0,7)); //选值
			gaveSelectInfo("cjdbm",js_departCode.substr(0,7)); //赋值
			gaveSelectValue("cjdbm",js_departCode); //选值
			$("#ch_ssdsbm").attr("checked",true);
			$("#ch_cjdbm").attr("checked",true);
			$("#t_ssdsbz").attr("value","1");
			$("#t_cjdbz").attr("value","1");
			$("#t_ssdsbm").attr("value",js_departCode.substr(0,7));
			$("#t_cjdbm").attr("value",js_departCode);
		} else if (js_sdfjksdFlage=='4'){ //直辖市的分县
			gaveSelectInfo("ssdsbm",js_departCode.substr(0,5)); //赋值
			gaveSelectValue("ssdsbm",js_departCode); //选值
			gaveSelectInfo("cjdbm",js_departCode.substr(0,5)); //赋值
			gaveSelectValue("cjdbm",js_departCode); //选值
			$("#ch_ssdsbm").attr("checked",true);
			$("#ch_cjdbm").attr("checked",true);
			$("#t_ssdsbz").attr("value","1");
			$("#t_cjdbz").attr("value","1");
			$("#t_ssdsbm").attr("value",js_departCode.substr(0,5));
			$("#t_cjdbm").attr("value",js_departCode);
		} else if (js_sdfjksdFlage=='5'){ //直辖市特殊
			$("#ch_cjdbm").attr("disabled",false);
			gaveSelectInfo("ssdsbm",js_departCode.substr(3,5)+"00"); //赋值
			gaveSelectValue("ssdsbm",js_departCode.substr(3,5)+"0000000000"); //选值
			gaveSelectInfo("cjdbm",js_departCode); //赋值
			$("#ch_ssdsbm").attr("disabled",true).attr("checked",true);
			$("#t_ssdsbz").attr("value","1");
			$("#t_ssdsbm").attr("value",js_departCode);
		}
	}	
	function gaveSelectInfo(nowBqId,departValue){ //标签ID，部门编码（给下拉 赋值）
		$("#k_deptCode").attr("value",departValue);
		createXML("k_");
		if(departValue==""){
		    $("#bq_"+nowBqId).selectBox({url:"sysadmin/queryAllDepartGa_department.action"});
		}else{
		    $("#bq_"+nowBqId).selectBox({url:"sysadmin/querySelDepartGa_department.action"});
		}
	}
	function gaveSelectValue(nowBqId,departValue){ //给选择框 赋选择值
		$("#bq_"+nowBqId).setValue(departValue); //全部
	}
	function openRead(obj){ //打开下拉框
		$("#bq_"+obj).setAttr("readonly",false);
	}
	function closeRead(obj){ //关闭下拉框 只读
		$("#bq_"+obj).setValue(""); //全部
		$("#bq_"+obj).setAttr("readonly",true);
		$("#t_"+obj).attr("value","");
	}
	
	function gajgSelect(obj){ //选择机关 checkBox
		var dataKey = $(obj).attr("dataKey");
		var thisChecked = $(obj).attr("checked");
		if(thisChecked){ //打开下拉框
			checkedBox(dataKey);
		} else { //关闭下拉框
			uncheckedBox(dataKey);
			eval(dataKey+"Onchange();");
		}
	}
	function checkedBox(obj){
		$("#t_"+obj.substr(0,obj.length-2)+"bz").attr("value","1");
		if(obj=='ssdsbm'){
			openRead(obj);
			$("#ch_cjdbm").attr("disabled",false);
		}
		if(obj=='cjdbm'){
			//if($("#bq_ssdsbm").attr("value")!=''){
				openRead(obj);
			//}
		}
	}
	function uncheckedBox(obj){
		closeRead(obj);
		$("#t_"+obj.substr(0,obj.length-2)+"bz").attr("value","0");
		if(obj=='ssdsbm'){
			$("#ch_cjdbm").attr("disabled",true).attr("checked",false);
			uncheckedBox('cjdbm');
		}
		if(obj=='cjdbm'){
		}
	}
	function ssdsbmOnchange(){ //地市下拉变化时候
		if($("#bq_ssdsbm").attr("value")!=''){
			$("#t_ssdsbm").attr("value",$("#bq_ssdsbm").attr("value"));
			if($("#ch_cjdbm").attr("checked")){
				openRead('cjdbm');
			}
			gaveSelectInfo("cjdbm",$("#bq_ssdsbm").attr("value"));
			cjdbmOnchange(); ///------------
		} else {
			$("#t_ssdsbm").attr("value","");
			gaveSelectInfo("cjdbm","");
			cjdbmOnchange();
			//closeRead("cjdbm");
		}
	}
	function cjdbmOnchange(){ //分县局下拉变化时候
		if($("#bq_cjdbm").attr("value")!=''){
			$("#t_cjdbm").attr("value",$("#bq_cjdbm").attr("value"));
		} else {
			$("#t_cjdbm").attr("value","");
		}
	}
		
	function setPageList(pageno,url){
		url=setList(pageno,url);
		setParams("t_"); //传参
		var mygrid1 = $("#"+tableid).ingrid({
				ingridPageParams:sXML,
				url: url,
				height: pageHeight-234,
				pageNumber: pageno,
				colWidths: thePlayColWidths,
				onRowSelect: function(tr, selected){},
				sorting: false
		});
	}
	
	function startTjcx(){ //查询
		if(manVerify()){
			thePlayColWidths = initColWidths1;
			var ganjCol = "";
			$("#gajgAll").find("input[type='checkbox']").each(function(){
				if($(this).attr("checked")==true){
					if($(this).attr("dataKey")=='ssdsbm'){
						ganjCol += "<th>地市</th>";
						thePlayColWidths = initColWidths2;
					}
					if($(this).attr("dataKey")=='cjdbm'){
						ganjCol += "<th>采集点</th>";
						thePlayColWidths = initColWidths1;
					}
				}
			});
			if(ganjCol==""){
				thePlayColWidths = initColWidths3;
			}
			var result = "<table id='table1' width='100%'><thead><tr>";
			result += ganjCol;
			result += "<th>已录入企业</th>";
			result += "<th>已录入从业人员</th>";
			result += "<th>已受理IC卡</th>";
			result += "<th>已接收</th>";
			result += "<th>已发放</th>";
			result += "</tr></thead><tbody></tbody></table>";
			$("#tabledata").html(result);
			loadPage("tabledata");
			setPageList(1);
		}
	}
	function setExportExcel(){
		var leng=$('#tabledata').find('.datagrid').find('tbody').find('tr').length;
	//	var zhi =$('#tabledata').find('.datagrid').find('tbody').find('tr').find("td").eq(0).val();
	 if(leng==0){
		 	jAlert('没有可导出的数据','提示');
			return ;
		}else{
//			 if(zhi == ""){
//				 	jAlert('没有可导出的数据','提示');
//					return ;
//				}else{
			if(manVerify()){
			 	thePlayColWidths = initColWidths1;
				var ganjCol = "";
				$("#gajgAll").find("input[type='checkbox']").each(function(){
					if($(this).attr("checked")==true){
						if($(this).attr("dataKey")=='ssdsbm'){
							ganjCol += "<th name='l_ssdsmc' datatype='String' sumflag='0'>地市</th>";
							thePlayColWidths = initColWidths2;
						}
						if($(this).attr("dataKey")=='cjdbm'){
							ganjCol += "<th name='l_cjdmc' datatype='String' sumflag='0'>采集点</th>";
							thePlayColWidths = initColWidths1;
						}
					}
				});
				if(ganjCol==""){
					thePlayColWidths = initColWidths3;
				}
				var result = "<table id='table1' width='100%'><thead><tr>";
				result += ganjCol;
				result += "<th name='l_lrcss' datatype='String' sumflag='0'>已录入企业</th>";
				result += "<th name='l_lrcyrys' datatype='String' sumflag='0'>已录入从业人员</th>";
				result += "<th name='l_yslicks' datatype='String' sumflag='0'>已受理IC卡</th>";
				result += "<th name='l_yjss' datatype='String' sumflag='0'>已接收</th>";
				result += "<th name='l_yffs' datatype='String' sumflag='0'>已发放</th>";
				result += "</tr></thead><tbody></tbody></table>";
				$("#tabledata").html(result);
				geteExcelHead("tabledata");
				setSearchLong();
				loadPage("tabledata");
				setPageList(1);
			}
		}
//			}
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
		var bbmc="采集点统计";
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
		var p_qssj = $("#t_qssj").attr("value");
		var p_jzsj = $("#t_jzsj").attr("value");
		if(p_qssj!=''&&p_jzsj!=''&&formatDate(p_qssj)-formatDate(p_jzsj)>0){
			jAlert("请正确选择起始和截至日期!","提示信息");
			return false;
		}
		return true;
	}
	function formatDate(strDate){ //转换成日期格式
		var riqi = strDate.split("-");
		return new Date(riqi[0],(riqi[1]-1),riqi[2]);
	}
</script>

<body>
<input type="hidden" id="k_deptCode">

<input type="hidden" id="t_ssdsbz" value="0">
<input type="hidden" id="t_ssdsbm">
<input type="hidden" id="t_cjdbz" value="0">
<input type="hidden" id="t_cjdbm">

<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询条件</td>
  </tr>
  <tr id="gajgAll">
    <td valign="top" class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td class="pagedistd">行业类别</td>
			<td class="pagetd"><select name="select" id="t_hylbdm"></select></td>
			<td class="pagedistd">
			<input dataKey="ssdsbm" type="checkbox" id="ch_ssdsbm" onClick="gajgSelect(this);"/>地市</td>
			<td class="pagetd">
			<select name="cylb" id="bq_ssdsbm" onChange="ssdsbmOnchange();"><option>全部</option></select>
			</td>
			<td class="pagedistd">
			<input dataKey="cjdbm" type="checkbox" id="ch_cjdbm" onClick="gajgSelect(this);">采集点</td>
			<td class="pagetd" colspan="2">
			<select name="cylb" id="bq_cjdbm" onChange="cjdbmOnchange();"><option>全部</option></select></td>
		</tr>
		<tr>
			<td class="pagedistd">起始时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_qssj"></td>
			<td class="pagedistd">截止时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_jzsj"></td>
			<td width="23%" class="pagetd" colspan="5">
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
<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>
	     	<th>&nbsp;地市</th>
	     	<th>采集点</th>
	     	<th>已录入企业</th>
	     	<th>已录入从业人员</th>
	     	<th>已受理IC卡</th>
	     	<th>已接收</th>
	     	<th>已发放</th>
	    </tr>
	  </thead>
	</table>
</div>
</body>