<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript">
$(document).ready(function() {
	pageUrl="publicsystem/Gaquerylist_kyqk.action";
	divnid="tabledata";
	tableid="table1";
	addUrl="publicsystem/insert_kyqk.action";
	addHtml="basic/publicsystem/KyqkAdd.jsp";
	addWidth="600";
	delUrl="publicsystem/delete_kyqk.action";
	delid="d_kyqkid";
	modHtml="basic/publicsystem/KyqkModify-gad.jsp";
	modUrl="publicsystem/modify_kyqk.action";
	modWidth="700";
	detailHtml="basic/publicsystem/KyqkDetail-gad.jsp";
	detailid="kyqk_detail";
	detailUrl="publicsystem/query_kyqk.action";
	detailWidth="700";
	kyqk_loadPage("tabledata");
	$("#p_hylbdm").selectBoxhylb({code:"flgy"});//行业类别	
	$("#p_tbsj").attr("readonly","true");
	$("#p_tbsj").datepicker();
	$("#p_tbsjzhi").attr("readonly","true");
	$("#p_tbsjzhi").datepicker();
	$("#p_kyqklxbm").selectBox({code:"dm_kyqklx"});
	daggleDiv("kyqk_detail");
	$("#p_gxdw").click(function(){ //管辖单位
		getGxdw("p_gxdw","p_gxdwbh");
	});
	
	setHyxx();
}); 

function kyqk_loadPage(divpageid){
	tables=$("#"+divpageid).html();
	$("#"+detailid).hide(); 
	if(dataid=="J"){
	    dataid="";
	    $('#p_hydm').val('J');
	    $('#p_jjrxm').val('1');
	    setPageList(1);
	    $('#p_hydm').val('');
	    $('#p_jjrxm').val('');
	}else{
	    setPageList(1,'#');
	}
}
function setPageList(pageno,url){	
	if (manVerify()){
		url=setList(pageno,url);
		rows = Math.ceil((pageHeight-225-25-23)/20);
		// create the grid
		// returns a jQ object with a 'g' property - that's ingrid
		var mygrid1 = $("#"+tableid).ingrid({ 
										ingridPageWidth: pageWidth,
										url: url,	
										height: pageHeight-250,
										pageNumber: pageno,
										ingridPageParams: sXML,
										colWidths: ["20%","18%","18%","18%","18%","8%"]									
									});				
		setHyxx();
		}
}	
	function manVerify(){
		if (!checkControlValue("p_tbrxm","String",1,100,null,0,"填报人姓名"))
			return false;	
		if (!checkControlValue("p_kyqklxbm","String",1,100,null,0,"可疑情况类型"))
			return false;
		return true;
	}
	
	////可疑情况查询
	function querykyqk(){
	  if (!checkControlValue("p_tbrxm","String",1,100,null,0,"填报人姓名"))
			return false;	
	  if (!checkControlValue("p_kyqklxbm","String",1,100,null,0,"可疑情况类型"))
			return false;
	  if (!checkDateEarlier("p_tbsj","开始时间","p_tbsjzhi","结束时间","DATE"))
		return false;
	
	  setPageList(1);
	}
	  //企业筛选框
 $("#p_qymc").click(function(){
	 dataid=$('#p_hylbdm').val();
	 getTy_item("p_qymc","","p_qyid");
  });
  //设定行业信息表示
    function setHyxx(){
        var hylb=$("#p_hylbdm").val();
		if(hylb=='J'||hylb=='K'){
			$('#td_qymc').text('场所名称');
			$('#td_qybm').text('场所备案编号');
			$('#tabledata').find('thead').find('th[@name=l_qymc]').find('DIV').html('场所名称');
		}else{
		    $('#td_qymc').text('企业名称');
		    $('#td_qybm').text('企业编号');
			$('#tabledata').find('thead').find('th[@name=l_qymc]').find('DIV').html('企业名称');
		}
    }

    function getObject(obj){
    	sFlag="false";
    	//alert($(obj).attr("id")+"="+$(obj).text());
    	if($(obj).text()=="处理"){
    		doWithKyqk($(obj).attr("id").split("_")[1]);
    	}
    }
    
    function doWithKyqk(id){
        sFlag=false;
        dataid=id;
	    setWidth(detailid,modWidth);
	    setUrl(detailid,modHtml);
	    bindDocument(detailid);
    }
</script>

<body>
    <input type="hidden" id="p_jjrxm">
    <input type="hidden" id="p_hydm" value="">
	<input type="hidden" id="d_csid" value="">
	<input type="hidden" id="d_kyqkid" value="">
	<input type="hidden" id="p_qyid" value="">
	<table width="100%" cellpadding="0" cellspacing="0" class="tableborder">
		<tr>
			<td class="queryfont">
				可疑情况管理
			</td>
		</tr>
		<tr>
			<td class="tdbg">
				<table width="100%" border="0" cellspacing="0" cellpadding="2">
					<tr>
						<td width="10%" class="pagedistd">
							行业类别
						</td>
						<td width="23%" class="pagetd">
							<select id="p_hylbdm" onchange="setHyxx();"></select>
						</td>
						<td width="10%" class="pagedistd" id="td_qymc">
							企业名称
						</td>
						<td width="23%" class="pagetd"">
							<input type="text" class="inputstyle" id="p_qymc" value=""
								readonly="readonly">
						</td>
						<td width="10%" class="pagedistd" id="td_qybm">
							企业编号
						</td>
						<td width="23%" class="pagetd">
							<input type="text" class="inputstyle" id="p_qybm" value="">
						</td>
					</tr>
					<tr>
						<td class="pagedistd">
							填报时间
						</td>
						<td class="pagetd">
							<input type="text" class="inputstyle" id="p_tbsj" value="">
						</td>
						<td class="pagedistd">
							至
						</td>
						<td class="pagetd">
							<input type="text" class="inputstyle" id="p_tbsjzhi" value="">
						</td>
						<td class="pagedistd">
							填报人
						</td>
						<td class="pagetd">
							<input type="text" class="inputstyle" id="p_tbrxm" value="">
						</td>
					</tr>
					<tr>
						<td class="pagedistd">
							管辖单位
						</td>
						<td class="pagetd">
							<input type="text" class="inputstyle" id="p_gxdw" value=""
								readonly="readonly">
							<input type="hidden" id="p_gxdwbh">
						</td>
						<td class="pagedistd">
							可疑情况类型
						</td>
						<td class="pagetd">
							<select type="select" id="p_kyqklxbm" value="">
								<option value=""></option>
							</select>
						</td>
						<td class="pagedistd">
							&nbsp;
						</td>
						<td width="13%">
							<table width="124" border="0" align="right" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="52%"></td>
									<td width="48%">
										<a href="#" class="searchbutton" id="querys"
											onClick="querykyqk();">查询</a>
									</td>
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
	<div id="kyqk_detail" class="page-layout" src="#"
		style="top: 180px; left: 160px; width: 500px;">
	</div>

	<div id="tabledata" style="width: 100%;">
		<table id="table1" width="100%">
			<thead>
				<tr>

					<th name="l_qymc">
						企业名称
					</th>
					<th name="l_kyqkdjxh">
						登记序号
					</th>
					<th name="l_kyqklx">
						可疑情况类型
					</th>
					<th name="l_tbrxm">
						填报人姓名
					</th>
					<th name="l_tbsj">
						填报时间
					</th>
					<th name="">
						操作
					</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
