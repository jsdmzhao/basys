<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		
		pageUrl="publicsystem/querylist_qyjcxx.action";
		divnid="QyjcxxData";
		tableid="QyjcxxTable";
		addUrl="publicsystem/insert_qyjcxx.action";
		addHtml="basic/publicsystem/QyjcxxAdd.jsp";
		addWidth="600";
		delUrl="publicsystem/delete_qyjcxx.action";
		delid="d_qycfid";
		modHtml="basic/publicsystem/QyjcxxModify.jsp";
		modUrl="publicsystem/modify_qyjcxx.action";
		modWidth="600";
		detailHtml="basic/publicsystem/QyjcxxDetail.jsp";
		detailid="qyjcxx_detail";
		detailUrl="publicsystem/query_qyjcxx.action";
		detailWidth="600";
		
		$("#p_hylbdm").selectBoxhylb({code:"flgy"});//行业类别	
		$("#p_cflbbm").selectBox({code:"dm_jclb"});
		$("#p_jcmxlbdm").selectBox({code:"1"});//明细 处罚
		
		$("#p_qyjcrq").attr("readonly","true");
		$("#p_qyjcrq").datepicker();
		$("#p_qyjcrqzhi").attr("readonly","true");
		$("#p_qyjcrqzhi").datepicker();
		$("#p_pzrq").attr("readonly","true");
		$("#p_pzrq").datepicker();
		$("#p_zxrq").attr("readonly","true");
		$("#p_zxrq").datepicker();
		
		
		daggleDiv(detailid);
		loadPage(divnid);
		$("#p_cflbbm").change(function(){
			if($("#p_cflbbm").val()==0){
				$("#p_jcmxlbdm").selectBox({code:"dm_qyjllb"});//明细 奖励
			}
			if($("#p_cflbbm").val()==1){
				$("#p_jcmxlbdm").selectBox({code:"dm_qycflb(jxy)"});//明细 处罚
			}
			if($("#p_cflbbm").val()==''){
				$("#p_jcmxlbdm").selectBox({code:"1"});//明细 处罚
			}
		});
		$("#p_pzjg").click(function(){ //管辖单位
			getGxdw("p_pzjg","p_pzjgdm");
		});
		
		hylbOnchangeMan();
		
		
	}); 
	
	function setPageList(pageno,url){	
		url=setList(pageno,url);
		var mygrid1 = $("#"+tableid).ingrid({  
										loadAsync: false,		
										ingridPageWidth: pageWidth,
										url: url,	
										height: pageHeight-253,
										pageNumber: pageno,
										ingridPageParams: sXML,
										colWidths: ["20%","20%","10%","10%","10%","10%","10%","10%"]									
									});
		setTableText();
	}
	 //企业筛选框
	$("#p_qymc").click(function(){
		dataid=$('#p_hylbdm').val();
		getTy_item("p_qymc","","p_qyid");
	});
	function hylbOnchangeMan(){
		var hylb=$("#p_hylbdm").val();
		var csorqymc = "企业名称";
		var jcdjxh = "奖惩登记序号";
		var xzjcpwh = "行政奖惩批准文号";
		var jclb = "奖惩类别";
		var jcmclb = "奖惩明细类别";
		var jcfd = "奖惩幅度";
		var qyjcrq = "企业奖惩日期";
		var yjly = "依据理由";
		if(hylb=='J'||hylb=='K'){
			csorqymc = "场所名称";
			jcdjxh = "处罚/奖励登记序号";
			xzjcpwh = "处罚/奖励行政批准文号";
			jclb = "处罚/奖励类别";
			jcmclb = "处罚/奖励明细类别";
			jcfd = "处罚/奖励结果";
			qyjcrq = "处罚/奖励日期";
			yjly = "处罚/奖励依据";
		}
		$('#td_qymc').text(csorqymc);
		$('#jcdjxh-1').text(jcdjxh);
		$('#xzjcpwh-1').text(xzjcpwh);
		$('#jclb-1').text(jclb);
		$('#jcmclb-1').text(jcmclb);
		$('#qyjcrq-1').text(qyjcrq);
		setTableText();
	}
	function setTableText(){
		var hylb=$("#p_hylbdm").val();
		var csorqymc = "企业名称";
		if(hylb=='J'||hylb=='K'){
			csorqymc = "场所名称";
		}
		$('#QyjcxxData').find('thead').find('th[@name=l_qymc]').find('DIV').html(csorqymc);
	}
</script>

<body>
	
	<input type="hidden" id="d_qycfid">
		<input type="hidden" id="p_qyid">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">企业奖惩查询</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2" id='tempTable' >
				<tr>
					<td width="15%" class="pagedistd">行业类别</td>
					<td width="18%" class="pagetd"><select id="p_hylbdm" onchange="hylbOnchangeMan();"/></td>
					<td width="15%" class="pagedistd" id="td_qymc">企业名称</td>
					<td width="19%" class="pagetd"><input type="text" class="inputstyle" id="p_qymc" readonly="readonly"></td>
					<td width="15%" class="pagedistd">批准机构</td>
					<td width="18%" class="pagetd"><input type="hidden"class="inputstyle" id="p_pzjgdm">
					<input type="text"class="inputstyle" id="p_pzjg"></td>
				</tr>
				<tr>
					<td class="pagedistd" id="jclb-1">奖惩类别</td>
					<td class="pagetd"><select id="p_cflbbm"><option></option></select></td>
					<td class="pagedistd" id="jcdjxh-1">处罚登记序号</td>
					<td class="pagetd"><input type="text"class="inputstyle" id="p_cfdjxh"></td>
    				<td class="pagedistd" id="xzjcpwh-1">行政处罚批准文号</td>
					<td class="pagetd"><input type="text"class="inputstyle" id="p_xzcfpzwh"></td>
				</tr>
    			<tr>
					<td class="pagedistd" id="jcmclb-1">奖惩明细类别</td>
					<td class="pagetd"><select id="p_jcmxlbdm"><option></option></select></td>
					<td class="pagedistd" id="qyjcrq-1">企业奖惩日期</td>
					<td class="pagetd"><input type="text"class="inputstyle3" id="p_qyjcrq" style="width:80px">至
					<input type="text"class="inputstyle3" id="p_qyjcrqzhi" style="width:80px"></td>
					<td colspan="2">
	    				<table  border="0" align="right"  cellpadding="1"  cellspacing="0">
	    		    	<tr>
	    		    	  <td width="62"><a href="#" class="searchbutton" id="querys" onclick="setPageList(1);">查询</a></td>
	    		    	  <td width="62"><a href="#" class="addbutton" onclick='setAddPage()'>添加</a></td>
	    		    	</tr>
	    		  		</table>
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
<div id="qyjcxx_detail" class="page-layout" src="#"
		style="top:80px; left:160px;">
</div>	

<div id="QyjcxxData" style="width:100%;">
	<table id="QyjcxxTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_cfdjxh">奖惩登记序号</th>
	     	<th name="l_cflb">奖惩类别</th>
	     	<th name="l_jcmxlb">奖惩明细类别</th>
	     	<th name="l_pzjg">批准机构</th>
	     	<th name="l_qyjcrq">奖惩日期</th>
	     	<th name="l_bjcr">被奖惩人</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
