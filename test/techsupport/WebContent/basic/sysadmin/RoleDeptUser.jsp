<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%@page import="com.aisino2.sysadmin.domain.Department"%>
<%
User user = (User)session.getAttribute(Constants.userKey);
String jzlbdm = "";
String isSjyh = "1";
if(user!=null){
	jzlbdm = user.getJzlbdm();
	if(jzlbdm==null||"".equals(jzlbdm)){
		jzlbdm = "";
	}
	Department department = user.getDepartment();
	if("0".equals(""+department.getParentdepartid())){ //省级用户
		isSjyh = "0";
	}
}
%>
<script type="text/javascript">
	var jzlbdm = '<%=jzlbdm %>';
	var isSjyh = '<%=isSjyh %>';
	$(document).ready(function() {
		pageUrl="sysadmin/queryUserList_user.action";
		divnid="tabledata";
		tableid="table1";
		addUrl="sysadmin/insertRoleUser_user.action";
		addHtml="basic/sysadmin/RoleAdd.jsp";
		addWidth="260";
		delUrl="sysadmin/delete_param.action";
		delid="d_roleid";
		modHtml="basic/sysadmin/RoleModify.jsp";
		modUrl="sysadmin/modify_param.action";
		modWidth="260";
		detailHtml="basic/sysadmin/RoleDetail.jsp";
		detailid="role_detail";
		detailUrl="sysadmin/query_param.action";
		detailWidth="300";
		$("#bq_jzlbdm").selectBox({code:"dm_jzlb",width:"120px"});
		if(jzlbdm!=''){
			$("#bq_jzlbdm").setValue(jzlbdm);
			$("#p_jzlbdm").attr("value",jzlbdm);
		}
		if(isSjyh=='1'){ //非省级用户锁定
			$("#bq_jzlbdm").setAttr("readonly","true");
			yincangJzMan(); //隐藏警种字段 20100329 杨提出
		}
		loadPage("tabledata");
	}); 

	function setPageList(pageno,url){	
		if (manVerify()){
			url=setList(pageno,url);
			var mygrid1 = $("#"+tableid).ingrid({ 
											ingridPageParams:sXML, 
											ingridPageWidth: pageWidth-206,
											url: url,	
											height: pageHeight-183,
											pageNumber: pageno,
											sorting:false,
											onRowSelect:null, 
											paging: false,
											changeHref:function(table){
												var checkboxList = table.find("input[type='checkbox']");
												var listLength = checkboxList.length;
												var forLength = 0;
												for(var ii=0;ii<listLength;ii++){
													var newCheck = checkboxList.eq(ii).attr("checked");
													if(!newCheck){
														break;
													}
													forLength = ii;
												}
												if(forLength==listLength-1){
													$("#checkAll_user").attr("checked",true);
												}
											},
											colWidths: ["20%","20%","20%","20%","20%"]									
										});				
			}
	}	
	function manVerify(){
		if (!checkControlValue("p_username","String",1,50,null,0,"用户名称"))
			return false;
		if (!checkControlValue("p_useraccount","String",1,20,null,0,"用户账号"))
			return false;
		if (!checkControlValue("p_departname","String",1,20,null,0,"单位名称"))
			return false;
		return true;
	}
		
	//全选多选框事件
	function checkOrNot(obj){
		var checkedVal = $(obj).attr("checked");
		$("#grid").find("input[type='checkbox']").attr("checked",checkedVal);
	
	};
	
	//检查是否全部选中或全部未选中
	function validateChecked(obj){
		var checkboxList = $("#grid").find("input[type='checkbox']");
		var firstCheck = checkboxList.eq(0).attr("checked");
		var listLength = checkboxList.length;
		var forLength = 0;
		for(var ii=0;ii<listLength;ii++){
			var newCheck = checkboxList.eq(ii).attr("checked");
			if(firstCheck!=newCheck){
				break;
			}
			forLength = ii;
		}
		if(forLength==listLength-1){
			$("#checkAll_user").attr("checked",firstCheck);
		}
	}
	
	function addRole_User(){
		var checkboxList = $("#grid").find("input[type='checkbox']:not(input[type='checkbox']:first)");
		var useridSet = "";
		checkboxList.each(function(){
			if($(this).attr("checked"))
				useridSet += $(this).attr("name")+"_,,";
		});
		$("#a_useridSet").val(useridSet);
		setAdd_roleUser();
	}
	
	
	function setAdd_roleUser(){
			setParams("a_");
			jQuery.post(addUrl,params,addroleUserback,"json");
	}	
	
	function addroleUserback(json){
		if  (json.result=="success"){
			jAlert("保存成功",'提示信息');
			setPageList($("#pageNo").attr("value"));
		}else{
			jAlert(json.result,'错误信息');
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
<body>
<input type="hidden" id="p_roleid" value="<%=(String)request.getAttribute("roleid") %>">
<input type="hidden" id="a_roleid" value="<%=(String)request.getAttribute("roleid") %>">
<input type="hidden" id="a_useridSet" />
<input type="hidden" id="p_jzlbdm">
<div class="textdiv" valign="top" id="div_role_user">
      <table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
        <td class="queryfont">角色用户管理</td>
      </tr>
      <tr>
        <td class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="2">
            <tr>
              <td class="pagedistd">用户名称</td>
              <td class="pagetd"><input type="text" class="inputstyle3"  id="p_username" style="width:118px"></td>
              <td class="pagedistd">用户账号</td>
              <td class="pagetd"><input type="text" class="inputstyle3"  id="p_useraccount" style="width:118px"></td>
              <td class="pagedistd">单位名称</td>
              <td class="pagetd"><input type="text" class="inputstyle3"  id="p_departname" style="width:118px"></td>
              <td class="pagedistd" id="jz_tiele">警种</td>
	    	  <td class="pagetd" id="jz_content"><select id="bq_jzlbdm" onchange="jzlbOnchange();"><option></option></select></td>
              <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="61px"><a href="#" class="searchbutton" id="querys2" onClick="setPageList(1);">查询</a></td>
                  <td width="61px"><a href="#" class="submitbutton" onClick="addRole_User();">保存</a></td>
                </tr>
              </table>
              </td>
          </tr>
        </table></td>
      </tr>
    </table>
        
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
	</tr>
</table>
<div id="tabledata" style="width:100%;border:1px #c5d9e8 solid;">
	<table id="table1" width="100%">
		<thead>
            <tr>
              <th name=""><input type="checkbox" style="width:18" id="checkAll_user" onClick="checkOrNot(this);" />全选</th>
              <th name="l_departname">单位名称</th>
              <th name="l_username">用户名称</th>
              <th name="l_useraccount">用户账号</th>
              <th name="l_usertypename">用户类型</th>
            </tr>
		</thead>
	</table>
</div>
<div id="role_detail"  class="page-layout" src="#" style="top:40px; left:160px;"> </div>
</body>
