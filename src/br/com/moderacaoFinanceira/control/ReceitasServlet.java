package br.com.moderacaoFinanceira.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.moderacaoFinanceira.model.dao.ReceitasDao;
import br.com.moderacaoFinanceira.model.domain.Receitas;
import util.ValidacaoException;

/**
 * Servlet implementation class ContaServlet
 */
@WebServlet("/ReceitasServlet")
public class ReceitasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ReceitasDao receitasDao = new ReceitasDao();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String acao = request.getParameter("acao");
			if (acao != null) {

				if (acao.equals("CREATE") || acao.equals("UPDATE")) {
					Receitas receita = criaReceita(request);

					try {
						receita.valida();
					} catch (ValidacaoException e) {
						request.setAttribute("mensagem", "Erro de validação dos campos. " + e.getMessage());
						request.setAttribute("receitas", receita);
					}

					if (receita.getIdReceita() == null) {
						receitasDao.salvar(receita);
						request.setAttribute("mensagem", "Receita salva com sucesso. ");
					} else {
						receitasDao.atualizar(receita);
						request.setAttribute("mensagem", "Receita atualizada com sucesso. ");
					}

				} else if (acao.equals("RETRIEVE")) {
					String codigo = request.getParameter("codigo");
					Integer codReceita = Integer.parseInt(codigo);
					Receitas receita = receitasDao.getReceitaId(codReceita);
					request.setAttribute("receita", receita);
				} else if (acao.equals("DELETE")) {
					String codigo = request.getParameter("codigo");
					Integer codReceita = Integer.parseInt(codigo);
					receitasDao.excluir(codReceita);
					request.setAttribute("mensagem", "Receita excluida com sucesso. ");
				}
			}
			request.setAttribute("receitas", receitasDao.getReceitas());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/receita.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException | ClassNotFoundException | IllegalArgumentException e) {
			request.setAttribute("mensagem", "Erro: " + e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/erro.jsp");
			dispatcher.forward(request, response);
		}

	}

	private Receitas criaReceita(HttpServletRequest request) {
		String idReceita = request.getParameter("idReceita");
		String codigoConta = request.getParameter("codigoConta");
		String tipoConta = request.getParameter("tipoConta");
		String nomeTag = request.getParameter("nomeTag");
		String nomeCategoria = request.getParameter("nomeCategoria");
		String dataInclusao = request.getParameter("dataInclusao");
		String descricao = request.getParameter("descricao");
		String valorReceita = request.getParameter("valorReceita");
		
		Receitas receita = new Receitas(null, codigoConta, tipoConta, nomeTag, nomeCategoria, dataInclusao, descricao, valorReceita);

		if (idReceita != null && !idReceita.equals("")) {
			receita.setIdReceita(Integer.parseInt(idReceita));
		}
		return receita;
	}

}
