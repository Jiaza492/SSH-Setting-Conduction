$(function(){
	
	$("#ajaxtable tr:even").addClass("odd");
	
	$("#ajaxtable tr").hover(function(){
		$(this).addClass("hove");
	},function(){
		$(this).removeClass("hove");
	});
	$("#buttonmenu").hover(function() {
		
		$("#buttontitle").animate({top: "-120"}, {duration:2000,easing:'easeOutExpo'}).show();
	}, function() {
		$("#buttontitle").animate({top: "-130"}, {duration:1000,easing:'easeOutExpo'}).hide();
	});
	
});
