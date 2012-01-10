<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
rows = 10;
var detailidTopOffset,detailidLeftOffset;
var ylcsjbxx_detailidOffset = $("#divs_" + gmcId).offset();		
detailidTopOffset=ylcsjbxx_detailidOffset.top;
detailidLeftOffset=ylcsjbxx_detailidOffset.left;

pageUrld="<%=request.getContextPath() %>/sysadmin/queryForDictLd_dict.action";
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
	$("#t_query_simplepin").focus();

	setPageList1(1);
	
	
//字典项筛选 当有键盘动作时,筛选框值发生变化才执行筛选		
var tempvalue = "";		
	$(this).keydown(function(){
		$("#t_query_simplepin").bind("propertychange",function(){
		  if(tempvalue!=$("#t_query_simplepin").attr("value")){
			setPageList1(1);
		  	tempvalue = $("#t_query_simplepin").attr("value");
		  }
		});
	});
	
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
	
}); 

var mygrid1d;
function setPageList1(pageno,url){	
		url=setList1(pageno,url);
		createXML("t_");
		//$("#tabledatt").find("table").each(function(i){
		//	alert("the "+i+" table:"+$(this).attr("id"));
		//});
		//alert(sXML)
		mygrid1d = $("#dictTable").ingrid({ 
										ingridPageParams:sXML, 
										prefix:"t_",
										ingridPageWidth:375,
										barTopOffset:-(detailidTopOffset),
										barLeftOffset:-(detailidLeftOffset),
										url:url,	
										height: 220,
										pageNumber: pageno,
										onRowSelect:function(tr){
											mcId = gmcId;
											dmId = gdmId;
											mcva=$(tr).find("td").eq(0).text();
											dmva=$(tr).find("td").eq(1).text();
											$("#" + mcId).attr("value",mcva);
 											$("#" + dmId).attr("value",dmva);
											//$("#div_" + mcId).hide();
											$("#divs_" + mcId).remove();
										},
										/**onColFocus:function(tr){
											alert("3333");
										},*/
										colWidths: ["60%","40%"]									
									});		
}	

</script>
</head>
<body>
<div id="mybody">
<table width="100%" border="0" cellpadding="0" cellspacing="0"  background="images/toolbar.gif">
<tr>
    	<td width="85%"  style="text-align:left"><input id='t_query_simplepin' class="inputstyle3" type='text' style="width:95%" /></td>
    	<td width="15%" style="text-align:center"><img src="images/clear.gif" width="16" height="16" /><a href="#" id='b_clear' class="fontbutton1">[清除]</a></td>
   	</tr>
</table> 
<div id="tabledatt" style="width:100%;">

	<table id="dictTable" width="100%" border="1">
	  <thead>
	    <tr>       
	     	<th name="l_display_name">字典名称</th>
	     	<th name="l_dict_code">字典代码</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
</div>
</body>
</html>
