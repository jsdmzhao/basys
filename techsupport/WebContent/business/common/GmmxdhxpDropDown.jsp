<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
var tables_dwsjjdhxp=$("#DwsjjdhxppzComData").html();
$(document).ready(function() {
	$("#t_query_simplepin").focus();
	setPageList_dwsjjdhxp(1);
	//点击清除按钮，清除调用框及相应隐藏框的值	
	
	
    //回车键查询，选项上下移动
    var trIndex = 0;
    var keydownCode = 0;
    var tableIsFocus = 0;
	$("#mybody_dictItemDrop").keydown(function(event){
   		 var trList = $("#jdhxpComTableId").find("tbody").find("tr");
		if(event.keyCode == 13){//回车键
			if($("#jdhxpComTableId").find("tbody").find("tr[sel='true']").length>0){
				getDwGlJdhxp($("#jdhxpComTableId").find("tbody").find("tr[sel='true']"));
				$("#divs_" + gmcId).remove();
			}else{
				if($("#t_query_simplepin").val()!="")
					setPageList_dwsjjdhxp(1);
			}
			event.stopPropagation();
		}else if(event.keyCode == 38){//向上键
			if(tableIsFocus == 0){
				$("#jdhxpComTableId").focus();
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
				$("#jdhxpComTableId").focus();
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

$("#b_clear").click(function(){
	if(gdmId!=null){
		if(gdmId.pzbm!=null)
			$("#"+gdmId.pzbm).val("");
		if(gdmId.unbm!=null)
			$("#"+gdmId.unbm).val("");
		//品名
		if(gdmId.bm!=null)
			$("#"+gdmId.bm).val("");
		//化学名
		if(gdmId.hxm!=null)
			$("#"+gdmId.hxm).val("");
		//安评最大存储量
		if(gdmId.apzdcxl!=null)
			$("#"+gdmId.apzdcxl).val("");
		//计量单位
		if(gdmId.jldw!=null)
			$("#"+gdmId.jldw).val("");
		if(gdmId.unid!=null)
			$("#"+gdmId.unid).val("");
		//英文名	
		if(gdmId.ywm!=null)
			$("#"+gdmId.ywm).val("");
		//英文别名
		if(gdmId.ywbm!=null)	
			$("#"+gdmId.ywbm).val("");
		//计量单位编码
		if(gdmId.jldwbm!=null)
			$("#"+gdmId.jldwbm).val("");
	}
});		
 	
function setPageList_dwsjjdhxp(pageno,url){	
		createXML("t_");
		$("#DwsjjdhxppzComData").html(tables_dwsjjdhxp);
		var mygrid1 = $("#DwsjjdhxppzComTable").ingrid({ 
										sorting:false,
										tableid:"jdhxpComTableId",
										url: "jdhxpsys/querylistDict_gmjdhxpsqmx.action",	
										ingridPageWidth:400,
										height: 250,
                                       ingridPageParams:sXML,
										pageNumber: pageno,
										hideColIndex:[1,2,3,6,7,8,9,10,11,12],
										isPlayResultNull:false,//查询结果为空时不提示
										onRowSelect:function(tr){
											getDwGlJdhxp(tr);
										},
										changeHref:function(table){
											var trLength = table.find("tr").length;
											if(trLength==1){
												getDwGlJdhxp(table.find("tr"));
											}
										},
										colWidths: ["40%","0%","0%","0%","20%","40%","0%","0%","0%","0%","0%","0%","0%"]									
									});		
}	
	
function getDwGlJdhxp(trObj){
	if(gdmId!=null){
		
		if(gdmId.sqmxid!=null)
			$("#"+gdmId.sqmxid).val($(trObj).attr("id"));
		//凭证编号
		if(gdmId.pzbh!=null)
			$("#"+gdmId.pzbh).val($(trObj).find("td:nth(0)").html().replace(/(&nbsp;)/g,''));
		//申请记录号
		if(gdmId.sqjlh!=null)
			$("#"+gdmId.sqjlh).val($(trObj).find("td:nth(1)").html().replace(/(&nbsp;)/g,''));
		//unid
		if(gdmId.unid!=null)
			$("#"+gdmId.unid).val($(trObj).find("td:nth(2)").html().replace(/(&nbsp;)/g,''));
		//企业编码
		if(gdmId.qybm!=null)
			$("#"+gdmId.qybm).val($(trObj).find("td:nth(3)").html().replace(/(&nbsp;)/g,''));
		//UN码
		if(gdmId.unbm!=null)
			$("#"+gdmId.unbm).val($(trObj).find("td:nth(4)").html().replace(/(&nbsp;)/g,''));
		//品名
		if(gdmId.bm!=null)
			$("#"+gdmId.bm).val($(trObj).find("td:nth(5)").html().replace(/(&nbsp;)/g,''));
		//化学名
		if(gdmId.hxm!=null)
			$("#"+gdmId.hxm).val($(trObj).find("td:nth(6)").html().replace(/(&nbsp;)/g,''));
		//购买数量
		if(gdmId.gmsl!=null)
			$("#"+gdmId.gmsl).val($(trObj).find("td:nth(7)").html().replace(/(&nbsp;)/g,''));
		//计量单位编码
		if(gdmId.jldwbm!=null)
			$("#"+gdmId.jldwbm).val($(trObj).find("td:nth(8)").html().replace(/(&nbsp;)/g,''));
		//计量单位
		if(gdmId.jldw!=null)
			$("#"+gdmId.jldw).val($(trObj).find("td:nth(9)").html().replace(/(&nbsp;)/g,''));
		//实际买入数量
		if(gdmId.sjmrsl!=null)
			$("#"+gdmId.sjmrsl).val($(trObj).find("td:nth(10)").html().replace(/(&nbsp;)/g,''));
		
		//凭证编号
		if(gdmId.qyid!=null)
			$("#"+gdmId.qyid).val($(trObj).find("td:nth(11)").html().replace(/(&nbsp;)/g,''));
		//凭证编号
		if(gdmId.pzbm!=null)
			$("#"+gdmId.pzbm).val($(trObj).find("td:nth(12)").html().replace(/(&nbsp;)/g,''));
	}
	$("#divs_" + gmcId).remove();
}
</script>

<div id="mybody_dictItemDrop">
<table width="100%" border="0" cellpadding="0" cellspacing="0"  background="images/toolbar.gif">
    <tr>
    	<td width="85%"  style="text-align:left"><input id='t_query_simplepin' class="inputstyle3" type='text' style="width:300px;" /></td>
    	<td width="15%" style="text-align:center"><img src="images/clear.gif" width="16" height="16" /><a href="#" id='b_clear' class="fontbutton1">[清除]</a></td>
   	</tr>
</table> 
<div id="DwsjjdhxppzComData" style="width:100%;">
	<table id="DwsjjdhxppzComTable" width="100%">
	  <thead> 
	    <tr> 
	    	<th name="l_pzbh">凭证编号</th>
	     	<th name="l_sqjlh">申请记录号</th>
	     	<th name="l_unid">unid</th>
	     	<th name="l_qybm">企业编码</th>
	     	<th name="l_unbm">UN码</th>
	     	<th name="l_bm">品名</th>
	     	<th name="l_hxm">化学名</th>
	     	<th name="l_gmsl">购买数量</th>
	     	<th name="l_jldwbm">计量单位编码</th>
	     	<th name="l_jldw">计量单位</th>
	     	<th name="l_sjmrsl">实际买入数量</th>
	     	<th name="l_qyid">企业ID</th>
	     	<th name="l_pzbm">凭证编码</th>
	     	
	    </tr>
	  </thead>
	  
	</table>	
</div>
</div>