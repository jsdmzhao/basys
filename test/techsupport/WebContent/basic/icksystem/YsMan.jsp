<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery.mypagination.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mypagination.css" type="text/css"></link>
<script type="text/javascript">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
var zbsl = 0;
var ymzbsl = 0;
var currPage = 1;
var ctlp = document.getElementById("ctlPrint");
var ctlr = document.getElementById("ctlReg");
var flag=0;
var ysPerPage = getGlobalparByCode("zdpbh").value;
$(document).ready(function() {
	pageUrl="icksystem/querylist_cjdtjrb.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="icksystem/insert_cjdtjrb.action";
	addHtml="basic/icksystem/CjdtjrbAdd.jsp";
	addWidth="500";
	delUrl="icksystem/delete_cjdtjrb.action";
	//delid="d_cjdtjrbid";
	modHtml="basic/icksystem/CjdtjrbModify.jsp";
	modUrl="icksystem/modify_cjdtjrb.action";
	modWidth="500";
	detailHtml="basic/icksystem/CjdtjrbDetail.jsp";
	detailid="cjdtjrb_detail";
	detailUrl="icksystem/query_cjdtjrb.action";
	detailWidth="300";
	//loadPage("tabledata");
	$("#p_bcysym").selectBox({state:"1"});
	
	if(dataid!="" && delid!="" && (delid.indexOf("zb_")>-1)){
		$("#p_pch").val(dataid);
		var sfqbys = delid.split("_")[1];
		$("#p_sfqbys").val(sfqbys);
		if(sfqbys=="1"){
			$("#radioKs").attr("checked",false);
			$("#radioBc").attr("checked",true);
		}
		getYsymByPch(dataid);
	}

	dataid = "";
	delid = "";
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										height: 250,
										pageNumber: pageno,
										colWidths: ["9%","9%","9%","9%","9%","9%","9%","9%","9%","9%","9%"]									
									});				
		}
}	

function manVerify(){
	if (!checkControlValue("p_pch","String",1,100,null,1,"批次号"))
		return false;
	if (!checkControlValue("p_kssxh","Integer",0,100,null,0,"开始顺序号"))
		return false;
	if (!checkControlValue("p_bcyssl","Integer",0,100,null,0,"本次印刷数量"))
		return false;
	return true;
}

//预览方法
function yulanTupian(yuLanPageSize){
	if(manVerify()){
		if(flag==1){
	 	    if(yuLanPageSize>currPage){
	 	       currPage = currPage;
	 	    }else{
	 	     	currPage = yuLanPageSize;
	 	    }
	 	    flag=0;
	 	}else{
	 	    currPage = yuLanPageSize;
	 	}
	 //初始化分页插件
	 	var totalCount = 0;
	 	if(zbsl==0 && $("#radioBc").attr("checked")){
	 		totalCount = ymzbsl;
	 		if(ymzbsl==0)currPage=0;
	 		else currPage=1;
	 	}else{
	 		if(zbsl==0)currPage=0;
	 		//else currPage=1;
	 		totalCount = zbsl;
	 	}
	 	
	 	$('#mypage').mypagination(totalCount,{
	  			perPage:ysPerPage,
	  			currPage:currPage,
				callback:function(page){
					setPageImage(page);
				}
		});
		//显示预览页面
		$("#div_cardyinshu").css("display","block");
		$("#iframe_cardyinshu").css({width:pageWidth,height:pageHeight-298});
		var iframeSrc;
		iframeSrc = getSrcString(currPage);
		$("#iframe_cardyinshu").attr("src",iframeSrc);
		ctlr.attachEvent("onreadystatechange", setIEymsz); 
		setIEymsz();
		ctlp.SetUrl = "<%=basePath %>"+iframeSrc+"&isdy=1";
	}else{
		return false;
	}
}
//设置ie页面设置
function setIEymsz() { 
	if (ctlr.readyState=='4')
		ctlr.pageSetTemplate();
} 

//得到图片预览页面src
function getSrcString(yuLanPageSize){
	var iframeSrc = "basic/icksystem/CardTemplate.jsp?pch="+$("#p_pch").val();
	if($("#p_sfqbys").val()=="1"){
		if($("#radioBc").attr("checked")){
			iframeSrc += "&ysym="+$("#p_bcysym").val();
			yuLanPageSize = 1;
		}else{
			jAlert("请选择页码方式打印","提示信息");
			return;
		}
	}else{
		if($("#radioBc").attr("checked")){
			iframeSrc += "&ysym="+$("#p_bcysym").val();
		}
		if($("#radioKs").attr("checked")){
			iframeSrc += "&kssxh="+$("#p_kssxh").val() + "&bcyssl="+$("#p_bcyssl").val();
		}
	}
		//alert(iframeSrc);
	iframeSrc += "&yuLanPageSize="+yuLanPageSize;
	return iframeSrc;
}

//批次号失去焦点事件
$("#p_pch").blur(function(){
	var pchValue = $(this).val();
	getYsymByPch(pchValue);
});

//通过批次号得到印刷页码
function getYsymByPch(pchValue){
	if(pchValue!=null && pchValue!=""){
		$("#s_pch").val(pchValue);
		setParams("s_");
		jQuery.post("icksystem/ysymByPch_ickzb.action",params,ysymByPchback,"json");
	}
}

function ysymByPchback(json){
	if(json.result=="success"){
		if(json.LIckzb[0]!=null){
			var ysyms = json.LIckzb[0].ysyms;
			zbsl = json.LIckzb[0].bcyssl;
			$("#p_bcyssl").val(zbsl);
			if(zbsl==0)
				ymzbsl = json.LIckzb[0].bcysslByPage;
			$("#p_bcysym").empty();
			for(var i=1;i<ysyms+1;i++){
				var optionYsyms = "<option value='"+i+"'>"+i+"</option>";
				$("#p_bcysym").append($(optionYsyms));
				$("#p_bcysym").selectBox({state:"1"});
			}
			$("#a_yulanzhaopian").attr("disabled",false);
		}else{
			jAlert("批次号不正确","提示信息");
		}
	}
}

//照片显示方法
function setPageImage(pageno,url){
	
		if($("#p_sfqbys").val()!="1"){
			$("#imgpageno").val(pageno);
			//currPage = pageno;
			yulanTupian(pageno);
		}
}

//打印图片调用方法
function daYinTupian(){
	jConfirm('确定打印吗？', '打印提示', function(r) {
    	if(r==true){
			
		    var err=ctlp.PrintWeb();
		    switch(err){
				case 0:
				    flag=1;
					dayinSuccessBack();
					return true;
				case 1:
					jAlert("打印失败,请检查打印机配置!","提示信息");
					return false;
				case 2:
					jAlert("发生意外错误","提示信息");
					return false;
	 			default:
					return false;
			}
			
		}else{
		   return false;
		}
	});
	
}

//打印后修改制卡状态
function dayinSuccessBack(){
	setParams("y_");
	jQuery.post("icksystem/modifyYs_ickzb.action",params,dayinback,"json");

}

//修改制卡状态回调方法
function dayinback(json){
	if(json.result=="success"){
		jAlert("打印成功","提示信息");
		getYsymByPch($("#s_pch").val());
	}else{
		jAlert(json.result,"错误信息");
	}
	$("#y_ryidSet").val("");
	$("#y_ickslidSet").val("");
}
</script>
<body>
	<input type="hidden" id="d_cjdtjrbid" />
	<input type="hidden" id="s_pch" />
	<input type="hidden" id="p_sfqbys" value="0" />
    <input type="hidden" id="y_ryidSet" />
    <input type="hidden" id="y_ickslidSet" />
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">IC卡查询</td>
  </tr>
  <tr>
    <td bgcolor="#eef6ff">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="15%" class="pagedistd">批次号</td>
					<td colspan="4" class="pagetd"><input type="text" class="inputstyle" id="p_pch" /></td>
		  </tr>
				<tr>
					<td width="15%" class="pagedistd"><label>
					  <input type="radio" name="radio" id="radioKs" value="radio" checked>
					</label>
				    开始顺序号</td>
					<td width="22%" class="pagetd"><input type="text" class="inputstyle" id="p_kssxh" value="1" /></td>
					<td width="22%" class="pagedistd">本次印刷数量（单位张）</td>
				  <td colspan="1" class="pagetd"><input type="text" class="inputstyle" id="p_bcyssl" value="80" /></td>
				  <td align="left" nowrap>（注意该操作只限卡片未印刷情况使用）</td>
		  </tr>
				<tr>
					<td width="15%" class="pagedistd"><label>
					  <input type="radio" name="radio" id="radioBc" value="radio">
                    </label>本次印刷页码</td>
					<td colspan="2" class="pagetd"><select id="p_bcysym"><option></option></select>
				     </td><td align="left" nowrap>（注意该操作不考虑卡片是否已印刷）</td>
				  <td width="23%"><table width="54" border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="47%"><a href="#" id="a_yulanzhaopian" class="submitbutton" disabled="true" onclick='yulanTupian(1)'>预览</a> </td>
                    </tr>
                  </table></td>
		  </tr>
    	</table>
    </td>
  </tr>
</table>	
<div id="div_cardyinshu" style="display:none;overflow-y:auto;">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
 <tr>
    <td class="queryfont">IC卡预览</td>
 </tr>
 <tr>
 <tr>
 <td height="6"></td>
 </tr>
 <tr>
 <td width="23%"><table width="54" border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="47%"><a href="#" class="submitbutton"  onclick='daYinTupian()'>打印</a> </td>
                    </tr>
                  </table></td>
 </tr>
 <tr>
 <td height="6"></td>
 </tr>
 <tr>
 <td>
 <div id='mypage' class='mypagination'></div>
 </td>
 </tr>
 </table>
<iframe id="iframe_cardyinshu" style="overflow-y:auto;"></iframe>
</div>
<%@include file="../../public/includePrintKJ.jsp" %></body>