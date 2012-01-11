jQuery.fn.selectBox = function(options){
	var params = {
			url:"sysadmin/queryChSelDict_dict_item.action",
			code:null,
			query:"",
			valueId:null,
			textId:null
	};
	var itemIdLd=options.query;
	var sourceSelect = jQuery(this);
	sourceSelect.attr('code',options.code);
	var check_wi='148';
	if(options.width!=undefined&&options.width!=null&&options.width!=""){
		
		check_wi=options.width;
	}
	sourceSelect.unbind('mouseover');//移除事件，以避免事件冲突
	sourceSelect.css('width',check_wi);//设置宽度，也可以在此增加class样式
	var newwidth_select=sourceSelect.css('width').substring(0,sourceSelect.css('width').length-2);//取出目前的宽度
	sourceSelect.css('width',parseInt(newwidth_select)+7);//在原宽度上再增加2像素
	if(options.code!=undefined||options.code!=null||options.code!=""){//code不为空时将其加载到select的属性中
		sourceSelect.attr('code',options.code);
	}
	var selectLength=sourceSelect.find('option').length;//取出目前下拉菜单中的数据条数
	/**
	 * 设计思路
	 * select中无数据时需要默认写上字典的第一个数据，之后绑定事件，当鼠标滑过时才加载数据（通常这一条数据为空行）
	 * select只有一条数据时绑定触发事件，不加载数据
	 * select中有多条数据时清空数据，判断第一条如果是空行则保留， 之后绑定事件
	 * 如果code为空则不进行操作
	 */
	if(options.code==undefined||options.code==null||options.code==""){//未填写code 表示不需要加载字典
		return ;
	}
	if(selectLength>0){//多条记录
		var option=sourceSelect.find('option').val();//取出第一条记录
		sourceSelect.empty();//取出第一条记录后清除select中的数据，以便于加载新的值
		if(option==''){//如果第一条值是空白，那么继续保持该状态
			sourceSelect.append("<option></option>");
		}
		sourceSelect.bind('mouseover',function(){
			clickSelectBoxFunction(sourceSelect,options,itemIdLd);
		});
		return ;//多条数据直接绑定事件，不加载数据
	}
	if (options)
	{
		jQuery.extend(params, options);
	}
	if(params.query==undefined||params.query==null||params.query==''){
		params.query='';
	}
	if(params.code!=undefined&&params.code!=null&&params.code!=""&&selectLength==0){//当select中无数据时才加载一条
		$.ajax({
			  type: "POST",
			  url:"sysadmin/queryChSelDict_dict_item.action",
			  async: false,
			  data: {dict_code:params.code,superId:params.query},
			  dataType:"json",
			  timeout:1000,
			  success: function(result){
					  sourceSelect.append("<option value='"+result.ldata[0].fact_value+"' item='"+result.ldata[0].item_id+"'>"+result.ldata[0].display_name+"</option>");
					  sourceSelect.bind('mouseover',function(){//绑定事件
							clickSelectBoxFunction(sourceSelect,options,itemIdLd);
						});
			  }
			});
	}
}
function clickSelectBoxFunction(obj,options,itemIdLd){
	var roptions = obj.find('option').length;
	if(roptions>1){//大于1条记录则不操作，只有select为空或者1条记录时才加载数据，否则视为已经增加了事件
		return ;
	}
	if(itemIdLd==undefined||itemIdLd==null||itemIdLd==''){
		itemIdLd='';
	}else{
		alert(itemIdLd);
	}
	if(options.code!=undefined&&options.code!=null&&options.code!=""){
		$.ajax({
			  type: "POST",
			  url:"sysadmin/queryChSelDict_dict_item.action",
			  async: false,
			  data: {dict_code:options.code,query_simplepin:options.query,superId:itemIdLd},
			  dataType:"json",
			  timeout:1000,
			  success: function(result){
				  var i=0;
				  var lfvalue='';//首先读取出当前字典的值与title
				  var lftitle='';
				  var lfselect='';
				  	if(obj.find('option').val()!=''){//当第一条不为空时清空数据后才加载数据
				  		lfvalue=obj.find('option').val();
				  		lftitle=obj.find('option').attr('title');
				  		obj.empty();
				  	}
				  	for( i=0;i<result.ldata.length;i++){
				  		if(result.ldata[i].fact_value==lfvalue||result.ldata[i].display_name==lftitle){//当数据与默认值相同时设定为selected
				  			lfselect="selected='selected'";
				  		}
				  		obj.append("<option value='"+result.ldata[i].fact_value+"' item='"+result.ldata[i].item_id+"' title='"+result.ldata[i].display_name+"'"+lfselect+">"+result.ldata[i].display_name+"</option>");
				  		lfselect="";//使用之后清空值
				  	}
			  }
			});
	}
	obj.unbind('mouseover');//移除事件，以避免事件冲突
}
jQuery.fn.setValue = function(text){//setValue与setText可以走同一个方法
	var sourceSelect = jQuery(this);
	findValue(sourceSelect,text);
}
jQuery.fn.setText = function(text){
	var sourceSelect = jQuery(this);
	findValue(sourceSelect,text);
}
function findValue(sourceSelect,text){
	var roptions = sourceSelect.find('option').length;//首先判断条数
	if(roptions<=1){//当小于或等于1条记录时判定为尚未加载数据
		var code=sourceSelect.attr('code');//取出该下拉菜单的字典项//通常进行定位时都是有code的，所以下面就不判断code是否存在了
		sourceSelect.empty();//定位时清空数据，只要定位的一条数据
		$.ajax({
			  type: "POST",
			  url:"sysadmin/queryChSelDict_dict_item.action",
			  async: false,
			  data: {dict_code:code},
			  dataType:"json",
			  timeout:1000,
			  success: function(result){
				  var i=0;
				  for(i=0;i<result.ldata.length;i++){
					  if(result.ldata[i].fact_value==text||result.ldata[i].display_name==text){//字典值或者显示名称与传来的值相等时写到页面上,只写这一条 其他的点击才加载
						  sourceSelect.append("<option value='"+result.ldata[i].fact_value+"' item='"+result.ldata[i].item_id+"' title='"+result.ldata[i].display_name+"'>"+result.ldata[i].display_name+"</option>");
						  sourceSelect.bind('mouseover',function(){//绑定事件
								clickSelectBoxFunction(sourceSelect,options,itemIdLd);
							});
					  }
				  }
					 
			  }
			});
	}else{//大于1时判定为已经加载数据，直接定位到该数据
		obj.find('option').each(function(r){//循环每一条数据 
			var $option=obj.find('option').eq(r);
			if($option.val()==text||$option.attr('title')==text){//当找到这条数据时设为选中
				$option.attr('selected','selected');
			}
		});
	}
}
jQuery.fn.selectBoxhylb = function(options){
	var selData;
	var params = {
			url:"sysadmin/querySelDicthylb_dict_item.action",
			state:"",
			code:null,
			order:0,
			query:"",
			width: "150px"
			//selValue:"",
			//selText:""
	};
	var sourceSelect = jQuery(this);
	if (options)
	{
		jQuery.extend(params, options);
	}
	
	sourceSelect.width(params.width);
	if(params.code!=undefined && params.code!=null && params.code!=""){
		selData = {dict_code:params.code,query_simplepin:params.query,orderBySib_order:params.order};
	}else{
		selData = {dataxml:sXML};
	}
	 var flength=sourceSelect.find("option").length;
	  sourceSelect.empty();
	  if(flength!=0){//默认第一行有数据，当做其为空白行
		  sourceSelect.append("<option></option>");
	  }
	if(params.state==undefined || params.state==null || params.state==""){//行业类别不多，可以直接加载
		$.ajax({
			  type: "POST",
			  url: params.url,
			  async: false,
			  data: selData,
			  dataType:"json",
			  timeout:1000,
			  success: function(result){
					for( var h=0;h<result.ldata.length;h++){
						sourceSelect.append("<option value='"+result.ldata[h].fact_value+"' title='"+result.ldata[h].display_name+"'>"+result.ldata[h].display_name+"</option>");
					}
			  }
			});
	}else{
		sourceSelect.combobox(params);
	}
	if(sourceSelect.find("option").length<=1){
	    sourceSelect.setAttr("readonly",true);
	}	
}