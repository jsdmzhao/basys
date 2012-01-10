<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
		$("#baoCunTitle_blds").val($("#BldsjksbListData").html());
		$("#bldscx_qyid").val(qyjbxx_dataid);
		setParams("bldscx_");
		bldsjksb_setPageList(1,"publicsystem/querylistByQy_bldsjksb.action");
		daggleDiv("bldsjksb_detail");
	}); 
	function bldsjksb_setPageList(pageno,url){
		$("#BldsjksbListData").html($("#baoCunTitle_blds").val());
		if(url==null){
		//	url = "publicsystem/querylistBack_bldsjksb.action";
		  url="publicsystem/querylistinsertBack_bldsjksb.action";
		}
		var mygrid1 = $("#BldsjksbListTable").ingrid({ 
		                                tableid:"bldsjksbTable",
										ingridPageParams:sXML,
										ingridPageWidth: 998,
										url: url,	
										height: 60,
										pageNumber: pageno,
										sorting: false,
										paging: false,
										isPlayResultNull: false,
										onRowSelect:function(tr){
											bldsjksb_setDetailQuery($(tr).attr('rowindex')-1);
										},
										hideColIndex:[8,9,10,11,12],
										colWidths:["13%","22%","12%","18%","9%","10%","6%","10%","0%","0%","0%","0%","0%"]
									});				
	}

	function bldsjksb_setDetailQuery(trIndex){
		sFlag="false";
		setWidthSome("bldsjksb_detail","700");
		$("#bldsjksb_detail").empty().load("basic/publicsystem/BldsjksbDetail-gzth.jsp",function(){
			bldsjksb_updatediv($("#bldsjksbTable").find("tbody").find("tr:nth("+trIndex+")"));
		}).show("slow");
		upAllPage("bldsjksb_detail");
	}
</script>
<input type="hidden" id="bldscx_qyid" />
<table width="998px" cellpadding="0" cellspacing="0"  class="tableborder">
        <tr>
          <td style="color:#004499; font-size:12px; font-weight:bold;">视频监控设备</td>
        </tr>
</table>
<div id="bldsjksb_detail"  class="page-layout" src="#"
		style="top:180px; left:160px; width:500px;display:none">
</div>

<div id="BldsjksbListData" style="width:100%;">
	<table id="BldsjksbListTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_sbmc">设备名称</th>
	     	<th name="l_sccsmc">设备生产厂商名称</th>
	     	<th name="l_ggxh">规格型号</th>
	     	<th name="l_sbjcjgmc">设备检测机构名称</th>
	     	<th name="l_wlcslxmc">网络传输类型</th>
	     	<th name="l_azsxtsl">摄像头安装数量</th>
	     	<th name="l_sflx">是否录像</th>
	     	<th name="l_ipdz">IP地址</th>
	     	<th name="l_lrr">填报人</th>
	     	<th name="l_lrsj">填报时间</th>
	     	<th name="l_bz">备注</th>
	     	<th name="l_wlcslxbm">网络传输类型代码</th>
	     	<th name="l_azsl">安装数量</th>
	    </tr>
	  </thead>
	</table>	
</div>