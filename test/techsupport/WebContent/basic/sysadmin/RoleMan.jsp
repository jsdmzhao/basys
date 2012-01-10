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
<script type="text/javascript">
	var jzlbdm = '<%=jzlbdm %>';
	var jzlbmc = '<%=jzlbmc %>';
	var isSjyh = '<%=isSjyh %>';
	var moveDataId = -1;
	$(document).ready(function() {
		pageUrl="sysadmin/querylist_role.action";
		divnid="tabledata";
		tableid="table1";
		addUrl="sysadmin/insert_role.action";
		addHtml="basic/sysadmin/RoleAdd.jsp";
		addWidth="260";
		delUrl="sysadmin/delete_role.action";
		delid="d_roleid";
		modHtml="basic/sysadmin/RoleModify.jsp";
		modUrl="sysadmin/modify_role.action";
		modWidth="260";
		detailHtml="basic/sysadmin/RoleDetail.jsp";
		detailid="role_detail";
		detailUrl="sysadmin/query_role.action";
		detailWidth="300";
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
		daggleDiv("role_detail");
	}); 
	function setPageList(pageno,url){	
		url=setList(pageno,url);
		if($("#p_departid").val()==null ||$("#p_departid").val()=="0"){
			url="#";
		}
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML, 
										ingridPageWidth: pageWidth-206,
										url: url,	
										height: pageHeight-204,
										pageNumber: pageno,
										onColFocus: function(tr){
											moveDataId = $(tr).attr("id");
										},
										hideColIndex:[1],
										colWidths: ["35%","0%","30%","35%"]									
									});				
	}	

	var detailHeight,detailidTopOffset,detailidLeftOffset;
	/*
	function setPurview(id){
		$("#"+detailid).css("top",20);
		dataid=id;
		sFlag="false";
		detailHeight=$("#"+detailid).css("height");
		setWidth(detailid,"800");
		setUrl(detailid,"basic/sysadmin/jsqxAdd.jsp");
		var ylcsjbxx_detailidOffset = $("#"+detailid).offset();		
		detailidTopOffset=ylcsjbxx_detailidOffset.top;
		detailidLeftOffset=ylcsjbxx_detailidOffset.left;
	}
	*/
	
	function setPurview(id){
		$("#"+detailid).css("top",20);
		dataid=id;
		sFlag="false";
		detailHeight=$("#"+detailid).css("height");
		setWidth(detailid,"800");
		setUrl(detailid,"basic/sysadmin/RoleqxAdd_new2.jsp");
	}
function setMovePlace(){
		setParams("c_");
		jQuery.post("sysadmin/moveRole_role.action",params,movePlaceback,"json"); 	
}
function movePlaceback(json){
	if  (json.result=="success"){
		jAlert("移动成功",'保存信息');
		setPageList($("#pageNo").attr("value"));
	}else{
		jAlert(json.result,'错误信息');
	}		
}

function addRole(){
	if($("#p_departid").val()==null ||$("#p_departid").val()=="0"){
		jAlert("请选择机构","提示信息");
	}else{ 
		setAddPage();
	}
}
	function jzlbOnchangeMan(){
		var jzlbdm = $("#bq_jzlbdm").attr("value");
		$("#p_jzlbdm").attr("value",jzlbdm);
	}
	function yincangJzMan(){ //隐藏警种字段 20100329 杨提出
		$("#jz_tiele").hide();
		$("#jz_content").hide();
	}
</script>
	<input type="hidden" id="c_roleid">
	<input type="hidden" id="c_way">
	<input type="hidden" id="d_roleid" value="">
	<input type="hidden" id="p_departid" value="<%=(String)request.getAttribute("departid") %>">
	<input type="hidden" id="p_jzlbdm">
<div class="textdiv" valign="top">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
        <td class="queryfont">角色管理</td>
      </tr>
      <tr>
        <td class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="2">
            <tr>
              <td width="10%" class="pagedistd">角色名称</td>
              <td width="20%" class="pagetd"><input type="text" class="inputstyle"  id="p_rolename"></td>
              <td width="10%" class="pagedistd" id="jz_tiele">警种</td>
	    	  <td width="20%" class="pagetd" id="jz_content"><select id="bq_jzlbdm" onchange="jzlbOnchangeMan();"><option></option></select></td>
              <!--  
              <td width="10%" class="pagedistd">角色类别</td>
              <td width="49%" class="pagetd"><input type="text" class="inputstyle"  id="p_roletype"></td>
              -->
              <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="62px" ><a href="#" class="searchbutton" id="querys2" onClick="setPageList(1);">查询</a></td>
                  <td width="62px" ><a href="#" class="addbutton"  onclick='addRole()'>添加</a> </td>
                </tr>
              </table></td>
            </tr>
        </table></td>
      </tr>
    </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="3"></td>
        </tr>
      </table>
      <div id="role_detail"  class="page-layout" src="#"
		style="top:180px; left:160px;"> </div>
      <div id="tabledata" style="width:100%;">
        <table id="table1" width="100%">
          <thead>
            <tr>
              <th name="l_rolename">角色名称</th>
         
              <th name="l_roletype">角色类别</th>
          
              <th name="l_roledescription">角色描述</th>
              <th name="">操作</th>
	    </tr>
	  </thead>
        </table>
    </div>
</div>
