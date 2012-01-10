<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="publicsystem/querylistGadBG_qyryxx.action";
	divnid="tabledata";
	tableid="table1";
    detailHtml="basic/publicsystem/QyryxxDetail-gzth.jsp";
	detailid="cyryxx_detail";
	detailUrl="publicsystem/query_qyryxx.action";
	detailWidth="800";
	loadPage("tabledata");
	
  	$("#p_xbdm").selectBox({code:"dm_xb"});
 	hy_gwselectBox("p_hylbdm","p_gwbh");
 	$('#p_hylbdm').change(function(){
 		hy_gwselectBox("p_hylbdm","p_gwbh");
 	});
 	
	daggleDiv("cyryxx_detail");
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML,
										ingridPageWidth: pageWidth,
										url: url,	
										height: pageHeight-260,
										pageNumber: pageno,
										colWidths: ["10%","14%","14%","8%","14%","12%","10%","10%","8%"]										
									});				
		}
}	

	
//从业人员详情
function setCyryXq(id){
    sFlag="false";
	dataid=id;
	setWidth(detailid,950);
	setUrl(detailid,"basic/publicsystem/CyrylsxxMan-gn.jsp");
	bindDocument("cyryxx_detail");
}

	function manVerify(){
		return true;
	}
//企业筛选框
 $("#p_qymc").click(function(){
 	dataid=$('#p_hylbdm').val();
	getTy_item("p_qymc","p_qybm");
});
	
</script>

<body>

	<input type="hidden" id="d_ryid" value="">
	<table width="100%" cellpadding="0" cellspacing="0" class="tableborder">
		<tr>
			<td class="queryfont">
				国内从业人员变更查询
			</td>
		</tr>
		<tr>
			<td valign="top" class="tdbg">
				<table width="100%" border="0" cellspacing="0" cellpadding="2">
					<tr>
						<td width="10%" class="pagedistd">
							行业类别
						</td>
						<td width="27%" class="pagetd">
							<select name="cylb" id="p_hylbdm">
							</select>
						</td>
						<td width="10%" class="pagedistd">
							岗位类别
						</td>
						<td width="25%" class="pagetd">
							<select name="cylb" id="p_gwbh">
								<option></option>
							</select>
						</td>
						<td width="10%" class="pagedistd">
							姓名
						</td>
						<td width="23%" class="pagetd">
							<input type="text" class="inputstyle" id="p_xm" />
						</td>
					</tr>
					<tr>
						<td width="10%" class="pagedistd">
							性别
						</td>
						<td width="23%" class="pagetd">
							<select name="select" id="p_xbdm">
								<option></option>
							</select>
						</td>
						<td width="10%" class="pagedistd">
							公民身份号码
						</td>
						<td width="23%" class="pagetd">
							<input type="text" class="inputstyle" id="p_zjhm" />
						</td>
						<td width="10%" class="pagedistd">
							从业人员编号
						</td>
						<td width="23%" class="pagetd">
							<input type="text" class="inputstyle" id="p_cyrybh" />
						</td>
					</tr>
					<tr>
						<td width="10%" class="pagedistd">
							企业名称
						</td>
						<td width="23%" class="pagetd">
							<input type="hidden" id="p_qybm" />
							<input type="text" class="inputstyle" id="p_qymc" readonly />
						</td>
						<td width="10%" class="pagedistd">
							&nbsp;
						</td>
						<td colspan="3" width="23%" class="pagetd">
							<table width="60" border="0" align="right" cellpadding="0"
								cellspacing="0">
								<tr>
									<td height="28px">
										<a href="#" class="searchbutton" id="querys"
											onClick="setPageList(1);">查询</a>
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
	<div id="cyryxx_detail" class="page-layout" src="#"
		style="top: 20px; left: 160px; width: 500px;">
	</div>

	<div id="tabledata" style="width: 100%;">
		<table id="table1" width="100%">
			<thead>
				<tr>
					<th name="l_xm">
						姓名
					</th>
					<th name="l_zjhm">
						公民身份证号码
					</th>
					<th name="l_cyrybh">
						从业人员编号
					</th>
					<th name="l_xb">
						性别
					</th>
					<th name="l_qymc">
						企业名称
					</th>
					<th name="l_gwmc">
						岗位类别
					</th>
					<th name="l_zcsj">
						注册时间
					</th>
					<th name="l_cyryzt">
						从业人员状态
					</th>
					<th name="">
						操作
					</th>
				</tr>
			</thead>

		</table>
	</div>
</body>