package br.com.drinksaqlite.negocio;

import java.util.List;

/**
 * @author Diego Santos
 * 
 *         Métodos que obrigatoriamente devem ser implementados pela  Classe
 *         que implementar esta Interface que no caso vai ser RepositorioClienteDao
 */

public interface IRepositorioCliente {

	public boolean existeCliente(String cpf) throws Exception;

	public List<cliente> pesquisarCliente(String cpf) throws Exception;

	public void cadastrarCliente(cliente novoCliente) throws Exception;

	public void atualizarCliente(cliente cliente) throws Exception;

	public void excluirCliente(String cpf) throws Exception;

}
