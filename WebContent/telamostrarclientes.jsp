<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar Clientes</title>
<link  rel="stylesheet"  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"  integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"  crossorigin="anonymous">

</head>
<body>

	<br><center><h2>Lista de Clientes</h2>
    
	
	<br><a href="entrada?acao=incluir"><button type="button" class="btn btn-primary"> Cadastrar Novo Cliente</button></a><br><br></center>
	
	<table border="1">
		<thead>
		   <table class="table table-hover">
             <thead>
                <tr>
				<th>Código</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Endereço</th>
				<th>Nº Endereço</th>
				<th>CEP</th>
				<th>DDD</th>
				<th>Telefone</th>
				<th>Email</th>
				<th>Suporte</th>
				<th>Atendimento</th>
				<th colspan="2">Ação</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cliente" items="${clientes}">
				<tr>
					<td>${cliente.codigo }</td>
					<td>${cliente.nome }</td>
					<td>${cliente.cpf }</td>
					<td>${cliente.endereco }</td>
					<td>${cliente.numEndereco }</td>
					<td>${cliente.cep }</td>
					<td>${cliente.ddd }</td>
					<td>${cliente.telefone }</td>
					<td>${cliente.email }</td>
					<td>${cliente.dataSuporte }</td>
					<td>${cliente.tipoAtendimento }</td>
					<td><a href="entrada?acao=alterar&codigo=${cliente.codigo}">Alterar</a></td>
					<td><a href="entrada?acao=excluir&codigo=${cliente.codigo}">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>