<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants;"%>
<%
    /**
	//登录用户ID，用于获得菜单
	int userid = 0;
	User user = new User();
	//获得登录用户session
	user = (User) session.getAttribute(Constants.userKey);
	if (user == null)
		response.sendRedirect("login.jsp");
	else
		userid = user.getUserid().intValue();
	String deptCode = user.getDepartment().getDepartcode();
	String deptName = user.getDepartment().getDepartname();
	String userName = user.getUsername();
	
	**/
%>
<script type="text/javascript">
var fileData;
	$(document).ready(function() {
		$("#q_bkryid").attr("value",dataid);
		$("#m_bkryid").attr("value",dataid);
			setDetail();
		$("#ryImage").attr("src","basicsystem/queryZp_bkry.action?bkryid="+dataid);			
		//$("#m_ckczsj").val(TimeObject().fullYear+"-"+TimeObject().month+"-"+TimeObject().date);	
	}); 
	function updatediv (json) { 
		$("#m_bkryid").attr("value",setNull(json.LBkry[0].bkryid));
		$("#bkryid").append(setNull(json.LBkry[0].bkryid));
		$("#tbbh").append(setNull(json.LBkry[0].tbbh));
		$("#gmsfhm").append(setNull(json.LBkry[0].gmsfhm));
		$("#xm").append(setNull(json.LBkry[0].xm));
		$("#jg").append(setNull(json.LBkry[0].jg));
		$("#xb").append(setNull(json.LBkry[0].xb));
		$("#minzu").append(setNull(json.LBkry[0].minzu));
		$("#ky").append(setNull(json.LBkry[0].ky));
		$("#shengao").append(setNull(json.LBkry[0].shengao));
		$("#tz").append(setNull(json.LBkry[0].tz));
		$("#tt").append(setNull(json.LBkry[0].tt));
		$("#yz").append(setNull(json.LBkry[0].yz));
		$("#fwdw").append(setNull(json.LBkry[0].fwdw));
		$("#ajlb").append(setNull(json.LBkry[0].ajlb));
		$("#tbsj").append(setNull(json.LBkry[0].tbsj));
		$("#jyaq").append(setNull(json.LBkry[0].jyaq));
		$("#bkr").append(setNull(json.LBkry[0].bkr));
		$("#bkczy").append(setNull(json.LBkry[0].bkczy));
		$("#bkczsj").append(setNull(json.LBkry[0].bkczsj));
		$("#bkdqsj").append(setNull(json.LBkry[0].bkdqsj));
		$("#bkfw").append(setNull(json.LBkry[0].bkfw));
        $("#lxfs").append(setNull(json.LBkry[0].lxfs));
		$("#lxr").append(setNull(json.LBkry[0].lxr));
		$("#csrq").append(setNull(json.LBkry[0].csrq));
		//fileData = setNull(json.LBkry[0].fileload);
		//setFile();
	}	
	function modifyVerify(){
		return true;
	}
	
	function setShUpdate(){
	if (modifyVerify()){
		setParams("m_");
		jQuery.post(modUrl,params,updateCkback,"json"); 
		return true;
	}else{
		return false;
	}		
}
function updateCkback(json){
	if  (json.result=="success"){
		jAlert('审核成功','保存信息');
		setPageList($("#pageNo").attr("value"));
		$("#"+detailid).hideAndRemove("slow"); 
	}else{
		jAlert(json.result,'错误信息');
	}		
}
</script>
<input type="hidden" id="q_bkryid">
<input type="hidden" id="m_bkryid">
<input type="hidden" id="m_shsftg" value="1">

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">
			布控人员审核
		</td>
		<td align="right" class="title1">
			<a href="#" id="closeDiv"
				onclick='$("#bkry_detail").hideAndRemove(&quot;show&quot;);'class="close"></a>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellpadding="4" cellspacing="0"class="detail" id="detail" >
<tr>
					<td width="8%" class="distd1">
						姓名
					</td>
					<td width="21%" class="detailtd2">
						<span id="xm" /></span>
					</td>
					<td width="12%" class="distd1">
						公民身份号码
					</td>
					<td width="36%" class="detailtd2">
						<span id="gmsfhm" /></span>
					</td>
					<td width="23%" rowspan="6" colspan="2" class="detailtd2">
						<table width="35%" border="0" align="center" cellpadding="8"
							cellspacing="0">
							<tr>
								<td>
									<img id="ryImage" width="118" height="149" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="distd1">
						出生日期
					</td>
					<td class="detailtd2">
						<span id="csrq" /></span>
					</td>
					<td class="distd1">
						性别
					</td>
					<td class="detailtd2">
						<span id="xb" /></span>
					</td>
				</tr>
				<tr>
					<td class="distd1">
						籍贯
					</td>
					<td class="detailtd2">
						<span id="jg" /></span>
					</td>
					<td class="distd1">
						民族
					</td>
					<td class="detailtd2">
						<span id="minzu" /></span>
					</td>
				</tr>
				<tr>
					<td class="distd1">
						口音
					</td>
					<td class="detailtd2">
						<span id="ky" /></span>
					</td>
					<td class="distd1">
						身高
					</td>
					<td class="detailtd2">
						<span id="shengao" value="0" />
					</td>
				</tr>
				<tr>
					<td class="distd1">
						体征
					</td>
					<td class="detailtd2">
						<span id="tz" /></span>
					</td>
					<td class="distd1">
						体态
					</td>
					<td class="detailtd2">
						<span id="tt" /></span>
					</td>
				</tr>
				<tr>
					<td class="distd1">
						衣着
					</td>
					<td class="detailtd2">
						<span id="yz" /></span>
					</td>
					<td class="distd1">
						通报编号
					</td>
					<td class="detailtd2">
						<span id="tbbh" /></span>
		</td>
	</tr>
	<tr>
		<td width="8%" class="distd1">
			案件类别
		</td>
		<td width="21%" class="detailtd2">
			<span id="ajlb" /></span>
		</td>
		<td width="12%" class="distd1">
			通报时间
		</td>
		<td width="26%" class="detailtd2">
			<span id="tbsj" /></span>
		</td>
		<td width="10%" class="distd1">
			布控到期时间
		</td>
		<td width="23%" class="detailtd2">
			<span id="bkdqsj" /></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			发文单位
		</td>
		<td class="detailtd2" colspan="5">
			<span id="fwdw" /></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			简要案情
		</td>
		<td colspan="5" class="detailtd2">
			<span id="jyaq" /></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			布控人
		</td>
		<td class="detailtd2">
			<span id="bkr" /></span>
		</td>
		<td class="distd1">
			布控操作员
		</td>
		<td class="detailtd2">
			<span id="bkczy" /></span>
		</td>
		<td class="distd1">
			布控操作时间
		</td>
		<td class="detailtd2">
			<span id="bkczsj" /></span>
		</td>
	</tr>
	<tr>
		<td class="distd1">
			联系人
		</td>
		<td class="detailtd2">
			<span id="lxr" /></span>
		</td>
		<td class="distd1">
			联系方式
		</td>
		<td class="detailtd2">
			<span id="lxfs" /></span>
		</td>
		<td class="distd1">
			布控范围
		</td>
		<td class="detailtd2">
			<span id="bkfw" /></span>
		</td>
	</tr>
	<tr align="center">
		<td colspan="6" height="3"></td>
  </tr>
	<tr align="center">
		<td colspan="3" align="right">&nbsp;</td>
		<td colspan="3" align="left"><a href="#" id="addbutton" hidefocus="true" class="submitbutton"
				align="right" title="审核" onclick='setShUpdate();'>审核</a></td>
  </tr>
</table>
