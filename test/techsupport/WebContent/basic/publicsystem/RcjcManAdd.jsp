<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.common.QjblUtil"%>
<%@ page import="com.aisino2.sysadmin.Constants;"%>

<%
	//登录用户ID，用于获得菜单
	User user = new User();
	//获得登录用户session
	user = (User) session.getAttribute(Constants.userKey);
	String userAccount = user.getUseraccount();
	String userName = user.getUsername();
	String departname = user.getDepartment().getDepartname();
	String departcode = user.getDepartment().getDepartcode();
	//是否控制日常检查方式
	String sfkzrcjcfs = QjblUtil.queryQjblVal("sfkzrcjcfs");
%>

<script type="text/javascript">

var isGadLogin = true;
var shouci = true;//用于控制查询按钮调用setPageList时，调setHyxx();
var currPageHeight = pageHeight-215;
//离线页面高度
if($("#offineFlag").attr("value")=='1'){
	currPageHeight = pageHeight-145;
	isGadLogin = false;
}
var rcjcNum = 0;
var rcjcQybm,rcjcQymc;
var useraccount = "<%=userAccount%>";
var userName = "<%=userName%>";
var departname = "<%=departname%>";
var departcode = "<%=departcode%>";
var sfkzrcjcfs = "<%=sfkzrcjcfs%>";
$(document).ready(function() {

	pageUrl="publicsystem/querylist_publicrcjc.action";
	divnid="RcjcData";
	tableid="RcjcTable";
	addUrl="publicsystem/insert_publicrcjc.action";
	addHtml="basic/publicsystem/RcjcAdd.jsp";
	addWidth="550";
	delUrl="publicsystem/delete_publicrcjc.action";
	delid="d_rcjcid";
	modHtml="basic/publicsystem/RcjcModify.jsp";
	modUrl="publicsystem/modify_publicrcjc.action";
	modWidth="550";
	detailHtml="basic/publicsystem/RcjcDetail.jsp";
	detailid="rcjc_detail";
	detailUrl="publicsystem/query_publicrcjc.action";
	detailWidth="550";
	daggleDiv("rcjc_detail");	
	loadPage(divnid);
	
	$("#p_hylbdm").selectBoxhylb();//行业类别	
	if(sfkzrcjcfs=='0'){	
		$("#p_jcfs").selectBox({code:"dm_jcfs"});
	}else{
		$("#p_jcfs").selectBox({code:"dm_jcfs_sfkzrcjcfs"});
	}
	$("#p_jcrqt").attr("readonly","true");
	$("#p_jcrqt").datepicker();
	$("#p_jcrqf").attr("readonly","true");
	$("#p_jcrqf").datepicker();
			
	//依据csbm得到csid
	if(!isGadLogin){
		GetALine("p_qybm","p_qymc");
	}
	setHyxx();
}); 
	
function setPageList(pageno,url){	
	if (manVerify()){
		rcjcNum = 1;
		url=setList(pageno,url);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageParams:sXML,
										ingridPageWidth: pageWidth,
										height: pageHeight-238,
										url: url,	
										pageNumber: pageno,
										hideColIndex:[4],	
										colWidths: ["25%","25%","25%","25%","0%"]									
									});		
		if(shouci){		
			setHyxx();
		}
		}
}	
//设定行业信息表示
    function setHyxx(){
        var hylb=$("#p_hylbdm").val();
		if(hylb=='J'||hylb=='K'){
			$('#td_qymc').text('场所名称');
			$('#td_qybm').text('场所备案编号');
			$('#RcjcData').find('thead').find('th[@name=l_qymc]').find('DIV').html('场所名称');
			$('#p_qymc').val('');
		}else{
		    $('#td_qymc').text('企业名称');
		    $('#td_qybm').text('企业编号');
			$('#RcjcData').find('thead').find('th[@name=l_qymc]').find('DIV').html('企业名称');
			$('#p_qymc').val('');
		}
		shouci = false;
    }
function manVerify(){
	if(rcjcNum!=0){
		if (!checkControlValue("p_hylbdm","Select",1,100,null,1,"行业类别"))
			return false;
		if (!checkControlValue("p_qybm","String",1,20,null,0,"企业编码"))
			return false;
		if (!checkControlValue("p_qymc","String",1,200,null,0,"企业名称"))
			return false;
		if (!checkControlValue("p_jcrqf","Date",null,null,null,0,"检查日期"))
			return false;
		if (!checkControlValue("p_jcrqt","Date",null,null,null,0,"检查日期至"))
			return false;
		if(!checkTwoDateEarlier($("#p_jcrqf").val(),$("#p_jcrqt").val())){
			jAlert("检查日期必须小于检查日期至！","验证信息",null,"p_jcrqf");
			return false;
		}
	}
	return true;
}

var chuli = 0;
function setModifyRcjc(id){//修改
	chuli = 0;
	setModifyQuery(id);
}

function getObject(obj){ //点击链接方法(处理)
	chuli = 1;
	sFlag="false";
	setModifyQuery($(obj).attr("id").split("_")[1]);
}

function GetALine(bmid,mcid){   
	var fso,f,s,ForReading;
	var qybm = "",qymc="";   
	ForReading   =   1,   s   =   "";   
	fso = new ActiveXObject("Scripting.FileSystemObject");   
	f = fso.OpenTextFile("c:\\Program Files\\AERO_INFO\\config.ini", ForReading, false);   
	while(!f.AtEndOfStream){   
	    s=f.ReadLine(); 
	    if(s.indexOf("CSBM")==0){
	       qybm = s;
	    }else if(s.indexOf("CS=")==0){
	       qymc = s;
	    } 
	} 
	f.Close();
	rcjcQybm = qybm.split("=")[1];
	rcjcQymc = qymc.split("=")[1];
	$("#"+bmid).val(rcjcQybm);
	$("#"+mcid).val(rcjcQymc);
}

  //企业筛选框
 $("#p_qymc").click(function(){
	 dataid=$('#p_hylbdm').val();
	 getTy_item("p_qymc","","p_qyid");
  });

</script>

<body>
	
	<input type="hidden" id="d_rcjcid" value="">
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont">日常检查管理</td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
							<td width="7%" class="pagedistd">
								行业类别
							</td>
							<td width="17%" class="pagetd">
								<select id="p_hylbdm" onChange="setHyxx();">
								</select>
							</td>
							<td width="7%" class="pagedistd" id="td_qymc">
								企业名称
							</td>
							<td width="17%" class="pagetd">
								<input type="text" class="inputstyle" id="p_qymc" readonly="readonly"/>
							</td>
							<td width="7%" class="pagedistd" id="td_qybm">
								企业编码
							</td>
							<td width="16%" class="pagetd">
								<input type="text" class="inputstyle" id="p_qybm" />
							</td>
						</tr>
    		<tr>
					<td class="pagedistd">检查日期</td>
				  	<td class="pagetd"><input type="text" class="inputstyle1"  id="p_jcrqf" /> 
				    至<input type="text" class="inputstyle1"  id="p_jcrqt" value=""></td>
				    <td width="7%" class="pagedistd">检查方式</td>
				    <td class="pagetd"><select id="p_jcfs"><option></option></select></td>
				    <td class="pagetd" colspan="2"><table width="65" border="0" align="right" cellpadding="2" cellspacing="0">
                    <tr>
                      <td width="41%" height="28px"><a href="#"  class="searchbutton" id="querys" onClick="setPageList(1);">查询</a></td>
                      <td><a href="#" class="addbutton"  onclick="setAddPage();">添加</a> </td>
                    </tr>
                  </table></td>
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
<div id="rcjc_detail" class="page-layout" src="#"
		style="top:20px;">
</div>	

<div id="RcjcData" style="width:100%;">
	<table id="RcjcTable" width="100%">
	  <thead>
	    <tr>       
	     	<th name="l_jcrq">检查时间</th>
	     	<th name="l_qymc">企业名称</th>
	     	<th name="l_jcrxm">检查人</th>
	     	<th name="l_jcjgmc">检查单位</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>



</body>
