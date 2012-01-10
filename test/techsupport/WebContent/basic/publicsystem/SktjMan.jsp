<%@ page language="java" pageEncoding="UTF-8"%>
<jsp:include page="../../public/publicGADTJ.jsp" flush="true"></jsp:include>
<script type="text/javascript">
     var jb;
     var sktjfalg;
	var initColWidths1 = ["12%","16%","7%","8%","8%","7%","8%","8%","6%","6%","6%","6%"];
	var initColWidths2 = ["16%","10%","10%","10%","10%","10%","10%","6%","6%","6%","6%"];
	var initColWidths3 = ["10%","10%","10%","10%","10%","10%","10%","12%","12%","6%"];
	var initColWidths4 = ["16%","10%","10%","10%","10%","10%","10%","12%","12%"];
	
	var thePlayColWidths = initColWidths1;
	var changsuoCanPlay = false;
	var skxxtj_detail = "skxxtj_detail";
	
	$(document).ready(function() {
		initTJDate();
		$("#ztxx_detail").hide();
		$("#ycskxx_detail").hide();
		$("#dcskxx_detail").hide();
		$("#"+skxxtj_detail).hide();
		pageUrl="publicsystem/querylistsktj_qysctj.action";
		divnid="tabledata";
		tableid="table1";
		loadPage("tabledata");
		csxxtjInit();
		$("#t_qssj").attr("readonly","true").attr("value",tomorrowDate).datepicker();
		$("#t_jzsj").attr("readonly","true").attr("value",currentDate).datepicker();
		
		//ExcelURL
		excelUrl="publicsystem/querylistExcel_qysctj.action";
		searchLongUrl="publicsystem/querylistExcelTemp_qysctj.action";
		$("#p_csmc").click(function(){
			if(changsuoCanPlay&&$("#ch_csbm").attr("checked")){
		     	dataid=$("#t_hylbdm").val();
			    getTy_item_super("p_csmc","t_csbm","","",$("#t_gxdwdm").attr("value"),"1","1");
				//getQY_item("p_csmc","t_csbm","1",$("#t_gxdwdm").attr("value"));
			}
		});
		$("#t_hylbdm").selectBoxhylb({code:"dm_hylb"});// 行业类别选择框

		 daggleDiv("ztxx_detail");
		 daggleDiv("skxxtj_detail");
		   $("#t_zskbdxdy").selectBox({state:"1",width:50});
	});
	
	function setPageList(pageno,url){
		url=setList(pageno,url);
		setParams("t_"); //传参
		var mygrid1 = $("#"+tableid).ingrid({
				ingridPageParams:sXML,
				url: url,
				height: pageHeight-262,
				pageNumber: pageno,
				colWidths: thePlayColWidths,
				onRowSelect:null,
				
					     changeHref:function(table){
					         if(jb!=null&&jb!=''){
													$(table).find("tr").each(function(){
													
													var temp1=$(this).attr('id');
													  if(jb=='ds'||jb=='fxj'||jb=='gxdw'){
														  if($(this).find("td:nth(4)").text()>0){
																var temp=$(this).find("td:nth(4)").text();
																$(this).find("td:nth(4)").html('<a href="#" class="fontbutton" onclick=setZtxxQuery("'+temp1+'")>'+temp+'</a>');
															}
														//添加一次刷卡人数链接	
																var temp=$(this).find("td:nth(6)").text();
																$(this).find("td:nth(6)").html('<a href="#" class="fontbutton" onclick=setYcskxxQuery("'+temp1+'")>'+temp+'</a>');
														//添加多次刷卡人数链接
																var temp=$(this).find("td:nth(8)").text();
																$(this).find("td:nth(8)").html('<a href="#" class="fontbutton" onclick=setDcskxxQuery("'+temp1+'")>'+temp+'</a>');
													    }
													   else if(jb=='qy'){
													      if($(this).find("td:nth(5)").text()>0){
																var temp=$(this).find("td:nth(5)").text();
																$(this).find("td:nth(5)").html('<a href="#" class="fontbutton" onclick=setZtxxQuery("'+temp1+'")>'+temp+'</a>');
															}
															//添加一次刷卡人数链接	
																var temp=$(this).find("td:nth(7)").text();
																$(this).find("td:nth(7)").html('<a href="#" class="fontbutton" onclick=setYcskxxQuery("'+temp1+'")>'+temp+'</a>');
														 	//添加多次刷卡人数链接
																var temp=$(this).find("td:nth(9)").text();
																$(this).find("td:nth(9)").html('<a href="#" class="fontbutton" onclick=setDcskxxQuery("'+temp1+'")>'+temp+'</a>');
													   }
					
													});
												}
											},
				
				
				
				sorting: false
		});
	}
	
	
	
	function startTjcx(){ //查询
		if(manVerify()){
		$("#x_hylbdm").attr("value", $("#t_hylbdm").attr("value"));
		$("#x_qssj").attr("value", $("#t_qssj").attr("value"));
		$("#x_jzsj").attr("value", $("#t_jzsj").attr("value"));
		
		
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
						ganjCol += "<th name='l_qymc' datatype='String' sumflag='0'>服务场所</th>";
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
		    result += "<th name='l_zrs' datatype='Integer' sumflag='0'>总人数汇总</th>";
	     	result += "<th name='l_gzrs' datatype='Integer' sumflag='0'>工作人数汇总</th>";
	     	result += "<th name='l_sskrs' datatype='Integer' sumflag='0'>实际刷卡人数</th>";
	     	result += "<th name='l_ztskrs' datatype='Integer' sumflag='0'>走台人次</th>";
	     	result += "<th name='l_zskbstring' datatype='String' sumflag='0'>总刷卡比(%)</th>";
	     	result += "<th name='l_ycskrs' datatype='Integer' sumflag='0'>一次刷卡人数</th>";
	        result += "<th name='l_ycskbstring' datatype='String' sumflag='0'>一次刷卡率(%)</th>";
	     	result +="<th name='l_dcskrs' datatype='Integer' sumflag='0'>多次刷卡人数</th>";
	        result += "<th name='l_dcskbstring' datatype='String' sumflag='0'>多次刷卡率(%)</th>";
			
			result += "<th name=''>操作</th>";
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
						ganjCol += "<th name='l_qymc' datatype='String' sumflag='0'>服务场所</th>";
						thePlayColWidths = initColWidths1;
						
					}
				}
			});
			if(ganjCol==''){
				thePlayColWidths = initColWidths3;
				
			}
			var result = "<table id='table1' width='100%'><thead><tr>";
			result += ganjCol;
		    result += "<th name='l_zrs' datatype='Integer' sumflag='0'>总人数汇总</th>";
	     	result += "<th name='l_gzrs' datatype='Integer' sumflag='0'>工作人数汇总</th>";
	     	result += "<th name='l_sskrs' datatype='Integer' sumflag='0'>实际刷卡人数</th>";
	     	result += "<th name='l_ztskrs' datatype='Integer' sumflag='0'>走台人次</th>";
	     	result += "<th name='l_zskbstring' datatype='String' sumflag='0'>总刷卡比(%)</th>";
	     	result += "<th name='l_ycskrs' datatype='Integer' sumflag='0'>一次刷卡人数</th>";
	        result += "<th name='l_ycskbstring' datatype='String' sumflag='0'>一次刷卡率(%)</th>";
	     	result +="<th name='l_dcskrs' datatype='Integer' sumflag='0'>多次刷卡人数</th>";
	        result += "<th name='l_dcskbstring' datatype='String' sumflag='0'>多次刷卡率(%)</th>";
			result += "<th name=''>操作</th>";
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
		var bbmc="刷卡信息统计";
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
	    if (!checkControlValue("t_qssj","Date",null,null,null,1,"起始日期"))
			return false;
		if (!checkControlValue("t_jzsj","Date",null,null,null,1,"截止日期"))
			return false;
		var p_qssj = $("#t_qssj").attr("value");
		var p_jzsj = $("#t_jzsj").attr("value");
		if(p_qssj!=''&&p_jzsj!=''&&formatDate(p_qssj)-formatDate(p_jzsj)>0){
			jAlert("请正确选择起始和截至日期!","提示信息");
			return false;
		}
		
		
			var zskbdxdys= document.getElementById('t_zskbdxdy').value;
			 var zskbbfbs=	 document.getElementById('t_zskbbfb').value;
			 if(!checkIsDouble(zskbbfbs)){
			  alert("请正确填写总刷卡比");
			  return false;
			 }
			 
			 
			 
			 if(zskbdxdys!=''&&zskbbfbs==''){
			    alert('请将总刷卡比填写完整');
						return false;
			 }
			  if(zskbbfbs!=''&&zskbdxdys==''){
			    alert('请将总刷卡比填写完整');
						return false;
			 }
			
		
		return true;
	}
	function formatDate(strDate){ //转换成日期格式


		var riqi = strDate.split("-");
		return new Date(riqi[0],(riqi[1]-1),riqi[2]);
	}
	function setXxQuery(id){
	      setXParmValue(id);
	     detailid="skxxtj_detail";
	     dataid=id;
	     setWidth(detailid,"1000");
		  var url="basic/publicsystem/SktjxxMan.jsp";
		 setUrl(detailid,url);
		
	}
	function setZtxxQuery(id){
	     setXParmValue(id);
	     sktjfalg="yes";
	     detailid="ztxx_detail";
	     setWidth(detailid,"900");
	     $("#x_ztjbdm").attr("value", id);
		 var url="basic/publicsystem/ZtryxxMan.jsp";
		 setUrl(detailid,url);
	}
	//一次刷卡人员信息
	function setYcskxxQuery(id){
	     setXParmValue(id);
	     sktjfalg="yes";
	     detailid="ycskxx_detail";
	     setWidth(detailid,"800");
	     $("#x_ztjbdm").attr("value", id);
		 var url="basic/publicsystem/ycsk-cyryxxMan-gn.jsp";
		 setUrl(detailid,url);
	}
	//多次刷卡人员信息
	function setDcskxxQuery(id){
	     setXParmValue(id);
	     sktjfalg="yes";
	     detailid="dcskxx_detail";
	     setWidth(detailid,"800");
	     $("#x_ztjbdm").attr("value", id);
		 var url="basic/publicsystem/dcsk-cyryxxMan-gn.jsp";
		 setUrl(detailid,url);
	}
	
	function setXParmValue(id){
		if(jb!=null&&jb!=''){
					if(jb=='ds'){
						 $("#x_dsjgdm").attr("value", id);
					}
					if(jb=='fxj'){
						 $("#x_fxjdm").attr("value", id);
					}
					if(jb=='gxdw'){
						 $("#x_gxdwdm").attr("value", id);
					}
					if(jb=='qy'){
						 $("#x_csbm").attr("value", id);
					}
				}
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
<input type="hidden" id="x_qssj">
<input type="hidden" id="x_jzsj">
<input type="hidden" id="x_ztjbdm">

<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">刷卡信息统计</td>
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
		</tr>
		<tr>
		    <td class="pagedistd">
			<input dataKey="csbm" type="checkbox" id="ch_csbm" onClick="gajgSelect(this);">场所</td>
			<td class="pagetd"><input type="text" id="p_csmc" class="inputstyle" readonly="readonly"></td>
	    	<td class="pagedistd">行业类别</td>
			<td class="pagetd"><select type="select" id="t_hylbdm"></select></td>
			<td class="pagedistd">总刷卡比</td>
			<td class="pagetd">
			<table >
				<tr>
				<td>
				<select type="select" id="t_zskbdxdy">
				     <option value=''></option>
				   <option value='0'>等于</option>
				     <option value='1'>大于</option>
				    <option value='-1' >小于</option>
				</select>
				</td>
		   	<td>
			   <input class="inputstyle" style="width:80px;" type="text" id="t_zskbbfb"  >%
			   	</td>
			</tr>
				</table>
			</td>
		</tr>
		<tr>
		    <td class="pagedistd">起始时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_qssj"></td>
			<td class="pagedistd">截止时间</td>
			<td class="pagetd"><input class="inputstyle" type="text" id="t_jzsj"></td>
			<td width="23%" class="pagetd" colspan="2">
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
<div id="skxxtj_detail" class="page-layout" src="#" style="top:20px; left:160px; width:800px;"></div>
<div id="ycskxx_detail" class="page-layout" src="#" style="top:20px; left:160px; width:800px;"></div>
<div id="dcskxx_detail" class="page-layout" src="#" style="top:20px; left:160px; width:800px;"></div>
<div id="ztxx_detail"  class="page-layout" src="#" style="top:20px; left:160px; width:800px;"></div>
<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_qybm" datatype="String" sumflag="0">场所编码</th>
	     	<th name="l_qymc" datatype="String" sumflag="0">场所名称</th>
	     	<th name="l_zrs" datatype="Integer" sumflag="0">总人数汇总</th>
	     	<th name="l_gzrs" datatype="Integer" sumflag="0">工作人数汇总</th>
	     	<th name="l_sskrs" datatype="Integer" sumflag="0">实际刷卡人数</th>
	     	<th name="l_ztskrs" datatype="Integer" sumflag="0">走台人次</th>
	     	<th name="l_zskbstring" datatype="String" sumflag="0">总刷卡比(%)</th>
	     	<th name="l_ycskrs" datatype="Integer" sumflag="0">一次刷卡人数</th>
	     	<th name="l_ycskbstring" datatype="String" sumflag="0">一次刷卡率(%)</th>
	     	<th name="l_dcskrs" datatype="Integer" sumflag="0">多次刷卡人数</th>
	     	<th name="l_dcskbstring" datatype="String" sumflag="0">多次刷卡率(%)</th>
	     	<th name="">操作</th>
	    </tr>
	  </thead>
	</table>
</div>
</body>