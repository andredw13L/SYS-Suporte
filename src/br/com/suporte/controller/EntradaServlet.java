package br.com.suporte.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.suporte.jdbc.Cliente;
import br.com.suporte.jdbc.ClienteDao;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		
		if(acao.equals("mostrar")) {
			
			ClienteDao clienteDao = new ClienteDao();
			ArrayList<Cliente> clientes = clienteDao.mostrarTodosClientes();
			
			request.setAttribute("clientes", clientes);
			
			RequestDispatcher rd = request.getRequestDispatcher("/telamostrarclientes.jsp");
			rd.forward(request, response);
			
		}else if(acao.equals("incluir")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/telacadastrarcliente.jsp");
			rd.forward(request,response);

		}else if (acao.equals("cliente")) {

			RequestDispatcher rd = request.getRequestDispatcher("/telacliente.jsp");
			rd.forward(request, response);
			
		}else if(acao.equals("excluir")) {
			
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			
			ClienteDao clienteDao = new ClienteDao();
			clienteDao.excluirClientePorCodigo(codigo);
			
			response.sendRedirect("http://localhost:8080/SysSuporte2/entrada?acao=mostrar");
			
		}else if(acao.equals("alterar")) {
			
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			
			ClienteDao clienteDao = new ClienteDao();
			Cliente cliente = clienteDao.mostrarClientePorCodigo(codigo);
			
			request.setAttribute("cliente", cliente);
			
			RequestDispatcher rd = request.getRequestDispatcher("/telaalterarcliente.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("txtacao");
		
		String nome = request.getParameter("txtnome");
		String cpf = request.getParameter("txtcpf");
		String endereco = request.getParameter("txtendereco");
		String numEndereco = request.getParameter("txtnumEndereco");
		String cep = request.getParameter("txtcep");
		String ddd = request.getParameter("txtddd");
		String telefone = request.getParameter("txttelefone");
		String eMail = request.getParameter("txteMail");
		String dataSuporte = request.getParameter("txtdataSuporte");
		String tipoAtendimento = request.getParameter("radiotipoAtendimento");
		
		Cliente cliente = new Cliente(nome, cpf, endereco, numEndereco, cep, ddd, telefone, eMail, dataSuporte, tipoAtendimento);
		ClienteDao clienteDao = new ClienteDao();
		
		if(acao.equals("cadastrar")) {
			
			clienteDao.cadastrar(cliente);

		}else if(acao.equals("alterar")) {
			
			cliente.setCodigo(Integer.parseInt(request.getParameter("txtcodigo")));
			clienteDao.alterarClientePorCodigo(cliente);
			
		}
		
		response.sendRedirect("http://localhost:8080/SysSuporte2/entrada?acao=mostrar");
		
	}

}
