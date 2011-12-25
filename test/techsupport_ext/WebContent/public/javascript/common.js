/*
 * filename: common.js 一些共有的JS组件或者属性
 * 
 */

/** 文档区域高度 */
document_height = Ext.getDoc().getHeight();
/**
 * 通过结构化的JSON对象返回，FORM提交用的对象
 * */
function buildSubmitParam(subpa, para, prefix) {

	for (key in para) {
		if (para[key] && typeof para[key] == "object") {
			if (prefix)
				prefix = prefix + key + '.';
			else
				prefix = key + '.';
			subpa = buildSubmitParam(subpa, para[key], prefix);
			prefix = null;
		} else {
			if (prefix == null){
				if(para[key])
					subpa[key] = para[key];
			}
				
			else{
				if(para[key])
					subpa[prefix + key] = para[key];
			}
				
		}
	}
	return subpa;
}

(function(){
	
	/**
	 * 扩充EXT，通用提交方法
	 * 
	 */
	Ext.Ajax.simpleSubmit = function(config){
		var para={};
		if(config.actionPrefix){
			if(/\[[A-z]*\]/.exec(config.actionPrefix)){
				var tmpPara = {};
				for(var i=0;i< config.para.length;i++){
					var prefix = config.actionPrefix;
					prefix = prefix.replace(/\[[A-z]*\]/,"["+i+"]");
					tmpPara[prefix]=config.para[i];
				}
				para = buildSubmitParam({},tmpPara);
			}
			else
				
				para = buildSubmitParam({},config.para,config.actionPrefix);
		}
			
		Ext.Ajax.request({
			url:config.url,
			params:para,
			success:function(response,opt){
				var data = Ext.decode(response.responseText);
				
				
				if(!data.returnNo&&data.returnMessage){
					
					//执行回调
					if(config.successCallback){
						config.successCallback(data);
					}
					
					Ext.example.msg('成功',data.returnMessage);
				}
					
				if(data.returnNo&&data.returnMessage){
					//执行错误回调
					if(config.successFailCallback){
						config.successFailCallback(data);
					}
					Ext.example.msg('错误',data.returnMessage);
					if(data.returnMessageDebug)
						Ext.example.msg('错误',data.returnMessageDebug);
				}
					
			},
			failure:function(response,opt){
				Ext.example.msg('未成功错误',response.responseText);
			}
		});
	};
	
	Ext.AsinoPagingToolBar = Ext.extend(Ext.PagingToolbar,{
		constructor:function(config){
			this.afterPageText = config.afterPageText || '共{0}页';
	        this.beforePageText = config.beforePageText || '当前页';
	        this.lastText = config.lastText || "尾页";   
	        this.nextText  = config.nextText || "下一页";   
	        this.prevText  = config.prevText || "上一页";   
	        this.firstText  = config.firstText || "首页";   
	        this.refreshText = config.refreshText || "刷新";  
			this.emptyMsg  =  config.emptyMsg || '没有数据显示';
			this.displayMsg  = config.displayMsg || '{0}-{1}条,总条数{2}';
			
			Ext.AsinoPagingToolBar.superclass.constructor.apply(this, arguments);

		}
		
	}); 
})();

	
