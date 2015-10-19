<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<tiles:insertDefinition name="template">
		<tiles:putAttribute name="corpo">
			<h1>Listar Médicos</h1>
			
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Especialidade</th>
						<th>Excluir</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="m" items="${medicos}">
						<tr>
							<td>${m.id}</td>
							<td>${m.nome}</td>
							<td>${m.especialidade.descricao}</td>
							<td>
								<a href="${pageContext.request.contextPath}/medico/excluir.do?idMedico=${m.id}">
									<input type="button" value="Excluir" class="btn btn-danger" />
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</tiles:putAttribute>
	</tiles:insertDefinition>
</html>
