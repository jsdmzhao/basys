<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<%@include file="../../public/includeImgerToBase64.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath() %>/javascript/stringcommon.js"></script>
<%
Map map=new HashMap();
session.setAttribute("parameters",map);
%>
<script type="text/javascript">

     $.fn.multiupload = function(options) {

        var multiupload = this;

         options = $.extend({
             fileSelector: ".file-upload",
             deleteSelector: ".delete-file"
         }, options || {});

        var fileNameDataKey = "targetFileName";

        var addOperate = function(target) {
            var warp = $("<div></div>");
             multiupload.append(warp);

             warp.append(target);
             target = $(target);

            var deleteButton = $("<a></a>");
             warp.prev().append(deleteButton);
             deleteButton.text("删除");
             deleteButton.attr("href", "javascript:void(0);");
             deleteButton.data(fileNameDataKey, target.attr("name"));
             deleteButton.addClass(options.deleteSelector.substring(1));
         };

        var fileCount = function() {
            return multiupload.find(options.fileSelector).size();
         };

        var emptyFileCount = function() {
            return multiupload.find(options.fileSelector).filter(function() {
                return !$(this).val();
             }).size();
         };

        var templete = multiupload.find(options.fileSelector + ":first");
        // addOperate(templete);
        var div = $("<div></div>");
         div.append(templete);
         multiupload.append(div);
        //alert(multiupload.html());

        var baseName = templete.attr("name");

        var count = 1;

        this.find(options.fileSelector).change(function() {
            var self = $(this);

            if (self.val() && emptyFileCount() === 0) {
                var newFile = self.clone(true);

                 self.parent().append(newFile);
                 newFile.val(null);
                 newFile.attr("name", baseName + ++count);

                 addOperate(newFile);
             }

         });

        this.find(options.deleteSelector).live("click", function() {
            var self = $(this);
             self.parent().remove();
            //             var fileName = self.data(fileNameDataKey);
            //             var file = multiupload.find("input[name=" + fileName + "]");

            //             if (fileCount() === 1) {
            //                 file.val(null);
            //             } else {
            //                 file.parent().remove();
            //             }

         });

     };







// --------------------------------------------------------------------------------
	var glabal=0;
	var arr=new Array(); //新建一个数组，存放路径
	$(document).ready(function() {	
		// $("#fjdiv").multiupload({ fileSelector: ".file-upload" });
		$("#bq_hylb").selectBoxhylb();//行业类别
		hylbOnchange()
	}); 
	
	function hylbOnchange(){
		var key = $("#bq_hylb").attr("value");
		var val = $("#bq_hylb").attr("title");
		$("#a_hylbdm").attr("value",key);
		$("#a_hylb").attr("value",val);

	}	
	function addVerify(){
	/*	if (!checkControlValue("a_qyzlxxid","Integer",-9999999999,9999999999,null,0,"企业质量信息ID"))
			return false;
		if (!checkControlValue("a_hylbdm","String",1,3,null,0,"行业类别代码"))
			return false;
		if (!checkControlValue("a_hylb","String",1,40,null,0,"行业类别"))
			return false;
		if (!checkControlValue("a_fbdwdm","String",1,20,null,0,"发布单位代码"))
			return false;
		if (!checkControlValue("a_fbdwmc","String",1,60,null,0,"发布单位名称"))
			return false;
		if (!checkControlValue("a_fbr","String",1,30,null,0,"发布人"))
			return false;
		if (!checkControlValue("a_fbsj","Date",null,null,null,0,"发布时间"))
			return false;
		if (!checkControlValue("a_scbz","Integer",-99,99,null,0,"删除标志"))
			return false; */
		return true;
	}
function fjadd(){
// $("#selectFJ").click();
// alert($("#selectFJ").val());
}

// 附件上传
 function openHyfj(){
	 	$("#a_fjnr").attr("value","");
	 	$("#a_fjmc").attr("value","");
		ImgerToBase1.SetFileSize= 10240;
        ImgerToBase1.OpenFile();
        ImgerToBase();
    }
    
    function ImgerToBase(){
        var pathfileName = ImgerToBase1.getFile();
       //  alert(pathfileName);
        if (pathfileName != null && pathfileName != "") {
        glabal++;
            afsb_zpFileName = ImgerToBase1.getFileName();
            var strid="fjmc"+glabal;
          //  $("#a_fjnr").val(ImgerToBase1.getBase64());
            $("#a_fjmc").val(afsb_zpFileName);
            var str1=$("#a_fjmc").val();
            var str2="<a href='#' onclick='delfj("+glabal+");' id='"+glabal+"' name='"+afsb_zpFileName+"'> 删除</a>";          
            addfjshow(str1,str2,glabal); 
         	AddValTOArr(pathfileName);
        }
    }
    function addfjshow(str1,str2,strid){
    var str="<tr id='tr"+strid+"'>";
    str+="<td>"+str1+"</td>";
    str+="<td>"+str2+"</td>";
    str+="</tr>";
    $("#fjTab").append(str);
   //   alert( $("#fjTab").html());
    }
    function delfj(id){
    //alert(id);
   
  	// var index=$("#"+id).attr("id");
  // alert(fjm);
   //  $(this).parents("tr").remove();
   $("#tr"+id).remove();
  deleteUploadPath(id);
   return;
  	//$("#fjTab").find($("#"+id).parents("a").parents("td").parents("tr")).remove();
    }
    
    // 向arr中增加值
	function AddValTOArr(fjmc){
		arr.push(fjmc);
	//	arr.push("||");  //后台的分割符
		// alert(arr.toString());
    }
    //从数组中删除路径
    function deleteUploadPath(index){
    arr.splice(index-1,1);
  //  alert(arr.toString());
    }
    
  //重写保存函数
  function setAdd(){
  if(arr.toString()!=null&&arr.toString()!=""){
	if (addVerify()){
		$("#a_fjmc").attr("value",arr.toString()); //把所有上传的路径连接成字符串
		setParams("a_");
		jQuery.post(addUrl,params,addback,"json");
	}
	}
	else{
	alert("没有附件，无法保存");
	}
}	
function addback(){
glabal=0;
arr=new Array();
$("#fjTab").find("tr:gt(0)").remove();
}

//------------------------------------------------由于旧的上传早某些环境下，读不到路径，改新的上传
var fjnum = 0;  ///附件的个数 
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
			//显示BASE64编码
		var base64code = ImgerToBase1.getBase64();
		// alert(fileName);
	     params={fileNamecon:fileName,base64codecon:base64code};
         jQuery.post("publicsystem/uptempfile_qyzlxx.action",params,uploadfileback,"json");
         
		}
		//////////
		
	}
	
	/////上传文件的回调函数
	function uploadfileback(json){
	
	   var obj = document.getElementById("fjnameshowtable");
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
	 	   //alert(fjnum);
	   ImgerToBase1.OpenFile();
	   
	   ImgerToBase();
	} 
		/////重写添加方法
	function setAddxctb(){
		if (addVerify()){
		    var child=new Array("XctbfjListData");
			setParams("a_",child);
			// allXctbPageUp();
			jQuery.post(addUrl,params,addbackxctb,"json");
		}else{
			return addVerify();
		}	
    }	
    function addbackxctb(json){
	 //  $("#jquery-overlayXctb").remove();
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
	 var obj = document.getElementById("fjnameshowtable");
	 ////显示部分删除附件名称
	 obj.deleteRow(cGetRow);
	 
	 //alert($("#fjcontect").find("tr").eq(cGetRow-1).find("td:nth(1)").text());
	 var fileTempName = $("#fjcontect").find("tr").eq(cGetRow-1).find("td:nth(1)").text(); /////上传的临时文件名字
	 ////隐藏域删除附件信息
	 $("#fjcontect").find("tr").eq(cGetRow-1).remove();
	 params={fileTempNamecon:fileTempName};
	 jQuery.post("publicsystem/deleteFile_qyzlxx.action",params,delback,"json");  ////删除上传的文件
	 
	  fjnum = fjnum-1;  ////附件个数减1
	 
    }
    function delback(){}
    
    ///////清空所有的控件
    function delallfj(){
    
      var child=new Array("lXctbfj");
	  setParams("a_",child);
	  jQuery.post("publicsystem/deleteAllFile_qyzlxx.action",params,delback,"json");
	  
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
<input type="hidden" id="a_fjbase64" ><!--附件的base64码-->
<input type="hidden" id="a_fjname" ><!--附件的名称-->
<input type="hidden" id="a_hylb">
<input type="hidden" id="a_hylbdm">
<div style="display:none;">

</div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">新增</td>
      <td align="right"><a href="#" id="closeDiv" onclick='$("#qyzlxx_detail").hideAndRemove("show");' class="close"></a></td>
    </tr>  
</table>
<fieldset style="height:70px;">
<table align="left">
	<td class="pagedistd">行业类别</td>
	<td>
	<select  class="pagetd" id="bq_hylb" value="" onChange="hylbOnchange()">	

	</td>
</table>
</fieldset>

								

<div style="display:none;" id="fjdiv">
<input type="hidden" id="a_fjnr"/>
<input type="text" id="a_fjmc">
</div>
<div align="right">
<a href="#" id="addfj" class="submitbutton" title="添加附件" onclick='openfile();'>添加附件</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setAddxctb();'>保存</a>

</div>
<!-- 
<div id="fjcontailer">
<table align="center" width="80%" id="fjTab">
<tr>
<td>附件名称</td><td>操作</td>
</tr>
</table>
</div>  -->
<!-- 新加入的 -->
<div id="fjshowdiv">
    <table  id="fjnameshowtable" style="width:50%;">
      <thead>
	    <tr>
	     	<th name="show_fjmc">文件名</th>
	     	<th name="show_cz">操作</th>
	    </tr>
	  </thead>
    </table>
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

<!--  
<table width="100%" id="add">

	<tr height="20">
		<td class="distd">企业质量信息ID</td>
		<td class="detailtd"><input type="text" id="a_qyzlxxid" class="inputstyle" value="0"></td>
		<td class="distd">行业类别代码</td>
		<td class="detailtd"><input type="text" id="a_hylbdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">行业类别</td>
		<td class="detailtd"><input type="text" id="a_hylb" class="inputstyle" value=""></td>
		<td class="distd">发布单位代码</td>
		<td class="detailtd"><input type="text" id="a_fbdwdm" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发布单位名称</td>
		<td class="detailtd"><input type="text" id="a_fbdwmc" class="inputstyle" value=""></td>
		<td class="distd">发布人</td>
		<td class="detailtd"><input type="text" id="a_fbr" class="inputstyle" value=""></td>
	</tr>
	<tr height="20">
		<td class="distd">发布时间</td>
		<td class="detailtd"><input type="text" id="a_fbsj" class="inputstyle" value=""></td>
		<td class="distd">删除标志</td>
		<td class="detailtd"><input type="text" id="a_scbz" class="inputstyle" value="0"></td>
	</tr>
<tr height="25" align="center"><td  colspan="4"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setadd();'>保存</a></td></tr>
</table> -->