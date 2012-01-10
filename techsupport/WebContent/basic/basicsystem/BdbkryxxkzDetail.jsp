<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#q_bkryid").attr("value",dataid);
			setDetail();
	}); 
	function updatediv (json) { 
		$("#bkryid").append(setNull(json.LBkry[0].bkryid));
		$("#tbbh").append(setNull(json.LBkry[0].tbbh));
		$("#xm").append(setNull(json.LBkry[0].xm));
		$("#bm").append(setNull(json.LBkry[0].jg));
		$("#xb").append(setNull(json.LBkry[0].xb));
		$("#qtzjhm").append(setNull(json.LBkry[0].minzu));
		$("#ky").append(setNull(json.LBkry[0].ky));
		$("#shengao").append(setNull(json.LBkry[0].shengao));
		$("#tz").append(setNull(json.LBkry[0].tz));
		$("#tt").append(setNull(json.LBkry[0].tt));
		$("#yz").append(setNull(json.LBkry[0].yz));
		$("#fwdw").append(setNull(json.LBkry[0].fwdw));
		$("#ajlb").append(setNull(json.LBkry[0].ajlb));
		$("#tbsj").append(setNull(json.LBkry[0].tbsj));
		$("#jyaq").append(setNull(json.LBkry[0].jyaq));
		$("#bkr").append(setNull(json.LBkry[0].bkr));
		$("#bkczsj").append(setNull(json.LBkry[0].bkczsj));
		$("#bkfw").append(setNull(json.LBkry[0].bkfw));
		$("#lxfs").append(setNull(json.LBkry[0].lxfs));
	}	
</script>
<input type="hidden" id="q_bkryid">
<table width="100%" border="0">
  <tr>
    <td colspan="6" class="queryfont">本地布控人员信息</td>
  </tr>
  <tr>
    <td colspan="6" valign="top"><table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
      <tr>
        <td width="8%" class="detailtd2">姓名</td>
        <td width="21%" class="detailtd1"><span id="xm"/></span></td>
        <td width="12%" class="detailtd2">身份证号码</td>
        <td width="36%" class="detailtd1"><span id="gmsfhm"/></span></td>
        <td class="detailtd2">别名</td>
        <td class="detailtd1"><span id="bm"/></span></td>
        <td width="23%" rowspan="8" class="detailtd1"><table width="60%" border="0" align="center" cellpadding="2" cellspacing="0">
          <tr>
            <td align="center"><img src="../../images/pto.gif" width="118" height="149" /></td>
          </tr>
          <tr>
            <td><table width="124" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="50%" ><a href="#" class="submitbutton" id="querys" onclick="setPageList(1);">获取照片</a></td>
                <td width="50%" ><a href="#" class="submitbutton" onclick='setAddPage()'>清除</a></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td class="detailtd2">出生日期</td>
        <td class="detailtd1"><span id="csrq"/></span></td>
        <td class="detailtd2">性别</td>
        <td class="detailtd1"><span id="xb"/></span></td>
        <td class="detailtd2">其他证件</td>
        <td class="detailtd1"><span id="qtzjhm"/></span></td>
      </tr>
      <tr> </tr>
      <tr>
        <td class="detailtd2">口音</td>
        <td class="detailtd1"><span id="ky"/></span></td>
        <td class="detailtd2">身高</td>
        <td class="detailtd1"><span id="shengao" value="0" /></span></td>
        <td class="detailtd2">体征</td>
        <td class="detailtd1"><span id="tz"/></span></td>
      </tr>
      <tr>
        <td class="detailtd2">体态</td>
        <td class="detailtd1"><span id="tt"/></span></td>
        <td class="detailtd2">衣着</td>
        <td class="detailtd1"><span id="yz"/></span></td>
        <td class="detailtd2">通报编号</td>
        <td class="detailtd1"><span id="tbbh"/></span></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td class="detailtd2">发文单位</td>
    <td class="detailtd1" ><span readonly="readonly" class="readonly" id="fwdw"/></span></td>
    <td width="12%" class="detailtd2">通报时间</td>
    <td width="26%" class="detailtd1"><span id="tbsj"/></span></td>
    <td width="8%" class="detailtd2">案件类别</td>
    <td width="21%" class="detailtd1"><span id="ajlb"/></span></td>
  </tr>
  <tr>
    <td  class="detailtd2">简要案情</td>
    <td colspan="5"class="detailtd1"><textarea name="textarea" id="jyaq" style="width:670px;"/></textarea>
        </span>
      </textarea>
    </td>
  </tr>
  <tr>
    <td class="detailtd2">布控人</td>
    <td class="detailtd1"><span id="bkr"/></span></td>
    <td class="detailtd2">布控范围</td>
    <td class="detailtd1"><span id="bkfw"/></span></td>
    <td class="detailtd2">联系方式</td>
    <td class="detailtd1"><span id="lxfs"/></span></td>
  </tr>
</table>
