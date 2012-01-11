	function csxxtjInit(){
		$("#bq_dsjgdm").selectBox({state:"1"});
		$("#bq_fxjdm").selectBox({state:"1"});
		$("#bq_gxdwdm").selectBox({state:"1"});
		
		$("#bq_dsjgdm").setAttr("readonly",true);
		$("#bq_fxjdm").setAttr("readonly",true);
		$("#bq_gxdwdm").setAttr("readonly",true);
		
		$("#ch_dsjgdm").attr("disabled",true).attr("checked",false);
		$("#ch_fxjdm").attr("disabled",true).attr("checked",false);
		$("#ch_gxdwdm").attr("disabled",true).attr("checked",false);
		$("#ch_csbm").attr("disabled",true).attr("checked",false);
		
		if(js_sdfjksdFlage=='1'){ //省厅
			$("#ch_dsjgdm").attr("disabled",false).attr("checked",true);
			gaveSelectInfo("dsjgdm",js_departCode); //赋值
			checkedBox('dsjgdm');
			openRead('dsjgdm');
		} else if (js_sdfjksdFlage=='2'){ //地市
			$("#ch_fxjdm").attr("disabled",false);
			if(isZxs=='1'){ //直辖市
				ksd_gaveSelectInfo("dsjgdm",js_departCode.substr(0,2)+'00'); //赋值
			}else{
				ksd_gaveSelectInfo("dsjgdm",js_departCode.substr(0,2)+'0000000000'); //赋值
			}
			gaveSelectValue("dsjgdm",js_departCode); //选值
			gaveSelectInfo("fxjdm",js_departCode); //赋值
			$("#ch_dsjgdm").attr("checked",true);
			$("#t_dsjgbz").attr("value","1");
			$("#t_dsjgdm").attr("value",js_departCode);
		} else if (js_sdfjksdFlage=='3'){ //分局
			$("#ch_gxdwdm").attr("disabled",false);
			gaveSelectInfo("dsjgdm",js_departCode.substr(0,2)+'0000000000'); //赋值
			gaveSelectValue("dsjgdm",js_departCode.substr(0,4)+'00000000'); //选值
			gaveSelectInfo("fxjdm",js_departCode.substr(0,4)+'00000000'); //赋值
			gaveSelectValue("fxjdm",js_departCode); //选值
			gaveSelectInfo("gxdwdm",js_departCode); //赋值
			$("#ch_dsjgdm").attr("checked",true);
			$("#ch_fxjdm").attr("checked",true);
			$("#t_dsjgbz").attr("value","1");
			$("#t_fxjbz").attr("value","1");
			$("#t_dsjgdm").attr("value",js_departCode.substr(0,4)+'00000000');
			$("#t_fxjdm").attr("value",js_departCode);
		} else { //科所队
		    $("#ch_csbm").attr("disabled",false);
		    changsuoCanPlay = true;
			gaveSelectInfo("dsjgdm",js_departCode.substr(0,2)+'0000000000'); //赋值
			gaveSelectValue("dsjgdm",js_departCode.substr(0,4)+'00000000'); //选值
			gaveSelectInfo("fxjdm",js_departCode.substr(0,4)+'00000000'); //赋值
			gaveSelectValue("fxjdm",js_departCode.substr(0,6)+'000000'); //选值
			gaveSelectInfo("gxdwdm",js_departCode.substr(0,6)+'000000'); //赋值
			gaveSelectValue("gxdwdm",js_departCode); //选值
			$("#ch_dsjgdm").attr("checked",true);
			$("#ch_fxjdm").attr("checked",true);
			$("#ch_gxdwdm").attr("checked",true);
			$("#t_dsjgbz").attr("value","1");
			$("#t_fxjbz").attr("value","1");
			$("#t_gxdwbz").attr("value","1");
			$("#t_dsjgdm").attr("value",js_departCode.substr(0,4)+'00000000');
			$("#t_fxjdm").attr("value",js_departCode.substr(0,6)+'000000');
			$("#t_gxdwdm").attr("value",js_departCode);
		}
	}	
	function gaveSelectInfo(nowBqId,departValue){ //标签ID，部门编码（给下拉 赋值）
		$("#k_deptCode").attr("value",departValue);
		createXML("k_");
		$("#bq_"+nowBqId).selectBox({url:"sysadmin/querySelDepartGa_department.action"});
	}
	function gaveSelectValue(nowBqId,departValue){ //给选择框 赋选择值
		$("#bq_"+nowBqId).setValue(departValue); //全部
	}
	function openRead(obj){ //打开下拉框
		$("#bq_"+obj).setAttr("readonly",false);
	}
	function closeRead(obj){ //关闭下拉框 只读
		$("#bq_"+obj).setValue(""); //全部
		$("#bq_"+obj).setAttr("readonly",true);
		$("#t_"+obj).attr("value","");
		//if(obj=='gxdw'){
		//	changsuoCanPlay = false; ///------------
		//}
		if(obj!='csbm'){
		    changsuoCanPlay = false; 
		}
	}
	function closeFwcs(){ //情况服务场所
		$("#t_csbm").attr("value","");
		$("#p_csmc").attr("value","");
	}
	function gajgSelect(obj){ //选择机关 checkBox
		var dataKey = $(obj).attr("dataKey")
		var objbz = dataKey.substr(0,dataKey.length-2);
		var thisChecked = $(obj).attr("checked");
		if(thisChecked){ //打开下拉框
			checkedBox(dataKey);
		} else { //关闭下拉框
			uncheckedBox(dataKey);
			eval(dataKey+"Onchange();");
		}
	}
	function checkedBox(obj){
		$("#t_"+obj.substr(0,obj.length-2)+"bz").attr("value","1");
		if(obj=='dsjgdm'){
			openRead(obj);
			$("#ch_fxjdm").attr("disabled",false);
		}
		if(obj=='fxjdm'){
			closeRead(obj);
			if($("#bq_dsjgdm").attr("value")!=''){
				openRead(obj);
			}
			$("#ch_gxdwdm").attr("disabled",false);
		}
		if(obj=='gxdwdm'){
			closeRead(obj);
			if($("#bq_fxjdm").attr("value")!=''){
				openRead(obj);
			}
			$("#ch_csbm").attr("disabled",false);
		}
	}
	function uncheckedBox(obj){
		closeRead(obj);
		$("#t_"+obj.substr(0,obj.length-2)+"bz").attr("value","0");
		if(obj=='dsjgdm'){
			$("#ch_fxjdm").attr("disabled",true).attr("checked",false);
			$("#ch_gxdwdm").attr("disabled",true).attr("checked",false);
			$("#ch_csbm").attr("disabled",true).attr("checked",false);
			$("#t_fxjbz").attr("value","0");
			$("#t_gxdwbz").attr("value","0");
			$("#t_csbz").attr("value","0");
		}
		if(obj=='fxjdm'){
			$("#ch_gxdwdm").attr("disabled",true).attr("checked",false);
			$("#ch_csbm").attr("disabled",true).attr("checked",false);
			$("#t_gxdwbz").attr("value","0");
			$("#t_csbz").attr("value","0");
		}
		if(obj=='gxdwdm'){
			$("#ch_csbm").attr("disabled",true).attr("checked",false);
			$("#t_csbz").attr("value","0");
		}
		if(obj=='csbm'){
			//$("#ch_csbm").attr("disabled",true).attr("checked",false);
			$("#t_csbz").attr("value","0");
		}
	}
	function dsjgdmOnchange(){ //地市下拉变化时候
		if($("#bq_dsjgdm").attr("value")!=''){
			$("#t_dsjgdm").attr("value",$("#bq_dsjgdm").attr("value"));
			if($("#ch_fxjdm").attr("checked")){
				openRead('fxjdm');
			}
			gaveSelectInfo("fxjdm",$("#bq_dsjgdm").attr("value"));
			fxjdmOnchange(); ///------------
		} else {
			$("#t_dsjgdm").attr("value","");
			closeRead("fxjdm");
			closeRead("gxdwdm");
			closeFwcs();
		}
	}
	function fxjdmOnchange(){ //分县局下拉变化时候
		if($("#bq_fxjdm").attr("value")!=''){
			$("#t_fxjdm").attr("value",$("#bq_fxjdm").attr("value"));
			if($("#ch_gxdwdm").attr("checked")){
				openRead('gxdwdm');
			}
			gaveSelectInfo("gxdwdm",$("#bq_fxjdm").attr("value"));
			gxdwdmOnchange(); ///-----------
			$("#ch_gxdwdm").attr("disabled",false);
		} else {
			$("#t_fxjdm").attr("value","");
			closeRead("gxdwdm");
			closeFwcs();
		}
	}
	function gxdwdmOnchange(){ //科所队下拉变化时候
		if($("#bq_gxdwdm").attr("value")!=''){
			$("#t_gxdwdm").attr("value",$("#bq_gxdwdm").attr("value"));
			changsuoCanPlay = true;
			
			
			//科所队变化，场所清空start
			if($("#ch_csbm").attr("checked")){
			    $("#p_csmc").attr("value","");
			    $("#t_csbm").attr("value","");
			}
			//end
		} else {
			$("#t_gxdwdm").attr("value","");
			changsuoCanPlay = false;
			closeFwcs();
		}
	}
	function csbmOnchange(){ //
		closeFwcs();
	}