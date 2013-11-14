package br.com.drinkbar.dados;

import java.util.List;

import br.com.drinksaqlite.negocio.IRepositorioCliente;
import br.com.drinksaqlite.negocio.cliente;

/**
 * @author Diego Santos
 * 
 *         classe responsavel por implementar os metodos da interface
 *         IRepositorio.metodos que serao usados para manipular as operacoes
 *         como: inserir,atualizar,remover e consultar.
 * */

public class RecpositorioClienteDao extends ConectaSqlite implements
		IRepositorioCliente {

	private String sql = "";

	public RecpositorioClienteDao() {
		super();
	}

	@Override
	public boolean existeCliente(String cpf) throws Exception {

		return false;
	}

	@Override
	public List<cliente> pesquisarCliente(String cpf) throws Exception {

		return null;
	}

	// metodo responsalvel pela insercao de um cliente no banco de dados
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.drinksaqlite.negocio.IRepositorioCliente#cadastrarCliente(br.com
	 * .drinksaqlite.negocio.cliente)
	 */
	@Override
	public void cadastrarCliente(cliente novoCliente) throws Exception {

		/*
		 * metodo herdado da classe ConectaSqlite para abrir conexao com a base
		 * de dados
		 */
		abrirConexao();

		if (novoCliente != null) {

			sql = "INSERT INTO main.cliente(mome_cliente,endereco_cliente,bairro_cliente,cidade_cliente,estado_cliente,cep_cliente,telefone_cliente,cpf_cliente,sexo_cliente)VALUES(?,?,?,?,?,?,?,?,?)";
			/*
			 * comandoQuery e conexao atributos herdados da classe ConectaSqlite
			 * 
			 * preparedStatement permite criar instruções SQL
			 */
			comandoQuery = conexao.prepareStatement(sql);
			comandoQuery.setString(1, novoCliente.getNome());
			comandoQuery.setString(2, novoCliente.getEndereco());
			comandoQuery.setString(3, novoCliente.getBairro());
			comandoQuery.setString(4, novoCliente.getCidade());
			comandoQuery.setString(5, novoCliente.getEstado());
			comandoQuery.setString(6, novoCliente.getCep());
			comandoQuery.setString(7, novoCliente.getTelefone());
			comandoQuery.setString(8, novoCliente.getCpf());
			// convertendo o atributo do tipo char para string
			String sexo = String.valueOf(novoCliente.getSexo());
			comandoQuery.setString(9, sexo);
			comandoQuery.execute();

			throw new Exception("Cliente: " + novoCliente.getNome() + "\nCPF: "
					+ novoCliente.getCpf() + "\nCADASTRADO COM SUCESSO!!");
			/*
			 * metodo herdado da classe ConectaSqlite para fechar conexao com a
			 * base de dados
			 */

		}// fim do if
		fecharConexaoBancoDados();

	}// fim do metodo cadastrarCliente

	@Override
	public void atualizarCliente(cliente cliente) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluirCliente(String cpf) throws Exception {
		// TODO Auto-generated method stub

	}

}
