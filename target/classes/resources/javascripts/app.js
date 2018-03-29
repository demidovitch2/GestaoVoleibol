$(function() {
	$('.js-toggle').bind('click', function(event) {
		$('.js-sidebar, .js-conteudo').toggleClass('is-toggled');
		event.preventDefault();
	});	
});