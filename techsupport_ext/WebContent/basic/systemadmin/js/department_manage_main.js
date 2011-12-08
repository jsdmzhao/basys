/**
 * filename:department_manage_main.js 机构管理页面
 */

Ext.ns("techsupport.deparmentmanage");

techsupport.deparmentmanage.DepartmentMain = Ext.extend(Ext.Panel, {
	constructor : function(config) {
		// 父类
		this.title = config.title | '机构管理';
		this.layout = 'border';
		this.id = 'department_manage_panal';
		this.defaults = {
			bodyStyle : 'padding:4px;'
		};
		
		/** 机构树*/
		this.department_treepanel;
		/** 机构表格*/
		this.department_gridpanel;
		/** 机构详情动作*/
		this.department_action;
		/** 当前的机构ID*/
		this.current_department_id;
		/** 单位数据集*/
		this.department_store;
		
		this.department_request;
		alert(1111);//###
		techsupport.deparmentmanage.DepartmentMain.superclass.constructor
				.apply(this, arguments);
	},
	/** 初始化组件内容 */
	initComponent : function() {
		this.department_store =  new Ext.data.JsonStore({
				proxy:new Ext.data.HttpProxy({
					url:context_path+'/query_departmentmanage.action',
					params:{'department.departid':this.current_department_id}}),
				reader:new Ext.data.JsonReader({
					idProperty:'department_reader_id',
					root:'department_list',
					totalProperty:'total',
					fields:['departid','departcode','departname',{name:"parentname",mapping:'parent.departanme'}]
				})
			});
		this.department_treepanel = new Ext.tree.TreePanel({
			xtype : 'treepanel',
			layout : 'west',
			id : 'department_treepanel',
			title : '机构',// 以后去掉
			useArrows : true,
			autoScroll : true,
			animate : true,
			enableDD : false,
			containerScroll : true,
			border : false
		});
		alert(22222);//###
		this.department_gridpanel = new Ext.grid.GridPanel({
			xtype : 'gridpanel',
			layout : 'center',
			id : 'department_grid',
			store : this.department_store,
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
		this.items = [ this.department_treepanel, this.department_gridpanel ];
		//父类
		techsupport.deparmentmanage.DepartmentMain.superclass.initComponent.apply(this,arguments);
	},
	/** 添加一个单位 */
	add_department : function() {
	},
	/**
	 * 删除一个单位，当该单位有下级单位弹出确认框，让用户确认是否全部依赖删除，当用户选择确认以后
	 * ，删除跟改单位所有相关的信息（单位，用户，用户权限映射）
	 */
	remove_department : function() {
	},
	/** 修改一个单位信息 */
	modify_department : function() {
	}
});

Ext.reg('department_main', techsupport.deparmentmanage.DepartmentMain);
