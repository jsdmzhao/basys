<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/dictDropDown.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery.mypagination.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/jquery.lightbox-0.5.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery.lightbox-0.5.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mypagination.css" type="text/css"></link>
<script type="text/javascript">
var wtgyyDso = "<table></table>";
var jqueryXmlDoc = $(wtgyyDso);
var currPage = 0;
var rowOfNum = Math.round(pageWidth/170);
rows = Math.round((pageHeight-280)/190)*rowOfNum;
var gzrzPageDiv = "qyryxx_detail";
var alertFlag = 0;// 默认0不提示消息
$(document).ready(function() {
	dataid = "";
	modWidth = 160;
	pageUrl="icksystem/listOfZpsh_icksl.action";
	detailid = "zpyy_detail";
	
	createXML("s_");
	$("#p_cjdbm").selectBox({url:"sysadmin/querySelDepart_department.action"});

	daggleDiv("zpyy_detail");
}); 

function manVerify(){
	if (!checkControlValue("p_hjdxzqh","String",1,200,null,0,"户籍省县"))
		return false;
	return true;
}
// 行业类别	
$("#p_hylbdm").selectBoxhylb();
//
function createXmlData(dataList){

}

//照片显示回调方法
function pageImageBack(json){
	$("#imageList").empty();
	var lIcksl = json.LIcksl;
	if(lIcksl.length>0){
		var imageTable = "<table id='imgtable'>";
		imageTable += "<tr>";
		var lIckslLength = lIcksl.length;
		for(var ryNum=0;ryNum<lIckslLength;ryNum++){
			var ryid = lIcksl[ryNum].ryid;
			var ickslid = lIcksl[ryNum].ickslid;
			imageTable += "<td><table>";
			imageTable += "<tr><td class='grid-col-style2'>受理号"+lIcksl[ryNum].kh+"</td></tr>";
			imageTable += "<tr><td><img id='img"+ryid+"' src='icksystem/queryTp_icksl.action?ryId="+ryid+"' width='140' height='160' /></td></tr>";
			imageTable += "<tr><td class='grid-col-style2'><input type='checkbox' id='checkbox_"+ickslid+"' value='"+ickslid+"' />不通过</td></tr>";
			imageTable += "</table></td>";
			if(ryNum>0 && (ryNum+1)%rowOfNum==0){
				imageTable += "</tr><tr>";
			}
		}
		imageTable += "</tr></table>";
		$("#imageList").append($(imageTable));
		
		for(var ryNum=0;ryNum<lIckslLength;ryNum++){
			var ryid = lIcksl[ryNum].ryid;
			var ickslid = lIcksl[ryNum].ickslid;
			var qyid = lIcksl[ryNum].qyid;
			
			if(jqueryXmlDoc.find("#"+ickslid).attr("id")==null){
				var allOfOneRow = "<tr id='"+ickslid+"'><td>"+ickslid+"</td><td>"+ryid+"</td><td>"+qyid+"</td><td>1</td><td>@##@</td></tr>";
				jqueryXmlDoc.append(allOfOneRow);
			}else{
				if(jqueryXmlDoc.find("#"+ickslid).find("td").eq(3).text()=="0"){
					$("#imageList").find("#checkbox_"+ickslid).attr("checked",true);
				}
			}
		}
		
		$("#imageList").find("input[type='checkbox']").click(function(){
			if($(this).attr("checked")){
				var checkTop = $(this).position().top;
				var checkLeft = $(this).position().left;
				
				if((checkLeft+modWidth)>(pageWidth-120))
					checkLeft = checkLeft - ((checkLeft+modWidth) - (pageWidth-130));
					
				$("#"+detailid).css({top:checkTop,left:checkLeft});
				
				if($("#zpyy_detail").html()!="" && dataid!=""){
					$("#imageList").find("input[type='checkbox'][value='"+dataid+"']").attr("checked",false);
				}
				setZpwtgyyPage($(this).val());
			}else{
				$("#"+detailid).empty();
				$("#"+detailid).hide();
				load_ryzpwtgyy_dataXml($(this).val());
			}
		});
	}else{
	    if(alertFlag == 1){
	        $("#tabledata").after($("<div id='ryzpsh-zp' style='padding-top: 180px;padding-left: 460px;float: left; color:#405368; font-weight:bold;'>没有符合条件的记录</div>"));
	        alertFlag = 0;
	    }
	}
	  
	  if($("#mypage").attr("id")==null){
	 	var pageDiv_height = pageHeight-100;
	  	$("#allImageList").append($("<div id='mypage' class='mypagination' style='top:"+pageDiv_height+"px'></div>"));
	  }
	  
	 $('#mypage').mypagination(json.totalrows,{
	  			perPage:rows,
	  			currPage:currPage,
				callback:function(page){
					setPageImage(page);
				}
	});
}

//照片显示方法
function setPageImage(pageno,url){
	setParams("p_");
	var imageData = jQuery.extend(params,{pagesize:pageno,pagerow:rows});
	jQuery.post(pageUrl,imageData,pageImageBack,"json");
	$("#imgpageno").val(pageno);
	currPage = pageno;
}

function getImageList(pageno){
	$("#tabledata").hide();
	$("#ryzpsh-zp").remove();
	if($("#allImageList").attr("id")==null){
		var imageDiv_height = pageHeight-208;
		$("#tabledata").after($("<div id='allImageList' style='border:1px #c5d9e8 solid;'>"+
				"<div id='imageList' style='overflow-y:auto;height:"+imageDiv_height+"px'></div></div>"));
			var caozuoHtml = "<div id='div_wtgyyCaozuo'><table width='100%'><tr><td align='center'><input type='checkbox' id='checkbox_all' value='' />"+
					"全部审核通过</td><td width='70%'></td><td align='right'><a href='#' class='submitbutton' id='querys' onClick='submitAllZpwtgyy();'>确定</a></td><td align='left'>"+
						"<a href='#' class='submitbutton' id='querys' onClick='qxZpwtgyy();'>取消</a></td></tr></table></div>";
						
			$("#allImageList").append($(caozuoHtml));
			
	}else{
		$("#allImageList").show();
	}
	
	if(pageno==null || pageno=="")pageno=1;
	setPageImage(pageno);	
}

//管辖单位所筛选框
 $("#p_gxdw").click(function(){
	getGxdwTree("p_gxdw","p_gxdwbm",'1');
});

//弹出填写照片未通过原因页面
function setZpwtgyyPage(id){
	dataid=id;
	$("#"+detailid).css("width",modWidth+"px");
	setUrl(detailid,"basic/icksystem/ZpwtgyyDetail.jsp");
	//bindDocument(detailid);
}

//将未通过原因设置到jquery对象中
function set_ryzpwtgyy_dataXml(trid){
	var trid_tdlist = jqueryXmlDoc.find("#"+trid).find("td");
    trid_tdlist.eq(3).text(0);
    trid_tdlist.eq(4).text($("#a_zpwtgyy").val());
}

//删除照片未通过原因
function load_ryzpwtgyy_dataXml(trid){
	var trid_tdlist = jqueryXmlDoc.find("#"+trid).find("td");
    trid_tdlist.eq(3).text(1);
    trid_tdlist.eq(4).text("");
}

//取消选中的未通过项
function qxZpwtgyy(){
	jqueryXmlDoc.find("tr").each(function(){
		var tdList = $(this).find("td");
		tdList.eq(3).text(1);
		tdList.eq(4).text("");
	});
	$("#imageList").find("input[type='checkbox']").attr("checked",false);
}

//提交照片未通过原因
function submitAllZpwtgyy(){
	if($("#zpyy_detail").html()!="" && dataid!=""){
		jAlert("请填写原因保存或关闭窗口","提示信息");
		return;
	}
	if(!($("#imgtable").attr("id")==null)){
		jConfirm('确定审核照片吗？', '审核提示', function(r) {
			if(r==true){
				allPageUp();
				var qingqiuSrc = "";
				if(!$("#checkbox_all").attr("checked")){
					qingqiuSrc = "icksystem/modifyZpsh_icksl.action";
					var ickslidSet= "";
					var ryidSet= "";
					var qyidSet= "";
					var zpsftgSet= "";
					var wtgyySet= "";
					var trList = jqueryXmlDoc.find("tr");
					var listLength = trList.length;
					trList.each(function(i){
						var tdList = $(this).find("td");
						ickslidSet += tdList.eq(0).text()+"_,,";
						ryidSet += tdList.eq(1).text()+"_,,";
						qyidSet += tdList.eq(2).text()+"_,,";
						zpsftgSet += tdList.eq(3).text()+"_,,";
						wtgyySet += tdList.eq(4).text()+"_,,";
						
						if(listLength<100){
							if(listLength==(i+1)){
								$("#y_ryidSet").val(ryidSet);
								$("#y_ickslidSet").val(ickslidSet);
								$("#y_qyidSet").val(qyidSet);
								$("#y_zpsftgSet").val(zpsftgSet);
								$("#y_wtgyySet").val(wtgyySet);
								setParams("y_");
								jQuery.post(qingqiuSrc,params,shenheback,"json");
							}
						}else{
							if(i!=0 && (i+1)%100==0){
								$("#y_ryidSet").val(ryidSet);
								$("#y_ickslidSet").val(ickslidSet);
								$("#y_qyidSet").val(qyidSet);
								$("#y_zpsftgSet").val(zpsftgSet);
								$("#y_wtgyySet").val(wtgyySet);
								setParams("y_");
								jQuery.post(qingqiuSrc,params,shenheback,"json");
								ickslidSet= "";
								ryidSet= "";
								qyidSet= "";
								zpsftgSet= "";
								wtgyySet= "";
							}else{
								if(listLength-(i+1)<100){
									if(listLength==(i+1)){
										$("#y_ryidSet").val(ryidSet);
										$("#y_ickslidSet").val(ickslidSet);
										$("#y_qyidSet").val(qyidSet);
										$("#y_zpsftgSet").val(zpsftgSet);
										$("#y_wtgyySet").val(wtgyySet);
										setParams("y_");
										jQuery.post(qingqiuSrc,params,shenheback,"json");
									}
								}
							}
						}
					});
					
					$("#y_ryidSet").val(ryidSet);
					$("#y_ickslidSet").val(ickslidSet);
					$("#y_qyidSet").val(qyidSet);
					$("#y_zpsftgSet").val(zpsftgSet);
					$("#y_wtgyySet").val(wtgyySet);
					setParams("y_");
					
				}else{
					$("#t_gxdwbm").val($("#p_gxdwbm").val());
					$("#t_cjdbm").val($("#p_cjdbm").val());
					setParams("t_");
					qingqiuSrc = "icksystem/modifyZpqbsh_icksl.action";
					jQuery.post(qingqiuSrc,params,shenheback,"json");
				}
			}
		});
	}else{
		jAlert("没有可供审核的人员照片","提示信息");
	}
}


//IC 照片审核回调方法
function shenheback(json){
	if(json.result=="success"){
	    isPlayChengGong = true;
		jAlert("审核成功","提示信息");
		$(".tableborder").find("input").val("");
		getImageList(1);
	}else{
		jAlert(json.result,"错误信息");
	}
	$('#jquery-overlay').remove();	
}

function allPageUp(){
	$('#allDiv').before('<div id="jquery-overlay"></div>');
	$('#jquery-overlay').css({
		backgroundColor: 	"#FFFFFF",
		opacity:			0.8,
		width:				pageWidth,
		height:				pageHeight
	}).fadeIn();	
}
function searchImageList(){
    alertFlag = 1;// 1提示消息
    getImageList(1);
}
</script>

<body>
<input type="hidden" id="s_isCjd" value="1" />
<input type="hidden" id="t_sfqbtg" value="1"  />
<input type="hidden" id="t_gxdwbm" />
<input type="hidden" id="t_cjdbm" />
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项
    <input type="hidden" id="y_ryidSet" />
    <input type="hidden" id="y_ickslidSet" />
    <input type="hidden" id="y_qyidSet" />
    <input type="hidden" id="y_zpsftgSet" />
    <input type="hidden" id="y_wtgyySet" />
    </td>
  </tr>
  <tr>
    <td valign="top" class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
				    <td width="10%" class="pagedistd">行业类别</td>
		            <td width="23%" class="pagetd"><select  id="p_hylbdm" ></select></td>
				    <td width="10%"  class="pagedistd">所属地市</td>
			        <td width="23%"  class="pagetd"><input type="text" class="inputstyle" id="p_gxdw" readonly><input type="hidden" id="p_gxdwbm" value=""></td>	  
                  <td width="10%" class="pagedistd">受理点</td>
                  <td class="pagetd"><select id="p_cjdbm"><option></option></select></td>
                  <td ><a href="#" class="searchbutton" id="querys" onClick="searchImageList();">查询</a></td>
         </table>
      </td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
</table>
<!--  
<div id="allImageList">	
<div id="imageList"><div>
<div>-->
<div id="zpyy_detail"  class="page-layout" src="#"
		style="display:none;top:0px;">
</div>
<div id="tabledata" style="width:100%;">
</div> 
</body>