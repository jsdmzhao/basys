<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var wldj_fk_tables = "";
	var wldj_fk_dataid = "";
	var wldj_fk_pageUrl="icksystem/querylistBaoKa_wldj.action";
	var wldj_fk_divnid="wldj_fk_tabledata";
	var wldj_fk_tableid="wldj_fk_table1";
	var wldj_fk_addUrl="icksystem/insert_wldj.action";
	var wldj_js_addHtml="basic/icksystem/WldjAdd.jsp";
	var wldj_fk_addWidth="500";
	var wldj_fk_delUrl="icksystem/delete_wldj.action";
	var wldj_fk_delid="d_wlid";
	var wldj_fk_modHtml="basic/icksystem/WldjModify.jsp";
	var wldj_fk_modUrl="icksystem/modify_wldj.action";
	var wldj_fk_modWidth="500";
	var wldj_fk_detailHtml="basic/icksystem/WldjDetail.jsp";
	var wldj_fk_detailid="wldj_fk_detail";
	var wldj_fk_detailUrl="icksystem/query_wldj.action";
	var wldj_fk_detailWidth="300";
	$(document).ready(function() {
	    bc_bottonMoveRight(1,'反馈');
		$("#q_wlid").attr("value",dataid);
		if(chakanFlag=='1'){ //查看
			document.getElementById("tijiao").style.display='none';
			document.getElementById("m_fkxx").style.display='none';
			document.getElementById("m_wlxx").style.display='none';
			document.getElementById("wlck_title").style.display='block';
		} else { //反馈
			document.getElementById("fk_fkxx").style.display='none';
			document.getElementById("fk_wlxx").style.display='none';
			document.getElementById("wlfk_title").style.display='block';
		}
		wldj_fk_loadPage(wldj_fk_divnid);
		setDetail();
	}); 
	function wldj_fk_setPageList(pageno,url){	
		wldj_fk_url=wldj_fk_setList(pageno,url);
		var topPosition = 0;
		if(chakanFlag=='1'){ //查看
			topPosition = $("#wldj_detail").position().top+200;
		} else {
			topPosition = $("#wldj_detail").position().top+205;
		}
		var mygrid1 = $("#"+wldj_fk_tableid).ingrid({ 
										ingridPageWidth:900,
										ingridPageParams:sXML,
										barTopPosition:topPosition,
										sorting: false,
										url: wldj_fk_url,	
										height: 250,
										pageNumber: pageno,
										onRowSelect: function(tr, selected){
										},
										colWidths: ["20%","10%","20%","10%","24%","12%"]									
									});				
	}
	function wldj_fk_loadPage(divpageid){
		wldj_fk_tables=$("#"+divpageid).html();
		$("#"+wldj_fk_detailid).hide(); 	
		wldj_fk_setPageList(1,'#');
	}
	function wldj_fk_setList(pageno,url){	
		$("#"+wldj_fk_divnid).html(wldj_fk_tables);	
		createXML("q_");
		if (url==null || url=="undefined"){
			url=wldj_fk_pageUrl;
		}
		return url;
	}
	function updatediv (json) { 
		$("#m_wlid").attr("value",setNull(json.LWldj[0].wlid));
		$("#fk_wlpc").append(setNull(json.LWldj[0].wlpc));
		$("#fk_djr").append(setNull(json.LWldj[0].djr));
		$("#fk_zbsj").append(setNull(json.LWldj[0].zbsj));
		$("#fk_mbsldmc").append(setNull(json.LWldj[0].mbsldmc));
		$("#fk_fsr").append(setNull(json.LWldj[0].fsr));
		$("#fk_fssj").append(setNull(json.LWldj[0].fssj));
		$("#fk_jsr").append(setNull(json.LWldj[0].jsr));
		$("#fk_jssj").append(setNull(json.LWldj[0].jssj));
		$("#fk_bz").append(setNull(json.LWldj[0].bz));
		$("#fk_wlgs").append(setNull(json.LWldj[0].wlgs));
		$("#fk_ydh").append(setNull(json.LWldj[0].ydh));
		
		$("#fk_fkxx").append(setNull(json.LWldj[0].fkxx));
		
		if(json.LWldj[0].fkxx==null||json.LWldj[0].fkxx==''||json.LWldj[0].fkxx=='null'){
			$("#m_fkxx").append(setNull(json.LWldj[0].ztdmmc)+' '+setNull(json.LWldj[0].jsr)+' '+setNull(json.LWldj[0].fssj));
		} else {
			$("#m_fkxx").append(setNull(json.LWldj[0].fkxx));
		}
		$("#m_wlgs").attr("value",setNull(json.LWldj[0].wlgs));
		$("#m_ydh").attr("value",setNull(json.LWldj[0].ydh));
		wldj_fk_setPageList(1);
	}
	function setUpdateFk(){
		if (!checkControlValue("m_fkxx","String",1,2000,null,1,"反馈内容"))
			return false;
		if (!checkControlValue("m_wlgs","String",1,200,null,0,"物流公司"))
			return false;
		if (!checkControlValue("m_ydh","String",1,200,null,0,"运单号"))
			return false;
		setParams("m_");
		jQuery.post('icksystem/modify_wldj.action',params,updateFkback,"json");
	}
	function updateFkback(json){
		if (json.result=="success"){
			jAlert('反馈成功','提示信息');
			$("#wldj_detail").hideAndRemove("show"); 
			setPageList(1);
		}else{
			jAlert(json.result,'错误信息');
		}
	}	
</script>

</head>
<body>
<input type="hidden" id="q_wlid">
<input type="hidden" id="m_wlid">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1" id="wlfk_title" style="display:none">物流反馈</td>
      <td align="left" class="title1" id="wlck_title" style="display:none">物流查看</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#wldj_detail").hideAndRemove("show");'class="close"></a></td>
    </tr>
</table>	
<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="4"></td>
		</tr>
	</table>
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
				<tr id="fk_wlxx">
					<td class="distd1">物流公司</td>
					<td class="detailtd2"><span id="fk_wlgs" ></span></td>
					<td class="distd1">运单号</td>
					<td class="detailtd2"><span id="fk_ydh" ></span></td>
					<td class="distd1">&nbsp;</td>
					<td class="detailtd2">&nbsp;</td>
				</tr>
				<tr id="m_wlxx">
					<td class="distd1">物流公司</td>
					<td class="detailtd2"><input type="text" class="inputstyle" id="m_wlgs"/></td>
					<td class="distd1">运单号</td>
					<td class="detailtd2"><input type="text" class="inputstyle" id="m_ydh"/></td>
					<td class="distd1">&nbsp;</td>
					<td class="detailtd2">&nbsp;</td>
				</tr>
				<tr>
					<td class="distd1">备注</td>
					<td class="detailtd2" colspan="5" width="790px"><span id="fk_bz"></span></td>
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
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">反馈信息</td>
  </tr>
  <tr>
    <td class="tdbg">
    <table width="100%" border="0" cellspacing="0" cellpadding="2" class="detail">
      	<tr>
        <td width="10%" class="distd1">接收人</td>
        <td width="480" class="detailtd2"><span id="fk_jsr" ></span></td>
                <td class="distd1">接收时间</td>
        <td width="480" class="detailtd2"><span id="fk_jssj" ></span></td>
        </tr>
      	<tr>
        <td width="10%" class="distd1">反馈内容</td>
        <td colspan="3" valign="top" class="detailtd2">
        	<textarea name="textarea" id="m_fkxx" cols="59" rows="2"></textarea>
            <span id="fk_fkxx"></span>		</td>
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
<div id="wldj_fk_detail"  class="page-layout" src="#"
		style="top:180px;">
</div>	

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td align="left" valign="top">
<div id="wldj_fk_tabledata" style="width:100%;">
	<table id="wldj_fk_table1" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_kh">IC卡卡号</th>
	     	<th name="l_xm">姓名</th>
	     	<th name="l_zjhm">证件号码</th>
	     	<th name="l_csrq">出生日期</th>
	     	<th name="l_hjdxzqh">户籍省县</th>
	     	<th name="l_cyryzt">状态</th>
	    </tr>
	  </thead>
	</table>	
</div>
	</td></tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" id="tijiao">
	<tr>
          <td colspan="5" class="detailtd"><table width="100%" border="0" cellspacing="0" cellpadding="2">
              <tr height="25" align="center">
                <td width="100%">
                <a href="#" hidefocus="true" class="submitbutton" title="反馈" onclick='setUpdateFk();'>反馈</a>
                </td>
              </tr>
          </table></td>
        </tr>
</table>
</body>
</html>