<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<HTML>
<script type="text/javascript">
	$(document).ready(function() {
		//$("#bq_hylb").selectBoxhylb({code:"ggmk",width:"118px"});
		$("#bq_ylcsfl").selectBox({state:"1",width:"118px"}); //动态
		$("#m_gxdwmc").click(function(){ //管辖单位
			getGxdw("m_gxdwmc","m_gxdwbm");
		});
		hyInit();
	});
	function qyjbxx_modifyVerify(){ //验证
		//企业基本信息验证开始
		var gxdw = "管辖单位";
		if(selHylb=="E01"||selHylb=="E02"||selHylb=="F01"||selHylb=="F02"){ //二手机、车 汽车出租、租赁
			gxdw = "治安管辖机构";
		}else if(selHylb=="C"){
			gxdw = "治安管理机构";
		}
		if (!checkControlValue("m_gxdwmc","String",1,60,null,1,gxdw))
			return false;
		if (!checkControlValue("bq_ylcsfl","Select",1,30,null,1,"企业主分类"))
			return false;
		
		if(selHylb=='J'){ //娱乐业初始
		} else if(selHylb=='C') { //机修业
			if(!qyjbxx_modifyVerify_jxy())
				return false;
		} else if(selHylb=='E01') { //二手车
			if(!qyjbxx_modifyVerify_esc())
				return false;
		} else if(selHylb=='E02') { //二手机
			if(!qyjbxx_modifyVerify_esj())
				return false;
		} else if(selHylb=='E04') { //废旧金属
			if(!qyjbxx_modifyVerify_fjjs())
				return false;
		} else if(selHylb=='F01') { //出租车
			if(!qyjbxx_modifyVerify_czc())
				return false;
		} else if(selHylb=='F02') { //汽车租赁
			if(!qyjbxx_modifyVerify_qczl())
				return false;
		} else if(selHylb=='B') { //印章行业
			if(!qyjbxx_modifyVerify_yzhy())
				return false;
		} else if(selHylb=='E03') { //典当业
			if(!qyjbxx_modifyVerify_ddy())
				return false;
		} else if(selHylb=='E07') { //典当业
			if(!qyjbxx_modifyVerify_wtjm())
				return false;
		} else if(selHylb=='C01') { //机动车拆解业
			if(!qyjbxx_modifyVerify_jdccj())
				return false;
		}
		return true;
	}
	function csflOnchange(){ //企业分类
		var csflkey = $("#bq_ylcsfl").attr("value");
		var csflval = $("#bq_ylcsfl").attr("title");
		$("#m_qyzflbm").attr("value",csflkey);
		$("#m_qyzflmc").attr("value",csflval);
	}
	function hylbOnchange(){ //修改默认添加隐藏域  - 修改的时候不改行业类别
		var key = $("#bq_hylb").attr("value");
		var val = $("#bq_hylb").attr("title");
		$("#m_hylbdm").attr("value",key);
		$("#m_hylb").attr("value",val);
	}
</script>
<BODY>
	<input type="hidden" id="m_qyid">
	<input type="hidden" id="m_hylbdm"/>
	<input type="hidden" id="m_hylb"/>
	<input type="hidden" id="m_qyzflbm"/>
	<input type="hidden" id="m_qyzflmc"/>
	<input type="hidden" id="m_qyfflbm"/>
	<input type="hidden" id="m_qyfflmc"/>
	<input type="hidden" id="m_gxdwbm"/>

	<table width="100%"  cellspacing="0" cellpadding="0" class="line" >
	<tr>
	<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="1">
			<tr>
		      	<td width="13%" class="red">行业类别</td>
		        <td width="17%" class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="tempHylb" readonly="readonly"/></td>
		        <td width="19%" class="red"><label id="gxdw_title"></label></td>
		        <td width="51%" class="pagetd1"><input  type="text" class="inputstyle1" id="m_gxdwmc" style="width:470px" readonly/></td>
			</tr>
			<tr id="hqZhuFuType">
		        <td class="red"><label id="qyorcs_title"></label>分类（主）</td>
		        <td class="pagetd1"><select name="select" id="bq_ylcsfl" onChange="csflOnchange();">
		        </select></td>
		        <td class="pagedistd1" id="yly_csffl_title" style="display:none"><label id="qyorcs_title"></label>分类（副）</td>
		        <td class="pagetd1" id="yly_csffl_content" style="display:none"><select name="select" id="bq_csffl"></select></td>
			</tr>
		</table>
		<div id="QyJibenxiangmu"></div>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" id="bgqyxx" style="DISPLAY: none">
		  <tr>
		    <td class="tdbg">
			    <table width="100%" border="0" cellspacing="0" cellpadding="1">
			      <tr>
			        <td id="bgyy_title" class="red" width="13%">变更原因</td>
			        <td id="bgyy_conte" colspan="3" class="pagetd1"><textarea name="textarea2" id="m_bgyy" cols="102" rows="1"></textarea></td>
			      </tr>
			    </table>
		    </td>
		  </tr>
		</table>
	</td>
	</tr>
	</table>
</BODY>
</HTML>