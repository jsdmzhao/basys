<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<HTML>
<script type="text/javascript">
	$(document).ready(function() {
		$("#bq_frdbzj").selectBox({code:"dm_frdbzjlb(ylcs)",width:"118px"});
		$("#bq_frdbzj").setValue(111);//居民身份证
		
		$("#a_thbajg").click(function(){ //特行备案机构
			getGxdw("a_thbajg","a_thbajgdm");
		});
		$("#a_jjlxmc").click(function(){ //经济类型筛选
			getDict_item("a_jjlxmc","a_jjlxbm","dm_jjlx");
		});
		
		$("#a_kyrq").attr("readonly","true").datepicker();
		$("#a_nsrq").attr("readonly","true").datepicker();
		
	});
	$("#a_frdbzjhm").blur(function(){
		var zjhmValue = $(this).val();
		var zjlxValue = $("#bq_frdbzj").val();
		if(zjlxValue=="111" || zjlxValue=="112"){
			if(!checkIdCardNo("a_frdbzjhm")){
				jAlert("“法人证件号码”不正确！","提示信息");
			}
		}
	});
	$("#a_dwfzrzjhm").blur(function(){//单位负责人身份证号
	    var sfzh = $("#a_dwfzrzjhm").val();
	    if(sfzh==''){
	        return true;
	    }
		var returnCardNo = checkIdCardNo("a_dwfzrzjhm");
		if(returnCardNo){
			
		}else{
			jAlert("单位负责人身份证号不正确","验证信息");
		}
	});
	$("#a_bafzrgmsfhm").blur(function(){//治安负责人身份证号
	    var sfzh = $("#a_bafzrgmsfhm").val();
	    if(sfzh==''){
	        return true;
	    }
		var returnCardNo = checkIdCardNo("a_bafzrgmsfhm");
		if(returnCardNo){
			
		}else{
			jAlert("治安负责人身份证号不正确","验证信息");
		}
	});
	
	function qyjbxx_addVerify_jdccj(){ //验证
		if (!checkControlValue("a_qymc","String",1,120,null,1,"企业名称"))
			return false;
		if (!checkControlValue("a_jydz","String",1,200,null,1,"企业地址"))
			return false;
		if (!htjdOnBlurNotOnlyZfVal('a_qyzzjgdm','jyxk','1','‘组织机构代码’','1','0')){
			return false;
		}
		if (!checkControlValue("a_jyfwzy","String",1,200,null,1,"经营范围"))
			return false;
		if (!checkControlValue("a_lxdh","String",1,30,null,1,"联系电话"))
			return false;
		if (!checkControlValue("a_chzh","String",1,30,null,0,"传真"))
			return false;
		if (!checkControlValue("a_yzbm","String",1,6,null,0,"邮政编码")) //4.27 罗波提 所有非必填
			return false;
		if (!checkControlValue("a_kyrq","Date",null,null,null,1,"开业日期"))
			return false;
		if (!checkControlValue("a_jjlxmc","String",1,100,null,1,"经济类型"))
			return false;
		if (!checkControlValue("a_jymj","Float",-99999999.99,99999999.99,2,0,"占地面积"))
			return false;
		if (!checkControlValue("a_zczj","Float",-99999999.99,99999999.99,2,0,"注册资金"))
			return false;
		if (!checkControlValue("a_frdb","String",1,30,null,1,"法定代表人"))
			return false;
		if (!checkControlValue("a_frdbzjhm","String",1,30,null,1,"法人证件号码"))
			return false;
		if (!checkControlValue("a_frdblxfs","String",1,30,null,1,"法人联系方式"))
			return false;
		if (!checkControlValue("a_thbajg","String",1,60,null,1,"特行备案管理机构"))
			return false;
		if (!checkControlValue("a_yyzzZjbh","String",1,60,null,0,"营业执照编号"))
			return false;
		if (!checkControlValue("a_yyzzFzjg","String",1,60,null,0,"营业执照发证机关"))
			return false;	
		if (!checkControlValue("a_swdjZjbh","String",1,60,null,0,"税务登记证编号"))
			return false;
		if (!checkControlValue("a_swdjFzjg","String",1,60,null,0,"税务登记证发证机关"))
			return false;	
		if (!checkControlValue("a_jyxkZjbh","String",1,60,null,0,"经营许可证号"))
			return false;
		if (!checkControlValue("a_jyxkFzjg","String",1,60,null,0,"经营许可证发证机关"))
			return false;	
		if (!checkControlValue("a_dwfzr","String",1,30,null,1,"单位负责人"))
			return false;
		if (!checkControlValue("a_dwfzrzjhm","String",1,30,null,1,"单位负责人身份证号"))
			return false;
		if (!checkControlValue("a_dwfzrlxfs","String",1,30,null,1,"单位负责人联系方式"))
			return false;
		if (!checkControlValue("a_bafzrxm","String",1,30,null,1,"治安负责人"))
			return false;
		if (!checkControlValue("a_bafzrgmsfhm","String",1,30,null,1,"治安负责人身份证号"))
			return false;
		if (!checkControlValue("a_bafzrdh","String",1,30,null,1,"治安负责人联系方式"))
			return false;
		if (!checkControlValue("a_bz","String",1,2000,null,0,"备注"))
			return false;

		valadateYyzz();
		if(!canCommit)
			return false;
		return true;
	}
	function valadateYyzz(){ //营业执照编号
		var yyzzZjbh = $("#a_yyzzZjbh").attr("value");
		if(yyzzZjbh==''){
			//canCommit=false;
			//jAlert('请正确输入营业执照编号!','验证信息',null,'a_yyzzZjbh');
			return;
		}
		setParams("a_");
		var sUrl="publicsystem/valadateYyzz_qyjbxx.action";
		jQuery.ajax({
			type: 'POST',
			url: sUrl,
			data: params,
			async: false,
			dataType: 'json',
			success: function(result){						
				var rows  = eval(result);
				valadateYyzzBack(rows);
			}
		});
	}
	function valadateYyzzBack(json){
		if(json.result=="success"){
			if(json.valiResult=="1"){
				jAlert('此营业执照编号已存在!','验证信息',null,'a_yyzzZjbh');
				canCommit=false;
			}else{
				canCommit=true;
			}
		}else{
			jAlert('error!','提示信息');
			canCommit=false;
		}
	}
	var canCommit = true;
	
	function frdbzjOnchange(){ //法人证件类型
		var frdbzjlbkey = $("#bq_frdbzj").attr("value");
		var frdbzjlbval = $("#bq_frdbzj").attr("title");
		$("#a_frdbzjlb").attr("value",frdbzjlbval);
	}
	function zajbOnchange(){ //治安等级
		var zajbkey = $("#bq_zajb").attr("value");
		var zajbval = $("#bq_zajb").attr("title");
		$("#a_zabdm").attr("value",zajbkey);
		$("#a_zajbmc").attr("value",zajbval);
	}
	function yyztOnchange(){ // 营业状态
		var yyztkey = $("#bq_yyzt").attr("value");
		var yyztval = $("#bq_yyzt").attr("title");
		$("#a_yyztdm").attr("value",yyztkey);
		$("#a_yyztmc").attr("value",yyztval);
	}
	 
</script>
<BODY>

<input type="hidden" id="a_frdbzjlb"/>
<input type="hidden" id="a_jjlxbm"/>

<input type="hidden" id="a_yyztdm"/>
<input type="hidden" id="a_yyztmc"/>
<input type="hidden" id="a_zabdm"/>
<input type="hidden" id="a_zajbmc"/>

	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr><td class="queryfont">企业基本信息</td></tr>
		<tr>
		<td valign="top" class="tdbg">
			<table width="100%" border="0" cellspacing="0" cellpadding="1">
			<tr height="25">
			    <td class="red">企业名称</td>
		        <td class="pagetd1" colspan="3"><input style="width:490px" type="text" class="inputstyle1" id="a_qymc"/></td>
		        <td class="pagedistd1">企业代码</td>
				<td class="pagetd1"><input style="width:120px" type="text" class="readonly" id="a_qybm" readonly/></td>
			</tr>
			<tr height="25">
			    <td class="red">企业地址</td>
		        <td class="pagetd1" colspan="3"><input style="width:490px" type="text" class="inputstyle1" id="a_jydz"/></td>
			    <td class="pagedistd1">组织机构代码</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_qyzzjgdm" maxlength="9"
					onkeyup="htjdOnkeyupVal('a_qyzzjgdm','jyxk');" onBlur="htjdOnBlurNotOnlyZfVal('a_qyzzjgdm','jyxk','0','‘组织机构编码’','1','0');"/></td>
			</tr>
			<tr height="25">
			    <td class="red">经营范围</td>
		        <td class="pagetd1" colspan="3"><input style="width:490px" type="text" class="inputstyle1" id="a_jyfwzy"/></td>
		        <td class="red" >联系电话</td>
	          <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_lxdh"/></td>
			</tr height="25">
			<tr height="25">
			    <td class="pagedistd1" width="12%">传真</td>
				<td class="pagetd1" width="14%"><input style="width:120px" type="text" class="inputstyle1" id="a_chzh"/></td>
		        <td class="pagedistd1" width="20%">邮政编码</td>
	          <td class="pagetd1" width="20%"><input style="width:120px" type="text" class="inputstyle1" id="a_yzbm" maxlength="6" onKeyUp="value=value.replace(/[^\d]/g,'')"/></td>
		        <td class="red" width="11%">开业日期</td>
		        <td class="pagetd1" width="15%"><input style="width:120px" type="text" class="inputstyle1" id="a_kyrq"/></td>
           	  </tr>
			<tr height="25">
				<td class="red">经济类型</td>
		        <td class="pagetd1" ><input style="width:120px" type="text" class="inputstyle1" id="a_jjlxmc" readonly/></td>
			    <td class="pagedistd1">占地面积（平米）</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_jymj"/></td>
		        <td class="pagedistd1">注册资金（万元）</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_zczj"/></td>
              </tr>
			<tr height="25">
		        <td class="red">法定代表人</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_frdb"
		        	onkeyup="htjdOnkeyupVal('a_frdb','xingming');" onBlur="htjdOnBlurNotOnlyZfVal('a_frdb','xingming','0','‘法定代表人’','1','0');"/></td>
		        <td class="red">法人证件类型</td>
		        <td class="pagetd1"><select name="select4" id="bq_frdbzj" onChange="frdbzjOnchange();"></select></td>
		        <td class="red">法人证件号码</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_frdbzjhm"/></td>
             </tr>
			<tr height="25">
		        <td class="red">法人联系方式</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_frdblxfs"/></td>
		        <td class="red">特行备案管理机构</td>
				<td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_thbajg" readonly/>
					<input type="hidden" id="a_thbajgdm"/></td>
				<td class="pagedistd1">营业执照编号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_yyzzZjbh"/></td>
			</tr>
			<tr height="25">
		        <td class="pagedistd1">营业执照发证机关</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_yyzzFzjg"
		        	onkeyup="htjdOnkeyupVal('a_yyzzFzjg','zhongwen');"/></td>
		        <td class="pagedistd1">税务登记证编号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_swdjZjbh"/></td>
		        <td class="pagedistd1">税务登记证发证机关</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_swdjFzjg"
		        	onkeyup="htjdOnkeyupVal('a_swdjFzjg','zhongwen');"/></td>
            	</tr>
			<tr height="25">
		        <td class="pagedistd1">经营许可证编号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_jyxkZjbh"/></td>
		        <td class="pagedistd1">经营许可证发证机关</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_jyxkFzjg"
		        	onkeyup="htjdOnkeyupVal('a_jyxkFzjg','zhongwen');"/></td>
				<td class="red">单位负责人</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_dwfzr"
		        	onkeyup="htjdOnkeyupVal('a_dwfzr','xingming');" onBlur="htjdOnBlurNotOnlyZfVal('a_dwfzr','xingming','0','‘单位负责人’','1','0');"/></td>
              </tr>
			<tr height="25">
		        <td class="red">单位负责人身份证号</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_dwfzrzjhm"/></td>
		        <td class="red">单位负责人联系方式</td>
		        <td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_dwfzrlxfs"/></td>
		        <td class="red">治安负责人</td>
				<td class="pagetd1"><input style="width:120px" type="text" class="inputstyle1" id="a_bafzrxm"
				onkeyup="htjdOnkeyupVal('a_bafzrxm','xingming');" onBlur="htjdOnBlurNotOnlyZfVal('a_bafzrxm','xingming','0','‘治安负责人’','1','0');"/></td>
          </tr>
			<tr height="25">
				<td class="red"  >治安负责人身份证号</td>
				<td class="pagetd1"  ><input style="width:120px" type="text" class="inputstyle1" id="a_bafzrgmsfhm"/></td>
				<td class="red"  >治安负责人联系方式</td>
				<td class="pagetd1" colspan="3"  ><input style="width:120px" type="text" class="inputstyle1" id="a_bafzrdh"/></td>
		    </tr>
			<tr height="25">
				<td id="bz_title" class="pagedistd1">备注</td>
				<td id="bz_conte" colspan="7" class="pagetd1"><textarea name="textarea" id="a_bz" cols="102" rows="2"></textarea></td>
			</tr>
			</table>
		</td>
		</tr>
	</table>
</BODY>
</HTML>