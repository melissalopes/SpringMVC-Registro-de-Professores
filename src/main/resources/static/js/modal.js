$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	var btn = $(event.relatedTarget);
	
	var codigoProfessor = btn.data('codigo');
	var nomeProfessor = btn.data('nome');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	
	if(!action.endsWith('/')){
		action += '/';
	}
	
	form.attr('action', action + codigoProfessor);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o Professor <strong>' + nomeProfessor + '</strong>?');
});

$(function(){
	$('[rel="tooltip"]').tooltip();
	$('.js-currency').maskMoney({decimal: ',', thousands: '.', allowZero: true });
	
	$('.js-atualizar-status').on('click', function(event){
		event.preventDefault();
		
		var btnReceber = $(event.currentTarget);
		var urlReceber = btnReceber.attr('href');
		
		var response = $.ajax({
			url: urlReceber,
			type: 'PUT'
		});
		
		response.done(function(e){
			var codigoProfessor = btnReceber.data('codigo');
			$('[data-role=' + codigoProfessor + ']').html('<span class="label label-success">' + e + '</span>');
			btnReceber.hide();
		});
		
		response.fail(function(e){
			alert("ERRO!!");
		});
	});
	
});