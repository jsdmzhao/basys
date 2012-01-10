<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#a_zdskb").attr("value",zdskb); //最低刷卡比
		
		//$("#bq_hylb").selectBoxhylb({code:"dm_hylb",width:"115px"});
		$("#bq_frdbzj").selectBox({code:"dm_frdbzjlb(ylcs)",width:"115px"});
		$("#bq_frdbzj").setValue("111",115);//默认赋值
		$("#bq_frdbzj").setText("居民身份证",115);//默认赋值
		
		$("#bq_zjzt").selectBox({code:"dm_yyzt",width:"115px"});
		$("#bq_zjzt").setValue("3",115);//默认赋值
		$("#bq_zjzt").setText("未装机开业",115);//默认赋值
		//$("#bq_ylcsfl").selectBox({state:"1",width:"115px"}); //动态
		$("#bq_yyzt").selectBox({code:"dm_yyzt(bzhylcs)",width:"115px"});
		$("#bq_zajb").selectBox({code:"dm_zajb(bzhylcs)",width:"115px"});
		
		$("#a_thbajg").click(function(){ //特行备案机构
			getGxdw("a_thbajg","a_thbajgdm");
		});
		$("#a_jjlxmc").click(function(){ //经济类型筛选
			getDict_item("a_jjlxmc","a_jjlxbm","dm_jjlx");
		});
		frdbzjOnchange();
		zjztOnchange();
		zajbOnchange();
		yyztOnchange();
		$("#a_kyrq").attr("readonly","true").datepicker();
		$("#a_barq").attr("readonly","true");
		$("#a_yyzzQsrq").attr("readonly","true").datepicker();
		$("#a_yyzzJzrq").attr("readonly","true").datepicker();
		$("#a_jyxkQsrq").attr("readonly","true").datepicker();
		$("#a_jyxkJzrq").attr("readonly","true").datepicker();
		$("#a_thxkQsrq").attr("readonly","true").datepicker();
		$("#a_thxkJzrq").attr("readonly","true").datepicker();
		$("#a_swdjQsrq").attr("readonly","true").datepicker();
		$("#a_swdjJzrq").attr("readonly","true").datepicker();
		$("#a_tyrq").attr("readonly","true").datepicker();
		$("#a_djrq").attr("readonly","true").datepicker();
	});
</script>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td class="queryfont">基本信息</td>
		  </tr>
		  <tr>
		    <td valign="top"  class="tdbg"><table width="100%" border="0" cellspacing="0" cellpadding="1">
		      <tr id="qyjbxxTr1">
		        <td class="red">场所备案编号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" id="a_qybm" readonly class="readonly"/></td>
		        <td class="red">场所名称</td>
		        <td class="pagetd1" colspan="3"><input style="width:370px" type="text" class="inputstyle3" id="a_qymc"/></td>
		        <td class="red">企业组织机构代码</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_qyzzjgdm" maxlength="9"
		        		onkeyup="htjdOnkeyupVal('a_qyzzjgdm','jyxk');" onblur="htjdOnBlurNotOnlyZfVal('a_qyzzjgdm','jyxk','0','‘组织机构编码’','1','0');"/></td>
		      </tr>
		      <tr id="qyjbxxTr2">
		        <td width="11%" class="red">联系电话</td>
		        <td width="14%" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_lxdh"/></td>
		        <td id="yzbm_title" width="11%" class="pagedistd1">邮政编码</td>
		        <td id="yzbm_conte" width="14%" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_yzbm" maxlength="6" onkeyup="value=value.replace(/[^\d]/g,'')"/></td>
		        <td width="11%" class="pagedistd1">传真</td>
		        <td width="14%" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_chzh"/></td>
		        <td id="jjlx_title" width="11%" class="pagedistd1">经济类型</td>
		        <td id="jjlx_conte" width="14%" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_jjlxmc" readonly/></td>
		      </tr>
		      <tr id="qyjbxxTr3">
		      	<td class="red">注册资金（万）</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_zczj"/></td>
		        <td class="red">经营范围（主营）</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_jyfwzy"/></td>
		        <td id="jyfwjy_title" class="pagedistd1">经营范围（兼营）</td>
		        <td id="jyfwjy_conte" class="pagetd1" colspan="3"><input style="width:370px" type="text" class="inputstyle3" id="a_jyfwjy"/></td>
		      </tr>
		      <tr id="qyjbxxTr4">
		        <td id="jymj_title" class="red">经营面积（㎡）</td>
		        <td id="jymj_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_jymj"/></td>
		        <td id="yyzt_title" class="red">场所状态</td>
		        <td id="yyzt_conte" class="pagetd1"><select name="select3" id="bq_yyzt" onchange="yyztOnchange();"></select></td>
		        <td id="jydz_title" class="red">经营地址</td>
		        <td id="jydz_conte" class="pagetd1" colspan="3"><input style="width:370px" type="text" class="inputstyle3" id="a_jydz"/></td>
		      </tr>
		      <tr id="qyjbxxTr5">
		        <td class="red">法定代表人姓名</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_frdb"
		        	onkeyup="htjdOnkeyupVal('a_frdb','xingming');" onblur="htjdOnBlurNotOnlyZfVal('a_frdb','xingming','0','‘法定代表人’','1','0');"/></td>
		        <td class="red">法人证件类型</td>
		        <td class="pagetd1"><select name="select4" id="bq_frdbzj" onchange="frdbzjOnchange();"></select></td>
		        <td class="red">法人证件号码</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_frdbzjhm"/></td>
		        <td id="frlxfs_title" class="red">法人联系方式</td>
		        <td id="frlxfs_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_frdblxfs"/></td>
		      </tr>
		      <tr id="qyjbxxTr6">
		        <td class="red">开业日期</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_kyrq"/></td>
		        <td id="yysj_title" class="pagedistd1">营业时间</td>
		        <td id="yysj_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_yysj"/></td>
		      <!--   <td id="barq_title" class="pagedistd1">备案日期</td>
		        <td id="barq_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_barq"/></td>--> 
		        <td class="red" id="zjzt_title" valign="top">装机状态</td>
		        <td class="pagetd1" id="zjzt_content" valign="top"><select name="select3" id="bq_zjzt" onchange="zjztOnchange();"></select></td>
		         <td class="red">单位负责人</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_dwfzr"
		        	onkeyup="htjdOnkeyupVal('a_dwfzr','xingming');" onblur="htjdOnBlurNotOnlyZfVal('a_dwfzr','xingming','0','‘单位负责人’','1','0');"/></td>
		      </tr>
		      <tr id="qyjbxxTr7">
		       
		        <td class="red">负责人<br>公民身份号码</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_dwfzrzjhm"/></td>
		        <td class="red">负责人联系方式</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_dwfzrlxfs"/></td>
		        <td id="zadj_title" class="red">服务场所治安级别</td>
		        <td id="zadj_conte" class="pagetd1"><select name="select2" id="bq_zajb" onchange="zajbOnchange();"></select></td>
		         <td class="pagedistd1">营业执照编号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_yyzzZjbh"/></td>
		      </tr>
		      <tr id="qyjbxxTr8">
		        <td class="pagedistd1" id="djrq_title" valign="top">营业执照登记日期</td>
		        <td class="pagetd1" id="djrq_content" valign="top"><input style="width:120px" type="text" class="inputstyle3" id="a_djrq"/></td>
		        <td class="pagedistd1">营业执照发证机构</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_yyzzFzjg"
		        	onkeyup="htjdOnkeyupVal('a_yyzzFzjg','zhongwen');"/></td>
		        <td id="yyzzqsrq_title" class="pagedistd1">营业执照起始日期</td>
		        <td id="yyzzqsrq_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_yyzzQsrq"/></td>
		        <td id="yyzzjzrq_title" class="pagedistd1">营业执照截止日期</td>
		        <td id="yyzzjzrq_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_yyzzJzrq"/></td>
		      </tr>
		       
		      <tr id="qyjbxxTr9" style="display:none">
		        <td id="swdjzbh_title" class="red">税务登记证编号</td>
		        <td id="swdjzbh_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_swdjZjbh"/></td>
		        <td id="swdjfzjg_title" class="red"><label id="swdjfzjg_title"></label></td>
		        <td id="swdjfzjg_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_swdjFzjg"
		        	onkeyup="htjdOnkeyupVal('a_swdjFzjg','zhongwen');"/></td>
		        <td id="swdjqsrq_title" class="red">税务登记证起始日期</td>
		        <td id="swdjqsrq_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_swdjQsrq"/></td>
		        <td id="swdjjzrq_title" class="red">税务登记证截止日期</td>
		        <td id="swdjjzrq_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_swdjJzrq"/></td>
		      </tr>
		      
		      <tr id="qyjbxxTr10">
		        <td id="jyxk_bh_" class="red">经营许可证号</td>
		        <td id="jyxk_bhConte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_jyxkZjbh"/></td>
		        <td id="jyxk_fzjg_" class="red">经营许可证<br>发证机关</td>
		        <td id="jyxk_fzjgConte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_jyxkFzjg"
		        	onkeyup="htjdOnkeyupVal('a_jyxkFzjg','zhongwen');"/></td>
		        <td id="jyxk_qsrq" class="pagedistd1">经营许可证起始日期</td>
		        <td id="jyxk_qsrq_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_jyxkQsrq"/></td>
		        <td id="jyxk_jzrq" class="pagedistd1">经营许可证截止日期</td>
		        <td id="jyxk_jzrq_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_jyxkJzrq"/></td>
		      </tr>
		      
		      <tr id="thxx_" style="display:none">
		        <td id="thxk_bh" class="red">特行许可证编号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_thxkZjbh"/></td>
		        <td id="thxk_fzjg" class="red">特行许可证发证机关</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_thxkFzjg"
		        	onkeyup="htjdOnkeyupVal('a_thxkFzjg','zhongwen');"/></td>
		        <td id="thxk_qsrq" class="red">特行许可证起始日期</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_thxkQsrq"/></td>
		        <td id="thxk_jzrq" class="red">特行许可证截止日期</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_thxkJzrq"/></td>
		      </tr>
		      
		      <tr id="xfxx_">
		        <td id="xf_hgzh" class="red">消防合格证号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_xfhgzh"/></td>
		        <td id="xf_dw" class="red">消防审核单位</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_xfshdw"
		        	onkeyup="htjdOnkeyupVal('a_xfshdw','zhongwen');"/></td>
		        <td class="pagedistd1">经纬度坐标</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle3"  id="a_jwdzb"/></td>
		        <td class="pagedistd1" style="display: none;">机器编码</td>
		        <td class="pagetd1" style="display: none;"><input style="width:120px" type="text" class="inputstyle3"  id="a_jqbm"/></td>
		         <td class="pagedistd1" id="zdskb_title" valign="top">最低刷卡比</td>
		        <td class="pagetd1" id="zdskb_content" valign="top"><input style="width:120px" type="text" class="inputstyle3" id="a_zdskb"/></td>
		      </tr>
		      <tr id="qyjbxxTr13" style="display: none;">
		       
		       
			  </tr>
			  <tr>
				<td id="gdxx_title" class="pagedistd1">个人股东及投资单位</td>
				<td id="gdxx_conte" colspan="7" class="pagetd1"><textarea name="textarea" id="a_gdxx" cols="106" rows="2"></textarea></td>
			  </tr>
			  <tr id="qyjbxxTr14"></tr>
			  <tr id="qyjbxxTrLinshi1" style="display:none">
			      <td id="thbajg_title" class="pagedistd1">特行备案机构</td>
			      <td id="thbajg_conte" class="pagetd1"><input type="hidden" id="a_thbajgdm"/>
			      <input style="width:120px" type="text" class="inputstyle3" id="a_thbajg" readonly/></td>
			      <td id="jyxkzfzjgdm_title" class="red">经营许可证<br>发证机构代码</td>
			      <td id="jyxkzfzjgdm_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_jyxkFzjgdm"/></td>
		      </tr>
		      <tr id="qyjbxxTrLinshi2" style="display:none">
			      <td id="bwbmdh_title" class="red">保卫部门电话</td>
			      <td id="bwbmdh_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_bwbmdh"/></td>
			      <td id="sfazsxt_title" class="red">是否安装摄像头</td>
			      <td id="sfazsxt_conte" class="pagetd1"><select id="a_sfazsxt"><option></option></select></td>
			      <td id="azsxtsl_title" class="pagedistd1">摄像头数量</td>
			      <td id="azsxtsl_conte" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_azsxtsl"/></td>
		      </tr>
		    </table></td>
		  </tr>
		</table>	
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
		  <tr>
		    <td id="ryjqt_title" class="queryfont">&nbsp;人员及其他信息</td>
		  </tr>
		  <tr>
		    <td class="tdbg">
			    <table width="100%" border="0" cellspacing="0" cellpadding="1">
			      <tr id="ryxxTr1">
			        <td id="zrs_title" width="11%" class="pagedistd1">总人数</td>
			        <td id="zrs_conte" width="14%" class="pagetd1"><input style="width:120px" type="text" id="a_zrs" value="" readonly class="readonly"/></td>
			        <td id="hdrs_title" width="11%" class="pagedistd1" id="hdrs_title">核定消费者数量</td>
			        <td id="hdrs_conte" width="14%" class="pagetd1"><input style="width:120px" type="text" class="inputstyle3" id="a_hdrs"/></td>
			        <td id="bafzr_title" width="11%" class="pagedistd1"><label id="bafzr_title">治安负责人</label></td>
			        <td id="bafzr_content" width="14%" class="pagetd1"><label id="bafzr_content"><input style="width:120px" type="text" class="inputstyle3" id="a_bafzrxm"
			        	onkeyup="htjdOnkeyupVal('a_bafzrxm','xingming');" onblur="htjdOnBlurNotOnlyZfVal('a_bafzrxm','xingming','0','‘治安负责人’','1','0');"/></label></td>
			        <td id="bars_title" width="11%" class="pagedistd1"><label id="bars_title">保安人数</label></td>
			        <td id="bars_content" width="14%" class="pagetd1"><label id="bars_content"><input style="width:120px" type="text" class="inputstyle3" id="a_bars"/></label></td>
			      </tr>
			      <tr id="ryxxTr2">
			        <td class="pagedistd1" id="jgpxrs_title">经岗位培训人数</td>
			        <td class="pagetd1" id="jgpxrs_content"><input style="width:120px" type="text" class="inputstyle3" id="a_jgpxrs"/></td>
			        <td class="red" width="11%" id="cksl_title"  >安全出口数量</td>
			        <td class="pagetd1" width="14%" id="cksl_content"  ><input style="width:120px" type="text" class="inputstyle3" id="a_cksl"/></td>
			        <td class="red" width="11%" id="bxbjsl_title"  >包厢包间数量(间)</td>
			        <td class="pagetd1" width="14%" id="bxbjsl_content"  ><input style="width:120px" type="text" class="inputstyle3" id="a_bxbjsl"/></td>
			      </tr>
			      <tr id="ryxxTr3">
			        <td id="bz_title" class="red">项目内容</td>
			        <td id="bz_conte" colspan="3" class="pagetd1"><textarea name="textarea" id="a_bz" cols="44" rows="2"></textarea></td>
			        <td id="bagsyj_title" class="pagedistd1">保安公司意见</td>
			        <td id="bagsyj_content" colspan="3" class="pagetd1"><textarea name="textarea" id="a_bagsyj" cols="44" rows="2"></textarea></td>
			      </tr>
			    </table>
		    </td>
		  </tr>
		</table>