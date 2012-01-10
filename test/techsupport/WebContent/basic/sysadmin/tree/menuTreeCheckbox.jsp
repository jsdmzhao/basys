<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<html>
<head>
		<link rel="stylesheet" type="text/css" href="css/dhtmlXTree.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<script src="javascript/dhtmlXCommon.js"></script>
		<script src="javascript/dhtmlXTree.js"></script>
</head>
<body>
	<input type='hidden' id='p_roleid' name='p_roleid'>
	<input type='hidden' id='p_systemcode' name='p_systemcode'>
	<input type='hidden' id='systemcodeSet' name='systemcodeSet'>
	<input type='hidden' id='rolesystemmenucodeSet' name='rolesystemmenucodeSet'>
	
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="6"></td></tr>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td valign="top">
			<div class="treediv" style="width: 100%">
			<!--表单样式开始 -->
			<table width="100%" align="center" cellpadding="1" cellspacing="3" class="titleTable">
				<tr>
				<td class="tdContent">
					<table id='menuTreeCheckbox_table' width="100%" border='0'align="center" cellpadding="1" cellspacing="1" class="listTable">
					<tr>
						<td valign="top">
							<div id="menuTreeCheckbox_tree" class="titleTablenei"></div>
						</td>
					</tr>
					</table>
				</td>
				</tr>
			</table>
			</div>
			</td>
			<td width="4"><img name="" src="" width="4" height="1" alt=""></td>
			<td valign="top" align="left">
				<div class="textdiv" id="menuManager" onload='$("menuManager").show("slow");'></div>
			</td>
		</tr>
	</table>
</body>

<script>
	//获得有子节点的顶级节点串
	function getRoleSystem(){
		//得到roleid
		var roleid = $("#q_roleid").val();
		$("#p_roleid").val(roleid);
		setParams("p_");
		var sUrl="sysadmin/getRolesystemList_tree.action";
		jQuery.ajax({
			type: 'POST',
			url: sUrl,
			data: params,
			async: false,
			dataType: 'json',
			success: getRoleSystemCallback
		});
	}
	function getRoleSystemCallback(result){
		$("#systemcodeSet").val("");
		for(var i=0;i<result.LRoleSystem.length;i++){
			$("#systemcodeSet").val($("#systemcodeSet").val()+result.LRoleSystem[i].systemcode+",");
		}
		if($("#systemcodeSet").val() != null){
			$("#systemcodeSet").val($("#systemcodeSet").val().substr(0,$("#systemcodeSet").val().length-1));
		}
	}
	//获得指定节点下的所有子节点
	function getRoleSystemMenu(systemcode){
		//得到roleid
		var roleid = $("#q_roleid").val();
		$("#p_roleid").val(roleid);
		$("#p_systemcode").val(systemcode);
		setParams("p_");
		var sUrl="sysadmin/getRolesystemenuList_tree.action";
		jQuery.ajax({
			type: 'POST',
			url: sUrl,
			data: params,
			async: true,
			dataType: 'json',
			success: getRoleSystemMenuCallback
		});
	}
	function getRoleSystemMenuCallback(result){
		$("#rolesystemmenucodeSet").val("");
		for(var i=0;i<result.LRoleSystemMenu.length;i++){
			$("#rolesystemmenucodeSet").val($("#rolesystemmenucodeSet").val()+result.LRoleSystemMenu[i].menucode+",");
		}
		if($("#rolesystemmenucodeSet").val() != null){
			$("#rolesystemmenucodeSet").val($("#rolesystemmenucodeSet").val().substr(0,$("#rolesystemmenucodeSet").val().length-1));
		}
		setRolesystemmenuCheck();
	}
	
	function setRolesystemmenuCheck(){
		if($("#rolesystemmenucodeSet").val() != null && $("#rolesystemmenucodeSet").val()!= undefined){
			var rolesystemmenucodeArr;//应被check的所有非顶级节点
			rolesystemmenucodeArr = $("#rolesystemmenucodeSet").val().split(",");
			for(var j = 0;j<rolesystemmenucodeArr.length;j++){
				if(!tree2.hasChildren("menuflag"+rolesystemmenucodeArr[j])||tree2.hasChildren("menuflag"+rolesystemmenucodeArr[j])<1){
					tree2.setCheck("menuflag"+rolesystemmenucodeArr[j],1);
				}
			}
		}
	}
	//树加载后，选中该角色下所有系统和菜单
	function initTree(){
		//获得有子节点的顶级节点串
		getRoleSystem();
		//var allRootNodeItem;//所有顶级节点
		var checkedRoleSystemArr;//应被check的所有顶级节点
		//获得所有顶级节点串，以逗号分隔
		//allRootNodeItem = tree2.getSubItems(0);
		if($("#systemcodeSet").val() != null && $("#systemcodeSet").val()!= undefined){
			checkedRoleSystemArr = $("#systemcodeSet").val().split(",");
			for(var i = 0;i<checkedRoleSystemArr.length;i++){
				tree2.openItem("sysfalg"+checkedRoleSystemArr[i]);
				//获得选中的顶级节点下的原有的所有子节点，并选中这些子节点
				getRoleSystemMenu(checkedRoleSystemArr[i]);
				//alert("点击加载菜单");
				//setTimeout("setRolesystemmenuCheck()",2000);
				//setRolesystemmenuCheck();
				/*if(confirm("是否加载数据?"))
				{
					setRolesystemmenuCheck();
				}
				else
					return false;*/
			}
		}
	}




	$("#menuTreeCheckbox_table").height(pageHeight*0.57);
	$("#menuTreeCheckbox_tree").height(pageHeight*0.57);
	//$("#menuTreeCheckbox_tree").width($("#"+detailid).width());

	tree2=new dhtmlXTreeObject("menuTreeCheckbox_tree","100%","100%",0);
	tree2.setImagePath("images/tree/");
	//显示checkBoxes
	tree2.enableCheckBoxes(1);
	//子父连带
	tree2.tscheck=true;
	//tree2.setOnClickHandler(doOnClick);
	tree2.setOnCheckHandler(doOnCheck);
	tree2.setXMLAutoLoading("sysadminDefault/menuTreeCheckbox_tree.action");
	tree2.loadXML("sysadminDefault/menuTreeCheckbox_tree.action?id=0");
	//初始化树，加载已有数据
	initTree();
	$("#depart_tree").width(depart_treeWidth);
	
	function doOnClick(itemId){
	  	var treesystemcode = '';//选中节点所在的系统
	    var treemenucode = '';//选中节点的菜单id
	    var treelevel;//选中几点的level
	    var rootid;//选中节点的根节点id
	    var tempItemid;//itemId的临时值
		//菜单节点
		if(itemId.indexOf('sysfalg')==-1){
      		treemenucode =itemId;
      		//获得菜单节点所在的系统
      		treelevel = tree2.getLevel(itemId);
      		tempItemid = itemId;
      		for(var i = treelevel;i>1;i--){
	      		rootid = tree2.getParentId(tempItemid);
	      		tempItemid = rootid;
	      	}
      		treesystemcode = rootid.substring(7);
		}else{ //系统节点
	    	treesystemcode = itemId.substring(7);
	      	treemenucode ="0";
	    }
    	//rightMain(treesystemcode,treememucode);
	}
    //复选框点击事件,点击复选框展开所有节点
    function doOnCheck(itemId){
		tree2.openItem(itemId);
    }
    /**获得所有选中节点的menucode,拼串，以逗号(,)分隔.串放到ctrlId标识的隐藏阈中*/
    function getAllCheckedNode(ctrlId){
    	var allChecked = tree2.getAllCheckedBranches();//获得checkstate为1和2(unsure)的节点
    	$("#"+ctrlId).val(allChecked);
    }
</script>
<script>
//var treememucode =0;
//var treesystemcode="glpt";
	function rightMain(treesystemcode,treememucode){
		$("#menuManager").empty();
		$("#menuManager").load("sysadminDefault/queryMenu_menu.action?systemcode="+treesystemcode+"&memucode="+treememucode);
		$("#menuManager").show("slow"); 
	}
   //rightMain();
</script>
</html>