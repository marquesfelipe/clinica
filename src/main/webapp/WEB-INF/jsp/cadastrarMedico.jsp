<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<tiles:insertDefinition name="template">
		<tiles:putAttribute name="corpo">
			<h1>Cadastrar Médico</h1>
			
			<springform:form method="post" action="${pageContext.request.contextPath}/medico/cadastrar.do" modelAttribute="medico">
				<div style="width: 300px;">
					<div class="form-group">
	  					<label for="nome">Nome:</label>
  						<springform:input id="nome" path="nome" cssClass="form-control" />
	  				</div>
	  				<div class="form-group">
	  					<label for="especialidade">Especialidade:</label>
  						<springform:select id="especialidade" path="especialidade" cssClass="form-control">
							<option value="">selecione</option>
							<c:forEach items="${especialidades}" var="e">
								<option value="${e}">${e.descricao}</option>
							</c:forEach>
						</springform:select>
					</div>
				</div>
				
				<input type="submit" value="Gravar" class="btn btn-primary" />
			</springform:form>
		</tiles:putAttribute>
	</tiles:insertDefinition>
</html>