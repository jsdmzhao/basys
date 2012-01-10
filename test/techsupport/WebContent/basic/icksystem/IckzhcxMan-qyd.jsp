<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var gnRyHtml,gwRyHtml,QyHtml;
var clickNum = 0;
$(document).ready(function() {
	//从业人员详细信息页面
	gnRyHtml="basic/publicsystem/QyryxxDetail.jsp";
	gwRyHtml="basic/publicsystem/WgcyryxxDetail.jsp";
	//场所详细信息页面
	QyHtml="basic/publicsystem/QyjbxxDetail.jsp";
	
	pageUrl="icksystem/zhcxlist_icksl.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="icksystem/insert_ickyj.action";
	addHtml="basic/icksystem/IckyjAdd.jsp";
	addWidth="500";
	delUrl="icksystem/delete_ickyj.action";
	delid="d_ickyjid";
	modHtml="basic/icksystem/IckyjModify.jsp";
	modUrl="icksystem/modify_ickyj.action";
	modWidth="800";
	detailHtml="basic/icksystem/IckzhcxDetail.jsp";
	detailid="ickzh_detail";
	detailUrl="icksystem/query_icksl.action";
	detailWidth="800";
	loadPage("tabledata");
	$("#p_zkztbs").selectBox({code:"dm_zkzt"});
	$("#p_slyy").selectBox({code:"dm_ickslyy"});
	$("#p_sfzx").selectBox({state:"1"});
	
	daggleDiv("ickzh_detail");
	daggleDiv("qyjbxx_detail");
}); 

function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML,
										ingridPageWidth: pageWidth,
										onRowSelect: null,	
										colClasses: ['grid-col-style2','grid-col-style2','grid-col-style2'],
										colIndex: [0,1,7],
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
													var tdnum = $(tr).find("td").index(this);
													if(tdnum!=$(tr).find("td").length-1){
														if(tdnum==1 || tdnum==0)
															setRyDetail(tr);
														else if(tdnum==6)
															setQyDetail(tr);
														else if(tdnum==7)
															setIckDetail(tr);
													}
											});
										},
										url: url,	
										height: pageHeight-277,
										pageNumber: pageno,
										hideColIndex:[6],
										colWidths: ["22%","11%","6%","10%","14%","14%","0%","13%","10%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_cyrybh","String",1,60,null,0,"人员编号"))
			return false;
		if (!checkControlValue("p_kh","String",1,20,null,0,"IC卡卡号"))
			return false;
		if (!checkControlValue("p_xm","String",1,60,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_ywx","String",1,20,null,0,"英文姓"))
			return false;
		if (!checkControlValue("p_ywm","String",1,60,null,0,"英文名"))
			return false;
		if (!checkControlValue("p_sfzx","String",1,20,null,0,"是否注销"))
			return false;
		//if (!checkControlValue("p_qymc","String",1,60,null,0,"企业名称"))
		//	return false;
		if (!checkControlValue("p_zjhm","String",1,20,null,0,"证件号码"))
			return false;
		if (!checkControlValue("p_qzhm","String",1,20,null,0,"护照"))
			return false;
		if (!checkControlValue("p_zkztbs","String",1,2,null,0,"制卡状态"))
			return false;
		if (!checkControlValue("p_slyy","String",1,60,null,0,"申领原因"))
			return false;
		return true;
	}
	
//人员详细查询	
function setRyDetail(obj){
	dataid=$(obj).find("input[name='ryid"+$(obj).attr("id")+"']").val();
	sFlag="false";
	setWidth(detailid,modWidth);
	var rylbInput = $(obj).find("input[name='"+$(obj).attr("id")+"']");
	var rylbValue = rylbInput.val();
	$("#f_rylbbm").val(rylbValue);
	if(rylbValue == 0){
		detailUrl="publicsystem/query_qyryxx.action";
		setUrl(detailid,gnRyHtml);
	}else{
		detailUrl="publicsystem/query_publicwgcyryxx.action";
		setUrl(detailid,gwRyHtml);
	}
	bindDocument(detailid);
}

//场所详细查询
var qyjbxx_requestType;
var qyjbxx_dataid;
var qyjbxx_detailWidth="990";

function setQyDetail(obj){
	detailUrl="publicsystem/query_qyjbxx.action";
	qyjbxx_requestType="detail";
	qyjbxx_dataid=$(obj).find("input[name='qy"+$(obj).attr("id")+"']").val();
	setWidth("qyjbxx_detail",qyjbxx_detailWidth);
	setUrl("qyjbxx_detail",QyHtml);
	sFlag="false";
	bindDocument("qyjbxx_detail");
}
function qyjbxx_setDetail(){
	setParams("q_");
	jQuery.post("publicsystem/query_qyjbxx.action",params,qyjbxx_updatediv,"json");
}

//IC卡详细查询
function setIckDetail(obj){
	dataid=$(obj).attr("id");
	detailUrl="icksystem/queryZh_icksl.action";
	setWidth(detailid,modWidth);
	setUrl(detailid,detailHtml);
	bindDocument(detailid);
}

function setIckxq(id){
	dataid=id;
	detailUrl="icksystem/queryZh_icksl.action";
	setWidth(detailid,modWidth);
	setUrl(detailid,detailHtml);
	bindDocument("ickzh_detail");
}

// 行业类别	
//$("#p_hylbdm").selectBoxhylb();

/*	
function bindDocument(detailDiv){
	clickNum = 0;
	$(document).click(function(event){
 					var target = (event.target) ? event.target : event.srcElement;
 						var parents = $(target).parents();
 						var ishave = false;
 						for(var i=0;i<parents.length;i++){
 							if(parents.eq(i).attr("id")==detailDiv|| $(target).attr("id")==detailDiv || 
 								$(target).attr("id").indexOf("datepicker_div_")>-1){
 								ishave = true;
 								break;
 						}
 					}
 					if(!ishave){
 						if(clickNum!=0){
 							$('#'+detailDiv).hide("show");
 							$(document).unbind("click");
 						}
 					}
 						clickNum++;
	});
}	
*/
</script>

<body>
	<input type="hidden" id="f_rylbbm" />
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">IC卡综合查询</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
				   <!--  <td width="10%" class="pagedistd">行业类别</td>
		            <td width="23%" class="pagetd"><select  id="p_hylbdm" ></select></td>
		            -->
					<td width="10%" class="pagedistd">人员编号</td>
				    <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_cyrybh" /></td>
					<td width="10%" class="pagedistd">IC卡号</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_kh" /></td>
					<td width="10%" class="pagedistd">身份证号</td>
				    <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_zjhm" /></td>
				</tr>
				<tr>
				    <td width="10%" class="pagedistd">姓名</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_xm" /></td>
					<td width="10%" class="pagedistd">英文姓</td>
				    <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_ywx" /></td>
					<td width="10%" class="pagedistd">英文名</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_ywm" /></td>
				</tr>
				<tr>
				    <td width="10%" class="pagedistd">护照</td>
					<td width="23%" class="pagetd"><input type="text" class="inputstyle" id="p_qzhm" /></td>
					<td width="10%" class="pagedistd">制卡状态</td>
					<td width="23%" class="pagetd"><select id="p_zkztbs"><option></option></select></td>
					<td width="10%" class="pagedistd">申领原因</td>
					<td width="23%" class="pagetd"><select id="p_slyy"><option></option></select></td>
		        </tr>
		        <tr>
				    <td width="10%" class="pagedistd">IC卡是否注销</td>
					<td width="23%" class="pagetd"><select id="p_sfzx"><option></option>
						<option value="1">是</option><option value="0">否</option>
					</select></td>
					<!-- <td width="10%" class="pagedistd">企业名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_qymc" class="inputstyle" readonly></td>
					 -->
				    <td colspan="4">
	    		  <table border="0" align="right" cellpadding="0" cellspacing="0">
				  		<tr>
				          <td width="100%" ><a href="#" class="searchbutton"id="querys" onClick="setPageList(1);">查询</a></td>
				        </tr>
				  </table>
    		  	</td>
				</tr>
    	</table>
    </td>
  </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
<div id="ickzh_detail"  class="page-layout" src="#"
		style="top:20px;">
</div>	
	
<div id="qyjbxx_detail"  class="page-layout" src="#"
		style="display:none;top:20px; left:0px; width:500px;">
</div>
<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>       
	     	<!--  <th name="l_ickslid">序号</th>-->
	     	<th name="l_cyrybh">人员编号</th>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_xb" nowrap>性别</th>
	     	<th name="l_csrq">出生日期</th>
	     	<th name="l_gj">国籍</th>
	     	<th name="l_zjhm">证件号码</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_kh">IC卡卡号</th>
	     	<th name="l_zkztbs">制卡状态</th>
	    </tr>
	  </thead>
	</table>	
</div>
</body>