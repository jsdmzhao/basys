<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>


<body>
<%@include file="../../public/includeImageKJ.jsp" %>
</body>

<script type="text/javascript">
function getFile(){
	//得到图片Base64
	var Pic = ctlPicture1.GetImage();
	//把Pic付给bean的隐藏变量
	$("#"+fileId).val(Pic);
}

function setFile(){
	ctlPicture1.SetCommonImage(fileData);
}
	
//初始化图像控件
	ctlPicture1.InitPicture();
	//设置图像模式 1为摄像头取像,0为路径取像
	//ctlPicture1.photomode = 0;
	ctlPicture1.photomode = 0;
	//设置路径
	ctlPicture1.SetImagePath="C:/fileload";
	
 	//设置图片
 	//ctlPicture1.SetCommonImage("");
</script>