function carregaMedicosDaEspecialidade() {
	$("select#medico option").remove();
	var selectMedicos = $('#medico');
	selectMedicos.append('<option value="">selecione</option>');

	if ($("#especialidade").val() != '') {
		$
				.ajax({
					type : "get",
					url : "${pageContext.request.contextPath}/medico/listarPorEspecialidade",
					data : 'especialidade=' + $("#especialidade").val(),
					success : function(medicos) {
						$.each(medicos, function(i, medico) {
							selectMedicos.append('<option value="' + medico.id
									+ '">' + medico.nome + '</option>');
						});
					},
					error : function() {
						alert("Erro ao pesquisar médicos pela especialidade");
					}
				});
	}
}
