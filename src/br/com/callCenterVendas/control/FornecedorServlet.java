package br.com.callCenterVendas.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.callCenterVendas.model.dao.FornecedorDao;
import br.com.callCenterVendas.model.domain.Fornecedor;
import util.ValidacaoException;

@WebServlet("/FornecedorServlet")
public class FornecedorServlet extends HttpServlet {

	private FornecedorDao fornecedorDao = new FornecedorDao();
	private static final long serialVersionUID = 1L;

	public FornecedorServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		List<Fornecedor> fornecedores = new ArrayList<>();
//		fornecedores.add(new Fornecedor(1,"fulano@gmail.com","Alpargatas","teste","1231-2"));

		try {
			request.setAttribute("fornecedores", fornecedorDao.getFornecedores());
		} catch (SQLException e) {
			request.setAttribute("mensagem", "Erro de Banco de Dados" + e.getMessage());
		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagem", "Erro de Driver" + e.getMessage());
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/fornecedores.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String razaoSocial = request.getParameter("razaoSocial");
		String email = request.getParameter("email");
		String cnpj = request.getParameter("cnpj");
		Fornecedor fornecedor = new Fornecedor(null, nome, email, razaoSocial, cnpj);

		try {
			fornecedor.valida();
			fornecedorDao.salvar(fornecedor);
			request.setAttribute("mensagem", "Fornecedor salvo com sucesso. ");
		} catch (ValidacaoException e) {
			request.setAttribute("mensagem", "Erro de validação dos campos. " + e.getMessage());
			request.setAttribute("fornecedores", fornecedor);
		} catch (SQLException e) {
			request.setAttribute("mensagem", "Erro de Banco de Dados. " + e.getMessage());
			request.setAttribute("fornecedores", fornecedor);
		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagem", "Erro de Driver. " + e.getMessage());
			request.setAttribute("fornecedores", fornecedor);
		}
		
		try {
			request.setAttribute("fornecedores", fornecedorDao.getFornecedores());
		} catch (SQLException e) {
			request.setAttribute("mensagem", "Erro de Banco de Dados. " + e.getMessage());
			request.setAttribute("fornecedores", fornecedor);
		} catch (ClassNotFoundException e) {
			request.setAttribute("mensagem", "Erro de Driver. " + e.getMessage());
			request.setAttribute("fornecedores", fornecedor);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/fornecedores.jsp");
		dispatcher.forward(request, response);

	}

}
