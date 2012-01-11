/**gmcId,gdmId,gdictCode 全局变量，方便在jsp中获得
 * gmcId-字典显示值控件ID,gdmId-字典实际值控件ID,gdictCode-字典编码,gitemid-树的节点id
 */
var gmcId;
var gdmId;
var gdictCode;
var gcodeValue;
var gjsdmId;
var glevel;
var gitemid;
var gparentItemId;
var gfullcode;
var gisLeaf;
var gtreeParentId;
var gfact_value;
var diaoYongMethod;
var flagTj;
var gsfyx;
var gzjztdm;
var gymgn;
var gmcitemId;
var glitemCode;
var glflg;
var ghylbbz;//用于传递in方法的行业类别编码
var gsfhc;

//弹出DIV层，覆盖setAddPage()方法
function setDictPage()
{
	setDictWidth(detailidDict,addWidthDict);
	setDictUrl(detailidDict,addHtmlDict);
}
//设置DIV层的宽度及左边距，覆盖setWidth()方法
function setDictWidth(divid,sWidth)
{
	$("#"+divid).css("width",sWidth+"px");
}
//设置DIV层内嵌jsp，覆盖setUrl()方法
function setDictUrl(divid,url)
{
	$("#"+divid).empty();
	$("#"+divid).load(url);
}
	
function shuaiXuanKuangComm(mcId,dmId){	
	$("#t_query_simplepin").remove();
	$("#t_super_item_id").remove();
	
  	//获取mcId控件的top、left位置和width、height
 	//var top = $("#" + mcId).offset().top;
	
 	var top = $("#" + mcId).position().top;   
 	var left = $("#" + mcId).position().left;
 	var height = $("#" + mcId).height();
 	var width = $("#" + mcId).width()+3;
 	var factTop = top+height+6;
 	var option_open = false;      //标记是否打开下拉option
	//若下拉框左边界距屏幕右边界的距离小于下拉框的宽度，则将下拉框左移
 	var cliWidth = document.body.clientWidth;
 	var cliHeight = document.body.clientHeight;
 	if(cliWidth-left<400)
 	{
 		left = cliWidth-(cliWidth-(left+width)+400);
 	}
 	//若下拉框上边界距屏幕下边界的距离小于下拉框的高度，则将下拉框上移
 	if(cliHeight-(top+height)<330)
 	{
 		if((top+height)<330)
	 		factTop = 20;
	 	else
	 		factTop = top-330-height;
 	}
	//定义DIV层
	var div_html = "<div></div>";
 	div_html = "<div id='divs_"+mcId+"' style='position:absolute;background-color:#FFFFFF;top:"+factTop
 		+"px;left:"+left+"px;width:800"+
 		"px;border:1px #666666 solid;overflow-x:hidden;overflow-y:hidden;display:none;z-index:99999;'>";
 	div_html += "</div>";	
 	//字典编码与筛选条件控件不存在时再生成
 	if($("#t_dict_code").attr("id")==undefined ||$("#t_dict_code").attr("id")==null){
 		div_html += "<input id='t_dict_code' type='hidden'/>";
 	}	
 	$("#" + mcId).after(div_html);  //添加到input控件后面
 	
 	
 	//控制DIV层的显示与关闭
 	function __open_option(){$("div[id^='divs_']").hide();$("#divs_" + mcId).show();option_open=true;}  //显示下拉option
 		
 	function __hide_option()
 	{
 		//隐藏DIV层时清空字典编码与筛选条件控件的值
 		if($("#t_dict_code").attr("id")!=null&&$("#t_dict_code").attr("id")!=undefined )
 		{
 			$("#t_dict_code").val("");
 			
 		}
 		//隐藏DIV
 		$("#divs_" + mcId).hide();
 		//清除DIV,必须清除div，否则造成里面嵌入的jsp中的元素重复加载
 		$("#divs_" + mcId).remove();
 		option_open=false;$(document).unbind("click",__hide_option);
 	}  //隐藏下拉option
 	$("#" + mcId).click(function(event){
 			if(option_open){
 			//__hide_option();
 			}
 			else{__open_option();
 			$(document).bind("click",function(event){
 				var target = (event.target) ? event.target : event.srcElement;
 					var parents = $(target).parents();
 					var ishave = false;
 					for(var i=0;i<parents.length;i++){
 						if(parents.eq(i).attr("id")==("divs_" + mcId)||
 								$(target).attr("id")==("divs_" + mcId)){
 							ishave = true;
 							break;
 						}
 					}
 					if(!ishave){
 						__hide_option();
 					}
 			});
 	}
 			event.stopPropagation();}
 	);
 
 	
}
	
/** mcId-字典显示值控件ID,dmId-字典实际值控件ID,dictCode-字典编码*/
function getDict_item(mcId,dmId,dictCode,codeValue,treeParentId)
{	
	gmcId=mcId;
	gdmId=dmId;
	gdictCode=dictCode;
	gcodeValue = codeValue;
	gtreeParentId = treeParentId;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
	
 	detailidDict="divs_"+mcId;//DIV层的ID
 	
    addHtmlDict="basic/common/dictDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="420";	//DIV层的宽度
	

	setDictPage();
}

/** mcId-字典显示值控件ID,dmId-字典实际值控件ID,dictCode-字典编码*/
function getDict_item4(mcId,dmId,dictCode)
{
	getDict_item(mcId,dmId,dictCode);
}

//联动字典筛选框
function getDict_liandong(mcId,dmId)
{
	gmcId=mcId;
	gdmId=dmId;
	//gdictCode = flag;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
	
	detailidDict="divs_"+mcId;//DIV层的ID
	addHtmlDict="basic/common/dictLdDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
}

function getYlcs_item(mcId,dmId,flag,gxdwbm,csbmId)
{
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = flag;
	gGxdwbm = gxdwbm;
	gcodeValue = csbmId;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="business/common/ylcsDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
}

function getSsfwxh_item(mcId,dmId,flag,gxdwbm,csbmId)
{
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = flag;
	gGxdwbm = gxdwbm;
	gcodeValue = csbmId;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/ssfwxhDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
}
function getTy_item(mcId,dmId,csidId,flag,gxdwbm,hylbbz)
{
	//alert('getTy_item');
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = flag;
	gGxdwbm = gxdwbm;
	gcodeValue = csidId;
	ghylbbz=hylbbz;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/TyDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
}
/**
	可根据页面功能来区分的控件
	ymgn-页面功能
*/
function getTy_item_ymgn(mcId,dmId,csidId,flag,gxdwbm,ymgn)
{
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = flag;
	gGxdwbm = gxdwbm;
	gcodeValue = csidId;
	gymgn = ymgn;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/TyDropDown_ymgn.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
}

/**
 * 超级通用企业下拉控件
 * mcId,dmId,csidId,flag,gxdwbm-同getTy_item(mcId,dmId,csidId,flag,gxdwbm)方法
 * sfyx-是否有效企业：0-无效，1-有效, 2需要核查的企业(2010-07-02 苗电话确认)
 * zjztdm-装机状态代码
 * sfhc-是否核查
 * hylbbz-传入in方式的行业类别代码
 * 注意本控件使用时应保证传入参数与页面调用action的传入参数保持一致
 */
function getTy_item_super(mcId,dmId,csidId,flag,gxdwbm,sfyx,zjztdm,sfhc,hylbbz)
{
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = flag;
	gGxdwbm = gxdwbm;
	gcodeValue = sfyx;
	gsfyx = sfyx;
	gzjztdm = zjztdm;
	gsfhc = sfhc;
	ghylbbz=hylbbz;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/TyDropDown_super.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
}

function getTy_itemTj(mcId,dmId,csidId,flag,gxdwbm,flagValue)
{
	//alert('getTy_item');
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = flag;
	gGxdwbm = gxdwbm;
	gcodeValue = csidId;
	flagTj=flagValue;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/TyDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
}







function getTyRY_item(mcId,dmId,flag,gxdwbm,csidId)//公用人员筛选框
{
	gmcId=mcId; 
	gdmId=dmId;
	gdictCode = flag;
	gGxdwbm = gxdwbm;
	gcodeValue = csidId;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+gmcId;//DIV层的ID
    addHtmlDict="basic/common/TyRyDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度
	setDictPage();
}
function getTw_item(mcId,dmId,twid)
{
	//alert('getTy_item');
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = twid;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="business/esjzagl/TwDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
}
function getTwry_item(mcId,dmId,twid)
{
	//alert('getTy_item');
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = twid;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="business/esjzagl/TwryDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
}
function getQY_item(mcId,dmId,flag,gxdwbm)
{
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = flag;
	gGxdwbm = gxdwbm;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="business/common/qyDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
}

function getQyry_item(mcId,dmId,qybh,ryID)
{
	//alert('getTy_item');
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = qybh;
	gcodeValue=ryID;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/QyryDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
}

function getYzQy_item(mcId,dmId,qylx,gxdwbm)
{
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = qylx;
	gGxdwbm = gxdwbm;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="business/common/yzqyDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
	
}

  /**  印章使用单位  **/
function getYzsyQy_item(mcId,dmId,qylx,gxdwbm)
{
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = qylx;
	gGxdwbm = gxdwbm;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="business/common/yzsyqyDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
	
}

/*旅馆的筛选框*/
function getLg_item(mcId,dmId,flag)
{
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = flag;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="business/common/lgDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="450";	//DIV层的宽度
	setDictPage();
}

/*旅馆的筛选框-企业名称可选值根据管辖单位选取而变化*/
function getLg_item_liandong(mcId,dmId,flag,gxdwbm,depLev)
{
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = flag;
	gitemid = gxdwbm;
	glevel = depLev;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="business/common/lgDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="450";	//DIV层的宽度
	setDictPage();
}

/*获得管辖单位筛选框*/
function getGxdw(mcId,dmId)
{
	gmcId=mcId;
	gdmId=dmId;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/gxdwDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="420";	//DIV层的宽度
	setDictPage();
}

/*获得管辖单位下拉框 管辖单位为树形结构*/
/*
	mcId-管辖单位名称控件,dmId-管辖单位代码控件,flag-代码类型标志：0-完整管辖单位代码，1-去掉尾部偶数个0的管辖单位代码,level-机构级别
*/
function getGxdwTree(mcId,dmId,flag,level)
{
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = flag;
	glevel = level;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/gxdwTreeDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
}
/*获得管辖单位下拉框 管辖单位为树形结构
  开发监督举报开发的控件  要求根据fullcode显示相应的管辖单位，下级可看到上级。
*/
/*
	mcId-管辖单位名称控件,dmId-管辖单位代码控件,flag-代码类型标志：0-完整管辖单位代码，1-去掉尾部偶数个0的管辖单位代码,level-机构级别
*/
function getGxdwTreejdjb(mcId,dmId,fullCode)
{
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = fullCode;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/gxdwTreeJdjbDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
}
/*获得管辖单位下拉框 管辖单位为树形结构*/
/*
	mcId-管辖单位名称控件,dmId-管辖单位代码控件,flag-代码类型标志：0-完整管辖单位代码，1-去掉尾部偶数个0的管辖单位代码,level-机构级别,treeItemId-树节点id
*/
function getGxdwTree(mcId,dmId,flag,level,treeItemId)
{
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = flag;
	glevel = level;
	gitemid = treeItemId;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/gxdwTreeDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
	
}
/*获得管辖单位下拉框 管辖单位为树形结构 */
/*
	mcId-管辖单位名称控件,
	dmId-管辖单位代码控件,
	jsdmId-管辖单位简项代码控件,
	level-机构级别,
	treeItemId-树节点id
	parentItemId-父节点Id
	fullcode-全路径代码
	isLeaf-是否叶子节点
*/
function getGxdwTree(mcId,dmId,jsdmId,level,treeItemId,parentItemId,fullcode,isLeaf)
{
	gmcId=mcId;
	gdmId=dmId;
	gjsdmId = jsdmId;
	glevel = level;
	gitemid = treeItemId;
	gparentItemId = parentItemId;
	gfullcode = fullcode;
	gisLeaf = isLeaf;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/gxdwTreeDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
	
}

/*获得协查通报下拉框 单位和场所为树形结构*/
/*
	mcId-管辖单位名称控件,dmId-管辖单位代码控件,flag-是传的页面的 行业标志
*/
function getXctbTree(mcId,dmId,flag)
{
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = flag;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/xctbtree.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
	
}

/*获得管辖单位下拉框 管辖单位为树形结构*/
/*
	mcId-管辖单位名称控件,dmId-管辖单位代码控件,flag-代码类型标志：0-完整管辖单位代码，1-去掉尾部偶数个0的管辖单位代码,level-机构级别
*/
function getrylbTree(mcId,dmId,dictCode)
{
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = dictCode;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/rylbTreeDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="200";	//DIV层的宽度

	setDictPage();
	
}

/** 根据实际值得到 部门字典树 **/
/*
mcId-管辖单位名称控件,dmId-管辖单位代码控件, dictCode 字典编码   fact_value 实际值
*/
function getdic_factTree(mcId,dmId,dictCode,fact_value)
{
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = dictCode;
	gfact_value = fact_value;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/xzqhTreeDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="200";	//DIV层的宽度

	setDictPage();
	
}

/*获得奖惩信息下拉框 单位和场所为树形结构*/
/*
	mcId-管辖单位名称控件,dmId-管辖单位代码控件
*/
function getJcxxTree(mcId,dmId,gxdwmc,gxdwbm)
{
	gmcId=mcId;
	gdmId=dmId;
	//gdictCode = flag;
	
	//获取mcId控件的top、left位置和width、height
 	var top = $("#" + mcId).position().top;   
 	var left = $("#" + mcId).position().left;
 	var height = $("#" + mcId).height();
 	var width = $("#" + mcId).width()+3;
 	var option_open = false;      //标记是否打开下拉option
 	//定义DIV层
	var div_html = "<div></div>";
 	div_html = "<div id='divs_"+mcId+"' name='"+gxdwmc+"' path='"+gxdwbm+"' style='position:absolute;background-color:#FFFFFF;top:"+(top+height+6)
 		+"px;left:"+left+"px;width:800"+
 		"px;border:1px #666666 solid;overflow-x:hidden;overflow-y:hidden;display:none;z-index:99999;'>";
 	div_html += "</div>";	

 	$("#" + mcId).after(div_html);   //添加到input控件后面
 	

 	//控制DIV层的显示与关闭
 	function __open_option(){$("div[id^='divs_']").hide();$("#divs_" + mcId).show();option_open=true;}  //显示下拉option
 		
 	function __hide_option()
 	{
 		//隐藏DIV
 		$("#divs_" + mcId).hide();
 		//清除DIV,必须清除div，否则造成里面嵌入的jsp中的元素重复加载
 		$("#divs_" + mcId).remove();
 		option_open=false;$(document).unbind("click",__hide_option);
 	} //隐藏下拉option
 	$("#" + mcId).click(function(event){
 			if(option_open){
 			//__hide_option();
 			}
 			else{__open_option();
 			$(document).bind("click",function(event){
 				var target = (event.target) ? event.target : event.srcElement;
 					var parents = $(target).parents();
 					var ishave = false;
 					for(var i=0;i<parents.length;i++){
 						if(parents.eq(i).attr("id")==("divs_" + mcId)||
 								$(target).attr("id")==("divs_" + mcId)){
 							ishave = true;
 							break;
 						}
 					}
 					if(!ishave){
 						__hide_option();
 					}
 			});
 	}
 			event.stopPropagation();}
 	);

 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/jcxxtree.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
	
}

	//典当企业	
function getDdqy_item(mcId,dmId,mgdictCode){
	gmcId=mcId;
	gdmId=dmId;
	
	gdictCode = mgdictCode;
	$("#divs_" + mcId).remove(); //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);	 	
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="business/common/ddqyDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="500";	//DIV层的宽度
	setDictPage();
}



/*获得详细地址的树形结构  点击叶子节点 得到树形结构的全路径   出租房系统*/
/*  cId-字典显示值控件ID,dmId-字典实际值控件ID,dictCode-字典编码  */
function getxxdzTree(mcId,dmId,dictCode){
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = dictCode;
	
  	//获取mcId控件的top、left位置和width、height
 	var top = $("#" + mcId).position().top;   
 	var left = $("#" + mcId).position().left;
 	var height = $("#" + mcId).height();
 	var width = $("#" + mcId).width()+3;
 	var factTop = top+height+6;
 	var option_open = false;      //标记是否打开下拉option
 	//若下拉框左边界距屏幕右边界的距离小于下拉框的宽度，则将下拉框左移
 	if(document.body.clientWidth-left<400)
 	{
 		left = document.body.clientWidth-(document.body.clientWidth-(left+width)+400);
 	}
 	//若下拉框上边界距屏幕下边界的距离小于下拉框的高度，则将下拉框上移
 	if(document.body.clientHeight-(top+height)<330)
 	{
 		factTop = top-330-height;
 	}
 	//定义DIV层
	var div_html = "<div></div>";
 	div_html = "<div id='divs_"+mcId+"' style='position:absolute;background-color:#FFFFFF;top:"+factTop
 		+"px;left:"+left+"px;width:220"+
 		"px;border:1px #666666 solid;overflow-x:hidden;overflow-y:hidden;display:none;z-index:99999;'>";
 	div_html += "</div>";	

 	$("#" + mcId).after(div_html);   //添加到input控件后面
 	

 	//控制DIV层的显示与关闭
 	function __open_option(){$("div[id^='divs_']").hide();$("#divs_" + mcId).show();option_open=true;}  //显示下拉option
 		
 	function __hide_option()
 	{
 		//隐藏DIV
 		$("#divs_" + mcId).hide();
 		//清除DIV,必须清除div，否则造成里面嵌入的jsp中的元素重复加载
 		$("#divs_" + mcId).remove();
 		option_open=false;$(document).unbind("click",__hide_option);
 	} //隐藏下拉option
 	$("#" + mcId).click(function(event){
 			if(option_open){
 			//__hide_option();
 			}
 			else{__open_option();
 			$(document).bind("click",function(event){
 				var target = (event.target) ? event.target : event.srcElement;
 					var parents = $(target).parents();
 					var ishave = false;
 					for(var i=0;i<parents.length;i++){
 						if(parents.eq(i).attr("id")==("divs_" + mcId)||
 								$(target).attr("id")==("divs_" + mcId)){
 							ishave = true;
 							break;
 						}
 					}
 					if(!ishave){
 						__hide_option();
 					}
 			});
 	}
 			event.stopPropagation();}
 	);

 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/xxdzTreeDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="380";	//DIV层的宽度

	setDictPage();
	
}

//出租房采集点管辖单位树
function getGxdwCaiJiDianTree(mcId,dmId,method){
	diaoYongMethod = method;
	getGxdwTree(mcId,dmId);
}


function getCaijidian_List(mcId,dmId,flag,gxdwbm){
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = flag;
	gGxdwbm = gxdwbm;
	
  	//获取mcId控件的top、left位置和width、height
 	var top = $("#" + mcId).position().top;   
 	var left = $("#" + mcId).position().left;
 	var height = $("#" + mcId).height();
 	var width = $("#" + mcId).width()+3;
 	var option_open = false;      //标记是否打开下拉option
 	var factTop = top+height+6;
 	//若下拉框左边界距屏幕右边界的距离小于下拉框的宽度，则将下拉框左移
 	if(document.body.clientWidth-left<400)
 	{
 		left = document.body.clientWidth-(document.body.clientWidth-(left+width)+400);
 	}
 	//若下拉框上边界距屏幕下边界的距离小于下拉框的高度，则将下拉框上移
 	if(document.body.clientHeight-(top+height)<330)
 	{
 		factTop = top-330-height;
 	}
 	//定义DIV层
	var div_html = "<div></div>";
 	div_html = "<div id='divs_"+mcId+"' style='position:absolute;background-color:#FFFFFF;top:"+factTop
 		+"px;left:"+left+"px;width:800"+
 		"px;border:1px #666666 solid;overflow-x:hidden;overflow-y:hidden;display:none;z-index:99999;'>";
 	div_html += "</div>";	

 	$("#" + mcId).after(div_html);   //添加到input控件后面
 	

 	//控制DIV层的显示与关闭
 	function __open_option(){$("div[id^='divs_']").hide();$("#divs_" + mcId).show();option_open=true;}  //显示下拉option
 		
 	function __hide_option()
 	{
 		//隐藏DIV
 		$("#divs_" + mcId).hide();
 		//清除DIV,必须清除div，否则造成里面嵌入的jsp中的元素重复加载
 		$("#divs_" + mcId).remove();
 		option_open=false;$(document).unbind("click",__hide_option);
 	} //隐藏下拉option
 	$("#" + mcId).click(function(event){
 			if(option_open){
 			//__hide_option();
 			}
 			else{__open_option();
 			$(document).bind("click",function(event){
 				var target = (event.target) ? event.target : event.srcElement;
 					var parents = $(target).parents();
 					var ishave = false;
 					for(var i=0;i<parents.length;i++){
 						if(parents.eq(i).attr("id")==("divs_" + mcId)||
 								$(target).attr("id")==("divs_" + mcId)){
 							ishave = true;
 							break;
 						}
 					}
 					if(!ishave){
 						__hide_option();
 					}
 			});
 	}
 			event.stopPropagation();}
 	);

 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="business/common/caijidianDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
	
}


function getDwsjjdhxp_item(mcId,dmId)
{
	gmcId=mcId;
	gdmId=dmId;
	$("#divs_" + mcId).remove(); //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="business/common/DwsjjdhxpDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="500";	//DIV层的宽度

	setDictPage();
}
function getGmmxjdhxp_item(mcId,dmId)
{
	gmcId=mcId;
	gdmId=dmId;
	$("#divs_" + mcId).remove(); //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="business/common/GmmxdhxpDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="500";	//DIV层的宽度

	setDictPage();
}
/*获得典当企业筛选框*/
function getDdqy(mcId,dmId,qyid)
{
	gmcId=mcId;
	gdmId=dmId;
	if(qyid!=""){
		gdictCode=qyid;
	}
	$("#divs_" + mcId).remove(); //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);

 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/ddqy2DropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="420";	//DIV层的宽度
	setDictPage();
}


/** 根据实际值得到 部门字典树 **/


/*获得企业副分类下拉框 管辖单位为树形结构*/
/*
	mcId-名称,dmId-代码,imid-id,dictCode-字典代码
*/
function getqyfflTree(mcId,dmId,imid,glbm,dictCode,flg)
{
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = dictCode;
	gmcitemId=imid;
	glitemCode=glbm;
	if(flg!='undefined'){
		glflg=flg;
	}else{
		glflg='';
	}
	
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
     addHtmlDict="basic/common/qyffl_dictDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="200";	//DIV层的宽度

	setDictPage();
	
}

/*获得积分规则下拉框为树形结构

	mcId-显示名称,dmId-拼接字符串,ruleId-规则id
	* dataid传递参数
	* dataid=________a,则不传参数，8个下划线
	* dataid=$("#a_ssdwdm").val()+"__"+$("#a_hylbdm").val()+"__"+$("#a_jcbmdm").val()+"__"+$("#a_gzlx").val()+"__a";
*/
function getJfgzTree(mcId,dmId,ruleId)
{
	gmcId=mcId;
	gdmId=dmId;
	gitemid = ruleId;
	if($("#divs_"+mcId).length>0){return;} 
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
 	$("#"+detailidDict).css("left",$("#"+mcId).position().left+"px");//修正div层的位置
    addHtmlDict="basic/common/jfgzTree_DropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="200";	//DIV层的宽度

	setDictPage();
	
}
/*获得物品名称及物品所有人信息
 *flag-0物品文本框被点击；1物品所有人文本框被选中
 *return
 * wtjmwpmc-物品名称,wtjmwpid-物品ID,dhxm-物品所有人,wtjmxxid-委托寄卖信息ID
 * qyid-企业ID
 */
var gmc2Id;
var gdm2Id;
function getWtjmwp_item(mcOne,bmOne,mcTwo,bmTwo,qyid,flag)
{
	gmcId=mcOne;
	gdmId=bmOne;
	gmc2Id=mcTwo;
	gdm2Id=bmTwo;
	gcodeValue=qyid;
	glflg=flag;
	if($("#divs_"+gmcId).length>0){return;}
	shuaiXuanKuangComm(gmcId,gdmId);
 	detailidDict="divs_"+gmcId;//DIV层的ID
    addHtmlDict="business/wtjmzagl/WtjmwpDropDown.jsp";//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
}

/*获得管辖单位下拉框且为全机构不做等级限制 管辖单位为树形结构*/
function getGxdwAllTree(mcId,dmId,flag,level)
{
	gmcId=mcId;
	gdmId=dmId;
	gdictCode = flag;
	glevel = level;
	if($("#divs_"+mcId).length>0){return;} //yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId,dmId);
 	detailidDict="divs_"+mcId;//DIV层的ID
    addHtmlDict="basic/common/gxdwAllTreeDropDown.jsp?level="+level;//DIV层内嵌的jsp页面
	addWidthDict="400";	//DIV层的宽度

	setDictPage();
}
 /* 获得协查通报下拉框 单位和场所为树形结构 */
/*
 * mcId-管辖单位名称控件,dmId-管辖单位代码控件,flag-是传的页面的 行业标志
 */
function getGatztbTree(mcId, dmId, flag) {
	gmcId = mcId;
	gdmId = dmId;
	gdictCode = flag;
	if ($("#divs_" + mcId).length > 0) {
		return;
	} // yangbo 4.29 add:偶尔筛选不好用
	shuaiXuanKuangComm(mcId, dmId);
	detailidDict = "divs_" + mcId;// DIV层的ID
	addHtmlDict = "basic/common/gatztbtree.jsp";// DIV层内嵌的jsp页面
	addWidthDict = "400"; // DIV层的宽度
	
	setDictPage();
	
}
