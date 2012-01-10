<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="basicsystem/querylist_bdqclxxkz.action";
	divnid="BdqclxxkzData";
	tableid="BdqclxxkzTable";
	addUrl="basicsystem/insert_bdqclxxkz.action";
	addHtml="business/basicsystem/BdqclxxkzAdd.jsp";
	addWidth="800";
	delUrl="basicsystem/delete_bdqclxxkz.action";
	delid="d_bjxxid2";
	modHtml="business/basicsystem/BdqclxxkzModify.jsp";
	modUrl="basicsystem/modify_bdqclxxkz.action";
	modWidth="800";
	detailHtml="business/basicsystem/BdqclxxkzDetail.jsp";
	detailid="bdqclxxkz_detail";
	detailUrl="basicsystem/query_bdqclxxkz.action";
	detailWidth="800";
	loadPage(divnid);
		$("#p_ccdjrq").attr("readonly","true");
		$("#p_ccdjrq").datepicker();
		$("#p_lasj").attr("readonly","true");
		$("#p_lasj").datepicker();
		$("#p_slsj").attr("readonly","true");
		$("#p_slsj").datepicker();
		$("#p_tbsj3").attr("readonly","true");
		$("#p_tbsj3").datepicker();
		$("#p_lrsj").attr("readonly","true");
		$("#p_lrsj").datepicker();
		$("#p_xgsj").attr("readonly","true");
		$("#p_xgsj").datepicker();
	
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										url: url,	
										height: 250,
										pageNumber: pageno,
										colWidths: ["1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%","1%"]									
									});				
		}
}	
	function manVerify(){
		if (!checkControlValue("p_bjxxid2","Integer",-9999999999,9999999999,null,0,"报警信息ID"))
			return false;
		if (!checkControlValue("p_bdqclxxkzid","Integer",-9999999999,9999999999,null,0,"被盗抢车辆信息快照ID"))
			return false;
		if (!checkControlValue("p_id","String",1,46,null,0,"序号"))
			return false;
		if (!checkControlValue("p_cllxdm","String",1,10,null,0,"车辆类型代码"))
			return false;
		if (!checkControlValue("p_cllx","String",1,32,null,0,"车辆类型"))
			return false;
		if (!checkControlValue("p_clpp","String",1,64,null,0,"车辆品牌"))
			return false;
		if (!checkControlValue("p_clxh","String",1,64,null,0,"车辆型号"))
			return false;
		if (!checkControlValue("p_hpzldm","String",1,4,null,0,"号牌种类代码"))
			return false;
		if (!checkControlValue("p_hpzl","String",1,32,null,0,"号牌种类"))
			return false;
		if (!checkControlValue("p_hphm","String",1,32,null,0,"号牌号码"))
			return false;
		if (!checkControlValue("p_csys","String",1,32,null,0,"车身颜色"))
			return false;
		if (!checkControlValue("p_syr","String",1,512,null,0,"机动车所有人"))
			return false;
		if (!checkControlValue("p_ccdjrq","Date",null,null,null,0,"初次登记时间"))
			return false;
		if (!checkControlValue("p_fdjh","String",1,60,null,0,"发动机号"))
			return false;
		if (!checkControlValue("p_clsbdh","String",1,50,null,0,"车辆识别代号"))
			return false;
		if (!checkControlValue("p_cjh","String",1,50,null,0,"车架号"))
			return false;
		if (!checkControlValue("p_sfbx","String",1,4,null,0,"是否参加被盗抢险"))
			return false;
		if (!checkControlValue("p_bar","String",1,128,null,0,"报案人"))
			return false;
		if (!checkControlValue("p_ladwqhbm","String",1,20,null,0,"立案单位区划编码"))
			return false;
		if (!checkControlValue("p_ladwqh","String",1,24,null,0,"立案单位区划"))
			return false;
		if (!checkControlValue("p_ladwbm","String",1,20,null,0,"立案单位编码"))
			return false;
		if (!checkControlValue("p_ladwmc","String",1,100,null,0,"立案单位名称"))
			return false;
		if (!checkControlValue("p_lasj","Date",null,null,null,0,"立案时间"))
			return false;
		if (!checkControlValue("p_lajbr","String",1,128,null,0,"立案经办人"))
			return false;
		if (!checkControlValue("p_ladh","String",1,128,null,0,"立案单位联系电话"))
			return false;
		if (!checkControlValue("p_sldwqhbm","String",1,20,null,0,"受理单位区划编码"))
			return false;
		if (!checkControlValue("p_sldwqh","String",1,24,null,0,"受理单位区划"))
			return false;
		if (!checkControlValue("p_sldwbm","String",1,24,null,0,"受理单位编码"))
			return false;
		if (!checkControlValue("p_sldwmc","String",1,128,null,0,"受理单位名称"))
			return false;
		if (!checkControlValue("p_slsj","Date",null,null,null,0,"受理时间"))
			return false;
		if (!checkControlValue("p_sljbr","String",1,128,null,0,"受理经办人"))
			return false;
		if (!checkControlValue("p_sldh","String",1,128,null,0,"受理单位联系电话"))
			return false;
		if (!checkControlValue("p_bz","String",1,2000,null,0,"备注"))
			return false;
		if (!checkControlValue("p_tbdwqhbm","String",1,24,null,0,"填报单位区划编码"))
			return false;
		if (!checkControlValue("p_tbdwqh","String",1,24,null,0,"填报单位区划"))
			return false;
		if (!checkControlValue("p_tbdwbm","String",1,24,null,0,"填报单位编码"))
			return false;
		if (!checkControlValue("p_tbdwmc","String",1,128,null,0,"填报单位名称"))
			return false;
		if (!checkControlValue("p_tbtbr","String",1,128,null,0,"填表人"))
			return false;
		if (!checkControlValue("p_tbsj3","Date",null,null,null,0,"填表时间"))
			return false;
		if (!checkControlValue("p_zt","String",1,2,null,0,"状态"))
			return false;
		if (!checkControlValue("p_scbz","Integer",-99,99,null,0,"删除标志"))
			return false;
		if (!checkControlValue("p_lrdwbm","String",1,20,null,0,"录入单位编码"))
			return false;
		if (!checkControlValue("p_lrdw","String",1,128,null,0,"录入单位"))
			return false;
		if (!checkControlValue("p_lrr","String",1,30,null,0,"录入人"))
			return false;
		if (!checkControlValue("p_lrsj","Date",null,null,null,0,"录入时间"))
			return false;
		if (!checkControlValue("p_xgdwbm","String",1,24,null,0,"修改单位编码"))
			return false;
		if (!checkControlValue("p_xgdw","String",1,128,null,0,"修改单位"))
			return false;
		if (!checkControlValue("p_xgr","String",1,128,null,0,"修改人"))
			return false;
		if (!checkControlValue("p_xgsj","Date",null,null,null,0,"修改时间"))
			return false;
		if (!checkControlValue("p_spr3","String",1,128,null,0,"审批人"))
			return false;
		if (!checkControlValue("p_spyj","String",1,512,null,0,"审批意见"))
			return false;
		if (!checkControlValue("p_sydwbm","String",1,24,null,0,"使用单位编码"))
			return false;
		if (!checkControlValue("p_sydw","String",1,128,null,0,"使用单位"))
			return false;
		return true;
	}
</script>

<body>
	
	<input type="hidden" id="d_bjxxid2" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">查询选项</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="10%" class="pagedistd">报警信息ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bjxxid2" value="0"></td>
					<td width="10%" class="pagedistd">被盗抢车辆信息快照ID</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bdqclxxkzid" value="0"></td>
					<td width="10%" class="pagedistd">序号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_id" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">车辆类型代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cllxdm" value=""></td>
					<td width="10%" class="pagedistd">车辆类型</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cllx" value=""></td>
					<td width="10%" class="pagedistd">车辆品牌</td>
					<td width="23%" class="pagetd"><input type="text" id="p_clpp" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">车辆型号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_clxh" value=""></td>
					<td width="10%" class="pagedistd">号牌种类代码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hpzldm" value=""></td>
					<td width="10%" class="pagedistd">号牌种类</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hpzl" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">号牌号码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_hphm" value=""></td>
					<td width="10%" class="pagedistd">车身颜色</td>
					<td width="23%" class="pagetd"><input type="text" id="p_csys" value=""></td>
					<td width="10%" class="pagedistd">机动车所有人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_syr" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">初次登记时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ccdjrq" value=""></td>
					<td width="10%" class="pagedistd">发动机号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_fdjh" value=""></td>
					<td width="10%" class="pagedistd">车辆识别代号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_clsbdh" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">车架号</td>
					<td width="23%" class="pagetd"><input type="text" id="p_cjh" value=""></td>
					<td width="10%" class="pagedistd">是否参加被盗抢险</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sfbx" value=""></td>
					<td width="10%" class="pagedistd">报案人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bar" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">立案单位区划编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ladwqhbm" value=""></td>
					<td width="10%" class="pagedistd">立案单位区划</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ladwqh" value=""></td>
					<td width="10%" class="pagedistd">立案单位编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ladwbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">立案单位名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ladwmc" value=""></td>
					<td width="10%" class="pagedistd">立案时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lasj" value=""></td>
					<td width="10%" class="pagedistd">立案经办人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lajbr" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">立案单位联系电话</td>
					<td width="23%" class="pagetd"><input type="text" id="p_ladh" value=""></td>
					<td width="10%" class="pagedistd">受理单位区划编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sldwqhbm" value=""></td>
					<td width="10%" class="pagedistd">受理单位区划</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sldwqh" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">受理单位编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sldwbm" value=""></td>
					<td width="10%" class="pagedistd">受理单位名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sldwmc" value=""></td>
					<td width="10%" class="pagedistd">受理时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_slsj" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">受理经办人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sljbr" value=""></td>
					<td width="10%" class="pagedistd">受理单位联系电话</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sldh" value=""></td>
					<td width="10%" class="pagedistd">备注</td>
					<td width="23%" class="pagetd"><input type="text" id="p_bz" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">填报单位区划编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tbdwqhbm" value=""></td>
					<td width="10%" class="pagedistd">填报单位区划</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tbdwqh" value=""></td>
					<td width="10%" class="pagedistd">填报单位编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tbdwbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">填报单位名称</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tbdwmc" value=""></td>
					<td width="10%" class="pagedistd">填表人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tbtbr" value=""></td>
					<td width="10%" class="pagedistd">填表时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_tbsj3" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">状态</td>
					<td width="23%" class="pagetd"><input type="text" id="p_zt" value=""></td>
					<td width="10%" class="pagedistd">删除标志</td>
					<td width="23%" class="pagetd"><input type="text" id="p_scbz" value="0"></td>
					<td width="10%" class="pagedistd">录入单位编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrdwbm" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">录入单位</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrdw" value=""></td>
					<td width="10%" class="pagedistd">录入人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrr" value=""></td>
					<td width="10%" class="pagedistd">录入时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_lrsj" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">修改单位编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xgdwbm" value=""></td>
					<td width="10%" class="pagedistd">修改单位</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xgdw" value=""></td>
					<td width="10%" class="pagedistd">修改人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xgr" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">修改时间</td>
					<td width="23%" class="pagetd"><input type="text" id="p_xgsj" value=""></td>
					<td width="10%" class="pagedistd">审批人</td>
					<td width="23%" class="pagetd"><input type="text" id="p_spr3" value=""></td>
					<td width="10%" class="pagedistd">审批意见</td>
					<td width="23%" class="pagetd"><input type="text" id="p_spyj" value=""></td>
				</tr>
				<tr>
					<td width="10%" class="pagedistd">使用单位编码</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sydwbm" value=""></td>
					<td width="10%" class="pagedistd">使用单位</td>
					<td width="23%" class="pagetd"><input type="text" id="p_sydw" value=""></td>
				</tr>
    		<tr>
    		  <td colspan="6">
    		  	<table  border="0" align="right"  cellpadding="2"  cellspacing="0">
    		    	<tr>
    		    	  <td width="50%" class="querybutton"><a href="#" class="querybuttonfont" id="querys" onclick="setPageList(1);">查询</a></td>
    		    	  <td width="50%" class="addbutton"><a href="#" class="addbutton" onclick='setAddPage()'>添加</a></td>
    		    	</tr>
    		  	</table>
    		  </td>
    		</tr>
    	</table>
    </td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="3"></td>
	</tr>
</table>
<div id="bdqclxxkz_detail" class="page-layout" src="#"
		style="top:180px; left:160px;">
</div>	

<div id="BdqclxxkzData" style="width:100%;">
	<table id="BdqclxxkzTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_bdqclxxkzid">被盗抢车辆信息快照ID</th>
	     	<th name="l_id">序号</th>
	     	<th name="l_cllxdm">车辆类型代码</th>
	     	<th name="l_cllx">车辆类型</th>
	     	<th name="l_clpp">车辆品牌</th>
	     	<th name="l_clxh">车辆型号</th>
	     	<th name="l_hpzldm">号牌种类代码</th>
	     	<th name="l_hpzl">号牌种类</th>
	     	<th name="l_hphm">号牌号码</th>
	     	<th name="l_csys">车身颜色</th>
	     	<th name="l_syr">机动车所有人</th>
	     	<th name="l_ccdjrq">初次登记时间</th>
	     	<th name="l_fdjh">发动机号</th>
	     	<th name="l_clsbdh">车辆识别代号</th>
	     	<th name="l_cjh">车架号</th>
	     	<th name="l_sfbx">是否参加被盗抢险</th>
	     	<th name="l_bar">报案人</th>
	     	<th name="l_ladwqhbm">立案单位区划编码</th>
	     	<th name="l_ladwqh">立案单位区划</th>
	     	<th name="l_ladwbm">立案单位编码</th>
	     	<th name="l_ladwmc">立案单位名称</th>
	     	<th name="l_lasj">立案时间</th>
	     	<th name="l_lajbr">立案经办人</th>
	     	<th name="l_ladh">立案单位联系电话</th>
	     	<th name="l_sldwqhbm">受理单位区划编码</th>
	     	<th name="l_sldwqh">受理单位区划</th>
	     	<th name="l_sldwbm">受理单位编码</th>
	     	<th name="l_sldwmc">受理单位名称</th>
	     	<th name="l_slsj">受理时间</th>
	     	<th name="l_sljbr">受理经办人</th>
	     	<th name="l_sldh">受理单位联系电话</th>
	     	<th name="l_bz">备注</th>
	     	<th name="l_tbdwqhbm">填报单位区划编码</th>
	     	<th name="l_tbdwqh">填报单位区划</th>
	     	<th name="l_tbdwbm">填报单位编码</th>
	     	<th name="l_tbdwmc">填报单位名称</th>
	     	<th name="l_tbtbr">填表人</th>
	     	<th name="l_tbsj3">填表时间</th>
	     	<th name="l_zt">状态</th>
	     	<th name="l_scbz">删除标志</th>
	     	<th name="l_lrdwbm">录入单位编码</th>
	     	<th name="l_lrdw">录入单位</th>
	     	<th name="l_lrr">录入人</th>
	     	<th name="l_lrsj">录入时间</th>
	     	<th name="l_xgdwbm">修改单位编码</th>
	     	<th name="l_xgdw">修改单位</th>
	     	<th name="l_xgr">修改人</th>
	     	<th name="l_xgsj">修改时间</th>
	     	<th name="l_spr3">审批人</th>
	     	<th name="l_spyj">审批意见</th>
	     	<th name="l_sydwbm">使用单位编码</th>
	     	<th name="l_sydw">使用单位</th>
				<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
</html>