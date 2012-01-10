<%@ page language="java" pageEncoding="UTF-8"%>

		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td class="queryfont">&nbsp;企业基本信息</td>
		  </tr>
		  <tr>
		    <td valign="top"  class="tdbg">
		    <table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
		      <tr height="25">
		        <td class="distd1" id="qymc_title">经营名称</td>
		        <td width="620px" class="detailtd2" colspan="3"><span id="qymc_"></span></td>
		        <td class="distd1" id="qybm_title">企业代码</td>
		        <td width="132px" class="detailtd2"><span id="qybm_"></span></td>
		      </tr>
		      <tr height="25">
		        <td class="distd1" id="jydz_title">经营地址</td>
		        <td width="620px" class="detailtd2" colspan="3" id="jydz_conte"><span id="jydz_"></span></td>
		        <td class="distd1" id="qyzzjgdm_title">组织机构代码</td>
		        <td width="132px" class="detailtd2"><span id="qyzzjgdm_"></span></td>
		      </tr>
		      <tr height="25">
		        <td class="distd1" id="jyfwzy_title">经营范围</td>
		        <td width="620px" class="detailtd2" colspan="3"><span id="jyfwzy_"></span></td>
		        <td class="distd1" id="lxdh_title">联系电话</td>
		        <td width="132px" class="detailtd2"><span id="lxdh_"></span></td>
		      </tr>
		      <tr height="25">
		        <td width="12%" class="distd1" id="chzh_title">传真</td>
		        <td width="14%" class="detailtd2"><span width="132px" id="chzh_"></span></td>
		        <td width="20%"class="distd1" id="yzbm_title">邮政编码</td>
		        <td width="20%" class="detailtd2"><span width="132px" id="yzbm_"></span></td>
		        <td width="11%" class="distd1" id="kyrq_title">开业日期</td>
		        <td width="15%" class="detailtd2"><span width="132px" id="kyrq_"></span></td>
		      </tr>
		      <tr height="25">
		        <td  class="distd1" id="jjlxmc_title">经济类型</td>
		        <td  class="detailtd2"><span width="132px" id="jjlxmc_"></span></td>
		        <td class="distd1" id="jymj_title">占地面积（平米）</td>
		        <td width="132px" id="jymj_conte" class="detailtd2"><span id="jymj_"></span></td>
		      	<td class="distd1" id="zczj_title">注册资金（万元）</td>
		        <td width="132px" class="detailtd2"><span id="zczj_"></span></td>
		      </tr>
		      <tr height="25">
		        <td class="distd1" id="frdb_title">法定代表人</td>
		        <td width="132px" class="detailtd2"><span id="frdb_"></span></td>
		        <td class="distd1" id="frdbzjlb_title">法人证件类型</td>
		        <td width="132px" class="detailtd2"><span id="frdbzjlb_"></span></td>
		        <td class="distd1" id="frdbzjhm_title">法人证件号码</td>
		        <td width="132px" class="detailtd2"><span id="frdbzjhm_"></span></td>
		      </tr>
		      <tr height="25">
		        <td class="distd1" id="frdblxfs_title">法人联系方式</td>
		        <td width="132px" class="detailtd2" id="frdblxfs_conte"><span id="frdblxfs_"></span></td>
		        <td class="distd1" id="thbajg_title">特行备案管理机构</td>
		        <td class="detailtd2" width="132px"><span id="thbajg_"></span></td>
		        <td class="distd1" id="yyzzZjbh_title">营业执照编号</td>
		        <td width="132px" class="detailtd2"><span id="yyzzZjbh_"></span></td>
		      </tr>
		      <tr height="25">
		        <td class="distd1" id="yyzzFzjg_title">营业执照发证机关</td>
		        <td width="132px" class="detailtd2"><span id="yyzzFzjg_"></span></td>
		        <td class="distd1" id="djrq_title">营业执照发证日期</td>
		        <td width="132px" class="detailtd2"><span id="djrq_"></span></td>
		        <td class="distd1" id="swdjZjbh_title">税务登记证编号</td>
		        <td width="132px" class="detailtd2" id="swdjZjbh_conte"><span id="swdjZjbh_"></span></td>
		      </tr>
		      <tr height="25">
		        <td class="zhehangtd" id="swdjFzjg_title">税务登记证发证机关</td>
		        <td width="132px" class="detailtd2" id="swdjFzjg_conte"><span id="swdjFzjg_"></span></td>
		        <td class="distd1" id="jyxkZjbh_title">经营许可证编号</td>
		        <td width="132px" class="detailtd2" id="jyxkZjbh_conte"><span id="jyxkZjbh_"></span></td>
		        <td class="zhehangtd" id="jyxkFzjg_title">经营许可证发证机关</td>
		        <td width="132px" class="detailtd2" id="jyxkFzjg_conte"><span id="jyxkFzjg_"></span></td>
		      </tr>
		      <tr height="25">
		        <td class="distd1" id="dwfzr_title">经营负责人</td>
		        <td width="132px" class="detailtd2"><span id="dwfzr_"></span></td>
		        <td class="distd1" id="dwfzrzjhm_title">经营负责人身份证号</td>
		        <td width="132px" class="detailtd2"><span id="dwfzrzjhm_"></span></td>
		        <td class="distd1" id="dwfzrlxfs_title">经营负责人联系方式</td>
		        <td class="detailtd2" width="132px"><span id="dwfzrlxfs_"></span></td>
		      </tr>
		      <tr height="25">
		        <td class="distd1" id="bafzrxm_title">治安负责人</td>
		        <td class="detailtd2" width="132px"><span id="bafzrxm_"></span></td>
		        <td class="distd1" id="bafzrgmsfhm_title">治安负责人身份证号</td>
		        <td class="detailtd2" width="132px"><span id="bafzrgmsfhm_"></span></td>
		        <td class="distd1" id="bafzrdh_title">治安负责人联系方式</td>
		        <td class="detailtd2" width="132px"><span id="bafzrdh_"></span></td>
		      </tr>
		    <tr>
		        <td class="distd1" id="bz_title">备注</td>
			    <td colspan="5" class="detailtd2" width="582px"><span id="bz_"></span></td>
		    </tr>
		    </table></td>
		  </tr>
		</table>