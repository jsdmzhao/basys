<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bkryid").attr("value",dataid);
			setDetail();
	}); 
	function updatediv (json) {                             
		$("#gmsfhm").append(setNull(json.LBkry[0].bkryid));
		$("#bm").append(setNull(json.LBkry[0].tbbh));
		$("#xm").append(setNull(json.LBkry[0].xm));
		$("#csrq").append(setNull(json.LBkry[0].jg));
		$("#xb").append(setNull(json.LBkry[0].xb));
		$("#qtzjhm").append(setNull(json.LBkry[0].minzu));
		$("#tbbh").append(setNull(json.LBkry[0].ky));
		$("#hjd").append(setNull(json.LBkry[0].shengao));
		$("#xzdq").append(setNull(json.LBkry[0].tz));
		$("#xzqh").append(setNull(json.LBkry[0].tt));
		$("#djrq").append(setNull(json.LBkry[0].yz));
		$("#hjxxdz").append(setNull(json.LBkry[0].fwdw));
		$("#ladq").append(setNull(json.LBkry[0].ajlb));
		$("#xzdxxdz").append(setNull(json.LBkry[0].tbsj));
		$("#badw").append(setNull(json.LBkry[0].jyaq));
		$("#tbr").append(setNull(json.LBkry[0].bkr));
		$("#lxr").append(setNull(json.LBkry[0].bkczsj));
	}	
</script>
<input type="hidden" id="q_bkryid">
<table width="100%" border="0">
  <tr>
    <td class="queryfont">旅馆入住信息</td>
  </tr>
  <tr>
    <td class="detailtd2">&nbsp;</td>
  </tr>
</table>
