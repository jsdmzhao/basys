<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants;"%>
<html>
	<head>
		<title>布控人员管理</title>
	</head>
	<%
		//登录用户ID，用于获得菜单
		int userid = 0;
		User user = new User();
		//获得登录用户session
		user = (User) session.getAttribute(Constants.userKey);
		if (user == null)
			response.sendRedirect("login.jsp");
		else
			userid = user.getUserid().intValue();
		String deptId = user.getDepartment().getDepartcode().toString();
	%>
	<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_bkry.action";
	divnid="BkryData";
	tableid="BkryTable";
	addUrl="basicsystem/insert_bkry.action";
	addHtml="basic/basicsystem/BkryAdd.jsp";
	addWidth="740";
	delUrl="basicsystem/delete_bkry.action";
	delid="d_bkryid";
	modHtml="basic/basicsystem/BkryModify.jsp";
	modUrl="basicsystem/modify_bkry.action";
	modWidth="720";
	detailHtml="basic/basicsystem/BkryDetail.jsp";
	detailid="bkry_detail";
	detailUrl="basicsystem/query_bkry.action";
	detailWidth="720";
	loadPage(divnid);
		$("#p_csrq").attr("readonly","true");
		$("#p_csrq").datepicker();
		$("#p_csrq2").attr("readonly","true");
		$("#p_csrq2").datepicker();
		$("#p_tbsj").attr("readonly","true");
		$("#p_tbsj").datepicker();
		$("#p_bkczsj").attr("readonly","true");
		$("#p_bkczsj2").datepicker();
		$("#p_bkczsj2").attr("readonly","true");
		$("#p_bkczsj").datepicker();
		$("#p_bkdqsj").attr("readonly","true");
		$("#p_bkdqsj").datepicker();
		$("#p_sprq").attr("readonly","true");
		$("#p_sprq").datepicker();
		$("#p_cksj").attr("readonly","true");
		$("#p_cksj").datepicker();
		$("#p_ckczsj").attr("readonly","true");
		$("#p_ckczsj").datepicker();
		$("#p_cksprq").attr("readonly","true");
		$("#p_cksprq").datepicker();
		
		 $("#p_xb").selectBox({code:"dm_xb"});
		 $("#p_bkfw").selectBox({code:"dm_bkfw"});
		  $("#p_jg").click(function(){
			getDict_item("p_jg","p_jgdm","dm_xzqh");
			});
			
		$("#p_hylbdm").selectBoxhylb();//行业类别
			
		$("#p_shsftg").selectBox({code:"dm_bez"});
	   
	daggleDiv("bkry_detail");
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										noSortColIndex:[9],	
										ingridPageParams:sXML,
										height:  pageHeight-280,
										pageNumber: pageno,
										colWidths: ["10%","15%","10%","5%","10%","10%","10%","10%","10%","10%"]	
									});				
		}
}	
	function manVerify(){
		$("#m_dqrq").val(TimeObject().fullYear+"-"+TimeObject().month+"-"+TimeObject().date);
	    if (!checkControlValue("p_xm","String",1,100,null,0,"姓名"))
			return false;
		if (!checkControlValue("p_gmsfhm","String",1,20,null,0,"身份证号码"))
			return false;
        if (!checkControlValue("p_csrq","Date",null,null,null,0,"出生日期"))
			return false;
		if (!checkControlValue("p_jg","String",1,100,null,0,"籍贯"))
			return false;
	    if (!checkControlValue("p_xb","String",1,2,null,0,"性别"))
			return false;
		if (!checkControlValue("p_bkczsj","Date",null,null,null,0,"布控操作时间"))
			return false;
		if (!checkControlValue("p_bkfw","String",1,300,null,0,"布控范围"))
			return false;
	    if (!checkDateEarlier("p_csrq", "开始出生日期", "m_dqrq", "当前日期", "DATE")) 
            return false;
	    if (!checkDateEarlier("p_csrq", "开始出生日期", "p_csrq2", "结束出生日期", "DATE")) 
	       return false;
	    if (!checkDateEarlier("p_bkczsj", "开始布控操作时间", "m_dqrq", "当前时间", "DATE")) 
	       return false;
	    if (!checkDateEarlier("p_bkczsj", "开始布控操作时间", "p_bkczsj2", "结束布控操作时间", "DATE")) 
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
		var par=$(obj).attr("id").split("_");
		if(par[0]=="setModify"){
			setModifyQuery(par[1]);
		}else{
			setDelete(par[1]);
		}
	}
	
</script>
	<body>
		<input type="hidden" id="d_bkryid" value="">
		<input type="hidden" id="m_dqrq">
		<input type="hidden" id="p_flag" value="manage">
		<input type="hidden" id="p_tyCheck">
		<input type="hidden" id="p_fwdwbm" value="<%=deptId%>">
		<table width="100%" cellpadding="0" cellspacing="0"
			class="tableborder">
			<tr>
				<td class="queryfont">
					布控人员管理
				</td>
			</tr>
			<tr>
				<td class="tdbg">
					<table width="100%" border="0" cellspacing="0" cellpadding="2">
						<tr>
							<td width="10%" class="pagedistd">
								姓名
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" id="p_xm" value="">
								<label>
									<input name="checkbox" type="checkbox" id="p_checkbox"
										style="width: 20px">
									同音
								</label>
							</td>
							<td width="10%" class="pagedistd">
								公民身份号码
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" id="p_gmsfhm" value="">
							</td>
							<td width="10%" class="pagedistd">
								出生日期
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle1" id="p_csrq" value="">
								至
								<input type="text" class="inputstyle1" id="p_csrq2" value="">
							</td>
						</tr>
						<tr>
							<td width="10%" class="pagedistd">
								布控范围
							</td>
							<td class="pagetd">
								<select type="select" id="p_bkfw" value="">
									<option></option>
								</select>
							</td>
							<td width="10%" class="pagedistd">
								性别
							</td>
							<td width="23%" class="pagetd">
								<select type="select" id="p_xb" value="">
									<option></option>
								</select>
							</td>
							<td width="10%" class="pagedistd">
								布控操作时间
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle1" id="p_bkczsj" value="">
								至
								<input type="text" class="inputstyle1" id="p_bkczsj2" value="">
							</td>
						</tr>
						<tr>
							<td width="10%" class="pagedistd">
								籍贯
							</td>
							<td width="23%" class="pagetd">
								<input type="text" class="inputstyle" id="p_jg" readonly />
								<input type="hidden" id="p_jgdm" />
							</td>

							<td class="pagedistd">
								是否已审核
							</td>
							<td class="pagetd">
								<select type="select" id="p_shsftg" value="">
									<option></option>
								</select>
							</td>
							<td class="pagedistd">
								行业类别
							</td>
							<td class="pagetd">
								<select type="select" id="p_hylbdm" value="">
								</select>
							</td>
						</tr>
						<tr>
							<td colspan="5" class="pagedistd">
								&nbsp;
							</td>
							<td class="pagetd">
								<table width="90" border="0" align="right" cellpadding="2"
									cellspacing="0">
									<tr>
										<td width="54%">
											<a href="#" class="searchbutton" id="querys"
												onclick="setPageList(1);">查询</a>
											<!-- <a href="#" class="submitbutton" onclick=''>高级查询</a> -->
										</td>
										<td width="46%">
											<a href="#" class="addbutton" onclick='setAddPage()'>添加</a>
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
					<div id="bkry_detail" class="page-layout" src="#"
						style="top: 100px; left: 160px; width: 500px;">
					</div>

					<div id="BkryData" style="width: 100%;">
						<table id="BkryTable" width="100%">
							<thead>
								<tr>
									<th name="l_xm">
										姓名
									</th>
									<th name="l_gmsfhm">
										公民身份号码
									</th>
									<th name="l_csrq">
										出生日期
									</th>
									<th name="l_xb">
										性别
									</th>
									<th name="l_minzu">
										民族
									</th>
									<th name="l_jg">
										籍贯
									</th>
									<th name="l_bkfw">
										布控范围
									</th>
									<th name="l_bkczsj">
										布控操作时间
									</th>
									<th name="l_bkdqsj">
										布控到期时间
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
