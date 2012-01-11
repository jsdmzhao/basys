var ieTuXingTitle = document.title;
$.fn.fusionChart = function(options){

	setting = {
		url:"",
		title:"Test",
		leftTitle:"",
		bottomTitle:"",
		subTitle:"",
		prefix:"p_",
		type:"bar",
		width:"400",
		height:"300",
		columns:[],
		rows:[],
		data:null,
		xtiaoyuehang:0,
		xzuobiaoCol:0,
		panduanlieIndex:null
	};
	var chartControl = this;
	setting = $.extend(setting,options);
	var url = setting.url;
	var charTable = setting.data;
	var columns = setting.columns;
	var chartType = setting.type;
	var title = setting.title;
	var xtiaoyuehang = eval(setting.xtiaoyuehang);
	var xzuobiaoCol = eval(setting.xzuobiaoCol);
	var panduanlieIndex = eval(setting.panduanlieIndex);
	var charXML;

	if(charTable!=null){
		switch(chartType){
			case 'bar':
				createBarChart();
				break;
			case 'line':
				createLineChart();
				break;
			case 'pie':
				createPieChart();
				break;
			default : 
				alert("统计图类型不正确！");
			return;
		}
		document.title=ieTuXingTitle;
	}

/*
<categories>
<category label='Austria' />
<category label='Brazil' />
<category label='France' />
<category label='Germany' /><category label='USA' />
</categories>
*/
	function getMultiChartHead(){
		var chartHead,headTitle="";
		var leftTitle = setting.leftTitle;
		var bottomTitle = setting.bottomTitle;
		if(title!=null && title!="")
			headTitle += " caption='"+title+"' ";
		if(leftTitle!=null && leftTitle!="")
			headTitle += " yAxisName='"+leftTitle+"' ";
		if(bottomTitle!=null && bottomTitle!="")
			headTitle += " xAxisName='"+bottomTitle+"' ";
		
		switch(chartType){
			case 'bar':
				chartHead = '<chart showBorder="1" bgColor="99CCFF,FFFFFF" bgAlpha="40,100" bgRatio="0,100" bgAngle="360" showCanvasBg="1" showCanvasBase="1" legendPosition="RIGHT"'+headTitle+'palette="1" showValues="0" yAxisValuesPadding="10" outCnvBaseFont="Arial" outCnvBaseFontSize="12" outCnvBaseFontColor="333333" showAboutMenuItem="0">';
				break;
			case 'line':
				var numvLine =0;
				if(columns.length==0)
					numvLine = charTable.find("tr:not(tr:first)").length-2;
				else
					numvLine = columns.length-2;
				if(numvLine<0)numvLine = 0;
				chartHead = '<chart bgColor="99CCFF,FFFFFF" bgAlpha="40,100" bgRatio="0,100" bgAngle="360" canvasPadding="4" legendPosition="RIGHT"'+headTitle+' lineThickness="1" showValues="0" formatNumberScale="0" anchorRadius="2" divLineAlpha="20" divLineColor="CC3300" showAlternateHGridColor="1" alternateHGridAlpha="5" alternateHGridColor="CC3300" shadowAlpha="40" numvdivlines="'+numvLine+'" chartRightMargin="35" bgColor="FFFFFF,CC3300" bgAngle="270" bgAlpha="10,10" outCnvBaseFont="Arial" outCnvBaseFontSize="12" outCnvBaseFontColor="333333" showAboutMenuItem="0">';
				break;
			case 'pie':
				chartHead = '<chart palette="4" decimals="0" enableSmartLabels="1"'+headTitle+'enableRotation="0" bgColor="99CCFF,FFFFFF" bgAlpha="40,100" bgRatio="0,100" bgAngle="360" showBorder="1" startingAngle="70" outCnvBaseFont="Arial" outCnvBaseFontSize="12" outCnvBaseFontColor="333333" showAboutMenuItem="0">';
				break;
		}
		
		return chartHead;
	}

	function getCategories(){
		var category = "<categories>";
		var length = charTable.find("tbody").find("tr").length;
		if(length>0){
			var categoryStr,quYuIndex=0;
			for(var index=0;index<length;index=index+xtiaoyuehang){    
			
				charTable.find("tbody").find("tr:nth("+index+")").find("td:nth("+xzuobiaoCol+")").each(function(){
					//categoryStr = "";
					//if((quYuIndex+1)%10==0){
						categoryStr = $(this).text();
					//}
					category += "<category label='"+categoryStr+"' />";
				});
				quYuIndex++;
			}

		}else if(length==0){
			
			charTable.find("th:not(th:first)").each(function(){
				category += "<category label='"+$(this).text()+"' />";
			});

		}
		category += "</categories>";
		
		return category;
	}

/*
<dataset seriesName='1997' color='F6BD0F' showValues='0'>
<set value='57401.85' />
<set value='41941.19' />
<set value='45263.37' />
<set value='117320.16' />
<set value='114845.27' />
</dataset>
*/
	function getDataSet(){
		var chartDataSet = "";
		var length = columns.length;
		if(length>0){
				charTable.find("tr:not(tr:first)").each(function(){
					chartDataSet += "<dataset seriesName='"+$(this).find("td:first").text()+"'>";
					var length = columns.length;
					for(var index=0;index<length;index++){

						$(this).find("td:nth("+columns[index]+")").each(function(i){
								chartDataSet += "<set value='"+$(this).text()+"' link='n-http://www.baidu.com' />";
						});
					}
					chartDataSet += "</dataset>";
				});

		}else if(length==0){
			charTable.find("tr:not(tr:first)").each(function(){
				chartDataSet += "<dataset seriesName='"+$(this).find("td:first").text()+"'>";

				$(this).find("td:not(td:first)").each(function(){
					chartDataSet += "<set value='"+$(this).text()+"' link='n-http://www.baidu.com' />";
				});

				chartDataSet += "</dataset>";
			});
		}

		return chartDataSet;
	}

	function getOnlySet(){
		var chartSet = "";
		var length = columns.length;
		if(length==1){
				charTable.find("tr:not(tr:first)").each(function(){
					var lable = $(this).find("td:first").text();
					var value = $(this).find("td:nth("+columns[0]+")").text();
					
					chartSet += "<set label='"+lable+"' value='"+value+"' />";
					
				});

		}
		return chartSet;
	}
	
	

	function createBarChart(){
		charXML = getMultiChartHead() + getCategories() + getDataSet() +"</chart>";

	   //var chart = new FusionCharts("Charts/Column3D.swf", "ChartId", "600", "350", "0", "0");
		var chart = new FusionCharts("Charts/MSColumn3D.swf", "ChartId", "600", "350", "0", "0");
		chart.setDataXML(charXML);		   
	   //myGrid.addVariable('showPercentValues', '1');	
		chart.render(chartControl.attr("id"));

	}

	function getLineDataSet(){
		var chartDataSet = "";
		var length = columns.length;// xtiaoyuehang
		if(length>0){
				var seriesName = "";
				charTable.find("tbody").find("tr:lt("+xtiaoyuehang+")").each(function(index){
					if(panduanlieIndex!=null){
						seriesName = $(this).find("td:first").text() + "(" + $(this).find("td:nth("+panduanlieIndex+")").text() + ")";
					}
					chartDataSet += "<dataset seriesName='"+seriesName+"'>";
					var length = charTable.find("tbody").find("tr").length;
					
					for(var forIndex = index;forIndex<length;forIndex=forIndex+xtiaoyuehang){

						charTable.find("tbody").find("tr:nth("+forIndex+")").find("td:nth("+columns[0]+")").each(function(i){
								chartDataSet += "<set value='"+$(this).text()+"' />";
						});
					}
					chartDataSet += "</dataset>";
				});

		}else if(length==0){
			charTable.find("tr:not(tr:first)").each(function(){
				chartDataSet += "<dataset seriesName='"+$(this).find("td:first").text()+"'>";

				$(this).find("td:not(td:first)").each(function(){
					chartDataSet += "<set value='"+$(this).text()+"' link='n-http://www.baidu.com' />";
				});

				chartDataSet += "</dataset>";
			});
		}

		return chartDataSet;
	}

	function createLineChart(){
		 charXML = '<chart caption="Daily Visits" subcaption="(from 8/6/2006 to 8/12/2006)" lineThickness="1" showValues="0" formatNumberScale="0" anchorRadius="2" divLineAlpha="20" divLineColor="CC3300" divLineIsDashed="1" showAlternateHGridColor="1" alternateHGridAlpha="5" alternateHGridColor="CC3300" shadowAlpha="40" labelStep="2" numvdivlines="5" chartRightMargin="35" bgColor="FFFFFF,CC3300" bgAngle="270" bgAlpha="10,10">'
						+'<categories>'
					  +'<category label="8/6/2006" />' 
					  +'<category label="8/7/2006" />' 
					  +'<category label="8/8/2006" />'  
					  +'<category label="8/9/2006" />' 
					  +'<category label="8/10/2006" />'  
					  +'</categories>'
					  +'<dataset seriesName="Offline Marketing">'
					  +'<set value="1327" />' 
					  +'<set value="1826" />' 
					  +'<set value="1699" />' 
					  +'<set value="1511" />' 
					  +'<set value="1904" />' 
					  +'<set value="1957" />' 
					  +'<set value="1296" />' 
					  +'</dataset>'
					  +'<dataset seriesName="Search">'
					  +'<set value="2042" />' 
					  +'<set value="3210" />' 
					  +'<set value="2994" />' 
					  +'<set value="3115" />' 
					  +'<set value="2844" />' 
					  +'<set value="3576" />' 
					  +'<set value="1862" />' 
					  +'</dataset>'
						+'<dataset seriesName="Paid Search">'
					  +'<set value="850" />' 
					  +'<set value="1010" />' 
					  +'<set value="1116" />' 
					  +'<set value="1234" />' 
					  +'<set value="1210" />' 
					  +'<set value="1054" />' 
					  +'<set value="802" />' 
					  +'</dataset>'
						+'<dataset seriesName="wwwww">'
					  +'<set value="850" />' 
					  +'<set value="1010" />' 
					  +'<set value="1116" />' 
					  +'<set value="1234" />' 
					  +'<set value="1210" />' 
					  +'<set value="1054" />' 
					  +'<set value="802" />' 
					  +'</dataset>'
						+'<dataset seriesName="qqqq">'
					  +'<set value="850" />' 
					  +'<set value="1010" />' 
					  +'<set value="1116" />' 
					  +'<set value="1234" />' 
					  +'<set value="1210" />' 
					  +'<set value="1054" />' 
					  +'<set value="802" />' 
					  +'</dataset>'
					  +'<styles>'
					  +'<definition>'
					  +'<style name="CaptionFont" type="font" size="12" />' 
					  +'</definition>'
					  +'<application>'
					  +'<apply toObject="CAPTION" styles="CaptionFont" />' 
					  +'<apply toObject="SUBCAPTION" styles="CaptionFont" />' 
					  +'</application>'
					  +'</styles>'
					  +'</chart>';
					 // alert(getLineDataSet());
		charXML = getMultiChartHead() + getCategories() + getLineDataSet() +"</chart>";
	   var chart = new FusionCharts("Charts/MSLine.swf",setting.chartId,setting.width, setting.height,"0", "0");
	   chart.setDataXML(charXML);		   
	   chart.render(chartControl.attr("id"));

	}

	function createPieChart(){
		 charXML = '<chart palette="4" decimals="0" enableSmartLabels="1" enableRotation="0" bgColor="99CCFF,FFFFFF" bgAlpha="40,100" bgRatio="0,100" bgAngle="360" showBorder="1" startingAngle="70">'
						 +' <set label="France" value="17" /> '
						 +' <set label="India" value="12" /> '
						 +' <set label="Brazil" value="18" /> '
						 +'<set label="USA" value="8" isSliced="1" /> '
						 +'<set label="Australia" value="10" isSliced="1" /> '
						 +' <set label="Japan" value="16" isSliced="1" /> '
						 +' <set label="England" value="11" /> '
						 +' <set label="Nigeria" value="12" /> '
						 +' <set label="Italy" value="8" /> '
						 +' <set label="China" value="10" /> '
						 +' <set label="Canada" value="19" /> '
						+'  <set label="Germany" value="15" /> '
						 +' <set label="Brazil" value="18" /> '
						 +'<set label="USA" value="8" isSliced="1" /> '
						 +'<set label="Australia" value="10" isSliced="1" /> '
						 +' <set label="Japan" value="16" isSliced="1" /> '
						 +' <set label="England" value="11" /> '
						 +' <set label="Nigeria" value="12" /> '
						 +' <set label="Italy" value="8" /> '
						 +' <set label="China" value="10" /> '
						 +' <set label="Canada" value="19" /> '
						+'  <set label="Germany" value="15" /> '
						 +' <set label="China" value="10" /> '
						 +' <set label="Canada" value="19" /> '
						+'  <set label="Germany" value="15" /> '
						 +' <set label="Brazil" value="18" /> '
						 +'<set label="USA" value="8" isSliced="1" /> '
						 +'<set label="Australia" value="10" isSliced="1" /> '
						 +' <set label="Japan" value="16" isSliced="1" /> '
						 +' <set label="England" value="11" /> '
						 +' <set label="Nigeria" value="12" /> '
						 +' <set label="Italy" value="8" /> '
						 +' <set label="China" value="10" /> '
						 +' <set label="Canada" value="19" /> '
						+'  <set label="Germany" value="15" /> '
						 +' </chart>';


		charXML = getMultiChartHead() + getOnlySet() +"</chart>";
		//alert(charXML);
	   var chart = new FusionCharts("Charts/Pie3D.swf", "ChartId", "600", "350", "0", "0");
	   chart.setDataXML(charXML);		   
	   chart.render(chartControl.attr("id"));

	   var myGrid = new FusionCharts("Charts/SSGrid.swf", "myGrid", "150", "350", "0", "0");
	   myGrid.setDataXML(charXML);		         
	   myGrid.addVariable('showPercentValues', '1');	         
	   myGrid.addVariable('numberItemsPerPage', '100');
	   myGrid.addVariable('showShadow', '0');
	   myGrid.render("ddddd");
	}

}