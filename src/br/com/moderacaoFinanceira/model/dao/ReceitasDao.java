package br.com.moderacaoFinanceira.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.moderacaoFinanceira.model.domain.Receitas;

public class ReceitasDao {
	
	public List<Receitas> getReceitas() throws SQLException, ClassNotFoundException {
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement("SELECT ID_RECEITA, CODIGO_CONTA, TIPO_CONTA, NOME_TAG, NOME_CATEGORIA"
				                                           + ", DT_INCLUSAO_REC, DESCRICAO_RECEITA, VALOR_RECEITA "
				                                        + "FROM SYSTEM.TB_RECEITAS");
		
		ResultSet rs = ps.executeQuery();
		List<Receitas> receitas = new ArrayList<>();
		
		while(rs.next()) {
			receitas.add(new Receitas(rs.getInt(1), rs.getString(2),  rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
		}
		return receitas;
	
	}

	public void salvar(Receitas receitas) throws SQLException, ClassNotFoundException {
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement statement = conexao.prepareStatement("INSERT INTO SYSTEM.TB_RECEITAS "
			+ "(ID_RECEITA, CODIGO_CONTA, TIPO_CONTA, NOME_TAG, NOME_CATEGORIA, DT_INCLUSAO_REC"
		    + ", DESCRICAO_RECEITA, VALOR_RECEITA) "
		    + "VALUES(RECEITAS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)");
		
		statement.setString(1, receitas.getCodigoConta());
		statement.setString(2, receitas.getTipoConta());
		statement.setString(3, receitas.getNomeTag());
		statement.setString(4, receitas.getNomeCategoria());
		statement.setString(5, receitas.getDataInclusao());
		statement.setString(6, receitas.getDescricao());
		statement.setString(7, receitas.getValorReceita());
		statement.execute();
	}

	public void excluir(Integer codReceita) throws SQLException, ClassNotFoundException {
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement statement = conexao.prepareStatement("DELETE FROM SYSTEM.TB_RECEITAS WHERE ID_RECEITA = ?");
		statement.setInt(1, codReceita);
		statement.execute();
	}

	public Receitas getReceitaId(Integer codReceita) throws SQLException, ClassNotFoundException, IllegalArgumentException {
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement("SELECT ID_RECEITA, CODIGO_CONTA, TIPO_CONTA, NOME_TAG, NOME_CATEGORIA"
				                                           + ", DT_INCLUSAO_REC, DESCRICAO_RECEITA, VALOR_RECEITA "
				                                        + "FROM SYSTEM.TB_RECEITAS "
				                                       + "WHERE ID_RECEITA = ?");
		
		ps.setInt(1, codReceita);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return new Receitas(rs.getInt(1), rs.getString(2),  rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
		}
		throw new IllegalArgumentException ("Codigo da receita não encontrado");
	}

	public void atualizar(Receitas receitas) throws SQLException, ClassNotFoundException {
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement statement = conexao.prepareStatement("UPDATE SYSTEM.TB_RECEITAS "
				+ "SET CODIGO_CONTA = ?, TIPO_CONTA = ?, NOME_TAG = ?, NOME_CATEGORIA = ?"
				+ ", DT_INCLUSAO_REC = ?, DESCRICAO_RECEITA = ?, VALOR_RECEITA = ? "
				+ "WHERE ID_RECEITA = ?");
		
		
		statement.setString(1, receitas.getCodigoConta());
		statement.setString(2, receitas.getTipoConta());
		statement.setString(3, receitas.getNomeTag());
		statement.setString(4, receitas.getNomeCategoria());
		statement.setString(5, receitas.getDataInclusao());
		statement.setString(6, receitas.getDescricao());
		statement.setString(7, receitas.getValorReceita());
		statement.setInt(8, receitas.getIdReceita());
		statement.execute();
	}

}
