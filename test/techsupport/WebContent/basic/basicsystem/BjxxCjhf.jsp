<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants"%>

<%
	User user = (User) session.getAttribute(Constants.userKey);
%>
<script type="text/javascript">
	var userType = "<%=user.getUsertype()%>".substr(0,1);
	
	var hylbdm1 = "";
	
	$(document).ready(function() {
		bc_bottonMoveRight(); //将保存按钮右移
		//alert($("#m_bjxxid").attr("value"));
		// 读入报警回复信息
		setParams("m_");
		jQuery.post("basicsystem/cjhf_bjxxb.action",params,cjhf_div,"json"); // 提交到BjxxbAction中,调用其中的queryCjhf方法
		// 读入在逃（本地）布控人员信息
		
		$("#div_bdxx").empty();
		if($("#current_recordBjlx").attr("value")=="全国在逃报警"){
			$("#div_bdxx").load("basic/basicsystem/BjxxDetailQgztjyxxKz.jsp");
		}else if($("#current_recordBjlx").attr("value")=="本地布控报警"){
			$("#div_bdxx").load("basic/basicsystem/BjxxDetailBdbkryxxKz.jsp");
		}
		$("#div_bdxx").show("slow");
		
		
		// 添加日期属性
		$("#m_chjsj").datepicker(true); //出警时间
		$("#m_zhsj").datepicker(true); // 抓获时间
		
		// 添加下拉菜单
		$("#m_cjjgdm").selectBox({code:"dm_cjjg"}); // 处警结果选择框
		$("#m_cjfklbdm").selectBox({code:"dm_cjfklb"}); // 处警反馈类别选择框
		//$("#m_cjfklbdm").setAttr("readonly",true);
		//$("#m_zhsj").css("display","none");
		
		// 根据处警结果清空处警反馈类别或者抓获时间 
		$("#m_cjjgdm").change(function(){
			chageCjfklbdm();
		});
	});
	function chageCjfklbdm(){
		if($("#m_cjjgdm").attr("value")==1){ // 已抓获
			
				$("#m_cjfklbdm").setValue("");
				$("#m_cjfklbdm").setAttr("readonly",true);
				
				$("#m_zhsj").css("display","block");
				$("#m_zhsj").datepicker(true); // 抓获时间
			}else{ // 未抓获
				$("#m_zhsj").attr("value","");
				$("#m_zhsj").css("display","none");
				$("#m_zhsj").click(function(){return false;});
				
				$("#m_cjfklbdm").setAttr("readonly",false);
				$("#m_cjfklbdm").setAttr("readonly",false);
			}
	}
	function cjhfVerify(){
		if (!checkControlValue("m_chjsj","Datetime",null,null,null,1,"出警时间"))
			return false;
		if (!checkControlValue("m_cjfzr","String",1,100,null,1,"出警负责人"))
			return false;
		if (!checkControlValue("m_lxdh","String",1,30,null,1,"回复人联系电话"))
			return false;
		if(hylbdm1=="A"){
			if (!checkControlValue("m_fjh","String",1,30,null,1,"房间号"))
				return false;
			}
		if (!checkControlValue("m_jyaq","String",1,2000,null,1,"简要案情"))
			return false;
		if (!checkControlValue("m_cjjg","String",1,2000,null,1,"处警经过"))
			return false;
		if (!checkControlValue("m_cjjgdm","Select",1,2,null,1,"处警结果"))
			return false;
		if($("#m_cjjgdm").attr("value")=="1"){ // 已抓获
			if (!checkControlValue("m_zhsj","Datetime",null,null,null,1,"抓获时间"))
			return false;
		}else{ // 未抓获
			if (!checkControlValue("m_cjfklbdm","Select",1,2,null,1,"处警反馈类别"))
			return false;
		}
		if (!checkDateEarlier("s_pjsj","派警时间","m_chjsj","出警时间","DATETIME"))
			return false;
		if (!checkDateEarlier("m_chjsj","出警时间","m_zhsj","抓获时间","DATETIME"))
			return false;
		$("#temp_dqsj").val(TimeObject().fullYear+"-"+TimeObject().month+"-"+TimeObject().date+" "+TimeObject().hours+":"+TimeObject().minutes+":59");
		if (!checkDateEarlier("m_zhsj", "抓获时间", "temp_dqsj", "当前时间", "DATETIME")) 
	        return false;
		// 设定下拉框的值和代码
		$("#m_cjfklb").val($("#m_cjfklbdm").attr("title"));
		$("#m_chjjg").val($("#m_cjjgdm").attr("title"));
		
		return true;
	}
	
	function cjhf_div (json) {
		// 不可修改的初始值
		$("#s_bjsj").val(setNull(json.LBjxxb[0].bjsj));
		$("#s_pjsj").val(setNull(json.LBjxxb[0].pjsj));
		$("#s_ssqymc").val(setNull(json.LBjxxb[0].ssqymc));
		$("#m_gxbbh").val(setNull(json.LBjxxb[0].gxbbh));
		
		if(json.LBjxxb[0].canModify==0){ // 根据是否可以修改属性设置只读
			$("#detail2").find("input").attr("readonly","true");
			$("#detail2").find("input").attr("class","readonly");
			$("#detail2").find("textarea").attr("readonly","true");
			$("#detail2").find("textarea").attr("class","readonlytext");
			$("#buttonUpdate").attr("onclick","");
		}
		
		// 可以修改的初始值
		$("#m_chjsj").val(setNull(json.LBjxxb[0].chjsj));
		$("#m_lxdh").val(setNull(json.LBjxxb[0].lxdh));
		$("#m_fjh").val(setNull(json.LBjxxb[0].fjh));
		$("#m_jyaq").val(setNull(json.LBjxxb[0].jyaq));
		$("#m_cjjg").val(setNull(json.LBjxxb[0].cjjg));
		$("#m_cjjgdm").setValue((setNull(json.LBjxxb[0].cjjgdm)));
		$("#m_cjfklbdm").setValue((setNull(json.LBjxxb[0].cjfklbdm)));
		$("#m_zhsj").val(setNull(json.LBjxxb[0].zhsj));
		$("#m_cjfkbz").val(setNull(json.LBjxxb[0].cjfkbz));
		
		hylbdm1 = json.LBjxxb[0].hylbdm;   //////////////////////////////////////得到行业类别代码
		
		
		// 从Session中获取登录用户相关信息
		if(setNull(json.LBjxxb[0].cjbm)=="")
			$("#m_cjbm").val("<%=user.getDepartment().getDepartname()%>");
		else
			$("#m_cjbm").val(setNull(json.LBjxxb[0].cjbm));
			
		if(setNull(json.LBjxxb[0].cjbmbm)=="")
			$("#m_cjbmbm").val("<%=user.getDepartment().getDepartcode()%>");
		else
			$("#m_cjbmbm").val(setNull(json.LBjxxb[0].cjbmbm));
			
		if(setNull(json.LBjxxb[0].cjfzr)=="")
			$("#m_cjfzr").val("<%=user.getUsername()%>");
		else
			$("#m_cjfzr").val(setNull(json.LBjxxb[0].cjfzr));
			
		if(setNull(json.LBjxxb[0].fkdw)=="")
			$("#m_fkdw").val("<%=user.getDepartment().getDepartname()%>");
		else
			$("#m_fkdw").val(setNull(json.LBjxxb[0].fkdw));
			
		if(setNull(json.LBjxxb[0].fkdwbm)=="")
			$("#m_fkdwbm").val("<%=user.getDepartment().getDepartcode()%>");
		else
			$("#m_fkdwbm").val(setNull(json.LBjxxb[0].fkdwbm));
			
		if(setNull(json.LBjxxb[0].fkr)=="")
			$("#m_fkr").val("<%=user.getUsername()%>");
		else
			$("#m_fkr").val(setNull(json.LBjxxb[0].fkr));
		
		// 添加只读属性
		$("#m_chjsj").attr("readonly","true");
		$("#m_zhsj").attr("readonly","true");
		$("#s_bjsj").attr("readonly","true");
		$("#s_pjsj").attr("readonly","true");
		$("#s_ssqymc").attr("readonly","true");
		$("#m_cjbm").attr("readonly","true");
		chageCjfklbdm();
		if(hylbdm1=="A"){ //////////旅馆业 显示输入房间号
		  $("#fjhdiv").show();
		  $("#fjhinputdiv").show();
		}
	}

function cjhfUpdate(){
	if (cjhfVerify()){
		setParams("m_");
		jQuery.post("basicsystem/cjhfUpdate_bjxxb.action",params,cjhfupdateback,"json"); 
	}else{
		return cjhfVerify();
	}		
}
	
function cjhfupdateback(json){
	if  (json.result=="success"){
		jAlert("回复成功",'保存信息');
		setPageList($("#pageNo").attr("value"));
		$("#"+detailid).hideAndRemove("slow"); 
	}else{
		jAlert(json.result,'错误信息');
	}		
}

function printpage(myDiv){ 

   
	$("#s_bjsj_span").text($("#s_bjsj").val()); 
	$("#s_pjsj_span").text($("#s_pjsj").val()); 
	$("#m_chjsj_span").text($("#m_chjsj").val());
	$("#m_cjbm_span").text($("#m_cjbm").val());  
	$("#m_cjfzr_span").text($("#m_cjfzr").val());
	$("#m_lxdh_span").text($("#m_lxdh").val()); 
	$("#s_ssqymc_span").text($("#s_ssqymc").val()); 
	$("#m_fjh_span").text($("#m_fjh").val()); 
	  
	$("#m_jyaq_span").text($("#m_jyaq").val());  ///案情简介 
	$("#m_cjjg_span").text($("#m_cjjg").val());  
	
	$("#m_cjjgdm_span").text($("#m_cjjgdm").find("option:selected").text());  
	$("#m_cjfklbdm_span").text($("#m_cjfklbdm").find("option:selected").text());  
	
	$("#m_zhsj_span").text($("#m_zhsj").val()); 
	$("#m_cjfkbz_span").text($("#m_cjfkbz").val());
	
   	var content = document.all.item("div_bdxx").innerHTML;
   	content += document.all.item("printDivtest").innerHTML;
   	
   	content = content.replace(new RegExp("TEXTAREA","gm"),"SPAN");
   	
	var title = "处警回复";
	params={con:content,titlecon:title};
	jQuery.post("basicsystem/printCon_publicPrint.action",params,printback,"json");
    return false; 
} 

var printConxbj;
function printback(json){
	printConxbj = json.con;
	//$("#print_detaildisplay").html(json.con);
	var url = window.location.href;
   	var len = url.lastIndexOf('/');
   	url = url.substring(0, len)+"/public/printXbj.jsp";
   	window.open(url,"打印");
}

/**
function printback(){
	var url = window.location.href;
   	var len = url.lastIndexOf('/');
   	url = url.substring(0, len)+"/public/printHtml.jsp";
   	window.open(url);
} **/

</script>
<input type="hidden" id="temp_dqsj">
<input type="hidden" id="m_gxbbh">
<input type="hidden" id="m_fkdw">
<input type="hidden" id="m_fkdwbm">
<input type="hidden" id="m_fkr">
<input type="hidden" id="m_fkrq">
<input type="hidden" id="m_jqzt" value="已回复报警">
<input type="hidden" id="m_jqztdm" value="2">

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			处警回复
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv" onclick='$("#bjxxb_detail").hideAndRemove("show");'class="close"></a>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="3"></td>
  </tr>
</table>
<div id="printDiv" class="scrollbarface" style="overflow-y:auto;overflow-x:hidden;height:400">
<div style="width:98%" id="div_bdxx"></div>
<tr align="center">
  <td colspan="6" height="8"><table width="98%" border="0" cellspacing="0" cellpadding="0"  class="tableborder">
   <tr>
	<td colspan="6" class="queryfont">&nbsp;处警情况</td>
</tr>
    <tr>
      <td><table width="100%" id="detail2" class="detail">
        <tr>
          <td width="89" class="distd1"> 报警时间 </td>
          <td width="206" class="detailtd2"><input type="text"    id="s_bjsj" />
          </td>
          <td width="100" class="distd1"> 派警时间 </td>
          <td width="197" class="detailtd2"><input type="text"    id="s_pjsj" />
          </td>
          <td width="132" class="reddistd1"> 出警时间 </td>
          <td width="204" class="detailtd2"><input type="text"    id="m_chjsj" />
          </td>
        </tr>
        <tr>
          <td class="distd1"> 出警部门名称 </td>
          <td class="detailtd2"><input type="hidden" id="m_cjbmbm" />
              <input type="text"    id="m_cjbm" />
          </td>
          <td class="reddistd1"> 出警负责人 </td>
          <td class="detailtd2"><input type="text"    id="m_cjfzr" />
          </td>
          <td class="reddistd1"> 回复人联系电话 </td>
          <td class="detailtd2"><input type="text"    id="m_lxdh" />
          </td>
        </tr>
        <tr>
          <td class="distd1"> 所属企业名称 </td>
          <td class="detailtd2"><input type="text"    id="s_ssqymc" />
          </td>
          	<td class="reddistd1" ><div id="fjhdiv" style="display:none" >房间号</div></td>
            <td class="detailtd2" colspan="3"><div id="fjhinputdiv" style="display:none" ><input type="text"    id="m_fjh" /></div></td>
        </tr>
        <tr>
          <td class="reddistd1"> 简要案情 </td>
          <td  colspan="5" class="detailtd2"><textarea name="textarea" id="m_jyaq"  style="width:98%"  rows="2"></textarea>
          </td>
        </tr>
        <tr>
          <td class="reddistd1"> 处警经过 </td>
          <td  colspan="5" class="detailtd2" ><textarea name="textarea2" id="m_cjjg"  style="width:98%" rows="2"></textarea>
          </td>
        </tr>
        <tr>
          <td class="reddistd1"> 处警结果 </td>
          <td class="detailtd2"><input type="hidden" id="m_chjjg" />
              <select name="m_cjjgdm" id="m_cjjgdm" type="select">
              	<option></option>
              </select>
          </td>
          <td class="distd1"> 处警反馈类别 </td>
          <td class="detailtd2"><input type="hidden" id="m_cjfklb" />
              <select name="m_cjfklbdm" id="m_cjfklbdm" type="select">
                <option></option>
              </select>
          </td>
          <td class="distd1"> 抓获时间 </td>
          <td class="detailtd2"><input type="text"    id="m_zhsj" />
          </td>
        </tr>
        <tr>
          <td class="distd1"> 备注 </td>
          <td colspan="5" class="detailtd2"><textarea name="textarea3"  id="m_cjfkbz" style="width:98%" rows="2"></textarea>
          </td>
        </tr>
      </table></td>
    </tr>
  </table></td>
</tr>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="3"></td>
  </tr>
</table>




<!-- 打印部分  -->

<div id="printDivtest" class="scrollbarface" style="display:none;overflow-y:auto;overflow-x:hidden;height:400" >
<tr align="center">
  <td colspan="6" height="8"><table width="98%" border="0" cellspacing="0" cellpadding="0"  class="tableborder">
   <tr>
	<td colspan="6" class="queryfont">&nbsp;处警情况</td>
</tr>
    <tr>
      <td><table width="100%" id="detail2" class="detail">
        <tr>
          <td width="13%" class="distd1"> 报警时间 </td>
          <td width="20%" class="detailtd2"><span id="s_bjsj_span"></span>
          </td>
          <td width="13%" class="distd1"> 派警时间 </td>
          <td width="20%" class="detailtd2"><span id="s_pjsj_span"></span>
          </td>
          <td width="13%" class="reddistd1"> 出警时间 </td>
          <td width="20%" class="detailtd2"><span id="m_chjsj_span"></span>
          </td>
        </tr>
        <tr>
          <td class="distd1"> 出警部门名称 </td>
          <td class="detailtd2"><span id="m_cjbm_span"></span>
          </td>
          <td class="reddistd1"> 出警负责人 </td>
          <td class="detailtd2"><span id="m_cjfzr_span"></span>
          </td>
          <td class="reddistd1"> 回复人联系电话 </td>
          <td class="detailtd2"><span id="m_lxdh_span"></span>
          </td>
        </tr>
        <tr>
          <td class="distd1"> 所属企业名称 </td>
          <td class="detailtd2"><span id="s_ssqymc_span"></span>
          </td>
          	<td class="reddistd1" ><div id="fjhdiv" style="display:none" >房间号</div></td>
            <td class="detailtd2" colspan="3"><div id="fjhinputdiv" style="display:none" ><span id="m_fjh_span"></span></div></td>
        </tr>
        <tr>
          <td class="reddistd1"> 简要案情 </td>
          <td style="width:600px;" colspan="5" class="detailtd2">
              <span id="m_jyaq_span"></span>
          </td>
        </tr>
        <tr>
          <td class="reddistd1"> 处警经过 </td>
          <td style="width:600px;" colspan="5" class="detailtd2" >
             <span id="m_cjjg_span"></span>
          </td>
        </tr>
        <tr>
          <td class="reddistd1"> 处警结果 </td>
          <td class="detailtd2">
              <span id="m_cjjgdm_span"></span>
          </td>
          <td class="distd1"> 处警反馈类别 </td>
          <td class="detailtd2">
              <span id="m_cjfklbdm_span"></span>
          </td>
          <td class="distd1"> 抓获时间 </td>
          <td class="detailtd2">
             <span id="m_zhsj_span"></span>
          </td>
        </tr>
        <tr>
          <td class="distd1"> 备注 </td>
          <td colspan="5" class="detailtd2">
             <span id="m_cjfkbz_span"></span>
          </td>
        </tr>
      </table></td>
    </tr>
  </table></td>
</tr>
</div>

<!-- 打印部分  -->



<table width="100%" border="0" cellspacing="0" cellpadding="2">
<tr align="center">
	<td><a href="#" id="buttonUpdate" hidefocus="true" class="submitbutton" title="保存" onclick='cjhfUpdate();'>保存</a>
	<a href="#" id="buttonPrint" hidefocus="true" class="submitbutton" title="打印" onclick='printpage("printDiv");'>打印</a></td>
</tr>
</table>