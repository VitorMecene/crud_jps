package br.com.callCenterVendas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.callCenterVendas.model.domain.Fornecedor;


public class FornecedorDao {
	
	public List<Fornecedor> getFornecedores() throws SQLException, ClassNotFoundException {
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement("SELECT CD_FORNECEDOR, NM_FORNECEDOR, DS_EMAIL, DS_RAZAO_SOCIAL, DS_CNPJ "
			                                           	+ "FROM SYSTEM.TB_FORNECEDOR");
		ResultSet rs = ps.executeQuery();
		List<Fornecedor> fornecedores = new ArrayList<>();
		
		while(rs.next()) {
			fornecedores.add(new Fornecedor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		}
		return fornecedores;
	
	}

	public void salvar(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement statement = conexao.prepareStatement("INSERT INTO SYSTEM.TB_FORNECEDOR(CD_FORNECEDOR, NM_FORNECEDOR, DS_EMAIL, DS_RAZAO_SOCIAL, DS_CNPJ)\r\n" + 
				                                               "VALUES(SEQ_FORNECEDOR.NEXTVAL, ?, ?, ?, ?)");
		
		statement.setString(1, fornecedor.getNome());
		statement.setString(2, fornecedor.getEmail());
		statement.setString(3, fornecedor.getRazaoSocial());
		statement.setString(4, fornecedor.getCnpj());
		statement.execute();
	}

	public void excluir(Integer codFornecedor) throws SQLException, ClassNotFoundException {
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement statement = conexao.prepareStatement("DELETE FROM SYSTEM.TB_FORNECEDOR WHERE CD_FORNECEDOR = ?");
		statement.setInt(1, codFornecedor);
		statement.execute();
	}

	public Fornecedor getFornecedorId(Integer codFornecedor) throws SQLException, ClassNotFoundException, IllegalArgumentException {
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement ps = conexao.prepareStatement("SELECT CD_FORNECEDOR, NM_FORNECEDOR, DS_EMAIL, DS_RAZAO_SOCIAL, DS_CNPJ "
				                                        + "FROM SYSTEM.TB_FORNECEDOR WHERE CD_FORNECEDOR = ?");
		ps.setInt(1, codFornecedor);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return new Fornecedor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		}
		throw new IllegalArgumentException ("Codigo de fornecedor não encontrado");
	}

	public void atualizar(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
		Connection conexao = ConexaoJDBCFactory.getConexao();
		PreparedStatement statement = conexao.prepareStatement("UPDATE SYSTEM.TB_FORNECEDOR "
				                                                + "SET NM_FORNECEDOR = ?, DS_EMAIL = ?, DS_RAZAO_SOCIAL = ?, DS_CNPJ = ? "
				                                              + "WHERE CD_FORNECEDOR = ?");
		
		statement.setString(1, fornecedor.getNome());
		statement.setString(2, fornecedor.getEmail());
		statement.setString(3, fornecedor.getRazaoSocial());
		statement.setString(4, fornecedor.getCnpj());
		statement.setInt(5, fornecedor.getCodigo());
		statement.execute();
	}

}
