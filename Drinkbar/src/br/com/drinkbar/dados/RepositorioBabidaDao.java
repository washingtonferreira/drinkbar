package br.com.drinkbar.dados;

import java.util.List;

import br.com.drinksaqlite.negocio.Bebida;
import br.com.drinksaqlite.negocio.Cliente;
import br.com.drinksaqlite.negocio.IRepositorioBebida;

public class RepositorioBabidaDao extends ConectaSqlite implements
		IRepositorioBebida {

	private String sql = " ";

	public RepositorioBabidaDao() {

	}

	@Override
	public List<Bebida> pesquisarBebida(String text) throws Exception {
		return null;
	}

	@Override
	public void cadastrarBebida(Bebida novoBebida) throws Exception {

		abrirConexao();

		if (novoBebida != null) {
			sql = "INSERT INTO main.bebida (nome_bebida,tipo_bebida,fabricante_bebida,dataFabricacao_bebida,preco_bebida)VALUES(?,?,?,?,?)";

			comandoQuery = conexao.prepareStatement(sql);
			comandoQuery.setString(1, novoBebida.getNome());
			comandoQuery.setString(2, novoBebida.getTipo());
			comandoQuery.setString(3, novoBebida.getFabricante());
			comandoQuery.setString(4, novoBebida.getDataFabricacao());
			comandoQuery.setDouble(5, novoBebida.getPreco());
			comandoQuery.executeUpdate();

			throw new Exception("Bebida cadasrado com sucesso!!");

		}
		fecharConexaoBancoDados();

	}

	@Override
	public void atualizarBebidae(Bebida bebida) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluirBebida(String nome) throws Exception {
		// TODO Auto-generated method stub

	}

}
