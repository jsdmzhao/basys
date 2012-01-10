<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<script type="text/javascript">
	var tableRolePurview=$("#FuncListData").html();
	var state=0;
	$(document).ready(function() {
		$("#q_roleid").attr("value",dataid);
		$("#s_roleid").attr("value",dataid);
		//$("#roleMenuList").empty();
		//$("#roleMenuList").load("basic/sysadmin/RoleMenuTreeMan.jsp");
		setParams("q_");
		jQuery.post("sysadmin/querylistRoleMenu_menu.action",params,testRoleMenuBack,"json"); 
		
		setPageListR(1);
	});
	
	function updatediv (json) { 
		$("#s_rolename").val(setNull(json.LRole[0].rolename));
		
		$("#func_multiple").empty();
		$("#func_multiple").load("sysadminDefault/systemTreeForm_tree.action?systemTreeFalg=role");
	}
	
	function show_js(id){
	    for(var n=1;n<=2;n++){document.getElementById('js_'+n).style.display='none';}
	    document.getElementById(id).style.display='block';
	}
	
	function hidePage(){
		$("#role_detail").css("top",180);
		$("#role_detail").css("height",detailHeight);
		$("#func_multiple").empty();
		$("#role_detail").empty();
		$("#role_detail").hideAndRemove("show");
	}
	
	function moveUp(objOption){
		var isHave = 0;
		var trlist = $("#roleFunctionTable").find("tr");
		for(var i=0;i<trlist.length;i++){
			tdlist = trlist.eq(i).find("td");
			if($(objOption).attr("value")==tdlist.eq(0).text())
				isHave = 1;
		}
		if(isHave==0){
			var newRow="<TR><TD><DIV>"+$(objOption).attr("value")+"</DIV></TD><TD><DIV>"+$(objOption).text()+"</DIV></TD><TD><DIV>"
				+$(objOption).attr("title")+"</DIV></TD><TD></TD></TR>";
			var queryNewRow = $(newRow);
			$("#roleFunctionTable").append(queryNewRow);
		}
			$(objOption).remove();
	}
	
	function setListData(){
		var funcList = new Array("FuncListData");
		createXML("s_",funcList);
			
		$("#FuncListData").html(tableRolePurview);
			$("#tableRolePurview").ingrid({ 
										tableid:"roleFunctionTable",
										isPlayResultNull: false,
										ingridPageParams:sXML,
										ingridPageWidth: 800,
										height: pageHeight*0.275,
										sorting: false,
										url: "sysadmin/listByRole_role_func.action",
										pageNumber: 1,
										paging: false,
										onRowSelect: null,
										colWidths: ["25%","25%","25%","25%"]									
									});
	}
			
	function moveOptionUp(){
		$("#sys_rolelist option:selected").each(function(){
			moveUp(this);
		});
		setListData();
	}
	
	function moveOptionUpAll(){
		$("#sys_rolelist option").each(function(){
			moveUp(this);
		});
		setListData();
	}
		
	function moveOptionDown(){
		var checkboxlist = $("#roleFunctionTable").find("input[type='checkbox']");
		for(var i=1;i<checkboxlist.length;i++){
			var checkboxone = checkboxlist.eq(i);
			if(checkboxone.attr("checked")){
				var checkboxtr = checkboxone.parent().parent();
				if(checkboxone.attr("name")==$("#q_systemcode").val()){
				
					var objOption = "<option value='"+checkboxtr.find("td").eq(0).text()+"' title='"+
										checkboxtr.find("td").eq(2).text()+"'>"+checkboxtr.find("td").eq(1).text()+"</option>";
					$("#sys_rolelist").append($(objOption));
				}
				checkboxtr.remove();
			}
		}
		//setListData();
	}
	
	function moveOptionDownAll(){
		var trlist = $("#roleFunctionTable").find("tr");
		var checkboxlist = $("#roleFunctionTable").find("input[type='checkbox']");
		for(var i=1;i<trlist.length;i++){
			var checkboxone = checkboxlist.eq(i);
			if(checkboxone.attr("name")==$("#q_systemcode").val()){
				tdlist = trlist.eq(i).find("td");
				var objOption = "<option value='"+tdlist.eq(0).text()+"' title='"+
									tdlist.eq(2).text()+"'>"+tdlist.eq(1).text()+"</option>";
				$("#sys_rolelist").append($(objOption));
				//$("#sys_rolelist").get(0).options.add(new Option(tdlist.eq(1).text(),tdlist.eq(0).text()));
			}
			trlist.eq(i).remove();
		}
	}
	
	function checkOrNot(){
		if($("#x_checkall").attr("checked")){
			$("#roleFunctionTable").find("input[type='checkbox']").each(function(){
				$(this).attr("checked",true);
			});
		}else{
			$("#roleFunctionTable").find("input[type='checkbox']").each(function(){
				$(this).attr("checked",false);
			});
		}
	}
	
	function setPageListR(pageno,url){	
		createXML("s_");
		$("#FuncListData").html(tableRolePurview);
		var mygrid1 = $("#tableRolePurview").ingrid({  
										tableid:"roleFunctionTable",
										isPlayResultNull: false,
										ingridPageParams:sXML,
										ingridPageWidth: 800,
										sorting: false,
										paging: false,
										onRowSelect: null,
										url: "sysadmin/querylist_role_func.action",	
										height: pageHeight*0.275,
										pageNumber: pageno,
										colWidths: ["25%","25%","25%","25%"]									
									});		
	}
	
//角色菜单操作方法
function spCk(tdObj){
	var tableObj = $("#RoleMenutable");
	var trId = $(tdObj).parent().parent().attr("id");
	tdParent = $(tdObj).parent().parent();
	var scode = tdParent.attr("sd");
	var tdObjText = $(tdObj).text();

	if(scode!=trId){
		if(tdObjText=="＋"){
			$(tdObj).text("－");
			tableObj.find("tr[pd='"+trId+"']").show();
			
		}else if(tdObjText=="－"){
			$(tdObj).text("＋");
			tableObj.find("tr[pd^='"+trId+"']").each(function(){
				tableObj.find("tr[fd^='"+$(this).attr("fd")+"']").hide().find("span:first[lf!='Y']").text("＋");
			});
		}
	}else{
		if(tdObjText=="＋"){
			$(tdObj).text("－");
			tableObj.find("tr[sd^='"+scode+"'][way=1]").show();
		}else if(tdObjText=="－"){
			$(tdObj).text("＋");
			tableObj.find("tr[sd^='"+scode+"']:gt(0)").hide().find("span:first[lf!='Y']").text("＋");
		}
	}
}

function imCk(tdObj){
	var parentTrObj = $(tdObj).parent().parent();
	var trId = parentTrObj.attr("fd");
	var check = parentTrObj.attr("ck");
	var pcode = parentTrObj.attr("pd");
	var fullCode = parentTrObj.attr("fd");
	var way = parentTrObj.attr("way");
	var tableObj = $("#RoleMenutable");
	var scode = parentTrObj.attr("sd");
	var fcodeTr,pcodeTr,pallcodeTr;
	//得到下一级的所有节点、所有选中的(全部选中和部分选中)节点
	if(trId!="0"){
		fcodeTr = tableObj.find("tr[fd^='"+trId+"']");
		pallcodeTr = tableObj.find("tr[pd='"+pcode+"']");
		pcodeTr = tableObj.find("tr[pd='"+pcode+"'][ck!=0]");
	}else{
		fcodeTr = tableObj.find("tr[sd='"+parentTrObj.attr("id")+"']");
		pallcodeTr = null;
		pcodeTr = null;
	}
	//点击的节点当前为“未选”或“部分选中”则设置为“选中”
	if(check=="0" || check=="-1"){
		fcodeTr.find("img").attr("src","images/ckall.gif");
		fcodeTr.attr("ck","1");
		if(pcodeTr!=null){
			var pcodeLen = pcodeTr.length,pallcodeLen = pallcodeTr.length-1;
			var pcodeTrList = tableObj.find("#"+pcode+"");
			
			if(pcodeTrList.length>0){
				//同级节点为部分选中，上级、更高级别节点都为部分选中
				if(pcodeLen<pallcodeLen){
					pcodeTrList.find("img").attr("src","images/ckgray.gif");
					pcodeTrList.attr("ck","-1");
					
					//设置更高级别节点选中状态
					fullCode = pcodeTrList.attr("fd");
					var lastIndex = fullCode.lastIndexOf('.');
					if(lastIndex!=-1){
						fullCode = fullCode.substring(0,lastIndex);
						var checkFullTrList,fullTrList;
						//上级为部分选中时，上上级也为部分选中
						while((lastIndex=fullCode.lastIndexOf('.'))!=-1){
							fullCode = fullCode.substring(0,lastIndex);
							way = way - 1;
							fullTrList =  tableObj.find("tr[fd^='"+fullCode+"'][way='"+way+"']");
							pcodeTrList = tableObj.find("#"+fullTrList.eq(0).attr("pd")+"");
							pcodeTrList.attr("ck","-1");
							pcodeTrList.find("img").attr("src","images/ckgray.gif");
						}
					}
				//同级节点为全部选中，上级为全部选中
				}else if(pcodeLen==pallcodeLen){
					pcodeTrList.find("img").attr("src","images/ckall.gif");
					pcodeTrList.attr("ck","1");
					
					//设置更高级别节点选中状态
					fullCode = pcodeTrList.attr("fd");
					var lastIndex = fullCode.lastIndexOf('.');
					if(lastIndex!=-1){
						fullCode = fullCode.substring(0,lastIndex);
						var checkFullTrList,fullTrList;
						var checkFullLength;
						while((lastIndex=fullCode.lastIndexOf('.'))!=-1){
							fullCode = fullCode.substring(0,lastIndex);
							way = way - 1;
							checkFullTrList = tableObj.find("tr[fd^='"+fullCode+"'][way='"+way+"'][ck=1]");
							checkFullLength = checkFullTrList.length;
							fullTrList =  tableObj.find("tr[fd^='"+fullCode+"'][way='"+way+"']");
							pcodeTrList = tableObj.find("#"+checkFullTrList.eq(0).attr("pd")+"");
							//上级菜单部分选中时，上上级菜单状态为“部分选中(ck=-1)”
							if(checkFullLength<fullTrList.length){
								pcodeTrList.attr("ck","-1");
								pcodeTrList.find("img").attr("src","images/ckgray.gif");
							//上级菜单全部选中时，上上级菜单状态为“全部选中(ck=1)”
							}else if(checkFullLength==fullTrList.length){
								tableObj.find("#"+fullTrList.eq(0).attr("pd")+"").attr("ck","1");
								tableObj.find("#"+fullTrList.eq(0).attr("pd")+"").find("img").attr("src","images/ckall.gif");
							}
						}
					}
				}
			}
		}
		
	//点击的节点当前为“选中”则设置为“未选”
	}else{
		fcodeTr.find("img").attr("src","images/ckunall.gif");
		fcodeTr.attr("ck","0");
		if(pcodeTr!=null){
			var pcodeLen = pcodeTr.length,pallcodeLen = pallcodeTr.length;
			var pcodeTrList = tableObj.find("#"+pcode+"");
			
			if(pcodeTrList.length>0){
				//全部取消选中
				if(pcodeLen==1){
					pcodeTrList.find("img").attr("src","images/ckunall.gif");
					pcodeTrList.attr("ck","0");
				
					//全部取消选中时关联上级选中状态
					fullCode = pcodeTrList.attr("fd");
					var lastIndex = fullCode.lastIndexOf('.');
					if(lastIndex!=-1){
						fullCode = fullCode.substring(0,lastIndex);
						var checkFullTrList,fullTrList;
						var checkFullLength;
						while((lastIndex=fullCode.lastIndexOf('.'))!=-1){
							fullCode = fullCode.substring(0,lastIndex);
							way = way - 1;
							checkFullTrList = tableObj.find("tr[fd^='"+fullCode+"'][way='"+way+"'][ck!=0]");
							checkFullLength = checkFullTrList.length;
							fullTrList =  tableObj.find("tr[fd^='"+fullCode+"'][way='"+way+"']");
							pcodeTrList = tableObj.find("#"+checkFullTrList.eq(0).attr("pd")+"");
							//上级菜单全部取消选中时，上上级菜单状态为“未选(ck=0)”
							if(checkFullLength==1){
								pcodeTrList.attr("ck","0");
								pcodeTrList.find("img").attr("src","images/ckunall.gif");
							//上级菜单部分取消选中时，上上级菜单状态为“部分选中(ck=-1)”
							}else if(checkFullLength>1 && checkFullLength<=fullTrList.length){
								pcodeTrList.attr("ck","-1");
								pcodeTrList.find("img").attr("src","images/ckgray.gif");
							}else if(checkFullLength==0){
								tableObj.find("#"+fullTrList.eq(0).attr("pd")+"").attr("ck","0");
								tableObj.find("#"+fullTrList.eq(0).attr("pd")+"").find("img").attr("src","images/ckunall.gif");
							}
						}
					}
				
				//部分取消选中
				}else if(pcodeLen>1 && pcodeLen<=pallcodeLen){
					pcodeTrList.find("img").attr("src","images/ckgray.gif");
					pcodeTrList.attr("ck","-1");
	
					//部分取消选中时关联上级选中状态
					fullCode = pcodeTrList.attr("fd");
					var lastIndex = fullCode.lastIndexOf('.');
					if(lastIndex!=-1){
						fullCode = fullCode.substring(0,lastIndex);
						var checkFullTrList,fullTrList;
						//上级为部分选中时，上上级也为部分选中
						while((lastIndex=fullCode.lastIndexOf('.'))!=-1){
							fullCode = fullCode.substring(0,lastIndex);
							way = way - 1;
							fullTrList =  tableObj.find("tr[fd^='"+fullCode+"'][way='"+way+"']");
							pcodeTrList = tableObj.find("#"+fullTrList.eq(0).attr("pd")+"");
							pcodeTrList.attr("ck","-1");
							pcodeTrList.find("img").attr("src","images/ckgray.gif");
						}
					}
				}
			}
		}
	}
	
	//系统阶段选中状态设置
	var allScodeLength = tableObj.find("tr[sd='"+scode+"'][way=1]").length;
	var bfxzScodeLength = tableObj.find("tr[sd='"+scode+"'][way=1][ck=-1]").length;
	var wxzScodeLength = tableObj.find("tr[sd='"+scode+"'][way=1][ck=0]").length;
	var systemObj = tableObj.find("#"+scode+"");
	if(bfxzScodeLength>0 || (wxzScodeLength>0 && wxzScodeLength<allScodeLength)){
		systemObj.attr("ck","-1");
		systemObj.find("img").attr("src","images/ckgray.gif");
	}else if(wxzScodeLength==allScodeLength){
		systemObj.attr("ck","0");
		systemObj.find("img").attr("src","images/ckunall.gif");
	}else{
		systemObj.attr("ck","1");
		systemObj.find("img").attr("src","images/ckall.gif");
	}
	tableObj = null;
}

var resultTableObj = null;
function testRoleMenuBack(json){
	resultTableObj = $(json.tabledata);
	var thisObj,checkLen,thisObjId;
	
	//顶级节点初始化状态及图片路径
	resultTableObj.find("tr[way=0]").each(function(){
		thisObj = $(this);
		thisObjId = thisObj.attr("id");
		checkLen = resultTableObj.find("tr[way=1][sd='"+thisObjId+"'][ck='1']").length;
		if(checkLen>0){
			if(checkLen<resultTableObj.find("tr[way=1][sd='"+thisObjId+"']").length){
				thisObj.find("img").attr("src","images/ckgray.gif");
				thisObj.attr("ck","-1");
			}else{
				thisObj.find("img").attr("src","images/ckall.gif");
				thisObj.attr("ck","1");
			}
		}else{
			thisObj.find("img").attr("src","images/ckunall.gif");
			thisObj.attr("ck","0");
		}
	});
	$("#RoleMenutable").find("tbody").html(resultTableObj.find("tr[way=0]").clone());
	$("#RoleMenutable").bind("mouseover",tableMouseOver);
	$("#addbutton").bind("mouseover",tableMouseOver);
	
	setDetail();
}

function spanClickEvent(){
	$(this).parent().find("span:first").click();
}

//鼠标移到table上时，绑定事件、下载图片
function tableMouseOver(){
	if(resultTableObj!=null){
		var tableObj = $("#RoleMenutable");
		tableObj.unbind("mouseover");
		resultTableObj.find("tr[way!=0]").css("display","none");
		tableObj.find("tbody").html(resultTableObj.find("tbody").html());
		tableObj.find("tr").find("span:nth(1)").bind("click",spanClickEvent);
		tableObj.find("tr[ck=1][way!=0]").find("img").attr("src","images/ckall.gif");
		tableObj.find("tr[ck=0][way!=0]").find("img").attr("src","images/ckunall.gif");
		tableObj.find("tr[ck=-1][way!=0]").find("img").attr("src","images/ckgray.gif");
		tableObj = null;
		resultTableObj = null;
	}
}

function saveAll(){
	var checkedTr = $("#RoleMenutable").find("tbody").find("tr[ck!=0][way!=0]");
	var entTable = $("#RoleMenuEntable").find("tbody");
	entTable.empty();
	entTable.append(checkedTr.clone());
	dataid="menucode";
	var funcList = new Array("FuncListData","RoleMenuData");
	setParams("s_",funcList);
	jQuery.post("sysadmin/insFuncMenu_role.action",params,jueSeQuanXianBack,"json"); 
	checkedTr = null;
	entTable = null;
}

function jueSeQuanXianBack(json){
	hidePage();
}

</script>
<style type="text/css">
	#RoleMenuDisData span{
 		cursor:pointer;
 		font-size:12px;
	}
	#RoleMenuDisData img{
 		vertical-align:middle;
	}
</style>
<input type="hidden" id="q_roleid">
<input type="hidden" id="s_roleid">
<input type="hidden" id="s_menucode">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">角色权限</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='hidePage();'class="close"></a></td>
    </tr>
</table>
<!--角色菜单开始-->
<table width="100%" border="0" align="center"  cellpadding="0" cellspacing="0" id=js_1 style="DISPLAY: block">
<tr>
<td>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
	    <td width="100%" valign="top" >
	    	<table width="100%"  border="0" align="left" cellpadding="0" cellspacing="0">
	      	<tr>
        		<td width="25" valign="bottom">
        			<table width="100%" border="0" cellspacing="0" cellpadding="0"  class="navbg">
            		<tr><td></td></tr>
            		</table>
            	</td>
       			<td width="78" valign="bottom">
       				<table width="100%" border="0"  align="right" cellpadding="0" cellspacing="0" class="nav11">
            		<tr><td><a  href="#" onmousedown="show_js('js_1')" class="navfont" hidefocus="true">角色菜单</a></td></tr>
            		</table>
            	</td>
        		<td width="78">
        			<table width="100%" border="0" align="right" cellpadding="0" cellspacing="0"  class="nav1" >
            		<tr><td><a href="#" onmousedown="show_js('js_2')" class="navfont" hidefocus="true" >角色功能</a></td></tr>
        			</table>
        		</td>
       		  <td width="1048" valign="bottom">
        			<table width="100%" border="0" cellspacing="0" cellpadding="0"  class="navbg">
            		<tr><td></td></tr>
        			</table>
        		</td>
      		</tr>
    		</table>
    	</td>
  		</tr>
	</table>
<table width="100%" cellspacing="0" cellpadding="0" class="line" >
    <tr><td height="3"></td></tr>
	<tr>
	<td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
		  <tr>
		    <td class="queryfont">&nbsp;角色菜单</td>
		  </tr>
		  <tr>
		    <td class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="1">
		      <tr>
		        <td width="13%" class="pagedistd"> 角色名称：</td>
		        <td class="pagetd"><input type="text" id="s_rolename" readonly class="readonly"/></td>
		        </tr>
		    </table></td>
		  </tr>
		</table>	
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="3">&nbsp;</td>
  </tr>
</table>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="titleTable">
		  <tr>
		    <td class="queryfont">&nbsp;菜单列表</td>
		  </tr>
		  <tr>
		    <td valign="top" class="tdbg">
		    <div id="roleMenuList">
		<div id="RoleMenuDisData" style="width:100%;height:400;overflow-y:scroll" class="titleTablenei">
	<table id="RoleMenutable" width="97%">
	  <thead>
	    <tr>       
	     	<th name="" width="100%"></th>
	    </tr>
	  </thead>
	  
	</table>	
</div><div id="RoleMenuData" style="display:none">
	<table id="RoleMenuEntable">
	  <thead>
	    <tr>       
	     	<th name=""></th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
		    </div></td>
		  </tr>
		</table>
	</td>
	</tr>
	</table>
</td>
</tr>
</table>
<!--角色菜单结束-->
<!--角色功能开始-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" id=js_2  style="DISPLAY:none">
<tr>
<td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
		<tr>
	    <td width="100%" valign="top" >
	    	<table width="100%"  border="0" align="left" cellpadding="0" cellspacing="0">
	      	<tr>
        		<td width="25" valign="bottom">
        			<table width="100%" border="0" cellspacing="0" cellpadding="0"  class="navbg">
            		<tr><td></td></tr>
            		</table>
            	</td>
       			<td width="78" valign="bottom">
       				<table width="100%" border="0"  align="right" cellpadding="0" cellspacing="0" class="nav1">
            		<tr><td><a  href="#" onmousedown="show_js('js_1')" class="navfont" hidefocus="true">角色菜单</a></td></tr>
            		</table>
            	</td>
        		<td width="78">
        			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0"  class="nav11" >
            		<tr><td align="center"><a href="#" onmousedown="show_js('js_2')" class="navfont" hidefocus="true" >角色功能</a></td></tr>
        			</table>
        		</td>
       		  <td width="1048" valign="bottom">
        			<table width="100%" border="0" cellspacing="0" cellpadding="0"  class="navbg">
            		<tr><td></td></tr>
        			</table>
        		</td>
      		</tr>
    		</table>
    	</td>
  		</tr>
	</table>
	<table width="100%"  cellspacing="0" cellpadding="0" class="line" >
    <tr><td height="3"></td></tr>
		<tr><td>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
      <tr>
        <td class="queryfont">&nbsp;已选功能</td>
      </tr>
      <tr>
        <td valign="top" class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="1">
            <tr>
              <td colspan="2"><div id="FuncListData" style="width:100%;">
                <table id="tableRolePurview" width="100%">
                  <thead>
                    <tr>
                      <th name="l_funccode">功能代码</th>
                      <th name="l_funcname">功能名称</th>
                      <th name="l_functype">功能类别</th>
                      <th name=""><input type="checkbox" id="x_checkall" onclick="checkOrNot();" /></th>
	    </tr>
	  </thead>
                </table>
              </div></td>
              </tr>
            <tr>
              <td colspan="2" class="red"><table width="360" border="0" align="left" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="29%" height="28px" ><a href="#" class="submitbutton" onclick="moveOptionUpAll();">全部上移</a></td>
                  <td width="22%" ><a href="#" class="submitbutton" onclick="moveOptionUp();">上移</a></td>
                  <td width="24%" ><a href="#" class="submitbutton" onclick="moveOptionDown();">下移</a></td>
                  <td width="25%" ><a href="#" class="submitbutton" onclick="moveOptionDownAll();">全部下移</a></td>
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
     <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
      <tr>
        <td class="queryfont">&nbsp;未选功能</td>
      </tr>
      <tr>
        <td valign="top" class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="1">
            <tr>
              <td valign="top" class="pagetd1">
 				<div id="func_multiple"></div>
 				</td>
            </tr>
        </table></td>
      </tr>
    </table>
		</td></tr>
	</table>
	</td>
</tr>
</table>
<!--角色功能结束-->

<table width="100%" border="0" cellspacing="0" cellpadding="0"  class="tdbg">
  <tr>
    <td height="6"></td>
  </tr>
  <tr>
    <td align="center"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='saveAll();'>保存</a></td>
  </tr>
</table>