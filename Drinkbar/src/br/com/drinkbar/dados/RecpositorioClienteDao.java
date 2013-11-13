package br.com.drinkbar.dados;

import java.util.List;

import br.com.drinksaqlite.negocio.IRepositorioCliente;
import br.com.drinksaqlite.negocio.cliente;

/**
 * @author Diego Santos
 * 
 *         classe respondavel por implementar os metodos da interface
 *         IRepositorio.metodos que serao usados para ferenciar os dados de um
 *         determinado cliente na base de dados.
 * */

public class RecpositorioClienteDao implements IRepositorioCliente {

	@Override
	public boolean existeCliente(String cpf) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<cliente> pesquisarCliente(String cpf) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cadastrarCliente(cliente novoCliente) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizarCliente(cliente cliente) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluirCliente(String cpf) throws Exception {
		// TODO Auto-generated method stub

	}

}
