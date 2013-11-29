package br.com.drinksaqlite.negocio;

import java.util.List;

import br.com.drinkbar.dados.RecpositorioClienteDao;

public class FachadaCliente {

	private RecpositorioClienteDao reporCliente;

	public FachadaCliente() {

		this.reporCliente = new RecpositorioClienteDao();

	}

	public void cadastraCliente(Cliente novoCliente) throws Exception {

		this.reporCliente.cadastrarCliente(novoCliente);
	}

	public List<Cliente> pesquisarCliente(String text) throws Exception {

		return this.reporCliente.pesquisarCliente(text);

	}

}
