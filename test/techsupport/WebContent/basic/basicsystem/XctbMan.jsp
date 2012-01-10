<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">

    var timeFlag = true;

    var xctb_detailidTopOffset;
    var xctb_detailidLeftOffset;
	$(document).ready(function() {
		pageUrl="basicsystem/querylistcx_xctb.action";
		divnid="XctbData";
		tableid="XctbTable";
		addUrl="basicsystem/insert_xctb.action";
		addHtml="basic/basicsystem/XctbAdd.jsp";
		addWidth="686";
		delUrl="basicsystem/delete_xctb.action";
		delid="d_tbid";
		modHtml="basic/basicsystem/XctbModify.jsp";
		modUrl="basicsystem/modify_xctb.action";
		modWidth="686";
		detailHtml="basic/basicsystem/XctbDetail.jsp";
		detailid="xctb_detail";
		detailUrl="basicsystem/query_xctb.action";
		detailWidth="686";
		loadPage(divnid);
		$("#p_fbkssj").attr("readonly","true");
		$("#p_fbkssj").datepicker();
		$("#p_jzrq").attr("readonly","true");
		$("#p_jzrq").datepicker();
		$("#p_fbjssj").attr("readonly","true");
		$("#p_fbjssj").datepicker();
        $("#gqbs").selectBox({state:"dm_hyzk"});
	    $("#p_sxhylbdm").selectBoxhylb();//行业类别
	    bc_bottonMoveRight(5,"查询");
		daggleDiv("xctb_detail");
	}); 
	
	function setPageList(pageno,url){	
		if (manVerify()){
			url=setList(pageno,url);
			rows = Math.ceil((pageHeight-235-25-23)/20);
			// create the grid
			// returns a jQ object with a 'g' property - that's ingrid
			var mygrid1 = $("#"+tableid).ingrid({ 
					url: url,	
					height: pageHeight-275,
					pageNumber: pageno,
					ingridPageParams: sXML,
					onRowSelect: null,
					noSortColIndex:[4],
					colWidths: ["10%","25%","32%","23%","10%"]							
			});				
		}
	}
			
	function manVerify(){
		if (!checkControlValue("p_bt","String",1,100,null,0,"标题"))
			return false;
		if (!checkControlValue("p_fbkssj","Date",null,null,null,0,"发布开始时间"))
			return false;
		if (!checkControlValue("p_fbjssj","Date",null,null,null,0,"发布结束时间"))
			return false;
		if (!checkControlValue("p_fbr","String",1,100,null,0,"发布人"))
			return false;
		if (!checkControlValue("p_fbdw","String",1,200,null,0,"发布单位"))
			return false;
		//if (!checkControlValue("p_hylx","String",1,100,null,0,"行业类型"))
			//return false;
		if (!checkDateEarlier("p_fbkssj","发布开始时间","p_fbjssj","发布结束时间","DATE")){
			return false;
		}
		return true;
	}
  $("#p_fbdw").click(function(){
		//getGxdwTree("p_fbdw","p_fbdwbm",'0');
		//getGxdw("p_fbdw","p_fbdwbm");
		getGxdwTree("p_fbdw","p_fbdwbm",null,null,null,null,null,null);
  });
  /////select表单 赋值
  function changegqbs(){
     $("#p_gqbs").attr("value",$("#gqbs").attr("value"));
  }

  function setXiangQing(id){
		sFlag="false";
		dataid=id;
		setQuery_xctbcx(dataid,detailHtml,detailWidth); 
  }

  //重写查询的方法
	function setQuery_xctbcx(id,url){
	 if(timeFlag){
	    timeFlag = false;
		dataid=id;
		setWidth(detailid,detailWidth);
		setUrl(detailid,url);
		bindDocument(detailid);
		var xctb_detailidOffset = $("#"+detailid).offset();
		xctb_detailidTopOffset=xctb_detailidOffset.top;
		xctb_detailidLeftOffset=xctb_detailidOffset.left;
	  	setTimeout(function(){timeFlag = true;},800);
	   }
	 }
 
</script>

<body>
	<input type="hidden" id="p_gqbs">
	<input type="hidden" id="d_tbid" value="">
	<table width="100%" cellpadding="0" cellspacing="0" class="tableborder">
		<tr>
			<td class="queryfont">
				通知通告查询
			</td>
		</tr>
		<tr>
			<td class="tdbg">
				<table width="100%" border="0" cellspacing="0" cellpadding="2">
					<tr>
						<td width="11%" class="pagedistd">
							发布时间
						</td>
						<td width="22%" class="pagetd">
							<input type="text" class="inputstyle" id="p_fbkssj" />
						</td>
						<td width="11%" class="pagedistd">
							至
						</td>
						<td width="22%" class="pagetd">
							<input type="text" class="inputstyle" id="p_fbjssj" />
						</td>
						<td width="11%" class="pagedistd">
							发布单位
						</td>
						<td width="22%" class="pagetd">
							<input type="text" class="inputstyle" id="p_fbdw" readonly />
							<input type="hidden" id="p_fbdwbm" />
						</td>
					</tr>
					<tr>
						<td class="pagedistd">
							标题
						</td>
						<td class="pagetd">
							<input type="text" class="inputstyle" id="p_bt" value="">
						</td>
						<td class="pagedistd">
							发布人
						</td>
						<td class="pagetd">
							<input type="text" class="inputstyle" id="p_fbr" value="">
						</td>
						<td class="pagedistd">
							是否撤销
						</td>
						<td class="pagetd">
							<select id="gqbs" onChange="changegqbs();">
								<option value=""></option>
								<option value="0">
									未撤销
								</option>
								<option value="1">
									已撤销
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td width="10%" class="pagedistd">
							行业类别
						</td>
						<td width="23%" class="pagetd">
							<select type="select" id="p_sxhylbdm" value=""
								onChange="changegqbs();">
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="6">
							<table border="0" align="right" cellpadding="0"
								cellspacing="0">
								<tr>
									<td>
										<a href="#" class="searchbutton" id="querys" title="查询" onClick="setPageList(1);">查询</a>
									</td>
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
	<div id="xctb_detail" class="page-layout" src="#"
		style="top: 30px; left: 160px;; overflowY: scroll;">
	</div>

	<div id="XctbData" style="width: 100%;">
		<table id="XctbTable" width="100%">
			<thead>
				<tr>
					<th name="l_fbsj">
						发布时间
					</th>
					<th name="l_fbdw">
						发布单位
					</th>
					<th name="l_bt">
						标题
					</th>
					<th name="l_fbr">
						发布人
					</th>
					<th name="">
						操作
					</th>
				</tr>
			</thead>

		</table>
	</div>



</body>
