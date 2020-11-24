package br.com.moderacaoFinanceira.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.moderacaoFinanceira.model.dao.ContaDao;
import br.com.moderacaoFinanceira.model.domain.Conta;
import util.ValidacaoException;

/**
 * Servlet implementation class ContaServlet
 */
@WebServlet("/ContaServlet")
public class ContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ContaDao contaDao = new ContaDao();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String acao = request.getParameter("acao");
			if (acao != null) {

				if (acao.equals("CREATE") || acao.equals("UPDATE")) {
					Conta conta = criaConta(request);

					try {
						conta.valida();
					} catch (ValidacaoException e) {
						request.setAttribute("mensagem", "Erro de validação dos campos. " + e.getMessage());
						request.setAttribute("contas", conta);
					}

					if (conta.getCodigoConta() == null) {
						contaDao.salvar(conta);
						request.setAttribute("mensagem", "Conta salva com sucesso. ");
					} else {
						contaDao.atualizar(conta);
						request.setAttribute("mensagem", "Conta atualizada com sucesso. ");
					}

				} else if (acao.equals("RETRIEVE")) {
					String codigo = request.getParameter("codigo");
					Integer codConta = Integer.parseInt(codigo);
					Conta conta = contaDao.getContaId(codConta);
					request.setAttribute("conta", conta);
				} else if (acao.equals("DELETE")) {
					String codigo = request.getParameter("codigo");
					Integer codConta = Integer.parseInt(codigo);
					contaDao.excluir(codConta);
					request.setAttribute("mensagem", "Conta excluida com sucesso. ");
				}
			}
			request.setAttribute("contas", contaDao.getContas());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/conta.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException | ClassNotFoundException | IllegalArgumentException e) {
			request.setAttribute("mensagem", "Erro: " + e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/erro.jsp");
			dispatcher.forward(request, response);
		}

	}

	private Conta criaConta(HttpServletRequest request) {
		String codigoConta = request.getParameter("codigoConta");
		String codigoUsuario = request.getParameter("codigoUsuario");
		String nomeConta = request.getParameter("nomeConta");
		String tipoConta = request.getParameter("tipoConta");
		String valor = request.getParameter("valor");
		
		Conta conta = new Conta(null, codigoUsuario, nomeConta, tipoConta, valor);

		if (codigoConta != null && !codigoConta.equals("")) {
			conta.setCodigoConta(Integer.parseInt(codigoConta));
		}
		return conta;
	}

}
