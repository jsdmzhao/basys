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
	function updatediv(json) { 
		if(json.qyryxx!=null){
		$("#w_cyrybh").append(setNull(json.qyryxx.cyrybh));
		$("#w_cylb").append(setNull(json.qyryxx.cylb));
		$("#w_xm").append(setNull(json.qyryxx.xm));
		$("#w_bm").append(setNull(json.qyryxx.bm));
		$("#w_minzu").append(setNull(json.qyryxx.minzu));
		$("#w_xb").append(setNull(json.qyryxx.xb));
		$("#w_csrq").append(setNull(json.qyryxx.csrq));
		$("#w_hyzk").append(setNull(json.qyryxx.hyzk));
		$("#w_hjdxzqh").append(setNull(json.qyryxx.hjdxzqh));
		$("#w_hjdxz").append(setNull(json.qyryxx.hjdxz));
		$("#w_zjhm").append(setNull(json.qyryxx.zjhm));
		$("#w_zzzhm").append(setNull(json.qyryxx.zzzhm));
		$("#w_zzdz").append(setNull(json.qyryxx.zzdz));
		$("#w_shouji").append(setNull(json.qyryxx.shouji));
		$("#w_jjlxrdh").append(setNull(json.qyryxx.jjlxrdh));
		//$("#w_zhiwu").append(setNull(json.qyryxx.zhiwu));
		$("#w_rzrq").append(setNull(json.qyryxx.rzrq));
		$("#w_zxr").append(setNull(json.qyryxx.zxr));
		$("#w_zxsj").append(setNull(json.qyryxx.zxsj));
		$("#w_lrsj").append(setNull(json.qyryxx.lrsj));
		$("#w_lrr").append(setNull(json.qyryxx.lrr));
		$("#w_shengao").append(setNull(json.qyryxx.shengao));
		$("#w_tizh").append(setNull(json.qyryxx.tizh));
		$("#w_qymc").append(setNull(json.qyryxx.qymc));
		$("#w_zxyy").append(setNull(json.qyryxx.zxyy));
		$("#w_zt").append(setNull(json.qyryxx.zt));
		$("#w_scbz").append(setNull(json.qyryxx.scbz));
		}else{
			jAlert("该从业人员不存在","提示信息");
		}
		
		$("#a_cjdbm").val(setNull(json.LIcksl[0].cjdbm));
		$("#a_cjdmc").val(setNull(json.LIcksl[0].cjdmc));
		$("#a_lqsj").val(setNull(json.LIcksl[0].lqsj).substring(0,10));
		$("#a_yxqhzrq").val(setNull(json.LIcksl[0].yxqhzrq).substring(0,10));
		$("#a_slr").val(setNull(json.LIcksl[0].slr));

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
<input type="hidden" id="i_cyrylbdm" value="0">
<input type="hidden" id="a_ryid">
<div>
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">从业人员IC卡受理</td>
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
            <td width="23%" class="pagetd">
            <select name="select" id="a_slyy"><option></option></select></td>
            <td width="10%" class="pagedistd">预计领卡时间</td>
            <td width="23%" class="pagetd"><input type="text" id="a_lqsj" readonly class="readonly" /></td>
            <td width="10%" class="pagedistd">有效截止日期</td>
            <td width="23%" class="pagetd"><input type="text" id="a_yxqhzrq" readonly class="readonly" /></td>
          </tr>
          <tr>
            <td width="10%" class="pagedistd">受理人</td>
            <td width="23%" class="pagetd"><input type="text" class="readonly" id="a_slr" readonly /></td>
            <td width="10%" class="pagedistd">采集点编号</td>
            <td width="23%" class="pagetd"><input type="text" class="readonly" id="a_cjdbm" readonly /></td>
            <td width="10%" class="pagedistd">采集点名称</td>
            <td width="23%" class="pagetd"><input type="text" class="readonly" id="a_cjdmc" readonly /></td>
          </tr>
          <tr>
            <td colspan="6"><table width="240" border="0" align="right" cellpadding="0" cellspacing="0">
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
      <td class="queryfont">国内从业人员</td>
    </tr>
    <tr>
      <td class="tdbg"><table width="100%"  cellpadding="4" cellspacing="0" class="detail" id="detail" >
        <tr>
          <td width="14%" class="distd1">人员编号</td>
          <td width="24%"  class="detailtd2"><span id="w_cyrybh"></span></td>
          <td width="13%" class="distd1">姓名</td>
          <td width="21%" class="detailtd2"><span id="w_xm"></span></td>
          <td width="28%" rowspan="11" align="center" valign="top" class="detailtd2"><table width="35%" border="0" align="center" cellpadding="8" cellspacing="0">
        <tr><td><img id="ryImage" width="150" height="180" /></td></tr>
      </table></td>
        </tr>
        <tr>
          <td class="distd1">公民身份号码</td>
          <td class="detailtd2"><span id="w_zjhm" ></span></td>
          <td class="distd1">别名</td>
          <td class="detailtd2"><span id="w_bm" ></span></td>
          </tr>
        <tr>
          <td class="distd1">性别</td>
          <td class="detailtd2"><span id="w_xb"></span></td>
          <td class="distd1">出生日期</td>
          <td class="detailtd2"><span id="w_csrq"></span></td>
          </tr>
        <tr>
          <td class="distd1">民族</td>
          <td class="detailtd2"><span id="w_minzu"></span></td>
          <td class="distd1">婚姻状况</td>
          <td class="detailtd2"><span id="w_hyzk"></span></td>
          </tr>
        <tr>
          <td class="distd1">户籍省县</td>
          <td class="detailtd2"><span id="w_hjdxzqh"></span></td>
          <td class="distd1">入职日期</td>
          <td class="detailtd2"><span id="w_rzrq"></span></td>
          </tr>
        <tr>
          <td  class="distd1">户籍地详址</td>
          <td colspan="3" class="detailtd2"><span id="w_hjdxz"></span></td>
          </tr>
        <tr>
          <td class="distd1">人员类别</td>
          <td class="detailtd2" colspan="3"><span id="w_cylb"></span></td>
          <!--  <td class="distd1">&nbsp;</td>
          <td class="detailtd2"><span id="shouji"></span></td>-->
        </tr>
        <tr>
          <td class="distd1">服务单位</td>
          <td colspan="3" class="detailtd2"><span id="w_qymc"></span></td>
          </tr>
        <tr>
          <td class="distd1">联系电话</td>
          <td class="detailtd2"><span id="w_shouji"></span></td>
          <td class="distd1">紧急联系电话</td>
          <td class="detailtd2"><span id="w_jjlxrdh"></span></td>
          </tr>
        <tr>
          <td class="distd1">身高（厘米）</td>
          <td class="detailtd2"><span id="w_shengao"></span></td>
          <td class="distd1">体重（公斤）</td>
          <td class="detailtd2"><span id="w_tizh"></span></td>
          </tr>
        <tr>
          <!--  <td class="distd1">职务</td>
          <td class="detailtd2"><span id="w_zhiwu"></span></td>-->
          <td class="distd1">暂住编号</td>
          <td class="detailtd2"><span id="w_zzzhm"></span></td>
          <td class="distd1">采集时间</td>
          <td class="detailtd2"><span id="w_lrsj"></span></td>
        </tr>
       <!--  <tr>
          <td class="distd1">暂住编号</td>
          <td colspan="4" class="detailtd2"><span id="w_zzzhm"></span></td>
          </tr> -->
        <tr>
          <td class="distd1">暂住地址</td>
          <td colspan="4" class="detailtd2"><span id="w_zzdz"></span></td>
          </tr>
      </table></td>
    </tr>
	</table>
</div>
