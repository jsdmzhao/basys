// JavaScript Document
function show_tab(id)
{
    for(var n=1;n<=3;n++)
	{document.getElementById('tab_'+n).style.display='none';}
     document.getElementById(id).style.display='block';
}

