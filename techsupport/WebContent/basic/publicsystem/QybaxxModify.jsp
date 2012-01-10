<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function(){
		if(dangQianHylbdm=="J"){
			$("#td_qybaxxtjTitle").text("场所备案信息修改");
			$("#td_qyxxbaTitle").text("场所信息备案");
			$("#td_qyfl_zhu").text("场所分类（主）");
			$("#qyflf").text("场所分类（副）"); 
			$("#td_csjyxxTitle").text(" 场所简要信息");
			$("#td_qybm_modify").text("场所编码");
			$("#td_qymc_modify").text("场所名称");
		}
		
	  	bc_bottonMoveRight(1); 
	  
		$("#tjclxx").empty();
		$("#tjclxx").load(csbaxx_tjclHtml); //提交材料信息
		
		$("#q_qyid").attr("value",ylcsjbxx_dataid);
		$("#q_qybaxxid").attr("value",csbaxx_dataid);
		
		$("#m_barq").attr("readonly","true");
		$("#m_barq").datepicker();
	});
	function CompleteEnd(){
		$("#grid_baxxtjTable").find("input[@type='checkbox']").attr("disabled","disabled").end();
		$("#grid_baxxtjTable").find("input[@id^='tjrq']").attr("readonly","true").datepicker().end();
		ylcsjbxx_setDetail();
	}
	function ylcsjbxx_updatediv(json){
		$("span").html("").end();
		$("#hylb").append(setNull(json.LQyjbxx[0].hylb));
		if(setNull(json.LQyjbxx[0].hylbdm)!="J"){
			$('#qyflf').hide();
			$('#qyflf2').hide();
		}
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
		$("#m_qyid").attr("value",setNull(json.LQybaxx[0].qyid));
		$("#m_qybm").attr("value",setNull(json.LQybaxx[0].qybm));
		$("#m_qybaxxid").attr("value",setNull(json.LQybaxx[0].qybaxxid));
		
		$("#m_qybabm").attr("value",setNull(json.LQybaxx[0].qybabm));
		$("#m_babmmc").attr("value",setNull(json.LQybaxx[0].babmmc));
		$("#m_babmbm").attr("value",setNull(json.LQybaxx[0].babmbm));
		$("#m_barq").attr("value",setNull(json.LQybaxx[0].barq));
		$("#m_bar").attr("value",setNull(json.LQybaxx[0].bar));
		$("#m_sftjwz").attr("value",setNull(json.LQybaxx[0].sftjwz));
		
		if(setNull(json.LQybaxx[0].sftjwz)=='1'){
			$("#sftjwz").attr("checked",true);
		}else{
			$("#sftjwz").attr("checked",false);
		}
		
		if(json.LQybaxx[2].length>0){
		
			for(var index=0,max=json.LQybaxx[2].length;index<max;index++){
				var thisid = json.LQybaxx[2][index].tjcllxdm;
				$("#grid_baxxtjTable").find("input[@id='sftj_"+thisid+"']").attr("checked",true).end();
				$("#grid_baxxtjTable").find("input[@id='tjr_"+thisid+"']").attr("value",json.LQybaxx[2][index].tjrxm).end();
				$("#grid_baxxtjTable").find("input[@id='tjrq_"+thisid+"']").
					attr("value",setNull(json.LQybaxx[2][index].tijiaorq)).end();
			}
		}
	}
	function csbaxx_update(){
		if (csbaxx_queryVerify()){
			csbaxx_setQueryBaxx();
		}
	}
	function csbaxx_queryVerify(){
		var isCanPlay = 1;
		if (!checkControlValue("m_barq","Date",null,null,null,1,"备案日期"))
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
				
				$("#m_tjcllx").attr("value",$("#m_tjcllx").attr("value")+lxmc+"|");
				$("#m_tjcllxdm").attr("value",$("#m_tjcllxdm").attr("value")+thisid+"|");
				$("#m_tjrxm").attr("value",$("#m_tjrxm").attr("value")+tjrval+"|");
				$("#m_pageSort").attr("value",$("#m_pageSort").attr("value")+tjrqval+"|"); //提交日期
			}
		});
		
		if($("#sftjwz").attr("checked")==true){
			$("#m_sftjwz").attr("value","1");
		}else{
			$("#m_sftjwz").attr("value","0");
		}
		return true;
	}
</script>
<input type="hidden" id="q_qyid" value="">
<input type="hidden" id="q_qybaxxid" value="">

<input type="hidden" id="m_qyid" value="">
<input type="hidden" id="m_qybaxxid" value="">
<input type="hidden" id="m_qybm" value="">
<input type="hidden" id="m_babmbm" value="">

<input type="hidden" id="m_tjcllxdm" value="">
<input type="hidden" id="m_tjcllx" value="">
<input type="hidden" id="m_tjrxm" value="">
<input type="hidden" id="m_pageSort" value="">

<input type="hidden" id="m_sftjwz" value="">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1" id="td_qybaxxtjTitle">企业备案信息修改</td>
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
            <td class="queryfont" id="td_qyxxbaTitle">&nbsp;企业信息备案</td>
          </tr>
          <tr>
            <td valign="top" class="tdbg">
            <table width="100%" border="0" cellspacing="0" cellpadding="2" class="detail">
           <tr>
                <td class="distd1">行业分类</td>
                <td  class="detailtd2"><span id="hylb"></span></td>
                 <td width="13%" class="distd1">管辖单位</td>
                <td class="detailtd2"><span id="gxdwmc"></span></td>
              </tr>
              <tr>
                <td width="13%" class="distd1" id="td_qyfl_zhu">企业分类（主）</td>
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
		    <td class="queryfont" id="td_csjyxxTitle">&nbsp;企业简要信息</td>
		  </tr>
		  <tr>
          
		    <td valign="top" class="tdbg">
		    <table width="100%" border="0" cellspacing="0" cellpadding="2" class="detail">
		      <tr>
		        <td width="13%" class="distd1" id="td_qybm_modify">企业编码</td>
		        <td width="20%" class="detailtd2"><span id="csbm"></span></td>
		        <td width="13%" class="distd1" id="td_qymc_modify">企业名称</td>
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
		        <td colspan="5"class="detailtd2"><span id="dwfzrlxfs"></span></td>
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
				        <td width="20%" class="pagetd1"><input type="text" id="m_qybabm" readonly class="readonly"/></td>
				        <td width="13%" class="pagedistd1">备案机构</td>
				        <td class="pagetd1"><input type="text" id="m_babmmc" readonly class="readonly"/></td>
			          </tr>
				      <tr>
				        <td class="pagedistd1">备案日期</td>
				        <td class="pagetd1"><input id="m_barq" type="text"/></td>
				        <td class="pagedistd1">备案人</td>
				        <td class="pagetd1"><input type="text" id="m_bar" readonly class="readonly"/></td>
			          </tr>
                      <tr>
				        <td colspan="4" class="pagetd1">
				        <div style="width:100%" id=tjclxx></div>
				        </td>
		              </tr>
                      <tr>
				      <td class="pagedistd1">
				          <input type="checkbox" name="checkbox" id="sftjwz"/></td>
			            <td colspan="3" class="pagetd1">备案信息提交完整</td>
		              </tr>
		              <tr>
                         <td colspan="4">
                         <table width="100%" border="0" cellspacing="0" cellpadding="0">
						 <tr>
						   <td height="6"></td>
						 </tr>
						 <tr>
						   <td>
						   <a href="#" hidefocus="true" class="submitbutton" title="修改" onclick='csbaxx_update();'>保存</a></td>
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
	