/***
 * filename: systemManageMain.js
 * description: 系统管理页面组件 主要继承 系统管理页面组件，
 * 				对中间部分组件做修改
 * 
 */

(function(){
//	声明包
	Ext.ns("techsupport.systemmanage");
	
	techsupport.systemmanage.SystemMain = Ext.extend(techsupport.deparmentmanage.DepartmentMain,{
		constructor:function(config){
			config.title_base = "系统",
			config.dir = "nodeorder",
			config.pagesize=15;
			config.sort="asc";
			
			config.addURL = context_path+'/sysadminDefault/add_systemmanage.action';
			config.modifyURL = context_path+'/sysadminDefault/modify_systemmanage.action';
			config.queryURL = context_path+'/sysadminDefault/querylist_systemmanage.action';
			config.detailURL = context_path+'/sysadminDefault/query_systemmanage.action';
			config.removeURL = context_path+'/sysadminDefault/remove_systemmanage.action';
			
			config.actionPrefix = 'system.';
			config.removePrefix = 'systemList[i]';
		
			
			//-----------------------重写表格区域属性-----------------
			techsupport.systemmanage.SystemMain.superclass.constructor.apply(this,arguments);
		},
			
		initComponent:function(ct,position){
			//父类加载前
			var self = this;
			
			//----------------------重写gridpanel 的重要属性------------------------
			techsupport.systemmanage.SystemMain.superclass.initComponent.apply(this,arguments);
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
					{name:'parent',mapping:'parent'},
					{name:'systemdefine',mapping:'systemdefine'}
				],
				listeners:{
					beforeload:{
						fn:function(store,options){
							Ext.apply(options.params,{
								dir:this.dir,
								sort:this.sort
							});
							options.params[this.actionPrefix+'parent.systemcode']=this.current_treenode_id;
						},
						scope:this
					}
					
				}
			});
			
			
			this.detail_store =  new Ext.data.JsonStore( {
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
					{name:'parent',mapping:'parent'},
					{name:'systemdefine',mapping:'systemdefine'}
				]
			});
			//复习重新设定父类属性加载器属性
			this.treeloader = new Ext.tree.TreeLoader({
					url:context_path+'/sysadminDefault/querySystemNodes_systemmanage.action',
					method:'post',
					listeners:{
						beforeload:function(loader,node){
							loader.baseParams[this.actionPrefix+'systemcode'] = node.id;
						}
					}});
			this.remove(this.treepanel);
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
				root:{id:'0',text:'顶端',nodeType: 'async'},
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
						var param={};
						param[this.ownerCt.actionPrefix+self.store.idProperty]=node.id;
						this.ownerCt.detail_store.load({params:param,callback:function(r,options,success){
							var record = this.getAt(0);
							var form = self.detail_panel.getForm();
							if(record)
								form.setValues(buildSubmitParam({},record.data));
						}});
						
					}
				}
			});
			this.add(this.treepanel);
			
			//----------------------复习重新设定父类属性加载器属性--------------------------------
			//重写gridpanel 的重要属性
			this.sm = new Ext.grid.CheckboxSelectionModel();
			
			this.columnModel = new Ext.grid.ColumnModel({
			    columns:[
				     this.sm,
					{id:'systemcode',header: this.title_base+'代码', dataIndex:'systemcode',width:100},
					{header: this.title_base+'名称',dataIndex:'systemname',width:300},
					{header: this.title_base+'全码',dataIndex:'fullcode',width:300},
					{header: this.title_base+'定义',dataIndex:'systemdefine',width:300}
				],
			    defaults: {
			        sortable: false,
			        menuDisabled: false
			    }
			});
			this.gridpanel.store = this.store;
			this.gridpanel.selModel = this.sm;
			this.gridpanel.colModel = this.columnModel;
			//父类加载后
			//右边详情显示面板
			var detail_panel_items_defaults = {
				   xtype:'textfield',
				   columnWidth: .25
			};
			//当前系统详情面板
			this.detail_panel.items.clear();
			this.detail_panel.add([Ext.create({
				    	   layout:'form',
				    	   xtype:'panel',
				    	   defaults:detail_panel_items_defaults,
				    	   items:[
				    	          {name:'systemcode',fieldLabel:this.title_base+'代码',readOnly:true}
				    	          
				    	   ]
				       }),
				       Ext.create({
				    	   layout:'form',
				    	   xtype:'panel',
				    	   defaults:detail_panel_items_defaults,
				    	   items:[
				    	          {name:'systemname',fieldLabel:this.title_base+'名称'}
				    	   ]
				       })
				       ,
				       Ext.create({
				    	   layout:'form',
				    	   xtype:'panel',
				    	   defaults:detail_panel_items_defaults,
				    	   items:[
				    	          {name:'fullcode',fieldLabel:this.title_base+'全码',readOnly:true}
				    	   ]
				       })
				       ]);
			
		}
	});
	
	
	/**
	 * 
	 */
	techsupport.systemmanage.SystemWindow = Ext.extend(techsupport.deparmentmanage.DepartmentWindow,{
		title:'系统',
		initComponent:function(ct,position){
			
			techsupport.systemmanage.SystemWindow.initComponent.call(this,ct,position);
			//========================重写form_panel表单信息===============================
			this.form_panel.items.items.clear();
			//添加系统的表单信息
			this.form_panel.add([
				      {name:'systemname',fieldLabel:'系统名称',allowBlank:false,blankText:'系统名称不能空'},
				      {name:'systemcode',fieldLabel:'系统代码',allowBlank:false,blankText:'系统代码不能为空',
				    	  validationEvent:'blur',
				    	  validator:function(val){
				    		  //验证系统代码是否可用
				    		  var result = false;
				    		  Ext.Ajax.request({url:context_path+'/sysadminDefault/checkSystemcode_systemmanage.action',
				    			  params:{'system.systemcode':val},
				    			  async:false,
				    			  success:function(response,opt){
				    				  var data = Ext.decode(response.responseText);
				    				  if(!data.returnNo)
				    					  result = true;
				    				  else
				    					  result = false;
				    			  }
				    		  });
				    		  if(result)
				    			  return true;
				    		  else
				    			  return '系统代码不可用';
				    	  }
				      },
				      {name:'picturepath',fieldLabel:'系统图标'},
				      {name:'parent.systemname',fieldLabel:'上级系统',allowBlank:false,blankText:'上级系统不能为空',readOnly:true},
				      {name:'fullcode',fieldLabel:'系统全码',allowBlank:false,blankText:'系统全码不能为空',readOnly:true},
				      {name:'parent.systemcode',fieldLabel:'上级系统代码',allowBlank:false,blankText:'上级系统代码不能为空',readOnly:true,hidden:true},
				      {name:'parent.isleaf',fieldLabel:'上级系统叶子',hidden:true,readOnly:true},
				      {name:'parent.fullcode',fieldLabel:'上级系统全码',allowBlank:false,blankText:'上级系统全码不能为空',readOnly:true,hidden:true},
				      {name:'nodeorder',fieldLabel:'序列',allowBlank:true,readOnly:true,regex:/^\d*$/,regexText:'序列必须为数字',hidden:true}
			]);
			
			//添加全码设置事件
			this.form_panel.getForm().findField("systemcode").on("blur",function(field){
				var form = this.form_panel.getForm();
				var fullcode = form.findField("fullcode");
				var parentFullcode = form.findField("parent.fullcode");
				fullcode.setValue(parentFullcode.getValue()+fullcode+".");
			});
			
			//------------------------重写form_panel表单信息-------------------------------
			
		}
	});
	
})();