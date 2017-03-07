<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>



		<h1>Cadastrar Consulta</h1>
			
		 	<script type="text/javascript">
				function carregaMedicosDaEspecialidade() {
					$("select#medico option").remove();
					var selectMedicos = $('#medico');
					selectMedicos.append('<option value="">selecione</option>');
					
					if ($("#especialidade").val() != '') {
				 		$.ajax({
				  			type: "get",
				  			url: "${pageContext.request.contextPath}/medico/listarPorEspecialidade",
				  			data: 'especialidade=' + $("#especialidade").val(),
				  			success: function(medicos) {
			                    $.each(medicos, function(i, medico) {    
			                    	selectMedicos.append('<option value="' + medico.id + '">' + medico.nome + '</option>');
			                   	});
				  			},
				  			error: function() {
				  				alert("Erro ao pesquisar médicos pela especialidade");
				  			}
				 		});
					}
				}


		
								
				function checkDate(){
				    var campodata = $('#data').val();
				    var dataInformada = moment(campodata);
				    var now = moment();
				    var result = true; 
					if (dataInformada >= now) {
						result = false; 
					}else {
						alert("A data informada é Retroativa...\nInforme uma data Valida")
						$('#data').val(now.toDate());
					}
				}
			</script> 
			
			<springform:form method="post" action="${pageContext.request.contextPath}/consulta/agendar.do" modelAttribute="consulta">
				<div style="width: 300px;">
					<div class="form-group">
	  					<label for="especialidade">Especialidade:</label>
						<select id="especialidade" onchange="carregaMedicosDaEspecialidade();" class="form-control">
							<option value="">selecione</option>
							<c:forEach items="${especialidades}" var="e">
								<option value="${e}">${e.descricao}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">								
						<label for="medico">Médico:</label>
						<springform:select id="medico" path="medico.id" cssClass="form-control" required ="true">
							<option value="">selecione</option>
						</springform:select>
						<springform:errors path="medico" cssStyle="color:red;"/>
					</div>
					<div class="form-group">					
						<label for="paciente">Paciente:</label>
						<springform:select id="paciente" path="paciente.id" cssClass="form-control" required ="true">
							<option value="">selecione</option>
							<c:forEach items="${pacientes}" var="p">
								<option value="${p.id}">${p.nome}</option>
							</c:forEach>
						</springform:select>	
						<springform:errors path="medico" cssStyle="color:red;"/>
					</div>
					<div class="form-group">
						<label for="data">Data (DD/MM/AAAA):</label>
						<input id="data" type="date" name="data" maxlength="10" required ="true" class="form-control" onchange="checkDate();"/>
					</div>
					<div class="form-group">
						<label for="hora">Hora (HH:MM):</label>
						<input id="hora" type="time" name="hora" maxlength="5" required ="true" class="form-control" />
					</div>
				</div>
				<input type="submit" value="Gravar" class="btn btn-primary" />
			</springform:form>
	</html>