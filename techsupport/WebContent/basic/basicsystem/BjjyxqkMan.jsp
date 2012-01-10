<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script language="javascript" type="text/javascript" src="javascript/dictDropDown.js"> </script>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_bjjsx.action";
	divnid="BjjsxData";
	tableid="BjjsxTable";
	addUrl="basicsystem/insert_bjjsx.action";
	addHtml="basic/basicsystem/BjjsxAdd.jsp";
	addWidth="500";
	delUrl="basicsystem/delete_bjjsx.action";
	delid="d_bjjxh";
	modHtml="basic/basicsystem/BjjsxModify.jsp";
	modUrl="basicsystem/modify_bjjsx.action";
	modWidth="500";
	detailHtml="basic/basicsystem/BjjsxDetail.jsp";
	detailid="bjjsx_detail";
	detailUrl="basicsystem/query_bjjsx.action";
	detailWidth="300";
	//loadPage(detailid);
	tables=$("#BjjsxData").html();
	$("#bjjsx_detail").hide();
	$("#"+tableid).ingrid({ 
							url: "#",	
							height: pageHeight-205,
							onRowSelect: null,
							pageNumber: 0,
							colWidths: ["20%","20%","20%","20%","20%"]									
						});
									
	$("#p_gajgmc").click(function(){//getGxdwTree("p_gajgmc","p_gajgbm","1");
	getGxdwTree("p_gajgmc",null,"p_gajgbm",null,null,null,null,null);});
	   
	daggleDiv("bjjsx_detail");
}); 
	
function setPageList(pageno,url){
	if(url!='#')	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										height: pageHeight-205, 
										onRowSelect: null,
										pageNumber: pageno,
										ingridPageParams:sXML,
										colWidths: ["20%","20%","20%","20%","20%"]									
									});				
		}
}	
function manVerify(){
	if (!checkControlValue("p_gajgmc","String",1,100,null,1,"公安机关名称"))
		return false;
	if (!checkControlValue("p_yscsxsjdjg","Integer",-999999,999999,null,1,"与上次刷新时间间隔"))
		return false;
	return true;
}
</script>
<html/>
<body>
	<input type="hidden" id="d_bjjxh" value="">
	<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
		<tr>
			<td class="queryfont">
				报警机刷新</td>
		</tr>
		<tr>
			<td class="tdbg">
				<input type="hidden" id="p_gajgbm" value="">
				<table width="100%" border="0" cellspacing="0" cellpadding="2">
					<tr>
						<td width="10%" class="red">
							公安机关
						</td>
						<td width="23%" class="pagetd">
							<input type="text" class="inputstyle" id="p_gajgmc" readonly="readonly"/>
						</td>
						<td width="14%" class="red">
							时间间隔(分钟)
						</td>
						<td width="30%" class="pagetd">
							<input type="text" class="inputstyle"  id="p_yscsxsjdjg" value="">
						</td>
						<td width="23%" class="pagetd">
							<table width="62" border="0" align="right" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="100%" >
										<a href="#" class="searchbutton" id="querys"
											onclick="setPageList(1);">查询</a>
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
	<div id="bjjsx_detail"  class="page-layout" src="#"
		style="top: 180px; left: 160px; width: 500px;">
	</div>
	<div id="BjjsxData" style="width:100%;">
		<table id="BjjsxTable" width="100%">
			<thead>
				<tr>
					<th name="l_gajgbm">
						公安机关编码
					</th>
					<th name="l_gajgmc">
						公安机关名称
					</th>
					<th name="l_bjjipdz">
						报警机IP地址
					</th>
					<th name="l_bjjsxj">
						报警机刷新时间
					</th>
					<th name="l_yscsxsjdjg">
						与上次刷新时间间隔(秒)
					</th>
	    </tr>
	  </thead>
		</table>
	</div>
</body>
</html>