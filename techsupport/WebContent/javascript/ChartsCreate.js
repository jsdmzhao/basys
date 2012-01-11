var ieTuXingTitle = document.title;
$.fn.fusionChart = function(options){

	var setting = {
		chartId:"chartId",
		title:"Test",
		subTitle:"",
		prefix:"p_",
		type:"bar",
		width:"400",
		height:"300",
		columns:[],
		rows:[],
		isTotal:false,
		data:null
	};
	var chartControl = this;
	setting = $.extend(setting,options);
	var charTable = setting.data;
	var columns = setting.columns;
	var chartType = setting.type;
	var title = setting.title;
	var charXML;
	var notColumn=1;
	if(!setting.isTotal)
		notColumn=2;

	if(charTable!=null){
		switch(chartType){
			case 'bar':
				createBarChart();
			case 'barC':
				createBarChartC();
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
		tuXingChaJianTitle();
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
		var chartHead;
		switch(chartType){
			case 'bar':
				chartHead = '<chart formatNumberScale="0" showBorder="1" bgColor="99CCFF,FFFFFF" bgAlpha="40,100" bgRatio="0,100" bgAngle="360" showCanvasBg="1" showCanvasBase="1" legendPosition="RIGHT" caption="'+title+'" palette="1" showValues="0" yAxisValuesPadding="10" outCnvBaseFont="Arial" outCnvBaseFontSize="12" outCnvBaseFontColor="333333" showAboutMenuItem="0">';
				break;
			case 'line':
				var numvLine =0;
				if(columns.length==0)
					numvLine = charTable.find("tr:not(tr:first)").length-2;
				else
					numvLine = columns.length-2;
				if(numvLine<0)numvLine = 0;
				chartHead = '<chart bgColor="99CCFF,FFFFFF" bgAlpha="40,100" bgRatio="0,100" bgAngle="360" canvasPadding="20" legendPosition="RIGHT" caption="'+title+'" subcaption="(from 8/6/2006 to 8/12/2006)" lineThickness="1" showValues="0" formatNumberScale="0" anchorRadius="2" divLineAlpha="20" divLineColor="CC3300" showAlternateHGridColor="1" alternateHGridAlpha="5" alternateHGridColor="CC3300" shadowAlpha="40" numvdivlines="'+numvLine+'" chartRightMargin="35" bgColor="FFFFFF,CC3300" bgAngle="270" bgAlpha="10,10" outCnvBaseFont="Arial" outCnvBaseFontSize="12" outCnvBaseFontColor="333333" showAboutMenuItem="0">';
				break;
			case 'pie':
				chartHead = '<chart formatNumberScale="0" palette="4" decimals="0" enableSmartLabels="1" caption="'+title+'" enableRotation="0" bgColor="99CCFF,FFFFFF" bgAlpha="40,100" bgRatio="0,100" bgAngle="360" showBorder="1" startingAngle="70" outCnvBaseFont="Arial" outCnvBaseFontSize="12" outCnvBaseFontColor="333333" showAboutMenuItem="0">';
				break;
		}
		
		return chartHead;
	}

	function getCategories(){
		var category = "<categories>";
		var length = columns.length;
		if(length>0){
			for(var index=0;index<length;index++){
				charTable.find("th:nth("+columns[index]+")").each(function(){
					category += "<category label='"+$(this).text()+"' />";
				});
			}

		}else if(length==0){
			
			charTable.find("th:not(th:first)").each(function(){
				category += "<category label='"+$(this).text()+"' />";
			});

		}
		category += "</categories>";

		return category;
	}

	function getCategoriesBarC(){
		var category = "<categories>";
		var length = columns.length;
		if(length>0){
			for(var index=0;index<length;index++){
				charTable.find("th:nth("+columns[index]+")").each(function(){
					category += "<category label='"+$(this).text()+"' />";
				});
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

						$(this).find("td:not(td:first)").each(function(i){
							if((index+1)==i)
								chartDataSet += "<set value='"+$(this).text()+"' />";
						});
					}
					chartDataSet += "</dataset>";
				});

		}else if(length==0){
			charTable.find("tr:not(tr:first)").each(function(){
				chartDataSet += "<dataset seriesName='"+$(this).find("td:first").text()+"'>";
				$(this).find("td:not(td:first)").each(function(){
					
					chartDataSet += "<set value='"+$(this).text()+"' />";
				});

				chartDataSet += "</dataset>";
			});
		}

		return chartDataSet;
	}
	
	function getDataSetBarC(){
		var chartDataSet = "";
		var length = columns.length;
		if(length>0){
				charTable.find("tr:not(tr:lt("+notColumn+"))").each(function(){
					chartDataSet += "<dataset seriesName='"+$(this).find("td:first").text()+"'>";
					var length = columns.length;
					for(var index=0;index<length;index++){
						 var columnTd = $(this).find("td:nth("+columns[index]+")");
						 chartDataSet += "<set value='"+columnTd.text()+"' />";
					}
					chartDataSet += "</dataset>";
				});

		}else if(length==0){
			charTable.find("tr:not(tr:lt("+notColumn+"))").each(function(){
				chartDataSet += "<dataset seriesName='"+$(this).find("td:first").text()+"'>";
				$(this).find("td:not(td:first)").each(function(){
					chartDataSet += "<set value='"+$(this).text()+"'/>";
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
			var lable, value;
				charTable.find("tr:not(tr:lt("+notColumn+"))").each(function(){
					lable = $(this).find("td:first").text();
					value = $(this).find("td:nth("+columns[0]+")").text();
					//if(value!=0){
						chartSet += "<set label='"+lable+"' value='"+value+"' />";
					//}
					
				});

		}
		return chartSet;
	}

	function createBarChart(){
		charXML = getMultiChartHead() + getCategories() + getDataSetBarC() +"</chart>";
	   //var chart = new FusionCharts("Charts/Column3D.swf", "ChartId", "600", "350", "0", "0");
		var chart = new FusionCharts("Charts/MSColumn3D.swf", setting.chartId,setting.width, setting.height, "0", "0");
		chart.setDataXML(charXML);		   
		chart.render(chartControl.attr("id"));

	}

	function createBarChartC(){
		charXML = getMultiChartHead() + getCategoriesBarC() + getDataSetBarC() +"</chart>";
	   //var chart = new FusionCharts("Charts/Column3D.swf", "ChartId", "600", "350", "0", "0");
		var chart = new FusionCharts("Charts/MSColumn3D.swf", setting.chartId,setting.width, setting.height, "0", "0");
		chart.setDataXML(charXML);		   
		chart.render(chartControl.attr("id"));

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
					  
		charXML = getMultiChartHead() + getCategories() + getDataSet() +"</chart>";
	   var chart = new FusionCharts("Charts/MSLine.swf", setting.chartId,setting.width, setting.height, "0", "0");
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
	   var chart = new FusionCharts("Charts/Pie3D.swf", setting.chartId,setting.width, setting.height, "0", "0");
	   chart.setDataXML(charXML);		   
	   chart.render(chartControl.attr("id"));

//	   var myGrid = new FusionCharts("Charts/SSGrid.swf", "myGrid", "150", "350", "0", "0");
//	   myGrid.setDataXML(charXML);		         
//	   myGrid.addVariable('showPercentValues', '1');	         
//	   myGrid.addVariable('numberItemsPerPage', '100');
//	   myGrid.addVariable('showShadow', '0');
//	   myGrid.render("ddddd");
	}
}
function tuXingChaJianTitle(){
	var sheZhiTitle = setTimeout(function(){
		if(ieTuXingTitle==null || ieTuXingTitle=="")
			ieTuXingTitle = location.href;
		document.title=ieTuXingTitle;
		sheZhiTitle = null;
	},100);
}