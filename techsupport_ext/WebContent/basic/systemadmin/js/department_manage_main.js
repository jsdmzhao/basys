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
	techsupport.deparmentmanage.DepartmentWindow = Ext.extend(Ext.Window,{
		constructor: function(config){
			this.width = config.width || 300;
			this.layout = config.layout;
			this.title = config.title || '机构';
			this.id = config.id;
			this.defaults = config.defaults || { bodyStyle : 'padding: 4px;',xtype:'textfield'};
			this.renderTo = config.renderTo || Ext.getBody();
			this.closeAction=config.closeAction || "close";
			this.viewConfig = {
					forceFit:true
			};
//			设置上层容器
			this.ownerCt = config.ownerCt;
//			动作名称 例如 add modify detail之类的
			this.action_name = config.action_name || 'detail';
			this.action = config.action;
			this.store = config.store;
			this.modal = config.modal || true;
			this.dstore = config.dstore;
			
			techsupport.deparmentmanage.DepartmentWindow.superclass.constructor.apply(this,arguments);
		},
		initComponent:function(ct,position){
			var self = this;
			//form对象默认值
			this.form_panel_default = {
				xtype:'textfield',
				columnWidth:.20
			};
			//内容包含一个form表单
			this.form_panel = Ext.create({
				xtype:'form',
				layout:'form',
				viewConfig:{ forceFit:true},
				defaults:this.form_panel_default,
//				面板里面放置机构所需的属性
				items:[
				      {name:'departid',fieldLabel:'机构ID',xtype:'hidden'},
				      {name:'departcode',fieldLabel:'机构代码',allowBlank:false,blankText:'机构代码不能为空',
				    	  validator:function(val){
				    		  //验证机构代码是否可用
				    		  var result = null;
				    		  Ext.Ajax.request({url:});//###
				    		  return result;
				    	  }
				      },
				      {name:'departname',fieldLabel:'机构名称',allowBlank:false,blankText:'机构名称不能空'},
				      {name:'parent.departname',fieldLabel:'上级机构',allowBlank:false,blankText:'上级机构不能为空',readOnly:true},
				      {name:'departfullcode',fieldLabel:'机构全码',allowBlank:false,blankText:'机构全码不能为空',readOnly:true},
				      {name:'parent.departid',fieldLabel:'上级机构ID',allowBlank:false,blankText:'上级机构ID不能为空',readOnly:true,hidden:true},
				      {name:'parent.isleaf',fieldLabel:'上级机构叶子',allowBlank:false,blankText:'上级机构叶子不能为空',value:'N',hidden:true},
				      {name:'parent.departfullcode',fieldLabel:'上级机构全码',allowBlank:false,blankText:'上级机构全码不能为空',readOnly:true,hidden:true},
				      {name:'nodeorder',fieldLabel:'序列',allowBlank:true,blankText:'序列不能为空',readOnly:true,hidden:true}
				]
			});
			//添加FORM事件
			this.form_panel.getForm().findField('departcode').on('blur',function(field){
	    				  	var form = this.form_panel.getForm();
			    		    var parentfullcodeField = form.findField('parent.departfullcode');
							var fullcodeField = form.findField('departfullcode');
							fullcodeField.setValue(parentfullcodeField.getValue()+field.getValue());
			    	  },
	    			  this
	    		  );
			
			this.items = [this.form_panel];
			
			if(this.action_name=='add'){
				this.title='添加机构信息';
				this.buttons = [
				     {
				    	 xtype:'button',text:'保存',handler:function(){
				    		 var action = self.action;
				    		 if(self.form_panel.getForm().isValid()){
				    			 action.add(self.form_panel.getForm().getValues(),function(){
					    			 self.close();
					    		 });
				    		 }
				    		 
				    	 }
				     },
				     {xtype:'button',text:'关闭',handler:function(){
				    	 self.close();
				     }}
				];

			}
			else if (this.action_name == 'modify'){
				this.title = '修改机构信息';
				var form = self.form_panel.getForm();
				this.buttons = [
				    {
				    	xtype:'button',text:'保存',handler:function(){
				    		self.form_panel.getForm().findField('nodeorder').setVisable
				    		if(self.form_panel.getForm().isValid()){
				    			self.action.modify(self.form_panel.getForm().getValues(),function(){
					    			self.close();
					    		});
				    		}
				    		
				    	}
				    },
				    {
				    	xtype:'button',text:'关闭',handler:function(){
				    		self.close();
				    	}
				    }
				];
			}
			else if (this.action_name == 'detail'){
				this.title = '机构信息';
			}
			
			techsupport.deparmentmanage.DepartmentWindow.superclass.initComponent.apply(this,arguments);
		},
		afterRender:function(ct,position){
			techsupport.deparmentmanage.DepartmentWindow.superclass.afterRender.apply(this,arguments);
		}
	});
	
	
	techsupport.deparmentmanage.DepartmentMain = Ext.extend(Ext.Panel, {
		constructor:function(config) {
			// 父类
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
			/** 左边树*/
			this.treepanel;
			/** 后边表格*/
			this.gridpanel;
			/** 详情动作*/
			this.action;
			/** 数据集*/
			this.store;
			/** 详情数据集*/
			this.detail_store;
			
			this.tree_level = 99;
			this.treeloader;
			
			this.right_panel;
			this.detail_panel;
//			每页显示数
			this.pagesize = 25;
//			默认排序列
			this.dir = 'nodeorder';
//			默认排序方式
			this.sort = 'asc';
//			当前id
			this.current_treenode_id;
			
			this.addURL=context_path+'/sysadminDefault/add_departmentmanage.action';
			this.modifyURL=context_path+'/sysadminDefault/modify_departmentmanage.action';
			this.removeURL=context_path+'/sysadminDefault/remove_departmentmanage.action';
			this.queryURL=context_path+'/sysadminDefault/querylist_departmentmanage.action';
			this.detailURL=context_path+'/sysadminDefault/query_departmentmanage.action';
			
			this.action_prefix = 'department.';
			this.remove_prefix = 'department_list[i].';
			
			//详情弹出窗口容器
			this.detail_window = config.detail_window || Ext.getBody();
			techsupport.deparmentmanage.DepartmentMain.superclass.constructor
					.apply(this, arguments);
			
		},
		/** 初始化组件内容 */
		initComponent : function(ct,position) {
			var self = this;
			this.action = {
					modify:function(para,callback,callback_scope){
						
						if(self.action_prefix){
							para = buildSubmitParam({},para,self.action_prefix);
						}
							
						Ext.Ajax.request({
							url:self.modifyURL,
							params:para,
							success:function(response,opt){
								var data = Ext.decode(response.responseText);
								
								//执行回调
								if(callback){
									if(callback_scope)
										with(callback_scope){
										callback(response);
										}
									else 
										callback(response);
								}
								
								if(!data.returnNo&&data.returnMessage)
									Ext.example.msg('成功',data.returnMessage);
								if(data.returnNo&&data.returnMessage){
									Ext.example.msg('错误',data.returnMessage);
									if(data.returnMessageDebug)
										Ext.example.msg('错误',data.returnMessageDebug);
								}
									
							},
							failure:function(response,opt){
								Ext.example.msg('错误',response.responseText);
							}
						});
					},
					add:function(para,callback,callback_scope){
						if(self.action_prefix){
							para = buildSubmitParam({},para,self.action_prefix);
						}
						Ext.Ajax.request({
							url:self.addURL,
							params:para,
							success:function(response,opt){
								var data = Ext.decode(response.responseText);
								//执行回调
								
								if(callback){
									if(callback_scope)
										with(callback_scope){
										callback(response);
										}
									else 
										callback(response);
								}
								
								if(!data.returnNo&&data.returnMessage)
									Ext.example.msg('成功',data.returnMessage);
								if(data.returnNo&&data.returnMessage){
									Ext.example.msg('错误',data.returnMessage);
									if(data.returnMessageDebug)
										Ext.example.msg('错误',data.returnMessageDebug);
								}
									
							},
							failure:function(response,opt){
								Ext.example.msg('错误',response.responseText);
							}
						});
					}
			};
			this.store =  new Ext.data.JsonStore( {
				idProperty:'departid',
				root:'department_list',
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
					{name:'departid',mapping:'departid'},
					{name:'departcode',mapping:'departcode'},
					{name:'departname',mapping:'departname'},
					{name:'departfullcode',mapping:'departfullcode'},
					{name:'departlevel',mapping:'departlevel'},
					{name:'isleaf',mapping:'isleaf'},
					{name:'nodeorder',mapping:'nodeorder'},
					{name:'parent',mapping:'parent'},
					{name:'departbrevitycode',mapping:'departbrevitycode'}
				],
				listeners:{
					beforeload:{
						fn:function(store,options){
							Ext.apply(options.params,{
								dir:this.dir,
								sort:this.sort
							});
							options.params[this.action_prefix+'parent.departid']=this.current_treenode_id;
						},
						scope:this
					}
					
				}
				});
			
			
			this.detail_store = new Ext.data.JsonStore({
				idProperty:'departid',
				root:'department_list',
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
					{name:'departid',mapping:'departid'},
					{name:'departcode',mapping:'departcode'},
					{name:'departname',mapping:'departname'},
					{name:'departfullcode',mapping:'departfullcode'},
					{name:'departlevel',mapping:'departlevel'},
					{name:'isleaf',mapping:'isleaf'},
					{name:'nodeorder',mapping:'nodeorder'},
					{name:'parent',mapping:'parent'},
					{name:'departbrevitycode',mapping:'departbrevitycode'}
				]
				});
			
			this.treeloader = new Ext.tree.TreeLoader({
				url:context_path+'/sysadminDefault/query_department_node_departmentmanage.action',
				method:'post',
				listeners:{
					beforeload:{
						fn:function(loader,node){
							loader.baseParams[this.action_prefix+'departid'] = node.id;
							loader.baseParams[this.action_prefix+'departlevel'] = this.tree_level;
						},
						scope:this
					}
				}});
			this.treepanel = new Ext.tree.TreePanel({
				region : 'west',
				id : this.id+'_tree',
				title : this.title_base +'树',// 以后去掉
				useArrows : true,
				autoScroll : true,
				animate : true,
				enableDD : false,
				containerScroll : true,
				border : false,
				width: '25%',
				rootVisable : false,
				viewConfig:{
					forceFit:true,
					enableRowBody:true
				},
				loader:this.treeloader,
				root:{id:'0',text:'顶端',nodeType: 'async',attributes:{'departid':0,departlevel:this.tree_level}},
				listeners:{
					click:function(node,evt){
						//点击动作
//						子类可以按照自己的需求重载
						this.ownerCt.current_treenode_id = node.id;
						
						this.ownerCt.store.load(
								{
									params:{
										start:0,
										limit:this.ownerCt.pagesize,
										dir:this.ownerCt.dir,
										desc:this.ownerCt.desc
									}
								}
						);
						var self = this;
						var param={};
						param[this.ownerCt.action_prefix+'departid']=node.id;
						this.ownerCt.detail_store.load({params:param,callback:function(r,options,success){
							var record = this.getAt(0);
							var form = self.ownerCt.detail_panel.getForm();
						
							form.setValues(buildSubmitParam({},record.data));
						}});
						
					}
				}
			});

//			子机构面板
			var sm = new Ext.grid.CheckboxSelectionModel();
			this.gridpanel = new Ext.grid.GridPanel({
				id : this.id+'_grid',
				store : this.store,
				border:false,
				viewConfig:{
					forceFit:true
				},
				sm:sm,
				columns:[
				    sm,
					{header: '机构ID', dataIndex: 'departid', sortable: false,width:100},
					{header: this.title_base+'代码',dataIndex:'departfullcode',width:300},
					{header: this.title_base+'名称',dataIndex:'departname',width:300},
					{header:'上级'+this.title_base,dataIndex:'parent',renderer:function(obj){return obj.departname;},width:300}
				],
				tbar:[
						{xtype:'button',text:'添加',handler:function(){
//							弹出添加窗口
//							判断是不是已经点击了左边的机构树
							if(self.current_treenode_id && self.current_treenode_id > 0){
								var window = new techsupport.deparmentmanage.DepartmentWindow({
									ownerCt:self,action_name:'add',action:self.action,
									renderTo:self.detail_window,
									store:self.store,
									dstore:self.detail_store
								});
								window.center();
								window.show();
//								初始化添加机构时候的必须数据
								var record = self.detail_store.getAt(0);
								var form = window.form_panel.getForm();
								form.setValues({
											'parent.departid':record.data.departid,
											'parent.departname':record.data.departname,
											'parent.departfullcode':record.data.departfullcode
										});
							}
							else{
								Ext.MessageBox.alert("提示","请选择树形菜单中的机构");
							}
						}},
						'-',
						{xtype:'button',text:'修改',handler:function(){
//							弹出修改窗口
						}},
						'-',
						{xtype:'button',text:'删除',handler:function(){}},
						'-',
						{xtype:'button',text:'置顶',handler:function(){}},
						'-',
						{xtype:'button',text:'上移',handler:function(){}},
						'-',
						{xtype:'button',text:'下移',handler:function(){}},
						'-',
						{xtype:'button',text:'置底',handler:function(){}},
						'-','-',
						{xtype:'button',text:'保存',handler:function(){ 
							/* 保存当前机构 */
							var record = this.ownerCt.ownerCt.ownerCt.ownerCt.detail_store.getAt(0);
							this.ownerCt.ownerCt.ownerCt.ownerCt.detail_panel.getForm().updateRecord(record);
							this.ownerCt.ownerCt.ownerCt.ownerCt.action.modify(record.data);
						}}
					],
					bbar:new Ext.PagingToolbar({
						store:this.store,
						displayInfo:true,
						pageSize:this.pagesize,
						 afterPageText: '共{0}页',
                         beforePageText: '当前页',
                         lastText:"尾页",   
                         nextText :"下一页",   
                         prevText :"上一页",   
                         firstText :"首页",   
                         refreshText:"刷新页面",  
						emptyMsg : '没有数据显示',
						displayMsg : '{0}-{1}条,总条数{2}'
					})
			});
//			-------------------------------子机构面板------------------------------------
			
			//右边详情显示面板
			var detail_panel_items_defaults = {
				   xtype:'textfield',
				   columnWidth: .25
			};
			
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
				    	          {name:'departid',fieldLabel:this.title_base+'ID',readOnly:true}
				    	          
				    	   ]
				       },
				       {
				    	   layout:'form',
				    	   defaults:detail_panel_items_defaults,
				    	   items:[
				    	          {name:'departcode',fieldLabel:this.title_base+'代码',readOnly:true}
				    	          
				    	   ]
				       },
				       {
				    	   layout:'form',
				    	   defaults:detail_panel_items_defaults,
				    	   items:[
				    	          {name:'departname',fieldLabel:this.title_base+'名称'},
				    	   ]
				       },
				       {
				    	   layout:'form',
				    	   defaults:detail_panel_items_defaults,
				    	   items:[
				    	          {name:'departfullcode',fieldLabel:this.title_base+'全码',readOnly:true},
				    	   ]
				       },
				       {
				    	   layout:'form',
				    	   defaults:detail_panel_items_defaults,
				    	   items:[
				    	          {name:'parent.departid',fieldLabel:'上级'+this.title_base+'ID',readOnly:true}
				    	   ]
				       },
				       {
				    	   layout:'form',
				    	   defaults:detail_panel_items_defaults,
				    	   items:[
				    	          {name:'parent.departname',fieldLabel:'上级机构名称',readOnly:true}
				    	   ]
				       }
				]
			});
			//-----------------------------------------------详情面板------------------------
			//右边面板
			this.right_panel = Ext.create({
				xtype:'panel',
				title : this.title_base +'信息',
				region : 'center',
				layout : 'vbox',
				viewConfig : { forceFit:true},
				items: [this.detail_panel , this.gridpanel]
			});
//			----------------------------右边面板-------------------------------------------
			//给最外面的面板添加树形菜单和右边的垂直面板
			this.items = [this.right_panel, this.treepanel ];
			//父类
			techsupport.deparmentmanage.DepartmentMain.superclass.initComponent.apply(this,arguments);
		},
		onRender:function(ct,position){
			techsupport.deparmentmanage.DepartmentMain.superclass.onRender.apply(this,arguments);
		},
		afterRender:function(ct,position){
			this.body_height = this.getHeight()-this.getFrameHeight();
			this.body.setHeight(this.body_height);
			techsupport.deparmentmanage.DepartmentMain.superclass.afterRender.apply(this,arguments );
			
			this.treepanel.getRootNode().expand();
//			设置内容表格高度
			this.grid_body_height = this.right_panel.getInnerHeight() - this.gridpanel.getFrameHeight()
				- this.detail_panel.getHeight() - 9;
			this.gridpanel.body.setHeight(this.grid_body_height);
		}
		//-----------------------------------附加内容结束-------------------------------------
	});
	Ext.reg('department_main', techsupport.deparmentmanage.DepartmentMain);
})();



