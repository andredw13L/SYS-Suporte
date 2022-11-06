<%@page import="br.com.suporte.jdbc.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1" />
		<link  rel="stylesheet"  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"  integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"  crossorigin="anonymous">
		<title>Alterar Cliente</title>
		
		<script type="text/javascript">
			function validacao(){
				var formulario = document.forms["formcadastro"];
				var nome = formulario.txtnome.value;
				var cpf = formulario.txtcpf.value;
				var endereco = formulario.txtendereco.value;
				var num_Endereco = formulario;
				var cep = formulario.txtcep.value;
				var ddd = formulario.txtddd.value;
				var tel = formulario.txttelefone.value;
				var email = formulario.txteMail.value;
				var data = formulario.txtdataSuporte.value;
				var atendimento = formulario.radiotipoAtendimento.value;
				
				if (nome.indexOf(" ") == -1){
					
					alert("Preencha o nome por completo")
					erro = true;
					
				}else {
					
					if (cpf.Cliente.validaCPF(cpf) == true) {
						
						alert("passei soooo")
						erro = true;
						
					}else {
						
						alert("Ops!!! Esse CPF é invalido!")
						erro = true;
					}
				}
			
				if (erro){
					return false;
				}else {
					return true;
				}
			}
			
		</script>
	</head>
	<body>
	<br>
	
		<div class="container">
		<div class="card-home">
		<div class="card">
		<div class="card-header">
		
		<center><h2>Cadastro do Cliente</h2></center>
			
			<form name="formcadastro" action="entrada" method="post" onsubmit="return validacao()" >
				
				
		<div class="form-group">
				
				<label>Código :</label>
				<input class="form-control" type="text" name="txtcodigo" value="${cliente.codigo}" size="60" readonly />
				<label>Nome :</label>
				<input class="form-control" type="text" name="txtnome" value="${cliente.nome}" size="60" />
				<label>CPF :</label>
				<input class="form-control" type="number" name="txtcpf" value="${cliente.cpf}" size="14" />
				<label>Endereço :</label>
				<input class="form-control" type="text" name="txtendereco" value="${cliente.endereco}" size="30" />
				<label>Nº Endereço :</label>
				<input class="form-control" type="number" name="txtnumEndereco" value="${cliente.numEndereco}" size="5" />
				<label>CEP :</label>
				<input class="form-control" type="text" name="txtcep" value="${cliente.cep}" size="10" />
				<label>DDD :</label>
				<input class="form-control" type="text" name="txtddd" value="${cliente.ddd}" size="3" />
				<label>Telefone :</label>
				<input class="form-control" type="text" name="txttelefone" value="${cliente.telefone}" size="11" />
				<label>E_Mail :</label>
				<input class="form-control" type="text" name="txteMail" value="${cliente.email}" size="45" />
				<label>Data :</label>
				<input class="form-control" type="text" name="txtdataSuporte" value="${cliente.dataSuporte}" size="11" /><br />
				<label>Atendimento :&nbsp;&nbsp;</label>
				Presencial <input type="radio" name="radiotipoAtendimento" value="Presencial" checked="checked" size="8" />&nbsp;&nbsp;&nbsp;
				Remoto <input type="radio" name="radiotipoAtendimento" value="Remoto" size="8" /><br />
				
				<input type="hidden" name="txtacao" value="alterar"><br />
				<input type="submit" value="Salvar Chamado" />
				<script> alert('RESGATANDO DADOS! ');</script>
				
			</form>
		</div>
	</body>
</html>