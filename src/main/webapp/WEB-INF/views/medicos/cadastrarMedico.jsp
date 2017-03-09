<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="springform"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<h1>Cadastrar Médico</h1>

<springform:form method="post"
	action="${pageContext.request.contextPath}/medico/cadastrar"
	modelAttribute="medico">
	<div style="width: 300px;">
		<div class="form-group">
			<label for="nome">Nome:</label>
			<springform:input id="nome" path="nome" cssClass="form-control" />
			<springform:errors path="nome" cssStyle="color:red;" />
		</div>
		<div class="form-group">
			<label for="username">Login:</label>
			<springform:input id="username" path="username"
				cssClass="form-control" />
			<springform:errors path="username" cssStyle="color:red;" />
		</div>
		<div class="form-group">
			<label for="password">Senha:</label>
			<springform:password id="password" path="password"
				cssClass="form-control" />
			<springform:errors path="password" cssStyle="color:red;" />
		</div>
		<div class="form-group">
			<label for="especialidade">Especialidade:</label>
			<springform:select id="especialidade" path="especialidade"
				cssClass="form-control">
				<option value="">selecione</option>
				<c:forEach items="${especialidades}" var="e">
					<option value="${e}">${e.descricao}</option>
				</c:forEach>
			</springform:select>
		</div>
	</div>

	<button class="btn btn-success btn-xs">
		Gravar <span class="glyphicon glyphicon-plus"></span>
	</button>
</springform:form>
</html>