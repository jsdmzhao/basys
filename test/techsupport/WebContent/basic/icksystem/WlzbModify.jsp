<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	var wlzbadd_tables = "";
	var wlzbadd_divnid="wlzb_tabledata";
	var wlzbadd_tableid="wlzb_table";
	var wlzbadd_detailid = "wldj_ick_detail";
	var wlzbadd_pageUrl = "#";
	
	var cardInfoVal = new Array();
	var cardInfoArr = new Array();
	cardInfoArr[0]='cyrybh';
	cardInfoArr[1]='xingming';
	cardInfoArr[2]='xb';
	cardInfoArr[3]='gj';
	cardInfoArr[4]='zjhm';
	cardInfoArr[5]='csrq';
	cardInfoArr[6]='hjdxz';
	cardInfoArr[7]='ickkh';
	
	$(document).ready(function() {
	    bc_bottonMoveRight(1);
		$("#q_wlid").attr("value",dataid);
		$("#m_wlid").attr("value",dataid);
		wlzbadd_loadPage(wlzbadd_divnid);
		wlzbadd_setPageList(1);
		setDetail();
		daggleDiv("wldj_ick_detail");
	});
	function wlzbadd_setPageList(pageno,url){
		url = wlzbadd_setList(pageno,url);
		var mygrid1 = $("#"+wlzbadd_tableid).ingrid({
											url: url,
											ingridPageWidth: addWidth,
											height: 260, //下面是假的 不走后台 添加所以 高度为0
											sorting: false,
											paging: false,
											gridClass:'tablestyle',
											ingridHtmlFlag:true,
											colWidths: ["18%","8%","8%","12%","16%","8%","22%","8%"]
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
	function updatediv (json) {
		$("#fk_wlpc").append(setNull(json.LWldj[0].wlpc));
		$("#fk_djr").append(setNull(json.LWldj[0].djr));
		$("#fk_zbsj").append(setNull(json.LWldj[0].zbsj));
		$("#fk_mbsldmc").append(setNull(json.LWldj[0].mbsldmc));
		$("#fk_fsr").append(setNull(json.LWldj[0].fsr));
		$("#fk_fssj").append(setNull(json.LWldj[0].fssj));
		$("#m_bz").append(setNull(json.LWldj[0].bz));
		
		$("#s_cjdbm").attr("value",setNull(json.LWldj[0].mbsldbh));
		$("#bnksl").html(setNull(json.LWldj[0].bnksl));
		setParams("q_");
		jQuery.post('icksystem/querylistUpwlzb_wldj.action',params,backQuerylistUpwlzb,"json");
	}
	function backQuerylistUpwlzb(json){
		if(json.LWldj!=null&&json.LWldj.length>0){
			for(var indexRow=0,maxRow=json.LWldj.length;indexRow<maxRow;indexRow++){
				var trValue = "";
				trValue += "<tr id='"+json.LWldj[indexRow].cyrybh+"'>";
				trValue += "<td><div>"+wlzb_setNull(json.LWldj[indexRow].cyrybh)+"</div></td>";
				trValue += "<td><div>"+wlzb_setNull(json.LWldj[indexRow].xm)+"</div></td>";
				trValue += "<td><div>"+wlzb_setNull(json.LWldj[indexRow].xb)+"</div></td>";
				trValue += "<td><div>"+wlzb_setNull(json.LWldj[indexRow].gj)+"</div></td>";
				trValue += "<td><div>"+wlzb_setNull(json.LWldj[indexRow].zjhm)+"</div></td>";
				trValue += "<td><div>"+wlzb_setNull(json.LWldj[indexRow].csrq)+"</div></td>";
				trValue += "<td><div>"+wlzb_setNull(json.LWldj[indexRow].hjdxz)+"</div></td>";
				trValue += "<td><div><a href='#' class='fontbutton' onclick=deltempSkjl('"+wlzb_setNull(json.LWldj[indexRow].cyrybh)+"');>删除</a></td>";
				trValue += "</tr>";
				$("#grid").append(trValue);
				addtotempSkjl(json.LWldj[indexRow].cyrybh,json.LWldj[indexRow].kh);
			}
		}
	}
	function notFirstValidater(){ //验证 - 原来分第一次和非第一次 现在就用这个验证
		setParams("s_"); //需要卡号 和 采集点编码
		jQuery.post('icksystem/validaterNoFirstShua_wldj.action',params,backNotFirstValidater,"json");
	}
	function backNotFirstValidater(json){ //非第一进来的验证 - 回调
		if(json.result=="success"){
			if(json.LWldj[0]=='1'){
				successAndInsrt();
			}else{
				jAlert("此卡无法添加,请检查!","提示信息");
			}
		}else{
			jAlert(json.result,'错误');
			wlzbAddClose();
		}
	}
	function successAndInsrt(){ //验证成功 并向Table添加一条信息
		var trValue = "";
		trValue += "<tr id='"+wlzb_setNull(cardInfoVal[0])+"'>";
		trValue += "<td><div>"+wlzb_setNull(cardInfoVal[0])+"</div></td>";
		trValue += "<td><div>"+wlzb_setNull(cardInfoVal[1])+"</div></td>";
		trValue += "<td><div>"+wlzb_setNull(cardInfoVal[2])+"</div></td>";
		trValue += "<td><div>"+wlzb_setNull(cardInfoVal[3])+"</div></td>";
		trValue += "<td><div>"+wlzb_setNull(cardInfoVal[4])+"</div></td>";
		trValue += "<td><div>"+wlzb_setNull(cardInfoVal[5]).replace('年','-').replace('月','-').replace('日','')+"</div></td>";
		trValue += "<td><div>"+wlzb_setNull(cardInfoVal[6])+"</div></td>";
		trValue += "<td><div><a href='#' class='fontbutton' title='删除' onclick=deltempSkjl('"+wlzb_setNull(cardInfoVal[0])+"');>删除</a></td>";
		trValue += "</tr>";
		if(!isContents(cardInfoVal[0])){
			$("#grid").append(trValue);
			addtotempSkjl(cardInfoVal[0],cardInfoVal[7]); //value : ic卡卡号
			var bnksl = $("#bnksl").html();
			$("#bnksl").html(parseInt(bnksl)+1);
		} else {
			jAlert('此卡已经刷过','提示信息');
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
		//获取卡内信息结束
		//取得ick芯片号和kh
	    var ick_ickh=document.getElementById('ctlICCard').cardno;
	    var ick_kh=cardInfoVal[7];
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
		cardInfoVal[7]=setNull(json.LIcksl[0].kh);
		cardInfoVal[0]=setNull(json.LIcksl[0].cyrybh);
		} else {
		jAlert(json.result,'提示信息');
		}
		shuaka();
	}
	function shuaka(){
		$("#s_kh").attr("value",cardInfoVal[7]);
		var isResult = true;
		$("#delskjl option").each(function(){
			if($(this).attr("value")==cardInfoVal[0]){
			    $(this).remove();
			    successAndInsrt();
				isResult = false;
			}
		});
		if(isResult){
		    notFirstValidater();
		}
	}
	function addtotempSkjl(key,value){ //添加刷卡记录
		var objOption = "<option value='"+key+"' title='"+key+"'>"+value+"</option>";
		$("#tempskjl").append($(objOption));
	}
	function deltempSkjl(key){ //清除刷卡记录
		jConfirm('确定删除吗？', '删除提示', function(r) {
	    	if(r==true){
	    		$("#tempskjl option").each(function(){
					if($(this).attr("value")==key){
						$(this).remove();
						var objDelOption = "<option value='"+key+"' title='"+key+"'>"+key+"</option>";
		                $("#delskjl").append($(objDelOption));
						$("#grid").find("tr[@id="+key+"]").html();
						$("#grid").find("tr[@id="+key+"]").remove();
					}
				});
				var bnksl = $("#bnksl").html();
				bnksl = parseInt(bnksl)-1;
			    $("#bnksl").html(bnksl+'');
			}else{
			   return false;
			}
		});
	}
	function isContents(key){ //是否包含传来的值
		var isResult = false;
		$("#tempskjl option").each(function(){
			if($(this).attr("value")==key){
				isResult = true;
			}
		});
		return isResult;
	}
	
	function wlzb_modifyVerify(){
		$("#m_cyrybhSet").attr("value","");
		$("#m_khSet").attr("value","");
		$("#tempskjl option").each(function(){
			var kh = $(this).text(); //卡号
			var cyrybh = $(this).attr("value"); //从业人员编号
			
			var khSet = $("#m_khSet").attr("value");
			khSet += ",'"+kh+"'";
			$("#m_khSet").attr("value",khSet);
			
			var cyrybhSet = $("#m_cyrybhSet").attr("value");
			cyrybhSet += ",'"+cyrybh+"'";
			$("#m_cyrybhSet").attr("value",cyrybhSet);
		});
		if($("#m_cyrybhSet").attr("value")==""){
			jAlert("请刷卡","提示信息");
			return false;
		}
		return true;
	}
	function modAddIckMes(){ //修改-添加IC卡信息
		$("#wldj_ick_detail").css("width","550px").css("left","200px");   
		setUrl('wldj_ick_detail','basic/icksystem/WlzbModify-addIck.jsp');
	}
	function wlzbModefyClose(){
	    if(document.getElementById('ctlICCard')!=null){
	        document.getElementById('ctlICCard').CloseWrite();
		    $("#ctlICCard").remove();
	    }
		$("#wldj_detail").hideAndRemove("show");
		$("#wldj_detail").empty();
	}
</script>
<input type="hidden" id="q_wlid">
<input type="hidden" id="m_wlid">

<input type="hidden" id="m_cyrybhSet" value="">
<input type="hidden" id="m_khSet" value="">
<input type="hidden" id="x_ickh" value="">
<input type="hidden" id="x_zkztbs" value="">
<input type="hidden" id="s_cjdbm" value="">
<input type="hidden" id="s_kh" value="">

<select id="tempskjl" style="DISPLAY:none"></select>
<select id="delskjl" style="DISPLAY:none"></select>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">物流修改</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='wlzbModefyClose();'class="close"></a></td>
    </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="4"></td></tr>
</table>
<table width="100%" cellpadding="0" cellspacing="0" id="detail">
<tr>
<td>
    <table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
	  <tr>
	    <td class="queryfont">物流包信息</td>
	  </tr>
	  <tr>
	    <td class="tdbg">
	    	<table width="100%" border="0" cellspacing="0" cellpadding="2" class="detail">
					<tr>
						<td width="10%" class="distd1">物流批次</td>
						<td width="23%" class="detailtd2"><span id="fk_wlpc" ></span></td>
						<td width="10%" class="distd1">组包人</td>
						<td width="23%" class="detailtd2"><span id="fk_djr" ></span></td>
						<td width="10%" class="distd1">组包时间</td>
					  	<td width="23%" class="detailtd2"><span id="fk_zbsj" ></span></td>
					</tr>
					<tr>
						<td class="distd1">目标采集点名称</td>
						<td class="detailtd2"><span id="fk_mbsldmc" ></span></td>
						<td class="distd1">发送人</td>
						<td class="detailtd2"><span id="fk_fsr" ></span></td>
						<td class="distd1">发送时间</td>
						<td class="detailtd2"><span id="fk_fssj" ></span></td>
					</tr>
					<tr>
						<td class="distd1">备注</td>
						<td class="detailtd2" colspan="5" width="790px">
						<textarea name="textarea" id="m_bz" cols="90" rows="2"></textarea>
						</td>
					</tr>
	    	</table>
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
		style="top:50px;"> </div>
			
			<div id="wlzb_tabledata" style="width:100%;">
	          <table id="wlzb_table" width="100%">
	            <thead>
	              <tr>
	                <th>从业人员编号</th>
	                <th>姓名</th>
	                <th>性别</th>
	                <th>国籍</th>
	                <th>证件号码</th>
	                <th>出生日期</th>
	                <th>户籍地址</th>
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
<td colspan="4">
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
		    <td align="left">包内卡数量：<span id="bnksl">0</span></td>
			<td><a href="#" id="addbutton" class="addbutton"  onclick='modAddIckMes();'>添加</a>
			<a href="#" id="addbutton" class="submitbutton" onclick='setWlzbUpdate();' title="修改保存">保存</a></td>
		</tr>
	</table>
</td>
</tr>
</table>
