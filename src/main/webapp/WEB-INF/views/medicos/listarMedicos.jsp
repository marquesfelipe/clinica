<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<h1>Listar M�dicos</h1>

<table class="table">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Especialidade</th>
			<th>Alterar</th>
			<th>Excluir</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="m" items="${medicos}">
			<tr>
				<td>${m.id}</td>
				<td>${m.nome}</td>
				<td>${m.especialidade.descricao}</td>
				<td><a
					href="${pageContext.request.contextPath}/medico/alterar/+${m.id}">
                            <button class="btn btn-danger  btn-xs">
								Alterar <span class="glyphicon glyphicon-edit"></span>
							</button>      
				</a></td>
				<td><a
					href="${pageContext.request.contextPath}/medico/excluir?idMedico=${m.id}">
						 <button class="btn btn-primary btn-xs">
								Excluir <span class="glyphicon glyphicon-remove"></span>
							</button>   
				</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</html>
