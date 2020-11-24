package br.com.moderacaoFinanceira.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.moderacaoFinanceira.model.domain.Conta;

public class ContaDao {
	
	public List<Conta> getContas() throws SQLException, ClassNotFoundException {
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement("SELECT CODIGO_CONTA, CODIGO_USUARIO, NOME_CONTA"
				                                           + ", TIPO_CONTA, VALOR_INICIAL "
				                                        + "FROM SYSTEM.TB_CONTA");
		ResultSet rs = ps.executeQuery();
		List<Conta> contas = new ArrayList<>();
		
		while(rs.next()) {
			contas.add(new Conta(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
		return contas;
	
	}

	public void salvar(Conta conta) throws SQLException, ClassNotFoundException {
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement statement = conexao.prepareStatement("INSERT INTO SYSTEM.TB_CONTA "
				+ "(CODIGO_CONTA, CODIGO_USUARIO, NOME_CONTA, TIPO_CONTA, VALOR_INICIAL) "
				+ "VALUES(CONTA_SEQ.NEXTVAL, ?, ?, ?, ?)");
		
		statement.setString(1, conta.getCodigoUsuario());
		statement.setString(2, conta.getNomeConta());
		statement.setString(3, conta.getTipoConta());
		statement.setString(4, conta.getValorConta());
		statement.execute();
	}

	public void excluir(Integer codConta) throws SQLException, ClassNotFoundException {
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement statement = conexao.prepareStatement("DELETE FROM SYSTEM.TB_CONTA WHERE CODIGO_CONTA = ?");
		statement.setInt(1, codConta);
		statement.execute();
	}

	public Conta getContaId(Integer codConta) throws SQLException, ClassNotFoundException, IllegalArgumentException {
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement("SELECT CODIGO_CONTA, CODIGO_USUARIO"
				                                           + ", NOME_CONTA, TIPO_CONTA, VALOR_INICIAL "
				                                        + "FROM SYSTEM.TB_CONTA "
				                                       + "WHERE CODIGO_CONTA = ?");
		
		ps.setInt(1, codConta);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return new Conta(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		}
		throw new IllegalArgumentException ("Codigo da conta não encontrado");
	}

	public void atualizar(Conta conta) throws SQLException, ClassNotFoundException {
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement statement = conexao.prepareStatement("UPDATE SYSTEM.TB_CONTA "
				+ "SET CODIGO_USUARIO = ?, NOME_CONTA = ?, TIPO_CONTA = ?, VALOR_INICIAL = ? "
				+ "WHERE CODIGO_CONTA = ?");
		
		
		statement.setString(1, conta.getCodigoUsuario());
		statement.setString(2, conta.getNomeConta());
		statement.setString(3, conta.getTipoConta());
		statement.setString(4, conta.getValorConta());
		statement.setInt(5, conta.getCodigoConta());
		statement.execute();
	}


}
