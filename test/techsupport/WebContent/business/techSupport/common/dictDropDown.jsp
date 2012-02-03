<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
var detailidTopOffset,detailidLeftOffset;
var ylcsjbxx_detailidOffset = $("#divs_" + gmcId).offset();		
detailidTopOffset=ylcsjbxx_detailidOffset.top;
detailidLeftOffset=ylcsjbxx_detailidOffset.left;

pageUrld="<%=request.getContextPath() %>/sysadmin/queryForDict_dict_item.action";
divnidd="tabledatt";
//tableidd="dictTable";
//loadPage("tabledatt");
tabled=$("#tabledatt").html();


//从url中获得值 paramName-参数名称
 function getQueryStringRegExp(paramName) 
 {     var reg = new RegExp("(^|\\?|&)"+ paramName +"=([^&]*)(\\s|&|$)", "i");
       if (reg.test(location.href)) 
       		return unescape(RegExp.$2.replace(/\+/g, " "));
       return ""; 
 };

function setList1(pageno,url){	
	$("#"+divnidd).html(tabled);	
	//createXML("p_");
	if (url==null || url=="undefined"){
		url=pageUrld;
	}
	return url;
}	

$(document).ready(function() {
	if($('#pageurl').val())
		pageUrld = $('#pageurl').val();
	
	if(gcodeValue!=null && gcodeValue!=""){
		$("#t_query_simplepin").val(gcodeValue);
	}
	if(gtreeParentId!=null && gtreeParentId!="")
		$("#t_super_item_id").val(gtreeParentId);
	setPageList1(1);	

	//点击清除按钮，清除调用框及相应隐藏框的值
	$("#b_clear").click(function(){
        mcId = gmcId;
		dmId = gdmId;
		if($("#" + mcId).attr("id")!=null&&$("#" + mcId).attr("id")!=undefined )
 		{
 			$("#" + mcId).val("");
 		}
 		if($("#" + dmId).attr("id")!=null&&$("#" + dmId).attr("id")!=undefined )
 		{
 			$("#" + dmId).val("");
 		}
 				
    });
    
    //回车键查询，选项上下移动
    var trIndex = 0;
    var keydownCode = 0;
    var tableIsFocus = 0;
	$("#mybody_dictItemDrop").keydown(function(event){
   		 var trList = $("#dictItemTable").find("tbody").find("tr");
		if(event.keyCode == 13){//回车键
			if($("#dictItemTable").find("tbody").find("tr[sel='true']").length>0){
				xuanzhongzhi($("#dictItemTable").find("tbody").find("tr[sel='true']"));
				$("#divs_" + mcId).remove();
			}else{
				//if($("#t_query_simplepin").val()!="")
					setPageList1(1);
			}
			event.stopPropagation();
		}else if(event.keyCode == 38){//向上键
			if(tableIsFocus == 0){
				$("#dictItemTable").focus();
				tableIsFocus = 1;
			}
				if(keydownCode ==40)
					trIndex--;
				keydownCode = 38;
				trList.eq(trIndex).removeClass("grid-row-sel");
				trList.eq(trIndex).attr("sel",'false');
				if(trIndex!=-1){
					trList.eq(trIndex-1).addClass("grid-row-sel");
					trList.eq(trIndex-1).attr("sel",'true');
				}
				if(trIndex>0){
					trIndex--;
				}else if(trIndex==0){
					$("#t_query_simplepin").focus();
					tableIsFocus = 0;
					trIndex--;
				}
				
		}else if(event.keyCode == 40){//向下键
			
			if(tableIsFocus == 0){
				$("#dictItemTable").focus();
				tableIsFocus = 1;
			}
				if(keydownCode ==38)
					trIndex++;
				keydownCode = 40;
				trList.eq(trIndex-1).removeClass("grid-row-sel");
				trList.eq(trIndex-1).attr("sel",'false');
				trList.eq(trIndex).addClass("grid-row-sel");
				trList.eq(trIndex).attr("sel",'true');
				if(trList.length>=trIndex)
					trIndex++;
		}
	}); 
}); 

var mygrid1d;
function setPageList1(pageno,url){	
		url=setList1(pageno,url);
		$("#t_dict_code").val(gdictCode);
		createXML("t_");
		mygrid1d = $("#dictTable").ingrid({ 
										ingridPageParams:sXML, 
										tableid:"dictItemTable",
										prefix:"t_",
										ingridPageWidth:420,
										barTopOffset:-(detailidTopOffset),
										barLeftOffset:-(detailidLeftOffset),
										url:url,	
										height: 250,
										sorting: false,
										pageNumber: pageno,
										isPlayResultNull:false,//查询结果为空时不提示
										onRowSelect:function(tr){
											xuanzhongzhi(tr);
											$("#divs_" + mcId).remove();
										},
										changeHref:function(table){
											$("#t_query_simplepin").focus();
											var trLength = table.find("tr").length;
											if(trLength==1){
												xuanzhongzhi(table.find("tr"));
											}
										},
										colWidths: ["36%","18%","36%","10%"]
									});		
}	

//选中值
function xuanzhongzhi(tr){
	mcId = gmcId;
	dmId = gdmId;
	mcva=$(tr).find("td").eq(0).text();
	dmva=$(tr).find("td").eq(3).text();
	$("#" + mcId).attr("value",mcva);
	$("#" + dmId).attr("value",dmva);
}
</script>
</head>
<body>
<div id="mybody_dictItemDrop">
<%
//提交路径
String pageurl = request.getParameter("pageurl");
if(pageurl==null)
	pageurl="";
//角色名称
String user_rolename_list = request.getParameter("rolename_list");
if(user_rolename_list == null)
	user_rolename_list = "";
%>
<input type="hidden" id="pageurl" value="<%=pageurl%>"/>
<input id='t_super_item_id' type='hidden' />
<table width="100%" border="0" cellpadding="0" cellspacing="0"  background="images/toolbar.gif">
    <tr>
    	<td width="85%"  style="text-align:left"><input id='t_query_simplepin' class="inputstyle3" type='text' style="width:98%" /></td>
    	<td width="15%" style="text-align:center"><img src="images/clear.gif" width="16" height="16" /><a href="#" id='b_clear' class="fontbutton1">[清除]</a></td>
   	</tr>
</table> 
<div id="tabledatt" style="width:100%;">
	<table id="dictTable" width="100%" border="1">
	  <thead>
	    <tr>       
	     	<th name="">名称</th>
	     	<th name="">简拼</th>
	     	<th name="">全拼</th>
	     	<th name="">代码</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
</div>
</body>
</html>
