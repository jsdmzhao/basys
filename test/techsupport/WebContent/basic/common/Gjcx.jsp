<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
var addTableTr = "";
var xuanzemianban = 0;
var loadNum = 0;
var zdyLoadNum = 0;
var gjcxfaName;
$(document).ready(function() {
	getFangAnSelect();

	$("#gjcx_xszd").empty();
	$("#gjcx_xszd").width("160px");
	$("#gjcx_xszd").load("basic/common/Gjcx_syzd.jsp");
	
	$("#gjcx_pptj").empty();
	$("#gjcx_pptj").width("630px");
	$("#gjcx_pptj").load("basic/common/Gjcx_pptj.jsp");
	
	$("#gjcx_pxgz").empty();
	$("#gjcx_pxgz").width("630px");
	$("#gjcx_pxgz").load("basic/common/Gjcx_pxgz.jsp");

	$("#gjcx_zdysqlcx").empty();
	$("#gjcx_zdysqlcx").width("780px");
	$("#gjcx_zdysqlcx").load("basic/common/Gjcx_zdycx.jsp");
	
	daggleDiv("gjcx_detail");
});

function getFangAnSelect(){
	$("#b_ssgnmc").val(func_code);
	$("#a_ssgnmc").val(func_code);
	
	createXML("b_");
	$("#fangan_list").selectBox({url:"basicsystem/listNoPage_gjcxfa.action"});
}

//显示标签方法
function show_biaoqian(id){
 	if(id=='biaoqian_3'){
 		$("#pptjAndPxgzTr").css("display","block");
 		$("#pptjAndPxgzTrHide").css("display","none");
 		$("#table_dtcx").removeClass("nav1").addClass("nav11");
 		$("#table_zdysqlcx").removeClass("nav33").addClass("nav3");
 		$("#biaoqian_3").css("display","block");
 		$("#biaoqian_4").css("display","none");
 	}else if(id=='biaoqian_4'){
 		$("#pptjAndPxgzTr").css("display","none");
 		$("#pptjAndPxgzTrHide").css("display","block");
 		$("#table_zdysqlcx").removeClass("nav3").addClass("nav33");
 		$("#table_dtcx").removeClass("nav11").addClass("nav1");
 		var zdyDisplay = $("#biaoqian_4").css("display");
 		$("#biaoqian_4").css("display","block");
 		$("#biaoqian_3").css("display","none");
 		if(zdyLoadNum == 0 && zdyDisplay == "none"){
			zdyLoadNum = 1;
		}
 		
 	}else if(id=='td_pptj'){
 		$("#click_pptj").removeClass("nav011").addClass("nav01");
 		$("#click_pxgz").removeClass("nav01").addClass("nav011");
 		xuanzemianban = 0;
 		$("#td_pptj").css("display","block");
 		$("#td_pxgz").css("display","none");
 		addTableTr = "";
 		if(loadNum==0)
			getFanganZbxx("","");
 	}else{
 		$("#click_pxgz").removeClass("nav011").addClass("nav01");
 		$("#click_pptj").removeClass("nav01").addClass("nav011");
 		xuanzemianban = 1;
 		var pxgzDisplay = $("#td_pxgz").css("display");
 		$("#td_pptj").css("display","none");
 		$("#td_pxgz").css("display","block");
 		addTableTr = "";
 		if(loadNum == 0 && pxgzDisplay == "none"){
 			loadNum = 1;
		}
 	}
}

//高级查询方法
function setGaojiList(){

	if($("#biaoqian_4").css("display")!="block"){
	///*
		if(!validateSqlYuJu()){
			return;
		}//*/
		
		dataid = "sjbjgid";
		var pptjList = new Array("Pptj_tableData","Pxgz_tableData");
		$("#a_gjcxlx").val("动态");
		
		removeInput();
		
		setParams("a_",pptjList);
	}else{
		$("#a_gjcxlx").val("SQL");
		var pptjList = new Array("Pptj_tableData","Pxgz_tableData");
		setParams("a_",pptjList);
		//setParams("a_");
	}
	jQuery.post("basicsystem/executeQuery_gjcxfa.action",params,putHiddenValueback,"json"); 
}

function putHiddenValueback(json){
	$("#p_superbWhere").val(json.gjcx[0]);
	$("#p_superbOrderBy").val(json.gjcx[1]);
	//原先默认查询以p_为前缀，现在可根据自定义前缀
	if(gjcx_ListPrefix!="p_"){
		var whereId = $("#p_superbWhere").attr("id");
		var orderById = $("#p_superbOrderBy").attr("id");
		$("#p_superbWhere").attr("id",(gjcx_ListPrefix+whereId.substring(gjcx_ListPrefix.length)));
		$("#p_superbOrderBy").attr("id",(gjcx_ListPrefix+orderById.substring(gjcx_ListPrefix.length)));
	}
	setParams(gjcx_ListPrefix);
	
	if(gjcx_pageListMethod==null || gjcx_pageListMethod=="")
		setPageList(1);
	else
		eval(gjcx_pageListMethod+"(1)");
	gjcx_pageListMethod = "";
	var parent_Page = $("#hide_div").parent();
	parent_Page.empty();
	parent_Page.hideAndRemove("show");
}

//高级查询保存
function gjcx_baocun(){
	setWidth("gjcx_detail","230");
	var parentDiv = $("#hide_div").parent();
	$("#gjcx_detail").css("left",(parentDiv.width()-230)/2);
	setUrl("gjcx_detail","basic/common/Gjcx_faAdd.jsp");
}

//高级查询维护
function gjcx_weihu(){
	setWidth("gjcx_detail","400");
	var parentDiv = $("#hide_div").parent();
	$("#gjcx_detail").css("left",(parentDiv.width()-400)/2);
	setUrl("gjcx_detail","basic/common/Gjcx_falist.jsp");
}

//关闭当前div
function hideGjcxPage(){
	var parent_Div = $("#hide_div").parent();
	parent_Div.empty();
	parent_Div.hideAndRemove("show");
}

//得到高级查询方案子表信息
function getCxfaZb(){
	var fanganId = $("#fangan_list").val();
	gjcxfaName = $("#fangan_list").attr("title");
	loadNum = 0;
	getFanganZbxx($("#fangan_list").val());
}

function getFanganZbxx(dataVal,level){
	if(level==null){
		if(dataVal==null || dataVal=="")
			dataVal = "-1";
		$("#h_gjcxfaid").val(dataVal);
		$("#a_gjcxfaid").val(dataVal);
	}
	
	var gjcxfaid = $("#h_gjcxfaid").val();
	if(gjcxfaid==null || gjcxfaid==""){
		$("#h_gjcxfaid").val("-1");
		$("#a_gjcxfaid").val("-1");
	}
	setDetail_zdycx();									
	setPageList_pptj(1);
	setPageList_pxgz(1);
}

function addTrEvent(tr){
	var currTrClass;
	jQuery(tr).hover(
		function() { 
		currTrClass = $(tr).attr("class");
		if (jQuery(this).attr('_selected') != 'true')
			jQuery(this).removeClass(currTrClass).addClass("grid-row-hover") ; 
		},
		function() { if (jQuery(this).attr('_selected') != 'true') jQuery(this).removeClass("grid-row-hover").addClass(currTrClass); }	
	);
	
	jQuery(tr).click(function(){
		var tr_class;
		jQuery(this).parent().find("tr").each(function(i){
			if(i%2==1)
				tr_class = "grid-row-style2";
			else
				tr_class = "grid-row-style1";
				
			jQuery(this).removeClass("grid-row-sel").removeClass("grid-row-hover").addClass(tr_class).attr("_selected","false");
		});
		jQuery(this).removeClass("grid-row-hover").addClass("grid-row-sel").attr("_selected","true") ;
	});
}

//依据gjcxfaid查询数据表单条信息
function setDetail_zdycx(){
	setParams("h_");
	jQuery.post("basicsystem/query_zdycxtj.action",params,updatediv_zdycx,"json");
}

function updatediv_zdycx(json){
	var zdycxtj = json.LZdycxtj[0];
	if(zdycxtj!=null){
		$("#a_cxtj").val(setNull(zdycxtj.cxtj));
		$("#a_cxpx").val(setNull(zdycxtj.cxpx));
	}else{
		$("#a_cxtj").val("");
		$("#a_cxpx").val("");
	}
}

function validateSqlYuJu(){
//验证括号
	var kskhArry = new Array();
	var jskhArry = new Array();
	var ljfArry = new Array();
	var ifSuccess = true;
	var kskhNum = 0;
	var jskhNum = 0;
	var trList = $("#pptjTable").find("tr");
	trList.find("td:first").each(function(){
		if($(this).text()=="("){
			kskhNum += 1;
			kskhArry[kskhArry.length] = trList.index($(this).parent());
		}else if($(this).text()=="(("){
			kskhNum += 2;
			kskhArry[kskhArry.length] = trList.index($(this).parent());
		}else if($(this).text()=="((("){
			kskhNum += 3;
			kskhArry[kskhArry.length] = trList.index($(this).parent());
		}
	});
	trList.each(function(i){
		var nth5Text = $(this).find("td:nth(5)").text();
		if(nth5Text==")"){
			jskhNum += 1;
			jskhArry[kskhArry.length] = trList.index($(this));
		}else if(nth5Text=="))"){
			jskhNum += 2;
			jskhArry[kskhArry.length] = trList.index($(this));
		}else if(nth5Text==")))"){
			jskhNum += 3;
			jskhArry[kskhArry.length] = trList.index($(this));
		}	
	});
	if(kskhNum!=jskhNum){
		jAlert("“(”与“)”个数不一致","验证信息");
		return false;
	}
	
//验证匹配符
	$("#pptjTable").find("tr:not(tr:first)").each(function(){
		var nth3Text = $(this).find("td:nth(3)").text();
		if(nth3Text==""){
			jAlert("匹配符不能为空","验证信息");
			ifSuccess = false;
		}
	});
	if(!ifSuccess)
		return ifSuccess;

//验证逻辑符	
	$("#pptjTable").find("tr:not(tr:last,tr:first)").each(function(i){
		var lastText = $(this).find("td:last").text();
		if(lastText==""){
			jAlert("不是最后一行逻辑符不能为空","验证信息");
			ifSuccess = false;
		}
		if(lastText=="或"){
			ljfArry[ljfArry.length] = trList.index($(this));
			//alert(ljfArry[ljfArry.length-1]);
		}
	});
	if(!ifSuccess)
		return ifSuccess;
	
	var nthLastText = $("#pptjTable").find("td:last").text();
	if(nthLastText=="和" || nthLastText=="或"){
		jAlert("最后一行逻辑符应为空","验证信息");
		return false;
	}
	
	//kskhArry  jskhArry
	var ljfValidate = false;
	var ljfLength = ljfArry.length;
	if(ljfLength>0){
		var ksLength = kskhArry.length,jsLength = jskhArry.length;
		if(ksLength==0 || jsLength==0){
			ljfValidate = true;
		}else{
			var kskhValidate = true,jskhValidate = true;
			for(var index=0;index<ksLength;index++){
				if(kskhArry[index]<=ljfArry[0]){
					kskhValidate = false;
					break;
				}
			}
			for(var index=0;index<jsLength;index++){
				if(jskhArry[index]>ljfArry[ljfLength-1]){
					jskhValidate = false;
					break;
				}
			}
			ljfValidate = kskhValidate || jskhValidate;
		}
		
		if(!ljfValidate){
			for(var index=0;index<ljfLength;index++){
				kskhNum = 0;
				jskhNum = 0;
				var ljfValue = ljfArry[index];
				trList.slice(1,ljfValue+1).each(function(){
					var nth1Text = $(this).find("td:first").text();
					var nth5Text = $(this).find("td:nth(5)").text();
					if(nth1Text=="("){
						kskhNum += 1;
					}else if(nth1Text=="(("){
						kskhNum += 2;
					}else if(nth1Text=="((("){
						kskhNum += 3;
					}	
					
					if(nth5Text==")"){
						jskhNum += 1;
					}else if(nth5Text=="))"){
						jskhNum += 2;
					}else if(nth5Text==")))"){
						jskhNum += 3;
					}	
				});
				if(kskhNum<=jskhNum){
					ljfValidate = true;
					break;
				}
			}
		}
	}
	
	if(ljfValidate){
		jAlert("逻辑符“或”必须在括号内","验证信息");
		return false;
	}
	
	return true;
}

function removeInput(){
	$("#Pptj_tableData").find("input").each(function(){
		if($(this).attr("type")=="text"){
			$(this).parent().text($(this).val());
		}
		$(this).remove();
	});
}

</script>
<!--<input type="button" value="测试" onclick="validateSqlYuJu();" />-->
<div id="hide_div"></div>
<input type="hidden" id="h_gjcxfaid" />
<input type="hidden" id="a_gjcxfaid" />
<input type="hidden" id="b_ssgnmc" />
<input type="hidden" id="a_ssgnmc" />
<input type="hidden" id="a_gjcxlx" />
<input type="hidden" id="p_superbWhere" name="p_superbWhere"/>
<input type="hidden" id="p_superbOrderBy" name="p_superbOrderBy"/>

<!-- 高级查询使用字段功能 -->
<input type="hidden" id="g_sjbidSet">
<input type="hidden" id="g_sjbid">
<input type="hidden" id="g_sjbmSet">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">高级查询</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='hideGjcxPage();'class="close"></a></td>
    </tr>
</table>
<!--动态查询开始-->
<table width="100%" border="0" align="center"  cellpadding="0" cellspacing="0" id=biaoqian_1 style="DISPLAY: block">
<tr>
<td valign="top">
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
       				<table width="100%" border="0"  align="right" cellpadding="0" cellspacing="0" class="nav11" id="table_dtcx">
            		<tr><td><a  href="#" onmousedown="show_biaoqian('biaoqian_3')" class="navfont" hidefocus="true">动态查询</a></td></tr>
            		</table>
            	</td>
        		<td width="156">
       			  <table width="100%" border="0" align="left" cellpadding="0" cellspacing="0" class="nav3" id="table_zdysqlcx" >
            		<tr><td align="center"><a href="#" onmousedown="show_biaoqian('biaoqian_4')" class="navfont" hidefocus="true" >自定义SQL查询</a></td></tr>
       			  </table>
        		</td>
        		<td width="1034" valign="bottom"><table width="100%" align="right" cellpadding="0" cellspacing="0" class="navbg">
                    <tr>
                      <td width="62%">&nbsp;</td>
                      <td width="11%"><a id="hyperlinkSave"  class="fontbutton1"  href="#" onclick="gjcx_baocun();">[保存]</a></td>
                      <td width="12%"><a href="#"  class="fontbutton1" onclick="gjcx_weihu();">[维护]</a></td>
                      <td width="15%" class="detailtd"><select id="fangan_list" onchange="getCxfaZb();"><option value=""></option></select></td>
                    </tr>
      		  </table></td>
      		</tr>
    		</table>
    	</td>
  		</tr>
	</table>
<div id="gjcx_detail"  class="page-layout" src="#"
		style="display:none; top:100px;"> </div>
	<table width="100%"  cellspacing="0" cellpadding="0" class="line" style="border-bottom:none" >
	<tr>
	<td valign="top">
     <!--匹配条件开始-->   
		<table width="100%" border="0" cellspacing="0" cellpadding="1"  id="biaoqian_3" style="DISPLAY: block">
		      <tr><!-- 显示字段 及 查询字段 div -->
		        <td width="30%" valign="top" align="left"><div id="gjcx_xszd" style="height:280">显示字段</div></td>
		        <td class="pagetd1" valign="top">
	        	  <table width="100%"  border="0" cellspacing="0" cellpadding="0" >
		        	<tr>
		       	 <td class="pagetd1" id="td_pptj"><div class="textdiv" id="gjcx_pptj"></div></td>
		       	 <td class="pagetd1" id="td_pxgz" style="display:none"><div class="textdiv" id="gjcx_pxgz"></div></td>
		        </tr>
                <tr>
		        	</table>
		        </td>
	          </tr>
	          <tr>
		      <td colspan="2">
                </td></tr>
		</table>
 <!--匹配条件结束-->       
           <!--排序规则开始-->   
		<table width="100%" border="0" cellspacing="0" cellpadding="1"  id="biaoqian_4" style="DISPLAY: none">
		      <tr>
		        <td class="pagetd1">
		        	<div id="gjcx_zdysqlcx"></div>
		        </td>
	          </tr>
                <tr><td colspan="2">
                <table width="100%"  border="0" align="left" cellpadding="0" cellspacing="0">
      <tr>
        <td width="25" valign="bottom"></td>
        <td width="78" id="qitabq4">&nbsp;</td>
        <td width="1048" valign="bottom">&nbsp;</td>
      </tr>
    </table></td></tr>
		</table>
 <!--排序规则结束-->       
		</td>
	</tr>
	</table>
</td>
</tr>
</table>
<table width="100%"  border="0" align="left" cellpadding="0" cellspacing="0">
<tr id="pptjAndPxgzTrHide" style="display:none"><td class="navbg01">&nbsp;</td><td class="navbg01">&nbsp;</td></tr>
  <tr id="pptjAndPxgzTr">
    <td width="14"  class="navbg01" >&nbsp;</td>
    <td width="78" valign="top"><table width="100%" border="0"  align="right" cellpadding="0" cellspacing="0" class="nav01" id="click_pptj">
      <tr>
        <td valign="top"><a  href="#" onmousedown="show_biaoqian('td_pptj')" class="navfont01" hidefocus="true">匹配条件</a></td>
      </tr>
    </table></td>
    <td width="78" valign="top" ><table width="100%" border="0" align="left" cellpadding="0" cellspacing="0"  class="nav011" id="click_pxgz" >
      <tr>
        <td align="center" valign="top"><a href="#" onmousedown="show_biaoqian('td_pxgz')" class="navfont01" hidefocus="true" >排序规则</a></td>
      </tr>
    </table></td>
    <td  class="navbg01" >&nbsp;</td>
  </tr>
</table>
<br />
<br />
<table width="100" border="0" align="center" cellpadding="2" cellspacing="0">
  <tr>
    <td width="59%" height="3" ></td>
  </tr>
  <tr>
    <td width="59%" align="right"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="查询" onclick='setGaojiList();'>查询</a></td>
    <td width="41%"><a href="#" hidefocus="true" class="submitbutton" title="取消" onclick='hideGjcxPage();'>取消</a></td>
  </tr>
</table>
