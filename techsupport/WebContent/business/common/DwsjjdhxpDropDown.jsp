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
										tableid:"jdhxpComTableId",
										url: "jdhxpsys/querylistCommon_dwsjjdhxppz.action",	
										ingridPageWidth:500,
										height: 250,
                                       ingridPageParams:sXML,
										pageNumber: pageno,
										hideColIndex:[1,5,6,7,8,9,10],
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
										colWidths: ["18%","0%","47%","20%","15%","0%","0%","0%","0%","0%","0%"]									
									});		
}	
	
function getDwGlJdhxp(trObj){
	if(gdmId!=null){
		if(gdmId.untr==null){
			if(gdmId.pzbm!=null)
				$("#"+gdmId.pzbm).val($(trObj).attr("id"));
			if(gdmId.unbm!=null)
				$("#"+gdmId.unbm).val($(trObj).find("td:nth(0)").html().replace(/(&nbsp;)/g,''));
			//品名
			if(gdmId.bm!=null)
				$("#"+gdmId.bm).val($(trObj).find("td:nth(1)").html().replace(/(&nbsp;)/g,''));
			//化学名
			if(gdmId.hxm!=null)
				$("#"+gdmId.hxm).val($(trObj).find("td:nth(2)").html().replace(/(&nbsp;)/g,''));
			//安评最大存储量
			if(gdmId.apzdcxl!=null)
				$("#"+gdmId.apzdcxl).val($(trObj).find("td:nth(3)").html().replace(/(&nbsp;)/g,''));
			//计量单位
			if(gdmId.jldw!=null)
				$("#"+gdmId.jldw).val($(trObj).find("td:nth(4)").html().replace(/(&nbsp;)/g,''));
			if(gdmId.unid!=null)
				$("#"+gdmId.unid).val($(trObj).find("td:nth(5)").html().replace(/(&nbsp;)/g,''));
			//英文名	
			if(gdmId.ywm!=null)
				$("#"+gdmId.ywm).val($(trObj).find("td:nth(6)").html().replace(/(&nbsp;)/g,''));
			//英文别名
			if(gdmId.ywbm!=null)	
				$("#"+gdmId.ywbm).val($(trObj).find("td:nth(7)").html().replace(/(&nbsp;)/g,''));
			//计量单位编码
			if(gdmId.jldwbm!=null)
				$("#"+gdmId.jldwbm).val($(trObj).find("td:nth(8)").html().replace(/(&nbsp;)/g,''));
			//单位ID
			if(gdmId.qyid!=null)	
				$("#"+gdmId.qyid).val($(trObj).find("td:nth(9)").html().replace(/(&nbsp;)/g,''));
			//单位编码
			if(gdmId.qybm!=null)
				$("#"+gdmId.qybm).val($(trObj).find("td:nth(10)").html().replace(/(&nbsp;)/g,''));
		}else{
			var untr = gdmId.untr;
			if(gdmId.pzbm!=null)
				$(untr).find("td[name='"+gdmId.pzbm+"']").text($(trObj).attr("id"));
			if(gdmId.unbm!=null)
				$("#"+gdmId.unbm).val($(trObj).find("td:nth(0)").html().replace(/(&nbsp;)/g,''));
			//品名
			if(gdmId.bm!=null)
				$(untr).find("td[name='"+gdmId.bm+"']").text($(trObj).find("td:nth(1)").html().replace(/(&nbsp;)/g,''));
			//化学名
			if(gdmId.hxm!=null)
				$(untr).find("td[name='"+gdmId.hxm+"']").text($(trObj).find("td:nth(2)").html().replace(/(&nbsp;)/g,''));
			//安评最大存储量
			if(gdmId.apzdcxl!=null)
				$(untr).find("td[name='"+gdmId.apzdcxl+"']").text($(trObj).find("td:nth(3)").html().replace(/(&nbsp;)/g,''));
			//计量单位
			if(gdmId.jldw!=null)
				$(untr).find("td[name='"+gdmId.jldw+"']").text($(trObj).find("td:nth(4)").html().replace(/(&nbsp;)/g,''));
			if(gdmId.unid!=null)
				$(untr).find("td[name='"+gdmId.unid+"']").text($(trObj).find("td:nth(5)").html().replace(/(&nbsp;)/g,''));
			//英文名	
			if(gdmId.ywm!=null)
				$(untr).find("td[name='"+gdmId.ywm+"']").text($(trObj).find("td:nth(6)").html().replace(/(&nbsp;)/g,''));
			//英文别名
			if(gdmId.ywbm!=null)	
				$(untr).find("td[name='"+gdmId.ywbm+"']").text($(trObj).find("td:nth(7)").html().replace(/(&nbsp;)/g,''));
			//计量单位编码
			if(gdmId.jldwbm!=null)
				$(untr).find("td[name='"+gdmId.jldwbm+"']").text($(trObj).find("td:nth(8)").html().replace(/(&nbsp;)/g,''));
			//单位ID
			if(gdmId.qyid!=null)	
				$(untr).find("td[name='"+gdmId.qyid+"']").val($(trObj).find("td:nth(9)").html().replace(/(&nbsp;)/g,''));
			//单位编码
			if(gdmId.qybm!=null)
				$(untr).find("td[name='"+gdmId.qybm+"']").val($(trObj).find("td:nth(10)").html().replace(/(&nbsp;)/g,''));
		}
	}
	$("#divs_" + gmcId).remove();
}
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0"  background="images/toolbar.gif">
    <tr>
    	<td width="85%"  style="text-align:left"><input id='t_query_simplepin' class="inputstyle3" type='text' style="width:98%" /></td>
    	<td width="15%" style="text-align:center"><img src="images/clear.gif" width="16" height="16" /><a href="#" id='b_clear' class="fontbutton1">[清除]</a></td>
   	</tr>
</table> 
<div id="DwsjjdhxppzComData" style="width:100%;">
	<table id="DwsjjdhxppzComTable" width="100%">
	  <thead> 
	    <tr> 
	     	<th name="l_unbm">UN码</th>
	     	<th name="l_bm">品名</th>
	     	<th name="l_hxm">涉及品名(化学名)</th>
	     	<th name="l_apzdcxl">最大储存量</th>
	     	<th name="l_jldw">计量单位</th>
	     	<th name="l_unid"></th>
	     	<th name="l_ywm"></th>
	     	<th name="l_ywbm"></th>
	     	<th name="l_jldwbm"></th> 
	     	<th name="l_qyid"></th>
	     	<th name="l_qybm"></th> 
	    </tr>
	  </thead>
	  
	</table>	
</div>