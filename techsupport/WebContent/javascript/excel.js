/*
*tableid：导出table的id
*MaxColumns:表的最大列数
*headCount：表头行数
*/
function expExcel(tableid,MaxColumns,headCount) {
    document.all(tableid).border = 1; 
    window.clipboardData.setData("Text",document.all(tableid).outerHTML);   
    try{   
        var ExApp = new ActiveXObject("Excel.Application"); 
    }catch(e){   
	    alert(e);
        alert("您的电脑没有安装Microsoft Excel软件！");   
        return false;  
    }    
    var ExWBk = ExApp.workbooks.add();   
    var ExWSh = ExWBk.worksheets(1);   
    var ExWCe = ExWBk.ActiveSheet; 
    ExApp.DisplayAlerts = false;  
    ExApp.visible = true;  
    ExApp.UserControl = true; 

    ExWSh.Paste; 
    ExWCe.Range( ExWCe.Cells(1,1),ExWCe.Cells(headCount,MaxColumns)).Font.Name="黑体";
    ExWCe.Range( ExWCe.Cells(1,1),ExWCe.Cells(headCount,MaxColumns)).Font.Bold=true;
    ExWCe.Range( ExWCe.Cells(1,1),ExWCe.Cells(headCount,MaxColumns)).Font.Size=14;
    
    ExWCe.Columns.AutoFit;
    ExWCe.Columns.NumberFormatLocal="##############";
    ExWCe.Columns.NumberFormatLocal="0";
    //ExWCe.Range( ExWCe.Cells(1,1),ExWCe.Cells(1,MaxColumns)).HorizontalAlignment =-4108;  
    document.all(tableid).border = 0;
}

function expExcel2(tableid,MaxColumns,headCount,delInfo) {
    window.clipboardData.setData("Text",document.all(tableid).outerHTML);   
    try{   
        var ExApp = new ActiveXObject("Excel.Application"); 
    }catch(e){   
	    alert(e);
        alert("请正确安装Microsoft Excel软件或设置IE的安全选项！");   
        return false;  
    }    
    var ExWBk = ExApp.workbooks.add();   
    var ExWSh = ExWBk.worksheets(1);   
    var ExWCe = ExWBk.ActiveSheet; 
    ExApp.DisplayAlerts = false;  
    ExApp.visible = true;  
    ExApp.UserControl = true; 

    //ExWSh.Paste;
    ExWSh.Selection.PasteSpecial();
    if(delInfo!=0){
        ExWSh.Columns(delInfo).Clear;
    }
    ExWSh.Rows("1:1").Delete;
    ExWCe.Range( ExWCe.Cells(1,1),ExWCe.Cells(headCount,MaxColumns)).Font.Name="黑体";
    ExWCe.Range( ExWCe.Cells(1,1),ExWCe.Cells(headCount,MaxColumns)).Font.Bold=true;
    ExWCe.Range( ExWCe.Cells(1,1),ExWCe.Cells(headCount,MaxColumns)).Font.Size=14;
    ExWCe.Range( ExWCe.Cells(1,1),ExWCe.Cells(ExWSh.Rows.Count,MaxColumns)).Borders.LineStyle=1;
    
    ExWCe.Columns.AutoFit;
    ExWCe.Columns.NumberFormatLocal="##############";
    ExWCe.Columns.NumberFormatLocal="0";
    //ExWCe.Range( ExWCe.Cells(1,1),ExWCe.Cells(1,MaxColumns)).HorizontalAlignment =-4108;  
}