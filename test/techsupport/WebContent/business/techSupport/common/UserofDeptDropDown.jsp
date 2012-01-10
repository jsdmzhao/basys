<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
var parentDiv = $("#mybody_userofdeptDrop").parent();
var detailidTopOffset,detailidLeftOffset;
var userofdeptjbxx_detailidOffset = $("#divs_" + gmcId).offset();		
detailidTopOffset=userofdeptjbxx_detailidOffset.top;
detailidLeftOffset=userofdeptjbxx_detailidOffset.left;

pageUrld="<%=request.getContextPath() %>/techsupport/querylistUserofDept_tscommon.action";
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
	//gdictCode=="kcyzx"，可以筛选已注销的场所
	
	if(gdictCode!=null && gdictCode=="kcyzx"){
		$("#t_depatname").val(0);
	}

	$('#t_hylbdm').val(dataid);
	if(gGxdwbm!=null && gGxdwbm!=""){
		$("#t_username").before("<input type='hidden' id='t_departcode' value='"+gGxdwbm+"' />");
	}
	$("#t_username").focus();

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
 			
    });
	  
    //回车键查询，选项上下移动
    var trIndex = 0;
    var keydownCode = 0;
    var tableIsFocus = 0;
	$("#mybody_userofdeptDrop").keydown(function(event){
   		 var trList = $("#userofdeptDropTable").find("tbody").find("tr");
		if(event.keyCode == 13){//回车键

			if($("#userofdeptDropTable").find("tbody").find("tr[sel='true']").length>0){
				xuanzhongzhi($("#userofdeptDropTable").find("tbody").find("tr[sel='true']"));
				$("#divs_" + mcId).remove();
			}else{
				if($("#t_username").val()!="")
					setPageList1(1);
			}
			event.stopPropagation();
		}else if(event.keyCode == 38){//向上键

			if(tableIsFocus == 0){
				$("#userofdeptDropTable").focus();
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
					$("#t_username").focus();
					tableIsFocus = 0;
					trIndex--;
				}
				
		}else if(event.keyCode == 40){//向下键

			
			if(tableIsFocus == 0){
				$("#userofdeptDropTable").focus();
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
		mygrid1d = $("#userofdeptTable").ingrid({ 
										ingridPageParams:sXML, 
										tableid:"userofdeptDropTable",
										prefix:"t_",
										ingridPageWidth:375,
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
										colWidths: ["20%","35%","45%"]									
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
	}
</script>
</head>
<body>
<div id="mybody_userofdeptDrop">
<table width="100%" border="0" cellpadding="0" cellspacing="0" background="images/toolbar.gif">
  <tr>
    	<td width="85%"  style="text-align:left">
    	<input id='t_username' class="inputstyle3" type='text' style="width:98%" />
    	<input id='t_depatname' type='hidden' />
    	<input type="hidden" id="t_hylbdm"/>
    	</td>
    	<td width="15%" style="text-align:center"><img src="images/clear.gif" width="16" height="16" /><a href="#" id='b_clear' class="fontbutton1">[清除]</a></td>
   	</tr>
</table> 
<div id="tabledatt" style="width:100%;">

	<table id="userofdeptTable" width="100%" border="1">
	  <thead>
	    <tr>       
	     	<th name="l_username">姓名</th>
	     	<th name="l_userid">编号</th>
	     	<th name="l_departname">岗位</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
</div>
</body>
</html>
