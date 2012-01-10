<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	var tableRolePurview=$("#FuncListData").html();
	var state=0;
	$(document).ready(function() {
		$("#q_roleid").attr("value",dataid);
		$("#s_roleid").attr("value",dataid);
		$("#roleMenuList").empty();
		$("#roleMenuList").load("basic/sysadmin/tree/menuTreeCheckbox.jsp");

		setPageListR(1);
		$("#func_multiple").empty();
		$("#func_multiple").load("sysadminDefault/systemTreeForm_tree.action?systemTreeFalg=role");
		setDetail();
	});
	
	function updatediv (json) { 
		$("#s_rolename").val(setNull(json.LRole[0].rolename));
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

	function saveAll(){
		getAllCheckedNode("s_menucode");
		var funcList = new Array("FuncListData");
		setParams("s_",funcList);
		jQuery.post("sysadmin/insFuncMenu_role.action",params,updateback,"json"); 
	}
	
	function ddd(){
		alert($("#menuTreeCheckbox_tree").find("table").eq(6).html());
	}
</script>
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
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
		  <tr>
		    <td class="queryfont" onclick="ddd();">&nbsp;菜单列表</td>
		  </tr>
		  <tr>
		    <td valign="top" class="tdbg"><div id="roleMenuList"></div></td>
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