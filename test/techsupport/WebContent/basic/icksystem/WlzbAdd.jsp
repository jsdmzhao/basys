<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	var isFirstComeIn = 0;
	var wlzbadd_tables = "";
	var wlzbadd_divnid="wlzb_tabledata";
	var wlzbadd_tableid="wlzb_table";
	var wlzbadd_detailid = "wldj_ick_detail";
	var wlzbadd_pageUrl = "#";
	
	var cardInfoVal = new Array();
	var cardInfoArr = new Array();
	cardInfoArr[0]='cyrybh';
	cardInfoArr[1]='xingming'; 
	cardInfoArr[2]='zjhm';
	cardInfoArr[3]='rjrq'; //有效起始日期
	cardInfoArr[4]='zatlq'; //有效截至日期
	cardInfoArr[5]='ickkh'; //有效截至日期
	
	$(document).ready(function() {
	bc_bottonMoveRight(1);
		$("#ickknxx").empty();
		$("#ickknxx").load("public/skOne.jsp");
		$("#ickknxx").show("slow");
		wlzbadd_loadPage(wlzbadd_divnid);
	});
	function wlzbadd_setPageList(pageno,url){
		url = wlzbadd_setList(pageno,url);
		var mygrid1 = $("#"+wlzbadd_tableid).ingrid({
											url: url,
											ingridPageParams:sXML,
											ingridPageWidth: addWidth,
											height: 260, //下面是假的 不走后台 添加所以 高度为0
											sorting: false,
											paging: false,
											gridClass:'tablestyle',
											ingridHtmlFlag:true,
											colWidths: ["22%","10%","22%","20%","20%","6%"]
										});
	}
	function wlzbadd_loadPage(divpageid){
		wlzbadd_tables=$("#"+divpageid).html();
		$("#"+wlzbadd_detailid).hide();
		wlzbadd_setPageList(1,'#');
	}
	function wlzbadd_setList(pageno,url){
		$("#"+wlzbadd_divnid).html(wlzbadd_tables);	
		if (url==null || url=="undefined"){
			url='#';
		}
		return url;
	}
	function firstValidater(){ //第一进来的验证
		setParams("f_"); //需要卡号
		jQuery.post('icksystem/validaterFirstShua_wldj.action',params,backFirstValidater,"json");
	}
	function backFirstValidater(json){ //第一进来的验证 - 回调
		if(json.result=="success"){
			if(json.LWldj[0]!=null){
				isFirstComeIn = 1;
				$("#s_cjdbm").attr("value",json.LWldj[0].cjdbm); //将IC卡受理bean中的采集点编码 放到隐藏域里
				successAndInsrt();
			}else{
				jAlert("此卡物流已组包,请检查!","提示信息");
			}
		}else{
			jAlert(json.result,'错误');
			wlzbAddClose();
		}
	}
	function notFirstValidater(){ //非第一进来的验证
		setParams("s_"); //需要卡号 和 采集点编码
		jQuery.post('icksystem/validaterNoFirstShua_wldj.action',params,backNotFirstValidater,"json");
	}
	function backNotFirstValidater(json){ //非第一进来的验证 - 回调
		if(json.result=="success"){
			if(json.LWldj[0]=='1'){
				successAndInsrt();
			}else{
				jAlert("此卡采集点冲突,请检查!","提示信息");
			}
		}else{
			jAlert(json.result,'错误');
			wlzbAddClose();
		}
	}
	//刷卡掉此方法
	function setXmlAddData(xml){
		//获取卡内信息开始
		for(var index=0,max=cardInfoArr.length;index<max;index++){
			var temp0 = '<'+cardInfoArr[index]+'>';
			var temp1 = '</'+cardInfoArr[index]+'>';
			var h0 = temp0.length;
			var h1 = xml.indexOf(temp0);
			var h2 = xml.indexOf(temp1);
			cardInfoVal[index] = xml.substr((h1+h0),(h2-h1-h0));
		}
		//取得ick芯片号和kh
	    var ick_ickh=document.getElementById('ctlICCard').cardno;
	    var ick_kh=cardInfoVal[5];
		//获取卡内信息结束
	    if (ick_kh==null||ick_kh=="null"||ick_kh==""){
	    $("#x_ickh").attr("value",ick_ickh);
		$("#x_zkztbs").attr("value","5");
		setParams("x_");
		jQuery.post('icksystem/queryKhcyrybm_icksl.action',params,ickhback,"json");
	    } else {
		shuaka();
		}
	}
	function ickhback(json){
		if(json.result=='success'){
		cardInfoVal[5]=setNull(json.LIcksl[0].kh);
		cardInfoVal[0]=setNull(json.LIcksl[0].cyrybh);
		} else {
		jAlert(json.result,'提示信息');
		}
		shuaka();
	}
	function shuaka(){
		if(isFirstComeIn==0){ //第一次进来
			$("#f_kh").attr("value",cardInfoVal[5]);
			firstValidater();
		}else{
			$("#s_kh").attr("value",cardInfoVal[5]);
			notFirstValidater();
		}
	}
	function successAndInsrt(){ //验证成功 并向Table添加一条信息
		var trValue = "";
		trValue += "<tr id='"+cardInfoVal[0]+"'>";
		trValue += "<td><div>"+cardInfoVal[0]+"</div></td>";
		trValue += "<td><div>"+cardInfoVal[1]+"</div></td>";
		trValue += "<td><div>"+cardInfoVal[2]+"</div></td>";
		trValue += "<td><div>"+cardInfoVal[3].replace('年','-').replace('月','-').replace('日','')+"</div></td>";
		trValue += "<td><div>"+cardInfoVal[4].replace('年','-').replace('月','-').replace('日','')+"</div></td>";
		trValue += "<td><div><a href='#' class='fontbutton' title='删除' onclick=deltempSkjl('"+cardInfoVal[0]+"');>删除</a></td>";
		trValue += "</tr>";
		
		if(!isContents(cardInfoVal[0])){
			$("#grid").append(trValue);
			addtotempSkjl(cardInfoVal[0],cardInfoVal[5]); //value : ic卡卡号
			var bnksl = $("#bnksl").html();
			$("#bnksl").html(parseInt(bnksl)+1);
		} else {
			jAlert('此卡已经刷过','提示信息');
		}
	}
	function addtotempSkjl(key,value){ //添加刷卡记录
		var objOption = "<option value='"+key+"' title='"+key+"'>"+value+"</option>";
		$("#tempskjl").append($(objOption));
		
	}
	function deltempSkjl(key){ //清除刷卡记录
		jConfirm('确定删除吗？', '删除提示', function(r) {
	    	if(r==true){
				var rowlength = 0;
				$("#tempskjl option").each(function(){
					rowlength++;
					if($(this).attr("value")==key){
						$(this).remove();
						$("#grid").find("tr[@id="+key+"]").remove();
					}
				});
				var bnksl = $("#bnksl").html();
				bnksl = parseInt(bnksl)-1;
			    $("#bnksl").html(bnksl+'');
				if(rowlength==1){ //共有一条记录 删除后没有记录 在刷卡为第一次
					isFirstComeIn = 0;
				}
			}else{
			   return false;
			}
		});
	}
	function isContents(key){ //是否包含传来的值
		var isResult = false;
		$("#tempskjl option").each(function(){
			if($(this).attr("value")==key)
				isResult = true;
		});
		return isResult;
	}
	
	function wlzb_addVerify(){
		$("#a_cyrybhSet").attr("value","");
		$("#a_khSet").attr("value","");
		$("#tempskjl option").each(function(){
			var kh = $(this).text(); //卡号
			var cyrybh = $(this).attr("value"); //从业人员编号
			
			var khSet = $("#a_khSet").attr("value");
			khSet += ",'"+kh+"'";
			$("#a_khSet").attr("value",khSet);
			
			var cyrybhSet = $("#a_cyrybhSet").attr("value");
			cyrybhSet += ",'"+cyrybh+"'";
			$("#a_cyrybhSet").attr("value",cyrybhSet);
		});
		if($("#a_cyrybhSet").attr("value")==""){
			jAlert("请刷卡","提示信息");
			return false;
		}
		return true;
	}
	function wlzbAddClose(){
	    document.getElementById('ctlICCard').CloseWrite();
		$("#ctlICCard").remove();
		$("#wldj_detail").hideAndRemove("show");
		$("#wldj_detail").empty();
	}
</script>
<input type="hidden" id="a_cyrybhSet" value="">
<input type="hidden" id="a_khSet" value="">
<input type="hidden" id="x_ickh" value="">
<input type="hidden" id="x_zkztbs" value="">
<input type="hidden" id="f_kh" value="">
<input type="hidden" id="s_kh" value="">
<input type="hidden" id="s_cjdbm" value="">
<select id="tempskjl" style="DISPLAY:none"></select>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">物流包新增</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='wlzbAddClose();'class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="4"></td></tr>
</table>
<table width="100%" cellpadding="0" cellspacing="0" id="detail">
<tr>
<td>
    <table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
		<tr>
        	<td class="queryfont">从业人员信息</td>
		</tr>
		<tr>
			<td class="tdbg">
				<div id="ickknxx"></div>
			</td>
		</tr>
    </table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
	<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
		<tr>
			<td class="queryfont">刷卡人员列表</td>
		</tr>
		<tr>
			<td valign="top" >      
			<div id="wldj_ick_detail"  class="page-layout" src="#"
		style=" width:500px;"> </div>
			
			<div id="wlzb_tabledata" style="width:100%;">
	          <table id="wlzb_table" width="100%">
	            <thead>
	              <tr>
	                <th>从业人员编号</th>
	                <th>姓名</th>
	                <th>证件号码</th>
	                <th>有效起始日期</th>
	                <th>有效截止日期</th>
	                <th>操作</th>
	              </tr>
	            </thead>
	          </table>
			</div>
			</td>
		</tr>
	</table>
</td>
</tr>
<tr height="25" align="center">
<td>
<table width="100%">
<tr>
<td align="left">包内卡数量：<span id="bnksl">0</span></td>
<td>
<a href="#" id="addbutton" class="submitbutton" onclick='setWlzbAdd();' title="保存">保存</a>
</td>
</tr>
</table>
</td>
</tr>
</table>
