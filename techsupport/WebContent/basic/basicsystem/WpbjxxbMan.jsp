<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants"%>
<%
	User user = (User) session.getAttribute(Constants.userKey);
%>
<script type="text/javascript">
var daochuNum = 0;//是否可以导出Excle标志，0-无法导出，1-可以导出
$(document).ready(function() {
    searchLongUrl="basicsystem/queryForExport_wpbjxxb.action";
	pageUrl="basicsystem/querylist_wpbjxxb.action";
	divnid="WpbjxxbData";
	tableid="WpbjxxbTable";
	addUrl="basicsystem/insert_wpbjxxb.action";
	addHtml="basic/basicsystem/WpbjxxbAdd.jsp";
	addWidth="800";
	delUrl="basicsystem/delete_wpbjxxb.action";
	delid="d_bjxxid2";
	modHtml="basic/basicsystem/WpbjxxbModify.jsp";
	modUrl="basicsystem/modify_wpbjxxb.action";
	modWidth="800";
	detailHtml="basic/basicsystem/WpbjxxbDetail.jsp";
	detailid="wpbjxxb_detail";
	detailUrl="basicsystem/query_wpbjxxb.action";
	detailWidth="800";
	
	// Excel表头
	tabletitle = "";
	geteExcelHead(divnid);
	
	// ExcelURL
	excelUrl="basicsystem/getExcelCreateRz_wpbjxxb.action";
	
	loadPage(divnid);
	
	// 添加日期属性
	$("#p_bjsjks").datepicker(true);
	$("#p_bjsjjs").datepicker(true);
	$("#p_chjsjks").datepicker(true);
	$("#p_chjsjjs").datepicker(true);
	
	// 添加只读属性
	$("#p_bjsjks").attr("readonly","true");
	$("#p_bjsjjs").attr("readonly","true");
	$("#p_chjsjks").attr("readonly","true");
	$("#p_chjsjjs").attr("readonly","true");
	$("#s_gxdwmc").attr("readonly","true");
	
	// 添加下拉框
	// 行业类别选择框
	$("#p_hylbdm").selectBoxhylb({code:"dm_hylb"});
	// 处警结果选择框
	$("#p_cjjgdm").selectBox({code:"dm_cjjg"}); 
	// 所属单位
	$("#s_gxdwmc").click(function(){getGxdwTree("s_gxdwmc",null,"p_gxdwbm",null,null,null,null,null);});
	// 警情是否有效选择框
	$("#p_sfyxbjdm").selectBox({code:"dm_bez"}); 
	// 报警类型选择框
	$("#p_bjlxdm").selectBox({code:"dm_wpbjlx"});
	
	daggleDiv(detailid);
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										height: pageHeight-258,
										ingridPageParams:sXML,
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
												if($(tr).find("td").index(this)!=8){
													detail($(tr).attr("id")); 
												}
												});
										},
										changeHref:function(table){//若表格无数据，则点击导出不起作用
											$("#gnlkexcel").unbind("click");
											if($(table).find("tr").length==0){
													daochuNum = 0;
												}else{
													daochuNum = 1;
												}	
										},
										onRowSelect: null,
										pageNumber: pageno,
										hideColIndex:[4],
										colWidths: ["10%","20%","20%","10%","0%","10%","10%","10%","10%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_wpmc","String",1,30,null,0,"物品名称"))
			return false;
		if (!checkControlValue("p_ssqymc","String",1,100,null,0,"企业名称"))
			return false;
		if (!checkDateEarlier("p_bjsjks","报警时间（开始）","p_bjsjjs","报警时间（结束）"))
			return false;
		if (!checkDateEarlier("p_chjsjks","出警时间（开始）","p_chjsjjs","出警时间（结束）"))
			return false;
		if($("#p_checkbox").attr("checked")){
			$("#p_tyCheck").val("1");
		}else{
			$("#p_tyCheck").val("0");
		}
		return true;
	}
	
function getObject(obj){
	sFlag="false";
	//alert($(obj).attr("id")+"="+$(obj).text());
	if($(obj).text()=="新报警"){
		xbj($(obj).attr("id").substr(1,$(obj).attr("id").length-1));
	}
	if($(obj).text()=="回复"){
		var id = $(obj).attr("id").substr(1,$(obj).attr("id").length-1);
		if($("#"+id).find("td").eq(2).text()=="<%=user.getDepartment().getDepartname()%>"){
			cjhf(id);
		}else{
			return false;
		}
	}
	if($(obj).text()=="修改回复"){
		cjhf($(obj).attr("id").substr(1,$(obj).attr("id").length-1));
	}
	if($(obj).text()=="无效报警"){
		wxbj($(obj).attr("id").substr(1,$(obj).attr("id").length-1));
	}
}
	
function xbj(id){
	$("#current_recordBjlx").attr("value",$("#WpbjxxbData").find("tr[id='"+id+"']").find("td").eq(4).text()); //保存本记录的报警类型
	$("#m_bjxxid2").attr("value",id); // 保存本记录的报警信息id

	sFlag="false";
	setWidth(detailid,modWidth);

	$("#wpbjxxb_detail").empty();
	$("#wpbjxxb_detail").load("basic/basicsystem/PjxxAdd.jsp");
	$("#wpbjxxb_detail").show("slow"); 
   
	bindDocument("wpbjxxb_detail");
}

function wxbj(id){
	$("#current_recordBjlx").attr("value",$("#WpbjxxbData").find("tr[id='"+id+"']").find("td").eq(4).text()); //保存本记录的报警类型
	$("#m_bjxxid2").attr("value",id); // 保存本记录的报警信息id

	sFlag="false";
	setWidth(detailid,modWidth);

	$("#wpbjxxb_detail").empty();
	$("#wpbjxxb_detail").load("basic/basicsystem/WpbjxxbDetailWxbj.jsp");
	$("#wpbjxxb_detail").show("slow"); 
   
	bindDocument("wpbjxxb_detail");
}

function detail(id){
	$("#current_recordBjlx").attr("value",$("#WpbjxxbData").find("tr[id='"+id+"']").find("td").eq(4).text()); //保存本记录的报警类型
	$("#m_bjxxid2").attr("value",id); // 保存本记录的报警信息id

	sFlag="false";
	setWidth(detailid,modWidth);

	$("#wpbjxxb_detail").empty();
	$("#wpbjxxb_detail").load("basic/basicsystem/WpbjxxbDetail.jsp");
	$("#wpbjxxb_detail").show("slow"); 
   
	bindDocument("wpbjxxb_detail");
}

function cjhf(id){
	$("#current_recordBjlx").attr("value",$("#WpbjxxbData").find("tr[id='"+id+"']").find("td").eq(4).text()); //保存本记录的报警类型
	$("#m_bjxxid2").attr("value",id); // 保存本记录的报警信息id

	sFlag="false";
	setWidth(detailid,modWidth);

	$("#wpbjxxb_detail").empty();
	$("#wpbjxxb_detail").load("basic/basicsystem/WpbjxxCjhf.jsp");
	$("#wpbjxxb_detail").show("slow"); 
   
	bindDocument("wpbjxxb_detail");
}
	
//导出Excel
function setExportExcel(){	
  	if(daochuNum==1){
		if (manVerify()){
  			setSearchLong(); //传全部参数将查询结果放入json，对应后台Action方法中将结果集放入session，用于处理超长参数的数据导出
  		}
  	}else{
  		alert('无查询结果不能导出！');
  	}		
}
//导出前对应setSearchLong()的回调方法  由于执行查询时候有延迟，故将导出放入回调函数
function searchLongBack(json){  
		//报表标题
		var bbmc="报警信息";
		//报表请求
		setExcelLong("bjxxExcel",bbmc);	
}
</script>

<html>
<body>
    <%-- 当前选择的记录的报警类型，用来给子div用 --%>
    <input type="hidden" id="current_recordBjlx" value="">
    <%-- 当前选择的记录的报警信息ID，用来给子div用 --%>
    <input type="hidden" id="current_bjxxid" value="">
	<input type="hidden" id="p_tyCheck">
	<input type="hidden" id="m_bjxxid2" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
 <tr>
				<td class="tdbg">
					<table width="100%" border="0" cellspacing="0" cellpadding="2">
						<tr>
							<td width="5%" class="pagedistd">
								物品名称
							</td>
							<td width="21%" class="pagetd">
								<input type="text" class="inputstyle"  id="p_wpmc" value="">
								<label><input name="checkbox" type="checkbox" id="p_checkbox" style="width:20px">同音</label>
							</td>
							<td width="9%" class="pagedistd">
								行业类别
							</td>
							<td width="17%" class="pagetd">
								<select type="select" id="p_hylbdm">
								</select>
							</td>
							<td width="8%" class="pagedistd">
								企业名称
							</td>
							<td width="17%" class="pagetd">
								<input type="text" class="inputstyle"  id="p_ssqymc" value="">
							</td>
							<td width="8%" class="pagedistd">
								处警结果
							</td>
							<td width="16%" class="pagetd">
								<select type="select" id="p_cjjgdm" value="">
									<option></option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="pagedistd">
								报警时间
							</td>
							<td  class="pagetd">
								<input type="text" class="inputstyle"  id="p_bjsjks" value="">
							</td>
							<td class="pagedistd">
								至
							</td>
							<td  class="pagetd">
								<input type="text" class="inputstyle"  id="p_bjsjjs" value="">
							</td>
							<td class="pagedistd">
								所属单位
							</td>
							<td class="pagetd">
								<input type="hidden" id="p_gxdwbm" value="">
								<input type="text" class="inputstyle"  id="s_gxdwmc" value="">
							</td>
							<td class="pagedistd">
								报警类型
							</td>
							<td class="pagetd">
								<select type="select" id="p_bjlxdm" value="">
									<option></option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="pagedistd">
								出警时间
							</td>
							<td  class="pagetd">
								<input type="text" class="inputstyle"  id="p_chjsjks" value="">
							</td>
							<td class="pagedistd">
								至
							</td>
							<td  class="pagetd">
								<input type="text" class="inputstyle"  id="p_chjsjjs" value="">
							</td>
							<td  class="pagedistd">
								警情是否有效
							</td>
							<td  class="pagetd">
								<select type="select" id="p_sfyxbjdm">
									<option></option>
								</select>
							</td>
							<td colspan="5">
								<table width="150" border="0" align="right" cellpadding="2"
									cellspacing="0">
	                                <tr>
										<td width="25%" >
											<a href="#" class="searchbutton" id="querys"
												onClick="setPageList(1);">查询</a>
										</td>
										<td width="25%" >
											<a href="#" class="exceldcbutton" id='bjxxExcel' onclick='setExportExcel();'>导出</a>
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
<div id="wpbjxxb_detail" class="page-layout" src="#"
		style="top:10px; left:160px;">
</div>	

<!--Excel表头 
 	name domain的属性以l_开头；
 	datatyoe 数据类型 （字符 string,数字 number,日期 date）;
 	sumflag 0不合计，1合计-->
<div id="WpbjxxbData" style="width:100%;">
	<table id="WpbjxxbTable" width="100%">
	<thead>
		<tr>
		<th name="l_wpmc" datatype="String" sumflag="0">
		    物品名称
		</th>
		<th name="l_ssqymc" datatype="String" sumflag="0">
			企业名称
		</th>
		<th name="l_gxdwmc" datatype="String" sumflag="0">
			所属单位
		</th>
		<th name="l_bjsj" datatype="String" sumflag="0">
			报警时间
		</th>
		<th name="l_bjlxdm" datatype="String" sumflag="0">
			报警类型代码
		</th>
		<th name="l_bjlx" datatype="String" sumflag="0">
			报警类型
		</th>
		<th name="l_jqzt" datatype="String" sumflag="0">
			警情状态
		</th>
		<th name="l_chjjg" datatype="String" sumflag="0">
			处警结果
		</th>
		<th name="">
			操作
		</th>
		</tr>
	</thead>
    </table>	
</div>
</body>
</html>