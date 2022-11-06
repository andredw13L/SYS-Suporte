<%@page import="br.com.suporte.jdbc.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link  rel="stylesheet"  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"  integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"  crossorigin="anonymous">
		<title>Cadastro do Cliente</title>
		
		<script type="text/javascript">
			function validacao(){
				var formulario = document.forms["formcadastro"];
				var nome = formulario.txtnome.value;
				var cpf = formulario.txtcpf.value;
				var endereco = formulario.txtendereco.value;
				var numEndereco = formulario.txtnumEndereco.value;
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
					
					if (cpf.length != 11){
						alert("Erro, preencha o CPF corretamente!")
						erro = true;
					}else {
						
						if (endereco.length <5){
							alert("Preencha o endereço corretamente! ")
							erro = true;
						}else {
							
							if (numEndereco.length <1 || numEndereco.length >5){
								alert("Nº de Endereço invalido! ")
								erro = true;
							}else {

								if (cep.length != 8){
									alert("Erro, CEP invalido!")
									erro = true;
								}else {

									if (ddd.length <2 || ddd.length >3){
										alert("Erro, DDD invalido!")
										erro = true;
									}else {

										if (tel.length <8 || tel.length >9){
											alert("Erro, Telefone invalido!")
											erro = true;
											
										}else {
											
											if (email.indexOf("@hotmail.com") == -1 && email.indexOf("@uni9.edu.br") == -1 && email.indexOf("@gmail.com") == -1 && email.indexOf("@outlook.com") == -1 && email.indexOf("@uni9.pro.br") == -1 && email.indexOf("@icloud.com") == -1){
							 					alert("Preencha o E_mail corretamente!")
							 					erro = true;
											}else {
												if (!data){
													alert("Nao se esqueça de preencher a data!")
								 					erro = true;
												}else {
													erro = false;
												}
											}
										}
									}
								}
							}
						}
					}
				}
				
				if (erro == true){
					return false;
					erro = null;
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
				
				<label>Nome :</label>
				<input class="form-control"  type="text" name="txtnome" placeholder="Nome Completo" size="60" />
				<label>CPF :</label>
				<input class="form-control" type="number" name="txtcpf" placeholder="12345678911" size="14" />
				<label>Endereço :</label>
				<input class="form-control" type="text" name="txtendereco" placeholder="Av/Rua/Travessa" size="30" />
				<label>Nº Endereço :</label>
				<input class="form-control" type="number" name="txtnumEndereco" placeholder="1234" size="5" />
				<label>CEP :</label>
				<input class="form-control" type="number" name="txtcep" placeholder="01234056" size="10" />
				<label>DDD :</label>
				<input class="form-control" type="number" name="txtddd" placeholder="011" size="3" />
				<label>Telefone :</label>
				<input class="form-control" type="number" name="txttelefone" placeholder="912344567" size="11" />
				<label>E_Mail :</label>
				<input class="form-control" type="text" name="txteMail" placeholder="abc@abcd.com" size="45" />
				<label>Data :</label>
				<input class="form-control" type="Date" name="txtdataSuporte" size="11"><br />
				<label>Atendimento :&nbsp;&nbsp;</label>
				Presencial <input type="radio" name="radiotipoAtendimento" value="Presencial" checked="checked" size="8" />&nbsp;&nbsp;&nbsp;
				Remoto <input type="radio" name="radiotipoAtendimento" value="Remoto" size="8" /><br />
				
				<input type="hidden" name="txtacao" value="cadastrar" /><br />
				<input type="submit" value="Salvar Chamado" />
				
			</form>
		</div>
	</body>
</html>