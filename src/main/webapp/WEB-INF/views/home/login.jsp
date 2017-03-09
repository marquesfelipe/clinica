<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:url value="/resources/css/estiloLogin.css" var="estiloLogin"></spring:url>
<link href="${estiloLogin}" rel="stylesheet">
<spring:url value="/resources/js/jquery.validate.min.js" var="jvalidate"></spring:url>
<script type="text/javascript" src="${jvalidate}"></script>
 <script>
    $(function(){
        $("#form-login").validate({
            rules : {
            	username : {
                    required : true
                },
                password : {
                    required : true,
                }
            },
            messages : {
            	username : {
                    required : "Por favor, informe seu nome de usuário."
                },
                password : {
                    required : "Informe uma senha.",
                },
           }
        });
    });
    </script>



<br />
<div id="form-container">
	<div class="panel" id="form-box">
		<form action="/clinica/login" method="post" id="form-login">

			<div class="form-group">
				<label>Nome do Usuário: </label> <input type="text" name="username"
					class="form-control" autofocus>
			</div>


			<div class="form-group">
				<label>Senha:</label> <input type="password" name="password"
					class="form-control">
			</div>
			
			<div class="form-group">
				<input type="submit" value="Acessar"
					class="btn btn-success form-control btn-xs" />
			</div>
		</form>
	</div>
</div>
