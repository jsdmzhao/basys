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
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">报警信息查询本地布控人员详细信息</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$(&quot;#ylcsjbxx_detail&quot;).hideAndRemove(&quot;show&quot;);'class="close"></a></td>
    </tr>
</table>
    <table width="100%" border="0">
    <tr><td colspan="6" class="queryfont">本地布控人员信息</td></tr>
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
      <tr>
      </tr>
      <tr>
        <td class="detailtd2">口音</td>
        <td class="detailtd1"><span id="ky"/></span></td>
        <td class="detailtd2">身高</td>
        <td class="detailtd1"><span id="shengao" value="0" /></td>
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
  </tr>
  <tr>
    <td  class="detailtd2">简要案情</td>
    <td colspan="5"class="detailtd1">
      <textarea name="textarea" id="jyaq" style="width:670px;"/></span></textarea>    </td>
  </tr>
  <tr>
    <td class="detailtd2">布控人</td>
    <td class="detailtd1"><span id="bkr"/></span></td>
    <td class="detailtd2">布控范围</td>
    <td class="detailtd1"><span id="bkfw"/></span></td>      
    <td class="detailtd2">联系方式</td>
    <td class="detailtd1"><span id="lxfs"/></span></td>  
  </tr>
    <tr><td colspan="6" height="8" class="queryfont">接处警基本情况</td></tr>
  <tr align="center"><td colspan="6" height="8"><table width="100%" id="detail2">
    <tr>
      <td width="8%" class="detailtd2">是否确认报警</td>
      <td width="18%" class="detailtd1"><span id=" "/></span></td>
      <td width="11%" class="detailtd2">值班员</td>
      <td width="18%" class="detailtd1"><span id=" "/></span></td>
      <td width="7%" class="detailtd2">是否出警</td>
      <td width="17%" class="detailtd1"><span id=" "/></span></td>
      <td width="21%" rowspan="2" class="detailtd1">&nbsp;</td>
    </tr>
    <tr>
      <td class="detailtd2">出警时间</td>
      <td class="detailtd1"><span id=" "/></span></td>
      <td class="detailtd2">处警部门代码</td>
      <td class="detailtd1"><span id=" "/></span></td>
      <td class="detailtd2">处警部门</td>
      <td class="detailtd1"><span id=" "/></span></td>
    </tr>
    
    <tr>
      <td class="detailtd2">是否撤销</td>
      <td class="detailtd1"><span id=""/></span></td>
      <td class="detailtd2">撤销时间</td>
      <td class="detailtd1"><span id="" value="0" /></span></td>
      <td class="detailtd2">反馈单位</td>
      <td class="detailtd1"><span id=""/></span></td>
    </tr>
    <tr>
      <td class="detailtd2">反馈日期</td>
      <td class="detailtd1"><span id=""/></span></td>
      <td class="detailtd2">是否有效报警</td>
      <td class="detailtd1"><span id=""/></span></td>
      <td class="detailtd2">是否抓获</td>
      <td class="detailtd1"><span id=""/></span></td>
    </tr>
        <tr>
      <td class="detailtd2">反馈情况</td>
      <td colspan="3" class="detailtd1"><span id=""/></span></td>
      <td class="detailtd2">是否漏网</td>
      <td class="detailtd1"><span id=""/></span></td>
    </tr>
        <tr>
      <td class="detailtd2">登记单位</td>
      <td class="detailtd1"><span id=""/></span></td>
      <td class="detailtd2">登记人员</td>
      <td class="detailtd1"><span id=""/></span></td>
      <td class="detailtd2">登记时间</td>
      <td class="detailtd1"><span id=""/></span></td>
    </tr>
  </table></td></tr>
      <tr>
        <td colspan="6" class="queryfont">国内旅客入住信息</td>
      </tr>
  <tr align="center">
    <td colspan="6"><a href="#" id="addbutton" hidefocus="true" class="submitbutton" title="打印" onclick='setAdd();'>打印</a></td>
  </tr>
</table>
</td>
  </tr>
</table>