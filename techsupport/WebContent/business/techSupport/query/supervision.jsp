<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/base.jsp" %>

<!DOCTYPE div PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>督办进展</title>
		<script type="text/javascript">
			var supervision_div_id="supervision_list_div";
			var supervision_table_id="supervision_list_table";
			//进展内部容器宽度
			var supervision_div_inner_width=650;
			//督办进展表格宽度
			var ingridWidth = 600;
			var supervision_tables;
			$(function(){
				//设置支持单id
				$('#sv_st_id').val(dataid);

				$('#supervision_process').width(supervision_div_inner_width);

				//$('#'+supervision_div_id).width(ingridWidth);
			//	$('#'+supervision_div_id).css('margin-left','auto').css('margin-right','auto');
				
				//supervision_tables = $('#'+supervision_table_id);
				load_page_supervision_query(supervision_div_id);
				
				daggleDiv(supervision_div);
				
				supervision_query(1);

				//绑定保存按钮
				$('#saveBtn').click(function(){
					if(verify()){
						var params = getSubmitParams('#supervision_process [name~=supervision.]');
						$.post(supervision_url,params,function(data){
							$("#"+supervision_div).hideAndRemove("show");
						});
					}
					
				});

				//设置只读
				$('.ro').attr('readOnly',true);

			});


			function load_page_supervision_query(divpageid){
				supervision_tables=$("#"+divpageid).html();
				supervision_query(1,'#');
			}
			
			function set_supervision_list(pageno,url){	
				$("#"+supervision_div_id).html(supervision_tables);
				createXML("sv_");
				if (url==null || url=="undefined"){
					url=supervision_query_url;
				}
				return url;
			}

			/**
			 * 查询函数
			 * */
			function supervision_query(pageno,url){
				
				if (true){
					url=set_supervision_list(pageno,url);
					// create the grid
					// returns a jQ object with a 'g' property - that's ingrid
					var mygrid2 = $("#"+supervision_table_id).ingrid({ 
													url: url,	
													height:70,
													ingridPageWidth:ingridWidth,
													isPlayResultNull: false,
													havaWaiDivGunDong: true,
			                                      	ingridPageParams:sXML,
			                                      	onRowSelect:null,
													pageNumber: pageno,
													colWidths: ["14%","70%","16%"]				
												});
					}
			}

			function verify(){
				if (!checkControlValue("supervision_suggestion","String",1,4000,null,1,"督办进展填写"))
					return false;
				if (!checkControlValue("supervision_person_name","String",1,20,null,1,"督办人"))
					return false;
				if (!checkControlValue("sv_st_id","String",1,30,null,1,"支持单唯一键"))
					return false;

				
				return true;
			}
		</script>
	</head>

	<body>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
		    <tr>
		      <td align="left" class="title1">督办进展</td>
		      <td align="right"><a href="#" id="closeDiv" onclick='$("#"+supervision_div).hideAndRemove("show");' class="close"></a></td>
		    </tr>
		</table>
		
		<div id="supervision_process" style="margin-left: auto; margin-right: auto; padding-top: 10px;padding-bottom: 10px;">
			<input type="hidden" id="sv_st_id" name="supervision.st_id">
			<input type="hidden" id="supervision_person_id" name="supervision.supervision_person.userid" value="<%=user.getUserid()%>">
			<%-- 督办进展显示 --%>
			<fieldset>
				<legend>督办进展</legend>
				<div id="supervision_list_div" style="margin-left: auto;margin-right: auto;text-align: center;">
					<table id="supervision_list_table" >
						<thead>
							<tr>
								<th>督办人</th>
								<th>督办进展</th>
								<th>督办时间</th>
							</tr>
						</thead>
					</table>
				</div>
			</fieldset>
			<%-- 督办填写 --%>
			<fieldset>
				<legend>督办</legend>
				<div class="row">
					<div class="column">
						<div >
							<label class="label red">督办填写:</label>
							<textarea class="item  inputstyle" style="width:470px ! important;height: 80px;" name="supervision.supervision_suggestion" id="supervision_suggestion"></textarea>
						</div>
						<div class="clear-column"></div>
					</div>
					<div class="clear-row"></div>
				</div>
				
				<div class="row">
					<div class="column">
						<div>
							<label class="label red">日期:</label>
							<input type="text" class="date  item  inputstyle ro" name="supervision.supervision_date" id="supervision_date" value="<%=dateNow%>">
						</div>
						<div class="clear-column"></div>
					</div>
					
					<div class="column">
						<div>
							<label class="label red">督办人:</label>
							<input type="text" class="date  item  inputstyle ro" name="supervision.supervision_person.username" id="supervision_person_name" value="<%=username%>">
						</div>
						<div class="clear-column"></div>
					</div>
					<div class="clear-row"></div>
				</div>
			</fieldset>	
			
			
			
			<div class="row">
				<div class="column" style="width: 70%">
					<div class="clear-column"></div>
				</div>
				<div class="column" style="width: 120px;">
					<a class="item submitbutton" id="saveBtn" href="#">保存</a>
					<div class="clear-column"></div>
				</div>
				<div class="clear-row"></div>
			</div>
		</div>
		
	</body>

</html>

