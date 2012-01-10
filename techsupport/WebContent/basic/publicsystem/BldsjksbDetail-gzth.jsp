<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		//$("#q_bldsjksbid").attr("value",bldsjksb_dataid);
		//bldsjksb_setDetail();
	}); 
	function bldsjksb_updatediv (json) { 
		var sourceVal;
		$("#bldsjksb_sbmc").append(setNull(json.find("td:nth(0)").html()));
		$("#bldsjksb_sccsmc").append(setNull(json.find("td:nth(1)").html()));
		$("#bldsjksb_ggxh").append(setNull(json.find("td:nth(2)").html()));
		
		sourceVal = setNull(json.find("td:nth(3)").html());
		sourceVal = sourceVal.replace(/(&nbsp;)/g,'');
	    $("#bldsjksb_sbjcjgmc").append(sourceVal);
	    
		sourceVal = setNull(json.find("td:nth(4)").html());
		sourceVal = sourceVal.replace(/(&nbsp;)/g,'');
		$("#bldsjksb_wlcslxmc").append(sourceVal);
		
		$("#bldsjksb_azsxtsl").append(setNull(json.find("td:nth(5)").html()));
		$("#bldsjksb_sflx").append(setNull(json.find("td:nth(6)").html()));
		
		sourceVal = setNull(json.find("td:nth(7)").html());
		sourceVal = sourceVal.replace(/(&nbsp;)/g,'');
		$("#bldsjksb_ipdz").append(sourceVal);
		
		$("#bldsjksb_lrr").append(setNull(json.find("td:nth(8)").html()));
		$("#bldsjksb_lrsj").append(setNull(json.find("td:nth(9)").html()));
		
		var sourceVal = setNull(json.find("td:nth(10)").html());
		sourceVal = sourceVal.replace(/(&nbsp;)/g,'');
		$("#bldsjksb_bz").append(sourceVal);
	}	
	
	
	
	function bldspjksb_updatediv (json) { 
		var sourceVal;
		$("#bldsjksb_sbmc").append(setNull(json.find("td:nth(2)").html()));
		$("#bldsjksb_sccsmc").append(setNull(json.find("td:nth(3)").html()));
		$("#bldsjksb_ggxh").append(setNull(json.find("td:nth(4)").html()));
		$("#bldsjksb_azsxtsl").append(setNull(json.find("td:nth(5)").html()));
		$("#bldsjksb_sflx").append(setNull(json.find("td:nth(6)").html()));
		$("#bldsjksb_ipdz").append(setNull(json.find("td:nth(7)").html()));
	    $("#bldsjksb_sbjcjgmc").append(setNull(json.find("td:nth(8)").html()));
	    $("#bldsjksb_wlcslxmc").append(setNull(json.find("td:nth(9)").html()));
	    $("#bldsjksb_lrr").append(setNull(json.find("td:nth(10)").html()));
		$("#bldsjksb_lrsj").append(setNull(json.find("td:nth(11)").html()));
		$("#bldsjksb_bz").append(setNull(json.find("td:nth(12)").html()));
	}	
</script>
<input type="hidden" id="q_bldsjksbid">
<span id="closeFlag"></span>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">视频监控设备信息明细</td>
      <td align="right" class="title1">
      <a href="#" id="closeDiv" onclick='$("#closeFlag").parent().hideAndRemove("show");' class="close"></a>
      </td>
    </tr>
</table>

<table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
	<tr>
      <td class="distd1">设备名称</td>
	  <td class="detailtd2"><span id="bldsjksb_sbmc"></span></td>
		<td class="distd1">设备生产厂商</td>
	  <td class="detailtd2" colspan="3" style="width:392px"><span id="bldsjksb_sccsmc"></span></td>
	</tr>
	<tr>
		<td class="distd1">规格型号</td>
      <td class="detailtd2"><span id="bldsjksb_ggxh"></span></td>
      <td class="distd1">设备检测机构名称</td>
		<td class="detailtd2"><span id="bldsjksb_sbjcjgmc"></span></td>
		<td class="distd">网络传输类型</td>
      <td class="detailtd2">
      	<span id="bldsjksb_wlcslxmc"></span>
      </td>
  </tr>
	<tr>
		<td class="distd1" width="10%">是否录像</td>
      <td class="detailtd2" width="21%"><span id="bldsjksb_sflx"></span></td>
		<td class="distd1" width="15%">摄像头安装数量</td>
      <td class="detailtd2" width="20%"><span id="bldsjksb_azsxtsl"></span></td>
	    <td class="distd1" width="13%">IP地址</td>
	    <td class="detailtd2" width="20%"><span id="bldsjksb_ipdz"></span></td>
  </tr>
	<tr height="20">
		<td class="distd1">填报人</td>
		<td class="detailtd2"><span id="bldsjksb_lrr"/></td>
		<td class="distd1">填报时间</td>
		<td class="detailtd2" colspan="3"><span id="bldsjksb_lrsj"></span></td>
	</tr>	
	<tr>
		<td class="distd1" valign="top">备注</td>
      <td class="detailtd2" colspan="5" style="width:630px"><span id="bldsjksb_bz"></span></td>
  </tr>
</table>