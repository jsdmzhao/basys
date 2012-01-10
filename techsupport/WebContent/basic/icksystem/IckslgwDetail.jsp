<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%
String slyy = (String)request.getParameter("slyy");//申领原因
 %>
<script type="text/javascript">
var slyy ='<%=slyy%>';
	$(document).ready(function() {
		$("#i_ryid").attr("value",dataid);
		$("#a_ryid").attr("value",dataid);
		$("#a_slyy").selectBox({code:"dm_ickslyy"});
		setDetail_icksl();
		if(slyy != '' && slyy != 'null'){
		    $("#a_slyy").setValue(slyy);
		}
		$("#ryImage").attr("src","publicsystem/queryTp_qyryxx.action?ryId="+dataid);
	}); 
function updatediv (json) { 
	if(json.wgcyryxx!=null){
		$("#w_cyrybh").append(setNull(json.wgcyryxx.cyrybh));
		$("#w_xm").append(setNull(json.wgcyryxx.xm));
		$("#w_xb").append(setNull(json.wgcyryxx.xb));
		$("#w_csrq").append(setNull(json.wgcyryxx.csrq));
		$("#w_hyzk").append(setNull(json.wgcyryxx.hyzk));
		$("#w_zzzhm").append(setNull(json.wgcyryxx.zzzhm));
		$("#w_zzdz").append(setNull(json.wgcyryxx.zzdz));
		$("#w_shouji").append(setNull(json.wgcyryxx.shouji));
		$("#w_qtlxdh").append(setNull(json.wgcyryxx.qtlxdh));
		//$("#w_zhiwu").append(setNull(json.wgcyryxx.zhiwu));
		$("#w_rzrq").append(setNull(json.wgcyryxx.rzrq));
		$("#w_zxr").append(setNull(json.wgcyryxx.zxr));
		$("#w_zxsj").append(setNull(json.wgcyryxx.zxsj));
		$("#w_lrsj").append(setNull(json.wgcyryxx.lrsj));
		$("#w_lrr").append(setNull(json.wgcyryxx.lrr));
		$("#w_qymc").append(setNull(json.wgcyryxx.qymc));
		$("#w_zxyy").append(setNull(json.wgcyryxx.zxyy));
		$("#w_zt").append(setNull(json.wgcyryxx.zt));
		$("#w_scbz").append(setNull(json.wgcyryxx.scbz));
		$("#w_ywx").append(setNull(json.wgcyryxx.ywx));
		$("#w_ywm").append(setNull(json.wgcyryxx.ywm));
		$("#w_gj").append(setNull(json.wgcyryxx.gj));
		$("#w_wgrjyxkz").append(setNull(json.wgcyryxx.wgrjyxkz));
		//$("#w_qzzldm").append(setNull(json.wgcyryxx.qzzldm));
		//$("#w_qzhm").append(setNull(json.wgcyryxx.qzhm));
		$("#w_cyzj").append(setNull(json.wgcyryxx.cyzj));
		$("#w_zjhm").append(setNull(json.wgcyryxx.zjhm));
		$("#w_cjdbm").append(setNull(json.wgcyryxx.cjdbm));
		$("#w_cjdmc").append(setNull(json.wgcyryxx.cjdmc));
		$("#w_cylb").append(setNull(json.wgcyryxx.cylb));
		$("#w_shengao").append(setNull(json.wgcyryxx.shengao));
		$("#w_tizh").append(setNull(json.wgcyryxx.tizh));
		}else{
			jAlert("该境外从业人员不存在","提示信息");
		}
		$("#a_lqsj").val(setNull(json.LIcksl[0].lqsj).substring(0,10));
		$("#a_yxqhzrq").val(setNull(json.LIcksl[0].yxqhzrq).substring(0,10));
		$("#a_slr").val(setNull(json.LIcksl[0].slr));
		$("#a_slr").val(setNull(json.LIcksl[0].slr));
		$("#a_cjdbm").val(setNull(json.LIcksl[0].cjdbm));
		$("#a_cjdmc").val(setNull(json.LIcksl[0].cjdmc));
	}	
	
	function addVerify(){
		var slyyValue = $("#a_slyy").val();
		if (slyyValue==null || slyyValue==""){
			jAlert("申请原因不能为空值！",'验证信息');
			return false;
		}
		
		return true;
	}

var shifouDayin = false;
function addAndPrint(){
	shifouDayin = true;
	if (addVerify()){
		setParams("a_");
		jQuery.post("icksystem/insert_icksl.action",params,addslback,"json");
		$("#"+detailid).hideAndRemove("slow"); 
	}else{
		return addVerify();
	}	
	
}
	
function addAll(){
	shifouDayin = false;
	if (addVerify()){
		setParams("a_");
		jQuery.post("icksystem/insert_icksl.action",params,addslback,"json");
	}else{
		return addVerify();
	}	
}

function addslback(json){
	if  (json.result=="success"){
		jAlert("受理成功",'提示信息');
		setPageList($("#pageNo").attr("value"));
		closeIcksl();
		if(shifouDayin)
			window.open("basic/icksystem/ickslQueryPrint.jsp",json.icksl.ickslid,"width=800,height=600");
	}else{
		jAlert(json.result,'错误信息');
	}		
}

function setDetail_icksl(){
	setParams("i_");
	jQuery.post(detailUrl,params,updatediv,"json");
}

function closeIcksl(){
	$("#icksl_detail").empty();
	$("#icksl_detail").hideAndRemove("show");
}
</script>
<input type="hidden" id="i_ryid">
<input type="hidden" id="i_cyrylbdm" value="1">
<input type="hidden" id="a_ryid">
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">境外从业人员IC卡受理</td>
      <td><a href="#" id="closeDiv" onclick='closeIcksl();'class="close"></a></td>
    </tr>
     <tr>
      <td align="left"></td>
      <td></td>
    </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table></div> 
  <table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
    <tr>
      <td class="queryfont">IC卡受理</td>
    </tr>
    <tr>
      <td class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="2">
          <tr>
            <td width="10%" class="red">申请原因</td>
            <td width="23%" class="pagetd"><select name="select" id="a_slyy"><option></option></select></td>
            <td width="10%" class="pagedistd">预计领卡时间</td>
            <td width="23%" class="pagetd"><input type="text"   id="a_lqsj" readonly class="readonly" /></td>
            <td width="10%" class="pagedistd">有效截止日期</td>
            <td width="23%" class="pagetd"><input type="text" id="a_yxqhzrq" readonly class="readonly" /></td>
          </tr>
          <tr>
            <td width="10%" class="pagedistd">受理人</td>
            <td width="23%" class="pagetd"><input type="text"  id="a_slr" readonly class="readonly" /></td>
            <td width="10%" class="pagedistd">采集点编号</td>
            <td width="23%" class="pagetd"><input type="text"   id="a_cjdbm" readonly class="readonly" /></td>
            <td width="10%" class="pagedistd">采集点名称</td>
            <td width="23%" class="pagetd"><input type="text"   id="a_cjdmc" readonly class="readonly" /></td>
          </tr>
          <tr>
            <td colspan="6"><table width="220" border="0" align="right" cellpadding="0" cellspacing="0">
            <tr>
                  <td width="28%" height="28px" ><a href="#" class="submitbutton" onclick='addAll();' >受理</a></td>
                <td width="44%"><a href="#" class="submitlongbutton" onclick='addAndPrint();'>受理并打印</a></td>
                <td width="28%" ><a href="#" class="submitbutton" onclick='$("#icksl_detail").hideAndRemove("show");'>关闭</a></td>
              </tr>
            </table></td>
          </tr>
      </table></td>
    </tr>
  </table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="3"></td>
    </tr>
  </table>
  <table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
    <tr>
      <td class="queryfont">境外从业人员</td>
    </tr>
    <tr>
      <td class="tdbg"><table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
        <tr>
          <td width="14%" class="distd1">人员编号</td>
          <td width="24%"  class="detailtd2"><span id="w_cyrybh"></span></td>
          <td width="13%" class="distd1">中文姓名</td>
          <td width="21%" class="detailtd2"><span id="w_xm"></span></td>
          <td width="28%" rowspan="13" align="center" valign="top" class="detailtd2"><table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
        <tr><td><img id="ryImage" width="150" height="180" /></td></tr>
      </table></td>
        </tr>
        <tr>
          <td class="distd1">英文姓</td>
          <td class="detailtd2"><span id="w_ywx"></span></td>
          <td class="distd1">英文名</td>
          <td class="detailtd2"><span id="w_ywm"></span></td>
        </tr>
        <tr>
          <td class="distd1">性别</td>
          <td class="detailtd2"><span id="w_xb"></span></td>
          <td class="distd1">出生日期</td>
          <td class="detailtd2"><span id="w_csrq"></span></td>
        </tr>
        <tr>
          <td class="distd1">国籍</td>
          <td class="detailtd2"><span id="w_gj"></span></td>
          <td class="distd1">婚姻状况</td>
          <td class="detailtd2"><span id="w_hyzk"></span></td>
        </tr>
        <tr>
          <td class="distd1">就业许可证号</td>
          <td class="detailtd2"><span id="w_wgrjyxkz"></span></td>
          <td class="distd1">入职日期</td>
          <td class="detailtd2"><span id="w_rzrq"></span></td>
        </tr>
        <tr>
          <td class="distd1">护照类型</td>
          <td class="detailtd2"><span id="w_cyzj"></span></td>
          <td class="distd1">护照号</td>
          <td class="detailtd2"><span id="w_zjhm"></span></td>
        </tr>
        <tr>
          <td class="distd1">人员类别</td>
          <td class="detailtd2"><span id="w_cylb"></span></td>
          <td class="detailtd2">&nbsp;</td>
          <td class="distd1"></td>
        </tr>
        <tr>
          <td class="distd1">服务单位</td>
          <td colspan="3" class="detailtd2"><span id="w_qymc"></span></td>
        </tr>
        <tr>
          <td class="distd1">联系电话</td>
          <td class="detailtd2"><span id="w_shouji"></span></td>
          <td class="distd1">紧急联系电话</td>
          <td class="detailtd2"><span id="w_qtlxdh"></span></td>
        </tr>
        <tr>
          <td class="distd1">身高（厘米）</td>
          <td class="detailtd2"><span id="w_shengao"></span></td>
          <td class="distd1">体重（公斤）</td>
          <td class="detailtd2"><span id="w_tizh"></span></td>
        </tr>
        <tr>
          <!-- <td class="distd1">职务</td>
          <td class="detailtd2"><span id="w_zhiwu"></span></td> -->
          <td class="distd1">暂住证号码</td>
          <td class="detailtd2"><span id="w_zzzhm"></span></td>
          <td class="distd1">采集时间</td>
          <td class="detailtd2"><span id="w_lrsj"></span></td>
        </tr>
       <!-- <tr>
          <td class="distd1">暂住证号码</td>
          <td colspan="3" class="detailtd2"><span id="w_zzzhm"></span></td>
        </tr> --> 
        <tr>
          <td class="distd1">暂住地址</td>
          <td colspan="3" class="detailtd2"><span id="w_zzdz"></span></td>
        </tr>
  </table>
