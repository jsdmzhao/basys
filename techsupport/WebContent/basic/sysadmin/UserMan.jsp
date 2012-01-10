<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%@page import="com.aisino2.sysadmin.domain.Department"%>
<%
User user = (User)session.getAttribute(Constants.userKey);
String jzlbdm = "";
String jzlbmc = "";
String isSjyh = "1";
if(user!=null){
	jzlbdm = user.getJzlbdm();
	jzlbmc = user.getJzlbmc();
	if(jzlbdm==null||"".equals(jzlbdm)){
		jzlbdm = "";	jzlbmc = "";
	}
	Department department = user.getDepartment();
	if("0".equals(""+department.getParentdepartid())){ //省级用户
		isSjyh = "0";
	}
}
%>
<html>
<head>
<script type="text/javascript">
	var jzlbdm = '<%=jzlbdm %>';
	var jzlbmc = '<%=jzlbmc %>';
	var isSjyh = '<%=isSjyh %>';
	var moveSelectId;
	var pageHeigthOffset = 0;
	$(document).ready(function() {
		pageHeigthOffset = 224;
		resetPwdUrl="sysadmin/redoUserPwd_user.action";
		pageUrl="sysadmin/querylist_user.action";
		divnid="tabledata";
		tableid="table1";
		addUrl="sysadmin/insert_user.action";
		addHtml="basic/sysadmin/UserAdd.jsp";
		addWidth="540";
		delUrl="sysadmin/delete_user.action";
		modHtml="basic/sysadmin/UserModify.jsp";
		modUrl="sysadmin/modify_user.action";
		modWidth="540";
		detailHtml="basic/sysadmin/UserDetail.jsp";
		detailid="user_detail";
		detailUrl="sysadmin/query_user.action";
		detailWidth="400";
		delid="d_userid";
		$("#bq_jzlbdm").selectBox({code:"dm_jzlb"});
		if(jzlbdm!=''){
			$("#bq_jzlbdm").setValue(jzlbdm);
			$("#p_jzlbdm").attr("value",jzlbdm);
		}
		if(isSjyh=='1'){ //非省级用户锁定
			$("#bq_jzlbdm").setAttr("readonly","true");
			yincangJzMan(); //隐藏警种字段 20100329 杨提出
		}
		loadPage("tabledata");
		setPageList(1);
	 	daggleDiv("user_detail");
	}); 
	function setPageListTemp(obj){
		var departid = $("#p_departid").attr("value");
		if(departid==null||departid=='null'||departid==''||departid=='0'){
			jAlert('请选择机构!','提示信息');
			return;
		}
		setPageList(obj);
	}
	function setPageList(pageno,url){
		url=setList(pageno,url);
		setParams("p_");
		var departid = $("#p_departid").attr("value");
		if(departid==null||departid=='null'||departid==''||departid=='0'){
			url="#";
		}
		
		var useraccount = $("#p_useraccount").attr("value");
		var username = $("#p_username").attr("value");
		if(useraccount==''&&username==''){
			$("#moveid").show();
			pageHeigthOffset = 229;
		}else{
			$("#moveid").hideAndRemove();
			pageHeigthOffset = 203;
		}
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML,
										ingridPageWidth: pageWidth-205,
										url: url,	
										height: pageHeight-pageHeigthOffset,
										pageNumber: pageno,
										sorting: false,
										onRowSelect: function(tr, selected){
											moveSelectId = $(tr).attr("id");
										},
										colWidths: ["14%","19%","40%","27%"]									
									});				
	}
	function setUserDetail(id){
		setQuery(id,detailHtml,detailWidth);
		bindDocument(detailid); //自动关闭
	}
	function setQuerys(){ //添加新功能
		var departid = $("#p_departid").attr("value");
		if(departid==null||departid=='null'||departid==''||departid=='0'){
			jAlert('请选择机构!','提示信息');
			return;
		}
		dataid = departid;
		$("#"+detailid).css("top","120px");
		setWidth(detailid,addWidth);
		setUrl(detailid,addHtml);
		bindDocument(detailid); //自动关闭
	}
	function setModifyQuery(id){
		dataid=id;
		sFlag="false";
		$("#"+detailid).css("top","120px");
		setWidth(detailid,modWidth);
		setUrl(detailid,modHtml);
		bindDocument(detailid); //自动关闭
	}
	function setQuery(id,url){
		dataid=id;
		$("#"+detailid).css("top","120px");
		setWidth(detailid,detailWidth);
		setUrl(detailid,url);
	}
	function setUserRole(id){ //用户角色管理
		sFlag="false";
		dataid=id;
		$("#"+detailid).css("top","50px");
		setWidth(detailid,800);
		setUrl(detailid,'basic/sysadmin/UserRole.jsp');
		bindDocument(detailid); //自动关闭
	}
	function resetPwd(id){ //重置密码
		sFlag="false";
		jConfirm('确定要重置此用户密码吗？', '提示', function(r) {
	    	if(r==true){
				$("#"+delid).attr("value",id);
				setParams("d_");
		        jQuery.post(resetPwdUrl,params,resetPwdBack,"json");
			}else{
			   return false;
			}
		});
	}
	function resetPwdBack(json){
		if  (json.result=="success"){
			jAlert('密码重置成功','提示信息');
		}else{
			jAlert(json.result,'错误信息');
		}	
	}
	function moveSort(moveWay){ //移动
		var row=$().find('tr[@id]');
		if(row.length>0){
			if(moveSelectId==null||moveSelectId==''){
				jAlert('请选择用户!','提示信息');
				return;
			}
			var moveParentid=$("#p_departid").attr("value");
			var params={moveParentid:moveParentid,moveSelectId:moveSelectId,moveWay:moveWay};
			var sUrl="sysadmin/moveSort_user.action";
			jQuery.post(sUrl,params,moveSortBack,"json");
		}
	}
	function moveSortBack(json){
		if(json.result=="success"){
			moveSelectId = '';
			setPageList($("#pageNo").attr("value"));
		}
	}
	function jzlbOnchange(){
		var jzlbdm = $("#bq_jzlbdm").attr("value");
		$("#p_jzlbdm").attr("value",jzlbdm);
	}
	function yincangJzMan(){ //隐藏警种字段 20100329 杨提出
		$("#jz_tiele").hide();
		$("#jz_content").hide();
	}
</script>
</head>
<body>
<input type="hidden" id="d_userid" value="">
<input type="hidden" id="p_departid" value="<%=(String)request.getAttribute("departid") %>">
<input type="hidden" id="p_jzlbdm">
<div class="textdiv">
<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
<tr>
            <td class="queryfont">用户管理</td>
          </tr>
          <tr>
            <td class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="2">
                <tr>
                  <td width="10%" class="pagedistd">登录账号</td>
                  <td width="16%" class="pagetd"><input type="text" class="inputstyle"  id="p_useraccount" value=""></td>
                  <td width="10%" class="pagedistd">用户姓名</td>
                  <td width="16%" class="pagetd"><input type="text" class="inputstyle"  id="p_username" value=""></td>
                  <td width="10%" class="pagedistd" id="jz_tiele">警种</td>
	    		  <td width="16%" class="pagetd" id="jz_content"><select id="bq_jzlbdm" onChange="jzlbOnchange();"><option></option></select></td>
                  <td>
                  <table width="120" border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="55%" ><a href="#" class="searchbutton" id="querys" onClick="setPageListTemp(1);">查询</a></td>
                  <td width="45%" ><a href="#" class="addbutton"  onclick='setQuerys();'>添加</a> </td>
                </tr>
              </table>
                  </td>
              </tr>
            </table></td>
          </tr>
        </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
    <div id="moveid">
    <table width="360" border="0" align="left" cellpadding="0" cellspacing="0">
     <tr><td height="3"></td></tr>
        <tr>
         <td width="17%"><a href="#" class="submitbutton" onClick="moveSort('置顶');">置顶</a></td>
         <td width="17%" ><a href="#" class="submitbutton" onClick="moveSort('上移');">上移</a></td>
         <td width="17%" ><a href="#" class="submitbutton" onClick="moveSort('下移');">下移</a></td>
         <td width="17%" ><a href="#" class="submitbutton" onClick="moveSort('置底');">置底</a></td>
         <td width="28%">&nbsp;</td>
         </tr>
          <tr><td height="3"></td></tr>
                </table>
    </div>          
     </td>
  </tr>
</table>
<div id="user_detail"  class="page-layout" src="#" style="top:120px; left:160px;"></div>
          <div id="tabledata" style="width:100%;">
            <table id="table1" width="100%">
              <thead>
                <tr>
                  <th name="l_username">用户姓名</th>
                  <th name="l_useraccount">登录账号</th>
                  <th name="l_usertype">用户类别</th>
                  <th name="">操作</th>
	    </tr>
	  </thead>
            </table>
        </div>
</div>
</html>