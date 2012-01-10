/**
 * ApplyReported.js 技术支持单录入填报或申请
 */
Ext.ns('ext.techsupport');

ext.techsupport.ApplyReported = Ext.extend(Ext.Panel, {

	constructor : function(cfg) { // 构造器
		cfg = cfg || {
			id : 'applyCt',
			renderTo : Ext.get('applyReportedCt'),
			layout : 'fit',
			frame:true,
			autoScroll:true,
			width : '100%',
			height : 380,
			title : '技术支持单录入',
			margins : '5 5 5 5',
			padding : '5 5 40 40',
			defaults : {
				border : false,
				labelWidth : 140,
				labelAlign : "right",
				buttonAlign:'right',
				buttonMagin:''
			}

		};
		ext.techsupport.ApplyReported.superclass.constructor.call(this, cfg);
	},
	initComponent : function() {

		this.items = [ {
			xtype : 'form',
			autoScroll:true,
			height:370,
			layout:'form',
			witdh:'96%',
			items : [ {
				xtype : 'textfield',
				name : 'st.stNo',
				fieldLabel : '技术支持单编号',
				maxLength : 100,
				maxLengthText : '最多100位',
				readOnly : true
			}, {
				xtype : 'panel',
				layout : 'column',
				items : [ {
					xtype : 'panel',
					layout : 'form',
					items : [ {
						xtype : 'combo',
						fieldLabel : '申请人',
						displayField : 'display_name',
						valueField : 'fact_value',
						lazyRender:true,
						mode: 'local',
						store : new Ext.data.JsonStore({
							proxy : new Ext.data.HttpProxy({
								url : './sysadmin/querySelDict_dict_item.action'
							}),
							fields:['fact_value','display_name'],
							root:'ldata',
							baseParams:{'dict_code':'ts_applicant'},
							autoLoad:true
						})
					} ]
				}, {
					xtype : 'panel',
					layout : 'form',
					labelWidth : 100,
					items : [ {
						xtype : 'combo',
						fieldLabel : '区域',
						displayField : 'display_name',
						valueField : 'fact_value',
						lazyRender:true,
						mode: 'local',
						store : new Ext.data.JsonStore({
							proxy : new Ext.data.HttpProxy({
								url : './sysadmin/querySelDict_dict_item.action'
							}),
							fields:['fact_value','display_name'],
							root:'ldata',
							baseParams:{'dict_code':'dm_xzqh'},
							autoLoad:true
						})
					} ]
				}, {
					xtype : 'panel',
					layout : 'form',
					labelWidth : 100,
					items : [ {
						xtype : 'combo',
						fieldLabel : '序号',
						displayField : 'text',
						valueField : 'value',
						triggerAction: 'all',
						lazyRender:true,
						mode: 'local',
						store : new Ext.data.ArrayStore({
							id:'sn',
							fields:['value','text'],
							data:function(){ var num=new Array(); 
								for(i=1;i<=100;i++) {
									arrtemp=[i,i];
									num.push(arrtemp);
								}
								return num;
							}()
						})
					} ]
				} ]
			}, {
				xtype : 'panel',
				layout : 'column',
				items : [ {
					xtype : 'panel',
					layout : 'form',
					items : [ {
						xtype : 'datefield',
						fieldLabel : '总工批复日期'
					} ]
				}, {
					xtype : 'panel',
					layout : 'form',
					items : [ {
						xtype : 'textarea',
						fieldLabel : '总工意见批复',
						maxLength : 4000,
						maxLengthText : '最多4000个字符',
						width : 400
					} ]
				} ]
			}, {
				xtype : 'panel',
				layout : 'column',
				items : [ {
					xtype : 'panel',
					layout : 'form',
					items : [ {
						xtype : 'datefield',
						fieldLabel : '日期'
					} ]
				}, {
					xtype : 'panel',
					layout : 'form',
					items : [ {
						xtype : 'textarea',
						fieldLabel : '产品方案部主管批复意见',
						maxLength : 4000,
						maxLengthText : '最多4000个字符',
						width : 400
					} ]
				} ]
			}, {
				xtype : 'panel',
				layout : 'column',
				items : [ {xtype:'panel',layout:'form',items:[{xtype:'datefield',fieldLabel:'计划完成时间'}]} ,
				          {xtype:'panel',layout:'form',items:[{xtype : 'checkbox',fieldLabel : '阶段',handler:function(e,checked){
				        	  var ardatefield=e.ownerCt.ownerCt.findByType('datefield');
				        	  var arel=[];
				        	  Ext.each(ardatefield,function(item,idx,items){
				        		  if(item.initialConfig.cls == e.id ){
				        			  arel.push(item);
				        		  }
				        	  });
				        	  
				        	  if(checked){
					        	  for(i=0;i<arel.length;i++){
					        		  arel[i].setVisible(true);
					        	  }
				        	  }
				        	  else{
					        	  for(i=0;i<arel.length;i++){
					        		  arel[i].setVisible(false);
					        	  }
				        	  }
				        		  
				          },id:'pgms_'}]},
				          {xtype:'panel',layout:'form',labelWidth:60,items:[{xtype:'datefield',fieldLabel:'需求',cls:'pgms_',hidden:true}]},
				          {xtype:'panel',layout:'form',labelWidth:60,items:[{xtype:'datefield',fieldLabel:'实施',cls:'pgms_',hidden:true}]}
				          ]
			}, {
				xtype : 'panel',
				layout : 'column',
				items : [ {
					xtype : 'panel',
					layout : 'form',
					items : [ {
						xtype : 'datefield',
						fieldLabel : '日期'
					} ]
				}, {
					xtype : 'panel',
					layout : 'form',
					items : [ {
						xtype : 'textarea',
						fieldLabel : '技术开发部主管批复意见',
						maxLength : 4000,
						maxLengthText : '最多4000个字符',
						width : 400
					} ]
				} ]
			}, {
				xtype : 'panel',
				layout : 'column',
				items : [{xtype:'panel',layout:'form',items:[{xtype:'datefield',fieldLabel:'计划完成时间'}]} ,
				         {xtype:'panel',layout:'form',items:[{xtype : 'checkbox',fieldLabel : '阶段',handler:function(e,checked){
				        	  var ardatefield=e.ownerCt.ownerCt.findByType('datefield');
				        	  var arel=[];
				        	  Ext.each(ardatefield,function(item,idx,items){
				        		  if(item.initialConfig.cls == e.id ){
				        			  arel.push(item);
				        		  }
				        	  });
				        	  
				        	  if(checked){
					        	  for(i=0;i<arel.length;i++){
					        		  arel[i].setVisible(true);
					        	  }
				        	  }
				        	  else{
					        	  for(i=0;i<arel.length;i++){
					        		  arel[i].setVisible(false);
					        	  }
				        	  }
				        		  
				          },id:'dvml_'}]},
				         {xtype:'panel',layout:'form',labelWidth : 60,items:[{xtype:'datefield',fieldLabel:'设计开发',cls:'dvml_',hidden:true}]},
				         {xtype:'panel',layout:'form',labelWidth : 60,items:[{xtype:'datefield',fieldLabel:'测试',cls:'dvml_',hidden:true}]}
				         ]
			},{xtype:'panel',layout:'column',defaults:{abelWidth : 100,labelAlign : "right"},items:[{xtype:'panel',layout:'form',
				items:[{xtype:'combo',fieldLabel:'技术负责人',displayField:'display_name',valueField:'fact_value',lazyRender:true,
					mode: 'local',
					loadingText:'加载中',
					store:new Ext.data.JsonStore({
						proxy:new Ext.data.HttpProxy({url:'./sysadmin/querySelDict_dict_item.action'}),
						fields:['fact_value','display_name'],
						root:'ldata',
						baseParams:{'dict_code':'ts_sl'},
						autoLoad:true
					})}
				]
			},
	          {xtype:'panel',layout:'form',items:[{
	        	  xtype:'combo',fieldLabel:'技术支持部门',displayField:'display_name',valueField:'fact_value',
	        	  	lazyRender:true,
					mode: 'local',
					loadingText:'加载中',
					store:new Ext.data.JsonStore({
	        		  proxy:new Ext.data.HttpProxy({url:'./sysadmin/querySelDict_dict_item.action'}),
	        		  fields:['fact_value','display_name'],
	        		  root:'ldata',
	        		  baseParams:{'dict_code':'ts_sdept'},
	        		  autoLoad:true
	        	  })
	          }]
			}]}
			]
		} ];

		this.buttons=[{xtype:'button',text:'保存',width:80,handler:this.save,id:'savebtn'}];
		//this.on('afterrender', this.afterrender, this);

		ext.techsupport.ApplyReported.superclass.initComponent.call(this);
	},
	save:function(){ //保存并且开始流程
		
	},
	afterrender : function(ct, postion) {
		var offsetTop = (Ext.getBody().getHeight() - ct.el.getHeight()) / 2;
		if (offsetTop < 0)
			offsetTop = 0;
		ct.el.setTop(offsetTop);
	}

});

Ext.onReady(function() {
	var appreport = new ext.techsupport.ApplyReported();
//	appreport.show();
});
