<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../../public/common.jsp"%>
<%@include file="../common/base.jsp" %>
<link href="<%=tsBase %>/common/css/basets.css" type="text/css" rel="stylesheet"></link>
<script type="text/javascript">
<!--
	$(function(){
		//设置时间控件
		$('.date').each(function(){
			$(this).datepicker();
			$(this).attr('readOnly',true);
		});
		
		if(departfullcode.indexOf('.cpfab.') > -1)
			$('#jsb_block').hide();
		if(departfullcode.indexOf('.jskfb.') > -1)
			$('#cpb_block').hide();

		//非阶段性隐藏
		relateHide('devcpstage');
		relateHide('psgcpstage');
		//当阶段按钮取消的时候，需要情况阶段时间
		$('#devcpstage,#psgcpstage').click(function(){
			if(!$(this).attr('checked'))
				$('.'+$(this).attr('id')).find('input:text').val('');	
		});
//		初始化提请反馈必填项颜色信息
//		if($('#p_deptName').val().indexOf('方案部') > -1){
		if(	departfullcode.indexOf('.cpfab.') > -1){
			$('#p_psgCompDate').prev('label').addClass('blue');
			// 修正bug 添加必要的颜色信息
			$("#psgcpstage").blur(function() {
				if ($(this).attr('checked')) {
					$('.' + this.id).addClass('blue');
				} else {
					$('.' + this.id).removeClass("blue");
				}
			});
		}
		if(departfullcode.indexOf('.jskfb.') > -1){
			$('#p_devCompDate').prev('label').addClass('blue');
			// 修正bug 添加必要的颜色信息
			$("#devcpstage").blur(function() {
				if ($(this).attr('checked')) {
					$('.' + this.id).addClass('blue');
				} else {
					$('.' + this.id).removeClass("blue");
				}
			});
		}
		
		$('#doFeedBackBtn').click(function(){
			if(!toFeedbackVerify()){
				return;
			}
			var params = {};
			
			$('[name^=track.]').each(function(){
				params[$(this).attr('name')]=$(this).val();
			});
			
			//设置当前的track.stId
			params['track.stId']=$('input:hidden[name=st.id]').val();
			//设置trSt,保存环节信息
			$('[name^=trSt.]').each(function(){
				params[$(this).attr('name')]=$(this).val();
			});
			params['trSt.id']=$('input:hidden[name=st.id]').val();
			
			//设置任务号
			params.taskId = $('#p_taskId').val();

			$.post(toFeedbackURL,params,function(data){
				if(!data){
					alert("传输错误，管理人员");
				}
				data = eval("("+data+")");
				
				if(data.returnNo == 0){
//					alert(data.returnMsg);
					$(detailWindow).empty();
					$(detailWindow).hideAndRemove("show");
					worksheetQuery(1);
					
					
					
				}
				else{
					alert(data.returnMsg);
				}
			});
		});
	});
//-->
</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="left" class="title1">完成时间</td>
		<td align="right"><a href="#" id="closeDiv"
			onclick='$("#comp_time_div").hideAndRemove("show");' class="close"></a>
		</td>
	</tr>
</table>
<div class="row">
	<div class="column column-block2" id="cpb_block">
		<div>
			<label class="label label-80">产品方案部:</label>
		</div>
		<div class="clear-column"></div>


		<div class="row">
			<div class="column">
				<label class="label label-80">实际完成时间:</label> <input type="text"
					class=" item inputstyle  date" name="trSt.psgCompDate"
					id="p_psgCompDate">
				<div class="clear-column"></div>
			</div>
			<div class="clear-row"></div>
		</div>
		<div class="row">
			<div class="column">
				<label class="label label-80">阶段:</label> <input type="checkbox"
					class=" item" id="psgcpstage">
				<div class="clear-column"></div>
			</div>
			<div class="clear-row"></div>
		</div>

		<div class="row">
			<div class="column">
				<div class="psgcpstage">
					<label class="label label-80">需求:</label> <input type="text"
						class=" item inputstyle date  " name="trSt.psgDsCompDate"
						id="p_psgDsCompDate">
				</div>
				<div class="clear-column"></div>
			</div>
			<div class="clear-row"></div>
		</div>

		<div class="row">
			<div class="column">
				<div class="psgcpstage">
					<label class="label label-80">实施:</label> <input type="text"
						class=" item inputstyle date " name="trSt.psgIsCompDate"
						id="p_psgIsCompDate">
				</div>
				<div class="clear-column"></div>
			</div>
			<div class="clear-row"></div>
		</div>

		<div class="clear-column"></div>
	</div>
	<div class="column column-block2" id="jsb_block">
		<div>
			<label class="label label-80">技术开发部:</label>
		</div>
		<div class="clear-column"></div>


		<div class="row">
			<div class="column">
				<label class="label label-80">实际完成时间:</label> <input type="text"
					class=" item inputstyle date" name="trSt.devCompDate"
					id="p_devCompDate">
				<div class="clear-column"></div>
			</div>
			<div class="clear-row"></div>
		</div>

		<div class="row">
			<div class="column">
				<label class="label label-80">阶段:</label> <input type="checkbox"
					class=" item" id="devcpstage">
				<div class="clear-column"></div>
			</div>
			<div class="clear-row"></div>
		</div>

		<div class="row">
			<div class="column">
				<div class="devcpstage">
					<label class="label label-80">设计:</label> <input type="text"
						class=" item inputstyle date " name="trSt.devDsCompDate"
						id="p_devDsCompDate">
				</div>
				<div class="clear-column"></div>
			</div>
			<div class="clear-row"></div>
		</div>

		<div class="row">
			<div class="column">
				<div class="devcpstage">
					<label class="label label-80">开发:</label> <input type="text"
						class=" item inputstyle date " name="trSt.devDdCompDate"
						id="p_devDdCompDate">
				</div>
				<div class="clear-column"></div>
			</div>
			<div class="clear-row"></div>
		</div>

		<%-- ++ 新需求 技术开发部添加阶段测试 --%>
		<div class="row">
			<div class="column">
				<div class="devcpstage">
					<label class="label label-80">测试:</label> <input type="text"
						class=" item inputstyle date " name="trSt.devDtCompDate"
						id="p_devDtCompDate">
				</div>
				<div class="clear-column"></div>
			</div>
			<div class="clear-row"></div>
		</div>
		<%-- -- 新需求 技术开发部添加阶段测试 --%>
	</div>
	<div class="clear-row"></div>
</div>
	<div class="row">
		<div class="column" style="width: 70%">
			<div class="clear-column"></div>
		</div>
		<div class="column" style="width: 120px;">
			<a class="item submitbutton" id="doFeedBackBtn" href="#">保存</a>
			<div class="clear-column"></div>
		</div>
		<div class="clear-row"></div>
	</div>