<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var moveSelectId;
	$(document).ready(function() {
		pageUrl="sysadmin/querylist_menu.action";
		divnid="tabledata";
		tableid="table1";
		addUrl="sysadmin/insert_menu.action";
		addHtml="basic/sysadmin/MenuAdd.jsp";
		addWidth="500";
		delUrl="sysadmin/delete_menu.action";
		modHtml="basic/sysadmin/MenuModify.jsp";
		modUrl="sysadmin/modify_menu.action";
		modWidth="500";
		detailHtml="basic/sysadmin/MenuDetail.jsp";
		detailid="menu_detail";
		detailUrl="sysadmin/query_menu.action";
		detailWidth="500";
		delid="d_menucode";
		loadPage("tabledata");
		getMenu();
		setPageList(1);
		
		daggleDiv("menu_detail");
	}); 
	function getMenu(){
		setParams("p_");
		var sUrl="sysadmin/showMenu_menu.action";
		jQuery.post(sUrl,params,menuInfo,"json");
	}
	function menuInfo(json){
		if(json.nowMenu!=null){
			$("#n_menucode").attr("value",setNull(json.nowMenu.menucode));
			$("#n_systemcode").attr("value",setNull(json.nowMenu.systemcode));
			$("#n_menuname").attr("value",setNull(json.nowMenu.menuname));
			$("#n_funcentry").attr("value",setNull(json.nowMenu.funcentry));
			
			$("#n_menulevel").attr("value",setNull(json.nowMenu.menulevel));
			$("#n_parentmenucode").attr("value",setNull(json.nowMenu.parentmenucode));
			$("#n_menufullcode").attr("value",setNull(json.nowMenu.menufullcode));
			$("#n_nodeorder").attr("value",setNull(json.nowMenu.nodeorder));
			$("#n_isleaf").attr("value",setNull(json.nowMenu.isleaf));
			$("#nparentmenuname").attr("value",setNull(json.nowMenu.parentmenuname));
		} else {
			$('input[@id^="n_"]').attr("value","").end();
			$("#nparentmenuname").attr("value","");
		}
	}
	function setPageList(pageno,url){	
		if (manVerify()){
			url=setList(pageno,url);
			var mygrid1 = $("#"+tableid).ingrid({ 
											ingridPageParams:sXML,
											ingridPageWidth: pageWidth-205,
											url: url,	
											height: pageHeight-284,
											sorting: false,
											onRowSelect: function(tr, selected){
												moveSelectId = $(tr).attr("id");
											},
											colWidths: ["25%","30%","30%","15%"]									
										});				
			}
	}	
	function manVerify(){
		if (!checkControlValue("n_menuname","String",1,50,null,0,"菜单名称"))
			return false;
        if (!checkControlValue("n_parentmenucode","String",1,40,null,0,"上级菜单"))
			return false;
		if (!checkControlValue("n_menucode","String",1,40,null,0,"菜单代码"))
			return false;
		if (!checkControlValue("n_menufullcode","String",1,400,null,0,"菜单全路径代码"))
			return false;
		if (!checkControlValue("n_nodeorder","Integer",-999999999,999999999,null,0,"排列顺序"))
			return false;
		if (!checkControlValue("n_funcentry","String",1,500,null,0,"菜单连接"))
			return false;
		return true;
	}
	function setMenuDetail(id){
		setQuery(id,detailHtml,detailWidth); 
	}
	function setQuerys(){ //添加子菜单
		var code = $("#n_menucode").attr("value");
		var lsystemcode = $("#p_systemcode").attr("value");
		if(lsystemcode==null||lsystemcode=='null'||lsystemcode==''){
			jAlert('请选择系统!','提示信息');
			return;
		}
		if(code==null||code==''){
			code='0'; //父ID为''
		}
		dataid=code;
		setWidth(detailid,addWidth);
		setUrl(detailid,addHtml);
		bindDocument(detailid); //自动关闭
	}
	function updateNowObject(){ //修改
		if (manVerify()){ //验证
			var code = $("#n_menucode").attr("value");
			var lsystemcode = $("#p_systemcode").attr("value");
			if(lsystemcode==null||lsystemcode=='null'||lsystemcode==''){
				jAlert('请选择系统!','提示信息');
				return;
			}
			if(code==null||code==''){
				jAlert('请选择菜单!','提示信息');
				return;
			}
			setParams("n_");
	    	jQuery.post(modUrl,params,updateNowObjectBack,"json");
		}
	}
	function updateNowObjectBack(json){
		if(json.result=="success"){
			jAlert('修改成功!','保存信息');
			setPageList($("#pageNo").attr("value"));
			$("#"+detailid).hideAndRemove("slow");
			var parentCode = $("#n_parentmenucode").attr("value");
			if(parentCode==''||parentCode==null||parentCode=='null'||parentCode=='0'){
				saveOnClick('sysfalg'+$("#p_systemcode").attr("value")); //刷系统新树
			} else {
				saveOnClick(parentCode); //刷新树
			}
		}else{
			getMenu();
			jAlert(json.result,'错误');
		}		
	}
	function deleteNowObject(){
		var code = $("#n_menucode").attr("value");
		var lsystemcode = $("#p_systemcode").attr("value");
		if(lsystemcode==null||lsystemcode=='null'||lsystemcode==''){
			jAlert('请选择系统!','提示信息');
			return;
		}
		if(code==null||code==''){
			jAlert('请选择菜单!','提示信息');
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
			getMenu();
			setPageList($("#pageNo").attr("value"));
			var parentCode = $("#n_parentmenucode").attr("value");
			if(parentCode==''||parentCode==null||parentCode=='null'||parentCode=='0'){
				saveOnClick('sysfalg'+$("#p_systemcode").attr("value")); //刷系统新树
			} else {
				saveOnClick(parentCode); //刷新树
			}
		}else{
			jAlert(json.result,'错误');
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
			var parentCode = $("#n_menucode").attr("value");
			if(parentCode==''||parentCode==null||parentCode=='null'){
				saveOnClick('sysfalg'+$("#p_systemcode").attr("value")); //刷系统新树
			} else {
				saveOnClick(parentCode); //刷新树
			}
		}else{
			jAlert(json.result,'错误信息');
		}	
	}
	function moveSort(moveWay){ //移动
		var row=$().find('tr[@id]');
		if(row.length>0){
			if(moveSelectId==null||moveSelectId==''){
				jAlert('请选择子菜单!','提示信息');
				return;
			}
			var moveParentid=$("#n_menucode").attr("value");
			var params={moveParentid:moveParentid,moveSelectId:moveSelectId,moveWay:moveWay};
			var sUrl="sysadmin/moveSort_menu.action";
			jQuery.post(sUrl,params,moveSortBack,"json");
		}
	}
	function moveSortBack(json){
		if(json.result=="success"){
			moveSelectId = '';
			setPageList($("#pageNo").attr("value"));
			var lsystemcode = $("#p_systemcode").attr("value");
			if(lsystemcode==null||lsystemcode=='null'||lsystemcode==''){
				//不刷新树 因为第一层为系统 而不是菜单
			} else {
				var parentCode = $("#n_menucode").attr("value");
				if(parentCode==''||parentCode==null||parentCode=='null'){
					//saveOnClick('sysfalg'+$("#p_systemcode").attr("value")); //刷系统新树
				} else {
					saveOnClick(parentCode); //刷新树
				}
			}
		}
	}
</script>
<body>
	<input type="hidden" id="p_systemcode" value="<%=(String)request.getAttribute("systemcode") %>">
	<input type="hidden" id="p_menucode" value="<%=(String)request.getAttribute("menucode") %>">
	<input type="hidden" id="d_menucode" value="">
<div class="textdiv">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
      <tr>
        <td class="queryfont">菜单管理</td>
      </tr>
      <tr>
        <td class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="2">
            <tr>
              <input type="hidden" id="n_systemcode">
              <input type="hidden" id="n_menulevel">
              <input type="hidden" id="n_parentmenucode">
              <input type="hidden" id="n_isleaf">
              <td width="12%" class="pagedistd">菜单名称</td>
              <td width="22%" class="pagetd"><input type="text" class="inputstyle" id="n_menuname" value=""></td>
              <td width="10%" class="pagedistd">上级菜单</td>
              <td width="22%" class="pagetd"><input type="text" readonly  class="readonly"  id="nparentmenuname" value=""></td>
              <td width="10%" class="pagedistd">菜单代码</td>
              <td width="24%" class="pagetd"><input type="text" id="n_menucode" value="" readonly class="readonly"></td>
            </tr>
            <tr>
              <td class="pagedistd">菜单全路径代码</td>
              <td class="pagetd" colspan="3"><input type="text" id="n_menufullcode" class="readonly" value="" style="width:410;"></td>
              <td class="pagedistd">排列顺序 </td>
              <td class="pagetd"><input type="text" class="inputstyle"  id="n_nodeorder" value="0"></td>
            </tr>
            <tr>
              <td class="pagedistd">菜单连接</td>
              <td class="pagetd" colspan="3"><input type="text"  class="inputstyle" id="n_funcentry" value="" style="width:410;"></td>
              <td class="pagedistd" colspan="2"><table width="210" border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td><a href="#" class="submitlongbutton" onclick='setQuerys()'>添加下级菜单</a></td>
                  <td>&nbsp;</td>
                  <td><a href="#" class="submitbutton" onclick='updateNowObject();'>修改</a></td>
                  <td>&nbsp;</td>
                  <td ><a href="#" class="submitbutton" onClick="deleteNowObject();">删除</a></td>
                </tr>
              </table></td>
          </tr>
        </table></td>
      </tr>
    </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr><td height="3"></td></tr>
        <tr>
          <td><table width="360" border="0" align="left" cellpadding="0" cellspacing="0">
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
      <div id="menu_detail"  class="page-layout" src="#"
		style="top:240px; left:160px;"> </div>
      <div id="tabledata" style="width:100%;">
        <table id="table1" width="100%">
          <thead>
            <tr>
              <th name="l_systemcode">菜单代码</th>
              <th name="l_menuname">菜单名称</th>
              <th name="l_parentmenucode">上级菜单</th>
              <th name="">操作</th>
	    </tr>
	  </thead>
        </table>
    </div>
</div>
</body>
</html>