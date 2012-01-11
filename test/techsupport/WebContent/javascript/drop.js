
document.onclick=hideDrop;
var fld1,fld2,fld3;
var frameName;
function showDrop(sImg,sFld1,sFld2)
{
	var cf=document.getElementById(frameName);
	var oImg=document.getElementById(sImg);
	if(!oImg){alert("控制对象不存在！");return;}
	if(!sFld1){alert("输入控件未指定！");return;}
	fld1=document.getElementById(sFld1);
	if(!fld1){alert("输入控件不存在:"+sFld1);return;}
	if(fld1.tagName!="INPUT"||fld1.type!="text"){alert("输入控件类型错误:"+sFld1);return}
	if(sFld2!=null)
	{
		fld2=document.getElementById(sFld2);
		if(!fld2){alert("值控件不存在:"+sFld2);return;}
		if(fld2.tagName!="INPUT"){alert("值控件类型错误："+sFld2);return;}
	}

	if(!window.frames[frameName].bCalLoaded){alert("未成功装载！请刷新页面！");return;}
	if(cf.style.display=="block"){cf.style.display="none";return;}

	var eT=0,eL=0,p=oImg;
	var sT=document.body.scrollTop,sL=document.body.scrollLeft;
	var eH=oImg.height,eW=oImg.width;
	while(p&&p.tagName!="body"){eT+=p.offsetTop;eL+=p.offsetLeft;p=p.offsetParent;}
	cf.style.top=(document.body.clientHeight-(eT-sT)-eH>=cf.height)?eT+eH:eT-cf.height;
	cf.style.left=(document.body.clientWidth-(eL-sL)>=cf.width)?eL:eL+eW-cf.width;
	cf.style.display="block";

}
function hideDrop()
{
	var cf=document.getElementById(frameName);
	cf.style.display="none";
}
