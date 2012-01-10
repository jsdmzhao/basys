<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var moveSelectId;
	$(document).ready(function() {
		$("#deptDell").hide();
		$("#deptTable").css("width",148);
		pageUrl="sysadmin/querylist_department.action";
		divnid="tabledata";
		tableid="table1";
		addUrl="sysadmin/insert_department.action";
		addHtml="basic/sysadmin/DepartmentAdd.jsp";
		addWidth="500";
		delUrl="sysadmin/delete_department.action";
		modHtml="basic/sysadmin/DepartmentModify.jsp";
		modUrl="sysadmin/modify_department.action";
		modWidth="500";
		detailHtml="basic/sysadmin/DepartmentDetail.jsp";
		detailid="department_detail";
		detailUrl="sysadmin/query_department.action";
		detailWidth="310";
		delid="d_departid";	
		loadPage("tabledata");
		setPageList(1);
		getDepartment();
		
	 	daggleDiv("department_detail");
	}); 
	function getDepartment(){
		setParams("s_");
		var sUrl="sysadmin/showDepart_department.action";
		jQuery.post(sUrl,params,departmentInfo,"json");
	}
	function departmentInfo(json){
		if(json.nowDepartment!=null){
			$("#n_departid").attr("value",setNull(json.nowDepartment.departid));
			$("#n_departlevel").attr("value",setNull(json.nowDepartment.departlevel));
			$("#n_parentdepartid").attr("value",setNull(json.nowDepartment.parentdepartid));
			$("#n_isleaf").attr("value",setNull(json.nowDepartment.isleaf));
			$("#n_departsimplepin").attr("value",setNull(json.nowDepartment.departsimplepin));
			$("#n_departallpin").attr("value",setNull(json.nowDepartment.departallpin));
			
			$("#n_departname").attr("value",setNull(json.nowDepartment.departname));
			$("#parentdepartname").attr("value",setNull(json.nowDepartment.parentdepartname));
			$("#n_departcode").attr("value",setNull(json.nowDepartment.departcode));
			$("#n_departfullcode").attr("value",setNull(json.nowDepartment.departfullcode));
			$("#n_nodeorder").attr("value",setNull(json.nowDepartment.nodeorder));
			
			var child_count = json.nowDepartment.child_count;
			if(child_count=='0'){
				$("#deptDell").show();
				$("#deptTable").css("width",210);
			}
		} else {
			$('input[@id^="n_"]').attr("value","").end();
			$("#parentdepartname").attr("value","");
		}
	}
	function setPageList(pageno,url){	
		if (manVerify()){
			url=setList(pageno,url);
			setParams("s_"); //传参
			var mygrid1 = $("#"+tableid).ingrid({ 
											ingridPageParams:sXML,
											ingridPageWidth: pageWidth-205,
											url: url,	
											height: pageHeight-283,
											pageNumber: pageno,
											sorting: false,
											onRowSelect: function(tr, selected){
												moveSelectId = $(tr).attr("id");
											},
											colWidths: ["25%","30%","30%","15%"]									
										});				
			}
	}
	
	var wldj_timeFlag = true;
	function getObject(obj){ //操作
		sFlag="false";
		if(wldj_timeFlag){
			wldj_timeFlag = false;
			var content = $(obj).text();
			var falg = $(obj).attr("id").split("_")[0];
			var thisId = $(obj).attr("id").split("_")[1];
			if(content=='详细'){
				setDepartDetail(thisId);
			}
			if(content=='修改'){
				setModifyQuery(thisId);
			}
			if(content=='删除'){
				if(falg=='cantdept'){ //不可以删除
					jAlert("请注意：此机构下存在用户或角色，不可以删除!","提示");
				}else{ //可以删除
					setDelete(thisId);
				}
			}
			setTimeout(function(){wldj_timeFlag = true;},800);
		}
	}
	
	function manVerify(){
		if (!checkControlValue("n_departcode","String",1,20,null,0,"机构代码"))
			return false;
		if (!checkControlValue("n_departname","String",1,50,null,0,"机构名称"))
			return false;
		if (!checkControlValue("n_departfullcode","String",1,200,null,0,"机构全路径代码"))
			return false;
		if (!checkControlValue("n_nodeorder","Integer",-999999999,999999999,null,0,"节点顺序"))
			return false;
		return true;
	}
	
	function setDepartDetail(id){
		dataid = id;
		setWidth(detailid,detailWidth);
		setUrl(detailid,detailHtml);
		bindDocument(detailid); //自动关闭
	}
	function setQuerys(){ //添加子机构
		var code = $("#n_departid").attr("value");
		if(code==null||code==''){
			code=0; //父ID为0
		}
		dataid = code;
		setWidth(detailid,addWidth);
		setUrl(detailid,addHtml);
		bindDocument(detailid); //自动关闭
	}
	function updateNowObject(){ //修改
		if (manVerify()){ //验证
			var code = $("#n_departid").attr("value");
			if(code==null||code==''){
				jAlert('请选择机构!','提示信息');
				return;
			}
			setParams("n_");
	    	jQuery.post(modUrl,params,updateNowObjectBack,"json");
		}
	}
	function updateNowObjectBack(json){
		if(json.result=="success"){
			jAlert('修改成功!','保存信息');
			getDepartment();
			setPageList($("#pageNo").attr("value"));
			$("#"+detailid).hideAndRemove("slow");
			saveOnClick($("#n_parentdepartid").attr("value")); //刷新树
		}else{
			jAlert(json.result,'错误');
		}		
	}
	function deleteNowObject(){
		var code = $("#n_departid").attr("value");
		if(code==null||code==''){
			jAlert('请选择机构!','提示信息');
			return;
		}
		sFlag="false";
		jConfirm('确定删除吗?', '删除提示', function(r){
	    	if(r==true){
				setParams("n_");
		        jQuery.post(delUrl,params,deleteObjectBack,"json");
			}else{
			   return false;
			}
		});
	}
	function deleteObjectBack(json){
		if  (json.result=="success"){
			jAlert('删除成功！','提示信息');
			getDepartment();
			setPageList($("#pageNo").attr("value"));
			saveOnClick($("#n_parentdepartid").attr("value")); //刷新树
		}else{
			jAlert(json.result,'错误');
		}
	}
	function moveSort(moveWay){ //移动
		var row=$().find('tr[@id]');
		if(row.length>0){
			if(moveSelectId==null||moveSelectId==''){
				jAlert('请选择子机构!','提示信息');
				return;
			}
			var moveParentid=$("#n_departid").attr("value");
			var params={moveParentid:moveParentid,moveSelectId:moveSelectId,moveWay:moveWay};
			var sUrl="sysadmin/moveSort_department.action";
			jQuery.post(sUrl,params,moveSortBack,"json");
		}
	}
	function moveSortBack(json){
		if(json.result=="success"){
			moveSelectId = '';
			setPageList($("#pageNo").attr("value"));
			saveOnClick($("#n_departid").attr("value")); //刷新树
		}
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
			setPageList(pageno);
			saveOnClick($("#s_departid").attr("value")); //刷新树
		}else{
			jAlert(json.result,'错误信息');
		}	
	}
</script>
</head>
<body>
<input type="hidden" id="d_departid">
<input type="hidden" id="s_departid" value="<%=(String)request.getAttribute("departid") %>">
<div class="textdiv">
	<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
        <tr>
          <td class="queryfont">&nbsp;机构管理</td>
        </tr>
        <tr>
          <td class="tdbg" valign="top"><table width="100%" border="0" align="center" cellpadding="2" cellspacing="0">
      <tr>
                <input type="hidden" id="n_departid">
                <input type="hidden" id="n_departlevel">
                <input type="hidden" id="n_parentdepartid">
                <input type="hidden" id="n_isleaf">
                <input type="hidden" id="n_departsimplepin">
                <input type="hidden" id="n_departallpin">
                <td width="12%" class="pagedistd">机构名称</td>
                <td width="25%" class="pagetd"><input type="text" class="inputstyle"  id="n_departname" value=""></td>
                <td width="7%" class="pagedistd">上级机构</td>
                <td width="24%" class="pagetd"><input type="text" readonly class="readonly" id="parentdepartname" value=""></td>
                <td width="8%" class="pagedistd">机构代码</td>
                <td width="24%" class="pagetd"><input type="text" readonly class="readonly" id="n_departcode" value=""></td>
              </tr>
              <tr>
                <td width="12%" class="pagedistd">机构全路径代码</td>
                <td colspan="3" class="pagetd"><input type="text" readonly   class="readonly" id="n_departfullcode" value="" style="width:410;"></td>
                <td class="pagedistd">排列顺序</td>
                <td class="pagetd"><input type="text" class="inputstyle"  id="n_nodeorder" value="0"></td>
              </tr>
              <tr>
                <td colspan="6">
                <table id="deptTable" width="210" border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
                      <td ><a href="#" class="submitlongbutton" onclick='setQuerys()'>添加下级机构</a></td>
                      <td width="3">&nbsp;</td>
                      <td ><a href="#" class="submitbutton" onClick="updateNowObject();">修改</a></td>
                       <td width="3">&nbsp;</td>
                      <td ><a href="#" id="deptDell" class="submitbutton" onClick="deleteNowObject();">删除</a></td>
                    </tr>
                </table>
                </td>
              </tr>
          </table></td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td ><table width="360" border="0" align="left" cellpadding="1" cellspacing="0">
    <tr><td height="3"></td></tr>
<tr>
                      <td width="17%"><a href="#" class="submitbutton" onClick="moveSort('置顶');">置顶</a></td>
                      <td width="17%" ><a href="#" class="submitbutton" onClick="moveSort('上移');">上移</a></td>
                      <td width="17%" ><a href="#" class="submitbutton" onClick="moveSort('下移');">下移</a></td>
                      <td width="17%" ><a href="#" class="submitbutton" onClick="moveSort('置底');">置底</a></td>
                      <td width="28%">&nbsp;</td>
                    </tr>
                     <tr><td height="3"></td></tr>
                </table></td>
  </tr>
</table>
<div id="department_detail" class="page-layout" src="#" style="top:235px; left:160px; width:500px;"></div>	
<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%" cellpadding="0" cellspacing="0" height="18" >
	  <thead>
	    <tr>       
	     	<th name="l_departcode">机构代码</th>
	     	<th name="l_departname">机构名称</th>
	     	<th name="l_parentdepartid">上级机构</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
</div>
</body>
</html>