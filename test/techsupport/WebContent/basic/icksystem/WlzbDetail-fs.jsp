<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var wldj_fk_tables = "";
	var wldj_fk_dataid = "";
	var wldj_fk_pageUrl="icksystem/querylistUpwlzb_wldj.action";
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
	    bc_bottonMoveRight(1,'发送');
		$("#q_wlid").attr("value",dataid);
		wldj_fk_loadPage(wldj_fk_divnid);
		setDetail();
	}); 
	function wldj_fk_setPageList(pageno,url){	
		wldj_fk_url=wldj_fk_setList(pageno,url);
		var mygrid1 = $("#"+wldj_fk_tableid).ingrid({ 
										url: wldj_fk_url,
										ingridPageWidth: addWidth,
										ingridPageParams:sXML,
										barTopPosition:$("#wldj_detail").position().top+200,
										height: 250,
										pageNumber: pageno,
										onRowSelect: function(tr, selected){
										},
										sorting: false,
										paging: false,
										colWidths: ["16%","14%","9%","6%","10%","12%","9%","12%","12%"]
									});
	}
	function wldj_fk_loadPage(divpageid){
		wldj_fk_tables=$("#"+divpageid).html();
		$("#"+wldj_fk_detailid).hide(); 	
		wldj_fk_setPageList(1,'#');
	}
	function wldj_fk_setList(pageno,url){
		$("#"+wldj_fk_divnid).html(wldj_fk_tables);	
		setParams("q_");
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
		$("#fk_fkxx").append(setNull(json.LWldj[0].fkxx));
		$("#m_wlgs").append(setNull(json.LWldj[0].wlgs));
		$("#m_ydh").append(setNull(json.LWldj[0].ydh));
		wldj_fk_setPageList(1);
	}
	function wlzbDetailClose(){
		$("#wldj_detail").hideAndRemove("show");
		$("#wldj_detail").empty();
	}
	function setUpdateFs(){
		if (!checkControlValue("m_wlgs","String",1,200,null,1,"物流公司"))
			return false;
		if (!checkControlValue("m_ydh","String",1,200,null,1,"运单号"))
			return false;
		setParams("m_");
		jQuery.post('icksystem/wlzbSend_wldj.action',params,updateFsback,"json");
	}
	function updateFsback(json){
		if (json.result=="success"){
			jAlert('发送物流包成功!','提示信息');
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
      <td align="left" class="title1">物流包发送信息</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='wlzbDetailClose();'class="close"></a></td>
    </tr>
</table>	
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td height="5"></td></tr>
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
				<tr>
					<td class="red">物流公司</td>
					<td class="detailtd2"><input type="text" class="inputstyle" id="m_wlgs"/></td>
					<td class="red">运单号</td>
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
        <td width="23%" class="detailtd2"><span id="fk_jsr" ></span></td>
        <td width="10%" class="distd1">反馈内容</td>
        <td width="480px" class="detailtd2" valign="top" rowspan="2">
            <span id="fk_fkxx"></span>
		</td>
        </tr>
      	<tr>
        <td class="distd1">接收时间</td>
        <td class="detailtd2"><span id="fk_jssj" ></span></td>
        <td class="distd1">&nbsp;</td>
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
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td align="left" valign="top">
<div id="wldj_fk_tabledata" style="width:100%;">
	<table id="wldj_fk_table1" width="100%">
	  <thead>
	    <tr>
	        <th>IC卡卡号</th>
	     	<th>从业人员编号</th>
	        <th>姓名</th>
	        <th>性别</th>
	        <th>国籍</th>
	        <th>证件号码</th>
	        <th>出生日期</th>
	        <th>户籍地址</th>
	        <th>状态</th>
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
                <a href="#" hidefocus="true" class="submitbutton" title="发送" onclick='setUpdateFs();'>发送</a>
                </td>
              </tr>
          </table></td>
        </tr>
</table>
</body>
</html>