<%@ page language="java" pageEncoding="UTF-8"%>

		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td class="queryfont">&nbsp;企业基本信息</td>
		  </tr>
		  <tr>
		    <td valign="top"  class="tdbg">
		    <table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
		      <tr height="25">
		        <td class="distd1" id="qymc_title">经营者名称</td>
		        <td width="132px" class="detailtd2"><span id="qymc_"></span></td>
		        <td class="distd1" id="jydz_title">经营地址</td>
		        <td width="132px" class="detailtd2" id="jydz_conte"><span id="jydz_"></span></td>
		        <td class="distd1" id="qybm_title">企业代码</td>
		        <td width="132px" class="detailtd2"><span id="qybm_"></span></td>
		      </tr>
		      <tr height="25">
		        <td class="distd1" id="sgscxfjjs_title">收购生产性废旧金属</td>
		        <td width="132px" class="detailtd2"><span id="sgscxfjjs_"></span></td>
		        <td class="distd1" id="jhltlxmc_title">旧货流通类型</td>
		        <td width="132px" class="detailtd2"><span id="jhltlxmc_"></span></td>
		        <td class="distd1" id="qyzzjgdm_title">组织机构代码</td>
		        <td width="132px" class="detailtd2"><span id="qyzzjgdm_"></span></td>
		      </tr>
		      <tr height="25">
		        <td class="distd1" id="jyfwzy_title">经营范围</td>
		        <td  class="detailtd2" colspan="3"><span width="490px" id="jyfwzy_"></span></td>
		        <td class="distd1" id="lxdh_title">联系电话</td>
		        <td width="132px" class="detailtd2"><span id="lxdh_"></span></td>
		      </tr>
		      <tr height="25">
		        <td width="12%" class="distd1" id="chzh_title">传真</td>
		        <td width="14%"  class="detailtd2"><span id="chzh_"></span></td>
		        <td width="20%" class="distd1" id="yzbm_title">邮政编码</td>
		        <td  width="20%" class="detailtd2"><span width="132px" id="yzbm_"></span></td>
		        <td  width="11%" class="distd1" id="kyrq_title">开业日期</td>
		        <td width="15%"  class="detailtd2"><span id="kyrq_"></span></td>
		      </tr>
		      <tr height="25">
		        <td class="distd1" id="jjlxmc_title">经济类型</td>
		        <td width="132px" class="detailtd2"><span id="jjlxmc_"></span></td>
		        <td class="distd1" id="jymj_title">经营面积（平米）</td>
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
		      <!-- 
		      <tr>
		        <td class="distd1" id="jyfwzy_title">经营范围（兼营）</td>
		        <td width="380px" class="detailtd2" colspan="3"><span id="jyfwzy_"></span></td>
		        <td class="distd1" id="yyztmc_title">营业状态</td>
		        <td width="132px" class="detailtd2" id="yyztmc_conte"><span id="yyztmc_"></span></td>
		         <td class="distd1" id="yysj_title">营业时间</td>
		        <td width="132px" class="detailtd2" id="yysj_conte"><span id="yysj_"></span></td>
		        <td class="distd1" id="barq_title">备案日期</td>
		        <td width="132px" class="detailtd2" id="barq_conte"><span id="barq_"></span></td>
		         <td class="distd1" id="yyzzQsrq_title">营业执照起始日期</td>
		        <td width="132px" class="detailtd2" id="yyzzQsrq_conte"><span id="yyzzQsrq_"></span></td>
		        <td class="distd1" id="yyzzJzrq_title">营业执照截止日期</td>
		        <td width="132px" class="detailtd2" id="yyzzJzrq_conte"><span id="yyzzJzrq_"></span></td>
		         <td class="distd1" id="dwfzrlxfs_title">负责人联系方式</td>
		        <td width="132px" class="detailtd2"><span id="dwfzrlxfs_"></span></td>
		        <td class="pagedistd1" id="zajbmc_title">治安等级</td>
		        <td width="132px" class="detailtd2" id="zajbmc_conte"><span id="zajbmc_"></span></td>
		          <td class="distd1" id="swdjQsrq_title">税务登记证起始日期</td>
		        <td width="132px" class="detailtd2" id="swdjQsrq_conte"><span id="swdjQsrq_"></span></td>
		        <td class="distd1" id="swdjJzrq_title">税务登记证截止日期</td>
		        <td width="132px" class="detailtd2" id="swdjJzrq_conte"><span id="swdjJzrq_"></span></td>
		        <td class="distd1" id="jyxkQsrq_title">经营许可证起始日期</td>
		        <td width="132px" class="detailtd2" id="jyxkQsrq_conte"><span id="jyxkQsrq_"></span></td>
		        <td class="distd1" id="jyxkJzrq_title">经营许可证截止日期</td>
		        <td width="132px" class="detailtd2" id="jyxkJzrq_conte"><span id="jyxkJzrq_"></span></td>
		      </tr>
		       -->
		      <tr>
		        <td class="distd1" id="frdblxfs_title">法人联系方式</td>
		        <td width="132px" class="detailtd2" id="frdblxfs_conte"><span id="frdblxfs_"></span></td>
		        <td class="distd1" id="babh_title">再生资源回收备案登记证号</td>
		        <td width="132px" class="detailtd2"><span id="babh_"></span></td>
		        <td class="distd1">再生资源回收备案<br>登记发证公安机关</td>
		        <td class="detailtd2" width="132px"><span id="thbajg_"></span></td>
		      </tr>
		      <tr height="25">
		        <td class="distd1" id="yyzzZjbh_title">营业执照编号</td>
		        <td width="132px" class="detailtd2"><span id="yyzzZjbh_"></span></td>
		        <td class="distd1" id="yyzzFzjg_title">营业执照发证机关</td>
		        <td width="132px" class="detailtd2"><span id="yyzzFzjg_"></span></td>
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
		        <td class="distd1">经营负责人联系方式</td>
		        <td class="detailtd2" width="132px"><span id="dwfzrlxfs_"></span></td>
		      </tr>
		      <tr height="25">
		        <td class="distd1">治安负责人</td>
		        <td class="detailtd2" width="132px"><span id="bafzrxm_"></span></td>
		        <td class="distd1">治安负责人身份证号</td>
		        <td class="detailtd2" width="132px"><span id="bafzrgmsfhm_"></span></td>
		        <td class="distd1">治安负责人联系方式</td>
		        <td class="detailtd2" width="132px"><span id="bafzrdh_"></span></td>
		      </tr>
		      <tr height="25">
		        <td class="distd1">年审日期</td>
		        <td colspan="5" class="detailtd2" width="582px"><span id="nsrq_"></span></td>
		    </tr>
		    <tr>
		        <td class="distd1">备注</td>
			    <td colspan="5" class="detailtd2" width="582px"><span id="bz_"></span></td>
		    </tr>
		      <!-- 
		      <tr>
		        <td class="distd1" id="thxkZjbh_title">特行许可证编号</td>
		        <td width="132px" class="detailtd2"><span id="thxkZjbh_"></span></td>
		        <td class="distd1" id="thxkFzjg_title">特行许可证发证机关</td>
		        <td width="132px" class="detailtd2"><span id="thxkFzjg_"></span></td>
		        <td class="distd1" id="thxkQsrq_title">特行许可证起始日期</td>
		        <td width="132px" class="detailtd2"><span id="thxkQsrq_"></span></td>
		        <td class="distd1" id="thxkJzrq_title">特行许可证截止日期</td>
		        <td width="132px" class="detailtd2"><span id="thxkJzrq_"></span></td>
		      </tr>
		      <tr>
		        <td class="distd1" id="xfhgzh_title">消防合格证号</td>
		        <td width="132px" class="detailtd2"><span id="xfhgzh_"></span></td>
		        <td class="distd1" id="xfshdw_title">消防审核单位</td>
		        <td width="132px" class="detailtd2"><span id="xfshdw_"></span></td>
		        <td class="distd1" id="jwdzb_title">经纬度坐标</td>
		        <td width="132px" class="detailtd2"><span id="jwdzb_"></span></td>
		        <td class="distd1" id="jqbm_title">机器编码</td>
		        <td width="132px" class="detailtd2"><span id="jqbm_"></span></td>
		      </tr>
		      <tr>
				<td id="gdxx_title" class="distd1">股东信息</td>
				<td id="gdxx_conte" colspan="7" width="870px" class="detailtd2"><span id="gdxx_"></span></td>
			  </tr>
			   -->
		    </table></td>
		  </tr>
		</table>
	<!-- 
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
		  <tr>
		    <td class="queryfont">&nbsp;人员及其他信息</td>
		  </tr>
		  <tr>
		    <td class="tdbg">
			    <table width="100%" border="0" cellspacing="0" cellpadding="3" class="detail">
			      <tr>
			        <td width="11%" class="distd1" id="zrs_title">总人数</td>
			        <td width="132px" width="132px" class="detailtd2" id="zrs_conte"><span id="zrs_"></span></td>
			        <td width="11%" class="distd1" id="hdrs_title">核定人数</td>
			        <td width="132px" width="132px" class="detailtd2" id="hdrs_conte"><span id="hdrs_"></span></td>
			        <td width="11%" class="distd1" id="bafzrxm_title">治安负责人</td>
			        <td width="132px" width="132px" class="detailtd2" id="bafzrxm_conte"><span id="bafzrxm_"></span></td>
			        <td width="11%" class="distd1"><label id="bars_title">保安人数</label></td>
			        <td width="132px" width="132px" class="detailtd2"><span id="bars_"></span></td>
			      </tr>
			      <tr>
			        <td class="distd1" id="jgpxrs_title">经岗位培训人数</td>
			        <td width="132px" class="detailtd2" id="jgpxrs_content"><span id="jgpxrs_"></span></td>
			        <td class="distd1" id="bagsyj_title">保安公司意见</td>
			        <td width="132px" class="detailtd2" id="bagsyj_content" colspan="3"><span id="bagsyj_"></span></td>
			      </tr>
			      <tr>
			        <td class="distd1" id="bz_title">备注</td>
			        <td colspan="7" width="870px" class="detailtd2" id="bz_conte"><span id="bz_"></span></td>
			      </tr>
			    </table>
		    </td>
		  </tr>
		</table>
 -->	