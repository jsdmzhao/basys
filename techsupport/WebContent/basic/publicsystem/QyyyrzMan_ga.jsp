<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<script type="text/javascript">
	var qyjbxx_detailidTopOffset=0;
	var qyjbxx_detailidLeftOffset=0;
	var qyjbxx_requestType=""; //添加、查看、修改
	var qyjbxx_dataid="";
	var qyjbxx_tables = "";
	var qyjbxx_divnid="tabledata";
	var qyjbxx_tableid="table1";
	var qyjbxx_pageUrl="publicsystem/queryCsChaxunYyrzList_qyyyrz.action";
	var qyjbxx_detailid="ylcsjbxx_detail";
	var qyjbxx_detailHtml="basic/publicsystem/QyjbxxDetail.jsp";
	var qyjbxx_yyrzHtml="basic/publicsystem/QyyyrzManlist.jsp";
	var qyjbxx_csskjlHtml="basic/icksystem/QyryskjlMan-ga.jsp";
	var qyjbxx_detailUrl="publicsystem/query_qyjbxx.action";
	var qyjbxx_detailWidth="990";
	var qyyyrz_detailWidth="760";
	$(document).ready(function() {
		ylcsjbxx_loadPage("tabledata");
		hylbLinkQyzfl("p_hylbdm","p_qyzflbm","","qhy"); // 行业类别与企业主分类联动
		$("#p_zabdm").selectBox({code:"dm_cszajb"});
		$("#p_yyztdm").selectBox({code:"dm_yyzt(bzhylcs)"});
		$("#p_relation").selectBox({state:"temp",width:"80px"});
		$("#p_gxdwmc").click(function(){ //管辖单位
			getGxdw("p_gxdwmc","p_gxdwbm");
		});
		if($("#p_hylbdm").val()!="J"){
			qyjbxx_detailHtml="basic/publicsystem/QyjbxxDetail-gzth.jsp";
			
			$('body').find('div [@id=qy]').each(function(r){
				$(this).show();
			});
			$('body').find('div [@id=cs]').each(function(){
				$(this).hide();
			});
			$('#zajb').hide();
		}
		daggleDiv("ylcsjbxx_detail");
	});

	function ylcsjbxx_loadPage(divpageid){
		qyjbxx_tables=$("#"+divpageid).html();
		$("#"+qyjbxx_detailid).hide();
		ylcsjbxx_setPageList(1,'#');
	}
	function ylcsjbxx_setList(pageno,url){	
		$("#"+qyjbxx_divnid).html(qyjbxx_tables);	
		createXML("p_");
		if (url==null || url=="undefined"){
			url=qyjbxx_pageUrl;
		}
		return url;
	}
	function ylcsjbxx_setPageList(pageno,url){	
		if (manVerify()){
			url=ylcsjbxx_setList(pageno,url);
			var mygrid1 = $("#"+qyjbxx_tableid).ingrid({ 
										url: url,
										ingridPageParams:sXML,
										height: pageHeight-263,
										pageNumber: pageno,
										colClasses: ['grid-col-style2','grid-col-style2'],
										colIndex: [0,1],
										onRowSelect: function(tr, selected){
										},
										onTdSelect: function(tr){
											$(tr).find("td").click(function(){
												if (sFlag=="true"){
													var tdnum = $(tr).find("td").index(this);
													if(tdnum!=$(tr).find("td").length-1&&(tdnum==0||tdnum==1)){
														ylcshc_setQuery($(tr).attr("id"));
													}
												}else{
													sFlag="true";
												}
											});	
										},
										colWidths: ["14%","29%","7%","16%","10%","8%","12%"]									
									});				
		}
		if($("#p_hylbdm").val()!="J"){
				//alert($("#p_hylbdm").val());
				$('body').find('div [@id=qy]').each(function(r){
					$(this).show();
				});
				$('body').find('div [@id=cs]').each(function(){
					$(this).hide();
				});
		}
	}
	function ylcshc_setQuery(id){
		qyjbxx_requestType="detail";
		qyjbxx_dataid=id;
		setWidth(qyjbxx_detailid,qyjbxx_detailWidth);
		setUrl(qyjbxx_detailid,qyjbxx_detailHtml);
		var qyjbxx_detailidOffset = $("#"+qyjbxx_detailid).offset();
		qyjbxx_detailidTopOffset=qyjbxx_detailidOffset.top;
		qyjbxx_detailidLeftOffset=qyjbxx_detailidOffset.left;
		bindDocument(qyjbxx_detailid);
	}
	function ylcsjbxx_setDetail(){
		setParams("q_");
		jQuery.post(qyjbxx_detailUrl,params,ylcsjbxx_updatediv,"json");
	}
	var csyyrz_timeFlag = true;
	function ylcshc_setYyrz(id){ //营业日志页面加载
		if(csyyrz_timeFlag){
			csyyrz_timeFlag = false;
			qyjbxx_dataid=id;
			$("#p_qyid").val(id);
			setWidth(qyjbxx_detailid,qyyyrz_detailWidth);
			setUrl(qyjbxx_detailid,qyjbxx_yyrzHtml);
			var qyjbxx_detailidOffset = $("#"+qyjbxx_detailid).offset();
			qyjbxx_detailidTopOffset=qyjbxx_detailidOffset.top;
			qyjbxx_detailidLeftOffset=qyjbxx_detailidOffset.left;
			bindDocument(qyjbxx_detailid);
			setTimeout(function(){csyyrz_timeFlag = true;},1000);
		}
	}
	
	function ylcshc_setSkjl(id){ //刷卡记录
		if(csyyrz_timeFlag){
			csyyrz_timeFlag = false;
			qyjbxx_dataid=id;
			setWidth(qyjbxx_detailid,qyjbxx_detailWidth);
			setUrl(qyjbxx_detailid,qyjbxx_csskjlHtml);
			var qyjbxx_detailidOffset = $("#"+qyjbxx_detailid).offset();
			qyjbxx_detailidTopOffset=qyjbxx_detailidOffset.top;
			qyjbxx_detailidLeftOffset=qyjbxx_detailidOffset.left;
			bindDocument(qyjbxx_detailid);
			setTimeout(function(){csyyrz_timeFlag = true;},1000);
		}
	}
	function bgqk_setWidth(divid,sWidth){
		$("#"+divid).css("width",sWidth+"px");
		$("#"+divid).css("left","0px");
	}
	function manVerify(){
		var mc="场所名称";
		var bm="场所备案编码";
		if($("#p_hylbdm").val()!="J"){
			mc="企业名称";
			bm="企业编码";
		}
		if (!checkControlValue("p_qymc","String",1,120,null,0,mc))
			return false;
		if (!checkControlValue("p_zrs","Integer",-999999,999999,null,0,"从业人员数量"))
			return false;
		if (!checkControlValue("p_gxdwmc","String",1,60,null,0,"管辖单位名称"))
			return false;
		if (!checkControlValue("p_qybm","String",1,20,null,0,bm))
			return false;
		if (!checkControlValue("p_zjbh","String",1,60,null,0,"营业执照编号"))
			return false;
		return true;
	}
	function gaojichaxun_csyyrz(){
		gaojichaxun("44,46",qyjbxx_detailid,"ylcsjbxx_setPageList");
	}
	
	//服务场所筛选框
	$("#p_qymc").click(function(){
	 	dataid=$("#p_hylbdm").val();
		getTy_item_super("p_qymc","p_qybm",'','','','1');
	});
	
	//行业类别更换触发页面变换
	$("#p_hylbdm").change(function(){
		if($("#p_hylbdm").val()!="J"){
			qyjbxx_detailHtml="basic/publicsystem/QyjbxxDetail-gzth.jsp";
			
			$('body').find('div [@id=qy]').each(function(r){
				$(this).show();
			});
			$('body').find('div [@id=cs]').each(function(){
				$(this).hide();
			});
			$('#zajb').hide();
		}else{
			qyjbxx_detailHtml="basic/publicsystem/QyjbxxDetail.jsp";
			
			$('body').find('div [@id=qy]').each(function(r){
				$(this).hide();
			});
			$('body').find('div [@id=cs]').each(function(){
				$(this).show();
			});
			$('#zajb').show();
		}
	});
</script>

</head>
<body>
<input type="hidden" id="d_csflid" value="">
<input type="hidden" id="p_gxdwbm" value=""/>
<input type="hidden" id="p_qyid" value=""/>
<table width="100%" cellpadding="0" cellspacing="0"  class="tableborder">
  <tr>
    <td class="queryfont"><div id="cs" >场所营业日志查询</div><div id="qy" style="display:none">企业营业日志查询</div></td>
  </tr>
  <tr>
    <td class="tdbg">
    	<table width="100%" border="0" cellspacing="0" cellpadding="2">
				<tr>
					<td width="11%" class="pagedistd">行业类别</td>
					<td width="22%" class="pagetd"><select id="p_hylbdm"></select></td>
					<td width="11%" class="pagedistd"><div id="cs" >场所类别</div><div id="qy" style="display:none">企业类别</div></td>
					<td width="22%" class="pagetd"><select name="select" id="p_qyzflbm" ><option></option></select></td>
					<td width="11%"  class="pagedistd">管辖单位</td>
					<td class="pagetd"><input type="text" class="inputstyle"id="p_gxdwmc" value="" readonly="readonly"></td>
				</tr>
				<tr>
					<td  class="pagedistd"><div id="cs" >场所名称</div><div id="qy" style="display:none">企业名称</div></td>
				    <td class="pagetd"><input type="hidden" id="p_qybm" /><input type="text" class="inputstyle" id="p_qymc" readonly /></td>
					<td class="pagedistd">营业执照编号</td>
				    <td class="pagetd" ><input type="text" class="inputstyle"  id="p_zjbh" value=""></td>
				    <td  class="pagedistd">从业人员数量</td>
				    <td class="pagetd">
				    <table><tr><td><select style="width:60px;" id="p_relation">
                    <option></option>
                    <option value="3">等于</option>
                    <option value="4">大于</option>
                    <option value="5">小于</option>
                    <option value="1">大于等于</option>
                    <option value="2">小于等于</option>
                    </select></td>
                    <td><input type="text" class="inputstyle3" style="width:56px;" id="p_zrs" ></td>
                  </tr></table></td>
		 		 </tr>
				<tr >
					<td colspan="4">
						<table width="100%" border="0" cellspacing="0" cellpadding="2">
							<tr id = "zajb" >
								<td width="11%" class="pagedistd">营业状态</td>
						    	<td width="22%" class="pagetd" ><select id="p_yyztdm">
						    	<option></option></select></td>
						    	<td width="11%" class="pagedistd">治安级别</td>
						    	<td width="22%" class="pagetd"><select id="p_zabdm">
				            	<option></option></select></td>
							</tr>
						</table>
					</td>
					<td colspan="2">
                        <table width="62" border="0" align="right" cellpadding="0" cellspacing="0">
		                    <tr>
		                      <td><a href="#" class="searchbutton" id="querys" onClick="ylcsjbxx_setPageList(1);">查询</a></td>
		                    </tr>
		                </table>
                    </td>
				</tr>

    	</table>
    </td>
  </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table>
<div id="ylcsjbxx_detail" class="page-layout" src="#" style="z-index:2000;  top:10px; left:0px;">
</div>
<div id="tabledata" style="width:100%;">
	<table id="table1" width="100%">
	  <thead>
	    <tr>
	     	<th name="l_qybm"><div id="cs" >场所备案编码</div><div id="qy" style="display:none">企业代码</div></th>
	     	<th name="l_qymc"><div id="cs" >场所名称</div><div id="qy" style="display:none">企业名称</div></th>
	     	<th name="l_zrs">总人数</th>
	     	<th name="l_cszflmc"><div id="cs" >场所类别</div><div id="qy" style="display:none">企业类别</div></th>
	     	<th name="l_ztmc">状态</th>
	     	<th name="l_zajbmc">治安级别</th>
			<th name="">操作</th>
	    </tr>
	  </thead>
	  
	</table>	
</div>
</body>
</html>