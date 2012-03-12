/**
 * 技术支持单共有函数
 * 
 */

//设置DIV层内嵌jsp，覆盖setUrl()方法
function setDictUrl(divid,url,data,func)
{
	$("#"+divid).empty();
	$("#"+divid).load(url,data,func);
}

//弹出DIV层，覆盖setAddPage()方法
function setDictPage(data,func)
{
	setDictWidth(detailidDict,addWidthDict);
	setDictUrl(detailidDict,addHtmlDict,data,func);
}

function getUserofDept(mcId, dmId, gxdwbm,rolename_list,is_recursive) {
	gmcId = mcId;
	gdmId = dmId;
	gGxdwbm = gxdwbm;
	if ($("#divs_" + mcId).length > 0) {
		return;
	} // yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId, dmId);
	detailidDict = "divs_" + gmcId;// DIV层的ID
	addHtmlDict = "business/techSupport/common/UserofDeptDropDown.jsp";// DIV层内嵌的jsp页面
	addWidthDict = "400"; // DIV层的宽度

	var s_rolename_list = "";
	if (Object.prototype.toString.call(rolename_list) == "[object Array]"){
		s_rolename_list = rolename_list.join(",");
	}
	else if (typeof(rolename_list) == "string"){
		s_rolename_list = rolename_list;	
	}
	if(!is_recursive)
		is_recursive = null;
	setDictPage({rolename_list:s_rolename_list,is_recursive:is_recursive});
}

/**
 * 获取字典项信息
 * 
 * @param config
 *            {url:'字典后台服务地址', dictcode:'字典代码', value:'真实值'}
 * @return 符合条件的字典项对象[数组]
 */
function getDictitem(config) {
	var _config = {
		url : 'sysadmin/queryChSelDict_dict_item.action',
		dictcode : '',
		value : ''
	};
	var url_query = "sysadmin/query_dict_item.action";
	var _ret;
	var _param = {};
	// <Params>
	// <Param name="item_id">31433</Param>
	// </Params>
	var dataxml = "<Params>";

	$.extend(_config, config);

	if (!_config.url)
		throw new Error("参数config {url}信息为空");
	if (!_config.dictcode)
		throw new Error("参数config {dictcode}信息为空");

	_param['dict_code'] = _config.dictcode;

	dataxml += '<Param name="dict_code">' + _config.dictcode + '</Param>';
	if (_config.value) {
		_param['fact_value'] = _config.value;
		_param['query_simplepin'] = _config.value;
		_config.url = url_query;
		dataxml += '<Param name="fact_value">' + _config.value + '</Param>';
		dataxml += '<Param name="query_simplepin">' + _config.value
				+ '</Param>';
	}

	dataxml += "</Params>";
	_param['dataxml'] = dataxml;
	$.ajax({
				async : false,
				type : 'post',
				url : _config.url,
				data : _param,
				dataType : 'json',
				success : function(json) {

					if (json.LDict_item && json.LDict_item.length > 0) {
						_ret = json.LDict_item;
					} else if (json.ldata && json.ldata.length > 0) {
						_ret = json.ldata;
					}

				}
			});
	return _ret;
}

/**
 * 弹出窗口
 * 
 * @param detailid
 *            对话框容器ID
 * @param width
 *            对话框的宽度
 * @param url
 *            对话框加载的内容地址
 * @param config
 *            需要传递给对话框的参数，使用JSON格式
 */
function detailDialog(detailid, width, url, config) {
	setWidth(detailid, width);
	$("#" + detailid).empty();
	$("#" + detailid).load(url, config);
	$("#" + detailid).show("slow");
	upAllPage(detailid);
	bindDocument(detailid);
}

/**
 * 自动通过字典项生成HTML组件工具
 * 
 * @param radioTemplateHtml
 *            HTML组件模板 {fact_value} 对应
 *            字典项实际值，{display}对应字典项显示值,{append_value}对应字典项附加值，{i}相当于是一个序列。
 * @param panel
 *            容器
 * @param dict_code
 *            字典代码
 * @param condition
 *            过滤不需要的条件(dict_item代表字典项，可以使用字典项里面的属性)
 */
function buildHTMLComponentByDict(radioTemplateHtml, panel, dict_code,
		condition) {
	var dict_items = getDictitem({
				dictcode : dict_code
			});

	var dict_items2 = [];
	if (condition) {

		for (i = 0; i < dict_items.length; i++) {
			var the_condition = condition.replace(/dict_item\./, 'dict_items['
							+ i + ']\.');
			var ret = eval("(" + the_condition + ")");
			if (!ret) {
				dict_items2.push(dict_items[i]);
			}

		}
	}
	var radios = '';
	for (i = 0; i < dict_items2.length; i++) {

		var the_radio = radioTemplateHtml.replace(/{fact_value}/g,
				dict_items2[i].fact_value);
		the_radio = the_radio
				.replace(/{display}/g, dict_items2[i].display_name);
		the_radio = the_radio.replace(/{append_value}/g,
				dict_items2[i].append_value);
		the_radio = the_radio.replace(/{i}/g, i);

		radios += the_radio;
	}

	$(panel).html(radios);
}

// 非阶段性隐藏
/**
 * 开关式隐藏组件，会隐藏和class == relateId 的元素
 * 
 * @param relateId
 *            级联隐藏的ID
 */
function relateHide(relateId) {
	// 非阶段性隐藏
	$('.' + relateId).each(function() {
				$(this).hide();
			});
	// 非阶段性隐藏
	$('#' + relateId).blur(function() {
				if ($(this).attr('checked')) {
					$('.' + this.id).show();
				} else {
					$('.' + this.id).hide();
				}
			});

	$('#' + relateId).click(function() {
				$(this).focus();
				$(this).blur();
			});

	var relateValue = "";
	$('.' + relateId).each(function() {
				relateValue += $(this).val();
	});

	if (relateValue != null && relateValue != "")
		$('#' + relateId).click();
		
	
}
/**
 * selectBox选项控制器, 允许通过表达式(表达式兼容JQUERY)和函数回调的方式来控制哪些选项不显示.
 * 
 * @param selectboxEl
 *            selectbox容器
 * @param options
 *            选项 (选项内容: {url:''<可选>,params:'url参数',expr:'逻辑判断表达式：opt为内置变量代表
 *            selectbox对应option<支持JQ>'})
 * @param callbackFunc
 *            expr逻辑表达式回调
 * 
 * @example
 * 实例隐藏selectbox,OPTION 值大于10的选项.
 selectBoxOption($('#a_pxksdj'),{expr:'opt.val() > 10'}); //opt为内置变量代表option元素
 */
function selectBoxOption(selectboxEl, options, callbackFunc) {
	var curOptions = {
		expr : '',
		url : '',
		params : {}
	};
	var dictval = []; // option val
	$.extend(curOptions, options);

	$(selectboxEl).find('option').each(function() {
				dictval.push($(this).val());
			});

	if (curOptions.url != null && curOptions.url != '') {
		$.post(curOptions.url, curOptions.params, function(result) {
					curOptions.expr = callbackFunc(result, dictval);
					selectExpr();
				});
	} else
		selectExpr();

	function selectExpr() {
		if (curOptions.expr != null && curOptions.expr != '') {
			var len = 0;
			var _this = $('#div_' + $(selectboxEl).attr('id'));

			$(selectboxEl).val('');
			_this.find('div > div').eq(0).text('');

			curOptions.expr = curOptions.expr.replace(/opt/g, '$(this)');

			var dp_ul = _this.find('>ul');

			if (dp_ul.attr('ulHeight') == null || dp_ul.attr('ulHeight') == '')
				dp_ul.attr('ulHeight', dp_ul.height());
			else
				dp_ul.height(dp_ul.attr('ulHeight'));

			$(selectboxEl).find('option').each(function() {
						var dp_li = _this.find('li').eq(len);

						dp_li.show();

						if (eval(curOptions.expr)) {
							dp_li = _this.find('li').eq(len);
							dp_ul = _this.find('>ul');
							dp_ul.height(dp_ul.height()
									- $(selectboxEl).height());
							dp_li.hide();
						}
						len++;
					});
		}
	}

}
/**
 * 载入等待遮罩
 * @param {} visable
 * @param {} msg
 */
function showloading(visable,msg) {
	var loaddiv;
	var _visable=true;
	var _msg="数据正在获取，请稍等......";
	
	_visable=visable;
	if(msg)
		_msg=msg;
	if (loaddiv = document.getElementById("loaddiv")) {
		if(_visable){
			loaddiv.style.display = "block";
			var bgDiv=document.getElementById("bgDiv");
			bgDiv.style.display = "block";
		}
			
		else{
			var bgDiv=document.getElementById("bgDiv");
			bgDiv.style.display = "none";
			document.body.style.cursor="";
			loaddiv.style.display = "none";
		}
			
	} else {
		loaddiv = document.createElement("DIV");
		loaddiv.id = "loaddiv";
		loaddiv.style.position = "absolute";
		loaddiv.style.zIndex = 1000;
		loaddiv.style.display = "";
		loaddiv.style.left = 0;
		loaddiv.style.top = 0;
		loaddiv.style.border = "1px solid gray"
		loaddiv.style.background = "#ffffff"
		loaddiv.style.padding = "5";
		
		var scrollTop = 0;
	if (top.document.documentElement && top.document.documentElement.scrollTop) {
		scrollTop = top.document.documentElement.scrollTop;
	} else if (document.body) {
		scrollTop = top.document.body.scrollTop;
	}

	var scrollWid = document.body.scrollWidth / 2 - 50;

	loaddiv.style.left = scrollWid + "px";
	loaddiv.style.top = (scrollTop + 5) + "px";
	
	document.body.style.cursor = "wait";

	var sWidth, sHeight;
	sWidth = document.body.scrollWidth;// 浏览器工作区域内页面宽度 或使用 screen.width//屏幕的宽度
	sHeight = document.body.scrollHeight;// 屏幕高度（垂直分辨率）

	// 背景层（大小与窗口有效区域相同，即当弹出对话框时，背景显示为放射状透明灰色）
	var bgObj = document.createElement("div");// 创建一个div对象（背景层）
												// //动态创建元素，这里创建的是 div
	
	// 定义div属性，即相当于(相当于，但确不是，必须对对象属性进行定义
	// <div id="bgDiv" style="position:absolute; top:0; background-color:#777;
	// filter:progid:DXImagesTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75);
	// opacity:0.6; left:0; width:918px; height:768px; z-index:10000;"></div>
	bgObj.setAttribute('id', 'bgDiv');
	bgObj.style.position = "absolute";
	bgObj.style.top = "0";
	bgObj.style.background = "#ffffff";
	bgObj.style.filter = "progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
	bgObj.style.opacity = "0.6";
	bgObj.style.left = "0";
	bgObj.style.width = sWidth + "px";
	bgObj.style.height = sHeight + "px";
	bgObj.style.zIndex = "10000";
	document.body.appendChild(bgObj);// 在body内添加该div对象

	document.body.appendChild(loaddiv);
	}
	loaddiv.innerHTML = "<img width='32' height='32' src='business/techSupport/common/image/loading.gif'><h>"+_msg+"</h>";
}


/** 获取更具当前用户的角色信息获取地区 mcId-字典显示值控件ID,dmId-字典实际值控件ID,dictCode-字典编码*/
function getRegionWithRole(mcId,dmId){
	gmcId=mcId;
	gdmId=dmId;
	gdictCode=ST_REGION_DICT_CODE;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
 	alert(1);//###
    addHtmlDict="business/techSupport/common/dictDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="420";	//DIV层的宽度
	setDictPage({pageurl:'techsupport/querylistRegionByRole_tscommon.action'});
}
/**
 * 获取一个用于提交的对象 
 * @param {} expr
 */
function getSubmitParams(expr,params){
	var allfields=[];
	var fields;
	// 过滤非单选复选
	fields=$(expr).filter(function(idx){ return $(this).attr("name") != null 
				&& $(this).attr("type") != 'checkbox'
				&& $(this).attr("type") != 'radio';});
	
	for(var i=0;i<fields.length;i++){
		allfields.push(fields.eq(i));
	}
	//过滤单选复选
	fields = $(expr).filter(function(idx){ return $(this).attr("name") != null && $(this).attr("checked") == true});
	for(var i=0;i<fields.length;i++){
		allfields.push(fields.eq(i));
	}
	//设置对象
	if(!params)
		var params = {};
	for(var i=0;i<allfields.length;i++){
		params[allfields[i].attr('name')] = allfields[i].val();
	}
	
	return params;
}