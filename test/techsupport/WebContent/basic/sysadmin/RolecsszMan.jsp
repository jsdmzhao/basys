<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="sysadmin/queryRoleList_param.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="sysadmin/insertRoleParam_param.action";
	addHtml="basic/sysadmin/RoleAdd.jsp";
	addWidth="260";
	delUrl="sysadmin/deleteRoleParam_param.action";
	delid="d_paramcode";
	modHtml="basic/sysadmin/RoleModify.jsp";
	modUrl="sysadmin/updateRoleParam_param.action";
	modWidth="260";
	detailHtml="basic/sysadmin/RoleDetail.jsp";
	detailid="role_detail";
	detailUrl="sysadmin/query_param.action";
	detailWidth="300";
	loadPage("tabledata");
	setDetail();
}); 

function updatediv (json) { 
	if(json.LParam[0]!=null){
		$("#a_paramcode").val(setNull(json.LParam[0].paramcode));
		$("#a_paramname").val(setNull(json.LParam[0].paramname));
		$("#a_paramvalue").val(setNull(json.LParam[0].paramvalue));
	}
	setPageList(1);
	}
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML, 
										ingridPageWidth: pageWidth-206,
										url: url,	
										height: pageHeight-254,
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
												$("#checkAll_role").attr("checked",true);
											}
										},
										hideColIndex:[3],
										colWidths: ["25%","35%","40%","0%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_departname","String",1,50,null,0,"部门名称"))
			return false;
		if (!checkControlValue("p_rolename","String",1,20,null,0,"角色名称"))
			return false;
		return true;
	}

	function addVerify(){
		if (!checkControlValue("a_paramcode","String",1,50,null,1,"参数代码"))
			return false;
		if (!checkControlValue("a_paramname","String",1,50,null,1,"参数名称"))
			return false;
		if (!checkControlValue("a_paramvalue","String",1,1000,null,0,"参数值"))
			return false;
		return true;
	}

//修改按钮状态	
function addParam(obj){
	if($(obj).text()=="添加"){
	
		$(obj).text("保存");
		$("#grid").find("input[type='checkbox']").attr("checked",false);
		$("#checkAll_role").attr("checked",false);
		$(obj).parent().parent().find("td").each(function(i){
			if(i!=0){
				$(this).find("a").text("");
				$(this).find("a").removeClass("submitbutton");
			}
		});
		$("#div_param").find("input[type='text']").val("");
		$("#a_paramcode").attr("readonly",false);
		$("#a_paramcode").removeClass("readonly");
		$("#a_paramcode").addClass("inputstyle");
	}else{
		set_roleParam();
		var addState = setAdd_roleParam();
		if(addState!=false){
			var tdList = $(obj).parent().parent().find("td");
			$(obj).parent().parent().find("td").each(function(i){
				if(i==1){
					$(this).find("a").text("修改");
				}else if(i==2){
					$(this).find("a").text("删除");
				}
				$(this).find("a").addClass("submitbutton");
			});
			$(obj).text("添加");
			$("#a_paramcode").attr("readonly",true);
			$("#a_paramcode").addClass("readonly");
		}
	}
}

//全选多选框事件
function checkOrNot(obj){
	var checkedVal = $(obj).attr("checked");
	$("#grid").find("input[type='checkbox']").attr("checked",checkedVal);

};

//得到选中的角色信息

function set_roleParam(){
	var checkboxList = $("#grid").find("input[type='checkbox']:not(input[type='checkbox']:first)");
	var useridSet = "";
	checkboxList.each(function(){
		if($(this).attr("checked"))
			useridSet += $(this).attr("name")+"_,,";
	});
	$("#a_roleidSet").val(useridSet);
}
//添加参数以及角色参数信息方法
function setAdd_roleParam(){
	if(addVerify()){
		setParams("a_");
		jQuery.post(addUrl,params,addroleParamback,"json");
	}else{
		return addVerify();
	}
}

function addroleParamback(json){
	if  (json.result=="success"){
	$("#list1").empty();
	$("#list1").load("basic/sysadmin/tree/paramList.jsp");
		jAlert("保存成功",'提示信息');
		setDetail();
		setPageList($("#pageNo").attr("value"));
	}else{
		jAlert(json.result,'错误信息');
	}		
}

function updateParam(){
	set_roleParam();
	setUpdate_roleParam();
}

//修改参数以及角色参数信息方法
function setUpdate_roleParam(){
	setParams("a_");
	jQuery.post(modUrl,params,updateroleParamback,"json");
}

function updateroleParamback(json){
	if  (json.result=="success"){
		$("#list1").empty();
		$("#list1").load("basic/sysadmin/tree/paramList.jsp");
		jAlert("修改成功",'提示信息');
		setDetail();
		setPageList($("#pageNo").attr("value"));
	}else{
		jAlert(json.result,'错误信息');
	}		
}

//删除方法
function deleteParam(){
	setDelete($("#q_paramcode").val());
	
}

function deleteback(json){
	if  (json.result=="success"){
		jAlert(delMessage,'提示信息');
		var pageno=$("#pageNo").attr("value");
		if ($("#startno").html()==$("#endno").html()){
			if ($("#pageNo").attr("value")>1){
				pageno=""+(parseInt(pageno)-1);
			}
		}
		$("#list1").empty();
		$("#list1").load("basic/sysadmin/tree/paramList.jsp");
		setParamNull();
		setPageList(pageno);
	}else{
		jAlert(json.result,'错误信息');
	}	
}	

function setParamNull(){
	$(".textdiv").find("input").val("");
}

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
		$("#checkAll_role").attr("checked",firstCheck);
	}
}

</script>
<body>
	<input type="hidden" id="d_paramcode">
	<input type="hidden" id="q_paramcode" value="<%=(String)request.getAttribute("paramcode") %>">
<input type="hidden" id="p_paramcode" value="<%=(String)request.getAttribute("paramcode") %>">
<input type="hidden" id="a_roleidSet" />
<div class="textdiv" valign="top">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
        <td class="queryfont">参数信息</td>
      </tr>
      <tr>
        <td class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="2" id="div_param">
            <tr>
              <td width="10%" class="pagedistd">参数名称</td>
              <td width="23%" class="pagetd"><input type="text" class="inputstyle" id="a_paramname" /></td>
              <td width="10%" class="pagedistd">参数代码</td>
              <td class="pagetd"><input type="text" id="a_paramcode" readonly class="readonly" /></td>
          </tr>
            <tr>
              <td class="pagedistd">参数值</td>
              <td class="pagetd"><input type="text" class="inputstyle" id="a_paramvalue" /></td>
              <td class="pagedistd"></td>
              <td class="pagetd"><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="33%" ><a href="#" class="addbutton"  onClick="addParam(this);">添加</a></td>
                  <td width="33%" ><a href="#" class="submitbutton" onClick="updateParam();">修改</a></td>
                  <td width="33%" ><a href="#" class="submitbutton" onClick="deleteParam();">删除</a></td>
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
      <table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
        <td class="queryfont">角色选择</td>
      </tr>
      <tr>
        <td class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="2">
            <tr>
              <td width="10%" class="pagedistd">部门名称</td>
              <td width="23%" class="pagetd"><input type="text" class="inputstyle"  id="p_departname" value=""></td>
              <td width="10%" class="pagedistd">角色名称</td>
              <td width="39%" class="pagetd"><input type="text" class="inputstyle"  id="p_rolename" value=""></td>
              <td width="18%"><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="100%" ><a href="#" class="searchbutton"  id="querys2" onClick="setPageList(1);">查询</a></td>
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
      <div id="role_detail"  class="page-layout" src="#"
		style="top:40px; left:160px;"> </div>
      <div id="tabledata" style="width:100%;">
        <table id="table1" width="100%">
          <thead>
            <tr>
              <th name=""><input type="checkbox" style="width:18" id="checkAll_role" onClick="checkOrNot(this);" />全选</th>
              <th name="l_departname">部门名称</th>
              <th name="l_rolename">角色名称</th>
            
                <th name="l_roletype">角色类型</th>
              
            
              
            </tr>
          </thead>
        </table>
    </div>
</div>
</body>