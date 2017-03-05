<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>Listagem de Usuários</h2>
<br />	
<table class="table" id="tbl-musicas">
	<thead>
		<th>ID</th>
		<th>Nome do Usuário</th>
		<th>Role</th>
	</thead>
	<tbody>
		<c:if test="${!empty usuarios}"></c:if>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuario.idUsuario}</td>
				<td>${usuario.username}</td>
				<td>${usuario.role}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br />
<a href="/treinaweb-spring-mvc/usuarios/adicionar" class="btn btn-default">Adicionar novo Usuário</a>