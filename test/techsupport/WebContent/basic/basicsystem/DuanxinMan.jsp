<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
	<script>
	var initTable = $('<table><tr><td name="`bjdd`" text="报警地点">报警地点</td></tr><tr><td name="`bjddxxdz`" text="报警地点详细地址">报警地点详细地址</td></tr>'+
						'<tr><td name="`gxdwmc`" text="管辖单位名称">管辖单位名称</td></tr><tr><td name="`bjlx`" text="报警类型">报警类型</td></tr>'+
							'<tr><td name="`xm`" text="嫌疑人姓名">嫌疑人姓名</td></tr><tr><td name="`sfzh`" text="嫌疑人身份证号">嫌疑人身份证号</td></tr>'+
								'<tr><td name="`bjsj`" text="报警时间">报警时间</td></tr></table>');
	var zd_tables;
	var addTrData,removeTrData ;
	var trClassStyle = 0;
$(document).ready(function() {
	addTrData = null;
	removeTrData = null;
	modUrl="sysadmin/modify_globalpar.action";
	detailUrl="sysadmin/query_globalpar.action";
	loadPage_zd("kxzd_tabledata","kxzd_table1");
	loadPage_zd("sjzd_tabledata","sjzd_table1");
	
	initIngridData();
	setDetail();
}); 
function initIngridData(){
	initTable.find("tr").each(function(i){
		if(i%2==0)
			$(this).addClass("grid-row-style1");
		else
			$(this).addClass("grid-row-style2");
		
		$(this).find("td").addClass("grid-col-style1");
	});
		
	$("#kxzd_table1").append(initTable.html());
	
	var trList = $("#kxzd_table1").find("tr:not(tr:first)");
	
	trList.dblclick(function(){
		$("#sjzd_table1").append(addTrInit($(this)));
		var content = $("#zdywbnr").val()+$(this).text()+$(this).find("td").attr("name");
		$("#zdywbnr").val(replaceAll(content," ",""));
	});
	
	trList.each(function(){
		var currTrClass;
		$(this).click(function(){
			listEach(trList);
			jQuery(this).removeClass("grid-row-hover").addClass("grid-row-sel").attr("_selected","true") ;
			addTrData = $(this);
		});	
	});
}

function addTrInit(tr){
	var returnTr ;
	if(trClassStyle==0){
		returnTr = tr.clone().attr("class","").addClass("grid-row-style1").attr("_selected","false")
		trClassStyle=1;
	}else{
		returnTr = tr.clone().attr("class","").addClass("grid-row-style2").attr("_selected","false")
		trClassStyle=0;
	}
	
	returnTr.click(function(){
			listEach(jQuery(this).parent().find("tr"));
			jQuery(this).addClass("grid-row-sel").attr("_selected","true") ;
			removeTrData = $(this);
		});		
		
	return returnTr;
}

function listEach(lst){
	var tr_class;
	lst.each(function(i){
				if(i%2==1)
					tr_class = "grid-row-style2";
				else
					tr_class = "grid-row-style1";
				jQuery(this).removeClass("grid-row-sel").addClass(tr_class).attr("_selected","false");
		});		
}

function loadPage_zd(divpageid,zd_tableid){
	zd_tables=$("#"+divpageid).html();
	setPageList_zd(1,"#",divpageid,zd_tableid);
}
	
function setPageList_zd(pageno,url,divpageid,zd_tableid){	

	url=setList_zd(divpageid,pageno,url);
	// create the grid
	// returns a jQ object with a 'g' property - that's ingrid
	var mygrid1 = $("#"+zd_tableid).ingrid({ 	
							ingridPageParams:sXML,						// height of our datagrid (scrolling body area)
							tableid : zd_tableid,
							ingridPageWidth: 285,
							url: url,	
							height: pageHeight-312,
							paging:false,
							sorting:false,
							colWidths: ["100%"]									
						});				

}	

function setList_zd(divpageid,pageno,url){	
	$("#"+divpageid).html(zd_tables);	
	//createXML("g_");
	if (url==null || url=="undefined"){
		url="#";
	}
	return url;
}

function updatediv (json) { 
	$("#m_globalparcode").val(setNull(json.LGlobalpar[0].globalparcode));
	$("#m_globalparname").val(setNull(json.LGlobalpar[0].globalparname));
	$("#m_globalparvalue").val(setNull(json.LGlobalpar[0].globalparvalue));
}	


function setUpdate_Duanxin(){
	var zdywbnr = $("#zdywbnr").val();
	if(zdywbnr != ""){
	$("#m_globalparvalue").val(zdywbnr);
		setParams("m_");
		jQuery.post(modUrl,params,updateDuanxinback,"json"); 
	}	
}

function updateDuanxinback(json){
	if  (json.result=="success"){
		jAlert("设置自定义短信内容成功",'保存信息');
		$("#sjzd_table1").find("tr:not(tr:first)").remove();
	}else{
		jAlert("设置自定义短信内容失败",'错误信息');
		setDetail();
	}	
	$("#zdywbnr").val("");
}

function setReset(){
	addTrData = null;
	$("#kxzd_table1").find("tr[_selected='true']").attr("_selected","false").removeClass("grid-row-sel");
	setDetail();
	$("#sjzd_table1").find("tr:not(tr:first)").remove();
	$("#zdywbnr").val("");
}	

function moveOptionUp(){
	if(addTrData!=null){
		$("#sjzd_table1").append(addTrInit(addTrData));
		var content = $("#zdywbnr").val()+addTrData.text()+addTrData.find("td").attr("name");
		$("#zdywbnr").val(replaceAll(content," ",""));
	}else{
		jAlert("请选择要添加的选项","提示信息");
	}
}

function moveOptionDown(){
	if(removeTrData!=null){
		var removeListTr = $("#sjzd_table1").find("tr:not(tr:first)");
		var listLength = removeListTr.length;
		if(removeListTr.length==1){
			$("#zdywbnr").val("");
		}else{
		
			var oldValue = $("#zdywbnr").val();
			var removeName = removeTrData.find("td").attr("name");
			var removeText = removeTrData.find("td").attr("text");
			var nameIndex = oldValue.indexOf(removeName);
			if(nameIndex==oldValue.lastIndexOf(removeName)){
				oldValue = oldValue.substring(0,nameIndex-removeText.length)+oldValue.substring(nameIndex);
				$("#zdywbnr").val(oldValue.replace(removeName,""));
			}else{
				var trIndex = removeListTr.index(removeTrData);
				if(trIndex == listLength-1){
					oldValue = oldValue.substring(0,oldValue.length-removeName.length-removeText.length);
					$("#zdywbnr").val(oldValue);
				}else{
					var removeLength = 0;
					var content ="";
					for(var index=0;index<listLength;index++){
						if(index!=trIndex){
							var oneTdObj = removeListTr.eq(index).find("td");
							content += oneTdObj.attr("text") + oneTdObj.attr("name");
						}
					}
					$("#zdywbnr").val(content);
					/*
					var subValue = "";
					var eachIndex = 0;
					while(oldValue.indexOf(removeName)>-1){
						oldValue = oldValue.substring(nameIndex+removeName.length);
						subValue += oldValue.substring(0,nameIndex+removeName.length);
						eachIndex++;
						if(nameIndex==eachIndex){
							$("#zdywbnr").val();
							break;
						}
					}
					*/
				}
			}
		}
		
		removeTrData.remove();
		
		$("#sjzd_table1").find("tr:not(tr:first)").each(function(i){
				if(i%2==1)
					tr_class = "grid-row-style2";
				else
					tr_class = "grid-row-style1";
				jQuery(this).attr("class","").addClass(tr_class).attr("_selected","false");
		});		
			
		removeTrData = null;
	}else{
		jAlert("请选择要删除的选项","提示信息");
	}
}

function replaceAll(content,oldStr,newStr){
	return content.replace(new RegExp(oldStr,"gm"),newStr);
}
</script>
	<body>
		<div>
			<input type="hidden" id="q_globalparcode" value="zdydxbjnr" />
			<input type="hidden" id="m_globalparcode" value="zdydxbjnr" />
			<div align="right">
				<table width="100%" cellpadding="0" cellspacing="0"
					class="tableborder">
					<tr>
						<td class="queryfont">
							自定义短信报警内容
						</td>
					</tr>
				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="3"></td>
					</tr>
				</table>
			</div>
			<table cellpadding="0" cellspacing="0" class="tableborder" width="700">
				<tr>
					<td>
						<table width="100%" cellpadding="0" cellspacing="0" class="tableborder">
							<tr>
								<td width="43%" align="left" class="tableborder">

									<div id="kxzd_tabledata" style="width: 100%;">

										<table id="kxzd_table1" width="100%">
											<thead>
												<tr>
													<th name="l_sjbzwm">
														可选项
													</th>
												</tr>
											</thead>

										</table>
									</div>
								</td>
								<td width="14%" class="tableborder">
									<table width="100%" border="0" align="center" cellpadding="0"
										cellspacing="0">
										<tr>
											<td height="30">
												<a href="#" class="submitlongbutton" id="querys4"
													onClick="moveOptionUp();">添加到已选项</a>
											</td>
										</tr>
										<tr>
											<td height="30">
												<a href="#" class="submitlongbutton" id="querys5"
													onClick="moveOptionDown();">&nbsp;&nbsp;删除已选项&nbsp;</a>
											</td>
										</tr>
									</table>
								</td>
								<td width="43%" align="right" class="tableborder">
									<div id="sjzd_tabledata" style="width: 100%;">
										<table id="sjzd_table1" width="100%" >
											<thead>
												<tr>
													<th name="l_sjbzwm">
														已选项
													</th>
												</tr>
											</thead>

										</table>
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%" id="modify" align="center" cellpadding="0" cellspacing="0" class="tableborder" >
							<tr>
								<td class="distd" width="15%">
									原自定义短信内容
								</td>
								<td class="detailtd">
									<textarea id="m_globalparvalue" style="width: 99%; height: 50" readonly class="readonly"></textarea>
								</td>
							</tr>
							<tr>
								<td class="distd" width="15%">
									新自定义短信内容
								</td>
								<td class="detailtd">
									<textarea id="zdywbnr" style="width: 99%; height: 50"></textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<table>
										<tr align="center">
											<td align="right">
												<a href="#" id="addbutton" hidefocus="true"
													class="submitbutton" title="保存" onclick='setUpdate_Duanxin();'>保存</a>
											</td>
											<td align="left">
												<a href="#" id="addbutton" hidefocus="true"
													class="submitbutton" title="取消" onclick='setReset();'>取消</a>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>