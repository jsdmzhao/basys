//页面高度页面宽度
		var pageWidth=0;
		var pageHeight=0;
/**
*	控件部分
*/

/*

-------------- 函数检索 --------------
trim函数:                         trim() lTrim() rTrim()
校验字符串是否为空:                 checkIsNotEmpty(str)
校验字符串是否为整型:               checkIsInteger(str)
校验整型最小值:                    checkIntegerMinValue(str,val)
校验整型最大值:                    checkIntegerMaxValue(str,val) 
校验整型是否为非负数:               isNotNegativeInteger(str)
校验字符串是否为浮点型:             checkIsDouble(str) 
校验浮点型最小值:                  checkDoubleMinValue(str,val)
校验浮点型最大值:                  checkDoubleMaxValue(str,val)
校验浮点型是否为非负数:             isNotNegativeDouble(str)
检验浮点值的小数位：				checkFlatDecimalLength(sControlObject,iDecimalLength)
校验字符串是否为日期型:             checkIsValidDate(str)
校验两个日期的先后:                checkDateEarlier(strStart,strEnd)
校验字符串是否为email型:           checkEmail(str)

校验字符串是否为中文:               checkIsChinese(str)
计算字符串的长度，一个汉字两个字符:   realLength()
校验字符串是否符合自定义正则表达式:   checkMask(str,pat)
得到文件的后缀名:                   getFilePostfix(oFile)  
-------------- 函数检索 --------------
*/
/**
*	added by snakeyang 2004.10.19
*	对页面的控件值进行判断
*	sControlObject 	控件对象
*	sControlType 	控件类型	Integer 整型；Float 浮点；PN 正数；Date 日期；Email 邮件地址；String 字符串
*	sMinValue		最小值
*	sMaxValue		最大值
*	iDecimalLength  小数点长度
*	iNullFlag		控件值是否可以为空	0、允许；1、不允许
**/

/**if (window.dialogArguments){
	var opener;
	opener=window.dialogArguments;
}**/		
function checkControlValue(sControlName,sControlType,sMinValue,sMaxValue,iDecimalLength,iNullFlag,sMessage){
	var sControlObject=$("#"+sControlName);
	var sControlValue=sControlObject.attr("value");
	//当控件不可见时，不获得焦点
	var offsetHeight = sControlObject.get(0).offsetHeight;
	if(offsetHeight==0 && sControlType!="Select"){
		sControlName = null;
	}
	if (parseInt(iNullFlag)==1 ){
		if (sControlType=="Select"){
			if (checkIsNotEmpty(sControlValue)==false){
				jAlert("\""+sMessage+"\"必须填写！",'验证信息',null,"div_"+sControlName);
				return false;
			}
		}else{ 
			if (checkIsNotEmpty(sControlValue)==false){
				jAlert("\""+sMessage+"\"必须填写！",'验证信息',null,sControlName);
				return false;
			}	
		}
	}
	if (sControlType=="Integer" && sControlValue!="") {
		if (checkIsInteger(sControlValue)==false){
			jAlert(sMessage+"不是数字类型！",'验证信息',null,sControlName);
			sControlObject.get(0).select();
			return false;
		}else{
			if (sMinValue!=null){
				if (checkIntegerMinValue(sControlValue,sMinValue)==false){
					jAlert(sMessage+"不能小于"+sMinValue+"！",'验证信息',null,sControlName);
					sControlObject.get(0).select();
					return false;
				}
			}
			if (sMaxValue!=null){
				if (checkIntegerMaxValue(sControlValue,sMaxValue)==false){
					jAlert(sMessage+"不能大于"+sMaxValue+"！",'验证信息',null,sControlName);
					sControlObject.get(0).select();
					return false;
				}
			}	
		}	
	}else if (sControlType=="Float" && sControlValue!="") {
		if (checkIsDouble(sControlValue)==false){
			jAlert(sMessage+"不是数字类型！",'验证信息',null,sControlName);
			sControlObject.get(0).select();
			return false;
		}else{
			if (sMinValue!=null){
				if (checkDoubleMinValue(sControlValue,sMinValue)==false){
					jAlert(sMessage+"不能小于"+sMinValue+"！",'验证信息',null,sControlName);
					sControlObject.get(0).select();
					return false;
				}
			}
			if (sMaxValue!=null){
				if (checkDoubleMaxValue(sControlValue,sMaxValue)==false){
					jAlert(sMessage+"不能大于"+sMaxValue+"！",'验证信息',null,sControlName);
					sControlObject.get(0).select();
					return false;
				}
			}	
			if (iDecimalLength!=null){
				if (!checkFlatDecimalLength(sControlObject,iDecimalLength,sControlName)){
					jAlert("在"+sMessage+"中只允许输入"+iDecimalLength+"位小数，请重新填写！",'验证信息');
					sControlObject.focus();
					sControlObject.get(0).select();
					return false;
				}	
			}
		}		
	}else if (sControlType=="PN" && sControlValue!=""){
		if (isNotNegativeDouble(sControlValue)==false){
			jAlert(sMessage+"不能是负数！",'验证信息',null,sControlName);
			sControlObject.get(0).select();
			return false;
		}else {
			if (sMinValue!=null){
				if (checkIntegerMinValue(sControlValue,sMinValue)==false){
					jAlert(sMessage+"不能小于"+sMinValue+"！",'验证信息',null,sControlName);
					sControlObject.get(0).select();
					return false;
				}
			}
			if (sMaxValue!=null){
				if (checkIntegerMaxValue(sControlValue,sMaxValue)==false){
					jAlert(sMessage+"不能大于"+sMaxValue+"！",'验证信息',null,sControlName);
					sControlObject.get(0).select();
					return false;
				}
			}	
		}	
	}else if (sControlType=="Date" && sControlValue!=""){
		if (checkIsValidDate(sControlName,sControlValue)==false){
			sControlObject.focus();
			sControlObject.get(0).select();
			return false;
		}		
	}else if (sControlType=="Datetime" && sControlValue!=""){
		if (parseInt(iNullFlag)==1 && sControlValue==""){
			sControlObject.focus();
			sControlObject.get(0).select();
			return false;
		}		
	}else if (sControlType=="Email" && sControlValue!=""){
		if (checkEmail(sControlValue)==false){
			jAlert(sMessage+"的格式不合法！",'验证信息',null,sControlName);
			sControlObject.get(0).select();
			return false;
		}else {
			if (sMinValue!=null){
				if (parseInt(sControlValue.realLength())<parseInt(sMinValue)){
					jAlert(sMessage+"的长度不能小于"+sMinValue+"！",'验证信息',null,sControlName);
					sControlObject.get(0).select();
					return false;
				}
			}
			if (sMaxValue!=null){
				if (parseInt(sControlValue.realLength())>parseInt(sMaxValue)){
					jAlert(sMessage+"的长度不能大于"+sMaxValue+"！",'验证信息',null,sControlName);
					sControlObject.get(0).select();
					return false;
				}
			}	
		}			
	}else  if (iNullFlag==1){
		if (sMinValue!=null){
			if (parseInt(sControlValue.realLength())<parseInt(sMinValue)){
				jAlert(sMessage+"的长度不能小于"+sMinValue+"！",'验证信息',null,sControlName);
				sControlObject.get(0).select();
				return false;
			}
		}
		if (sMaxValue!=null){
			if (parseInt(sControlValue.realLength())>parseInt(sMaxValue)){
				jAlert(sMessage+"的长度不能大于"+sMaxValue+"！",'验证信息',null,sControlName);
				sControlObject.get(0).select();
				return false;
			}
		}	
	} else  if (sControlType=="String" && sControlValue!=""){
		if (sMaxValue!=null){
			if (parseInt(sControlValue.realLength())>parseInt(sMaxValue)){
				jAlert(sMessage+"的长度不能大于"+sMaxValue+"！",'验证信息',null,sControlName);
				sControlObject.get(0).select();
				return false;
			}
		}	
	} 
	
	return true;
}	
/**
* added by LxcJie 2004.6.25
* 去除多余空格函数
* trim:去除两边空格 lTrim:去除左空格 rTrim: 去除右空格
* 用法：
*     var str = "  hello ";
*     str = str.trim();
*/
String.prototype.trim = function()
{
    return this.replace(/(^[\s]*)|([\s]*$)/g, "");
}
String.prototype.lTrim = function()
{
    return this.replace(/(^[\s]*)/g, "");
}
String.prototype.rTrim = function()
{
    return this.replace(/([\s]*$)/g, "");
}
/********************************** Empty **************************************/
/**
*校验字符串是否为空
*返回值：
*如果不为空，定义校验通过，返回true
*如果为空，校验不通过，返回false               参考提示信息：输入域不能为空！
*/
function checkIsNotEmpty(str)
{
    if(str.trim() == "")
        return false;
    else
        return true;
}//~~~
/*--------------------------------- Empty --------------------------------------*/
/********************************** Integer *************************************/
/**
*校验字符串是否为整型
*返回值：
*如果为空，定义校验通过，      返回true
*如果字串全部为数字，校验通过，返回true
*如果校验不通过，              返回false     参考提示信息：输入域必须为数字！
*/
function checkIsInteger(str)
{
    //如果为空，则通过校验
    if(str == "")
        return true;
    if(/^(\-?)(\d+)$/.test(str))
        return true;
    else
        return false;
}//~~~
/**
*校验整型最小值
*str：要校验的串。  val：比较的值
*
*返回值：
*如果为空，定义校验通过，                返回true
*如果满足条件，大于等于给定值，校验通过，返回true
*如果小于给定值，                        返回false              参考提示信息：输入域不能小于给定值！
*/
function checkIntegerMinValue(str,val)
{
    //如果为空，则通过校验
    if(str == "")
        return true;
    if(typeof(val) != "string")
        val = val + "";
    if(checkIsInteger(str) == true)
    {
        if(parseInt(str,10)>=parseInt(val,10))
            return true;
        else
            return false;
    }
    else
        return false;
}//~~~
/**
*校验整型最大值
*str：要校验的串。  val：比较的值
*
*返回值：
*如果为空，定义校验通过，                返回true
*如果满足条件，小于等于给定值，校验通过，返回true
*如果大于给定值，                        返回false       参考提示信息：输入值不能大于给定值！
*/
function checkIntegerMaxValue(str,val)
{
    //如果为空，则通过校验
    if(str == "")
        return true;
    if(typeof(val) != "string")
        val = val + "";
    if(checkIsInteger(str) == true)
    {
        if(parseInt(str,10)<=parseInt(val,10))
            return true;
        else
            return false;
    }
    else
        return false;
}//~~~
/**
*校验整型是否为非负数
*str：要校验的串。
*
*返回值：
*如果为空，定义校验通过，返回true
*如果非负数，            返回true
*如果是负数，            返回false               参考提示信息：输入值不能是负数！
*/
function isNotNegativeInteger(str)
{
    //如果为空，则通过校验
    if(str == "")
        return true;
    if(checkIsInteger(str) == true)
    {
        if(parseInt(str,10) < 0)
            return false;
        else
            return true;
    }
    else
        return false;
}//~~~
/*--------------------------------- Integer --------------------------------------*/
/********************************** Double ****************************************/
/**
*校验字符串是否为浮点型
*返回值：
*如果为空，定义校验通过，      返回true
*如果字串为浮点型，校验通过，  返回true
*如果校验不通过，              返回false     参考提示信息：输入域不是合法的浮点数！
*/
function checkIsDouble(str)
{
    //如果为空，则通过校验
    if(str == "")
        return true;
    //如果是整数，则校验整数的有效性
    if(str.indexOf(".") == -1)
    {
        if(checkIsInteger(str) == true)
            return true;
        else
            return false;
    }
    else
    {
        if(/^(\-?)(\d+)(.{1})(\d+)$/g.test(str))
            return true;
        else
            return false;
    }
}//~~~
/**
*校验浮点型最小值
*str：要校验的串。  val：比较的值
*
*返回值：
*如果为空，定义校验通过，                返回true
*如果满足条件，大于等于给定值，校验通过，返回true
*如果小于给定值，                        返回false              参考提示信息：输入域不能小于给定值！
*/
function checkDoubleMinValue(str,val)
{
    //如果为空，则通过校验
    if(str == "")
        return true;
    if(typeof(val) != "string")
        val = val + "";
    if(checkIsDouble(str) == true)
    {
        if(parseFloat(str)>=parseFloat(val))
            return true;
        else
            return false;
    }
    else
        return false;
}//~~~
/**
*校验浮点型最大值
*str：要校验的串。  val：比较的值
*
*返回值：
*如果为空，定义校验通过，                返回true
*如果满足条件，小于等于给定值，校验通过，返回true
*如果大于给定值，                        返回false       参考提示信息：输入值不能大于给定值！
*/
function checkDoubleMaxValue(str,val)
{
    //如果为空，则通过校验
    if(str == "")
        return true;
    if(typeof(val) != "string")
        val = val + "";
    if(checkIsDouble(str) == true)
    {
        if(parseFloat(str)<=parseFloat(val))
            return true;
        else
            return false;
    }
    else
        return false;
}//~~~
/**
*校验浮点型是否为非负数
*str：要校验的串。
*
*返回值：
*如果为空，定义校验通过，返回true
*如果非负数，            返回true
*如果是负数，            返回false               参考提示信息：输入值不能是负数！
*/
function isNotNegativeDouble(str)
{
    //如果为空，则通过校验
    if(str == "")
        return true;
    if(checkIsDouble(str) == true)
    {
        if(parseFloat(str) < 0)
            return false;
        else
            return true;
    }
    else
        return false;
}//~~~
/*--------------------------------- Double ---------------------------------------*/
/********************************** date ******************************************/
/**
*校验字符串是否为日期型
*返回值：
*如果为空，定义校验通过，           返回true
*如果字串为日期型，校验通过，       返回true
*如果日期不合法，                   返回false    参考提示信息：输入域的时间不合法！（yyyy-MM-dd）
*/
function checkIsValidDate(sControlName,sControlValue)
{
    //如果为空，则通过校验
   
    if(sControlValue == "")
        return true;
    var pattern = /^((\d{4})|(\d{2}))-(\d{1,2})-(\d{1,2})$/g;
    if(!pattern.test(sControlValue)){
        jAlert(sMessage+"的格式不合法(yyyy-MM-dd)！",'验证信息');
        return false;
    }    
    var arrDate = sControlValue.split("-");
    if(parseInt(arrDate[0],10) < 100)
        arrDate[0] = 2000 + parseInt(arrDate[0],10) + "";
    var date =  new Date(arrDate[0],(parseInt(arrDate[1],10) -1)+"",arrDate[2]);
    if (parseInt(arrDate[1],10)>12 && parseInt(arrDate[1],10)>0){
    	jAlert(sMessage+"的月份不能大于12"); 
        return false;
    }else if ((parseInt(arrDate[1],10)==1 || parseInt(arrDate[1],10)==3 || parseInt(arrDate[1],10)==5 || parseInt(arrDate[1],10)==7 || parseInt(arrDate[1],10)==8 || parseInt(arrDate[1],10)==10 || parseInt(arrDate[1],10)==12) && parseInt(arrDate[1],10)>0){
		if (parseInt(arrDate[2],10)>31 && parseInt(arrDate[2],10)>0){
			jAlert(sMessage+"的值错误"+arrDate[0]+"年"+arrDate[1]+"月的天数不能大于31"); 
        	return false;
    	}
	}else if ((parseInt(arrDate[1],10)==4 || parseInt(arrDate[1],10)==6 || parseInt(arrDate[1],10)==9 || parseInt(arrDate[1],10)==11) && parseInt(arrDate[1],10)>0){
		if (parseInt(arrDate[2])>30 && parseInt(arrDate[2],10)>0){
			jAlert(sMessage+"的值错误"+arrDate[0]+"年"+arrDate[1]+"月的天数不能大于30");
        	return false;
    	}
	}else if (parseInt(arrDate[1],10)==2 && parseInt(arrDate[1],10)>0){ 
		if (checkLeapYear(arrDate[0]) && parseInt(arrDate[2],10)>29 && parseInt(arrDate[2],10)>0){
			jAlert(sMessage+"的值错误"+arrDate[0]+"年"+arrDate[1]+"月的天数不能大于29");
			return false;
		}
		if (!checkLeapYear(arrDate[0]) && parseInt(arrDate[2],10)>28 && parseInt(arrDate[2],10)>0){
			jAlert(sMessage+"的值错误"+arrDate[0]+"年"+arrDate[1]+"月的天数不能大于28");	
			return false;
		}
	}else if (date.getYear() == arrDate[0] && date.getMonth() == (parseInt(arrDate[1],10) -1)+"" && date.getDate() == arrDate[2]){
        return true;
    }else{
    	jAlert(sMessage+"的格式不合法(yyyy-MM-dd)！",'验证信息');
		return false;
	}
	return true;	 	    
}//~~~
/**
*校验两个日期的先后
*返回值：
*如果其中有一个日期为空，校验通过,          返回true
*如果起始日期早于等于终止日期，校验通过，   返回true
*如果起始日期晚于终止日期，                 返回false    参考提示信息： 起始日期不能晚于结束日期。
*/
function checkTwoDateEarlier(strStart,strEnd)
{
    if(checkIsValidDate(null,strStart) == false || checkIsValidDate(null,strEnd) == false)
        return false;
    //如果有一个输入为空，则通过检验
    if (( strStart == "" ) || ( strEnd == "" ))
        return true;
    var arr1 = strStart.split("-");
    var arr2 = strEnd.split("-");
    var date1 = new Date(arr1[0],parseInt(arr1[1].replace(/^0/,""),10) - 1,arr1[2]);
    var date2 = new Date(arr2[0],parseInt(arr2[1].replace(/^0/,""),10) - 1,arr2[2]);
    if(arr1[1].length == 1)
        arr1[1] = "0" + arr1[1];
    if(arr1[2].length == 1)
        arr1[2] = "0" + arr1[2];
    if(arr2[1].length == 1)
        arr2[1] = "0" + arr2[1];
    if(arr2[2].length == 1)
        arr2[2]="0" + arr2[2];
    var d1 = arr1[0] + arr1[1] + arr1[2];
    var d2 = arr2[0] + arr2[1] + arr2[2];
    if(parseInt(d1,10) > parseInt(d2,10))
       return false;
    else
       return true;
}

function checkDateEarlier(strStart,strEnd)
{
    if(checkIsValidDate(null,strStart) == false || checkIsValidDate(null,strEnd) == false)
        return false;
    //如果有一个输入为空，则通过检验
    if (( strStart == "" ) || ( strEnd == "" ))
        return true;
    var arr1 = strStart.split("-");
    var arr2 = strEnd.split("-");
    var date1 = new Date(arr1[0],parseInt(arr1[1].replace(/^0/,""),10) - 1,arr1[2]);
    var date2 = new Date(arr2[0],parseInt(arr2[1].replace(/^0/,""),10) - 1,arr2[2]);
    if(arr1[1].length == 1)
        arr1[1] = "0" + arr1[1];
    if(arr1[2].length == 1)
        arr1[2] = "0" + arr1[2];
    if(arr2[1].length == 1)
        arr2[1] = "0" + arr2[1];
    if(arr2[2].length == 1)
        arr2[2]="0" + arr2[2];
    var d1 = arr1[0] + arr1[1] + arr1[2];
    var d2 = arr2[0] + arr2[1] + arr2[2];
    if(parseInt(d1,10) > parseInt(d2,10))
       return false;
    else
       return true;
}

function checkDateEarlier(start,startName,end,endName,type) // type="DATETIME"
{
	var strStart = $("#"+start).val(); 
	var strEnd = $("#"+end).val();
	
	
    //如果有一个输入为空，则通过检验
    if (( strStart == "" ) || ( strEnd == "" ))
        return true;
    
    var date1;
    var date2;
    
    if(type=="DATE"){ // 年月日
    	var arr1 = strStart.split("-");
    	var arr2 = strEnd.split("-");
    	
    	date1 = new Date(arr1[0],parseInt(arr1[1].replace(/^0/,""),10) - 1,arr1[2]);
    	date2 = new Date(arr2[0],parseInt(arr2[1].replace(/^0/,""),10) - 1,arr2[2]);
    	
    }else if(type=="DATETIME"){ // 时分秒
	    var arr1 = strStart.split(" ");
	    var arr11 = arr1[0].split("-");// 年月日
	    var arr12 = arr1[1].split(":");// 时分秒
	    
	    var arr2 = strEnd.split(" ");
	    var arr21 = arr2[0].split("-");// 年月日
	    var arr22 = arr2[1].split(":");// 时分秒
	    
	    date1 = new Date(arr11[0],parseInt(arr11[1].replace(/^0/,""),10) - 1,arr11[2],arr12[0],parseInt(arr12[1].replace(/^0/,""),10) - 1,arr12[2]);
	    date2 = new Date(arr21[0],parseInt(arr21[1].replace(/^0/,""),10) - 1,arr21[2],arr22[0],parseInt(arr22[1].replace(/^0/,""),10) - 1,arr22[2]);
    }else if(type=="DateAndDatetime"){ // 时分秒
    	var arr11 = strStart.split("-");// 年月日
    	var time="00:00:00";
	    var arr12 = time.split(":");// 时分秒
	    
	    var arr2 = strEnd.split(" ");
	    var arr21 = arr2[0].split("-");// 年月日
	    var arr22 = arr2[1].split(":");// 时分秒
	    
	    date1 = new Date(arr11[0],parseInt(arr11[1].replace(/^0/,""),10) - 1,arr11[2],arr12[0],parseInt(arr12[1].replace(/^0/,""),10) - 1,arr12[2]);
	    date2 = new Date(arr21[0],parseInt(arr21[1].replace(/^0/,""),10) - 1,arr21[2],arr22[0],parseInt(arr22[1].replace(/^0/,""),10) - 1,arr22[2]);
    }else if(type=="DatetimeAndDate"){ // 时分秒
	    var arr1 = strStart.split(" ");
	    var arr11 = arr1[0].split("-");// 年月日
	    var arr12 = arr1[1].split(":");// 时分秒
	    
	    var arr21 = strEnd.split("-");
	    var time="23:59:59";
		var arr22 = time.split(":");// 时分秒
	    
	    date1 = new Date(arr11[0],parseInt(arr11[1].replace(/^0/,""),10) - 1,arr11[2],arr12[0],parseInt(arr12[1].replace(/^0/,""),10) - 1,arr12[2]);
	    date2 = new Date(arr21[0],parseInt(arr21[1].replace(/^0/,""),10) - 1,arr21[2],arr22[0],parseInt(arr22[1].replace(/^0/,""),10) - 1,arr22[2]);
    }
    
    //alert(date1);
    //alert(date2);
    
    if(date1>date2){
    	jAlert(startName + "不能大于" + endName,"提示信息");
       	return false;
       }
    else
       return true;
}
/**
*startTimeId:开始时间的id
*endTimeId：结束时间的id
*str：字段名称
*/
function dateTimeCompare(startTimeId,endTimeId,str){
	var sj1= $("#"+startTimeId).val();
	var sj2= $("#"+endTimeId).val();
	if(sj1!=null && sj1!="" && sj2!=null && sj2!=""){
		if(sj1>sj2){
			jAlert(str+"范围不正确","验证信息",null,startTimeId);
			return false;
		}else{
			return true;
		}
	}else{
		return true;
	}
}
//~~~
/*--------------------------------- date -----------------------------------------*/
/********************************** email *****************************************/
/**
*校验字符串是否为email型
*返回值：
*如果为空，定义校验通过，           返回true
*如果字串为email型，校验通过，      返回true
*如果email不合法，                  返回false    参考提示信息：Email的格式不正確！
*/
function checkEmail(str)
{
    //如果为空，则通过校验
    if(str == "")
        return true;
    if (str.charAt(0) == "." || str.charAt(0) == "@" || str.indexOf('@', 0) == -1
        || str.indexOf('.', 0) == -1 || str.lastIndexOf("@") == str.length-1 || str.lastIndexOf(".") == str.length-1)
        return false;
    else
        return true;
}//~~~
/*--------------------------------- email ----------------------------------------*/
/********************************** chinese ***************************************/
/**
*校验字符串是否为中文
*返回值：
*如果为空，定义校验通过，           返回true
*如果字串为中文，校验通过，         返回true
*如果字串为非中文，             返回false    参考提示信息：必须为中文！
*/
function checkIsChinese(str)
{
    //如果值为空，通过校验
    if (str == "")
        return true;
    var pattern = /^([\u4E00-\u9FA5]|[\uFE30-\uFFA0])*$/gi;
    if (pattern.test(str))
        return true;
    else
        return false;
}//~~~
/**
* 计算字符串的长度，一个汉字两个字符
*/
String.prototype.realLength = function()
{
  return this.replace(/[^\x00-\xff]/g,"**").length;
}
/*--------------------------------- chinese --------------------------------------*/
/********************************** mask ***************************************/
/**
*校验字符串是否符合自定义正则表达式
*str 要校验的字串  pat 自定义的正则表达式
*返回值：
*如果为空，定义校验通过，           返回true
*如果字串符合，校验通过，           返回true
*如果字串不符合，                   返回false    参考提示信息：必须满足***模式
*/
function checkMask(str,pat)
{
    //如果值为空，通过校验
    if (str == "")
        return true;
    var pattern = new RegExp(pat,"gi")
    if (pattern.test(str))
        return true;
    else
        return false;
}//~~~
/*--------------------------------- mask --------------------------------------*/
/********************************** file ***************************************/
/**
* added by LxcJie 2004.6.25
* 得到文件的后缀名
* oFile为file控件对象
*/
function getFilePostfix(oFile)
{
    if(oFile == null)
        return null;
    var pattern = /(.*)\.(.*)$/gi;
    if(typeof(oFile) == "object")
    {
        if(oFile.value == null || oFile.value == "")
            return null;
        var arr = pattern.exec(oFile.value);
        return RegExp.$2;
    }
    else if(typeof(oFile) == "string")
    {
        var arr = pattern.exec(oFile);
        return RegExp.$2;
    }
    else
        return null;
}//~~~
/*--------------------------------- file --------------------------------------*/

//检验浮点值的小数位
function checkFlatDecimalLength(sControlObject,iDecimalLength,sControlName){
 	//判断小数位
	var sControlValue=sControlObject.attr("value");
	
 	if(!checkIsInteger(sControlValue)){
		var iValueLength=sControlValue.split(".")[1].length;
 		if(parseInt(iValueLength,10) > parseInt(iDecimalLength,10)){
 			
 			return false ;
 		}
 	}
 	return true;
}


//检查时间是否正确
function checkTime(sHour,sMinute,displayValue){
	var hour=sHour.attr("value");
	var minute=sMinute.attr("value");
	if(hour>23||hour<0){
    	alert(displayValue+"时数在0-23之内");
    	return false;
	}
	if(minute>59||minute<0){
    	alert(displayValue+"分钟数在0-59之内");
    	return false;
	}
	return true;
}

//检查是否闰年
function checkLeapYear(sYear){
	if (((sYear%4==0)&&(sYear%100!=0))||(sYear%400))
		return true;
	else
		return false;
}

//多行列表框移动操作
//查找所有记录
function selectAll(objectName){
 	var ilen;
  	ilen=objectName.length;
  	for (var i=0;i<ilen;i++){
    	objectName.options[i].selected=true;
  	}
}
//移动到顶部
function upTopMove(objectName){
  	var temptext,tempvalue;
  	var index;
  	index=objectName.selectedIndex; 
  	if (index == -1)
    	alert("请先选择一项！");
  	else {
   		if (index > 0) {
    		temptext=objectName.options[index].text;
    		tempvalue=objectName.options[index].value;
    		for (i = index -1;i > -1;i--) {  	
  				objectName.options[i + 1].text=objectName.options[i].text;
  				objectName.options[i + 1].value=objectName.options[i].value;  	
  			}
    		objectName.options[0].text=temptext;
    		objectName.options[0].value=tempvalue;
    		objectName.selectedIndex = 0;
    	}
  	}
}
//向上移动
function upStepMove(objectName){
  	var temptext,tempvalue;
  	var index;
  	index=objectName.selectedIndex;
  	if (index == -1)
    	alert("请先选择一项！");
  	else {
   		if (index > 0) {
  			temptext=objectName.options[index - 1].text;
  			tempvalue=objectName.options[index - 1].value;
  			objectName.options[index - 1].text=objectName.options[index].text;
  			objectName.options[index - 1].value=objectName.options[index].value;
  			objectName.options[index].text=temptext;
  			objectName.options[index].value=tempvalue;
  			objectName.selectedIndex = index - 1; 
  		}
  	}
}
//向下移动
function downStepMove(objectName){
 	var temptext,tempvalue;
  	var index;
  	index=objectName.selectedIndex;  
  	if (index == -1)
    	alert("请先选择一项！");
  	else {
    	if (index < objectName.length - 1 ) {
  			temptext=objectName.options[index + 1].text;
  			tempvalue=objectName.options[index + 1].value;
  			objectName.options[index + 1].text=objectName.options[index].text;
  			objectName.options[index + 1].value=objectName.options[index].value;
  			objectName.options[index].text=temptext;
  			objectName.options[index].value=tempvalue;
  			objectName.selectedIndex = index + 1;  	
  		}
  	}
}
//移动到底部
function downFloorMove(objectName){
  	var temptext,tempvalue;
  	var index,MaxIndex;
  	index=objectName.selectedIndex;
  	MaxIndex=objectName.length - 1;
   	if (index == -1)
    	alert("请先选择一项！");
  	else {
   		if (index < objectName.length - 1) {
    		temptext=objectName.options[index].text;
    		tempvalue=objectName.options[index].value;
    		for (i = index +1;i < objectName.length;i++) {  	
  				objectName.options[i - 1].text=objectName.options[i].text;
  				objectName.options[i - 1].value=objectName.options[i].value;  	
  			}
    		objectName.options[MaxIndex].text=temptext;
    		objectName.options[MaxIndex].value=tempvalue;
    		objectName.selectedIndex = MaxIndex;
   	 	}
  	}
}
//向左移动
function leftMove(TarObjectName,ResObjectName){
   	var index = ResObjectName.selectedIndex;
   	var MaxIndex = ResObjectName.length;
   	var oOption;
   	if (index == -1)
    	alert("请先选择一项！");
  	else {
    	StartPoint = 0;
    	EndPoint = MaxIndex;
    	for (i=StartPoint;i < EndPoint;i++){
       		if (ResObjectName.options[i].selected){      
    			oOption = new Option(ResObjectName.options[i].text,ResObjectName.options[i].value);
    			TarObjectName.add(oOption);
    			ResObjectName.remove(i);
    			i--;
    			EndPoint--;
    		}
    	}	
   	}  
}
//全部左移
function leftAllMove(TarObjectName,ResObjectName){
   	var MaxIndex = ResObjectName.length;
   	var oOption;   
   	if (MaxIndex != 0){    
    	for (i=0;i < MaxIndex;i++){       
    		oOption = new Option(ResObjectName.options[0].text,ResObjectName.options[0].value);
    		TarObjectName.add(oOption);
    		ResObjectName.remove(0);    		
    	}
    }	   
}
//向右移动
function rightMove(TarObjectName,ResObjectName){
   	var index = TarObjectName.selectedIndex;
   	var MaxIndex = TarObjectName.length;
   	var oOption;
   	if (index == -1)
    	alert("请先选择一项！");
  	else {
    	StartPoint = 0;
    	EndPoint = MaxIndex;
    	for (i=StartPoint;i < EndPoint;i++){
       		if (TarObjectName.options[i].selected){      
    			oOption = new Option(TarObjectName.options[i].text,TarObjectName.options[i].value);
    			ResObjectName.add(oOption);
    			TarObjectName.remove(i);
    			i--;
    			EndPoint--;
    		}    	
    	} 	
   }
}
//全部右移
function rightAllMove(TarObjectName,ResObjectName){
   	var MaxIndex = TarObjectName.length;
    if (MaxIndex != 0){    
    	for (i=0;i < MaxIndex;i++){     		    		  		
    		oOption = new Option(TarObjectName.options[0].text,TarObjectName.options[0].value);
    		ResObjectName.add(oOption);
    		TarObjectName.remove(0);  
    	}
    }	
}

/**
*	页面控制部分
*/
//var sTG="WzjqyWIN";
var sTG="_blank";
//打开一个新窗口
function openWindow(htmlURL,sTarget,iTop,iLeft,sToolbar,sLocation,sDirectories,sStatus,sMenubar,sScrollbars,sResizable,iWidth,iHigh){
	var newWIN=window.open(htmlURL,sTarget,"top="+iTop+",left="+iLeft+",toolbar="+sToolbar+",location="+sLocation+",directories="+sDirectories+",status="+sStatus+",menubar="+sMenubar+",scrollbars="+sScrollbars+",resizable="+sResizable+",width="+iWidth+",height="+iHigh);
	newWIN.focus();
	return false;
}

function openWindowModal(htmlURL,sTarget,iTop,iLeft,sToolbar,sLocation,sDirectories,sStatus,sMenubar,sScrollbars,sResizable,iWidth,iHigh){
	var newWIN=window.showModalDialog(htmlURL,sTarget,"top="+iTop+",left="+iLeft+",toolbar="+sToolbar+",location="+sLocation+",directories="+sDirectories+",status="+sStatus+",menubar="+sMenubar+",scrollbars="+sScrollbars+",resizable="+sResizable+",width="+iWidth+",height="+iHigh);
	newWIN.focus();
	return false;
}
//第一层窗口打开
//链接路径、宽度、高度、判断选中记录的对象、提示信息（可选）
function oneOpenWin(sUrl,sWidth,sHeight,sCheckValue,alertText){
  	if (sCheckValue!=null){
  		if(sCheckValue==""){
  			if (alertText==null)
    			alert("请先选择记录！");
    		else
    			alert(alertText);
    		return false;
  		}
	}
	var iX=(650-parseInt(sHeight))/2;
	var iY=(1010-parseInt(sWidth))/2;
	openWindow(sUrl,sTG,""+iX,""+iY,"no","no","no","yes","no","no","no",sWidth,sHeight);
 	return true;
}
//第一层自定义长宽窗口打开
function oneOpenWinD(sUrl,sWidth,sHeight,sCheckValue){
  	if (sCheckValue!=null){
  		if(sCheckValue==""){
    		alert("请先选择记录！");
    		return false;
  		}
	}
		itop=parseInt(document.body.clientHeight)/4;
		ileft=parseInt(document.body.clientWidth)/4;
  	openWindow(sUrl,sTG,itop,ileft,"no","no","no","no","no","no","no",sWidth,sHeight);
 	return true;
}
//多层窗口打开
function multilayerOpenWin(sUrl,sTarget,sWidth,sHeight,sCheckValue){
  	if (sCheckValue!=null){
  		if(sCheckValue==""){
    		alert("请选择记录！");
    		return false;
  		}
  	}	
  	openWindow(sUrl,sTarget,"20","20","no","no","no","no","no","no","no",sWidth,sHeight);
  	return true;
}
//XML窗口打开
function xmlOpenWin(sUrl,sTarget,sWidth,sHeight){
  	openWindow(sUrl,sTarget,"20","20","no","no","no","no","no","no","no",sWidth,sHeight);
}
//打印系统时间
function sysDate(){
  	var y=new Date();
	var gy=y.getYear();
	var dName=new Array("星期天","星期一","星期二","星期三","星期四","星期五","星期六");
	var mName=new Array("1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月");
	return "<span class=\"date\">"+y.getFullYear() +"年"+ mName[y.getMonth()] + y.getDate() + "日" +"&nbsp; "+ dName[y.getDay()] + "</span>";
			
}

function isChecked(obj){
	if (obj==null){ 
  		return false;
  	}	
  	if (obj.length==null){
  		if (obj.checked == true)
  			return true;
  		else 
  			return false;
  	}
  	for (i=0;i < obj.length;i++){
  		if (obj[i].checked == true)
  			return true;
  	}
  	return false;
}
//查询按钮
<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
//////////////////////////////////////
//以下为新增、修改界面公用
function SetRow(xmlTable){
   
	   var index = 0;
    for (i = 0; i < xmlTable.rows.length; i++) 
    {
 
       if ((xmlTable.rows(i) ==window.event.srcElement.parentElement)||(xmlTable.rows(i) ==window.event.srcElement.parentElement.parentElement)||(xmlTable.rows(i) ==window.event.srcElement.parentElement.parentElement.parentElement))
       {      
          xmlTable.rows(i).children(0).children(0).checked = true;
     	
       }
    }   

   
}
//数字大小写转换
function convertCurrency(currencyDigits) {
// Constants:
var MAXIMUM_NUMBER = 99999999999.99;
// Predefine the radix characters and currency symbols for output:
var CN_ZERO = "零";
var CN_ONE = "壹";
var CN_TWO = "贰";
var CN_THREE = "叁";
var CN_FOUR = "肆";
var CN_FIVE = "伍";
var CN_SIX = "陆";
var CN_SEVEN = "柒";
var CN_EIGHT = "捌";
var CN_NINE = "玖";
var CN_TEN = "拾";
var CN_HUNDRED = "佰";
var CN_THOUSAND = "仟";
var CN_TEN_THOUSAND = "万";
var CN_HUNDRED_MILLION = "亿";
var CN_SYMBOL = "人民币";
var CN_DOLLAR = "元";
var CN_TEN_CENT = "角";
var CN_CENT = "分";
var CN_INTEGER = "整";

// Variables:
var integral; // Represent integral part of digit number.
var decimal; // Represent decimal part of digit number.
var outputCharacters; // The output result.
var parts;
var digits, radices, bigRadices, decimals;
var zeroCount;
var i, p, d;
var quotient, modulus;

// Validate input string:
currencyDigits = currencyDigits.toString();
if (currencyDigits == "") {
alert("Empty input!");
return "";
}
if (currencyDigits.match(/[^,.\d]/) != null) {
alert("Invalid characters in the input string!");
return "";
}
if ((currencyDigits).match(/^((\d{1,3}(,\d{3})*(.((\d{3},)*\d{1,3}))?)|(\d+(.\d+)?))$/) == null) {
alert("Illegal format of digit number!");
return "";
}

// Normalize the format of input digits:
currencyDigits = currencyDigits.replace(/,/g, ""); // Remove comma delimiters.
currencyDigits = currencyDigits.replace(/^0+/, ""); // Trim zeros at the beginning.
// Assert the number is not greater than the maximum number.
if (Number(currencyDigits) > MAXIMUM_NUMBER) {
alert("Too large a number to convert!");
return "";
}

// Process the coversion from currency digits to characters:
// Separate integral and decimal parts before processing coversion:
parts = currencyDigits.split(".");
if (parts.length > 1) {
integral = parts[0];
decimal = parts[1];
// Cut down redundant decimal digits that are after the second.
decimal = decimal.substr(0, 2);
}
else {
integral = parts[0];
decimal = "";
}
// Prepare the characters corresponding to the digits:
digits = new Array(CN_ZERO, CN_ONE, CN_TWO, CN_THREE, CN_FOUR, CN_FIVE, CN_SIX, CN_SEVEN, CN_EIGHT, CN_NINE);
radices = new Array("", CN_TEN, CN_HUNDRED, CN_THOUSAND);
bigRadices = new Array("", CN_TEN_THOUSAND, CN_HUNDRED_MILLION);
decimals = new Array(CN_TEN_CENT, CN_CENT);
// Start processing:
outputCharacters = "";
// Process integral part if it is larger than 0:
if (Number(integral) > 0) {
zeroCount = 0;
for (i = 0; i < integral.length; i++) {
p = integral.length - i - 1;
d = integral.substr(i, 1);
quotient = p / 4;
modulus = p % 4;
if (d == "0") {
zeroCount++;
}
else {
if (zeroCount > 0)
{
outputCharacters += digits[0];
}
zeroCount = 0;
outputCharacters += digits[Number(d)] + radices[modulus];
}
if (modulus == 0 && zeroCount < 4) {
outputCharacters += bigRadices[quotient];
}
}
outputCharacters += CN_DOLLAR;
}
// Process decimal part if there is:
if (decimal != "") {
for (i = 0; i < decimal.length; i++) {
d = decimal.substr(i, 1);
if (d != "0") {
outputCharacters += digits[Number(d)] + decimals[i];
}
}
}
// Confirm and return the final output string:
if (outputCharacters == "") {
outputCharacters = CN_ZERO + CN_DOLLAR;
}
if (decimal == "") {
outputCharacters += CN_INTEGER;
}
//outputCharacters = CN_SYMBOL + outputCharacters;
outputCharacters = outputCharacters;
return outputCharacters;
}
//判断是否选中数据 
function radioCheck(cControlObject,iRows,sText){
	if (sText==null)
		sText="请选择数据！";
	if (iRows==""){
		alert(sText);
		return false;
	}	
	if (cControlObject.checked!=true){
		alert(sText);
		return false;
	}
	return true;
}	
//生成下拉列表内容
function createSelectOption(resDso,aNameValue){
   	//var doc=resDso.XMLDocument;
  	var root=resDso.documentElement;
  	var nodelist=root.childNodes;
  	var tempArray=new Array();
  	var outstr="";
  	if (resDso.text!=""){
  	if (nodelist.length!=0){
  		if (nodelist!=null){
  			for (i=0;i<nodelist.length;i++){
  				tempname = nodelist[i].selectSingleNode(aNameValue[1]).text;
    			tempvalue = nodelist[i].selectSingleNode(aNameValue[0]).text;
    			if (i==0)
    				tempArray[i] ="<option selected value="+ tempvalue +">" + tempname + "</option>";
    			else	
    				tempArray[i] ="<option value="+ tempvalue +">" + tempname + "</option>";
    		}
  		}
  		outstr=outstr + tempArray.join() ;
  	}
  	}
  	return outstr;
}	
//校验分割字符串
function setCheckSplit(sStr,len,sText){
	var aOne=sStr.split(";");
	var aTwo=null;
	if (sText==null)
		sText="字符串格式不正确！"
	for (var i=0;i<aOne.length;i++){
		aTwo=aOne[i].split(",");
		if (aTwo.length!=len){
			alert(sText);
			return false;
		}	
	}	
	return true;
}	

//每一页都要用到的	
function selectTag(showContent,selfObj){ 
		// 操作标签 
		var tag = document.getElementById("tags").getElementsByTagName("li"); 
		var taglength = tag.length; 
		for(i=0; i<taglength; i++){ 
		tag[i].className = ""; 
		} 
		selfObj.parentNode.className = "selectTag"; 
		// 操作内容 
		for(i=0; j=document.getElementById("tagContent"+i); i++){ 
		j.style.display = "none"; 
		} 
		document.getElementById(showContent).style.display = "block"; 
	
} 

//用showModalDialog方式打开窗口
function oneOpenShowModal(sUrl,sWidth,sHeight){
	window.showModalDialog(sUrl,window,"dialogHeight:"+sHeight+"px;dialogWidth:"+sWidth+"px");
}
	
//页面回车
function setDocumentkeydown(sControlObject,sControlType,sMinValue,sMaxValue,iDecimalLength,iNullFlag,sMessage) 
{
	if (sControlObject!=null && (event.keyCode==13 || event.keyCode==9)){
			if(sControlObject.type!='button'){
			if (!checkControlValue(sControlObject,sControlType,sMinValue,sMaxValue,iDecimalLength,iNullFlag,sMessage)){
				sControlObject.focus(); 
				if (event.keyCode==9)
					event.returnValue=false;
				return false;
			}				
	  		event.keyCode=9;
  		}
	}	
} 
/*
 *生成XML字符串
 *
 *
 *
 * 
 */
var sXML="";
var params;
function createXML(contype,childList){
	sXML="<Params>\n";
	
	$("[id^="+contype+"]").each(function(index, domEle) {
		var parName = $(domEle).attr("id").substr(contype.length);
		var parValue = $(domEle).attr("value");
		sXML+="<Param name=\""+parName+"\">"+changeTsZifu(parValue)+"</Param>\n";
	});
	
	if (childList!=null && childList.length>0){
		var thNameArr = new Array();
		var listTrId;
		var isObject = (dataid!=null && typeof(dataid)=="object");
		sXML+="<Lists>\n";
		for (var i=0;i<childList.length;i++){
			sXML+="<List name=\""+childList[i]+"\">\n";
			var oThead=$("#"+childList[i]).find("THEAD");
			var oTbody=$("#"+childList[i]).find("TBODY");
			if (oTbody.length>0){
				oThead.find("TR").find("TH").each(function(indexTH, domEleTH) {
					var colName = $(domEleTH).attr("name");
					thNameArr[indexTH] = colName.substr(2);
				});
				
				if(isObject){
					listTrId = dataid[i];
				}else{
					listTrId = dataid;
				}
				
				oTbody.find("TR").each(function(indexTR, domEleTR) {
					sXML+="<Row>\n";
					if (dataid!=""&&dataid!=null){
						sXML+="<Col name=\""+listTrId+"\">"+changeTsZifu($(domEleTR).attr("id"))+"</Col>\n";
					}
					$(domEleTR).find("TD").each(function(indexTD, domEleTD) {
						if(thNameArr[indexTD]!=null&&thNameArr[indexTD]!='null'
							&&thNameArr[indexTD]!=''&&thNameArr[indexTD]!='undefined'){
							var colName;
							if($(domEleTD).find("div").length==0)
								colName = $(domEleTD).html();
							else
								colName = $(domEleTD).find("div").html();
							sXML+="<Col name=\""+thNameArr[indexTD]+"\">"+changeTsZifu(colName)+"</Col>\n";
						}
					});
					sXML+="</Row>\n";
				});
			}
			sXML+="</List>\n";
		}
		sXML+="</Lists>\n";
	}
	sXML+="</Params>\n";
}
function changeTsZifu(obj){ //20100927 避免后台解析XML错误去掉特殊字符。 去掉&nbsp;是以前的需求
	obj=''+obj;
	obj=obj.replace(/(&nbsp;)/g,''); //去掉字符&nbsp;
	if(obj.indexOf("&gt;")==-1 && obj.indexOf("&lt;")==-1){
		obj=obj.replace(/(&)/g,'&amp;'); //去掉字符&
	}
	obj=obj.replace(/(<)/g,'&lt;'); //去掉字符<
	obj=obj.replace(/(>)/g,'&gt;'); //去掉字符>
	obj=obj.replace(/(\')/g,'&apos;');
	obj=obj.replace(/(\")/g,'&quot;');
	return obj;
}
function setParams(contype,childList){
	createXML(contype,childList);
	params={dataxml:sXML}; //序列化表单的值，与prototype中的form.serialize()相同
}	
//===============应用于jQuery============================================================================

var tables="";
var dataid="";
var sFlag="true";
var divnid="";
var tableid="";
var pageUrl="";
var modHtml="";
var delMessage="删除成功！";
var addMessage="添加成功，继续添加！";
var modMessage="修改成功！";
var detailid="";
var modUrl="";
var addUrl="";
var delUrl="";
var delid="";
var detailUrl="";
var detailHtml="";

/*loadPage 对于有翻页的页面的初始化
 * param divpageid：有翻页的div的id
 * param detailid：用于修改，明细查询的div的id
 */
function loadPage(divpageid){
	tables=$("#"+divpageid).html();
	$("#"+detailid).hide(); 	
	setPageList(1,'#');
}	
/*setQuery 实现数据的详细信息查询
 * id：数据的唯一标识id
 * url：需要访问的路径
 */	
function setQuery(id,url){
	$("#"+detailid).empty();
	dataid=id;
	setWidth(detailid,detailWidth);
	setUrl(detailid,url);
	bindDocument(detailid);
}

/*setUrl 设置load页面
 * param: url请求路径 
 */

function setUrl(divid,url){
	$("#"+divid).empty();
	$("#"+divid).load(url);
	$("#"+divid).show("slow"); 
	upAllPage(divid);
}
/*setDetail 明细查询
 * param: url请求路径 
 */

function setDetail(){
	setParams("q_");
	jQuery.post(detailUrl,params,updatediv,"json");
}
/*setModifyQuery 实现修改的查询
 * id：数据的唯一标识id
 */

function setModifyQuery(id){
	dataid=id;
	sFlag="false";
	setWidth(detailid,modWidth);
	setUrl(detailid,modHtml);
	bindDocument(detailid);
}	
/*setDelete 删除数据
 * delid：存储删除id的控件id
 * id：数据的唯一标识id
 * url：需要访问的路径
 */
function setDelete(id){
	sFlag="false";
	jConfirm('确定删除吗？', '删除提示', function(r) {
    	if(r==true){
			$("#"+delid).attr("value",id);
			setParams("d_");
	        jQuery.post(delUrl,params,deleteback,"json");
		}else{
		   return false;
		}
	});
}

/*setExcel 生成EXCEL
 * excelid 链接id
 * bbmc：报表标题
 */
function setExcel(excelid,bbmc){
	setParams("p_");
	var surl=excelUrl+"?xml="+sXML+"&tabletitle="+tabletitle+"&bbmc="+bbmc;
	surl=encodeURI(surl);
	//surl=encodeURI(surl);
	$("#"+excelid).attr("href",surl);
}
/* geteExcelHead 获取表头
 * divid mygrid1插件外层的Div的ID
 */
function geteExcelHead(divid){
	var theadHtml = $("#"+divid).find("table:first").find("thead:first");
	theadHtml.find("td").remove();
	tabletitle=theadHtml.html();
}

/*调用后台的处理
 * 
 */	
function deleteback(json){
	if  (json.result=="success"){
		jAlert(delMessage,'提示信息');
		var pageno=$("#pageNo").attr("value");
		if ($("#startno").html()==$("#endno").html()){
			if ($("#pageNo").attr("value")>1){
				pageno=""+(parseInt(pageno)-1);
			}
		}
		setPageList(pageno);
	}else{
		jAlert(json.result,'错误信息');
	}	
}	

function setList(pageno,url){	
	$("#"+divnid).html(tables);	
	createXML("p_");
	if (url==null || url=="undefined"){
		url=pageUrl;
	}
	return url;
}	

function setAddPage(){
	setWidth(detailid,addWidth);
	setUrl(detailid,addHtml);
	bindDocument(detailid);
}

function setAdd(){
	if (addVerify()){
		setParams("a_");
		jQuery.post(addUrl,params,addback,"json");
	}
}	

function addback(json){
	if  (json.result=="success"){
		jAlert(addMessage,'提示信息');
		setPageList($("#pageNo").attr("value"));
		setAddPage();
	}else{
		jAlert(json.result,'错误信息');
	}		
}	

function setUpdate(){
	if (modifyVerify()){
		setParams("m_");
		jQuery.post(modUrl,params,updateback,"json"); 
		return true;
	}else{
		return false;
	}		
}
function setBjUpdate(sOldXML){
	if (modifyVerify()){
		setParams("m_");
		if (sOldXML!=sXML)
			jQuery.post(modUrl,params,updateback,"json"); 
		else
			jAlert('数据没发生改变','提示信息');
		return true;
	}else{
		return false;
	}		
}

function valSelectChange(sOldXML,prefix){
	var myPrefix = prefix;
	if (manVerify()){
		if(myPrefix==null)myPrefix = "p_";
		setParams(myPrefix);
		if (sOldXML!=sXML){
			jAlert('查询条件已改变','提示信息'); 
			return false;
		}
		else
			return true;
	}else{
		return false;
	}		
}

function updateback(json){
	if  (json.result=="success"){
		jAlert(modMessage,'保存信息');
		setPageList($("#pageNo").attr("value"));
		$("#"+detailid).hideAndRemove("slow"); 
	}else{
		jAlert(json.result,'错误信息');
	}		
}

function bindDocument(detailDiv){
	clickNum = 0;
	$(document).click(function(event){
		var target = (event.target) ? event.target : event.srcElement;
			var parents = $(target).parents();
			var ishave = false;
			for(var i=0;i<parents.length;i++){
				if(parents.eq(i).attr("id")==detailDiv|| $(target).attr("id")==detailDiv || 
						parents.eq(i).attr("id").indexOf("datepicker_div")>-1 || $(target).attr("id").indexOf("datepicker_div")>-1
						|| $(target).attr("id")=="jquery-wangZhaZhuangTai" || parents.eq(i).attr("id")=="wangZhaKongZhi_login"
						|| $(target).attr("id")=="wangZhaKongZhi_login"){

					ishave = true;
					break;
			}
		}
		if(clickNum!=0 && $("#popup_container").attr("id")==null){
			if(!ishave){
				var spanLength = $("#"+detailDiv).find("span").length;
				var inputLength = $("#"+detailDiv).find("input").length;
				var inputULength = $("#"+detailDiv).find("input[id^='m_']").length;
				if(inputULength<=0){
					if(spanLength<inputLength){
						jConfirm("是否关闭弹出页面吗？","提示信息",function(r){
							if(r){
								var newDivHtml = $("#"+detailDiv).html();
								if(newDivHtml){
									$('#jquery-overlay').remove();
									$('#'+detailDiv).empty();
									$('#'+detailDiv).hide("show");
									$(document).unbind("click");
								}
							}
						});
					}else{
						var newDivHtml = $("#"+detailDiv).html();
						if(newDivHtml){
							$('#jquery-overlay').remove();
							$('#'+detailDiv).empty();
							$('#'+detailDiv).hide("show");
							$(document).unbind("click");
						}
					}
				}
			}
				
		}
			clickNum++;

	});
}

function setNull(sValue){
	if (sValue==null){
		sValue="";
	}else{
		sValue=''+sValue;
		sValue=sValue.split("T00:00:00")[0];
	}
	var patrn = /^(\d{4})\-(\d{2})\-(\d{2})T(\d{2}):(\d{2}):(\d{2})$/;
	if (patrn.test(sValue)){
		sValue = sValue.replace('T',' ');
	}
	return sValue;
}	


//四舍五入
function  ForDight(Dight,How)  
{  
           Dight  =  Math.round  (Dight*Math.pow(10,How))/Math.pow(10,How);  
           return  Dight;  
}  


function setWidth(divid,sWidth){
	var divObject = $("#"+divid);
	divObject.css("width",sWidth+"px");
	sLeft=ForDight((parseFloat(allPageWidth)-parseFloat(sWidth))/2,2)-3;
	divObject.css("left",sLeft+"px");
	
}

//适用于多层div
function setWidthSome(divid,sWidth){
	var divObject = $("#"+divid);
	var parentWidth = allPageWidth;
	 var parentList = divObject.parents();
	 var oneParent,parentLeft;
	 for(var index=0,length=parentList.length;index<length;index++){
		 oneParent = parentList.eq(index);
		 parentLeft = oneParent.css("left")
		if(parentLeft.indexOf("px")!=-1 || !isNaN(parentLeft)){
			parentWidth = oneParent.width();
			break;
		}
	 }
	divObject.css("width",sWidth+"px");
	var sLeft=ForDight((parseFloat(parentWidth)-parseFloat(sWidth))/2,2)-3;
	divObject.css("left",sLeft+"px");
}

////清空div隐藏div
function divclear(obj){
   var divParent = obj;
	  divParent.empty();
	  divParent.hideAndRemove("show");
  
}

/*setExcel 生成EXCEL
 * excelid 链接id
 * bbmc：报表标题
 */
function setExcel(excelid,bbmc){
	setParams("p_");
	var surl=excelUrl+"?xml="+sXML+"&tabletitle="+tabletitle+"&bbmc="+bbmc;
	surl=encodeURI(surl);
	//surl=encodeURI(surl);
	$("#"+excelid).attr("href",surl);
}

/*
不分页传参数将结果集返回，用于长参数导出前的查询
*/
function setSearchLong(){
	setParams("p_");
	jQuery.post(searchLongUrl,params,searchLongBack,"json");
}

/*setExcel 生成EXCEL,不传参数，防止超长
 * excelid 链接id
 * bbmc：报表标题
 */
function setExcelLong(excelid,bbmc){
	//setParams("p_");
	var surl=excelUrl+"?tabletitle="+tabletitle+"&bbmc="+bbmc;
	//alert(surl);
	surl=encodeURI(surl);
	//surl=encodeURI(surl);
	location.href = surl;
}
/*解决表头过长，导致导出时页面报"不是有效的方法"js错误。
 *setExcelLongTT 生成EXCEL,不传参数，防止超长
 * excelid 链接id
 * tabletitleid：ttt_tabletitle
 * bbmc：报表标题
 * bbmcid：ttt_bbmc
 * formname：testForm
 * 在页面中添加如下示例：
 *<form action="xxx/getExcelCreate_xxxx.action" method="post" id="testForm">
 *<input id="ttt_tabletitle" type="hidden" name="tabletitle" />
 *<input id="ttt_bbmc" type="hidden" name="bbmc" />
 *</form>
 */
function setExcelPost(excelid,tabletitleid,bbmc,bbmcid,formname){
	//setParams("p_");
	var surl=excelUrl+"?tabletitle="+tabletitle+"&bbmc="+bbmc;
	$("#"+tabletitleid).val(tabletitle);
	$("#"+bbmcid).val(bbmc);
	$("#"+formname).submit();
}

//高级查询
var tj_tcryxx;
var func_code; //功能编码
var gjcx_sjbm;
var gjcx_loadDivTopOffset;
var gjcx_pageListMethod; //主页面列表查询方法
var gjcx_ListPrefix; //主页面列表查询查询条件前缀 默认 p_
//sjbid:数据表结构id;loadDiv:加载高级查询页面的div;
function gaojichaxun(sjbid,loadDiv,pageListMethod,width,prefix){
	gjcx_ListPrefix="p_";
	gjcx_pageListMethod = "";
	if(sjbid==null)sjbid="";
	if(loadDiv==null)loadDiv=detailid;
	if(width==null)width="800";
	if(pageListMethod!=null && pageListMethod!="")gjcx_pageListMethod = pageListMethod;
	if(prefix!=null && prefix!="")gjcx_ListPrefix = prefix;
	
	loadGaoJiChaXunPage({sjbid:sjbid,loadDiv:loadDiv,width:width});
}

function loadGaoJiChaXunPage(settings){
	var loadDiv = settings.loadDiv;
	dataid = settings.sjbid;	//国内旅客数据表ID
	sFlag="false";
	setWidth(settings.loadDiv,settings.width);	
	$("#"+loadDiv).empty();
	$("#"+loadDiv).load("basic/common/Gjcx.jsp",function(){
		if(settings.sjbm!=null){
			$("#g_sjbmSet").val(settings.sjbm);
		}
	});
	$("#"+loadDiv).show("slow"); 
	upAllPage(loadDiv);
	//bindDocument(detailid);
	var gjcx_detailidOffset = $("#"+settings.loadDiv).offset();	
	gjcx_loadDivTopOffset=gjcx_detailidOffset.top;
	//gjcx_loadDivLeftOffset=gjcx_detailidOffset.left;
}

function gaoJiChaXunJSON(settings){
	var gjcxParams = {
			sjbid : null,
			sjbm : null,
			loadDiv : null,
			pageListMethod : null,
			width : null,
			prefix : null
	};
	jQuery.extend(gjcxParams, settings); //将页面参数覆盖默认参数
	
	gjcx_ListPrefix="p_";
	gjcx_pageListMethod = "";
	if(gjcxParams.sjbid==null)gjcxParams.sjbid="";
	if(gjcxParams.loadDiv==null)gjcxParams.loadDiv=detailid;
	if(gjcxParams.width==null)gjcxParams.width="800";
	var pageListMethod = gjcxParams.pageListMethod;
	if(pageListMethod!=null && pageListMethod!="")gjcx_pageListMethod = pageListMethod;
	var prefix = gjcxParams.prefix;
	if(prefix!=null && prefix!="")gjcx_ListPrefix = prefix;
	
	loadGaoJiChaXunPage({sjbid:gjcxParams.sjbid,sjbm:gjcxParams.sjbm,loadDiv:gjcxParams.loadDiv,width:gjcxParams.width});
}

//div拖拽
function daggleDiv(divId) { 
	var nodeType ;

	$("#"+divId).mousedown(function(e) {
		//e.stopPropagation();
		nodeType = e.target.nodeName;
		var target = $(e.target);	
		//alert(nodeType);
		if(nodeType=="TD"){
			if(target.attr("class")==null || target.attr("class")=="" || target.attr("class").indexOf("title")>-1){
				$("#"+divId).draggable();
				
				var datepickerDisplay = $("#datepicker_div").css("display");
				if(datepickerDisplay=="block"){
					$("#datepicker_div").css("display","none");
				}
			}else{
				//alert();
				$("#"+divId).draggable("destroy");
			}
		}else{
			$("#"+divId).draggable("destroy");
		}
	}); 	
} 

//弹出DIV时，背景覆盖，只能操作弹出页面
function upAllPage(divPage){
	if(!($("#jquery-overlay").attr("id")=="jquery-overlay")){
		$('body').append('<div id="jquery-overlay" name="'+divPage+'"></div>');
		$('#jquery-overlay').css({
			backgroundColor: 	"#FFFFFF",
			opacity:			0.1,
			width:				pageWidth,
			height:				pageHeight
		}).fadeIn();	
	}else{
		if($("#jquery-overlay").attr("name")!=divPage)
			$("#jquery-overlay").append('<div name="'+divPage+'"></div>');
	}

}
jQuery.fn.hideAndRemove=function(speed,callback){
	var sourceDiv = jQuery(this);
	sourceDiv.hide(speed,callback);
	sourceDiv.empty();
	if($('#jquery-overlay').attr("name")==sourceDiv.attr("id")){
		$('#jquery-overlay').remove();
		$(document).unbind("click");
	}else{
		var divList = $('#jquery-overlay').find("div");
		if(divList.length==0){
			$('#jquery-overlay').remove();
			$(document).unbind("click");
		}else{
			divList.eq(0).remove();
			$('#jquery-overlay').find("div[name='"+divList.eq(0).attr("name")+"']").remove();
		}
	}
}
function checkWangZhaZhuangTai(){
	var globalparParams = '<Params><Param name="globalparcode">wzztbz</Param></Params>';
	jQuery.post("sysadmin/checkWzzt_globalpar.action",{dataxml:globalparParams},wangZhaZhuangTaiBack,"json");
	var tt = setTimeout(checkWangZhaZhuangTai,70000);
	//clearTimeout(tt);
}

//依据全局参数code得到全局参数对象json
function getGlobalparByCode(code){
	var returnObj;
	var globalparParams = '<Params><Param name="globalparcode">'+code+'</Param></Params>';
	$.ajax({
		  type: "POST",
		  url: "sysadmin/query_globalpar.action",
		  async: false,
		  data: {dataxml:globalparParams},
		  dataType:"json",
		  timeout:100,
		  success: function(json){
			  var lGlobalpar = json.LGlobalpar;
			  if(lGlobalpar!=null && lGlobalpar.length>0){
				  returnObj = {name:lGlobalpar[0].globalparname,code:lGlobalpar[0].globalparcode,value:lGlobalpar[0].globalparvalue};
			  }
		}
	});
	return returnObj;
}

function wangZhaZhuangTaiBack(json){
	var lGlobalpar = json.LGlobalpar;
	var wangZhaZhuangTaiZhi = json.LGlobalpar[0].globalparvalue;
	if(wangZhaZhuangTaiZhi=="0"){

		var shiFouGuoQi = lGlobalpar[1];
		if(shiFouGuoQi==1){
			$('body').append("<div id='wangZhaKongZhi_login' class='page-layout'></div>");
			var loginDivTop = (pageHeight-200)/2;
			var loginDivLeft = (pageWidth-300)/2;
			$("#wangZhaKongZhi_login").width(300).height(200).css({
				top:loginDivTop,left:loginDivLeft,display:'none',"z-index":101000
			});
			$("#wangZhaKongZhi_login").load("loginNoRefresh.jsp").show();
		}else{
			$("#jquery-wangZhaZhuangTai").remove();
		}
		
	}else if(wangZhaZhuangTaiZhi=="1"){
		var wangZhaDivId = $("#jquery-wangZhaZhuangTai").attr("id");
		if(wangZhaDivId==null || wangZhaDivId==""){
			$('body').append('<div id="jquery-wangZhaZhuangTai" class="jquery-overlay"></div>');
			$('#jquery-wangZhaZhuangTai').css({
				backgroundColor: 	"#FFFFFF",
				opacity:			0.4,
				width:				pageWidth,
				height:				pageHeight,
				"z-index":			100000
			}).fadeIn();	
		}
	}
	
}
var allPageWidth = 1024;
$(document).ajaxSend(function(evt, request, settings){
   var canShu = settings.url;
   if(canShu.indexOf("insert")>-1 || canShu.indexOf("modify")>-1){
	   ajaxAddDivCeng();
   }
});

function ajaxAddDivCeng(){
	$("body").append('<div id="ajaxRequest_overlay" class="jquery-overlay"></div>');
	$("#ajaxRequest_overlay").css({
		"text-align":"center",
		"z-index":			900000,
		backgroundColor: 	"#5a5a5a",
		opacity:			0.75, 
		left:				(allPageWidth-pageWidth)/2,
		width:				pageWidth,
		height:				pageHeight
	}).fadeIn();
	$("body").append('<div id="div_loadingBaoCun" style="position:absolute;background-image:url(images/bgloading.gif);height:40px;width:260px;padding-top:25px;font:13px;">&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/jiazaizhong.gif" width="190" height="19" /><br>&nbsp;&nbsp;&nbsp;&nbsp;保存中，请稍候...</div>')
	$("#div_loadingBaoCun").css({
		"z-index":			900001,
		"text-align":"center",
		left:				(allPageWidth-280)/2,
		top:				(pageHeight-90)/2
	});	
}

$(document).ajaxComplete(function(event,request, settings){ 
	var canShu = settings.url;
	 if(canShu.indexOf("insert")>-1 || canShu.indexOf("modify")>-1){
			removeAllDivCeng();
	   }
});
$(document).ajaxError(function(event,request, settings){ 
	var canShu = settings.url;
	 if(canShu.indexOf("insert")>-1 || canShu.indexOf("modify")>-1){
			removeAllDivCeng();
	   }
});
function ajaxSearchDivCeng(){
	$("body").append('<div id="ajaxRequest_overlay" class="jquery-overlay"></div>');
	$("#ajaxRequest_overlay").css({
		"text-align":"center",
		"z-index":			900000,
		backgroundColor: 	"#5a5a5a",
		opacity:			0.75, 
		left:				(allPageWidth-pageWidth)/2,
		width:				pageWidth,
		height:				pageHeight
	}).fadeIn();
	$("body").append('<div id="div_loadingBaoCun" style="position:absolute;background-image:url(images/bgloading.gif);height:40px;width:260px;padding-top:25px;font:13px;">&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/jiazaizhong.gif" width="190" height="19" /><br>&nbsp;&nbsp;&nbsp;&nbsp;检索中，请稍候...</div>')
	$("#div_loadingBaoCun").css({
		"z-index":			900001,
		"text-align":"center",
		left:				(allPageWidth-280)/2,
		top:				(pageHeight-90)/2
	});	
}
function removeAllDivCeng(){
	$("#ajaxRequest_overlay").remove();
	$("#div_loadingBaoCun").remove();
}
function bc_bottonMoveRight(mrlen,mrMes){ //将按钮mrMes移动至靠右mrlen像素 默认：mrMes=保存，mrlen=15
	if(mrMes==null||mrMes=='null'||mrMes==''){
		mrMes='保存';
	}
	$("a").each(function(){
		if($(this).html().indexOf(mrMes)>=0){
			bottonMoveRight($(this),mrlen);
		}
	});
}
function bottonMoveRight(obj,movelen){
	if(movelen==null||movelen=='null'||movelen==''){
		movelen=15;
	}
	obj.parent().attr("align","right");
	obj.css('margin-right', movelen);
}

var currentDate;
var tomorrowDate;
// 初期化统计日期（一周内）
function initTJDate(){
    var date = new Date();
	var nowMonth = (date.getMonth()+1)+'';
	var nowDate = date.getDate()+'';
	if(nowMonth.length==1) nowMonth = '0'+nowMonth;
	if(nowDate.length==1)  nowDate = '0'+nowDate;
	currentDate = date.getFullYear()+'-'+nowMonth+'-'+nowDate;
  
    date.setTime(date.setDate(date.getDate()-6));   
    var oldMonth = (date.getMonth()+1)+'';
	var oldDate = date.getDate()+'';
	if(oldMonth.length==1) oldMonth = '0'+oldMonth;
	if(oldDate.length==1)  oldDate = '0'+oldDate;
	tomorrowDate = date.getFullYear()+'-'+oldMonth+'-'+oldDate;
}

/**导出时,查询结果为空需要调用此方法 dcjgwkDyff:导出结果为空调用方法*/
function dcjgwkDyff(aId,tsxx){
	$("#"+aId).attr("href","#");
	if(tsxx==null)
		tsxx = "无结果不能导出！";
	jAlert(tsxx,"提示信息");
}

//form表单导出方式
jQuery.fn.exportForm=function(setting){
	var exportParams={
			titleDiv:null,	//表头div
			titleName:null,	//表头名称
			url:null,	//导出路径
			prefix:'p_',
			message:'没有可供导出的数据'
	};
	jQuery.extend(exportParams, setting); //将页面参数覆盖默认参数
	var thisAObj = $(this);
	var thisAObjId = thisAObj.attr("id");
	var titleDiv = exportParams.titleDiv;
	var titleName = exportParams.titleName;
	var url = exportParams.url;
	var prefix = exportParams.prefix;
	if(titleDiv!=null && titleDiv!="" && titleName!=null && titleName!="" && url!=null && url!=""){
		
		//得到导出的表头信息
		var titleDivObj = jQuery("#"+titleDiv);
		var theadHtml = titleDivObj.find("table:first").find("thead:first");
		theadHtml.find("td").remove();
		var titleInput = jQuery('<input type="hidden" name="tabletitle" />');
		titleInput.val(theadHtml.html());
		
		//得到查询条件参数
		var dataInput = jQuery('<input type="hidden" name="xml" />');
		
		//创建导出表单form
		var exportForm = jQuery('<form style="display:none" id="'+thisAObjId+'_Form" name="daoChuForm" method="post" action="'+url+'"><input type="hidden" name="bbmc" value="'+titleName+'" /></form>');
		
		thisAObj.parent().append(exportForm.append(titleInput).append(dataInput));
		var exportFormObj = $("#"+thisAObjId+"_Form");
		thisAObj.click(function(){
			if(titleDivObj.find("table:first").find("tbody").find("tr").length>0){
				setParams(prefix);
				exportFormObj.find("input[name='xml']").val(sXML);
				exportFormObj.submit();
			}else{
				jAlert(exportParams.message,"提示信息");
			}
		});
	}
}

/*功能权限判断参数
 * 调用方式：  type为0时，checkFunction({funcStr:"a",type:"0",buttonStr:"e"});
 * 			 type为1时，checkFunction({funcStr:"a,b,c,d",type:"1",buttonStr:"e,f,g,h"});
 * 注意：type可以为空，默认值为0；buttonStr可以为空，默认值为null。
 */
function checkFunction(settings){
	var checkParams = {	
			funcStr:null,	//功能code 操作类型为"0"时，值为某个功能code；
								//类型为"1"时，值为多个功能code，以","分割。例："a,b,c,d"
			type:"0",		//操作类型  0:判断单个功能权限  1:判断多个功能权限
			buttonStr:null	//需要控制权限的按钮ID 操作类型为"0"时，值为某个按钮ID；
								//类型为"1"时，值为多个按钮ID，以","分割。例："e,f,g,h"
	/*		注意：buttonStr不为空时，funcStr和buttonStr需要一一对应。
		例：funcStr为"a,b,c,d"，buttonStr为"e,f,g,h"。"a功能"需对应"e按钮"的功能权限,
		"b功能"需对应"f按钮"的功能权限。
			单个功能权限判断时同上。
	*/
	};
	jQuery.extend(checkParams, settings); //将页面参数覆盖默认参数
	
	var caozuoType = checkParams.type;
	var functionStr = checkParams.funcStr;
	var buttonStr = checkParams.buttonStr;
	if(functionStr!=null){
		//设置请求参数
		var funcParams = {dataxml:functionStr,result:caozuoType};
		
		//发送请求
		jQuery.ajax({
			type: "POST",
			url : "sysadmin/checkFunction_function.action",
			data : funcParams,
			async : false,
			dataType:"json",
			success : function(json){
				if(caozuoType=="0"){
					//单个功能权限判断
					if(json.result=="failure"){
						//不具备该功能权限
						if(buttonStr==null){
							//按钮ID为空，默认隐藏ID为"功能code"的按钮
							$("#"+functionStr).parent().hide();
						}else{
							$("#"+buttonStr).parent().hide();
						}
					}
				}else{
					//多个功能权限判断
					var lFunction = json.LFunction;
					var length = lFunction.length;
					if(buttonStr==null){
						//按钮ID为空，默认隐藏ID为"功能code"的按钮
						var functionArry = functionStr.split(",");
						for(var index=0;index<length;index++){
							if(!lFunction[index]){
								$("#"+functionArry[index]).parent().hide();
							}
						}
					}else{
						//按钮ID不为空，隐藏ID为"按钮ID"的按钮
						var buttonArry = buttonStr.split(",");
						for(var index=0;index<length;index++){
							if(!lFunction[index]){
								$("#"+buttonArry[index]).parent().hide();
							}
						}
					}
				}
			}
		});
	}
}

function findList(path){
	jQuery.post(path,null,removeSessionBack,"json");
}

function removeSessionBack(json){
	setPageList(1);
}

//从内保拷入2010-12-17
function imgToBase(ImgerToBase1,imgid,zpdataid,fileSize){  
		if(fileSize==null||fileSize=='null'||fileSize==''){	
			fileSize = 50;
		} 
		ImgerToBase1.SetFileFilter="JPEG Image File (*.jpg)|*.jpg|JPEG Image File (*.jpeg)|*.jpeg|Bitmaps (*.bmp)|*.bmp|Gif Image File (*.gif)|*.gif|";
		//设置打开图片的大小
		ImgerToBase1.SetFileSize= fileSize;
		ImgerToBase1.OpenFile();
		//文件名称 eg: snow.jpeg
		//var fileName = ImgerToBase1.getFileName();
		//文件路径 包括文件名称
		var filePath = ImgerToBase1.getFile();
		var base64code="";
		var fileName = ImgerToBase1.getFileName();
		
		if(fileName==null||fileName==''||fileName=='null'){		
			//$("#"+imgid).attr("src","images/zwtp.gif");
		} else {			
			//BASE64编码
			base64code = ImgerToBase1.getBase64();
			$("#"+imgid).attr("src",filePath);
			$("#"+zpdataid).attr("value",base64code);
		}
}
function checkTel(telephone,message){
	if(message==null||message==''||message==undefined){
		message="手机号码";
	}
	var length=telephone.length;
	if(length!=7&&length!=8&&length!=11&&length!=12){
		jAlert(message+"错误！",'验证信息');
		return ;
	}
	return true;
}
