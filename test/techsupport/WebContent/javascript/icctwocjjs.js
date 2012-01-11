

/******************
  读卡返回部分信息
*****************/
function OpenRead(){
	document.getElementById('ctlICCard').ConnJava=content_connJava;
	document.getElementById('ctlICCard').ICCardDevice=content_deviceType;
	document.getElementById('ctlICCard').OpenRead();
}

/******************
  控件读卡返回部分信息的回调函数

*****************/
var fivecyrybh;
var xb3="";
var minzu4="";
var gj13="";
var hjsx7="";
var cardInfoArray= new Array();
var jspInfoArray= new Array();
var xml="";
var stringkongfalg="";
 function ReadICCardFinish(strValue)
      {  
     if(strValue.indexOf("$")>=0){
	     
	         jspInfoArray[0]='xingming'; 
	         jspInfoArray[1]='cyrybh';
	         jspInfoArray[2]='zjhm';
	         jspInfoArray[3]='xb';   
	         jspInfoArray[4]='minzu';  
	         //是否注销不显示[5]  
	         jspInfoArray[5]='zxbz'; 
	          
	         jspInfoArray[6]='csrq';
	         jspInfoArray[7]='hjsx';
	         jspInfoArray[8]='hjdxz';
	         jspInfoArray[9]='rjrq';
	         jspInfoArray[10]='zatlq';
	        
	         jspInfoArray[11]='ywx';
	         jspInfoArray[12]='ywm';
	         jspInfoArray[13]='gj';
	         //外国人就业许可证号 暂不显示
	         jspInfoArray[14]='wgrjyxkz';
	          //最近5次刷卡记录  暂不显示
	         jspInfoArray[15]= 'ickkh'
	         jspInfoArray[16]='fiveshakajilu';
	         jspInfoArray[17]= 'hjlbmc'
	         jspInfoArray[18]='cylb';
	         
					     cardInfoArray = strValue.split('$');
					     stringkongfalg =cardInfoArray[1];		     
					     if(stringkongfalg!=''){
					     fivecyrybh=cardInfoArray[1];
					     stringkongfalg="";
					      for(var i=0;i<cardInfoArray.length;i++){
						     //if((i!=5)&&(i!=14)&&(i!=15)){
						      if(i!=16){
						         if(i==5){
						        		 if(cardInfoArray[i]=='0'){
					                			sValue = '未注销';
							            	 }else if(cardInfoArray[i]=='1'){
							               		 sValue = '已注销';
							            	 }else	if(cardInfoArray[i]=='4'){
				                				sValue = '未注销';
							            	 }else{
							               		 sValue = '已注销';
							            	 }
						         }else if(i==6||i==9||i==10){
						         	//日期格式化
						          	sValue=timeFormat(jstrim(cardInfoArray[i]));
						         }else{
						           if(i==1 && cardInfoArray[i]==""){
						                  sValue= jstrim(cardInfoArray[14]);	
						           }else{
						            	sValue=jstrim(cardInfoArray[i]);
						            	 
						           }
						          	
						         }
						        
						         document.getElementById(jspInfoArray[i]).innerText=sValue;
						      
						     }
					     }	 
					     //将代码装换成显示名称
					 // codeChangeDisplayName(jstrim(cardInfoArray[3]),jstrim(cardInfoArray[4]),jstrim(cardInfoArray[13]),jstrim(cardInfoArray[7]),jstrim(cardInfoArray[1]));
            codeChangeDisplayName1(jstrim(cardInfoArray[3]),jstrim(cardInfoArray[4]),jstrim(cardInfoArray[13]),jstrim(cardInfoArray[7]));
           // var operXmlArray = cardInfoArray;
            
            //operXmlArray[3]= xb3;
           // operXmlArray[4]= minzu4;
           // operXmlArray[13]= gj13;
            //operXmlArray[7]= hjsx7;   
             
           }
       }  
          
      }
         
  function jstrim(s){   
    return  s.replace(/(^\s*)|(\s*$)/g,"");       
 } 
  
 
 //日期格式化函数
  function timeFormat(timeString){
  var  timeFormatString="";
	  if(timeString!=''){
	      var year=timeString.substring(0,4);
	      var month=timeString.substring(4,6);
	        var day=timeString.substring(6,8);
	       timeFormatString=year+'年'+month+'月'+day+'日';
	  }
  return timeFormatString;
  
  }
  
   //字典代码转换成显示名称
     ////应用新平台的ajax   
  function codeChangeDisplayName1(xb,minzu,gj,hjsx){
  
     	var sUrl="sysadmin/codeChangeDisplayName_dict_item.action";
     	var params={xb:xb,minzu:minzu,gj:gj,hjsx:hjsx};
     	jQuery.ajax({
			type: 'POST',
			url: sUrl,
			data: params,
			async: false,
			dataType: 'json',
			success: codeChangeDisplayNameResponse1
		});
       
  }
  
  ///新平台调用的方法
  function codeChangeDisplayNameResponse1(json){
  var displayNameInfo = json.result;
  if(displayNameInfo!=''){
   var displayNameArray = displayNameInfo.split(",|");
     document.getElementById('xb').innerText=displayNameArray[0];
      //document.getElementById('xb').style.color="#0000FF";
     xb3=displayNameArray[0];
     document.getElementById('minzu').innerText=displayNameArray[1];
      //document.getElementById('minzu').style.color="#0000FF";
     minzu4 = displayNameArray[1];
     document.getElementById('gj').innerText=displayNameArray[2];
      //document.getElementById('gj').style.color="#0000FF";
     gj13 = displayNameArray[2];
     document.getElementById('hjsx').innerText=displayNameArray[3];
     //document.getElementById('hjsx').style.color="#0000FF";
     hjsx7 = displayNameArray[3];
     xml="<Row>";    
     for (var j=0;j<cardInfoArray.length;j++){
        	//if(j!=5 && j!=14 && j!=15){
        	if(j!=16){
        	  if (j==3)
        	  	xml +="<"+jspInfoArray[j]+">"+ xb3+"</"+jspInfoArray[j]+">";	
        	  else if (j==4)
        	  	xml +="<"+jspInfoArray[j]+">"+ minzu4+"</"+jspInfoArray[j]+">";		
        	  else if (j==7)
        	  	xml +="<"+jspInfoArray[j]+">"+ hjsx7+"</"+jspInfoArray[j]+">";		
        	  else if (j==13)
        	  	xml +="<"+jspInfoArray[j]+">"+ gj13+"</"+jspInfoArray[j]+">";		
        	  else			
         	  	xml +="<"+jspInfoArray[j]+">"+ document.getElementById(jspInfoArray[j]).innerText+"</"+jspInfoArray[j]+">";
        	}
     }
     xml +="</Row>";
     
   if(typeof(fivefalg)=="unknown" || typeof(fivefalg)== "undefined"){
		     if(opener){ 
					if((typeof(window.opener.document)!="unknown") && (typeof(window.opener.document)!= "undefined")){ 
						if(typeof(opener.setXmlAddData)!="undefined" && typeof(opener.setXmlAddData)!="unknown"){
							opener.setXmlAddData(xml);
							window.focus();
						}else{	
					         setXmlAddData(xml);
					         }	   
					}else{	
					setXmlAddData(xml);
				    }	
			     }else{	
					setXmlAddData(xml);
			 }		
     }else{
     		 if(typeof(ryzcfalg)=="unknown" || typeof(ryzcfalg)== "undefined"){
     		    skjlslxxx(fivecyrybh);
     		 }
     }
	    
 } 
 
  return true;
 }
  