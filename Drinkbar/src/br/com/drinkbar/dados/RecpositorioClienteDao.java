package br.com.drinkbar.dados;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import br.com.drinksaqlite.negocio.IRepositorioCliente;
import br.com.drinksaqlite.negocio.Cliente;
import br.com.drinksaqlite.negocio.UtilGui;

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
	private static Logger LOG = Logger.getLogger(RecpositorioClienteDao.class);

	public RecpositorioClienteDao() {
		super();
	}

	@Override
	public boolean existeCliente(String cpf) throws Exception {

		boolean achou = false;

		sql = "SELECT * FROM cliente WHERE cpf_cliente = ?";
		comandoQuery = conexao.prepareStatement(sql);
		comandoQuery.setString(1, cpf);
		resultSet = comandoQuery.executeQuery();
		if (cpf != null) {
			if (resultSet.next()) {
				achou = true;
			} else {

				achou = false;
			}
		}

		return achou;
	}

	@Override
	public List<Cliente> pesquisarCliente(String text) throws Exception {

		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = new Cliente();

		sql = "SELECT * FROM cliente WHERE cpf_cliente = ?";
		abrirConexao();
		comandoQuery = conexao.prepareStatement(sql);
		comandoQuery.setString(1, text);
		resultSet = comandoQuery.executeQuery();
		if (resultSet.next()) {
			cliente.setNome(resultSet.getString("mome_cliente"));
			cliente.setCpf(resultSet.getString("cpf_cliente"));
			cliente.setTelefone(resultSet.getString("telefone_cliente"));
			cliente.setBairro(resultSet.getString("bairro_cliente"));
			cliente.setCep(resultSet.getString("cep_cliente"));
			cliente.setCidade(resultSet.getString("cidade_cliente"));
			cliente.setEndereco(resultSet.getString("endereco_cliente"));
			cliente.setEstado(resultSet.getString("estado_cliente"));
			cliente.setSexo(resultSet.getString("sexo_cliente"));
			clientes.add(cliente);

		}

		return clientes;
	}

	// metodo responsalvel pela insercao de um cliente no banco de dados
	@Override
	public void cadastrarCliente(Cliente novoCliente) throws Exception {

		/*
		 * metodo herdado da classe ConectaSqlite para abrir conexao com a base
		 * de dados
		 */
		abrirConexao();

		if (novoCliente != null) {
			if (this.existeCliente(novoCliente.getCpf()) == true) {

				UtilGui.errorMessage("CPF: " + novoCliente.getCpf()
						+ " já cadastrado.");
			} else if (this.existeCliente(novoCliente.getCpf()) == false) {
				sql = "INSERT INTO main.cliente(mome_cliente,endereco_cliente,bairro_cliente,cidade_cliente,estado_cliente,cep_cliente,telefone_cliente,cpf_cliente,sexo_cliente)VALUES(?,?,?,?,?,?,?,?,?)";
				/*
				 * comandoQuery e conexao atributos herdados da classe
				 * ConectaSqlite
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
				comandoQuery.setString(9, novoCliente.getSexo());

				if (comandoQuery.executeUpdate() > 0) {

					UtilGui.successMessage("Cliente: " + novoCliente.getNome()
							+ "\nCPF: " + novoCliente.getCpf()
							+ "\nCADASTRADO COM SUCESSO!!");
				}

			} // fim do if existe

		}// fim do if

	}// fim do metodo cadastrarCliente

	@Override
	public void atualizarCliente(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluirCliente(String cpf) throws Exception {
		// TODO Auto-generated method stub

	}


}
