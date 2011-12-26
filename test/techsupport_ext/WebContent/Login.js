function  LoginPageInit(){
	Ext.QuickTips.init();

    // turn on validation errors beside the field globally
    Ext.form.Field.prototype.msgTarget = 'qtip';

    var bd = Ext.getBody();
	  /**
     * 回车监听
     * */
    function enterListener(val,evt){
    	if(evt.keyCode == 13){
    		LoginForm.getForm().submit();
    	}
    }

    var LoginForm = new Ext.FormPanel({
        labelWidth: 75, // label settings here cascade unless overridden
        frame:true,
        method:'POST',
        title: '航天金盾技术支持系统',
        onSubmit: Ext.emptyFn,
       	submit: function() 
       	{
           this.getEl().dom.action= 'login.action'; //连接到服务器的url地址
           this.getEl().dom.submit();
       	},
        bodyStyle:'padding:5px 5px 0',
        width: 350,
        defaults: {width: 230},
        defaultType: 'textfield',
        items: [{
                fieldLabel: '用户名',
                name: 'user.useraccount',
                allowBlank:false,
                blankText:'用户名不能为空',
                enableKeyEvents:true,
                listeners:{
                	keyup:enterListener
                }
            },{
                fieldLabel: '密码',
                name: 'user.password',
                allowBlank:false,
                blankText:'密码不能为空',
                inputType:'password',
                enableKeyEvents:true,
                listeners:{
                	keyup:enterListener
                }
            }
        ]
    });
    
    
	var LoginWindow=new Ext.Window({
			closable:false,
			resizable:false,
			draggable:false,
			width:350,
			height:170,
			items:[LoginForm],
			buttons:[
				{
		            text: '确定',
		            handler:function(){
		            	LoginForm.form.submit();
		            }
		        },{
		            text: '清空'
		        }
			]
	});
	LoginWindow.show();
}


Ext.onReady(LoginPageInit);