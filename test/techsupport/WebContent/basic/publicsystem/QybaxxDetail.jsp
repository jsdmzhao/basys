<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
	$(document).ready(function(){
		$("#tjclxx").empty();
		$("#tjclxx").load(csbaxx_tjclHtml); //提交材料信息
		
		$("#h_qybaxxid").attr("value",csbaxx_dataid);
		$("#q_qyid").attr("value",ylcsjbxx_dataid);
		$("#q_qybaxxid").attr("value",csbaxx_dataid);
		
		if(dangQianHylbdm=="J"){
			$("#td_qybaxxtjTitle").text("场所备案详细信息");
			$("#td_qyxxbaTitle").text("场所信息备案");
			$("#td_qyfl_zhu").text("场所分类（主）");
			$("#qyflf").text("场所分类（副）"); 
			$("#td_csjyxxTitle").text(" 场所简要信息");
			$("#td_qybm_detail").text("场所编码");
			$("#td_qymc_detail").text("场所名称");
		}
	});
	function CompleteEnd(){
		$("#grid_baxxtjTable").find("input[@type='checkbox']").attr("disabled","disabled").end();
		$("#grid_baxxtjTable").find("input[@type='text']").attr("readonly","true").end();
		ylcsjbxx_setDetail();
	}
	function ylcsjbxx_updatediv(json){
		$("#csbaxx_detail span").html("").end();
		$("#qyba_hylb").append(setNull(json.LQyjbxx[0].hylb));
		if(setNull(json.LQyjbxx[0].hylbdm)!="J"){
			$('#qyflf').hide();
			$('#qyflf2').hide();
		}
		$("#h_qyid").attr("value",setNull(json.LQyjbxx[0].qyid));
		$("#qyba_cszflmc").append(setNull(json.LQyjbxx[0].qyzflmc));
		$("#qyba_gxdwmc").append(setNull(json.LQyjbxx[0].gxdwmc));
		$("#qyba_csfflmc").append(setNull(json.LQyjbxx[0].qyfflmc));
		$("#qyba_csbm").append(setNull(json.LQyjbxx[0].qybm));
		$("#qyba_csmc").append(setNull(json.LQyjbxx[0].qymc));
		$("#qyba_jjlxmc").append(setNull(json.LQyjbxx[0].jjlxmc));
		$("#qyba_lxdh").append(setNull(json.LQyjbxx[0].lxdh));
		$("#qyba_jydz").append(setNull(json.LQyjbxx[0].jydz));
		$("#qyba_zczj").append(setNull(json.LQyjbxx[0].zczj));
		$("#qyba_jyfwzy").append(setNull(json.LQyjbxx[0].jyfwzy));
		$("#qyba_jymj").append(setNull(json.LQyjbxx[0].jymj));
		$("#qyba_jyfwjy").append(setNull(json.LQyjbxx[0].jyfwjy));
		$("#qyba_frdb").append(setNull(json.LQyjbxx[0].frdb));
		$("#qyba_frdbzjlb").append(setNull(json.LQyjbxx[0].frdbzjlb));
		$("#qyba_frdbzjhm").append(setNull(json.LQyjbxx[0].frdbzjhm));
		$("#qyba_frdblxfs").append(setNull(json.LQyjbxx[0].frdblxfs));
		$("#qyba_dwfzr").append(setNull(json.LQyjbxx[0].dwfzr));
		$("#qyba_dwfzrzjhm").append(setNull(json.LQyjbxx[0].dwfzrzjhm));
		$("#qyba_dwfzrlxfs").append(setNull(json.LQyjbxx[0].dwfzrlxfs));
		csbaxx_setDetail(); //备案详细信息
	}
	function csbaxx_updatediv(json){
		$("#qyba_csbabm").append(setNull(json.LQybaxx[0].qybabm));
		$("#qyba_babmmc").append(setNull(json.LQybaxx[0].babmmc));
		$("#qyba_barq").append(setNull(json.LQybaxx[0].barq));
		$("#qyba_bar").append(setNull(json.LQybaxx[0].bar));
		if(setNull(json.LQybaxx[0].sftjwz)=='1'){
			$("#sftjwz").attr("checked",true);
		}else{
			$("#sftjwz").attr("checked",false);
		}
		$("#sftjwz").attr("disabled","disabled");
		
		$("#qyba_bbgzrq").append(setNull(json.LQybaxx[1].bbgzrq));
		$("#qyba_bbwcrq").append(setNull(json.LQybaxx[1].bbwcrq));
		$("#qyba_bbyy").append(setNull(json.LQybaxx[1].bbyy));
		
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
</script>
<input type="hidden" id="h_qyid" value="">
<input type="hidden" id="h_qybaxxid" value="">
<input type="hidden" id="q_qyid" value="">
<input type="hidden" id="q_qybaxxid" value="">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1" id="td_qybaxxtjTitle">企业备案详细信息</td>
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
                <td  class="detailtd2"><span id="qyba_hylb"></span></td>
                 <td width="13%" class="distd1">管辖单位</td>
                <td class="detailtd2"><span id="qyba_gxdwmc"></span></td>
              </tr>
              <tr>
                <td width="13%" class="distd1" id="td_qyfl_zhu">企业分类（主）</td>
                <td width="20%" class="detailtd2"><span id="qyba_cszflmc"></span></td>
                	 <td class="distd1" id="qyflf">企业分类（副）</td>
               				 <td colspan="3" id="qyflf2" class="detailtd2"><span id="qyba_csfflmc"></span></td>
               
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
		        <td width="13%" class="distd1" id="td_qybm_detail">企业编码</td>
		        <td width="20%" class="detailtd2"><span id="qyba_csbm"></span></td>
		        <td width="13%" class="distd1" id="td_qymc_detail">企业名称</td>
		        <td width="20%" class="detailtd2"><span id="qyba_csmc"></span></td>
		        <td width="13%" class="distd1">经济类型</td>
		        <td width="20%" class="detailtd2"><span id="qyba_jjlxmc"></span></td>
		      </tr>
		      <tr>
		        <td class="distd1">联系电话</td>
		        <td class="detailtd2"><span id="qyba_lxdh"></span></td>
		        <td class="distd1">经营地址</td>
		        <td class="detailtd2" colspan="3"><span id="qyba_jydz"></span></td>
		        </tr>
		      <tr>
		        <td class="distd1">注册资金（万）</td>
		        <td class="detailtd2"><span id="qyba_zczj"></span></td>
		        <td class="distd1">经营范围（主营）</td>
		        <td class="detailtd2" colspan="3"><span id="qyba_jyfwzy"></span></td>
		      </tr>
		      <tr>
		        <td class="distd1">经营面积（㎡）</td>
		        <td class="detailtd2"><span id="qyba_jymj"></span></td>
		        <td class="distd1">经营范围（兼）</td>
		        <td class="detailtd2" colspan="3"><span id="qyba_jyfwjy"></span></td>
		      </tr>
		      <tr>
		        <td class="distd1">法定代表人</td>
		        <td class="detailtd2"><span id="qyba_frdb"></span></td>
		        <td class="distd1">法人证件类型</td>
		        <td class="detailtd2"><span id="qyba_frdbzjlb"></span></td>
		        <td class="distd1">法人证件号码</td>
		        <td class="detailtd2"><span id="qyba_frdbzjhm"></span></td>
		      </tr>
		      <tr>
		        <td class="distd1">法人联系方式</td>
		        <td class="detailtd2"><span id="qyba_frdblxfs"></span></td>
		        <td class="distd1">单位负责人</td>
		        <td class="detailtd2"><span id="qyba_dwfzr"></span></td>
		        <td class="distd1">负责人公民身份号码</td>
		        <td class="detailtd2"><span id="qyba_dwfzrzjhm"></span></td>
		      </tr>
              <tr>
		        <td class="distd1">负责人联系方式</td>
		        <td colspan="5" class="detailtd2"><span id="qyba_dwfzrlxfs"></span></td>
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
				<table width="100%" border="0" cellspacing="0" cellpadding="2" class="detail">
				      <tr>
				        <td width="13%" class="distd1">备案编号</td>
				        <td width="20%" class="detailtd2"><span id="qyba_csbabm"></span></td>
				        <td width="13%" class="distd1">备案机构</td>
				        <td class="detailtd2"><span id="qyba_babmmc"></td>
			          </tr>
				      <tr>
				        <td class="distd1">备案日期</td>
				        <td class="detailtd2"><span id="qyba_barq"></span></td>
				        <td class="distd1">备案人</td>
				        <td class="detailtd2"><span id="qyba_bar"></span></td>
			          </tr>
                      <tr>
				        <td colspan="4" class="detailtd2">
				        <div style="width:100%" id=tjclxx></div>
				        </td>
		              </tr>
                      <tr>
				      <td class="distd1">
				          <input type="checkbox" name="checkbox" id="sftjwz" style="width:12"/></td>
			            <td colspan="3" class="detailtd2">备案信息提交完整</td>
		              </tr>
                      <tr>
				        <td class="distd1">补备告知日期</td>
				        <td class="detailtd2"><span id="qyba_bbgzrq"></span></td>
				        <td class="distd1">补备完成日期</td>
				        <td class="detailtd2"><span id="qyba_bbwcrq"></span></td>
			          </tr>
                      <tr>
				        <td class="distd1">补备原因</td>
				        <td colspan="3" class="detailtd2"><span id="qyba_bbyy"></span></td>
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
	