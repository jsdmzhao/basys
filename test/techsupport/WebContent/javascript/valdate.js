function isIdCardNo(num) 
{ 
	
	num = num.toUpperCase(); 
	//身份证号码不允许为111111111111111或将111111191111111113.20100817修改
	if(num=='111111111111111'||num=='111111191111111113')
	{
		alert('输入的身份证号码不正确！'); 
		return false; 
	}
	//身份证号码为15位,17位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X。 
	if (!(/(^\d{17}$)|(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num))) 
	{ 
		alert('输入的身份证号码不正确！'); 
		return false; 
	} 
	//校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。 
	//下面分别分析出生日期和校验位 
	var len, re; 
	len = num.length; 
	//如果是17位的，则先把年份的前面2个去掉，变成15位
	if(len == 17){
		num = num = num.substr(0, 6) +  num.substr(8, num.length - 8);
		len = num.length;
	}
	if (len == 15) 
	{ 
		re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/); 
		var arrSplit = num.match(re); 
	
		//检查生日日期是否正确 
		var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]); 
		var bGoodDay; 
		bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4])); 
		if (!bGoodDay) 
		{ 
			alert('输入的身份证号码不正确！'); 
			return false; 
		} 
		else 
		{ 
			//将15位身份证转成18位 
			//校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。 
			var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2); 
			var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'); 
			var nTemp = 0, i; 
			num = num.substr(0, 6) + '19' + num.substr(6, num.length - 6); 
			for(i = 0; i < 17; i ++) 
			{ 
				nTemp += num.substr(i, 1) * arrInt[i]; 
			} 
			num += arrCh[nTemp % 11]; 
			return num; 
		} 
	} 
	if (len == 18) 
	{ 
		re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/); 
		var arrSplit = num.match(re); 
	
		//检查生日日期是否正确 
		var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]); 
		var bGoodDay; 
		bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4])); 
		if (!bGoodDay) 
		{ 
			alert('输入的身份证号码不正确！'); 
			return false; 
		} 
		else 
		{ 
			//检验18位身份证的校验码是否正确。 
			//校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。 
			var valnum; 
			var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2); 
			var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'); 
			var nTemp = 0, i; 
			for(i = 0; i < 17; i ++) 
			{ 
				nTemp += num.substr(i, 1) * arrInt[i]; 
			} 
			valnum = arrCh[nTemp % 11]; 
			if (valnum != num.substr(17, 1)) 
			{ 
				alert('输入的身份证号码不正确'); 
				return false; 
			} 
			return num; 
		} 
	} 
	return false; 
} 

//校验身份证号码
//zjlxObj-证件类型所属对象, zjhmObj-证件号码所属对象

	function checkIDCardNum(zjlxObj,zjhmObj)
	{
		var isIDCardValidate = zjhmObj.value;
		if(zjlxObj.value=='居民身份证')
		{
		 if(zjhmObj.value!=null&&zjhmObj.value!='')
		 {
		      	isIDCardValidate = isIdCardNo(zjhmObj.value);
		      	if(isIDCardValidate==false)
		 		{
		     		zjhmObj.focus();
		     		return false;
		 		}
		 		else zjhmObj.value = isIDCardValidate;
		 }
		}
	}
	

//校验电话号码，8位或以上数字，不能输入汉字
function f_check_phone(obj,message)    
{   
    var regu =/^\(?0\d{2}[) -]?\d{8}|\d{8,12}$/;    
    var re = new RegExp(regu);   
    if(obj.value!=null&&obj.value!='')
    {
	    if (!re.test(obj.value)) {   
	      	alert(message+"应为8位以上数字");
	    	obj.focus();
	    	return false;   
	    }  
	}
}

//校验汉字
function isChinese(obj,message)    
{   
    var regu =/^([\u4E00-\u9FA5]|[\uFE30-\uFFA0])*$/gi;    
    var re = new RegExp(regu);   
    if($("#"+obj).val()!=null&&$("#"+obj).val()!='')
    {
	    if (!re.test($("#"+obj).val())) {   
	    	jAlert(message+"只能输入汉字","验证信息");
	    	$("#"+obj).focus();
	    	return false;   
	    }else{
	    	return true;
	    }
	}
}


function checkIdCardNo(valueId){ 
	var obj = $("#"+valueId);//得到控件的Jquery对象
	var num = obj.val().toUpperCase();//得到对象值
	var objType = obj.attr("type");
	if(num==null || num==""){
		return false; 
	}
	//身份证号码不允许为111111111111111或将111111191111111113.20100817修改
	if(num=='111111111111111'||num=='111111191111111113')
	{
		return false; 
	}
	num = num.toUpperCase(); 
	//身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X。 
	if (!(/(^\d{17}$)|(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num))){ 
		return false;
	} 
	//校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。 
	//下面分别分析出生日期和校验位 
	var len, re; 
	len = num.length; 
	if(len == 17){
		num = num = num.substr(0, 6) +  num.substr(8, num.length - 8);
		len = num.length;
	}
	
	if (len == 15){ 
		re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/); 
		var arrSplit = num.match(re); 
	
		//检查生日日期是否正确 
		var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]); 
		var bGoodDay; 
		bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4])); 
		if (!bGoodDay) 
		{ 
			return false;
		} 
		else 
		{ 
			//将15位身份证转成18位 
			//校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。 
			var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2); 
			var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'); 
			var nTemp = 0, i; 
			num = num.substr(0, 6) + '19' + num.substr(6, num.length - 6); 
			for(i = 0; i < 17; i ++) 
			{ 
				nTemp += num.substr(i, 1) * arrInt[i]; 
			} 
			num += arrCh[nTemp % 11]; 
			obj.val(num);
			return true; 
		} 
	} 
	if (len == 18){ 
		re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/); 
		var arrSplit = num.match(re); 
	
		//检查生日日期是否正确 
		var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]); 
		var bGoodDay; 
		bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4])); 
		if (!bGoodDay) 
		{ 
			return false; 
		} 
		else 
		{ 
			//检验18位身份证的校验码是否正确。 
			//校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。 
			var valnum; 
			var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2); 
			var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'); 
			var nTemp = 0, i; 
			for(i = 0; i < 17; i ++) 
			{ 
				nTemp += num.substr(i, 1) * arrInt[i]; 
			} 
			valnum = arrCh[nTemp % 11]; 
			if (valnum != num.substr(17, 1)) 
			{ 
				return false; 
			} 
			obj.val(num);
			return true; 
		} 
	} 
	return false; 
} 


//从身份证号码中得到出生日期
function getBirthday(num){
	var len, re; 
	len = num.length; 
	if (len == 15) 
	{ 
		re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/); 
		var arrSplit = num.toUpperCase().match(re); 
	
		//检查生日日期是否正确 
		var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]); 
		var birYear,birMonth,birDate; 
		birYear = dtmBirth.getFullYear();
		birMonth =(dtmBirth.getMonth() + 1);
		birDate = dtmBirth.getDate();
		
		if(birMonth<10)
			birMonth = "0" + birMonth;
		if(birDate<10)
			birDate = "0" + birDate;
		return birYear + "-" + birMonth + "-" + birDate;
	} 
	if (len == 18) 
	{ 
		re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/); 
		var arrSplit = num.toUpperCase().match(re); 
	
		//检查生日日期是否正确 
		var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]); 
		var birYear,birMonth,birDate; 
		birYear = dtmBirth.getFullYear();
		birMonth =(dtmBirth.getMonth() + 1);
		birDate = dtmBirth.getDate();
		
		if(birMonth<10)
			birMonth = "0" + birMonth;
		if(birDate<10)
			birDate = "0" + birDate;
		return birYear + "-" + birMonth + "-" + birDate;
	} 
}

//从身份证号码中得到性别 
function getXb(num){
	var len; 
	len = num.length; 
	if (len == 15) 
	{ 
		var xbNum = num.substring(14,15);
		return xbNum%2==0 ? 2 : 1;
	} 
	if (len == 18) 
	{ 
		var xbNum = num.substring(16,17);
		return xbNum%2==0 ? 2 : 1;
	} 
}

//从身份证号码中得到户籍省县
function getHjsx(num,dmId,mcId){
	if(num!=null&&num!=""){
		var zjhm="<Params>\n";
		zjhm+="	<Param name=\"zjhm\">"+num+"</Param>\n";
		zjhm+="</Params>\n";
	$.ajax({
		  type: "POST",
		  url: "ylfwzagl/getxzqhByZj_cyryxx.action",
		  async: false,
		  data: {dataxml:zjhm},
		  dataType:"json",
		  timeout:1000,
		  success: function(result){
			  	$("#"+dmId).val(result.cyryxx.hjdxzqhdm);
	  			$("#"+mcId).val(result.cyryxx.hjdxzqh);
		  }
		});
	}
}

	//从身份证号码中得到户籍省县
	function getDdHjsx(num,dmId,mcId){
		if(num!=null&&num!=""){
			var zjhm="<Params>\n";
			zjhm+="	<Param name=\"zjhm\">"+num+"</Param>\n";
			zjhm+="</Params>\n";
		$.ajax({
			  type: "POST",
			  url: "ddhyzagl/queryHjsxByZjhm_ddcyryxx.action",
			  async: false,
			  data: {dataxml:zjhm},
			  dataType:"json",
			  timeout:1000,
			  success: function(result){
				  	$("#"+dmId).val(result.ddcyryxx.hjdxzqhdm);
		  			$("#"+mcId).val(result.ddcyryxx.hjdxzqh);
			  }
			});
		}
	}

//从身份证号码中得到户籍省县 典当业
function getHjsxDD(num,dict_code,dmId,mcId){
	if(num!=null && num!="" && num.length>5){
		var zjhm="<Params>\n";
		zjhm+="	<Param name=\"dict_code\">"+dict_code+"</Param>\n";
		zjhm+="	<Param name=\"fact_value\">"+num.substring(0,6)+"</Param>\n";
		zjhm+="</Params>\n";
	$.ajax({
		  type: "POST",
		  url: "sysadmin/queryXZQH_dict_item.action",
		  async: false,
		  data: {dataxml:zjhm},
		  dataType:"json",
		  timeout:1000,
		  success: function(result){
		  		if(result.LDict_item!=null&&result.LDict_item.length>0){
		  			$("#"+dmId).val(result.LDict_item[0].fact_value);
	  				$("#"+mcId).val(result.LDict_item[0].display_name);
		  		}
			  	
		  }
		});
	}
}
//从身份证号码中得到民族
function getMinZu(num,dict_code,dmId,mcId){
	if(num!=null && num!=""){
		var zjhm="<Params>\n";
		zjhm+="	<Param name=\"dict_code\">"+dict_code+"</Param>\n";
		zjhm+="	<Param name=\"fact_value\">"+num+"</Param>\n";
		zjhm+="</Params>\n";
	$.ajax({
		  type: "POST",
		  url: "sysadmin/queryXZQH_dict_item.action",
		  async: false,
		  data: {dataxml:zjhm},
		  dataType:"json",
		  timeout:1000,
		  success: function(result){
		  		if(result.LDict_item!=null&&result.LDict_item.length>0){
		  			$("#"+dmId).val(result.LDict_item[0].fact_value);
	  				$("#"+mcId).val(result.LDict_item[0].display_name);
		  		}
			  	
		  }
		});
	}
}

///身份证号码 18 转 15位
function isIdCardNo15(num){

 var len
 len = num.length;
 if (len == 18){ 
    num = num.substring(0,6)+num.substring(8,17);
    return num;
 }
 
}
