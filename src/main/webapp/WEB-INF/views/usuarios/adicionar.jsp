<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="actionAdicionar" value="/usuarios/adicionar"></c:url>
<h2>Inserir Novo Usuário</h2>
<form:form action="${actionAdicionar}" method="post" modelAttribute="usuario">
	<div class="row">
		<div class="col-md-3">
			<div class="form-group">
				<label>Nome do Usuário: </label>
				<form:input path="username" cssClass="form-control"/>			
				<form:errors path="username" cssStyle="color:red;"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<div class="form-group">
				<label>Senha:</label>
				<form:password path="password" cssClass="form-control"/>
				<form:errors path="password" cssStyle="color:red;"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<div class="form-group">
				<label>Perfil:</label>
				<select name="role" class="form-control">
					<option value="ROLE_ADMIN">Administrador</option>
					<option value="ROLE_USER">Usuário Comum</option>
				</select>
			</div>
		</div>
	</div>
	<input type="submit" value="Gravar!" class="btn btn-default"/>
</form:form>