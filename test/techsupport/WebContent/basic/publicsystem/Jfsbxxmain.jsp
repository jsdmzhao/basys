<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
	<head>
		<script type="text/javascript">
	$(document).ready(function() {
	    pageUrl="publicsystem/Aqquerylist_aqjcsb.action";
		divnid="aqjkxxData";
		tableid="aqjkxxTable";
		detailHtml="basic/publicsystem/QyjbxxDetail-gzth.jsp";
		detailid="aqjksbxx_detail";
		detailWidth="600";
		loadPage(divnid);	
		$("#p_hylbdm").selectBoxhylb({code:"ggmk"});
		$("#p_qymc").click(function(){ //服务场所筛选框
		 	dataid=$('#p_hylbdm').val();
			getTy_item("p_qymc","s_qybm");
		});
		$("#p_zt").selectBox({code:"dm_sbzt"});
		$("#p_aqjcsbzlbm").selectBox({code:"dm_aqjcsbzl"});
		
		daggleDiv(detailid); 
	});
		
	function setPageList(pageno,url){	
		if (manVerify()){
			url=setList(pageno,url);
			var mygrid1 = $("#"+tableid).ingrid({
			    tableid:"bldsjksbTable",
				url: url,
				pageNumber: pageno,				
				ingridPageParams:sXML,
				height: pageHeight-253,
				onRowSelect: null,
				onTdSelect: function(tr){
					var qyid=$(tr).find("td").eq(8).text();
					var obj = $(tr).find("td").eq(1); //企业名称
					var hydm = $(tr).find("td").eq(10); //企业名称
					obj.html("<a href='#' class='hyperlink' onClick=qyjbxx_qyxx('"+qyid+"','"+hydm.text()+"');>"+obj.text()+"</a>");
				},
				 changeHref:function(table){
					$(table).find("tr").each(function(){
						$(this).append("<td><a href='#' class='fontbutton' onclick='aqjcsb_setDetailQuery("+$(table).find("tr").index(this)+")'>详细信息</a></td>"
						);
					});
				},
				hideColIndex:[5,6,7,8,9,10],
				colWidths: ["16%","31%","16%","16%","15%","0%","0%","0%","0%","0%","0%","6%"]
			});
		}
	}	
	
	var qyjbxx_dataid;
	var qyjbxx_qymc;
	var ylyjbxx_detailHtml="business/Ylfwzagl/YlcsjbxxDetail.jsp";
	var qyjbxx_detailHtml="basic/publicsystem/QyjbxxDetail-gzth.jsp";
	var qyjbxx_detailWidth="1000";
	function qyjbxx_qyxx(id,hylbdm){ //企业基本信息
		qyjbxx_requestType="detail";
		qyjbxx_dataid=id;
		qyjbxx_qymc=hylbdm;
		$("#"+detailid).css("top","10px");
		setWidth(detailid,qyjbxx_detailWidth);
		if(qyjbxx_qymc!='J'){
		setUrl(detailid,qyjbxx_detailHtml);
		}else{
		  setUrl(detailid,ylyjbxx_detailHtml);}
		bindDocument(detailid);
	}
	
	var aqjcsb_dataid;
	var aqjcsb_detailHtml="basic/publicsystem/AqjcsbDetail-gzth.jsp";
	var aqjcsb_detailUrl="publicsystem/query_bldsjksb.action";
	var aqjc_detailWidth="650";
	
	function aqjksb_spsbxx(id){ //设备详细 
		aqjcsb_dataid=id
		$("#"+detailid).css("top","140px");
		setWidth(detailid,aqjc_detailWidth);
		setUrl(detailid,aqjcsb_detailHtml);
		bindDocument(detailid);
	}
	
	function aqjcsb_setDetailQuery(trIndex){
	    $("#"+detailid).css("top","140px");
		setWidthSome("aqjksbxx_detail","650");
		$("#aqjksbxx_detail").empty().load("basic/publicsystem/AqjcsbDetail-gzth.jsp",function(){
			aqjksb_updatediv($("#bldsjksbTable").find("tbody").find("tr:nth("+trIndex+")"));
		}).show("slow");
		upAllPage("aqjksbxx_detail");
	}
	
	function aqjcsb_setList(pageno,url){	
		$("#"+aqjcsb_divnid).html(aqjcsb_tables);
		createXML("p_");
		if (url==null || url=="undefined"){
			url=aqjcsb_pageUrl;
		}
		return url;
	}
	
	 function aqjcsb_setDetail(){
	}
	function manVerify(){
		return true;
	}
	
</script>
	<head>
	<body>

		<table width="100%" cellpadding="0" cellspacing="0"
			class="tableborder">
			<tr>
				<td class="queryfont">
					技防设备信息查询条件
				</td>
			</tr>
			<tr>
				<td class="tdbg">
					<table width="100%" border="0" cellspacing="0" cellpadding="2">
						<tr>
							<td class="pagedistd">
								行业类别
							</td>
							<td class="pagetd">
								<select name="select" id="p_hylbdm">
							</td>
							<td class="pagedistd">
								企业名称
							</td>
							<td class="pagetd" colspan="3">
								<input type="text" class="inputstyle" style="width: 470px"
									id="p_qymc" readonly />
							</td>
						</tr>
						<tr>
							<td width="12%" class="pagedistd">
								设备名称
							</td>
							<td width="23%" class="pagetd">
								<input type="text" id="p_sbmc" class="inputstyle">
							</td>
							<td width="10%" class="pagedistd">
								规格型号
							</td>
							<td width="21%" class="pagetd">
								<input type="text" id="p_ggxh" class="inputstyle">
							</td>
							<td width="10%" class="pagedistd">
								技防设备种类
							</td>
							<td width="23%" class="pagetd">
								<select name="select" id="p_aqjcsbzlbm"><option></option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="pagedistd">
								设备状态
							</td>
							<td class="pagetd">
								<select name="select" id="p_zt"> <option></option>
							</td>
							<td colspan="4">
								<table border="0" align="right" cellpadding="0" cellspacing="0">
									<tr>
										<td width="62px">
											<a href="#" class="searchbutton" id="querys"
												onClick="setPageList(1);">查询</a>
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
		<div id="aqjksbxx_detail" class="page-layout" src="#" style="top: 60px;"></div>
		<div id="aqjkxxData" style="width: 100%;">
			<table id="aqjkxxTable" width="100%">
				<thead>
					<tr>
						<th name="l_hylb">
							行业类别
						</th>
						<th name="l_qymc">
							企业名称
						</th>
						<th name="l_sbmc">
							设备名称
						</th>
						<th name="l_ggxh">
							规格型号
						</th>
						<th name="l_jssbzl">
							技术设备种类
						</th>
						<th name="l_azsl">
							安装数量
						</th>
						<th name="l_lrr">
							填报人
						</th>
						<th name="l_lrsj">
							填报时间 
						</th>
						<th name="l_qyid">
							企业ID
						</th>
						<th name="l_bz">
							备注
						</th>
						<th name="l_hylbdm">
							企业行业类别代码
						</th>
						<th name="l_cz">
							操作
						</th>
					</tr>
				</thead>
			</table>
		</div>
	</body>
</html>