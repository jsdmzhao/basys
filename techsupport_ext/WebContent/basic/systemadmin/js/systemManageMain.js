/***
 * filename: systemManageMain.js
 * description: 系统管理页面组件 主要继承 机构管理页面组件，
 * 				对中间部分组件做修改
 * 
 */

(function(){
//	声明包
	Ext.ns("techsupport.systemmanage");
	
	techsupport.systemmanage.SystemMain = Ext.extend(techsupport.deparmentmanage.DepartmentMain,{
		constructor:function(config){
			this.title = "系统管理";
			this.title_base = "系统";
			this.dir = "nodeorder";
			
			this.addUrl = context_path+'/sysadminDefault/add_systemmanage.action';
			this.modifyUrl = context_path+'/sysadminDefault/modify_systemmanage.action';
			this.queryUrl = context_path+'/sysadminDefault/querylist_systemmanage.action';
			this.detailUrl = context_path+'/sysadminDefault/query_systemmanage.action';
			this.removeUrl = context_path+'/sysadminDefault/remove_systemmanage.action';
			
			this.actionPrefix = 'system.';
			this.removePrefix = 'systemList[i]';
			
			techsupport.systemmanage.SystemMain.superclass.constructor.apply(this,arguments);
		},
		initComponent:function(ct,position){
			var self = this;
			//列表区域的数据仓库
			this.store =  new Ext.data.JsonStore( {
				idProperty:'systemcode',
				root:'systemList',
				url:this.queryURL,
				baseParams:{
					start:0,
					limit:this.pagesize,
					dir:this.dir,
					sort:this.sort
				},
				remoteSort:true,
				totalProperty:'total',
				fields:[
					{name:'systemcode',mapping:'systemcode'},
					{name:'systemname',mapping:'systemname'},
					{name:'fullcode',mapping:'fullcode'},
					{name:'picturepath',mapping:'picturepath'},
					{name:'isleaf',mapping:'isleaf'},
					{name:'nodeorder',mapping:'nodeorder'},
					{name:'parentsystemcode',mapping:'parentsystemcode'},
					{name:'systemdefine',mapping:'systemdefine'}
				],
				listeners:{
					beforeload:{
						fn:function(store,options){
							Ext.apply(options.params,{
								dir:this.dir,
								sort:this.sort
							});
							options.params[this.actionPrefix+'parentsystemcode']=this.current_treenode_id;
						},
						scope:this
					}
					
				}
			});
			//当前系统详情面板
			this.detail_panel = Ext.create({
				xtype:'form',
				layout:'column',
				viewConfig:{forceFit:true},
				frame:false,
				defaults:{
					border:false,
					bodyStyle:'padding:2',
					labelAlign:'right'
				},
//				自动适应浏览器宽度
				items:[
				       {
				    	   layout:'form',
				    	   defaults:detail_panel_items_defaults,
				    	   items:[
				    	          {name:'systemcode',fieldLabel:this.title_base+'代码',readOnly:true}
				    	          
				    	   ]
				       },
				       {
				    	   layout:'form',
				    	   defaults:detail_panel_items_defaults,
				    	   items:[
				    	          {name:'systemname',fieldLabel:this.title_base+'名称'}
				    	   ]
				       },
				       {
				    	   layout:'form',
				    	   defaults:detail_panel_items_defaults,
				    	   items:[
				    	          {name:'fullcode',fieldLabel:this.title_base+'全码',readOnly:true}
				    	   ]
				       }
				]
			});
				
			this.columnModel = new Ext.grid.ColumnModel({
			    columns:[
				    sm,
					{header: this.title_base+'代码', dataIndex:'systemcode',width:100},
					{header: this.title_base+'名称',dataIndex:'systemname',width:300},
					{header: this.title_base+'全码',dataIndex:'fullcode',width:300},
					{header: this.title_base+'定义',dataIndex:'systemdefine',width:300}
				],
			    defaults: {
			        sortable: false,
			        menuDisabled: false
			    }
			});
			
			
			techsupport.systemmanage.SystemMain.superclass.initComponent.apply(this,arguments);
		}
	});
})();