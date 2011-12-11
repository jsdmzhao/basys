/**
 * filename:department_manage_main.js 机构管理页面
 */

(function(){
	
	Ext.ns("techsupport.deparmentmanage");

	/**
	 * 机构动作，例如增删改详情
	 * @param config 构造参数
	 * @author hooxin
	 *
	 */
	techsupport.deparmentmanage.DepartmentAction = function(config){
		this.action_name = config.action_name || '浏览';
		this.width = config.width || 500;
		this.height = config.height || 300;
		this.layout = config.layout;
		this.title = config.title || '机构';
		this.id = config.id;
		this.defaults = config.defaults || { bodyStyle : 'padding: 4px;',xtype:'textfield'};
		this.renderTo = config.renderTo || 'body';
		
		this.viewConfig = {
				forceFit:true
		};
		
		techsupport.deparmentmanage.DepartmentActionFrame.superclass.constructor.apply(this,arguments);
	};
	
	Ext.extend(techsupport.deparmentmanage.DepartmentAction,Ext.Window,{
		initComponent:function(ct,position){
			techsupport.deparmentmanage.DepartmentAction.superclass.initComponent.apply(this,arguments);
		}
	});
	
	
	techsupport.deparmentmanage.DepartmentMain = function(config) {
		// 父类
		this.title = config.title || '机构管理';
		this.title_base = config.title_base || '机构';
		this.layout = config.layout ||'border';
		this.id =  config.id ||'manage_panal';
		this.defaults = config.defaults || {
			bodyStyle : 'padding:4px;',
			split : true
		};
		this.renderTo = config.renderTo || 'body';
		
		this.items = config.items || [];
		
		this.width = config.width || '100%;';
		this.height = config.height || '100%;';

		this.style = 'height:100%;';
		this.enableDD = config.enableDD ||false;
		this.body_height;
		this.viewConfig = {
				forceFit:true
		};
		techsupport.deparmentmanage.DepartmentMain.superclass.constructor
				.apply(this, arguments);
		
		/** 左边树*/
		this.treepanel;
		/** 后边表格*/
		this.gridpanel;
		/** 详情动作*/
		this.action;
		/** 当前的ID*/
		this.current_treenode_id;
		/** 数据集*/
		this.store;
		this.tree_level = 99;
		this.treeloader;
		
		this.right_detail_panel;
		
	};
	
	Ext.reg('department_main', techsupport.deparmentmanage.DepartmentMain);
	
	Ext.extend(techsupport.deparmentmanage.DepartmentMain,Ext.Panel, {
		/** 初始化组件内容 */
		initComponent : function(ct,position) {
			this.store =  new Ext.data.JsonStore({
					proxy:new Ext.data.HttpProxy({
						url:context_path+'/sysadminDefault/query_departmentmanage.action',
						params:{'department.departid':this.current_treenode_id}}),
//				    proxy:Ext.data.MemoryProxy({department_list:[{departid:'1',departcode:'1',departname:'1',parent:{parentname:'0'}},
//				                                                 {departid:'2',departcode:'2',departname:'2',parent:{parentname:'0'}},
//				                                                 {departid:'3',departcode:'3',departname:'3',parent:{parentname:'0'}}
//				                                                 ],total:3}),
					reader:new Ext.data.JsonReader({
						idProperty:'department_reader_id',
						root:'department_list',
						totalProperty:'total',
						fields:['departid','departcode','departname',{name:"parentname",mapping:'parent.departanme'}]
					})
				});
		
			this.right_detail_panel = new Ext.Panel({
				id:this.id + '_detail',
				});
			this.treeloader = new Ext.tree.TreeLoader({
				url:context_path+'/sysadminDefault/query_department_node_departmentmanage.action',
				method:'post',
				listeners:{
					beforeload:function(loader,node){
						loader.baseParams['department.departid'] = node.attributes.attributes.departid;
						loader.baseParams['department.departlevel'] = techsupport.deparmentmanage.DepartmentMain.tree_level;
					}
				}});
			this.treepanel = new Ext.tree.TreePanel({
				region : 'west',
				id : this.id+'_tree',
				title : this.title_base +'数',// 以后去掉
				useArrows : true,
				autoScroll : true,
				animate : true,
				enableDD : false,
				containerScroll : true,
				border : false,
				width: '25%',
				rootVisable : false,
				viewConfig:{
					forceFit:true
				},
				loader:this.treeloader,
				root:{id:'tree_root',text:'顶端',nodeType: 'async',attributes:{'departid':0,departlevel:this.tree_level}},
				listeners:{
					click:function(tree,node){
						//点击动作
					}
				}
			});
			this.gridpanel = new Ext.grid.GridPanel({
				title : this.title_base +'信息',
				region : 'center',
				id : this.id+'_grid',
				store : this.store,
				border:false,
				width:'75%',
				defaults:{
					bodyStyle:'width:100%;'
				},
				viewConfig:{
					forceFit:true
				},
				columns:[
					{id: 'departid', header: '机构ID', dataIndex: 'departid', sortable: false,width:100},
					{header: this.title_base+'代码',dataIndex:'departcode',width:300},
					{header: this.title_base+'名称',dataIndex:'departname',width:300},
					{header:'上级'+this.title_base,dataIndex:'parentname',width:300}
				],
				tbar:[
						{xtype:'button',text:'添加',handler:function(){}},
						'-',
						{xtype:'button',text:'修改',handler:function(){}},
						'-',
						{xtype:'button',text:'删除',handler:function(){}},
						'-',
						{xtype:'button',text:'置顶',handler:function(){}},
						'-',
						{xtype:'button',text:'上移',handler:function(){}},
						'-',
						{xtype:'button',text:'下移',handler:function(){}},
						'-',
						{xtype:'button',text:'置底',handler:function(){}}
					]
			});
			this.items = [this.gridpanel, this.treepanel ];
			//父类
			techsupport.deparmentmanage.DepartmentMain.superclass.initComponent.apply(this,arguments);
		},
		onRender:function(ct,position){
			techsupport.deparmentmanage.DepartmentMain.superclass.onRender.apply(this,arguments);
		},
		afterRender:function(ct,position){
			this.body_height = this.getHeight()-this.getFrameHeight() - 15;
			this.body.setHeight(this.body_height);
			
			techsupport.deparmentmanage.DepartmentMain.superclass.afterRender.apply(this,arguments );
			this.treepanel.getRootNode().expand();
		}
		//附加内容结束
	});
	
})();



