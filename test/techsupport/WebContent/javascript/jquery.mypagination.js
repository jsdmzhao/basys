$.fn.mypagination = function(totalProperty,opts){
	opts = $.extend({
		perPage:10,
		currPage:1,
		callback:function(){
		}
	},opts||{});
		
	return this.each(function(){
		function numPages(){
			return Math.ceil(totalProperty/opts.perPage);
		}
 
		
		function selectPage(page){
			return function(){
				currPage = page;
				if (page<0) currPage = 0;
				if (page>=numPages()) currPage = numPages()-1;
				render();
 
				$('img.page-wait',panel).attr('src','images/wait.gif');
				opts.callback(currPage+1);
				$('img.page-wait',panel).attr('src','images/nowait.gif');
			}
		}
		
		function render(){
 
		    var html = '<table width="100%" border="0"><tbody><tr>' 
				+'<td  align="left" ><table width="100%" border="0" align="left" cellpadding="0" cellspacing="0">'
				+'<tr><td align="left">第'+opts.currPage+'页\/共'+numPages()+'页 \/共'+totalProperty+'条</td></tr></table></td>'
                +'<td align="left"></td><td align="right"><table width="100%" border="0" align="right" cellpadding="0" cellspacing="0">'
                +'<tr><td align="right"><a href="#"><img class="page-first"></a><a href="#"><img class="page-prev"></a></td>'
				+'<td align="right" width="60">第'+'<input type="text" id="imgpageno" class="page-num">页</td>'
				+'<td align="left" width="60"><a href="#"><img class="page-next"></a><a href="#"><img class="page-last"></a></td>'
			    +'</tr></table></td>'
				+'</tr></tbody></table>';
			var imgFirst = 'images/page-first-disabled.gif';
			var imgPrev = 'images/page-prev-disabled.gif';
			var imgNext = 'images/page-next-disabled.gif';
			var imgLast = 'images/page-last-disabled.gif';
			//if (currPage > 0){
				imgFirst = 'images/page-first.gif';
				imgPrev = 'images/page-prev.gif';
			//}
			//if (currPage < numPages()-1){
				imgNext = 'images/page-next.gif';
				imgLast = 'images/page-last.gif';
			//}
			panel.empty();
			panel.append(html);
			$('img.page-first',panel)
				.bind('click',selectPage(0))
				.attr('src',imgFirst);	
			$('img.page-prev',panel)
				.bind('click',selectPage(currPage-1))
				.attr('src',imgPrev);	
			$('img.page-next',panel)
				.bind('click',selectPage(currPage+1))
				.attr('src',imgNext);	
			$('img.page-last',panel)
				.bind('click',selectPage(numPages()-1))
				.attr('src',imgLast);
			$('input.page-num',panel)
				.val(currPage+1)
				.change(function(){
					selectPage($(this).val()-1)();
				});
		}
		
		var currPage = opts.currPage - 1;
		var panel = $(this);
		render();
 
	});
}