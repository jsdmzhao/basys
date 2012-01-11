// 行业类别与企业主分类联动
function hylbLinkQyzfl(hylbId,qyzflId,pchyCode,onlyJK){
	var initPchyCode = "ggmk";
	if(pchyCode!=null){
		initPchyCode = pchyCode;
	}
    var hylbdm;
    if(onlyJK==null){
    	 // 行业类别初期化
   		 $("#"+hylbId).selectBoxhylb({code:initPchyCode});
    }else if(onlyJK=="qhy"){
    	//显示行业类别字典中的全部行业
    	 $("#"+hylbId).selectBoxhylb();//行业类别
    }else{
    	// 行业类别初始化J K 当空白时为J,K
    	$("#p_hylbdm").selectBoxinhylb({code:"J"});
    }
   
    // 企业主分类初期化
    $("#"+qyzflId).selectBox({state:"1"});
	
    hylbdm=$("#"+hylbId).find("option:nth(0)").val();
	setQyzflDic(hylbdm,qyzflId);

    $("#"+hylbId).change(function(){
        hylbdm = $("#"+hylbId).attr("value");
	    setQyzflDic(hylbdm,qyzflId);
    });
}
// 根据行业类别编码设定企业主分类字典
function setQyzflDic(hylbdm,qyzflId){
    if("J"==hylbdm||"'J'"==hylbdm){//娱乐场所
        $("#"+qyzflId).selectBox({code:"dm_ylcsfl(bzh)"});
    }else if("C"==hylbdm){// 机修业
	    $("#"+qyzflId).selectBox({code:"dm_jxqyfl"});
    }else if("E01"==hylbdm){// 二手车
	    $("#"+qyzflId).selectBox({code:"dm_qyzfl(esc)"});
    }else if("E02"==hylbdm){// 二手机
	    $("#"+qyzflId).selectBox({code:"dm_qyzfl(esj)"});
    }else if("E04"==hylbdm){// 废旧金属
	    $("#"+qyzflId).selectBox({code:"dm_qyzfl(fjjs)"});
    }else if("F01"==hylbdm){// 出租车
	    $("#"+qyzflId).selectBox({code:"dm_qyzfl(czc)"});
    }else if("F02"==hylbdm){// 汽车租赁
	    $("#"+qyzflId).selectBox({code:"dm_qyzfl(qczl)"});
    }else if("E03"==hylbdm){// 典当
	    $("#"+qyzflId).selectBox({code:"dm_qyzfl(ddy)"});
	}else if("C01"==hylbdm){// 机动车拆解
	    $("#"+qyzflId).selectBox({code:"dm_qyzfl(jdccj)"});
    }else if("B"==hylbdm){// 印章业
	    $("#"+qyzflId).selectBox({code:"dm_qyzfl(yz)"});
    }else if("E07"==hylbdm){// 委托寄卖业
	    $("#"+qyzflId).selectBox({code:"dm_qyzfl(wtjmy)"});
    }else if("A"==hylbdm){// 委托寄卖业
	    $("#"+qyzflId).selectBox({code:"dm_qyzfl(lgy)"});
    }else {
	    $("#"+qyzflId).selectBox({clear:"1"});
    }
}
	//动态得到岗位类别树
 	function gy_getgwTree(gwmc,gwbh){
 		var gy_hylb="";
	 	gy_hylb="<div style='display: none;'><select id='gy_hylbdm'/></div>"
	 	$("#"+gwmc).parent().append(gy_hylb);
	 	$('#gy_hylbdm').selectBoxhylb();
	 	
	 	if($('#gy_hylbdm').val()=='J'){
	 		getrylbTree(gwmc,gwbh,"dm_cyrylb");
	 	}else if($('#gy_hylbdm').val()=='E01'){
	 		getrylbTree(gwmc,gwbh,"dm_cyrylb(ersc)");
	 	}else if($('#gy_hylbdm').val()=='E02'){
	 		getrylbTree(gwmc,gwbh,"dm_cyrylb(esj)");
	 	}else{
	 		getrylbTree(gwmc,gwbh,"dm_gycyrylb");
	 	}
 	}
	//动态得到岗位类别列表
 	function gy_getselectBox(hylb){
 		var gy_hylb="";
	 	gy_hylb="<div style='display: none;'><select id='gy_hylbdm'/></div>"
	 	$("#"+hylb).parent().append(gy_hylb);
	 	$('#gy_hylbdm').selectBoxhylb();
	 	
	 	if($('#gy_hylbdm').val()=='J'){
	 		$('#'+hylb).selectBox({code:"dm_cyrylb"});
	 	}else if($('#gy_hylbdm').val()=='E01'){
	 		$('#'+hylb).selectBox({code:"dm_cyrylb(ersc)"});
	 	}else if($('#gy_hylbdm').val()=='E02'){
	 		$('#'+hylb).selectBox({code:"dm_cyrylb(esj)"});
	 	}else{
	 		$('#'+hylb).selectBox({code:"dm_gycyrylb"});
	 	}
 	}
	//根据行业类别得到岗位列表
 	function hy_gwselectBox(hylb,gwbh){
 		
 		if($('#'+hylb).val()==''||$('#'+hylb).val()==null){
 			$('#'+hylb).selectBoxhylb({code:"ggmk"});
 		}
	 	if($('#'+hylb).val()=='J'){
	 		$('#'+gwbh).selectBox({code:"dm_cyrylb"});
	 	}else if($('#'+hylb).val()=='E01'){
	 		$('#'+gwbh).selectBox({code:"dm_cyrylb(ersc)"});	
	 	}else if($('#'+hylb).val()=='E02'){
	 		$('#'+gwbh).selectBox({code:"dm_cyrylb(esj)"});	
	 	}else{
	 		$('#'+gwbh).selectBox({code:"dm_gycyrylb"});	
	 	}
 	}
 	
   ////根据行业类别  得到人员类别
   function hy_lbselectBox(hylb,gwbh){
	    
	 	if(hylb=='J'){
	 		$('#'+gwbh).selectBox({clear:"1"});
	 		$('#'+gwbh).selectBox({code:"dm_cyrylb"});
	 	}else if(hylb=='E01'){
	 		$('#'+gwbh).selectBox({clear:"1"});
	 		$('#'+gwbh).selectBox({code:"dm_cyrylb(ersc)"});	
	 	}else if(hylb=='E02'){
	 		$('#'+gwbh).selectBox({clear:"1"});
	 		$('#'+gwbh).selectBox({code:"dm_cyrylb(esj)"});	
	 	}else if(hylb=='A'){
	 		$('#'+gwbh).selectBox({clear:"1"});
	 		$('#'+gwbh).selectBox({code:"dm_lgyrylb"});	
	 	}else if(hylb=='E03'){
	 		$('#'+gwbh).selectBox({clear:"1"});
	 		$('#'+gwbh).selectBox({code:"dm_ddyrylb"});	
	 	}else if(hylb=='C'){
	 		$('#'+gwbh).selectBox({clear:"1"});
	 	}else if(hylb=='B'){
	 		$('#'+gwbh).selectBox({clear:"1"});
	 		$('#'+gwbh).selectBox({code:"dm_yzyrylb"});	
	 	}else{
	 		$('#'+gwbh).selectBox({clear:"1"});
	 		$('#'+gwbh).selectBox({code:"dm_gycyrylb"});	
	 	}
 	}
	function checkHideOrShowHylb(usertype){
		var type = usertype.split(",");
		var k=0;
		for(var i=0;i<type.length;i++){
			if(type[i]=='14'){
				k=k+1;
			}
			if(type[i]=='144'){
				k=k+1;
			}
			if(type[i]=='12'){
				k=k+1;
			}
			if(type[i]=='142'){
				k=k+1;
			}
		}
		if(k<2){
			$('#hylb_title').before('<td>&nbsp;</td><td>&nbsp;</td>');
			$('#hylb_title').hide();
			$('#hylb_count').hide();
		}
		
	}
 	
 	
 	
 	