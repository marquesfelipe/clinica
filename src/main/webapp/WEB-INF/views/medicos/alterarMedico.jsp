<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="actionEditar" value="/medico/alterar"></c:url>
<h1>Alterar Médico</h1>
<form:form action="${actionEditar}" method="post"
	modelAttribute="medico">
		<div style="width: 300px;">
				<form:hidden path="id" />
					<div class="form-group">
	  					<label for="nome">Nome:</label>
  						<form:input id="nome" path="nome" cssClass="form-control" />
	  					<form:errors path="nome" cssStyle="color:red;"/>
	  				</div>
	  				<div class="form-group">
	  					<label for="username">Login:</label>
  						<form:input id="username" path="username" cssClass="form-control" />
  						<form:errors path="username" cssStyle="color:red;"/>
  					</div>
	  				<div class="form-group">
	  					<label for="password">Senha:</label>	  								
  						<form:password id="password" path="password" cssClass="form-control" />
	  					<form:errors path="password" cssStyle="color:red;"/>
	  				</div>	  				
	  				<div class="form-group">
	  					<label for="especialidade">Especialidade:</label>
  						<form:select id="especialidade" path="especialidade" cssClass="form-control">
							<option value="">selecione</option>
							<c:forEach items="${especialidades}" var="e">
								<option value="${e}">${e.descricao}</option>
							</c:forEach>
						</form:select>
					</div>
				</div>
	<input type="submit" value="Gravar" class="btn btn-primary"/>
</form:form>