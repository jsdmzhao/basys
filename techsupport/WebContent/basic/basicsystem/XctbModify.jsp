<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
    //var parentDivM = $("#m_tbid").parent();
    
     var fjnum = 0;  ///附件的个数 
     var hylbdm = "";  ///行业类别代码  
     
	$(document).ready(function() {
	$("#q_tbid").attr("value",dataid);
	$("#m_tbid").attr("value",dataid);
	setDetail();
	$("#m_fbsj").attr("readonly","true");
	$("#m_fbsj").datepicker();
	$("#m_jzrq").attr("readonly","true");
	$("#m_jzrq").datepicker();

	$("#xctb-fj").empty();
	$("#xctb-fj").load("basic/basicsystem/Xctb_fjManM.jsp");
	$("#xctb-fj").show("slow");
	
	var updatinitUrl = "basicsystem/initxctbupdate_xctb.action";
	setParams("q_");
	jQuery.post(updatinitUrl,params,initxctbupdate,"json");
	
	///初始化附件ingrid
	var addtables=$("#fjshowdiv").html();
	$("#fjshowdiv").html(addtables);
	setPageList_xctbadd(1);	
	
	}); 
	
	function setPageList_xctbadd(pageno,url){	
			url="#";
			var mygrid1 = $("#fjnameshowtable").ingrid({ 
											url: url,
											barTopOffset:-(xctb_detailidTopOffset+1),
										    barLeftOffset:-(xctb_detailidLeftOffset+1),
											tableid : "fjnameshow",
										    ingridHtmlFlag:true,
										    gridClass:'tablestyle',
											height: 70,
											pageNumber: pageno,
											onRowSelect: function(tr, selected){
										   },
										    ingridPageWidth:691,
										    ingridPageParams: sXML,
										    
										    paging: false,
											sorting: false,
										    colWidths: ["70%","30%"]									
										});				
	}
	
	
	function updatediv (json) { 
	    $("#jsdwmc").attr("value",setNull(json.LXctb[0].jsdwmc));
		$("#m_bt").attr("value",setNull(json.LXctb[0].bt));
		$("#m_fbsj").attr("value",setNull(json.LXctb[0].fbsj));
		$("#m_fbnr").attr("value",setNull(json.LXctb[0].fbnr));
		$("#m_fbr").attr("value",setNull(json.LXctb[0].fbr));
		$("#m_fbdw").attr("value",setNull(json.LXctb[0].fbdw));
		$("#m_jzrq").attr("value",setNull(json.LXctb[0].jzrq));
		//$("#m_gqbs").attr("value",setNull(json.LXctb[0].gqbs));
		
	}	
	function modifyVerify(){
		if (!checkControlValue("m_bt","String",1,100,null,1,"标题"))
			return false;
		if (!checkControlValue("m_fbsj","Date",null,null,null,1,"发布时间"))
			return false;
		if (!checkControlValue("m_jzrq","Date",null,null,null,1,"截至时间"))
			return false;
		if (!checkControlValue("m_fbnr","String",1,2000,null,1,"通知内容"))
			return false;
		if (!checkControlValue("m_fbr","String",1,100,null,1,"发布人"))
			return false;
		if (!checkControlValue("m_fbdw","String",1,200,null,1,"发布单位"))
			return false;
		if (!checkDateEarlier("m_fbsj","发布时间","m_jzrq","截至时间","DATE")){
			return false;
		}
		return true;
	}
	///初始化的回调函数
	function initxctbupdate(json){
	  document.getElementById("tdhylb").innerHTML = json.xctb.sxhylbmc;
	  
	  ///////行业类别代码
	  hylbdm = json.xctb.sxhylbdm;
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
		//显示BASE64编码
		var fileName = pathfileName; ///得到文件名字
		////cuicui update 
		if(fileName!=null&&fileName!=""){
		  ajaxAddDivCeng();
		  var base64code = ImgerToBase1.getBase64();
		  params={fileNamecon:fileName,base64codecon:base64code};
		  jQuery.post("basicsystem/uptempfile_xctb.action",params,uploadfileback,"json");
		}
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
	  newTd1.innerHTML = "<a href='#' onclick='delfj1();' style='cursor:hand;' class='fontbutton' >删除</a>"; 
		
	 /////new 把附件名字 和转换后的base64码 放入隐藏域
	 var newRow="<TR><TD><DIV>"+json.fileNamecon+"</DIV></TD><TD><DIV>"+json.fileTempNamecon+"</DIV></TD></TR>";
	 var queryNewRow = $(newRow);
	 $("#fjcontect").append(queryNewRow);
	
	 fjnum = fjnum+1;  ////附件个数加1
	 
	}
	
	function openfile(){
	    if(hylbdm.indexOf("A")>=0||hylbdm.indexOf("Z")>=0){
	     ///如果协查通报中的行业类别包括旅馆业 控制附件的个数不能大于1
	     if(fjnum>0){
	       jAlert("协查通报的附件个数不能大于1",'提示信息');
	       return false;
	     }
	    }
		ImgerToBase1.OpenFile();
		ImgerToBase();
	}
	
	function setUpdatexctb(){
	if (modifyVerify()){
	    var child=new Array("XctbfjListData");
		setParams("m_",child);
		jQuery.post(modUrl,params,updateback,"json"); 
	}else{
		return modifyVerify();
	}
		
   } 

	
	///////在添加页面删除附件
    function delfj1(){
	 //获得行索引
	 //两个parentElement分别是TD和TR哟，rowIndex是TR的属性
	 //this.parentElement.parentElement.rowIndex
	 ////得到tr的rowIndex属性
	 var cGetRow=window.event.srcElement.parentElement.parentElement.rowIndex;
	 var obj = document.getElementById("fjnameshow");
	 ////显示部分删除附件名称
	 obj.deleteRow(cGetRow);
	 
	 var fileTempName = $("#fjcontect").find("tr").eq(cGetRow-1).find("td:nth(1)").text(); /////上传的临时文件名字
	 ////隐藏域删除附件信息
	 $("#fjcontect").find("tr").eq(cGetRow-1).remove();
	 params={fileTempNamecon:fileTempName};
	 jQuery.post("basicsystem/deleteFile_xctb.action",params,delback,"json");  ////删除上传的文件
	 
	  fjnum = fjnum-1;  ////附件个数减1
	 
    }
    function delback(){}
</script>
<input type="hidden" id="q_tbid">
<input type="hidden" id="m_tbid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">通知通告修改</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#xctb_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="3"></td>
  </tr>
</table>
<!--  <div  class="scrollbarface"  style="overflow-y:auto;height:450"> -->
<table width="100%" cellpadding="2" cellspacing="0" id="modify" >
	<tr>
		<td colspan="6" valign="top">
			<table width="100%" cellpadding="0" cellspacing="0"
				class="tableborder">
				<tr>
					<td class="queryfont">
						行业类别
					</td>
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
	<tr>
		<td colspan="6" valign="top">
			<table width="100%" border="0" cellpadding="2" cellspacing="0"class="tableborder">
				<tr>
					<td width="9%" class="distd" nowrap valign="top">
						接收单位
					</td>
					<td class="detailtd" colspan="5">
						<textarea id="jsdwmc" name="tzcs" readonly="readonly" theme="simple"
							class="readonly"
							style="font-size: 12px; WIDTH: 625; BORDER: #A3B4CD 1px solid; height: 50px;">
     					</textarea>
					</td>
				</tr>
				<tr>
					<td width="10%" class="red" nowrap>
						发布人
					</td>
					<td width="22%" class="detailtd">
						<input type="text" readonly="readonly" class="readonly" id="m_fbr" />
					</td>
					<td width="11%" class="red">
						发布时间
					</td>
					<td width="22%" class="detailtd">
						<input type="text" readonly="readonly" id="m_fbsj" value="" />
					</td>
					<td width="11%" class="red">
						发布单位
					</td>
					<td width="24%" class="detailtd">
						<input type="text" readonly="readonly" class="readonly"
							id="m_fbdw" value="" />
					</td>
				</tr>
				<tr>
					<td class="red">
						截至时间
					</td>
					<td class="detailtd">
						<input type="text" readonly="readonly" id="m_jzrq" value="" />
					</td>
					<td class="red"></td>
					<td class="detailtd"></td>
					<td class="distd"></td>
					<td class="detailtd"></td>
				</tr>
				<tr>
					<td class="red">
						标题
					</td>
					<td class="detailtd" colspan="5">
						<input type="text" class="inputstyle3" style="width: 624px"
							id="m_bt" value="" />
					</td>
				</tr>
				<tr>
					<td class="red" valign="top">
						通知内容
					</td>
					<td colspan="5" class="detailtd">
						<textarea type="textarea "
							style="font-size: 12px; WIDTH: 625; BORDER: #A3B4CD 1px solid; height: 80px;"
							id="m_fbnr" value="" /> </textarea>
					</td>
				</tr>
				<tr>
					<td class="distd"></td>
					<td colspan="5" width="">
						<table width="97%">
							<tr>
								<td width="96%">
									&nbsp;
								</td>
								<td>
									<a href="#" id="addbutton" hidefocus="true"
										class="submitbutton" title="添加附件" onclick='openfile();'>添加附件</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="6">
						<div id="fjshowdiv" style="width: 100%;">
							<table align="left" id="fjnameshowtable" style="width: 100%;">
								<thead>
									<tr>
										<th width="48%" name="show_fjmc">
											文件名
										</th>
										<th width="52%" name="show_cz">
											操作
										</th>
									</tr>
								</thead>
							</table>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="6">
						<div id="xctb-fj" style="width: 98%;"></div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr align="right">
		<td colspan="6" height="3"></td>
	</tr>
	<tr>
		<td colspan="6">
			<table width="97%">
				<tr>
					<td width="96%">
						&nbsp;
					</td>
					<td>
						<a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdatexctb();'>保存</a>
					</td>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!--  </div> -->

<!-- test  -->
<div id="XctbfjListData" style="width:100%;">
	<table id="lXctbfj" width="100%" style="display:none;" >
	  <thead>
	    <tr>
	     	<th name="l_fjmc">文件</th>
	     	<th name="l_fjbase">文件</th> 	
	    </tr>
	  </thead>
	  <tbody id="fjcontect">
	  </tbody>
	</table>	
</div>
<div style="height:10"></div>
<%@include file="../../public/includeImgerToBase64.jsp" %>

