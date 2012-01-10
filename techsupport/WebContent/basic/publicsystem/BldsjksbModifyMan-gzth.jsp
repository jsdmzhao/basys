<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@include file="../../public/common.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#baoCunTitle_blds").val($("#BldsjksbListData").html());
		$("#bldscx_qyid").val(qyjbxx_dataid);
		setParams("bldscx_");
		    /*  bldsjksb_setPageList(1,"publicsystem/querylistByQy_bldsjksb.action");*/
		     bldsjksb_setPageList(1,"publicsystem/querystoplistByQy_bldsjksb.action");
		    daggleDiv("bldsjksb_detail");
	}); 
	function bldsjksb_setPageList(pageno,url){
		$("#BldsjksbListData").html($("#baoCunTitle_blds").val());
		if(url==null){
			/*url = "publicsystem/querylistBack_bldsjksb.action";*/
			url="publicsystem/querylistinsertBack_bldsjksb.action";
		}
		var mygrid1 = $("#BldsjksbListTable").ingrid({ 
		                                tableid:"bldsjksbTable",
										ingridPageParams:sXML,
										ingridPageWidth: 998,
										url: url,	
										height: 80,
										pageNumber: pageno,
										sorting: false,
										paging: false,
										changeHref:function(table){
											table.find("tr").each(function(index){
											var qyid = $(this).attr("id");
											 	var obj = $(this).find("td").eq(13); //停用时间	判断 显示（修改 停用） or 空
												var text = obj.html();
												if(text==2)
												       {
													 		$(this).append("<td>&nbsp;</td>");
													 	}
											 	 else
													 	{
													 	   if(qyid==0){
																		$(this).append("<td><a href='#' class='fontbutton' onclick='bldsjksb_setModify("+index+")'>修改</a>"+
																		"&nbsp;&nbsp;<a href='#' class='fontbutton' onclick='bldsjksb_setDelete("+index+")'>删除</a></td>");
																	  } 
															else 
															   {
																		 $(this).append("<td><a href='#' class='fontbutton' onclick='bldsjksb_setModify("+index+")'>修改</a>"+
																		"&nbsp;&nbsp;<a href='#' class='fontbutton' onclick='bldsjksb_setSpstop("+index+")'>停用</a></td>");
																} 
														} 
											});
										},
										onRowSelect : function(tr){
											if(sFlag=="true"){
												if ($(tr).attr('_selected')=="true"){
													bldsjksb_setDetailQuery($(tr).attr('rowindex')-1);
												}
											}else{
												sFlag="true";
											}
										},
										isPlayResultNull:false,
										hideColIndex:[8,9,10,11,12,13,14,15,16],
										colWidths:["11%","21%","10%","16%","8%","9%","6%","11%","0%","0%","0%","0%","0%","0%","0%","0%","0%","8%"]
									});				
	}

	function bldsjksb_setAddPage(){
		setWidthSome("bldsjksb_detail","700");
		setUrl("bldsjksb_detail","basic/publicsystem/BldsjksbAdd-gzth.jsp");
	}

	function bldsjksb_setModify(trIndex){
		sFlag="false";
		$("#caozuo_trIndex_blds").val(trIndex);
		setWidthSome("bldsjksb_detail","750");
		setUrl("bldsjksb_detail","basic/publicsystem/BldsjksbModify-gzth.jsp");
	}
	
	
	function bldsjksb_setSpstop(trIndex){
		sFlag="false";
		$("#caozuo_trIndex_blds").val(trIndex);
		setWidthSome("bldsjksb_detail","750");
		setUrl("bldsjksb_detail","basic/publicsystem/SpjksbxxStop.jsp");
	}

	function bldsjksb_setDelete(trIndex){
		sFlag="false";
		jConfirm('确定删除吗？', '删除提示', function(r){
			if(r){
				$("#bldsczlx_bldsjkRequetType").val("sc");
				$("#bldsjksbTable").find("tbody").find("tr:nth("+trIndex+")").remove();
				var child=new Array("BldsjksbListData");
				setParams("bldsczlx_",child);
				bldsjksb_setPageList(1);
				$("#bldsczlx_bldsjkRequetType").val("");
			}
		});
	}

	function bldsjksb_setDetailQuery(trIndex){
		setWidthSome("bldsjksb_detail","750");
		$("#bldsjksb_detail").empty().load("basic/publicsystem/BldsjksbDetail-gzth.jsp",function(){
			bldsjksb_updatediv($("#bldsjksbTable").find("tbody").find("tr:nth("+trIndex+")"));
		}).show("slow");
		upAllPage("bldsjksb_detail");
	}
</script>
<input type="hidden" id="bldscx_qyid" />
<input type="hidden" id="baoCunTitle_blds" />
<input type="hidden" id="caozuo_trIndex_blds" />
<input type="hidden" id="bldsczlx_bldsjkRequetType" />
<table width="998px" cellpadding="0" cellspacing="0" class="tableborder">
	<tr>
		<td style="color: #004499; font-size: 12px; font-weight: bold;">
			视频监控设备
		</td>
		<td align="right" id="bldsjksb_add">
			<table border="0" align="right" cellpadding="0" cellspacing="0"
				width="75">
				<tr>
					<td width="60">
						<a href="#" class="addbutton"  onclick='bldsjksb_setAddPage();'>添加</a>
					</td>
					<td>&nbsp;
						
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<div id="bldsjksb_detail" class="page-layout" src="#"
	style="top: 180px; left: 160px; width: 500px; display: none">
</div>

<div id="BldsjksbListData" style="width: 100%;">
	<table id="BldsjksbListTable" width="100%">
		<thead>
			<tr>
				<th name="l_sbmc">
					设备名称
				</th>
				<th name="l_sccsmc">
					设备生产厂商名称
				</th>
				<th name="l_ggxh">
					规格型号
				</th>
				<th name="l_sbjcjgmc">
					设备检测机构名称
				</th>
				<th name="l_wlcslxmc">
					网络传输类型
				</th>
				<th name="l_azsxtsl">
					摄像头安装数量
				</th>
				<th name="l_sflx">
					是否录像
				</th>
				<th name="l_ipdz">
					IP地址
				</th>
				<th name="l_lrr">
					填报人
				</th>
				<th name="l_lrsj">
					填报时间
				</th>
				<th name="l_bz">
					备注
				</th>
				<th name="l_jibr">
					经办人
				</th>
				<th name="l_tysj">
					停用时间
				</th>
				<th name="l_zt">
					设备状态
				</th>
				<th name="l_tyyy">
					停用原因
				</th>
				<th name="l_hylb">
					行业类别
				</th>
				<th name="l_qymc">
					企业名称
				</th>
				<th name="">
					操作
				</th>
			</tr>
		</thead>
	</table>
</div>