<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/stringcommon.js"></script>
<script type="text/javascript">
    //var parentDiv = $("#a_jsdwbm").parent();
    
    var fjnum = 0;  ///附件的个数  
    var selectHtml = "";
	var selectWidth = "";
	var selectid = "";
	
	$(document).ready(function(){
		selectHtml = "basic/basicsystem/XctbSelect.jsp";
		selectWidth = "720";
		selectid = "xctb_select";		
		$("#a_fbsj").attr("readonly","true");  ///控件只读属性
		//$("#a_fbsj").datepicker();             ///控件加时间
		$("#a_jzrq").attr("readonly","true");  ///控件只读属性
		$("#a_jzrq").datepicker();             ///控件加时间
		var xctbUrl = "basicsystem/initxctbAdd_xctb.action";
		jQuery.post(xctbUrl,params,initxctbAdd,"json"); 
		$("#a_fbsj").attr("value",gettoday());
		$("#a_jzrq").attr("value",getcxday());
		///初始化附件ingrid
		var addtables=$("#fjshowdiv").html();
		$("#fjshowdiv").html(addtables);
		setPageList_xctbadd(1);
		$("#" + selectid).hide();
		daggleDiv(selectid);
	});
	 function setPageList_xctbadd(pageno,url){	
			url="#";
			var mygrid1 = $("#fjnameshowtable").ingrid({ 
											url: url,
											tableid : "fjnameshow",
											ingridHtmlFlag:true,
											gridClass:'tablestyle',
											height: 120,
											sorting: false,
											pageNumber: pageno,
											paging: false,
											onRowSelect: function(tr, selected){
										    },
										    ingridPageWidth: 680,
										   colWidths: ["70%","30%"]									
										});				
	}
	
	////添加验证 
	function addVerify(){
	    //if (!checkControlValue("a_sxhylbmc","String",1,1000,null,1,"行业类别"))
			//return false;
		if(document.getElementById("a_sxhylbmc").value==""){
		    jAlert("行业类别不能为空","验证信息",null,null);
		    return false;
		    }
		if(!checkControlValue("a_jsdwmc","String",1,100000,null,1,"接收单位名称"))
		    return false;
		if (!checkControlValue("a_bt","String",1,100,null,1,"标题"))
			return false;
		if (!checkControlValue("a_fbsj","Date",null,null,null,1,"发布时间"))
			return false;
		if (!checkControlValue("a_jzrq","Date",null,null,null,1,"截至时间"))
			return false;
		if (!checkControlValue("a_fbnr","String",1,2000,null,1,"通知内容"))
			return false;
		if (!checkControlValue("a_fbr","String",1,100,null,1,"发布人"))
			return false;
		if (!checkControlValue("a_fbdw","String",1,200,null,1,"发布单位"))
			return false;
		if (!checkDateEarlier("a_fbsj","发布时间","a_jzrq","截至时间","DATE")){
			return false;
		}
		return true;
	}
	
	//选择接收单位事件
	$("#a_jsdwmc").click(function(){
	    var hylbdmall = hylbbm;//$("#a_sxhylbdm").attr("value");
	    if(hylbbm ==""||hylbbm==null){
	       alert("请选择行业类别！");
	       return false;
	    }
		if($("#tdhylb").find("input:checked").length == 1 && (hylbdmall == 'A' || hylbdmall == 'N' || hylbdmall == 'J')){
			//清空行业类别session
			jQuery.post("basicsystem/clearHylb_xctb.action",null,null,"json");
			//清空企业单位session
			setClearxctb();
			//选择单个行业旅馆业、内保、娱乐时，显示接收单位行业细选页面
			$("#a_jsdwmc").val("");
			$("#a_jsdwbm").val("");
			setSelectPageXctb();
		} else {
			//选择多行业时，显示接收单位下拉树
			setClearxctb();
			$("#a_jsdwmc").val("");
			$("#a_jsdwbm").val("");
			getXctbTree("a_jsdwmc", "a_jsdwbm", hylbdmall);		
		}
    });
		
	//显示接收单位行业细选页面
	function setSelectPageXctb(){
		sFlag = "false";
		//回显选择的企业单位名称
		gmcId = "a_jsdwmc";
		setWidthSome(selectid, selectWidth);
		setUrl(selectid, selectHtml);
		bindDocument(selectid);
	}
	
	function initxctbAdd(json){
	 document.getElementById("a_fbr").value = json.user.username;
	 document.getElementById("a_fbdw").value = json.user.department.departname;
	 document.getElementById("a_fbdwbm").value = json.user.department.departcode;
	 document.getElementById("tdhylb").innerHTML = json.hylbstr;
	 $("#tdhylb").find("input:checkbox").click();
	}
	
	var hylb = "";
	var hylbbm = "";
	var setFlage = 1;
	
	/////把所选的行业赋值给 a_hylb 和 a_hylbbm
	function gethylb(obj){ 
	 var hylbname = $(obj).attr("name");
	 var hylbid  = $(obj).attr("id");
	 if($(obj).attr("checked")==true){
	   //选中
	   if(hylb==""){
	    hylb += hylbname;
	    hylbbm += hylbid;
	   }else{
	     if(hylb.indexOf(hylbname)==-1)
	      hylb += ";"+ hylbname;
	      hylbbm += ";"+hylbid;
	   } 
	 }else{
	   //由选中状态 清除
	   if(hylb.indexOf(hylbname)!=-1){
	      if(hylb.indexOf(hylbname)==0){
	        hylb = replaceString(hylb,hylbname+";","");
	        hylbbm = replaceString(hylbbm,hylbid+";","");  
	      }else{
	        hylb = replaceString(hylb,";"+hylbname,"");
	        hylbbm = replaceString(hylbbm,";"+hylbid,""); 
	      }
	   }
	   if(hylb==null)
	       hylb = "";
	   if(hylbbm==null)
	       hylbbm = "";
	 }
	 document.getElementById("a_sxhylbmc").value = hylb;
	 document.getElementById("a_sxhylbdm").value = hylbbm;
	 
	 ///////选择行业类别 要清空 接受单位
	 //////////////////////////////
	 document.getElementById("a_jsdwbm").value = "";
	 document.getElementById("a_jsdwmc").value = "";
	 ///////选择行业类别 要清空 附件
	 delallfj();
	}
	
	//根据具体的选择来设置行业类别
    function sethylb(selectedHylbbm, selectedHylbmc){
        var hylbs = selectedHylbbm.split(";");
        $.each(hylbs, function(i, n){
            var setObject = $("#tdhylb").find("input[id='" + n + "']");
            var hylbname = $(setObject).attr("name");
            var hylbid = $(setObject).attr("id");
			$(setObject).attr("checked", false);
            //由选中状态 清除
            if (hylb.indexOf(hylbname) != -1) {
                if (hylb.indexOf(hylbname) == 0) {
                    hylb = replaceString(hylb, hylbname + ";", "");
                    hylbbm = replaceString(hylbbm, hylbid + ";", "");
                } else {
                    hylb = replaceString(hylb, ";" + hylbname, "");
                    hylbbm = replaceString(hylbbm, ";" + hylbid, "");
                }
            }
            if (hylb == null) 
                hylb = "";
            if (hylbbm == null) 
                hylbbm = "";
			document.getElementById("a_sxhylbmc").value = hylb;
	 		document.getElementById("a_sxhylbdm").value = hylbbm;
        });
    }
	
	///把文件转换为base64码
	var allfielName = "";
	var allbase64Code = "";
	var pathfileName;
	
	
	function ImgerToBase(){   
		//设置打开图片的大小
		ImgerToBase1.SetFileSize= 10000;
		pathfileName=null;
		//显示图片路径
		pathfileName = ImgerToBase1.getFileName();
		
		var fileName = pathfileName; ///得到文件名字
		
		////cuicui update 
		if(fileName!=null&&fileName!=""){
		ajaxAddDivCeng();
			//显示BASE64编码
		var base64code = ImgerToBase1.getBase64();
	     params={fileNamecon:fileName,base64codecon:base64code};
         jQuery.post("basicsystem/uptempfile_xctb.action",params,uploadfileback,"json");
         
		}
		//////////
		
	}
	/////上传文件的回调函数
	function uploadfileback(json){
	   removeAllDivCeng();
	   var obj = document.getElementById("fjnameshow");
	   var newTr = obj.insertRow();
	   var newTd0 = newTr.insertCell();
	   var newTd1 = newTr.insertCell();
	   newTd0.width = "70%";
	   newTd1.width = "30%";
	   newTd0.innerHTML = json.fileNamecon;  ///返回的文件名字
	   newTd1.innerHTML = "<a href='#' onclick='delfj();' style='cursor:hand;' class='fontbutton' >删除</a>"; 
	
	   /////new 把附件名字 和转换后的base64码 放入隐藏域
	   var newRow="<TR><TD><DIV>"+json.fileNamecon+"</DIV></TD><TD><DIV>"+json.fileTempNamecon+"</DIV></TD></TR>";
	   var queryNewRow = $(newRow);
	   $("#fjcontect").append(queryNewRow);
	  
	   fjnum = fjnum+1;  ////附件个数加1
	  
	}
	
	
	/////添加附件的方法
	function openfile(){
	   var hylbdm = $("#a_sxhylbdm").attr("value");
	   if(hylbdm==""){
	     jAlert("请选择行业类别",'提示信息');
	     return false;
	   }
	   
	   if(hylbdm.indexOf("A")>=0||hylbdm.indexOf("Z")>=0){
	     ///如果协查通报中的行业类别包括旅馆业 控制附件的个数不能大于1
	     if(fjnum>0){
	       jAlert("通知通告的附件个数不能大于1",'提示信息');
	       return false;
	     }
	   }
	   //alert(fjnum);
	   ImgerToBase1.OpenFile();
	   ImgerToBase();
	} 
	/////重写添加方法
	function setAddxctb(){	
		if (addVerify()){
		    var child=new Array("XctbfjListData");
			setParams("a_",child);
			allXctbPageUp();
			jQuery.post(addUrl,params,addbackxctb,"json");
		}else{
			return addVerify();
		}	
    }	
	function addbackxctb(json){
	  $("#jquery-overlayXctb").remove();
	  if(json.result=="success"){
		jAlert(addMessage,'提示信息');
		setPageList($("#pageNo").attr("value"));
		setAddPage();
	  }else{
		jAlert(json.result,'错误信息');
	  }		
    }
    
    ///////在添加页面删除附件
    function delfj(){
	 //获得行索引
	 //两个parentElement分别是TD和TR哟，rowIndex是TR的属性
	 //this.parentElement.parentElement.rowIndex
	 ////得到tr的rowIndex属性
	 var cGetRow=window.event.srcElement.parentElement.parentElement.rowIndex;
	 var obj = document.getElementById("fjnameshow");
	 ////显示部分删除附件名称
	 obj.deleteRow(cGetRow);
	 
	 //alert($("#fjcontect").find("tr").eq(cGetRow-1).find("td:nth(1)").text());
	 var fileTempName = $("#fjcontect").find("tr").eq(cGetRow-1).find("td:nth(1)").text(); /////上传的临时文件名字
	 ////隐藏域删除附件信息
	 $("#fjcontect").find("tr").eq(cGetRow-1).remove();
	 params={fileTempNamecon:fileTempName};
	 jQuery.post("basicsystem/deleteFile_xctb.action",params,delback,"json");  ////删除上传的文件
	 
	  fjnum = fjnum-1;  ////附件个数减1
	 
    }
    function delback(){}
    
    ///////清空所有的控件
    function delallfj(){
    
      var child=new Array("XctbfjListData");
	  setParams("a_",child);
	  jQuery.post("basicsystem/deleteAllFile_xctb.action",params,delback,"json");
	  
      $("#fjnameshow").find("tr:not(tr:first)").remove();
      $("#fjcontect").find("tr").remove();
      fjnum = 0;
    }
    
    ////////得到今天的日期
    function gettoday(){
     var today = new Date();
     var month = "";
     var date = "";
     if((today.getMonth()+1)<10)
         month = "0"+(today.getMonth()+1);
     else
         month = today.getMonth()+1;
     
     if(today.getDate()<10)
         date = "0"+today.getDate();
     else
         date = today.getDate();
     mydate = today.getYear()+"-"+month+"-"+date;
     return mydate;
  }
  function getcxday(){
    var today = new Date();
    today.setDate(today.getDate()+30);
     var month = "";
     var date = "";
     if((today.getMonth()+1)<10)
         month = "0"+(today.getMonth()+1);
     else
         month = today.getMonth()+1;
     if(today.getDate()<10)
         date = "0"+today.getDate();
     else
         date = today.getDate();
     mydate = today.getYear()+"-"+month+"-"+date;
     return mydate;
  }
  
  function closeXctbDiv(){
 	 setClearxctb();
 	 $("#xctb_detail").hideAndRemove("show");
  }
  
function allXctbPageUp(){
	$("body").append('<div id="jquery-overlayXctb" class="jquery-overlay"><div style="position:absolute;">保存中，请稍候......<div></div>');
	$("#jquery-overlayXctb").css({
		"text-align":"center",
		"z-index":			100000,
		backgroundColor: 	"#FFFFFF",
		opacity:			0.3, 
		width:				pageWidth,
		height:				pageHeight
	}).fadeIn().find("div").css({
		left:				$(this).width()/2,
		top:				pageHeight/2
	});	
}
     
</script>

<input type="hidden" id="a_sxhylbmc" >
<input type="hidden" id="a_sxhylbdm" >
<input type="hidden" id="a_jsdwbm" ><!--接受单位编码-->
<input type="hidden" id="a_fbdwbm" ><!--发布单位编码-->

<input type="hidden" id="a_fjbase64" ><!--附件的base64码-->
<input type="hidden" id="a_fjname" ><!--附件的名称-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">通知通告添加</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='closeXctbDiv();'class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="3"></td>
  </tr>
</table>

<table width="100%" cellpadding="2" cellspacing="0" id="add">
  <tr>
    <td colspan="6" valign="top">
    	<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
      		<tr>
       		 <td class="queryfont">行业类别</td>
      		</tr>
     		<tr>
       			<td class="tdbg" align="left" valign="top">
       				<table width="100%" border="0" cellspacing="0" cellpadding="2">
            			<tr>
              				<td id="tdhylb"></td>            
            			</tr>
        			</table>
  				 </td>
  			</tr>
  		</table>
  	</td>
  </tr>
  <tr height="20"></tr>
  <tr>
    <td width="9%" class="red">接收单位</td>
    <td class="detailtd" colspan="5"><input type="text" class="inputstyle1" id="a_jsdwmc" value="" style="width:624" readonly /></td>
  </tr>
  <tr>
    <td width="10%" class="red">发布人</td>
    <td width="22%" class="detailtd"><input type="text" readonly="readonly" class="readonly" id="a_fbr" value="" /></td>
    <td width="11%" class="red">发布时间</td>
    <td width="22%" class="detailtd"><input type="text" readonly="readonly" class="readonly" id="a_fbsj" value="" /></td>
    <td width="11%" class="red">截至时间</td>
    <td width="24%" class="detailtd"><input type="text" class="inputstyle" id="a_jzrq" value="" /></td>
  </tr>
  <tr >
    <td class="red">发布单位</td>
    <td class="detailtd" colspan="5"><input type="text" readonly="readonly" class="readonly" style="width:624" id="a_fbdw" value="" /></td>
  </tr>
  <tr >
    <td class="red">标题</td>
    <td class="detailtd" colspan="5"><input type="text" class="inputstyle1"  style="width:624" id="a_bt" value="" /></td>
  </tr>
  <tr>
    <td class="red" valign="top">通知内容</td>
    <td colspan="5" class="detailtd"><textarea  type="textarea " style="width:624;height:100" id="a_fbnr" value="" /></textarea></td>
  </tr>
  <tr >
    <td align="left">&nbsp;</td>
    <td align="left">&nbsp;</td>
    <td align="left">&nbsp;</td>
    <td align="left">&nbsp;</td>
    <td align="left">&nbsp;</td>
    <td align="left">
    	<table width="93%" border="0" cellspacing="0" cellpadding="4">
      		<tr>
     			<td width="70%">&nbsp;</td>
        		<td><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="添加附件" onclick='openfile();'>添加附件</a></td>
       			<td><a href="#" id="addbutton2" hidefocus="true" class="submitbutton" title="保存" onclick='setAddxctb();'>保存</a></td>
     		</tr>
   		</table>
    </td>
  </tr>
  <tr align="center"><td colspan="6" height="3"></td></tr>
</table>

<table class="tableborder">
<tr>
<td><div id="fjshowdiv">
    <table  id="fjnameshowtable" style="width:50%;">
      <thead>
	    <tr>
	     	<th name="show_fjmc">文件名</th>
	     	<th name="show_cz">操作</th>
	    </tr>
	  </thead>
    </table>
</div></td>
</tr>
</table>

<div id="xctb_select" class="page-layout" src="#"
		style="top: 0px; overflowY: scroll;">
</div>

<!-- test  -->
<div id="XctbfjListData" style="width:100%;">
	<table id="lXctbfj" width="100%" style="display:none;" >
	  <thead>
	    <tr>
	     	<th name="l_fjmc">文件</th>
	     	<th name="l_fjbase">base</th> 	
	    </tr>
	  </thead>
	  <tbody id="fjcontect">
	  </tbody>
	</table>	
</div>
<div style="height:20"></div>
<%@include file="../../public/includeImgerToBase64.jsp" %>