/**
 * filename:department_manage_main.js 机构管理页面
 */

(function(){
	
	Ext.ns("techsupport.deparmentmanage");

	techsupport.deparmentmanage.DepartmentMain = function(config) {
		// 父类
		this.title = config.title || '机构管理';
		this.layout = config.layout ||'border';
		this.id =  config.id ||'manage_panal';
		this.defaults = config.defaults || {
			bodyStyle : 'padding:4px;'
		};
		this.renderTo = config.renderTo || 'body';
		
		this.items = config.items || [];
		
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
		
	};
	Ext.extend(techsupport.deparmentmanage.DepartmentMain,Ext.Panel, {
		/** 初始化组件内容 */
		initComponent : function(ct,position) {
			this.store =  new Ext.data.JsonStore({
					proxy:new Ext.data.HttpProxy({
						url:context_path+'/query_departmentmanage.action',
						params:{'department.departid':this.current_treenode_id}}),
					reader:new Ext.data.JsonReader({
						idProperty:'department_reader_id',
						root:'department_list',
						totalProperty:'total',
						fields:['departid','departcode','departname',{name:"parentname",mapping:'parent.departanme'}]
					})
				});
			this.treepanel = new Ext.tree.TreePanel({
				region : 'west',
				id : 'treepanel',
				title : '机构',// 以后去掉
				useArrows : true,
				autoScroll : true,
				animate : true,
				enableDD : false,
				containerScroll : true,
				border : false,
				anchor : 'width:28%;height:100%;',
				rootVisable : false,
				root:{}
			
			});
			this.gridpanel = new Ext.grid.GridPanel({
				region : 'center',
				id : this.id+'_grid',
				store : this.store,
				anchor:'width:70%;height:100%;',
				columns:[
					{id: 'departid', header: '机构ID', sortable: true, dataIndex: 'departid',width:'10%'},
					{header:'机构代码',dataIndex:'departcode',width:'30%'},
					{header:'机构名称',dataIndex:'departname'},
					{header:'上级机构',dataIndex:'parentname'}
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
			this.items = [this.treepanel, this.gridpanel ];
			//父类
			techsupport.deparmentmanage.DepartmentMain.superclass.initComponent.apply(this,arguments);
		},
		onRender:function(ct,position){
			techsupport.deparmentmanage.DepartmentMain.superclass.onRender.apply(this,arguments);
		}
		//附加内容结束
	});
	
	Ext.reg('department_main', techsupport.deparmentmanage.DepartmentMain);
})(Ext);



