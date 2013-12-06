package br.com.drinkbar.dados;

import java.util.ArrayList;
import java.util.List;

import br.com.drinksaqlite.negocio.Bebida;
import br.com.drinksaqlite.negocio.IRepositorioBebida;

public class RepositorioBabidaDao extends ConectaSqlite implements
		IRepositorioBebida {

	private String sql = " ";

	public RepositorioBabidaDao() {

	}

	@Override
	public List<Bebida> pesquisarBebida(String tipo) throws Exception {

		List<Bebida> bebidas = new ArrayList<>();

		Bebida bebida = new Bebida();

		sql = "SELECT * FROM bebida WHERE tipo_bebida = ?";
		abrirConexao();
		comandoQuery = conexao.prepareStatement(sql);
		comandoQuery.setString(1, tipo);
		resultSet = comandoQuery.executeQuery();

		if (resultSet.next()) {

			bebida.setDataFabricacao(resultSet
					.getString("dataFabricacao_bebida"));
			bebida.setFabricante(resultSet.getString("fabricante_bebida"));
			bebida.setNome(resultSet.getString("nome_bebida"));
			bebida.setPreco(resultSet.getDouble("preco_bebida"));
			bebida.setTipo(resultSet.getString("tipo_bebida"));
			bebidas.add(bebida);

		}

		return bebidas;
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
