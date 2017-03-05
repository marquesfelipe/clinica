<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<h1>Cadastrar Paciente</h1>
			
			<springform:form method="post" action="${pageContext.request.contextPath}/paciente/cadastrar.do" modelAttribute="paciente">
				<div style="width: 300px;">
					<div class="form-group">
	  					<label for="nome">Nome:</label>
						<springform:input id="nome" path="nome" cssClass="form-control" />
					</div>
					<div class="form-group">
	  					<label for="username">Login:</label>
  						<springform:input id="username" path="username" cssClass="form-control" />
	  				</div>
	  				<div class="form-group">
	  					<label for="password">Senha:</label>	  								
  						<springform:password id="password" path="password" cssClass="form-control" />
	  				</div>	 
					<div class="form-group">
						<label for="data">Data de Nascimento (DD/MM/AAAA):</label>
						<input id="data" type="date" name="data" maxlength="10" class="form-control" />
					</div>
				</div>
						
				<input type="submit" value="Gravar" class="btn btn-primary" />
			</springform:form>
	</html>
