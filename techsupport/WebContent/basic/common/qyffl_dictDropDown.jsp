<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/css/dhtmlXTree.css">
<link href="<c:out value="${pageContext.request.contextPath}"/>/css/style.css" rel="stylesheet" type="text/css">
<script  src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXCommon.js"></script>
<script  src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXTree.js"></script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0"  background="images/toolbar.gif">
    <tr>
    	<td width="70%"  style="text-align:left"></td>
    	<td width="30%" style="text-align:center"><img src="images/clear.gif" width="16" height="16" /><a href="#" id='b_clear'  class="fontbutton1" onclick='fnclear();'>[清除]</a></td>
   	</tr>
</table> 
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
		<div class="treediv" style='width:200px'>
			<!--表单样式开始 -->
			<table width="100%" align="center" cellpadding="1" cellspacing="3" class="titleTable" >
            	<tr>
                	<td class="tdContent" >
                  		<table width="100%" border='0'  align="center" cellpadding="1" cellspacing="1" class="listTable">
  							
  							<tr>
    							<td valign="top">
       								<div id="qyfl_treeDropDown" style="width:100%;background-color:#eef6ff; border :0px solid Silver; overflow:auto;"></div>
	    						</td>
							</tr>	
       					</table>   
                	</td>
            	</tr>
        	</table>
		</div>
	</td>
  </tr>
</table>
</body>

<script>
function initTree(){
	tree.openAllItems(tree.getParentId(0));
	setTimeout('initTree2()',1000);
}
function initTree2(){
	var itemtemp_id = $('#'+gmcitemId).val().split("|");
 	for(var l=0;l<itemtemp_id.length;l++){
 		//tree.openItem(tree.getParentId(itemtemp_id[l]));
 		if(itemtemp_id[l]!=''){
 			tree.setCheck(itemtemp_id[l],1);
 		}
		
	}
}
$("#qyfl_treeDropDown").css({height:300});
var itemSelect = 0;

 tree=new dhtmlXTreeObject("qyfl_treeDropDown","100%","100%",0);
  //tree=new dhtmlXTreeObject("depart_treeDropDown","100%","100%",parentID);
  tree.setImagePath("<c:out value="${pageContext.request.contextPath}"/>/images/tree/");
  //显示checkBoxes
  tree.enableCheckBoxes(1);
  if(glflg!='1'){
  	//子父连带
  tree.tscheck=true;
  }
  
  //tree.setOnClickHandler(doOnClick);
  tree.setOnCheckHandler(doOnCheck);
  tree.setXMLAutoLoading("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/dictItemTree_tree.action?dict_code="+gdictCode);
  //tree.loadXML("<c:out value="${pageContext.request.contextPath}"/>/privisys/department.do?method=tree&id=0");
  tree.loadXML("<c:out value="${pageContext.request.contextPath}"/>/sysadminDefault/dictItemTree_tree.action?dict_code="+gdictCode);
  setTimeout('initTree()',1000);
  function doOnClick(itemId)
  {
  		if(!tree.hasChildren(itemId)){
	  		//返回管辖单位名称
	  		$("#"+gmcId).val(tree.getItemText(itemId));
	  		//获得userdata
	  		var userdatavalue = tree.getUserData(itemId,itemId);
	  		alert(userdatavalue);
	  		if(userdatavalue == null || userdatavalue==undefined)
	  			userdatavalue = "";
	  		var userdatavalueArr = userdatavalue.split(",");
	 		//返回完整管辖单位代码
	  		if(gdmId!=null&&gdmId!=undefined&&gdmId!="undefined")
	  			$("#"+gdmId).val(userdatavalueArr[0]);
	  		//返回去掉尾部偶数个0的管辖单位代码
	  		if(gjsdmId!=null&&gjsdmId!=undefined&&gjsdmId!="undefined")
	  			$("#"+gjsdmId).val(userdatavalueArr[1]);
	  		//返回级别
	  		if(glevel!=null&&glevel!=undefined&&glevel!="undefined")
	  			$("#"+glevel).val(userdatavalueArr[2]);
	  		//返回节点ID
	  		if(gmcitemId!=null&&gmcitemId!=undefined&&gmcitemId!="undefined")
	  			$("#"+gmcitemId).val(itemId);
	  		//返回父节点ID
	  		if(gparentItemId!=null&&gparentItemId!=undefined&&gparentItemId!="undefined")
	  			$("#"+gparentItemId).val(userdatavalueArr[3]);
	  		//返回全路径代码
	  		if(gfullcode!=null&&gfullcode!=undefined&&gfullcode!="undefined")
	  			$("#"+gfullcode).val(userdatavalueArr[4]);
	  		//返回是否叶节点
	  		if(gisLeaf!=null&&gisLeaf!=undefined&&gisLeaf!="undefined")
	  			$("#"+gisLeaf).val(userdatavalueArr[5]);
	  		
	  		$("#divs_" + gmcId).remove();
	  	}
  }
   function doOnCheck(itemId){
	   	if(!tree.hasChildren(itemId)||glflg=='1'){//当是子节点获允许选择叶节点
	   			if(tree.isItemChecked(itemId)==1){//选中
	   				replaceItem(itemId);//赋值
	   			}else{//非选中
	   				//$('#'+gmcId).val($('#'+gmcId).val().replace(tree.getItemText(itemId)+"|",''));
	   				$('#'+gdmId).val($('#'+gdmId).val().replace(tree.getUserData(itemId,itemId) +"|",''));//删掉编码
	   				$('#'+gmcitemId).val($('#'+gmcitemId).val().replace(itemId +"|",''));//删掉节点id
	   				updateItemName();//根据编码重新获取所有选中的名称
	   			}
	   		 
	   	}else{//当是叶节点时
	   		if(tree.isItemChecked(itemId)==1){//选中
	   			var itemtemp_id = tree.getSubItems(itemId).split(",");//得到下属所有子节点
 				for(var l=0;l<itemtemp_id.length;l++){
 					replaceItem(itemtemp_id[l]);//将子节点值加入字段中
 				}
	   		}else{//非选中
	   			var itemtemp_id = tree.getSubItems(itemId).split(",");//得到下属所有子节点
 				for(var l=0;l<itemtemp_id.length;l++){
 					//$('#'+gmcId).val($('#'+gmcId).val().replace(tree.getItemText(itemtemp_id[l])+"|",''));
	   				$('#'+gdmId).val($('#'+gdmId).val().replace(tree.getUserData(itemtemp_id[l],itemtemp_id[l]) +"|",''));//删掉子节点代码
	   				$('#'+gmcitemId).val($('#'+gmcitemId).val().replace(itemtemp_id[l] +"|",''));//删掉节点id
 				}
 				updateItemName();//根据编码重新获取所有选中的名称
	   		}
	   		
	   	}
    }
    function updateItemName(){
    	var itemtemp_idArry = $('#'+gmcitemId).val().split("|");
    	var tempItemName="";
    	var tempItemCode="";
    	var tempItemId="";
    	for(var i=0;i<itemtemp_idArry.length;i++){
    		if(itemtemp_idArry[i]!=''){
    			var teName=tree.getItemText(itemtemp_idArry[i]);
    			var teCode=tree.getUserData(itemtemp_idArry[i],itemtemp_idArry[i]);
    			var teId=itemtemp_idArry[i];
    			if(teCode!=$('#'+glitemCode).val()){
    				tempItemName=tempItemName+teName+"|";
	    			tempItemCode=tempItemCode+teCode+"|";
	    			tempItemId=tempItemId+teId+"|";
    			}
    		}
    	}
    	$('#'+gmcId).val("");
    	$('#'+gmcId).val(tempItemName);
    	$('#'+gdmId).val("");
    	$('#'+gdmId).val(tempItemCode);
    	$('#'+gmcitemId).val("");
    	$('#'+gmcitemId).val(tempItemId);
    }
    function replaceItem(itemId){
    	//$('#'+gmcId).val($('#'+gmcId).val().replace(tree.getItemText(itemId)+"|",''));
		//$('#'+gdmId).val($('#'+gdmId).val().replace(tree.getUserData(itemId,itemId) +"|",''));
		//$('#'+gmcId).val( $('#'+gmcId).val()+tree.getItemText(itemId)+"|");
		
		//$('#'+gdmId).val( $('#'+gdmId).val()+tree.getUserData(itemId,itemId)+"|");
		$('#'+gmcitemId).val($('#'+gmcitemId).val().replace(itemId+"|",''));
		$('#'+gmcitemId).val( $('#'+gmcitemId).val()+itemId+"|");
		updateItemName();
    }
  //点击清除按钮，清除调用框及相应隐藏框的值
	function fnclear()
	{
		if($("#" + gmcId).attr("id")!=null&&$("#" + gmcId).attr("id")!=undefined )
 		{
 			$("#" + gmcId).val("");
 		}
 		if($("#" + gdmId).attr("id")!=null&&$("#" + gdmId).attr("id")!=undefined )
 		{
 			$("#" + gdmId).val("");
 		}
 		if($("#" + gjsdmId).attr("id")!=null&&$("#" + gjsdmId).attr("id")!=undefined )
 		{
 			$("#" + gjsdmId).val("");
 		}
 		if($("#" + glevel).attr("id")!=null&&$("#" + glevel).attr("id")!=undefined )
 		{
 			$("#" + glevel).val("");
 		}
 		if($("#" + gmcitemId).attr("id")!=null&&$("#" + gmcitemId).attr("id")!=undefined )
 		{
 			$("#" + gmcitemId).val("");
 		}
 		if($("#" + gparentItemId).attr("id")!=null&&$("#" + gparentItemId).attr("id")!=undefined )
 		{
 			$("#" + gparentItemId).val("");
 		}
 		if($("#" + gfullcode).attr("id")!=null&&$("#" + gfullcode).attr("id")!=undefined )
 		{
 			$("#" + gfullcode).val("");
 		}
 		if($("#" + gisLeaf).attr("id")!=null&&$("#" + gisLeaf).attr("id")!=undefined )
 		{
 			$("#" + gisLeaf).val("");
 		}

    }
  
</script>
<script>

</script>
</html>