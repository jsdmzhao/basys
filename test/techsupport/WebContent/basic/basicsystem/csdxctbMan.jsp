<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">

    var timeFlag = true;
    
    var xctb_detailidTopOffset;
    var xctb_detailidLeftOffset;
    var pageHeight1;
	$(document).ready(function() {
		pageUrl="basicsystem/querylistcs_xctb.action";
		divnid="XctbData";
		tableid="XctbTable";
		addUrl="basicsystem/insert_xctbhf.action";
		addHtml="basic/basicsystem/XctbAdd.jsp";
		addWidth="680";
		delUrl="basicsystem/delete_xctb.action";
		delid="d_tbid";
		modHtml="basic/basicsystem/XctbModify.jsp";
		modUrl="basicsystem/modify_xctb.action";
		modWidth="680";
		detailHtml="basic/basicsystem/XctbDetailcs.jsp";
		detailid="xctb_detail";
		detailUrl="basicsystem/query_xctb.action";
		detailWidth="700";
		
		if($("#offineFlag").attr("value")=='1'){
		   pageHeight1=	pageHeight-110;
		}else{
		   pageHeight1=	pageHeight-235;
		}
		loadPage(divnid);
		$("#p_fbkssj").attr("readonly","true");
		$("#p_fbkssj").datepicker();
		$("#p_fbjssj").attr("readonly","true");
		$("#p_fbjssj").datepicker();
		daggleDiv("xctb_detail");
	}); 
	
	function setPageList(pageno,url){	
		if (manVerify()){
			url=setList(pageno,url);
			rows = Math.ceil((pageHeight-205-25-23)/20);
			// create the grid
			// returns a jQ object with a 'g' property - that's ingrid
			var mygrid1 = $("#"+tableid).ingrid({ 
				url: url,	
				height: pageHeight1,
				pageNumber: pageno,
				onRowSelect: null,
			    ingridPageParams: sXML,
			    noSortColIndex:[4],
				colWidths: ["10%","25%","36%","16%","13%"]									
			});				
		}
	}
	
	function setQuery_xctbcs(id,url){
	  if(timeFlag){
	 	timeFlag = false;
		dataid=id;
		setWidth(detailid,detailWidth);
		setUrl(detailid,url);
		var xctb_detailidOffset = $("#"+detailid).offset();
		xctb_detailidTopOffset=xctb_detailidOffset.top;
		xctb_detailidLeftOffset=xctb_detailidOffset.left;
		bindDocument("xctb_detail");
		setTimeout(function(){timeFlag = true;},800);
      }
    }
		
	function manVerify(){
		if (!checkControlValue("p_bt","String",1,100,null,0,"标题"))
			return false;
		if (!checkDateEarlier("p_fbkssj","发布开始时间","p_fbjssj","发布结束时间","DATE")){
			return false;
		}
		return true;
	}
	function set_replay(id){	
		if(timeFlag){
		  	timeFlag = false;
			sFlag = "false";
			dataid = id;
			setWidth(detailid,700);
			setUrl(detailid,'basic/basicsystem/Xctbhf.jsp');
			var xctb_detailidOffset = $("#"+detailid).offset();
			xctb_detailidTopOffset=xctb_detailidOffset.top;
			xctb_detailidLeftOffset=xctb_detailidOffset.left;	
			bindDocument("xctb_detail");
			setTimeout(function(){timeFlag = true;},800);
	     }
	}
	/////回复情况查看
	function replaystatus(id){
		if(timeFlag){
		  	timeFlag = false;
			sFlag = "false";
			dataid = id;
			setWidth(detailid,680);
			setUrl(detailid,'basic/basicsystem/XctbhfAdd.jsp');
			var xctb_detailidOffset = $("#"+detailid).offset();
			xctb_detailidTopOffset=xctb_detailidOffset.top;
			xctb_detailidLeftOffset=xctb_detailidOffset.left;
			bindDocument("xctb_detail");
			setTimeout(function(){timeFlag = true;},800);
	     }
	}
	
	function setXiangQing(id){
		sFlag="false";
		dataid=id;
		setQuery_xctbcs(dataid,detailHtml,detailWidth); 
	} 
</script>

<body>
	
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
						<td width="10%" class="pagedistd">
							发布时间
						</td>
						<td width="23%" class="pagetd">
							<input type="text" class="inputstyle" id="p_fbkssj" value="">
						</td>
						<td width="10%" class="pagedistd">
							至
						</td>
						<td width="23%" class="pagetd">
							<input type="text" class="inputstyle" id="p_fbjssj" value="">
						</td>
						<td width="10%" class="pagedistd">
							标题
						</td>
						<td width="23%" class="pagetd">
							<input type="text" class="inputstyle" id="p_bt" value="">
						</td>
					</tr>
					<tr>
						<td colspan="6">
							<table border="0" align="right" cellpadding="2"
								cellspacing="0">
								<tr>
									<td>
										<a href="#" class="searchbutton" title="查询" id="querys" onClick="setPageList(1);">查询</a>
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
		<td height="6"></td>
	</tr>
</table>
<div id="xctb_detail"  class="page-layout" src="#"
		style="top:90px; left:160px; width:550px;">
</div>	

<div id="XctbData" style="width:100%; ">
	<table id="XctbTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_fbsj">发布时间</th>
	     	<th name="l_fbdw">发布单位</th>
	     	<th name="l_bt">标题</th>
	     	<th name="l_fbr">发布人</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
