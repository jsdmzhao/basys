<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
var parentDiv = $("#mybody_ylcsDrop").parent();
var detailidTopOffset,detailidLeftOffset;
var ylcsjbxx_detailidOffset = $("#divs_" + gmcId).offset();		
detailidTopOffset=ylcsjbxx_detailidOffset.top;
detailidLeftOffset=ylcsjbxx_detailidOffset.left;

pageUrld="<%=request.getContextPath() %>/publicsystem/queryTYlist_qyjbxx.action";
var pageUrldNB="<%=request.getContextPath() %>/nbdw/querylistQY_nbdwjbxx.action";
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
		if($('#t_hylbdm').val()=="N"){
			url=pageUrldNB;
		}
	}
	return url;
}	

$(document).ready(function() {
	//gdictCode=="kcyzx"，可以筛选已注销的场所
	if(gdictCode!=null && gdictCode=="kcyzx"){
		$("#t_zxbz").val(0);
	}
	$('#t_hylbdm').val(dataid);
	$('#t_allhylbdm').val(ghylbbz);
	if(gGxdwbm!=null && gGxdwbm!=""){
		$("#t_query_simplepin").before("<input type='hidden' id='t_gxdwbm' value='"+gGxdwbm+"' />");
	}
	if(gsfyx!=null && gsfyx!=""){
		$("#t_query_simplepin").before("<input type='hidden' id='t_sfyx' value='"+gsfyx+"' />");
	}
	if(gzjztdm!=null && gzjztdm!=""){
		$("#t_query_simplepin").before("<input type='hidden' id='t_zjztdm' value='"+gzjztdm+"' />");
	}
	if(gsfhc!=null && gsfhc!=""){
		$("#t_query_simplepin").before("<input type='hidden' id='t_sfhc' value='"+gsfhc+"' />");
	}
	$("#t_query_simplepin").focus();

	setPageList1(1);
	
	//点击清除按钮，清除调用框及相应隐藏框的值

	$("#b_clear").click(function(){
        mcId = gmcId;
		dmId = gdmId;
		if($("#" + mcId).length>0)
 		{
 			$("#" + mcId).val("");
 		}
 		if($("#" + dmId).length>0)
 		{
 			$("#" + dmId).val("");
 		}
 		if($("#" + gcodeValue).length>0)
 		{
			$("#" + gcodeValue).val("");	
 		}
 			
    });
	  
    //回车键查询，选项上下移动
    var trIndex = 0;
    var keydownCode = 0;
    var tableIsFocus = 0;
	$("#mybody_ylcsDrop").keydown(function(event){
   		 var trList = $("#ylcsDropTable").find("tbody").find("tr");
		if(event.keyCode == 13){//回车键

			if($("#ylcsDropTable").find("tbody").find("tr[sel='true']").length>0){
				xuanzhongzhi($("#ylcsDropTable").find("tbody").find("tr[sel='true']"));
				$("#divs_" + mcId).remove();
			}else{
				if($("#t_query_simplepin").val()!="")
					setPageList1(1);
			}
			event.stopPropagation();
		}else if(event.keyCode == 38){//向上键

			if(tableIsFocus == 0){
				$("#ylcsDropTable").focus();
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
				$("#ylcsDropTable").focus();
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
		createXML("t_");
		mygrid1d = $("#ylcsTable").ingrid({ 
										isPlayResultNull: false,
										ingridPageParams:sXML, 
										tableid:"ylcsDropTable",
										prefix:"t_",
										ingridPageWidth:375,
										barTopOffset:-(detailidTopOffset),
										barLeftOffset:-(detailidLeftOffset),
										ingridPageWidth: parentDiv.width(),
										url:url,	
										height: 250,
										pageNumber: pageno,
										onRowSelect:function(tr){
											xuanzhongzhi(tr);
											$("#divs_" + mcId).remove();
										},
										changeHref:function(table){
											var trLength = table.find("tr").length;
											if(trLength==1){
												xuanzhongzhi(table.find("tr"));
											}
										},
										colWidths: ["60%","40%"]									
									});		
}	

//选中值

function xuanzhongzhi(tr){
	mcId = gmcId;
	dmId = gdmId;
	var mcva=$(tr).find("td").eq(0).text();
	var dmva;
			dmva=$(tr).find("td").eq(1).text();
	$("#" + mcId).attr("value",mcva);
	$("#" + dmId).attr("value",dmva);
	$("#" + gcodeValue).attr("value",$(tr).attr("id"));
	if(gdictCode=='click'){
		openclick();
	}
	}
</script>
</head>
<body>
<div id="mybody_ylcsDrop">
<table width="100%" border="0" cellpadding="0" cellspacing="0" background="images/toolbar.gif">
  <tr>
    	<td width="85%"  style="text-align:left">
    	<input id='t_query_simplepin' class="inputstyle3" type='text' style="width:98%" />
    	<input id='t_zxbz' type='hidden' />
    	<input type="hidden" id="t_hylbdm"/>
    	<input type="hidden" id="t_allhylbdm"/>
    	</td>
    	<td width="15%" style="text-align:center"><img src="images/clear.gif" width="16" height="16" /><a href="#" id='b_clear' class="fontbutton1">[清除]</a></td>
   	</tr>
</table> 
<div id="tabledatt" style="width:100%;">

	<table id="ylcsTable" width="100%" border="1">
	  <thead>
	    <tr>       
	     	<th name="l_csmc">名称</th>
	     	<th name="l_csbm">代码</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
</div>
</body>
</html>
