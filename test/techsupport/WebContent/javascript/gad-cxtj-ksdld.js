	function ksd_csxxtjInit(){
		$("#bq_dsjgdm").selectBox({state:"1"});
		$("#bq_fxjdm").selectBox({state:"1"});
		$("#bq_gxdwdm").selectBox({state:"1"});
		
		$("#bq_dsjgdm").setAttr("readonly",true);
		$("#bq_fxjdm").setAttr("readonly",true);
		$("#bq_gxdwdm").setAttr("readonly",true);
		
		$("#ch_dsjgdm").attr("disabled",true).attr("checked",false);
		$("#ch_fxjdm").attr("disabled",true).attr("checked",false);
		$("#ch_gxdwdm").attr("disabled",true).attr("checked",false);
		
		if(js_sdfjksdFlage=='1'){ //省厅
			$("#ch_dsjgdm").attr("disabled",false).attr("checked",true);
			ksd_gaveSelectInfo("dsjgdm",js_departCode); //赋值
			ksd_checkedBox('dsjgdm');
			ksd_openRead('dsjgdm');
		} else if (js_sdfjksdFlage=='2'){ //地市
			$("#ch_fxjdm").attr("disabled",false);
			if(isZxs=='1'){ //直辖市
				ksd_gaveSelectInfo("dsjgdm",js_departCode.substr(0,2)+'00'); //赋值
			}else{
				ksd_gaveSelectInfo("dsjgdm",js_departCode.substr(0,2)+'0000000000'); //赋值
			}
			ksd_gaveSelectValue("dsjgdm",js_departCode); //选值
			ksd_gaveSelectInfo("fxjdm",js_departCode); //赋值
			$("#ch_dsjgdm").attr("checked",true);
			$("#t_dsjgbz").attr("value","1");
			$("#t_dsjgdm").attr("value",js_departCode);
		} else if (js_sdfjksdFlage=='3'){ //分局
			$("#ch_gxdwdm").attr("disabled",false);
			ksd_gaveSelectInfo("dsjgdm",js_departCode.substr(0,2)+'0000000000'); //赋值
			ksd_gaveSelectValue("dsjgdm",js_departCode.substr(0,4)+'00000000'); //选值
			ksd_gaveSelectInfo("fxjdm",js_departCode.substr(0,4)+'00000000'); //赋值
			ksd_gaveSelectValue("fxjdm",js_departCode); //选值
			ksd_gaveSelectInfo("gxdwdm",js_departCode); //赋值
			$("#ch_dsjgdm").attr("checked",true);
			$("#ch_fxjdm").attr("checked",true);
			$("#t_dsjgbz").attr("value","1");
			$("#t_fxjbz").attr("value","1");
			$("#t_dsjgdm").attr("value",js_departCode.substr(0,4)+'00000000');
			$("#t_fxjdm").attr("value",js_departCode);
		} else if (js_sdfjksdFlage=='4'){ //科所队
			ksd_gaveSelectInfo("dsjgdm",js_departCode.substr(0,2)+'0000000000'); //赋值
			ksd_gaveSelectValue("dsjgdm",js_departCode.substr(0,4)+'00000000'); //选值
			ksd_gaveSelectInfo("fxjdm",js_departCode.substr(0,4)+'00000000'); //赋值
			ksd_gaveSelectValue("fxjdm",js_departCode.substr(0,6)+'000000'); //选值
			ksd_gaveSelectInfo("gxdwdm",js_departCode.substr(0,6)+'000000'); //赋值
			ksd_gaveSelectValue("gxdwdm",js_departCode); //选值
			$("#ch_dsjgdm").attr("checked",true);
			$("#ch_fxjdm").attr("checked",true);
			$("#ch_gxdwdm").attr("checked",true);
			$("#t_dsjgbz").attr("value","1");
			$("#t_fxjbz").attr("value","1");
			$("#t_gxdwbz").attr("value","1");
			$("#t_dsjgdm").attr("value",js_departCode.substr(0,4)+'00000000');
			$("#t_fxjdm").attr("value",js_departCode.substr(0,6)+'000000');
			$("#t_gxdwdm").attr("value",js_departCode);
		} else if (js_sdfjksdFlage=='5'){ //直辖市
			$("#ch_fxjdm").attr("disabled",false);
			ksd_gaveSelectInfo("dsjgdm",js_departCode.substr(0,2)+'00'); //赋值
			ksd_gaveSelectValue("dsjgdm",js_departCode); //选值
			ksd_gaveSelectInfo("fxjdm",js_departCode); //赋值
			$("#ch_dsjgdm").attr("checked",true);
			$("#t_dsjgbz").attr("value","0");
			$("#t_dsjgdm").attr("value",js_departCode);
		} else if (js_sdfjksdFlage=='6'){ //分局
			$("#ch_gxdwdm").attr("disabled",false);
			ksd_gaveSelectInfo("dsjgdm",js_departCode.substr(0,2)+'00'); //赋值
			ksd_gaveSelectInfo("dsjgdm",js_departCode.substr(0,2)+'0000000000'); //选值
			ksd_gaveSelectInfo("fxjdm",js_departCode.substr(0,2)+'0000000000'); //赋值
			ksd_gaveSelectValue("fxjdm",js_departCode.substr(0,6)+'000000'); //选值
			ksd_gaveSelectInfo("gxdwdm",js_departCode); //赋值
			$("#ch_dsjgdm").attr("checked",true);
			$("#ch_fxjdm").attr("checked",true);
			$("#t_dsjgbz").attr("value","1");
			$("#t_dsjgdm").attr("value",js_departCode.substr(0,2)+'0000000000');
			$("#t_fxjdm").attr("value",js_departCode.substr(0,6)+'000000');
		} else if (js_sdfjksdFlage=='7'){ //科所队
			ksd_gaveSelectInfo("dsjgdm",js_departCode.substr(0,2)+'00'); //赋值
			ksd_gaveSelectInfo("dsjgdm",js_departCode.substr(0,2)+'0000000000'); //选值
			ksd_gaveSelectInfo("fxjdm",js_departCode.substr(0,2)+'0000000000'); //赋值
			ksd_gaveSelectValue("fxjdm",js_departCode.substr(0,6)+'000000'); //选值
			ksd_gaveSelectInfo("gxdwdm",js_departCode.substr(0,6)+'000000'); //赋值
			ksd_gaveSelectValue("gxdwdm",js_departCode); //选值
			$("#ch_dsjgdm").attr("checked",true);
			$("#ch_fxjdm").attr("checked",true);
			$("#ch_gxdwdm").attr("checked",true);
			$("#t_dsjgbz").attr("value","1");
			$("#t_fxjbz").attr("value","1");
			$("#t_dsjgdm").attr("value",js_departCode.substr(0,2)+'0000000000');
			$("#t_fxjdm").attr("value",js_departCode.substr(0,6)+'000000');
			$("#t_gxdwdm").attr("value",js_departCode);
		}
	}	
	function ksd_gaveSelectInfo(nowBqId,departValue){ //标签ID，部门编码（给下拉 赋值）
		$("#k_deptCode").attr("value",departValue);
		createXML("k_");
		$("#bq_"+nowBqId).selectBox({url:"sysadmin/querySelDepartGa_department.action"});
	}
	function ksd_gaveSelectValue(nowBqId,departValue){ //给选择框 赋选择值
		$("#bq_"+nowBqId).setValue(departValue); //全部
	}
	function ksd_openRead(obj){ //打开下拉框
		$("#bq_"+obj).setAttr("readonly",false);
	}
	function ksd_closeRead(obj){ //关闭下拉框 只读
		$("#bq_"+obj).setValue(""); //全部
		$("#bq_"+obj).setAttr("readonly",true);
		$("#t_"+obj).attr("value","");
	}
	function ksd_gajgSelect(obj){ //选择机关 checkBox
		var dataKey = $(obj).attr("dataKey")
		var objbz = dataKey.substr(0,dataKey.length-2);
		var thisChecked = $(obj).attr("checked");
		if(thisChecked){ //打开下拉框
			ksd_checkedBox(dataKey);
		} else { //关闭下拉框
			ksd_uncheckedBox(dataKey);
			eval("ksd_"+dataKey+"Onchange();");
		}
	}
	function ksd_checkedBox(obj){
		$("#t_"+obj.substr(0,obj.length-2)+"bz").attr("value","1");
		if(obj=='dsjgdm'){
			ksd_openRead(obj);
			$("#ch_fxjdm").attr("disabled",false);
		}
		if(obj=='fxjdm'){
			ksd_closeRead(obj);
			if($("#bq_dsjgdm").attr("value")!=''){
				ksd_openRead(obj);
			}
			$("#ch_gxdwdm").attr("disabled",false);
		}
		if(obj=='gxdwdm'){
			ksd_closeRead(obj);
			if($("#bq_fxjdm").attr("value")!=''){
				ksd_openRead(obj);
			}
		}
	}
	function ksd_uncheckedBox(obj){
		ksd_closeRead(obj);
		$("#t_"+obj.substr(0,obj.length-2)+"bz").attr("value","0");
		if(obj=='dsjgdm'){
			$("#ch_fxjdm").attr("disabled",true).attr("checked",false);
			$("#ch_gxdwdm").attr("disabled",true).attr("checked",false);
			$("#t_fxjbz").attr("value","0");
			$("#t_gxdwbz").attr("value","0");
		}
		if(obj=='fxjdm'){
			$("#ch_gxdwdm").attr("disabled",true).attr("checked",false);
			$("#t_gxdwbz").attr("value","0");
		}
		if(obj=='gxdwdm'){
		}
	}
	function ksd_dsjgdmOnchange(){ //地市下拉变化时候
		if($("#bq_dsjgdm").attr("value")!=''){
			$("#t_dsjgdm").attr("value",$("#bq_dsjgdm").attr("value"));
			if($("#ch_fxjdm").attr("checked")){
				ksd_openRead('fxjdm');
			}
			ksd_gaveSelectInfo("fxjdm",$("#bq_dsjgdm").attr("value"));
			ksd_fxjdmOnchange(); ///--------------
		} else {
			$("#t_dsjgdm").attr("value","");
			ksd_closeRead("fxjdm");
			ksd_closeRead("gxdwdm");
		}
	}
	function ksd_fxjdmOnchange(){ //分县局下拉变化时候
		if($("#bq_fxjdm").attr("value")!=''){
			$("#t_fxjdm").attr("value",$("#bq_fxjdm").attr("value"));
			if($("#ch_gxdwdm").attr("checked")){
				ksd_openRead('gxdwdm');
			}
			ksd_gaveSelectInfo("gxdwdm",$("#bq_fxjdm").attr("value"));
			ksd_gxdwdmOnchange(); ///------------
			$("#ch_gxdwdm").attr("disabled",false);
		} else {
			$("#t_fxjdm").attr("value","");
			ksd_closeRead("gxdwdm");
		}
	}
	function ksd_gxdwdmOnchange(){ //科所队下拉变化时候
		if($("#bq_gxdwdm").attr("value")!=''){
			$("#t_gxdwdm").attr("value",$("#bq_gxdwdm").attr("value"));
		} else {
			$("#t_gxdwdm").attr("value","");
		}
	}