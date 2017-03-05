<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
		<h1>Listar Pacientes</h1>
			
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Data de Nascimento</th>
						<th>Excluir</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${pacientes}">
						<tr>
							<td>${p.id}</td>
							<td>${p.nome}</td>
							<td>
								<fmt:formatDate value="${p.dataNascimento}" pattern="dd/MM/yyyy" />
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/paciente/excluir.do?idPaciente=${p.id}">
									<input type="button" value="Excluir" class="btn btn-danger" />
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</html>
