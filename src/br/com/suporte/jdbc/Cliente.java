package br.com.suporte.jdbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
	
	private int codigo;
	private String nome;
	private String cpf;
	private String endereco;
	private String numEndereco;
	private String cep;
	private String ddd;
	private String telefone;
	private String email;
	public String data;
	private String atendimento;
	private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
	
	//CONSTRUTOR 
	public Cliente (int codigo, String nome, String cpf, String endereco, String numEndereco, String cep, String ddd, String telefone, String email, String data, String atendimento) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.numEndereco = numEndereco;
		this.cep = cep;
		this.ddd = ddd;
		this.telefone = telefone;
		this.email = email;
		this.data = data;
		this.atendimento = atendimento;
	}
	
	public Cliente (String nome, String cpf, String endereco, String numEndereco, String cep, String ddd, String telefone, String email, String data, String atendimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.numEndereco = numEndereco;
		this.cep = cep;
		this.ddd = ddd;
		this.telefone = telefone;
		this.email = email;
		this.data = data;
		this.atendimento = atendimento;
	}
	
	public Cliente () {
		
	}
	
	
	// MÉTODO TRATAR DATA             //SÓ TRATA O FORMATO DA DATA, NAO CHECA SE É VERDADEIRA
	public static boolean validarData(String dataSuporte) {
		
		try {
			SimpleDateFormat dtformat = new SimpleDateFormat ("dd/MM/yyyy");
			dtformat.setLenient(false);
			dtformat.parse(dataSuporte);
			return true;
		} catch (ParseException ex) {
			return false;
		}
	}
	
	//M�TODO TRATAR CPF         //VERIFICA SE é UM CPF REAL
	
	public static boolean validaCPF(String cpf) {
		
	     return (isValidCPF(cpf));
	}

	private static int calcularDigito(String str, int[] peso) {
		
		int soma = 0;
		
		for (int i= str.length()-1, digito; i >= 0; i-- ) {
			digito = Integer.parseInt(str.substring(i,i+1));
			soma += digito*peso[peso.length-str.length()+i];
	   }
		soma = 11 - soma % 11;
	   	return soma > 9 ? 0 : soma;
	 }

	private static String padLeft(String text, char character) {
		return String.format("%11s", text).replace(' ', character);
	}

	private static boolean isValidCPF(String cpf) {
		
		cpf = cpf.trim().replace(".", "").replace("-", "");  // FORMATO CONFORTAVEL PARA CLIENTE FINAL (aceita com "." ou com "-" )
		
	    if ((cpf==null) || (cpf.length()!=11)) {
	    	return false;
	    }

	    for (int j = 0; j < 10; j++) {
	    	if (padLeft(Integer.toString(j), Character.forDigit(j, 10)).equals(cpf)) {
	    		return false;
	    	}
	    }

	   	Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
	   	Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
	   	
	   	return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
	}
			
	
	// M�TODO VALIDAR EMAIL  --  APENAS FAZ A VALIDA��O DO EMAIL , N�O VERIFICA SE EXISTE.
	
	public static boolean validarEmail(String eMail) {
		
        if ((eMail == null) || (eMail.trim().length() == 0)) {
        	return false;
        }

        String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(eMail);
        return matcher.matches();
    }
	
	// M�TODO VALIDAR STRING (NOME) ----- IMPEDE DE COLOCAR NUMERO, NOME MENOR QUE 3 CARACTERER OU DEIXAR CAMPO VAZIO
	
	public static boolean validarNome(String nome) {
		
		
		if (nome.isEmpty()) {
			return false;
		}else if (nome.length()>=3){
			Pattern pattern = Pattern.compile("[0-9/|@|_|-|#|!|&|*|(|)|¹|²|³|£|¢|¬|§/g]");
			Matcher matcher = pattern.matcher(nome);
			if(matcher.find()){
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	// M�TODO VALIDAR CEP        --- IMPEDE DE COLOCAR CEP VAZIO, MENOR QUE 8 NUMEROS OU LETRAS E CARACTER ESPECIAIS.
	
	public static boolean validarCEP(String cep) {
		
		cep = cep.trim().replace(".", "").replace("-", "");  // FORMATO CONFORTAVEL PARA CLIENTE FINAL (aceita com "." ou com "-" )
			
			if (cep.isEmpty()) {
				return false;
			}else if (cep.length()==8) {
				Pattern pattern = Pattern.compile("[/a-z-A-Z|@|_|-|#|!|&|*|(|)|¹|²|³|£|¢|¬|§/gi]");
				Matcher matcher = pattern.matcher(cep);
				
				if (matcher.find()) {
					return false;
				}else {
					return true;
				}
				
			}else{
				return false;
			}
	}
	
	
	// M�TODO VALIDAR ENDERE�O
	
	public static boolean validarEND (String endereco) {
		
		if (endereco.isEmpty()) {
			return false;
		}else if (endereco.length()>=6) {
			Pattern pattern = Pattern.compile("[0-9/|@|_|-|#|!|&|*|(|)|¹|²|³|£|¢|¬|§/g]");
			Matcher matcher = pattern.matcher(endereco);
			
			if(matcher.find()){
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	// M�TODO VALIDAR DDD
	
	public static boolean validarDDD(String ddd) {
		
		ddd = ddd.trim().replace("0", "");  // FORMATO CONFORTAVEL PARA CLIENTE FINAL (SUBSTITUI O "0" POR "VAZIO" ACEITANDO EX:011)
		
		if (ddd.isEmpty()) {
			return false;
		}else if (ddd.length()!=2) {
			return false;
		}else if (ddd.length()==2) {
			Pattern pattern = Pattern.compile("[/a-z-A-Z|@|_|-|#|!|&|*|(|)|¹|²|³|£|¢|¬|§/gi]");
			Matcher matcher = pattern.matcher(ddd);
			if (matcher.find()) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	
	// M�TODO VALIDAR TELEFONE
	
	public static boolean validarTEL (String telefone) {
		
		telefone = telefone.trim().replace("-", "").replace(".", ""); // FORMATO CONFORTAVEL PARA CLIENTE FINAL (ACEITANDO EX: 9.1234-5678 ou 1234-5678)
		
		if (telefone.isEmpty()) {
			return false;
		}else if (telefone.length()<8 || telefone.length()>9) {
			return false;
		}else if (telefone.length()>=8 || telefone.length()<=9) {
			Pattern pattern = Pattern.compile("[/a-z-A-Z|@|_|-|#|!|&|*|(|)|¹|²|³|£|¢|¬|§/gi]");
			Matcher matcher = pattern.matcher(telefone);
			if (matcher.find()) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}
	
	
	// M�TODO VALIDAR TIPO DE ATENDIMENTO
	
	public static boolean validarATDM(String tipoAtendimento) {
		
		if (tipoAtendimento.equalsIgnoreCase("Presencial") || tipoAtendimento.equalsIgnoreCase("Remoto")){ //IGNORA O CASE SENSITIVE
			return true;
		}else {
			return false;
		}
	}
	
	
	// M�TODO VALIDAR NUMERO DE ENDERE�O
	
	public static boolean validarNumEND(String numEndereco) {
		
		numEndereco = numEndereco.trim().replace(".", ""); // FORMATO CONFORTAVEL PARA CLIENTE FINAL (aceita numero com ".")
		
		if (numEndereco.isEmpty()) {
			return false;
		}else if (numEndereco.length()>5) { // numero de endere�o vai de 1 ate 99.999
			return false;
		}else {
			Pattern pattern = Pattern.compile("[/a-z-A-Z|@|_|-|#|!|&|*|(|)|¹|²|³|£|¢|¬|§/gi]");
			Matcher matcher = pattern.matcher(numEndereco);
			if(matcher.find()) {
				return false;
			}else {
				return true;
			}
		}
	}
	
	
	// M�TODO GETTERS E SETTERS 
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumEndereco() {
		return numEndereco;
	}

	public void setNumEndereco (String numEndereco) {
		this.numEndereco = numEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getDdd() {
		return ddd;
	}
	
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDataSuporte() {
		return data;
	}

	public void setDataSuporte(String data) {
		this.data = data;
	}

	public String getTipoAtendimento() {
		return atendimento;
	}

	public void setTipoAtendimento(String atendimento) {
		this.atendimento = atendimento;
	}
}
	
	
