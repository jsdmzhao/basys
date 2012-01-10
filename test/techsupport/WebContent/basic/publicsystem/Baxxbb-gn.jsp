<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function(){
	
	  bc_bottonMoveRight(1); 
	
		$("#tjclxx").empty();
		$("#tjclxx").load(csbaxx_tjclHtml); //提交材料信息
		
		$("#q_qyid").attr("value",ylcsjbxx_dataid);
		$("#q_qybaxxid").attr("value",csbaxx_dataid);
		
		$("#b_bbgzrq").attr("readonly","true");
		$("#b_bbgzrq").datepicker();
		$("#b_bbwcrq").attr("readonly","true");
		$("#b_bbwcrq").datepicker();
	});
	function CompleteEnd(){
		ylcsjbxx_setDetail();
	}
	function ylcsjbxx_updatediv(json){
	if(setNull(json.LQyjbxx[0].hylbdm)!="J"){
			$('#qyflf').hide();
			$('#qyflf2').hide();
		}
		$("span").html("").end();
		$("#hylb").append(setNull(json.LQyjbxx[0].hylb));
		$("#cszflmc").append(setNull(json.LQyjbxx[0].qyzflmc));
		$("#gxdwmc").append(setNull(json.LQyjbxx[0].gxdwmc));
		$("#csfflmc").append(setNull(json.LQyjbxx[0].qyfflmc));
		$("#csbm").append(setNull(json.LQyjbxx[0].qybm));
		$("#csmc").append(setNull(json.LQyjbxx[0].qymc));
		$("#jjlxmc").append(setNull(json.LQyjbxx[0].jjlxmc));
		$("#lxdh").append(setNull(json.LQyjbxx[0].lxdh));
		$("#jydz").append(setNull(json.LQyjbxx[0].jydz));
		$("#zczj").append(setNull(json.LQyjbxx[0].zczj));
		$("#jyfwzy").append(setNull(json.LQyjbxx[0].jyfwzy));
		$("#jymj").append(setNull(json.LQyjbxx[0].jymj));
		$("#jyfwjy").append(setNull(json.LQyjbxx[0].jyfwjy));
		$("#frdb").append(setNull(json.LQyjbxx[0].frdb));
		$("#frdbzjlb").append(setNull(json.LQyjbxx[0].frdbzjlb));
		$("#frdbzjhm").append(setNull(json.LQyjbxx[0].frdbzjhm));
		$("#frdblxfs").append(setNull(json.LQyjbxx[0].frdblxfs));
		$("#dwfzr").append(setNull(json.LQyjbxx[0].dwfzr));
		$("#dwfzrzjhm").append(setNull(json.LQyjbxx[0].dwfzrzjhm));
		$("#dwfzrlxfs").append(setNull(json.LQyjbxx[0].dwfzrlxfs));
		csbaxx_setDetail(); //备案详细信息
	}
	function csbaxx_updatediv(json){
	
		$("#b_qyid").attr("value",setNull(json.LQybaxx[0].qyid));
		$("#b_qybaxxid").attr("value",setNull(json.LQybaxx[0].qybaxxid));
		$("#b_qybm").attr("value",setNull(json.LQybaxx[0].qybm));
		
		$("#b_qybabm").attr("value",setNull(json.LQybaxx[0].qybabm));
		$("#b_babmmc").attr("value",setNull(json.LQybaxx[0].babmmc));
		$("#b_babmbm").attr("value",setNull(json.LQybaxx[0].babmbm));
		$("#b_barq").attr("value",setNull(json.LQybaxx[0].barq));
		$("#b_bar").attr("value",setNull(json.LQybaxx[0].bar));
		$("#b_sftjwz").attr("value",setNull(json.LQybaxx[0].sftjwz));
		
		$("#qybabm").append(setNull(json.LQybaxx[0].qybabm));
		$("#babmmc").append(setNull(json.LQybaxx[0].babmmc));
		$("#barq").append(setNull(json.LQybaxx[0].barq));
		$("#bar").append(setNull(json.LQybaxx[0].bar));
		
		if(setNull(json.LQybaxx[0].sftjwz)=='1'){
			$("#sftjwz").attr("checked",true);
		}else{
			$("#sftjwz").attr("checked",false);
		}
		
		$("#b_bbgzrq").attr("value",setNull(json.LQybaxx[1].bbgzrq));
		$("#b_bbwcrq").attr("value",setNull(json.LQybaxx[1].bbwcrq));
		$("#b_bbyy").attr("value",setNull(json.LQybaxx[1].bbyy));
		
		if(json.LQybaxx[2].length>0){
			for(var index=0,max=json.LQybaxx[2].length;index<max;index++){
				var thisid = json.LQybaxx[2][index].tjcllxdm;
				$("#grid_baxxtjTable").find("input[@id='sftj_"+thisid+"']").attr("checked",true).attr("disabled","disabled");
				$("#grid_baxxtjTable").find("input[@id='tjr_"+thisid+"']").attr("value",json.LQybaxx[2][index].tjrxm).attr("readonly",true);
				$("#grid_baxxtjTable").find("input[@id='tjrq_"+thisid+"']").
					attr("value",setNull(json.LQybaxx[2][index].tijiaorq)).attr("readonly",true);
			}
		}
		$("#grid_baxxtjTable").find("input[@id^='tjrq_']").each(function(){
			var date = new Date();
			var newTime = date.getYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
			if($(this).attr("readonly")==false){
				$(this).attr("readonly","true").attr("value",newTime).datepicker(); //日期控件
			}
		});
		//$("#grid_baxxtjTable").find("input[@id^='sftj_']").click(function(){
		//	if(!isComplete()){
		//		$("#b_bbwcrq").attr("value","");
		//		$("#sftjwz").attr("checked",false);
		//	}
		//});
	}
	function csbaxx_bubei(){
		if (csbaxx_bubeiVerify()){
			csbaxx_setBubei();
		}
	}
	function csbaxx_bubeiVerify(){ //验证
		var isCanPlay = 1;
		
		if (!checkControlValue("b_bbgzrq","Date",null,null,null,1,"补备告知日期"))
			return false;
		if($("#sftjwz").attr("checked")==true){ //提交完毕
			if (!checkControlValue("b_bbwcrq","Date",null,null,null,1,"补备完成日期"))
				return false;
		}else{
			if (!checkControlValue("b_bbwcrq","Date",null,null,null,0,"补备完成日期"))
				return false;
		}
		if (!checkControlValue("b_bbyy","String",1,200,null,1,"补备原因"))
			return false;
		$("#grid_baxxtjTable").find("input[type='checkbox']").each(function(){
			if($(this).attr("checked")==true){
				var thisid = $(this).attr("id").replace('sftj_','');
				if (!checkControlValue("tjr_"+thisid,"String",1,200,null,1,"提交人"))
					isCanPlay = 0;
				if (!checkControlValue("tjrq_"+thisid,"Date",null,null,null,1,"提交日期"))
					isCanPlay = 0;
			}
		});
		if(isCanPlay == 0){
			return false;
		}
		$("#grid_baxxtjTable").find("input[type='checkbox']").each(function(){
			if($(this).attr("checked")==true){
				var lxmc = $(this).attr("name");
				var thisid = $(this).attr("id").replace('sftj_','');
				var tjrval = $("#tjr_"+thisid).attr("value");
				var tjrqval = $("#tjrq_"+thisid).attr("value");
				
				$("#b_tjcllx").attr("value",$("#b_tjcllx").attr("value")+lxmc+"|");
				$("#b_tjcllxdm").attr("value",$("#b_tjcllxdm").attr("value")+thisid+"|");
				$("#b_tjrxm").attr("value",$("#b_tjrxm").attr("value")+tjrval+"|");
				$("#b_pageSort").attr("value",$("#b_pageSort").attr("value")+tjrqval+"|"); //提交日期
			}
		});
		
		if($("#sftjwz").attr("checked")==true){
			$("#b_sftjwz").attr("value","1");
		}else{
			$("#b_sftjwz").attr("value","0");
		}
		return true;
	}
	function bbwcOnchange(){ //补备完成日期
		if($("#b_bbwcrq").attr("value")!=""){
		}
	}
	function sftjOnclick(){ //提交材料完整
		if($("#sftjwz").attr("checked")==true){
		}
	}
</script>
<input type="hidden" id="q_qyid" value="">
<input type="hidden" id="q_qybaxxid" value="">

<input type="hidden" id="b_qyid" value="">
<input type="hidden" id="b_qybm" value="">
<input type="hidden" id="b_qybaxxid" value="">
<input type="hidden" id="b_babmbm" value="">
<input type="hidden" id="b_sftjwz" value="">
<input type="hidden" id="b_qybabm" value="">
<input type="hidden" id="b_babmmc" value="">
<input type="hidden" id="b_barq" value="">
<input type="hidden" id="b_bar" value="">

<input type="hidden" id="b_tjcllxdm" value="">
<input type="hidden" id="b_tjcllx" value="">
<input type="hidden" id="b_tjrxm" value="">
<input type="hidden" id="b_pageSort" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">备案信息补备</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='$("#csbaxx_detail").hide("show");'class="close"></a></td>
    </tr>
</table>	
<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="6"></td>
		</tr>
</table>
<table width="100%" border="0" align="center"  cellpadding="0" cellspacing="0"  id="add">
<tr>
<td valign="top">
	<table width="100%"  cellspacing="0" cellpadding="0">
	<tr>
	<td><table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
          <tr>
            <td class="queryfont">&nbsp;场所信息备案</td>
          </tr>
          <tr>
            <td valign="top" class="tdbg">
            <table width="100%" border="0" cellspacing="0" cellpadding="1" class="detail">
              <tr>
                <td class="distd1">行业分类</td>
                <td  class="detailtd2"><span id="hylb"></span></td>
                 <td width="13%" class="distd1">管辖单位</td>
                <td class="detailtd2"><span id="gxdwmc"></span></td>
              </tr>
              <tr>
                <td width="13%" class="distd1">企业分类（主）</td>
                <td width="20%" class="detailtd2"><span id="cszflmc"></span></td>
                	 <td class="distd1" id="qyflf">企业分类（副）</td>
               				 <td colspan="3" id="qyflf2" class="detailtd2"><span id="csfflmc"></span></td>
               
              </tr>
            </table></td>
          </tr>
        </table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
		<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
		  <tr>
		    <td class="queryfont">&nbsp;场所简要信息</td>
		  </tr>
		  <tr>
          
		    <td valign="top" class="tdbg">
		    <table width="100%" border="0" cellspacing="0" cellpadding="1" class="detail">
		      <tr>
		        <td width="13%" class="distd1">场所编码</td>
		        <td width="20%" class="detailtd2"><span id="csbm"></span></td>
		        <td width="13%" class="distd1">场所名称</td>
		        <td width="20%" class="detailtd2"><span id="csmc"></span></td>
		        <td width="13%" class="distd1">经济类型</td>
		        <td width="20%" class="detailtd2"><span id="jjlxmc"></span></td>
		      </tr>
		      <tr>
		        <td class="distd1">联系电话</td>
		        <td class="detailtd2"><span id="lxdh"></span></td>
		        <td class="distd1">经营地址</td>
		        <td class="detailtd2" colspan="3"><span id="jydz"></span></td>
		        </tr>
		      <tr>
		        <td class="distd1">注册资金（万）</td>
		        <td class="detailtd2"><span id="zczj"></span></td>
		        <td class="distd1">经营范围（主营）</td>
		        <td class="detailtd2" colspan="3"><span id="jyfwzy"></span></td>
		      </tr>
		      <tr>
		        <td class="distd1">经营面积（㎡）</td>
		        <td class="detailtd2"><span id="jymj"></span></td>
		        <td class="distd1">经营范围（兼）</td>
		        <td class="detailtd2" colspan="3"><span id="jyfwjy"></span></td>
		      </tr>
		      <tr>
		        <td class="distd1">法定代表人</td>
		        <td class="detailtd2"><span id="frdb"></span></td>
		        <td class="distd1">法人证件类型</td>
		        <td class="detailtd2"><span id="frdbzjlb"></span></td>
		        <td class="distd1">法人证件号码</td>
		        <td class="detailtd2"><span id="frdbzjhm"></span></td>
		      </tr>
		      <tr>
		        <td class="distd1">法人联系方式</td>
		        <td class="detailtd2"><span id="frdblxfs"></span></td>
		        <td class="distd1">单位负责人</td>
		        <td class="detailtd2"><span id="dwfzr"></span></td>
		        <td class="distd1">负责人公民身份号码</td>
		        <td class="detailtd2"><span id="dwfzrzjhm"></span></td>
		      </tr>
              <tr>
		        <td class="distd1">负责人联系方式</td>
		        <td colspan="5" class="detailtd2"><span id="dwfzrlxfs"></span></td>
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
			  <td class="queryfont">备案信息</td>
			</tr>
			<tr><td class="tdbg">
				<table width="100%" border="0" cellspacing="0" cellpadding="2">
				      <tr>
				        <td width="13%" class="pagedistd1">备案编号</td>
				        <td width="20%" class="pagetd1"><span id="qybabm"></span></td>
				        <td width="13%" class="pagedistd1">备案机构</td>
				        <td class="pagetd1"><span id="babmmc"></td>
			          </tr>
				      <tr>
				        <td class="pagedistd1">备案日期</td>
				        <td class="pagetd1"><span id="barq"></span></td>
				        <td class="pagedistd1">备案人</td>
				        <td class="pagetd1"><span id="bar"></span></td>
			          </tr>
                      <tr>
				        <td colspan="4" class="pagetd1">
				        <div style="width:100%" id=tjclxx></div>
				        </td>
		              </tr>
                      <tr>
				      <td class="pagedistd1">
				          <input type="checkbox" name="checkbox" id="sftjwz" /></td>
			            <td colspan="3" class="pagetd1">备案信息提交完整</td>
		              </tr>
                      <tr>
				        <td class="red">补备告知日期</td>
				        <td class="pagetd1"><input type="text" id="b_bbgzrq" class="inputstyle"></td>
				        <td class="pagedistd1">补备完成日期</td>
				        <td class="pagetd1"><input type="text" id="b_bbwcrq" class="inputstyle"></td>
			          </tr>
                      <tr>
				        <td class="red">补备原因</td>
				        <td colspan="3" class="pagetd1">
				        <textarea name="textarea" id="b_bbyy" cols="90" rows="2"></textarea></td>
			          </tr>
			          <tr>
                         <td colspan="4">
                         <table width="100%" border="0" cellspacing="0" cellpadding="0" >
						 <tr>
						   <td><a href="#" hidefocus="true" class="submitbutton" title="补备" onclick='csbaxx_bubei();'>保存</a></td>
						 </tr>
						 </table></td>
               	    </tr> 
				</table>
			</td>
			</tr>
		</table>
	</td>
	</tr>
	</table>
</td>
</tr>
</table>
	