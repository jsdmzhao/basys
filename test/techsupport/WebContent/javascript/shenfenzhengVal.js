	
	var sfzValArrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
	var sfzValArrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
	var sfzIsFoucsMes;
	function valSfzCardIsRight(objId,errmess,isFoucsMes){
		(isFoucsMes==null)?sfzIsFoucsMes=1:sfzIsFoucsMes=isFoucsMes;
		var cardNumber = $("#"+objId).attr("value");
		cardNumber = cardNumber.toUpperCase();
		//身份证号码不允许为111111111111111或将111111191111111113.20100817修改
		if(cardNumber=='111111111111111'||cardNumber=='111111191111111113')
		{
			return errtishi(errmess,objId);
		}
		if(valIsWrite(cardNumber)){ //写法没有问题 15/17/18
			if(cardNumber.length==17){
				cardNumber = change17to15(cardNumber);
			}
			
			if (cardNumber.length==15){
				var re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);
				var arrSplit = cardNumber.match(re);
				var dtmBirth = new Date('19'+ arrSplit[2]+'/'+arrSplit[3]+'/'+arrSplit[4]);
				var goodDate = valIs15Birth(dtmBirth,arrSplit); //判断生日
				if (goodDate){ //生日正确
					$("#"+objId).attr("value",change15to18(cardNumber))
				} else {
					return errtishi(errmess,objId);
				}
			}
			
			if (cardNumber.length==18){
				var re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);
				var arrSplit = cardNumber.match(re);
				var dtmBirth = new Date(arrSplit[2]+"/"+arrSplit[3]+"/"+arrSplit[4]);
				var goodDate = valIs18Birth(dtmBirth,arrSplit); //判断生日
				if (goodDate){ //生日正确
					if(!varThe18LastStr(cardNumber)){ //验证最后一位
						return errtishi(errmess,objId);
					}
				} else {
					return errtishi(errmess,objId);
				}
			}
		} else {
			return errtishi(errmess,objId);
		}
		return true;
	}
	
	/** 验证身份证的写法是否正确 */
	function valIsWrite(cardNumber){ //身份证号码为15位,17位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X。 
		if (!(/(^\d{17}$)|(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(cardNumber))){ 
			return false; 
		}
		return true;
	}
	/** 15位验证生日 */
	function valIs15Birth(birth,arrSplit){
		return (birth.getYear()==Number(arrSplit[2]))&&((birth.getMonth()+1)==Number(arrSplit[3]))&&(birth.getDate()==Number(arrSplit[4]));
	}
	/** 18位验证生日 */
	function valIs18Birth(birth,arrSplit){
		return (birth.getFullYear()==Number(arrSplit[2]))&&((birth.getMonth()+1)==Number(arrSplit[3]))&&(birth.getDate()==Number(arrSplit[4]));
	}
	/** 验证身份证第18位 */
	function varThe18LastStr(obj){
		var lastStr = query18Wei(obj);
		if (lastStr!=obj.substr(17, 1)){
			return false;
		}
		return true;
	}
	/** 将17位变为15位 */
	function change17to15(obj){
		return obj.substr(0,6)+obj.substr(8,obj.length-8);
	}
	/** 将15位变为18位 */
	function change15to18(obj){
		obj = obj.substr(0,6)+'19'+obj.substr(6,obj.length-6);
		obj += query18Wei(obj);
		return obj;
	}
	/** 第18位身份证 */
	function query18Wei(obj){
		var nTemp = 0;
		for(var i=0;i<17;i++){
			nTemp+=obj.substr(i,1)*sfzValArrInt[i];
		}
		return sfzValArrCh[nTemp%11];
	}
	function errtishi(errmess,objId){
		if(sfzIsFoucsMes=="0"){
			jAlert(errmess,"提示");
		}
		if(sfzIsFoucsMes=="1"){
			jAlert(errmess,"提示",null,objId);
		}
		return false;
	}
	
	
	//************************************浮点型验证
	function valFloatValue(objId,tsMes,maxVal,minVal,points,isMust){
		var content = $("#"+objId).attr("value")+"";
		
		content = content.replace(/(^\s*)|(\s*$)/g,'');
		if(content==""&&isMust==0){ //不是必须填写
			return true;
		}
		if(content.indexOf(".") != -1){
		var valpoins = content.split(".")[1].length;
			if(parseInt(valpoins,10) > parseInt(points,10)){
				jAlert(""+tsMes+"，例如:100.00","提示",null,''+objId);
				return false;
			}
		}
		if(/^(\-?)(\d+)$/.test(content)||(/^(\-?)(\d+)(.{1})(\d+)$/g.test(content))){
			if(parseFloat(content)>=parseFloat(maxVal)){
				jAlert(""+tsMes+"，最大值不能超过:"+maxVal,"提示",null,''+objId);
				return false;
			}
			if(parseFloat(minVal)>=parseFloat(content)){
				jAlert(""+tsMes+"，最小值不能小于:"+minVal,"提示",null,''+objId);
				return false;
			}
		} else {
			jAlert(""+tsMes+"，例如:100.00","提示",null,''+objId);
			return false;
		}
		return true;
	}
	
	
	//************************************输入验证 KeyUp事件
	function htjdOnkeyupVal(obj,flags){
		var values = $("#"+obj).attr("value");
		if(flags=='dh'){ //电话
			lxdhValZz(obj,values); 
		}else if(flags=='zzz'){ //暂住证 
			zzzbhValZz(obj,values); 
		}else if(flags=='hz'){ //护照
			hzbhValZz(obj,values); 
		}else if(flags=='jyxk'){ //就业许可、签证
			jyxkValZz(obj,values); 
		}else if(flags=='zhongwen'){ //中文
			zhongwenValZz(obj,values); 
		}else if(flags=='xingming'){ //中文
			xingmingValZz(obj,values); 
		}else if(flags=='pwh'){ //批文号
			pwhValZz(obj,values); 
		}else if(flags=='shuzi'){ //数字
			shuziValZz(obj,values); 
		}else if(flags=='banjiao'){ //半角
			banjiaoValZz(obj,values); 
		}
	}
	
	/** 联系电话：数字 空格 - ( ) */
	function lxdhValZz(obj,values){
		var val = values;
		values = quchuShuzi(values);
		values = quchuKongge(values);
		values = quchuHenggang(values);
		values = quchuZuoKuohao(values);
		values = quchuYouKuohao(values);
		noProblemSetContent(obj,values,val);
	}
	
	/** 暂住证：汉字 字母 数字 ( ) */
	function zzzbhValZz(obj,values){
		var val = values;
		values = quchuHanzi(values);
		values = quchuZimu(values);
		values = quchuShuzi(values);
		values = quchuZuoKuohao(values);
		values = quchuYouKuohao(values);
		noProblemSetContent(obj,values,val);
	}
	/** 护照：字母 数字 空格 - ( ) . 大写 */
	function hzbhValZz(obj,values){
		var val = values;
		values = quchuZimu(values);
		values = quchuShuzi(values);
		values = quchuKongge(values);
		values = quchuHenggang(values);
		values = quchuZuoKuohao(values);
		values = quchuYouKuohao(values);
		values = quchuDian(values);
		noProblemSetContent(obj,values,val);
	}
	/** 就业许可和签证：字母 数字 大写 */
	function jyxkValZz(obj,values){
		var val = values;
		values = quchuZimu(values);
		values = quchuShuzi(values);
		noProblemSetContent(obj,values,val);
	}
	/** 姓名等 中文 */
	function zhongwenValZz(obj,values){
		var val = values;
		values = quchuHanzi(values);
		noProblemSetContent(obj,values,val);
	}
	/** 姓名有关项 中文 字母 空格 */
	function xingmingValZz(obj,values){
		var val = values;
		values = quchuHanzi(values);
		values = quchuZimu(values);
		values = quchuKongge(values);
		noProblemSetContent(obj,values,val);
	}
	/** 批文号 汉字 数字 字母 半角 */
	function pwhValZz(obj,values){
		var val = values;
		values = quchuHanzi(values);
		values = quchuShuzi(values);
		values = quchuZimu(values);
		values = quchuBanjiao(values);
		noProblemSetContent(obj,values,val);
	}
	/** 数字 */
	function shuziValZz(obj,values){
		var val = values;
		values = quchuShuzi(values);
		noProblemSetContent(obj,values,val);
	}
	/** 半角 */
	function banjiaoValZz(obj,values){
		var val = values;
		values = quchuBanjiao(values);
		noProblemSetContent(obj,values,val);
	}
	function noProblemSetContent(obj,values,val){ //去掉可以输入的所有字符 仍然不为空则有问题
		if(values!=''){
			$("#"+obj).attr("value",val.replace(values,''));
		} else { } //不动了
	}
	//************************************输入验证 KeyUp事件
	function htjdOnBlurNotOnlyZfVal(obj,flags,guangbiaoFlags,tishiMes,upCharsFlag,fzifuFlag,qitaVal){
		htjdOnkeyupVal(obj,flags); //再验证一边：拖动鼠标拽数据不能验证 再此屏蔽此BUG
		var val = $("#"+obj).attr("value");
		var values = val;
		if(values!=''){ //不为空则验证
			if(fzifuFlag=='1'){ //非字符验证
				values = quchuTeshuZifu(values);
				guangbiaoTishi(values,obj,tishiMes,guangbiaoFlags);
			}
			if(upCharsFlag=='1'){ //转成大写
				upObjChars(obj,val);
			}
		}
		return true;
	}
	function quchuShuzi(values){
		return values = values.replace(/[\d]*/g,''); //去掉数字
	}
	function quchuHanzi(values){
		return values = values.replace(/[\u4e00-\u9fa5]*/g,''); //去掉汉字
	}
	function quchuZimu(values){
		return values = values.replace(/[a-zA-Z]*/g,''); //去掉字母
	}
	function quchuKongge(values){
		return values = values.replace(/[\s]*/g,''); //去掉空格
	}
	function quchuHenggang(values){
		return values = values.replace(/[-]*/g,''); //去掉-
	}
	function quchuDian(values){
		return values = values.replace(/[.]*/g,''); //去掉.
	}
	function quchuZuoKuohao(values){
		return values = values.replace(/[\u0028]*/g,''); //去掉(
	}
	function quchuYouKuohao(values){
		return values = values.replace(/[\u0029]*/g,''); //去掉)
	}
	function quchuQuanjiao(values){
		return values = values.replace(/[\uff00-\uffff]*/g,''); //去掉全角
	}
	function quchuBanjiao(values){
		return values = values.replace(/[\u0000-\u00ff]*/g,''); //去掉半角
	}
	function quchuBug(values){ //bug字符^： \u005E
		return values.replace(/[\u005E]*/g,'');
	}
	function quchuTeshuZifu(values){ //去除特殊字符
		values = quchuKongge(values);
		values = quchuHenggang(values);
		values = quchuZuoKuohao(values);
		values = quchuYouKuohao(values);
		values = quchuDian(values);
		return values;
	}
	function upChars(values){ //转成大写 
		return values.toUpperCase();
	}
	function upObjChars(obj,val){ //对象内容转成大写 
		$("#"+obj).attr("value",upChars(val));
	}
	function guangbiaoTishi(values,obj,tishiMes,guangbiaoFlags){
		if(values==''){ //去除掉所有字符为空说明全是字符
			if(guangbiaoFlags=='1'){ //指定光标
				jAlert(tishiMes+'不允许只输入符号','提示',null,''+obj);
			} else { //不指定区域
				jAlert(tishiMes+'不允许只输入符号','提示');
			}
			return false;
		}
	}
	
	//************************************返回日期字符串
	function backStrDate(d){
		var tempArr = new Array("00","01","02","03","04","05","06","07","08","09");
		var year = d.getFullYear();
		var mon = (d.getMonth()<9)?tempArr[d.getMonth()+1]:d.getMonth();
		var day = (d.getDate()<10)?tempArr[d.getDate()]:d.getDate();
		return year+'-'+mon+'-'+day;
	}