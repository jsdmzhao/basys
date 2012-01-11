/**
*
*	配合 business/Ylfwzagl/DxrMan.jsp 完成电写入
*	配合 business/Ylfwzagl/DxrMan-bx.jsp 完成-补写-电写入
*	配合 business/Ylfwzagl/DxrMan-pxr.jsp 完成-批写入-电写入
*
**/	
	var dxr_querysnAndWcUrl = "icksystem/querySnAndWc_ickzb.action"; //获取开始顺序号和写卡数量 url
	var dxr_queryCyryxxMesUrl = "icksystem/queryCyryxxMes_ickzb.action"; //获取从业信息 url
	var dxr_backWriteIckhUrl = "icksystem/backWriteIckh_ickzb.action"; //将ic卡号(芯片号)写到数据库
	var dxr_queryCyryxxMesByCyrybhUrl = "icksystem/queryCyryxxMesByCyrybh_ickzb.action"; //获取从业信息(自定义写入) url
	var wldj_queryCyryzpImageUrl = "icksystem/queryCyryzpImage_wldj.action?cyrybh="; // 获取物流登记时从业人员照片
	
	var isCanStart = false; //是否可以开始
	var isCanTiaog = false; //是否可以跳过
	
	var startNum = 0; //开始顺序号
	var maxNum = 0; //本次最大顺序号
	var writeCount = 0; //本次电写入数量
	
	var bpcWriteCount = 0; //本次最终写入数量
	var bpcDxrSuccess = 0; //本次成功写入数量
	var bpcDxrTiaog = 0; //本次跳过写入数量
	var bpcDxrErr = 0; //本次写入失败数量
	
	var pxrStart = false; //批写入开始
	
	var jsonLIckzb = null; //[0]：数据库中的值(待显示的) [1]：待写入卡的内容
	var thePlayRow = 0; //当前活动的行
	
	function startDxrIckBon(){ //开始 按钮事件
		initParms();
		var pxr_check = $("#pxr").attr("checked");
		var zdyxr_check = $("#zdyxr").attr("checked");
			if(pxr_check==true){ //批写入
				if (!checkControlValue("p_pch","String",1,20,null,1,"批次号"))
					return false;
				if(isCanStart==true){ //可以开始
					if(startVerify()){ //验证批写入
						pxrStart = true;
						queryCyryxxMes();
					}
				} else { //不可以开始
					jAlert("错误的条件,不可以开始电写入!","提示");
				}
			} else { //自定义
				if (!checkControlValue("c_cyrybh","String",1,50,null,1,"从业人员编号"))
					return false;
				queryCyryxxMesByCyrybh();
			}
	}
	function tiaoGuoIckBon(){ //跳过按钮事件
		if(pxrStart==true){
			thePlayRow += 1;
			bpcDxrTiaog += 1;
			if(!isFinash("")){ //没有结束
				nowState(""); //刷卡情况
				startDxr(); //继续刷卡
			}
		}
	}
	function queryStartNumAndWriteCount(){ //根据物流批次号获取(开始顺序号 和 本次写卡数量) 前提是  radio 为批写入
		var pxr_check = $("#pxr").attr("checked");
		if(pxr_check==true){ //批写入
			var pch = $("#p_pch").attr("value");
			if(pch.length==18){
				huoquMess();
			}else{
				$("#p_kssxh").attr("value","");
				$("#p_bcdxrsl").attr("value","");
				isCanStart = false;
			}
		}
	}
	function huoquMess(){ //同步 获取从业人员信息 准备电写入
		setParams("p_");
		jQuery.ajax({
			type: 'POST',
			url: dxr_querysnAndWcUrl,
			data: params,
			async: false,
			dataType: 'json',
			success: function(result){
				var rows  = eval(result);
				backHuoquMess(rows);
			}
		});
	}
	function backHuoquMess(json){
		$("#p_kssxh").attr("value","");
		$("#p_bcdxrsl").attr("value","");
		$('span[@id^="ic_"]').html("").end();
		$("#tpnrImg").attr("src","images/pic.gif");
		if(json.result=="success"){
			if(json.LIckzb[0]=='1'){ //是否查到了数据
				$("#p_kssxh").attr("value",json.LIckzb[1]);
				$("#p_bcdxrsl").attr("value",json.LIckzb[3]);
				startNum = json.LIckzb[1];
				maxNum = json.LIckzb[2];
				writeCount = json.LIckzb[3];
				isCanStart = true;
			}else{
				isCanStart = false;
			}
		}else{
			jAlert("错误信息","提示");
			isCanStart = false;
		}
	}
	function queryCyryxxMes(){ //同步 获取从业人员信息 准备电写入
		setParams("p_");
		jQuery.ajax({
			type: 'POST',
			url: dxr_queryCyryxxMesUrl,
			data: params,
			async: false,
			dataType: 'json',
			success: function(result){
				var rows  = eval(result);
				backCyryxxMes(rows);
			}
		});
	}
	function backCyryxxMes(json){ //获取从业人员信息 - 回调
		if(json.result=="success"){
			jsonLIckzb = json.LIckzb; //将回调信息 放到页面临时变量
			if(jsonLIckzb.length>0){ //有数据
				thePlayRow = 0;
				bpcWriteCount = jsonLIckzb[0].length;
				startDxr(); //开始电写入
			} else {
				jAlert("没有可电写入数据","提示");
			}
		}else{
			jAlert("错误信息","提示");
		}
	}
	function startDxr(){ //[0]：数据库中的值(待显示的) [1]：待写入卡的内容
		if(jsonLIckzb.length>0){
			showMesToPage(); //页面下方显示
			ickOpenWrite();//刷卡(OpenWrite())
		}
	}
	function ickOpenWrite(){ //将数据写入卡内
		//下面是的链接是给控件用的，控件通过他来拼url然后跟数据库进行交互，根据卡号查数据库，看是否电写入过。
		var ickContent = jsonLIckzb[1][thePlayRow];
		document.getElementById('ctlICCard').URL= $("#projectUrl").attr("value")+"kjdy/kongJianDiaoYong.action";
		document.getElementById('ctlICCard').ConnJava=content_connJava;
		document.getElementById('ctlICCard').ICCardDevice=content_deviceType; //旧设备
		document.getElementById('ctlICCard').OpenWrite(ickContent);
		
	}
	function WriteICCardFinish(backIckh){ //读卡结束回调函数
	    //  modify on 2010-08-13 by mds begin
		//var ickh = backIckh.replace('-','');
		var ickh = backIckh;
		//  modify on 2010-08-13 by mds end
		//是否应该判断是数字?
		backWriteIckh(ickh); //将IC卡号 写到数据库 ajax同步 参数 IC卡号
	}
	function backWriteIckh(ickh){ //同步 将ic卡号(芯片号)写到数据库
		$("#b_ickslid").attr("value",jsonLIckzb[0][thePlayRow].ickslid);
		$("#b_ryid").attr("value",jsonLIckzb[0][thePlayRow].ryid);
		$("#b_ickh").attr("value",ickh); //
		setParams("b_");
		jQuery.ajax({
			type: 'POST',
			url: dxr_backWriteIckhUrl,
			data: params,
			async: false,
			dataType: 'json',
			success: function(result){
				var rows  = eval(result);
				backBackWriteIckh(rows);
			}
		});
	}
	function backBackWriteIckh(json){ //将ic卡号(芯片号)写到数据库 - 回调
		thePlayRow += 1;
		var resMes = "";
		if(json.result=="success"){
			if(json.LIckzb=='1'){ //回写成功
				bpcDxrSuccess += 1;
				isPlayChengGong = true;
				resMes = "本次电写入成功！";
			} else {
				bpcDxrErr += 1;
				resMes = "本次电写入失败！";
			}
		} else {
			bpcDxrErr += 1;
			resMes = "本次电写入失败！";
		}
		if(pxrStart==true){ //批写入
			if(!isFinash(resMes)){ //没有结束
				nowState(resMes); //刷卡情况
				startDxr(); //继续刷卡
			}else{
				$("#p_kssxh").attr("attr","");
				$("#p_bcdxrsl").attr("attr","");
				var pxrflag = $("#pxrflag").attr("value");
				if(pxrflag=='1'){
					dxrpxrColse(); //关闭批写入页面
				}
			}
		} else { //自定义写入
			jAlert(resMes,"提示");
			$('span[@id^="ic_"]').html("").end();
			$("#tpnrImg").attr("src","images/pic.gif");
			var bxrflag = $("#bxrflag").attr("value");
			if(bxrflag=='1'){
				dxrbxColse(); //关闭补写页面
			}
		}
	}
	function queryCyryxxMesByCyrybh(){ //同步 获取从业人员信息(自定义写入) 准备电写入
		setParams("c_");
		jQuery.ajax({
			type: 'POST',
			url: dxr_queryCyryxxMesByCyrybhUrl,
			data: params,
			async: false,
			dataType: 'json',
			success: function(result){
				var rows  = eval(result);
				backQueryCyryxxMesByCyrybh(rows);
			}
		});
	}
	function backQueryCyryxxMesByCyrybh(json){ //获取从业人员信息 - 回调
		if(json.result=="success"){
			jsonLIckzb = json.LIckzb; //将回调信息 放到页面临时变量
			if(jsonLIckzb.length>0){ //有数据
				thePlayRow = 0;
				bpcWriteCount = jsonLIckzb[0].length;
				zdyDxr(); //自定义电写入
			} else {
				jAlert("没有可电写入数据","提示");
			}
		}else{
			jAlert("错误信息","提示");
		}
	}
	function zdyDxr(){ //自定义电写入
		showMesToPage(); //页面下方显示
		ickOpenWrite();//刷卡(OpenWrite())
	}
	
	
	
	
	
	
	
	function initParms(){ //初始化参数
		bpcWriteCount = 0; //本次最终写入数量
		bpcDxrSuccess = 0; //本次成功写入数量
		bpcDxrTiaog = 0; //本次跳过写入数量
		bpcDxrErr = 0; //本次写入失败数量
		
		pxrStart = false; //批写入开始
		
		jsonLIckzb = null; //[0]：数据库中的值(待显示的) [1]：待写入卡的内容
		thePlayRow = 0; //当前活动的行
	
	}
	function isFinash(obj){ //刷卡是否结束 //当最后一次失败的时候 拼提示信息
		if(bpcWriteCount==thePlayRow){
			pxrStart = false;
			nowState(obj+"刷卡结束！");
			$('span[@id^="ic_"]').html("").end();
			$("#tpnrImg").attr("src","images/pic.gif");
			return true;
		}
		return false;
	}
	function nowState(mess){ //刷卡情况
	    isPlayChengGong = true;
		jAlert(mess+"共有可写卡 "+bpcWriteCount+" 张，写入成功 "+bpcDxrSuccess+" 张，跳过 "+bpcDxrTiaog+" 张，失败 "+bpcDxrErr+" 张。","提示");//提示   可写卡N张，写入成功N张，跳过N张。
	}
	function showMesToPage(){ //显示信息到页面
		var theNowRow = jsonLIckzb[0][thePlayRow];
		$('span[@id^="ic_"]').html("").end();
		$("#tpnrImg").attr("src",wldj_queryCyryzpImageUrl+setNull(theNowRow.cyrybh));
		$("#ic_orderNum").append(setNull(theNowRow.sxh));
		$("#ic_xingming").append(setNull(theNowRow.xm));
		$("#ic_kh").append(setNull(theNowRow.kh));
		$("#ic_cyrybh").append(setNull(theNowRow.cyrybh));
		$("#ic_zjhm").append(setNull(theNowRow.zjhm)); //090617 问小苗是此字段（原来是lqrzjhm）
		$("#ic_xb").append(setNull(theNowRow.xb));
		$("#ic_minzu").append(setNull(theNowRow.minzu));
		$("#ic_csrq").append(setNull(theNowRow.csrq));
		$("#ic_zxbz").append(setNull(theNowRow.sfzxmc)); //注销
		$("#ic_hjsx").append(setNull(theNowRow.hjdxzqh));
		$("#ic_hjdxz").append(setNull(theNowRow.hjdxz));
		$("#ic_ywm").append(setNull(theNowRow.ywm));
		$("#ic_ywx").append(setNull(theNowRow.ywx));
		$("#ic_gj").append(setNull(theNowRow.gj));
		$("#ic_wgrjyxkz").append(setNull(theNowRow.wgrjyxkz));
		$("#ic_rjrq").append(setNull(theNowRow.yxsksrq));
		$("#ic_zatlq").append(setNull(theNowRow.yxqhzrq));
	}
	function startVerify(){ //验证批写入
		if (!checkControlValue("p_kssxh","Integer",-9999999999,9999999999,null,0,"开始顺序号"))
			return false;
		if (!checkControlValue("p_bcdxrsl","Integer",-9999999999,9999999999,null,0,"本次电写入数量"))
			return false;
		var p_startNum = $("#p_kssxh").attr("value");
		var p_writeCount = $("#p_bcdxrsl").attr("value");
		if((p_startNum-startNum)<0){
			jAlert("当前批次,最小开始顺序号为:"+startNum+".请正确填写开始顺序号","提示",null,"p_kssxh");
			return false;
		}
		if((maxNum-p_startNum)<0){
			jAlert("当前批次,最大顺序号为:"+maxNum+".请正确填写开始顺序号","提示",null,"p_kssxh");
			return false;
		}
		if((writeCount-p_writeCount)<0){
			jAlert("当前批次,最大电写入数量为:"+writeCount+".请正确填写本次电写入数量","提示",null,"p_bcdxrsl");
			return false;
		}
		return true;
	}
// ********** end **********