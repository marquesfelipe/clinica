<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<tiles:insertDefinition name="template">
		<tiles:putAttribute name="corpo">
			<h1>${(consulta.dataAtendimento == null) ? "Realizar Atendimento" : "Visualizar Atendimento"}</h1>
			
			<springform:form method="post" action="${pageContext.request.contextPath}/consulta/atender.do" modelAttribute="consulta">
				<div style="width: 500px;">
  					Especialidade: ${consulta.medico.nome}
  					<br />
					Paciente: ${consulta.paciente.nome}
					<br />
					Data da Consulta: <fmt:formatDate value="${consulta.dataConsulta}" pattern="dd/MM/yyyy HH:mm" />
				</div>
				<br />
				<div style="width: 500px;">
					<div class="form-group">
						<label for="sintomas">Sintomas:</label>
						<springform:textarea id="sintomas" path="sintomas" readonly="${consulta.dataAtendimento != null}" cssClass="form-control" />
					</div>
					<div class="form-group">
						<label for="sintomas">Receita:</label>
						<springform:textarea id="receita" path="receita" readonly="${consulta.dataAtendimento != null}" cssClass="form-control" />
					</div>
				</div>
					
				<c:if test="${consulta.dataAtendimento == null}">
					<input type="submit" value="Gravar" class="btn btn-primary" />
				</c:if>
				<c:if test="${consulta.dataAtendimento != null}">
					<a href="${pageContext.request.contextPath}/cadastroAtendimentoPasso1.do">
						<input type="button" value="Voltar" class="btn btn-warning" />
					</a>
				</c:if>
				
				<springform:hidden path="id" />
				<springform:hidden path="dataConsulta" />
				<springform:hidden path="medico.id" />
				<springform:hidden path="paciente.id" />
			</springform:form>
		</tiles:putAttribute>
	</tiles:insertDefinition>
</html>