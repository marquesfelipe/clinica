<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand">Clinica</a>
		</div>

		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal" var="principal" />
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Medicos <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<sec:authorize access="hasRole('ROLE_ADMIN')">						
						<li><a
							href="${pageContext.request.contextPath}/preparaCadastroMedico">Cadastrar</a></li>
						</sec:authorize>
						<li><a
							href="${pageContext.request.contextPath}/medico/listar">Listar</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Pacientes <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<sec:authorize access="hasRole('ROLE_ADMIN')">						
						<li><a
							href="${pageContext.request.contextPath}/preparaCadastroPaciente">Cadastrar</a></li>
						</sec:authorize>
						<li><a
							href="${pageContext.request.contextPath}/paciente/listar">Listar</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav">
				<li><a
					href="${pageContext.request.contextPath}/preparaCadastroConsulta">Marcar
						Consulta</a></li>
			</ul>
			<ul class="nav navbar-nav">
				<li><a
					href="${pageContext.request.contextPath}/preparaCadastroAtendimento">Realizar
						/ Visualizar Atendimento</a></li>
			</ul>
			<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Bem-vindo, ${principal.username}&nbsp &nbsp<span class="glyphicon glyphicon-user"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/clinica/logout">Sair</a></li>
						</ul></li>
				</ul>
		</div>
			</sec:authorize>
	</div>
</nav>
<c:if test="${mensagem != null}">
	<div class="${mensagem.tipoMensagem.classeCss}" role="alert">${mensagem.texto}</div>
</c:if>