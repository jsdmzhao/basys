<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	var pfsk_detailid = "pfsk_detail";
	var pfsk_skgjHtml = "basic/icksystem/pfsk-skgjMan.jsp";
	var date = new Date();
	//var nowTime = date.getYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
	var oldTime = new Date();
	oldTime.setDate(date.getDate() - 7);

	$(document).ready(function() {
		$("#"+pfsk_detailid).hide();
		pageUrl="icksystem/querylistPfsk_qyryskjl.action";
		divnid="tabledata";
		tableid="table1";
		geteExcelHead("tabledataExcel");
		loadPage("tabledata");
		
	  	$("#manbq_relation").selectBox({state:"temp",width:"80px"});
	  	initTJDate();
	  	$("#t_sksjf").attr("readonly","true").attr("value",tomorrowDate).datepicker();
		$("#t_sksjt").attr("readonly","true").attr("value",currentDate).datepicker();
		$("#t_skcs").attr("value","1");
		relationChange();
		excelUrl="icksystem/querylistPfskExcel_qyryskjl.action";
		searchLongUrl="icksystem/querylistPfskExcelTemp_qyryskjl.action";
		$("#t_hylbdm").selectBoxhylb();
		$("#t_gxdwmc").click(function(){// 管辖单位
		getGxdw("t_gxdwmc","t_gxdwbm");
	});
	}); 
	
	function setPageList(pageno,url){
		url=setList(pageno,url);
		setParams("t_"); //传参
		var mygrid1 = $("#"+tableid).ingrid({
				ingridPageParams:sXML,
				url: url,
				height: pageHeight-238,
				pageNumber: pageno,
				colWidths: ["25%","20%","25%","15%","15%"],
				onRowSelect: function(tr, selected){},
				onTdSelect: function(tr){
					var thisIds = $(tr).attr("id"); 
					var ryid = thisIds.split("___")[1].split("---")[0];
					var cyrylb = thisIds.split("___")[1].split("---")[1].split("===")[0];
					var hylbdm = thisIds.split("===")[1];
					
					var cyrybh = $(tr).find("td").eq(0);
					cyrybh.html("<a href='#' class='hyperlink' onClick=ryMessage('"+ryid+"','"+cyrylb+"','"+hylbdm+"');>"+cyrybh.text()+"</a>");
					var xm = $(tr).find("td").eq(1);
					xm.html("<a href='#' class='hyperlink' onClick=ryMessage('"+ryid+"','"+cyrylb+"','"+hylbdm+"');>"+xm.text()+"</a>");
				},
				sorting: false
		});
	}
	function searchPageList(obj){
		if(manVerify()){
			setPageList(obj);
		}
	}
	function manVerify(){
		var t_sksjf = $("#t_sksjf").attr("value");
		var t_sksjt = $("#t_sksjt").attr("value");
		if(t_sksjf!=''&&t_sksjt!=''&&formatDate(t_sksjf)-formatDate(t_sksjt)>0){
			jAlert("请正确选择起始和截至日期!","提示信息");
			return false;
		}
		if (!checkControlValue("t_skcs","Integer",-999999999,999999999,null,1,"刷卡次数"))
			return false;
		return true;
	}
	function formatDate(strDate){ //转换成日期格式
		var riqi = strDate.split("-");
		return new Date(riqi[0],(riqi[1]-1),riqi[2]);
	}
	function relationChange(){ //大于等于
		var relation = $("#manbq_relation").attr("value");
		$("#t_bds").attr("value",relation);
	}
	function setSkgj(obj){ //刷卡轨迹
		pfsk_dataid = obj.split("___")[0]; //从业人员编号
		setWidth(pfsk_detailid,600);
		setUrl(pfsk_detailid,pfsk_skgjHtml);
		bindDocument(pfsk_detailid);
	}
	var cscxCyrx_gnRyHtml="business/Ylfwzagl/CyryxxDetail-cjd.jsp"; //国内人员信息
	var cscxCyrx_gnRyWidth="800";
	var cscxCyrx_wgRyHtml="business/Ylfwzagl/CyryxxDetail-wg-cjd.jsp"; //外国人员信息
	var cscxCyrx_wgRyWidth="800";
	var detailUrl = "";
	var detailWidth = 800;
	
	function ryMessage(ryid,gnorgw,hylbdm){ //从业人员详情
		dataid=ryid;
		//根据不同的行业类别显示不同的人员详细页面
		//if(hylbdm=='J')
		//{
			if(gnorgw=='0'){ //国内
				detailUrl="publicsystem/query_qyryxx.action";
				setWidth(pfsk_detailid,cscxCyrx_gnRyWidth);
				setUrl(pfsk_detailid,cscxCyrx_gnRyHtml);
				bindDocument(pfsk_detailid);
			}
			if(gnorgw=='1'){ //境外
				detailUrl="publicsystem/query_publicwgcyryxx.action";
				setWidth(pfsk_detailid,cscxCyrx_wgRyWidth);
				setUrl(pfsk_detailid,cscxCyrx_wgRyHtml);
				bindDocument(pfsk_detailid);
			}
		//}
	}
	function setExportExcel(){
		if(manVerify()){
			setSearchLong();
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
		var bbmc="频繁刷卡统计";
		//报表请求
		setExcelLong("pfskxxExcel",bbmc);	
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
</script>

<body>
<input type="hidden" id="t_bds" value="0">
<input type="hidden" id="t_gxdwbm" value=""/>
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">频繁刷卡</td>
  </tr>
  <tr>
    <td valign="top" class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
    			<tr>
				  <td width="7%" class="pagedistd">行业类别</td>
				  <td width="21%" class="pagetd"><select type="select" id="t_hylbdm"></td>
				  <td width="11%" class="pagedistd">管辖单位</td>
				  <td width="22%" class="pagetd"><input type="text" class="inputstyle" id="t_gxdwmc" value="" readonly></td>
				<td width="10%" class="pagedistd">刷卡次数</td>
			      <td class="pagetd" width="29%">
                  <table><tr><td><select name="manbq_relation" id="manbq_relation" style="width:60px;" onchange="relationChange();">
                    <option value="1">大于</option>
                    <option value="0">等于</option>
				  <option value="-1">小于</option>
                  </select>
                    </td>
                      <td><input type="text" class="inputstyle"  id="t_skcs" style="width:60px;"></td>
                  </tr></table>
			      </td>
				</tr>
				<tr>
				  <td width="10%" class="pagedistd">起始时间</td>
				  <td width="23%" class="pagetd"><input class="inputstyle" type="text" id="t_sksjf"></td>
				  <td width="10%" class="pagedistd">截止时间</td>
				  <td width="23%" class="pagetd"><input class="inputstyle" type="text" id="t_sksjt"></td>
				  <td class="pagetd" colspan='3'>
				  	<table width="124px" border="0" align="right" cellpadding="2" cellspacing="0">
					<tr>
					<td><a href="#" class="searchbutton" id="querys2" onClick="searchPageList(1);">查询</a></td>
					<td><a href="#" class="exceldcbutton" onClick="setExportExcel()" id="pfskxxExcel">导出</a></td>
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
<div id="pfsk_detail" class="page-layout" src="#" style="top:20px; left:160px; width:500px;"></div>	

<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<th>从业人员编号</th>
	     	<th>姓名</th>
	     	<th>证件号码</th>
	     	<th>刷卡次数</th>
	     	<th>刷卡轨迹</th>
	    </tr>
	  </thead>
	  
	</table>	
</div> 
<div id="tabledataExcel" style="display:none">
	<table id="table1Excel" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_cyrybh" datatype='String' sumflag='0'>从业人员编号</th>
	     	<th name="l_xm" datatype='String' sumflag='0'>姓名</th>
	     	<th name="l_zjhm" datatype='String' sumflag='0'>证件号码</th>
	     	<th name="l_skcs" datatype='String' sumflag='0'>刷卡次数</th>
	    </tr>
	  </thead>
	  
	</table>	
</div> 
</body>