<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants"%>

<%
	//登录用户所在部门父节点id
	int parentdeptid = -1;
	User user = new User();
	//获得登录用户session
	user = (User)session.getAttribute(Constants.userKey);
	if(user == null)
		response.sendRedirect("login.jsp");
	else
		parentdeptid = user.getDepartment().getParentdepartid().intValue();
 %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/css/dhtmlXTree.css">
<link href="<c:out value="${pageContext.request.contextPath}"/>/css/style.css" rel="stylesheet" type="text/css">
<script  src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXCommon.js"></script>
<script  src="<c:out value="${pageContext.request.contextPath}"/>/javascript/dhtmlXTree.js"></script>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0"  background="images/toolbar.gif">
  <tr>
    <td height="6"></td>
    <tr>
  		<td style="text-align:right"><a href="#" id='b_clear' class="addbutton" onclick='addallcs();'>确定</a></td>
  	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td valign="top">
		<div class="treediv" style='width:400px'>
			<!--表单样式开始 -->
			<table width="100%" align="center" cellpadding="1" cellspacing="3" class="titleTable" >
            	<tr>
                	<td class="tdContent" >
                  		<table width="100%" border='0'  align="center" cellpadding="1" cellspacing="1" class="listTable">
  							
  							<tr>
    							<td valign="top">
       								<div id="depart_treeDropDown" style="width:100%;background-color:#eef6ff; border :0px solid Silver; overflow:auto;"></div>
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
$("#depart_treeDropDown").css({height:300});

//var parentdeptid = "<c:out value='${parentdeptid}'/>";
  var parentdeptid = '<%=parentdeptid%>';
  //tree=new dhtmlXTreeObject("depart_treeDropDown","100%","100%",parentdeptid);
  tree=new dhtmlXTreeObject("depart_treeDropDown","100%","100%",0);
  
  tree.setImagePath("<c:out value="${pageContext.request.contextPath}"/>/images/tree/");
   //显示checkBoxes
  tree.enableCheckBoxes(1);
  tree.enableThreeStateCheckboxes(true);
  //子父连带
  //tree.tscheck=true;
  //tree.setOnClickHandler(doOnClick);
   tree.setOnCheckHandler(doOnCheck);     ////错选框选中状态
    
  var hylbdmall = "";
  if(gdictCode!=null){
      hylbdmall = gdictCode;
  }
  hylbdmall = "A";
  tree.setXMLAutoLoading("<c:out value="${pageContext.request.contextPath}"/>/lgyzagl/tree2_qiyejl.action?hylbdmall="+hylbdmall);
  tree.loadXML("<c:out value="${pageContext.request.contextPath}"/>/lgyzagl/tree2_qiyejl.action?hylbdmall="+hylbdmall);
  
 var csString = ""; //全部场所名称
 var cscode = "";   ///  全部场所编码";
 var gxdwString = ""; //全部管辖单位名称
 var gxdwcode = "";   ///  全部管辖单位编码";
  
 function doOnCheck(itemId){
     var flagcheck = tree.isItemChecked(itemId); ///判断结点是否被选中的  1为选中 0未选中
     var note = itemId.substring(0,1); /////判断是否叶子节点的标志 note等于'-' 为叶子节点（场所节点） 不等于时为 部门节点
    
     if(flagcheck==1){
       //选中的情况
       if(note=='-'){
            csString = tree.getItemText(itemId);
            cscode = itemId.substring(1);
            var allString = tree.getUserData(itemId,itemId);
            var index = allString.indexOf("||");
            gxdwcode = allString.substring(0,index);
            gxdwString = allString.substring(index+2);
       
	        var userData = "<Params>";
			userData += "<Param name='csmc'>"+csString+"</Param>";
			userData += "<Param name='csbm'>"+cscode+"</Param>";
			userData += "<Param name='gxdwbm'>"+gxdwcode+"</Param>";
			userData += "<Param name='gxdwmc'>"+gxdwString+"</Param>";
			userData += "</Params>";
	        selectQiYeRequest({dataxml:userData,reXml:"1"});
       }else{
         ////部门节点的情况
         selectItem(itemId);
       } 
     }else if(flagcheck==0){
       //撤销的情况
       if(note=='-'){
	        var userData = "<Params>";
			userData += "<Param name='csbm'>"+itemId.substring(1)+"</Param>";
			userData += "</Params>";
	        selectQiYeRequest({dataxml:userData,reXml:"0"});
       }else{
         ////部门节点的情况
         outItem(itemId);
       }
      
     }
     
     //alert(cscode);
  }
  
  function selectQiYeRequest(userData){
  	jQuery.ajax({
			type: 'POST',
			url: "<c:out value="${pageContext.request.contextPath}"/>/lgyzagl/treeQiye_qiyejl.action",
			data: userData,
			async: true,
			dataType: 'json',
			success: function(json){
			    
				 selectResponse(json);					
			}
		});
  }
  
   ///选择结点的ajax方法
  function selectItem(itemId){
       
       if(itemId!=''){  
         var url ="<c:out value="${pageContext.request.contextPath}"/>/lgyzagl/treeCs_qiyejl.action";
        //var pars = 'id='+ itemId;
        //asynchronous:true, true---异步;false---同步.默认为true
        // var myAjax = new Ajax.Request(url,{method: 'post', asynchronous:true, parameters: pars, onComplete: selectResponse});
        var params = {id:itemId,reXml:"1"};
       
        jQuery.ajax({
			type: 'POST',
			url: url,
			data: params,
			async: false,
			dataType: 'json',
			success: function(json){
			    
				 selectResponse(json);					
			}
		});
		
	   }
    }
    
   ///消去结点的ajax方法
  function outItem(itemId){
       if(itemId!=''){  
         var url ="<c:out value="${pageContext.request.contextPath}"/>/lgyzagl/treeCs_qiyejl.action";
         var params = {id:itemId,reXml:"0"};
         jQuery.ajax({
			type: 'POST',
			url: url,
			data: params,
			async: false,
			dataType: 'json',
			success: function(json){
				 outSelectResponse(json);					
			}
		});
	   }
   }
  
  
  //选择结点返回的方法
function selectResponse(json){        
	var backInfoList= json.reXml.split("!!");
	csString = backInfoList[0];
	gxdwString = backInfoList[1];
}
  
   ///消去结点的返回方法 从csid_csname 中删除该字符串
   
   function outSelectResponse(json){
	var backInfoList= json.reXml.split("!!");
	csString = backInfoList[0];
	gxdwString = backInfoList[1];
   }
 
  
  
  //点击清除按钮，清除调用框及相应隐藏框的值
	function addallcs(){
        mcId = gmcId;
		dmId = gdmId;
		if($("#" + mcId).attr("id")!=null&&$("#" + mcId).attr("id")!=undefined )
 		{
 			$("#" + mcId).attr("value",csString);
 		}
 		if($("#" + dmId).attr("id")!=null&&$("#" + dmId).attr("id")!=undefined )
 		{
 			$("#" + dmId).attr("value",cscode);
 		}
 		$("#"+$("#divs_" + mcId).attr("name")).val(gxdwString);
 		$("#"+$("#divs_" + mcId).attr("path")).val(gxdwcode);
 		$("#divs_" + mcId).remove();
 				
    }
 
</script>
<script>

</script>
</html>