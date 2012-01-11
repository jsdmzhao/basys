//取当前系统时间,返回一个对象，包括年月日，时分秒，
function TimeObject() {
	var myDate = new Date();
	var ObjectTime = new Object();
	ObjectTime.year = myDate.getYear();
	ObjectTime.fullYear = myDate.getFullYear();  //获取完整的年份(4位,1970-????)
	var month = myDate.getMonth();
	if ((month + 1) < 10) {
		month = "0" + (month + 1);
	} else {
		month = month + 1;
	}
	ObjectTime.month = month;      //获取当前月份(0-11,0代表1月)
	var date = myDate.getDate();
	if (date < 10) {
		date = "0" + date;
	} else {
		date = date;
	}
	ObjectTime.date = date;      //获取当前日(1-31)
	ObjectTime.day = myDate.getDay();        //获取当前星期X(0-6,0代表星期天)
	ObjectTime.time = myDate.getTime();      //获取当前时间(从1970.1.1开始的毫秒数)
	ObjectTime.hours = myDate.getHours();      //获取当前小时数(0-23)
	ObjectTime.minutes = myDate.getMinutes();    //获取当前分钟数(0-59)
	ObjectTime.seconds = myDate.getSeconds();    //获取当前秒数(0-59)
	ObjectTime.milliseconds = myDate.getMilliseconds();  //获取当前毫秒数(0-999)
	ObjectTime.localeDateString = myDate.toLocaleDateString();    //获取当前日期
	var mytime = myDate.toLocaleTimeString();    //获取当前时间
	myDate.toLocaleString();      //获取日期与时间
	return ObjectTime;
}



//判2个时间前后的顺序：如开始时间不能大于接收时间,str用来存提示的具体项
function compare_twoTime(beginTime, endTime, type) {
	if(type==null || type.toUpperCase()=="DATE"){
		if(!isDate(beginTime)){
			beginTime = beginTime.replace(/-/g, "");
		}else{
			beginTime = getDate(beginTime);
		}
		if(!isDate(endTime)){
			endTime = endTime.replace(/-/g, "");
		}else{
			endTime = getDate(endTime);
		}
		if (Number(beginTime) > Number(endTime)) {
			return false;
		} else {
			return true;
		}
	}else if(type.toUpperCase()=="DATETIME"){
		if(Date.parse(beginTime.replace(/-/g, "/"))>Date.parse(endTime.replace(/-/g, "/"))){
			return false;
		}else{
			return true;
		}
	}
}

//判断当前某个时间段的结束时间不能大于当前日期
function compare_now(endTime, type) {
	var today = new Date();
	if(type==null || type.toUpperCase()=="DATE"){
		if(!isDate(endTime)){
			endTime = endTime.replace(/-/g, "");
		}else{
			endTime = getDate(endTime);
		}
		if (Number(endTime) > Number(getDate(today))) {
			return false;
		} else {
			return true;
		}
	}else if(type.toUpperCase()=="DATETIME"){
		if(Date.parse(endTime.replace(/-/g, "/"))>Date.parse(today)){
			return false;
		}else{
			return true;
		}
	}
}
function getDate(dt,dateType) {
	var strDt = "";
	var year;
	var month;
	var date;
	year = dt.getYear();
	month = (dt.getMonth() + 1) + "";
	date = dt.getDate() + "";
	if (month.length == 1) {
		month = "0" + month;
	}
	if (date.length == 1) {
		date = "0" + date;
	}
	
	if(dateType!=null && dateType=="-"){
		
		strDt = "" + dt.getFullYear() + "-" + month + "-" + date;
	}else{
		strDt = "" + year + month + date;
	}
	return strDt;
}
//查看是否是时间类型
function isDate(obj){
 return (typeof obj=='object')&&obj.constructor==Date; 
} 

//得到2个时间查的天数,传入2个时间字符串,如"2007-01-01"
function getTianshu(beginTime, endTime) {
	var s1 = endTime;
	var s2 = beginTime;
	s1 = s1.replace(/-/g, "/");
	s2 = s2.replace(/-/g, "/");
	s1 = new Date(s1);
	s2 = new Date(s2);
	var days = s1.getTime() - s2.getTime();
	var iDays = parseInt(days / (1000 * 60 * 60 * 24));
	return iDays;
}

