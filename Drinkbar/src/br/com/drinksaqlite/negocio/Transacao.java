package br.com.drinksaqlite.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

import br.com.drinkbar.dados.RecpositorioClienteDao;

public class Transacao {

	private RecpositorioClienteDao rep;
	private String sql;

	public Transacao() {
		this.rep = new RecpositorioClienteDao();
		this.sql = "";

	}

	// metodo para preencher a tabela
	public void povoarTabelaBebida(String criterio,
			DefaultTableModel modeloTabela) throws Exception {
		rep.abrirConexao();

		if (criterio != null || modeloTabela != null) {

			sql = "SELECT * FROM bebida WHERE tipo_bebida = ?";

			rep.comandoQuery = rep.conexao.prepareStatement(sql);
			rep.comandoQuery.setString(1, criterio);
			rep.resultSet = rep.comandoQuery.executeQuery();

			ResultSet rs = rep.resultSet;
			if (rs.next()) {
				modeloTabela.addRow(new Object[] { rs.getString("tipo_bebida"),
						rs.getString("nome_bebida"),
						rs.getString("fabricante_bebida"),
						rs.getString("dataFabricacao_bebida"),
						rs.getDouble("preco_bebida") });

			}
		}

	}// fim do metodo preencher a tabela

	public void PesquisaClienteVenda(String cpf, Cliente cliente)
			throws Exception {

		if (cpf != null && cliente != null) {

			sql = " SELECT * FROM cliente WHERE cpf_cliente = ?";
			rep.abrirConexao();

			rep.comandoQuery = rep.conexao.prepareStatement(sql);
			rep.comandoQuery.setString(1, cpf);
			rep.resultSet = rep.comandoQuery.executeQuery();

			if (rep.resultSet.next()) {

				cliente.setNome(rep.resultSet.getString("mome_cliente"));
				cliente.setTelefone(rep.resultSet.getString("telefone_cliente"));
				cliente.setBairro(rep.resultSet.getString("bairro_cliente"));
				cliente.setCep(rep.resultSet.getString("cep_cliente"));
				cliente.setCidade(rep.resultSet.getString("cidade_cliente"));
				cliente.setEndereco(rep.resultSet.getString("endereco_cliente"));
				cliente.setEstado(rep.resultSet.getString("estado_cliente"));

			}
		}

	}// fim do método PesquisaClienteVenda

	public void consultarBebida(String tipoBebida, Bebida precoBebida)
			throws Exception {

		sql = " SELECT * FROM bebida WHERE tipo_bebida = ?";
		rep.abrirConexao();

		if (tipoBebida != null && precoBebida != null) {
			rep.comandoQuery = rep.conexao.prepareStatement(sql);
			rep.comandoQuery.setString(1, tipoBebida);
			rep.resultSet = rep.comandoQuery.executeQuery();

			if (rep.resultSet.next()) {

				double preco = rep.resultSet.getDouble("preco_bebida");
				precoBebida.setPreco(preco);

			}
		}
	}// fim do método

}
