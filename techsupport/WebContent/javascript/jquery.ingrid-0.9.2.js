/**
 *
 */
var rowselect=0; //用到onRowSelect方法 点击列表中的行数 --- 前台页面用时最好重写onRowSelect方法 并在页面定义此变量
function queryIngridPageRows(height,overHeadHeight,row){ //根据插件高度获取 页面显示条数
	if(row>0){
		return row;
	}
	var resultNum = 0;
	if(!isNaN(height)&&!isNaN(overHeadHeight)){
		resultNum = Math.ceil((height-overHeadHeight)/22);
		resultNum = Math.ceil(resultNum/5)*5;
	}
	if(resultNum==0){ //如果计算完依然为0 默认为5	解释:正常情况下本js的26行默认为200不会出现计算完还为0，当修改这个值并传来负数时会为0。故暂时默认为5。 yangboadd-20110117
		resultNum = 5;
	}
	return resultNum;
}
var initParams='<Params></Params>'; //默认给核心包传的参数 避免后台setClass得到对象是 抛异常 --- 将来核心包参数变化改变这里
jQuery.fn.ingrid = function(o){
	var cfg = {
		ingridHtmlFlag:false,
		ingridPageRows:0,
		ingridHightSpeed:false,                        //插件高速模式 默认为关闭
		ingridPageParams:initParams,
		height: 200,									//默认插件高度 --- 一般在页面都要重新设置
		tableid : "grid",								//插件的ID --- 方便在页面直接对插件内容的操作
		sumFlag: false,									//合计请求标识 ---
		havaWaiDivGunDong: false,						//外层DIV滚动 时候需要固定HEAD 这时需要true 而且控制数据量不能出现滚动条
		headerRow: 0,								    //自定义条数
		ingridPageWidth : pageWidth,					//默认插件宽度 浏览器宽度 --- 如果为弹出页面 必须重新设置 
		colWidths: ["50%","50%"],						//插件几列对应就要有几个"n%" --- 必须为此格式"n%" n加起来必须为100
		minColWidth: 60,
		headerHeight: 24,								//插件头的高度 --- th
		overHeadHeight: 0,								//TH上面复合型的表头的高度
		thBhuanhKg: true,								//th不换行开关 默认不换行
		headerClass: 'grid-header-bg',
		headerClassHtml: 'grid-header-bg-html',
		headerTRClass: 'grid-header-tr',
		resizableCols: false,
		isHaveMorenPaixuClass: false,					//是否有默认排序样式
		morenPaixuCol: null,							//默认排序的列 0开始
		morenPaixuFangshi: null,						//默认排序方式 'desc' or 'asc'
		
		gridMoreDateMesFlag: false,						//数据条数过多提示开关
		gridMoreDateMesLen: 500,						//数据条数过多数据标准 默认500条
		gridMoreDateMes: '',							//数据条数过多提示信息
		
		gridClass: 'datagrid',
		colIndex: [],
		rowClasses: ['grid-row-style1','grid-row-style2'],
		colClasses: ['grid-col-styleblue'],
		normolColClass:'grid-col-style1',
		colHoverClass: 'grid-col-hoverblue',
		rowHoverClass: 'grid-row-hover',
		rowSelection: true,
		rowSelectedClass: 'grid-row-sel',
		onRowSelect: function(tr, selected){
			var str = selected ? 'SELECTED' : 'UNSELECTED';
			if(sFlag=="true"){
				if ($(tr).attr('_selected')=="true"){
					setQuery($(tr).attr("id"),detailHtml,detailWidth); 	
				}
			}else{
				sFlag="true";
			}
			rowselect=$(tr).attr('rowindex');
		},
		
		onColFocus:function(tr){},	
		changeHref:function(table){},
		onTdSelect:function(tr){},						//点击TD是出发的方法 --- 一般在前台需要的页面重写
		ingridComplete:function(){},					//插件AJAX请求结束后执行方法 --- 里面没有内容 方便前台页面需要的操作
		
		clickPageOrSort: false,							//是否点击了排序或分页
		isPlayResultNull: true,							//是否提示查询结果为空
		playResultNull: "没有符合条件的记录",				//查询结果为空的提示内容
		
		/* 是否排序 */
		sorting: true,
		noSortColIndex:[],								//不需要 排序 的列索引 eg:[0,6] 第一列和第七列不需要 排序
		hideColIndex:[],								//不需要 显示 的列索引 eg:[0,6] 第一列和第七列不需要 显示
		alignCenterColIndex:[],							//需要居中 的列索引 eg:[0,6] 第一列和第七列需要 居中
		alignRightColIndex:[],							//需要靠右 的列索引 eg:[0,6] 第一列和第七列需要 靠右
		headAlignCenter: false,							//默认表头为居左   如需要居中则开启此开关
		colSortParams: [],								// value to pass as sort param when header clicked (i.e. '&sort=param') ex: ['col1','col2','col3','col4']
		sortAscParam: 'asc',							// param passed on ascending sort (i.e. '&dir=asc)
		sortDescParam: 'desc',						// param passed on ascending sort (i.e. '&dir=desc)
		sortedCol: 'col1',								// current data's sorted column (can be a key from 'colSortParams', or an int 0-n (for n columns)
		sortedColDir: 'desc',							// current data's sorted dorections
		sortDefaultDir: 'desc',						// on 1st click, sort tihs direction
		sortAscClass: 'grid-sort-asc',		// class for ascending sorted col
		sortDescClass: 'grid-sort-desc',	// class for descending sorted col
		sortNoneClass: 'grid-sort-none',	// ... not sorted? use this class
		scrollClass:'scrollbarface',
		ingridSort:'',
		ingridDir:'',
		
		/* 移除样式 */
		removeClass:[],
		
		/* 是否分页 */
		paging: true,
		pageNumber: 1,
		recordsPerPage: 0,
		totalRecords: 0,
		pageToolbarHeight: 23,
		pageToolbarClass: 'grid-page-toolbar',
		pageStartClass: 'grid-page-start',
		pagePrevClass: 'grid-page-prev',
		pageInfoClass: 'grid-page-info',
		pageInputClass: 'grid-page-input',
		pageNextClass: 'grid-page-next',
		pageEndClass: 'grid-page-end',
		pageLoadingClass: 'grid-page-loading',
		pageLoadingDoneClass: 'grid-page-loading-done',
		pageViewingRecordsInfoClass: 'grid-page-viewing-records-info',
		pageTollDivId: 'ingrid_pagestyle_092',

		/* ajax stuff */
		url: '',										//AJAX请求的URL --- 前台必须设置
		type: 'POST',
		dataType: 'json',								//类型为 json 或 html --- 一般我们用 json
		loadAsync: true,								//默认请求AJAX 为异步 同步设置为：FALSE
		extraParams: {dataxml:initParams,pagesize:'1',pagerow:0}, //默认AJAX传参数				
		loadingClass: 'grid-loading',					//请求AJAX 等待请求的动画样式 --- 那个带斜线的样式
		noresultClass: 'grid-noresult',					//插件 记录数位空的时候的动画样式 --- 那个带斜线的样式
		loadingHtml: '<div>&nbsp;</div>',
					
		
		/* should seldom change */
		resizeHandleHtml: '',									// resize handle html + css
		resizeHandleClass: 'grid-col-resize',
		columnIDAttr: '_colid',					// attribute name used to groups TDs in columns
		ingridIDPrefix: '_ingrid',			// prefix used to create unique IDs for Ingrid
		
		/* cookie, for saving state */
		cookieExpiresDays: 360,
		cookiePath: '/',
		
		/* not yet implemented */
		minHeight: 100,
		resizableGrid: true,
		dragDropCols: true,
		sortType: 'server|client|none',
		nowTimeMill:'',
		isDaoChu:false,	//是否导出标示，false为不导出，true为导出
		excelUrl:null,
		searchLongUrl:null,
		biaoTouMc:null	//导出表头名称
	};
	jQuery.extend(cfg, o); //将页面参数覆盖默认参数
	
	if(cfg.ingridPageRows==0){ //默认计算插件显示的条数
		cfg.ingridPageRows = queryIngridPageRows(cfg.height,cfg.overHeadHeight,cfg.headerRow);
	}
	function canSorting(index){ //配合排序  判断此列是否可以排序 true:可以 false:不可以
		var nosortlen = cfg.noSortColIndex.length;
		if(nosortlen>0){
			for(var i=0;i<nosortlen;i++){
				if(cfg.noSortColIndex[i]==index) return false;
			}
		}
		return true;
	}
	function isHideCol(index){ //判断此列是否隐藏 true:隐藏 false:不隐藏
		var hideColLeng = cfg.hideColIndex.length;
		if(hideColLeng>0){
			for(var i=0;i<hideColLeng;i++){
				if(cfg.hideColIndex[i]==index) return true;
			}
		}
		return false;
	}
	
	var theadHtml = this.find('thead').html();
	var $header = jQuery('<div/>') //存放插件 head 的临时变量
					.html(jQuery('<thead></thead>').html(theadHtml))
					.height(cfg.headerHeight);
	if(!cfg.havaWaiDivGunDong){
		$header.find('tr').addClass(cfg.headerTRClass);
	}
	var $bodyer = jQuery('<div/>') //存放插件 tbody内容 的临时变量
					.html(jQuery('<tbody></tbody>').html(this.find('tbody').html()));
	var $gridObj = jQuery('<table id='+cfg.tableid+' cellpadding="0" cellspacing="0"></table>') //就是个TABLE
					.addClass(cfg.gridClass)
					.css('border','none')
					.html($header.html()+$bodyer.html());
	
	$gridObj.find('thead').find('tr').find('th').each(function(i){ //初始化插件 head
		var $theadTrTh = jQuery(this);
		$theadTrTh.width(cfg.colWidths[i].substr(0,cfg.colWidths[i].indexOf('%'))*(cfg.ingridPageWidth)/100+'px'); //设置TH的宽度
		if(cfg.ingridHtmlFlag){ //不走后台直接添加的情况
			$theadTrTh.addClass(cfg.headerClassHtml);
		} else {
			$theadTrTh.addClass(cfg.headerClass);
		}
		var $col_label = jQuery('<div/>')
					.html(jQuery(this).html())
					.css('-moz-user-select', 'none')
					.css('-khtml-user-select', 'none')
					.css('user-select', 'none')
					.attr('unselectable', 'on');
		if(cfg.thBhuanhKg){ //不换行
			$col_label.css('white-space', 'nowrap');
		}
		if(cfg.headAlignCenter){ //表头居中
			$col_label.css('text-align', 'center');
		}
		$theadTrTh.html($col_label);
		if(isHideCol(i)){
			$theadTrTh[0].style.display='none';
		}
		if (cfg.sorting&&canSorting(i)) { //需要排序样式 执行次方法
			if(i==cfg.morenPaixuCol){ //默认排序的列
				if(cfg.isHaveMorenPaixuClass){ //2010.04.19 加需求 默认排序样式
					if('asc'==cfg.morenPaixuFangshi){
						$theadTrTh.find('div:first').addClass(cfg.sortAscClass);
					} else if('desc'==cfg.morenPaixuFangshi){
						$theadTrTh.find('div:first').addClass(cfg.sortDescClass);
					} else {
						$theadTrTh.find('div:first').addClass(cfg.sortNoneClass);
					}
				}
			} else {
				$theadTrTh.find('div:first').addClass(cfg.sortNoneClass);
			}
			$theadTrTh.click(function(){
				cfg.clickPageOrSort = true; //点击了排序
				$gridObj.find('tbody').html("");
				var $nowthdiv = $theadTrTh.find('div:first');
				
				var dir = $nowthdiv.hasClass(cfg.sortNoneClass)? 
					cfg.sortDefaultDir:($nowthdiv.hasClass(cfg.sortAscClass)?cfg.sortDescParam:cfg.sortAscParam);
				var nowclass = $nowthdiv.hasClass(cfg.sortNoneClass) ? 
					( cfg.sortDefaultDir == cfg.sortAscParam ? cfg.sortAscClass : cfg.sortDescClass ) :
					( $nowthdiv.hasClass(cfg.sortAscClass) ? cfg.sortDescClass : cfg.sortAscClass );
				cfg.ingridSort = i;
				cfg.ingridDir = dir;
				$gridObj.find('th').each(function(){
					var $nowthdivtemp = jQuery(this).find('div:first');
					if($nowthdivtemp.hasClass(cfg.sortAscClass)||$nowthdivtemp.hasClass(cfg.sortDescClass)){
						$nowthdivtemp.removeClass(cfg.sortAscClass).removeClass(cfg.sortDescClass).addClass(cfg.sortNoneClass);
					}
				});
				$nowthdiv.removeClass(cfg.sortAscClass).removeClass(cfg.sortDescClass).removeClass(cfg.sortNoneClass).addClass(nowclass);
				$ingrider.load();
			});
		}
	});

	var $ingridTablePage = jQuery("<div id='"+cfg.pageTollDivId+"'/>") //分页的DIV
				.addClass(cfg.pageToolbarClass)
				.height(cfg.pageToolbarHeight)
			    .width(cfg.ingridPageWidth)
	
	var $ingridTable = jQuery("<div />") //将上面的TABLE放到这个DIV里面 作为插件的内容(如果需要改变插件的内容就改变gridObj就行了)
			.width(cfg.ingridPageWidth-1)
			.height(cfg.height+cfg.headerHeight)
			.css('overflow-y', 'scroll')
			.css('overflow-x', 'auto')
			//.css('position','relative') //9月9日
			.addClass(cfg.scrollClass)
			.addClass('bordsoild')
			.append($gridObj).extend({
				$gridObj : $gridObj
			});
	if(!cfg.havaWaiDivGunDong){ //将9.9 进一步改 9.14
		$ingridTable.css('position','relative');
	}
	
	//var $ingrider = jQuery("<div><div></div></div>"); //将上面的TABLE放到这个DIV里面 作为插件的内容(如果需要改变插件的内容就改变gridObj就行了)
	var $ingrider = jQuery("<div id="+cfg.gridClass+"><div></div><div></div></div>"); //将上面的TABLE放到这个DIV里面 作为插件的内容(如果需要改变插件的内容就改变gridObj就行了)
			
	var modalmask = $ingrider.find('div:first').html(cfg.loadingHtml).addClass(cfg.loadingClass).css({
		position: 'absolute',		
		zIndex: '1000',
		width: cfg.ingridPageWidth,
		height: cfg.height+cfg.headerHeight
	}).hide();
	var modalmaskNoResult = $ingrider.find('div:last').html(cfg.playResultNull).addClass(cfg.noresultClass).css({
		position: 'absolute',		
		zIndex: '1000',
		width: cfg.ingridPageWidth,
		height: cfg.height+cfg.headerHeight
	}).hide();
	
	if(cfg.paging==true){ //需要分页就加分页DIV
		$ingrider.append($ingridTable).append($ingridTablePage).extend({
				$ingridTable : $ingridTable,
				$ingridTablePage : $ingridTablePage
			});
		modalmask.css({
			height: cfg.height+cfg.headerHeight+cfg.pageToolbarHeight //动画把分页DIV也盖住
		});
		modalmaskNoResult.css({
			height: cfg.height+cfg.headerHeight+cfg.pageToolbarHeight //动画把分页DIV也盖住 //如果提示的文字将来变成放中间则改对齐方式就行了
		});
	} else {
		$ingrider.append($ingridTable).extend({
				$ingridTable : $ingridTable
			});
	}
	
	$ingrider.extend({
		load : function(params, cb) { //AJAX加载数据
			if(cfg.url!="#"){ //正常请求后台
				//start --- 如果为统计 传递isQuery 查询的时候传递1 再点分页或排序就传递0
				if(cfg.sumFlag==true){
					var clearQuery0 = "	<Param name=\"isQuery\">0</Param>";
					var clearQuery1 = "	<Param name=\"isQuery\">1</Param>";
					if(cfg.ingridPageParams.indexOf("	<Param name=\"isQuery\">")>0){
						cfg.ingridPageParams = cfg.ingridPageParams.replace(clearQuery0,"");
						cfg.ingridPageParams = cfg.ingridPageParams.replace(clearQuery1,"");
					}
					if(cfg.clickPageOrSort==false){ //正常查询
						var sumParam = "	<Param name=\"isQuery\">1</Param></Params>";
						cfg.ingridPageParams = cfg.ingridPageParams.replace("</Params>",sumParam);
					} else { //点击了排序或者分页
						var sumParam = "	<Param name=\"isQuery\">0</Param></Params>";
						cfg.ingridPageParams = cfg.ingridPageParams.replace("</Params>",sumParam);
					}
				}
				//end
				if(cfg.ingridSort==''&&cfg.ingridDir==''){
					thisPageParams = { dataxml:cfg.ingridPageParams,
						pagerow:cfg.ingridPageRows,pagesize:cfg.pageNumber }
				} else {
					thisPageParams = { dataxml:cfg.ingridPageParams,
						pagerow:cfg.ingridPageRows,pagesize:cfg.pageNumber,
						sort:cfg.ingridSort, dir:cfg.ingridDir }
				}
				var data = jQuery.extend(cfg.extraParams, thisPageParams);
				
				modalmaskNoResult.hide(); //关闭 记录为空动画
				modalmask.show(); //打开 AJAX 等待动画
				
				jQuery.ajax({
					type: cfg.type.toUpperCase(),
					url: cfg.url,
					data: data,
					async: cfg.loadAsync,
					success: function(result){
						if (cfg.dataType == 'json') {
							var $rows  = eval( '(' + result + ')' );
							if($rows.result=='success'){
								cfg.totalRecords=$rows.totalrows;
								$ingrider.setPageCon($rows.tabledata);
							} else { //后台抛异常
								jAlert("程序异常,请联系管理员!","提示");
							}
						}
						if (cfg.dataType == 'html') {
							cfg.totalRecords=200;
							$ingrider.setPageCon(result);
						}
					},
					error: function(){
						//插件初始化的时候 给个URL为#当前页面 --- 这样会失败 不用提示
						$ingrider.setPageTool();
					},
					complete: function(){
						//$("#div_login").hide(); //关闭 AJAX 等待动画
						modalmask.hide(); //关闭 AJAX 等待动画
						cfg.ingridComplete();
						var reclass=cfg.removeClass;
						for(var k=0;k<reclass.length;k++){
							var rc=reclass[k].split(',');
							$ingridTable.find('tbody tr:nth('+rc[0]+') td:nth('+rc[1]+')').attr('class','grid-col-style1').unbind('mouseenter').unbind('mouseleave');
						}
					}
				});
			} else { //插件初始化的时候 给个URL为# 初始化分页样式
				$ingrider.setPageTool();
			}
			return this;
		},
		setPageCon : function(pageconnect){
			var $tbl = jQuery(pageconnect);
			$ingrider.setPageTool();
			cfg.changeHref($tbl);
			if(!cfg.ingridHightSpeed){
				var row  = $tbl.find('tr:first');
				if ( jQuery(row).find('td').length == cfg.colWidths.length ) {
					var gridCanPlay = true;
					if(cfg.gridMoreDateMesFlag){ //数据条数过多提示开关:开
						if(cfg.totalRecords>cfg.gridMoreDateMesLen){
							gridCanPlay = false;
							jAlert(""+cfg.gridMoreDateMes,'提示');
						}
					}
					if(gridCanPlay){
						$gridObj.find('tbody').html($tbl.find('tbody').html()); //插件内容改变了 就改变 gridObj对象
						$ingrider.initStylesAndWidths(); 
					}
				} else if (row.length < 1) {
					//if(cfg.isPlayResultNull){ //范英确定全部改成当前的样式
						//jAlert(""+cfg.playResultNull,"提示");
					//}
					if(cfg.isPlayResultNull){ //杨建辉确认加此开关,解决特殊页面需求
						modalmaskNoResult.show(); //关闭 记录为空动画
					}
				} else { //后台设置的列和前台的 列colWidths[] 不一致
					jAlert("请管理员检查:后台查询结果列与前台配置列!","提示");
				}
			}else{
				$gridObj.find('tbody').empty().remove();
				$gridObj.append($tbl.html());
				$ingrider.initStylesAndWidths(); 
			}
		},
		initStylesAndWidths : function() { //对插件里的内容进行格式化
			if(!cfg.ingridHightSpeed){
			$gridObj.find('tbody').find('tr').each(function(r){
				var $tbodyTr = jQuery(this);
				if (cfg.rowClasses.length > 0) {
					var cursor = (r == 0 ? 0 : r % cfg.rowClasses.length);
					if (cfg.rowClasses[cursor] != '') {
						$tbodyTr.addClass(cfg.rowClasses[cursor]);							
					}
					if (cfg.rowHoverClass != '') {
						$tbodyTr.hover(
							function() { if ($tbodyTr.attr('_selected') != 'true' ) $tbodyTr.removeClass(cfg.rowClasses[cursor]).addClass(cfg.rowHoverClass); },
							function() { if ($tbodyTr.attr('_selected') != 'true') $tbodyTr.removeClass(cfg.rowHoverClass).addClass(cfg.rowClasses[cursor]); }
						);
					}
					if (cfg.rowSelection == true) {
						var iclass=0;
						cfg.onTdSelect(this);
						$tbodyTr.click(function(){
							iclass = 0;
							var $gridObjTbodyTr = $gridObj.find('tbody').find("tr");
							for (var i=0,max=$gridObjTbodyTr.length;i<max;i++){
								jQuery($gridObjTbodyTr[i]).removeClass(cfg.rowSelectedClass);
								jQuery($gridObjTbodyTr[i]).removeClass(cfg.rowHoverClass);
								if (iclass>cfg.rowClasses.length-1){
									iclass=0;
								}	
								jQuery($gridObjTbodyTr[i]).attr('_selected','false');
								jQuery($gridObjTbodyTr[i]).addClass(cfg.rowClasses[iclass]);		
					  			iclass=iclass+1;
							}
							if ($tbodyTr.attr('_selected')) {
								$tbodyTr.attr('_selected') == 'true' ?
									$tbodyTr.attr('_selected', 'false').removeClass(cfg.rowSelectedClass) :
									$tbodyTr.attr('_selected', 'true').addClass(cfg.rowSelectedClass);
								
							} else {
								$tbodyTr.attr('_selected', 'true').addClass(cfg.rowSelectedClass);
							}
							if (cfg.onRowSelect) {
								cfg.onRowSelect(this, ($tbodyTr.attr('_selected') == 'true' ? true : false) );
							}
							cfg.onColFocus(this);
						});
					}
				}
				$tbodyTr.find('td').each(function(i){
					var $tbodyTrTd = jQuery(this);
					if(isHideCol(i)){
						$tbodyTrTd[0].style.display='none';
					}
					$tbodyTrTd.attr(cfg.columnIDAttr, i)
							.width(cfg.colWidths[i].substr(0,cfg.colWidths[i].indexOf('%'))*(cfg.ingridPageWidth)/100+'px')
							.css('word-break', 'break-all');
					if(cfg.alignCenterColIndex.length>0){
						for(var k=0;k<cfg.alignCenterColIndex.length;k++){
							if(cfg.alignCenterColIndex[k]==i){
								$tbodyTrTd.css('text-align', 'center');//文字居中
							}
						}
					}
					if(cfg.alignRightColIndex.length>0){
						for(var k=0;k<cfg.alignRightColIndex.length;k++){
							if(cfg.alignRightColIndex[k]==i){
								$tbodyTrTd.css('text-align', 'right');//文字居右
							}
						}
					}
					if (cfg.colIndex.length > 0) {
						var classes=cfg.normolColClass;
						for (var a=0,max=cfg.colIndex.length;a<max;a++){
							if (cfg.colIndex[a]==i){
								classes=cfg.colClasses[0];
								if (cfg.rowHoverClass != '') {
									$tbodyTrTd.hover(
										function() { if ($tbodyTrTd.attr('_selected') != 'true' ) $tbodyTrTd.removeClass(classes).addClass(cfg.colHoverClass); },
										function() { if ($tbodyTrTd.attr('_selected') != 'true') $tbodyTrTd.removeClass(cfg.colHoverClass).addClass(classes); }
									);
								}
							}
						}
						$tbodyTrTd.addClass(classes);
					}else{
						if (cfg.colClasses[0] != '') {
							$tbodyTrTd.addClass(cfg.normolColClass);
						}
					}
				});
			});
			}else{
				$gridObj.removeAttr('style').removeClass();
				$gridObj.attr('style',"WORD-BREAK: break-all;width:"+cfg.ingridPageWidth+";text-align:left;");
				$gridObj.find('tbody').find('tr:even').addClass(cfg.rowClasses[0]).attr('height','20');
				$gridObj.find('tbody').find('tr:odd').addClass(cfg.rowClasses[1]).attr('height','20');
				$gridObj.find('tbody').find('td').css('word-break', 'break-all');
				$gridObj.find('tbody').find('tr').eq(0).find('td').each(function(i){
					$(this).attr('width',cfg.colWidths[i]);
				});
			}
		},
		setPageTool : function(){
			if (cfg.paging) { //分页 
				//this.find('#'+cfg.pageTollDivId).remove(); //先将上一次分页DIV移除 准备加新DIV
				var totr  = cfg.recordsPerPage > 0 ? cfg.recordsPerPage : cfg.ingridPageRows;
				var totp  = cfg.totalRecords > 0 ? Math.ceil(cfg.totalRecords/totr) : 1;
				
				var $pv; //分页样式最右边 --- eg:显示行数 1-10 of 20
				$pv = jQuery('<div />')
					.addClass(cfg.pageViewingRecordsInfoClass)
					.extend({
							updateViewInfo : function(loaded_rows, page){
							var _start = ( cfg.totalRecords>0 ? (loaded_rows * (page - 1) + 1) : 0 );
							var _end   = ( (loaded_rows * page) > cfg.totalRecords ? cfg.totalRecords : loaded_rows * page );
							var rightHtml ='第'+cfg.pageNumber+'页/共'+totp+'页  '+totr+'条/页  '
									+ _start +' - '+ _end +'条  共'+cfg.totalRecords+'条'; 
							this.html(rightHtml);
							return this;
						}
					});
				$pv.updateViewInfo(totr, cfg.pageNumber);
				//分页DIV
				$ingridTablePage.extend({
							setPage : function(p){
								$gridObj.find('tbody').html("");
								cfg.clickPageOrSort = true; //点击了分页
								cfg.extraParams={pagesize:p,pagerow:cfg.ingridPageRows};
								var input = this.find('input.' + cfg.pageInputClass);
								//$pload.removeClass(cfg.pageLoadingDoneClass);
								$ingrider.load( {page : p}, function(){
									input.val(p);
									if (cfg.totalRecords > 0) {
										var totr = cfg.ingridPageRows;
										$pv.updateViewInfo(totr, p);
									}
									//$pload.addClass(cfg.pageLoadingDoneClass);
								});
								return this;
							},
							getPage : function(){
								var p = Number(this.find('input.'+cfg.pageInputClass).val());
								return p;
							}
						});
				// << 首页
				var $pb1 = jQuery('<a href="#" title="首页">11111111111111111111</a>').addClass(cfg.pageStartClass).click(function(){
						var _p = cfg.pageNumber;
						if (totp>1&&_p!=1) { //总页数大于1 当前页数不为1
							cfg.pageNumber = 1;
							$ingridTablePage.setPage(1);
						}
					});
				// < 上一页
				var $pb2 = jQuery('<a href="#" title="上一页"></a>').addClass(cfg.pagePrevClass).click(function(){
						var _p = cfg.pageNumber;
						if (totp>1&&_p >1) { //总页数大于1 当前页数大于1
							_p--;
							cfg.pageNumber = _p;
							$ingridTablePage.setPage(_p);
						}										
					});
				// > 下一页
				var $pb3 = jQuery('<a href="#" title="下一页"></a>').addClass(cfg.pageNextClass).click(function(){
						var _p = cfg.pageNumber;
						if (totp>1&&_p<totp) { //总页数大于1 且不是最后一页
							_p++;
							cfg.pageNumber = _p;
							$ingridTablePage.setPage(_p);
						}
					});
				// >> 最后一页
				var $pb4 = jQuery('<a href="#" title="尾页"></a>').addClass(cfg.pageEndClass).click(function(){
						var _p = cfg.pageNumber;
						if (totp>1&&_p<totp) { //总页数大于1 且不是最后一页
							cfg.pageNumber = totp;
							$ingridTablePage.setPage(totp);
						}
					});
				//alert('cfg.pageNumber:'+cfg.pageNumber);
				//var $pload	= jQuery('<div />').addClass(cfg.pageLoadingClass).addClass(cfg.pageLoadingDoneClass);
				var $pfld  = jQuery('<input type="text" id="pageNo" value="'+cfg.pageNumber+'"/>').addClass(cfg.pageInputClass);
				var $pinfo = jQuery('<div />').addClass(cfg.pageInfoClass).append($pfld);
				var $pform = jQuery('<form></form>').append($pinfo).keydown(function(){
					if(event.keyCode==13){
						var _p = parseInt($ingridTablePage.getPage());
						if(!isNaN(_p)){
							if(_p<=0) _p = 1;
							if(_p>totp) _p = totp;
						}else{
							_p = 1;
						}
						if (totp>0){
							cfg.pageNumber = _p;
							$ingridTablePage.setPage(_p);
						}
						return false;
					}
				});
				$pinfo.html('第 '+$pinfo.html()+' 页');
				$ingridTablePage.empty();
				//$ingridTablePage.append($pb1).append($pb2).append($pform).append($pb3).append($pb4).append($pv); //跳转在左边
				$ingridTablePage.append($pv).append($pb4).append($pb3).append($pform).append($pb2).append($pb1); //跳转在右边
				
			}
			
			var excelUrl = cfg.excelUrl;
			if(cfg.isDaoChu && excelUrl!=null && excelUrl!=''){
				var $daochu = jQuery('<div style="position:absolute;"></div>').css("width",40);
				var tableId = this.attr("id");
				
				//导出按钮对象
				var daoChuA = jQuery('<a href="#" class="exceldcbutton" style="color:#084c6c;FONT:12px \'宋体\';">导出</a>');
				
				//导出form表单对象
				var daoChuForm = jQuery('<form name="daoChuForm" method="post" action="'+excelUrl+'"><input type="hidden" name="bbmc" value="'+cfg.biaoTouMc+'" /></form>');
				
				//导出表头对象
				var titleInput = jQuery('<input type="hidden" name="tabletitle" />');
				titleInput.val(theadHtml);
				daoChuForm.append(titleInput);
				
				//判断是否是长参数导出方式
				var searchLongUrl = cfg.searchLongUrl;
				//普通导出方式
				if(searchLongUrl==null || searchLongUrl==''){
					daoChuA.click(function(){
						lieBiaoDaoChu(tableId);
					});
					
					//查询条件对象
					var dataInput = jQuery('<input type="hidden" name="xml" />');
					dataInput.val(cfg.ingridPageParams);
					daoChuForm.append(dataInput);
					
				}else{
					//长参数导出方式
					daoChuA.click(function(){
						lieBiaoDaoChuLong(tableId,searchLongUrl,cfg.ingridPageParams);
					});
				}
				$daochu.append(daoChuA);
				$daochu.append(daoChuForm);
				var pageDivWidth = cfg.ingridPageWidth;
				if(cfg.paging){
					$ingridTablePage.append($daochu.css("left",pageDivWidth-220));
				}else{
					
					$ingridTablePage.append($daochu.css("left",pageDivWidth-55));
					$ingrider.append($ingridTablePage);
				}
			}
		}
	});
	
	/**
	* 	每次调用插件-setPageList都进入这个方法
	*/
	return this.each(function(tblIter){
		var g_id = 	cfg.ingridIDPrefix + '_' + jQuery( this ).attr('id') + '_' + tblIter;
		$ingrider.attr( 'id', g_id );
		jQuery( this ).replaceWith( $ingrider[0] ); //将页面上的TABLE替换成本插件的一个对象 ： $ingrider
		$ingrider.load(); //请求AJAX装载数据
	}).extend({
		$ingrider : $ingrider
	});
	
};

function lieBiaoDaoChu(tableId){
	var tableOjbect = $("#"+tableId);
	if(tableOjbect.find("tbody").find("tr").length>0){
		tableOjbect.find("form[name='daoChuForm']").submit();
	}else{
		jAlert("没有可供导出的数据！","提示信息");
	}
}

function lieBiaoDaoChuLong(tableId,searchLongUrl,chaXunCanShu){
	var tableOjbect = $("#"+tableId);
	if(tableOjbect.find("tbody").find("tr").length>0){
		jQuery.post(searchLongUrl,{dataxml:chaXunCanShu},function(json){
			tableOjbect.find("form[name='daoChuForm']").submit();
		},"json");
	}else{
		jAlert("没有可供导出的数据！","提示信息");
	}
}
