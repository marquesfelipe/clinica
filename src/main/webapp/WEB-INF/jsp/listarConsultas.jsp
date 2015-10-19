<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<tiles:insertDefinition name="template">
		<tiles:putAttribute name="corpo">
			<h1>Listar Consultas do Paciente</h1>
			
			<script type="text/javascript">
				function carregaConsultasPorPaciente(){
					$("#lista_consultas").hide();
					$("#sem_consultas").hide();
					
					if ($("#paciente").val() != '') {
				 		$.ajax({
				  			type: "get",
				  			url: "${pageContext.request.contextPath}/consulta/listarPorPaciente.do",
				  			data: 'idPaciente=' + $("#paciente").val(),
				  			success: function(consultas) {
				  				if (consultas.length == 0) {
				  					$("#sem_consultas").show();
				  				} else {
				  					$("#lista_consultas").show();
				  					$("#tabela_consultas tbody tr").remove();
				  					var dataConsulta;
				  					var dataAtendimento;
				  					
				  					$.each(consultas, function(i, consulta) {
				  						dataConsulta = new Date(consulta.dataConsulta);
			  							dataAtendimento = consulta.dataAtendimento == null ? null : new Date(consulta.dataAtendimento);
				  						
										$("#tabela_consultas tbody").append(
								        	"<tr>"+
									        	"<td>" + consulta.medico.nome + "</td>" +
									        	"<td>" + formataData(dataConsulta) + "</td>" +
									        	"<td>" + formataData(dataAtendimento) + "</td>" +
									        	"<td>" +
									        		"<a href=${pageContext.request.contextPath}/consulta/detalharConsulta.do?idConsulta=" + consulta.id + ">" +
									        			"<input type=\"button\" value=\"Selecionar\" class=\"btn btn-success\" />" +
							        				"</a>" + 
									        	"</td>" +
									        "</tr>"
										);
									});					  					
				  				}
				  			},
				  			error: function() {
				  				alert("Erro ao pesquisar consultas do paciente");
				  			}
				 		});
					}
				}
				
				function formataData(d) {
					if (d == null) {
						return '';
					}
				  	var dia = d.getDate();
				  	var mes = d.getMonth() + 1;
				  	var hora = d.getHours();
				  	var minuto = d.getMinutes();

				  	return (dia < 10 ? '0' + dia : dia) + '/' + (mes < 10 ? '0' + mes : mes) + '/' + d.getFullYear() + ' ' + (hora < 10 ? '0' + hora : hora) + ':' + (minuto < 10 ? '0' + minuto : minuto);
				}
			</script>
			
			<div style="width: 300px;">
				<div class="form-group">
					<label for="paciente">Paciente:</label>
					<select id="paciente" onchange="carregaConsultasPorPaciente();" class="form-control">
						<option value="">selecione</option>
						<c:forEach items="${pacientes}" var="p">
							<option value="${p.id}">${p.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>											
			
			<div id="sem_consultas" style="display: none;">
				<p>&nbsp;</p>
				<span style="color: red">Paciente sem consultas</span>
			</div>
			
			<div id="lista_consultas" style="display: none;">
				<table class="table" id="tabela_consultas">
					<thead>
						<tr>
							<th>Médico</th>
							<th>Data da Consulta</th>
							<th>Data do Atendimento</th>
							<th>Selecionar</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</tiles:putAttribute>
	</tiles:insertDefinition>
</html>
